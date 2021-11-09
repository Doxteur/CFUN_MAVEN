package com.CFUN.barcodeGeneration;

import com.keepautomation.barcode.*;

public class generatingBarCode {

	BarCode barcode = new BarCode();
    barcode.setCodeToEncode(barCodeNum);
    barcode.setSymbology(IBarCode.EAN13);
    barcode.setX(2);
    barcode.setY(50);
    barcode.setChecksumEnabled(false);
    barcode.setFnc1(IBarCode.FNC1_NONE);
    try {
    	barcode.draw("/home/etudiant/Private Pierr/cfun-git/Project_Other/barcode/barcode.png");
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
	
}
