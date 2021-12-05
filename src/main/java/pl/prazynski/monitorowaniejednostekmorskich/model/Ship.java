package pl.prazynski.monitorowaniejednostekmorskich.model;

public class Ship {

    private String vesselName;
    private String portOfCall;
    private String vesselType;
    private String vesselFlag;


    private String lastPort;
    private String nextPort;
    private String eta;
    private String ata;
    private String etd;
    private String callId;
    private String statusId;

    private String countryCode;

    public Ship() {
    }

    public Ship(String vesselName, String portOfCall, String vesselType, String vesselFlag, String lastPort, String nextPort, String eta, String ata, String etd, String callId, String statusId, String countryCode) {
        this.vesselName = vesselName;
        this.portOfCall = portOfCall;
        this.vesselType = vesselType;
        this.vesselFlag = vesselFlag;
        this.lastPort = lastPort;
        this.nextPort = nextPort;
        this.eta = eta;
        this.ata = ata;
        this.etd = etd;
        this.callId = callId;
        this.statusId = statusId;
        this.countryCode = countryCode;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getPortOfCall() {
        return portOfCall;
    }

    public void setPortOfCall(String portOfCall) {
        this.portOfCall = portOfCall;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
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

        if (nextPort.length()>6){
            this.nextPort = nextPort;
        }else{
            this.nextPort = "brak danych";
        }
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
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
