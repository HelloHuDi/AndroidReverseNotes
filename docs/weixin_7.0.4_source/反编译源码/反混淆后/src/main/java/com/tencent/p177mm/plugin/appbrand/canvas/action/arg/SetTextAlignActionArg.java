package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg */
public class SetTextAlignActionArg extends BaseDrawActionArg {
    public static final Creator<SetTextAlignActionArg> CREATOR = new C331191();
    public String hdq;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg$1 */
    static class C331191 implements Creator<SetTextAlignActionArg> {
        C331191() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetTextAlignActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103557);
            SetTextAlignActionArg setTextAlignActionArg = new SetTextAlignActionArg(parcel);
            AppMethodBeat.m2505o(103557);
            return setTextAlignActionArg;
        }
    }

    public SetTextAlignActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103558);
        super.mo5879i(parcel);
        this.hdq = parcel.readString();
        AppMethodBeat.m2505o(103558);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103559);
        super.mo5880j(jSONObject);
        this.hdq = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103559);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103560);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdq);
        AppMethodBeat.m2505o(103560);
    }

    static {
        AppMethodBeat.m2504i(103563);
        AppMethodBeat.m2505o(103563);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103561);
        if (this == obj) {
            AppMethodBeat.m2505o(103561);
            return true;
        } else if (!(obj instanceof SetTextAlignActionArg)) {
            AppMethodBeat.m2505o(103561);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdq, ((SetTextAlignActionArg) obj).hdq);
            AppMethodBeat.m2505o(103561);
            return equals;
        } else {
            AppMethodBeat.m2505o(103561);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103562);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdq});
        AppMethodBeat.m2505o(103562);
        return hash;
    }
}
