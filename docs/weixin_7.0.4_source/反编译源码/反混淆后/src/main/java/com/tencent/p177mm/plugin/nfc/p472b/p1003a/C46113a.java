package com.tencent.p177mm.plugin.nfc.p472b.p1003a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.nfc.p1002a.C12714c;
import com.tencent.p177mm.plugin.nfc.p1002a.C34621a;
import com.tencent.p177mm.plugin.nfc.p1004c.C12717a;
import com.tencent.p177mm.plugin.nfc.p472b.C12716b;
import com.tencent.p177mm.plugin.nfc.p472b.C3552a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.nfc.b.a.a */
public final class C46113a extends C12716b {
    private static C46113a oTo = null;
    private Set<String> oTp;
    public C12715d oTq = null;

    public static C46113a bVz() {
        AppMethodBeat.m2504i(23029);
        if (oTo == null) {
            oTo = new C46113a();
        }
        C46113a c46113a = oTo;
        AppMethodBeat.m2505o(23029);
        return c46113a;
    }

    /* renamed from: a */
    public final boolean mo24725a(Tag tag) {
        AppMethodBeat.m2504i(23030);
        super.mo24725a(tag);
        this.oTp = new HashSet();
        for (Object obj : tag.getTechList()) {
            C4990ab.m7410d("MicroMsg.ApduEngine", "[NFC]tech : ".concat(String.valueOf(obj)));
            this.oTp.add(obj);
        }
        try {
            if (this.oTq != null && this.oTq.isConnected()) {
                this.oTq.close();
            }
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.ApduEngine", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.ApduEngine", e.toString());
        }
        if (this.oTp.contains(IsoDep.class.getName())) {
            this.oTq = new C34622b(tag);
            AppMethodBeat.m2505o(23030);
            return true;
        } else if (this.oTp.contains(NfcA.class.getName())) {
            this.oTq = new C34623c(tag);
            AppMethodBeat.m2505o(23030);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
            AppMethodBeat.m2505o(23030);
            return false;
        }
    }

    /* renamed from: a */
    public final C12714c mo74057a(C34621a c34621a) {
        AppMethodBeat.m2504i(23031);
        C3552a c3552a = new C3552a(1, "def", c34621a);
        m86055a(c3552a);
        C12714c c12714c = c3552a.oTl;
        AppMethodBeat.m2505o(23031);
        return c12714c;
    }

    /* renamed from: a */
    private boolean m86055a(C3552a c3552a) {
        AppMethodBeat.m2504i(23032);
        if (this.oTq == null) {
            C4990ab.m7412e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
            IllegalStateException illegalStateException = new IllegalStateException("ApduEngine not ready !");
            AppMethodBeat.m2505o(23032);
            throw illegalStateException;
        } else if (c3552a == null || c3552a.oTk == null) {
            C4990ab.m7412e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu is null !");
            AppMethodBeat.m2505o(23032);
            throw illegalArgumentException;
        } else {
            C4990ab.m7416i("MicroMsg.ApduEngine", "[NFC][" + c3552a.name + "] do cmd : " + c3552a.oTk.toString());
            c3552a.oTl = m86056b(c3552a.oTk);
            if (c3552a.oTl.bVy()) {
                C4990ab.m7416i("MicroMsg.ApduEngine", "[NFC][" + c3552a.name + "] result==> OK : " + c3552a.oTl.toString());
                AppMethodBeat.m2505o(23032);
                return true;
            }
            C4990ab.m7412e("MicroMsg.ApduEngine", "[NFC][" + c3552a.name + "] result==> fail : " + c3552a.oTl.toString());
            AppMethodBeat.m2505o(23032);
            return false;
        }
    }

    /* renamed from: b */
    private C12714c m86056b(C34621a c34621a) {
        AppMethodBeat.m2504i(23033);
        C12714c a = this.oTq.mo24720a(c34621a);
        AppMethodBeat.m2505o(23033);
        return a;
    }

    /* renamed from: a */
    public final boolean mo74058a(List<C3552a> list, boolean z, boolean z2) {
        AppMethodBeat.m2504i(23034);
        for (C3552a a : list) {
            boolean a2 = m86055a(a);
            if (!a2 && z) {
                AppMethodBeat.m2505o(23034);
                return false;
            } else if (a2 && z2) {
                AppMethodBeat.m2505o(23034);
                return false;
            }
        }
        AppMethodBeat.m2505o(23034);
        return true;
    }

    /* renamed from: eF */
    public final int mo74059eF(Context context) {
        AppMethodBeat.m2504i(23035);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            C4990ab.m7416i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
            AppMethodBeat.m2505o(23035);
            return 0;
        } else if (!defaultAdapter.isEnabled()) {
            AppMethodBeat.m2505o(23035);
            return 1;
        } else if (this.oTq == null) {
            AppMethodBeat.m2505o(23035);
            return 4;
        } else {
            try {
                if (this.oTq == null || !this.oTq.isConnected()) {
                    AppMethodBeat.m2505o(23035);
                    return 2;
                }
                AppMethodBeat.m2505o(23035);
                return 3;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                AppMethodBeat.m2505o(23035);
                return 2;
            }
        }
    }

    /* renamed from: eG */
    public final int mo74060eG(Context context) {
        AppMethodBeat.m2504i(23036);
        int eF = mo74059eF(context);
        if (eF == 3 || eF == 2) {
            try {
                if (this.oTq != null) {
                    this.oTq.connect();
                    if (this.oTq.isConnected()) {
                        AppMethodBeat.m2505o(23036);
                        return 3;
                    }
                }
                AppMethodBeat.m2505o(23036);
                return 2;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                AppMethodBeat.m2505o(23036);
                return 2;
            }
        }
        AppMethodBeat.m2505o(23036);
        return eF;
    }

    public final String getInfo() {
        AppMethodBeat.m2504i(23037);
        if (this.oTm == null) {
            C4990ab.m7420w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
            AppMethodBeat.m2505o(23037);
            return null;
        }
        String jSONObject;
        long anU = C5046bo.anU();
        JSONObject jSONObject2 = new JSONObject();
        C4990ab.m7410d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.oTp.size());
        for (String jSONObject3 : this.oTp) {
            C4990ab.m7410d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = ".concat(String.valueOf(jSONObject3)));
            try {
                Object obj;
                if (jSONObject3.equals(NfcA.class.getName())) {
                    NfcA nfcA = NfcA.get(this.oTm);
                    if (nfcA == null) {
                        C4990ab.m7420w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
                        obj = null;
                    } else {
                        obj = new JSONObject();
                        obj.put("atqa", C12717a.byteArrayToHexString(nfcA.getAtqa()));
                        obj.put("sak", C12717a.byteArrayToHexString(C12717a.m20733b(nfcA.getSak())));
                    }
                    jSONObject2.put(NfcA.class.getSimpleName(), obj);
                } else if (jSONObject3.equals(IsoDep.class.getName())) {
                    IsoDep isoDep = IsoDep.get(this.oTm);
                    if (isoDep == null) {
                        C4990ab.m7420w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
                        obj = null;
                    } else {
                        obj = new JSONObject();
                        obj.put("hiLayerResponse", C12717a.byteArrayToHexString(isoDep.getHiLayerResponse()));
                        obj.put("historicalBytes", C12717a.byteArrayToHexString(isoDep.getHistoricalBytes()));
                    }
                    jSONObject2.put(IsoDep.class.getSimpleName(), obj);
                }
            } catch (JSONException e) {
                C4990ab.m7420w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + e.getLocalizedMessage());
                jSONObject3 = jSONObject2.toString();
                AppMethodBeat.m2505o(23037);
                return jSONObject3;
            }
        }
        C4990ab.m7418v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (C5046bo.anU() - anU));
        C4990ab.m7418v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + jSONObject2.toString());
        jSONObject3 = jSONObject2.toString();
        AppMethodBeat.m2505o(23037);
        return jSONObject3;
    }
}
