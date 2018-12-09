package ua.edu.ukma.ykrukovska.warplane;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GPolygon;

import java.awt.*;

public class GPlane extends GCompound {


    // Compounds elements of planes.
    public GPlane(double width, double height) {

        GPolygon rudder = createRudder(width, height);
        rudder.setFilled(true);
        rudder.setFillColor(Color.black);
        add(rudder);

        GPolygon body = createBody(width, height);
        body.setFilled(true);
        body.setFillColor(Color.black);
        add(body);

        GOval propeller = new GOval(width / 100, height / 75.);
        propeller.setFilled(true);
        propeller.setFillColor(Color.black);
        add(propeller, width / 3.2, height / 5.);

        GPolygon wing = createWing(width, height);
        wing.setFilled(true);
        wing.setFillColor(Color.black);
        add(wing);

    }

    // Creates rudder
    private GPolygon createRudder(double width, double height) {
        GPolygon rudder = new GPolygon();
        rudder.addVertex(width / 16., height / 12.);
        rudder.addVertex(width / 16., height / 6.);
        rudder.addVertex(width / 8., height / 6.);

        return rudder;
    }

    // Creates body of the plane
    private GPolygon createBody(double width, double height) {
        GPolygon body = new GPolygon();
        body.addVertex(width / 16., height / 6.);
        body.addVertex(width / 3.2, height / 4.);
        body.addVertex(width / 3.2, height / 6.);
        return body;

    }

    // Creares a wing of the plane
    private GPolygon createWing(double width, double height) {
        GPolygon wing = new GPolygon();
        wing.addVertex(width / 5.3, height / 4.8);
        wing.addVertex(width / 4., height / 4.8);
        wing.addVertex(width / 6.7, height / 3.4);
        return wing;
    }


}
