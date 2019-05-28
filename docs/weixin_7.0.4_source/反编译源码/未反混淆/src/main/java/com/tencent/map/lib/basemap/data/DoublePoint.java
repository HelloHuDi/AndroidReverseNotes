package com.tencent.map.lib.basemap.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DoublePoint {
    public double x;
    public double y;

    public DoublePoint(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void set(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (this.x == doublePoint.x && this.y == doublePoint.y) {
            return true;
        }
        return false;
    }

    public String toString() {
        AppMethodBeat.i(97841);
        String str = this.x + "," + this.y;
        AppMethodBeat.o(97841);
        return str;
    }
}
