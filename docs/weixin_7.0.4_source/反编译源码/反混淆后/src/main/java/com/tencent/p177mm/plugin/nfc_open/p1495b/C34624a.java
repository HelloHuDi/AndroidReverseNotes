package com.tencent.p177mm.plugin.nfc_open.p1495b;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.nfc_open.p736a.C12718b;
import com.tencent.p177mm.protocal.protobuf.C23442sz;
import com.tencent.p177mm.protocal.protobuf.C35937nn;
import com.tencent.p177mm.protocal.protobuf.C40578ul;
import com.tencent.p177mm.protocal.protobuf.C46590uk;
import com.tencent.p177mm.protocal.protobuf.bel;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.nfc_open.b.a */
public final class C34624a implements C1202f {
    public bel oTw;

    public C34624a() {
        AppMethodBeat.m2504i(23063);
        init();
        AppMethodBeat.m2505o(23063);
    }

    private void init() {
        AppMethodBeat.m2504i(23064);
        this.oTw = new bel();
        C9638aw.m17190ZK();
        String valueOf = String.valueOf(C18628c.m29072Ry().get(C5127a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null));
        if (C5046bo.isNullOrNil(valueOf)) {
            this.oTw.wbW = new LinkedList();
            this.oTw.lastUpdateTime = 0;
            this.oTw.wbX = 86400;
            this.oTw.version = 0;
            AppMethodBeat.m2505o(23064);
            return;
        }
        try {
            this.oTw.parseFrom(valueOf.getBytes("ISO-8859-1"));
            AppMethodBeat.m2505o(23064);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.oTw.wbW = new LinkedList();
            this.oTw.lastUpdateTime = 0;
            this.oTw.wbX = 86400;
            this.oTw.version = 0;
            AppMethodBeat.m2505o(23064);
        }
    }

    /* renamed from: a */
    private void m56795a(bel bel) {
        AppMethodBeat.m2504i(23065);
        if (C9638aw.m17179RK()) {
            if (bel != null) {
                C4990ab.m7416i("MicroMsg.CpuCardConfigManager", "setConfig config");
                this.oTw = bel;
                try {
                    Object str = new String(this.oTw.toByteArray(), "ISO-8859-1");
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, str);
                    AppMethodBeat.m2505o(23065);
                    return;
                } catch (UnsupportedEncodingException e) {
                    C4990ab.m7420w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
                    AppMethodBeat.m2505o(23065);
                    return;
                } catch (IOException e2) {
                    C4990ab.m7420w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
                }
            }
            AppMethodBeat.m2505o(23065);
            return;
        }
        C4990ab.m7416i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        AppMethodBeat.m2505o(23065);
    }

    private bel bVC() {
        AppMethodBeat.m2504i(23066);
        if (this.oTw == null) {
            init();
        }
        bel bel = this.oTw;
        AppMethodBeat.m2505o(23066);
        return bel;
    }

    public final boolean bGv() {
        int i = 1800;
        AppMethodBeat.m2504i(23067);
        try {
            if (NfcAdapter.getDefaultAdapter(C4996ah.getContext()) == null) {
                C4990ab.m7416i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
                AppMethodBeat.m2505o(23067);
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
                C4990ab.m7416i("MicroMsg.CpuCardConfigManager", "now=" + C5046bo.anT() + ", lastUpdateTime=" + this.oTw.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.oTw.wbX);
                if (C5046bo.anT() - this.oTw.lastUpdateTime > ((long) i)) {
                    AppMethodBeat.m2505o(23067);
                    return true;
                }
            }
            AppMethodBeat.m2505o(23067);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CpuCardConfigManager", e, "", new Object[0]);
            AppMethodBeat.m2505o(23067);
            return false;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(23068);
        C9638aw.m17182Rg().mo14546b(1561, (C1202f) this);
        if (c1207m instanceof C12718b) {
            bel bVC = bVC();
            bVC.lastUpdateTime = C5046bo.anT();
            if (i == 0 && i2 == 0) {
                C46590uk c46590uk = (C46590uk) ((C12718b) c1207m).ehh.fsH.fsP;
                if (c46590uk != null) {
                    bVC.wbX = c46590uk.wbX;
                    bVC.wbY = c46590uk.wbY;
                    C9638aw.m17190ZK();
                    if (((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        if (c46590uk.wbY == 1) {
                            C4996ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            C4996ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(c46590uk.wbY));
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, c46590uk.tuB);
                    if (bVC.version != c46590uk.version) {
                        bVC.version = c46590uk.version;
                        if (c46590uk.wbW != null && !c46590uk.wbW.isEmpty()) {
                            if (bVC.wbW == null) {
                                bVC.wbW = new LinkedList();
                            } else {
                                bVC.wbW.clear();
                            }
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= c46590uk.wbW.size()) {
                                    break;
                                }
                                C35937nn c35937nn = new C35937nn();
                                c35937nn.vzX = ((C35937nn) c46590uk.wbW.get(i4)).vzX;
                                c35937nn.vRS = ((C35937nn) c46590uk.wbW.get(i4)).vRS;
                                C4990ab.m7410d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + C5046bo.m7567h(Integer.valueOf(c35937nn.vRS)) + ", url=" + C5046bo.nullAsNil(c35937nn.vzX));
                                if (c35937nn.vRR == null) {
                                    c35937nn.vRR = new LinkedList();
                                } else {
                                    c35937nn.vRR.clear();
                                }
                                i3 = 0;
                                while (true) {
                                    int i5 = i3;
                                    if (i5 >= ((C35937nn) c46590uk.wbW.get(i4)).vRR.size()) {
                                        break;
                                    }
                                    C40578ul c40578ul = new C40578ul();
                                    if (c40578ul.wbZ == null) {
                                        c40578ul.wbZ = new LinkedList();
                                    } else {
                                        c40578ul.wbZ.clear();
                                    }
                                    i3 = 0;
                                    while (true) {
                                        int i6 = i3;
                                        if (i6 >= ((C40578ul) ((C35937nn) c46590uk.wbW.get(i4)).vRR.get(i5)).wbZ.size()) {
                                            break;
                                        }
                                        C23442sz c23442sz = new C23442sz();
                                        c23442sz.wap = ((C23442sz) ((C40578ul) ((C35937nn) c46590uk.wbW.get(i4)).vRR.get(i5)).wbZ.get(i6)).wap;
                                        c23442sz.nYb = ((C23442sz) ((C40578ul) ((C35937nn) c46590uk.wbW.get(i4)).vRR.get(i5)).wbZ.get(i6)).nYb;
                                        C4990ab.m7410d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + C5046bo.nullAsNil(c23442sz.wap) + ", answer=" + C5046bo.nullAsNil(c23442sz.nYb));
                                        c40578ul.wbZ.add(c23442sz);
                                        i3 = i6 + 1;
                                    }
                                    c35937nn.vRR.add(c40578ul);
                                    i3 = i5 + 1;
                                }
                                bVC.wbW.add(c35937nn);
                                i3 = i4 + 1;
                            }
                        } else {
                            bVC.wbW.clear();
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + c46590uk.version);
                        m56795a(bVC);
                        AppMethodBeat.m2505o(23068);
                        return;
                    }
                }
            }
            m56795a(bVC);
        }
        AppMethodBeat.m2505o(23068);
    }
}
