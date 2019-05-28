package com.tencent.p177mm.p199ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.protocal.protobuf.chg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C36001bm;

/* renamed from: com.tencent.mm.ax.d */
public final class C6328d implements C1202f {
    public C6329a fKT = null;

    /* renamed from: com.tencent.mm.ax.d$a */
    public interface C6329a {
        /* renamed from: e */
        void mo14568e(C36001bm c36001bm);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78425);
        C4990ab.m7416i("MicroMsg.NewTipsManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() == 597) {
            if (i == 0 && i2 == 0) {
                boolean z = ((C32320a) c1207m).fKz;
                C36001bm Ms = C16841a.bVu().mo48500Ms(((C32320a) c1207m).fKA);
                if (Ms != null) {
                    Ms.field_isReject = z;
                    C4990ab.m7417i("MicroMsg.NewTipsManager", "Newtips push is reject: %s", Boolean.valueOf(z));
                    C16841a.bVu().mo48501a(Ms, new String[0]);
                }
            } else {
                AppMethodBeat.m2505o(78425);
                return;
            }
        }
        AppMethodBeat.m2505o(78425);
    }

    /* renamed from: b */
    public static void m10411b(int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(78426);
        C36001bm Ms = C16841a.bVu().mo48500Ms(i);
        if (Ms == null) {
            Ms = new C36001bm();
            Ms.field_tipId = i;
            Ms.field_tipVersion = 1;
            Ms.field_tipkey = str;
            Ms.field_tipType = i2;
            if (Ms.field_tipsShowInfo == null) {
                Ms.field_tipsShowInfo = new chg();
            }
            Ms.field_tipsShowInfo.path = str2;
            C16841a.bVu().mo48502f(Ms);
            if (i2 == C32321b.fKB && !(Ms.field_isExit && 1 == Ms.field_tipVersion)) {
                C1720g.m3540Rg().mo14541a(new C32320a(i, str), 0);
                C4990ab.m7410d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
                AppMethodBeat.m2505o(78426);
                return;
            }
        }
        if (i2 == C32321b.fKB && !(Ms.field_isExit && 1 == Ms.field_tipVersion)) {
            C1720g.m3540Rg().mo14541a(new C32320a(i, str), 0);
            C4990ab.m7410d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
        }
        if ((i2 == C32321b.fKB && 1 != Ms.field_tipVersion) || (i2 == C32321b.fKC && Ms.field_tipVersion <= 0)) {
            Ms.field_tipId = i;
            Ms.field_tipVersion = 1;
            Ms.field_tipkey = str;
            Ms.field_tipType = i2;
            Ms.field_isExit = false;
            if (Ms.field_tipsShowInfo == null) {
                Ms.field_tipsShowInfo = new chg();
            }
            Ms.field_tipsShowInfo.path = str2;
            C16841a.bVu().mo48501a(Ms, new String[0]);
        }
        AppMethodBeat.m2505o(78426);
    }

    /* renamed from: lR */
    public static void m10412lR(int i) {
        AppMethodBeat.m2504i(78427);
        C36001bm Ms = C16841a.bVu().mo48500Ms(i);
        if (Ms == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
            AppMethodBeat.m2505o(78427);
            return;
        }
        C4990ab.m7417i("MicroMsg.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", Integer.valueOf(i), Boolean.TRUE);
        if (Ms.field_tipType == C32321b.fKB) {
            Ms.field_hadRead = true;
            C16841a.bVu().mo48501a(Ms, new String[0]);
        }
        if (Ms.field_tipType == C32321b.fKC) {
            Ms.field_hadRead = true;
            C16841a.bVu().mo48501a(Ms, new String[0]);
        }
        C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", C5046bo.anU()).commit();
        AppMethodBeat.m2505o(78427);
    }

    /* renamed from: u */
    public static void m10413u(int i, long j) {
        AppMethodBeat.m2504i(78428);
        C36001bm Ms = C16841a.bVu().mo48500Ms(i);
        if (Ms == null) {
            C4990ab.m7412e("MicroMsg.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
            AppMethodBeat.m2505o(78428);
            return;
        }
        Ms.field_pagestaytime = j;
        C16841a.bVu().mo48501a(Ms, new String[0]);
        AppMethodBeat.m2505o(78428);
    }
}
