package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C45414d;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.config.C38167m;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.p177mm.protocal.protobuf.C46539ey;
import java.util.ArrayList;

public class AppBrandSysConfigLU extends C16597h implements Parcelable, C10441j {
    public static final Creator<AppBrandSysConfigLU> CREATOR = new C09961();
    public int bQA;
    public boolean bQB;
    public boolean bQC;
    public long bQD;
    public int bQE;
    public ArrayList<String> bQF;
    public ArrayList<String> bQG;
    public ArrayList<String> bQH;
    public ArrayList<String> bQI;
    public ArrayList<String> bQJ;
    public boolean bQK;
    public int bQL;
    public int bQM;
    public long bQN;
    public AppBrandGlobalSystemConfig bQO;
    public boolean bQP;
    public String[] bQQ;
    public C46539ey bQR;
    public boolean bQf;
    public String bQo;
    public boolean bQp;
    public boolean bQq;
    public boolean bQr;
    public boolean bQs;
    public AppRuntimeApiPermissionBundle bQt;
    public String bQu;
    public int bQv;
    public int bQw;
    public int bQx;
    public int bQy;
    public int bQz;
    public String nickname;

    /* renamed from: com.tencent.luggage.sdk.config.AppBrandSysConfigLU$1 */
    static class C09961 implements Creator<AppBrandSysConfigLU> {
        C09961() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandSysConfigLU[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(101621);
            AppBrandSysConfigLU appBrandSysConfigLU = new AppBrandSysConfigLU(parcel);
            AppMethodBeat.m2505o(101621);
            return appBrandSysConfigLU;
        }
    }

    /* renamed from: xE */
    public final long mo3970xE() {
        return this.bQR == null ? 0 : this.bQR.vGQ;
    }

    public AppBrandSysConfigLU() {
        AppMethodBeat.m2504i(101622);
        this.bQp = false;
        this.bQq = false;
        this.bQr = false;
        this.bQs = false;
        this.bQf = false;
        this.bQN = 0;
        this.bQQ = new String[0];
        this.nickname = "";
        this.hhd = new WxaPkgWrappingInfo();
        AppMethodBeat.m2505o(101622);
    }

    public String toString() {
        AppMethodBeat.m2504i(101623);
        String str = "AppBrandSysConfigLU{, brandName='" + this.cwz + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.hgW + '\'' + ", debugEnabled=" + this.bQp + ", performancePanelEnabled=" + this.bQq + ", maxWebViewDepth=" + this.hgX + ", maxBackgroundLifeSpan=" + this.bQv + ", maxRequestConcurrent=" + this.bQw + ", maxUploadConcurrent=" + this.bQx + ", maxDownloadConcurrent=" + this.bQy + ", maxWebsocketConnect=" + this.bQz + ", websocketSkipPortCheck=" + this.bQB + ", requestDomains=" + this.bQF + ", socketDomains=" + this.bQG + ", uploadDomains=" + this.bQH + ", downloadDomains=" + this.bQI + ", downloadDomains=" + this.bQJ + ", appPkgInfo=" + this.hhd + ", systemSettings=" + this.bQO + ", runningFlag=" + C38167m.m64601a(this.bQR) + ", operationInfo=" + this.bQu + ", kvStorageScheme=" + this.hhe + ", TLSSkipHostnameCheck=" + this.bQC + ", kvStoragePerformanceReportOn=" + this.hhf + '}';
        AppMethodBeat.m2505o(101623);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(101624);
        parcel.writeString(this.cwz);
        parcel.writeString(this.bQo);
        parcel.writeString(this.appId);
        parcel.writeString(this.hgW);
        parcel.writeByte(this.bQp ? (byte) 1 : (byte) 0);
        if (this.bQq) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.bQr) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeParcelable(this.bQt, i);
        parcel.writeInt(this.hgX);
        parcel.writeInt(this.bQv);
        parcel.writeInt(this.bQw);
        parcel.writeInt(this.bQx);
        parcel.writeInt(this.bQy);
        parcel.writeInt(this.bQz);
        parcel.writeInt(this.bQA);
        if (this.bQB) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.bQC) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.bQD);
        parcel.writeInt(this.bQE);
        parcel.writeStringList(this.bQF);
        parcel.writeStringList(this.bQG);
        parcel.writeStringList(this.bQH);
        parcel.writeStringList(this.bQI);
        parcel.writeStringList(this.bQJ);
        parcel.writeParcelable(this.hhd, i);
        parcel.writeParcelable(this.bQO, i);
        parcel.writeByte(this.hgY ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.hhb);
        parcel.writeInt(this.hhc);
        parcel.writeInt(this.bQL);
        if (this.bQK) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.bQN);
        if (this.bQP) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.bQu);
        parcel.writeInt(this.bQQ.length);
        parcel.writeStringArray(this.bQQ);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.bQM);
        parcel.writeInt(this.hhe);
        if (this.hhf) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.hgZ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.hha) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        C45414d.m83635a(this.bQR, parcel);
        AppMethodBeat.m2505o(101624);
    }

    protected AppBrandSysConfigLU(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(101625);
        this.bQp = false;
        this.bQq = false;
        this.bQr = false;
        this.bQs = false;
        this.bQf = false;
        this.bQN = 0;
        this.bQQ = new String[0];
        this.nickname = "";
        this.cwz = parcel.readString();
        this.bQo = parcel.readString();
        this.appId = parcel.readString();
        this.hgW = parcel.readString();
        this.bQp = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.bQq = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.bQr = z;
        this.bQt = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
        this.hgX = parcel.readInt();
        this.bQv = parcel.readInt();
        this.bQw = parcel.readInt();
        this.bQx = parcel.readInt();
        this.bQy = parcel.readInt();
        this.bQz = parcel.readInt();
        this.bQA = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.bQB = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.bQC = z;
        this.bQD = parcel.readLong();
        this.bQE = parcel.readInt();
        this.bQF = parcel.createStringArrayList();
        this.bQG = parcel.createStringArrayList();
        this.bQH = parcel.createStringArrayList();
        this.bQI = parcel.createStringArrayList();
        this.bQJ = parcel.createStringArrayList();
        this.hhd = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.bQO = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        this.hgY = parcel.readByte() > (byte) 0;
        this.hhb = parcel.readInt();
        this.hhc = parcel.readInt();
        this.bQL = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bQK = z;
        this.bQN = parcel.readLong();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bQP = z;
        this.bQu = parcel.readString();
        this.bQQ = new String[parcel.readInt()];
        parcel.readStringArray(this.bQQ);
        this.nickname = parcel.readString();
        this.bQM = parcel.readInt();
        this.hhe = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hhf = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hgZ = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.hha = z2;
        this.bQR = (C46539ey) C45414d.m83636f(parcel);
        AppMethodBeat.m2505o(101625);
    }

    static {
        AppMethodBeat.m2504i(101626);
        AppMethodBeat.m2505o(101626);
    }
}
