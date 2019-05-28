package com.tencent.p177mm.plugin.game;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p230g.p231a.C26242ss;
import com.tencent.p177mm.p230g.p231a.C32607ok;
import com.tencent.p177mm.p230g.p231a.C37722gx;
import com.tencent.p177mm.p230g.p231a.C37725gz;
import com.tencent.p177mm.p230g.p231a.C37729hr;
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.p230g.p231a.C41999hc;
import com.tencent.p177mm.p230g.p231a.C45327gw;
import com.tencent.p177mm.p230g.p231a.C45329gy;
import com.tencent.p177mm.p230g.p231a.C45351oj;
import com.tencent.p177mm.p230g.p231a.C6519lw;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.p230g.p231a.C9369gv;
import com.tencent.p177mm.p230g.p231a.C9419mz;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.game.commlib.C20945b;
import com.tencent.p177mm.plugin.game.model.C12174s;
import com.tencent.p177mm.plugin.game.model.C12175u;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C21004l;
import com.tencent.p177mm.plugin.game.model.C28227m;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28236t;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.model.C43189f;
import com.tencent.p177mm.plugin.game.model.C43191i;
import com.tencent.p177mm.plugin.game.model.C46010aw;
import com.tencent.p177mm.plugin.game.model.C46011p;
import com.tencent.p177mm.plugin.game.model.C46011p.C210061;
import com.tencent.p177mm.plugin.game.model.C46012r;
import com.tencent.p177mm.plugin.game.model.p978a.C20985d;
import com.tencent.p177mm.plugin.game.model.p978a.C43186h;
import com.tencent.p177mm.plugin.game.model.p978a.C43186h.C43185a;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.GameCenterUI;
import com.tencent.p177mm.plugin.game.p433ui.GameDetailUI;
import com.tencent.p177mm.plugin.game.p433ui.GameLibraryUI;
import com.tencent.p177mm.plugin.game.p433ui.GameMessageUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1077c.C35783d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.c */
public final class C20931c {
    C4884c egQ = new C121053();
    C4884c lOc = new C209438();
    C1837a luy = new C209331();
    C46010aw mSR = new C46010aw();
    C4884c mSS = new C2093710();
    C4884c mST = new C2094111();
    C4884c mSU = new C1210312();
    C4884c mSV = new C2093213();
    C4884c mSW = new C1210414();
    C4884c mSX = new C692815();
    C4884c mSY = new C2093516();
    C4884c mSZ = new C2093617();
    C35783d mTa = new C209302();
    C4884c mTb = new C209344();
    C4884c mTc = new C209385();
    C4884c mTd = new C209426();
    C4884c mTe = new C209397();
    C4884c mTf = new C209409();

    /* renamed from: com.tencent.mm.plugin.game.c$15 */
    class C692815 extends C4884c<C45351oj> {
        C692815() {
            AppMethodBeat.m2504i(111160);
            this.xxI = C45351oj.class.getName().hashCode();
            AppMethodBeat.m2505o(111160);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111161);
            C45351oj c45351oj = (C45351oj) c4883b;
            C34277b.m56210a(C4996ah.getContext(), c45351oj.cKF.scene, c45351oj.cKF.cKG, 1, c45351oj.cKF.action, 0, c45351oj.cKF.appId, 0, c45351oj.cKF.msgType, c45351oj.cKF.cJb, c45351oj.cKF.ctu, c45351oj.cKF.cKH);
            AppMethodBeat.m2505o(111161);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$12 */
    class C1210312 extends C4884c<C9365gt> {
        C1210312() {
            AppMethodBeat.m2504i(111153);
            this.xxI = C9365gt.class.getName().hashCode();
            AppMethodBeat.m2505o(111153);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111154);
            C9365gt c9365gt = (C9365gt) c4883b;
            switch (c9365gt.cBv.actionCode) {
                case 1:
                    C20993e.m32263a(c9365gt.cBv.context, c9365gt.cBv.appId, c9365gt.cBv.messageAction, c9365gt.cBv.messageExt, null);
                    C34277b.m56211a(c9365gt.cBv.context, c9365gt.cBv.scene, c9365gt.cBv.scene, 1, 3, c9365gt.cBv.appId, 0, null);
                    break;
                case 2:
                    int i = c9365gt.cBv.scene;
                    C4990ab.m7417i("MicroMsg.GameEventListener", "scene = %d, extinfo = %s", Integer.valueOf(i), c9365gt.cBv.extMsg);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game_report_from_scene", i);
                    bundle.putCharSequence("game_app_id", c9365gt.cBv.appId);
                    bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                    C34277b.m56211a(c9365gt.cBv.context, c9365gt.cBv.scene, c9365gt.cBv.scene, 1, C46001c.m85451a(c9365gt.cBv.context, c9365gt.cBv.appId, null, bundle, c9365gt.cBv.scene), c9365gt.cBv.appId, 0, null);
                    break;
                case 3:
                    C28227m.update();
                    break;
                case 5:
                    int i2 = c9365gt.cBv.scene;
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    C21004l.m32304a(C39215q.bEo(), i2, 2);
                    break;
            }
            AppMethodBeat.m2505o(111154);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$14 */
    class C1210414 extends C4884c<C6519lw> {
        C1210414() {
            AppMethodBeat.m2504i(111157);
            this.xxI = C6519lw.class.getName().hashCode();
            AppMethodBeat.m2505o(111157);
        }

