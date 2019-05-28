package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallRechargeProduct implements Parcelable {
    public static final Creator<MallRechargeProduct> CREATOR = new Creator<MallRechargeProduct>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallRechargeProduct[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44189);
            MallRechargeProduct mallRechargeProduct = new MallRechargeProduct(parcel);
            AppMethodBeat.o(44189);
            return mallRechargeProduct;
        }
    };
    public String appId;
    public String cwg;
    public int fmR;
    public boolean isDefault;
    public String lcC;
    public String pFP;
    public String pFQ;
    public float pFR = 0.0f;
    public float pFS = 0.0f;
    public boolean pFT;
    public int pFU;
    public int pFV;
    public final boolean pFW;
    public boolean pFX = true;

    public MallRechargeProduct(boolean z) {
        this.pFW = z;
    }

    public final boolean isValid() {
        if (!this.pFT || this.pFU > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.pFP = mallRechargeProduct.pFP;
        mallRechargeProduct2.cwg = mallRechargeProduct.cwg;
        mallRechargeProduct2.lcC = mallRechargeProduct.lcC;
        mallRechargeProduct2.pFQ = mallRechargeProduct.pFQ;
        mallRechargeProduct2.pFR = mallRechargeProduct.pFR;
        mallRechargeProduct2.pFS = mallRechargeProduct.pFS;
        mallRechargeProduct2.pFT = mallRechargeProduct.pFT;
        mallRechargeProduct2.pFU = mallRechargeProduct.pFU;
        mallRechargeProduct2.pFV = mallRechargeProduct.pFV;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.pFX = mallRechargeProduct.pFX;
        mallRechargeProduct2.fmR = mallRechargeProduct.fmR;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(44190);
        this.pFP = parcel.readString();
        this.appId = parcel.readString();
        this.cwg = parcel.readString();
        this.lcC = parcel.readString();
        this.pFQ = parcel.readString();
        this.pFR = parcel.readFloat();
        this.pFS = parcel.readFloat();
        this.pFT = parcel.readInt() == 1;
        this.pFU = parcel.readInt();
        this.pFV = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.pFW = z2;
        this.fmR = parcel.readInt();
        AppMethodBeat.o(44190);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(44191);
        parcel.writeString(this.pFP);
        parcel.writeString(this.appId);
        parcel.writeString(this.cwg);
        parcel.writeString(this.lcC);
        parcel.writeString(this.pFQ);
        parcel.writeFloat(this.pFR);
        parcel.writeFloat(this.pFS);
        parcel.writeInt(this.pFT ? 1 : 0);
        parcel.writeInt(this.pFU);
        parcel.writeInt(this.pFV);
        if (this.isDefault) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pFW) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.fmR);
        AppMethodBeat.o(44191);
    }

    static {
        AppMethodBeat.i(44192);
        AppMethodBeat.o(44192);
    }
}
