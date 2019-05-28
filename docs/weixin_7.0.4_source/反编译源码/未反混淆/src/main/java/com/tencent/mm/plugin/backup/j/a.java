package com.tencent.mm.plugin.backup.j;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.z;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a;
import com.tencent.mm.plugin.q.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;

public class a implements at {
    private static a jCS;
    private c jCT = new c<ab>() {
        {
            AppMethodBeat.i(18085);
            this.xxI = ab.class.getName().hashCode();
            AppMethodBeat.o(18085);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(18086);
            ab abVar = (ab) bVar;
            if (abVar != null && (abVar instanceof ab)) {
                Context context = (Context) abVar.csW.csX;
                c.rK(-1).m(context);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore", "receive BackupUSBStopActionEvent.");
            }
            AppMethodBeat.o(18086);
            return false;
        }
    };
    private c jCU = new c<y>() {
        {
            AppMethodBeat.i(18087);
            this.xxI = y.class.getName().hashCode();
            AppMethodBeat.o(18087);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(18088);
            y yVar = (y) bVar;
            if (yVar != null && (yVar instanceof y)) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore", "receive BackupGetA8keyRedirectEvent.");
                String str = yVar.csT.url;
                c.rK(2).m(str);
            }
            AppMethodBeat.o(18088);
            return false;
        }
    };
    private c jCV = new c<kb>() {
        {
            AppMethodBeat.i(18090);
            this.xxI = kb.class.getName().hashCode();
            AppMethodBeat.o(18090);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(18091);
            final kb kbVar = (kb) bVar;
            if (!(kbVar == null || !(kbVar instanceof kb) || kbVar.cFs == null)) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent.");
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18089);
                        kb kbVar = kbVar;
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", Boolean.valueOf(kbVar.cFs.cFv));
                        if (kbVar.cFs.cFv) {
                            h.pYm.a(466, 13, 1, false);
                            AppMethodBeat.o(18089);
                            return;
                        }
                        byte[] bArr = kbVar.cFs.cFt;
                        if (bArr == null) {
                            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
                            h.pYm.a(466, 14, 1, false);
                            AppMethodBeat.o(18089);
                            return;
                        }
                        int i = kbVar.cFs.cFu;
                        f jf = f.jf(true);
                        jf.cFu = i;
                        jf.e(com.tencent.mm.plugin.q.b.oFb, "", bArr);
                        AppMethodBeat.o(18089);
                    }
                });
            }
            AppMethodBeat.o(18091);
            return false;
        }
    };
    private c jCW = new c<ka>() {
        {
            AppMethodBeat.i(18092);
            this.xxI = ka.class.getName().hashCode();
            AppMethodBeat.o(18092);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(18093);
            ka kaVar = (ka) bVar;
            if (kaVar != null && (kaVar instanceof ka)) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore", "receive MsgSynchronizeABTestEvent.");
                com.tencent.mm.plugin.q.b.bQV();
                kaVar.cFo.cFp = com.tencent.mm.plugin.q.b.oFe;
                kaVar.cFo.cFq = com.tencent.mm.plugin.q.b.oFf;
                kaVar.cFo.cFr = com.tencent.mm.plugin.q.b.oFg;
            }
            AppMethodBeat.o(18093);
            return false;
        }
    };
    private com.tencent.mm.model.bz.a jCX = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(18094);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
            h.pYm.a(400, 0, 1, false);
            String str = (String) br.z(aa.a(aVar.eAB.vED), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
            if (bo.isNullOrNil(str)) {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
                AppMethodBeat.o(18094);
                return;
            }
            Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
            Intent I = bo.I(ah.getContext(), className);
            if (I == null) {
                I = className;
            }
            d.aH(I.putExtra("url", str).putExtra("isFromWifi", true));
            AppMethodBeat.o(18094);
        }
    };
    private com.tencent.mm.model.bz.a jCY = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            final String str;
            AppMethodBeat.i(18096);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
            Map z = br.z(aa.a(aVar.eAB.vED), "appmsg");
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", str);
            if (((String) z.get(".appmsg.action")).equals("phone")) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
                AppMethodBeat.o(18096);
                return;
            }
            str = (String) z.get(".appmsg.messageaction");
            final String str2 = (String) z.get(".appmsg.extinfo");
            final byte[] bytes = ((String) z.get(".appmsg.appattach.aeskey")).getBytes();
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18095);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
                    f.jf(false).e(str, str2, bytes);
                    AppMethodBeat.o(18095);
                }
            });
            AppMethodBeat.o(18096);
        }
    };

    public a() {
        AppMethodBeat.i(18097);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupCore", "BackupCore init");
        AppMethodBeat.o(18097);
    }

    public static void reset() {
        AppMethodBeat.i(18098);
        if (com.tencent.mm.plugin.backup.b.d.aSB()) {
            AppMethodBeat.o(18098);
            return;
        }
        jCS = null;
        com.tencent.mm.plugin.backup.b.a.aSo();
        com.tencent.mm.plugin.backup.b.d.aSC();
        AppMethodBeat.o(18098);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(18099);
        b aVg = b.aVg();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupEventListener", "init addListener");
        aVg.jDe = new c<x>() {
            {
                AppMethodBeat.i(18101);
                this.xxI = x.class.getName().hashCode();
                AppMethodBeat.o(18101);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(18102);
                a.reset();
                AppMethodBeat.o(18102);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(aVg.jDe);
        aVg.jDf = new c<z>() {
            {
                AppMethodBeat.i(18103);
                this.xxI = z.class.getName().hashCode();
                AppMethodBeat.o(18103);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(18104);
                boolean z = ((z) bVar).csU.csV;
                c.rK(1).m(Boolean.valueOf(z));
                AppMethodBeat.o(18104);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(aVg.jDf);
        aVg.gRa = new c<ae>() {
            {
                AppMethodBeat.i(18105);
                this.xxI = ae.class.getName().hashCode();
                AppMethodBeat.o(18105);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(18106);
                ae aeVar = (ae) bVar;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupEventListener", "receive BannerOnInitEvent.");
                af afVar = new af();
                afVar.csZ.ctb = new a(aeVar.csY.activity);
                afVar.csZ.cta = false;
                com.tencent.mm.sdk.b.a.xxA.m(afVar);
                afVar = new af();
                afVar.csZ.ctb = new com.tencent.mm.plugin.backup.backupui.a(aeVar.csY.activity);
                afVar.csZ.cta = false;
                com.tencent.mm.sdk.b.a.xxA.m(afVar);
                AppMethodBeat.o(18106);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(aVg.gRa);
        aw.getSysCmdMsgExtension().a("MMBakChatNotify", this.jCX, true);
        aw.getSysCmdMsgExtension().a("ChatSync", this.jCY, true);
        com.tencent.mm.sdk.b.a.xxA.b(this.jCT);
        com.tencent.mm.sdk.b.a.xxA.b(this.jCU);
        com.tencent.mm.sdk.b.a.xxA.b(this.jCV);
        com.tencent.mm.sdk.b.a.xxA.b(this.jCW);
        AppMethodBeat.o(18099);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(18100);
        b aVg = b.aVg();
        com.tencent.mm.sdk.b.a.xxA.d(aVg.jDe);
        com.tencent.mm.sdk.b.a.xxA.d(aVg.jDf);
        com.tencent.mm.sdk.b.a.xxA.d(aVg.gRa);
        aw.getSysCmdMsgExtension().b("MMBakChatNotify", this.jCX, true);
        aw.getSysCmdMsgExtension().b("ChatSync", this.jCY, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.jCT);
        com.tencent.mm.sdk.b.a.xxA.d(this.jCU);
        com.tencent.mm.sdk.b.a.xxA.d(this.jCV);
        com.tencent.mm.sdk.b.a.xxA.d(this.jCW);
        AppMethodBeat.o(18100);
    }
}
