package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ab {
    private static ab Agg;
    private int Aga = 0;
    public String Agb = "";
    public String Agc = "";
    public String Agd = "";
    public String Age = "";
    public Vector<aa> Agf = new Vector();
    public String TAG = "MicroMsg.WalletDigCertManager";

    public static void ato(String str) {
        AppMethodBeat.i(49093);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC, (Object) str);
        AppMethodBeat.o(49093);
    }

    public static String dNY() {
        AppMethodBeat.i(49094);
        g.RQ();
        String str = (String) g.RP().Ry().get(a.USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC, (Object) "");
        AppMethodBeat.o(49094);
        return str;
    }

    public ab() {
        AppMethodBeat.i(49095);
        AppMethodBeat.o(49095);
    }

    public static ab dNZ() {
        AppMethodBeat.i(49096);
        if (Agg == null) {
            Agg = new ab();
        }
        ab abVar = Agg;
        AppMethodBeat.o(49096);
        return abVar;
    }

    public final void aT(JSONObject jSONObject) {
        AppMethodBeat.i(49098);
        JSONObject optJSONObject = jSONObject.optJSONObject("cert_info");
        if (optJSONObject == null) {
            AppMethodBeat.o(49098);
            return;
        }
        this.Agf = new Vector();
        int optInt = optJSONObject.optInt("show_crt_info");
        this.Aga = optJSONObject.optInt("is_crt_install");
        this.Age = optJSONObject.optString("crt_item_logo_url");
        this.Agb = optJSONObject.optString("crt_entry_desc");
        this.Agc = optJSONObject.optString("crt_entry_title");
        this.Agd = optJSONObject.optString("crt_status_name");
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, Integer.valueOf(optInt));
        String dNY = dNY();
        JSONArray optJSONArray = optJSONObject.optJSONArray("crt_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    aa aaVar = new aa(optJSONArray.getJSONObject(i));
                    if (aaVar.AfZ == 0) {
                        this.Agf.add(aaVar);
                    } else if (bo.isNullOrNil(dNY)) {
                        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "drop crt list no exist local drop: %s", aaVar.xfz);
                    } else if (aaVar.xfz.equals(dNY)) {
                        this.Agf.add(aaVar);
                    } else {
                        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "drop crt list %s drop: %s", dNY, aaVar.xfz);
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "WalletDigCertManager error %s", e.getMessage());
                }
            }
        }
        AppMethodBeat.o(49098);
    }

    public final void atp(String str) {
        AppMethodBeat.i(49099);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(49099);
            return;
        }
        if (str.equals(dNY())) {
            this.Aga = 0;
            ato("");
            com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "clean token %s  stack %s ", str, bo.dpG().toString());
            b.dNJ();
            b.clearCert(str);
        }
        Iterator it = this.Agf.iterator();
        if (it.hasNext()) {
            this.Agf.remove((aa) it.next());
            AppMethodBeat.o(49099);
            return;
        }
        AppMethodBeat.o(49099);
    }

    public final boolean dOa() {
        AppMethodBeat.i(49097);
        if (bo.isNullOrNil(dNY())) {
            AppMethodBeat.o(49097);
            return false;
        } else if (this.Aga > 0) {
            AppMethodBeat.o(49097);
            return true;
        } else {
            AppMethodBeat.o(49097);
            return false;
        }
    }
}
