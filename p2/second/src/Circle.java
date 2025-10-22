public class Circle {
    private double radius;
    private double x;
    private double y;

    public Circle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    public boolean isInside(double pointX, double pointY) {
        double dx = pointX - this.x;
        double dy = pointY - this.y;

        double distance = Math.hypot(dx, dy);

        return distance <= this.radius;
    }

    public int getIntersectionPoints(Circle other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double distance = Math.hypot(dx, dy);

        double radiusSum = this.radius + other.radius;
        double radiusDiff = Math.abs(this.radius - other.radius);


        if (distance == 0 && this.radius == other.radius) {
            return -1;
        }

        if (distance > radiusSum) {
            return 0;
        }

        if (distance == radiusSum) {
            return 1;
        }

        if (distance < radiusDiff) {
            return 0;
        }

        if (distance == radiusDiff) {
            return 1;
        }

        return 2;
    }

    @Override
    public String toString() {
        return String.format("Circle[Radius=%.2f, Center=(%.2f, %.2f)]",
                this.radius, this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Circle other = (Circle) obj;

        return this.radius == other.radius &&
                this.x == other.x &&
                this.y == other.y;
    }
}