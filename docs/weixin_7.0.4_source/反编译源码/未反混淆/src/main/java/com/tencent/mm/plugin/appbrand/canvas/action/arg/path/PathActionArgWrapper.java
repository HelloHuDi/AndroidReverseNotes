package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathActionArgWrapper extends BaseDrawActionArg {
    public static final Creator<PathActionArgWrapper> CREATOR = new Creator<PathActionArgWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathActionArgWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103588);
            PathActionArgWrapper pathActionArgWrapper = new PathActionArgWrapper(parcel);
            AppMethodBeat.o(103588);
            return pathActionArgWrapper;
        }
    };
    public List<BasePathActionArg> hdv;

    public PathActionArgWrapper(Parcel parcel) {
        this(parcel, (byte) 0);
    }

    private PathActionArgWrapper(Parcel parcel, byte b) {
        super(parcel);
        AppMethodBeat.i(103589);
        this.hdv = new ArrayList();
        this.hdv = parcel.readArrayList(PathActionArgWrapper.class.getClassLoader());
        AppMethodBeat.o(103589);
    }

    public PathActionArgWrapper() {
        AppMethodBeat.i(103590);
        this.hdv = new ArrayList();
        AppMethodBeat.o(103590);
    }

    public final void reset() {
        AppMethodBeat.i(103591);
        super.reset();
        for (BasePathActionArg a : this.hdv) {
            f.aym().a(a);
        }
        this.hdv.clear();
        AppMethodBeat.o(103591);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103592);
        super.i(parcel);
        AppMethodBeat.o(103592);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103593);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            AppMethodBeat.o(103593);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                BasePathActionArg basePathActionArg = (BasePathActionArg) f.aym().yy(optJSONObject.optString(b.METHOD));
                basePathActionArg.j(optJSONObject);
                this.hdv.add(basePathActionArg);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(103593);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103594);
        if (!super.equals(obj)) {
            AppMethodBeat.o(103594);
            return false;
        } else if (obj instanceof PathActionArgWrapper) {
            boolean equals = this.hdv.equals(((PathActionArgWrapper) obj).hdv);
            AppMethodBeat.o(103594);
            return equals;
        } else {
            AppMethodBeat.o(103594);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103595);
        super.writeToParcel(parcel, i);
        parcel.writeList(this.hdv);
        AppMethodBeat.o(103595);
    }

    static {
        AppMethodBeat.i(103596);
        AppMethodBeat.o(103596);
    }
}
