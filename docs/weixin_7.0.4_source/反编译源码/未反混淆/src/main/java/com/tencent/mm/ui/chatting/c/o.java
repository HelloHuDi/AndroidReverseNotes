package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.az.e;
import com.tencent.mm.g.a.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.m;
import com.tencent.mm.ui.chatting.viewitems.k;
import java.util.LinkedList;

@a(dFp = m.class)
public class o extends a implements m {
    private c yPA = new c<r>() {
        {
            AppMethodBeat.i(31394);
            this.xxI = r.class.getName().hashCode();
            AppMethodBeat.o(31394);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(31395);
            final r rVar = (r) bVar;
            if (o.this.cgL != null) {
                if (rVar.csC.status == 1) {
                    com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31392);
                            o.this.cgL.aWv();
                            AppMethodBeat.o(31392);
                        }
                    });
                } else {
                    com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31393);
                            k.b.n(rVar.csC.csD, rVar.csC.csE, rVar.csC.status);
                            AppMethodBeat.o(31393);
                        }
                    });
                }
            }
            AppMethodBeat.o(31395);
            return false;
        }
    };

    public o() {
        AppMethodBeat.i(31396);
        AppMethodBeat.o(31396);
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        AppMethodBeat.i(31397);
        EmojiInfo Jd;
        ap aps;
        j.b X;
        j.b bVar;
        String str;
        EmojiInfo Jd2;
        switch (menuItem.getItemId()) {
            case 103:
                boolean bh = bh(biVar);
                AppMethodBeat.o(31397);
                return bh;
            case 104:
                if (biVar.dtx() || biVar.dty()) {
                    String oy;
                    if (biVar.dtx()) {
                        Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                    } else {
                        aps = ap.aps(biVar.field_content);
                        X = j.b.X(biVar.field_content, biVar.field_reserved);
                        if (X == null) {
                            X = new j.b();
                            X.fgq = aps.cvZ;
                            bVar = X;
                        } else {
                            bVar = X;
                        }
                        if (!(bo.isNullOrNil(bVar.fgq) || bVar.fgq.equals("-1"))) {
                            Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(bVar.fgq);
                        }
                    }
                    str = biVar.field_talker;
                    if (t.kH(str)) {
                        oy = bf.oy(biVar.field_content);
                    } else {
                        oy = str;
                    }
                    h.pYm.e(12789, Integer.valueOf(3), Jd.Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", "", Jd.field_activityid);
                    ((d) g.M(d.class)).getEmojiMgr().a(aVar.yTx.getContext(), Jd, 0, oy);
                }
                AppMethodBeat.o(31397);
                return true;
            case 113:
                if (biVar.dtx() || biVar.dty()) {
                    boolean z;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(biVar);
                    if (((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn() || aVar.dFw()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.ui.chatting.k.a(aVar.yTx.getContext(), linkedList, z, aVar.getTalkerUserName(), null);
                    if (biVar.dtx()) {
                        Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                    } else {
                        aps = ap.aps(biVar.field_content);
                        if (!(bo.isNullOrNil(aps.cvZ) || aps.cvZ.equals("-1"))) {
                            Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(aps.cvZ);
                        }
                    }
                    if (Jd != null) {
                        str = aVar.getTalkerUserName();
                        if (t.kH(str)) {
                            str = bf.oy(biVar.field_content);
                        }
                        h.pYm.e(12789, Integer.valueOf(1), Jd.Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, str, "", "", "", Jd.field_activityid);
                    }
                }
                AppMethodBeat.o(31397);
                return true;
            case 114:
                if (biVar.dtx() || biVar.dty()) {
                    am.d(biVar, aVar.yTx.getContext());
                    AppMethodBeat.o(31397);
                    return true;
                }
                AppMethodBeat.o(31397);
                return false;
            case 128:
                if (biVar.dtx()) {
                    Jd2 = ((d) g.M(d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                } else {
                    aps = ap.aps(biVar.field_content);
                    if (!(bo.isNullOrNil(aps.cvZ) || aps.cvZ.equals("-1"))) {
                        Jd2 = ((d) g.M(d.class)).getEmojiMgr().Jd(aps.cvZ);
                    }
                    AppMethodBeat.o(31397);
                    return true;
                }
                if (Jd2 != null) {
                    h.pYm.e(12789, Integer.valueOf(2), Jd2.Aq(), Integer.valueOf(0), Jd2.field_designerID, Jd2.field_groupId, "", "", "", "", "", Jd2.field_activityid);
                }
                if (Jd2 == null) {
                    str = "";
                } else {
                    str = Jd2.field_groupId;
                }
                if (!bo.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("preceding_scence", 3);
                    intent.putExtra("download_entrance_scene", 16);
                    intent.putExtra("extra_id", str);
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
                AppMethodBeat.o(31397);
                return true;
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*135*/:
                if (biVar.dtx()) {
                    Jd2 = ((d) g.M(d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                } else {
                    aps = ap.aps(biVar.field_content);
                    X = j.b.X(biVar.field_content, biVar.field_reserved);
                    if (X == null) {
                        X = new j.b();
                        X.fgq = aps.cvZ;
                        bVar = X;
                    } else {
                        bVar = X;
                    }
                    if (!(bo.isNullOrNil(bVar.fgq) || bVar.fgq.equals("-1"))) {
                        Jd2 = ((d) g.M(d.class)).getEmojiMgr().Jd(bVar.fgq);
                    }
                    AppMethodBeat.o(31397);
                    return true;
                }
                h.pYm.e(12789, Integer.valueOf(5), Jd2.Aq(), Integer.valueOf(0), Jd2.field_designerID, Jd2.field_groupId, "", "", "", "", "", Jd2.field_activityid);
                com.tencent.mm.plugin.emojicapture.api.c.an(aVar.yTx.getContext(), Jd2.Aq());
                AppMethodBeat.o(31397);
                return true;
            default:
                AppMethodBeat.o(31397);
                return false;
        }
    }

    public final void dxz() {
        AppMethodBeat.i(31398);
        ab.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
        com.tencent.mm.sdk.b.a.xxA.c(this.yPA);
        AppMethodBeat.o(31398);
    }

    public final void dxC() {
        AppMethodBeat.i(31399);
        ab.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
        com.tencent.mm.sdk.b.a.xxA.d(this.yPA);
        AppMethodBeat.o(31399);
    }

    public final void dDh() {
        AppMethodBeat.i(31400);
        super.dDh();
        ab.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
        com.tencent.mm.sdk.b.a.xxA.d(this.yPA);
        AppMethodBeat.o(31400);
    }

    public final boolean bh(bi biVar) {
        AppMethodBeat.i(31401);
        ab.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", Long.valueOf(biVar.field_msgId));
        if (biVar.dtx()) {
            bi(biVar);
            AppMethodBeat.o(31401);
            return true;
        } else if (biVar.dty()) {
            aT(biVar);
            AppMethodBeat.o(31401);
            return true;
        } else {
            AppMethodBeat.o(31401);
            return false;
        }
    }

    private void bi(bi biVar) {
        AppMethodBeat.i(31402);
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            ab.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
            if (!this.cgL.getTalkerUserName().equals("medianote")) {
                aw.ZK();
                com.tencent.mm.model.c.XL().c(new e(biVar.field_talker, biVar.field_msgSvrId));
            }
            ak.aS(biVar);
            AppMethodBeat.o(31402);
            return;
        }
        com.tencent.mm.ui.base.t.hO(this.cgL.yTx.getContext());
        AppMethodBeat.o(31402);
    }

    private void aT(bi biVar) {
        AppMethodBeat.i(31403);
        ab.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
        if (!this.cgL.getTalkerUserName().equals("medianote")) {
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new e(biVar.field_talker, biVar.field_msgSvrId));
        }
        ak.aT(biVar);
        this.cgL.qp(true);
        AppMethodBeat.o(31403);
    }
}
