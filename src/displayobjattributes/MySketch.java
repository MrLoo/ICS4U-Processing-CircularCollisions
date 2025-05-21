package displayobjattributes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 090464
 */
import processing.core.PApplet;

public class MySketch extends PApplet {
  private Person person1; // declare a person object
  private Person person2; // declare a person object
  private boolean showInfo = false; // whether or not to display the person's info

  
  public void settings() {
    size(400, 400);
  }
  public void setup() {
    background(255); // set the background color to white
    // create a person object in the center of the screen
    person1 = new Person(this, 100, 100, "Mr. Lu", 99, "images/person.png");
    person2 = new Person(this, 200, 200, "Mr. Loo", 77, "images/person.png"); 
  }
  
  public void draw() {
    background(255); // clear the screen
    person1.draw(); // draw the person on the screen
    if (keyPressed) {
      if (keyCode == LEFT) {
        person2.move(-2, 0);
      } else if (keyCode == RIGHT) {
        person2.move(2, 0);
      } else if (keyCode == UP) {
        person2.move(0, -2);
      } else if (keyCode == DOWN) {
        person2.move(0, 2);
      }
    }
    person2.draw(); // draw the person on the screen
    
    if (person1.isCollidingWith(person2)) {
      fill(255, 0, 0); // set the stroke color to red
      this.text("oouch", person2.x, person2.y); 
    }
  }
  
}



