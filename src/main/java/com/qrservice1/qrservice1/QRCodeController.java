package com.qrservice1.qrservice1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class QRCodeController {

    @GetMapping(value = "/generateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<String> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height) {
        try {
            if (width <= 0 || height <= 0) {
                return ResponseEntity.badRequest().body("Width and height must be positive integers.");
            }

            byte[] qrCodeImage = QRCodeGenerator.getQRCodeImage(codeText, width, height);
            String base64Image = Base64.getEncoder().encodeToString(qrCodeImage);
            String imgTag = "<img src='data:image/png;base64," + base64Image + "' alt='QR Code'/>";

            return ResponseEntity.status(HttpStatus.OK).body(imgTag);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error generating QR Code: " + e.getMessage());
        }
    }
}
