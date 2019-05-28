package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bm;

public final class d implements f {
    public a fKT = null;

    public interface a {
        void e(bm bmVar);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78425);
        ab.i("MicroMsg.NewTipsManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() == 597) {
            if (i == 0 && i2 == 0) {
                boolean z = ((a) mVar).fKz;
                bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(((a) mVar).fKA);
                if (Ms != null) {
                    Ms.field_isReject = z;
                    ab.i("MicroMsg.NewTipsManager", "Newtips push is reject: %s", Boolean.valueOf(z));
                    com.tencent.mm.plugin.r.a.bVu().a(Ms, new String[0]);
                }
            } else {
                AppMethodBeat.o(78425);
                return;
            }
        }
        AppMethodBeat.o(78425);
    }

    public static void b(int i, int i2, String str, String str2) {
        AppMethodBeat.i(78426);
        bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(i);
        if (Ms == null) {
            Ms = new bm();
            Ms.field_tipId = i;
            Ms.field_tipVersion = 1;
            Ms.field_tipkey = str;
            Ms.field_tipType = i2;
            if (Ms.field_tipsShowInfo == null) {
                Ms.field_tipsShowInfo = new chg();
            }
            Ms.field_tipsShowInfo.path = str2;
            com.tencent.mm.plugin.r.a.bVu().f(Ms);
            if (i2 == b.fKB && !(Ms.field_isExit && 1 == Ms.field_tipVersion)) {
                g.Rg().a(new a(i, str), 0);
                ab.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
                AppMethodBeat.o(78426);
                return;
            }
        }
        if (i2 == b.fKB && !(Ms.field_isExit && 1 == Ms.field_tipVersion)) {
            g.Rg().a(new a(i, str), 0);
            ab.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
        }
        if ((i2 == b.fKB && 1 != Ms.field_tipVersion) || (i2 == b.fKC && Ms.field_tipVersion <= 0)) {
            Ms.field_tipId = i;
            Ms.field_tipVersion = 1;
            Ms.field_tipkey = str;
            Ms.field_tipType = i2;
            Ms.field_isExit = false;
            if (Ms.field_tipsShowInfo == null) {
                Ms.field_tipsShowInfo = new chg();
            }
            Ms.field_tipsShowInfo.path = str2;
            com.tencent.mm.plugin.r.a.bVu().a(Ms, new String[0]);
        }
        AppMethodBeat.o(78426);
    }

    public static void lR(int i) {
        AppMethodBeat.i(78427);
        bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(i);
        if (Ms == null) {
            ab.e("MicroMsg.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
            AppMethodBeat.o(78427);
            return;
        }
        ab.i("MicroMsg.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", Integer.valueOf(i), Boolean.TRUE);
        if (Ms.field_tipType == b.fKB) {
            Ms.field_hadRead = true;
            com.tencent.mm.plugin.r.a.bVu().a(Ms, new String[0]);
        }
        if (Ms.field_tipType == b.fKC) {
            Ms.field_hadRead = true;
            com.tencent.mm.plugin.r.a.bVu().a(Ms, new String[0]);
        }
        ah.getContext().getSharedPreferences(ah.doA() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", bo.anU()).commit();
        AppMethodBeat.o(78427);
    }

    public static void u(int i, long j) {
        AppMethodBeat.i(78428);
        bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(i);
        if (Ms == null) {
            ab.e("MicroMsg.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
            AppMethodBeat.o(78428);
            return;
        }
        Ms.field_pagestaytime = j;
        com.tencent.mm.plugin.r.a.bVu().a(Ms, new String[0]);
        AppMethodBeat.o(78428);
    }
}
