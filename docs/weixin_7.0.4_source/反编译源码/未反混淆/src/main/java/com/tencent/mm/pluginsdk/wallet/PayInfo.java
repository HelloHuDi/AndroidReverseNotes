package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayInfo implements Parcelable {
    public static final Creator<PayInfo> CREATOR = new Creator<PayInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70464);
            PayInfo payInfo = new PayInfo(parcel);
            AppMethodBeat.o(70464);
            return payInfo;
        }
    };
    public String aIm;
    public boolean aPn;
    public String appId;
    public int cBS;
    public String cBU;
    public String cBV;
    public String cHI = "";
    public int cIb;
    public int cIf = 0;
    public int cIg = -1;
    public String cQF;
    public String cwg;
    public String czZ;
    public String eCq;
    public String hHV;
    public String kck;
    public boolean mXg = false;
    public int pPV = 0;
    public String pPw;
    public String partnerId;
    public int tKd = 0;
    public int tKe = 0;
    public String tRb;
    public int vwe = 0;
    public boolean vwf = true;
    public String vwg;
    public Bundle vwh;
    public int vwi;
    public long vwj = 0;
    public int vwk = -1;
    public String vwl;
    public String vwm;
    public int vwn = 1;
    public double vwo = 0.0d;
    public String vwp = "";

    public PayInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(70465);
        this.cIf = parcel.readInt();
        this.vwe = parcel.readInt();
        this.czZ = parcel.readString();
        this.eCq = parcel.readString();
        this.appId = parcel.readString();
        this.tRb = parcel.readString();
        this.partnerId = parcel.readString();
        this.cQF = parcel.readString();
        this.cwg = parcel.readString();
        this.aIm = parcel.readString();
        this.cIb = parcel.readInt();
        this.cIg = parcel.readInt();
        this.mXg = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.vwf = z;
        this.vwh = parcel.readBundle();
        this.tKd = parcel.readInt();
        this.cBU = parcel.readString();
        this.cBV = parcel.readString();
        this.cBS = parcel.readInt();
        this.vwj = parcel.readLong();
        this.cHI = parcel.readString();
        this.vwl = parcel.readString();
        this.vwm = parcel.readString();
        this.vwn = parcel.readInt();
        this.kck = parcel.readString();
        this.hHV = parcel.readString();
        this.pPV = parcel.readInt();
        this.vwo = parcel.readDouble();
        this.vwp = parcel.readString();
        if (this.vwp == null) {
            this.vwp = "";
        }
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.aPn = z2;
        this.pPw = parcel.readString();
        AppMethodBeat.o(70465);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(70466);
        parcel.writeInt(this.cIf);
        parcel.writeInt(this.vwe);
        parcel.writeString(this.czZ);
        parcel.writeString(this.eCq);
        parcel.writeString(this.appId);
        parcel.writeString(this.tRb);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.cQF);
        parcel.writeString(this.cwg);
        parcel.writeString(this.aIm);
        parcel.writeInt(this.cIb);
        parcel.writeInt(this.cIg);
        parcel.writeInt(this.mXg ? 1 : 0);
        if (this.vwf) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.vwh);
        parcel.writeInt(this.tKd);
        parcel.writeString(this.cBU);
        parcel.writeString(this.cBV);
        parcel.writeInt(this.cBS);
        parcel.writeLong(this.vwj);
        parcel.writeString(this.cHI);
        parcel.writeString(this.vwl);
        parcel.writeString(this.vwm);
        parcel.writeInt(this.vwn);
        parcel.writeString(this.kck);
        parcel.writeString(this.hHV);
        parcel.writeInt(this.pPV);
        parcel.writeDouble(this.vwo);
        parcel.writeString(this.vwp);
        if (!this.aPn) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.pPw);
        AppMethodBeat.o(70466);
    }

    static {
        AppMethodBeat.i(70468);
        AppMethodBeat.o(70468);
    }

    public String toString() {
        AppMethodBeat.i(70467);
        String format = String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[]{Integer.valueOf(this.cIf), this.czZ, this.eCq, this.appId, this.tRb, this.partnerId, this.cQF, this.cwg, this.cHI});
        AppMethodBeat.o(70467);
        return format;
    }
}
