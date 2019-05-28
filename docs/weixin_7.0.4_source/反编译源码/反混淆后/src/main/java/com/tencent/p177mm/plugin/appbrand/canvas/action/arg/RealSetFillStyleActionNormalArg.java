package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg */
public class RealSetFillStyleActionNormalArg extends RealSetFillStyleActionArg {
    public static final Creator<RealSetFillStyleActionNormalArg> CREATOR = new C191401();
    public int color;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg$1 */
    static class C191401 implements Creator<RealSetFillStyleActionNormalArg> {
        C191401() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionNormalArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103371);
            RealSetFillStyleActionNormalArg realSetFillStyleActionNormalArg = new RealSetFillStyleActionNormalArg(parcel);
            AppMethodBeat.m2505o(103371);
            return realSetFillStyleActionNormalArg;
        }
    }

    public RealSetFillStyleActionNormalArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103373);
        super.mo5879i(parcel);
        this.color = parcel.readInt();
        AppMethodBeat.m2505o(103373);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103374);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.color);
        AppMethodBeat.m2505o(103374);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public final void mo30544f(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103375);
        super.mo30544f(jSONArray);
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.m2505o(103375);
            return;
        }
        this.color = C42668g.m75567n(optJSONArray);
        AppMethodBeat.m2505o(103375);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103376);
        if (this == obj) {
            AppMethodBeat.m2505o(103376);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionNormalArg)) {
            AppMethodBeat.m2505o(103376);
            return false;
        } else if (super.equals(obj)) {
            if (this.color == ((RealSetFillStyleActionNormalArg) obj).color) {
                AppMethodBeat.m2505o(103376);
                return true;
            }
            AppMethodBeat.m2505o(103376);
            return false;
        } else {
            AppMethodBeat.m2505o(103376);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103377);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.color)});
        AppMethodBeat.m2505o(103377);
        return hash;
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103378);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103378);
    }

    static {
        AppMethodBeat.m2504i(103379);
        AppMethodBeat.m2505o(103379);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103372);
        C10148a c10148a = c2102d.hcF;
        c10148a.setShader(null);
        c10148a.setColor(this.color);
        AppMethodBeat.m2505o(103372);
        return true;
    }
}
