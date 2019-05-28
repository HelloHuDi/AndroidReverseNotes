package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg */
public class SetLineJoinActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineJoinActionArg> CREATOR = new C268111();
    public String hdm;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg$1 */
    static class C268111 implements Creator<SetLineJoinActionArg> {
        C268111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineJoinActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103520);
            SetLineJoinActionArg setLineJoinActionArg = new SetLineJoinActionArg(parcel);
            AppMethodBeat.m2505o(103520);
            return setLineJoinActionArg;
        }
    }

    public SetLineJoinActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103521);
        super.mo5879i(parcel);
        this.hdm = parcel.readString();
        AppMethodBeat.m2505o(103521);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103522);
        super.mo5880j(jSONObject);
        this.hdm = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103522);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103523);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdm);
        AppMethodBeat.m2505o(103523);
    }

    static {
        AppMethodBeat.m2504i(103526);
        AppMethodBeat.m2505o(103526);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103524);
        if (this == obj) {
            AppMethodBeat.m2505o(103524);
            return true;
        } else if (!(obj instanceof SetLineJoinActionArg)) {
            AppMethodBeat.m2505o(103524);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdm, ((SetLineJoinActionArg) obj).hdm);
            AppMethodBeat.m2505o(103524);
            return equals;
        } else {
            AppMethodBeat.m2505o(103524);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103525);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdm});
        AppMethodBeat.m2505o(103525);
        return hash;
    }
}
