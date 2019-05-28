package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg */
public class SetLineCapActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineCapActionArg> CREATOR = new C165891();
    public String hdj;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg$1 */
    static class C165891 implements Creator<SetLineCapActionArg> {
        C165891() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineCapActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103506);
            SetLineCapActionArg setLineCapActionArg = new SetLineCapActionArg(parcel);
            AppMethodBeat.m2505o(103506);
            return setLineCapActionArg;
        }
    }

    public SetLineCapActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103507);
        super.mo5879i(parcel);
        this.hdj = parcel.readString();
        AppMethodBeat.m2505o(103507);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103508);
        super.mo5880j(jSONObject);
        this.hdj = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103508);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103509);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdj);
        AppMethodBeat.m2505o(103509);
    }

    static {
        AppMethodBeat.m2504i(103512);
        AppMethodBeat.m2505o(103512);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103510);
        if (this == obj) {
            AppMethodBeat.m2505o(103510);
            return true;
        } else if (!(obj instanceof SetLineCapActionArg)) {
            AppMethodBeat.m2505o(103510);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdj, ((SetLineCapActionArg) obj).hdj);
            AppMethodBeat.m2505o(103510);
            return equals;
        } else {
            AppMethodBeat.m2505o(103510);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103511);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdj});
        AppMethodBeat.m2505o(103511);
        return hash;
    }
}
