package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne
    @JoinColumn
    private User user;

    public Car() {

    }

    public Car(String model, int series) {

        this.model = model;
        this.series = series;
    }


    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", model=" + model + ", series=" + series + "]";
    }
}
