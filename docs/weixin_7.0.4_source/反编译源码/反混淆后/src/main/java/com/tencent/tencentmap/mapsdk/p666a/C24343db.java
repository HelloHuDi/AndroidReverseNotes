package com.tencent.tencentmap.mapsdk.p666a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.db */
public class C24343db implements Parcelable {
    public static final Creator<C24343db> CREATOR = new C243441();
    /* renamed from: a */
    public double f4615a;
    /* renamed from: b */
    public double f4616b;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.db$1 */
    static class C243441 implements Creator<C24343db> {
        C243441() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(100983);
            C24343db a = mo40480a(parcel);
            AppMethodBeat.m2505o(100983);
            return a;
        }

        public final /* synthetic */ Object[] newArray(int i) {
            AppMethodBeat.m2504i(100982);
            C24343db[] a = mo40481a(i);
            AppMethodBeat.m2505o(100982);
            return a;
        }

        /* renamed from: a */
        public final C24343db[] mo40481a(int i) {
            return new C24343db[i];
        }

        /* renamed from: a */
        public final C24343db mo40480a(Parcel parcel) {
            AppMethodBeat.m2504i(100981);
            C24343db c24343db = new C24343db(parcel, null);
            AppMethodBeat.m2505o(100981);
            return c24343db;
        }
    }

    public C24343db(double d, double d2) {
        AppMethodBeat.m2504i(100984);
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.f4616b = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f4616b = d2;
        }
        this.f4615a = Math.max(-90.0d, Math.min(90.0d, d));
        AppMethodBeat.m2505o(100984);
    }

    private C24343db(Parcel parcel) {
        AppMethodBeat.m2504i(100985);
        this.f4615a = parcel.readDouble();
        this.f4616b = parcel.readDouble();
        AppMethodBeat.m2505o(100985);
    }

    public int hashCode() {
        AppMethodBeat.m2504i(100986);
        long doubleToLongBits = Double.doubleToLongBits(this.f4615a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f4616b);
        i = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        AppMethodBeat.m2505o(100986);
        return i;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(100987);
        if (this == obj) {
            AppMethodBeat.m2505o(100987);
            return true;
        } else if (obj instanceof C24343db) {
            C24343db c24343db = (C24343db) obj;
            if (Double.doubleToLongBits(this.f4615a) == Double.doubleToLongBits(c24343db.f4615a) && Double.doubleToLongBits(this.f4616b) == Double.doubleToLongBits(c24343db.f4616b)) {
                AppMethodBeat.m2505o(100987);
                return true;
            }
            AppMethodBeat.m2505o(100987);
            return false;
        } else {
            AppMethodBeat.m2505o(100987);
            return false;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(100988);
        String str = "lat/lng: (" + this.f4615a + "," + this.f4616b + ")";
        AppMethodBeat.m2505o(100988);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(100989);
        parcel.writeDouble(this.f4615a);
        parcel.writeDouble(this.f4616b);
        AppMethodBeat.m2505o(100989);
    }

    static {
        AppMethodBeat.m2504i(100990);
        AppMethodBeat.m2505o(100990);
    }
}
