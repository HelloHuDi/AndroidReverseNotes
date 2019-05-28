package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C33122f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper */
public class PathActionArgWrapper extends BaseDrawActionArg {
    public static final Creator<PathActionArgWrapper> CREATOR = new C268141();
    public List<BasePathActionArg> hdv;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper$1 */
    static class C268141 implements Creator<PathActionArgWrapper> {
        C268141() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathActionArgWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(103588);
            PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper(parcel);
            AppMethodBeat.m2505o(103588);
            return pathActionArgWrapper;
        }
    }

    public PathActionArgWrapper(Parcel parcel) {
        this(parcel, (byte) 0);
    }

    private PathActionArgWrapper(Parcel parcel, byte b) {
        super(parcel);
        AppMethodBeat.m2504i(103589);
        this.hdv = new ArrayList();
        this.hdv = parcel.readArrayList(PathActionArgWrapper.class.getClassLoader());
        AppMethodBeat.m2505o(103589);
    }

    public PathActionArgWrapper() {
        AppMethodBeat.m2504i(103590);
        this.hdv = new ArrayList();
        AppMethodBeat.m2505o(103590);
    }

    public final void reset() {
        AppMethodBeat.m2504i(103591);
        super.reset();
        for (BasePathActionArg a : this.hdv) {
            C33122f.aym().mo5897a(a);
        }
        this.hdv.clear();
        AppMethodBeat.m2505o(103591);
    }

    /* renamed from: i */
    public final void mo5879i(Parcel parcel) {
        AppMethodBeat.m2504i(103592);
        super.mo5879i(parcel);
        AppMethodBeat.m2505o(103592);
    }

    /* renamed from: j */
    public final void mo5880j(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103593);
        super.mo5880j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            AppMethodBeat.m2505o(103593);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                BasePathActionArg basePathActionArg = (BasePathActionArg) C33122f.aym().mo5899yy(optJSONObject.optString(C8741b.METHOD));
                basePathActionArg.mo5880j(optJSONObject);
                this.hdv.add(basePathActionArg);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(103593);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(103594);
        if (!super.equals(obj)) {
            AppMethodBeat.m2505o(103594);
            return false;
        } else if (obj instanceof PathActionArgWrapper) {
            boolean equals = this.hdv.equals(((PathActionArgWrapper) obj).hdv);
            AppMethodBeat.m2505o(103594);
            return equals;
        } else {
            AppMethodBeat.m2505o(103594);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(103595);
        super.writeToParcel(parcel, i);
        parcel.writeList(this.hdv);
        AppMethodBeat.m2505o(103595);
    }

    static {
        AppMethodBeat.m2504i(103596);
        AppMethodBeat.m2505o(103596);
    }
}
