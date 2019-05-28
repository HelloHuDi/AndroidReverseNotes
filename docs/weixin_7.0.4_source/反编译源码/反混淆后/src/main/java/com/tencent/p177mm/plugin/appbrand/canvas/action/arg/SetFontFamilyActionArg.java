package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg */
public class SetFontFamilyActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontFamilyActionArg> CREATOR = new C165881();
    public String bnS;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg$1 */
    static class C165881 implements Creator<SetFontFamilyActionArg> {
        C165881() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontFamilyActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103464);
            SetFontFamilyActionArg setFontFamilyActionArg = new SetFontFamilyActionArg(parcel);
            AppMethodBeat.m2505o(103464);
            return setFontFamilyActionArg;
        }
    }

    public SetFontFamilyActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103465);
        super.mo5879i(parcel);
        this.bnS = parcel.readString();
        AppMethodBeat.m2505o(103465);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103466);
        super.mo5880j(jSONObject);
        this.bnS = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103466);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103467);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.bnS);
        AppMethodBeat.m2505o(103467);
    }

    static {
        AppMethodBeat.m2504i(103470);
        AppMethodBeat.m2505o(103470);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103468);
        if (this == obj) {
            AppMethodBeat.m2505o(103468);
            return true;
        } else if (!(obj instanceof SetFontFamilyActionArg)) {
            AppMethodBeat.m2505o(103468);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.bnS, ((SetFontFamilyActionArg) obj).bnS);
            AppMethodBeat.m2505o(103468);
            return equals;
        } else {
            AppMethodBeat.m2505o(103468);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103469);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.bnS});
        AppMethodBeat.m2505o(103469);
        return hash;
    }
}
