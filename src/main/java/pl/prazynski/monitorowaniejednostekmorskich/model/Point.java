package pl.prazynski.monitorowaniejednostekmorskich.model;

public class Point {

    private double y;
    private double x;
    private String name;


    private String portOfCalls;
    private String vesselName;
    private double destinationY;
    private double destinationX;

    public Point(double x, double y, String name, double destinationY, double destinationX) {
        this.y = y;
        this.x = x;
        this.name = name;
        this.destinationY = destinationY;
        this.destinationX = destinationX;
    }

    public Point(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }


    public Point(double x, double y, String portOfCalls, String vesselName) {
        this.x = x;
        this.y = y;
        this.portOfCalls = portOfCalls;
        this.vesselName = vesselName;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getPortOfCalls() {
        return portOfCalls;
    }

    public void setPortOfCalls(String portOfCalls) {
        this.portOfCalls = portOfCalls;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(double destinationY) {
        this.destinationY = destinationY;
    }

    public double getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(double destinationX) {
        this.destinationX = destinationX;
    }
}