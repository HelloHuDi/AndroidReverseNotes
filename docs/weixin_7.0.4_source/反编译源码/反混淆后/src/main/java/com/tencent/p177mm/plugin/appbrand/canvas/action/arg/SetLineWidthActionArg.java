package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg */
public class SetLineWidthActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineWidthActionArg> CREATOR = new C20951();
    public float hdn;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg$1 */
    static class C20951 implements Creator<SetLineWidthActionArg> {
        C20951() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineWidthActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103527);
            SetLineWidthActionArg setLineWidthActionArg = new SetLineWidthActionArg(parcel);
            AppMethodBeat.m2505o(103527);
            return setLineWidthActionArg;
        }
    }

    public SetLineWidthActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103528);
        super.mo5879i(parcel);
        this.hdn = parcel.readFloat();
        AppMethodBeat.m2505o(103528);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103529);
        super.mo5880j(jSONObject);
        this.hdn = C42668g.m75561d(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.m2505o(103529);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103530);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hdn);
        AppMethodBeat.m2505o(103530);
    }

    static {
        AppMethodBeat.m2504i(103533);
        AppMethodBeat.m2505o(103533);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103531);
        if (this == obj) {
            AppMethodBeat.m2505o(103531);
            return true;
        } else if (!(obj instanceof SetLineWidthActionArg)) {
            AppMethodBeat.m2505o(103531);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103531);
            return false;
        } else if (Float.compare(((SetLineWidthActionArg) obj).hdn, this.hdn) == 0) {
            AppMethodBeat.m2505o(103531);
            return true;
        } else {
            AppMethodBeat.m2505o(103531);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103532);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hdn)});
        AppMethodBeat.m2505o(103532);
        return hash;
    }
}
