package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg extends BaseDrawActionArg {
    public static final Creator<DrawImageActionArg> CREATOR = new Creator<DrawImageActionArg>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrawImageActionArg[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103332);
            DrawImageActionArg drawImageActionArg = new DrawImageActionArg(parcel);
            AppMethodBeat.o(103332);
            return drawImageActionArg;
        }
    };
    public int aIJ;
    public int aIK;
    public int hcT;
    public int hcU;
    public int hcV;
    public float height;
    public String url;
    public float width;
    public float x;
    public float y;

    public DrawImageActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public final void i(Parcel parcel) {
        AppMethodBeat.i(103333);
        super.i(parcel);
        this.hcT = parcel.readInt();
        this.url = parcel.readString();
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        this.hcU = parcel.readInt();
        this.hcV = parcel.readInt();
        this.aIJ = parcel.readInt();
        this.aIK = parcel.readInt();
        AppMethodBeat.o(103333);
    }

    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(103334);
        super.j(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            this.hcT = optJSONArray.length();
            this.url = optJSONArray.optString(0);
            this.x = g.d(optJSONArray, 1);
            this.y = g.d(optJSONArray, 2);
            this.width = g.d(optJSONArray, 3);
            this.height = g.d(optJSONArray, 4);
            this.hcU = optJSONArray.optInt(5);
            this.hcV = optJSONArray.optInt(6);
            this.aIJ = optJSONArray.optInt(7);
            this.aIK = optJSONArray.optInt(8);
            AppMethodBeat.o(103334);
        } catch (Exception e) {
            d.printErrStackTrace("DrawImageActionArg", e, "", new Object[0]);
            AppMethodBeat.o(103334);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(103335);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.hcT);
        parcel.writeString(this.url);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeInt(this.hcU);
        parcel.writeInt(this.hcV);
        parcel.writeInt(this.aIJ);
        parcel.writeInt(this.aIK);
        AppMethodBeat.o(103335);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(103336);
        if (this == obj) {
            AppMethodBeat.o(103336);
            return true;
        } else if (!(obj instanceof DrawImageActionArg)) {
            AppMethodBeat.o(103336);
            return false;
        } else if (super.equals(obj)) {
            DrawImageActionArg drawImageActionArg = (DrawImageActionArg) obj;
            if (this.hcT == drawImageActionArg.hcT && Float.compare(drawImageActionArg.x, this.x) == 0 && Float.compare(drawImageActionArg.y, this.y) == 0 && Float.compare(drawImageActionArg.width, this.width) == 0 && Float.compare(drawImageActionArg.height, this.height) == 0 && this.hcU == drawImageActionArg.hcU && this.hcV == drawImageActionArg.hcV && this.aIJ == drawImageActionArg.aIJ && this.aIK == drawImageActionArg.aIK && Objects.equals(this.url, drawImageActionArg.url)) {
                AppMethodBeat.o(103336);
                return true;
            }
            AppMethodBeat.o(103336);
            return false;
        } else {
            AppMethodBeat.o(103336);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(103337);
        int hash = Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.hcT), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.hcU), Integer.valueOf(this.hcV), Integer.valueOf(this.aIJ), Integer.valueOf(this.aIK)});
        AppMethodBeat.o(103337);
        return hash;
    }

    static {
        AppMethodBeat.i(103338);
        AppMethodBeat.o(103338);
    }
}
