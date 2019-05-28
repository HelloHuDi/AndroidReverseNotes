package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng implements Cloneable {
    /* renamed from: df */
    private static DecimalFormat f15013df = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    private final double latitude;
    private final double longitude;

    static {
        AppMethodBeat.m2504i(101198);
        AppMethodBeat.m2505o(101198);
    }

    public LatLng(double d, double d2) {
        AppMethodBeat.m2504i(101191);
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.longitude = parseDouble(((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        } else {
            this.longitude = parseDouble(d2);
        }
        this.latitude = parseDouble(Math.max(-85.0d, Math.min(85.0d, d)));
        AppMethodBeat.m2505o(101191);
    }

    private static double parseDouble(double d) {
        AppMethodBeat.m2504i(101192);
        double parseDouble = Double.parseDouble(f15013df.format(d));
        AppMethodBeat.m2505o(101192);
        return parseDouble;
    }

    public final LatLng clone() {
        AppMethodBeat.m2504i(101193);
        LatLng latLng = new LatLng(this.latitude, this.longitude);
        AppMethodBeat.m2505o(101193);
        return latLng;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101194);
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        AppMethodBeat.m2505o(101194);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101195);
        if (this == obj) {
            AppMethodBeat.m2505o(101195);
            return true;
        } else if (obj instanceof LatLng) {
            LatLng latLng = (LatLng) obj;
            if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude)) {
                AppMethodBeat.m2505o(101195);
                return true;
            }
            AppMethodBeat.m2505o(101195);
            return false;
        } else {
            AppMethodBeat.m2505o(101195);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(101196);
        String str = "lat/lng: (" + this.latitude + "," + this.longitude + ")";
        AppMethodBeat.m2505o(101196);
        return str;
    }
}
