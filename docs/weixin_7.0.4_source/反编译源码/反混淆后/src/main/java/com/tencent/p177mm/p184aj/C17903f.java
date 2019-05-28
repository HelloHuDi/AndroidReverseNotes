package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf.C18266;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.bbo;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.aj.f */
public final class C17903f {
    /* renamed from: qX */
    public static C16527d m28104qX(String str) {
        AppMethodBeat.m2504i(11359);
        C16527d qP = C41747z.aeR().mo43729qP(str);
        if (qP.field_updateTime > 0) {
            AppMethodBeat.m2505o(11359);
            return qP;
        }
        AppMethodBeat.m2505o(11359);
        return null;
    }

    /* renamed from: qY */
    public static boolean m28105qY(String str) {
        AppMethodBeat.m2504i(11360);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11360);
            return false;
        } else if (qX.adM()) {
            AppMethodBeat.m2505o(11360);
            return true;
        } else {
            AppMethodBeat.m2505o(11360);
            return false;
        }
    }

    /* renamed from: qZ */
    public static boolean m28106qZ(String str) {
        AppMethodBeat.m2504i(11361);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11361);
            return false;
        }
        boolean adN = qX.adN();
        AppMethodBeat.m2505o(11361);
        return adN;
    }

    /* renamed from: ra */
    public static boolean m28107ra(String str) {
        AppMethodBeat.m2504i(11362);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11362);
            return false;
        } else if (qX.adO()) {
            AppMethodBeat.m2505o(11362);
            return true;
        } else {
            AppMethodBeat.m2505o(11362);
            return false;
        }
    }

    /* renamed from: rb */
    public static boolean m28108rb(String str) {
        AppMethodBeat.m2504i(11363);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11363);
            return false;
        } else if (qX.adQ()) {
            AppMethodBeat.m2505o(11363);
            return true;
        } else {
            AppMethodBeat.m2505o(11363);
            return false;
        }
    }

    /* renamed from: rc */
    public static boolean m28109rc(String str) {
        AppMethodBeat.m2504i(11364);
        if (str == null) {
            AppMethodBeat.m2505o(11364);
            return false;
        }
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11364);
            return false;
        } else if (qX.adP()) {
            AppMethodBeat.m2505o(11364);
            return true;
        } else {
            AppMethodBeat.m2505o(11364);
            return false;
        }
    }

    /* renamed from: kq */
    public static boolean m28103kq(String str) {
        AppMethodBeat.m2504i(11365);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11365);
            return false;
        } else if (qX.adR()) {
            AppMethodBeat.m2505o(11365);
            return true;
        } else {
            AppMethodBeat.m2505o(11365);
            return false;
        }
    }

    /* renamed from: rd */
    public static boolean m28110rd(String str) {
        AppMethodBeat.m2504i(11366);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11366);
            return false;
        } else if (qX.adS()) {
            AppMethodBeat.m2505o(11366);
            return true;
        } else {
            AppMethodBeat.m2505o(11366);
            return false;
        }
    }

    /* renamed from: re */
    public static boolean m28111re(String str) {
        AppMethodBeat.m2504i(11367);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11367);
            return false;
        }
        boolean adH = qX.adH();
        AppMethodBeat.m2505o(11367);
        return adH;
    }

    /* renamed from: f */
    public static void m28099f(C16527d c16527d) {
        AppMethodBeat.m2504i(11368);
        if (c16527d == null) {
            C4990ab.m7412e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            AppMethodBeat.m2505o(11368);
            return;
        }
        bbo bbo = new bbo();
        bbo.gvb = c16527d.field_brandFlag;
        bbo.jBB = c16527d.field_username;
        C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(c16527d.field_username);
        if (aoN == null || !C7486a.m12942jh(aoN.field_type)) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(58, bbo));
        } else {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(47, bbo));
        }
        boolean c = C41747z.aeR().mo10103c(c16527d, new String[0]);
        C4990ab.m7417i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", Boolean.valueOf(c), Integer.valueOf(c16527d.field_brandFlag));
        AppMethodBeat.m2505o(11368);
    }

    /* renamed from: g */
    public static void m28100g(C16527d c16527d) {
        AppMethodBeat.m2504i(11369);
        if (c16527d != null) {
            bbo bbo = new bbo();
            bbo.gvb = c16527d.field_brandFlag;
            bbo.jBB = c16527d.field_username;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(47, bbo));
            C41747z.aeR().mo10103c(c16527d, new String[0]);
        }
        AppMethodBeat.m2505o(11369);
    }

    /* renamed from: h */
    public static void m28101h(C16527d c16527d) {
        AppMethodBeat.m2504i(11370);
        if (c16527d != null) {
            c16527d.field_brandFlag |= 8;
            C17903f.m28100g(c16527d);
        }
        AppMethodBeat.m2505o(11370);
    }

    /* renamed from: i */
    public static void m28102i(C16527d c16527d) {
        AppMethodBeat.m2504i(11371);
        if (c16527d != null) {
            c16527d.field_brandFlag &= -9;
            C17903f.m28100g(c16527d);
        }
        AppMethodBeat.m2505o(11371);
    }

    public static boolean aex() {
        AppMethodBeat.m2504i(11372);
        if (C41747z.aeR().mo43728lf(1) > 0) {
            AppMethodBeat.m2505o(11372);
            return true;
        }
        AppMethodBeat.m2505o(11372);
        return false;
    }

    public static boolean aey() {
        AppMethodBeat.m2504i(11373);
        if (C41747z.aeR().mo43728lf(4) > 0) {
            AppMethodBeat.m2505o(11373);
            return true;
        }
        AppMethodBeat.m2505o(11373);
        return false;
    }

    public static boolean aez() {
        AppMethodBeat.m2504i(11374);
        if (C41747z.aeR().mo43728lf(8) > 0) {
            AppMethodBeat.m2505o(11374);
            return true;
        }
        AppMethodBeat.m2505o(11374);
        return false;
    }

    public static boolean aeA() {
        AppMethodBeat.m2504i(11375);
        if (C41747z.aeR().mo43728lf(16) > 0) {
            AppMethodBeat.m2505o(11375);
            return true;
        }
        AppMethodBeat.m2505o(11375);
        return false;
    }

    public static boolean aeB() {
        AppMethodBeat.m2504i(11376);
        if (C41747z.aeR().mo43728lf(64) > 0) {
            AppMethodBeat.m2505o(11376);
            return true;
        }
        AppMethodBeat.m2505o(11376);
        return false;
    }

    public static List<String> aeC() {
        AppMethodBeat.m2504i(11377);
        List le = C41747z.aeR().mo43727le(128);
        AppMethodBeat.m2505o(11377);
        return le;
    }

    public static boolean aeD() {
        AppMethodBeat.m2504i(11378);
        if (C41747z.aeR().mo43728lf(128) > 0) {
            AppMethodBeat.m2505o(11378);
            return true;
        }
        AppMethodBeat.m2505o(11378);
        return false;
    }

    public static List<String> aeE() {
        AppMethodBeat.m2504i(11379);
        List le = C41747z.aeR().mo43727le(256);
        AppMethodBeat.m2505o(11379);
        return le;
    }

    public static boolean aeF() {
        AppMethodBeat.m2504i(11380);
        if (C41747z.aeR().mo43728lf(256) > 0) {
            AppMethodBeat.m2505o(11380);
            return true;
        }
        AppMethodBeat.m2505o(11380);
        return false;
    }

    public static List<String> aeG() {
        AppMethodBeat.m2504i(11381);
        List le = C41747z.aeR().mo43727le(512);
        AppMethodBeat.m2505o(11381);
        return le;
    }

    public static boolean aeH() {
        AppMethodBeat.m2504i(11382);
        if (C41747z.aeR().mo43728lf(512) > 0) {
            AppMethodBeat.m2505o(11382);
            return true;
        }
        AppMethodBeat.m2505o(11382);
        return false;
    }

    /* renamed from: rf */
    public static void m28112rf(String str) {
        int i = 0;
        AppMethodBeat.m2504i(11383);
        C41747z.aeR();
        String qT = C25764e.m40952qT(str);
        if (qT != null) {
            ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP().mo74791Rh(qT);
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(str);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            C41747z.afa().mo20346pI(str);
            AppMethodBeat.m2505o(11383);
            return;
        }
        if (qX.adP()) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apq(str);
            C41747z.aeR();
            List qS = C25764e.m40951qS(str);
            if (qS == null || qS.size() <= 0) {
                C4990ab.m7410d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", C5046bo.dpG());
                C7305d.post(new C18266(qS), "deleteMsgByTalkers");
            }
            while (i < qS.size()) {
                String str2 = (String) qS.get(i);
                if (C17903f.m28103kq(str2)) {
                    C25754e.m40889G(str2, true);
                }
                C41747z.aeR().delete(str2);
                i++;
            }
        }
        if (qX.adR()) {
            C25754e.m40889G(str, true);
        }
        C41747z.aeR().mo43723c(qX);
        C41747z.afa().mo20346pI(str);
        AppMethodBeat.m2505o(11383);
    }
}
