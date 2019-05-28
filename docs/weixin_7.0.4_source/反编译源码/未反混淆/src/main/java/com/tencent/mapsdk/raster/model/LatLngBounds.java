package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.h;

public class LatLngBounds {
    private int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;

    public static final class Builder {
        private double mEast = Double.NaN;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mWest = Double.NaN;

        public final Builder include(LatLng latLng) {
            AppMethodBeat.i(101199);
            this.mSouth = Math.min(this.mSouth, latLng.getLatitude());
            this.mNorth = Math.max(this.mNorth, latLng.getLatitude());
            double longitude = latLng.getLongitude();
            if (Double.isNaN(this.mWest)) {
                this.mWest = longitude;
            } else {
                if (!containsLongitude(longitude)) {
                    if (LatLngBounds.access$400(this.mWest, longitude) < LatLngBounds.access$500(this.mEast, longitude)) {
                        this.mWest = longitude;
                    }
                }
                AppMethodBeat.o(101199);
                return this;
            }
            this.mEast = longitude;
            AppMethodBeat.o(101199);
            return this;
        }

        public final Builder include(Iterable<LatLng> iterable) {
            AppMethodBeat.i(101200);
            if (iterable != null) {
                for (LatLng include : iterable) {
                    include(include);
                }
            }
            AppMethodBeat.o(101200);
            return this;
        }

        private boolean containsLongitude(double d) {
            if (this.mWest <= this.mEast) {
                if (this.mWest > d || d > this.mEast) {
                    return false;
                }
                return true;
            } else if (this.mWest <= d || d <= this.mEast) {
                return true;
            } else {
                return false;
            }
        }

        public final LatLngBounds build() {
            AppMethodBeat.i(101201);
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
            AppMethodBeat.o(101201);
            return latLngBounds;
        }
    }

    static /* synthetic */ double access$400(double d, double d2) {
        AppMethodBeat.i(101214);
        double longitudeDistanceHeadingWest = longitudeDistanceHeadingWest(d, d2);
        AppMethodBeat.o(101214);
        return longitudeDistanceHeadingWest;
    }

    static /* synthetic */ double access$500(double d, double d2) {
        AppMethodBeat.i(101215);
        double longitudeDistanceHeadingEast = longitudeDistanceHeadingEast(d, d2);
        AppMethodBeat.o(101215);
        return longitudeDistanceHeadingEast;
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(101202);
        Builder include = new Builder().include(latLng).include(latLng2);
        this.southwest = new LatLng(include.mSouth, include.mWest);
        this.northeast = new LatLng(include.mNorth, include.mEast);
        this.mVersionCode = i;
        AppMethodBeat.o(101202);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* Access modifiers changed, original: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public static Builder builder() {
        AppMethodBeat.i(101203);
        Builder builder = new Builder();
        AppMethodBeat.o(101203);
        return builder;
    }

    public LatLng getSouthwest() {
        return this.southwest;
    }

    public LatLng getNortheast() {
        return this.northeast;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.i(101204);
        if (containsLatitude(latLng.getLatitude()) && containsLongitude(latLng.getLongitude())) {
            AppMethodBeat.o(101204);
            return true;
        }
        AppMethodBeat.o(101204);
        return false;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        boolean z = false;
        AppMethodBeat.i(101205);
        if (latLngBounds == null) {
            AppMethodBeat.o(101205);
        } else {
            if (contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
                z = true;
            }
            AppMethodBeat.o(101205);
        }
        return z;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        AppMethodBeat.i(101206);
        if (latLngBounds == null) {
            AppMethodBeat.o(101206);
            return false;
        } else if (intersect(latLngBounds) || latLngBounds.intersect(this)) {
            AppMethodBeat.o(101206);
            return true;
        } else {
            AppMethodBeat.o(101206);
            return false;
        }
    }

    private boolean intersect(LatLngBounds latLngBounds) {
        AppMethodBeat.i(101207);
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            AppMethodBeat.o(101207);
            return false;
        }
        double latitude = ((latLngBounds.northeast.getLatitude() + latLngBounds.southwest.getLatitude()) - this.northeast.getLatitude()) - this.southwest.getLatitude();
        double latitude2 = ((this.northeast.getLatitude() - this.southwest.getLatitude()) + latLngBounds.northeast.getLatitude()) - latLngBounds.southwest.getLatitude();
        if (Math.abs(((latLngBounds.northeast.getLongitude() + latLngBounds.southwest.getLongitude()) - this.northeast.getLongitude()) - this.southwest.getLongitude()) >= ((this.northeast.getLongitude() - this.southwest.getLongitude()) + latLngBounds.northeast.getLongitude()) - latLngBounds.southwest.getLongitude() || Math.abs(latitude) >= latitude2) {
            AppMethodBeat.o(101207);
            return false;
        }
        AppMethodBeat.o(101207);
        return true;
    }

    public LatLngBounds including(LatLng latLng) {
        AppMethodBeat.i(101208);
        double min = Math.min(this.southwest.getLatitude(), latLng.getLatitude());
        double max = Math.max(this.northeast.getLatitude(), latLng.getLatitude());
        double longitude = this.northeast.getLongitude();
        double longitude2 = this.southwest.getLongitude();
        double longitude3 = latLng.getLongitude();
        if (!containsLongitude(longitude3)) {
            if (longitudeDistanceHeadingWest(longitude2, longitude3) < longitudeDistanceHeadingEast(longitude, longitude3)) {
                longitude2 = longitude3;
            } else {
                longitude = longitude3;
            }
        }
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(min, longitude2), new LatLng(max, longitude));
        AppMethodBeat.o(101208);
        return latLngBounds;
    }

    private static double longitudeDistanceHeadingWest(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double longitudeDistanceHeadingEast(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean containsLatitude(double d) {
        AppMethodBeat.i(101209);
        if (this.southwest.getLatitude() > d || d > this.northeast.getLatitude()) {
            AppMethodBeat.o(101209);
            return false;
        }
        AppMethodBeat.o(101209);
        return true;
    }

    private boolean containsLongitude(double d) {
        AppMethodBeat.i(101210);
        if (this.southwest.getLongitude() <= this.northeast.getLongitude()) {
            if (this.southwest.getLongitude() > d || d > this.northeast.getLongitude()) {
                AppMethodBeat.o(101210);
                return false;
            }
            AppMethodBeat.o(101210);
            return true;
        } else if (this.southwest.getLongitude() <= d || d <= this.northeast.getLongitude()) {
            AppMethodBeat.o(101210);
            return true;
        } else {
            AppMethodBeat.o(101210);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(101211);
        int a = h.a(new Object[]{this.southwest, this.northeast});
        AppMethodBeat.o(101211);
        return a;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(101212);
        if (this == obj) {
            AppMethodBeat.o(101212);
            return true;
        } else if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
                AppMethodBeat.o(101212);
                return true;
            }
            AppMethodBeat.o(101212);
            return false;
        } else {
            AppMethodBeat.o(101212);
            return false;
        }
    }

    public String toString() {
        AppMethodBeat.i(101213);
        String a = h.a(h.a("southwest", this.southwest), h.a("northeast", this.northeast));
        AppMethodBeat.o(101213);
        return a;
    }
}
