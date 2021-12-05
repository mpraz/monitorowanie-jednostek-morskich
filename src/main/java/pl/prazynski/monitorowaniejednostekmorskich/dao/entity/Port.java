package pl.prazynski.monitorowaniejednostekmorskich.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Port")
public class Port{

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String name;

    private String callOff;

    private Double x;

    private Double y;

    private String size;
    private String openedDate;
    private String camLink;
    private String description;


    public Port() {
    }

    public Port(Long id, String name, String callOff, Double x, Double y, String size, String openedDate, String camLink, String description) {
        this.id = id;
        this.name = name;
        this.callOff = callOff;
        this.x = x;
        this.y = y;
        this.size = size;
        this.openedDate = openedDate;
        this.description = description;
        this.camLink = camLink;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallOff() {
        return callOff;
    }

    public void setCallOff(String callOff) {
        this.callOff = callOff;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(String openedDate) {
        this.openedDate = openedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCamLink() {
        return camLink;
    }

    public void setCamLink(String camLink) {
        this.camLink = camLink;
    }
}
