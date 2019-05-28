package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg */
public class ScaleActionArg extends BaseDrawActionArg {
    public static final Creator<ScaleActionArg> CREATOR = new C20931();
    public float hcX;
    public float hcY;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg$1 */
    static class C20931 implements Creator<ScaleActionArg> {
        C20931() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScaleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103434);
            ScaleActionArg scaleActionArg = new ScaleActionArg(parcel);
            AppMethodBeat.m2505o(103434);
            return scaleActionArg;
        }
    }

    public ScaleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103435);
        super.mo5879i(parcel);
        this.hcX = parcel.readFloat();
        this.hcY = parcel.readFloat();
        AppMethodBeat.m2505o(103435);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103436);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.hcX = (float) optJSONArray.optDouble(0);
        this.hcY = (float) optJSONArray.optDouble(1);
        AppMethodBeat.m2505o(103436);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103437);
        if (this == obj) {
            AppMethodBeat.m2505o(103437);
            return true;
        } else if (!(obj instanceof ScaleActionArg)) {
            AppMethodBeat.m2505o(103437);
            return false;
        } else if (super.equals(obj)) {
            ScaleActionArg scaleActionArg = (ScaleActionArg) obj;
            if (Float.compare(scaleActionArg.hcX, this.hcX) == 0 && Float.compare(scaleActionArg.hcY, this.hcY) == 0) {
                AppMethodBeat.m2505o(103437);
                return true;
            }
            AppMethodBeat.m2505o(103437);
            return false;
        } else {
            AppMethodBeat.m2505o(103437);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103438);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY)});
        AppMethodBeat.m2505o(103438);
        return hash;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103439);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hcX);
        parcel.writeFloat(this.hcY);
        AppMethodBeat.m2505o(103439);
    }

    static {
        AppMethodBeat.m2504i(103440);
        AppMethodBeat.m2505o(103440);
    }
}
