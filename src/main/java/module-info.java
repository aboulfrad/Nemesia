module universite_paris8.iut.aboulfrad.nemesiatest2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens universite_paris8.iut.aboulfrad.nemesiatest2 to javafx.fxml;
    exports universite_paris8.iut.aboulfrad.nemesiatest2;
}