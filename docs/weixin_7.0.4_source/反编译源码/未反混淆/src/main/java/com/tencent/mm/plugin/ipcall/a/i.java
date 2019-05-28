package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.o;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.g.a.to;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.util.HashMap;
import java.util.Map;

public final class i implements at {
    private static i nvT = null;
    private static HashMap<Integer, d> nwm;
    private g nvU = new g();
    private a nvV = new a();
    private b nvW = new b();
    private com.tencent.mm.plugin.ipcall.a.b.b nvX = new com.tencent.mm.plugin.ipcall.a.b.b();
    private f nvY = new f();
    private c nvZ = new c();
    private com.tencent.mm.plugin.ipcall.a.g.d nwa;
    private l nwb;
    private j nwc;
    private h nwd;
    private com.tencent.mm.plugin.voip.video.i nwe;
    private com.tencent.mm.plugin.voip.video.d nwf;
    private Context nwg;
    private long nwh;
    private com.tencent.mm.sdk.b.c nwi = new com.tencent.mm.sdk.b.c<bc>() {
        {
            AppMethodBeat.i(21763);
            this.xxI = bc.class.getName().hashCode();
            AppMethodBeat.o(21763);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(21764);
            ab.d("MicroMsg.SubCoreIPCall", "change language");
            com.tencent.mm.plugin.ipcall.b.a.bIO();
            AppMethodBeat.o(21764);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nwj = new com.tencent.mm.sdk.b.c<ba>() {
        {
            AppMethodBeat.i(21767);
            this.xxI = ba.class.getName().hashCode();
            AppMethodBeat.o(21767);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(21768);
            ba baVar = (ba) bVar;
            if (baVar instanceof ba) {
                baVar.cuj.aFV = i.bHu().bHk();
            }
            AppMethodBeat.o(21768);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nwk = new com.tencent.mm.sdk.b.c<sg>() {
        {
            AppMethodBeat.i(21769);
            this.xxI = sg.class.getName().hashCode();
            AppMethodBeat.o(21769);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(21770);
            sg sgVar = (sg) bVar;
            if (sgVar instanceof sg) {
                Intent intent = new Intent(ah.getContext(), IPCallDialUI.class);
                intent.setFlags(268435456);
                intent.putExtra("IPCallTalkUI_contactId", sgVar.cOy.cOz);
                intent.putExtra("IPCallTalkUI_countryCode", sgVar.cOy.cOA);
                intent.putExtra("IPCallTalkUI_nickname", sgVar.cOy.bCu);
                intent.putExtra("IPCallTalkUI_phoneNumber", sgVar.cOy.cMQ);
                ah.getContext().startActivity(intent);
            }
            AppMethodBeat.o(21770);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nwl = new com.tencent.mm.sdk.b.c<iq>() {
        {
            AppMethodBeat.i(21771);
            this.xxI = iq.class.getName().hashCode();
            AppMethodBeat.o(21771);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(21772);
            iq iqVar = (iq) bVar;
            if (iqVar instanceof iq) {
                if (iqVar.cDO.cDR && i.this.nwh == iqVar.cDO.cDQ && i.this.nwg != null) {
                    i.this.nwg = null;
                    i.this.nwh = 0;
                }
                if (!iqVar.cDO.cDR) {
                    if (iqVar.cDO.cDQ == 0) {
                        i.this.nwg = null;
                        i.this.nwh = 0;
                    } else {
                        i.this.nwg = iqVar.cDO.cDP;
                        i.this.nwh = iqVar.cDO.cDQ;
                    }
                }
            }
            AppMethodBeat.o(21772);
            return false;
        }
    };
    private bz.a nwn = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(21773);
            ab.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
            String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
                AppMethodBeat.o(21773);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null) {
                ab.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
                AppMethodBeat.o(21773);
                return;
            }
            int i;
            int i2;
            Object substring;
            if (z.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
                i = bo.getInt((String) z.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", Integer.valueOf(i));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i));
                i2 = i;
            } else {
                i2 = -1;
            }
            if (z.containsKey(".sysmsg.WeChatOut.AcctRD")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.AcctRD"), 0)));
                if (bo.getInt((String) z.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13254, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                }
            }
            if (z.containsKey(".sysmsg.WeChatOut.TabRD")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.TabRD"), 0)));
                if (bo.getInt((String) z.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.TRUE);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13254, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE);
                }
            }
            if (z.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.RechargeRD"), 0)));
                if (bo.getInt((String) z.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13254, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.FALSE);
                }
            }
            if (z.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", (String) z.get(".sysmsg.WeChatOut.RechargeWording"));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_RECHARGE_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", (String) z.get(".sysmsg.WeChatOut.PackagePurchaseWording"));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountWording")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", (String) z.get(".sysmsg.WeChatOut.AccountWording"));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0)));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(i));
            }
            if (z.containsKey(".sysmsg.WeChatOut.TabWording")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", (String) z.get(".sysmsg.WeChatOut.TabWording"));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", (String) z.get(".sysmsg.WeChatOut.AccountActivityWording"));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, substring);
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0)));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(i));
            }
            if (z.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0)));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(i));
            }
            if (z.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WeChatOut.TabRedDotType"), 0)));
                com.tencent.mm.plugin.report.service.h.pYm.e(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_TYPE_INT, Integer.valueOf(i));
            }
            i = a.indexOf("<ActivityInfo>");
            i2 = a.indexOf("</ActivityInfo>");
            if (i > 0 && i2 > 0 && i2 > i) {
                substring = a.substring(i, i2 + 15);
                ab.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", substring);
                com.tencent.mm.plugin.ipcall.a.g.a OO = com.tencent.mm.plugin.ipcall.a.g.a.OO(substring);
                if (OO != null && bo.isNullOrNil(OO.Title) && bo.isNullOrNil(OO.Desc)) {
                    ab.i("MicroMsg.SubCoreIPCall", "clear activity");
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.FALSE);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ACTIVITY_STRING, (Object) "");
                } else if (OO != null) {
                    if (!bo.isNullOrNil(OO.ImgUrl)) {
                        o.ahk().a(OO.ImgUrl, null);
                    }
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.TRUE);
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_ACTIVITY_STRING, substring);
                }
            }
            com.tencent.mm.sdk.b.a.xxA.m(new ir());
            com.tencent.mm.sdk.b.a.xxA.m(new to());
            AppMethodBeat.o(21773);
        }
    };
    private bz.a nwo = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(21765);
            ab.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            cm cmVar = aVar.eAB;
            String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                AppMethodBeat.o(21765);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null) {
                ab.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                AppMethodBeat.o(21765);
                return;
            }
            int i;
            h bHz = i.bHz();
            long j = (long) cmVar.ptD;
            if (z != null) {
                g gVar = new g();
                gVar.field_svrId = j;
                gVar.field_title = (String) z.get(".sysmsg.WeChatOutMsg.Title");
                if (gVar.field_title == null) {
                    gVar.field_title = "";
                }
                gVar.field_content = (String) z.get(".sysmsg.WeChatOutMsg.Content");
                if (gVar.field_content == null) {
                    gVar.field_content = "";
                }
                int i2 = bo.getInt((String) z.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                gVar.field_msgType = i2;
                gVar.field_pushTime = bo.getLong((String) z.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                gVar.field_descUrl = (String) z.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (gVar.field_descUrl == null) {
                    gVar.field_descUrl = "";
                }
                ab.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", gVar.field_svrId, gVar.field_title, gVar.field_content, gVar.field_msgType, gVar.field_pushTime, gVar.field_descUrl);
                bHz.b((com.tencent.mm.sdk.e.c) gVar);
                i = i2;
            } else {
                i = -1;
            }
            if (i != -1) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i));
            }
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.TRUE);
            com.tencent.mm.plugin.report.service.h.pYm.e(13254, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1));
            AppMethodBeat.o(21765);
        }
    };
    private bz.a nwp = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(21766);
            ab.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
            String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
                AppMethodBeat.o(21766);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null) {
                ab.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
                AppMethodBeat.o(21766);
                return;
            }
            if (z.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
                ab.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.WCONotify.NotifyGetBalance"), 0)));
                if (bo.getInt((String) z.get(".sysmsg.WCONotify.NotifyGetBalance"), 0) > 0) {
                    aw.Rg().a(new com.tencent.mm.plugin.ipcall.a.d.g(2), 0);
                }
            }
            AppMethodBeat.o(21766);
        }
    };

    static {
        AppMethodBeat.i(21790);
        HashMap hashMap = new HashMap();
        nwm = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.ipcall.a.g.d.fnj;
            }
        });
        nwm.put(Integer.valueOf("IPCallRecord".hashCode()), new d() {
            public final String[] Af() {
                return l.fnj;
            }
        });
        nwm.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new d() {
            public final String[] Af() {
                return j.fnj;
            }
        });
        nwm.put(Integer.valueOf("IPCallMsg".hashCode()), new d() {
            public final String[] Af() {
                return h.fnj;
            }
        });
        AppMethodBeat.o(21790);
    }

    public i() {
        AppMethodBeat.i(21774);
        AppMethodBeat.o(21774);
    }

    public static i bHp() {
        AppMethodBeat.i(21775);
        if (nvT == null) {
            nvT = new i();
            aw.ZE().a("plugin.ipcall", nvT);
        }
        i iVar = nvT;
        AppMethodBeat.o(21775);
        return iVar;
    }

    public static g bHq() {
        AppMethodBeat.i(21776);
        g gVar = bHp().nvU;
        AppMethodBeat.o(21776);
        return gVar;
    }

    public static a bHr() {
        AppMethodBeat.i(21777);
        a aVar = bHp().nvV;
        AppMethodBeat.o(21777);
        return aVar;
    }

    public static b bHs() {
        AppMethodBeat.i(21778);
        b bVar = bHp().nvW;
        AppMethodBeat.o(21778);
        return bVar;
    }

    public static com.tencent.mm.plugin.ipcall.a.b.b bHt() {
        AppMethodBeat.i(21779);
        com.tencent.mm.plugin.ipcall.a.b.b bVar = bHp().nvX;
        AppMethodBeat.o(21779);
        return bVar;
    }

    public static f bHu() {
        AppMethodBeat.i(21780);
        f fVar = bHp().nvY;
        AppMethodBeat.o(21780);
        return fVar;
    }

    public static c bHv() {
        AppMethodBeat.i(21781);
        c cVar = bHp().nvZ;
        AppMethodBeat.o(21781);
        return cVar;
    }

    public static com.tencent.mm.plugin.ipcall.a.g.d bHw() {
        AppMethodBeat.i(21782);
        com.tencent.mm.kernel.g.RN().QU();
        if (bHp().nwa == null) {
            i bHp = bHp();
            aw.ZK();
            bHp.nwa = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.model.c.Ru());
        }
        com.tencent.mm.plugin.ipcall.a.g.d dVar = bHp().nwa;
        AppMethodBeat.o(21782);
        return dVar;
    }

    public static l bHx() {
        AppMethodBeat.i(21783);
        com.tencent.mm.kernel.g.RN().QU();
        if (bHp().nwb == null) {
            i bHp = bHp();
            aw.ZK();
            bHp.nwb = new l(com.tencent.mm.model.c.Ru());
        }
        l lVar = bHp().nwb;
        AppMethodBeat.o(21783);
        return lVar;
    }

    public static j bHy() {
        AppMethodBeat.i(21784);
        com.tencent.mm.kernel.g.RN().QU();
        if (bHp().nwc == null) {
            i bHp = bHp();
            aw.ZK();
            bHp.nwc = new j(com.tencent.mm.model.c.Ru());
        }
        j jVar = bHp().nwc;
        AppMethodBeat.o(21784);
        return jVar;
    }

    public static h bHz() {
        AppMethodBeat.i(21785);
        com.tencent.mm.kernel.g.RN().QU();
        if (bHp().nwd == null) {
            i bHp = bHp();
            aw.ZK();
            bHp.nwd = new h(com.tencent.mm.model.c.Ru());
        }
        h hVar = bHp().nwd;
        AppMethodBeat.o(21785);
        return hVar;
    }

    public static com.tencent.mm.plugin.voip.video.i bHA() {
        AppMethodBeat.i(21786);
        if (bHp().nwe == null) {
            bHp().nwe = new com.tencent.mm.plugin.voip.video.i(ah.getContext());
        }
        com.tencent.mm.plugin.voip.video.i iVar = bHp().nwe;
        AppMethodBeat.o(21786);
        return iVar;
    }

    public static com.tencent.mm.plugin.voip.video.d bHB() {
        AppMethodBeat.i(21787);
        if (bHp().nwf == null) {
            bHp().nwf = new com.tencent.mm.plugin.voip.video.d(ah.getContext());
        }
        com.tencent.mm.plugin.voip.video.d dVar = bHp().nwf;
        AppMethodBeat.o(21787);
        return dVar;
    }

    public final HashMap<Integer, d> Jx() {
        return nwm;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(21788);
        g gVar = this.nvU;
        gVar.nvF.init();
        gVar.nvG.init();
        gVar.nvH.init();
        gVar.nvI.init();
        gVar.nvJ.init();
        gVar.nvK.init();
        gVar.nvL.init();
        gVar.nvM.init();
        gVar.nvF.a((com.tencent.mm.plugin.ipcall.a.a.a.a) gVar);
        gVar.nvH.a((com.tencent.mm.plugin.ipcall.a.a.a.a) gVar);
        gVar.nvI.a((com.tencent.mm.plugin.ipcall.a.a.a.a) gVar);
        gVar.nvK.a((com.tencent.mm.plugin.ipcall.a.a.a.a) gVar);
        gVar.nvM.a((com.tencent.mm.plugin.ipcall.a.a.a.a) gVar);
        gVar.nvG.nws = gVar;
        gVar.nvJ.nws = gVar;
        aw.a(gVar.nvQ);
        b.init();
        com.tencent.mm.sdk.b.a.xxA.c(d.bHg().nvt);
        com.tencent.mm.sdk.b.a.xxA.c(e.bHj().gyU);
        aw.getSysCmdMsgExtension().a("WeChatOut", this.nwn, true);
        aw.getSysCmdMsgExtension().a("WeChatOutMsg", this.nwo, true);
        aw.getSysCmdMsgExtension().a("WCONotify", this.nwp, true);
        com.tencent.mm.sdk.b.a.xxA.c(this.nwi);
        com.tencent.mm.sdk.b.a.xxA.c(this.nwj);
        com.tencent.mm.sdk.b.a.xxA.c(this.nwk);
        com.tencent.mm.sdk.b.a.xxA.c(this.nwl);
        AppMethodBeat.o(21788);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(21789);
        if (this.nvY.bHk()) {
            this.nvZ.eo(0, 0);
        }
        g gVar = this.nvU;
        gVar.nvF.destroy();
        gVar.nvG.destroy();
        gVar.nvH.destroy();
        gVar.nvI.destroy();
        gVar.nvJ.destroy();
        gVar.nvL.destroy();
        aw.b(gVar.nvQ);
        b.release();
        f bHg = d.bHg();
        aw.Rg().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, bHg);
        aw.Rg().b(160, bHg);
        com.tencent.mm.sdk.b.a.xxA.d(bHg.nvt);
        com.tencent.mm.sdk.b.a.xxA.d(e.bHj().gyU);
        aw.getSysCmdMsgExtension().b("WeChatOut", this.nwn, true);
        aw.getSysCmdMsgExtension().b("WeChatOutMsg", this.nwo, true);
        aw.getSysCmdMsgExtension().b("WCONotify", this.nwp, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.nwi);
        com.tencent.mm.sdk.b.a.xxA.d(this.nwj);
        com.tencent.mm.sdk.b.a.xxA.d(this.nwk);
        com.tencent.mm.sdk.b.a.xxA.d(this.nwl);
        AppMethodBeat.o(21789);
    }
}
