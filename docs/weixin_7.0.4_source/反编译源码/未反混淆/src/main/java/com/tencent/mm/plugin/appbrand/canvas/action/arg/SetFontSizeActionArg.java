package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontSizeActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontSizeActionArg> CREATOR = new Creator<SetFontSizeActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontSizeActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103471);
            SetFontSizeActionArg setFontSizeActionArg = new SetFontSizeActionArg(parcel);
            AppMethodBeat.o(103471);
            return setFontSizeActionArg;
        }
    };
    public int size;

    public SetFontSizeActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103472);
        super.i(parcel);
        this.size = parcel.readInt();
        AppMethodBeat.o(103472);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103473);
        super.j(jSONObject);
        this.size = g.a(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.o(103473);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103474);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.size);
        AppMethodBeat.o(103474);
    }

    static {
        AppMethodBeat.i(103477);
        AppMethodBeat.o(103477);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103475);
        if (this == obj) {
            AppMethodBeat.o(103475);
            return true;
        } else if (!(obj instanceof SetFontSizeActionArg)) {
            AppMethodBeat.o(103475);
            return false;
        } else if (super.equals(obj)) {
            if (this.size == ((SetFontSizeActionArg) obj).size) {
                AppMethodBeat.o(103475);
                return true;
            }
            AppMethodBeat.o(103475);
            return false;
        } else {
            AppMethodBeat.o(103475);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103476);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.size)});
        AppMethodBeat.o(103476);
        return hash;
    }
}
