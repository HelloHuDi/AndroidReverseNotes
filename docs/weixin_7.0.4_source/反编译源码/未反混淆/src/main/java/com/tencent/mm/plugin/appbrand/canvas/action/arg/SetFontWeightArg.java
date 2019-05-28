package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontWeightArg extends BaseDrawActionArg {
    public static final Creator<SetFontWeightArg> CREATOR = new Creator<SetFontWeightArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontWeightArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103485);
            SetFontWeightArg setFontWeightArg = new SetFontWeightArg(parcel);
            AppMethodBeat.o(103485);
            return setFontWeightArg;
        }
    };
    public String hdi;

    public SetFontWeightArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103486);
        super.i(parcel);
        this.hdi = parcel.readString();
        AppMethodBeat.o(103486);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103487);
        super.j(jSONObject);
        this.hdi = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103487);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103488);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdi);
        AppMethodBeat.o(103488);
    }

    static {
        AppMethodBeat.i(103491);
        AppMethodBeat.o(103491);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103489);
        if (this == obj) {
            AppMethodBeat.o(103489);
            return true;
        } else if (!(obj instanceof SetFontWeightArg)) {
            AppMethodBeat.o(103489);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdi, ((SetFontWeightArg) obj).hdi);
            AppMethodBeat.o(103489);
            return equals;
        } else {
            AppMethodBeat.o(103489);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103490);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdi});
        AppMethodBeat.o(103490);
        return hash;
    }
}
