package com.tencent.p177mm.plugin.card.model;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p230g.p231a.C26214pb;
import com.tencent.p177mm.p230g.p231a.C37726hi;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.card.PluginCard;
import com.tencent.p177mm.plugin.card.model.p353a.C33765f;
import com.tencent.p177mm.plugin.card.model.p353a.C33765f.C2758a;
import com.tencent.p177mm.plugin.card.p1542a.C38726a;
import com.tencent.p177mm.plugin.card.p352b.C11268c;
import com.tencent.p177mm.plugin.card.p352b.C20119a;
import com.tencent.p177mm.plugin.card.p352b.C20123j;
import com.tencent.p177mm.plugin.card.p352b.C2752k;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.plugin.card.p352b.C27568d;
import com.tencent.p177mm.plugin.card.p352b.C33753g;
import com.tencent.p177mm.plugin.card.p352b.C33756o;
import com.tencent.p177mm.plugin.card.p352b.C38727e;
import com.tencent.p177mm.plugin.card.p352b.C38732n;
import com.tencent.p177mm.plugin.card.p352b.C6813l;
import com.tencent.p177mm.plugin.card.p352b.C6814m;
import com.tencent.p177mm.plugin.card.p355ui.C11332b;
import com.tencent.p177mm.plugin.card.p355ui.CardHomePageUI;
import com.tencent.p177mm.plugin.card.p355ui.p356v2.CardHomePageNewUI;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.sharecard.model.C20155k;
import com.tencent.p177mm.plugin.card.sharecard.model.C38753o;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C20150c;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C20150c.C11295a;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42855a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15368nz;
import com.tencent.p177mm.protocal.protobuf.C30208ny;
import com.tencent.p177mm.protocal.protobuf.C46570nm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000a.p051k.C17355d;

