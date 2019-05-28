package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC */
public class AppBrandSysConfigWC extends AppBrandSysConfigLU {
    public static final Creator<AppBrandSysConfigWC> CREATOR = new C268311();
    public boolean hhg;
    public boolean hhh;
    public int hhi;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC$1 */
    static class C268311 implements Creator<AppBrandSysConfigWC> {
        C268311() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandSysConfigWC[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(129843);
            AppBrandSysConfigWC appBrandSysConfigWC = new AppBrandSysConfigWC(parcel);
            AppMethodBeat.m2505o(129843);
            return appBrandSysConfigWC;
        }
    }

    public AppBrandSysConfigWC(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        AppMethodBeat.m2504i(129844);
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
        AppMethodBeat.m2505o(129844);
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        AppMethodBeat.m2504i(129845);
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
        AppMethodBeat.m2505o(129845);
    }

    static {
        AppMethodBeat.m2504i(129846);
        AppMethodBeat.m2505o(129846);
    }
}
