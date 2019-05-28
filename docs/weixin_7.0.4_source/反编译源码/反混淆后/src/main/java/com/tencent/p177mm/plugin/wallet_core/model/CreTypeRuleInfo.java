package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo */
public class CreTypeRuleInfo implements Parcelable {
    public static final Creator<CreTypeRuleInfo> CREATOR = new C225741();
    public int txX;
    public CreExtInfo txY;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo$1 */
    static class C225741 implements Creator<CreTypeRuleInfo> {
        C225741() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CreTypeRuleInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46734);
            CreTypeRuleInfo creTypeRuleInfo = new CreTypeRuleInfo(parcel);
            AppMethodBeat.m2505o(46734);
            return creTypeRuleInfo;
        }
    }

    protected CreTypeRuleInfo(Parcel parcel) {
        AppMethodBeat.m2504i(46735);
        this.txX = parcel.readInt();
        this.txY = (CreExtInfo) parcel.readParcelable(CreExtInfo.class.getClassLoader());
        AppMethodBeat.m2505o(46735);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46736);
        parcel.writeInt(this.txX);
        parcel.writeParcelable(this.txY, i);
        AppMethodBeat.m2505o(46736);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(46738);
        AppMethodBeat.m2505o(46738);
    }

    /* renamed from: av */
    public static CreTypeRuleInfo m46994av(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46737);
        if (jSONObject != null) {
            CreTypeRuleInfo creTypeRuleInfo = new CreTypeRuleInfo();
            creTypeRuleInfo.txX = jSONObject.optInt("support_cre_type", 0);
            creTypeRuleInfo.txY = CreExtInfo.m22430au(jSONObject.optJSONObject("cre_need_info"));
            AppMethodBeat.m2505o(46737);
            return creTypeRuleInfo;
        }
        AppMethodBeat.m2505o(46737);
        return null;
    }
}
