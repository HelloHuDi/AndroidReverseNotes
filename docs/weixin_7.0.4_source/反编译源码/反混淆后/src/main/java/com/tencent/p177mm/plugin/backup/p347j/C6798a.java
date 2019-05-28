package com.tencent.p177mm.plugin.backup.p347j;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26178kb;
import com.tencent.p177mm.p230g.p231a.C32509ab;
import com.tencent.p177mm.p230g.p231a.C37817y;
import com.tencent.p177mm.p230g.p231a.C9392ka;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p347j.C2657b.C26583;
import com.tencent.p177mm.plugin.backup.p347j.C2657b.C26591;
import com.tencent.p177mm.plugin.backup.p347j.C2657b.C26602;
import com.tencent.p177mm.plugin.p1014q.C28723b;
import com.tencent.p177mm.plugin.p1014q.C43397f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.backup.j.a */
public class C6798a implements C1816at {
    private static C6798a jCS;
    private C4884c jCT = new C67991();
    private C4884c jCU = new C68002();
    private C4884c jCV = new C68033();
    private C4884c jCW = new C68064();
    private C1837a jCX = new C68055();
    private C1837a jCY = new C68016();

    /* renamed from: com.tencent.mm.plugin.backup.j.a$1 */
    class C67991 extends C4884c<C32509ab> {
        C67991() {
            AppMethodBeat.m2504i(18085);
            this.xxI = C32509ab.class.getName().hashCode();
            AppMethodBeat.m2505o(18085);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18086);
            C32509ab c32509ab = (C32509ab) c4883b;
            if (c32509ab != null && (c32509ab instanceof C32509ab)) {
                Context context = (Context) c32509ab.csW.csX;
                C33710c.m55092rK(-1).mo61481m(context);
                C4990ab.m7416i("MicroMsg.BackupCore", "receive BackupUSBStopActionEvent.");
            }
            AppMethodBeat.m2505o(18086);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.a$2 */
    class C68002 extends C4884c<C37817y> {
        C68002() {
            AppMethodBeat.m2504i(18087);
            this.xxI = C37817y.class.getName().hashCode();
            AppMethodBeat.m2505o(18087);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18088);
            C37817y c37817y = (C37817y) c4883b;
            if (c37817y != null && (c37817y instanceof C37817y)) {
                C4990ab.m7416i("MicroMsg.BackupCore", "receive BackupGetA8keyRedirectEvent.");
                String str = c37817y.csT.url;
                C33710c.m55092rK(2).mo61481m(str);
            }
            AppMethodBeat.m2505o(18088);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.a$6 */
    class C68016 implements C1837a {
        C68016() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            final String str;
            AppMethodBeat.m2504i(18096);
            C4990ab.m7416i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
            Map z = C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "appmsg");
            C4990ab.m7411d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", str);
            if (((String) z.get(".appmsg.action")).equals("phone")) {
                C4990ab.m7416i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
                AppMethodBeat.m2505o(18096);
                return;
            }
            str = (String) z.get(".appmsg.messageaction");
            final String str2 = (String) z.get(".appmsg.extinfo");
            final byte[] bytes = ((String) z.get(".appmsg.appattach.aeskey")).getBytes();
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18095);
                    C4990ab.m7416i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
                    C43397f.m77451jf(false).mo68952e(str, str2, bytes);
                    AppMethodBeat.m2505o(18095);
                }
            });
            AppMethodBeat.m2505o(18096);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.a$3 */
    class C68033 extends C4884c<C26178kb> {
        C68033() {
            AppMethodBeat.m2504i(18090);
            this.xxI = C26178kb.class.getName().hashCode();
            AppMethodBeat.m2505o(18090);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18091);
            final C26178kb c26178kb = (C26178kb) c4883b;
            if (!(c26178kb == null || !(c26178kb instanceof C26178kb) || c26178kb.cFs == null)) {
                C4990ab.m7416i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent.");
                C9638aw.m17180RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(18089);
                        C26178kb c26178kb = c26178kb;
                        C4990ab.m7417i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", Boolean.valueOf(c26178kb.cFs.cFv));
                        if (c26178kb.cFs.cFv) {
                            C7060h.pYm.mo8378a(466, 13, 1, false);
                            AppMethodBeat.m2505o(18089);
                            return;
                        }
                        byte[] bArr = c26178kb.cFs.cFt;
                        if (bArr == null) {
                            C4990ab.m7412e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
                            C7060h.pYm.mo8378a(466, 14, 1, false);
                            AppMethodBeat.m2505o(18089);
                            return;
                        }
                        int i = c26178kb.cFs.cFu;
                        C43397f jf = C43397f.m77451jf(true);
                        jf.cFu = i;
                        jf.mo68952e(C28723b.oFb, "", bArr);
                        AppMethodBeat.m2505o(18089);
                    }
                });
            }
            AppMethodBeat.m2505o(18091);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.a$5 */
    class C68055 implements C1837a {
        C68055() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(18094);
            C4990ab.m7416i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
            C7060h.pYm.mo8378a(400, 0, 1, false);
            String str = (String) C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
                AppMethodBeat.m2505o(18094);
                return;
            }
            Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
            Intent I = C5046bo.m7503I(C4996ah.getContext(), className);
            if (I == null) {
                I = className;
            }
            C25985d.m41463aH(I.putExtra("url", str).putExtra("isFromWifi", true));
            AppMethodBeat.m2505o(18094);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.j.a$4 */
    class C68064 extends C4884c<C9392ka> {
        C68064() {
            AppMethodBeat.m2504i(18092);
            this.xxI = C9392ka.class.getName().hashCode();
            AppMethodBeat.m2505o(18092);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18093);
            C9392ka c9392ka = (C9392ka) c4883b;
            if (c9392ka != null && (c9392ka instanceof C9392ka)) {
                C4990ab.m7416i("MicroMsg.BackupCore", "receive MsgSynchronizeABTestEvent.");
                C28723b.bQV();
                c9392ka.cFo.cFp = C28723b.oFe;
                c9392ka.cFo.cFq = C28723b.oFf;
                c9392ka.cFo.cFr = C28723b.oFg;
            }
            AppMethodBeat.m2505o(18093);
            return false;
        }
    }

    public C6798a() {
        AppMethodBeat.m2504i(18097);
        C4990ab.m7416i("MicroMsg.BackupCore", "BackupCore init");
        AppMethodBeat.m2505o(18097);
    }

    public static void reset() {
        AppMethodBeat.m2504i(18098);
        if (C38634d.aSB()) {
            AppMethodBeat.m2505o(18098);
            return;
        }
        jCS = null;
        C33660a.aSo();
        C38634d.aSC();
        AppMethodBeat.m2505o(18098);
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
        AppMethodBeat.m2504i(18099);
        C2657b aVg = C2657b.aVg();
        C4990ab.m7416i("MicroMsg.BackupEventListener", "init addListener");
        aVg.jDe = new C26591();
        C4879a.xxA.mo10052c(aVg.jDe);
        aVg.jDf = new C26602();
        C4879a.xxA.mo10052c(aVg.jDf);
        aVg.gRa = new C26583();
        C4879a.xxA.mo10052c(aVg.gRa);
        C9638aw.getSysCmdMsgExtension().mo14900a("MMBakChatNotify", this.jCX, true);
        C9638aw.getSysCmdMsgExtension().mo14900a("ChatSync", this.jCY, true);
        C4879a.xxA.mo10051b(this.jCT);
        C4879a.xxA.mo10051b(this.jCU);
        C4879a.xxA.mo10051b(this.jCV);
        C4879a.xxA.mo10051b(this.jCW);
        AppMethodBeat.m2505o(18099);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(18100);
        C2657b aVg = C2657b.aVg();
        C4879a.xxA.mo10053d(aVg.jDe);
        C4879a.xxA.mo10053d(aVg.jDf);
        C4879a.xxA.mo10053d(aVg.gRa);
        C9638aw.getSysCmdMsgExtension().mo14903b("MMBakChatNotify", this.jCX, true);
        C9638aw.getSysCmdMsgExtension().mo14903b("ChatSync", this.jCY, true);
        C4879a.xxA.mo10053d(this.jCT);
        C4879a.xxA.mo10053d(this.jCU);
        C4879a.xxA.mo10053d(this.jCV);
        C4879a.xxA.mo10053d(this.jCW);
        AppMethodBeat.m2505o(18100);
    }
}
