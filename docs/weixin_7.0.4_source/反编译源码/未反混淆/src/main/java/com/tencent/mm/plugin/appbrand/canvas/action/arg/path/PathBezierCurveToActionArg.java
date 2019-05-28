package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathBezierCurveToActionArg extends BasePathActionArg {
    public static final Creator<PathBezierCurveToActionArg> CREATOR = new Creator<PathBezierCurveToActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PathBezierCurveToActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103601);
            PathBezierCurveToActionArg pathBezierCurveToActionArg = new PathBezierCurveToActionArg(parcel);
            AppMethodBeat.o(103601);
            return pathBezierCurveToActionArg;
        }
    };
    public float x1;
    public float x2;
    public float x3;
    public float y1;
    public float y2;
    public float y3;

    public PathBezierCurveToActionArg(Parcel parcel) {
        super(parcel);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103602);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x1 = g.d(optJSONArray, 0);
        this.y1 = g.d(optJSONArray, 1);
        this.x2 = g.d(optJSONArray, 2);
        this.y2 = g.d(optJSONArray, 3);
        this.x3 = g.d(optJSONArray, 4);
        this.y3 = g.d(optJSONArray, 5);
        AppMethodBeat.o(103602);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103603);
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x1);
        parcel.writeFloat(this.y1);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.y2);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.y2);
        AppMethodBeat.o(103603);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103604);
        super.i(parcel);
        this.x1 = parcel.readFloat();
        this.y1 = parcel.readFloat();
        this.x2 = parcel.readFloat();
        this.y2 = parcel.readFloat();
        this.x3 = parcel.readFloat();
        this.y3 = parcel.readFloat();
        AppMethodBeat.o(103604);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103605);
        if (!super.equals(obj)) {
            AppMethodBeat.o(103605);
            return false;
        } else if (obj instanceof PathBezierCurveToActionArg) {
            PathBezierCurveToActionArg pathBezierCurveToActionArg = (PathBezierCurveToActionArg) obj;
            if (pathBezierCurveToActionArg.x1 == this.x1 && pathBezierCurveToActionArg.y1 == this.y1 && pathBezierCurveToActionArg.x2 == this.x2 && pathBezierCurveToActionArg.y2 == this.y2 && pathBezierCurveToActionArg.x3 == this.x3 && pathBezierCurveToActionArg.y3 == this.y3) {
                AppMethodBeat.o(103605);
                return true;
            }
            AppMethodBeat.o(103605);
            return false;
        } else {
            AppMethodBeat.o(103605);
            return false;
        }
    }

    static {
        AppMethodBeat.i(103606);
        AppMethodBeat.o(103606);
    }
}
