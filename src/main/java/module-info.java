module com.CFUN.CFUNGIT {
    requires javafx.controls;
    requires com.keepautomation.barcode;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	
    opens com.CFUN.CFUNGIT to javafx.fxml;
    exports com.CFUN.CFUNGIT;
}
