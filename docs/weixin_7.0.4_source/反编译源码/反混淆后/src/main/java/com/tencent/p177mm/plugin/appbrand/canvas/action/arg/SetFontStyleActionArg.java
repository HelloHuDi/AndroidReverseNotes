package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg */
public class SetFontStyleActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontStyleActionArg> CREATOR = new C381421();
    public String hdh;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg$1 */
    static class C381421 implements Creator<SetFontStyleActionArg> {
        C381421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103478);
            SetFontStyleActionArg setFontStyleActionArg = new SetFontStyleActionArg(parcel);
            AppMethodBeat.m2505o(103478);
            return setFontStyleActionArg;
        }
    }

    public SetFontStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103479);
        super.mo5879i(parcel);
        this.hdh = parcel.readString();
        AppMethodBeat.m2505o(103479);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103480);
        super.mo5880j(jSONObject);
        this.hdh = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.m2505o(103480);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103481);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdh);
        AppMethodBeat.m2505o(103481);
    }

    static {
        AppMethodBeat.m2504i(103484);
        AppMethodBeat.m2505o(103484);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103482);
        if (this == obj) {
            AppMethodBeat.m2505o(103482);
            return true;
        } else if (!(obj instanceof SetFontStyleActionArg)) {
            AppMethodBeat.m2505o(103482);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdh, ((SetFontStyleActionArg) obj).hdh);
            AppMethodBeat.m2505o(103482);
            return equals;
        } else {
            AppMethodBeat.m2505o(103482);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103483);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdh});
        AppMethodBeat.m2505o(103483);
        return hash;
    }
}
