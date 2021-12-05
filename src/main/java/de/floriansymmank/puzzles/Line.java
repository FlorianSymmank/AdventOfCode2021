package de.floriansymmank.puzzles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public boolean isHorizontal() {
        return start.y == end.y;
    }

    public boolean isVertical() {
        return start.x == end.x;
    }

    public boolean isDiagonal() {
        return !isHorizontal() && !isVertical();
    }

    public List<Point> getAllPoints() {
        List<Point> points = new ArrayList<>();
        if (isHorizontal()) {
            for (int x = getMinX(); x <= getMaxX(); x++) {
                points.add(new Point(x, start.y));
            }
        } else if (isVertical()) {
            for (int y = getMinY(); y <= getMaxY(); y++) {
                points.add(new Point(start.x, y));
            }
        } else if (isDiagonal()) {
            Point leftPoint = end;
            Point rightPoint = start;

            if (Math.min(start.x, end.x) == start.x) {
                leftPoint = start;
                rightPoint = end;
            }

            int x = leftPoint.x;
            if (leftPoint.y < rightPoint.y) {
                for (int y = leftPoint.y; y <= rightPoint.y; y++) {
                    points.add(new Point(x, y));
                    x++;
                }
            } else {
                for (int y = leftPoint.y; y >= rightPoint.y; y--) {
                    points.add(new Point(x, y));
                    x++;
                }
            }
        }

        return points;
    }

    public int getMinX() {
        return Math.min(start.x, end.x);
    }

    public int getMaxX() {
        return Math.max(start.x, end.x);
    }

    public int getMinY() {
        return Math.min(start.y, end.y);
    }

    public int getMaxY() {
        return Math.max(start.y, end.y);
    }

    @Override
    public String toString() {
        return "Line{" + "start=" + start + ", end=" + end + '}';
    }
}
