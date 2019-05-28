package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetPixelsActionArg extends BaseDrawActionArg {
    public static final Creator<SetPixelsActionArg> CREATOR = new Creator<SetPixelsActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetPixelsActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103534);
            SetPixelsActionArg setPixelsActionArg = new SetPixelsActionArg(parcel);
            AppMethodBeat.o(103534);
            return setPixelsActionArg;
        }
    };
    public Bitmap bitmap = null;
    public int height;
    public int width;
    public int x;
    public int y;

    public SetPixelsActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103535);
        if (this == obj) {
            AppMethodBeat.o(103535);
            return true;
        } else if (!(obj instanceof SetPixelsActionArg)) {
            AppMethodBeat.o(103535);
            return false;
        } else if (super.equals(obj)) {
            SetPixelsActionArg setPixelsActionArg = (SetPixelsActionArg) obj;
            if (this.x == setPixelsActionArg.x && this.y == setPixelsActionArg.y && this.width == setPixelsActionArg.width && this.height == setPixelsActionArg.height && Objects.equals(this.bitmap, setPixelsActionArg.bitmap)) {
                AppMethodBeat.o(103535);
                return true;
            }
            AppMethodBeat.o(103535);
            return false;
        } else {
            AppMethodBeat.o(103535);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103536);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.width), Integer.valueOf(this.height), this.bitmap});
        AppMethodBeat.o(103536);
        return hash;
    }

    public int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103537);
        super.i(parcel);
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bitmap = (Bitmap) parcel.readParcelable(SetPixelsActionArg.class.getClassLoader());
        AppMethodBeat.o(103537);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103538);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeParcelable(this.bitmap, i);
        AppMethodBeat.o(103538);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103539);
        super.j(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.a(optJSONArray, 0);
        this.y = g.a(optJSONArray, 1);
        this.width = g.a(optJSONArray, 2);
        this.height = g.a(optJSONArray, 3);
        try {
            this.bitmap = (Bitmap) optJSONArray.get(4);
            AppMethodBeat.o(103539);
        } catch (JSONException e) {
            d.printErrStackTrace("SetPixelsActionArg", e, "", new Object[0]);
            AppMethodBeat.o(103539);
        }
    }

    static {
        AppMethodBeat.i(103540);
        AppMethodBeat.o(103540);
    }
}
