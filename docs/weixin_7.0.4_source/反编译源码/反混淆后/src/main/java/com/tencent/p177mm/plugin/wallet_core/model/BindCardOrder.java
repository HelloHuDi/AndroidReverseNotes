package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C46368q.C14239a;
import com.tencent.p177mm.plugin.wallet_core.model.C46368q.C29638b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.BindCardOrder */
public class BindCardOrder implements Parcelable {
    public static final Creator<BindCardOrder> CREATOR = new C296261();
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
    public C46368q txN;
    public C14239a txO;
    public C29638b txP;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.BindCardOrder$1 */
    static class C296261 implements Creator<BindCardOrder> {
        C296261() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindCardOrder[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46721);
            BindCardOrder bindCardOrder = new BindCardOrder(parcel);
            AppMethodBeat.m2505o(46721);
            return bindCardOrder;
        }
    }

    static {
        AppMethodBeat.m2504i(46725);
        AppMethodBeat.m2505o(46725);
    }

    protected BindCardOrder(Parcel parcel) {
        AppMethodBeat.m2504i(46722);
        this.txB = parcel.readString();
        try {
            mo63421as(new JSONObject(this.txB));
            AppMethodBeat.m2505o(46722);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
            AppMethodBeat.m2505o(46722);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46723);
        parcel.writeString(this.txB);
        AppMethodBeat.m2505o(46723);
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

    /* renamed from: as */
    public final void mo63421as(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46724);
        this.txB = jSONObject == null ? "" : jSONObject.toString();
        C4990ab.m7417i("MicroMsg.BindCardOrder", "feed json %s", this.txB);
        try {
            this.txF = jSONObject.optInt("show_bind_succ_page", 0);
            this.txG = jSONObject.optString("bind_succ_btn_wording", "");
            this.txH = jSONObject.optString("bind_succ_remind_wording", "");
            this.jumpType = jSONObject.optInt("jump_type", 0);
            this.txK = jSONObject.optString("bind_serial");
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_info");
            this.txN = new C46368q();
            if (optJSONObject != null) {
                this.txN.mo74581aA(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("h5_info");
            if (optJSONObject != null) {
                this.txO = new C14239a();
                this.txO.mo26540aA(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("native_info");
            if (optJSONObject != null) {
                this.txO = new C14239a();
                this.txO.mo26540aA(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("tinyapp_info");
            if (optJSONObject != null) {
                this.txP = new C29638b();
                this.txP.mo47885aA(optJSONObject);
            }
            AppMethodBeat.m2505o(46724);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
            AppMethodBeat.m2505o(46724);
        }
    }
}
