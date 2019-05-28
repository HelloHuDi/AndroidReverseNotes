package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg */
public class SeMiterLimitActionArg extends BaseDrawActionArg {
    public static final Creator<SeMiterLimitActionArg> CREATOR = new C101511();
    public float hdf;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg$1 */
    static class C101511 implements Creator<SeMiterLimitActionArg> {
        C101511() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SeMiterLimitActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103441);
            SeMiterLimitActionArg seMiterLimitActionArg = new SeMiterLimitActionArg(parcel);
            AppMethodBeat.m2505o(103441);
            return seMiterLimitActionArg;
        }
    }

    public SeMiterLimitActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103442);
        super.mo5879i(parcel);
        this.hdf = parcel.readFloat();
        AppMethodBeat.m2505o(103442);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103443);
        super.mo5880j(jSONObject);
        this.hdf = (float) jSONObject.optJSONArray("data").optDouble(0);
        AppMethodBeat.m2505o(103443);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103444);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hdf);
        AppMethodBeat.m2505o(103444);
    }

    static {
        AppMethodBeat.m2504i(103447);
        AppMethodBeat.m2505o(103447);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103445);
        if (this == obj) {
            AppMethodBeat.m2505o(103445);
            return true;
        } else if (!(obj instanceof SeMiterLimitActionArg)) {
            AppMethodBeat.m2505o(103445);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103445);
            return false;
        } else if (Float.compare(((SeMiterLimitActionArg) obj).hdf, this.hdf) == 0) {
            AppMethodBeat.m2505o(103445);
            return true;
        } else {
            AppMethodBeat.m2505o(103445);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103446);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hdf)});
        AppMethodBeat.m2505o(103446);
        return hash;
    }
}
