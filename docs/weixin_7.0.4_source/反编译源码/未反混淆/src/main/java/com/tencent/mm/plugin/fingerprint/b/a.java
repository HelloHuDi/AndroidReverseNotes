package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a implements l {
    public final void bxd() {
        ab.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (e.bxG() && !bxo()) {
            ab.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
        } else if (bxh() && !bxB()) {
            ab.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        } else if (q.etg.etr != 1) {
            ab.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        }
    }

    public final boolean bxe() {
        return e.bxG();
    }

    public boolean bxf() {
        return false;
    }

    public boolean bxg() {
        return false;
    }

    public final void a(lv lvVar, int i, String str) {
        ab.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (lvVar != null && lvVar.cHD.cHH != null) {
            lvVar.cHE = new b();
            lvVar.cHE.errCode = i;
            lvVar.cHE.cBU = "";
            lvVar.cHE.cBV = "";
            lvVar.cHE.aIm = str;
            lvVar.cHE.cHJ = type();
            lvVar.cHD.cHH.run();
        }
    }

    public final void hq(boolean z) {
        ab.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", Boolean.valueOf(z));
        e.hs(z);
    }

    public final boolean bxh() {
        return ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FACE_ID_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
    }

    public final void hr(boolean z) {
        ab.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", Boolean.valueOf(z));
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FACE_ID_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
    }

    public String bxi() {
        return "";
    }
}
