package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.a */
public abstract class C31356a implements C30052l {
    public final void bxd() {
        C4990ab.m7416i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (C39088e.bxG() && !bxo()) {
            C4990ab.m7412e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
        } else if (bxh() && !bxB()) {
            C4990ab.m7412e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        } else if (C1427q.etg.etr != 1) {
            C4990ab.m7412e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        }
    }

    public final boolean bxe() {
        return C39088e.bxG();
    }

    public boolean bxf() {
        return false;
    }

    public boolean bxg() {
        return false;
    }

    /* renamed from: a */
    public final void mo48286a(C18316lv c18316lv, int i, String str) {
        C4990ab.m7416i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (c18316lv != null && c18316lv.cHD.cHH != null) {
            c18316lv.cHE = new C18317b();
            c18316lv.cHE.errCode = i;
            c18316lv.cHE.cBU = "";
            c18316lv.cHE.cBV = "";
            c18316lv.cHE.aIm = str;
            c18316lv.cHE.cHJ = type();
            c18316lv.cHD.cHH.run();
        }
    }

    /* renamed from: hq */
    public final void mo48312hq(boolean z) {
        C4990ab.m7417i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", Boolean.valueOf(z));
        C39088e.m66514hs(z);
    }

    public final boolean bxh() {
        return ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FACE_ID_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
    }

    /* renamed from: hr */
    public final void mo48313hr(boolean z) {
        C4990ab.m7417i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FACE_ID_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
    }

    public String bxi() {
        return "";
    }
}
