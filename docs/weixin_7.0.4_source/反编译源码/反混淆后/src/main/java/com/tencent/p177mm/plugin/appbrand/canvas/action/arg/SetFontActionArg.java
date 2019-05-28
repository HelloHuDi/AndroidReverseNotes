package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontActionArg */
public class SetFontActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontActionArg> CREATOR = new C20941();
    public String name;
    public float size;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontActionArg$1 */
    static class C20941 implements Creator<SetFontActionArg> {
        C20941() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103457);
            SetFontActionArg setFontActionArg = new SetFontActionArg(parcel);
            AppMethodBeat.m2505o(103457);
            return setFontActionArg;
        }
    }

    public SetFontActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103458);
        super.mo5879i(parcel);
        this.name = parcel.readString();
        this.size = parcel.readFloat();
        AppMethodBeat.m2505o(103458);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103459);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.m2505o(103459);
            return;
        }
        this.name = optJSONArray.optString(0);
        this.size = C42668g.m75561d(optJSONArray, 1);
        AppMethodBeat.m2505o(103459);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103460);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.name);
        parcel.writeFloat(this.size);
        AppMethodBeat.m2505o(103460);
    }

    static {
        AppMethodBeat.m2504i(103463);
        AppMethodBeat.m2505o(103463);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103461);
        if (this == obj) {
            AppMethodBeat.m2505o(103461);
            return true;
        } else if (!(obj instanceof SetFontActionArg)) {
            AppMethodBeat.m2505o(103461);
            return false;
        } else if (super.equals(obj)) {
            SetFontActionArg setFontActionArg = (SetFontActionArg) obj;
            if (Float.compare(setFontActionArg.size, this.size) == 0 && Objects.equals(this.name, setFontActionArg.name)) {
                AppMethodBeat.m2505o(103461);
                return true;
            }
            AppMethodBeat.m2505o(103461);
            return false;
        } else {
            AppMethodBeat.m2505o(103461);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103462);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.name, Float.valueOf(this.size)});
        AppMethodBeat.m2505o(103462);
        return hash;
    }
}
