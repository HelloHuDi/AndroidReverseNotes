package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg */
public class SetTextBaseLineActionArg extends BaseDrawActionArg {
    public static final Creator<SetTextBaseLineActionArg> CREATOR = new C423921();
    public String hdq;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg$1 */
    static class C423921 implements Creator<SetTextBaseLineActionArg> {
        C423921() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetTextBaseLineActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103564);
            SetTextBaseLineActionArg setTextBaseLineActionArg = new SetTextBaseLineActionArg(parcel);
            AppMethodBeat.m2505o(103564);
            return setTextBaseLineActionArg;
        }
    }

    public SetTextBaseLineActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103565);
        super.mo5879i(parcel);
        this.hdq = parcel.readString();
        AppMethodBeat.m2505o(103565);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103566);
        super.mo5880j(jSONObject);
        this.hdq = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103566);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103567);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdq);
        AppMethodBeat.m2505o(103567);
    }

    static {
        AppMethodBeat.m2504i(103570);
        AppMethodBeat.m2505o(103570);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103568);
        if (this == obj) {
            AppMethodBeat.m2505o(103568);
            return true;
        } else if (!(obj instanceof SetTextBaseLineActionArg)) {
            AppMethodBeat.m2505o(103568);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdq, ((SetTextBaseLineActionArg) obj).hdq);
            AppMethodBeat.m2505o(103568);
            return equals;
        } else {
            AppMethodBeat.m2505o(103568);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103569);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdq});
        AppMethodBeat.m2505o(103569);
        return hash;
    }
}
