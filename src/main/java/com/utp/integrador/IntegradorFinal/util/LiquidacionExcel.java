package com.utp.integrador.IntegradorFinal.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.utp.integrador.IntegradorFinal.models.entity.DetalleVenta;

@Component("secciones/caja.xlsx")
public class LiquidacionExcel extends AbstractXlsxView {

    public String Fecha() {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        return formattedDate;
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"liquidacion.xlsx\"");
        Sheet hoja = workbook.createSheet("Reporte Diario de Ventas");

        Row filaTitulo = hoja.createRow(0);
        Cell celda = filaTitulo.createCell(0);
        celda.setCellValue("Ficha de Liquidacion "+Fecha());

        Row filaData = hoja.createRow(2);
        String[] columnas = {"ID Venta","Producto","Cantidad","Precio x Unidad","Total"};
        for(int i=0;i<columnas.length;i++){
            celda = filaData.createCell(i);
            celda.setCellValue(columnas[i]);
        }

        List<DetalleVenta> lDV = (List<DetalleVenta>) model.get("detalle");

        int numFila = 3;
        for (DetalleVenta dv : lDV){
            filaData = hoja.createRow(numFila);

            filaData.createCell(0).setCellValue(dv.getVentas().getIdComprobante());
            filaData.createCell(1).setCellValue(dv.getProducto().getNombreProducto());
            filaData.createCell(2).setCellValue(dv.getCantidad());
            filaData.createCell(3).setCellValue(dv.getPrecioUnidad().doubleValue());
            filaData.createCell(4).setCellValue(dv.getImporte().doubleValue());

            numFila++;
        }
    }
}
