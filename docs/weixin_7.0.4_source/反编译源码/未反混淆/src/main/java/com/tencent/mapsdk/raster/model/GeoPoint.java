package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GeoPoint implements Parcelable {
    public static final Creator<GeoPoint> CREATOR = new Creator<GeoPoint>() {
        public final GeoPoint createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101176);
            GeoPoint geoPoint = new GeoPoint(parcel, null);
            AppMethodBeat.o(101176);
            return geoPoint;
        }

        public final GeoPoint[] newArray(int i) {
            return new GeoPoint[i];
        }
    };
    private int e6Lat;
    private int e6Lon;

    public GeoPoint(int i, int i2) {
        this.e6Lat = 0;
        this.e6Lon = 0;
        this.e6Lat = i;
        this.e6Lon = i2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(101179);
        if (obj == null) {
            AppMethodBeat.o(101179);
            return false;
        } else if (obj.getClass() != getClass()) {
            AppMethodBeat.o(101179);
            return false;
        } else {
            GeoPoint geoPoint = (GeoPoint) obj;
            if (this.e6Lat == geoPoint.e6Lat && this.e6Lon == geoPoint.e6Lon) {
                AppMethodBeat.o(101179);
                return true;
            }
            AppMethodBeat.o(101179);
            return false;
        }
    }

    public int hashCode() {
        return (this.e6Lon * 7) + (this.e6Lat * 11);
    }

    public String toString() {
        AppMethodBeat.i(101180);
        String str = this.e6Lat + "," + this.e6Lon;
        AppMethodBeat.o(101180);
        return str;
    }

    public int getLongitudeE6() {
        return this.e6Lon;
    }

    public void setLongitudeE6(int i) {
        this.e6Lon = i;
    }

    public int getLatitudeE6() {
        return this.e6Lat;
    }

    public void setLatitudeE6(int i) {
        this.e6Lat = i;
    }

    public GeoPoint Copy() {
        AppMethodBeat.i(101181);
        GeoPoint geoPoint = new GeoPoint(this.e6Lat, this.e6Lon);
        AppMethodBeat.o(101181);
        return geoPoint;
    }

    private GeoPoint(Parcel parcel) {
        AppMethodBeat.i(101182);
        this.e6Lat = 0;
        this.e6Lon = 0;
        this.e6Lat = parcel.readInt();
        this.e6Lon = parcel.readInt();
        AppMethodBeat.o(101182);
    }

    static {
        AppMethodBeat.i(101185);
        AppMethodBeat.o(101185);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(101183);
        parcel.writeInt(this.e6Lat);
        parcel.writeInt(this.e6Lon);
        AppMethodBeat.o(101183);
    }

    public static LatLng g2l(GeoPoint geoPoint) {
        AppMethodBeat.i(101184);
        LatLng latLng = new LatLng((((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d, (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d);
        AppMethodBeat.o(101184);
        return latLng;
    }
}
