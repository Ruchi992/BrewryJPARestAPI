package com.ruchi.breweriesrestapi;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import java.awt.image.BufferedImage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Taste")
public class TasteController {

    @GetMapping(value = "/code/{BreweryId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception {
        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(barcode, BarcodeFormat.EAN_13, 300, 150);

        //example from https://www.baeldung.com/java-generating-barcodes-qr-codes
        //FIXME example does not say what static import was used to get okResponse() method.
        //return okResponse(MatrixToImageWriter.toBufferedImage(bitMatrix));
        return null;
    }
}
