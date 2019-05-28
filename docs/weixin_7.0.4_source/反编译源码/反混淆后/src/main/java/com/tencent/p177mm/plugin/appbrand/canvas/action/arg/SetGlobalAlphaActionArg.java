package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg */
public class SetGlobalAlphaActionArg extends BaseDrawActionArg {
    public static final Creator<SetGlobalAlphaActionArg> CREATOR = new C268101();
    public int alpha;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg$1 */
    static class C268101 implements Creator<SetGlobalAlphaActionArg> {
        C268101() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetGlobalAlphaActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103492);
            SetGlobalAlphaActionArg setGlobalAlphaActionArg = new SetGlobalAlphaActionArg(parcel);
            AppMethodBeat.m2505o(103492);
            return setGlobalAlphaActionArg;
        }
    }

    public SetGlobalAlphaActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103493);
        super.mo5879i(parcel);
        this.alpha = parcel.readInt();
        AppMethodBeat.m2505o(103493);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103494);
        super.mo5880j(jSONObject);
        this.alpha = C42668g.m75554a(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.m2505o(103494);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103495);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.alpha);
        AppMethodBeat.m2505o(103495);
    }

    static {
        AppMethodBeat.m2504i(103498);
        AppMethodBeat.m2505o(103498);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103496);
        if (this == obj) {
            AppMethodBeat.m2505o(103496);
            return true;
        } else if (!(obj instanceof SetGlobalAlphaActionArg)) {
            AppMethodBeat.m2505o(103496);
            return false;
        } else if (super.equals(obj)) {
            if (this.alpha == ((SetGlobalAlphaActionArg) obj).alpha) {
                AppMethodBeat.m2505o(103496);
                return true;
            }
            AppMethodBeat.m2505o(103496);
            return false;
        } else {
            AppMethodBeat.m2505o(103496);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103497);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.alpha)});
        AppMethodBeat.m2505o(103497);
        return hash;
    }
}
