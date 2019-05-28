package com.tencent.map.lib.basemap.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GeoPoint implements Parcelable {
    public static final Creator<GeoPoint> CREATOR = new Creator<GeoPoint>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97844);
            GeoPoint a = a(parcel);
            AppMethodBeat.o(97844);
            return a;
        }

        public final /* synthetic */ Object[] newArray(int i) {
            AppMethodBeat.i(97843);
            GeoPoint[] a = a(i);
            AppMethodBeat.o(97843);
            return a;
        }

        public final GeoPoint a(Parcel parcel) {
            AppMethodBeat.i(97842);
            GeoPoint geoPoint = new GeoPoint(parcel, null);
            AppMethodBeat.o(97842);
            return geoPoint;
        }

        public final GeoPoint[] a(int i) {
            return new GeoPoint[i];
        }
    };
    private int mLatitudeE6;
    private int mLongitudeE6;

    public GeoPoint() {
        this.mLatitudeE6 = -85000001;
        this.mLongitudeE6 = -180000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.mLatitudeE6 = geoPoint.mLatitudeE6;
        this.mLongitudeE6 = geoPoint.mLongitudeE6;
    }

    public GeoPoint(int i, int i2) {
        this.mLatitudeE6 = i;
        this.mLongitudeE6 = i2;
    }

    public int getLatitudeE6() {
        return this.mLatitudeE6;
    }

    public int getLongitudeE6() {
        return this.mLongitudeE6;
    }

    public void setLatitudeE6(int i) {
        this.mLatitudeE6 = i;
    }

    public void setLongitudeE6(int i) {
        this.mLongitudeE6 = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        AppMethodBeat.i(97845);
        this.mLatitudeE6 = geoPoint.getLatitudeE6();
        this.mLongitudeE6 = geoPoint.getLongitudeE6();
        AppMethodBeat.o(97845);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.mLatitudeE6 == geoPoint.mLatitudeE6 && this.mLongitudeE6 == geoPoint.mLongitudeE6) {
            return true;
        }
        return false;
    }

    public String toString() {
        AppMethodBeat.i(97846);
        String str = this.mLatitudeE6 + "," + this.mLongitudeE6;
        AppMethodBeat.o(97846);
        return str;
    }

    public static GeoPoint formString(String str) {
        AppMethodBeat.i(97847);
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length == 2) {
                    geoPoint.mLatitudeE6 = Integer.parseInt(split[0]);
                    geoPoint.mLongitudeE6 = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(97847);
        return geoPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97848);
        parcel.writeInt(this.mLatitudeE6);
        parcel.writeInt(this.mLongitudeE6);
        AppMethodBeat.o(97848);
    }

    static {
        AppMethodBeat.i(97850);
        AppMethodBeat.o(97850);
    }

    private GeoPoint(Parcel parcel) {
        AppMethodBeat.i(97849);
        this.mLatitudeE6 = parcel.readInt();
        this.mLongitudeE6 = parcel.readInt();
        AppMethodBeat.o(97849);
    }
}
