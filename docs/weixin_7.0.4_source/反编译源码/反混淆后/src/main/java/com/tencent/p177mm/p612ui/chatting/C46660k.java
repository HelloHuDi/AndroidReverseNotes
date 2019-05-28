package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C23698ah.C23699a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.p616c.C46648j;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.messenger.p993a.C28488d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44100d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.ui.chatting.k */
public final class C46660k {
    private static C40792a yIH = new C40792a();

    /* renamed from: com.tencent.mm.ui.chatting.k$2 */
    static class C305472 implements OnClickListener {
        C305472() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.k$a */
    static class C40792a {
        C45316cl cJy;
        String cKf;
        boolean yFW;
        List<C7620bi> yIP;
        C44100d yIQ;
        C23698ah yIw;

        private C40792a() {
        }

        /* synthetic */ C40792a(byte b) {
            this();
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m88360c(Context context, List list, boolean z, String str, C23698ah c23698ah) {
        AppMethodBeat.m2504i(30587);
        C46660k.m88359b(context, list, z, str, c23698ah);
        AppMethodBeat.m2505o(30587);
    }

    static {
        AppMethodBeat.m2504i(30589);
        AppMethodBeat.m2505o(30589);
    }

    /* renamed from: a */
    public static void m88358a(Context context, List<C7620bi> list, boolean z, String str, C23698ah c23698ah) {
        AppMethodBeat.m2504i(30580);
        C46660k.dCa();
        if (context == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
            AppMethodBeat.m2505o(30580);
        } else if (list == null || list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
            AppMethodBeat.m2505o(30580);
        } else {
            for (C7620bi aO : list) {
                if (!C23696ac.m36535aO(aO)) {
                    C23639t.makeText(context, C25738R.string.dal, 0).show();
                    AppMethodBeat.m2505o(30580);
                    return;
                }
            }
            if (C40788j.m70652a(false, (List) list, c23698ah)) {
                Object obj;
                if (list != null && !list.isEmpty()) {
                    for (C7620bi aO2 : list) {
                        String str2 = null;
                        if (!aO2.dtH()) {
                            if (aO2.drE()) {
                                C25822e c25822e = null;
                                if (aO2.field_msgId > 0) {
                                    c25822e = C32291o.ahl().mo73113fJ(aO2.field_msgId);
                                }
                                if ((c25822e == null || c25822e.fDy <= 0) && aO2.field_msgSvrId > 0) {
                                    c25822e = C32291o.ahl().mo73112fI(aO2.field_msgSvrId);
                                }
                                if (c25822e != null) {
                                    str2 = C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", "");
                                }
                            } else if (aO2.bwt() || aO2.bws()) {
                                C37961o.all();
                                str2 = C9720t.m17303uh(aO2.field_imgPath);
                            } else if (aO2.bAA()) {
                                C8910b me = C8910b.m16064me(aO2.field_content);
                                if (me != null) {
                                    C30065b aiM = C4733l.aiM(me.csD);
                                    if (aiM != null) {
                                        str2 = aiM.field_fileFullPath;
                                    }
                                }
                            } else {
                                str2 = aO2.field_imgPath;
                            }
                            if (aO2.drE() || aO2.bws() || aO2.bwt() || C40788j.m70661aI(aO2)) {
                                if (System.currentTimeMillis() - aO2.field_createTime <= 259200000 || (!C5046bo.isNullOrNil(str2) && C5730e.m8628ct(str2))) {
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
                    C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
                }
                obj = 1;
                if (obj != null) {
                    C4990ab.m7416i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
                    if (c23698ah != null && (c23698ah.dCJ() || list.size() == 1)) {
                        C30379h.m48438a(context, context.getString(C25738R.string.bio), context.getString(C25738R.string.f9238tz), new C305472());
                        AppMethodBeat.m2505o(30580);
                        return;
                    }
                }
                C46660k.m88359b(context, list, z, str, c23698ah);
                AppMethodBeat.m2505o(30580);
                return;
            }
            final List<C7620bi> list2 = list;
            final C23698ah c23698ah2 = c23698ah;
            final Context context2 = context;
            final boolean z2 = z;
            final String str3 = str;
            C30379h.m48466d(context, context.getString(C25738R.string.ce3), "", context.getString(C25738R.string.f9221tf), context.getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Object obj;
                    AppMethodBeat.m2504i(30574);
                    List<C7620bi> list = list2;
                    if (list != null && !list.isEmpty()) {
                        for (C7620bi c7620bi : list) {
                            if (!C40788j.m70653aA(c7620bi)) {
                                if (!c7620bi.drD() && !C40788j.m70662av(c7620bi) && !C40788j.m70664ax(c7620bi) && !C40788j.m70659aG(c7620bi) && !C40788j.m70665ay(c7620bi) && c7620bi.getType() != -1879048186 && !C40788j.m70658aF(c7620bi) && !C40788j.m70666az(c7620bi) && !C40788j.m70657aE(c7620bi) && !C40788j.m70653aA(c7620bi) && c7620bi.getType() != 318767153) {
                                    obj = null;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    C4990ab.m7420w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
                    obj = 1;
                    if (obj != null) {
                        C4990ab.m7420w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
                        if (c23698ah2 != null) {
                            c23698ah2.mo27933b(C23699a.trans);
                        }
                        AppMethodBeat.m2505o(30574);
                        return;
                    }
                    C46660k.m88360c(context2, list2, z2, str3, c23698ah2);
                    AppMethodBeat.m2505o(30574);
                }
            }, null);
            AppMethodBeat.m2505o(30580);
        }
    }

    /* renamed from: e */
    private static void m88362e(Context context, List<C7620bi> list) {
        AppMethodBeat.m2504i(30581);
        for (C7620bi c7620bi : list) {
            if (C1831bh.m3770o(c7620bi)) {
                switch (c7620bi.getType() & CdnLogic.kBizGeneric) {
                    case 1:
                        c7620bi.setContent(context.getString(C25738R.string.f9236tx));
                        break;
                    case 3:
                        c7620bi.setContent(context.getString(C25738R.string.f9199sn));
                        c7620bi.setType(1);
                        break;
                    case 43:
                        c7620bi.setContent(context.getString(C25738R.string.f9253ud));
                        c7620bi.setType(1);
                        break;
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        c7620bi.setContent(context.getString(C25738R.string.f9246u7));
                        c7620bi.setType(1);
                        break;
                }
                C1831bh.m3772p(c7620bi);
            }
        }
        AppMethodBeat.m2505o(30581);
    }

    /* renamed from: b */
    private static void m88359b(Context context, List<C7620bi> list, boolean z, String str, final C23698ah c23698ah) {
        AppMethodBeat.m2504i(30582);
        if (C40788j.m70677eS(list)) {
            C30379h.m48443a(context, context.getString(C25738R.string.b2y), "", context.getString(C25738R.string.f8636aj), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(30575);
                    if (c23698ah != null) {
                        C23698ah c23698ah = c23698ah;
                        C23699a c23699a = C23699a.trans;
                        c23698ah.dCI();
                    }
                    AppMethodBeat.m2505o(30575);
                }
            });
            AppMethodBeat.m2505o(30582);
            return;
        }
        int i;
        C46660k.m88362e(context, list);
        yIH.yIP = new LinkedList(list);
        yIH.yFW = z;
        yIH.yIw = c23698ah;
        yIH.cKf = str;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (list.size() == 1) {
            int i2;
            C7620bi c7620bi = (C7620bi) list.get(0);
            if (c7620bi.bAA() || c7620bi.drC()) {
                String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                y.mo53356j("preUsername", C5378c.m8122a(c7620bi, z, false));
                y.mo53356j("preChatName", c7620bi.field_talker);
                y.mo53356j("preMsgIndex", Integer.valueOf(0));
                y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                y.mo53356j("moreRetrAction", Boolean.TRUE);
                if (z) {
                    y.mo53356j("fromScene", Integer.valueOf(2));
                } else {
                    y.mo53356j("fromScene", Integer.valueOf(1));
                }
                ((C46210i) C1720g.m3528K(C46210i.class)).mo55530a("adExtStr", y, c7620bi);
                intent.putExtra("reportSessionId", nW);
            }
            String str2 = c7620bi.field_content;
            int i3 = 12;
            C26493s ut;
            if (c7620bi.bAC()) {
                i3 = 9;
            } else if (c7620bi.dtx()) {
                i3 = 5;
                intent.putExtra("Retr_File_Name", c7620bi.field_imgPath);
            } else if (c7620bi.dtw()) {
                i3 = 8;
            } else if (c7620bi.isText()) {
                i3 = 4;
                if (z && c7620bi.field_isSend == 0) {
                    str2 = C1829bf.m3763oz(str2);
                }
            } else if (c7620bi.drE()) {
                String I;
                C25822e c25822e = null;
                if (c7620bi.field_msgId > 0) {
                    c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                }
                if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                    c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                }
                if (c25822e.offset < c25822e.frO || c25822e.frO == 0) {
                    I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
                } else {
                    I = C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", "");
                }
                intent.putExtra("Retr_File_Name", I);
                i3 = 0;
            } else if (c7620bi.bwt()) {
                ut = C26494u.m42268ut(c7620bi.field_imgPath);
                if (ut != null) {
                    intent.putExtra("Retr_length", ut.fXd);
                }
                i3 = 11;
                intent.putExtra("Retr_File_Name", c7620bi.field_imgPath);
            } else if (c7620bi.bws()) {
                ut = C26494u.m42268ut(c7620bi.field_imgPath);
                if (ut != null) {
                    intent.putExtra("Retr_length", ut.fXd);
                }
                i3 = 1;
                intent.putExtra("Retr_File_Name", c7620bi.field_imgPath);
            } else if (c7620bi.bAA()) {
                C8910b me = C8910b.m16064me(str2);
                if (me != null && 19 == me.type) {
                    i3 = 10;
                } else if (me != null && 24 == me.type) {
                    i3 = 10;
                } else if (me == null || 16 != me.type) {
                    i3 = 2;
                } else {
                    i3 = 14;
                }
                if (c7620bi.drC()) {
                    intent.putExtra("is_group_chat", z);
                }
            }
            if (c7620bi.drC()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (c23698ah == null || c23698ah.dCJ()) {
                intent.putExtra("Retr_Msg_Type", i3);
            } else {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            }
            intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
            intent.putExtra("Retr_Msg_content", str2);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i = i2;
        } else if ((c23698ah == null || !c23698ah.dCJ()) && ((!C1855t.m3913mZ(str) || C17903f.m28103kq(str)) && !C1855t.m3924nJ(str))) {
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
        C44312l.m80097eU(yIH.yIP);
        AppMethodBeat.m2505o(30582);
    }

    /* renamed from: l */
    public static void m88364l(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(30583);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 5;
        c18348nt.cJY.cKe = yIH.yIP;
        c18348nt.cJY.toUser = str;
        c18348nt.cJY.cKf = yIH.cKf;
        c18348nt.cJY.context = context;
        c18348nt.cJY.cJy = yIH.cJy;
        c18348nt.cJY.cKh = yIH.yIQ;
        C4879a.xxA.mo10055m(c18348nt);
        if (yIH.yIP != null) {
            C7060h.pYm.mo8381e(10811, Integer.valueOf(8), Integer.valueOf(yIH.yIP.size()), Integer.valueOf(yIH.yIP.size() - C40788j.m70675eQ(yIH.yIP)));
            for (C7620bi c7620bi : yIH.yIP) {
                long anT = C5046bo.anT();
                C8910b me = C8910b.m16064me(C5046bo.anj(c7620bi.field_content));
                if (!(me == null || me.type != 5 || C5046bo.isNullOrNil(me.url))) {
                    int i;
                    if (c7620bi.drC()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = "";
                    try {
                        str2 = URLEncoder.encode(me.url, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e, "", new Object[0]);
                    }
                    C4990ab.m7411d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(anT), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                    C7060h.pYm.mo8381e(13378, str2, Long.valueOf(anT), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        if (z && yIH.yIw != null) {
            yIH.yIw.mo27933b(C23699a.trans);
        }
        AppMethodBeat.m2505o(30583);
    }

    /* renamed from: qo */
    public static void m88366qo(boolean z) {
        AppMethodBeat.m2504i(30584);
        if (z && yIH.yIw != null) {
            yIH.yIw.mo27933b(C23699a.trans);
        }
        AppMethodBeat.m2505o(30584);
    }

    /* renamed from: hS */
    public static C18348nt m88363hS(Context context) {
        AppMethodBeat.m2504i(30585);
        C18348nt c18348nt = new C18348nt();
        c18348nt.cJY.type = 6;
        c18348nt.cJY.cKe = yIH.yIP;
        c18348nt.cJY.cKf = yIH.cKf;
        c18348nt.cJY.context = context;
        C4879a.xxA.mo10055m(c18348nt);
        yIH.cJy = c18348nt.cJZ.cJy;
        yIH.yIQ = c18348nt.cJZ.cKh;
        AppMethodBeat.m2505o(30585);
        return c18348nt;
    }

    /* renamed from: m */
    public static void m88365m(final Context context, final String str, final boolean z) {
        AppMethodBeat.m2504i(30586);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
            AppMethodBeat.m2505o(30586);
        } else if (yIH.yIP == null || yIH.yIP.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
            AppMethodBeat.m2505o(30586);
        } else {
            C4990ab.m7419v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", str);
            C46648j.yOM.mo39163e(new C23499a() {
                final /* synthetic */ Runnable cfC = null;

                public final boolean acf() {
                    AppMethodBeat.m2504i(30576);
                    if (C46660k.yIH.yIP == null) {
                        AppMethodBeat.m2505o(30576);
                        return false;
                    }
                    for (C7620bi d : C46660k.yIH.yIP) {
                        C46660k.m88361d(context, str, d, C46660k.yIH.yFW);
                    }
                    AppMethodBeat.m2505o(30576);
                    return true;
                }

                public final boolean acg() {
                    AppMethodBeat.m2504i(30577);
                    if (C46660k.yIH.yIP != null) {
                        C7060h.pYm.mo8381e(10811, Integer.valueOf(5), Integer.valueOf(C46660k.yIH.yIP.size()), Integer.valueOf(C46660k.yIH.yIP.size() - C40788j.m70675eQ(C46660k.yIH.yIP)));
                    }
                    if (z) {
                        if (this.cfC != null) {
                            C4990ab.m7418v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                            this.cfC.run();
                        }
                        if (C46660k.yIH.yIw != null) {
                            C46660k.yIH.yIw.mo27933b(C23699a.trans);
                        }
                        C46660k.dCa();
                    }
                    AppMethodBeat.m2505o(30577);
                    return true;
                }
            });
            AppMethodBeat.m2505o(30586);
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
    /* renamed from: d */
    static /* synthetic */ void m88361d(Context context, String str, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(30588);
        C4990ab.m7417i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", Long.valueOf(c7620bi.field_msgId));
        boolean kH;
        if (C40788j.m70665ay(c7620bi) || C40788j.m70666az(c7620bi)) {
            AppMethodBeat.m2505o(30588);
        } else if (C17903f.m28103kq(str) && !c7620bi.drE() && !c7620bi.isText() && !c7620bi.drD()) {
            C4990ab.m7417i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", Integer.valueOf(c7620bi.getType()));
            AppMethodBeat.m2505o(30588);
        } else if (c7620bi.drE()) {
            C40788j.m70667b(context, str, c7620bi);
            AppMethodBeat.m2505o(30588);
        } else if (c7620bi.bws()) {
            C40788j.m70670c(context, str, c7620bi);
            AppMethodBeat.m2505o(30588);
        } else if (c7620bi.bwt()) {
            C40788j.m70670c(context, str, c7620bi);
            kH = C1855t.m3896kH(str);
            C40707a.m70380a(kH ? C40706c.Chatroom : C40706c.Chat, C23688d.Samll, c7620bi, kH ? C37921n.m64060mA(str) : 0);
            AppMethodBeat.m2505o(30588);
        } else if (c7620bi.isText()) {
            C40788j.m70649a(context, str, c7620bi, z);
            AppMethodBeat.m2505o(30588);
        } else if (c7620bi.dtr() || c7620bi.bAA()) {
            int mA;
            kH = C1855t.m3896kH(str);
            C40706c c40706c = kH ? C40706c.Chatroom : C40706c.Chat;
            C23688d c23688d = C23688d.Samll;
            if (kH) {
                mA = C37921n.m64060mA(str);
            } else {
                mA = 0;
            }
            C40707a.m70380a(c40706c, c23688d, c7620bi, mA);
            C8910b c8910b;
            if (c7620bi.dty()) {
                if (C40788j.m70651a(context, str, c7620bi, "appEmoji")) {
                    C44218ap aps = C44218ap.aps(c7620bi.field_content);
                    C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
                    if (X == null) {
                        X = new C8910b();
                        X.fgq = aps.cvZ;
                        c8910b = X;
                    } else {
                        c8910b = X;
                    }
                    if (C5046bo.isNullOrNil(c8910b.fgq) || c8910b.fgq.equalsIgnoreCase("-1")) {
                        C4990ab.m7412e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                        AppMethodBeat.m2505o(30588);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", str, c8910b.fgq);
                    EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c8910b.fgq);
                    if (Jd != null) {
                        C40788j.m70669b(Jd, str);
                        AppMethodBeat.m2505o(30588);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", aps);
                }
                AppMethodBeat.m2505o(30588);
            } else if (c7620bi.drC()) {
                try {
                    C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
                    LinkedList<C32224p> linkedList = b.fjr;
                    if (linkedList != null) {
                        for (C32224p c32224p : linkedList) {
                            C8910b c8910b2 = new C8910b();
                            if (C1192l.m2624mg(c32224p.fjC)) {
                                C44312l.m80096b(str, C44312l.m80095a(str, c32224p), c32224p.fjH);
                            } else {
                                c8910b2.title = c32224p.title;
                                c8910b2.description = c32224p.fjz;
                                c8910b2.action = "view";
                                c8910b2.type = 5;
                                c8910b2.url = c32224p.url;
                                c8910b2.cMg = b.cMg;
                                c8910b2.cMh = b.cMh;
                                c8910b2.dJv = b.dJv;
                                c8910b2.thumburl = C1192l.m2619a(c32224p);
                                C37435f c25747e = new C25747e();
                                c25747e.ffZ = c32224p.type;
                                if (c32224p.type == 5) {
                                    c25747e.fgd = c32224p.fgd;
                                    c25747e.fga = (int) c32224p.time;
                                    c25747e.duration = c32224p.fjB;
                                    c25747e.videoWidth = c32224p.videoWidth;
                                    c25747e.videoHeight = c32224p.videoHeight;
                                }
                                c8910b2.mo20334a(c25747e);
                                if (C5046bo.isNullOrNil(c8910b2.thumburl)) {
                                    C17880h qo = C17884o.act().mo33392qo(c7620bi.field_talker);
                                    if (qo != null) {
                                        c8910b2.thumburl = qo.ack();
                                    }
                                }
                                C40788j.m70650a(context, str, C8910b.m16061a(c8910b2, null, null), c7620bi.field_isSend, z);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(30588);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    C4990ab.m7413e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", e.getLocalizedMessage());
                    AppMethodBeat.m2505o(30588);
                }
            } else {
                String oz;
                if (c7620bi.field_isSend == 0) {
                    oz = C1829bf.m3763oz(c7620bi.field_content);
                } else {
                    oz = c7620bi.field_content;
                }
                c8910b = C8910b.m16064me(oz);
                if (c8910b == null) {
                    C4990ab.m7412e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                    AppMethodBeat.m2505o(30588);
                    return;
                }
                C40439f bT = C46494g.m87739bT(c8910b.appId, false);
                if (bT != null && bT.mo63847xy()) {
                    C4990ab.m7420w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    AppMethodBeat.m2505o(30588);
                } else if (c8910b.type == 19) {
                    C18348nt c18348nt = new C18348nt();
                    c18348nt.cJY.type = 4;
                    c18348nt.cJY.cKd = c7620bi;
                    c18348nt.cJY.toUser = str;
                    C4879a.xxA.mo10055m(c18348nt);
                    AppMethodBeat.m2505o(30588);
                } else {
                    if (c8910b.type == 6 && !C5046bo.isNullOrNil(c8910b.fgu)) {
                        C30065b aiM;
                        Object obj;
                        if (!C5046bo.isNullOrNil(c8910b.fgu)) {
                            aiM = C4733l.aiM(c8910b.csD);
                            if (aiM == null) {
                                C4733l.m7105s(c7620bi.field_msgId, oz);
                            }
                            obj = null;
                            if (aiM != null) {
                                File file = new File(aiM.field_fileFullPath);
                                if (file.exists() && file.length() == aiM.field_totalLen) {
                                    obj = 1;
                                }
                            }
                            if (obj == null) {
                                C42130g c42130g = new C42130g();
                                final Context context2 = context;
                                final String str2 = str;
                                final C7620bi c7620bi2 = c7620bi;
                                final boolean z2 = z;
                                c42130g.egl = new C1628a() {

                                    /* renamed from: com.tencent.mm.ui.chatting.k$5$1 */
                                    class C407911 implements Runnable {
                                        C407911() {
                                        }

                                        public final void run() {
                                            AppMethodBeat.m2504i(30578);
                                            C40788j.m70668b(context2, str2, c7620bi2, z2);
                                            AppMethodBeat.m2505o(30578);
                                        }
                                    }

                                    /* renamed from: a */
                                    public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                                        AppMethodBeat.m2504i(30579);
                                        if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                                            if (!(C5046bo.isNullOrNil(c8910b.fgu) || aiM == null)) {
                                                aiM.field_status = 199;
                                                aiM.field_offset = aiM.field_totalLen;
                                                C14877am.aUq().mo48326a(aiM, new String[0]);
                                                C9638aw.m17190ZK();
                                                C7620bi jf = C18628c.m29080XO().mo15340jf(aiM.field_msgInfoId);
                                                jf.setStatus(3);
                                                C9638aw.m17190ZK();
                                                C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                                            }
                                            new C7306ak(Looper.getMainLooper()).post(new C407911());
                                        }
                                        AppMethodBeat.m2505o(30579);
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
                                c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), c7620bi.field_talker, c7620bi.field_msgId);
                                c42130g.field_aesKey = c8910b.eyr;
                                c42130g.field_fileType = 19;
                                c42130g.field_authKey = c8910b.fgA;
                                c42130g.egm = c8910b.fgu;
                                if (aiM == null || C5046bo.isNullOrNil(aiM.field_fileFullPath)) {
                                    C9638aw.m17190ZK();
                                    c42130g.field_fullpath = C4733l.m7083X(C18628c.m29096Ye(), c8910b.title, c8910b.fgp);
                                } else {
                                    c42130g.field_fullpath = aiM.field_fileFullPath;
                                }
                                if (!C37461f.afx().mo51222b(c42130g, -1)) {
                                    C4990ab.m7412e("MicroMsg.ChattingEditModeRetransmitMsg", "openim attach download failed before rescend");
                                }
                                AppMethodBeat.m2505o(30588);
                                return;
                            }
                        }
                        aiM = C4733l.aiM(c8910b.csD);
                        obj = null;
                        if (aiM != null) {
                        }
                        if (obj == null) {
                        }
                    }
                    if (c8910b.type == 5 && !C5046bo.isNullOrNil(c8910b.url)) {
                        oz = "";
                        try {
                            oz = URLEncoder.encode(c8910b.url, "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                        }
                        long anT = C5046bo.anT();
                        C4990ab.m7411d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), c8910b.url, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                        C7060h.pYm.mo8381e(13378, oz, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    C40788j.m70668b(context, str, c7620bi, z);
                    AppMethodBeat.m2505o(30588);
                }
            }
        } else if (c7620bi.dtw()) {
            if (C40788j.m70651a(context, str, c7620bi, "friendcard")) {
                int i;
                String v = C40788j.m70679v(c7620bi.field_content, c7620bi.field_isSend, z);
                C5135a apC = C5135a.apC(v);
                C28488d bOk = C12519g.bOk();
                if (C7616ad.aox(apC.svN)) {
                    i = 66;
                } else {
                    i = 42;
                }
                bOk.mo46456F(str, v, i);
            }
            AppMethodBeat.m2505o(30588);
        } else {
            if (c7620bi.dtx() || c7620bi.dty()) {
                if (!C40788j.m70662av(c7620bi)) {
                    C40788j.m70648a(context, str, c7620bi);
                    AppMethodBeat.m2505o(30588);
                    return;
                }
            } else if (c7620bi.bAC()) {
                C40788j.m70671c(context, str, c7620bi, z);
            }
            AppMethodBeat.m2505o(30588);
        }
    }
}
