package com.CFUN.barcodeGeneration;

import com.keepautomation.barcode.*;

public class generatingBarCode {

	public void GenerateCode() {
		BarCode barcode = new BarCode();
	    barcode.setCodeToEncode("123456789");
	    barcode.setSymbology(IBarCode.CODE128);
	    barcode.setX(2);
	    barcode.setY(50);
	    barcode.setRightMargin(0);
	    barcode.setLeftMargin(0);
	    barcode.setTopMargin(0);
	    barcode.setBottomMargin(0);
	    barcode.setChecksumEnabled(false);
	    barcode.setFnc1(IBarCode.FNC1_NONE);
	    try {
	    	barcode.draw("c://code128.gif");
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}