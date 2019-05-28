package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.wallet_core.C46719b;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.n */
public final class C30860n extends C5749m {
    private int Afx = 0;
    private C30861a Afy = null;
    public boolean cNi = true;

    /* renamed from: com.tencent.mm.wallet_core.c.n$a */
    public interface C30861a {
        void cRX();
    }

    /* renamed from: aY */
    private static void m49259aY(Map<String, String> map) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(49063);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        String string = C1183p.getString(C1668a.m3383QF());
        String deviceID = C1427q.getDeviceID(C4996ah.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = C30862w.dNR().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i3 = 0;
        int i4 = 0;
        do {
            bArr[i4] = bytes[i3];
            i4++;
            i3++;
            if (i3 >= bytes.length) {
                i3 = 0;
                continue;
            }
        } while (i4 < 16);
        String str = new String(bArr);
        String ck = C4995ag.m7428ck(string + deviceID);
        String ck2 = C4995ag.m7428ck(string + ck + new String(bArr));
        C4990ab.m7416i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        C4990ab.m7417i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", string, deviceID, ck2);
        C40928b dNJ = C40928b.dNJ();
        C46719b.dNA();
        C5141c ll = C18624c.abi().mo17131ll("100369");
        if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", Integer.valueOf(i));
        if (i > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            i2 = 0;
        }
        String eJ = dNJ.mo64554eJ(ck2, i2);
        try {
            map.put("sn_salt", C18178q.encode(str));
            map.put("crt_csr", C18178q.encode(eJ));
            map.put("crt_device_id", ck);
            map.put("device_os", C7243d.eSg);
            map.put("device_name", C7243d.vxl);
            AppMethodBeat.m2505o(49063);
        } catch (Exception e) {
            AppMethodBeat.m2505o(49063);
        }
    }

    public C30860n(String str, int i, String str2) {
        AppMethodBeat.m2504i(49064);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.Afx = 1;
        C30860n.m49259aY(hashMap);
        hashMap.put("type", C18178q.encode("1"));
        hashMap.put("true_name", C18178q.encode(str2));
        hashMap.put("id_no", C18178q.encode(str));
        hashMap.put("id_type", C18178q.encode(String.valueOf(i)));
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(49064);
    }

    public C30860n(String str, String str2, C30861a c30861a, boolean z) {
        AppMethodBeat.m2504i(49065);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.cNi = z;
        this.Afx = 2;
        C30860n.m49259aY(hashMap);
        hashMap.put("type", C18178q.encode("2"));
        hashMap.put("crt_sms", C18178q.encode(str));
        hashMap.put("reqkey", C18178q.encode(str2));
        this.Afy = c30861a;
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(49065);
    }

    public C30860n(String str, String str2, String str3, C30861a c30861a, boolean z) {
        AppMethodBeat.m2504i(49066);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.Afx = 4;
        this.Afy = c30861a;
        this.cNi = z;
        C30860n.m49259aY(hashMap);
        hashMap.put("type", C18178q.encode("4"));
        hashMap.put("id_type", C18178q.encode(str));
        hashMap.put("cre_tail", C18178q.encode(str2));
        hashMap.put("reqkey", C18178q.encode(str3));
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(49066);
    }

    public final int bgI() {
        return 1580;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49067);
        C4990ab.m7417i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", Integer.valueOf(i), str);
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            C7060h.pYm.mo8378a(414, 0, 1, true);
            boolean importCert = C40928b.dNJ().importCert(optString2, optString);
            C46720ab.ato(optString2);
            if (importCert) {
                C7060h.pYm.mo8378a(414, 1, 1, true);
                C4990ab.m7416i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                C7060h.pYm.mo8378a(414, 2, 1, true);
                C4990ab.m7412e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.Afx == 1) {
                C7060h.pYm.mo8381e(13731, Integer.valueOf(3));
            } else if (this.Afx == 2) {
                C7060h.pYm.mo8381e(13731, Integer.valueOf(7));
            }
            C4990ab.m7417i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", C4995ag.m7428ck(optString), optString2);
            AppMethodBeat.m2505o(49067);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
            AppMethodBeat.m2505o(49067);
        }
    }

    /* renamed from: a */
    public final void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49068);
        C40928b.dNJ().dNK();
        if (c24144d.errCode != 0) {
            if (this.Afx == 1) {
                C7060h.pYm.mo8381e(13731, Integer.valueOf(4));
            } else if (this.Afx == 2) {
                C7060h.pYm.mo8381e(13731, Integer.valueOf(8));
            }
        }
        if (this.Afy != null && (!this.cNi || c24144d.errCode == 0)) {
            this.Afy.cRX();
        }
        AppMethodBeat.m2505o(49068);
    }

    public final boolean bXm() {
        return this.cNi;
    }
}
