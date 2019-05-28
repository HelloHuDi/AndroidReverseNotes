package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg */
public class SetLineDashActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineDashActionArg> CREATOR = new C381431();
    public float[] hdk = null;
    public float hdl = Float.MIN_VALUE;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg$1 */
    static class C381431 implements Creator<SetLineDashActionArg> {
        C381431() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineDashActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103513);
            SetLineDashActionArg setLineDashActionArg = new SetLineDashActionArg(parcel);
            AppMethodBeat.m2505o(103513);
            return setLineDashActionArg;
        }
    }

    public SetLineDashActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103514);
        super.mo5879i(parcel);
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.hdk = new float[readInt];
            parcel.readFloatArray(this.hdk);
        }
        this.hdl = parcel.readFloat();
        AppMethodBeat.m2505o(103514);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103515);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.m2505o(103515);
            return;
        }
        try {
            JSONArray jSONArray = optJSONArray.getJSONArray(0);
            if (jSONArray == null) {
                AppMethodBeat.m2505o(103515);
                return;
            }
            this.hdk = new float[jSONArray.length()];
            for (int i = 0; i < this.hdk.length; i++) {
                this.hdk[i] = C42668g.m75561d(jSONArray, i);
            }
            this.hdl = C42668g.m75561d(optJSONArray, 1);
            AppMethodBeat.m2505o(103515);
        } catch (JSONException e) {
            AppMethodBeat.m2505o(103515);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103516);
        super.writeToParcel(parcel, i);
        if (this.hdk != null) {
            parcel.writeInt(this.hdk.length);
            parcel.writeFloatArray(this.hdk);
        }
        parcel.writeFloat(this.hdl);
        AppMethodBeat.m2505o(103516);
    }

    static {
        AppMethodBeat.m2504i(103519);
        AppMethodBeat.m2505o(103519);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103517);
        if (this == obj) {
            AppMethodBeat.m2505o(103517);
            return true;
        } else if (!(obj instanceof SetLineDashActionArg)) {
            AppMethodBeat.m2505o(103517);
            return false;
        } else if (super.equals(obj)) {
            SetLineDashActionArg setLineDashActionArg = (SetLineDashActionArg) obj;
            if (Float.compare(setLineDashActionArg.hdl, this.hdl) == 0 && Arrays.equals(this.hdk, setLineDashActionArg.hdk)) {
                AppMethodBeat.m2505o(103517);
                return true;
            }
            AppMethodBeat.m2505o(103517);
            return false;
        } else {
            AppMethodBeat.m2505o(103517);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103518);
        int hash = (Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hdl)}) * 31) + Arrays.hashCode(this.hdk);
        AppMethodBeat.m2505o(103518);
        return hash;
    }
}
