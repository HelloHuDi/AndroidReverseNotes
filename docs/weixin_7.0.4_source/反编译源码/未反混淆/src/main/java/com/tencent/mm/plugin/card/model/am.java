package com.tencent.mm.plugin.card.model;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.model.a.f;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.b;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class am implements at {
    private static HashMap<Integer, d> eaA;
    private m keA;
    private a keB;
    private k keC;
    private o keD;
    private c keE;
    private com.tencent.mm.plugin.card.b.k keF = null;
    private e keG = null;
    private l keH = null;
    private com.tencent.mm.plugin.card.b.d keI = null;
    private j keJ = null;
    private com.tencent.mm.plugin.card.b.c keK;
    private g keL;
    private l keM;
    private j keN;
    private com.tencent.mm.sdk.b.c keO = new n();
    private com.tencent.mm.sdk.b.c keP = new com.tencent.mm.plugin.card.b.o();
    private com.tencent.mm.sdk.b.c keQ = new com.tencent.mm.plugin.card.b.a();
    private b keR = new b();
    private com.tencent.mm.sdk.b.c keS = new com.tencent.mm.sdk.b.c<hi>() {
        {
            AppMethodBeat.i(87931);
            this.xxI = hi.class.getName().hashCode();
            AppMethodBeat.o(87931);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(87932);
            final hi hiVar = (hi) bVar;
            ab.i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
            if (hiVar instanceof hi) {
                am.this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87930);
                        if (com.tencent.mm.kernel.g.RK()) {
                            boolean z = hiVar.cCe.cCf;
                            ab.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is ".concat(String.valueOf(z)));
                            boolean beC = com.tencent.mm.plugin.card.d.l.beC();
                            boolean beE = com.tencent.mm.plugin.card.d.l.beE();
                            if (beC && beE) {
                                ab.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                                AppMethodBeat.o(87930);
                                return;
                            }
                            if (z) {
                                com.tencent.mm.kernel.g.RO().eJo.a(new y(), 0);
                            } else {
                                int intValue;
                                Integer num = (Integer) com.tencent.mm.kernel.g.RP().Ry().get(282882, null);
                                if (num != null) {
                                    intValue = num.intValue();
                                } else {
                                    intValue = 0;
                                }
                                if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                    com.tencent.mm.kernel.g.RO().eJo.a(new y(), 0);
                                }
                            }
                            if (beE) {
                                Long l = (Long) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0));
                                if (l != null && l.longValue() == 0) {
                                    am.bbd().bbr();
                                }
                            }
                            if (beC && TextUtils.isEmpty((String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null))) {
                                am.baV();
                                com.tencent.mm.plugin.card.b.b.sO(1);
                            }
                            AppMethodBeat.o(87930);
                            return;
                        }
                        AppMethodBeat.o(87930);
                    }
                }, 10000);
            }
            AppMethodBeat.o(87932);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c keT = new com.tencent.mm.sdk.b.c<pb>() {
        {
            AppMethodBeat.i(87936);
            this.xxI = pb.class.getName().hashCode();
            AppMethodBeat.o(87936);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(87937);
            ab.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            al baX = am.baX();
            ab.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            baX.bSd.hY("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            AppMethodBeat.o(87937);
            return false;
        }
    };
    private bz.a keU = new bz.a() {
        public final void a(final com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(87939);
            final String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
                AppMethodBeat.o(87939);
                return;
            }
            am.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87938);
                    com.tencent.mm.plugin.card.b.k bba = am.bba();
                    String str = a;
                    String str2 = aVar.eAB.ptF;
                    ab.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str2)));
                    if (!TextUtils.isEmpty(str)) {
                        g gVar;
                        Map z = br.z(str, "sysmsg");
                        if (z == null) {
                            gVar = null;
                        } else {
                            g gVar2 = new g();
                            str = (String) z.get(".sysmsg.carditemmsg.card_type");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.field_card_type = 0;
                            } else {
                                gVar2.field_card_type = Integer.valueOf(str).intValue();
                            }
                            gVar2.field_title = (String) z.get(".sysmsg.carditemmsg.title");
                            gVar2.field_description = (String) z.get(".sysmsg.carditemmsg.description");
                            gVar2.field_logo_url = (String) z.get(".sysmsg.carditemmsg.logo_url");
                            gVar2.field_logo_color = (String) z.get(".sysmsg.carditemmsg.logo_color");
                            str = (String) z.get(".sysmsg.carditemmsg.time");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.field_time = (int) (System.currentTimeMillis() / 1000);
                            } else if (Long.valueOf(str).longValue() >= 2147483647L) {
                                gVar2.field_time = BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                gVar2.field_time = Integer.valueOf(str).intValue();
                            }
                            gVar2.field_card_id = (String) z.get(".sysmsg.carditemmsg.card_id");
                            gVar2.field_card_tp_id = (String) z.get(".sysmsg.carditemmsg.card_tp_id");
                            gVar2.field_msg_id = (String) z.get(".sysmsg.carditemmsg.msg_id");
                            str = (String) z.get(".sysmsg.carditemmsg.msg_type");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.field_msg_type = 0;
                            } else {
                                gVar2.field_msg_type = Integer.valueOf(str).intValue();
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.jump_type");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.field_jump_type = 1;
                            } else {
                                gVar2.field_jump_type = Integer.valueOf(str).intValue();
                            }
                            gVar2.field_url = (String) z.get(".sysmsg.carditemmsg.url");
                            str = (String) z.get(".sysmsg.carditemmsg.button.text");
                            if (!TextUtils.isEmpty(str)) {
                                nm nmVar = new nm();
                                nmVar.text = str;
                                nmVar.url = (String) z.get(".sysmsg.carditemmsg.button.url");
                                str = (String) z.get(".sysmsg.carditemmsg.button.action_type");
                                if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                    nmVar.kdC = 0;
                                } else {
                                    nmVar.kdC = Integer.valueOf(str).intValue();
                                }
                                gVar2.kdt = nmVar;
                                try {
                                    gVar2.field_buttonData = gVar2.kdt.toByteArray();
                                } catch (Exception e) {
                                    ab.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", e.getMessage());
                                    ab.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                }
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.opt_region.text");
                            if (!TextUtils.isEmpty(str)) {
                                nz nzVar = new nz();
                                nzVar.text = str;
                                nzVar.url = (String) z.get(".sysmsg.carditemmsg.opt_region.url");
                                str = (String) z.get(".sysmsg.carditemmsg.opt_region.type");
                                if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                    nzVar.type = 0;
                                } else {
                                    nzVar.type = Integer.valueOf(str).intValue();
                                }
                                str = (String) z.get(".sysmsg.carditemmsg.opt_region.endtime");
                                if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                    nzVar.qsz = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str).longValue() >= 2147483647L) {
                                    nzVar.qsz = BaseClientBuilder.API_PRIORITY_OTHER;
                                } else {
                                    nzVar.qsz = Integer.valueOf(str).intValue();
                                }
                                gVar2.kdu = nzVar;
                                try {
                                    gVar2.field_operData = gVar2.kdu.toByteArray();
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", e2.getMessage());
                                    ab.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                }
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.report_scene");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.field_report_scene = 2;
                            } else {
                                gVar2.field_report_scene = Integer.valueOf(str).intValue();
                            }
                            gVar2.field_read_state = 1;
                            gVar2.field_accept_buttons = com.tencent.mm.plugin.card.b.k.i(z, ".sysmsg.carditemmsg");
                            gVar2.field_jump_buttons = com.tencent.mm.plugin.card.b.k.h(z, ".sysmsg.carditemmsg");
                            str = (String) z.get(".sysmsg.carditemmsg.get_layout_scene");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.kdx = 0;
                            } else {
                                gVar2.kdx = Integer.valueOf(str).intValue();
                            }
                            gVar2.field_consumed_box_id = (String) z.get(".sysmsg.carditemmsg.consumed_box_id");
                            gVar2.kdn = (String) z.get(".sysmsg.carditemmsg.reddot_wording");
                            gVar2.kdo = (String) z.get(".sysmsg.carditemmsg.reddot_buff");
                            gVar2.kdp = (String) z.get(".sysmsg.carditemmsg.reddot_icon_url");
                            gVar2.kdq = (String) z.get(".sysmsg.carditemmsg.msg_tips.title");
                            gVar2.kdr = (String) z.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                            str = (String) z.get(".sysmsg.carditemmsg.msg_scene");
                            if (TextUtils.isEmpty(str) || !com.tencent.mm.plugin.card.d.l.isNumeric(str)) {
                                gVar2.kdy = 0;
                            } else {
                                gVar2.kdy = Integer.valueOf(str).intValue();
                                ab.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(str)));
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.need_check");
                            ab.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(str)));
                            if (TextUtils.isEmpty(str)) {
                                gVar2.kds = false;
                            } else {
                                gVar2.kds = str.equals("true");
                            }
                            String str3 = (String) z.get(".sysmsg.carditemmsg.all_unavailable");
                            ab.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(str)));
                            if (TextUtils.isEmpty(str3)) {
                                gVar2.kdz = false;
                            } else {
                                gVar2.kdz = str3.equals("true");
                            }
                            gVar2.field_unavailable_qr_code_list = com.tencent.mm.plugin.card.b.k.j(z, ".sysmsg.carditemmsg");
                            gVar2.field_need_pull_card_entrance = "true".equals(z.get(".sysmsg.carditemmsg.need_pull_card_entrance"));
                            gVar = gVar2;
                        }
                        if (gVar == null) {
                            ab.e("MicroMsg.CardMsgManager", "card msg == null");
                            AppMethodBeat.o(87938);
                            return;
                        }
                        if (TextUtils.isEmpty(gVar.field_card_id)) {
                            ab.e("MicroMsg.CardMsgManager", "card id == null");
                        }
                        str = gVar.field_msg_id;
                        gVar.field_msg_id = str2;
                        if (TextUtils.isEmpty(gVar.field_msg_id)) {
                            gVar.field_msg_id = str;
                        }
                        if (TextUtils.isEmpty(gVar.field_msg_id)) {
                            gVar.field_msg_id = System.currentTimeMillis();
                        }
                        ab.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + gVar.field_msg_id);
                        ab.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + gVar.field_msg_type);
                        if (gVar.kdx != 0) {
                            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(gVar.kdx));
                        }
                        ab.i("MicroMsg.CardMsgManager", "reddot_buff is " + gVar.kdo);
                        if (TextUtils.isEmpty(gVar.kdo)) {
                            ab.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                        } else {
                            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, gVar.kdo);
                        }
                        if ((gVar.field_msg_type & 1) != 0) {
                            ab.i("MicroMsg.CardMsgManager", "msg_tips_title is " + gVar.kdq);
                            ab.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + gVar.kdr);
                            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, gVar.kdq);
                            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, gVar.kdr);
                        }
                        boolean bX = com.tencent.mm.x.c.PK().bX(262152, 266256);
                        if (!(bX || (gVar.field_msg_type & 64) == 0)) {
                            com.tencent.mm.x.c.PK().x(262152, true);
                            bX = true;
                        }
                        if (bX) {
                            ab.i("MicroMsg.CardMsgManager", "has card new msg, return");
                        } else {
                            ab.i("MicroMsg.CardMsgManager", "not has new!");
                            if ((gVar.field_msg_type & 32) != 0) {
                                com.tencent.mm.x.c.PK().y(262152, true);
                                ab.i("MicroMsg.CardMsgManager", "has reddot");
                                bX = true;
                            } else {
                                ab.e("MicroMsg.CardMsgManager", "not has reddot!");
                                bX = false;
                            }
                            boolean z2;
                            if (TextUtils.isEmpty(gVar.kdn)) {
                                ab.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                                z2 = false;
                            } else {
                                ab.i("MicroMsg.CardMsgManager", "reddot_wording is " + gVar.kdn);
                                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, gVar.kdn);
                                com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, true);
                                z2 = true;
                            }
                            ab.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + gVar.kdp);
                            boolean z3;
                            if (TextUtils.isEmpty(gVar.kdp)) {
                                ab.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                                z3 = false;
                            } else {
                                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, gVar.kdp);
                                com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, true);
                                z3 = true;
                            }
                            if (!(bX && z2 && z3)) {
                                if (bX && z2 && !z3) {
                                    com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                } else if (bX && !z2 && z3) {
                                    com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                } else if (!bX && z2 && z3) {
                                    com.tencent.mm.x.c.PK().y(262152, false);
                                } else if (bX && !z2 && !z3) {
                                    com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                    com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                } else if (!bX && z2 && !z3) {
                                    com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                    com.tencent.mm.x.c.PK().y(262152, false);
                                } else if (!(bX || z2 || !z3)) {
                                    com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                    com.tencent.mm.x.c.PK().y(262152, false);
                                }
                            }
                            if (bX || z2 || z3) {
                                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, gVar.field_card_id);
                                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.valueOf(gVar.kds));
                                ab.i("MicroMsg.CardMsgManager", "card_id:" + gVar.field_card_id + "  need_check:" + gVar.kds);
                            }
                        }
                        if ((gVar.field_msg_type & 1) != 0) {
                            if (bba.Gq(gVar.field_msg_id)) {
                                ab.e("MicroMsg.CardMsgManager", "msg for id " + gVar.field_msg_id + " is exist!!");
                                bba.Gr(gVar.field_msg_id);
                                bba.kbM.add(gVar);
                                com.tencent.mm.plugin.card.b.k.c(gVar);
                            } else {
                                bba.kbM.add(gVar);
                                com.tencent.mm.plugin.card.b.k.c(gVar);
                                if ((gVar.field_msg_type & 128) != 0) {
                                    bba.kbN++;
                                }
                            }
                            com.tencent.mm.kernel.g.RP().Ry().set(139268, Integer.valueOf(bba.kbN));
                            bba.a(gVar);
                        }
                        if ((gVar.field_msg_type & 2) != 0) {
                            am.baV();
                            com.tencent.mm.plugin.card.b.b.sO(gVar.kdx);
                        }
                        if ((gVar.field_msg_type & 4) != 0) {
                            bba.aVU();
                        }
                        if ((gVar.field_msg_type & 8) != 0) {
                            am.bbc().s(gVar.field_card_id, gVar.field_card_tp_id, gVar.field_report_scene);
                        }
                        if ((gVar.field_msg_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            gVar.baQ();
                            am.bbm().b(gVar);
                        }
                        if ((gVar.field_msg_type & 4096) != 0 && gVar.field_need_pull_card_entrance) {
                            f.a aVar = f.kfh;
                            f.a.fF(true);
                        }
                        com.tencent.mm.plugin.card.d.l.beB();
                    }
                    AppMethodBeat.o(87938);
                }
            });
            AppMethodBeat.o(87939);
        }
    };
    private bz.a keV = new bz.a() {
        public final void a(final com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(87941);
            final String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
                AppMethodBeat.o(87941);
                return;
            }
            am.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87940);
                    c bbg = am.bbg();
                    String str = a;
                    ab.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(aVar.eAB.ptF)));
                    if (!TextUtils.isEmpty(str)) {
                        c.a aVar;
                        Map z = br.z(str, "sysmsg");
                        if (z == null) {
                            aVar = null;
                        } else {
                            c.a aVar2 = new c.a();
                            String str2 = (String) z.get(".sysmsg.notifysharecard.state_flag");
                            if (TextUtils.isEmpty(str2) || !com.tencent.mm.plugin.card.d.l.isNumeric(str2)) {
                                aVar2.kfy = 0;
                            } else {
                                aVar2.kfy = Integer.valueOf(str2).intValue();
                            }
                            aVar2.username = (String) z.get(".sysmsg.notifysharecard.username");
                            aVar2.cMC = (String) z.get(".sysmsg.notifysharecard.card_id");
                            aVar = aVar2;
                        }
                        if (aVar == null) {
                            ab.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                            AppMethodBeat.o(87940);
                            return;
                        }
                        if (TextUtils.isEmpty(aVar.cMC)) {
                            ab.e("MicroMsg.ShareCardMsgMgr", "card id == null");
                        }
                        ab.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + aVar.cMC);
                        am.bbd().bbr();
                        com.tencent.mm.plugin.card.d.l.beD();
                    }
                    AppMethodBeat.o(87940);
                }
            });
            AppMethodBeat.o(87941);
        }
    };
    private com.tencent.mm.sdk.b.c<ik> keW = new com.tencent.mm.sdk.b.c<ik>() {
        {
            AppMethodBeat.i(87933);
            this.xxI = ik.class.getName().hashCode();
            AppMethodBeat.o(87933);
        }

        private static boolean a(ik ikVar) {
            AppMethodBeat.i(87934);
            ab.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s", Integer.valueOf(((Integer) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue()), Integer.valueOf(((Integer) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(1))).intValue()));
            if (((Integer) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(1))).intValue() == 2) {
                String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INFO_STRING_SYNC, (Object) "");
                if (!bo.isNullOrNil(str)) {
                    try {
                        ny nyVar = (ny) new ny().parseFrom(str.getBytes(a.k.d.ISO_8859_1));
                        com.tencent.mm.plugin.card.d.b.t(nyVar.tzW, nyVar.ttg, nyVar.tIE);
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.SubCoreCard", e, "", new Object[0]);
                    }
                }
            } else if (r1 != 1) {
                if (ikVar.cDz.context != null) {
                    Intent intent = new Intent(ikVar.cDz.context, CardHomePageUI.class);
                    intent.putExtra("key_from_scene", 22);
                    intent.putExtra("key_home_page_from_scene", ikVar.cDz.scene);
                    ikVar.cDz.context.startActivity(intent);
                    com.tencent.mm.plugin.card.b.k.baK();
                    if (ikVar.cDz.cDB == 1) {
                        h.pYm.e(16322, Integer.valueOf(2));
                    }
                }
                ikVar.cDA.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (ikVar.cDz.context != null) {
                ikVar.cDz.context.startActivity(new Intent(ikVar.cDz.context, CardHomePageNewUI.class));
                com.tencent.mm.plugin.card.b.k.baK();
                if (ikVar.cDz.cDB == 1) {
                    h.pYm.e(16322, Integer.valueOf(3));
                }
            }
            f.a aVar = f.kfh;
            f.a.fF(false);
            AppMethodBeat.o(87934);
            return true;
        }
    };
    private com.tencent.mm.plugin.card.b.b kev;
    private c kew;
    private al kex;
    private h kez;
    private ak mHandler = new ak(Looper.getMainLooper());

    public am() {
        AppMethodBeat.i(87942);
        File file = new File(m.kdH);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(m.kdI);
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.o(87942);
    }

    private static am getCore() {
        am core;
        AppMethodBeat.i(87943);
        com.tencent.mm.plugin.card.a.a aVar = (com.tencent.mm.plugin.card.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.card.a.a.class);
        if (aVar != null) {
            core = ((PluginCard) aVar).getCore();
        } else {
            core = null;
        }
        AppMethodBeat.o(87943);
        return core;
    }

    static {
        AppMethodBeat.i(87964);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return c.fnj;
            }
        });
        eaA.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return al.fnj;
            }
        });
        eaA.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return h.fnj;
            }
        });
        eaA.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        eaA.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        eaA.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return j.fnj;
            }
        });
        eaA.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return l.fnj;
            }
        });
        AppMethodBeat.o(87964);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        com.tencent.mm.ai.f fVar;
        AppMethodBeat.i(87944);
        ab.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", Boolean.valueOf(z));
        com.tencent.mm.sdk.b.a.xxA.c(this.keS);
        com.tencent.mm.sdk.b.a.xxA.c(this.keT);
        com.tencent.mm.sdk.b.a.xxA.c(this.keO);
        com.tencent.mm.sdk.b.a.xxA.c(this.keP);
        com.tencent.mm.sdk.b.a.xxA.c(this.keQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.keW);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("carditemmsg", this.keU, true);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("notifysharecard", this.keV, true);
        this.keF = null;
        if (this.keG != null) {
            this.keG.kaV.clear();
            this.keG = null;
        }
        if (this.keA != null) {
            fVar = this.keA;
            synchronized (fVar.kbO) {
                try {
                    fVar.kbO.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(87944);
                    }
                }
            }
            synchronized (fVar.kbP) {
                try {
                    fVar.kbP.clear();
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(87944);
                    }
                }
            }
            com.tencent.mm.kernel.g.RO().eJo.b(563, fVar);
            com.tencent.mm.modelgeo.d agz = com.tencent.mm.modelgeo.d.agz();
            if (agz != null) {
                agz.c(fVar);
            }
            if (fVar.kbR != null) {
                com.tencent.mm.kernel.g.RO().eJo.c(fVar.kbR);
            }
            this.keA = null;
        }
        if (this.kev != null) {
            this.kev.detach();
            this.kev = null;
        }
        if (this.keB != null) {
            fVar = this.keB;
            synchronized (fVar.eMl) {
                try {
                    fVar.kaA.clear();
                    fVar.kaB.clear();
                } catch (Throwable th3) {
                    while (true) {
                        AppMethodBeat.o(87944);
                    }
                }
            }
            if (fVar.kfo != null) {
                com.tencent.mm.kernel.g.RO().eJo.c(fVar.kfo);
            }
            com.tencent.mm.kernel.g.RO().eJo.b((int) i.SCENE_BIZ_SCROLL, fVar);
            this.keB = null;
        }
        if (this.keI != null) {
            this.keI.release();
            com.tencent.mm.plugin.card.b.d dVar = this.keI;
            dVar.kaD.clear();
            dVar.kaP.clear();
            dVar.kaQ.clear();
            dVar.kaR.clear();
            dVar.kaT = false;
            this.keI = null;
        }
        if (this.keJ != null) {
            com.tencent.mm.ai.f fVar2 = this.keJ;
            com.tencent.mm.kernel.g.RO().eJo.b(907, fVar2);
            Iterator it = fVar2.kbA.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) fVar2.kbC.get(str);
                fVar2.kbC.remove(str);
                fVar2.kbB.removeCallbacks(runnable);
            }
            fVar2.kbz.clear();
            fVar2.kbA.clear();
            fVar2.kbC.clear();
            this.keJ = null;
        }
        if (this.keK != null) {
            this.keK.release();
            this.keK = null;
        }
        if (this.keL != null) {
            this.keL.release();
            this.keL = null;
        }
        this.keH = null;
        b.aMe().registerActivityLifecycleCallbacks(this.keR);
        if (z) {
            f.a aVar = f.kfh;
            f.a.fF(true);
        }
        AppMethodBeat.o(87944);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(87945);
        if (getCore().kev != null) {
            getCore().kev.detach();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.keS);
        com.tencent.mm.sdk.b.a.xxA.d(this.keT);
        com.tencent.mm.sdk.b.a.xxA.d(this.keO);
        com.tencent.mm.sdk.b.a.xxA.d(this.keP);
        com.tencent.mm.sdk.b.a.xxA.d(this.keQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.keW);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("carditemmsg", this.keU, true);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("notifysharecard", this.keV, true);
        b.aMe().unregisterActivityLifecycleCallbacks(this.keR);
        AppMethodBeat.o(87945);
    }

    public static com.tencent.mm.plugin.card.b.b baV() {
        AppMethodBeat.i(87946);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().kev == null) {
            getCore().kev = new com.tencent.mm.plugin.card.b.b();
        }
        com.tencent.mm.plugin.card.b.b bVar = getCore().kev;
        AppMethodBeat.o(87946);
        return bVar;
    }

    public static c baW() {
        AppMethodBeat.i(87947);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().kew == null) {
            getCore().kew = new c(com.tencent.mm.kernel.g.RP().eJN);
        }
        c cVar = getCore().kew;
        AppMethodBeat.o(87947);
        return cVar;
    }

    public static al baX() {
        AppMethodBeat.i(87948);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().kex == null) {
            getCore().kex = new al(com.tencent.mm.kernel.g.RP().eJN);
        }
        al alVar = getCore().kex;
        AppMethodBeat.o(87948);
        return alVar;
    }

    public static h baY() {
        AppMethodBeat.i(87949);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().kez == null) {
            getCore().kez = new h(com.tencent.mm.kernel.g.RP().eJN);
        }
        h hVar = getCore().kez;
        AppMethodBeat.o(87949);
        return hVar;
    }

    public static m baZ() {
        AppMethodBeat.i(87950);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keA == null) {
            getCore().keA = new m();
        }
        m mVar = getCore().keA;
        AppMethodBeat.o(87950);
        return mVar;
    }

    public static com.tencent.mm.plugin.card.b.k bba() {
        AppMethodBeat.i(87951);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keF == null) {
            getCore().keF = new com.tencent.mm.plugin.card.b.k();
        }
        com.tencent.mm.plugin.card.b.k kVar = getCore().keF;
        AppMethodBeat.o(87951);
        return kVar;
    }

    public static e bbb() {
        AppMethodBeat.i(87952);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keG == null) {
            getCore().keG = new e();
        }
        e eVar = getCore().keG;
        AppMethodBeat.o(87952);
        return eVar;
    }

    public static l bbc() {
        AppMethodBeat.i(87953);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keH == null) {
            getCore().keH = new l();
        }
        l lVar = getCore().keH;
        AppMethodBeat.o(87953);
        return lVar;
    }

    public static a bbd() {
        AppMethodBeat.i(87954);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keB == null) {
            getCore().keB = new a();
        }
        a aVar = getCore().keB;
        AppMethodBeat.o(87954);
        return aVar;
    }

    public static k bbe() {
        AppMethodBeat.i(87955);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keC == null) {
            getCore().keC = new k(com.tencent.mm.kernel.g.RP().eJN);
        }
        k kVar = getCore().keC;
        AppMethodBeat.o(87955);
        return kVar;
    }

    public static o bbf() {
        AppMethodBeat.i(87956);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keD == null) {
            getCore().keD = new o(com.tencent.mm.kernel.g.RP().eJN);
        }
        o oVar = getCore().keD;
        AppMethodBeat.o(87956);
        return oVar;
    }

    public static c bbg() {
        AppMethodBeat.i(87957);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keE == null) {
            getCore().keE = new c();
        }
        c cVar = getCore().keE;
        AppMethodBeat.o(87957);
        return cVar;
    }

    public static com.tencent.mm.plugin.card.b.d bbh() {
        AppMethodBeat.i(87958);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keI == null) {
            getCore().keI = new com.tencent.mm.plugin.card.b.d();
        }
        com.tencent.mm.plugin.card.b.d dVar = getCore().keI;
        AppMethodBeat.o(87958);
        return dVar;
    }

    public static j bbi() {
        AppMethodBeat.i(87959);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keJ == null) {
            getCore().keJ = new j();
        }
        j jVar = getCore().keJ;
        AppMethodBeat.o(87959);
        return jVar;
    }

    public static com.tencent.mm.plugin.card.b.c bbj() {
        AppMethodBeat.i(87960);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keK == null) {
            getCore().keK = new com.tencent.mm.plugin.card.b.c();
        }
        com.tencent.mm.plugin.card.b.c cVar = getCore().keK;
        AppMethodBeat.o(87960);
        return cVar;
    }

    public static l bbk() {
        AppMethodBeat.i(87961);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keM == null) {
            getCore().keM = new l(com.tencent.mm.kernel.g.RP().eJN);
        }
        l lVar = getCore().keM;
        AppMethodBeat.o(87961);
        return lVar;
    }

    public static j bbl() {
        AppMethodBeat.i(87962);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keN == null) {
            getCore().keN = new j(com.tencent.mm.kernel.g.RP().eJN);
        }
        j jVar = getCore().keN;
        AppMethodBeat.o(87962);
        return jVar;
    }

    public static g bbm() {
        AppMethodBeat.i(87963);
        com.tencent.mm.kernel.g.RN().QU();
        if (getCore().keL == null) {
            getCore().keL = new g();
        }
        g gVar = getCore().keL;
        AppMethodBeat.o(87963);
        return gVar;
    }
}
