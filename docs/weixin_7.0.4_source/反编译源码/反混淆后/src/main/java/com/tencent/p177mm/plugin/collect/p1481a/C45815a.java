package com.tencent.p177mm.plugin.collect.p1481a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C37696bx;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.collect.model.C11424u;
import com.tencent.p177mm.plugin.collect.model.C27676d;
import com.tencent.p177mm.plugin.collect.model.C27676d.C27677a;
import com.tencent.p177mm.plugin.collect.model.C27680t;
import com.tencent.p177mm.plugin.collect.model.C33858g;
import com.tencent.p177mm.plugin.collect.model.C33860o;
import com.tencent.p177mm.plugin.collect.model.voice.C45818a;
import com.tencent.p177mm.plugin.collect.model.voice.C45818a.C27681b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.bci;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.collect.a.a */
public class C45815a implements C1816at {
    public boolean kBA = false;
    private C4884c<C6504k> kBB = new C338533();
    private C1837a kBx = new C338511();
    private C33858g kBy = new C33858g();
    private C11424u kBz = new C11424u();

    /* renamed from: com.tencent.mm.plugin.collect.a.a$1 */
    class C338511 implements C1837a {
        C338511() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(40906);
            C45815a.bgv();
            if (C45815a.bgw() != null) {
                String a = C1946aa.m4148a(c1197a.eAB.vED);
                C45815a.bgv();
                C27676d bgw = C45815a.bgw();
                long j = (long) c1197a.eAB.pcX;
                C4990ab.m7418v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(a)));
                if (C5046bo.isNullOrNil(a)) {
                    C4990ab.m7410d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                    AppMethodBeat.m2505o(40906);
                    return;
                }
                Map z = C5049br.m7595z(a, "sysmsg");
                int i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), 0);
                if (i == 9 || i == 26) {
                    C27680t c27680t = new C27680t();
                    c27680t.username = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.username"));
                    c27680t.kCJ = C5046bo.getDouble((String) z.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                    c27680t.cuZ = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.feetype"));
                    c27680t.timestamp = C5046bo.getInt((String) z.get(".sysmsg.paymsgtimestamp"), (int) C5046bo.anT());
                    c27680t.cAa = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.transid"));
                    c27680t.eoz = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.displayname"));
                    c27680t.scene = C5046bo.getInt((String) z.get(".sysmsg.paymsg.scene"), 1);
                    c27680t.status = C5046bo.getInt((String) z.get(".sysmsg.paymsg.status"), 0);
                    c27680t.msgType = i;
                    c27680t.kCK = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.outtradeno"));
                    c27680t.type = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.type"));
                    String nullAsNil = C5046bo.nullAsNil((String) z.get(".sysmsg.paymsg.voice_content"));
                    for (C27677a c27677a : bgw.kaD) {
                        if (c27677a != null) {
                            c27677a.mo45523a(c27680t);
                        }
                    }
                    if (c27680t.status == 1) {
                        C37696bx c37696bx = new C37696bx();
                        c37696bx.cuX.cuY = (int) Math.round(c27680t.kCJ * 100.0d);
                        c37696bx.cuX.cuZ = c27680t.cuZ;
                        c37696bx.cuX.cvb = c27680t.type;
                        c37696bx.cuX.cva = c27680t.kCK;
                        c37696bx.cuX.cvc = C1839cb.aaE() - (j * 1000);
                        c37696bx.cuX.cvd = 1;
                        c37696bx.cuX.cve = nullAsNil;
                        C4879a.xxA.mo10055m(c37696bx);
                    }
                    AppMethodBeat.m2505o(40906);
                    return;
                }
                C4990ab.m7416i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(40906);
                return;
            }
            C4990ab.m7420w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
            AppMethodBeat.m2505o(40906);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.a.a$2 */
    class C338522 implements C1202f {
        C338522() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(40907);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(304, (C1202f) this);
            if (!(i == 0 && i2 == 0)) {
                C4990ab.m7416i("MicroMsg.SubCoreCollect", "set sound fail!");
            }
            AppMethodBeat.m2505o(40907);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.a.a$3 */
    class C338533 extends C4884c<C6504k> {
        C338533() {
            AppMethodBeat.m2504i(40908);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(40908);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(40909);
            C45815a.this.kBA = ((C6504k) c4883b).csh.csi;
            AppMethodBeat.m2505o(40909);
            return false;
        }
    }

    public C45815a() {
        AppMethodBeat.m2504i(40910);
        AppMethodBeat.m2505o(40910);
    }

    public static C45815a bgv() {
        AppMethodBeat.m2504i(40911);
        C45815a c45815a = (C45815a) C7485q.m12925Y(C45815a.class);
        AppMethodBeat.m2505o(40911);
        return c45815a;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(40912);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.kBx, true);
        this.kBB.dnU();
        C1202f c1202f = this.kBy;
        c1202f.dnU();
        c1202f.kBO = new ConcurrentLinkedQueue();
        C45818a bgJ = C45818a.bgJ();
        bgJ.kCX = c1202f;
        bgJ.kCY = new C27681b(bgJ.kCX);
        C1720g.m3536RP().mo5239Ry().mo10118a(bgJ);
        C45818a.bgJ().bgK();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1384, c1202f);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1317, c1202f);
        this.kBz.dnU();
        AppMethodBeat.m2505o(40912);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(40913);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.kBx, true);
        C1202f c1202f = this.kBy;
        c1202f.dead();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1384, c1202f);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1317, c1202f);
        C33858g.bgB();
        C45818a bgJ = C45818a.bgJ();
        C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
        if (bgJ.kCW != null) {
            bgJ.kCW.kDp.destroy();
        }
        if (bgJ.kDb != null) {
            bgJ.kDb.dead();
        }
        if (bgJ.kDc != null) {
            bgJ.kDc.dead();
        }
        C1720g.m3536RP().mo5239Ry().mo10121b(bgJ);
        C45818a.kCR = false;
        this.kBz.dead();
        this.kBB.dead();
        AppMethodBeat.m2505o(40913);
    }

    public static C27676d bgw() {
        AppMethodBeat.m2504i(40914);
        C1720g.m3534RN().mo5159QU();
        C27676d c27676d = C27676d.kBH;
        AppMethodBeat.m2505o(40914);
        return c27676d;
    }

    public static boolean bgx() {
        AppMethodBeat.m2504i(40915);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_F2F_RING_TONE_STRING, (Object) "");
        long YE = C1853r.m3823YE();
        if (!C5046bo.isNullOrNil(str) && !str.equals("in.caf")) {
            C4990ab.m7416i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
            C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(YE | 32768));
            bci bci = new bci();
            bci.pXD = 1;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(209, bci));
            AppMethodBeat.m2505o(40915);
            return true;
        } else if ((YE & 32768) != 0) {
            AppMethodBeat.m2505o(40915);
            return true;
        } else {
            AppMethodBeat.m2505o(40915);
            return false;
        }
    }

    public final void bgy() {
        AppMethodBeat.m2504i(40916);
        m84753HZ("cash.caf");
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_F2F_RING_TONE_STRING, (Object) "cash.caf");
        AppMethodBeat.m2505o(40916);
    }

    public final void bgz() {
        AppMethodBeat.m2504i(40917);
        m84753HZ("in.caf");
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_F2F_RING_TONE_STRING, (Object) "in.caf");
        AppMethodBeat.m2505o(40917);
    }

    /* renamed from: HZ */
    private void m84753HZ(String str) {
        AppMethodBeat.m2504i(40918);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(304, new C338522());
        C1207m c33860o = new C33860o(C5046bo.m7532bc(str, ""));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c33860o, 0);
        AppMethodBeat.m2505o(40918);
    }
}
