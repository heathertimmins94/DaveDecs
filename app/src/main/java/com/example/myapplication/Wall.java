package com.example.myapplication;

public class Wall {

    //Data field
    private String name;
    private double length;
    private double height;

    //Constructors
    public Wall(String name, double length, double height) {
        this.name = name;
        this.length = length;
        this.height = height;
    }


    //Methods
    public String getName() {
        return name;
    }

// If name is empty - throw exception
    public void setName(String name) {
        if (name!= "") {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public double getLength() {
        return length;
    }
    // If length is zero or less - throw exception
    public void setLength(double length) {
        if (length > 0 ) {
            this.length = length;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double getHeight() {
        return height;
    }
    // If height is zero or less - throw exception
    public void setHeight(double height) {
        if (height > 0 ) {
            this.height = height;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return
                "name=" + name +
                ", length=" + length +
                ", height=" + height + ", area=" + Area()
                ;
    }
    public double Area() {
        return height * length;
    }
}
