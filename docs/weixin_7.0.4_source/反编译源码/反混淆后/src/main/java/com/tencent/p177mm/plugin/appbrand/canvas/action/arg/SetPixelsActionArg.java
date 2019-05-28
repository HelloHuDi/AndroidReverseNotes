package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg */
public class SetPixelsActionArg extends BaseDrawActionArg {
    public static final Creator<SetPixelsActionArg> CREATOR = new C20961();
    public Bitmap bitmap = null;
    public int height;
    public int width;
    /* renamed from: x */
    public int f1243x;
    /* renamed from: y */
    public int f1244y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg$1 */
    static class C20961 implements Creator<SetPixelsActionArg> {
        C20961() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetPixelsActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103534);
            SetPixelsActionArg setPixelsActionArg = new SetPixelsActionArg(parcel);
            AppMethodBeat.m2505o(103534);
            return setPixelsActionArg;
        }
    }

    public SetPixelsActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103535);
        if (this == obj) {
            AppMethodBeat.m2505o(103535);
            return true;
        } else if (!(obj instanceof SetPixelsActionArg)) {
            AppMethodBeat.m2505o(103535);
            return false;
        } else if (super.equals(obj)) {
            SetPixelsActionArg setPixelsActionArg = (SetPixelsActionArg) obj;
            if (this.f1243x == setPixelsActionArg.f1243x && this.f1244y == setPixelsActionArg.f1244y && this.width == setPixelsActionArg.width && this.height == setPixelsActionArg.height && Objects.equals(this.bitmap, setPixelsActionArg.bitmap)) {
                AppMethodBeat.m2505o(103535);
                return true;
            }
            AppMethodBeat.m2505o(103535);
            return false;
        } else {
            AppMethodBeat.m2505o(103535);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103536);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.f1243x), Integer.valueOf(this.f1244y), Integer.valueOf(this.width), Integer.valueOf(this.height), this.bitmap});
        AppMethodBeat.m2505o(103536);
        return hash;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103537);
        super.mo5879i(parcel);
        this.f1243x = parcel.readInt();
        this.f1244y = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bitmap = (Bitmap) parcel.readParcelable(SetPixelsActionArg.class.getClassLoader());
        AppMethodBeat.m2505o(103537);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103538);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f1243x);
        parcel.writeInt(this.f1244y);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeParcelable(this.bitmap, i);
        AppMethodBeat.m2505o(103538);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103539);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f1243x = C42668g.m75554a(optJSONArray, 0);
        this.f1244y = C42668g.m75554a(optJSONArray, 1);
        this.width = C42668g.m75554a(optJSONArray, 2);
        this.height = C42668g.m75554a(optJSONArray, 3);
        try {
            this.bitmap = (Bitmap) optJSONArray.get(4);
            AppMethodBeat.m2505o(103539);
        } catch (JSONException e) {
            C45124d.printErrStackTrace("SetPixelsActionArg", e, "", new Object[0]);
            AppMethodBeat.m2505o(103539);
        }
    }

    static {
        AppMethodBeat.m2504i(103540);
        AppMethodBeat.m2505o(103540);
    }
}
