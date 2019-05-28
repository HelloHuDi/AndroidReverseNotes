package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.q.a;
import com.tencent.mm.plugin.wallet_core.model.q.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class BindCardOrder implements Parcelable {
    public static final Creator<BindCardOrder> CREATOR = new Creator<BindCardOrder>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindCardOrder[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46721);
            BindCardOrder bindCardOrder = new BindCardOrder(parcel);
            AppMethodBeat.o(46721);
            return bindCardOrder;
        }
    };
    public static int txC = 1;
    public static int txD = 2;
    public static int txE = 6;
    public int jumpType;
    public String pbn;
    private String txB = "";
    public int txF;
    public String txG = "";
    public String txH = "";
    public String txI = "";
    public String txJ = "";
    public String txK = "";
    public int txL;
    public int txM;
    public q txN;
    public a txO;
    public b txP;

    static {
        AppMethodBeat.i(46725);
        AppMethodBeat.o(46725);
    }

    protected BindCardOrder(Parcel parcel) {
        AppMethodBeat.i(46722);
        this.txB = parcel.readString();
        try {
            as(new JSONObject(this.txB));
            AppMethodBeat.o(46722);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
            AppMethodBeat.o(46722);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46723);
        parcel.writeString(this.txB);
        AppMethodBeat.o(46723);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean cPi() {
        return this.jumpType == txC && this.txO != null;
    }

    public final boolean cPj() {
        return this.jumpType == txD && this.txP != null;
    }

    public final boolean cPk() {
        return this.jumpType == txE && this.txO != null;
    }

    public final void as(JSONObject jSONObject) {
        AppMethodBeat.i(46724);
        this.txB = jSONObject == null ? "" : jSONObject.toString();
        ab.i("MicroMsg.BindCardOrder", "feed json %s", this.txB);
        try {
            this.txF = jSONObject.optInt("show_bind_succ_page", 0);
            this.txG = jSONObject.optString("bind_succ_btn_wording", "");
            this.txH = jSONObject.optString("bind_succ_remind_wording", "");
            this.jumpType = jSONObject.optInt("jump_type", 0);
            this.txK = jSONObject.optString("bind_serial");
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_info");
            this.txN = new q();
            if (optJSONObject != null) {
                this.txN.aA(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("h5_info");
            if (optJSONObject != null) {
                this.txO = new a();
                this.txO.aA(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("native_info");
            if (optJSONObject != null) {
                this.txO = new a();
                this.txO.aA(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("tinyapp_info");
            if (optJSONObject != null) {
                this.txP = new b();
                this.txP.aA(optJSONObject);
            }
            AppMethodBeat.o(46724);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
            AppMethodBeat.o(46724);
        }
    }
}
