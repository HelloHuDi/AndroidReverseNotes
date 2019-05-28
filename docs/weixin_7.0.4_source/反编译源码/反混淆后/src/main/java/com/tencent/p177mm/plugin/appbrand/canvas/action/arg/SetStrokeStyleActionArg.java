package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C10153h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg */
public class SetStrokeStyleActionArg extends BaseDrawActionArg {
    public static final Creator<SetStrokeStyleActionArg> CREATOR = new C191441();
    public RealSetStrokeStyleActionArg hdp;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg$1 */
    static class C191441 implements Creator<SetStrokeStyleActionArg> {
        C191441() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetStrokeStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103548);
            SetStrokeStyleActionArg setStrokeStyleActionArg = new SetStrokeStyleActionArg(parcel);
            AppMethodBeat.m2505o(103548);
            return setStrokeStyleActionArg;
        }
    }

    public SetStrokeStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void reset() {
        AppMethodBeat.m2504i(103549);
        super.reset();
        C10153h.ayo().mo5897a(this.hdp);
        this.hdp = null;
        AppMethodBeat.m2505o(103549);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103550);
        if (this.hdp == null) {
            AppMethodBeat.m2505o(103550);
            return false;
        }
        boolean a = this.hdp.mo21512a(c2102d, canvas);
        AppMethodBeat.m2505o(103550);
        return a;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103551);
        super.mo5879i(parcel);
        this.hdp = (RealSetStrokeStyleActionArg) parcel.readParcelable(SetStrokeStyleActionArg.class.getClassLoader());
        AppMethodBeat.m2505o(103551);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103552);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.hdp, i);
        AppMethodBeat.m2505o(103552);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103553);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.m2505o(103553);
            return;
        }
        this.hdp = (RealSetStrokeStyleActionArg) C10153h.ayo().mo5899yy(optJSONArray.optString(0));
        this.hdp.mo34358f(optJSONArray);
        AppMethodBeat.m2505o(103553);
    }

    static {
        AppMethodBeat.m2504i(103556);
        AppMethodBeat.m2505o(103556);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103554);
        if (this == obj) {
            AppMethodBeat.m2505o(103554);
            return true;
        } else if (!(obj instanceof SetStrokeStyleActionArg)) {
            AppMethodBeat.m2505o(103554);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdp, ((SetStrokeStyleActionArg) obj).hdp);
            AppMethodBeat.m2505o(103554);
            return equals;
        } else {
            AppMethodBeat.m2505o(103554);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103555);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdp});
        AppMethodBeat.m2505o(103555);
        return hash;
    }
}
