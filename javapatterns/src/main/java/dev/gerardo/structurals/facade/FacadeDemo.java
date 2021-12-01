package dev.gerardo.structurals.facade;

import java.util.ArrayList;
import java.util.List;

class Buffer {

  private char[] characters;
  private int lineWidth;

  public Buffer(int lineHeight, int lineWidth) {
    this.lineWidth = lineWidth;
    this.characters = new char[lineHeight * lineWidth];
  }

  public char charAt(int x, int y) {
    return characters[y * lineWidth + x];
  }
}

class ViewPort {
  private Buffer buffer;
  private int width;
  private int height;
  private int offsetX;
  private int offsetY;

  public ViewPort(Buffer buffer, int width, int height, int offsetX, int offsetY) {
    this.buffer = buffer;
    this.width = width;
    this.height = height;
    this.offsetX = offsetX;
    this.offsetY = offsetY;
  }

  public char charAt(int x, int y) {
    return buffer.charAt(x + offsetX, y + offsetY);
  }
}

class Console {
  private List<ViewPort> viewPorts = new ArrayList<>();
  private int width, height;

  public Console(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public static Console newConsole(int width, int height) {
    Buffer buffer = new Buffer(30, 20);
    ViewPort vp = new ViewPort(buffer, 30, 20, 0, 0);

    Console console = new Console(30, 20);
    return console;
  }

  public void addViewPort(ViewPort viewPort) {
    viewPorts.add(viewPort);
  }

  public void render() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        for (ViewPort vw : viewPorts) {
          System.out.print(vw.charAt(x, y));
        }
      }
      System.out.println();
    }
  }
}

public class FacadeDemo {
  public static void main(String[] args) {
    /* Buffer buffer = new Buffer(30, 20);
    ViewPort vp = new ViewPort(buffer, 30, 20, 0, 0);

    Console console = new Console(30, 20);
    console.addViewPort(vp);
    console.render(); */

    Console consoleFacade = Console.newConsole(30, 20);
    consoleFacade.render();;
  }
}
