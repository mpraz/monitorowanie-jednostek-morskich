package pl.prazynski.monitorowaniejednostekmorskich.model;

public class ShipPoint {

    private double x;
    private double y;
    private String portOfCall;
    private String vesselName;
    private String vesselFlag;
    private String vesselType;

    private String lastPort;
    private String nextPort;
    private String eta;
    private String ata;
    private String etd;
    private String callId;
    private String statusId;

    private String countryCode;

    public ShipPoint() {
    }

    public ShipPoint(double x, double y, String portOfCall, String vesselName, String vesselFlag, String vesselType, String lastPort, String nextPort, String eta, String ata, String etd, String callId, String statusId, String countryCode) {
        this.x = x;
        this.y = y;
        this.portOfCall = portOfCall;
        this.vesselName = vesselName;
        this.vesselFlag = vesselFlag;
        this.vesselType = vesselType;
        this.lastPort = lastPort;
        this.nextPort = nextPort;
        this.eta = eta;
        this.ata = ata;
        this.etd = etd;
        this.callId = callId;
        this.statusId = statusId;
        this.countryCode = countryCode;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getPortOfCall() {
        return portOfCall;
    }

    public void setPortOfCall(String portOfCall) {
        this.portOfCall = portOfCall;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVesselFlag() {
        return vesselFlag;
    }

    public void setVesselFlag(String vesselFlag) {
        this.vesselFlag = vesselFlag;
    }

    public String getLastPort() {
        return lastPort;
    }

    public void setLastPort(String lastPort) {
        this.lastPort = lastPort;
    }

    public String getNextPort() {
        return nextPort;
    }

    public void setNextPort(String nextPort) {
        this.nextPort = nextPort;

    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getAta() {
        return ata;
    }

    public void setAta(String ata) {
        this.ata = ata;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getStatusId() {

        String statusDescription = "nieznany";

        switch(this.statusId){
            case "1":
                statusDescription = "w drodze";
                break;
            case "2":
                statusDescription = "nieznany";
            case "3":
                statusDescription = "w porcie";
        }

        return statusDescription ;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
