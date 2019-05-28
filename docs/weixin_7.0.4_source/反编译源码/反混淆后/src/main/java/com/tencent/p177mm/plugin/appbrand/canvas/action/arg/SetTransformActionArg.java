package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg */
public class SetTransformActionArg extends BaseDrawActionArg {
    public static final Creator<SetTransformActionArg> CREATOR = new C191451();
    public float hdr;
    public float hds;
    public float scaleX;
    public float scaleY;
    public float translateX;
    public float translateY;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg$1 */
    static class C191451 implements Creator<SetTransformActionArg> {
        C191451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetTransformActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103571);
            SetTransformActionArg setTransformActionArg = new SetTransformActionArg(parcel);
            AppMethodBeat.m2505o(103571);
            return setTransformActionArg;
        }
    }

    public SetTransformActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103572);
        super.mo5879i(parcel);
        this.scaleX = parcel.readFloat();
        this.hdr = parcel.readFloat();
        this.hds = parcel.readFloat();
        this.scaleY = parcel.readFloat();
        this.translateX = parcel.readFloat();
        this.translateY = parcel.readFloat();
        AppMethodBeat.m2505o(103572);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103573);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        try {
            this.scaleX = (float) optJSONArray.getDouble(0);
            this.hdr = (float) optJSONArray.getDouble(1);
            this.hds = (float) optJSONArray.getDouble(2);
            this.scaleY = (float) optJSONArray.getDouble(3);
            this.translateX = C42668g.m75560c(optJSONArray, 4);
            this.translateY = C42668g.m75560c(optJSONArray, 5);
            AppMethodBeat.m2505o(103573);
        } catch (JSONException e) {
            C45124d.printErrStackTrace("SetTransformActionArg", e, "", new Object[0]);
            AppMethodBeat.m2505o(103573);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103574);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.scaleY);
        parcel.writeFloat(this.hdr);
        parcel.writeFloat(this.hds);
        parcel.writeFloat(this.scaleY);
        parcel.writeFloat(this.translateX);
        parcel.writeFloat(this.translateY);
        AppMethodBeat.m2505o(103574);
    }

    static {
        AppMethodBeat.m2504i(103577);
        AppMethodBeat.m2505o(103577);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103575);
        if (this == obj) {
            AppMethodBeat.m2505o(103575);
            return true;
        } else if (!(obj instanceof SetTransformActionArg)) {
            AppMethodBeat.m2505o(103575);
            return false;
        } else if (super.equals(obj)) {
            SetTransformActionArg setTransformActionArg = (SetTransformActionArg) obj;
            if (Float.compare(setTransformActionArg.scaleX, this.scaleX) == 0 && Float.compare(setTransformActionArg.hdr, this.hdr) == 0 && Float.compare(setTransformActionArg.hds, this.hds) == 0 && Float.compare(setTransformActionArg.scaleY, this.scaleY) == 0 && Float.compare(setTransformActionArg.translateX, this.translateX) == 0 && Float.compare(setTransformActionArg.translateY, this.translateY) == 0) {
                AppMethodBeat.m2505o(103575);
                return true;
            }
            AppMethodBeat.m2505o(103575);
            return false;
        } else {
            AppMethodBeat.m2505o(103575);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103576);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.scaleX), Float.valueOf(this.hdr), Float.valueOf(this.hds), Float.valueOf(this.scaleY), Float.valueOf(this.translateX), Float.valueOf(this.translateY)});
        AppMethodBeat.m2505o(103576);
        return hash;
    }
}
