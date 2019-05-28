package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg */
public class ClearRectActionArg extends BaseDrawActionArg {
    public static final Creator<ClearRectActionArg> CREATOR = new C191381();
    public float height;
    public float width;
    /* renamed from: x */
    public float f4342x;
    /* renamed from: y */
    public float f4343y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg$1 */
    static class C191381 implements Creator<ClearRectActionArg> {
        C191381() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ClearRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103309);
            ClearRectActionArg clearRectActionArg = new ClearRectActionArg(parcel);
            AppMethodBeat.m2505o(103309);
            return clearRectActionArg;
        }
    }

    public ClearRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103310);
        super.mo5879i(parcel);
        this.f4342x = parcel.readFloat();
        this.f4343y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.m2505o(103310);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103311);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f4342x);
        parcel.writeFloat(this.f4343y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.m2505o(103311);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103312);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f4342x = C42668g.m75561d(optJSONArray, 0);
        this.f4343y = C42668g.m75561d(optJSONArray, 1);
        this.width = C42668g.m75561d(optJSONArray, 2);
        this.height = C42668g.m75561d(optJSONArray, 3);
        AppMethodBeat.m2505o(103312);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103313);
        if (this == obj) {
            AppMethodBeat.m2505o(103313);
            return true;
        } else if (!(obj instanceof ClearRectActionArg)) {
            AppMethodBeat.m2505o(103313);
            return false;
        } else if (super.equals(obj)) {
            ClearRectActionArg clearRectActionArg = (ClearRectActionArg) obj;
            if (Float.compare(clearRectActionArg.f4342x, this.f4342x) == 0 && Float.compare(clearRectActionArg.f4343y, this.f4343y) == 0 && Float.compare(clearRectActionArg.width, this.width) == 0 && Float.compare(clearRectActionArg.height, this.height) == 0) {
                AppMethodBeat.m2505o(103313);
                return true;
            }
            AppMethodBeat.m2505o(103313);
            return false;
        } else {
            AppMethodBeat.m2505o(103313);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103314);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.f4342x), Float.valueOf(this.f4343y), Float.valueOf(this.width), Float.valueOf(this.height)});
        AppMethodBeat.m2505o(103314);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103315);
        AppMethodBeat.m2505o(103315);
    }
}
