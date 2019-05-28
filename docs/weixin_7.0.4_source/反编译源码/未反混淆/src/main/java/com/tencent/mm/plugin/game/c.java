package com.tencent.mm.plugin.game;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    com.tencent.mm.sdk.b.c egQ = new com.tencent.mm.sdk.b.c<ss>() {
        {
            AppMethodBeat.i(111138);
            this.xxI = ss.class.getName().hashCode();
            AppMethodBeat.o(111138);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111139);
            ss ssVar = (ss) bVar;
            if (ssVar.cOR.cOS.equals(gy.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    c.this.mTa.axy();
                } else {
                    c.this.mTa.unregister();
                }
            }
            AppMethodBeat.o(111139);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c lOc = new com.tencent.mm.sdk.b.c<jt>() {
        {
            AppMethodBeat.i(111146);
            this.xxI = jt.class.getName().hashCode();
            AppMethodBeat.o(111146);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            return false;
        }
    };
    a luy = new a() {
        /* JADX WARNING: Removed duplicated region for block: B:163:0x06cb  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x0738  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x055a  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0537  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(e.a aVar) {
            n nVar;
            long j;
            Object obj;
            AppMethodBeat.i(111135);
            ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
            String a = aa.a(aVar.eAB.vED);
            ab.i("MicroMsg.GameMessageService", "Received a message: %d", Long.valueOf(r0.ptF));
            ab.i("MicroMsg.GameMessageService", "Message content: %s".concat(String.valueOf(a)));
            if (bo.isNullOrNil(a)) {
                ab.e("MicroMsg.GameMessageParser", "msg content is null");
                nVar = null;
            } else {
                Map z = br.z(a, "sysmsg");
                if (z == null || z.size() == 0) {
                    ab.e("MicroMsg.GameMessageParser", "Parse failed");
                    nVar = null;
                } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
                    n nVar2 = new n();
                    nVar2.field_showInMsgList = true;
                    nVar2.field_msgId = System.currentTimeMillis();
                    nVar2.field_rawXML = a;
                    nVar2.field_msgType = bo.getInt((String) z.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    if (nVar2.field_msgType == 100 || nVar2.field_msgType == 30) {
                        u.bEx();
                        nVar2.field_gameMsgId = bo.bc((String) z.get(".sysmsg.gamecenter.msg_id"), "");
                        nVar2.field_appId = (String) z.get(".sysmsg.gamecenter.appid");
                        nVar2.field_createTime = bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            nVar2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            nVar2.field_expireTime = bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000) + j;
                        }
                        nVar2.mWf = bo.getLong((String) z.get(".sysmsg.gamecenter.time_info.random_time"), 0);
                        nVar2.field_isHidden = bo.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        nVar2.field_mergerId = bo.bc((String) z.get(".sysmsg.gamecenter.merge_id"), "");
                        nVar2.field_weight = bo.bc((String) z.get(".sysmsg.gamecenter.weight"), "");
                        nVar2.field_receiveTime = System.currentTimeMillis() / 1000;
                        u.q(z, nVar2);
                        nVar2.mWE = bo.getLong((String) z.get(".sysmsg.gamecenter.filter_flag"), 0);
                        nVar2.mWF = bo.getInt((String) z.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        nVar2.mWq = bo.getInt((String) z.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        nVar2.mWr.mXj = bo.bc((String) z.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (bo.isNullOrNil((String) z.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && bo.isNullOrNil((String) z.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            nVar2.mWs = false;
                        } else {
                            nVar2.mWs = true;
                        }
                        u.s(z, nVar2);
                        nVar2.mWW.mXy = bo.bc((String) z.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        nVar2.mWW.kgX = bo.getInt((String) z.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        if (!bo.isNullOrNil(nVar2.mWW.mXy)) {
                            nVar2.field_isHidden = true;
                        }
                        nVar2.mWW.mXz = bo.getLong((String) z.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                        u.u(z, nVar2);
                    } else {
                        nVar2.field_gameMsgId = bo.bc((String) z.get(".sysmsg.gamecenter.msg_id"), "");
                        nVar2.field_msgType = bo.getInt((String) z.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (nVar2.field_msgType == 0) {
                            nVar2.field_msgType = bo.getInt((String) z.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        nVar2.field_appId = (String) z.get(".sysmsg.gamecenter.appinfo.appid");
                        nVar2.field_showInMsgList = !bo.isNullOrNil(p.I(z));
                        nVar2.field_createTime = bo.getLong((String) z.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = bo.getLong((String) z.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            nVar2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            nVar2.field_expireTime = bo.getLong((String) z.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000) + j;
                        }
                        nVar2.field_isHidden = bo.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        nVar2.field_mergerId = bo.bc((String) z.get(".sysmsg.gamecenter.merge_id"), "");
                        if (nVar2.field_msgType == 10) {
                            nVar2.field_weight = "6";
                        } else {
                            nVar2.field_weight = "2";
                        }
                        nVar2.field_receiveTime = System.currentTimeMillis() / 1000;
                        nVar2.mWE = bo.getLong((String) z.get(".sysmsg.game_control_info.filter_flag"), 0);
                        nVar2.mWD = p.J(z);
                        nVar2.mWF = bo.getInt((String) z.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        nVar2.mWs = bo.getInt((String) z.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        nVar2.mXc = bo.bc((String) z.get(".sysmsg.gamecenter.noticeid"), "");
                        nVar2.mWr.mXl = bo.getInt((String) z.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        nVar2.mWq = nVar2.mWr.mXl > 0;
                        if ((nVar2.mWD & 4) == 0) {
                            nVar2.mWq = false;
                        }
                        p.k(z, nVar2);
                    }
                    if (nVar2.mWF == 1) {
                        nVar2.field_showInMsgList = false;
                    }
                    nVar2.mWY.mXA = bo.getInt((String) z.get(".sysmsg.support_version.$android"), 0);
                    ab.i("MicroMsg.GameMessageParser", "xml support version: %d, current client version: %d", Integer.valueOf(nVar2.mWY.mXA), Integer.valueOf(d.vxo));
                    if (nVar2.mWY.mXA == 0 || nVar2.mWY.mXA <= d.vxo) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        ab.i("MicroMsg.GameMessageParser", "xml is invalid in current client version");
                        com.tencent.mm.plugin.game.e.b.a(ah.getContext(), 0, 0, 0, 401, 0, nVar2.field_appId, 0, 0, nVar2.field_gameMsgId, nVar2.mXc, "");
                        nVar = null;
                    } else {
                        nVar2.mWZ.mXy = bo.bc((String) z.get(".sysmsg.wepkg.$pkg_id"), "");
                        nVar2.mWZ.mXB = bo.getInt((String) z.get(".sysmsg.wepkg.download_trigger_type"), 0);
                        new Thread(new com.tencent.mm.plugin.game.model.p.AnonymousClass1(nVar2.mWZ.mXy, nVar2.mWZ.mXB)).start();
                        nVar = nVar2;
                    }
                } else {
                    ab.e("MicroMsg.GameMessageParser", "Type not matched");
                    nVar = null;
                }
            }
            if (nVar != null) {
                int i;
                String str;
                int i2;
                ab.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", Integer.valueOf(nVar.field_msgType), nVar.field_appId, Long.valueOf(nVar.field_msgId));
                if (nVar == null) {
                    ab.e("MicroMsg.GameMessageService", "msg is null");
                    i = -1;
                } else {
                    a = nVar.field_gameMsgId;
                    if (!bo.isNullOrNil(a)) {
                        int i3 = 0;
                        Cursor rawQuery = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + a + "\"", new String[0]);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                i3 = rawQuery.getInt(0);
                            }
                            rawQuery.close();
                            if (i3 > 0) {
                                obj = 1;
                                if (obj == null) {
                                    ab.e("MicroMsg.GameMessageService", "duplicated msg:%s", nVar.field_gameMsgId);
                                    h.pYm.a(858, 4, 1, false);
                                    i = 2;
                                } else {
                                    if (nVar.field_expireTime <= System.currentTimeMillis() / 1000) {
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                    String str2;
                                    vv vvVar;
                                    if (obj == null) {
                                        ab.e("MicroMsg.GameMessageService", "msg is expired Time, %s", nVar.field_gameMsgId);
                                        h.pYm.a(858, 5, 1, false);
                                        str2 = nVar.mWW.mXy;
                                        if (!bo.isNullOrNil(str2)) {
                                            vvVar = new vv();
                                            vvVar.cSX.cuy = 6;
                                            vvVar.cSX.cSY = str2;
                                            com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                                        }
                                        i = 1;
                                    } else {
                                        long j2 = nVar.mWE;
                                        str = nVar.field_appId;
                                        if (j2 == 1) {
                                            if (bo.isNullOrNil(str) || !com.tencent.mm.pluginsdk.model.app.g.u(ah.getContext(), str)) {
                                                h.pYm.a(858, 6, 1, false);
                                                i3 = 3;
                                            }
                                            i3 = 0;
                                        } else {
                                            if (j2 == 2 && (bo.isNullOrNil(str) || com.tencent.mm.pluginsdk.model.app.g.u(ah.getContext(), str))) {
                                                h.pYm.a(858, 7, 1, false);
                                                i3 = 4;
                                            }
                                            i3 = 0;
                                        }
                                        if (i3 != 0) {
                                            ab.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", nVar.field_gameMsgId, Integer.valueOf(i3));
                                            i = i3;
                                        } else {
                                            if (nVar.field_msgType == 30) {
                                                h.pYm.a(858, 8, 1, false);
                                            } else {
                                                n bEs;
                                                n bEm = q.bEm();
                                                if (bEm == null) {
                                                    bEm = q.bEo();
                                                }
                                                if (bEm == null) {
                                                    bEm = q.bEq();
                                                }
                                                if (bEm == null) {
                                                    bEs = q.bEs();
                                                } else {
                                                    bEs = bEm;
                                                }
                                                if (bEs != null) {
                                                    bEs.bEl();
                                                    JSONObject jSONObject = new JSONObject();
                                                    try {
                                                        jSONObject.put("oldNoticeId", bEs.mXc);
                                                        jSONObject.put("oldMsgId", bEs.field_gameMsgId);
                                                        if (nVar.field_weight.compareTo(bEs.field_weight) >= 0) {
                                                            jSONObject.put("coverType", 1);
                                                        } else {
                                                            jSONObject.put("coverType", 2);
                                                        }
                                                    } catch (Exception e) {
                                                        ab.e("MicroMsg.GameMessageService", "reportMsgCover: " + e.getMessage());
                                                    }
                                                    i2 = nVar.field_msgType;
                                                    if (nVar.field_msgType == 100) {
                                                        i2 = nVar.mXb;
                                                    }
                                                    com.tencent.mm.plugin.game.e.b.a(ah.getContext(), 0, 0, 0, 31, 0, nVar.field_appId, 0, i2, nVar.field_gameMsgId, nVar.mXc, com.tencent.mm.plugin.game.e.a.kY(jSONObject.toString()));
                                                    if (nVar.field_weight.compareTo(bEs.field_weight) >= 0) {
                                                        h.pYm.a(858, 10, 1, false);
                                                        str2 = bEs.mWW.mXy;
                                                        if (!bo.isNullOrNil(str2)) {
                                                            vvVar = new vv();
                                                            vvVar.cSX.cuy = 6;
                                                            vvVar.cSX.cSY = str2;
                                                            com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                                                        }
                                                        obj = 1;
                                                    } else {
                                                        h.pYm.a(858, 11, 1, false);
                                                        obj = null;
                                                    }
                                                    if (obj == null) {
                                                        obj = null;
                                                        if (obj != null) {
                                                            if (nVar.mWq) {
                                                                g.RP().Ry().set(ac.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(nVar.field_msgId));
                                                            } else {
                                                                g.RP().Ry().set(ac.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                                                            }
                                                            if (bo.isNullOrNil(nVar.mWG.url)) {
                                                                q.bEp();
                                                            } else {
                                                                g.RP().Ry().set(ac.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(nVar.field_msgId));
                                                            }
                                                            if (nVar.mWs) {
                                                                g.RP().Ry().set(ac.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(nVar.field_msgId));
                                                            } else {
                                                                q.bEr();
                                                            }
                                                            if (bo.isNullOrNil(nVar.mWX.mXi)) {
                                                                q.bEt();
                                                            } else {
                                                                g.RP().Ry().set(ac.a.GAME_INDEX_BANNER_MSGID_LONG_SYNC, Long.valueOf(nVar.field_msgId));
                                                            }
                                                        }
                                                        if (nVar.field_msgType == 4) {
                                                            g.RP().Ry().set(ac.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(nVar.field_msgId));
                                                        }
                                                        if (!(nVar == null || bo.isNullOrNil(nVar.mWr.mXj))) {
                                                            com.tencent.mm.plugin.game.f.c.Ot(nVar.mWr.mXj);
                                                        }
                                                    }
                                                }
                                                obj = 1;
                                                if (obj != null) {
                                                }
                                                if (nVar.field_msgType == 4) {
                                                }
                                                com.tencent.mm.plugin.game.f.c.Ot(nVar.mWr.mXj);
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
                    q.c(nVar);
                    switch (nVar.field_msgType) {
                        case 30:
                            com.tencent.mm.plugin.game.model.a.h bFa = com.tencent.mm.plugin.game.model.a.h.a.mZh;
                            if (nVar != null && !bo.isNullOrNil(nVar.field_appId)) {
                                str = nVar.field_appId;
                                j = nVar.field_expireTime;
                                long j3 = nVar.mWf;
                                com.tencent.mm.plugin.game.model.a.d dVar = new com.tencent.mm.plugin.game.model.a.d();
                                dVar.field_appId = str;
                                if (!((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().b((com.tencent.mm.sdk.e.c) dVar, new String[0])) {
                                    dVar.field_expireTime = j;
                                    dVar.field_randomTime = j3;
                                    dVar.field_isFirst = true;
                                    dVar.field_isRunning = false;
                                    dVar.field_noWifi = true;
                                    dVar.field_noSdcard = true;
                                    dVar.field_noEnoughSpace = true;
                                    dVar.field_lowBattery = true;
                                    dVar.field_continueDelay = true;
                                    boolean b = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().b((com.tencent.mm.sdk.e.c) dVar);
                                    ab.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", dVar.field_appId, Long.valueOf(dVar.field_expireTime), Long.valueOf(dVar.field_randomTime), Boolean.valueOf(b));
                                    bFa.hO(false);
                                    break;
                                }
                                ab.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", str);
                                com.tencent.mm.game.report.api.b.eBF.j(str, 17);
                                break;
                            }
                            ab.i("MicroMsg.GameSilentDownloader", "msg is null");
                            com.tencent.mm.game.report.api.b.eBF.j("appid_is_empty", 16);
                            break;
                            break;
                        default:
                            ab.i("MicroMsg.GameMessageService", "Insert raw message: %b", Boolean.valueOf(((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().b((com.tencent.mm.sdk.e.c) nVar)));
                            break;
                    }
                    h.pYm.a(858, 1, 1, false);
                }
                i2 = nVar.field_msgType;
                if (nVar.field_msgType == 100) {
                    i2 = nVar.mXb;
                }
                com.tencent.mm.plugin.game.e.b.a(ah.getContext(), 0, 0, 0, 18, i, nVar.field_appId, 0, i2, nVar.field_gameMsgId, nVar.mXc, com.tencent.mm.plugin.game.e.b.eA("resource", String.valueOf(nVar.mWr.mXl)));
                h.pYm.a(858, 0, 1, false);
            }
            AppMethodBeat.o(111135);
        }
    };
    aw mSR = new aw();
    com.tencent.mm.sdk.b.c mSS = new com.tencent.mm.sdk.b.c<gw>() {
        {
            AppMethodBeat.i(111149);
            this.xxI = gw.class.getName().hashCode();
            AppMethodBeat.o(111149);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111150);
            gw gwVar = (gw) bVar;
            j.a(gwVar.cBC.url, gwVar.cBC.cvZ, gwVar.cBC.scene != 0 ? gwVar.cBC.scene : 1000, gwVar.cBC.appId, gwVar.cBC.extInfo);
            AppMethodBeat.o(111150);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mST = new com.tencent.mm.sdk.b.c<mz>() {
        {
            AppMethodBeat.i(111151);
            this.xxI = mz.class.getName().hashCode();
            AppMethodBeat.o(111151);
        }

        /* JADX WARNING: Missing block: B:47:0x01b0, code skipped:
            if ((((((new java.util.GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50) <= com.tencent.mm.sdk.platformtools.bo.gV(100, 0)) goto L_0x0086;
     */
        /* JADX WARNING: Missing block: B:62:0x01fe, code skipped:
            if ((((r3 + r5) * 10) + 50) <= com.tencent.mm.sdk.platformtools.bo.gV(100, 0)) goto L_0x0086;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(b bVar) {
            int i = 1;
            AppMethodBeat.i(111152);
            mz mzVar = (mz) bVar;
            if (bo.isNullOrNil(mzVar.cIX.content)) {
                n iP;
                ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                long longValue = ((Long) g.RP().Ry().get(ac.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
                if (longValue != 0) {
                    iP = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().iP(longValue);
                } else {
                    iP = null;
                }
                if (iP != null) {
                    int i2;
                    iP.bEl();
                    if (System.currentTimeMillis() / 1000 <= iP.field_receiveTime + iP.mWW.mXz) {
                        vv vvVar;
                        switch (iP.mWW.kgX) {
                            case 0:
                                i2 = 1;
                                break;
                            case 1:
                                vvVar = new vv();
                                vvVar.cSX.cuy = 2;
                                vvVar.cSX.cSY = iP.mWW.mXy;
                                com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                                if (!vvVar.cSX.cSZ) {
                                    i2 = 0;
                                    break;
                                }
                                i2 = 1;
                                break;
                            case 2:
                                vvVar = new vv();
                                vvVar.cSX.cuy = 4;
                                vvVar.cSX.cSY = iP.mWW.mXy;
                                com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                                if (vvVar.cSX.cTa <= 0) {
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
                        if (at.isWifi(ah.getContext())) {
                            ab.i("MicroMsg.GameWifiStrategy", "WifiStrategy:isInWifi");
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
                            ab.i("MicroMsg.GameWifiStrategy", "WifiStrategy:inWhichTimeRange = ".concat(String.valueOf(i3)));
                            if (i3 != 0) {
                                if (i3 != 3) {
                                    if (i3 == 1) {
                                        ab.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", Integer.valueOf(((((new GregorianCalendar().get(11) - 12) << 1) + 1) * 10) + 50), Integer.valueOf(bo.gV(100, 0)));
                                    } else if (i3 == 2) {
                                        gregorianCalendar = new GregorianCalendar();
                                        i4 = gregorianCalendar.get(11) - 18;
                                        if (gregorianCalendar.get(12) > 30) {
                                            i3 = 1;
                                        } else {
                                            i3 = 0;
                                        }
                                        ab.i("MicroMsg.GameWifiStrategy", "WifiStrategy:randomHide p = %s, randomNum = %s", Integer.valueOf(((i3 + i4) * 10) + 50), Integer.valueOf(bo.gV(100, 0)));
                                    }
                                }
                            }
                            if (i == 0 && i2 != 0) {
                                ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().bEu();
                            }
                        }
                        i = 0;
                        ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().bEu();
                    } else if (i2 != 0) {
                        ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().bEu();
                    }
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    n bEm = q.bEm();
                    if (bEm != null) {
                        bEm.bEl();
                        com.tencent.mm.plugin.game.e.a.Oh(bEm.mXc);
                        mzVar.cIX.showType = bEm.mWr.mXl;
                        mzVar.cIX.appId = bEm.field_appId;
                        mzVar.cIX.appName = bEm.mWr.mText;
                        mzVar.cIX.cIY = bEm.mWr.mXj;
                        mzVar.cIX.cIZ = bEm.mWr.mXm;
                        mzVar.cIX.cJa = bEm.mWr.mXn;
                        mzVar.cIX.msgType = bEm.field_msgType;
                        if (bEm.field_msgType == 100) {
                            mzVar.cIX.msgType = bEm.mXb;
                        }
                        mzVar.cIX.cJb = bEm.field_gameMsgId;
                        mzVar.cIX.ctu = bEm.mXc;
                    }
                }
            } else {
                String str = mzVar.cIX.content;
                if (str != null && str.startsWith("//gamemsg:")) {
                    new cm().vED = aa.vy(str.substring(10));
                    str = str.substring(10);
                    if (!bo.isNullOrNil(str)) {
                        if (str.equals("jumpnative")) {
                            Intent intent = new Intent();
                            intent.putExtra("from_find_more_friend", true);
                            com.tencent.mm.bp.d.b(ah.getContext(), "game", ".ui.tab.GameRouteUI", intent);
                        } else if (str.equals("jumpLibrary")) {
                            com.tencent.mm.bp.d.b(ah.getContext(), "game", ".ui.GameLibraryUI", new Intent());
                        } else if (str.contains("jumpDetail:")) {
                            str = str.substring(11, str.length());
                            Intent intent2 = new Intent();
                            intent2.putExtra("game_app_id", str);
                            com.tencent.mm.bp.d.b(ah.getContext(), "game", ".ui.GameDetailUI2", intent2);
                        }
                    }
                }
            }
            AppMethodBeat.o(111152);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mSU = new com.tencent.mm.sdk.b.c<gt>() {
        {
            AppMethodBeat.i(111153);
            this.xxI = gt.class.getName().hashCode();
            AppMethodBeat.o(111153);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111154);
            gt gtVar = (gt) bVar;
            switch (gtVar.cBv.actionCode) {
                case 1:
                    com.tencent.mm.plugin.game.model.e.a(gtVar.cBv.context, gtVar.cBv.appId, gtVar.cBv.messageAction, gtVar.cBv.messageExt, null);
                    com.tencent.mm.plugin.game.e.b.a(gtVar.cBv.context, gtVar.cBv.scene, gtVar.cBv.scene, 1, 3, gtVar.cBv.appId, 0, null);
                    break;
                case 2:
                    int i = gtVar.cBv.scene;
                    ab.i("MicroMsg.GameEventListener", "scene = %d, extinfo = %s", Integer.valueOf(i), gtVar.cBv.extMsg);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game_report_from_scene", i);
                    bundle.putCharSequence("game_app_id", gtVar.cBv.appId);
                    bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                    com.tencent.mm.plugin.game.e.b.a(gtVar.cBv.context, gtVar.cBv.scene, gtVar.cBv.scene, 1, com.tencent.mm.plugin.game.f.c.a(gtVar.cBv.context, gtVar.cBv.appId, null, bundle, gtVar.cBv.scene), gtVar.cBv.appId, 0, null);
                    break;
                case 3:
                    m.update();
                    break;
                case 5:
                    int i2 = gtVar.cBv.scene;
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    l.a(q.bEo(), i2, 2);
                    break;
            }
            AppMethodBeat.o(111154);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mSV = new com.tencent.mm.sdk.b.c<gx>() {
        {
            AppMethodBeat.i(111155);
            this.xxI = gx.class.getName().hashCode();
            AppMethodBeat.o(111155);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111156);
            gx gxVar = (gx) bVar;
            n nVar;
            switch (gxVar.cBD.Cn) {
                case 1:
                    String str = gxVar.cBD.cBy;
                    LinkedList linkedList = new LinkedList();
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int i = bo.getInt(jSONObject.optString("type"), 0);
                            int i2 = bo.getInt(jSONObject.optString("limit"), 0);
                            long j = bo.getLong(jSONObject.optString("lastLocalId"), -1);
                            int i3 = bo.getInt(jSONObject.optString("isUnread"), -1);
                            if (i2 > 0 && i2 <= Downloads.MIN_WAIT_FOR_NETWORK && j >= 0 && i3 >= 0) {
                                LinkedList b = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().b(i, j, i3, i2);
                                if (!bo.ek(b)) {
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = b.iterator();
                                    while (it.hasNext()) {
                                        nVar = (n) it.next();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("localId", nVar.field_msgId);
                                        jSONObject2.put(FirebaseAnalytics.b.CONTENT, nVar.field_rawXML);
                                        jSONArray.put(jSONObject2);
                                    }
                                    gxVar.cBE.cBF = jSONArray.toString();
                                    break;
                                }
                            }
                        } catch (JSONException e) {
                            ab.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e.getMessage());
                            break;
                        }
                    }
                    break;
                case 2:
                    s.a(gxVar);
                    break;
                case 3:
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    nVar = q.bEq();
                    if (nVar != null) {
                        gxVar.cBE.cBF = nVar.field_rawXML;
                        break;
                    }
                    break;
                case 4:
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    q.bEr();
                    break;
                case 5:
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    nVar = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().iP(((Long) g.RP().Ry().get(ac.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (nVar == null || nVar.field_isHidden) {
                        nVar = null;
                    }
                    if (nVar != null) {
                        gxVar.cBE.cBF = nVar.field_rawXML;
                        break;
                    }
                    break;
                case 6:
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    nVar = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().iP(((Long) g.RP().Ry().get(ac.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (!(nVar == null || nVar.field_isHidden)) {
                        g.RP().Ry().set(ac.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                        break;
                    }
                case 9:
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    nVar = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().iP(((Long) g.RP().Ry().get(ac.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (nVar != null) {
                        gxVar.cBE.cBF = nVar.field_rawXML;
                        break;
                    }
                    break;
                case 10:
                    ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                    if (((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY().iP(((Long) g.RP().Ry().get(ac.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue()) != null) {
                        g.RP().Ry().set(ac.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(111156);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mSW = new com.tencent.mm.sdk.b.c<lw>() {
        {
            AppMethodBeat.i(111157);
            this.xxI = lw.class.getName().hashCode();
            AppMethodBeat.o(111157);
        }

        private static boolean a(lw lwVar) {
            int i;
            AppMethodBeat.i(111158);
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(lwVar.cHK.extraInfo);
                str = jSONObject.optString("appId");
                i = bo.getInt(jSONObject.optString("ssid"), 0);
            } catch (JSONException e) {
                ab.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e.getMessage());
                i = 0;
            } catch (Exception e2) {
                ab.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e2.getMessage());
                i = 0;
            }
            Intent intent = new Intent();
            switch (lwVar.cHK.cHL) {
                case 0:
                    intent.setClass(lwVar.cHK.context, GameCenterUI.class);
                    if (lwVar.cHK.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lwVar.cHK.context.startActivity(intent);
                    com.tencent.mm.plugin.game.e.b.a(lwVar.cHK.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(lwVar.cHK.context, GameLibraryUI.class);
                    if (lwVar.cHK.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lwVar.cHK.context.startActivity(intent);
                    com.tencent.mm.plugin.game.e.b.a(lwVar.cHK.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (!bo.isNullOrNil(str)) {
                        intent.setClass(lwVar.cHK.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", str);
                        if (lwVar.cHK.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lwVar.cHK.context.startActivity(intent);
                        com.tencent.mm.plugin.game.e.b.a(lwVar.cHK.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(lwVar.cHK.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    lwVar.cHK.context.startActivity(intent);
                    com.tencent.mm.plugin.game.e.b.a(lwVar.cHK.context, 5, 5, 1, 6, i, null);
                    break;
            }
            AppMethodBeat.o(111158);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mSX = new com.tencent.mm.sdk.b.c<oj>() {
        {
            AppMethodBeat.i(111160);
            this.xxI = oj.class.getName().hashCode();
            AppMethodBeat.o(111160);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111161);
            oj ojVar = (oj) bVar;
            com.tencent.mm.plugin.game.e.b.a(ah.getContext(), ojVar.cKF.scene, ojVar.cKF.cKG, 1, ojVar.cKF.action, 0, ojVar.cKF.appId, 0, ojVar.cKF.msgType, ojVar.cKF.cJb, ojVar.cKF.ctu, ojVar.cKF.cKH);
            AppMethodBeat.o(111161);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mSY = new com.tencent.mm.sdk.b.c<ok>() {
        {
            AppMethodBeat.i(111162);
            this.xxI = ok.class.getName().hashCode();
            AppMethodBeat.o(111162);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111163);
            ok okVar = (ok) bVar;
            com.tencent.mm.game.report.api.c.eBG.a(okVar.cKI.context, okVar.cKI.csB, okVar.cKI.packageName, okVar.cKI.cEV, okVar.cKI.msgType, okVar.cKI.scene, okVar.cKI.cKJ, okVar.cKI.mediaTagName, okVar.cKI.cKK, okVar.cKI.cKL, okVar.cKI.cst);
            AppMethodBeat.o(111163);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mSZ = new com.tencent.mm.sdk.b.c<gu>() {
        {
            AppMethodBeat.i(111164);
            this.xxI = gu.class.getName().hashCode();
            AppMethodBeat.o(111164);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111165);
            f.a((gu) bVar);
            AppMethodBeat.o(111165);
            return false;
        }
    };
    com.tencent.mm.pluginsdk.c.d mTa = new com.tencent.mm.pluginsdk.c.d() {
        public final b NJ(String str) {
            AppMethodBeat.i(111136);
            gy gyVar = new gy();
            gyVar.cBG.ctq = str;
            AppMethodBeat.o(111136);
            return gyVar;
        }

        public final k bCU() {
            AppMethodBeat.i(111137);
            r bCY = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCY();
            AppMethodBeat.o(111137);
            return bCY;
        }
    };
    com.tencent.mm.sdk.b.c mTb = new com.tencent.mm.sdk.b.c<gv>() {
        {
            AppMethodBeat.i(111140);
            this.xxI = gv.class.getName().hashCode();
            AppMethodBeat.o(111140);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            gv gvVar = (gv) bVar;
            i.cBA = gvVar.cBz.cBA;
            i.countryCode = gvVar.cBz.countryCode;
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mTc = new com.tencent.mm.sdk.b.c<hr>() {
        {
            AppMethodBeat.i(111141);
            this.xxI = hr.class.getName().hashCode();
            AppMethodBeat.o(111141);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((hr) bVar).cCC.cBA = i.cBA;
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mTd = new com.tencent.mm.sdk.b.c<hc>() {
        {
            AppMethodBeat.i(111142);
            this.xxI = hc.class.getName().hashCode();
            AppMethodBeat.o(111142);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111143);
            hc hcVar = (hc) bVar;
            ab.i("MicroMsg.GameEventListener", "opType = %d, opStatus = %d, appId = %s", Integer.valueOf(hcVar.cBN.opType), Integer.valueOf(hcVar.cBN.cBO), hcVar.cBN.appId);
            if (hcVar.cBN.opType != 0) {
                switch (hcVar.cBN.opType) {
                    case 2:
                        j.bEg();
                        j.a(hcVar.cBN.appId, hcVar.cBN.cBO, false, hcVar.cBN.cvq);
                        break;
                    case 6:
                        j.bEg();
                        j.ex(hcVar.cBN.appId, hcVar.cBN.cvq);
                        break;
                    default:
                        ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCW();
                        t.b(hcVar.cBN.appId, hcVar.cBN.opType, hcVar.cBN.cBO, hcVar.cBN.openId, hcVar.cBN.cvq);
                        break;
                }
            }
            AppMethodBeat.o(111143);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mTe = new com.tencent.mm.sdk.b.c<mp>() {
        {
            AppMethodBeat.i(111144);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(111144);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111145);
            com.tencent.mm.plugin.game.commlib.b.bDn().hI(false);
            AppMethodBeat.o(111145);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mTf = new com.tencent.mm.sdk.b.c<gz>() {
        {
            AppMethodBeat.i(111147);
            this.xxI = gz.class.getName().hashCode();
            AppMethodBeat.o(111147);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(111148);
            gz gzVar = (gz) bVar;
            String str = gzVar.cBH.url;
            gzVar.cBI.cBJ = a.mSO;
            switch (gzVar.cBH.Cn) {
                case 1:
                    gzVar.cBI.cBK = com.tencent.mm.plugin.game.f.a.a.nnu.Op(str);
                    break;
                case 2:
                    com.tencent.mm.plugin.game.f.a.a.nnu.Oq(str);
                    break;
            }
            AppMethodBeat.o(111148);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(111166);
        AppMethodBeat.o(111166);
    }
}
