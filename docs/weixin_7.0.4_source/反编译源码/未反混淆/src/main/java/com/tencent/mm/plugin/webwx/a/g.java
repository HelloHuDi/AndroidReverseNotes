package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import java.util.HashMap;

public final class g implements at {
    private a jCX = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(26508);
            String str = (String) br.z(aa.a(aVar.eAB.vED), "sysmsg").get(".sysmsg.pushloginurl.url");
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
            }
            pt ptVar = new pt();
            ptVar.cLX.cLY = str;
            ptVar.cLX.type = 1;
            com.tencent.mm.sdk.b.a.xxA.m(ptVar);
            aVar.eAB.vEH = null;
            AppMethodBeat.o(26508);
        }
    };
    private f uLf = new f();
    private a uLg;
    private as uLh = new as() {
        public final void ZB() {
            AppMethodBeat.i(26509);
            aw.ZK();
            if (c.XI()) {
                g.ddg();
            }
            AppMethodBeat.o(26509);
        }
    };
    private com.tencent.mm.sdk.b.c uLi = new com.tencent.mm.sdk.b.c<pt>() {
        {
            AppMethodBeat.i(26511);
            this.xxI = pt.class.getName().hashCode();
            AppMethodBeat.o(26511);
        }

        private boolean a(final pt ptVar) {
            AppMethodBeat.i(26512);
            if (ptVar != null && (ptVar instanceof pt)) {
                final m dVar = new d(ptVar.cLX.cLY);
                aw.Rg().a(971, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        Intent intent;
                        CharSequence charSequence;
                        Object charSequence2;
                        Intent intent2;
                        AppMethodBeat.i(26510);
                        aw.Rg().b(971, (f) this);
                        zn znVar = (zn) dVar.fAT.fsH.fsP;
                        ab.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            if (znVar.weL != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", ptVar.cLX.cLY);
                                intent.putExtra("intent.key.type", 0);
                                intent.putExtra("intent.key.icon.type", znVar.weL.weH);
                                intent.putExtra("intent.key.ok.string", znVar.weL.weV);
                                intent.putExtra("intent.key.cancel.string", znVar.weL.weW);
                                intent.putExtra("intent.key.title.string", znVar.weL.weI);
                                intent.putExtra("intent.key.content.string", znVar.weL.wfa);
                                intent.putExtra("intent.key.login.client.version", znVar.weP);
                                intent.putExtra("intent.key.function.control", znVar.weQ);
                                String str2 = znVar.weL.weI;
                                StringBuilder stringBuilder = new StringBuilder();
                                Cursor cursor = null;
                                try {
                                    aw.ZK();
                                    cursor = c.XR().a(t.fkP, null, com.tencent.mm.o.a.ewS, true);
                                    if (cursor != null) {
                                        int count;
                                        if (cursor.getCount() < znVar.weL.weX) {
                                            count = cursor.getCount();
                                        } else {
                                            count = znVar.weL.weX;
                                        }
                                        int columnIndex = cursor.getColumnIndex("username");
                                        for (int i3 = 0; i3 < count; i3++) {
                                            if (cursor.moveToPosition(i3)) {
                                                stringBuilder.append(cursor.getString(columnIndex));
                                                if (i3 < count - 1) {
                                                    stringBuilder.append(",");
                                                }
                                            }
                                        }
                                    }
                                    intent.putExtra("intent.key.ok.session.list", stringBuilder.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence2 = str2;
                                    }
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence2 = str2;
                                    }
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    AppMethodBeat.o(26510);
                                }
                                charSequence2 = str2;
                            }
                            charSequence2 = null;
                            intent = null;
                        } else if (i2 == -1) {
                            if (znVar.weM != null) {
                                intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", ptVar.cLX.cLY);
                                intent2.putExtra("intent.key.type", -1);
                                intent2.putExtra("intent.key.title.string", znVar.weM.weJ);
                                intent2.putExtra("intent.key.icon.type", znVar.weM.weH);
                                intent2.putExtra("intent.key.ok.string", znVar.weM.weK);
                                intent2.putExtra("intent.key.content.string", znVar.weM.weI);
                                charSequence2 = znVar.weM.weI;
                                intent = intent2;
                            }
                            charSequence2 = null;
                            intent = null;
                        } else {
                            if (i2 == -2 && znVar.weN != null) {
                                intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", ptVar.cLX.cLY);
                                intent2.putExtra("intent.key.type", -2);
                                intent2.putExtra("intent.key.title.string", znVar.weN.weJ);
                                intent2.putExtra("intent.key.icon.type", znVar.weN.weH);
                                intent2.putExtra("intent.key.ok.string", znVar.weN.weK);
                                intent2.putExtra("intent.key.content.string", znVar.weN.weI);
                                charSequence2 = znVar.weN.weI;
                                intent = intent2;
                            }
                            charSequence2 = null;
                            intent = null;
                        }
                        if (intent != null) {
                            intent.setFlags(268435456);
                            intent.setClass(ah.getContext(), ExtDeviceWXLoginUI.class);
                            ah.getContext().startActivity(intent);
                            intent2 = new Intent(intent);
                            intent2.setFlags(67108864);
                            if (ptVar.cLX.type == 1) {
                                PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 0, intent2, 134217728);
                                v.c e2 = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(ah.getContext().getString(R.string.ru)).e(charSequence2);
                                e2.EI = activity;
                                Notification build = e2.build();
                                build.icon = com.tencent.mm.bo.a.bWV();
                                build.flags |= 16;
                                build.sound = RingtoneManager.getDefaultUri(2);
                                aw.getNotification().notify(38, build);
                            }
                        }
                        AppMethodBeat.o(26510);
                    }
                });
                aw.Rg().a(dVar, 0);
            }
            AppMethodBeat.o(26512);
            return false;
        }
    };
    private s uLj = new s<cm>() {
        public final /* synthetic */ void e(com.tencent.mm.bt.a aVar) {
            AppMethodBeat.i(26514);
            cm cmVar = (cm) aVar;
            if (cmVar.nao == 51 || !r.Yz().equals(cmVar.vEB.wVI)) {
                AppMethodBeat.o(26514);
                return;
            }
            aw.ZK();
            bi Q = c.XO().Q(cmVar.vEC.wVI, cmVar.ptF);
            if (Q.field_msgSvrId == 0) {
                ab.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(cmVar.ptF));
                AppMethodBeat.o(26514);
                return;
            }
            ab.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] selfSend msg, svrID:%d, localId:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
            g.ddf().ddh().lU(Q.field_msgId);
            AppMethodBeat.o(26514);
        }

        public final /* bridge */ /* synthetic */ void f(com.tencent.mm.bt.a aVar) {
        }
    };

    public g() {
        AppMethodBeat.i(26515);
        AppMethodBeat.o(26515);
    }

    public static g ddf() {
        AppMethodBeat.i(26516);
        aw.ZE();
        g gVar = (g) bw.oJ("plugin.webwx");
        if (gVar == null) {
            gVar = new g();
            aw.ZE().a("plugin.webwx", gVar);
        }
        AppMethodBeat.o(26516);
        return gVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(26517);
        d.b(Integer.valueOf(51), this.uLf);
        aw.getSysCmdMsgExtension().b("pushloginurl", this.jCX, true);
        aw.ZK();
        c.b(this.uLh);
        com.tencent.mm.sdk.b.a.xxA.d(this.uLi);
        ddg();
        if (this.uLg != null) {
            f fVar = this.uLg;
            o.all().a(fVar);
            com.tencent.mm.kernel.g.Rg().b(221, fVar);
        }
        u.a(this.uLj);
        AppMethodBeat.o(26517);
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(26518);
        d.a(Integer.valueOf(51), this.uLf);
        aw.getSysCmdMsgExtension().a("pushloginurl", this.jCX, true);
        aw.ZK();
        c.a(this.uLh);
        com.tencent.mm.sdk.b.a.xxA.c(this.uLi);
        this.uLg = null;
        u.a(5, this.uLj);
        AppMethodBeat.o(26518);
    }

    public final void bA(boolean z) {
    }

    static void ddg() {
        AppMethodBeat.i(26519);
        aw.getNotification().cancel(38);
        AppMethodBeat.o(26519);
    }

    public final a ddh() {
        AppMethodBeat.i(26520);
        com.tencent.mm.kernel.g.RN().QU();
        if (this.uLg == null) {
            this.uLg = new a();
        }
        a aVar = this.uLg;
        AppMethodBeat.o(26520);
        return aVar;
    }
}
