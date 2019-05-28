package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C32845h;
import com.tencent.p177mm.modelvideo.C32845h.C32846a;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25764e;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C45161i;
import com.tencent.p177mm.p190at.C6326m;
import com.tencent.p177mm.p190at.C6326m.C6327a;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.clk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.chatting.j */
public final class C40788j {

    /* renamed from: com.tencent.mm.ui.chatting.j$2 */
    static class C305442 implements C6327a {
        final /* synthetic */ long fFE;
        final /* synthetic */ long yIA;

        C305442(long j, long j2) {
            this.fFE = j;
            this.yIA = j2;
        }

        /* renamed from: a */
        public final void mo4586a(long j, int i, int i2, int i3) {
            AppMethodBeat.m2504i(30533);
            C4990ab.m7417i("MicroMsg.ChattingEditModeLogic", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.yIA);
                jf.setStatus(2);
                jf.mo14774eI(j);
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.yIA, jf);
                C45161i.m83148lB((int) this.fFE);
                AppMethodBeat.m2505o(30533);
                return;
            }
            C45161i.m83149lC((int) this.fFE);
            C45161i.m83148lB((int) this.fFE);
            AppMethodBeat.m2505o(30533);
        }
    }

    /* renamed from: av */
    public static boolean m70662av(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30539);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            AppMethodBeat.m2505o(30539);
            return true;
        }
        EmojiInfo Jd;
        if (c7620bi.dty()) {
            C8910b c8910b;
            C44218ap c44218ap = new C44218ap(c7620bi.field_content);
            C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
            if (X == null) {
                X = new C8910b();
                X.fgq = c44218ap.cvZ;
                c8910b = X;
            } else {
                c8910b = X;
            }
            Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
        } else {
            Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
        }
        if (Jd != null && (Jd.field_catalog == EmojiInfo.yaB || (!C5046bo.isNullOrNil(Jd.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(Jd.field_groupId)))) {
            AppMethodBeat.m2505o(30539);
            return false;
        } else if (Jd == null || !Jd.duU()) {
            AppMethodBeat.m2505o(30539);
            return false;
        } else {
            AppMethodBeat.m2505o(30539);
            return true;
        }
    }

    /* renamed from: aw */
    public static boolean m70663aw(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30540);
        if (c7620bi.dty()) {
            C8910b c8910b;
            C44218ap c44218ap = new C44218ap(c7620bi.field_content);
            C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
            if (X == null) {
                X = new C8910b();
                X.fgq = c44218ap.cvZ;
                c8910b = X;
            } else {
                c8910b = X;
            }
            if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq) == null) {
                AppMethodBeat.m2505o(30540);
                return false;
            }
        }
        AppMethodBeat.m2505o(30540);
        return true;
    }

    /* renamed from: ax */
    public static boolean m70664ax(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30541);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            AppMethodBeat.m2505o(30541);
            return true;
        }
        String oz;
        if (c7620bi.field_isSend == 0) {
            oz = C1829bf.m3763oz(c7620bi.field_content);
        } else {
            oz = c7620bi.field_content;
        }
        C8910b me = C8910b.m16064me(oz);
        if (me == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            AppMethodBeat.m2505o(30541);
            return false;
        }
        C40439f bT = C46494g.m87739bT(me.appId, false);
        if (bT == null || !bT.mo63847xy()) {
            AppMethodBeat.m2505o(30541);
            return false;
        }
        AppMethodBeat.m2505o(30541);
        return true;
    }

    /* renamed from: ay */
    public static boolean m70665ay(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30542);
        if (c7620bi.getType() == 419430449) {
            AppMethodBeat.m2505o(30542);
            return true;
        }
        AppMethodBeat.m2505o(30542);
        return false;
    }

    /* renamed from: az */
    public static boolean m70666az(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30543);
        if (c7620bi.getType() == 436207665 || c7620bi.getType() == 469762097) {
            AppMethodBeat.m2505o(30543);
            return true;
        }
        AppMethodBeat.m2505o(30543);
        return false;
    }

    /* renamed from: aA */
    public static boolean m70653aA(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30544);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
            AppMethodBeat.m2505o(30544);
            return true;
        }
        String oz;
        if (c7620bi.field_isSend == 0) {
            oz = C1829bf.m3763oz(c7620bi.field_content);
        } else {
            oz = c7620bi.field_content;
        }
        C8910b me = C8910b.m16064me(oz);
        if (me == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
            AppMethodBeat.m2505o(30544);
            return false;
        } else if (!(me.type == 33 && me.fiR == 3) && (!(me.type == 46 && me.fiR == 3) && (me.type != 44 || (me.fiR != 3 && me.fiY == 0 && me.mo20336cw(false))))) {
            AppMethodBeat.m2505o(30544);
            return false;
        } else {
            AppMethodBeat.m2505o(30544);
            return true;
        }
    }

    /* renamed from: eP */
    public static boolean m70674eP(List<C7620bi> list) {
        AppMethodBeat.m2504i(30545);
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
            AppMethodBeat.m2505o(30545);
            return true;
        }
        for (C7620bi c7620bi : list) {
            if (c7620bi.drD() || C40788j.m70662av(c7620bi) || c7620bi.dtw() || C40788j.m70664ax(c7620bi) || C40788j.m70665ay(c7620bi) || c7620bi.getType() == -1879048186 || C40788j.m70658aF(c7620bi) || C40788j.m70666az(c7620bi) || C40788j.m70657aE(c7620bi) || C40788j.m70653aA(c7620bi)) {
                AppMethodBeat.m2505o(30545);
                return true;
            } else if (C40788j.m70661aI(c7620bi)) {
                AppMethodBeat.m2505o(30545);
                return true;
            }
        }
        AppMethodBeat.m2505o(30545);
        return false;
    }

    /* renamed from: a */
    public static boolean m70652a(boolean z, List<C7620bi> list, C23698ah c23698ah) {
        boolean z2 = true;
        AppMethodBeat.m2504i(30546);
        C7620bi c7620bi;
        if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            AppMethodBeat.m2505o(30546);
            return false;
        } else if (list.size() != 1 || ((c23698ah == null || !c23698ah.dCJ()) && !z)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                boolean z3;
                c7620bi = (C7620bi) it.next();
                if ((c23698ah == null || !c23698ah.dCJ()) && !z) {
                    if (C40788j.m70654aB(c7620bi) || C40788j.m70655aC(c7620bi)) {
                        it.remove();
                        z3 = false;
                    }
                    z3 = z2;
                } else {
                    if (c7620bi.drD() || C40788j.m70662av(c7620bi) || C40788j.m70664ax(c7620bi) || C40788j.m70665ay(c7620bi) || c7620bi.getType() == -1879048186 || C40788j.m70658aF(c7620bi) || C40788j.m70666az(c7620bi) || ((C40788j.m70654aB(c7620bi) && (c23698ah == null || !c23698ah.dCJ())) || ((C40788j.m70655aC(c7620bi) && (c23698ah == null || !c23698ah.dCJ())) || c7620bi.getType() == 318767153 || C40788j.m70659aG(c7620bi) || C40788j.m70660aH(c7620bi) || C40788j.m70657aE(c7620bi) || C40788j.m70653aA(c7620bi)))) {
                        it.remove();
                        z2 = false;
                    }
                    z3 = z2;
                }
                z2 = z3;
            }
            AppMethodBeat.m2505o(30546);
            return z2;
        } else {
            c7620bi = (C7620bi) list.get(0);
            if (C40788j.m70659aG(c7620bi) || c7620bi.drD() || C40788j.m70662av(c7620bi) || C40788j.m70664ax(c7620bi) || C40788j.m70665ay(c7620bi) || c7620bi.getType() == -1879048186 || c7620bi.getType() == 318767153 || C40788j.m70658aF(c7620bi) || C40788j.m70666az(c7620bi) || C40788j.m70660aH(c7620bi) || C40788j.m70657aE(c7620bi) || C40788j.m70653aA(c7620bi)) {
                AppMethodBeat.m2505o(30546);
                return false;
            }
            AppMethodBeat.m2505o(30546);
            return true;
        }
    }

    /* renamed from: aB */
    private static boolean m70654aB(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30547);
        if (c7620bi != null) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me != null && me.type == 19) {
                C18348nt c18348nt = new C18348nt();
                c18348nt.cJY.type = 0;
                c18348nt.cJY.cKa = me.fgU;
                C4879a.xxA.mo10055m(c18348nt);
                C44099c c44099c = c18348nt.cJZ.cKi;
                if (c44099c != null) {
                    Iterator it = c44099c.fjr.iterator();
                    while (it.hasNext()) {
                        if (!C5046bo.isNullOrNil(((aar) it.next()).whr)) {
                            C4990ab.m7413e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", Integer.valueOf(((aar) it.next()).dataType));
                            AppMethodBeat.m2505o(30547);
                            return true;
                        }
                    }
                }
                if (me.fgU == null || !me.fgU.contains("<recordxml>")) {
                    AppMethodBeat.m2505o(30547);
                    return false;
                }
                AppMethodBeat.m2505o(30547);
                return true;
            }
        }
        AppMethodBeat.m2505o(30547);
        return false;
    }

    /* renamed from: aC */
    private static boolean m70655aC(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30548);
        if (c7620bi != null) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me != null && me.type == 24) {
                AppMethodBeat.m2505o(30548);
                return true;
            }
        }
        AppMethodBeat.m2505o(30548);
        return false;
    }

    /* renamed from: aD */
    public static boolean m70656aD(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30549);
        if (c7620bi != null) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me == null) {
                AppMethodBeat.m2505o(30549);
                return false;
            } else if (me.type == 6 || me.type == 5 || me.type == 19) {
                AppMethodBeat.m2505o(30549);
                return true;
            }
        }
        AppMethodBeat.m2505o(30549);
        return false;
    }

    /* renamed from: aE */
    public static boolean m70657aE(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30550);
        if (c7620bi == null || !c7620bi.drC()) {
            AppMethodBeat.m2505o(30550);
            return false;
        }
        boolean c = C1192l.m2622c(c7620bi.field_msgId, c7620bi.field_content);
        AppMethodBeat.m2505o(30550);
        return c;
    }

    /* renamed from: aF */
    static boolean m70658aF(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30551);
        if (c7620bi != null) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me != null && me.type == 16) {
                AppMethodBeat.m2505o(30551);
                return true;
            } else if (me != null && me.type == 34) {
                AppMethodBeat.m2505o(30551);
                return true;
            }
        }
        AppMethodBeat.m2505o(30551);
        return false;
    }

    /* renamed from: aG */
    static boolean m70659aG(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30552);
        if (c7620bi.dtw()) {
            C9638aw.m17190ZK();
            C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
            if (Rn == null || C5046bo.isNullOrNil(Rn.svN)) {
                AppMethodBeat.m2505o(30552);
                return true;
            } else if (C1855t.m3913mZ(Rn.svN)) {
                AppMethodBeat.m2505o(30552);
                return false;
            } else {
                AppMethodBeat.m2505o(30552);
                return true;
            }
        }
        AppMethodBeat.m2505o(30552);
        return false;
    }

    /* renamed from: aH */
    private static boolean m70660aH(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30553);
        if (c7620bi != null && c7620bi.bAA()) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me != null && me.type == 6 && (me.fgs != 0 || me.fgo > 26214400)) {
                AppMethodBeat.m2505o(30553);
                return true;
            }
        }
        AppMethodBeat.m2505o(30553);
        return false;
    }

    /* renamed from: aI */
    public static boolean m70661aI(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30554);
        if (c7620bi != null && c7620bi.bAA()) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (me != null && me.type == 6) {
                AppMethodBeat.m2505o(30554);
                return true;
            }
        }
        AppMethodBeat.m2505o(30554);
        return false;
    }

    /* renamed from: eQ */
    public static int m70675eQ(List<C7620bi> list) {
        int i = 0;
        AppMethodBeat.m2504i(30555);
        if (list == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            AppMethodBeat.m2505o(30555);
            return 0;
        }
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                C7620bi c7620bi = (C7620bi) it.next();
                if (c7620bi.drD() || C40788j.m70662av(c7620bi) || c7620bi.bAC() || C40788j.m70664ax(c7620bi) || C40788j.m70665ay(c7620bi) || C40788j.m70666az(c7620bi)) {
                    i = i2 + 1;
                } else {
                    i = i2;
                }
            } else {
                AppMethodBeat.m2505o(30555);
                return i2;
            }
        }
    }

    /* renamed from: eR */
    public static boolean m70676eR(List<C7620bi> list) {
        AppMethodBeat.m2504i(30556);
        if (list == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
            AppMethodBeat.m2505o(30556);
            return false;
        }
        for (C7620bi c7620bi : list) {
            C26493s uf;
            if (c7620bi.drE() || c7620bi.dtA()) {
                C25822e fI;
                C25822e c25822e = null;
                if (c7620bi.field_msgId > 0) {
                    c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                }
                if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                    fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                } else {
                    fI = c25822e;
                }
                if (fI != null && (fI.offset < fI.frO || fI.frO == 0)) {
                    AppMethodBeat.m2505o(30556);
                    return true;
                }
            } else if (c7620bi.bws()) {
                uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
                if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                    AppMethodBeat.m2505o(30556);
                    return true;
                }
            } else if (c7620bi.dty()) {
                if (!C40788j.m70663aw(c7620bi)) {
                    AppMethodBeat.m2505o(30556);
                    return true;
                }
            } else if (c7620bi.bAA()) {
                C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_content);
                if (X != null) {
                    switch (X.type) {
                        case 6:
                            C30065b aiE = C14877am.aUq().aiE(X.csD);
                            if (aiE != null) {
                                if (new C5728b(aiE.field_fileFullPath).exists()) {
                                    break;
                                }
                                AppMethodBeat.m2505o(30556);
                                return true;
                            }
                            AppMethodBeat.m2505o(30556);
                            return true;
                        default:
                            break;
                    }
                }
                AppMethodBeat.m2505o(30556);
                return true;
            } else if (c7620bi.bwt()) {
                uf = C26494u.m42268ut(c7620bi.field_imgPath);
                if (!(uf == null || uf.status == 199 || uf.status == 199)) {
                    AppMethodBeat.m2505o(30556);
                    return true;
                }
            } else {
                continue;
            }
        }
        AppMethodBeat.m2505o(30556);
        return false;
    }

    /* renamed from: eS */
    public static boolean m70677eS(List<C7620bi> list) {
        AppMethodBeat.m2504i(30557);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(30557);
            return false;
        }
        for (C7620bi c7620bi : list) {
            if (c7620bi.bws() && C30076j.aiB(c7620bi.field_imgPath)) {
                AppMethodBeat.m2505o(30557);
                return true;
            }
        }
        AppMethodBeat.m2505o(30557);
        return false;
    }

    /* renamed from: eT */
    public static boolean m70678eT(List<C7620bi> list) {
        AppMethodBeat.m2504i(30558);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(30558);
            return false;
        }
        for (C7620bi bwt : list) {
            if (bwt.bwt()) {
                AppMethodBeat.m2505o(30558);
                return true;
            }
        }
        AppMethodBeat.m2505o(30558);
        return false;
    }

    /* renamed from: v */
    public static String m70679v(String str, int i, boolean z) {
        AppMethodBeat.m2504i(30559);
        if (z && str != null && i == 0) {
            str = C1829bf.m3763oz(str);
        }
        AppMethodBeat.m2505o(30559);
        return str;
    }

    public static List<String> dBY() {
        String str;
        AppMethodBeat.m2504i(30560);
        List<String> le = C41747z.aeR().mo43727le(25);
        C25764e aeR = C41747z.aeR();
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40943a(stringBuilder);
        C25764e.m40948c(stringBuilder);
        C25764e.m40949d(stringBuilder);
        C25764e.m40945a(stringBuilder, true);
        stringBuilder.append(" order by ");
        stringBuilder.append(C25764e.aet());
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", stringBuilder.toString());
        Cursor rawQuery = aeR.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : arrayList) {
            String adX = C17903f.m28104qX(str2).adX();
            if (!C5046bo.isNullOrNil(adX)) {
                hashMap.put(adX, str2);
            }
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str22 : le) {
            if (!C17903f.m28107ra(str22)) {
                linkedList.add(str22);
            } else if (C17903f.m28111re(str22)) {
                str22 = C17903f.m28104qX(str22).field_enterpriseFather;
                if (!linkedList2.contains(str22) && C17903f.m28109rc(str22)) {
                    linkedList2.add(str22);
                    str22 = (String) hashMap.get(str22);
                    if (!C5046bo.isNullOrNil(str22)) {
                        linkedList2.add(str22);
                    }
                }
            }
        }
        for (String str222 : hashMap.values()) {
            if (!(C5046bo.isNullOrNil(str222) || linkedList2.contains(str222))) {
                linkedList2.add(str222);
            }
        }
        linkedList.addAll(linkedList2);
        C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(30560);
        return linkedList;
    }

    public static List<String> dBZ() {
        AppMethodBeat.m2504i(30561);
        List<String> le = C41747z.aeR().mo43727le(25);
        LinkedList linkedList = new LinkedList();
        for (String str : le) {
            if (!C17903f.m28107ra(str)) {
                linkedList.add(str);
            }
        }
        C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(30561);
        return linkedList;
    }

    /* renamed from: c */
    public static void m70672c(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.m2504i(30562);
        C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        String ug = C9720t.m17302ug(C1853r.m3846Yz());
        C37961o.all();
        C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", C9720t.m17303uh(str), C9720t.m17303uh(ug), C9720t.m17304ui(str), C9720t.m17304ui(ug));
        C5730e.m8644y(r1, r2);
        C5730e.m8644y(r3, r4);
        C26494u.m42239a(ug, i2, str2, null, i, str3, i3);
        C26494u.m42263uo(ug);
        AppMethodBeat.m2505o(30562);
    }

    /* renamed from: a */
    static boolean m70651a(Context context, String str, C7620bi c7620bi, String str2) {
        AppMethodBeat.m2504i(30563);
        if (context == null) {
            C4990ab.m7421w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", str2);
            AppMethodBeat.m2505o(30563);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", str2);
            AppMethodBeat.m2505o(30563);
            return false;
        } else if (c7620bi == null) {
            C4990ab.m7421w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", str2);
            AppMethodBeat.m2505o(30563);
            return false;
        } else {
            AppMethodBeat.m2505o(30563);
            return true;
        }
    }

    /* renamed from: a */
    public static void m70648a(Context context, String str, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30564);
        if (C40788j.m70651a(context, str, c7620bi, "emoji")) {
            String str2;
            String str3 = C44218ap.aps(c7620bi.field_content).cvZ;
            if (str3 == null || str3.endsWith("-1")) {
                str2 = c7620bi.field_imgPath;
            } else {
                str2 = str3;
            }
            if (str2 == null) {
                C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
                AppMethodBeat.m2505o(30564);
                return;
            }
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35663r(context, str, str2);
            AppMethodBeat.m2505o(30564);
            return;
        }
        AppMethodBeat.m2505o(30564);
    }

    /* renamed from: b */
    public static void m70667b(Context context, String str, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30565);
        if (C40788j.m70651a(context, str, c7620bi, "image")) {
            C25822e c25822e = null;
            if (c7620bi.field_msgId > 0) {
                c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
            }
            if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
            }
            if (c25822e == null) {
                AppMethodBeat.m2505o(30565);
                return;
            }
            int i = 0;
            if (c25822e.agQ() && !C37478f.m63225a(c25822e).fDz.startsWith("SERVERID://")) {
                i = 1;
            }
            String q = C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", "");
            String q2 = C32291o.ahl().mo73118q(c25822e.fDB, "th_", "");
            if (c25822e.offset < c25822e.frO || c25822e.frO == 0) {
                Object obj;
                final String Yz = C1853r.m3846Yz();
                final String str2 = c25822e.fDK;
                Map z = C5049br.m7595z(c25822e.fDK, "msg");
                if (z == null) {
                    C4990ab.m7413e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", c25822e.fDK);
                    obj = null;
                } else {
                    int i2;
                    String str3;
                    final int i3 = c25822e.fDC;
                    if (i3 != 1) {
                        i2 = 2;
                        str3 = (String) z.get(".msg.img.$cdnmidimgurl");
                    } else {
                        i2 = 1;
                        str3 = (String) z.get(".msg.img.$cdnbigimgurl");
                    }
                    C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", Integer.valueOf(i3), str3);
                    if (C5046bo.isNullOrNil(str3)) {
                        C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        String str4 = (String) z.get(".msg.img.$aeskey");
                        if (C5046bo.isNullOrNil(str4)) {
                            C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            if (C5046bo.isNullOrNil(C37458c.m63162a("downimg", (long) c25822e.fDG, c7620bi.field_talker, c7620bi.field_msgId))) {
                                C4990ab.m7421w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(c7620bi.field_msgSvrId));
                                obj = null;
                            } else {
                                final String str5 = (String) z.get(".msg.img.$md5");
                                C42130g c42130g = new C42130g();
                                final C7620bi c7620bi2 = c7620bi;
                                final String str6 = str;
                                final Context context2 = context;
                                c42130g.egl = new C1628a() {
                                    final /* synthetic */ int jOj = 4;

                                    /* JADX WARNING: Removed duplicated region for block: B:23:0x02bf  */
                                    /* JADX WARNING: Removed duplicated region for block: B:17:0x01aa  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    /* renamed from: a */
                                    public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                                        AppMethodBeat.m2504i(30532);
                                        if (c9545d != null) {
                                            if (c9545d.field_exist_whencheck) {
                                                long a;
                                                int i2;
                                                String a2;
                                                clk clk;
                                                C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", c9545d);
                                                C6575cy c6575cy = c7620bi2;
                                                int i3 = this.jOj;
                                                String str2 = str6;
                                                String str3 = Yz;
                                                String str4 = str2;
                                                String str5 = str5;
                                                int i4 = i3;
                                                String I = C32291o.ahl().mo73074I(c6575cy.field_imgPath, true);
                                                PString pString = new PString();
                                                PInt pInt = new PInt();
                                                PInt pInt2 = new PInt();
                                                pString.value = "";
                                                C6575cy c7620bi = new C7620bi();
                                                c7620bi.setType(C1855t.m3926nL(str2));
                                                c7620bi.mo14794ju(str2);
                                                c7620bi.mo14781hO(1);
                                                c7620bi.setStatus(1);
                                                c7620bi.mo14775eJ(C1829bf.m3756oC(c7620bi.field_talker));
                                                c7620bi.setContent(str4);
                                                C26350a.m41930KG().mo35238g(c7620bi);
                                                long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
                                                Assert.assertTrue(Z >= 0);
                                                C4990ab.m7416i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
                                                if (i4 == 1) {
                                                    a = C32291o.ahl().mo73082a(null, Z, true, c7620bi.field_content, pString, pInt, pInt2);
                                                } else {
                                                    a = 0;
                                                }
                                                long a3 = C32291o.ahl().mo73082a(null, Z, false, c7620bi.field_content, pString, pInt, pInt2);
                                                Map z2 = C5049br.m7595z(str4, "msg");
                                                int i5 = C5046bo.getInt((String) z2.get(".msg.img.$length"), c9545d.field_thumbimgLength);
                                                C25822e b = C32291o.ahl().mo73105b(Long.valueOf(a3));
                                                b.mo43793fG((long) ((int) Z));
                                                if (a3 > 0) {
                                                    C4990ab.m7417i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", C32291o.ahl().mo73106b(pString.value, "th_", "", false));
                                                    C5730e.m8644y(I, r9);
                                                    c7620bi.mo14795jv(pString.value);
                                                    c7620bi.mo14784hZ(c6575cy.dJw);
                                                    c7620bi.mo14786ia(c6575cy.dJx);
                                                    if (a > 0) {
                                                        b.mo43801lx(1);
                                                        b.mo43798lu((int) a);
                                                        i2 = C5046bo.getInt((String) z2.get(".msg.img.$hdlength"), c9545d.field_thumbimgLength);
                                                        C32291o.ahl().mo73077a(Long.valueOf(a3), b);
                                                        if (i4 != 1) {
                                                            b = C32291o.ahl().mo73105b(Long.valueOf(a));
                                                        } else {
                                                            a = a3;
                                                        }
                                                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(Z, (C7620bi) c7620bi);
                                                        C32291o.ahl().mo73077a(Long.valueOf(a), b);
                                                        a2 = C37458c.m63162a("upimg", c7620bi.field_createTime, c7620bi.field_talker, c7620bi.field_msgId + "_" + a + "_" + i4);
                                                        clk = new clk();
                                                        clk.vEB = new bts().alV(str3);
                                                        clk.vEC = new bts().alV(str2);
                                                        clk.nao = c7620bi.getType();
                                                        clk.vEG = c7620bi.dqJ;
                                                        clk.vRz = b.fDD;
                                                        clk.xja = new bts().alV(a2);
                                                        clk.wqw = i4;
                                                        c9545d.field_filemd5 = str5;
                                                        c9545d.field_thumbimgLength = (int) C5730e.asZ(I);
                                                        c9545d.field_fileLength = i2;
                                                        C1720g.m3540Rg().mo14541a(new C6326m(i3, clk, b, c9545d, new C305442(a3, Z)), 0);
                                                    }
                                                }
                                                i2 = i5;
                                                C32291o.ahl().mo73077a(Long.valueOf(a3), b);
                                                if (i4 != 1) {
                                                }
                                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(Z, (C7620bi) c7620bi);
                                                C32291o.ahl().mo73077a(Long.valueOf(a), b);
                                                a2 = C37458c.m63162a("upimg", c7620bi.field_createTime, c7620bi.field_talker, c7620bi.field_msgId + "_" + a + "_" + i4);
                                                clk = new clk();
                                                clk.vEB = new bts().alV(str3);
                                                clk.vEC = new bts().alV(str2);
                                                clk.nao = c7620bi.getType();
                                                clk.vEG = c7620bi.dqJ;
                                                clk.vRz = b.fDD;
                                                clk.xja = new bts().alV(a2);
                                                clk.wqw = i4;
                                                c9545d.field_filemd5 = str5;
                                                c9545d.field_thumbimgLength = (int) C5730e.asZ(I);
                                                c9545d.field_fileLength = i2;
                                                C1720g.m3540Rg().mo14541a(new C6326m(i3, clk, b, c9545d, new C305442(a3, Z)), 0);
                                            } else {
                                                C4990ab.m7410d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                                                C40788j.m70647a(context2, c25822e, c7620bi2, this.jOj, str6, C32291o.ahl().mo73118q(c25822e.fDB, "th_", ""));
                                            }
                                        }
                                        AppMethodBeat.m2505o(30532);
                                        return 0;
                                    }

                                    /* renamed from: a */
                                    public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                    }

                                    /* renamed from: l */
                                    public final byte[] mo5084l(String str, byte[] bArr) {
                                        return new byte[0];
                                    }
                                };
                                c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), str, c7620bi.field_msgId);
                                c42130g.field_fileId = str3;
                                c42130g.field_aesKey = str4;
                                c42130g.field_filemd5 = str5;
                                c42130g.field_fileType = i2;
                                c42130g.field_talker = str;
                                c42130g.field_priority = C42129a.efC;
                                c42130g.field_svr_signature = "";
                                c42130g.field_onlycheckexist = true;
                                c42130g.field_trysafecdn = true;
                                if (C37461f.afx().mo51225e(c42130g)) {
                                    obj = 1;
                                } else {
                                    C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
                                    obj = null;
                                }
                            }
                        }
                    }
                }
                if (obj == null) {
                    C40788j.m70647a(context, c25822e, c7620bi, 4, str, q2);
                }
                AppMethodBeat.m2505o(30565);
                return;
            }
            if (!C5046bo.isNullOrNil(q)) {
                C12519g.bOk().mo46457a(context, str, q, i, c25822e.fDK, q2);
            }
            AppMethodBeat.m2505o(30565);
            return;
        }
        AppMethodBeat.m2505o(30565);
    }

    /* renamed from: a */
    static void m70647a(final Context context, final C25822e c25822e, C7620bi c7620bi, int i, String str, String str2) {
        AppMethodBeat.m2504i(30566);
        String q = C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", "");
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = q;
        int i2 = c25822e.fDC;
        long a = C32291o.ahl().mo73079a(q, i2, i, pString, pInt, pInt2);
        C25822e b = C32291o.ahl().mo73105b(Long.valueOf(a));
        b.mo43800lw(1);
        C7620bi c7620bi2 = new C7620bi();
        c7620bi2.setType(C1855t.m3926nL(str));
        c7620bi2.mo14794ju(str);
        c7620bi2.mo14781hO(1);
        c7620bi2.setStatus(1);
        c7620bi2.mo14795jv(pString.value);
        c7620bi2.mo14784hZ(pInt.value);
        c7620bi2.mo14786ia(pInt2.value);
        c7620bi2.mo14775eJ(C1829bf.m3756oC(c7620bi2.field_talker));
        if (C17903f.m28103kq(c7620bi2.field_talker)) {
            c7620bi.mo14791ix(C25754e.aae());
        }
        C9638aw.m17190ZK();
        long Z = C18628c.m29080XO().mo15281Z(c7620bi2);
        Assert.assertTrue(Z >= 0);
        C4990ab.m7416i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
        b.mo43793fG((long) ((int) Z));
        C32291o.ahl().mo73077a(Long.valueOf(a), b);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(Z), c25822e);
        final String str3 = str;
        final String str4 = str2;
        C32291o.ahm().mo33467a(c25822e.fDy, c7620bi.field_msgId, i2, hashMap, C25738R.drawable.b0p, new C9017a() {
            /* renamed from: a */
            public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
            }

            /* renamed from: a */
            public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
                Object obj2;
                AppMethodBeat.m2504i(30534);
                if (i3 == 0 && i4 == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj instanceof HashMap) {
                    HashMap hashMap = (HashMap) obj;
                    if (hashMap != null) {
                        for (Entry entry : hashMap.entrySet()) {
                            Long l = (Long) entry.getKey();
                            String q = C32291o.ahl().mo73118q(C37478f.m63227c((C25822e) entry.getValue()), "", "");
                            if (obj2 != null) {
                                C9638aw.m17190ZK();
                                C18628c.m29080XO().mo15341jg(l.longValue());
                                C12519g.bOk().mo46457a(context, str3, q, i, c25822e.fDK, str4);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(30534);
            }

            /* renamed from: a */
            public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
            }
        });
        AppMethodBeat.m2505o(30566);
    }

    /* renamed from: e */
    static void m70673e(final String str, final C7620bi c7620bi) {
        AppMethodBeat.m2504i(30567);
        C9638aw.m17180RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.ui.chatting.j$5$1 */
            class C305461 implements C9721a {
                C305461() {
                }

                /* renamed from: a */
                public final void mo11381a(C9718a c9718a) {
                    AppMethodBeat.m2504i(30537);
                    C26493s ut = C26494u.m42268ut(c9718a.fileName);
                    if (ut != null && ut.status == 199) {
                        C40788j.m70672c(c7620bi.field_imgPath, str, ut.fXh, ut.fXd, ut.alw(), c7620bi.getType());
                    }
                    AppMethodBeat.m2505o(30537);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(30538);
                C37961o.alq().mo44278a(c7620bi.field_imgPath, new C305461());
                AppMethodBeat.m2505o(30538);
            }
        });
        AppMethodBeat.m2505o(30567);
    }

    /* renamed from: c */
    public static void m70670c(Context context, String str, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30568);
        if (!C40788j.m70651a(context, str, c7620bi, "video") || c7620bi == null) {
            AppMethodBeat.m2505o(30568);
        } else if (c7620bi != null && c7620bi.bwt() && C26494u.m42270uv(c7620bi.field_imgPath)) {
            AppMethodBeat.m2505o(30568);
        } else {
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            if (ut == null || ut.status != 199) {
                Object obj;
                Map z = C5049br.m7595z(ut.alw(), "msg");
                if (z == null) {
                    C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
                    obj = null;
                } else {
                    final String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                    if (C5046bo.isNullOrNil(str2)) {
                        obj = null;
                    } else {
                        final String str3 = (String) z.get(".msg.videomsg.$aeskey");
                        final String str4 = (String) z.get(".msg.videomsg.$md5");
                        final String str5 = (String) z.get(".msg.videomsg.$newmd5");
                        final int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
                        final int i = C5046bo.getInt((String) z.get(".msg.videomsg.$playlength"), 0);
                        final int i2 = C5046bo.getInt((String) z.get(".msg.videomsg.$cdnthumblength"), 0);
                        C42130g c42130g = new C42130g();
                        final String str6 = str;
                        final C7620bi c7620bi2 = c7620bi;
                        c42130g.egl = new C1628a() {
                            /* renamed from: a */
                            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                                AppMethodBeat.m2504i(30536);
                                if (c9545d != null) {
                                    if (c9545d.field_exist_whencheck) {
                                        c9545d.field_fileId = str2;
                                        c9545d.field_aesKey = str3;
                                        c9545d.field_thumbimgLength = i2;
                                        c9545d.field_fileLength = intValue;
                                        c9545d.field_toUser = str6;
                                        c9545d.field_filemd5 = str4;
                                        c9545d.field_mp4identifymd5 = str5;
                                        C4990ab.m7417i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", c9545d);
                                        final String ug = C9720t.m17302ug(C1853r.m3846Yz());
                                        C37961o.all();
                                        String ui = C9720t.m17304ui(ug);
                                        C37961o.all();
                                        C5730e.m8644y(C9720t.m17304ui(c7620bi2.field_imgPath), ui);
                                        C4990ab.m7417i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + str3 + "\" cdnthumbaeskey=\"" + str3 + "\" cdnvideourl=\"" + str2 + "\" ") + "cdnthumburl=\"" + str2 + "\" ") + "length=\"" + intValue + "\" ") + "cdnthumblength=\"" + i2 + "\"/></msg>");
                                        C26494u.m42248d(ug, i, str6, ui);
                                        C1720g.m3540Rg().mo14541a(new C32845h(ug, 0, c9545d, new C32846a() {
                                            /* renamed from: cC */
                                            public final void mo39619cC(int i, int i2) {
                                                AppMethodBeat.m2504i(30535);
                                                C26493s ut = C26494u.m42268ut(ug);
                                                ut.status = 111;
                                                ut.bJt = 256;
                                                C37961o.all().mo21060c(ut);
                                                C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
                                                AppMethodBeat.m2505o(30535);
                                            }
                                        }), 0);
                                    } else {
                                        C40788j.m70673e(str6, c7620bi2);
                                    }
                                }
                                AppMethodBeat.m2505o(30536);
                                return 0;
                            }

                            /* renamed from: a */
                            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                            }

                            /* renamed from: l */
                            public final byte[] mo5084l(String str, byte[] bArr) {
                                return new byte[0];
                            }
                        };
                        c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), str, c7620bi.field_msgId);
                        c42130g.field_fileId = str2;
                        c42130g.field_aesKey = str3;
                        c42130g.field_filemd5 = str4;
                        c42130g.field_fileType = C42129a.MediaType_VIDEO;
                        c42130g.field_talker = str;
                        c42130g.field_priority = C42129a.efC;
                        c42130g.field_svr_signature = "";
                        c42130g.field_onlycheckexist = true;
                        c42130g.field_trysafecdn = true;
                        if (C37461f.afx().mo51225e(c42130g)) {
                            obj = 1;
                        } else {
                            C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
                            obj = null;
                        }
                    }
                }
                if (obj == null) {
                    C40788j.m70673e(str, c7620bi);
                }
                AppMethodBeat.m2505o(30568);
                return;
            }
            C40788j.m70672c(c7620bi.field_imgPath, str, ut.fXh, ut.fXd, ut.alw(), c7620bi.getType());
            AppMethodBeat.m2505o(30568);
        }
    }

    /* renamed from: a */
    public static void m70649a(Context context, String str, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(30569);
        if (C40788j.m70651a(context, str, c7620bi, "text")) {
            String v = C40788j.m70679v(c7620bi.field_content, c7620bi.field_isSend, z);
            if (c7620bi.dtM()) {
                v = v + "\n\n" + C40788j.m70679v(c7620bi.field_transContent, c7620bi.field_isSend, z);
            }
            if (v == null || v.equals("")) {
                C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
                AppMethodBeat.m2505o(30569);
                return;
            }
            C12519g.bOk().mo46456F(str, v, C1855t.m3925nK(str));
            AppMethodBeat.m2505o(30569);
            return;
        }
        AppMethodBeat.m2505o(30569);
    }

    /* renamed from: b */
    public static void m70668b(Context context, String str, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(30570);
        if (!C40788j.m70651a(context, str, c7620bi, "appmsg")) {
            AppMethodBeat.m2505o(30570);
        } else if (context == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
            AppMethodBeat.m2505o(30570);
        } else if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
            AppMethodBeat.m2505o(30570);
        } else {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                String str2;
                String c = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, false);
                if (C42252ah.isNullOrNil(c) || c.endsWith("hd") || !C5730e.m8628ct(c + "hd")) {
                    str2 = c;
                } else {
                    str2 = c + "hd";
                }
                try {
                    C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
                    LinkedList<C32224p> linkedList = b.fjr;
                    if (linkedList == null || linkedList.size() <= 0) {
                        if (c7620bi == null || !(c7620bi.bAA() || c7620bi.drC())) {
                            c = null;
                        } else {
                            String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                            C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                            y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                            y.mo53356j("preUsername", C5378c.m8122a(c7620bi, z, false));
                            y.mo53356j("preChatName", c7620bi.field_talker);
                            y.mo53356j("preMsgIndex", Integer.valueOf(0));
                            y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                            ((C46210i) C1720g.m3528K(C46210i.class)).mo55530a("adExtStr", y, c7620bi);
                            c = nW;
                        }
                        C12519g.bOk().mo46460a(str, C5046bo.readFromFile(str2), C5046bo.anj(c7620bi.field_content), c);
                        AppMethodBeat.m2505o(30570);
                        return;
                    }
                    for (C32224p c32224p : linkedList) {
                        C8910b c8910b = new C8910b();
                        if (C1192l.m2624mg(c32224p.fjC)) {
                            C44312l.m80096b(str, C44312l.m80095a(str, c32224p), c32224p.fjH);
                        } else {
                            c8910b.title = c32224p.title;
                            c8910b.description = c32224p.fjz;
                            c8910b.action = "view";
                            c8910b.type = 5;
                            c8910b.url = c32224p.url;
                            c8910b.cMg = b.cMg;
                            c8910b.cMh = b.cMh;
                            c8910b.dJv = b.dJv;
                            c8910b.thumburl = C1192l.m2619a(c32224p);
                            C37435f c25747e = new C25747e();
                            c25747e.ffZ = c32224p.type;
                            if (c32224p.type == 5) {
                                c25747e.fgd = c32224p.fgd;
                                c25747e.fga = (int) c32224p.time;
                                c25747e.duration = c32224p.fjB;
                                c25747e.videoWidth = c32224p.videoWidth;
                                c25747e.videoHeight = c32224p.videoHeight;
                            }
                            c8910b.mo20334a(c25747e);
                            if (C5046bo.isNullOrNil(c8910b.thumburl) && !C5046bo.isNullOrNil(c8910b.cMg)) {
                                C17880h qo = C17884o.act().mo33392qo(c8910b.cMg);
                                if (qo != null) {
                                    c8910b.thumburl = qo.ack();
                                }
                            }
                            C12519g.bOk().mo46460a(str, C5046bo.readFromFile(str2), C5046bo.anj(C8910b.m16061a(c8910b, null, null)), null);
                        }
                    }
                    AppMethodBeat.m2505o(30570);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    C4990ab.m7413e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", e.getLocalizedMessage());
                    AppMethodBeat.m2505o(30570);
                    return;
                }
            }
            AppMethodBeat.m2505o(30570);
        }
    }

    /* renamed from: c */
    public static void m70671c(Context context, String str, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(30571);
        if (C40788j.m70651a(context, str, c7620bi, C8741b.LOCATION)) {
            C12519g.bOk().mo46456F(str, C40788j.m70679v(c7620bi.field_content, c7620bi.field_isSend, z), 48);
            AppMethodBeat.m2505o(30571);
            return;
        }
        AppMethodBeat.m2505o(30571);
    }

    /* renamed from: a */
    public static void m70650a(Context context, String str, String str2, int i, boolean z) {
        AppMethodBeat.m2504i(30572);
        try {
            C7620bi c7620bi = new C7620bi();
            c7620bi.setContent(str2);
            c7620bi.mo14781hO(i);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map z2 = C5049br.m7595z(str2, "msg");
            if (z2 != null && z2.size() > 0) {
                c7620bi.mo14796jw(C5035be.m7492aS(z2));
            }
            C40788j.m70668b(context, str, c7620bi, z);
            AppMethodBeat.m2505o(30572);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
            AppMethodBeat.m2505o(30572);
        }
    }

    /* renamed from: b */
    public static void m70669b(EmojiInfo emojiInfo, String str) {
        AppMethodBeat.m2504i(30573);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29093Yb()).append(emojiInfo.mo20410Aq()).toString();
        if (C5730e.asZ(stringBuilder2 + "_thumb") > 0) {
            wXMediaMessage.thumbData = C5730e.m8632e(stringBuilder2 + "_thumb", 0, (int) C5730e.asZ(stringBuilder2 + "_thumb"));
        } else {
            try {
                InputStream openRead = C5730e.openRead(stringBuilder2);
                wXMediaMessage.setThumbImage(C4977b.m7372b(openRead, 1.0f));
                openRead.close();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
        C4733l.m7090a(wXMediaMessage, emojiInfo.field_app_id, null, str, 1, emojiInfo.mo20410Aq());
        AppMethodBeat.m2505o(30573);
    }
}
