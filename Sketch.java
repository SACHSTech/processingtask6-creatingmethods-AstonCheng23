import processing.core.PApplet;

public class Sketch extends PApplet {
  
  double x;
  double sineX;
  double sineY;
  
  public void settings() {
    size(800, 800);
  }

  
  public void setup() {
    background(207, 255, 253);
  }

  public void draw() {
//    println(twoSurfaceWavesMagnitude(200, 200, 600, 600) + " " + twoSurfaceWavesXComponent(200, 200, 600, 600, 315) + " " + twoSurfaceWavesYComponent(200, 200, 600, 600, 315)); 

    surfaceWave(200, 200, 200, 15);
    surfaceWave(600, 600, 200, 15);
    surfaceWave(300, 600, 200, 15);

    stroke(255, 0, 0);
    line(200, 200, 600, 600);
    stroke(255, 0, 0);
    line(200, 200, 300, 600);

// makes the component x and y lines. 
    stroke(255, 0, 0);
    line(200, 200, 200 + (float)twoSurfaceWavesXComponent(200, 200, 600, 600, 315), 200);
    
    stroke(255, 0, 0);
    line(200, 200, 200, 200 + (float)twoSurfaceWavesYComponent(200, 200, 600, 600, 315)); 
    
    stroke(0, 255, 60);
    fill(0, 255, 60);
    line(200, 200, 200 - (float)twoSurfaceWavesXComponent(200, 200, 300, 600, 285), 200);

    stroke(0, 255, 60);
    fill(0, 255, 60);
    line(200, 200, 200, 200 + (float)twoSurfaceWavesYComponent(200, 200, 300, 600, 285)); 
    
  }
/**
 * makes waves at points specified at xWave and yWave. The waveEnd and the wavelength specify the frequency and the wavelength of each wave. 
 * @param xWave
 * @param yWave
 * @param waveEnd
 * @param wavelength
 */
  public void surfaceWave(int xWave, int yWave, int waveEnd, int wavelength){
    stroke(0);
    noFill();
    ellipse(xWave, yWave, 0, 0);
    for (int wavePropogate = 1; wavePropogate < waveEnd; wavePropogate += wavelength){
        stroke(0);
        noFill();
        ellipse(xWave, yWave, wavePropogate, wavePropogate);
      }
    }
  
/**
 * twoSurfaceWavesMagnitude finds the length of the line between two points. twoSurfaceWavesXComponent and twoSurfaceWavesYComponent splits the magnitude into x and y components. 
 * @param xWave1
 * @param yWave1
 * @param xWave2
 * @param yWave2
 * @return
 */
  public double twoSurfaceWavesMagnitude(int xWave1, int yWave1, int xWave2, int yWave2){
    // this just draws the other parts of the triangle, ignore this.
    /* 
    stroke(0);
    line(xWave1, yWave1, xWave2, yWave1);
    stroke(0);
    line(xWave2, yWave1, xWave2, yWave2);
    */
    return Math.sqrt(Math.pow((yWave2 - yWave1), 2) + Math.pow((xWave2 - xWave1), 2));     
  }

  public double twoSurfaceWavesXComponent(int xWave1, int yWave1, int xWave2, int yWave2, int angle){
    return (twoSurfaceWavesMagnitude(xWave1, yWave1, xWave2, yWave2)*Math.cos(angle));
  }

  public double twoSurfaceWavesYComponent(int xWave1, int yWave1, int xWave2, int yWave2, int angle){
    return (twoSurfaceWavesMagnitude(xWave1, yWave1, xWave2, yWave2)*Math.sin(angle));
  }

}