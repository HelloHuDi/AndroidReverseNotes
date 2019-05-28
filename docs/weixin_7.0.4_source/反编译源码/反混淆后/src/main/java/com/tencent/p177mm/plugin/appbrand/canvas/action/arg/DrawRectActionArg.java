package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg */
public class DrawRectActionArg extends BaseDrawActionArg {
    public static final Creator<DrawRectActionArg> CREATOR = new C191391();
    public float height;
    public float width;
    /* renamed from: x */
    public float f4344x;
    /* renamed from: y */
    public float f4345y;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg$1 */
    static class C191391 implements Creator<DrawRectActionArg> {
        C191391() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawRectActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103339);
            DrawRectActionArg drawRectActionArg = new DrawRectActionArg(parcel);
            AppMethodBeat.m2505o(103339);
            return drawRectActionArg;
        }
    }

    public DrawRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103340);
        super.mo5879i(parcel);
        this.f4344x = parcel.readFloat();
        this.f4345y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.m2505o(103340);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103341);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f4344x);
        parcel.writeFloat(this.f4345y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.m2505o(103341);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103342);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.f4344x = C42668g.m75561d(optJSONArray, 0);
        this.f4345y = C42668g.m75561d(optJSONArray, 1);
        this.width = C42668g.m75561d(optJSONArray, 2);
        this.height = C42668g.m75561d(optJSONArray, 3);
        AppMethodBeat.m2505o(103342);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103343);
        if (this == obj) {
            AppMethodBeat.m2505o(103343);
            return true;
        } else if (!(obj instanceof DrawRectActionArg)) {
            AppMethodBeat.m2505o(103343);
            return false;
        } else if (super.equals(obj)) {
            DrawRectActionArg drawRectActionArg = (DrawRectActionArg) obj;
            if (Float.compare(drawRectActionArg.f4344x, this.f4344x) == 0 && Float.compare(drawRectActionArg.f4345y, this.f4345y) == 0 && Float.compare(drawRectActionArg.width, this.width) == 0 && Float.compare(drawRectActionArg.height, this.height) == 0) {
                AppMethodBeat.m2505o(103343);
                return true;
            }
            AppMethodBeat.m2505o(103343);
            return false;
        } else {
            AppMethodBeat.m2505o(103343);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(103344);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Float.valueOf(this.f4344x), Float.valueOf(this.f4345y), Float.valueOf(this.width), Float.valueOf(this.height)});
        AppMethodBeat.m2505o(103344);
        return hash;
    }

    static {
        AppMethodBeat.m2504i(103345);
        AppMethodBeat.m2505o(103345);
    }
}
