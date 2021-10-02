module com.CFUN.CFUNGIT {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;

	
    opens com.CFUN.CFUNGIT to javafx.fxml;
    exports com.CFUN.CFUNGIT;
}
