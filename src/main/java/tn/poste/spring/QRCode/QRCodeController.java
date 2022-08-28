package tn.poste.spring.QRCode;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import com.google.zxing.WriterException;

import tn.poste.spring.entity.Bureau;
import tn.poste.spring.service.IBureauService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import java.util.Base64;

@RestController
public class QRCodeController {

	@Autowired
	private IBureauService bureauService;
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	@GetMapping(value = "/genrateQRCode/{idBureau}")
	public String getQRCode(Model model, @PathVariable("idBureau") Long idBureau) {
		Bureau b = bureauService.retrieveBureauById(idBureau);
		
		String medium =" CodePostale  :"+ b.getCodePostale();
		String github = "TypeDeStructure=" + b.getTypeDeStructure();

		byte[] image = new byte[0];
		try {

			// Generate and Return Qr Code in Byte Array
			image = QRCodeGenerator.getQRCodeImage(medium, 250, 250);

			// Generate and Save Qr Code Image in static/image folder
			QRCodeGenerator.generateQRCodeImage(medium, 250, 250, QR_CODE_IMAGE_PATH);

		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		// Convert Byte Array into Base64 Encode String
		String qrcode = Base64.getEncoder().encodeToString(image);

		model.addAttribute("medium", medium);
		model.addAttribute("github", github);
		model.addAttribute("qrcode", qrcode);

		return "medium";
	}
}
