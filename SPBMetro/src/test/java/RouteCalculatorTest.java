import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/*MY METRO
===================

*   A1          C4
*   |           |
* A2/AC1------C3/CA1
*   |           |
*   A3          C2
*   |           |
* A4/B1-B2-B3-B4/C1

* =================
* */
public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    List<Station> AB;
    List<Station> BC;
    List<Station> AC;
    List<Station> CA;
    List<Station> route;
    RouteCalculator shortRoute;
    Line A;
    Line B;
    Line C;
    Line ACL;

    @Override
    protected void setUp() throws Exception {
        AB = new ArrayList<>();
        BC = new ArrayList<>();
        AC = new ArrayList<>();
        CA = new ArrayList<>();
        route = new ArrayList<>();
        A = new Line(1, "A");
        B = new Line(2, "B");
        C = new Line(3, "C");
        ACL = new Line(4,"AC");
        Station A1 = new Station("A1", A);
        Station A2 = new Station("A2", A);
        Station A3 = new Station("A3", A);
        Station A4 = new Station("A4", A);
        Station B1 = new Station("B1", B);
        Station B2 = new Station("B2", B);
        Station B3 = new Station("B3", B);
        Station B4 = new Station("B4", B);
        Station C1 = new Station("C1", C);
        Station C2 = new Station("C2", C);
        Station C3 = new Station("C3", C);
        Station C4 = new Station("C4", C);
        Station AC1 = new Station("AC1", ACL);
        Station CA1 = new Station("CA1", ACL);
        A.addStation(A1);
        A.addStation(A2);
        A.addStation(A3);
        A.addStation(A4);
        B.addStation(B1);
        B.addStation(B2);
        B.addStation(B3);
        B.addStation(B4);
        C.addStation(C1);
        C.addStation(C2);
        C.addStation(C3);
        C.addStation(C4);
        ACL.addStation(CA1);
        ACL.addStation(AC1);
        AB.add(A4);
        AB.add(B1);
        BC.add(B4);
        BC.add(C4);
        AC.add(A2);
        AC.add(AC1);
        CA.add(C3);
        CA.add(CA1);
        stationIndex.addLine(A);
        stationIndex.addLine(B);
        stationIndex.addLine(C);
        stationIndex.addLine(ACL);
        stationIndex.addStation(A1);
        stationIndex.addStation(A2);
        stationIndex.addStation(A3);
        stationIndex.addStation(A4);
        stationIndex.addStation(B1);
        stationIndex.addStation(B2);
        stationIndex.addStation(B3);
        stationIndex.addStation(B4);
        stationIndex.addStation(C1);
        stationIndex.addStation(C2);
        stationIndex.addStation(C3);
        stationIndex.addStation(C4);
        stationIndex.addStation(AC1);
        stationIndex.addStation(CA1);
        stationIndex.addConnection(AB);
        stationIndex.addConnection(BC);
        stationIndex.addConnection(AC);
        stationIndex.addConnection(CA);
        route.add(A1);
        route.add(A2);
        route.add(A3);
        route.add(A4);
        route.add(B1);
        route.add(B2);
        route.add(B3);
        route.add(B4);
        route.add(C1);
        shortRoute = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22;
        assertEquals(expected, actual);

    }

    public void testGetShortestRoute() {
        List<Station> actual = shortRoute.getShortestRoute(stationIndex.getStation("A1"),
                stationIndex.getStation("C4"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("A1"));
        expected.add(stationIndex.getStation("A2"));
        expected.add(stationIndex.getStation("AC1"));
        expected.add(stationIndex.getStation("CA1"));
        expected.add(stationIndex.getStation("C3"));
        expected.add(stationIndex.getStation("C4"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute2() {
        List<Station> actual = shortRoute.getShortestRoute(stationIndex.getStation("A2"),
                stationIndex.getStation("B2"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("A2"));
        expected.add(stationIndex.getStation("A3"));
        expected.add(stationIndex.getStation("A4"));
        expected.add(stationIndex.getStation("B1"));
        expected.add(stationIndex.getStation("B2"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute3() {
        List<Station> actual = shortRoute.getShortestRoute(stationIndex.getStation("C4"),
                stationIndex.getStation("C1"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("C4"));
        expected.add(stationIndex.getStation("C3"));
        expected.add(stationIndex.getStation("C2"));
        expected.add(stationIndex.getStation("C1"));
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {
    }
}
