package com.orange.hrm.framework.utilities;

import com.orange.hrm.framework.web.constants.FrameworkConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PDFUtil {
    public static String ReadPDFFile(String filename) {
        String pdfFileData = null;
        String fileNameValue = FrameworkConstants.getPropertyLocation() + filename;
        try {
            FileInputStream file = new FileInputStream(fileNameValue);
            PDDocument doc = PDDocument.load(file);
            PDFTextStripper textStrip = new PDFTextStripper();
            pdfFileData = textStrip.getText(doc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfFileData;
    }
}
