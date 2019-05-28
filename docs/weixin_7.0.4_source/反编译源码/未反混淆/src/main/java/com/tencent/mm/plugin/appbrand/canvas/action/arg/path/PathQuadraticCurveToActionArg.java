package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathQuadraticCurveToActionArg extends BasePathActionArg {
    public static final Creator<PathQuadraticCurveToActionArg> CREATOR = new Creator<PathQuadraticCurveToActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathQuadraticCurveToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103622);
            PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg(parcel);
            AppMethodBeat.o(103622);
            return pathQuadraticCurveToActionArg;
        }
    };
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    public PathQuadraticCurveToActionArg(Parcel parcel) {
        super(parcel);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103623);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x1 = g.d(optJSONArray, 0);
        this.y1 = g.d(optJSONArray, 1);
        this.x2 = g.d(optJSONArray, 2);
        this.y2 = g.d(optJSONArray, 3);
        AppMethodBeat.o(103623);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103624);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x1);
        parcel.writeFloat(this.y1);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.y2);
        AppMethodBeat.o(103624);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103625);
        super.i(parcel);
        this.x1 = parcel.readFloat();
        this.y1 = parcel.readFloat();
        this.x2 = parcel.readFloat();
        this.y2 = parcel.readFloat();
        AppMethodBeat.o(103625);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103626);
        if (!super.equals(obj)) {
            AppMethodBeat.o(103626);
            return false;
        } else if (obj instanceof PathQuadraticCurveToActionArg) {
            PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg) obj;
            if (pathQuadraticCurveToActionArg.x1 == this.x1 && pathQuadraticCurveToActionArg.y1 == this.y1 && pathQuadraticCurveToActionArg.x2 == this.x2 && pathQuadraticCurveToActionArg.y2 == this.y2) {
                AppMethodBeat.o(103626);
                return true;
            }
            AppMethodBeat.o(103626);
            return false;
        } else {
            AppMethodBeat.o(103626);
            return false;
        }
    }

    static {
        AppMethodBeat.i(103627);
        AppMethodBeat.o(103627);
    }
}
