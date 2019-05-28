package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.p;
import com.tencent.mm.at.e;
import com.tencent.mm.at.f;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.n;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.j;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class k {
    private static a yIH = new a();

    static class a {
        cl cJy;
        String cKf;
        boolean yFW;
        List<bi> yIP;
        d yIQ;
        ah yIw;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static /* synthetic */ void c(Context context, List list, boolean z, String str, ah ahVar) {
        AppMethodBeat.i(30587);
        b(context, list, z, str, ahVar);
        AppMethodBeat.o(30587);
    }

    static {
        AppMethodBeat.i(30589);
        AppMethodBeat.o(30589);
    }

    public static void a(Context context, List<bi> list, boolean z, String str, ah ahVar) {
        AppMethodBeat.i(30580);
        dCa();
        if (context == null) {
            ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
            AppMethodBeat.o(30580);
        } else if (list == null || list.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
            AppMethodBeat.o(30580);
        } else {
            for (bi aO : list) {
                if (!ac.aO(aO)) {
                    t.makeText(context, R.string.dal, 0).show();
                    AppMethodBeat.o(30580);
                    return;
                }
            }
            if (j.a(false, (List) list, ahVar)) {
                Object obj;
                if (list != null && !list.isEmpty()) {
                    for (bi aO2 : list) {
                        String str2 = null;
                        if (!aO2.dtH()) {
                            if (aO2.drE()) {
                                e eVar = null;
                                if (aO2.field_msgId > 0) {
                                    eVar = o.ahl().fJ(aO2.field_msgId);
                                }
                                if ((eVar == null || eVar.fDy <= 0) && aO2.field_msgSvrId > 0) {
                                    eVar = o.ahl().fI(aO2.field_msgSvrId);
                                }
                                if (eVar != null) {
                                    str2 = o.ahl().q(f.c(eVar), "", "");
                                }
                            } else if (aO2.bwt() || aO2.bws()) {
                                com.tencent.mm.modelvideo.o.all();
                                str2 = com.tencent.mm.modelvideo.t.uh(aO2.field_imgPath);
                            } else if (aO2.bAA()) {
                                b me = b.me(aO2.field_content);
                                if (me != null) {
                                    com.tencent.mm.pluginsdk.model.app.b aiM = l.aiM(me.csD);
                                    if (aiM != null) {
                                        str2 = aiM.field_fileFullPath;
                                    }
                                }
                            } else {
                                str2 = aO2.field_imgPath;
                            }
                            if (aO2.drE() || aO2.bws() || aO2.bwt() || j.aI(aO2)) {
                                if (System.currentTimeMillis() - aO2.field_createTime <= 259200000 || (!bo.isNullOrNil(str2) && com.tencent.mm.vfs.e.ct(str2))) {
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                                if (obj == null) {
                                }
                            }
                            obj = null;
                            break;
                        }
                    }
                } else {
                    ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
                }
                obj = 1;
                if (obj != null) {
                    ab.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
                    if (ahVar != null && (ahVar.dCJ() || list.size() == 1)) {
                        h.a(context, context.getString(R.string.bio), context.getString(R.string.tz), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(30580);
                        return;
                    }
                }
                b(context, list, z, str, ahVar);
                AppMethodBeat.o(30580);
                return;
            }
            final List<bi> list2 = list;
            final ah ahVar2 = ahVar;
            final Context context2 = context;
            final boolean z2 = z;
            final String str3 = str;
            h.d(context, context.getString(R.string.ce3), "", context.getString(R.string.tf), context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Object obj;
                    AppMethodBeat.i(30574);
                    List<bi> list = list2;
                    if (list != null && !list.isEmpty()) {
                        for (bi biVar : list) {
                            if (!j.aA(biVar)) {
                                if (!biVar.drD() && !j.av(biVar) && !j.ax(biVar) && !j.aG(biVar) && !j.ay(biVar) && biVar.getType() != -1879048186 && !j.aF(biVar) && !j.az(biVar) && !j.aE(biVar) && !j.aA(biVar) && biVar.getType() != 318767153) {
                                    obj = null;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    ab.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
                    obj = 1;
                    if (obj != null) {
                        ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
                        if (ahVar2 != null) {
                            ahVar2.b(com.tencent.mm.ui.chatting.ah.a.trans);
                        }
                        AppMethodBeat.o(30574);
                        return;
                    }
                    k.c(context2, list2, z2, str3, ahVar2);
                    AppMethodBeat.o(30574);
                }
            }, null);
            AppMethodBeat.o(30580);
        }
    }

    private static void e(Context context, List<bi> list) {
        AppMethodBeat.i(30581);
        for (bi biVar : list) {
            if (bh.o(biVar)) {
                switch (biVar.getType() & CdnLogic.kBizGeneric) {
                    case 1:
                        biVar.setContent(context.getString(R.string.tx));
                        break;
                    case 3:
                        biVar.setContent(context.getString(R.string.sn));
                        biVar.setType(1);
                        break;
                    case 43:
                        biVar.setContent(context.getString(R.string.ud));
                        biVar.setType(1);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        biVar.setContent(context.getString(R.string.u7));
                        biVar.setType(1);
                        break;
                }
                bh.p(biVar);
            }
        }
        AppMethodBeat.o(30581);
    }

    private static void b(Context context, List<bi> list, boolean z, String str, final ah ahVar) {
        AppMethodBeat.i(30582);
        if (j.eS(list)) {
            h.a(context, context.getString(R.string.b2y), "", context.getString(R.string.aj), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(30575);
                    if (ahVar != null) {
                        ah ahVar = ahVar;
                        com.tencent.mm.ui.chatting.ah.a aVar = com.tencent.mm.ui.chatting.ah.a.trans;
                        ahVar.dCI();
                    }
                    AppMethodBeat.o(30575);
                }
            });
            AppMethodBeat.o(30582);
            return;
        }
        int i;
        e(context, list);
        yIH.yIP = new LinkedList(list);
        yIH.yFW = z;
        yIH.yIw = ahVar;
        yIH.cKf = str;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (list.size() == 1) {
            int i2;
            bi biVar = (bi) list.get(0);
            if (biVar.bAA() || biVar.drC()) {
                String nW = v.nW(biVar.field_msgSvrId);
                v.b y = v.Zp().y(nW, true);
                y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
                y.j("preUsername", c.a(biVar, z, false));
                y.j("preChatName", biVar.field_talker);
                y.j("preMsgIndex", Integer.valueOf(0));
                y.j("sendAppMsgScene", Integer.valueOf(1));
                y.j("moreRetrAction", Boolean.TRUE);
                if (z) {
                    y.j("fromScene", Integer.valueOf(2));
                } else {
                    y.j("fromScene", Integer.valueOf(1));
                }
                ((i) g.K(i.class)).a("adExtStr", y, biVar);
                intent.putExtra("reportSessionId", nW);
            }
            String str2 = biVar.field_content;
            int i3 = 12;
            s ut;
            if (biVar.bAC()) {
                i3 = 9;
            } else if (biVar.dtx()) {
                i3 = 5;
                intent.putExtra("Retr_File_Name", biVar.field_imgPath);
            } else if (biVar.dtw()) {
                i3 = 8;
            } else if (biVar.isText()) {
                i3 = 4;
                if (z && biVar.field_isSend == 0) {
                    str2 = bf.oz(str2);
                }
            } else if (biVar.drE()) {
                String I;
                e eVar = null;
                if (biVar.field_msgId > 0) {
                    eVar = o.ahl().fJ(biVar.field_msgId);
                }
                if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                    eVar = o.ahl().fI(biVar.field_msgSvrId);
                }
                if (eVar.offset < eVar.frO || eVar.frO == 0) {
                    I = o.ahl().I(biVar.field_imgPath, true);
                } else {
                    I = o.ahl().q(f.c(eVar), "", "");
                }
                intent.putExtra("Retr_File_Name", I);
                i3 = 0;
            } else if (biVar.bwt()) {
                ut = u.ut(biVar.field_imgPath);
                if (ut != null) {
                    intent.putExtra("Retr_length", ut.fXd);
                }
                i3 = 11;
                intent.putExtra("Retr_File_Name", biVar.field_imgPath);
            } else if (biVar.bws()) {
                ut = u.ut(biVar.field_imgPath);
                if (ut != null) {
                    intent.putExtra("Retr_length", ut.fXd);
                }
                i3 = 1;
                intent.putExtra("Retr_File_Name", biVar.field_imgPath);
            } else if (biVar.bAA()) {
                b me = b.me(str2);
                if (me != null && 19 == me.type) {
                    i3 = 10;
                } else if (me != null && 24 == me.type) {
                    i3 = 10;
                } else if (me == null || 16 != me.type) {
                    i3 = 2;
                } else {
                    i3 = 14;
                }
                if (biVar.drC()) {
                    intent.putExtra("is_group_chat", z);
                }
            }
            if (biVar.drC()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (ahVar == null || ahVar.dCJ()) {
                intent.putExtra("Retr_Msg_Type", i3);
            } else {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            }
            intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
            intent.putExtra("Retr_Msg_content", str2);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i = i2;
        } else if ((ahVar == null || !ahVar.dCJ()) && ((!com.tencent.mm.model.t.mZ(str) || com.tencent.mm.aj.f.kq(str)) && !com.tencent.mm.model.t.nJ(str))) {
            intent.putExtra("Retr_Msg_Type", 13);
            intent.putExtra("Retr_Multi_Msg_List_from", str);
            i = 2;
        } else {
            intent.putExtra("Retr_Msg_Type", 12);
            i = 2;
        }
        intent.putExtra("Retr_MsgFromScene", i);
        intent.putExtra("Retr_show_success_tips", true);
        context.startActivity(intent);
        l.eU(yIH.yIP);
        AppMethodBeat.o(30582);
    }

    public static void l(Context context, String str, boolean z) {
        AppMethodBeat.i(30583);
        nt ntVar = new nt();
        ntVar.cJY.type = 5;
        ntVar.cJY.cKe = yIH.yIP;
        ntVar.cJY.toUser = str;
        ntVar.cJY.cKf = yIH.cKf;
        ntVar.cJY.context = context;
        ntVar.cJY.cJy = yIH.cJy;
        ntVar.cJY.cKh = yIH.yIQ;
        com.tencent.mm.sdk.b.a.xxA.m(ntVar);
        if (yIH.yIP != null) {
            com.tencent.mm.plugin.report.service.h.pYm.e(10811, Integer.valueOf(8), Integer.valueOf(yIH.yIP.size()), Integer.valueOf(yIH.yIP.size() - j.eQ(yIH.yIP)));
            for (bi biVar : yIH.yIP) {
                long anT = bo.anT();
                b me = b.me(bo.anj(biVar.field_content));
                if (!(me == null || me.type != 5 || bo.isNullOrNil(me.url))) {
                    int i;
                    if (biVar.drC()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = "";
                    try {
                        str2 = URLEncoder.encode(me.url, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        ab.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e, "", new Object[0]);
                    }
                    ab.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(anT), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                    com.tencent.mm.plugin.report.service.h.pYm.e(13378, str2, Long.valueOf(anT), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        if (z && yIH.yIw != null) {
            yIH.yIw.b(com.tencent.mm.ui.chatting.ah.a.trans);
        }
        AppMethodBeat.o(30583);
    }

    public static void qo(boolean z) {
        AppMethodBeat.i(30584);
        if (z && yIH.yIw != null) {
            yIH.yIw.b(com.tencent.mm.ui.chatting.ah.a.trans);
        }
        AppMethodBeat.o(30584);
    }

    public static nt hS(Context context) {
        AppMethodBeat.i(30585);
        nt ntVar = new nt();
        ntVar.cJY.type = 6;
        ntVar.cJY.cKe = yIH.yIP;
        ntVar.cJY.cKf = yIH.cKf;
        ntVar.cJY.context = context;
        com.tencent.mm.sdk.b.a.xxA.m(ntVar);
        yIH.cJy = ntVar.cJZ.cJy;
        yIH.yIQ = ntVar.cJZ.cKh;
        AppMethodBeat.o(30585);
        return ntVar;
    }

    public static void m(final Context context, final String str, final boolean z) {
        AppMethodBeat.i(30586);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
            AppMethodBeat.o(30586);
        } else if (yIH.yIP == null || yIH.yIP.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
            AppMethodBeat.o(30586);
        } else {
            ab.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", str);
            j.yOM.e(new com.tencent.mm.sdk.platformtools.az.a() {
                final /* synthetic */ Runnable cfC = null;

                public final boolean acf() {
                    AppMethodBeat.i(30576);
                    if (k.yIH.yIP == null) {
                        AppMethodBeat.o(30576);
                        return false;
                    }
                    for (bi d : k.yIH.yIP) {
                        k.d(context, str, d, k.yIH.yFW);
                    }
                    AppMethodBeat.o(30576);
                    return true;
                }

                public final boolean acg() {
                    AppMethodBeat.i(30577);
                    if (k.yIH.yIP != null) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10811, Integer.valueOf(5), Integer.valueOf(k.yIH.yIP.size()), Integer.valueOf(k.yIH.yIP.size() - j.eQ(k.yIH.yIP)));
                    }
                    if (z) {
                        if (this.cfC != null) {
                            ab.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                            this.cfC.run();
                        }
                        if (k.yIH.yIw != null) {
                            k.yIH.yIw.b(com.tencent.mm.ui.chatting.ah.a.trans);
                        }
                        k.dCa();
                    }
                    AppMethodBeat.o(30577);
                    return true;
                }
            });
            AppMethodBeat.o(30586);
        }
    }

    public static void dCa() {
        yIH.yIP = null;
        yIH.yFW = false;
        yIH.yIw = null;
        yIH.cKf = null;
        yIH.cJy = null;
        yIH.yIQ = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void d(Context context, String str, bi biVar, boolean z) {
        AppMethodBeat.i(30588);
        ab.i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", Long.valueOf(biVar.field_msgId));
        boolean kH;
        if (j.ay(biVar) || j.az(biVar)) {
            AppMethodBeat.o(30588);
        } else if (com.tencent.mm.aj.f.kq(str) && !biVar.drE() && !biVar.isText() && !biVar.drD()) {
            ab.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", Integer.valueOf(biVar.getType()));
            AppMethodBeat.o(30588);
        } else if (biVar.drE()) {
            j.b(context, str, biVar);
            AppMethodBeat.o(30588);
        } else if (biVar.bws()) {
            j.c(context, str, biVar);
            AppMethodBeat.o(30588);
        } else if (biVar.bwt()) {
            j.c(context, str, biVar);
            kH = com.tencent.mm.model.t.kH(str);
            a.a(kH ? a.c.Chatroom : a.c.Chat, a.d.Samll, biVar, kH ? n.mA(str) : 0);
            AppMethodBeat.o(30588);
        } else if (biVar.isText()) {
            j.a(context, str, biVar, z);
            AppMethodBeat.o(30588);
        } else if (biVar.dtr() || biVar.bAA()) {
            int mA;
            kH = com.tencent.mm.model.t.kH(str);
            a.c cVar = kH ? a.c.Chatroom : a.c.Chat;
            a.d dVar = a.d.Samll;
            if (kH) {
                mA = n.mA(str);
            } else {
                mA = 0;
            }
            a.a(cVar, dVar, biVar, mA);
            b bVar;
            if (biVar.dty()) {
                if (j.a(context, str, biVar, "appEmoji")) {
                    ap aps = ap.aps(biVar.field_content);
                    b X = b.X(biVar.field_content, biVar.field_reserved);
                    if (X == null) {
                        X = new b();
                        X.fgq = aps.cvZ;
                        bVar = X;
                    } else {
                        bVar = X;
                    }
                    if (bo.isNullOrNil(bVar.fgq) || bVar.fgq.equalsIgnoreCase("-1")) {
                        ab.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                        AppMethodBeat.o(30588);
                        return;
                    }
                    ab.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", str, bVar.fgq);
                    EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(bVar.fgq);
                    if (Jd != null) {
                        j.b(Jd, str);
                        AppMethodBeat.o(30588);
                        return;
                    }
                    ab.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", aps);
                }
                AppMethodBeat.o(30588);
            } else if (biVar.drC()) {
                try {
                    com.tencent.mm.af.o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content);
                    LinkedList<p> linkedList = b.fjr;
                    if (linkedList != null) {
                        for (p pVar : linkedList) {
                            b bVar2 = new b();
                            if (com.tencent.mm.af.l.mg(pVar.fjC)) {
                                l.b(str, l.a(str, pVar), pVar.fjH);
                            } else {
                                bVar2.title = pVar.title;
                                bVar2.description = pVar.fjz;
                                bVar2.action = "view";
                                bVar2.type = 5;
                                bVar2.url = pVar.url;
                                bVar2.cMg = b.cMg;
                                bVar2.cMh = b.cMh;
                                bVar2.dJv = b.dJv;
                                bVar2.thumburl = com.tencent.mm.af.l.a(pVar);
                                com.tencent.mm.af.f eVar = new com.tencent.mm.af.e();
                                eVar.ffZ = pVar.type;
                                if (pVar.type == 5) {
                                    eVar.fgd = pVar.fgd;
                                    eVar.fga = (int) pVar.time;
                                    eVar.duration = pVar.fjB;
                                    eVar.videoWidth = pVar.videoWidth;
                                    eVar.videoHeight = pVar.videoHeight;
                                }
                                bVar2.a(eVar);
                                if (bo.isNullOrNil(bVar2.thumburl)) {
                                    com.tencent.mm.ah.h qo = com.tencent.mm.ah.o.act().qo(biVar.field_talker);
                                    if (qo != null) {
                                        bVar2.thumburl = qo.ack();
                                    }
                                }
                                j.a(context, str, b.a(bVar2, null, null), biVar.field_isSend, z);
                            }
                        }
                    }
                    AppMethodBeat.o(30588);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    ab.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", e.getLocalizedMessage());
                    AppMethodBeat.o(30588);
                }
            } else {
                String oz;
                if (biVar.field_isSend == 0) {
                    oz = bf.oz(biVar.field_content);
                } else {
                    oz = biVar.field_content;
                }
                bVar = b.me(oz);
                if (bVar == null) {
                    ab.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                    AppMethodBeat.o(30588);
                    return;
                }
                com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(bVar.appId, false);
                if (bT != null && bT.xy()) {
                    ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    AppMethodBeat.o(30588);
                } else if (bVar.type == 19) {
                    nt ntVar = new nt();
                    ntVar.cJY.type = 4;
                    ntVar.cJY.cKd = biVar;
                    ntVar.cJY.toUser = str;
                    com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                    AppMethodBeat.o(30588);
                } else {
                    if (bVar.type == 6 && !bo.isNullOrNil(bVar.fgu)) {
                        com.tencent.mm.pluginsdk.model.app.b aiM;
                        Object obj;
                        if (!bo.isNullOrNil(bVar.fgu)) {
                            aiM = l.aiM(bVar.csD);
                            if (aiM == null) {
                                l.s(biVar.field_msgId, oz);
                            }
                            obj = null;
                            if (aiM != null) {
                                File file = new File(aiM.field_fileFullPath);
                                if (file.exists() && file.length() == aiM.field_totalLen) {
                                    obj = 1;
                                }
                            }
                            if (obj == null) {
                                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                final Context context2 = context;
                                final String str2 = str;
                                final bi biVar2 = biVar;
                                final boolean z2 = z;
                                gVar.egl = new com.tencent.mm.i.g.a() {
                                    public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                        AppMethodBeat.i(30579);
                                        if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                                            if (!(bo.isNullOrNil(bVar.fgu) || aiM == null)) {
                                                aiM.field_status = 199;
                                                aiM.field_offset = aiM.field_totalLen;
                                                am.aUq().a(aiM, new String[0]);
                                                aw.ZK();
                                                bi jf = com.tencent.mm.model.c.XO().jf(aiM.field_msgInfoId);
                                                jf.setStatus(3);
                                                aw.ZK();
                                                com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
                                            }
                                            new ak(Looper.getMainLooper()).post(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(30578);
                                                    j.b(context2, str2, biVar2, z2);
                                                    AppMethodBeat.o(30578);
                                                }
                                            });
                                        }
                                        AppMethodBeat.o(30579);
                                        return 0;
                                    }

                                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                    }

                                    public final byte[] l(String str, byte[] bArr) {
                                        return new byte[0];
                                    }
                                };
                                gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), biVar.field_talker, biVar.field_msgId);
                                gVar.field_aesKey = bVar.eyr;
                                gVar.field_fileType = 19;
                                gVar.field_authKey = bVar.fgA;
                                gVar.egm = bVar.fgu;
                                if (aiM == null || bo.isNullOrNil(aiM.field_fileFullPath)) {
                                    aw.ZK();
                                    gVar.field_fullpath = l.X(com.tencent.mm.model.c.Ye(), bVar.title, bVar.fgp);
                                } else {
                                    gVar.field_fullpath = aiM.field_fileFullPath;
                                }
                                if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
                                    ab.e("MicroMsg.ChattingEditModeRetransmitMsg", "openim attach download failed before rescend");
                                }
                                AppMethodBeat.o(30588);
                                return;
                            }
                        }
                        aiM = l.aiM(bVar.csD);
                        obj = null;
                        if (aiM != null) {
                        }
                        if (obj == null) {
                        }
                    }
                    if (bVar.type == 5 && !bo.isNullOrNil(bVar.url)) {
                        oz = "";
                        try {
                            oz = URLEncoder.encode(bVar.url, "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            ab.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                        }
                        long anT = bo.anT();
                        ab.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), bVar.url, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                        com.tencent.mm.plugin.report.service.h.pYm.e(13378, oz, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    j.b(context, str, biVar, z);
                    AppMethodBeat.o(30588);
                }
            }
        } else if (biVar.dtw()) {
            if (j.a(context, str, biVar, "friendcard")) {
                int i;
                String v = j.v(biVar.field_content, biVar.field_isSend, z);
                com.tencent.mm.storage.bi.a apC = com.tencent.mm.storage.bi.a.apC(v);
                com.tencent.mm.plugin.messenger.a.d bOk = com.tencent.mm.plugin.messenger.a.g.bOk();
                if (ad.aox(apC.svN)) {
                    i = 66;
                } else {
                    i = 42;
                }
                bOk.F(str, v, i);
            }
            AppMethodBeat.o(30588);
        } else {
            if (biVar.dtx() || biVar.dty()) {
                if (!j.av(biVar)) {
                    j.a(context, str, biVar);
                    AppMethodBeat.o(30588);
                    return;
                }
            } else if (biVar.bAC()) {
                j.c(context, str, biVar, z);
            }
            AppMethodBeat.o(30588);
        }
    }
}
