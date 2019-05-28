package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg */
public class DrawTextActionArg extends BaseDrawActionArg {
    public static final Creator<DrawTextActionArg> CREATOR = new C165861();
    public float hcW;
    public String text;
    /* renamed from: x */
    public float f3570x;
    /* renamed from: y */
    public float f3571y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg$1 */
    static class C165861 implements Creator<DrawTextActionArg> {
        C165861() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawTextActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103346);
            DrawTextActionArg drawTextActionArg = new DrawTextActionArg(parcel);
            AppMethodBeat.m2505o(103346);
            return drawTextActionArg;
        }
    }

    public DrawTextActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103347);
        super.mo5879i(parcel);
        this.text = parcel.readString();
        this.f3570x = parcel.readFloat();
        this.f3571y = parcel.readFloat();
        this.hcW = parcel.readFloat();
        AppMethodBeat.m2505o(103347);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103348);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.text = optJSONArray.optString(0);
        this.f3570x = C42668g.m75561d(optJSONArray, 1);
        this.f3571y = C42668g.m75561d(optJSONArray, 2);
        this.hcW = C42668g.m75561d(optJSONArray, 3);
        AppMethodBeat.m2505o(103348);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103349);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
        parcel.writeFloat(this.f3570x);
        parcel.writeFloat(this.f3571y);
        parcel.writeFloat(this.hcW);
        AppMethodBeat.m2505o(103349);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103350);
        if (this == obj) {
            AppMethodBeat.m2505o(103350);
            return true;
        } else if (!(obj instanceof DrawTextActionArg)) {
            AppMethodBeat.m2505o(103350);
            return false;
        } else if (super.equals(obj)) {
            DrawTextActionArg drawTextActionArg = (DrawTextActionArg) obj;
            if (Float.compare(drawTextActionArg.f3570x, this.f3570x) == 0 && Float.compare(drawTextActionArg.f3571y, this.f3571y) == 0 && Float.compare(drawTextActionArg.hcW, this.hcW) == 0 && Objects.equals(this.text, drawTextActionArg.text)) {
                AppMethodBeat.m2505o(103350);
                return true;
            }
            AppMethodBeat.m2505o(103350);
            return false;
        } else {
            AppMethodBeat.m2505o(103350);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103351);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.text, Float.valueOf(this.f3570x), Float.valueOf(this.f3571y), Float.valueOf(this.hcW)});
        AppMethodBeat.m2505o(103351);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103352);
        AppMethodBeat.m2505o(103352);
    }
}
