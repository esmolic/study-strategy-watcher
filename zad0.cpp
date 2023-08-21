  #include <iostream>

  #include <assert.h>

  #include <stdlib.h>

  struct Point {
    int x;
    int y;
  };
  class Shape {
    public:
      enum EType {
        circle,
        square
      };
    virtual void draw() = 0;
    EType type_;
  };
  struct Circle: public Shape {
    private: double radius_;
    Point center_;
    public: Shape::EType type_;
    virtual void draw() {
      std::cerr << "in drawCircle\n";
    }
  };
  struct Square: public Shape {
    private: double side_;
    Point center_;
    public: Shape::EType type_;

    virtual void draw() {
      std::cerr << "in drawSquare\n";

    }
  };

  void drawShapes(Shape ** shapes, int n) {
    for (int i = 0; i < n; ++i) {
      struct Shape * s = shapes[i];
      s -> draw();
    }
  }
  int main() {
    Shape * shapes[4];
    shapes[0] = (Shape * ) new Circle;
    shapes[0] -> type_ = Shape::circle;
    shapes[1] = (Shape * ) new Square;
    shapes[1] -> type_ = Shape::square;
    shapes[2] = (Shape * ) new Square;
    shapes[2] -> type_ = Shape::square;
    shapes[3] = (Shape * ) new Circle;
    shapes[3] -> type_ = Shape::circle;

    drawShapes(shapes, 4);
  }