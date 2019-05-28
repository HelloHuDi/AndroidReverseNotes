package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.h;

public final class CameraPosition implements Parcelable {
    public static final Creator<CameraPosition> CREATOR = new Creator<CameraPosition>() {
        public final CameraPosition createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101161);
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            CameraPosition cameraPosition = new CameraPosition(new LatLng((double) readFloat, (double) readFloat2), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
            AppMethodBeat.o(101161);
            return cameraPosition;
        }

        public final CameraPosition[] newArray(int i) {
            return new CameraPosition[i];
        }
    };
    private static final int EMPTY_ZOOMLEVEL = -1;
    private float bearing;
    private float skew;
    private final LatLng target;
    private float zoom;

    public static final class Builder {
        private float bearing = 0.0f;
        private float skew = 0.0f;
        private LatLng target;
        private float zoom = -1.0f;

        public Builder(CameraPosition cameraPosition) {
            AppMethodBeat.i(101164);
            target(cameraPosition.getTarget()).zoom(cameraPosition.getZoom());
            AppMethodBeat.o(101164);
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder zoom(float f) {
            this.zoom = f;
            return this;
        }

        public final Builder skew(float f) {
            this.skew = f;
            return this;
        }

        public final Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public final CameraPosition build() {
            AppMethodBeat.i(101165);
            CameraPosition cameraPosition = new CameraPosition(this.target, this.zoom, this.skew, this.bearing);
            AppMethodBeat.o(101165);
            return cameraPosition;
        }
    }

    static {
        AppMethodBeat.i(101173);
        AppMethodBeat.o(101173);
    }

    public CameraPosition(LatLng latLng, float f) {
        this(latLng, f, 0.0f, 0.0f);
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this.zoom = -1.0f;
        this.skew = 0.0f;
        this.bearing = 0.0f;
        this.target = latLng;
        this.zoom = f;
        this.skew = f2;
        this.bearing = f3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(101166);
        parcel.writeFloat((float) this.target.getLatitude());
        parcel.writeFloat((float) this.target.getLongitude());
        parcel.writeFloat(this.zoom);
        parcel.writeFloat(this.skew);
        parcel.writeFloat(this.bearing);
        AppMethodBeat.o(101166);
    }

    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        AppMethodBeat.i(101167);
        int hashCode = super.hashCode();
        AppMethodBeat.o(101167);
        return hashCode;
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        AppMethodBeat.i(101168);
        CameraPosition cameraPosition = new CameraPosition(latLng, f);
        AppMethodBeat.o(101168);
        return cameraPosition;
    }

    public static Builder builder() {
        AppMethodBeat.i(101169);
        Builder builder = new Builder();
        AppMethodBeat.o(101169);
        return builder;
    }

    public static Builder builder(CameraPosition cameraPosition) {
        AppMethodBeat.i(101170);
        Builder builder = new Builder(cameraPosition);
        AppMethodBeat.o(101170);
        return builder;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101171);
        if (this == obj) {
            AppMethodBeat.o(101171);
            return true;
        } else if (obj instanceof CameraPosition) {
            CameraPosition cameraPosition = (CameraPosition) obj;
            if (getTarget().equals(cameraPosition.getTarget()) && Float.floatToIntBits(getZoom()) == Float.floatToIntBits(cameraPosition.getZoom())) {
                AppMethodBeat.o(101171);
                return true;
            }
            AppMethodBeat.o(101171);
            return false;
        } else {
            AppMethodBeat.o(101171);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(101172);
        String a = h.a(h.a("target", getTarget()), h.a("zoom", Float.valueOf(getZoom())));
        AppMethodBeat.o(101172);
        return a;
    }

    public final LatLng getTarget() {
        return this.target;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final float getSkew() {
        return this.skew;
    }

    public final float getBearing() {
        return this.bearing;
    }
}
