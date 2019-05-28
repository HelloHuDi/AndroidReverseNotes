package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo implements Parcelable {
    public static final Creator<ECardInfo> CREATOR = new Creator<ECardInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ECardInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46743);
            ECardInfo eCardInfo = new ECardInfo(parcel);
            AppMethodBeat.o(46743);
            return eCardInfo;
        }
    };
    public String cRb;
    public String cRf;
    public String cvQ;
    public int jSu;
    public String subtitle;
    public String title;
    public int tyj;
    public int tyk;
    public String tyl;
    public String tym;
    public String tyn;
    public int tyo;
    public ArrayList<String> typ = new ArrayList();
    public String tyq;
    public String tyr;
    public String tys;
    public String tyt;

    public ECardInfo() {
        AppMethodBeat.i(46744);
        AppMethodBeat.o(46744);
    }

    public ECardInfo(Parcel parcel) {
        AppMethodBeat.i(46745);
        this.jSu = parcel.readInt();
        this.cvQ = parcel.readString();
        this.tyj = parcel.readInt();
        this.tyk = parcel.readInt();
        this.tyl = parcel.readString();
        this.tym = parcel.readString();
        this.tyn = parcel.readString();
        this.tyo = parcel.readInt();
        this.title = parcel.readString();
        parcel.readStringList(this.typ);
        this.tyq = parcel.readString();
        this.tyr = parcel.readString();
        this.tys = parcel.readString();
        this.tyt = parcel.readString();
        this.cRb = parcel.readString();
        this.subtitle = parcel.readString();
        AppMethodBeat.o(46745);
    }

    static {
        AppMethodBeat.i(46750);
        AppMethodBeat.o(46750);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46746);
        parcel.writeInt(this.jSu);
        parcel.writeString(this.cvQ);
        parcel.writeInt(this.tyj);
        parcel.writeInt(this.tyk);
        parcel.writeString(this.tyl);
        parcel.writeString(this.tym);
        parcel.writeString(this.tyn);
        parcel.writeInt(this.tyo);
        parcel.writeString(this.title);
        parcel.writeStringList(this.typ);
        parcel.writeString(this.tyq);
        parcel.writeString(this.tyr);
        parcel.writeString(this.tys);
        parcel.writeString(this.tyt);
        parcel.writeString(this.cRb);
        parcel.writeString(this.subtitle);
        AppMethodBeat.o(46746);
    }

    public static void aw(JSONObject jSONObject) {
        AppMethodBeat.i(46747);
        if (jSONObject != null) {
            g.RP().Ry().set(a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, jSONObject.toString());
            AppMethodBeat.o(46747);
            return;
        }
        g.RP().Ry().set(a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, (Object) "");
        AppMethodBeat.o(46747);
    }

    public static bpt cPp() {
        AppMethodBeat.i(46748);
        String str = (String) g.RP().Ry().get(a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, null);
        if (!bo.isNullOrNil(str)) {
            try {
                bpt bpt = new bpt();
                JSONObject jSONObject = new JSONObject(str);
                bpt.vAF = jSONObject.optInt("guide_flag");
                bpt.nZa = jSONObject.optString("guide_wording");
                bpt.nZb = jSONObject.optString("left_button_wording");
                bpt.nZc = jSONObject.optString("right_button_wording");
                bpt.nZd = jSONObject.optString("upload_credit_url");
                AppMethodBeat.o(46748);
                return bpt;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ECardInfo", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46748);
        return null;
    }

    public static ECardInfo cPq() {
        AppMethodBeat.i(46749);
        String str = (String) g.RP().Ry().get(a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, null);
        if (!bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("upload_reasons");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.optString(i));
                    }
                }
                if (jSONObject.has("ecard_info")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("ecard_info");
                    ECardInfo eCardInfo = new ECardInfo();
                    eCardInfo.cRb = jSONObject.optString("guide_flag");
                    eCardInfo.title = jSONObject.optString("title");
                    eCardInfo.subtitle = jSONObject.optString(MessengerShareContentUtility.SUBTITLE);
                    eCardInfo.typ = new ArrayList(arrayList);
                    eCardInfo.tyr = jSONObject.optString("protocol_url");
                    eCardInfo.tys = jSONObject.optString("left_protocol_wording");
                    eCardInfo.tyt = jSONObject.optString("right_protocol_wording");
                    eCardInfo.tyq = jSONObject.optString("done_button_wording");
                    eCardInfo.jSu = optJSONObject.optInt("ecard_open_scene", 0);
                    eCardInfo.cvQ = optJSONObject.optString("ecard_type", "");
                    eCardInfo.tyj = optJSONObject.optInt("show_check_box", 0);
                    eCardInfo.tyk = optJSONObject.optInt("check_box_selected", 0);
                    eCardInfo.tyl = optJSONObject.optString("check_box_left_wording", "");
                    eCardInfo.tym = optJSONObject.optString("check_box_right_wording", "");
                    eCardInfo.tyn = optJSONObject.optString("check_box_url", "");
                    eCardInfo.tyo = optJSONObject.optInt("is_upload_credid", 0);
                    eCardInfo.cRf = optJSONObject.optString("upload_credit_url", "");
                    AppMethodBeat.o(46749);
                    return eCardInfo;
                }
                AppMethodBeat.o(46749);
                return null;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.ECardInfo", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46749);
        return null;
    }
}
