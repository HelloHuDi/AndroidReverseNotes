package com.tencent.p177mm.plugin.webwx.p1071a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C45359pt;
import com.tencent.p177mm.p761o.C7487a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28495s;
import com.tencent.p177mm.plugin.webwx.p582ui.ExtDeviceWXLoginUI;
import com.tencent.p177mm.protocal.protobuf.C35970zn;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webwx.a.g */
public final class C23163g implements C1816at {
    private C1837a jCX = new C147081();
    private C23162f uLf = new C23162f();
    private C46448a uLg;
    private C1815as uLh = new C147092();
    private C4884c uLi = new C231643();
    private C28495s uLj = new C231664();

    /* renamed from: com.tencent.mm.plugin.webwx.a.g$1 */
    class C147081 implements C1837a {
        C147081() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(26508);
            String str = (String) C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "sysmsg").get(".sysmsg.pushloginurl.url");
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
            }
            C45359pt c45359pt = new C45359pt();
            c45359pt.cLX.cLY = str;
            c45359pt.cLX.type = 1;
            C4879a.xxA.mo10055m(c45359pt);
            c1197a.eAB.vEH = null;
            AppMethodBeat.m2505o(26508);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.a.g$2 */
    class C147092 implements C1815as {
        C147092() {
        }

        /* renamed from: ZB */
        public final void mo5390ZB() {
            AppMethodBeat.m2504i(26509);
            C9638aw.m17190ZK();
            if (C18628c.m29074XI()) {
                C23163g.ddg();
            }
            AppMethodBeat.m2505o(26509);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.a.g$3 */
    class C231643 extends C4884c<C45359pt> {
        C231643() {
            AppMethodBeat.m2504i(26511);
            this.xxI = C45359pt.class.getName().hashCode();
            AppMethodBeat.m2505o(26511);
        }

        /* renamed from: a */
        private boolean m35544a(final C45359pt c45359pt) {
            AppMethodBeat.m2504i(26512);
            if (c45359pt != null && (c45359pt instanceof C45359pt)) {
                final C1207m c43993d = new C43993d(c45359pt.cLX.cLY);
                C9638aw.m17182Rg().mo14539a(971, new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        Intent intent;
                        CharSequence charSequence;
                        Object charSequence2;
                        Intent intent2;
                        AppMethodBeat.m2504i(26510);
                        C9638aw.m17182Rg().mo14546b(971, (C1202f) this);
                        C35970zn c35970zn = (C35970zn) c43993d.fAT.fsH.fsP;
                        C4990ab.m7411d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            if (c35970zn.weL != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", c45359pt.cLX.cLY);
                                intent.putExtra("intent.key.type", 0);
                                intent.putExtra("intent.key.icon.type", c35970zn.weL.weH);
                                intent.putExtra("intent.key.ok.string", c35970zn.weL.weV);
                                intent.putExtra("intent.key.cancel.string", c35970zn.weL.weW);
                                intent.putExtra("intent.key.title.string", c35970zn.weL.weI);
                                intent.putExtra("intent.key.content.string", c35970zn.weL.wfa);
                                intent.putExtra("intent.key.login.client.version", c35970zn.weP);
                                intent.putExtra("intent.key.function.control", c35970zn.weQ);
                                String str2 = c35970zn.weL.weI;
                                StringBuilder stringBuilder = new StringBuilder();
                                Cursor cursor = null;
                                try {
                                    C9638aw.m17190ZK();
                                    cursor = C18628c.m29083XR().mo15769a(C1855t.fkP, null, C7487a.ewS, true);
                                    if (cursor != null) {
                                        int count;
                                        if (cursor.getCount() < c35970zn.weL.weX) {
                                            count = cursor.getCount();
                                        } else {
                                            count = c35970zn.weL.weX;
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
                                    C4990ab.printErrStackTrace("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence2 = str2;
                                    }
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    AppMethodBeat.m2505o(26510);
                                }
                                charSequence2 = str2;
                            }
                            charSequence2 = null;
                            intent = null;
                        } else if (i2 == -1) {
                            if (c35970zn.weM != null) {
                                intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", c45359pt.cLX.cLY);
                                intent2.putExtra("intent.key.type", -1);
                                intent2.putExtra("intent.key.title.string", c35970zn.weM.weJ);
                                intent2.putExtra("intent.key.icon.type", c35970zn.weM.weH);
                                intent2.putExtra("intent.key.ok.string", c35970zn.weM.weK);
                                intent2.putExtra("intent.key.content.string", c35970zn.weM.weI);
                                charSequence2 = c35970zn.weM.weI;
                                intent = intent2;
                            }
                            charSequence2 = null;
                            intent = null;
                        } else {
                            if (i2 == -2 && c35970zn.weN != null) {
                                intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", c45359pt.cLX.cLY);
                                intent2.putExtra("intent.key.type", -2);
                                intent2.putExtra("intent.key.title.string", c35970zn.weN.weJ);
                                intent2.putExtra("intent.key.icon.type", c35970zn.weN.weH);
                                intent2.putExtra("intent.key.ok.string", c35970zn.weN.weK);
                                intent2.putExtra("intent.key.content.string", c35970zn.weN.weI);
                                charSequence2 = c35970zn.weN.weI;
                                intent = intent2;
                            }
                            charSequence2 = null;
                            intent = null;
                        }
                        if (intent != null) {
                            intent.setFlags(268435456);
                            intent.setClass(C4996ah.getContext(), ExtDeviceWXLoginUI.class);
                            C4996ah.getContext().startActivity(intent);
                            intent2 = new Intent(intent);
                            intent2.setFlags(67108864);
                            if (c45359pt.cLX.type == 1) {
                                PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 0, intent2, 134217728);
                                C0358c e2 = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(C4996ah.getContext().getString(C25738R.string.f9176ru)).mo623e(charSequence2);
                                e2.f362EI = activity;
                                Notification build = e2.build();
                                build.icon = C45186a.bWV();
                                build.flags |= 16;
                                build.sound = RingtoneManager.getDefaultUri(2);
                                C9638aw.getNotification().notify(38, build);
                            }
                        }
                        AppMethodBeat.m2505o(26510);
                    }
                });
                C9638aw.m17182Rg().mo14541a(c43993d, 0);
            }
            AppMethodBeat.m2505o(26512);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.a.g$4 */
    class C231664 implements C28495s<C7254cm> {
        C231664() {
        }

        /* renamed from: e */
        public final /* synthetic */ void mo35243e(C1331a c1331a) {
            AppMethodBeat.m2504i(26514);
            C7254cm c7254cm = (C7254cm) c1331a;
            if (c7254cm.nao == 51 || !C1853r.m3846Yz().equals(c7254cm.vEB.wVI)) {
                AppMethodBeat.m2505o(26514);
                return;
            }
            C9638aw.m17190ZK();
            C7620bi Q = C18628c.m29080XO().mo15241Q(c7254cm.vEC.wVI, c7254cm.ptF);
            if (Q.field_msgSvrId == 0) {
                C4990ab.m7417i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(c7254cm.ptF));
                AppMethodBeat.m2505o(26514);
                return;
            }
            C4990ab.m7417i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] selfSend msg, svrID:%d, localId:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
            C23163g.ddf().ddh().mo74667lU(Q.field_msgId);
            AppMethodBeat.m2505o(26514);
        }

        /* renamed from: f */
        public final /* bridge */ /* synthetic */ void mo35244f(C1331a c1331a) {
        }
    }

    public C23163g() {
        AppMethodBeat.m2504i(26515);
        AppMethodBeat.m2505o(26515);
    }

    public static C23163g ddf() {
        AppMethodBeat.m2504i(26516);
        C9638aw.m17184ZE();
        C23163g c23163g = (C23163g) C45439bw.m83697oJ("plugin.webwx");
        if (c23163g == null) {
            c23163g = new C23163g();
            C9638aw.m17184ZE().mo73244a("plugin.webwx", c23163g);
        }
        AppMethodBeat.m2505o(26516);
        return c23163g;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(26517);
        C1200d.m2637b(Integer.valueOf(51), this.uLf);
        C9638aw.getSysCmdMsgExtension().mo14903b("pushloginurl", this.jCX, true);
        C9638aw.m17190ZK();
        C18628c.m29104b(this.uLh);
        C4879a.xxA.mo10053d(this.uLi);
        C23163g.ddg();
        if (this.uLg != null) {
            C1202f c1202f = this.uLg;
            C37961o.all().mo21052a(c1202f);
            C1720g.m3540Rg().mo14546b(221, c1202f);
        }
        C21281u.m32652a(this.uLj);
        AppMethodBeat.m2505o(26517);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(26518);
        C1200d.m2636a(Integer.valueOf(51), this.uLf);
        C9638aw.getSysCmdMsgExtension().mo14900a("pushloginurl", this.jCX, true);
        C9638aw.m17190ZK();
        C18628c.m29103a(this.uLh);
        C4879a.xxA.mo10052c(this.uLi);
        this.uLg = null;
        C21281u.m32651a(5, this.uLj);
        AppMethodBeat.m2505o(26518);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    static void ddg() {
        AppMethodBeat.m2504i(26519);
        C9638aw.getNotification().cancel(38);
        AppMethodBeat.m2505o(26519);
    }

    public final C46448a ddh() {
        AppMethodBeat.m2504i(26520);
        C1720g.m3534RN().mo5159QU();
        if (this.uLg == null) {
            this.uLg = new C46448a();
        }
        C46448a c46448a = this.uLg;
        AppMethodBeat.m2505o(26520);
        return c46448a;
    }
}
