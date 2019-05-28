package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg */
public class DrawImageActionArg extends BaseDrawActionArg {
    public static final Creator<DrawImageActionArg> CREATOR = new C268061();
    public int aIJ;
    public int aIK;
    public int hcT;
    public int hcU;
    public int hcV;
    public float height;
    public String url;
    public float width;
    /* renamed from: x */
    public float f13669x;
    /* renamed from: y */
    public float f13670y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg$1 */
    static class C268061 implements Creator<DrawImageActionArg> {
        C268061() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawImageActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103332);
            DrawImageActionArg drawImageActionArg = new DrawImageActionArg(parcel);
            AppMethodBeat.m2505o(103332);
            return drawImageActionArg;
        }
    }

    public DrawImageActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103333);
        super.mo5879i(parcel);
        this.hcT = parcel.readInt();
        this.url = parcel.readString();
        this.f13669x = parcel.readFloat();
        this.f13670y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        this.hcU = parcel.readInt();
        this.hcV = parcel.readInt();
        this.aIJ = parcel.readInt();
        this.aIK = parcel.readInt();
        AppMethodBeat.m2505o(103333);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103334);
        super.mo5880j(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            this.hcT = optJSONArray.length();
            this.url = optJSONArray.optString(0);
            this.f13669x = C42668g.m75561d(optJSONArray, 1);
            this.f13670y = C42668g.m75561d(optJSONArray, 2);
            this.width = C42668g.m75561d(optJSONArray, 3);
            this.height = C42668g.m75561d(optJSONArray, 4);
            this.hcU = optJSONArray.optInt(5);
            this.hcV = optJSONArray.optInt(6);
            this.aIJ = optJSONArray.optInt(7);
            this.aIK = optJSONArray.optInt(8);
            AppMethodBeat.m2505o(103334);
        } catch (Exception e) {
            C45124d.printErrStackTrace("DrawImageActionArg", e, "", new Object[0]);
            AppMethodBeat.m2505o(103334);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103335);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.hcT);
        parcel.writeString(this.url);
        parcel.writeFloat(this.f13669x);
        parcel.writeFloat(this.f13670y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeInt(this.hcU);
        parcel.writeInt(this.hcV);
        parcel.writeInt(this.aIJ);
        parcel.writeInt(this.aIK);
        AppMethodBeat.m2505o(103335);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103336);
        if (this == obj) {
            AppMethodBeat.m2505o(103336);
            return true;
        } else if (!(obj instanceof DrawImageActionArg)) {
            AppMethodBeat.m2505o(103336);
            return false;
        } else if (super.equals(obj)) {
            DrawImageActionArg drawImageActionArg = (DrawImageActionArg) obj;
            if (this.hcT == drawImageActionArg.hcT && Float.compare(drawImageActionArg.f13669x, this.f13669x) == 0 && Float.compare(drawImageActionArg.f13670y, this.f13670y) == 0 && Float.compare(drawImageActionArg.width, this.width) == 0 && Float.compare(drawImageActionArg.height, this.height) == 0 && this.hcU == drawImageActionArg.hcU && this.hcV == drawImageActionArg.hcV && this.aIJ == drawImageActionArg.aIJ && this.aIK == drawImageActionArg.aIK && Objects.equals(this.url, drawImageActionArg.url)) {
                AppMethodBeat.m2505o(103336);
                return true;
            }
            AppMethodBeat.m2505o(103336);
            return false;
        } else {
            AppMethodBeat.m2505o(103336);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103337);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.hcT), this.url, Float.valueOf(this.f13669x), Float.valueOf(this.f13670y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.hcU), Integer.valueOf(this.hcV), Integer.valueOf(this.aIJ), Integer.valueOf(this.aIK)});
        AppMethodBeat.m2505o(103337);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103338);
        AppMethodBeat.m2505o(103338);
    }
}
