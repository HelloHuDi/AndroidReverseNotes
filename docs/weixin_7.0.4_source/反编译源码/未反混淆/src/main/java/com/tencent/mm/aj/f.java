package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.AnonymousClass6;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class f {
    public static d qX(String str) {
        AppMethodBeat.i(11359);
        d qP = z.aeR().qP(str);
        if (qP.field_updateTime > 0) {
            AppMethodBeat.o(11359);
            return qP;
        }
        AppMethodBeat.o(11359);
        return null;
    }

    public static boolean qY(String str) {
        AppMethodBeat.i(11360);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11360);
            return false;
        } else if (qX.adM()) {
            AppMethodBeat.o(11360);
            return true;
        } else {
            AppMethodBeat.o(11360);
            return false;
        }
    }

    public static boolean qZ(String str) {
        AppMethodBeat.i(11361);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11361);
            return false;
        }
        boolean adN = qX.adN();
        AppMethodBeat.o(11361);
        return adN;
    }

    public static boolean ra(String str) {
        AppMethodBeat.i(11362);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11362);
            return false;
        } else if (qX.adO()) {
            AppMethodBeat.o(11362);
            return true;
        } else {
            AppMethodBeat.o(11362);
            return false;
        }
    }

    public static boolean rb(String str) {
        AppMethodBeat.i(11363);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11363);
            return false;
        } else if (qX.adQ()) {
            AppMethodBeat.o(11363);
            return true;
        } else {
            AppMethodBeat.o(11363);
            return false;
        }
    }

    public static boolean rc(String str) {
        AppMethodBeat.i(11364);
        if (str == null) {
            AppMethodBeat.o(11364);
            return false;
        }
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11364);
            return false;
        } else if (qX.adP()) {
            AppMethodBeat.o(11364);
            return true;
        } else {
            AppMethodBeat.o(11364);
            return false;
        }
    }

    public static boolean kq(String str) {
        AppMethodBeat.i(11365);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11365);
            return false;
        } else if (qX.adR()) {
            AppMethodBeat.o(11365);
            return true;
        } else {
            AppMethodBeat.o(11365);
            return false;
        }
    }

    public static boolean rd(String str) {
        AppMethodBeat.i(11366);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11366);
            return false;
        } else if (qX.adS()) {
            AppMethodBeat.o(11366);
            return true;
        } else {
            AppMethodBeat.o(11366);
            return false;
        }
    }

    public static boolean re(String str) {
        AppMethodBeat.i(11367);
        d qX = qX(str);
        if (qX == null) {
            AppMethodBeat.o(11367);
            return false;
        }
        boolean adH = qX.adH();
        AppMethodBeat.o(11367);
        return adH;
    }

    public static void f(d dVar) {
        AppMethodBeat.i(11368);
        if (dVar == null) {
            ab.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            AppMethodBeat.o(11368);
            return;
        }
        bbo bbo = new bbo();
        bbo.gvb = dVar.field_brandFlag;
        bbo.jBB = dVar.field_username;
        ad aoN = ((j) g.K(j.class)).XM().aoN(dVar.field_username);
        if (aoN == null || !a.jh(aoN.field_type)) {
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(58, bbo));
        } else {
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(47, bbo));
        }
        boolean c = z.aeR().c(dVar, new String[0]);
        ab.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", Boolean.valueOf(c), Integer.valueOf(dVar.field_brandFlag));
        AppMethodBeat.o(11368);
    }

    public static void g(d dVar) {
        AppMethodBeat.i(11369);
        if (dVar != null) {
            bbo bbo = new bbo();
            bbo.gvb = dVar.field_brandFlag;
            bbo.jBB = dVar.field_username;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(47, bbo));
            z.aeR().c(dVar, new String[0]);
        }
        AppMethodBeat.o(11369);
    }

    public static void h(d dVar) {
        AppMethodBeat.i(11370);
        if (dVar != null) {
            dVar.field_brandFlag |= 8;
            g(dVar);
        }
        AppMethodBeat.o(11370);
    }

    public static void i(d dVar) {
        AppMethodBeat.i(11371);
        if (dVar != null) {
            dVar.field_brandFlag &= -9;
            g(dVar);
        }
        AppMethodBeat.o(11371);
    }

    public static boolean aex() {
        AppMethodBeat.i(11372);
        if (z.aeR().lf(1) > 0) {
            AppMethodBeat.o(11372);
            return true;
        }
        AppMethodBeat.o(11372);
        return false;
    }

    public static boolean aey() {
        AppMethodBeat.i(11373);
        if (z.aeR().lf(4) > 0) {
            AppMethodBeat.o(11373);
            return true;
        }
        AppMethodBeat.o(11373);
        return false;
    }

    public static boolean aez() {
        AppMethodBeat.i(11374);
        if (z.aeR().lf(8) > 0) {
            AppMethodBeat.o(11374);
            return true;
        }
        AppMethodBeat.o(11374);
        return false;
    }

    public static boolean aeA() {
        AppMethodBeat.i(11375);
        if (z.aeR().lf(16) > 0) {
            AppMethodBeat.o(11375);
            return true;
        }
        AppMethodBeat.o(11375);
        return false;
    }

    public static boolean aeB() {
        AppMethodBeat.i(11376);
        if (z.aeR().lf(64) > 0) {
            AppMethodBeat.o(11376);
            return true;
        }
        AppMethodBeat.o(11376);
        return false;
    }

    public static List<String> aeC() {
        AppMethodBeat.i(11377);
        List le = z.aeR().le(128);
        AppMethodBeat.o(11377);
        return le;
    }

    public static boolean aeD() {
        AppMethodBeat.i(11378);
        if (z.aeR().lf(128) > 0) {
            AppMethodBeat.o(11378);
            return true;
        }
        AppMethodBeat.o(11378);
        return false;
    }

    public static List<String> aeE() {
        AppMethodBeat.i(11379);
        List le = z.aeR().le(256);
        AppMethodBeat.o(11379);
        return le;
    }

    public static boolean aeF() {
        AppMethodBeat.i(11380);
        if (z.aeR().lf(256) > 0) {
            AppMethodBeat.o(11380);
            return true;
        }
        AppMethodBeat.o(11380);
        return false;
    }

    public static List<String> aeG() {
        AppMethodBeat.i(11381);
        List le = z.aeR().le(512);
        AppMethodBeat.o(11381);
        return le;
    }

    public static boolean aeH() {
        AppMethodBeat.i(11382);
        if (z.aeR().lf(512) > 0) {
            AppMethodBeat.o(11382);
            return true;
        }
        AppMethodBeat.o(11382);
        return false;
    }

    public static void rf(String str) {
        int i = 0;
        AppMethodBeat.i(11383);
        z.aeR();
        String qT = e.qT(str);
        if (qT != null) {
            ((o) g.K(o.class)).XP().Rh(qT);
        }
        ((j) g.K(j.class)).XR().aoX(str);
        d qX = qX(str);
        if (qX == null) {
            z.afa().pI(str);
            AppMethodBeat.o(11383);
            return;
        }
        if (qX.adP()) {
            ((j) g.K(j.class)).XR().apq(str);
            z.aeR();
            List qS = e.qS(str);
            if (qS == null || qS.size() <= 0) {
                ab.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", bo.dpG());
                d.post(new AnonymousClass6(qS), "deleteMsgByTalkers");
            }
            while (i < qS.size()) {
                String str2 = (String) qS.get(i);
                if (kq(str2)) {
                    e.G(str2, true);
                }
                z.aeR().delete(str2);
                i++;
            }
        }
        if (qX.adR()) {
            e.G(str, true);
        }
        z.aeR().c(qX);
        z.afa().pI(str);
        AppMethodBeat.o(11383);
    }
}
