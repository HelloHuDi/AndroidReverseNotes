package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg */
public class SetFontWeightArg extends BaseDrawActionArg {
    public static final Creator<SetFontWeightArg> CREATOR = new C191421();
    public String hdi;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg$1 */
    static class C191421 implements Creator<SetFontWeightArg> {
        C191421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontWeightArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103485);
            SetFontWeightArg setFontWeightArg = new SetFontWeightArg(parcel);
            AppMethodBeat.m2505o(103485);
            return setFontWeightArg;
        }
    }

    public SetFontWeightArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103486);
        super.mo5879i(parcel);
        this.hdi = parcel.readString();
        AppMethodBeat.m2505o(103486);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103487);
        super.mo5880j(jSONObject);
        this.hdi = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103487);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103488);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdi);
        AppMethodBeat.m2505o(103488);
    }

    static {
        AppMethodBeat.m2504i(103491);
        AppMethodBeat.m2505o(103491);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103489);
        if (this == obj) {
            AppMethodBeat.m2505o(103489);
            return true;
        } else if (!(obj instanceof SetFontWeightArg)) {
            AppMethodBeat.m2505o(103489);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdi, ((SetFontWeightArg) obj).hdi);
            AppMethodBeat.m2505o(103489);
            return equals;
        } else {
            AppMethodBeat.m2505o(103489);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103490);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdi});
        AppMethodBeat.m2505o(103490);
        return hash;
    }
}
