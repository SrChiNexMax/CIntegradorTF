package com.utp.integrador.IntegradorFinal.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import com.utp.integrador.IntegradorFinal.models.entity.Empleado;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component("secciones/usuarios.xlsx")
public class ListarUsuariosExcel extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"listado-usuarios.xlsx\"");
        Sheet hoja = workbook.createSheet("Usuarios");

        Row filaTitulo = hoja.createRow(0);
        Cell celda = filaTitulo.createCell(0);
        celda.setCellValue("Listado de Usuarios");

        Row filaData = hoja.createRow(2);
        String[] columnas = {"ID","Nombre","Acceso"};
        for(int i=0;i<columnas.length;i++){
            celda = filaData.createCell(i);
            celda.setCellValue(columnas[i]);
        }

        List<Empleado> listaU = (List<Empleado>) model.get("empleados");

        int numFila = 3;
        for (Empleado empleado : listaU){
            filaData = hoja.createRow(numFila);

            filaData.createCell(0).setCellValue(empleado.getIdEmpleado());
            filaData.createCell(1).setCellValue(empleado.getNombre());
            filaData.createCell(2).setCellValue(empleado.getAcceso());

            numFila++;
        }
    }
}
