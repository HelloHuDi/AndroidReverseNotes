package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C16200h;

public final class CameraPosition implements Parcelable {
    public static final Creator<CameraPosition> CREATOR = new C88981();
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
            AppMethodBeat.m2504i(101164);
            target(cameraPosition.getTarget()).zoom(cameraPosition.getZoom());
            AppMethodBeat.m2505o(101164);
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
            AppMethodBeat.m2504i(101165);
            CameraPosition cameraPosition = new CameraPosition(this.target, this.zoom, this.skew, this.bearing);
            AppMethodBeat.m2505o(101165);
            return cameraPosition;
        }
    }

    /* renamed from: com.tencent.mapsdk.raster.model.CameraPosition$1 */
    static class C88981 implements Creator<CameraPosition> {
        C88981() {
        }

        public final CameraPosition createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(101161);
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            CameraPosition cameraPosition = new CameraPosition(new LatLng((double) readFloat, (double) readFloat2), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
            AppMethodBeat.m2505o(101161);
            return cameraPosition;
        }

        public final CameraPosition[] newArray(int i) {
            return new CameraPosition[i];
        }
    }

    static {
        AppMethodBeat.m2504i(101173);
        AppMethodBeat.m2505o(101173);
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
        AppMethodBeat.m2504i(101166);
        parcel.writeFloat((float) this.target.getLatitude());
        parcel.writeFloat((float) this.target.getLongitude());
        parcel.writeFloat(this.zoom);
        parcel.writeFloat(this.skew);
        parcel.writeFloat(this.bearing);
        AppMethodBeat.m2505o(101166);
    }

    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101167);
        int hashCode = super.hashCode();
        AppMethodBeat.m2505o(101167);
        return hashCode;
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        AppMethodBeat.m2504i(101168);
        CameraPosition cameraPosition = new CameraPosition(latLng, f);
        AppMethodBeat.m2505o(101168);
        return cameraPosition;
    }

    public static Builder builder() {
        AppMethodBeat.m2504i(101169);
        Builder builder = new Builder();
        AppMethodBeat.m2505o(101169);
        return builder;
    }

    public static Builder builder(CameraPosition cameraPosition) {
        AppMethodBeat.m2504i(101170);
        Builder builder = new Builder(cameraPosition);
        AppMethodBeat.m2505o(101170);
        return builder;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101171);
        if (this == obj) {
            AppMethodBeat.m2505o(101171);
            return true;
        } else if (obj instanceof CameraPosition) {
            CameraPosition cameraPosition = (CameraPosition) obj;
            if (getTarget().equals(cameraPosition.getTarget()) && Float.floatToIntBits(getZoom()) == Float.floatToIntBits(cameraPosition.getZoom())) {
                AppMethodBeat.m2505o(101171);
                return true;
            }
            AppMethodBeat.m2505o(101171);
            return false;
        } else {
            AppMethodBeat.m2505o(101171);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(101172);
        String a = C16200h.m24669a(C16200h.m24668a("target", getTarget()), C16200h.m24668a("zoom", Float.valueOf(getZoom())));
        AppMethodBeat.m2505o(101172);
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
