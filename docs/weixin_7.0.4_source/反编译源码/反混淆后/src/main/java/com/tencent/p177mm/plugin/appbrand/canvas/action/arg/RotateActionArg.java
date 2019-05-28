package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg */
public class RotateActionArg extends BaseDrawActionArg {
    public static final Creator<RotateActionArg> CREATOR = new C455271();
    public float hde;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg$1 */
    static class C455271 implements Creator<RotateActionArg> {
        C455271() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RotateActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103427);
            RotateActionArg rotateActionArg = new RotateActionArg(parcel);
            AppMethodBeat.m2505o(103427);
            return rotateActionArg;
        }
    }

    public RotateActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103428);
        super.mo5879i(parcel);
        this.hde = parcel.readFloat();
        AppMethodBeat.m2505o(103428);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103429);
        super.mo5880j(jSONObject);
        this.hde = (float) jSONObject.optJSONArray("data").optDouble(0);
        AppMethodBeat.m2505o(103429);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103430);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hde);
        AppMethodBeat.m2505o(103430);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103431);
        if (this == obj) {
            AppMethodBeat.m2505o(103431);
            return true;
        } else if (!(obj instanceof RotateActionArg)) {
            AppMethodBeat.m2505o(103431);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103431);
            return false;
        } else if (Float.compare(((RotateActionArg) obj).hde, this.hde) == 0) {
            AppMethodBeat.m2505o(103431);
            return true;
        } else {
            AppMethodBeat.m2505o(103431);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103432);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hde)});
        AppMethodBeat.m2505o(103432);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103433);
        AppMethodBeat.m2505o(103433);
    }
}
