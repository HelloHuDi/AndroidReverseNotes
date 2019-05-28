package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.ci.c;
import com.tencent.mm.ci.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.va;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class r implements at {
    private static HashMap<Integer, d> eaA;
    private com.tencent.mm.model.bz.a old = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(46856);
            final Map z = br.z(aa.a(aVar.eAB.vED), "sysmsg");
            if (z == null) {
                AppMethodBeat.o(46856);
                return;
            }
            int i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            ab.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = ".concat(String.valueOf(i)));
            switch (i) {
                case 16:
                    i = bo.getInt((String) z.get(".sysmsg.paymsg.Flag"), 0);
                    ab.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
                    if (i == 1) {
                        ab.i("MicroMsg.SubCoreWalletCore", "open wallet");
                        com.tencent.mm.model.r.YJ();
                        AppMethodBeat.o(46856);
                        return;
                    } else if (i == 2) {
                        ab.i("MicroMsg.SubCoreWalletCore", "close wallet");
                        i = com.tencent.mm.model.r.YF() & -32769;
                        g.RQ();
                        g.RP().Ry().set(40, Integer.valueOf(i));
                        AppMethodBeat.o(46856);
                        return;
                    }
                    break;
                case 17:
                    i = bo.getInt((String) z.get(".sysmsg.paymsg.WalletType"), -1);
                    ab.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
                    if (i >= 0) {
                        g.RQ();
                        g.RP().Ry().set(339975, Integer.valueOf(i));
                        AppMethodBeat.o(46856);
                        return;
                    }
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                    ab.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", r1);
                    g.RQ();
                    g.RS().aa(new Runnable() {
                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            Exception e;
                            Throwable th;
                            AppMethodBeat.i(46855);
                            Cursor cursor = null;
                            Cursor Rz;
                            try {
                                String str;
                                String str2;
                                bi biVar;
                                Cursor cursor2;
                                Cursor cursor3;
                                String str3 = (String) z.get(".sysmsg.paymsg.fromusername");
                                String str4 = (String) z.get(".sysmsg.paymsg.tousername");
                                String str5 = (String) z.get(".sysmsg.paymsg.paymsgid");
                                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                                if (bo.isNullOrNil(str3) || str3.equals(com.tencent.mm.model.r.Yz())) {
                                    str = str4;
                                } else {
                                    str = str3;
                                }
                                if (t.kH(str3)) {
                                    str2 = str3;
                                } else if (t.kH(str4)) {
                                    str2 = str4;
                                } else {
                                    str2 = str;
                                }
                                ab.i("MicroMsg.SubCoreWalletCore", "username: %s, fromUsername: %s, toUsername: %s, talker: %s, payMsgId: %s", com.tencent.mm.model.r.Yz(), str3, str4, str2, str5);
                                b me = b.me(decode);
                                ab.i("MicroMsg.SubCoreWalletCore", "appMsgContent: %s, appMsg: %s", decode, me);
                                ArrayList<bi> arrayList = new ArrayList();
                                if (me != null) {
                                    Rz = ((j) g.K(j.class)).bOr().Rz(str2);
                                    if (Rz != null) {
                                        while (Rz.moveToNext()) {
                                            try {
                                                biVar = new bi();
                                                biVar.d(Rz);
                                                b me2 = b.me(biVar.field_content);
                                                if (!(me2 == null || bo.isNullOrNil(me2.fib) || !me2.fib.equals(me.fib))) {
                                                    ab.i("MicroMsg.SubCoreWalletCore", "update find msg id: %s, talker: %s, sender: %s", Long.valueOf(biVar.field_msgId), biVar.field_talker, Integer.valueOf(biVar.field_isSend));
                                                    if (t.kH(biVar.field_talker)) {
                                                        biVar.setContent(bf.al(decode, bf.oy(biVar.field_content)));
                                                    } else {
                                                        biVar.setContent(decode);
                                                    }
                                                    arrayList.add(biVar);
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        }
                                    }
                                    cursor2 = Rz;
                                } else {
                                    cursor2 = null;
                                }
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                        cursor2 = null;
                                    } catch (Exception e3) {
                                        cursor3 = cursor2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        AppMethodBeat.o(46855);
                                        throw th;
                                    }
                                }
                                cursor3 = cursor2;
                                try {
                                    ab.i("MicroMsg.SubCoreWalletCore", "updateMsg: %s", arrayList);
                                    if (arrayList.size() > 0) {
                                        for (bi biVar2 : arrayList) {
                                            ab.i("MicroMsg.SubCoreWalletCore", "do update msg: %s %s", Long.valueOf(biVar2.field_msgId), biVar2.field_content);
                                            ((j) g.K(j.class)).bOr().a(biVar2.field_msgId, biVar2);
                                        }
                                    }
                                    if (cursor3 != null) {
                                        cursor3.close();
                                        AppMethodBeat.o(46855);
                                        return;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    Rz = cursor3;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.SubCoreWalletCore", e, "parse c2c content update msg error", e.getMessage());
                                        if (Rz != null) {
                                            Rz.close();
                                            AppMethodBeat.o(46855);
                                            return;
                                        }
                                        AppMethodBeat.o(46855);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = Rz;
                                        if (cursor != null) {
                                        }
                                        AppMethodBeat.o(46855);
                                        throw th;
                                    }
                                } catch (Throwable th32) {
                                    th = th32;
                                    cursor = cursor3;
                                    if (cursor != null) {
                                    }
                                    AppMethodBeat.o(46855);
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                Rz = null;
                            } catch (Throwable th322) {
                                th = th322;
                                if (cursor != null) {
                                }
                                AppMethodBeat.o(46855);
                                throw th;
                            }
                            AppMethodBeat.o(46855);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(46856);
        }
    };
    private volatile t tBM = new t();
    private h<ak> tBN = new h(new c<ak>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46846);
            ak akVar = new ak();
            AppMethodBeat.o(46846);
            return akVar;
        }
    });
    private volatile ae tBO = null;
    private h<ah> tBP = new h(new c<ah>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46857);
            ah ahVar = new ah();
            AppMethodBeat.o(46857);
            return ahVar;
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.j> tBQ = new h(new c<com.tencent.mm.plugin.wallet_core.d.j>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46858);
            g.RQ();
            com.tencent.mm.plugin.wallet_core.d.j jVar = new com.tencent.mm.plugin.wallet_core.d.j(g.RP().eJN);
            AppMethodBeat.o(46858);
            return jVar;
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.c> tBR = new h(new c<com.tencent.mm.plugin.wallet_core.d.c>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46859);
            g.RQ();
            com.tencent.mm.plugin.wallet_core.d.c cVar = new com.tencent.mm.plugin.wallet_core.d.c(g.RP().eJN);
            AppMethodBeat.o(46859);
            return cVar;
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.a> tBS = new h(new c<com.tencent.mm.plugin.wallet_core.d.a>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46860);
            g.RQ();
            com.tencent.mm.plugin.wallet_core.d.a aVar = new com.tencent.mm.plugin.wallet_core.d.a(g.RP().eJN);
            AppMethodBeat.o(46860);
            return aVar;
        }
    });
    private h<f> tBT = new h(new c<f>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46861);
            g.RQ();
            f fVar = new f(g.RP().eJN);
            AppMethodBeat.o(46861);
            return fVar;
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.d> tBU = new h(new c<com.tencent.mm.plugin.wallet_core.d.d>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46862);
            g.RQ();
            com.tencent.mm.plugin.wallet_core.d.d dVar = new com.tencent.mm.plugin.wallet_core.d.d(g.RP().eJN);
            AppMethodBeat.o(46862);
            return dVar;
        }
    });
    private x tBV = new x();
    private h<e> tBW = new h(new c<e>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46863);
            g.RQ();
            e eVar = new e(g.RP().eJN);
            AppMethodBeat.o(46863);
            return eVar;
        }
    });
    private h<i> tBX = new h(new c<i>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46864);
            g.RQ();
            i iVar = new i(g.RP().eJN);
            AppMethodBeat.o(46864);
            return iVar;
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.h> tBY = new h(new c<com.tencent.mm.plugin.wallet_core.d.h>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46847);
            g.RQ();
            com.tencent.mm.plugin.wallet_core.d.h hVar = new com.tencent.mm.plugin.wallet_core.d.h(g.RP().eJN);
            AppMethodBeat.o(46847);
            return hVar;
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.g> tBZ = new h(new c<com.tencent.mm.plugin.wallet_core.d.g>() {
        public final /* synthetic */ Object get() {
            AppMethodBeat.i(46848);
            g.RQ();
            com.tencent.mm.plugin.wallet_core.d.g gVar = new com.tencent.mm.plugin.wallet_core.d.g(g.RP().eJN);
            AppMethodBeat.o(46848);
            return gVar;
        }
    });
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a tCa = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private com.tencent.mm.sdk.b.c tCb = new com.tencent.mm.sdk.b.c<on>() {
        {
            AppMethodBeat.i(46849);
            this.xxI = on.class.getName().hashCode();
            AppMethodBeat.o(46849);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(46850);
            on onVar = (on) bVar;
            r.B(onVar.cKQ.context, onVar.cKQ.intent);
            AppMethodBeat.o(46850);
            return true;
        }
    };
    private String tCc = "";
    private com.tencent.mm.sdk.b.c<tu> tCd = new com.tencent.mm.sdk.b.c<tu>() {
        {
            AppMethodBeat.i(46851);
            this.xxI = tu.class.getName().hashCode();
            AppMethodBeat.o(46851);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(46852);
            tu tuVar = (tu) bVar;
            if (tuVar.cPV.cvz == 11) {
                List list = tuVar.cPV.cPW;
                if (list == null || list.size() <= 0) {
                    ab.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty UpdatePackageEvent");
                } else {
                    byte[] a = aa.a(((bic) list.get(0)).vFG);
                    if (a == null || a.length == 0) {
                        AppMethodBeat.o(46852);
                        return false;
                    }
                    String str = new String(a);
                    if (str.equals(r.this.tCc)) {
                        ab.i("MicroMsg.UpdateMassSendPlaceTopListener", "the same result : %s".concat(String.valueOf(str)));
                    } else {
                        ab.i("MicroMsg.UpdateMassSendPlaceTopListener", "UpdatePackageEvent: %s", str);
                        com.tencent.mm.plugin.wallet_core.d.b.acL(str);
                        r.this.tCc = str;
                    }
                }
            }
            AppMethodBeat.o(46852);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<va> tCe = new com.tencent.mm.sdk.b.c<va>() {
        {
            AppMethodBeat.i(46853);
            this.xxI = va.class.getName().hashCode();
            AppMethodBeat.o(46853);
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ab abVar;
            AppMethodBeat.i(46854);
            va vaVar = (va) bVar;
            com.tencent.mm.plugin.wallet_core.d.g cPF = r.cPF();
            String str = vaVar.cRQ.cRS;
            if (!bo.isNullOrNil(str)) {
                if (com.tencent.mm.plugin.wallet_core.d.g.gms.containsKey(str)) {
                    abVar = (ab) com.tencent.mm.plugin.wallet_core.d.g.gms.get(str);
                } else {
                    abVar = cPF.acN(str);
                    if (abVar != null) {
                        com.tencent.mm.plugin.wallet_core.d.g.gms.put(str, abVar);
                    }
                }
                if (abVar != null) {
                    vaVar.cRR.cRT = abVar.field_hbType;
                    vaVar.cRR.cRU = abVar.field_hbStatus;
                    vaVar.cRR.cRV = abVar.field_receiveStatus;
                }
                AppMethodBeat.o(46854);
                return false;
            }
            abVar = null;
            if (abVar != null) {
            }
            AppMethodBeat.o(46854);
            return false;
        }
    };

    static class a implements com.tencent.mm.pluginsdk.cmd.a {
        a() {
        }

        public final boolean a(Context context, String[] strArr, String str) {
            AppMethodBeat.i(46865);
            String str2 = strArr[0];
            int i = -1;
            switch (str2.hashCode()) {
                case -1912590262:
                    if (str2.equals("//cleanpaycn")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    com.tencent.mm.wallet_core.c.b.dNJ();
                    com.tencent.mm.wallet_core.c.b.clean();
                    AppMethodBeat.o(46865);
                    return true;
                default:
                    AppMethodBeat.o(46865);
                    return false;
            }
        }
    }

    public r() {
        AppMethodBeat.i(46866);
        AppMethodBeat.o(46866);
    }

    static {
        AppMethodBeat.i(46886);
        k.a("tenpay_utils", r.class.getClassLoader());
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wallet_core.d.j.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wallet_core.d.c.fnj;
            }
        });
        eaA.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wallet_core.d.a.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return f.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wallet_core.d.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wallet_core.d.h.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return i.fnj;
            }
        });
        eaA.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wallet_core.d.g.fnj;
            }
        });
        AppMethodBeat.o(46886);
    }

    public static r cPD() {
        AppMethodBeat.i(46867);
        r rVar = (r) q.Y(r.class);
        AppMethodBeat.o(46867);
        return rVar;
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public static com.tencent.mm.plugin.wallet_core.d.j cPE() {
        AppMethodBeat.i(46868);
        if (g.RK()) {
            com.tencent.mm.plugin.wallet_core.d.j jVar = (com.tencent.mm.plugin.wallet_core.d.j) cPD().tBQ.get();
            AppMethodBeat.o(46868);
            return jVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46868);
        throw bVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.g cPF() {
        AppMethodBeat.i(46869);
        if (g.RK()) {
            com.tencent.mm.plugin.wallet_core.d.g gVar = (com.tencent.mm.plugin.wallet_core.d.g) cPD().tBZ.get();
            AppMethodBeat.o(46869);
            return gVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46869);
        throw bVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.c cPG() {
        AppMethodBeat.i(46870);
        if (g.RK()) {
            com.tencent.mm.plugin.wallet_core.d.c cVar = (com.tencent.mm.plugin.wallet_core.d.c) cPD().tBR.get();
            AppMethodBeat.o(46870);
            return cVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46870);
        throw bVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.h cPH() {
        AppMethodBeat.i(46871);
        if (g.RK()) {
            com.tencent.mm.plugin.wallet_core.d.h hVar = (com.tencent.mm.plugin.wallet_core.d.h) cPD().tBY.get();
            AppMethodBeat.o(46871);
            return hVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46871);
        throw bVar;
    }

    public static ak cPI() {
        AppMethodBeat.i(46872);
        if (g.RK()) {
            ak akVar = (ak) cPD().tBN.get();
            AppMethodBeat.o(46872);
            return akVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46872);
        throw bVar;
    }

    public static ah cPJ() {
        AppMethodBeat.i(46873);
        if (g.RK()) {
            ah ahVar = (ah) cPD().tBP.get();
            AppMethodBeat.o(46873);
            return ahVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46873);
        throw bVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.a cPK() {
        AppMethodBeat.i(46874);
        if (g.RK()) {
            com.tencent.mm.plugin.wallet_core.d.a aVar = (com.tencent.mm.plugin.wallet_core.d.a) cPD().tBS.get();
            AppMethodBeat.o(46874);
            return aVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46874);
        throw bVar;
    }

    public static f cPL() {
        AppMethodBeat.i(46875);
        if (g.RK()) {
            f fVar = (f) cPD().tBT.get();
            AppMethodBeat.o(46875);
            return fVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46875);
        throw bVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.d cPM() {
        AppMethodBeat.i(46876);
        if (g.RK()) {
            com.tencent.mm.plugin.wallet_core.d.d dVar = (com.tencent.mm.plugin.wallet_core.d.d) cPD().tBU.get();
            AppMethodBeat.o(46876);
            return dVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46876);
        throw bVar;
    }

    public static e cPN() {
        AppMethodBeat.i(46877);
        if (g.RK()) {
            e eVar = (e) cPD().tBW.get();
            AppMethodBeat.o(46877);
            return eVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46877);
        throw bVar;
    }

    public static i cPO() {
        AppMethodBeat.i(46878);
        if (g.RK()) {
            i iVar = (i) cPD().tBX.get();
            AppMethodBeat.o(46878);
            return iVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(46878);
        throw bVar;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public static ae cPP() {
        AppMethodBeat.i(46879);
        ae aeVar = cPD().tBO;
        AppMethodBeat.o(46879);
        return aeVar;
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(46880);
        ab.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
        com.tencent.mm.wallet_core.c.b.dNJ();
        com.tencent.mm.wallet_core.c.b.init(ah.getContext());
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.old, true);
        cPI().cQv();
        this.tBO = ae.cPT();
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.tBO.kBx, true);
        com.tencent.mm.sdk.b.a.xxA.b(this.tCb);
        com.tencent.mm.sdk.b.a.xxA.b(this.tBV);
        com.tencent.mm.sdk.b.a.xxA.b(this.tCe);
        com.tencent.mm.sdk.b.a.xxA.b(this.tCd);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), "//cleanpaycn");
        AppMethodBeat.o(46880);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(46881);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.old, true);
        cPI().Km();
        ah cPJ = cPJ();
        cPJ.tCO = null;
        cPJ.tCN.clear();
        cPJ.tCN = new ArrayList();
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.tBO.kBx, true);
        if (ae.lUV != null) {
            ae.lUV.clear();
        }
        this.tBO = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.tCb);
        com.tencent.mm.sdk.b.a.xxA.d(this.tBV);
        com.tencent.mm.sdk.b.a.xxA.d(this.tCe);
        com.tencent.mm.sdk.b.a.xxA.d(this.tCd);
        AppMethodBeat.o(46881);
    }

    public static void B(Context context, Intent intent) {
        AppMethodBeat.i(46882);
        if (intent == null) {
            intent = new Intent();
        }
        if (com.tencent.mm.model.r.YN()) {
            intent.setFlags(536870912);
            ab.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.bp.d.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
            AppMethodBeat.o(46882);
        } else if (com.tencent.mm.model.r.YO()) {
            intent.setFlags(536870912);
            com.tencent.mm.bp.d.b(context, "mall", ".ui.MallIndexOSUI", intent);
            AppMethodBeat.o(46882);
        } else {
            ab.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
            intent.setFlags(536870912);
            com.tencent.mm.bp.d.b(context, "mall", ".ui.MallIndexUI", intent);
            g.RQ();
            if (g.RP().isSDCardAvailable()) {
                m kVar = new com.tencent.mm.ba.k(11);
                g.RQ();
                g.RO().eJo.a(kVar, 0);
            }
            AppMethodBeat.o(46882);
        }
    }

    public static t cPQ() {
        AppMethodBeat.i(46883);
        t tVar = cPD().tBM;
        AppMethodBeat.o(46883);
        return tVar;
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar) {
        AppMethodBeat.i(46884);
        boolean a = cPD().tCa.a(mMActivity, eVar, 1008);
        AppMethodBeat.o(46884);
        return a;
    }

    public static boolean b(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar) {
        AppMethodBeat.i(46885);
        boolean a = cPD().tCa.a(mMActivity, eVar, 1006);
        AppMethodBeat.o(46885);
        return a;
    }
}
