import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter(Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    // getNumPoints
    public int getNumPoints(Shape s) {
        int totalPoints = 0;
        for (Point p : s.getPoints()) {
            totalPoints += 1;
        }
        return totalPoints;
    }

    // getAverageLength
    public double getAverageLength(Shape s) {
        double averageLength = getPerimeter(s) / getNumPoints(s);
        return averageLength;
    }

    // getLargestSide
    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide) {
                largestSide = currDist;
            }
            prevPt = currPt;
        }

        return largestSide;
    }

    // getLargestX
    public double getLargestX(Shape s) {
        double largestX = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currPtX = currPt.getX();
            if (currPtX > largestX) {
                largestX = currPtX;
            }
            prevPt = currPt;
        }
        return largestX;

    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        int totalPoints = getNumPoints(s);
        System.out.println("number of points = " + totalPoints);

        double averageLength = getAverageLength(s);
        System.out.println("average length = " + averageLength);

        double largestSide = getLargestSide(s);
        System.out.println("largest side = " + largestSide);

        double largestX = getLargestX(s);
        System.out.println("largest X = " + largestX);
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
