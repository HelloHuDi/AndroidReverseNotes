package com.tencent.p177mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper */
public class RealnameGuideHelper implements Parcelable {
    public static final Creator<RealnameGuideHelper> CREATOR = new C142271();
    private int gwj;
    private String nYZ;
    private String nZa;
    private String nZb = "";
    private String nZc = "";
    private String nZd = "";
    private SetPwdInfo tvP;
    private boolean tvQ = false;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper$1 */
    static class C142271 implements Creator<RealnameGuideHelper> {
        C142271() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealnameGuideHelper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46658);
            RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper(parcel);
            AppMethodBeat.m2505o(46658);
            return realnameGuideHelper;
        }
    }

    protected RealnameGuideHelper(Parcel parcel) {
        boolean z;
        AppMethodBeat.m2504i(46659);
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
        AppMethodBeat.m2505o(46659);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46660);
        parcel.writeParcelable(this.tvP, i);
        parcel.writeString(this.nYZ);
        parcel.writeString(this.nZa);
        parcel.writeString(this.nZb);
        parcel.writeString(this.nZc);
        parcel.writeString(this.nZd);
        parcel.writeByte((byte) (this.tvQ ? 1 : 0));
        parcel.writeInt(this.gwj);
        AppMethodBeat.m2505o(46660);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(46665);
        AppMethodBeat.m2505o(46665);
    }

    /* renamed from: a */
    public final void mo74570a(String str, SetPwdInfo setPwdInfo, String str2, String str3, String str4, String str5, int i) {
        this.tvP = setPwdInfo;
        this.nYZ = str;
        this.nZa = str2;
        this.nZb = str3;
        this.nZc = str4;
        this.nZd = str5;
        this.gwj = i;
    }

    /* renamed from: a */
    public final void mo74571a(String str, String str2, String str3, String str4, String str5, int i) {
        AppMethodBeat.m2504i(46661);
        mo74570a(str, null, str2, str3, str4, str5, i);
        AppMethodBeat.m2505o(46661);
    }

    /* renamed from: a */
    public final boolean mo74572a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        boolean z = false;
        AppMethodBeat.m2504i(46662);
        C4990ab.m7411d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", this.tvP, Integer.valueOf(this.gwj), this.nZa, this.nZd, this.nZb, this.nZc, Boolean.valueOf(this.tvQ), this.nYZ);
        if (this.tvQ) {
            AppMethodBeat.m2505o(46662);
        } else if (this.tvP == null || this.tvP.twa != 1) {
            AppMethodBeat.m2505o(46662);
        } else {
            z = C43795a.m78492a((Activity) mMActivity, bundle, this.gwj, this.tvP.nZa, this.tvP.nZb, this.tvP.nZc, onClickListener);
            if (z && !this.tvQ) {
                this.tvQ = true;
            }
            AppMethodBeat.m2505o(46662);
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo74574b(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(46663);
        boolean a = mo74573a(mMActivity, bundle, onClickListener, null, false);
        AppMethodBeat.m2505o(46663);
        return a;
    }

    /* renamed from: a */
    public final boolean mo74573a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener, C30857a c30857a, boolean z) {
        AppMethodBeat.m2504i(46664);
        boolean a;
        if (this.tvQ) {
            AppMethodBeat.m2505o(46664);
            return false;
        } else if ("1".equals(this.nYZ)) {
            if (!this.tvQ) {
                this.tvQ = true;
            }
            a = C43795a.m78493a(mMActivity, bundle, c30857a, this.gwj);
            AppMethodBeat.m2505o(46664);
            return a;
        } else if (!"2".equals(this.nYZ) || C5046bo.isNullOrNil(this.nZd)) {
            AppMethodBeat.m2505o(46664);
            return false;
        } else {
            if (!this.tvQ) {
                this.tvQ = true;
            }
            a = C43795a.m78495a((Activity) mMActivity, this.nZa, this.nZd, this.nZb, this.nZc, z, onClickListener);
            AppMethodBeat.m2505o(46664);
            return a;
        }
    }
}
