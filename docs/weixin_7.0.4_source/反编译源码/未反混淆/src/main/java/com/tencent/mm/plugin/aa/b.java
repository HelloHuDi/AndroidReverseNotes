package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vending.g.f;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;

public class b implements at {
    private static HashMap<Integer, d> eaA;
    private c<ni> gkG = new c<ni>() {
        {
            AppMethodBeat.i(40573);
            this.xxI = ni.class.getName().hashCode();
            AppMethodBeat.o(40573);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(40574);
            ni niVar = (ni) bVar;
            String str = "MicroMsg.SubCoreAA";
            String str2 = "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(niVar.cJE.content == null);
            objArr[1] = Integer.valueOf(niVar.cJE.type);
            objArr[2] = niVar.cJE.cEV;
            objArr[3] = niVar.cJE.toUser;
            objArr[4] = niVar.cJE.cJF;
            ab.i(str, str2, objArr);
            if (niVar.cJE.type == a.glq) {
                h.bg(niVar.cJE.content, niVar.cJE.toUser);
            } else if (niVar.cJE.type == a.glr) {
                h.x(niVar.cJE.content, niVar.cJE.toUser, niVar.cJE.cJF);
            } else if (niVar.cJE.type == a.gls) {
                String str3 = niVar.cJE.content;
                str = niVar.cJE.toUser;
                ab.i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s", str);
                if (!bo.isNullOrNil(str3) && t.kH(str)) {
                    bi biVar = new bi();
                    biVar.hO(0);
                    biVar.ju(str);
                    biVar.setStatus(3);
                    biVar.setContent(str3);
                    biVar.eJ(bf.q(str3, System.currentTimeMillis() / 1000));
                    biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                    biVar.hY(biVar.field_flag | 8);
                    biVar.setMsgId(bf.l(biVar));
                }
            }
            AppMethodBeat.o(40574);
            return false;
        }
    };
    private c<nh> gkH = new c<nh>() {
        {
            AppMethodBeat.i(40575);
            this.xxI = nh.class.getName().hashCode();
            AppMethodBeat.o(40575);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(40576);
            nh nhVar = (nh) bVar;
            ab.i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", Long.valueOf(nhVar.cJC.cJD), bo.anv(nhVar.cJC.cJh));
            h.g(r0, r2);
            AppMethodBeat.o(40576);
            return false;
        }
    };
    private c<br> gkI = new c<br>() {
        {
            AppMethodBeat.i(40579);
            this.xxI = br.class.getName().hashCode();
            AppMethodBeat.o(40579);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(40580);
            br brVar = (br) bVar;
            ab.i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", brVar.cuN.cuO, brVar.cuN.cuP);
            if (bo.isNullOrNil(brVar.cuN.cuO) || bo.isNullOrNil(brVar.cuN.cuP)) {
                AppMethodBeat.o(40580);
            } else {
                final j jVar = new j();
                jVar.aoo().init();
                j.a aVar = jVar.glN;
                String str = brVar.cuN.cuO;
                int i = a.glp;
                f.b(str, Integer.valueOf(i), brVar.cuN.cuP, Long.valueOf(brVar.cuN.cuQ)).c(aVar).d(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(40578);
                        ab.i("MicroMsg.SubCoreAA", "close aa success: %s", (Boolean) obj);
                        jVar.aoo().aon();
                        Toast.makeText(ah.getContext(), R.string.ar4, 0).show();
                        Void voidR = zXH;
                        AppMethodBeat.o(40578);
                        return voidR;
                    }
                }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                    public final void bi(Object obj) {
                        AppMethodBeat.i(40577);
                        if (obj instanceof String) {
                            Toast.makeText(ah.getContext(), obj.toString(), 0).show();
                        } else {
                            ab.e("MicroMsg.SubCoreAA", "close aa failed: %s", obj);
                            Toast.makeText(ah.getContext(), R.string.ar6, 1).show();
                        }
                        jVar.aoo().aon();
                        AppMethodBeat.o(40577);
                    }
                });
                AppMethodBeat.o(40580);
            }
            return false;
        }
    };
    private c<bs> gkJ = new c<bs>() {
        {
            AppMethodBeat.i(40582);
            this.xxI = bs.class.getName().hashCode();
            AppMethodBeat.o(40582);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(40583);
            final bs bsVar = (bs) bVar;
            if (bo.isNullOrNil(bsVar.cuR.cuO) || bo.isNullOrNil(bsVar.cuR.cuP)) {
                AppMethodBeat.o(40583);
            } else {
                new com.tencent.mm.plugin.aa.a.a.d(bsVar.cuR.cuO, bsVar.cuR.cuP).acy().h(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<com.tencent.mm.protocal.protobuf.c>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(40581);
                        com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                        ab.i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            ab.i("MicroMsg.SubCoreAA", "close aa urge notify success");
                            if (((com.tencent.mm.protocal.protobuf.c) aVar.fsy).kCl > 0 && !bo.isNullOrNil(((com.tencent.mm.protocal.protobuf.c) aVar.fsy).kCm)) {
                                Toast.makeText(ah.getContext(), ((com.tencent.mm.protocal.protobuf.c) aVar.fsy).kCm, 0).show();
                                com.tencent.mm.plugin.report.service.h.pYm.a(407, 29, 1, false);
                            } else if (((com.tencent.mm.protocal.protobuf.c) aVar.fsy).kCl == 0) {
                                Toast.makeText(ah.getContext(), R.string.ar4, 0).show();
                                com.tencent.mm.plugin.report.service.h.pYm.a(407, 27, 1, false);
                                if (!bo.isNullOrNil(((com.tencent.mm.protocal.protobuf.c) aVar.fsy).vzN)) {
                                    h.h(bsVar.cuR.cuQ, ((com.tencent.mm.protocal.protobuf.c) aVar.fsy).vzN);
                                }
                            } else {
                                ab.i("MicroMsg.SubCoreAA", "illegal resp");
                                com.tencent.mm.plugin.report.service.h.pYm.a(407, 29, 1, false);
                            }
                        } else {
                            ab.i("MicroMsg.SubCoreAA", "close aa urge notify failed");
                            Toast.makeText(ah.getContext(), R.string.ar3, 1).show();
                            com.tencent.mm.plugin.report.service.h.pYm.a(407, 28, 1, false);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(40581);
                        return voidR;
                    }
                });
                AppMethodBeat.o(40583);
            }
            return false;
        }
    };
    private o gkK = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, e.a aVar) {
            AppMethodBeat.i(40584);
            ab.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", Integer.valueOf(bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Integer.valueOf(com.tencent.mm.protocal.d.vxo));
            if (bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 32) {
                int i = bo.getInt((String) map.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
                int i2 = bo.getInt((String) map.get(".sysmsg.paymsg.grouppayreddot"), -1);
                int i3 = bo.getInt((String) map.get(".sysmsg.paymsg.facingreceivereddot"), -1);
                int i4 = bo.getInt((String) map.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
                int i5 = bo.getInt((String) map.get(".sysmsg.paymsg.rewardcodereddot"), -1);
                int i6 = bo.getInt((String) map.get(".sysmsg.paymsg.android_minclientversion"), -1);
                Object bc = bo.bc((String) map.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, bc);
                ab.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                if (com.tencent.mm.protocal.d.vxo >= i6) {
                    bc = null;
                    if (i == 1) {
                        ab.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
                        com.tencent.mm.x.c.PK().y(262159, true);
                    } else if (i == 0) {
                        com.tencent.mm.x.c.PK().y(262159, false);
                    }
                    if (i2 == 1) {
                        ab.i("MicroMsg.SubCoreAA", "mark group pay red dot");
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, true);
                        bc = 1;
                    } else if (i2 == 0) {
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, false);
                    }
                    if (i3 == 1) {
                        ab.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, true);
                        bc = 1;
                    } else if (i3 == 0) {
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, false);
                    }
                    if (i4 == 1) {
                        ab.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, true);
                        bc = 1;
                    } else if (i4 == 0) {
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, false);
                    }
                    if (i5 == 1) {
                        ab.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, true);
                        bc = 1;
                    } else if (i5 == 0) {
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, false);
                    }
                    if (bc != null) {
                        g.RP().Ry().set(ac.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(14396, Integer.valueOf(1));
            }
            AppMethodBeat.o(40584);
        }
    };
    c<uz> gkL = new c<uz>() {
        {
            AppMethodBeat.i(40585);
            this.xxI = uz.class.getName().hashCode();
            AppMethodBeat.o(40585);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i;
            AppMethodBeat.i(40586);
            uz uzVar = (uz) bVar;
            String str = uzVar.cRN.cRP;
            com.tencent.mm.g.a.uz.b bVar2 = uzVar.cRO;
            com.tencent.mm.plugin.aa.a.b.d aod = b.aod();
            if (com.tencent.mm.plugin.aa.a.b.d.gms.containsKey(str)) {
                i = ((com.tencent.mm.plugin.aa.a.b.c) com.tencent.mm.plugin.aa.a.b.d.gms.get(str)).field_status;
            } else {
                com.tencent.mm.plugin.aa.a.b.c vH = aod.vH(str);
                if (vH != null) {
                    com.tencent.mm.plugin.aa.a.b.d.gms.put(str, vH);
                    i = vH.field_status;
                } else {
                    i = -1;
                }
            }
            bVar2.status = i;
            AppMethodBeat.o(40586);
            return false;
        }
    };
    private com.tencent.mm.plugin.aa.a.b.d gkM;
    private com.tencent.mm.plugin.aa.a.b.b gkN;

    public b() {
        AppMethodBeat.i(40587);
        AppMethodBeat.o(40587);
    }

    private static b aoc() {
        AppMethodBeat.i(40588);
        b bVar = (b) q.Y(b.class);
        AppMethodBeat.o(40588);
        return bVar;
    }

    static {
        AppMethodBeat.i(40593);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.aa.a.b.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("AAPayRecord".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.aa.a.b.b.fnj;
            }
        });
        AppMethodBeat.o(40593);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public static com.tencent.mm.plugin.aa.a.b.d aod() {
        AppMethodBeat.i(40589);
        if (aoc().gkM == null) {
            b aoc = aoc();
            g.RQ();
            aoc.gkM = new com.tencent.mm.plugin.aa.a.b.d(g.RP().eJN);
        }
        com.tencent.mm.plugin.aa.a.b.d dVar = aoc().gkM;
        AppMethodBeat.o(40589);
        return dVar;
    }

    public static com.tencent.mm.plugin.aa.a.b.b aoe() {
        AppMethodBeat.i(40590);
        if (aoc().gkN == null) {
            b aoc = aoc();
            g.RQ();
            aoc.gkN = new com.tencent.mm.plugin.aa.a.b.b(g.RP().eJN);
        }
        com.tencent.mm.plugin.aa.a.b.b bVar = aoc().gkN;
        AppMethodBeat.o(40590);
        return bVar;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(40591);
        com.tencent.mm.sdk.b.a.xxA.c(this.gkG);
        com.tencent.mm.sdk.b.a.xxA.c(this.gkH);
        com.tencent.mm.sdk.b.a.xxA.c(this.gkI);
        com.tencent.mm.sdk.b.a.xxA.c(this.gkJ);
        com.tencent.mm.sdk.b.a.xxA.c(this.gkL);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.gkK);
        AppMethodBeat.o(40591);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(40592);
        com.tencent.mm.sdk.b.a.xxA.d(this.gkG);
        com.tencent.mm.sdk.b.a.xxA.d(this.gkH);
        com.tencent.mm.sdk.b.a.xxA.d(this.gkI);
        com.tencent.mm.sdk.b.a.xxA.d(this.gkJ);
        com.tencent.mm.sdk.b.a.xxA.d(this.gkL);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.gkK);
        AppMethodBeat.o(40592);
    }
}
