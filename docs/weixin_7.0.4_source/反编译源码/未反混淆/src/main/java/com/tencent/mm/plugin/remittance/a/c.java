package com.tencent.mm.plugin.remittance.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.remittance.b.b;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class c implements at {
    private static HashMap<Integer, d> eaA;
    private a foI = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(44426);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                int i;
                com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100324");
                if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
                    i = 1;
                } else {
                    i = 0;
                }
                z Ry = g.RP().Ry();
                Ry.set(ac.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i));
                ab.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", Integer.valueOf(i), Integer.valueOf(((Integer) Ry.get(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue()));
                if (((Integer) Ry.get(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                    com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                    Ry.set(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(1));
                    g.RP().Ry().set(ac.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
            }
            AppMethodBeat.o(44426);
        }
    };
    private bz.a luy = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(44427);
            ab.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
            cm cmVar = aVar.eAB;
            if (cmVar == null) {
                ab.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
                AppMethodBeat.o(44427);
                return;
            }
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
                AppMethodBeat.o(44427);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null) {
                ab.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
                AppMethodBeat.o(44427);
                return;
            }
            a = (String) z.get(".sysmsg.paymsg.PayMsgType");
            String str;
            if ("15".equals(a)) {
                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    ab.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    AppMethodBeat.o(44427);
                    return;
                }
                Map z2 = br.z(decode, "msg");
                if (z2 == null) {
                    ab.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    AppMethodBeat.o(44427);
                    return;
                }
                a = (String) z2.get(".msg.appmsg.wcpayinfo.transferid");
                if (bo.isNullOrNil(a)) {
                    ab.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
                    AppMethodBeat.o(44427);
                } else if (c.this.ceZ().VO(a)) {
                    ab.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
                    AppMethodBeat.o(44427);
                } else {
                    str = (String) z.get(".sysmsg.paymsg.tousername");
                    if (bo.isNullOrNil(decode) || bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                        AppMethodBeat.o(44427);
                        return;
                    }
                    c.this.ceZ().Z(a, decode, str);
                    AppMethodBeat.o(44427);
                }
            } else if ("22".equals(a)) {
                a = (String) z.get(".sysmsg.paymsg.tousername");
                str = (String) z.get(".sysmsg.paymsg.fromusername");
                try {
                    String decode2 = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (bo.isNullOrNil(decode2)) {
                        ab.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                        AppMethodBeat.o(44427);
                        return;
                    }
                    Map z3 = br.z(decode2, "msg");
                    if (z3 == null) {
                        ab.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                        AppMethodBeat.o(44427);
                        return;
                    }
                    String str2 = (String) z3.get(".msg.appmsg.wcpayinfo.transferid");
                    int i = bo.getInt((String) z3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                    ab.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", str, a, str2, Integer.valueOf(i));
                    com.tencent.mm.plugin.remittance.b.a aVar2 = null;
                    try {
                        c.ceW();
                        aVar2 = c.ceX().VM(str2);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                    }
                    if (aVar2 == null) {
                        ab.i("MicroMsg.SubCoreRemittance", "empty record");
                        AppMethodBeat.o(44427);
                        return;
                    }
                    bi jf = ((j) g.K(j.class)).bOr().jf(aVar2.field_msgId);
                    if (jf.field_msgId <= 0) {
                        ab.i("MicroMsg.SubCoreRemittance", "has delete msg");
                        c.ceW();
                        c.ceX().a((com.tencent.mm.sdk.e.c) aVar2, new String[0]);
                        AppMethodBeat.o(44427);
                        return;
                    }
                    ab.i("MicroMsg.SubCoreRemittance", "update msg: %s", Long.valueOf(jf.field_msgId));
                    jf.setContent(decode2);
                    ((j) g.K(j.class)).bOr().a(jf.field_msgId, jf);
                    com.tencent.mm.plugin.remittance.b.c VN = c.ceY().VN(str2);
                    if (VN != null) {
                        VN.field_receiveStatus = i;
                        c.ceY().a(VN);
                        AppMethodBeat.o(44427);
                        return;
                    }
                    if (!jf.field_talker.equals(r.Yz())) {
                        VN = new com.tencent.mm.plugin.remittance.b.c();
                        VN.field_locaMsgId = jf.field_msgId;
                        VN.field_transferId = str2;
                        VN.field_receiveStatus = i;
                        VN.field_isSend = false;
                        c.ceY().a(VN);
                    }
                    AppMethodBeat.o(44427);
                } catch (UnsupportedEncodingException e2) {
                    ab.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
                    AppMethodBeat.o(44427);
                }
            } else {
                if ("33".equals(a)) {
                    int i2 = bo.getInt((String) z.get(".sysmsg.paymsg.opentransferbankcard"), 0);
                    z Ry = g.RP().Ry();
                    Ry.set(ac.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i2));
                    ab.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", Integer.valueOf(i2), Integer.valueOf(((Integer) Ry.get(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue()));
                    if (((Integer) Ry.get(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                        Ry.set(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(1));
                        g.RP().Ry().set(ac.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                AppMethodBeat.o(44427);
            }
        }
    };
    private com.tencent.mm.plugin.remittance.model.aa pLl = null;
    public b pLm = null;
    private com.tencent.mm.plugin.remittance.b.d pLn = null;
    private com.tencent.mm.sdk.b.c<nm> pLo = new com.tencent.mm.sdk.b.c<nm>() {
        {
            AppMethodBeat.i(44428);
            this.xxI = nm.class.getName().hashCode();
            AppMethodBeat.o(44428);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44429);
            nm nmVar = (nm) bVar;
            ab.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", Long.valueOf(nmVar.cJL.cvx), nmVar.cJL.cEa);
            if (nmVar.cJL.cJM != null) {
                if (nmVar.cJL.cJM.fhv == 5) {
                    com.tencent.mm.plugin.remittance.b.a aVar = new com.tencent.mm.plugin.remittance.b.a();
                    aVar.field_msgId = nmVar.cJL.cvx;
                    aVar.field_transferId = nmVar.cJL.cEa;
                    c.ceW();
                    c.ceX().b((com.tencent.mm.sdk.e.c) aVar);
                }
                com.tencent.mm.plugin.remittance.b.c VN = c.ceY().VN(nmVar.cJL.cEa);
                if (VN != null) {
                    VN.field_receiveStatus = nmVar.cJL.cJM.fhv;
                    c.ceY().a(VN);
                } else if (!((j) g.K(j.class)).bOr().jf(nmVar.cJL.cvx).field_talker.equals(r.Yz())) {
                    VN = new com.tencent.mm.plugin.remittance.b.c();
                    VN.field_locaMsgId = nmVar.cJL.cvx;
                    VN.field_transferId = nmVar.cJL.cJM.fhy;
                    VN.field_receiveStatus = nmVar.cJL.cJM.fhv;
                    VN.field_isSend = false;
                    c.ceY().a(VN);
                }
            }
            AppMethodBeat.o(44429);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<vb> pLp = new com.tencent.mm.sdk.b.c<vb>() {
        {
            AppMethodBeat.i(44430);
            this.xxI = vb.class.getName().hashCode();
            AppMethodBeat.o(44430);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.remittance.b.c VN;
            AppMethodBeat.i(44431);
            vb vbVar = (vb) bVar;
            com.tencent.mm.plugin.remittance.b.d ceY = c.ceY();
            String str = vbVar.cRW.cEa;
            if (bo.isNullOrNil(str) || !com.tencent.mm.plugin.remittance.b.d.gms.containsKey(str)) {
                VN = ceY.VN(str);
                if (VN != null) {
                    com.tencent.mm.plugin.remittance.b.d.gms.put(str, VN);
                } else {
                    VN = null;
                }
            } else {
                VN = (com.tencent.mm.plugin.remittance.b.c) com.tencent.mm.plugin.remittance.b.d.gms.get(str);
            }
            if (VN != null) {
                vbVar.cRX.status = VN.field_receiveStatus;
                vbVar.cRX.cRY = VN.field_isSend;
            } else {
                vbVar.cRX.status = -2;
                vbVar.cRX.cRY = false;
            }
            AppMethodBeat.o(44431);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<ix> pLq = new com.tencent.mm.sdk.b.c<ix>() {
        {
            AppMethodBeat.i(44432);
            this.xxI = ix.class.getName().hashCode();
            AppMethodBeat.o(44432);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44433);
            ix ixVar = (ix) bVar;
            if (!(bo.isNullOrNil(ixVar.cDZ.username) || bo.isNullOrNil(ixVar.cDZ.cEa))) {
                Context context;
                com.tencent.mm.plugin.remittance.b.c VN = c.ceY().VN(ixVar.cDZ.cEa);
                ab.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, transferId: %s, username: %s", ixVar.cDZ.cEa, ixVar.cDZ.username);
                ab.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, isContact: %s", Boolean.valueOf(t.mY(ixVar.cDZ.username)));
                Context context2 = ixVar.cDZ.context;
                if (context2 == null) {
                    context = ah.getContext();
                } else {
                    context = context2;
                }
                if (!r3) {
                    c.ke(true);
                } else if (VN == null || VN.field_locaMsgId <= 0) {
                    ab.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, cannot find local msg");
                    c.ke(false);
                } else {
                    ab.i("MicroMsg.SubCoreRemittance", "handle JsApiOpenC2CTransferMsgViewEvent, localMsgId: %s", Long.valueOf(VN.field_locaMsgId));
                    if (((j) g.K(j.class)).bOr().jf(VN.field_locaMsgId).field_msgId <= 0) {
                        ab.i("MicroMsg.SubCoreRemittance", "cannot find msg in msg storage!");
                        c.ke(false);
                    } else {
                        com.tencent.mm.bp.d.f(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", ixVar.cDZ.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", VN.field_locaMsgId).putExtra("need_hight_item", true));
                    }
                }
            }
            AppMethodBeat.o(44433);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(44434);
        AppMethodBeat.o(44434);
    }

    static {
        AppMethodBeat.i(44442);
        com.tencent.mm.wallet_core.a.g("RemittanceProcess", a.class);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        eaA.put(Integer.valueOf("RemittanceRecord".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.remittance.b.d.fnj;
            }
        });
        AppMethodBeat.o(44442);
    }

    public static c ceW() {
        AppMethodBeat.i(44435);
        c cVar = (c) q.Y(c.class);
        AppMethodBeat.o(44435);
        return cVar;
    }

    public static b ceX() {
        AppMethodBeat.i(44436);
        if (ceW().pLm == null) {
            c ceW = ceW();
            g.RQ();
            ceW.pLm = new b(g.RP().eJN);
        }
        b bVar = ceW().pLm;
        AppMethodBeat.o(44436);
        return bVar;
    }

    public static com.tencent.mm.plugin.remittance.b.d ceY() {
        AppMethodBeat.i(44437);
        if (ceW().pLn == null) {
            c ceW = ceW();
            g.RQ();
            ceW.pLn = new com.tencent.mm.plugin.remittance.b.d(g.RP().eJN);
        }
        com.tencent.mm.plugin.remittance.b.d dVar = ceW().pLn;
        AppMethodBeat.o(44437);
        return dVar;
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(44438);
        if (this.pLl != null) {
            com.tencent.mm.plugin.remittance.model.aa aaVar = this.pLl;
            synchronized (aaVar.lock) {
                try {
                    aaVar.pQC = new HashSet();
                    aaVar.pQD.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(44438);
                    }
                }
            }
        }
        com.tencent.mm.model.c.c.abi().c(this.foI);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.luy, true);
        com.tencent.mm.sdk.b.a.xxA.b(this.pLo);
        com.tencent.mm.sdk.b.a.xxA.b(this.pLp);
        com.tencent.mm.sdk.b.a.xxA.b(this.pLq);
        AppMethodBeat.o(44438);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(44439);
        com.tencent.mm.model.c.c.abi().d(this.foI);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.luy, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.pLo);
        com.tencent.mm.sdk.b.a.xxA.d(this.pLp);
        com.tencent.mm.sdk.b.a.xxA.d(this.pLq);
        AppMethodBeat.o(44439);
    }

    public final com.tencent.mm.plugin.remittance.model.aa ceZ() {
        AppMethodBeat.i(44440);
        if (this.pLl == null) {
            this.pLl = new com.tencent.mm.plugin.remittance.model.aa();
        }
        com.tencent.mm.plugin.remittance.model.aa aaVar = this.pLl;
        AppMethodBeat.o(44440);
        return aaVar;
    }

    static /* synthetic */ void ke(boolean z) {
        AppMethodBeat.i(44441);
        new com.tencent.mm.ui.widget.a.e.a(ah.getContext()).asL(ah.getContext().getString(z ? R.string.dpa : R.string.dp_)).Qh(ah.getContext().getResources().getColor(R.color.a61)).Qg(R.string.cd_).b(new com.tencent.mm.ui.widget.a.e.c() {
            public final void d(boolean z, String str) {
            }
        }).show();
        AppMethodBeat.o(44441);
    }
}
