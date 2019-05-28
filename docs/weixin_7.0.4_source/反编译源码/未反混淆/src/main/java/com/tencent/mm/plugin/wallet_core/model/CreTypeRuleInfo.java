package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreTypeRuleInfo implements Parcelable {
    public static final Creator<CreTypeRuleInfo> CREATOR = new Creator<CreTypeRuleInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CreTypeRuleInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46734);
            CreTypeRuleInfo creTypeRuleInfo = new CreTypeRuleInfo(parcel);
            AppMethodBeat.o(46734);
            return creTypeRuleInfo;
        }
    };
    public int txX;
    public CreExtInfo txY;

    protected CreTypeRuleInfo(Parcel parcel) {
        AppMethodBeat.i(46735);
        this.txX = parcel.readInt();
        this.txY = (CreExtInfo) parcel.readParcelable(CreExtInfo.class.getClassLoader());
        AppMethodBeat.o(46735);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46736);
        parcel.writeInt(this.txX);
        parcel.writeParcelable(this.txY, i);
        AppMethodBeat.o(46736);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(46738);
        AppMethodBeat.o(46738);
    }

    public static CreTypeRuleInfo av(JSONObject jSONObject) {
        AppMethodBeat.i(46737);
        if (jSONObject != null) {
            CreTypeRuleInfo creTypeRuleInfo = new CreTypeRuleInfo();
            creTypeRuleInfo.txX = jSONObject.optInt("support_cre_type", 0);
            creTypeRuleInfo.txY = CreExtInfo.au(jSONObject.optJSONObject("cre_need_info"));
            AppMethodBeat.o(46737);
            return creTypeRuleInfo;
        }
        AppMethodBeat.o(46737);
        return null;
    }
}
