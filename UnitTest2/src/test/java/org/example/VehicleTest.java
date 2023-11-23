package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VehicleTest {

    Car auto = new Car("Ford", "Kuga", 2020);
    Motorcycle moto = new Motorcycle("Racer", "Ranger", 2016);

    @Test
    void instanceOf() {
        assertThat(auto instanceof Vehicle);
    }

    @Test
    void WheelsCar() {
        assertThat(auto.getNumWheels()).isEqualTo(4);
    }

    @Test
    void MotorcycleWheels() {
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    @Test
    void testDriveCar() {
        auto.testDrive();
        assertThat(auto.getSpeed()).isEqualTo(60);
    }

    @Test
    void testDriveMotorcycle() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    @Test
    void parkCar() {
        auto.testDrive();
        auto.park();
        assertThat(auto.getSpeed()).isEqualTo(0);
    }

    @Test
    void parkMotorcycle() {
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}