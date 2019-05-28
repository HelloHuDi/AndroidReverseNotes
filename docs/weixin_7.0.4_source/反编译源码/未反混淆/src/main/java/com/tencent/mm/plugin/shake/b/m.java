package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.c.a.f;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class m implements at {
    private static HashMap<Integer, d> eaA;
    private c egQ = new c<ss>() {
        {
            AppMethodBeat.i(24485);
            this.xxI = ss.class.getName().hashCode();
            AppMethodBeat.o(24485);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(24486);
            ss ssVar = (ss) bVar;
            if (ssVar.cOR.cOS.equals(qm.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    m.this.qse.axy();
                } else {
                    m.this.qse.unregister();
                }
            }
            AppMethodBeat.o(24486);
            return false;
        }
    };
    private a flN = new a() {
        public final void a(ak akVar, be beVar) {
            AppMethodBeat.i(24476);
            if (akVar != null && t.nC(akVar.field_username)) {
                akVar.setUsername("");
            }
            AppMethodBeat.o(24476);
        }
    };
    private com.tencent.mm.sdk.platformtools.ak mHandler = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
    private c oMA = new c<kd>() {
        {
            AppMethodBeat.i(24483);
            this.xxI = kd.class.getName().hashCode();
            AppMethodBeat.o(24483);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(24484);
            kd kdVar = (kd) bVar;
            if (kdVar instanceof kd) {
                switch (kdVar.cFz.action) {
                    case -4:
                        Cursor cjB = m.cjS().cjB();
                        kdVar.cFA.cAV = new ArrayList();
                        while (cjB != null && cjB.moveToNext()) {
                            d dVar = new d();
                            dVar.d(cjB);
                            kdVar.cFA.cAV.add(i.d(dVar.field_lvbuffer, 0));
                        }
                        if (cjB != null) {
                            cjB.close();
                            break;
                        }
                        break;
                    case 12:
                        kdVar.cFA.cFG = com.tencent.mm.plugin.shake.d.b.a.UK(kdVar.cFz.cFE);
                        break;
                }
            }
            AppMethodBeat.o(24484);
            return false;
        }
    };
    private bd.a oPE = new bd.a() {
        public final void a(bd bdVar, ad adVar) {
            AppMethodBeat.i(24490);
            if (!(bdVar == null || adVar == null || !adVar.Oa())) {
                m.cjS().WC(adVar.field_username);
            }
            AppMethodBeat.o(24490);
        }
    };
    private e qrY;
    private g qrZ;
    private f qsa;
    private com.tencent.mm.plugin.shake.c.a.d qsb;
    private o qsc;
    private n qsd = new n();
    com.tencent.mm.pluginsdk.c.d qse = new com.tencent.mm.pluginsdk.c.d() {
        public final b NJ(String str) {
            AppMethodBeat.i(24474);
            qm qmVar = new qm();
            qmVar.cMF.ctq = str;
            AppMethodBeat.o(24474);
            return qmVar;
        }

        public final k bCU() {
            AppMethodBeat.i(24475);
            g cjT = m.cjT();
            AppMethodBeat.o(24475);
            return cjT;
        }
    };
    private bz.a qsf = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(24489);
            m.cjZ();
            if (m.cjW() != null) {
                m.cjZ();
                m.cjW();
                String a = aa.a(aVar.eAB.vED);
                ab.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(a)));
                if (bo.isNullOrNil(a)) {
                    ab.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                    AppMethodBeat.o(24489);
                    return;
                }
                Map z = br.z(a, "sysmsg");
                int i = bo.getInt((String) z.get(".sysmsg.shake.$type"), 0);
                switch (i) {
                    case 1:
                        f fVar = new f();
                        i = bo.getInt((String) z.get(".sysmsg.shake.shaketv.msgtype"), 0);
                        if (i == 0) {
                            fVar.field_type = 1;
                            fVar.field_subtype = i;
                            fVar.field_svrid = aVar.eAB.ptF;
                            fVar.field_createtime = bo.anT();
                            fVar.field_tag = (String) z.get(".sysmsg.shake.shaketv.jumpurl");
                            fVar.field_status = 0;
                            fVar.field_title = (String) z.get(".sysmsg.shake.shaketv.title");
                            fVar.field_thumburl = (String) z.get(".sysmsg.shake.shaketv.iconurl");
                            fVar.field_desc = (String) z.get(".sysmsg.shake.shaketv.desc");
                            fVar.field_reserved1 = bo.nullAsNil((String) z.get(".sysmsg.shake.shaketv.pid"));
                            m.cjT().a(fVar);
                            AppMethodBeat.o(24489);
                            return;
                        }
                        ab.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
                        AppMethodBeat.o(24489);
                        return;
                    default:
                        ab.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
                        AppMethodBeat.o(24489);
                        return;
                }
            }
            ab.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
            AppMethodBeat.o(24489);
        }
    };
    private c qsg = new c<oh>() {
        {
            AppMethodBeat.i(24477);
            this.xxI = oh.class.getName().hashCode();
            AppMethodBeat.o(24477);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(24478);
            if (((oh) bVar) instanceof oh) {
                h.pYm.e(10221, Integer.valueOf(r7.cKC.scene));
                AppMethodBeat.o(24478);
            } else {
                ab.e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
                AppMethodBeat.o(24478);
            }
            return false;
        }
    };
    private bz.a qsh = new bz.a() {
        public final void a(final e.a aVar) {
            AppMethodBeat.i(24480);
            final String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
                AppMethodBeat.o(24480);
                return;
            }
            m.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24479);
                    m.cjX().i(a, aVar.eAB.ptF, 0);
                    AppMethodBeat.o(24479);
                }
            });
            AppMethodBeat.o(24480);
        }
    };
    private bz.a qsi = new bz.a() {
        public final void a(final e.a aVar) {
            AppMethodBeat.i(24482);
            final String a = aa.a(aVar.eAB.vED);
            if (a == null || a.length() == 0) {
                ab.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                AppMethodBeat.o(24482);
                return;
            }
            m.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24481);
                    m.cjX().i(a, aVar.eAB.ptF, 1);
                    AppMethodBeat.o(24481);
                }
            });
            AppMethodBeat.o(24482);
        }
    };

    public m() {
        AppMethodBeat.i(24491);
        AppMethodBeat.o(24491);
    }

    static /* synthetic */ m cjZ() {
        AppMethodBeat.i(24504);
        m cjR = cjR();
        AppMethodBeat.o(24504);
        return cjR;
    }

    private static m cjR() {
        AppMethodBeat.i(24492);
        aw.ZE();
        m mVar = (m) bw.oJ("plugin.shake");
        if (mVar == null) {
            mVar = new m();
            aw.ZE().a("plugin.shake", mVar);
        }
        AppMethodBeat.o(24492);
        return mVar;
    }

    public static e cjS() {
        AppMethodBeat.i(24493);
        g.RN().QU();
        if (cjR().qrY == null) {
            m cjR = cjR();
            aw.ZK();
            cjR.qrY = new e(com.tencent.mm.model.c.Ru());
        }
        e eVar = cjR().qrY;
        AppMethodBeat.o(24493);
        return eVar;
    }

    public static g cjT() {
        AppMethodBeat.i(24494);
        g.RN().QU();
        if (cjR().qrZ == null) {
            m cjR = cjR();
            aw.ZK();
            cjR.qrZ = new g(com.tencent.mm.model.c.Ru());
        }
        g gVar = cjR().qrZ;
        AppMethodBeat.o(24494);
        return gVar;
    }

    public static o cjU() {
        AppMethodBeat.i(24495);
        g.RN().QU();
        if (cjR().qsc == null) {
            m cjR = cjR();
            aw.ZK();
            cjR.qsc = new o(com.tencent.mm.model.c.Ru());
        }
        o oVar = cjR().qsc;
        AppMethodBeat.o(24495);
        return oVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(24496);
        aw.ZK();
        com.tencent.mm.model.c.XR().d(this.flN);
        com.tencent.mm.sdk.b.a.xxA.d(this.egQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.qsg);
        com.tencent.mm.sdk.b.a.xxA.d(this.qsd);
        com.tencent.mm.sdk.b.a.xxA.d(this.oMA);
        aw.ZK();
        com.tencent.mm.model.c.XM().b(this.oPE);
        aw.getSysCmdMsgExtension().b("shake", this.qsf, true);
        aw.getSysCmdMsgExtension().b("ShakeCardEntrance", this.qsh, true);
        aw.getSysCmdMsgExtension().b("ShakeCardRedDot", this.qsi, true);
        p.a.vav = null;
        AppMethodBeat.o(24496);
    }

    static {
        AppMethodBeat.i(24505);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        eaA.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        eaA.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        eaA.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        AppMethodBeat.o(24505);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public static void cjV() {
        AppMethodBeat.i(24497);
        cjS().cjH();
        com.tencent.mm.bi.d.akR().axQ();
        AppMethodBeat.o(24497);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(24498);
        p.a.vav = new h();
        aw.ZK();
        com.tencent.mm.model.c.XR().c(this.flN);
        com.tencent.mm.sdk.b.a.xxA.c(this.egQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.qsg);
        com.tencent.mm.sdk.b.a.xxA.c(this.qsd);
        com.tencent.mm.sdk.b.a.xxA.c(this.oMA);
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.oPE);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24487);
                if (aw.RK()) {
                    aw.ZK();
                    bo.o(com.tencent.mm.model.c.Yc(), "Sk", 604800000);
                    AppMethodBeat.o(24487);
                    return;
                }
                AppMethodBeat.o(24487);
            }

            public final String toString() {
                AppMethodBeat.i(24488);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(24488);
                return str;
            }
        });
        aw.getSysCmdMsgExtension().a("shake", this.qsf, true);
        aw.getSysCmdMsgExtension().a("ShakeCardEntrance", this.qsh, true);
        aw.getSysCmdMsgExtension().a("ShakeCardRedDot", this.qsi, true);
        this.qsa = null;
        this.qsb = null;
        AppMethodBeat.o(24498);
    }

    public final void bA(boolean z) {
    }

    public static i cjW() {
        AppMethodBeat.i(24499);
        g.RN().QU();
        i iVar = i.qrN;
        AppMethodBeat.o(24499);
        return iVar;
    }

    public static String sw(String str) {
        AppMethodBeat.i(24500);
        String format;
        if (aw.RK()) {
            r1 = new Object[2];
            aw.ZK();
            r1[0] = com.tencent.mm.model.c.Yc();
            r1[1] = com.tencent.mm.a.g.x(str.getBytes());
            format = String.format("%s/Sk_%s", r1);
            AppMethodBeat.o(24500);
            return format;
        }
        format = "";
        AppMethodBeat.o(24500);
        return format;
    }

    public static String fQ(String str, String str2) {
        AppMethodBeat.i(24501);
        String str3;
        if (!aw.RK() || bo.isNullOrNil(str)) {
            str3 = "";
            AppMethodBeat.o(24501);
            return str3;
        }
        r1 = new Object[3];
        aw.ZK();
        r1[0] = com.tencent.mm.model.c.Yc();
        r1[1] = str2;
        r1[2] = com.tencent.mm.a.g.x(str.getBytes());
        str3 = String.format("%s/Sk%s_%s", r1);
        AppMethodBeat.o(24501);
        return str3;
    }

    public static f cjX() {
        AppMethodBeat.i(24502);
        g.RN().QU();
        if (cjR().qsa == null) {
            cjR().qsa = new f();
        }
        f fVar = cjR().qsa;
        AppMethodBeat.o(24502);
        return fVar;
    }

    public static com.tencent.mm.plugin.shake.c.a.d cjY() {
        AppMethodBeat.i(24503);
        g.RN().QU();
        if (cjR().qsb == null) {
            cjR().qsb = new com.tencent.mm.plugin.shake.c.a.d();
        }
        com.tencent.mm.plugin.shake.c.a.d dVar = cjR().qsb;
        AppMethodBeat.o(24503);
        return dVar;
    }
}
