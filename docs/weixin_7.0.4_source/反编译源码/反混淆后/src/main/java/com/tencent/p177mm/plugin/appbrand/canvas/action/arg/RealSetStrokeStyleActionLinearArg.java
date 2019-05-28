package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg */
public class RealSetStrokeStyleActionLinearArg extends RealSetStrokeStyleActionArg {
    public static final Creator<RealSetStrokeStyleActionLinearArg> CREATOR = new C423911();
    public float hcX;
    public float hcY;
    public float hcZ;
    public float hda;
    public int[] hdb;
    public float[] positions;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg$1 */
    static class C423911 implements Creator<RealSetStrokeStyleActionLinearArg> {
        C423911() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionLinearArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103400);
            RealSetStrokeStyleActionLinearArg realSetStrokeStyleActionLinearArg = new RealSetStrokeStyleActionLinearArg(parcel);
            AppMethodBeat.m2505o(103400);
            return realSetStrokeStyleActionLinearArg;
        }
    }

    public RealSetStrokeStyleActionLinearArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103401);
        if (this.hdb == null || this.positions == null) {
            AppMethodBeat.m2505o(103401);
            return false;
        }
        c2102d.hcE.setShader(new LinearGradient(this.hcX, this.hcY, this.hcZ, this.hda, this.hdb, this.positions, TileMode.CLAMP));
        AppMethodBeat.m2505o(103401);
        return true;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103402);
        if (this == obj) {
            AppMethodBeat.m2505o(103402);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionLinearArg)) {
            AppMethodBeat.m2505o(103402);
            return false;
        } else if (super.equals(obj)) {
            RealSetStrokeStyleActionLinearArg realSetStrokeStyleActionLinearArg = (RealSetStrokeStyleActionLinearArg) obj;
            if (Float.compare(realSetStrokeStyleActionLinearArg.hcX, this.hcX) == 0 && Float.compare(realSetStrokeStyleActionLinearArg.hcY, this.hcY) == 0 && Float.compare(realSetStrokeStyleActionLinearArg.hcZ, this.hcZ) == 0 && Float.compare(realSetStrokeStyleActionLinearArg.hda, this.hda) == 0 && Arrays.equals(this.hdb, realSetStrokeStyleActionLinearArg.hdb) && Arrays.equals(this.positions, realSetStrokeStyleActionLinearArg.positions)) {
                AppMethodBeat.m2505o(103402);
                return true;
            }
            AppMethodBeat.m2505o(103402);
            return false;
        } else {
            AppMethodBeat.m2505o(103402);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103403);
        int hash = (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY), Float.valueOf(this.hcZ), Float.valueOf(this.hda)}) * 31) + Arrays.hashCode(this.hdb)) * 31) + Arrays.hashCode(this.positions);
        AppMethodBeat.m2505o(103403);
        return hash;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103404);
        super.mo5879i(parcel);
        this.hcX = parcel.readFloat();
        this.hcY = parcel.readFloat();
        this.hcZ = parcel.readFloat();
        this.hda = parcel.readFloat();
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
        AppMethodBeat.m2505o(103404);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103405);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.hcX);
        parcel.writeFloat(this.hcY);
        parcel.writeFloat(this.hcZ);
        parcel.writeFloat(this.hda);
        if (this.hdb != null) {
            parcel.writeInt(this.hdb.length);
            parcel.writeIntArray(this.hdb);
        } else {
            parcel.writeInt(0);
        }
        if (this.positions != null) {
            parcel.writeInt(this.positions.length);
            parcel.writeFloatArray(this.positions);
            AppMethodBeat.m2505o(103405);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(103405);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public final void mo34358f(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103406);
        super.mo34358f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.m2505o(103406);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.m2505o(103406);
            return;
        }
        this.hcX = C42668g.m75561d(optJSONArray, 0);
        this.hcY = C42668g.m75561d(optJSONArray, 1);
        this.hcZ = C42668g.m75561d(optJSONArray, 2);
        this.hda = C42668g.m75561d(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            AppMethodBeat.m2505o(103406);
            return;
        }
        this.hdb = new int[optJSONArray2.length()];
        this.positions = new float[optJSONArray2.length()];
        for (int i = 0; i < optJSONArray2.length(); i++) {
            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
            if (optJSONArray3.length() >= 2) {
                this.positions[i] = (float) optJSONArray3.optDouble(0);
                this.hdb[i] = C42668g.m75567n(optJSONArray3.optJSONArray(1));
            }
        }
        AppMethodBeat.m2505o(103406);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103407);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103407);
    }

    static {
        AppMethodBeat.m2504i(103408);
        AppMethodBeat.m2505o(103408);
    }
}
