package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg */
public class SetShadowActionArg extends BaseDrawActionArg {
    public static final Creator<SetShadowActionArg> CREATOR = new C20971();
    public int color;
    public float hdo;
    /* renamed from: x */
    public float f1245x;
    /* renamed from: y */
    public float f1246y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg$1 */
    static class C20971 implements Creator<SetShadowActionArg> {
        C20971() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetShadowActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103541);
            SetShadowActionArg setShadowActionArg = new SetShadowActionArg(parcel);
            AppMethodBeat.m2505o(103541);
            return setShadowActionArg;
        }
    }

    public SetShadowActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103542);
        super.mo5879i(parcel);
        this.f1245x = parcel.readFloat();
        this.f1246y = parcel.readFloat();
        this.hdo = parcel.readFloat();
        this.color = parcel.readInt();
        AppMethodBeat.m2505o(103542);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103543);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f1245x);
        parcel.writeFloat(this.f1246y);
        parcel.writeFloat(this.hdo);
        parcel.writeInt(this.color);
        AppMethodBeat.m2505o(103543);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103544);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        optJSONArray.length();
        this.f1245x = C42668g.m75561d(optJSONArray, 0);
        this.f1246y = C42668g.m75561d(optJSONArray, 1);
        this.hdo = C42668g.m75561d(optJSONArray, 2);
        optJSONArray = optJSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.m2505o(103544);
            return;
        }
        this.color = C42668g.m75567n(optJSONArray);
        AppMethodBeat.m2505o(103544);
    }

    static {
        AppMethodBeat.m2504i(103547);
        AppMethodBeat.m2505o(103547);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103545);
        if (this == obj) {
            AppMethodBeat.m2505o(103545);
            return true;
        } else if (!(obj instanceof SetShadowActionArg)) {
            AppMethodBeat.m2505o(103545);
            return false;
        } else if (super.equals(obj)) {
            SetShadowActionArg setShadowActionArg = (SetShadowActionArg) obj;
            if (Float.compare(setShadowActionArg.f1245x, this.f1245x) == 0 && Float.compare(setShadowActionArg.f1246y, this.f1246y) == 0 && Float.compare(setShadowActionArg.hdo, this.hdo) == 0 && this.color == setShadowActionArg.color) {
                AppMethodBeat.m2505o(103545);
                return true;
            }
            AppMethodBeat.m2505o(103545);
            return false;
        } else {
            AppMethodBeat.m2505o(103545);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103546);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.f1245x), Float.valueOf(this.f1246y), Float.valueOf(this.hdo), Integer.valueOf(this.color)});
        AppMethodBeat.m2505o(103546);
        return hash;
    }
}
