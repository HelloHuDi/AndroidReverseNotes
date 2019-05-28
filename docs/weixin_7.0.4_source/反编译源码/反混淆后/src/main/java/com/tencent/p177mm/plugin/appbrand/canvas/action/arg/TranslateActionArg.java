package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg */
public class TranslateActionArg extends BaseDrawActionArg {
    public static final Creator<TranslateActionArg> CREATOR = new C101521();
    /* renamed from: x */
    public float f4346x;
    /* renamed from: y */
    public float f4347y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg$1 */
    static class C101521 implements Creator<TranslateActionArg> {
        C101521() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TranslateActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103578);
            TranslateActionArg translateActionArg = new TranslateActionArg(parcel);
            AppMethodBeat.m2505o(103578);
            return translateActionArg;
        }
    }

    public TranslateActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final boolean ayg() {
        return this.f4346x == 0.0f && this.f4347y == 0.0f;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103579);
        super.mo5879i(parcel);
        this.f4346x = parcel.readFloat();
        this.f4347y = parcel.readFloat();
        AppMethodBeat.m2505o(103579);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103580);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f4346x);
        parcel.writeFloat(this.f4347y);
        AppMethodBeat.m2505o(103580);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103581);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f4346x = C42668g.m75561d(optJSONArray, 0);
        this.f4347y = C42668g.m75561d(optJSONArray, 1);
        AppMethodBeat.m2505o(103581);
    }

    static {
        AppMethodBeat.m2504i(103584);
        AppMethodBeat.m2505o(103584);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103582);
        if (this == obj) {
            AppMethodBeat.m2505o(103582);
            return true;
        } else if (!(obj instanceof TranslateActionArg)) {
            AppMethodBeat.m2505o(103582);
            return false;
        } else if (super.equals(obj)) {
            TranslateActionArg translateActionArg = (TranslateActionArg) obj;
            if (Float.compare(translateActionArg.f4346x, this.f4346x) == 0 && Float.compare(translateActionArg.f4347y, this.f4347y) == 0) {
                AppMethodBeat.m2505o(103582);
                return true;
            }
            AppMethodBeat.m2505o(103582);
            return false;
        } else {
            AppMethodBeat.m2505o(103582);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103583);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.f4346x), Float.valueOf(this.f4347y)});
        AppMethodBeat.m2505o(103583);
        return hash;
    }
}
