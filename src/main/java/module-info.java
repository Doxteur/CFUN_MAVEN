module com.CFUN.CFUNGIT {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	requires com.jfoenix;
	
    opens com.CFUN.CFUNGIT to javafx.fxml;
    exports com.CFUN.CFUNGIT;
}
