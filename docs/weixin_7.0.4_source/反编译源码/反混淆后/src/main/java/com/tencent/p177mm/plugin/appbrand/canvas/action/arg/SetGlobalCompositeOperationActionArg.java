package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg */
public class SetGlobalCompositeOperationActionArg extends BaseDrawActionArg {
    public static final Creator<SetGlobalCompositeOperationActionArg> CREATOR = new C191431();
    public String type;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg$1 */
    static class C191431 implements Creator<SetGlobalCompositeOperationActionArg> {
        C191431() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetGlobalCompositeOperationActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103499);
            SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg(parcel);
            AppMethodBeat.m2505o(103499);
            return setGlobalCompositeOperationActionArg;
        }
    }

    public SetGlobalCompositeOperationActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103500);
        super.mo5879i(parcel);
        this.type = parcel.readString();
        AppMethodBeat.m2505o(103500);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103501);
        super.mo5880j(jSONObject);
        this.type = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103501);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103502);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.type);
        AppMethodBeat.m2505o(103502);
    }

    static {
        AppMethodBeat.m2504i(103505);
        AppMethodBeat.m2505o(103505);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103503);
        if (this == obj) {
            AppMethodBeat.m2505o(103503);
            return true;
        } else if (!(obj instanceof SetGlobalCompositeOperationActionArg)) {
            AppMethodBeat.m2505o(103503);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.type, ((SetGlobalCompositeOperationActionArg) obj).type);
            AppMethodBeat.m2505o(103503);
            return equals;
        } else {
            AppMethodBeat.m2505o(103503);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103504);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.type});
        AppMethodBeat.m2505o(103504);
        return hash;
    }
}
