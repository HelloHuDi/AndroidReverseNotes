package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.ab */
public final class C46720ab {
    private static C46720ab Agg;
    private int Aga = 0;
    public String Agb = "";
    public String Agc = "";
    public String Agd = "";
    public String Age = "";
    public Vector<C16076aa> Agf = new Vector();
    public String TAG = "MicroMsg.WalletDigCertManager";

    public static void ato(String str) {
        AppMethodBeat.m2504i(49093);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC, (Object) str);
        AppMethodBeat.m2505o(49093);
    }

    public static String dNY() {
        AppMethodBeat.m2504i(49094);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETDIGITAL_CERT_NO_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(49094);
        return str;
    }

    public C46720ab() {
        AppMethodBeat.m2504i(49095);
        AppMethodBeat.m2505o(49095);
    }

    public static C46720ab dNZ() {
        AppMethodBeat.m2504i(49096);
        if (Agg == null) {
            Agg = new C46720ab();
        }
        C46720ab c46720ab = Agg;
        AppMethodBeat.m2505o(49096);
        return c46720ab;
    }

    /* renamed from: aT */
    public final void mo75126aT(JSONObject jSONObject) {
        AppMethodBeat.m2504i(49098);
        JSONObject optJSONObject = jSONObject.optJSONObject("cert_info");
        if (optJSONObject == null) {
            AppMethodBeat.m2505o(49098);
            return;
        }
        this.Agf = new Vector();
        int optInt = optJSONObject.optInt("show_crt_info");
        this.Aga = optJSONObject.optInt("is_crt_install");
        this.Age = optJSONObject.optString("crt_item_logo_url");
        this.Agb = optJSONObject.optString("crt_entry_desc");
        this.Agc = optJSONObject.optString("crt_entry_title");
        this.Agd = optJSONObject.optString("crt_status_name");
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, Integer.valueOf(optInt));
        String dNY = C46720ab.dNY();
        JSONArray optJSONArray = optJSONObject.optJSONArray("crt_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    C16076aa c16076aa = new C16076aa(optJSONArray.getJSONObject(i));
                    if (c16076aa.AfZ == 0) {
                        this.Agf.add(c16076aa);
                    } else if (C5046bo.isNullOrNil(dNY)) {
                        C4990ab.m7417i(this.TAG, "drop crt list no exist local drop: %s", c16076aa.xfz);
                    } else if (c16076aa.xfz.equals(dNY)) {
                        this.Agf.add(c16076aa);
                    } else {
                        C4990ab.m7417i(this.TAG, "drop crt list %s drop: %s", dNY, c16076aa.xfz);
                    }
                } catch (Exception e) {
                    C4990ab.m7417i(this.TAG, "WalletDigCertManager error %s", e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(49098);
    }

    public final void atp(String str) {
        AppMethodBeat.m2504i(49099);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(49099);
            return;
        }
        if (str.equals(C46720ab.dNY())) {
            this.Aga = 0;
            C46720ab.ato("");
            C4990ab.m7417i(this.TAG, "clean token %s  stack %s ", str, C5046bo.dpG().toString());
            C40928b.dNJ();
            C40928b.clearCert(str);
        }
        Iterator it = this.Agf.iterator();
        if (it.hasNext()) {
            this.Agf.remove((C16076aa) it.next());
            AppMethodBeat.m2505o(49099);
            return;
        }
        AppMethodBeat.m2505o(49099);
    }

    public final boolean dOa() {
        AppMethodBeat.m2504i(49097);
        if (C5046bo.isNullOrNil(C46720ab.dNY())) {
            AppMethodBeat.m2505o(49097);
            return false;
        } else if (this.Aga > 0) {
            AppMethodBeat.m2505o(49097);
            return true;
        } else {
            AppMethodBeat.m2505o(49097);
            return false;
        }
    }
}
