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

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg */
public class RealSetFillStyleActionLinearArg extends RealSetFillStyleActionArg {
    public static final Creator<RealSetFillStyleActionLinearArg> CREATOR = new C268071();
    public float hcX;
    public float hcY;
    public float hcZ;
    public float hda;
    public int[] hdb;
    public float[] positions;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg$1 */
    static class C268071 implements Creator<RealSetFillStyleActionLinearArg> {
        C268071() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionLinearArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103362);
            RealSetFillStyleActionLinearArg realSetFillStyleActionLinearArg = new RealSetFillStyleActionLinearArg(parcel);
            AppMethodBeat.m2505o(103362);
            return realSetFillStyleActionLinearArg;
        }
    }

    public RealSetFillStyleActionLinearArg(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: a */
    public final boolean mo21512a(C2102d c2102d, Canvas canvas) {
        AppMethodBeat.m2504i(103363);
        if (this.hdb == null || this.positions == null) {
            AppMethodBeat.m2505o(103363);
            return false;
        }
        c2102d.hcF.setShader(new LinearGradient(this.hcX, this.hcY, this.hcZ, this.hda, this.hdb, this.positions, TileMode.CLAMP));
        AppMethodBeat.m2505o(103363);
        return true;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103364);
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
        AppMethodBeat.m2505o(103364);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103365);
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
            AppMethodBeat.m2505o(103365);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(103365);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103366);
        if (this == obj) {
            AppMethodBeat.m2505o(103366);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionLinearArg)) {
            AppMethodBeat.m2505o(103366);
            return false;
        } else if (super.equals(obj)) {
            RealSetFillStyleActionLinearArg realSetFillStyleActionLinearArg = (RealSetFillStyleActionLinearArg) obj;
            if (Float.compare(realSetFillStyleActionLinearArg.hcX, this.hcX) == 0 && Float.compare(realSetFillStyleActionLinearArg.hcY, this.hcY) == 0 && Float.compare(realSetFillStyleActionLinearArg.hcZ, this.hcZ) == 0 && Float.compare(realSetFillStyleActionLinearArg.hda, this.hda) == 0 && Arrays.equals(this.hdb, realSetFillStyleActionLinearArg.hdb) && Arrays.equals(this.positions, realSetFillStyleActionLinearArg.positions)) {
                AppMethodBeat.m2505o(103366);
                return true;
            }
            AppMethodBeat.m2505o(103366);
            return false;
        } else {
            AppMethodBeat.m2505o(103366);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103367);
        int hash = (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.hcX), Float.valueOf(this.hcY), Float.valueOf(this.hcZ), Float.valueOf(this.hda)}) * 31) + Arrays.hashCode(this.hdb)) * 31) + Arrays.hashCode(this.positions);
        AppMethodBeat.m2505o(103367);
        return hash;
    }

    /* renamed from: f */
    public final void mo30544f(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103368);
        super.mo30544f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.m2505o(103368);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.m2505o(103368);
            return;
        }
        this.hcX = C42668g.m75561d(optJSONArray, 0);
        this.hcY = C42668g.m75561d(optJSONArray, 1);
        this.hcZ = C42668g.m75561d(optJSONArray, 2);
        this.hda = C42668g.m75561d(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            AppMethodBeat.m2505o(103368);
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
        AppMethodBeat.m2505o(103368);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103369);
        super.mo5880j(jSONObject);
        AppMethodBeat.m2505o(103369);
    }

    static {
        AppMethodBeat.m2504i(103370);
        AppMethodBeat.m2505o(103370);
    }
}
