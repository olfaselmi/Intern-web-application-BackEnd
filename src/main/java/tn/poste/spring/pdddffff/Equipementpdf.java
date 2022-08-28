package tn.poste.spring.pdddffff;
 
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.lowagie.text.DocumentException;

import tn.poste.spring.entity.Equipements;
import tn.poste.spring.service.IEquipementService;
@CrossOrigin(origins = "*", allowedHeaders = "*")

 
@Controller
public class Equipementpdf {
 
    @Autowired
    private IEquipementService service;
         
    @GetMapping("/Equipement/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=equipement_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<tn.poste.spring.entity.Equipements> listEquipement = service.retrieveAllEquipement();
        
        EquipementPDFExporter EquipementPDFExporter = new EquipementPDFExporter(listEquipement);
        EquipementPDFExporter.export(response);
         
         
    }
}