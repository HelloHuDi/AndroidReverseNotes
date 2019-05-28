package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private static a oTo = null;
    private Set<String> oTp;
    public d oTq = null;

    public static a bVz() {
        AppMethodBeat.i(23029);
        if (oTo == null) {
            oTo = new a();
        }
        a aVar = oTo;
        AppMethodBeat.o(23029);
        return aVar;
    }

    public final boolean a(Tag tag) {
        AppMethodBeat.i(23030);
        super.a(tag);
        this.oTp = new HashSet();
        for (Object obj : tag.getTechList()) {
            ab.d("MicroMsg.ApduEngine", "[NFC]tech : ".concat(String.valueOf(obj)));
            this.oTp.add(obj);
        }
        try {
            if (this.oTq != null && this.oTq.isConnected()) {
                this.oTq.close();
            }
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.ApduEngine", e, "", new Object[0]);
            ab.e("MicroMsg.ApduEngine", e.toString());
        }
        if (this.oTp.contains(IsoDep.class.getName())) {
            this.oTq = new b(tag);
            AppMethodBeat.o(23030);
            return true;
        } else if (this.oTp.contains(NfcA.class.getName())) {
            this.oTq = new c(tag);
            AppMethodBeat.o(23030);
            return true;
        } else {
            ab.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
            AppMethodBeat.o(23030);
            return false;
        }
    }

    public final c a(com.tencent.mm.plugin.nfc.a.a aVar) {
        AppMethodBeat.i(23031);
        com.tencent.mm.plugin.nfc.b.a aVar2 = new com.tencent.mm.plugin.nfc.b.a(1, "def", aVar);
        a(aVar2);
        c cVar = aVar2.oTl;
        AppMethodBeat.o(23031);
        return cVar;
    }

    private boolean a(com.tencent.mm.plugin.nfc.b.a aVar) {
        AppMethodBeat.i(23032);
        if (this.oTq == null) {
            ab.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
            IllegalStateException illegalStateException = new IllegalStateException("ApduEngine not ready !");
            AppMethodBeat.o(23032);
            throw illegalStateException;
        } else if (aVar == null || aVar.oTk == null) {
            ab.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu is null !");
            AppMethodBeat.o(23032);
            throw illegalArgumentException;
        } else {
            ab.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] do cmd : " + aVar.oTk.toString());
            aVar.oTl = b(aVar.oTk);
            if (aVar.oTl.bVy()) {
                ab.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> OK : " + aVar.oTl.toString());
                AppMethodBeat.o(23032);
                return true;
            }
            ab.e("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> fail : " + aVar.oTl.toString());
            AppMethodBeat.o(23032);
            return false;
        }
    }

    private c b(com.tencent.mm.plugin.nfc.a.a aVar) {
        AppMethodBeat.i(23033);
        c a = this.oTq.a(aVar);
        AppMethodBeat.o(23033);
        return a;
    }

    public final boolean a(List<com.tencent.mm.plugin.nfc.b.a> list, boolean z, boolean z2) {
        AppMethodBeat.i(23034);
        for (com.tencent.mm.plugin.nfc.b.a a : list) {
            boolean a2 = a(a);
            if (!a2 && z) {
                AppMethodBeat.o(23034);
                return false;
            } else if (a2 && z2) {
                AppMethodBeat.o(23034);
                return false;
            }
        }
        AppMethodBeat.o(23034);
        return true;
    }

    public final int eF(Context context) {
        AppMethodBeat.i(23035);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            ab.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
            AppMethodBeat.o(23035);
            return 0;
        } else if (!defaultAdapter.isEnabled()) {
            AppMethodBeat.o(23035);
            return 1;
        } else if (this.oTq == null) {
            AppMethodBeat.o(23035);
            return 4;
        } else {
            try {
                if (this.oTq == null || !this.oTq.isConnected()) {
                    AppMethodBeat.o(23035);
                    return 2;
                }
                AppMethodBeat.o(23035);
                return 3;
            } catch (IOException e) {
                ab.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                AppMethodBeat.o(23035);
                return 2;
            }
        }
    }

    public final int eG(Context context) {
        AppMethodBeat.i(23036);
        int eF = eF(context);
        if (eF == 3 || eF == 2) {
            try {
                if (this.oTq != null) {
                    this.oTq.connect();
                    if (this.oTq.isConnected()) {
                        AppMethodBeat.o(23036);
                        return 3;
                    }
                }
                AppMethodBeat.o(23036);
                return 2;
            } catch (IOException e) {
                ab.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                AppMethodBeat.o(23036);
                return 2;
            }
        }
        AppMethodBeat.o(23036);
        return eF;
    }

    public final String getInfo() {
        AppMethodBeat.i(23037);
        if (this.oTm == null) {
            ab.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
            AppMethodBeat.o(23037);
            return null;
        }
        String jSONObject;
        long anU = bo.anU();
        JSONObject jSONObject2 = new JSONObject();
        ab.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.oTp.size());
        for (String jSONObject3 : this.oTp) {
            ab.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = ".concat(String.valueOf(jSONObject3)));
            try {
                Object obj;
                if (jSONObject3.equals(NfcA.class.getName())) {
                    NfcA nfcA = NfcA.get(this.oTm);
                    if (nfcA == null) {
                        ab.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
                        obj = null;
                    } else {
                        obj = new JSONObject();
                        obj.put("atqa", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(nfcA.getAtqa()));
                        obj.put("sak", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.b(nfcA.getSak())));
                    }
                    jSONObject2.put(NfcA.class.getSimpleName(), obj);
                } else if (jSONObject3.equals(IsoDep.class.getName())) {
                    IsoDep isoDep = IsoDep.get(this.oTm);
                    if (isoDep == null) {
                        ab.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
                        obj = null;
                    } else {
                        obj = new JSONObject();
                        obj.put("hiLayerResponse", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(isoDep.getHiLayerResponse()));
                        obj.put("historicalBytes", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(isoDep.getHistoricalBytes()));
                    }
                    jSONObject2.put(IsoDep.class.getSimpleName(), obj);
                }
            } catch (JSONException e) {
                ab.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + e.getLocalizedMessage());
                jSONObject3 = jSONObject2.toString();
                AppMethodBeat.o(23037);
                return jSONObject3;
            }
        }
        ab.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (bo.anU() - anU));
        ab.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + jSONObject2.toString());
        jSONObject3 = jSONObject2.toString();
        AppMethodBeat.o(23037);
        return jSONObject3;
    }
}
