package com.tencent.map.lib.basemap.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DoublePoint {
    /* renamed from: x */
    public double f2800x;
    /* renamed from: y */
    public double f2801y;

    public DoublePoint(double d, double d2) {
        this.f2800x = d;
        this.f2801y = d2;
    }

    public void set(double d, double d2) {
        this.f2800x = d;
        this.f2801y = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (this.f2800x == doublePoint.f2800x && this.f2801y == doublePoint.f2801y) {
            return true;
        }
        return false;
    }

    public String toString() {
        AppMethodBeat.m2504i(97841);
        String str = this.f2800x + "," + this.f2801y;
        AppMethodBeat.m2505o(97841);
        return str;
    }
}
