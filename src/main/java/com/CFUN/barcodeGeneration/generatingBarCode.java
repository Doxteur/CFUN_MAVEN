package com.CFUN.barcodeGeneration;

import com.CFUN.app.Arrivee;
import com.CFUN.app.Complexe;
import com.keepautomation.barcode.*;

public class generatingBarCode {

	String CodeBar;
	
	public void GetInfo() {
		Complexe lecomplexe = new Complexe(4, 4, "CFUN");
		Arrivee MonArrivant = new Arrivee(lecomplexe, 'M');
		Arrivee.AjoutArrivant(MonArrivant);
		lecomplexe.entreeUsager(MonArrivant);
		Arrivee MonArrivant2 = Arrivee.GetArrivantByTicket("1");

		String[] Infobillet = MonArrivant.GetBilletInfo();
		String[] parts = Infobillet[2].split("/");
		String[] HourParts = Infobillet[3].split(":");

		// NUMERO DU TICKET pour ecrire sur le barcode
		String CodeBarNumticket = "";
		if (Integer.parseInt(Infobillet[1]) < 10) {
			CodeBarNumticket = "0" + Infobillet[1];
		} else {
			CodeBarNumticket = Infobillet[1];
		}

		// DATE DU TICKET pour ecrire sur le barcode
		int parts2 = Integer.parseInt(parts[2]) - 2000;
		String DateTicket = parts[0] + parts[1] + parts2;

		// HEURE DU TICKET pour ecrire sur le barcode
		String HourTicket = HourParts[0] + HourParts[1];

		// ECRITURE DU BARCODE
		CodeBar = CodeBarNumticket + DateTicket + HourTicket;

		System.out.println(CodeBar);
		
	}
	
	

	public void GenerateCode() {

		BarCode barcode = new BarCode();
		barcode.setCodeToEncode(/*CodeBar*/"012345678999");
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
			barcode.draw("CFUNGIT/src/main/java/com/CFUN/barcodeGeneration/BARCODE_Images/barcode_" + CodeBar + ".png");
			//barcode.draw("/home/etudiant/barcode.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}