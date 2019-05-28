package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C26812g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg */
public class SetFillStyleActionArg extends BaseDrawActionArg {
    public static final Creator<SetFillStyleActionArg> CREATOR = new C268091();
    public RealSetFillStyleActionArg hdg;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg$1 */
    static class C268091 implements Creator<SetFillStyleActionArg> {
        C268091() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFillStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103448);
            SetFillStyleActionArg setFillStyleActionArg = new SetFillStyleActionArg(parcel);
            AppMethodBeat.m2505o(103448);
            return setFillStyleActionArg;
        }
    }

    public SetFillStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void reset() {
        AppMethodBeat.m2504i(103449);
        super.reset();
        C26812g.ayn().mo5897a(this.hdg);
        this.hdg = null;
        AppMethodBeat.m2505o(103449);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103450);
        if (this.hdg == null) {
            AppMethodBeat.m2505o(103450);
            return false;
        }
        boolean a = this.hdg.mo21512a(c2102d, canvas);
        AppMethodBeat.m2505o(103450);
        return a;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103451);
        super.mo5879i(parcel);
        this.hdg = (RealSetFillStyleActionArg) parcel.readParcelable(SetFillStyleActionArg.class.getClassLoader());
        AppMethodBeat.m2505o(103451);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103452);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.hdg, i);
        AppMethodBeat.m2505o(103452);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103453);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.m2505o(103453);
            return;
        }
        this.hdg = (RealSetFillStyleActionArg) C26812g.ayn().mo5899yy(optJSONArray.optString(0));
        this.hdg.mo30544f(optJSONArray);
        AppMethodBeat.m2505o(103453);
    }

    static {
        AppMethodBeat.m2504i(103456);
        AppMethodBeat.m2505o(103456);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103454);
        if (this == obj) {
            AppMethodBeat.m2505o(103454);
            return true;
        } else if (!(obj instanceof SetFillStyleActionArg)) {
            AppMethodBeat.m2505o(103454);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdg, ((SetFillStyleActionArg) obj).hdg);
            AppMethodBeat.m2505o(103454);
            return equals;
        } else {
            AppMethodBeat.m2505o(103454);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103455);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdg});
        AppMethodBeat.m2505o(103455);
        return hash;
    }
}
