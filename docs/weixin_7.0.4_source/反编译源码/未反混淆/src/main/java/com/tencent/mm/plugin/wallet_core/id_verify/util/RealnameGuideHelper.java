package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.a;

public class RealnameGuideHelper implements Parcelable {
    public static final Creator<RealnameGuideHelper> CREATOR = new Creator<RealnameGuideHelper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealnameGuideHelper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46658);
            RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper(parcel);
            AppMethodBeat.o(46658);
            return realnameGuideHelper;
        }
    };
    private int gwj;
    private String nYZ;
    private String nZa;
    private String nZb = "";
    private String nZc = "";
    private String nZd = "";
    private SetPwdInfo tvP;
    private boolean tvQ = false;

    protected RealnameGuideHelper(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(46659);
        this.tvP = (SetPwdInfo) parcel.readParcelable(SetPwdInfo.class.getClassLoader());
        this.nYZ = parcel.readString();
        this.nZa = parcel.readString();
        this.nZb = parcel.readString();
        this.nZc = parcel.readString();
        this.nZd = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.tvQ = z;
        this.gwj = parcel.readInt();
        AppMethodBeat.o(46659);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46660);
        parcel.writeParcelable(this.tvP, i);
        parcel.writeString(this.nYZ);
        parcel.writeString(this.nZa);
        parcel.writeString(this.nZb);
        parcel.writeString(this.nZc);
        parcel.writeString(this.nZd);
        parcel.writeByte((byte) (this.tvQ ? 1 : 0));
        parcel.writeInt(this.gwj);
        AppMethodBeat.o(46660);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(46665);
        AppMethodBeat.o(46665);
    }

    public final void a(String str, SetPwdInfo setPwdInfo, String str2, String str3, String str4, String str5, int i) {
        this.tvP = setPwdInfo;
        this.nYZ = str;
        this.nZa = str2;
        this.nZb = str3;
        this.nZc = str4;
        this.nZd = str5;
        this.gwj = i;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i) {
        AppMethodBeat.i(46661);
        a(str, null, str2, str3, str4, str5, i);
        AppMethodBeat.o(46661);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        boolean z = false;
        AppMethodBeat.i(46662);
        ab.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", this.tvP, Integer.valueOf(this.gwj), this.nZa, this.nZd, this.nZb, this.nZc, Boolean.valueOf(this.tvQ), this.nYZ);
        if (this.tvQ) {
            AppMethodBeat.o(46662);
        } else if (this.tvP == null || this.tvP.twa != 1) {
            AppMethodBeat.o(46662);
        } else {
            z = a.a((Activity) mMActivity, bundle, this.gwj, this.tvP.nZa, this.tvP.nZb, this.tvP.nZc, onClickListener);
            if (z && !this.tvQ) {
                this.tvQ = true;
            }
            AppMethodBeat.o(46662);
        }
        return z;
    }

    public final boolean b(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        AppMethodBeat.i(46663);
        boolean a = a(mMActivity, bundle, onClickListener, null, false);
        AppMethodBeat.o(46663);
        return a;
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener, a aVar, boolean z) {
        AppMethodBeat.i(46664);
        boolean a;
        if (this.tvQ) {
            AppMethodBeat.o(46664);
            return false;
        } else if ("1".equals(this.nYZ)) {
            if (!this.tvQ) {
                this.tvQ = true;
            }
            a = a.a(mMActivity, bundle, aVar, this.gwj);
            AppMethodBeat.o(46664);
            return a;
        } else if (!"2".equals(this.nYZ) || bo.isNullOrNil(this.nZd)) {
            AppMethodBeat.o(46664);
            return false;
        } else {
            if (!this.tvQ) {
                this.tvQ = true;
            }
            a = a.a((Activity) mMActivity, this.nZa, this.nZd, this.nZb, this.nZc, z, onClickListener);
            AppMethodBeat.o(46664);
            return a;
        }
    }
}
