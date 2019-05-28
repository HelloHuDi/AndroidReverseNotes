package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.to;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.l;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vending.g.f;

public final class w implements b {
    MMFragmentActivity yhZ;
    c<px> yhq = new c<px>() {
        {
            AppMethodBeat.i(29662);
            this.xxI = px.class.getName().hashCode();
            AppMethodBeat.o(29662);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29663);
            w.this.ynU = true;
            al.af(w.this.ynV);
            al.d(w.this.ynV);
            AppMethodBeat.o(29663);
            return false;
        }
    };
    c yhr = new c<iw>() {
        {
            AppMethodBeat.i(29660);
            this.xxI = iw.class.getName().hashCode();
            AppMethodBeat.o(29660);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29661);
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29659);
                    w.this.ynU = true;
                    al.af(w.this.ynV);
                    al.d(w.this.ynV);
                    AppMethodBeat.o(29659);
                }
            });
            AppMethodBeat.o(29661);
            return true;
        }
    };
    c ynS;
    c ynT;
    boolean ynU;
    Runnable ynV = new Runnable() {
        public final void run() {
            AppMethodBeat.i(29653);
            if (!g.RN().QY()) {
                ab.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
                AppMethodBeat.o(29653);
            } else if (w.this.ynT == null) {
                ab.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
                AppMethodBeat.o(29653);
            } else {
                f.dMn().d(new com.tencent.mm.vending.c.a<Integer, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        int i = 0;
                        AppMethodBeat.i(29652);
                        if (aw.RK()) {
                            int YD = r.YD();
                            if ((r.YK() & 64) == 0 && (YD & 32768) == 0) {
                                YD = l.Yv() + 0;
                            } else {
                                YD = 0;
                            }
                            if ((r.YK() & 512) == 0 && !com.tencent.mm.bn.a.dgL()) {
                                i = d.akQ().baS() + 0;
                            }
                            if ((r.YK() & 256) == 0) {
                                bu akR = d.akR();
                                if (akR != null) {
                                    i += akR.baS();
                                }
                                i += com.tencent.mm.pluginsdk.p.a.dgQ().cjL();
                            }
                            YD += i;
                            if ((r.YK() & 32768) != 0 || n.qFz == null) {
                                i = YD;
                            } else {
                                i = YD + n.qFz.baS();
                            }
                            e redDotMgr = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
                            if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                                ab.i("MicroMsg.UnreadCountHelper", "checkLookVisibility EuropeanUnionCountry");
                            } else if (redDotMgr != null && redDotMgr.cFi() && redDotMgr.cFj()) {
                                int cEU = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEU();
                                if (((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEY() && cEU > 0) {
                                    i += cEU;
                                }
                            }
                        } else {
                            ab.w("MicroMsg.UnreadCountHelper", "getFindTabUnreadCount, but mmcore not ready");
                        }
                        Integer valueOf = Integer.valueOf(i);
                        AppMethodBeat.o(29652);
                        return valueOf;
                    }
                }).f(new com.tencent.mm.vending.c.a<Void, Integer>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(29651);
                        Void k = k((Integer) obj);
                        AppMethodBeat.o(29651);
                        return k;
                    }

                    /* JADX WARNING: Missing block: B:83:0x029f, code skipped:
            if (((java.lang.Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, java.lang.Boolean.FALSE)).booleanValue() == true) goto L_0x02a1;
     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private Void k(Integer num) {
                        Void voidR;
                        boolean z;
                        boolean cDt;
                        AppMethodBeat.i(29650);
                        w.this.ynT.px(false);
                        w.this.ynT.MO(num.intValue());
                        if (num.intValue() <= 0 && com.tencent.mm.bn.a.dgL() && d.akQ().baS() > 0) {
                            w.this.ynT.px(true);
                        }
                        if (num.intValue() <= 0 && (r.YK() & 32768) == 0) {
                            aw.ZK();
                            if (ah.f((Boolean) com.tencent.mm.model.c.Ry().get(68384, null))) {
                                aw.ZK();
                                if (ah.isNullOrNil((String) com.tencent.mm.model.c.Ry().get(68377, null))) {
                                    aw.ZK();
                                    if (((Boolean) com.tencent.mm.model.c.Ry().get(589825, Boolean.FALSE)).booleanValue()) {
                                        w.this.ynT.px(true);
                                        voidR = zXH;
                                        AppMethodBeat.o(29650);
                                        return voidR;
                                    }
                                    Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, null);
                                    long longValue = obj == null ? 0 : ((Long) obj).longValue();
                                    if (longValue != 0 && ((m) g.K(m.class)).jM(longValue)) {
                                        w.this.ynT.px(true);
                                        voidR = zXH;
                                        AppMethodBeat.o(29650);
                                        return voidR;
                                    }
                                }
                                w.this.ynT.px(true);
                                voidR = zXH;
                                AppMethodBeat.o(29650);
                                return voidR;
                            }
                        }
                        e redDotMgr = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
                        if (com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
                        } else if (redDotMgr != null && redDotMgr.cFi() && redDotMgr.cFj() && ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cET()) {
                            w.this.ynT.px(true);
                        }
                        if (((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agO("labs_nearbylife") && ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).xj("labs_nearbylife") && ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                            w.this.ynT.px(true);
                        }
                        if (num.intValue() <= 0) {
                            z = (r.YE() & 4194304) != 0;
                            String value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigName");
                            String value2 = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigIconUrl");
                            String value3 = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigJumpUrl");
                            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd tryshow configName " + value + " iconUrl " + value2 + " jumpUrl " + value3);
                            if (!(z || ah.isNullOrNil(value) || ah.isNullOrNil(value2) || ah.isNullOrNil(value3))) {
                                com.tencent.mm.pluginsdk.f.f.b bVar = com.tencent.mm.pluginsdk.f.f.vdy;
                                if (bVar != null) {
                                    cDt = bVar.cDt();
                                    ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(cDt)));
                                    if (cDt) {
                                        com.tencent.mm.pluginsdk.f.f.a cDB = bVar.cDB();
                                        if (!cDB.isStart() || cDB.bxX()) {
                                            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                                        } else {
                                            w.this.ynT.px(true);
                                            voidR = zXH;
                                            AppMethodBeat.o(29650);
                                            return voidR;
                                        }
                                    }
                                }
                            }
                        }
                        z = (r.YE() & 33554432) != 0;
                        if (!com.tencent.mm.plugin.ipcall.d.bGW()) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
                        } else if (!(z || w.this.ynT.getShowFriendPoint() || num.intValue() > 0)) {
                            aw.ZK();
                            if (((Integer) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.Nu().getInt("WCOEntranceRedDot", 0)) {
                                aw.ZK();
                            }
                            w.this.ynT.px(true);
                        }
                        if ((r.YE() & 2097152) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            am cVt = am.cVt();
                            if (cVt.uaS != null && cVt.uaS.isValid() && cVt.uaS.uaW == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                w.this.ynT.px(true);
                            }
                        }
                        aw.ZK();
                        if ((com.tencent.mm.model.c.Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                            cDt = true;
                        } else {
                            cDt = false;
                        }
                        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) == 1) {
                            aw.ZK();
                            z = ((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue();
                        } else {
                            z = false;
                        }
                        if (z && r3) {
                            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                            w.this.ynT.py(true);
                        }
                        w.this.ynU = false;
                        voidR = zXH;
                        AppMethodBeat.o(29650);
                        return voidR;
                    }
                }).a(w.this.yhZ);
                AppMethodBeat.o(29653);
            }
        }

        public final String toString() {
            AppMethodBeat.i(29654);
            String str = super.toString() + "|setTagRunnable";
            AppMethodBeat.o(29654);
            return str;
        }
    };
    a ynW;
    com.tencent.mm.x.a.a ynX = new com.tencent.mm.x.a.a() {
        public final void p(int i, String str) {
            AppMethodBeat.i(29668);
            if (i == 262145 || i == 262156 || i == 262152 || i == 266260 || i == 266267) {
                w.b(w.this);
            }
            if (i == 262147 || i == 262149 || i == 352279) {
                w.b(w.this);
            }
            AppMethodBeat.o(29668);
        }

        public final void b(com.tencent.mm.storage.ac.a aVar) {
            AppMethodBeat.i(29669);
            if (aVar == com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC) {
                w.b(w.this);
            }
            AppMethodBeat.o(29669);
        }
    };
    b ynY = new b() {
        public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
            AppMethodBeat.i(29670);
            int bh = ah.bh(obj);
            ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(bh), nVar);
            aw.ZK();
            if (nVar != com.tencent.mm.model.c.Ry() || bh <= 0) {
                ab.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(bh), nVar);
                AppMethodBeat.o(29670);
                return;
            }
            w.this.dyE();
            if (bh == 143618) {
                w.a(w.this);
                AppMethodBeat.o(29670);
                return;
            }
            if (bh == 204817 || bh == 204820) {
                w.b(w.this);
            }
            AppMethodBeat.o(29670);
        }
    };
    c ynZ = new c<to>() {
        {
            AppMethodBeat.i(29655);
            this.xxI = to.class.getName().hashCode();
            AppMethodBeat.o(29655);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29656);
            ab.v("MicroMsg.LauncherUI.MainTabUnreadMgr", "appTagUnreadChangeListener, event:%s", ((to) bVar).toString());
            w.this.dyE();
            AppMethodBeat.o(29656);
            return false;
        }
    };

    static class a implements com.tencent.mm.ax.d.a {
        c ynT;

        public a(c cVar) {
            this.ynT = cVar;
        }

        public final void e(bm bmVar) {
            AppMethodBeat.i(29671);
            if (bmVar.field_tipId == com.tencent.mm.ax.b.fKD) {
                com.tencent.mm.plugin.r.a.bVv();
                if (com.tencent.mm.ax.c.lQ(com.tencent.mm.ax.b.fKD)) {
                    this.ynT.py(true);
                }
            }
            AppMethodBeat.o(29671);
        }
    }

    public w() {
        AppMethodBeat.i(29672);
        AppMethodBeat.o(29672);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyI() {
        AppMethodBeat.i(29673);
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29665);
                w.this.ynU = true;
                al.af(w.this.ynV);
                al.d(w.this.ynV);
                AppMethodBeat.o(29665);
            }
        });
        AppMethodBeat.o(29673);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyE() {
        AppMethodBeat.i(29674);
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29666);
                w.this.ynU = true;
                al.af(w.this.ynV);
                al.n(w.this.ynV, 300);
                AppMethodBeat.o(29666);
            }
        });
        AppMethodBeat.o(29674);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyC() {
        AppMethodBeat.i(29675);
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29667);
                if (w.this.ynU) {
                    ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
                    al.af(w.this.ynV);
                }
                AppMethodBeat.o(29667);
            }
        });
        AppMethodBeat.o(29675);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyD() {
        AppMethodBeat.i(29676);
        if (this.ynU) {
            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
            dyI();
        }
        AppMethodBeat.o(29676);
    }

    public final void No(int i) {
        AppMethodBeat.i(29677);
        if (this.ynT != null) {
            this.ynT.MM(i);
            this.ynS.dxq();
        }
        AppMethodBeat.o(29677);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(29678);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(29678);
            return;
        }
        aw.ZK();
        if (nVar == com.tencent.mm.model.c.XR()) {
            ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", Integer.valueOf(i), obj);
            if (ad.mR((String) obj)) {
                dyE();
            }
            AppMethodBeat.o(29678);
            return;
        }
        AppMethodBeat.o(29678);
    }

    public final void Np(int i) {
        AppMethodBeat.i(29679);
        if (this.ynT != null) {
            this.ynT.setTo(i);
        }
        AppMethodBeat.o(29679);
    }

    public final int dyJ() {
        AppMethodBeat.i(29680);
        int i = 0;
        if (this.ynT != null && this.ynT.getMainTabUnread() > 0) {
            i = this.ynT.getMainTabUnread();
        }
        AppMethodBeat.o(29680);
        return i;
    }

    static /* synthetic */ void a(w wVar) {
        AppMethodBeat.i(29681);
        al.d(new Runnable() {
            public final String toString() {
                AppMethodBeat.i(29658);
                String str = super.toString() + "|setAddressTagUnread";
                AppMethodBeat.o(29658);
                return str;
            }

            public final void run() {
                int h;
                AppMethodBeat.i(29657);
                if (aw.RK()) {
                    aw.ZK();
                    h = ah.h((Integer) com.tencent.mm.model.c.Ry().get(143618, null));
                } else {
                    ab.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
                    h = 0;
                }
                if (w.this.ynT != null) {
                    w.this.ynT.MN(h);
                }
                AppMethodBeat.o(29657);
            }
        });
        AppMethodBeat.o(29681);
    }

    static /* synthetic */ void b(w wVar) {
        AppMethodBeat.i(29682);
        if (aw.RK()) {
            Object obj;
            int i;
            g.K(com.tencent.mm.plugin.card.c.b.class);
            boolean bX = com.tencent.mm.x.c.PK().bX(262156, 266241);
            boolean bY = com.tencent.mm.x.c.PK().bY(262156, 266241);
            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(bX), Boolean.valueOf(bY));
            if (bX || bY) {
                aw.ZK();
                long longValue = ((Long) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
                long lb = ah.lb(com.tencent.mm.m.g.Nu().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * lb;
                ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(lb), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
                if (longValue > 0 && lb > 0 && r14 >= ((double) lb)) {
                    bX = false;
                    com.tencent.mm.x.c.PK().x(262156, false);
                    bY = false;
                }
            }
            ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "after check, hasMallNew: %s, hasMallDot: %s", Boolean.valueOf(bX), Boolean.valueOf(bY));
            boolean bX2 = com.tencent.mm.x.c.PK().bX(262145, 266241);
            boolean bY2 = com.tencent.mm.x.c.PK().bY(266260, 266241);
            boolean bX3 = com.tencent.mm.x.c.PK().bX(262147, 266241);
            boolean bX4 = com.tencent.mm.x.c.PK().bX(262149, 266241);
            boolean bY3 = com.tencent.mm.x.c.PK().bY(262152, 266256);
            boolean bX5 = com.tencent.mm.x.c.PK().bX(262152, 266256);
            boolean a = com.tencent.mm.x.c.PK().a(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
            boolean bX6 = com.tencent.mm.x.c.PK().bX(352279, 266241);
            boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) g.K(com.tencent.mm.plugin.welab.a.a.c.class);
            Object obj2 = null;
            if (cVar != null) {
                obj = (cVar.ddn() || cVar.ddo()) ? 1 : null;
                obj2 = obj;
            }
            com.tencent.mm.x.a PK = com.tencent.mm.x.c.PK();
            int i2;
            if (PK.initialized) {
                com.tencent.mm.x.b.a F = PK.eER.F(262152, 266256, 4);
                if (F == null) {
                    i2 = 0;
                } else {
                    i2 = com.tencent.mm.x.a.parseInt(F.value);
                }
            } else {
                ab.w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
                i2 = 0;
            }
            com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) g.K(com.tencent.mm.plugin.card.c.b.class);
            if (bVar == null || !(bVar.bbn() || bVar.bbo())) {
                obj = null;
            } else {
                obj = 1;
            }
            Object obj3;
            if (obj == null || !(bY3 || bX5 || i2 > 0)) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            g.RQ();
            bY3 = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            g.RQ();
            long longValue2 = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0))).longValue();
            if (bY3 && longValue2 > 0 && System.currentTimeMillis() > longValue2) {
                ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasNewMallDot expire, ignore redot");
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, (Object) Boolean.FALSE);
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0));
                bY3 = false;
            }
            bX5 = com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
            g.RQ();
            longValue2 = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0))).longValue();
            if (bX5 && longValue2 > 0 && System.currentTimeMillis() > longValue2) {
                ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasNewMallDot expire, ignore redot");
                bY3 = false;
                com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                g.RQ();
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_EXPIRETIME_LONG_SYNC, (Object) Long.valueOf(0));
            }
            if (wVar.ynT != null) {
                if (bY || bX || bX2 || obj3 != null || bX3 || bX4 || bY2 || obj2 != null || a || r7 || bX5 || bX6) {
                    wVar.ynT.py(true);
                } else {
                    wVar.ynT.py(false);
                }
            }
            h hVar = h.scu;
            h.lp(bX6 ? 1 : 0);
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (bY) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            hVar2.e(14872, objArr);
            bm Ms = com.tencent.mm.plugin.r.a.bVu().Ms(com.tencent.mm.ax.b.fKD);
            if (Ms == null || Ms.field_isExit) {
                com.tencent.mm.plugin.r.a.bVv();
                if (com.tencent.mm.ax.c.lQ(com.tencent.mm.ax.b.fKD)) {
                    wVar.ynT.py(true);
                }
            } else {
                wVar.ynW = new a(wVar.ynT);
                com.tencent.mm.plugin.r.a.bVt().fKT = wVar.ynW;
            }
            if (wVar.ynT != null) {
                wVar.ynT.pz(booleanValue);
            }
            AppMethodBeat.o(29682);
            return;
        }
        ab.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "want update more menu new tips, but mmcore not ready");
        AppMethodBeat.o(29682);
    }
}
