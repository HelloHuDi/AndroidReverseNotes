package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandSysConfigWC extends AppBrandSysConfigLU {
    public static final Creator<AppBrandSysConfigWC> CREATOR = new Creator<AppBrandSysConfigWC>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandSysConfigWC[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(129843);
            AppBrandSysConfigWC appBrandSysConfigWC = new AppBrandSysConfigWC(parcel);
            AppMethodBeat.o(129843);
            return appBrandSysConfigWC;
        }
    };
    public boolean hhg;
    public boolean hhh;
    public int hhi;

    public AppBrandSysConfigWC(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        AppMethodBeat.i(129844);
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.hhg = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.hhh = z2;
        this.hhi = parcel.readInt();
        AppMethodBeat.o(129844);
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        AppMethodBeat.i(129845);
        super.writeToParcel(parcel, i);
        if (this.hhg) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.hhh) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.hhi);
        AppMethodBeat.o(129845);
    }

    static {
        AppMethodBeat.i(129846);
        AppMethodBeat.o(129846);
    }
}
