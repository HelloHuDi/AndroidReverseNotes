package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontStyleActionArg extends BaseDrawActionArg {
    public static final Creator<SetFontStyleActionArg> CREATOR = new Creator<SetFontStyleActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetFontStyleActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103478);
            SetFontStyleActionArg setFontStyleActionArg = new SetFontStyleActionArg(parcel);
            AppMethodBeat.o(103478);
            return setFontStyleActionArg;
        }
    };
    public String hdh;

    public SetFontStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103479);
        super.i(parcel);
        this.hdh = parcel.readString();
        AppMethodBeat.o(103479);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103480);
        super.j(jSONObject);
        this.hdh = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103480);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103481);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdh);
        AppMethodBeat.o(103481);
    }

    static {
        AppMethodBeat.i(103484);
        AppMethodBeat.o(103484);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103482);
        if (this == obj) {
            AppMethodBeat.o(103482);
            return true;
        } else if (!(obj instanceof SetFontStyleActionArg)) {
            AppMethodBeat.o(103482);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdh, ((SetFontStyleActionArg) obj).hdh);
            AppMethodBeat.o(103482);
            return equals;
        } else {
            AppMethodBeat.o(103482);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103483);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdh});
        AppMethodBeat.o(103483);
        return hash;
    }
}
