package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Base64;


/**
 * @author Ivannikov Ilya (voldores@mail.ru)
 * @version $id
 * @since 0.1
 */

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne (mappedBy = "carDetails", orphanRemoval = true, cascade = CascadeType.ALL)
    private Ads carAd;

    @ManyToOne (optional = false)
    @JoinColumn (name = "brand_id")
    private Brands brand;

    @ManyToOne (optional = false)
    @JoinColumn (name = "model_id")
    private Models model;

    @ManyToOne (optional = false)
    @JoinColumn(name = "body_id")
    private BodyType body;

    @ManyToOne (optional = false)
    @JoinColumn (name = "engine_id")
    private Engines engine;

    @Column(name = "car_year")
    private String carYear;

    @Column(name = "color")
    private String color;


    public Car(Brands brand, Models model, BodyType body, Engines engine, String carYear, String color) {
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.engine = engine;
        this.carYear = carYear;
        this.color = color;
    }

    public Car() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ads getCarAd() {
        return carAd;
    }

    public void setCarAd(Ads carAd) {
        this.carAd = carAd;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public BodyType getBody() {
        return body;
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

    public Engines getEngine() {
        return engine;
    }

    public void setEngine(Engines engine) {
        this.engine = engine;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}