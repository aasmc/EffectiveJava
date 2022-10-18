package ru.aasmc.effectivejava.chapter_03.item_10;

import java.awt.*;
import java.util.Objects;

public class TransitivityExample {
    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }
    }

    public static class ColorPointBrokenSymmetry extends Point {
        private final Color color;

        public ColorPointBrokenSymmetry(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColorPointBrokenSymmetry)) {
                return false;
            }
            // Broken - violates symmetry. You might get different results when
            // comparing a point to a color point and vice versa.
            return super.equals(o) && ((ColorPointBrokenSymmetry) o).color == color;
        }
    }

    public static class ColorPointBrokenTransitivity extends Point {
        private final Color color;

        public ColorPointBrokenTransitivity(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            // If o is a normal Point, do a color-blind comparison
            if (!(o instanceof ColorPointBrokenTransitivity)) {
                return o.equals(this);
            }
            // o is a ColorPointBrokenTransitivity; do a full comparison.
            return super.equals(o) && ((ColorPointBrokenTransitivity) o).color == color;
        }
    }

    public static class ColorPointCorrect {
        private final Point point;
        private final Color color;

        public ColorPointCorrect(int x, int y, Color color) {
            point = new Point(x, y);
            this.color = Objects.requireNonNull(color);
        }

        public Point asPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColorPointCorrect)) {
                return false;
            }
            ColorPointCorrect cp = (ColorPointCorrect) o;
            return cp.point.equals(point) && cp.color.equals(color);
        }
    }

    public static void main(String[] args) {
        ColorPointBrokenTransitivity p1 = new ColorPointBrokenTransitivity(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPointBrokenTransitivity p3 = new ColorPointBrokenTransitivity(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3)); // broken!
    }
}
