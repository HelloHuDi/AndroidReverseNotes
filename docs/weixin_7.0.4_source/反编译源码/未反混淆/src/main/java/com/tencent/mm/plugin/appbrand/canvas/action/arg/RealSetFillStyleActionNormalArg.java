package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionNormalArg extends RealSetFillStyleActionArg {
    public static final Creator<RealSetFillStyleActionNormalArg> CREATOR = new Creator<RealSetFillStyleActionNormalArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealSetFillStyleActionNormalArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103371);
            RealSetFillStyleActionNormalArg realSetFillStyleActionNormalArg = new RealSetFillStyleActionNormalArg(parcel);
            AppMethodBeat.o(103371);
            return realSetFillStyleActionNormalArg;
        }
    };
    public int color;

    public RealSetFillStyleActionNormalArg(Parcel parcel) {
        super(parcel);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103373);
        super.i(parcel);
        this.color = parcel.readInt();
        AppMethodBeat.o(103373);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103374);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.color);
        AppMethodBeat.o(103374);
    }

    public int describeContents() {
        return 0;
    }

    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(103375);
        super.f(jSONArray);
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(103375);
            return;
        }
        this.color = g.n(optJSONArray);
        AppMethodBeat.o(103375);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103376);
        if (this == obj) {
            AppMethodBeat.o(103376);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionNormalArg)) {
            AppMethodBeat.o(103376);
            return false;
        } else if (super.equals(obj)) {
            if (this.color == ((RealSetFillStyleActionNormalArg) obj).color) {
                AppMethodBeat.o(103376);
                return true;
            }
            AppMethodBeat.o(103376);
            return false;
        } else {
            AppMethodBeat.o(103376);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103377);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.color)});
        AppMethodBeat.o(103377);
        return hash;
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103378);
        super.j(jSONObject);
        AppMethodBeat.o(103378);
    }

    static {
        AppMethodBeat.i(103379);
        AppMethodBeat.o(103379);
    }

    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(103372);
        a aVar = dVar.hcF;
        aVar.setShader(null);
        aVar.setColor(this.color);
        AppMethodBeat.o(103372);
        return true;
    }
}
