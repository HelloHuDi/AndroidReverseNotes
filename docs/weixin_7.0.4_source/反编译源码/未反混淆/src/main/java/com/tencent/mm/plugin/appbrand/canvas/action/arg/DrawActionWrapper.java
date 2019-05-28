package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class DrawActionWrapper implements Parcelable {
    public static final Creator<DrawActionWrapper> CREATOR = new Creator<DrawActionWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawActionWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103318);
            DrawActionWrapper drawActionWrapper = new DrawActionWrapper(parcel);
            AppMethodBeat.o(103318);
            return drawActionWrapper;
        }
    };
    public BaseDrawActionArg hcP;
    public JSONObject hcQ;
    public int type;

    public DrawActionWrapper(Parcel parcel) {
        AppMethodBeat.i(103319);
        this.type = parcel.readInt();
        switch (this.type) {
            case 1:
                try {
                    this.hcQ = new JSONObject(parcel.readString());
                    AppMethodBeat.o(103319);
                    return;
                } catch (JSONException e) {
                    d.printErrStackTrace("DrawActionWrapper", e, "", new Object[0]);
                    AppMethodBeat.o(103319);
                    return;
                }
            case 2:
                this.hcP = (BaseDrawActionArg) parcel.readParcelable(DrawActionWrapper.class.getClassLoader());
                break;
        }
        AppMethodBeat.o(103319);
    }

    public final void reset() {
        AppMethodBeat.i(103320);
        if (this.hcP != null) {
            this.hcP.reset();
            c.ayj().a(this.hcP);
        }
        com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d.ayk().hdA.release(this);
        AppMethodBeat.o(103320);
    }

    public final String getMethod() {
        AppMethodBeat.i(103321);
        String optString;
        switch (this.type) {
            case 1:
                optString = this.hcQ.optString(b.METHOD);
                AppMethodBeat.o(103321);
                return optString;
            case 2:
                optString = this.hcP.method;
                AppMethodBeat.o(103321);
                return optString;
            default:
                optString = "";
                AppMethodBeat.o(103321);
                return optString;
        }
    }

    public String toString() {
        AppMethodBeat.i(103322);
        String format = String.format("type %d ,method %s", new Object[]{Integer.valueOf(this.type), getMethod()});
        AppMethodBeat.o(103322);
        return format;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103323);
        parcel.writeInt(this.type);
        switch (this.type) {
            case 1:
                parcel.writeString(this.hcQ.toString());
                AppMethodBeat.o(103323);
                return;
            case 2:
                parcel.writeParcelable(this.hcP, i);
                break;
        }
        AppMethodBeat.o(103323);
    }

    static {
        AppMethodBeat.i(103324);
        AppMethodBeat.o(103324);
    }
}
