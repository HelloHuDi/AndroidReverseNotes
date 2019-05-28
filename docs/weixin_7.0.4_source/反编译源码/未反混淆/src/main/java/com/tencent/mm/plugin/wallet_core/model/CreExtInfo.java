package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class CreExtInfo implements Parcelable {
    public static final Creator<CreExtInfo> CREATOR = new Creator<CreExtInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CreExtInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46729);
            CreExtInfo creExtInfo = new CreExtInfo(parcel);
            AppMethodBeat.o(46729);
            return creExtInfo;
        }
    };
    public int txT;
    public int txU;
    public int txV;
    public int txW;

    protected CreExtInfo(Parcel parcel) {
        AppMethodBeat.i(46730);
        this.txT = parcel.readInt();
        this.txU = parcel.readInt();
        this.txV = parcel.readInt();
        this.txW = parcel.readInt();
        AppMethodBeat.o(46730);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46731);
        parcel.writeInt(this.txT);
        parcel.writeInt(this.txU);
        parcel.writeInt(this.txV);
        parcel.writeInt(this.txW);
        AppMethodBeat.o(46731);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(46733);
        AppMethodBeat.o(46733);
    }

    public static CreExtInfo au(JSONObject jSONObject) {
        AppMethodBeat.i(46732);
        if (jSONObject != null) {
            CreExtInfo creExtInfo = new CreExtInfo();
            creExtInfo.txT = jSONObject.optInt("need_creid_renewal", 0);
            creExtInfo.txU = jSONObject.optInt("need_birth_date", 0);
            creExtInfo.txV = jSONObject.optInt("need_cre_expire_date", 0);
            creExtInfo.txW = jSONObject.optInt("need_show_cre_type", 0);
            AppMethodBeat.o(46732);
            return creExtInfo;
        }
        AppMethodBeat.o(46732);
        return null;
    }
}
