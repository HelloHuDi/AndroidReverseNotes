package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class db implements Parcelable {
    public static final Creator<db> CREATOR = new Creator<db>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(100983);
            db a = a(parcel);
            AppMethodBeat.o(100983);
            return a;
        }

        public final /* synthetic */ Object[] newArray(int i) {
            AppMethodBeat.i(100982);
            db[] a = a(i);
            AppMethodBeat.o(100982);
            return a;
        }

        public final db[] a(int i) {
            return new db[i];
        }

        public final db a(Parcel parcel) {
            AppMethodBeat.i(100981);
            db dbVar = new db(parcel, null);
            AppMethodBeat.o(100981);
            return dbVar;
        }
    };
    public double a;
    public double b;

    public db(double d, double d2) {
        AppMethodBeat.i(100984);
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.b = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.b = d2;
        }
        this.a = Math.max(-90.0d, Math.min(90.0d, d));
        AppMethodBeat.o(100984);
    }

    private db(Parcel parcel) {
        AppMethodBeat.i(100985);
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
        AppMethodBeat.o(100985);
    }

    public int hashCode() {
        AppMethodBeat.i(100986);
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        AppMethodBeat.o(100986);
        return i;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(100987);
        if (this == obj) {
            AppMethodBeat.o(100987);
            return true;
        } else if (obj instanceof db) {
            db dbVar = (db) obj;
            if (Double.doubleToLongBits(this.a) == Double.doubleToLongBits(dbVar.a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(dbVar.b)) {
                AppMethodBeat.o(100987);
                return true;
            }
            AppMethodBeat.o(100987);
            return false;
        } else {
            AppMethodBeat.o(100987);
            return false;
        }
    }

    public String toString() {
        AppMethodBeat.i(100988);
        String str = "lat/lng: (" + this.a + "," + this.b + ")";
        AppMethodBeat.o(100988);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(100989);
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
        AppMethodBeat.o(100989);
    }

    static {
        AppMethodBeat.i(100990);
        AppMethodBeat.o(100990);
    }
}
