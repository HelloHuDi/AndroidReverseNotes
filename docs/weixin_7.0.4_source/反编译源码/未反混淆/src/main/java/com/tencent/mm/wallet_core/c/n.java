package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends m {
    private int Afx = 0;
    private a Afy = null;
    public boolean cNi = true;

    public interface a {
        void cRX();
    }

    private static void aY(Map<String, String> map) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(49063);
        g.RQ();
        g.RN();
        String string = p.getString(com.tencent.mm.kernel.a.QF());
        String deviceID = q.getDeviceID(ah.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = w.dNR().getBytes();
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
        String ck = ag.ck(string + deviceID);
        String ck2 = ag.ck(string + ck + new String(bArr));
        ab.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        ab.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", string, deviceID, ck2);
        b dNJ = b.dNJ();
        b.dNA();
        c ll = com.tencent.mm.model.c.c.abi().ll("100369");
        if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        ab.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", Integer.valueOf(i));
        if (i > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            i2 = 0;
        }
        String eJ = dNJ.eJ(ck2, i2);
        try {
            map.put("sn_salt", com.tencent.mm.compatible.util.q.encode(str));
            map.put("crt_csr", com.tencent.mm.compatible.util.q.encode(eJ));
            map.put("crt_device_id", ck);
            map.put("device_os", d.eSg);
            map.put("device_name", d.vxl);
            AppMethodBeat.o(49063);
        } catch (Exception e) {
            AppMethodBeat.o(49063);
        }
    }

    public n(String str, int i, String str2) {
        AppMethodBeat.i(49064);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.Afx = 1;
        aY(hashMap);
        hashMap.put("type", com.tencent.mm.compatible.util.q.encode("1"));
        hashMap.put("true_name", com.tencent.mm.compatible.util.q.encode(str2));
        hashMap.put("id_no", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("id_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(i)));
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(49064);
    }

    public n(String str, String str2, a aVar, boolean z) {
        AppMethodBeat.i(49065);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.cNi = z;
        this.Afx = 2;
        aY(hashMap);
        hashMap.put("type", com.tencent.mm.compatible.util.q.encode("2"));
        hashMap.put("crt_sms", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("reqkey", com.tencent.mm.compatible.util.q.encode(str2));
        this.Afy = aVar;
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(49065);
    }

    public n(String str, String str2, String str3, a aVar, boolean z) {
        AppMethodBeat.i(49066);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.Afx = 4;
        this.Afy = aVar;
        this.cNi = z;
        aY(hashMap);
        hashMap.put("type", com.tencent.mm.compatible.util.q.encode("4"));
        hashMap.put("id_type", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("cre_tail", com.tencent.mm.compatible.util.q.encode(str2));
        hashMap.put("reqkey", com.tencent.mm.compatible.util.q.encode(str3));
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(49066);
    }

    public final int bgI() {
        return 1580;
    }

    public final int ZU() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49067);
        ab.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", Integer.valueOf(i), str);
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            h.pYm.a(414, 0, 1, true);
            boolean importCert = b.dNJ().importCert(optString2, optString);
            ab.ato(optString2);
            if (importCert) {
                h.pYm.a(414, 1, 1, true);
                ab.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                h.pYm.a(414, 2, 1, true);
                ab.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.Afx == 1) {
                h.pYm.e(13731, Integer.valueOf(3));
            } else if (this.Afx == 2) {
                h.pYm.e(13731, Integer.valueOf(7));
            }
            ab.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", ag.ck(optString), optString2);
            AppMethodBeat.o(49067);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
            AppMethodBeat.o(49067);
        }
    }

    public final void a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(49068);
        b.dNJ().dNK();
        if (dVar.errCode != 0) {
            if (this.Afx == 1) {
                h.pYm.e(13731, Integer.valueOf(4));
            } else if (this.Afx == 2) {
                h.pYm.e(13731, Integer.valueOf(8));
            }
        }
        if (this.Afy != null && (!this.cNi || dVar.errCode == 0)) {
            this.Afy.cRX();
        }
        AppMethodBeat.o(49068);
    }

    public final boolean bXm() {
        return this.cNi;
    }
}
