package com.tencent.p177mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C33120c;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C38144d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper */
public class DrawActionWrapper implements Parcelable {
    public static final Creator<DrawActionWrapper> CREATOR = new C268051();
    public BaseDrawActionArg hcP;
    public JSONObject hcQ;
    public int type;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper$1 */
    static class C268051 implements Creator<DrawActionWrapper> {
        C268051() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawActionWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103318);
            DrawActionWrapper drawActionWrapper = new DrawActionWrapper(parcel);
            AppMethodBeat.m2505o(103318);
            return drawActionWrapper;
        }
    }

    public DrawActionWrapper(Parcel parcel) {
        AppMethodBeat.m2504i(103319);
        this.type = parcel.readInt();
        switch (this.type) {
            case 1:
                try {
                    this.hcQ = new JSONObject(parcel.readString());
                    AppMethodBeat.m2505o(103319);
                    return;
                } catch (JSONException e) {
                    C45124d.printErrStackTrace("DrawActionWrapper", e, "", new Object[0]);
                    AppMethodBeat.m2505o(103319);
                    return;
                }
            case 2:
                this.hcP = (BaseDrawActionArg) parcel.readParcelable(DrawActionWrapper.class.getClassLoader());
                break;
        }
        AppMethodBeat.m2505o(103319);
    }

    public final void reset() {
        AppMethodBeat.m2504i(103320);
        if (this.hcP != null) {
            this.hcP.reset();
            C33120c.ayj().mo5897a(this.hcP);
        }
        C38144d.ayk().hdA.release(this);
        AppMethodBeat.m2505o(103320);
    }

    public final String getMethod() {
        AppMethodBeat.m2504i(103321);
        String optString;
        switch (this.type) {
            case 1:
                optString = this.hcQ.optString(C8741b.METHOD);
                AppMethodBeat.m2505o(103321);
                return optString;
            case 2:
                optString = this.hcP.method;
                AppMethodBeat.m2505o(103321);
                return optString;
            default:
                optString = "";
                AppMethodBeat.m2505o(103321);
                return optString;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(103322);
        String format = String.format("type %d ,method %s", new Object[]{Integer.valueOf(this.type), getMethod()});
        AppMethodBeat.m2505o(103322);
        return format;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103323);
        parcel.writeInt(this.type);
        switch (this.type) {
            case 1:
                parcel.writeString(this.hcQ.toString());
                AppMethodBeat.m2505o(103323);
                return;
            case 2:
                parcel.writeParcelable(this.hcP, i);
                break;
        }
        AppMethodBeat.m2505o(103323);
    }

    static {
        AppMethodBeat.m2504i(103324);
        AppMethodBeat.m2505o(103324);
    }
}
