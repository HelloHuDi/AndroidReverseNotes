package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetStrokeStyleActionNormalArg extends RealSetStrokeStyleActionArg {
    public static final Creator<RealSetStrokeStyleActionNormalArg> CREATOR = new Creator<RealSetStrokeStyleActionNormalArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetStrokeStyleActionNormalArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103409);
            RealSetStrokeStyleActionNormalArg realSetStrokeStyleActionNormalArg = new RealSetStrokeStyleActionNormalArg(parcel);
            AppMethodBeat.o(103409);
            return realSetStrokeStyleActionNormalArg;
        }
    };
    public int color;

    public RealSetStrokeStyleActionNormalArg(Parcel parcel) {
        super(parcel);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103411);
        super.i(parcel);
        this.color = parcel.readInt();
        AppMethodBeat.o(103411);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103412);
        if (this == obj) {
            AppMethodBeat.o(103412);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionNormalArg)) {
            AppMethodBeat.o(103412);
            return false;
        } else if (super.equals(obj)) {
            if (this.color == ((RealSetStrokeStyleActionNormalArg) obj).color) {
                AppMethodBeat.o(103412);
                return true;
            }
            AppMethodBeat.o(103412);
            return false;
        } else {
            AppMethodBeat.o(103412);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103413);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.color)});
        AppMethodBeat.o(103413);
        return hash;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103414);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.color);
        AppMethodBeat.o(103414);
    }

    public int describeContents() {
        return 0;
    }

    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(103415);
        super.f(jSONArray);
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(103415);
            return;
        }
        this.color = g.n(optJSONArray);
        AppMethodBeat.o(103415);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103416);
        super.j(jSONObject);
        AppMethodBeat.o(103416);
    }

    static {
        AppMethodBeat.i(103417);
        AppMethodBeat.o(103417);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103410);
        dVar.hcE.setColor(this.color);
        AppMethodBeat.o(103410);
        return true;
    }
}
