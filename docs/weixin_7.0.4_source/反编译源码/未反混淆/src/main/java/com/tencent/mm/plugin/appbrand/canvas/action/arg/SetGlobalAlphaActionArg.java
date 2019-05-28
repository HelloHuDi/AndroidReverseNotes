package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetGlobalAlphaActionArg extends BaseDrawActionArg {
    public static final Creator<SetGlobalAlphaActionArg> CREATOR = new Creator<SetGlobalAlphaActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetGlobalAlphaActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103492);
            SetGlobalAlphaActionArg setGlobalAlphaActionArg = new SetGlobalAlphaActionArg(parcel);
            AppMethodBeat.o(103492);
            return setGlobalAlphaActionArg;
        }
    };
    public int alpha;

    public SetGlobalAlphaActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103493);
        super.i(parcel);
        this.alpha = parcel.readInt();
        AppMethodBeat.o(103493);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103494);
        super.j(jSONObject);
        this.alpha = g.a(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.o(103494);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103495);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.alpha);
        AppMethodBeat.o(103495);
    }

    static {
        AppMethodBeat.i(103498);
        AppMethodBeat.o(103498);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103496);
        if (this == obj) {
            AppMethodBeat.o(103496);
            return true;
        } else if (!(obj instanceof SetGlobalAlphaActionArg)) {
            AppMethodBeat.o(103496);
            return false;
        } else if (super.equals(obj)) {
            if (this.alpha == ((SetGlobalAlphaActionArg) obj).alpha) {
                AppMethodBeat.o(103496);
                return true;
            }
            AppMethodBeat.o(103496);
            return false;
        } else {
            AppMethodBeat.o(103496);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103497);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.alpha)});
        AppMethodBeat.o(103497);
        return hash;
    }
}
