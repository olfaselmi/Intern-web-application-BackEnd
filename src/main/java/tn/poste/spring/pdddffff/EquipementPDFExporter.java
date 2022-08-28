package tn.poste.spring.pdddffff;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import tn.poste.spring.entity.*;
 
 
public class EquipementPDFExporter {
    private List<Equipements> listEquipement;
     
    public EquipementPDFExporter(List<Equipements> listEquipement) {
        this.listEquipement = listEquipement;
    }
 

	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase(" Nature équipement", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Marque et Modèle", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Code à barres", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Diagnostic du Technicien Régional ", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("date", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (Equipements equipements : listEquipement) {
        	 table.addCell(String.valueOf(equipements.getNature().toString()));
        	 table.addCell(equipements.getMarque().toString());
            table.addCell(equipements.getCodeabarre().toString());
            table.addCell(equipements.getDiagnostic().toString());
            table.addCell(String.valueOf(equipements.getDate_Affectation()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.GRAY);
         
        Paragraph p = new Paragraph("Fiche livraison ", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}