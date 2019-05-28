package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg */
public class RealSetStrokeStyleActionNormalArg extends RealSetStrokeStyleActionArg {
    public static final Creator<RealSetStrokeStyleActionNormalArg> CREATOR = new C101501();
    public int color;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg$1 */
    static class C101501 implements Creator<RealSetStrokeStyleActionNormalArg> {
        C101501() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionNormalArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103409);
            RealSetStrokeStyleActionNormalArg realSetStrokeStyleActionNormalArg = new RealSetStrokeStyleActionNormalArg(parcel);
            AppMethodBeat.m2505o(103409);
            return realSetStrokeStyleActionNormalArg;
        }
    }

    public RealSetStrokeStyleActionNormalArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103411);
        super.mo5879i(parcel);
        this.color = parcel.readInt();
        AppMethodBeat.m2505o(103411);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103412);
        if (this == obj) {
            AppMethodBeat.m2505o(103412);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionNormalArg)) {
            AppMethodBeat.m2505o(103412);
            return false;
        } else if (super.equals(obj)) {
            if (this.color == ((RealSetStrokeStyleActionNormalArg) obj).color) {
                AppMethodBeat.m2505o(103412);
                return true;
            }
            AppMethodBeat.m2505o(103412);
            return false;
        } else {
            AppMethodBeat.m2505o(103412);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103413);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.color)});
        AppMethodBeat.m2505o(103413);
        return hash;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103414);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.color);
        AppMethodBeat.m2505o(103414);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public final void mo34358f(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103415);
        super.mo34358f(jSONArray);
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.m2505o(103415);
            return;
        }
        this.color = C42668g.m75567n(optJSONArray);
        AppMethodBeat.m2505o(103415);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103416);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103416);
    }

    static {
        AppMethodBeat.m2504i(103417);
        AppMethodBeat.m2505o(103417);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103410);
        c2102d.hcE.setColor(this.color);
        AppMethodBeat.m2505o(103410);
        return true;
    }
}