/* renamed from: com.tencent.mm.plugin.card.model.am */
public class C42852am implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C6814m keA;
    private C42855a keB;
    private C20155k keC;
    private C38753o keD;
    private C20150c keE;
    private C2752k keF = null;
    private C38727e keG = null;
    private C6813l keH = null;
    private C27568d keI = null;
    private C20123j keJ = null;
    private C11268c keK;
    private C33753g keL;
    private C11289l keM;
    private C7603j keN;
    private C4884c keO = new C38732n();
    private C4884c keP = new C33756o();
    private C4884c keQ = new C20119a();
    private C11332b keR = new C11332b();
    private C4884c keS = new C428481();
    private C4884c keT = new C201445();
    private C1837a keU = new C201456();
    private C1837a keV = new C201477();
    private C4884c<C18296ik> keW = new C201434();
    private C27567b kev;
    private C27587c kew;
    private C20141al kex;
    private C45786h kez;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.card.model.am$4 */
    class C201434 extends C4884c<C18296ik> {
        C201434() {
            AppMethodBeat.m2504i(87933);
            this.xxI = C18296ik.class.getName().hashCode();
            AppMethodBeat.m2505o(87933);
        }

        /* renamed from: a */
        private static boolean m31162a(C18296ik c18296ik) {
            AppMethodBeat.m2504i(87934);
            C4990ab.m7417i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s", Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue()), Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(1))).intValue()));
            if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(1))).intValue() == 2) {
                String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INFO_STRING_SYNC, (Object) "");
                if (!C5046bo.isNullOrNil(str)) {
                    try {
                        C30208ny c30208ny = (C30208ny) new C30208ny().parseFrom(str.getBytes(C17355d.ISO_8859_1));
                        C45774b.m84635t(c30208ny.tzW, c30208ny.ttg, c30208ny.tIE);
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreCard", e, "", new Object[0]);
                    }
                }
            } else if (r1 != 1) {
                if (c18296ik.cDz.context != null) {
                    Intent intent = new Intent(c18296ik.cDz.context, CardHomePageUI.class);
                    intent.putExtra("key_from_scene", 22);
                    intent.putExtra("key_home_page_from_scene", c18296ik.cDz.scene);
                    c18296ik.cDz.context.startActivity(intent);
                    C2752k.baK();
                    if (c18296ik.cDz.cDB == 1) {
                        C7060h.pYm.mo8381e(16322, Integer.valueOf(2));
                    }
                }
                c18296ik.cDA.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (c18296ik.cDz.context != null) {
                c18296ik.cDz.context.startActivity(new Intent(c18296ik.cDz.context, CardHomePageNewUI.class));
                C2752k.baK();
                if (c18296ik.cDz.cDB == 1) {
                    C7060h.pYm.mo8381e(16322, Integer.valueOf(3));
                }
            }
            C2758a c2758a = C33765f.kfh;
            C2758a.m5011fF(false);
            AppMethodBeat.m2505o(87934);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$5 */
    class C201445 extends C4884c<C26214pb> {
        C201445() {
            AppMethodBeat.m2504i(87936);
            this.xxI = C26214pb.class.getName().hashCode();
            AppMethodBeat.m2505o(87936);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(87937);
            C4990ab.m7416i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
            C20141al baX = C42852am.baX();
            C4990ab.m7410d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
            baX.bSd.mo10108hY("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
            AppMethodBeat.m2505o(87937);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$6 */
    class C201456 implements C1837a {
        C201456() {
        }

        /* renamed from: a */
        public final void mo5414a(final C1197a c1197a) {
            AppMethodBeat.m2504i(87939);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
                AppMethodBeat.m2505o(87939);
                return;
            }
            C42852am.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87938);
                    C2752k bba = C42852am.bba();
                    String str = a;
                    String str2 = c1197a.eAB.ptF;
                    C4990ab.m7416i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str2)));
                    if (!TextUtils.isEmpty(str)) {
                        C38747g c38747g;
                        Map z = C5049br.m7595z(str, "sysmsg");
                        if (z == null) {
                            c38747g = null;
                        } else {
                            C38747g c38747g2 = new C38747g();
                            str = (String) z.get(".sysmsg.carditemmsg.card_type");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.field_card_type = 0;
                            } else {
                                c38747g2.field_card_type = Integer.valueOf(str).intValue();
                            }
                            c38747g2.field_title = (String) z.get(".sysmsg.carditemmsg.title");
                            c38747g2.field_description = (String) z.get(".sysmsg.carditemmsg.description");
                            c38747g2.field_logo_url = (String) z.get(".sysmsg.carditemmsg.logo_url");
                            c38747g2.field_logo_color = (String) z.get(".sysmsg.carditemmsg.logo_color");
                            str = (String) z.get(".sysmsg.carditemmsg.time");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.field_time = (int) (System.currentTimeMillis() / 1000);
                            } else if (Long.valueOf(str).longValue() >= 2147483647L) {
                                c38747g2.field_time = BaseClientBuilder.API_PRIORITY_OTHER;
                            } else {
                                c38747g2.field_time = Integer.valueOf(str).intValue();
                            }
                            c38747g2.field_card_id = (String) z.get(".sysmsg.carditemmsg.card_id");
                            c38747g2.field_card_tp_id = (String) z.get(".sysmsg.carditemmsg.card_tp_id");
                            c38747g2.field_msg_id = (String) z.get(".sysmsg.carditemmsg.msg_id");
                            str = (String) z.get(".sysmsg.carditemmsg.msg_type");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.field_msg_type = 0;
                            } else {
                                c38747g2.field_msg_type = Integer.valueOf(str).intValue();
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.jump_type");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.field_jump_type = 1;
                            } else {
                                c38747g2.field_jump_type = Integer.valueOf(str).intValue();
                            }
                            c38747g2.field_url = (String) z.get(".sysmsg.carditemmsg.url");
                            str = (String) z.get(".sysmsg.carditemmsg.button.text");
                            if (!TextUtils.isEmpty(str)) {
                                C46570nm c46570nm = new C46570nm();
                                c46570nm.text = str;
                                c46570nm.url = (String) z.get(".sysmsg.carditemmsg.button.url");
                                str = (String) z.get(".sysmsg.carditemmsg.button.action_type");
                                if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                    c46570nm.kdC = 0;
                                } else {
                                    c46570nm.kdC = Integer.valueOf(str).intValue();
                                }
                                c38747g2.kdt = c46570nm;
                                try {
                                    c38747g2.field_buttonData = c38747g2.kdt.toByteArray();
                                } catch (Exception e) {
                                    C4990ab.m7413e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", e.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                }
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.opt_region.text");
                            if (!TextUtils.isEmpty(str)) {
                                C15368nz c15368nz = new C15368nz();
                                c15368nz.text = str;
                                c15368nz.url = (String) z.get(".sysmsg.carditemmsg.opt_region.url");
                                str = (String) z.get(".sysmsg.carditemmsg.opt_region.type");
                                if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                    c15368nz.type = 0;
                                } else {
                                    c15368nz.type = Integer.valueOf(str).intValue();
                                }
                                str = (String) z.get(".sysmsg.carditemmsg.opt_region.endtime");
                                if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                    c15368nz.qsz = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str).longValue() >= 2147483647L) {
                                    c15368nz.qsz = BaseClientBuilder.API_PRIORITY_OTHER;
                                } else {
                                    c15368nz.qsz = Integer.valueOf(str).intValue();
                                }
                                c38747g2.kdu = c15368nz;
                                try {
                                    c38747g2.field_operData = c38747g2.kdu.toByteArray();
                                } catch (Exception e2) {
                                    C4990ab.m7413e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", e2.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                }
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.report_scene");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.field_report_scene = 2;
                            } else {
                                c38747g2.field_report_scene = Integer.valueOf(str).intValue();
                            }
                            c38747g2.field_read_state = 1;
                            c38747g2.field_accept_buttons = C2752k.m5002i(z, ".sysmsg.carditemmsg");
                            c38747g2.field_jump_buttons = C2752k.m5001h(z, ".sysmsg.carditemmsg");
                            str = (String) z.get(".sysmsg.carditemmsg.get_layout_scene");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.kdx = 0;
                            } else {
                                c38747g2.kdx = Integer.valueOf(str).intValue();
                            }
                            c38747g2.field_consumed_box_id = (String) z.get(".sysmsg.carditemmsg.consumed_box_id");
                            c38747g2.kdn = (String) z.get(".sysmsg.carditemmsg.reddot_wording");
                            c38747g2.kdo = (String) z.get(".sysmsg.carditemmsg.reddot_buff");
                            c38747g2.kdp = (String) z.get(".sysmsg.carditemmsg.reddot_icon_url");
                            c38747g2.kdq = (String) z.get(".sysmsg.carditemmsg.msg_tips.title");
                            c38747g2.kdr = (String) z.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                            str = (String) z.get(".sysmsg.carditemmsg.msg_scene");
                            if (TextUtils.isEmpty(str) || !C38736l.isNumeric(str)) {
                                c38747g2.kdy = 0;
                            } else {
                                c38747g2.kdy = Integer.valueOf(str).intValue();
                                C4990ab.m7416i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(str)));
                            }
                            str = (String) z.get(".sysmsg.carditemmsg.need_check");
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(str)));
                            if (TextUtils.isEmpty(str)) {
                                c38747g2.kds = false;
                            } else {
                                c38747g2.kds = str.equals("true");
                            }
                            String str3 = (String) z.get(".sysmsg.carditemmsg.all_unavailable");
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(str)));
                            if (TextUtils.isEmpty(str3)) {
                                c38747g2.kdz = false;
                            } else {
                                c38747g2.kdz = str3.equals("true");
                            }
                            c38747g2.field_unavailable_qr_code_list = C2752k.m5003j(z, ".sysmsg.carditemmsg");
                            c38747g2.field_need_pull_card_entrance = "true".equals(z.get(".sysmsg.carditemmsg.need_pull_card_entrance"));
                            c38747g = c38747g2;
                        }
                        if (c38747g == null) {
                            C4990ab.m7412e("MicroMsg.CardMsgManager", "card msg == null");
                            AppMethodBeat.m2505o(87938);
                            return;
                        }
                        if (TextUtils.isEmpty(c38747g.field_card_id)) {
                            C4990ab.m7412e("MicroMsg.CardMsgManager", "card id == null");
                        }
                        str = c38747g.field_msg_id;
                        c38747g.field_msg_id = str2;
                        if (TextUtils.isEmpty(c38747g.field_msg_id)) {
                            c38747g.field_msg_id = str;
                        }
                        if (TextUtils.isEmpty(c38747g.field_msg_id)) {
                            c38747g.field_msg_id = System.currentTimeMillis();
                        }
                        C4990ab.m7416i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + c38747g.field_msg_id);
                        C4990ab.m7416i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + c38747g.field_msg_type);
                        if (c38747g.kdx != 0) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(c38747g.kdx));
                        }
                        C4990ab.m7416i("MicroMsg.CardMsgManager", "reddot_buff is " + c38747g.kdo);
                        if (TextUtils.isEmpty(c38747g.kdo)) {
                            C4990ab.m7412e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                        } else {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, c38747g.kdo);
                        }
                        if ((c38747g.field_msg_type & 1) != 0) {
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "msg_tips_title is " + c38747g.kdq);
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + c38747g.kdr);
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, c38747g.kdq);
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, c38747g.kdr);
                        }
                        boolean bX = C16112c.m24429PK().mo28551bX(262152, 266256);
                        if (!(bX || (c38747g.field_msg_type & 64) == 0)) {
                            C16112c.m24429PK().mo28556x(262152, true);
                            bX = true;
                        }
                        if (bX) {
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "has card new msg, return");
                        } else {
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "not has new!");
                            if ((c38747g.field_msg_type & 32) != 0) {
                                C16112c.m24429PK().mo28557y(262152, true);
                                C4990ab.m7416i("MicroMsg.CardMsgManager", "has reddot");
                                bX = true;
                            } else {
                                C4990ab.m7412e("MicroMsg.CardMsgManager", "not has reddot!");
                                bX = false;
                            }
                            boolean z2;
                            if (TextUtils.isEmpty(c38747g.kdn)) {
                                C4990ab.m7412e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                                z2 = false;
                            } else {
                                C4990ab.m7416i("MicroMsg.CardMsgManager", "reddot_wording is " + c38747g.kdn);
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, c38747g.kdn);
                                C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, true);
                                z2 = true;
                            }
                            C4990ab.m7416i("MicroMsg.CardMsgManager", "reddot_icon_url is " + c38747g.kdp);
                            boolean z3;
                            if (TextUtils.isEmpty(c38747g.kdp)) {
                                C4990ab.m7412e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                                z3 = false;
                            } else {
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, c38747g.kdp);
                                C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, true);
                                z3 = true;
                            }
                            if (!(bX && z2 && z3)) {
                                if (bX && z2 && !z3) {
                                    C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                } else if (bX && !z2 && z3) {
                                    C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                } else if (!bX && z2 && z3) {
                                    C16112c.m24429PK().mo28557y(262152, false);
                                } else if (bX && !z2 && !z3) {
                                    C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                    C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                } else if (!bX && z2 && !z3) {
                                    C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                                    C16112c.m24429PK().mo28557y(262152, false);
                                } else if (!(bX || z2 || !z3)) {
                                    C16112c.m24429PK().mo28542a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                                    C16112c.m24429PK().mo28557y(262152, false);
                                }
                            }
                            if (bX || z2 || z3) {
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, c38747g.field_card_id);
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.valueOf(c38747g.kds));
                                C4990ab.m7416i("MicroMsg.CardMsgManager", "card_id:" + c38747g.field_card_id + "  need_check:" + c38747g.kds);
                            }
                        }
                        if ((c38747g.field_msg_type & 1) != 0) {
                            if (bba.mo6827Gq(c38747g.field_msg_id)) {
                                C4990ab.m7412e("MicroMsg.CardMsgManager", "msg for id " + c38747g.field_msg_id + " is exist!!");
                                bba.mo6828Gr(c38747g.field_msg_id);
                                bba.kbM.add(c38747g);
                                C2752k.m4999c(c38747g);
                            } else {
                                bba.kbM.add(c38747g);
                                C2752k.m4999c(c38747g);
                                if ((c38747g.field_msg_type & 128) != 0) {
                                    bba.kbN++;
                                }
                            }
                            C1720g.m3536RP().mo5239Ry().set(139268, Integer.valueOf(bba.kbN));
                            bba.mo6830a(c38747g);
                        }
                        if ((c38747g.field_msg_type & 2) != 0) {
                            C42852am.baV();
                            C27567b.m43779sO(c38747g.kdx);
                        }
                        if ((c38747g.field_msg_type & 4) != 0) {
                            bba.aVU();
                        }
                        if ((c38747g.field_msg_type & 8) != 0) {
                            C42852am.bbc().mo15082s(c38747g.field_card_id, c38747g.field_card_tp_id, c38747g.field_report_scene);
                        }
                        if ((c38747g.field_msg_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            c38747g.baQ();
                            C42852am.bbm().mo54288b(c38747g);
                        }
                        if ((c38747g.field_msg_type & 4096) != 0 && c38747g.field_need_pull_card_entrance) {
                            C2758a c2758a = C33765f.kfh;
                            C2758a.m5011fF(true);
                        }
                        C38736l.beB();
                    }
                    AppMethodBeat.m2505o(87938);
                }
            });
            AppMethodBeat.m2505o(87939);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$7 */
    class C201477 implements C1837a {
        C201477() {
        }

        /* renamed from: a */
        public final void mo5414a(final C1197a c1197a) {
            AppMethodBeat.m2504i(87941);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (a == null || a.length() == 0) {
                C4990ab.m7412e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
                AppMethodBeat.m2505o(87941);
                return;
            }
            C42852am.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(87940);
                    C20150c bbg = C42852am.bbg();
                    String str = a;
                    C4990ab.m7416i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(c1197a.eAB.ptF)));
                    if (!TextUtils.isEmpty(str)) {
                        C11295a c11295a;
                        Map z = C5049br.m7595z(str, "sysmsg");
                        if (z == null) {
                            c11295a = null;
                        } else {
                            C11295a c11295a2 = new C11295a();
                            String str2 = (String) z.get(".sysmsg.notifysharecard.state_flag");
                            if (TextUtils.isEmpty(str2) || !C38736l.isNumeric(str2)) {
                                c11295a2.kfy = 0;
                            } else {
                                c11295a2.kfy = Integer.valueOf(str2).intValue();
                            }
                            c11295a2.username = (String) z.get(".sysmsg.notifysharecard.username");
                            c11295a2.cMC = (String) z.get(".sysmsg.notifysharecard.card_id");
                            c11295a = c11295a2;
                        }
                        if (c11295a == null) {
                            C4990ab.m7412e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                            AppMethodBeat.m2505o(87940);
                            return;
                        }
                        if (TextUtils.isEmpty(c11295a.cMC)) {
                            C4990ab.m7412e("MicroMsg.ShareCardMsgMgr", "card id == null");
                        }
                        C4990ab.m7416i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + c11295a.cMC);
                        C42852am.bbd().bbr();
                        C38736l.beD();
                    }
                    AppMethodBeat.m2505o(87940);
                }
            });
            AppMethodBeat.m2505o(87941);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$3 */
    static class C275863 implements C1366d {
        C275863() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C11289l.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$11 */
    static class C3874211 implements C1366d {
        C3874211() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20155k.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$1 */
    class C428481 extends C4884c<C37726hi> {
        C428481() {
            AppMethodBeat.m2504i(87931);
            this.xxI = C37726hi.class.getName().hashCode();
            AppMethodBeat.m2505o(87931);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(87932);
            final C37726hi c37726hi = (C37726hi) c4883b;
            C4990ab.m7416i("MicroMsg.SubCoreCard.cardGetCountListener", "deal with card notify event GetCardCountEvent");
            if (c37726hi instanceof C37726hi) {
                C42852am.this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(87930);
                        if (C1720g.m3531RK()) {
                            boolean z = c37726hi.cCe.cCf;
                            C4990ab.m7416i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is ".concat(String.valueOf(z)));
                            boolean beC = C38736l.beC();
                            boolean beE = C38736l.beE();
                            if (beC && beE) {
                                C4990ab.m7416i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
                                AppMethodBeat.m2505o(87930);
                                return;
                            }
                            if (z) {
                                C1720g.m3535RO().eJo.mo14541a(new C38751y(), 0);
                            } else {
                                int intValue;
                                Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(282882, null);
                                if (num != null) {
                                    intValue = num.intValue();
                                } else {
                                    intValue = 0;
                                }
                                if (((int) (System.currentTimeMillis() / 1000)) - intValue >= 7200) {
                                    C1720g.m3535RO().eJo.mo14541a(new C38751y(), 0);
                                }
                            }
                            if (beE) {
                                Long l = (Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0));
                                if (l != null && l.longValue() == 0) {
                                    C42852am.bbd().bbr();
                                }
                            }
                            if (beC && TextUtils.isEmpty((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null))) {
                                C42852am.baV();
                                C27567b.m43779sO(1);
                            }
                            AppMethodBeat.m2505o(87930);
                            return;
                        }
                        AppMethodBeat.m2505o(87930);
                    }
                }, 10000);
            }
            AppMethodBeat.m2505o(87932);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$2 */
    static class C428492 implements C1366d {
        C428492() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7603j.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$8 */
    static class C428508 implements C1366d {
        C428508() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C27587c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$9 */
    static class C428519 implements C1366d {
        C428519() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C20141al.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$10 */
    static class C4285310 implements C1366d {
        C4285310() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45786h.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.am$12 */
    static class C4285412 implements C1366d {
        C4285412() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C38753o.fnj;
        }
    }

    public C42852am() {
        AppMethodBeat.m2504i(87942);
        File file = new File(C33770m.kdH);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(C33770m.kdI);
        if (!file.exists()) {
            file.mkdir();
        }
        AppMethodBeat.m2505o(87942);
    }

    private static C42852am getCore() {
        C42852am core;
        AppMethodBeat.m2504i(87943);
        C38726a c38726a = (C38726a) C1720g.m3530M(C38726a.class);
        if (c38726a != null) {
            core = ((PluginCard) c38726a).getCore();
        } else {
            core = null;
        }
        AppMethodBeat.m2505o(87943);
        return core;
    }

    static {
        AppMethodBeat.m2504i(87964);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new C428508());
        eaA.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new C428519());
        eaA.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new C4285310());
        eaA.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new C3874211());
        eaA.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new C4285412());
        eaA.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new C428492());
        eaA.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new C275863());
        AppMethodBeat.m2505o(87964);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        C1202f c1202f;
        AppMethodBeat.m2504i(87944);
        C4990ab.m7417i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", Boolean.valueOf(z));
        C4879a.xxA.mo10052c(this.keS);
        C4879a.xxA.mo10052c(this.keT);
        C4879a.xxA.mo10052c(this.keO);
        C4879a.xxA.mo10052c(this.keP);
        C4879a.xxA.mo10052c(this.keQ);
        C4879a.xxA.mo10052c(this.keW);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("carditemmsg", this.keU, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("notifysharecard", this.keV, true);
        this.keF = null;
        if (this.keG != null) {
            this.keG.kaV.clear();
            this.keG = null;
        }
        if (this.keA != null) {
            c1202f = this.keA;
            synchronized (c1202f.kbO) {
                try {
                    c1202f.kbO.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(87944);
                    }
                }
            }
            synchronized (c1202f.kbP) {
                try {
                    c1202f.kbP.clear();
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(87944);
                    }
                }
            }
            C1720g.m3535RO().eJo.mo14546b(563, c1202f);
            C26443d agz = C26443d.agz();
            if (agz != null) {
                agz.mo44208c(c1202f);
            }
            if (c1202f.kbR != null) {
                C1720g.m3535RO().eJo.mo14547c(c1202f.kbR);
            }
            this.keA = null;
        }
        if (this.kev != null) {
            this.kev.detach();
            this.kev = null;
        }
        if (this.keB != null) {
            c1202f = this.keB;
            synchronized (c1202f.eMl) {
                try {
                    c1202f.kaA.clear();
                    c1202f.kaB.clear();
                } catch (Throwable th3) {
                    while (true) {
                        AppMethodBeat.m2505o(87944);
                    }
                }
            }
            if (c1202f.kfo != null) {
                C1720g.m3535RO().eJo.mo14547c(c1202f.kfo);
            }
            C1720g.m3535RO().eJo.mo14546b((int) C1625i.SCENE_BIZ_SCROLL, c1202f);
            this.keB = null;
        }
        if (this.keI != null) {
            this.keI.release();
            C27568d c27568d = this.keI;
            c27568d.kaD.clear();
            c27568d.kaP.clear();
            c27568d.kaQ.clear();
            c27568d.kaR.clear();
            c27568d.kaT = false;
            this.keI = null;
        }
        if (this.keJ != null) {
            C1202f c1202f2 = this.keJ;
            C1720g.m3535RO().eJo.mo14546b(907, c1202f2);
            Iterator it = c1202f2.kbA.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Runnable runnable = (Runnable) c1202f2.kbC.get(str);
                c1202f2.kbC.remove(str);
                c1202f2.kbB.removeCallbacks(runnable);
            }
            c1202f2.kbz.clear();
            c1202f2.kbA.clear();
            c1202f2.kbC.clear();
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
        C11332b.aMe().registerActivityLifecycleCallbacks(this.keR);
        if (z) {
            C2758a c2758a = C33765f.kfh;
            C2758a.m5011fF(true);
        }
        AppMethodBeat.m2505o(87944);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(87945);
        if (C42852am.getCore().kev != null) {
            C42852am.getCore().kev.detach();
        }
        C4879a.xxA.mo10053d(this.keS);
        C4879a.xxA.mo10053d(this.keT);
        C4879a.xxA.mo10053d(this.keO);
        C4879a.xxA.mo10053d(this.keP);
        C4879a.xxA.mo10053d(this.keQ);
        C4879a.xxA.mo10053d(this.keW);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("carditemmsg", this.keU, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("notifysharecard", this.keV, true);
        C11332b.aMe().unregisterActivityLifecycleCallbacks(this.keR);
        AppMethodBeat.m2505o(87945);
    }

    public static C27567b baV() {
        AppMethodBeat.m2504i(87946);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().kev == null) {
            C42852am.getCore().kev = new C27567b();
        }
        C27567b c27567b = C42852am.getCore().kev;
        AppMethodBeat.m2505o(87946);
        return c27567b;
    }

    public static C27587c baW() {
        AppMethodBeat.m2504i(87947);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().kew == null) {
            C42852am.getCore().kew = new C27587c(C1720g.m3536RP().eJN);
        }
        C27587c c27587c = C42852am.getCore().kew;
        AppMethodBeat.m2505o(87947);
        return c27587c;
    }

    public static C20141al baX() {
        AppMethodBeat.m2504i(87948);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().kex == null) {
            C42852am.getCore().kex = new C20141al(C1720g.m3536RP().eJN);
        }
        C20141al c20141al = C42852am.getCore().kex;
        AppMethodBeat.m2505o(87948);
        return c20141al;
    }

    public static C45786h baY() {
        AppMethodBeat.m2504i(87949);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().kez == null) {
            C42852am.getCore().kez = new C45786h(C1720g.m3536RP().eJN);
        }
        C45786h c45786h = C42852am.getCore().kez;
        AppMethodBeat.m2505o(87949);
        return c45786h;
    }

    public static C6814m baZ() {
        AppMethodBeat.m2504i(87950);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keA == null) {
            C42852am.getCore().keA = new C6814m();
        }
        C6814m c6814m = C42852am.getCore().keA;
        AppMethodBeat.m2505o(87950);
        return c6814m;
    }

    public static C2752k bba() {
        AppMethodBeat.m2504i(87951);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keF == null) {
            C42852am.getCore().keF = new C2752k();
        }
        C2752k c2752k = C42852am.getCore().keF;
        AppMethodBeat.m2505o(87951);
        return c2752k;
    }

    public static C38727e bbb() {
        AppMethodBeat.m2504i(87952);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keG == null) {
            C42852am.getCore().keG = new C38727e();
        }
        C38727e c38727e = C42852am.getCore().keG;
        AppMethodBeat.m2505o(87952);
        return c38727e;
    }

    public static C6813l bbc() {
        AppMethodBeat.m2504i(87953);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keH == null) {
            C42852am.getCore().keH = new C6813l();
        }
        C6813l c6813l = C42852am.getCore().keH;
        AppMethodBeat.m2505o(87953);
        return c6813l;
    }

    public static C42855a bbd() {
        AppMethodBeat.m2504i(87954);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keB == null) {
            C42852am.getCore().keB = new C42855a();
        }
        C42855a c42855a = C42852am.getCore().keB;
        AppMethodBeat.m2505o(87954);
        return c42855a;
    }

    public static C20155k bbe() {
        AppMethodBeat.m2504i(87955);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keC == null) {
            C42852am.getCore().keC = new C20155k(C1720g.m3536RP().eJN);
        }
        C20155k c20155k = C42852am.getCore().keC;
        AppMethodBeat.m2505o(87955);
        return c20155k;
    }

    public static C38753o bbf() {
        AppMethodBeat.m2504i(87956);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keD == null) {
            C42852am.getCore().keD = new C38753o(C1720g.m3536RP().eJN);
        }
        C38753o c38753o = C42852am.getCore().keD;
        AppMethodBeat.m2505o(87956);
        return c38753o;
    }

    public static C20150c bbg() {
        AppMethodBeat.m2504i(87957);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keE == null) {
            C42852am.getCore().keE = new C20150c();
        }
        C20150c c20150c = C42852am.getCore().keE;
        AppMethodBeat.m2505o(87957);
        return c20150c;
    }

    public static C27568d bbh() {
        AppMethodBeat.m2504i(87958);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keI == null) {
            C42852am.getCore().keI = new C27568d();
        }
        C27568d c27568d = C42852am.getCore().keI;
        AppMethodBeat.m2505o(87958);
        return c27568d;
    }

    public static C20123j bbi() {
        AppMethodBeat.m2504i(87959);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keJ == null) {
            C42852am.getCore().keJ = new C20123j();
        }
        C20123j c20123j = C42852am.getCore().keJ;
        AppMethodBeat.m2505o(87959);
        return c20123j;
    }

    public static C11268c bbj() {
        AppMethodBeat.m2504i(87960);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keK == null) {
            C42852am.getCore().keK = new C11268c();
        }
        C11268c c11268c = C42852am.getCore().keK;
        AppMethodBeat.m2505o(87960);
        return c11268c;
    }

    public static C11289l bbk() {
        AppMethodBeat.m2504i(87961);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keM == null) {
            C42852am.getCore().keM = new C11289l(C1720g.m3536RP().eJN);
        }
        C11289l c11289l = C42852am.getCore().keM;
        AppMethodBeat.m2505o(87961);
        return c11289l;
    }

    public static C7603j bbl() {
        AppMethodBeat.m2504i(87962);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keN == null) {
            C42852am.getCore().keN = new C7603j(C1720g.m3536RP().eJN);
        }
        C7603j c7603j = C42852am.getCore().keN;
        AppMethodBeat.m2505o(87962);
        return c7603j;
    }

    public static C33753g bbm() {
        AppMethodBeat.m2504i(87963);
        C1720g.m3534RN().mo5159QU();
        if (C42852am.getCore().keL == null) {
            C42852am.getCore().keL = new C33753g();
        }
        C33753g c33753g = C42852am.getCore().keL;
        AppMethodBeat.m2505o(87963);
        return c33753g;
    }
}
