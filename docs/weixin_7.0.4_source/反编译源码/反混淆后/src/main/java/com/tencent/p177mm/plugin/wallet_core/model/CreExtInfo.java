package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.CreExtInfo */
public class CreExtInfo implements Parcelable {
    public static final Creator<CreExtInfo> CREATOR = new C142321();
    public int txT;
    public int txU;
    public int txV;
    public int txW;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.CreExtInfo$1 */
    static class C142321 implements Creator<CreExtInfo> {
        C142321() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CreExtInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46729);
            CreExtInfo creExtInfo = new CreExtInfo(parcel);
            AppMethodBeat.m2505o(46729);
            return creExtInfo;
        }
    }

    protected CreExtInfo(Parcel parcel) {
        AppMethodBeat.m2504i(46730);
        this.txT = parcel.readInt();
        this.txU = parcel.readInt();
        this.txV = parcel.readInt();
        this.txW = parcel.readInt();
        AppMethodBeat.m2505o(46730);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46731);
        parcel.writeInt(this.txT);
        parcel.writeInt(this.txU);
        parcel.writeInt(this.txV);
        parcel.writeInt(this.txW);
        AppMethodBeat.m2505o(46731);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(46733);
        AppMethodBeat.m2505o(46733);
    }

    /* renamed from: au */
    public static CreExtInfo m22430au(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46732);
        if (jSONObject != null) {
            CreExtInfo creExtInfo = new CreExtInfo();
            creExtInfo.txT = jSONObject.optInt("need_creid_renewal", 0);
            creExtInfo.txU = jSONObject.optInt("need_birth_date", 0);
            creExtInfo.txV = jSONObject.optInt("need_cre_expire_date", 0);
            creExtInfo.txW = jSONObject.optInt("need_show_cre_type", 0);
            AppMethodBeat.m2505o(46732);
            return creExtInfo;
        }
        AppMethodBeat.m2505o(46732);
        return null;
    }
}
