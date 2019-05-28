package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p201az.C32325e;
import com.tencent.p177mm.p230g.p231a.C42048r;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.C44288am;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44298m;
import com.tencent.p177mm.p612ui.chatting.viewitems.C30610k.C23853b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

@C15590a(dFp = C44298m.class)
/* renamed from: com.tencent.mm.ui.chatting.c.o */
public class C30479o extends C44291a implements C44298m {
    private C4884c yPA = new C304801();

    /* renamed from: com.tencent.mm.ui.chatting.c.o$1 */
    class C304801 extends C4884c<C42048r> {

        /* renamed from: com.tencent.mm.ui.chatting.c.o$1$1 */
        class C156251 implements Runnable {
            C156251() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31392);
                C30479o.this.cgL.aWv();
                AppMethodBeat.m2505o(31392);
            }
        }

        C304801() {
            AppMethodBeat.m2504i(31394);
            this.xxI = C42048r.class.getName().hashCode();
            AppMethodBeat.m2505o(31394);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31395);
            final C42048r c42048r = (C42048r) c4883b;
            if (C30479o.this.cgL != null) {
                if (c42048r.csC.status == 1) {
                    C46650a.dFz().post(new C156251());
                } else {
                    C46650a.dFz().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(31393);
                            C23853b.m36723n(c42048r.csC.csD, c42048r.csC.csE, c42048r.csC.status);
                            AppMethodBeat.m2505o(31393);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(31395);
            return false;
        }
    }

    public C30479o() {
        AppMethodBeat.m2504i(31396);
        AppMethodBeat.m2505o(31396);
    }

    /* renamed from: a */
    public final boolean mo48876a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31397);
        EmojiInfo Jd;
        C44218ap aps;
        C8910b X;
        C8910b c8910b;
        String str;
        EmojiInfo Jd2;
        switch (menuItem.getItemId()) {
            case 103:
                boolean bh = mo48877bh(c7620bi);
                AppMethodBeat.m2505o(31397);
                return bh;
            case 104:
                if (c7620bi.dtx() || c7620bi.dty()) {
                    String oy;
                    if (c7620bi.dtx()) {
                        Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                    } else {
                        aps = C44218ap.aps(c7620bi.field_content);
                        X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
                        if (X == null) {
                            X = new C8910b();
                            X.fgq = aps.cvZ;
                            c8910b = X;
                        } else {
                            c8910b = X;
                        }
                        if (!(C5046bo.isNullOrNil(c8910b.fgq) || c8910b.fgq.equals("-1"))) {
                            Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
                        }
                    }
                    str = c7620bi.field_talker;
                    if (C1855t.m3896kH(str)) {
                        oy = C1829bf.m3762oy(c7620bi.field_content);
                    } else {
                        oy = str;
                    }
                    C7060h.pYm.mo8381e(12789, Integer.valueOf(3), Jd.mo20410Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, "", "", "", "", "", Jd.field_activityid);
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35621a(c46650a.yTx.getContext(), Jd, 0, oy);
                }
                AppMethodBeat.m2505o(31397);
                return true;
            case 113:
                if (c7620bi.dtx() || c7620bi.dty()) {
                    boolean z;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(c7620bi);
                    if (((C36135d) c46650a.mo74857aF(C36135d.class)).dDn() || c46650a.dFw()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C46660k.m88358a(c46650a.yTx.getContext(), linkedList, z, c46650a.getTalkerUserName(), null);
                    if (c7620bi.dtx()) {
                        Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                    } else {
                        aps = C44218ap.aps(c7620bi.field_content);
                        if (!(C5046bo.isNullOrNil(aps.cvZ) || aps.cvZ.equals("-1"))) {
                            Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(aps.cvZ);
                        }
                    }
                    if (Jd != null) {
                        str = c46650a.getTalkerUserName();
                        if (C1855t.m3896kH(str)) {
                            str = C1829bf.m3762oy(c7620bi.field_content);
                        }
                        C7060h.pYm.mo8381e(12789, Integer.valueOf(1), Jd.mo20410Aq(), Integer.valueOf(0), Jd.field_designerID, Jd.field_groupId, str, "", "", "", Jd.field_activityid);
                    }
                }
                AppMethodBeat.m2505o(31397);
                return true;
            case 114:
                if (c7620bi.dtx() || c7620bi.dty()) {
                    C44288am.m80033d(c7620bi, c46650a.yTx.getContext());
                    AppMethodBeat.m2505o(31397);
                    return true;
                }
                AppMethodBeat.m2505o(31397);
                return false;
            case 128:
                if (c7620bi.dtx()) {
                    Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                } else {
                    aps = C44218ap.aps(c7620bi.field_content);
                    if (!(C5046bo.isNullOrNil(aps.cvZ) || aps.cvZ.equals("-1"))) {
                        Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(aps.cvZ);
                    }
                    AppMethodBeat.m2505o(31397);
                    return true;
                }
                if (Jd2 != null) {
                    C7060h.pYm.mo8381e(12789, Integer.valueOf(2), Jd2.mo20410Aq(), Integer.valueOf(0), Jd2.field_designerID, Jd2.field_groupId, "", "", "", "", "", Jd2.field_activityid);
                }
                if (Jd2 == null) {
                    str = "";
                } else {
                    str = Jd2.field_groupId;
                }
                if (!C5046bo.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("preceding_scence", 3);
                    intent.putExtra("download_entrance_scene", 16);
                    intent.putExtra("extra_id", str);
                    C25985d.m41467b(c46650a.yTx.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
                AppMethodBeat.m2505o(31397);
                return true;
            case C44697b.CTRL_INDEX /*135*/:
                if (c7620bi.dtx()) {
                    Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                } else {
                    aps = C44218ap.aps(c7620bi.field_content);
                    X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
                    if (X == null) {
                        X = new C8910b();
                        X.fgq = aps.cvZ;
                        c8910b = X;
                    } else {
                        c8910b = X;
                    }
                    if (!(C5046bo.isNullOrNil(c8910b.fgq) || c8910b.fgq.equals("-1"))) {
                        Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
                    }
                    AppMethodBeat.m2505o(31397);
                    return true;
                }
                C7060h.pYm.mo8381e(12789, Integer.valueOf(5), Jd2.mo20410Aq(), Integer.valueOf(0), Jd2.field_designerID, Jd2.field_groupId, "", "", "", "", "", Jd2.field_activityid);
                C20423c.m31581an(c46650a.yTx.getContext(), Jd2.mo20410Aq());
                AppMethodBeat.m2505o(31397);
                return true;
            default:
                AppMethodBeat.m2505o(31397);
                return false;
        }
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31398);
        C4990ab.m7416i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
        C4879a.xxA.mo10052c(this.yPA);
        AppMethodBeat.m2505o(31398);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31399);
        C4990ab.m7416i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
        C4879a.xxA.mo10053d(this.yPA);
        AppMethodBeat.m2505o(31399);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31400);
        super.dDh();
        C4990ab.m7416i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
        C4879a.xxA.mo10053d(this.yPA);
        AppMethodBeat.m2505o(31400);
    }

    /* renamed from: bh */
    public final boolean mo48877bh(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31401);
        C4990ab.m7417i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", Long.valueOf(c7620bi.field_msgId));
        if (c7620bi.dtx()) {
            m48578bi(c7620bi);
            AppMethodBeat.m2505o(31401);
            return true;
        } else if (c7620bi.dty()) {
            m48577aT(c7620bi);
            AppMethodBeat.m2505o(31401);
            return true;
        } else {
            AppMethodBeat.m2505o(31401);
            return false;
        }
    }

    /* renamed from: bi */
    private void m48578bi(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31402);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            C4990ab.m7410d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
            if (!this.cgL.getTalkerUserName().equals("medianote")) {
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C32325e(c7620bi.field_talker, c7620bi.field_msgSvrId));
            }
            C36121ak.m59477aS(c7620bi);
            AppMethodBeat.m2505o(31402);
            return;
        }
        C23639t.m36492hO(this.cgL.yTx.getContext());
        AppMethodBeat.m2505o(31402);
    }

    /* renamed from: aT */
    private void m48577aT(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31403);
        C4990ab.m7410d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
        if (!this.cgL.getTalkerUserName().equals("medianote")) {
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C32325e(c7620bi.field_talker, c7620bi.field_msgSvrId));
        }
        C36121ak.m59478aT(c7620bi);
        this.cgL.mo74882qp(true);
        AppMethodBeat.m2505o(31403);
    }
}
