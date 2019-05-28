package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineJoinActionArg extends BaseDrawActionArg {
    public static final Creator<SetLineJoinActionArg> CREATOR = new Creator<SetLineJoinActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetLineJoinActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103520);
            SetLineJoinActionArg setLineJoinActionArg = new SetLineJoinActionArg(parcel);
            AppMethodBeat.o(103520);
            return setLineJoinActionArg;
        }
    };
    public String hdm;

    public SetLineJoinActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103521);
        super.i(parcel);
        this.hdm = parcel.readString();
        AppMethodBeat.o(103521);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103522);
        super.j(jSONObject);
        this.hdm = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(103522);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103523);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.hdm);
        AppMethodBeat.o(103523);
    }

    static {
        AppMethodBeat.i(103526);
        AppMethodBeat.o(103526);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103524);
        if (this == obj) {
            AppMethodBeat.o(103524);
            return true;
        } else if (!(obj instanceof SetLineJoinActionArg)) {
            AppMethodBeat.o(103524);
            return false;
        } else if (super.equals(obj)) {
            boolean equals = Objects.equals(this.hdm, ((SetLineJoinActionArg) obj).hdm);
            AppMethodBeat.o(103524);
            return equals;
        } else {
            AppMethodBeat.o(103524);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103525);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.hdm});
        AppMethodBeat.o(103525);
        return hash;
    }
}