        /* renamed from: a */
        private static boolean m20031a(C6519lw c6519lw) {
            int i;
            AppMethodBeat.m2504i(111158);
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(c6519lw.cHK.extraInfo);
                str = jSONObject.optString("appId");
                i = C5046bo.getInt(jSONObject.optString("ssid"), 0);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e.getMessage());
                i = 0;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e2.getMessage());
                i = 0;
            }
            Intent intent = new Intent();
            switch (c6519lw.cHK.cHL) {
                case 0:
                    intent.setClass(c6519lw.cHK.context, GameCenterUI.class);
                    if (c6519lw.cHK.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    c6519lw.cHK.context.startActivity(intent);
                    C34277b.m56209a(c6519lw.cHK.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(c6519lw.cHK.context, GameLibraryUI.class);
                    if (c6519lw.cHK.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    c6519lw.cHK.context.startActivity(intent);
                    C34277b.m56209a(c6519lw.cHK.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (!C5046bo.isNullOrNil(str)) {
                        intent.setClass(c6519lw.cHK.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", str);
                        if (c6519lw.cHK.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        c6519lw.cHK.context.startActivity(intent);
                        C34277b.m56209a(c6519lw.cHK.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(c6519lw.cHK.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    c6519lw.cHK.context.startActivity(intent);
                    C34277b.m56209a(c6519lw.cHK.context, 5, 5, 1, 6, i, null);
                    break;
            }
            AppMethodBeat.m2505o(111158);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$3 */
    class C121053 extends C4884c<C26242ss> {
        C121053() {
            AppMethodBeat.m2504i(111138);
            this.xxI = C26242ss.class.getName().hashCode();
            AppMethodBeat.m2505o(111138);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111139);
            C26242ss c26242ss = (C26242ss) c4883b;
            if (c26242ss.cOR.cOS.equals(C45329gy.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C20931c.this.mTa.axy();
                } else {
                    C20931c.this.mTa.unregister();
                }
            }
            AppMethodBeat.m2505o(111139);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$2 */
    class C209302 extends C35783d {
        C209302() {
        }

        /* renamed from: NJ */
        public final C4883b mo36283NJ(String str) {
            AppMethodBeat.m2504i(111136);
            C45329gy c45329gy = new C45329gy();
            c45329gy.cBG.ctq = str;
            AppMethodBeat.m2505o(111136);
            return c45329gy;
        }

        public final C7296k bCU() {
            AppMethodBeat.m2504i(111137);
            C46012r bCY = ((C45983c) C1720g.m3528K(C45983c.class)).bCY();
            AppMethodBeat.m2505o(111137);
            return bCY;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$13 */
    class C2093213 extends C4884c<C37722gx> {
        C2093213() {
            AppMethodBeat.m2504i(111155);
            this.xxI = C37722gx.class.getName().hashCode();
            AppMethodBeat.m2505o(111155);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111156);
            C37722gx c37722gx = (C37722gx) c4883b;
            C28229n c28229n;
            switch (c37722gx.cBD.f16120Cn) {
                case 1:
                    String str = c37722gx.cBD.cBy;
                    LinkedList linkedList = new LinkedList();
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int i = C5046bo.getInt(jSONObject.optString("type"), 0);
                            int i2 = C5046bo.getInt(jSONObject.optString("limit"), 0);
                            long j = C5046bo.getLong(jSONObject.optString("lastLocalId"), -1);
                            int i3 = C5046bo.getInt(jSONObject.optString("isUnread"), -1);
                            if (i2 > 0 && i2 <= Downloads.MIN_WAIT_FOR_NETWORK && j >= 0 && i3 >= 0) {
                                LinkedList b = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73898b(i, j, i3, i2);
                                if (!C5046bo.m7548ek(b)) {
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = b.iterator();
                                    while (it.hasNext()) {
                                        c28229n = (C28229n) it.next();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("localId", c28229n.field_msgId);
                                        jSONObject2.put(C8741b.CONTENT, c28229n.field_rawXML);
                                        jSONArray.put(jSONObject2);
                                    }
                                    c37722gx.cBE.cBF = jSONArray.toString();
                                    break;
                                }
                            }
                        } catch (JSONException e) {
                            C4990ab.m7421w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e.getMessage());
                            break;
                        }
                    }
                    break;
                case 2:
                    C12174s.m20104a(c37722gx);
                    break;
                case 3:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    c28229n = C39215q.bEq();
                    if (c28229n != null) {
                        c37722gx.cBE.cBF = c28229n.field_rawXML;
                        break;
                    }
                    break;
                case 4:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    C39215q.bEr();
                    break;
                case 5:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (c28229n == null || c28229n.field_isHidden) {
                        c28229n = null;
                    }
                    if (c28229n != null) {
                        c37722gx.cBE.cBF = c28229n.field_rawXML;
                        break;
                    }
                    break;
                case 6:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (!(c28229n == null || c28229n.field_isHidden)) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                        break;
                    }
                case 9:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    c28229n = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (c28229n != null) {
                        c37722gx.cBE.cBF = c28229n.field_rawXML;
                        break;
                    }
                    break;
                case 10:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    if (((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue()) != null) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(111156);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$1 */
    class C209331 implements C1837a {
        C209331() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:163:0x06cb  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x0738  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x055a  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0537  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            C28229n c28229n;
            long j;
            Object obj;
            AppMethodBeat.m2504i(111135);
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7417i("MicroMsg.GameMessageService", "Received a message: %d", Long.valueOf(r0.ptF));
            C4990ab.m7416i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(a)));
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7412e("MicroMsg.GameMessageParser", "msg content is null");
                c28229n = null;
            } else {
                Map z = C5049br.m7595z(a, "sysmsg");
                if (z == null || z.size() == 0) {
                    C4990ab.m7412e("MicroMsg.GameMessageParser", "Parse failed");
                    c28229n = null;
                } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
                    C28229n c28229n2 = new C28229n();
                    c28229n2.field_showInMsgList = true;
                    c28229n2.field_msgId = System.currentTimeMillis();
                    c28229n2.field_rawXML = a;
                    c28229n2.field_msgType = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    if (c28229n2.field_msgType == 100 || c28229n2.field_msgType == 30) {
                        C12175u.bEx();
                        c28229n2.field_gameMsgId = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.msg_id"), "");
                        c28229n2.field_appId = (String) z.get(".sysmsg.gamecenter.appid");
                        c28229n2.field_createTime = C5046bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = C5046bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            c28229n2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            c28229n2.field_expireTime = C5046bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000) + j;
                        }
                        c28229n2.mWf = C5046bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.random_time"), 0);
                        c28229n2.field_isHidden = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        c28229n2.field_mergerId = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.merge_id"), "");
                        c28229n2.field_weight = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.weight"), "");
                        c28229n2.field_receiveTime = System.currentTimeMillis() / 1000;
                        C12175u.m20114q(z, c28229n2);
                        c28229n2.mWE = C5046bo.getLong((String) z.get(".sysmsg.gamecenter.filter_flag"), 0);
                        c28229n2.mWF = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        c28229n2.mWq = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        c28229n2.mWr.mXj = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (C5046bo.isNullOrNil((String) z.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && C5046bo.isNullOrNil((String) z.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            c28229n2.mWs = false;
                        } else {
                            c28229n2.mWs = true;
                        }
                        C12175u.m20116s(z, c28229n2);
                        c28229n2.mWW.mXy = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        c28229n2.mWW.kgX = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        if (!C5046bo.isNullOrNil(c28229n2.mWW.mXy)) {
                            c28229n2.field_isHidden = true;
                        }
                        c28229n2.mWW.mXz = C5046bo.getLong((String) z.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                        C12175u.m20118u(z, c28229n2);
                    } else {
                        c28229n2.field_gameMsgId = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.msg_id"), "");
                        c28229n2.field_msgType = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (c28229n2.field_msgType == 0) {
                            c28229n2.field_msgType = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        c28229n2.field_appId = (String) z.get(".sysmsg.gamecenter.appinfo.appid");
                        c28229n2.field_showInMsgList = !C5046bo.isNullOrNil(C46011p.m85487I(z));
                        c28229n2.field_createTime = C5046bo.getLong((String) z.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = C5046bo.getLong((String) z.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            c28229n2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            c28229n2.field_expireTime = C5046bo.getLong((String) z.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000) + j;
                        }
                        c28229n2.field_isHidden = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        c28229n2.field_mergerId = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.merge_id"), "");
                        if (c28229n2.field_msgType == 10) {
                            c28229n2.field_weight = "6";
                        } else {
                            c28229n2.field_weight = "2";
                        }
                        c28229n2.field_receiveTime = System.currentTimeMillis() / 1000;
                        c28229n2.mWE = C5046bo.getLong((String) z.get(".sysmsg.game_control_info.filter_flag"), 0);
                        c28229n2.mWD = C46011p.m85488J(z);
                        c28229n2.mWF = C5046bo.getInt((String) z.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        c28229n2.mWs = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        c28229n2.mXc = C5046bo.m7532bc((String) z.get(".sysmsg.gamecenter.noticeid"), "");
                        c28229n2.mWr.mXl = C5046bo.getInt((String) z.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        c28229n2.mWq = c28229n2.mWr.mXl > 0;
                        if ((c28229n2.mWD & 4) == 0) {
                            c28229n2.mWq = false;
                        }
                        C46011p.m85500k(z, c28229n2);
                    }
                    if (c28229n2.mWF == 1) {
                        c28229n2.field_showInMsgList = false;
                    }
                    c28229n2.mWY.mXA = C5046bo.getInt((String) z.get(".sysmsg.support_version.$android"), 0);
                    C4990ab.m7417i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", Integer.valueOf(c28229n2.mWY.mXA), Integer.valueOf(C7243d.vxo));
                    if (c28229n2.mWY.mXA == 0 || c28229n2.mWY.mXA <= C7243d.vxo) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        C4990ab.m7416i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
                        C34277b.m56210a(C4996ah.getContext(), 0, 0, 0, 401, 0, c28229n2.field_appId, 0, 0, c28229n2.field_gameMsgId, c28229n2.mXc, "");
                        c28229n = null;
                    } else {
                        c28229n2.mWZ.mXy = C5046bo.m7532bc((String) z.get(".sysmsg.wepkg.$pkg_id"), "");
                        c28229n2.mWZ.mXB = C5046bo.getInt((String) z.get(".sysmsg.wepkg.download_trigger_type"), 0);
                        new Thread(new C210061(c28229n2.mWZ.mXy, c28229n2.mWZ.mXB)).start();
                        c28229n = c28229n2;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.GameMessageParser", "Type not matched");
                    c28229n = null;
                }
            }
            if (c28229n != null) {
                int i;
                String str;
                int i2;
                C4990ab.m7417i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", Integer.valueOf(c28229n.field_msgType), c28229n.field_appId, Long.valueOf(c28229n.field_msgId));
                if (c28229n == null) {
                    C4990ab.m7412e("MicroMsg.GameMessageService", "msg is null");
                    i = -1;
                } else {
                    a = c28229n.field_gameMsgId;
                    if (!C5046bo.isNullOrNil(a)) {
                        int i3 = 0;
                        Cursor rawQuery = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + a + "\"", new String[0]);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                i3 = rawQuery.getInt(0);
                            }
                            rawQuery.close();
                            if (i3 > 0) {
                                obj = 1;
                                if (obj == null) {
                                    C4990ab.m7413e("MicroMsg.GameMessageService", "duplicated msg:%s", c28229n.field_gameMsgId);
                                    C7060h.pYm.mo8378a(858, 4, 1, false);
                                    i = 2;
                                } else {
                                    if (c28229n.field_expireTime <= System.currentTimeMillis() / 1000) {
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                    String str2;
                                    C9497vv c9497vv;
                                    if (obj == null) {
                                        C4990ab.m7413e("MicroMsg.GameMessageService", "msg is expired Time, %s", c28229n.field_gameMsgId);
                                        C7060h.pYm.mo8378a(858, 5, 1, false);
                                        str2 = c28229n.mWW.mXy;
                                        if (!C5046bo.isNullOrNil(str2)) {
                                            c9497vv = new C9497vv();
                                            c9497vv.cSX.cuy = 6;
                                            c9497vv.cSX.cSY = str2;
                                            C4879a.xxA.mo10055m(c9497vv);
                                        }
                                        i = 1;
                                    } else {
                                        long j2 = c28229n.mWE;
                                        str = c28229n.field_appId;
                                        if (j2 == 1) {
                                            if (C5046bo.isNullOrNil(str) || !C46494g.m87757u(C4996ah.getContext(), str)) {
                                                C7060h.pYm.mo8378a(858, 6, 1, false);
                                                i3 = 3;
                                            }
                                            i3 = 0;
                                        } else {
                                            if (j2 == 2 && (C5046bo.isNullOrNil(str) || C46494g.m87757u(C4996ah.getContext(), str))) {
                                                C7060h.pYm.mo8378a(858, 7, 1, false);
                                                i3 = 4;
                                            }
                                            i3 = 0;
                                        }
                                        if (i3 != 0) {
                                            C4990ab.m7413e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", c28229n.field_gameMsgId, Integer.valueOf(i3));
                                            i = i3;
                                        } else {
                                            if (c28229n.field_msgType == 30) {
                                                C7060h.pYm.mo8378a(858, 8, 1, false);
                                            } else {
                                                C28229n bEs;
                                                C28229n bEm = C39215q.bEm();
                                                if (bEm == null) {
                                                    bEm = C39215q.bEo();
                                                }
                                                if (bEm == null) {
                                                    bEm = C39215q.bEq();
                                                }
                                                if (bEm == null) {
                                                    bEs = C39215q.bEs();
                                                } else {
                                                    bEs = bEm;
                                                }
                                                if (bEs != null) {
                                                    bEs.bEl();
                                                    JSONObject jSONObject = new JSONObject();
                                                    try {
                                                        jSONObject.put("oldNoticeId", bEs.mXc);
                                                        jSONObject.put("oldMsgId", bEs.field_gameMsgId);
                                                        if (c28229n.field_weight.compareTo(bEs.field_weight) >= 0) {
                                                            jSONObject.put("coverType", 1);
                                                        } else {
                                                            jSONObject.put("coverType", 2);
                                                        }
                                                    } catch (Exception e) {
                                                        C4990ab.m7412e("MicroMsg.GameMessageService", "reportMsgCover: " + e.getMessage());
                                                    }
                                                    i2 = c28229n.field_msgType;
                                                    if (c28229n.field_msgType == 100) {
                                                        i2 = c28229n.mXb;
                                                    }
                                                    C34277b.m56210a(C4996ah.getContext(), 0, 0, 0, 31, 0, c28229n.field_appId, 0, i2, c28229n.field_gameMsgId, c28229n.mXc, C34276a.m56208kY(jSONObject.toString()));
                                                    if (c28229n.field_weight.compareTo(bEs.field_weight) >= 0) {
                                                        C7060h.pYm.mo8378a(858, 10, 1, false);
                                                        str2 = bEs.mWW.mXy;
                                                        if (!C5046bo.isNullOrNil(str2)) {
                                                            c9497vv = new C9497vv();
                                                            c9497vv.cSX.cuy = 6;
                                                            c9497vv.cSX.cSY = str2;
                                                            C4879a.xxA.mo10055m(c9497vv);
                                                        }
                                                        obj = 1;
                                                    } else {
                                                        C7060h.pYm.mo8378a(858, 11, 1, false);
                                                        obj = null;
                                                    }
                                                    if (obj == null) {
                                                        obj = null;
                                                        if (obj != null) {
                                                            if (c28229n.mWq) {
                                                                C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(c28229n.field_msgId));
                                                            } else {
                                                                C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                                                            }
                                                            if (C5046bo.isNullOrNil(c28229n.mWG.url)) {
                                                                C39215q.bEp();
                                                            } else {
                                                                C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(c28229n.field_msgId));
                                                            }
                                                            if (c28229n.mWs) {
                                                                C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(c28229n.field_msgId));
                                                            } else {
                                                                C39215q.bEr();
                                                            }
                                                            if (C5046bo.isNullOrNil(c28229n.mWX.mXi)) {
                                                                C39215q.bEt();
                                                            } else {
                                                                C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(c28229n.field_msgId));
                                                            }
                                                        }
                                                        if (c28229n.field_msgType == 4) {
                                                            C1720g.m3536RP().mo5239Ry().set(C5127a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(c28229n.field_msgId));
                                                        }
                                                        if (!(c28229n == null || C5046bo.isNullOrNil(c28229n.mWr.mXj))) {
                                                            C46001c.m85449Ot(c28229n.mWr.mXj);
                                                        }
                                                    }
                                                }
                                                obj = 1;
                                                if (obj != null) {
                                                }
                                                if (c28229n.field_msgType == 4) {
                                                }
                                                C46001c.m85449Ot(c28229n.mWr.mXj);
                                            }
                                            i = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                    }
                }
                if (i == 0) {
                    C39215q.m66822c(c28229n);
                    switch (c28229n.field_msgType) {
                        case 30:
                            C43186h bFa = C43185a.mZh;
                            if (c28229n != null && !C5046bo.isNullOrNil(c28229n.field_appId)) {
                                str = c28229n.field_appId;
                                j = c28229n.field_expireTime;
                                long j3 = c28229n.mWf;
                                C20985d c20985d = new C20985d();
                                c20985d.field_appId = str;
                                if (!((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo10102b((C4925c) c20985d, new String[0])) {
                                    c20985d.field_expireTime = j;
                                    c20985d.field_randomTime = j3;
                                    c20985d.field_isFirst = true;
                                    c20985d.field_isRunning = false;
                                    c20985d.field_noWifi = true;
                                    c20985d.field_noSdcard = true;
                                    c20985d.field_noEnoughSpace = true;
                                    c20985d.field_lowBattery = true;
                                    c20985d.field_continueDelay = true;
                                    boolean b = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo10101b((C4925c) c20985d);
                                    C4990ab.m7417i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", c20985d.field_appId, Long.valueOf(c20985d.field_expireTime), Long.valueOf(c20985d.field_randomTime), Boolean.valueOf(b));
                                    bFa.mo68678hO(false);
                                    break;
                                }
                                C4990ab.m7417i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", str);
                                C45405b.eBF.mo60571j(str, 17);
                                break;
                            }
                            C4990ab.m7416i("MicroMsg.GameSilentDownloader", "msg is null");
                            C45405b.eBF.mo60571j("appid_is_empty", 16);
                            break;
                            break;
                        default:
                            C4990ab.m7417i("MicroMsg.GameMessageService", "Insert raw message: %b", Boolean.valueOf(((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo10101b((C4925c) c28229n)));
                            break;
                    }
                    C7060h.pYm.mo8378a(858, 1, 1, false);
                }
                i2 = c28229n.field_msgType;
                if (c28229n.field_msgType == 100) {
                    i2 = c28229n.mXb;
                }
                C34277b.m56210a(C4996ah.getContext(), 0, 0, 0, 18, i, c28229n.field_appId, 0, i2, c28229n.field_gameMsgId, c28229n.mXc, C34277b.m56213eA("resource", String.valueOf(c28229n.mWr.mXl)));
                C7060h.pYm.mo8378a(858, 0, 1, false);
            }
            AppMethodBeat.m2505o(111135);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$4 */
    class C209344 extends C4884c<C9369gv> {
        C209344() {
            AppMethodBeat.m2504i(111140);
            this.xxI = C9369gv.class.getName().hashCode();
            AppMethodBeat.m2505o(111140);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C9369gv c9369gv = (C9369gv) c4883b;
            C43191i.cBA = c9369gv.cBz.cBA;
            C43191i.countryCode = c9369gv.cBz.countryCode;
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$16 */
    class C2093516 extends C4884c<C32607ok> {
        C2093516() {
            AppMethodBeat.m2504i(111162);
            this.xxI = C32607ok.class.getName().hashCode();
            AppMethodBeat.m2505o(111162);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111163);
            C32607ok c32607ok = (C32607ok) c4883b;
            C37860c.eBG.mo60575a(c32607ok.cKI.context, c32607ok.cKI.csB, c32607ok.cKI.packageName, c32607ok.cKI.cEV, c32607ok.cKI.msgType, c32607ok.cKI.scene, c32607ok.cKI.cKJ, c32607ok.cKI.mediaTagName, c32607ok.cKI.cKK, c32607ok.cKI.cKL, c32607ok.cKI.cst);
            AppMethodBeat.m2505o(111163);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$17 */
    class C2093617 extends C4884c<C9367gu> {
        C2093617() {
            AppMethodBeat.m2504i(111164);
            this.xxI = C9367gu.class.getName().hashCode();
            AppMethodBeat.m2505o(111164);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111165);
            C43189f.m76762a((C9367gu) c4883b);
            AppMethodBeat.m2505o(111165);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$10 */
    class C2093710 extends C4884c<C45327gw> {
        C2093710() {
            AppMethodBeat.m2504i(111149);
            this.xxI = C45327gw.class.getName().hashCode();
            AppMethodBeat.m2505o(111149);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111150);
            C45327gw c45327gw = (C45327gw) c4883b;
            C20998j.m32286a(c45327gw.cBC.url, c45327gw.cBC.cvZ, c45327gw.cBC.scene != 0 ? c45327gw.cBC.scene : 1000, c45327gw.cBC.appId, c45327gw.cBC.extInfo);
            AppMethodBeat.m2505o(111150);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$5 */
    class C209385 extends C4884c<C37729hr> {
        C209385() {
            AppMethodBeat.m2504i(111141);
            this.xxI = C37729hr.class.getName().hashCode();
            AppMethodBeat.m2505o(111141);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            ((C37729hr) c4883b).cCC.cBA = C43191i.cBA;
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$7 */
    class C209397 extends C4884c<C6523mp> {
        C209397() {
            AppMethodBeat.m2504i(111144);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(111144);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111145);
            C20945b.bDn().mo36287hI(false);
            AppMethodBeat.m2505o(111145);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$9 */
    class C209409 extends C4884c<C37725gz> {
        C209409() {
            AppMethodBeat.m2504i(111147);
            this.xxI = C37725gz.class.getName().hashCode();
            AppMethodBeat.m2505o(111147);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111148);
            C37725gz c37725gz = (C37725gz) c4883b;
            String str = c37725gz.cBH.url;
            c37725gz.cBI.cBJ = C43158a.mSO;
            switch (c37725gz.cBH.f13665Cn) {
                case 1:
                    c37725gz.cBI.cBK = C3220a.nnu.mo73885Op(str);
                    break;
                case 2:
                    C3220a.nnu.mo73886Oq(str);
                    break;
            }
            AppMethodBeat.m2505o(111148);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$11 */
    class C2094111 extends C4884c<C9419mz> {
        C2094111() {
            AppMethodBeat.m2504i(111151);
            this.xxI = C9419mz.class.getName().hashCode();
            AppMethodBeat.m2505o(111151);
        }

        /* JADX WARNING: Missing block: B:47:0x01b0, code skipped:
            if ((((((new java.util.GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50) <= com.tencent.p177mm.sdk.platformtools.C5046bo.m7560gV(100, 0)) goto L_0x0086;
     */
        /* JADX WARNING: Missing block: B:62:0x01fe, code skipped:
            if ((((r3 + r5) * 10) + 50) <= com.tencent.p177mm.sdk.platformtools.C5046bo.m7560gV(100, 0)) goto L_0x0086;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i = 1;
            AppMethodBeat.m2504i(111152);
            C9419mz c9419mz = (C9419mz) c4883b;
            if (C5046bo.isNullOrNil(c9419mz.cIX.content)) {
                C28229n iP;
                ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
                if (longValue != 0) {
                    iP = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73903iP(longValue);
                } else {
                    iP = null;
                }
                if (iP != null) {
                    int i2;
                    iP.bEl();
                    if (System.currentTimeMillis() / 1000 <= iP.field_receiveTime + iP.mWW.mXz) {
                        C9497vv c9497vv;
                        switch (iP.mWW.kgX) {
                            case 0:
                                i2 = 1;
                                break;
                            case 1:
                                c9497vv = new C9497vv();
                                c9497vv.cSX.cuy = 2;
                                c9497vv.cSX.cSY = iP.mWW.mXy;
                                C4879a.xxA.mo10055m(c9497vv);
                                if (!c9497vv.cSX.cSZ) {
                                    i2 = 0;
                                    break;
                                }
                                i2 = 1;
                                break;
                            case 2:
                                c9497vv = new C9497vv();
                                c9497vv.cSX.cuy = 4;
                                c9497vv.cSX.cSY = iP.mWW.mXy;
                                C4879a.xxA.mo10055m(c9497vv);
                                if (c9497vv.cSX.cTa <= 0) {
                                    i2 = 0;
                                    break;
                                }
                                i2 = 1;
                                break;
                            default:
                                i2 = 0;
                                break;
                        }
                    }
                    i2 = 1;
                    if (iP.mWC > 0) {
                        if (C5023at.isWifi(C4996ah.getContext())) {
                            C4990ab.m7416i("MicroMsg.GameWifiStrategy", "WifiStrategy:isInWifi");
                        } else {
                            int i3;
                            GregorianCalendar gregorianCalendar = new GregorianCalendar();
                            int i4 = gregorianCalendar.get(11);
                            gregorianCalendar.get(12);
                            if (i4 >= 21) {
                                i3 = 3;
                            } else if (i4 < 12) {
                                i3 = 0;
                            } else if (i4 < 14) {
                                i3 = 1;
                            } else if (i4 < 18) {
                                i3 = 0;
                            } else {
                                i3 = 2;
                            }
                            C4990ab.m7416i("MicroMsg.GameWifiStrategy", "WifiStrategy:inWhichTimeRange = ".concat(String.valueOf(i3)));
                            if (i3 != 0) {
                                if (i3 != 3) {
                                    if (i3 == 1) {
                                        C4990ab.m7417i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", Integer.valueOf(((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50), Integer.valueOf(C5046bo.m7560gV(100, 0)));
                                    } else if (i3 == 2) {
                                        gregorianCalendar = new GregorianCalendar();
                                        i4 = gregorianCalendar.get(11) - 18;
                                        if (gregorianCalendar.get(12) > 30) {
                                            i3 = 1;
                                        } else {
                                            i3 = 0;
                                        }
                                        C4990ab.m7417i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", Integer.valueOf(((i3 + i4) * 10) + 50), Integer.valueOf(C5046bo.m7560gV(100, 0)));
                                    }
                                }
                            }
                            if (i == 0 && i2 != 0) {
                                ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEu();
                            }
                        }
                        i = 0;
                        ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEu();
                    } else if (i2 != 0) {
                        ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEu();
                    }
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                    C28229n bEm = C39215q.bEm();
                    if (bEm != null) {
                        bEm.bEl();
                        C34276a.m56202Oh(bEm.mXc);
                        c9419mz.cIX.showType = bEm.mWr.mXl;
                        c9419mz.cIX.appId = bEm.field_appId;
                        c9419mz.cIX.appName = bEm.mWr.mText;
                        c9419mz.cIX.cIY = bEm.mWr.mXj;
                        c9419mz.cIX.cIZ = bEm.mWr.mXm;
                        c9419mz.cIX.cJa = bEm.mWr.mXn;
                        c9419mz.cIX.msgType = bEm.field_msgType;
                        if (bEm.field_msgType == 100) {
                            c9419mz.cIX.msgType = bEm.mXb;
                        }
                        c9419mz.cIX.cJb = bEm.field_gameMsgId;
                        c9419mz.cIX.ctu = bEm.mXc;
                    }
                }
            } else {
                String str = c9419mz.cIX.content;
                if (str != null && str.startsWith("//gamemsg:")) {
                    new C7254cm().vED = C1946aa.m4154vy(str.substring(10));
                    str = str.substring(10);
                    if (!C5046bo.isNullOrNil(str)) {
                        if (str.equals("jumpnative")) {
                            Intent intent = new Intent();
                            intent.putExtra("from_find_more_friend", true);
                            C25985d.m41467b(C4996ah.getContext(), "game", ".ui.tab.GameRouteUI", intent);
                        } else if (str.equals("jumpLibrary")) {
                            C25985d.m41467b(C4996ah.getContext(), "game", ".ui.GameLibraryUI", new Intent());
                        } else if (str.contains("jumpDetail:")) {
                            str = str.substring(11, str.length());
                            Intent intent2 = new Intent();
                            intent2.putExtra("game_app_id", str);
                            C25985d.m41467b(C4996ah.getContext(), "game", ".ui.GameDetailUI2", intent2);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(111152);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$6 */
    class C209426 extends C4884c<C41999hc> {
        C209426() {
            AppMethodBeat.m2504i(111142);
            this.xxI = C41999hc.class.getName().hashCode();
            AppMethodBeat.m2505o(111142);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(111143);
            C41999hc c41999hc = (C41999hc) c4883b;
            C4990ab.m7417i("MicroMsg.GameEventListener", "opType = %d, opStatus = %d, appId = %s", Integer.valueOf(c41999hc.cBN.opType), Integer.valueOf(c41999hc.cBN.cBO), c41999hc.cBN.appId);
            if (c41999hc.cBN.opType != 0) {
                switch (c41999hc.cBN.opType) {
                    case 2:
                        C20998j.bEg();
                        C20998j.m32285a(c41999hc.cBN.appId, c41999hc.cBN.cBO, false, c41999hc.cBN.cvq);
                        break;
                    case 6:
                        C20998j.bEg();
                        C20998j.m32290ex(c41999hc.cBN.appId, c41999hc.cBN.cvq);
                        break;
                    default:
                        ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
                        C28236t.m44820b(c41999hc.cBN.appId, c41999hc.cBN.opType, c41999hc.cBN.cBO, c41999hc.cBN.openId, c41999hc.cBN.cvq);
                        break;
                }
            }
            AppMethodBeat.m2505o(111143);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c$8 */
    class C209438 extends C4884c<C37748jt> {
        C209438() {
            AppMethodBeat.m2504i(111146);
            this.xxI = C37748jt.class.getName().hashCode();
            AppMethodBeat.m2505o(111146);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            return false;
        }
    }

    public C20931c() {
        AppMethodBeat.m2504i(111166);
        AppMethodBeat.m2505o(111166);
    }
}
