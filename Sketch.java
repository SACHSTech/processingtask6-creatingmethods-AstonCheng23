import processing.core.PApplet;

public class Sketch extends PApplet {
  
  double x;
  double sineX;
  double sineY;
  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(207, 255, 253);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    if (frameCount > 60){
      frameCount = 0;
    }
    println(twoSurfaceWavesMagnitude(200, 200, 600, 600) + " " + twoSurfaceWavesXComponent(200, 200, 600, 600, 315) + " " + twoSurfaceWavesYComponent(200, 200, 600, 600, 315)); 

    surfaceWave(200, 200, 200, 15);
    surfaceWave(600, 600, 200, 15);
    surfaceWave(300, 600, 200, 15);
    //println(surfaceWave(200, 200, 200, 15));

    stroke(0);
    line(200, 200, 600, 600);
    stroke(0);
    line(200, 200, 300, 600);


    stroke(0);
    line(200, 200, 200 + (float)twoSurfaceWavesXComponent(200, 200, 600, 600, 315), 200);
    
    stroke(0);
    line(200, 200, 200, 200 + (float)twoSurfaceWavesYComponent(200, 200, 600, 600, 315)); 
    
    stroke(100, 100, 100);
    fill(100,100,100);
    line(200, 200, 200 - (float)twoSurfaceWavesXComponent(200, 200, 300, 600, 285), 200);

    stroke(100, 100, 100);
    fill(100,100,100);
    line(200, 200, 200, 200 + (float)twoSurfaceWavesYComponent(200, 200, 300, 600, 285)); 
  }
/**
 * 
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
    return Math.sqrt(Math.pow((yWave2 - yWave1), 2) + Math.pow((xWave2 - xWave1), 2)); 
  }
  public double twoSurfaceWavesXComponent(int xWave1, int yWave1, int xWave2, int yWave2, int angle){
    return (twoSurfaceWavesMagnitude(xWave1, yWave1, xWave2, yWave2)*Math.cos(angle));
  }
  public double twoSurfaceWavesYComponent(int xWave1, int yWave1, int xWave2, int yWave2, int angle){
    return (twoSurfaceWavesMagnitude(xWave1, yWave1, xWave2, yWave2)*Math.sin(angle));
  }

}