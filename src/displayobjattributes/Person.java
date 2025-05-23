package displayobjattributes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Person {
  public int x, y; // position of the person
  private String name; // name of the person
  private int age; // age of the person
  private PImage image; // image of the person
  private PApplet app; // the canvas used to display
  public Person(PApplet p, int x, int y, String name, int age, String imagePath) {
    this.app = p;
    this.x = x;
    this.y = y;
    this.name = name;
    this.age = age;
    this.image = app.loadImage(imagePath);
  }
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }
  public void draw() {
    // draw the image at the person's position
    app.image(image, x, y); 
    
  }
  
  public boolean isCollidingWith(Person other) {
    // calculates the center of this image 
    int centerX = x+(image.pixelWidth/2);
    int centerY = y+(image.pixelHeight/2);
    // calculates the center of the other image 
    int otherCenterX = other.x+(other.image.pixelWidth/2);
    int otherCenterY = other.y+(other.image.pixelHeight/2);
    // calcalutes the distance between the two center points
    float d = PApplet.dist(otherCenterX, otherCenterY, centerX ,centerY );
    
    // returns true if  the distance between the 2 cener points is
    // less than 32 pixels
    return d < 32; 
  }
}