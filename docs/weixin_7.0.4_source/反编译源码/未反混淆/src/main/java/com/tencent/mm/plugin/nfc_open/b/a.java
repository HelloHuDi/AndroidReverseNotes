package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements f {
    public bel oTw;

    public a() {
        AppMethodBeat.i(23063);
        init();
        AppMethodBeat.o(23063);
    }

    private void init() {
        AppMethodBeat.i(23064);
        this.oTw = new bel();
        aw.ZK();
        String valueOf = String.valueOf(c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null));
        if (bo.isNullOrNil(valueOf)) {
            this.oTw.wbW = new LinkedList();
            this.oTw.lastUpdateTime = 0;
            this.oTw.wbX = 86400;
            this.oTw.version = 0;
            AppMethodBeat.o(23064);
            return;
        }
        try {
            this.oTw.parseFrom(valueOf.getBytes("ISO-8859-1"));
            AppMethodBeat.o(23064);
        } catch (Exception e) {
            ab.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.oTw.wbW = new LinkedList();
            this.oTw.lastUpdateTime = 0;
            this.oTw.wbX = 86400;
            this.oTw.version = 0;
            AppMethodBeat.o(23064);
        }
    }

    private void a(bel bel) {
        AppMethodBeat.i(23065);
        if (aw.RK()) {
            if (bel != null) {
                ab.i("MicroMsg.CpuCardConfigManager", "setConfig config");
                this.oTw = bel;
                try {
                    Object str = new String(this.oTw.toByteArray(), "ISO-8859-1");
                    aw.ZK();
                    c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, str);
                    AppMethodBeat.o(23065);
                    return;
                } catch (UnsupportedEncodingException e) {
                    ab.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
                    AppMethodBeat.o(23065);
                    return;
                } catch (IOException e2) {
                    ab.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
                }
            }
            AppMethodBeat.o(23065);
            return;
        }
        ab.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        AppMethodBeat.o(23065);
    }

    private bel bVC() {
        AppMethodBeat.i(23066);
        if (this.oTw == null) {
            init();
        }
        bel bel = this.oTw;
        AppMethodBeat.o(23066);
        return bel;
    }

    public final boolean bGv() {
        int i = 1800;
        AppMethodBeat.i(23067);
        try {
            if (NfcAdapter.getDefaultAdapter(ah.getContext()) == null) {
                ab.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
                AppMethodBeat.o(23067);
                return false;
            }
            if (this.oTw != null) {
                int i2 = this.oTw.wbX;
                if (i2 >= 1800) {
                    if (i2 > 604800) {
                        i = 604800;
                    } else {
                        i = i2;
                    }
                }
                ab.i("MicroMsg.CpuCardConfigManager", "now=" + bo.anT() + ", lastUpdateTime=" + this.oTw.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.oTw.wbX);
                if (bo.anT() - this.oTw.lastUpdateTime > ((long) i)) {
                    AppMethodBeat.o(23067);
                    return true;
                }
            }
            AppMethodBeat.o(23067);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CpuCardConfigManager", e, "", new Object[0]);
            AppMethodBeat.o(23067);
            return false;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(23068);
        aw.Rg().b(1561, (f) this);
        if (mVar instanceof b) {
            bel bVC = bVC();
            bVC.lastUpdateTime = bo.anT();
            if (i == 0 && i2 == 0) {
                uk ukVar = (uk) ((b) mVar).ehh.fsH.fsP;
                if (ukVar != null) {
                    bVC.wbX = ukVar.wbX;
                    bVC.wbY = ukVar.wbY;
                    aw.ZK();
                    if (((Integer) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        if (ukVar.wbY == 1) {
                            ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    aw.ZK();
                    c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(ukVar.wbY));
                    aw.ZK();
                    c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, ukVar.tuB);
                    if (bVC.version != ukVar.version) {
                        bVC.version = ukVar.version;
                        if (ukVar.wbW != null && !ukVar.wbW.isEmpty()) {
                            if (bVC.wbW == null) {
                                bVC.wbW = new LinkedList();
                            } else {
                                bVC.wbW.clear();
                            }
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= ukVar.wbW.size()) {
                                    break;
                                }
                                nn nnVar = new nn();
                                nnVar.vzX = ((nn) ukVar.wbW.get(i4)).vzX;
                                nnVar.vRS = ((nn) ukVar.wbW.get(i4)).vRS;
                                ab.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bo.h(Integer.valueOf(nnVar.vRS)) + ", url=" + bo.nullAsNil(nnVar.vzX));
                                if (nnVar.vRR == null) {
                                    nnVar.vRR = new LinkedList();
                                } else {
                                    nnVar.vRR.clear();
                                }
                                i3 = 0;
                                while (true) {
                                    int i5 = i3;
                                    if (i5 >= ((nn) ukVar.wbW.get(i4)).vRR.size()) {
                                        break;
                                    }
                                    ul ulVar = new ul();
                                    if (ulVar.wbZ == null) {
                                        ulVar.wbZ = new LinkedList();
                                    } else {
                                        ulVar.wbZ.clear();
                                    }
                                    i3 = 0;
                                    while (true) {
                                        int i6 = i3;
                                        if (i6 >= ((ul) ((nn) ukVar.wbW.get(i4)).vRR.get(i5)).wbZ.size()) {
                                            break;
                                        }
                                        sz szVar = new sz();
                                        szVar.wap = ((sz) ((ul) ((nn) ukVar.wbW.get(i4)).vRR.get(i5)).wbZ.get(i6)).wap;
                                        szVar.nYb = ((sz) ((ul) ((nn) ukVar.wbW.get(i4)).vRR.get(i5)).wbZ.get(i6)).nYb;
                                        ab.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bo.nullAsNil(szVar.wap) + ", answer=" + bo.nullAsNil(szVar.nYb));
                                        ulVar.wbZ.add(szVar);
                                        i3 = i6 + 1;
                                    }
                                    nnVar.vRR.add(ulVar);
                                    i3 = i5 + 1;
                                }
                                bVC.wbW.add(nnVar);
                                i3 = i4 + 1;
                            }
                        } else {
                            bVC.wbW.clear();
                        }
                    } else {
                        ab.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + ukVar.version);
                        a(bVC);
                        AppMethodBeat.o(23068);
                        return;
                    }
                }
            }
            a(bVC);
        }
        AppMethodBeat.o(23068);
    }
}
