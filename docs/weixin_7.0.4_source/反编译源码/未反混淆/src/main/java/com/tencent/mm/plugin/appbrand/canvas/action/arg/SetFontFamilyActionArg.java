package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontFamilyActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontFamilyActionArg> CREATOR = new Creator<SetFontFamilyActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontFamilyActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103464);
            SetFontFamilyActionArg setFontFamilyActionArg = new SetFontFamilyActionArg(parcel);
            AppMethodBeat.o(103464);
            return setFontFamilyActionArg;
        }
    };
    public String bnS;

    public SetFontFamilyActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103465);
        super.i(parcel);
        this.bnS = parcel.readString();
        AppMethodBeat.o(103465);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103466);
        super.j(jSONObject);
        this.bnS = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103466);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103467);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.bnS);
        AppMethodBeat.o(103467);
    }

    static {
        AppMethodBeat.i(103470);
        AppMethodBeat.o(103470);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103468);
        if (this == obj) {
            AppMethodBeat.o(103468);
            return true;
        } else if (!(obj instanceof SetFontFamilyActionArg)) {
            AppMethodBeat.o(103468);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.bnS, ((SetFontFamilyActionArg) obj).bnS);
            AppMethodBeat.o(103468);
            return equals;
        } else {
            AppMethodBeat.o(103468);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103469);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.bnS});
        AppMethodBeat.o(103469);
        return hash;
    }
}
