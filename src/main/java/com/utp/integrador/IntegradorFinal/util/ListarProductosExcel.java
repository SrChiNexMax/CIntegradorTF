package com.utp.integrador.IntegradorFinal.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import com.utp.integrador.IntegradorFinal.models.entity.Producto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component("secciones/almacen.xlsx")
public class ListarProductosExcel extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"listado-productos.xlsx\"");
        Sheet hoja = workbook.createSheet("Productos");

        Row filaTitulo = hoja.createRow(0);
        Cell celda = filaTitulo.createCell(0);
        celda.setCellValue("Listado de Productos");

        Row filaData = hoja.createRow(2);
        String[] columnas = {"Codigo","Descripción","Precio","Marca","Categoría","Stock","Suspendido"};
        for(int i=0;i<columnas.length;i++){
            celda = filaData.createCell(i);
            celda.setCellValue(columnas[i]);
        }

        List<Producto> listaP = (List<Producto>) model.get("productos");

        int numFila = 3;
        for (Producto producto : listaP){
            filaData = hoja.createRow(numFila);

            filaData.createCell(0).setCellValue(producto.getIdProducto());
            filaData.createCell(1).setCellValue(producto.getNombreProducto());
            filaData.createCell(2).setCellValue(String.valueOf(producto.getPrecioUnidad()));
            filaData.createCell(3).setCellValue(producto.getMarca().getNombreMarca());
            filaData.createCell(4).setCellValue(producto.getCategoria().getNombreCategoria());
            filaData.createCell(5).setCellValue(String.valueOf(producto.getUnidadesExistentes()));
            if (producto.isEstaSuspendido()){
                filaData.createCell(6).setCellValue("Si");
            }else{
                filaData.createCell(6).setCellValue("No");
            }
            numFila++;
        }
    }
}
