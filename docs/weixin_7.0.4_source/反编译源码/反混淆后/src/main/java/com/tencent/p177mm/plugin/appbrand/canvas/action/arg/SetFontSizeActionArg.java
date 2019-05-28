package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg */
public class SetFontSizeActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontSizeActionArg> CREATOR = new C331181();
    public int size;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg$1 */
    static class C331181 implements Creator<SetFontSizeActionArg> {
        C331181() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontSizeActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103471);
            SetFontSizeActionArg setFontSizeActionArg = new SetFontSizeActionArg(parcel);
            AppMethodBeat.m2505o(103471);
            return setFontSizeActionArg;
        }
    }

    public SetFontSizeActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103472);
        super.mo5879i(parcel);
        this.size = parcel.readInt();
        AppMethodBeat.m2505o(103472);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103473);
        super.mo5880j(jSONObject);
        this.size = C42668g.m75554a(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.m2505o(103473);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103474);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.size);
        AppMethodBeat.m2505o(103474);
    }

    static {
        AppMethodBeat.m2504i(103477);
        AppMethodBeat.m2505o(103477);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103475);
        if (this == obj) {
            AppMethodBeat.m2505o(103475);
            return true;
        } else if (!(obj instanceof SetFontSizeActionArg)) {
            AppMethodBeat.m2505o(103475);
            return false;
        } else if (super.equals(obj)) {
            if (this.size == ((SetFontSizeActionArg) obj).size) {
                AppMethodBeat.m2505o(103475);
                return true;
            }
            AppMethodBeat.m2505o(103475);
            return false;
        } else {
            AppMethodBeat.m2505o(103475);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103476);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.size)});
        AppMethodBeat.m2505o(103476);
        return hash;
    }
}
