package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;

/* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC */
public class AppBrandInitConfigWC extends AppBrandInitConfigLU implements Parcelable {
    public static final Creator<AppBrandInitConfigWC> CREATOR = new C21101();
    public transient boolean hgI;
    public boolean hgJ;
    public long hgK;
    public String hgL;
    public String hgM;
    public volatile QualitySession hgN;
    public boolean hgO = false;
    public transient int hgP;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC$1 */
    static class C21101 implements Creator<AppBrandInitConfigWC> {
        C21101() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfigWC[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(129833);
            AppBrandInitConfigWC appBrandInitConfigWC = new AppBrandInitConfigWC(parcel);
            AppMethodBeat.m2505o(129833);
            return appBrandInitConfigWC;
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(129840);
        AppBrandInitConfigWC ayE = ayE();
        AppMethodBeat.m2505o(129840);
        return ayE;
    }

    /* renamed from: xC */
    public final /* synthetic */ AppBrandInitConfigLU mo32989xC() {
        AppMethodBeat.m2504i(129839);
        AppBrandInitConfigWC ayE = ayE();
        AppMethodBeat.m2505o(129839);
        return ayE;
    }

    /* renamed from: xy */
    public final boolean mo32992xy() {
        return this.bQe == 4;
    }

    AppBrandInitConfigWC() {
    }

    public String toString() {
        AppMethodBeat.m2504i(129834);
        String str = "AppBrandInitConfigWC {visitingSessionId='" + this.bQd + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.cwz + '\'' + ", debugType=" + this.gVs + ", isPluginApp=" + this.hgJ + ", preferRunInTools=" + this.hgI + ", orientation='" + this.hfh + '\'' + ", enterPath='" + this.hgC + '\'' + ", shareName='" + this.bQh + '\'' + ", shareKey='" + this.bQi + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.hgO + ", referrer=" + this.hgF + ", extInfo=" + this.extInfo + ", appVersion=" + this.axy + ", loadingImgUrl=" + this.hgL + ", loadingImgrProgressbarColor" + this.hgM + '}';
        AppMethodBeat.m2505o(129834);
        return str;
    }

    private AppBrandInitConfigWC ayE() {
        AppMethodBeat.m2504i(129835);
        Parcel xD = mo32990xD();
        AppBrandInitConfigWC appBrandInitConfigWC = new AppBrandInitConfigWC(xD);
        xD.recycle();
        AppMethodBeat.m2505o(129835);
        return appBrandInitConfigWC;
    }

    /* renamed from: xD */
    public final Parcel mo32990xD() {
        AppMethodBeat.m2504i(129836);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AppMethodBeat.m2505o(129836);
        return obtain;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(129837);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.hgJ ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.hgK);
        parcel.writeParcelable(this.hgN, i);
        if (!this.hgO) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.hgL);
        parcel.writeString(this.hgM);
        AppMethodBeat.m2505o(129837);
    }

    protected AppBrandInitConfigWC(Parcel parcel) {
        boolean z = true;
        super(parcel);
        AppMethodBeat.m2504i(129838);
        this.hgJ = parcel.readByte() != (byte) 0;
        this.hgK = parcel.readLong();
        this.hgN = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.hgO = z;
        this.hgL = parcel.readString();
        this.hgM = parcel.readString();
        AppMethodBeat.m2505o(129838);
    }

    static {
        AppMethodBeat.m2504i(129841);
        AppMethodBeat.m2505o(129841);
    }
}
