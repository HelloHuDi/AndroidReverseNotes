package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg */
public class RealSetStrokeStyleActionRadialArg extends RealSetStrokeStyleActionArg {
    public static final Creator<RealSetStrokeStyleActionRadialArg> CREATOR = new C268081();
    public float hcX;
    public float hcY;
    public int[] hdb;
    public float hdd;
    public float[] positions;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg$1 */
    static class C268081 implements Creator<RealSetStrokeStyleActionRadialArg> {
        C268081() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionRadialArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103418);
            RealSetStrokeStyleActionRadialArg realSetStrokeStyleActionRadialArg = new RealSetStrokeStyleActionRadialArg(parcel);
            AppMethodBeat.m2505o(103418);
            return realSetStrokeStyleActionRadialArg;
        }
    }

    public RealSetStrokeStyleActionRadialArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103419);
        if (this.hdb == null || this.positions == null) {
            AppMethodBeat.m2505o(103419);
            return false;
        }
        c2102d.hcE.setShader(new RadialGradient(this.hcX, this.hcY, this.hdd, this.hdb, this.positions, TileMode.CLAMP));
        AppMethodBeat.m2505o(103419);
        return true;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103420);
        if (this == obj) {
            AppMethodBeat.m2505o(103420);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionRadialArg)) {
            AppMethodBeat.m2505o(103420);
            return false;
        } else if (super.equals(obj)) {
            RealSetStrokeStyleActionRadialArg realSetStrokeStyleActionRadialArg = (RealSetStrokeStyleActionRadialArg) obj;
            if (Float.compare(realSetStrokeStyleActionRadialArg.hcX, this.hcX) == 0 && Float.compare(realSetStrokeStyleActionRadialArg.hcY, this.hcY) == 0 && Float.compare(realSetStrokeStyleActionRadialArg.hdd, this.hdd) == 0 && Arrays.equals(this.hdb, realSetStrokeStyleActionRadialArg.hdb) && Arrays.equals(this.positions, realSetStrokeStyleActionRadialArg.positions)) {
                AppMethodBeat.m2505o(103420);
                return true;
            }
            AppMethodBeat.m2505o(103420);
            return false;
        } else {
            AppMethodBeat.m2505o(103420);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103421);
        int hash = (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY), Float.valueOf(this.hdd)}) * 31) + Arrays.hashCode(this.hdb)) * 31) + Arrays.hashCode(this.positions);
        AppMethodBeat.m2505o(103421);
        return hash;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103422);
        super.mo5879i(parcel);
        this.hcX = parcel.readFloat();
        this.hcY = parcel.readFloat();
        this.hdd = parcel.readFloat();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.hdb = new int[readInt];
            parcel.readIntArray(this.hdb);
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.positions = new float[readInt];
            parcel.readFloatArray(this.positions);
        }
        AppMethodBeat.m2505o(103422);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103423);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hcX);
        parcel.writeFloat(this.hcY);
        parcel.writeFloat(this.hdd);
        if (this.hdb != null) {
            parcel.writeInt(this.hdb.length);
            parcel.writeIntArray(this.hdb);
        } else {
            parcel.writeInt(0);
        }
        if (this.positions != null) {
            parcel.writeInt(this.positions.length);
            parcel.writeFloatArray(this.positions);
            AppMethodBeat.m2505o(103423);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(103423);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public final void mo34358f(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103424);
        super.mo34358f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.m2505o(103424);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 3) {
            AppMethodBeat.m2505o(103424);
            return;
        }
        this.hcX = C42668g.m75561d(optJSONArray, 1);
        this.hcY = C42668g.m75561d(optJSONArray, 2);
        this.hdd = C42668g.m75561d(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        this.hdb = new int[optJSONArray2.length()];
        this.positions = new float[optJSONArray2.length()];
        for (int i = 0; i < optJSONArray2.length(); i++) {
            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
            if (optJSONArray3.length() >= 2) {
                this.positions[i] = (float) optJSONArray3.optDouble(0);
                this.hdb[i] = C42668g.m75567n(optJSONArray3.optJSONArray(1));
            }
        }
        AppMethodBeat.m2505o(103424);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103425);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103425);
    }

    static {
        AppMethodBeat.m2504i(103426);
        AppMethodBeat.m2505o(103426);
    }
}
