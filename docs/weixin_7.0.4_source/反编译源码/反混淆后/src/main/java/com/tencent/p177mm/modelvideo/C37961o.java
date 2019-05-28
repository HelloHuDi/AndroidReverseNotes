package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelvideo.C42229y.C26495a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.tencent.mm.modelvideo.o */
public class C37961o implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private static C5004al fWL = null;
    private static C7306ak fWM = null;
    private volatile C18714v fWE = new C18714v();
    private volatile C9720t fWF;
    private volatile C42228x fWG;
    private volatile C26495a fWH = null;
    private volatile C26489l fWI = null;
    private volatile C1883k fWJ = null;
    private volatile C18709m fWK = null;
    private C45150e fWN = null;
    private C32847i fWO = null;
    private C46887p fWP = new C46887p();

    /* renamed from: com.tencent.mm.modelvideo.o$1 */
    static class C66931 implements C1366d {
        C66931() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C9720t.fnj;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.o$2 */
    static class C379592 implements C1366d {
        C379592() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C42228x.fnj;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.o$3 */
    static class C379603 implements C1366d {
        C379603() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C26489l.fnj;
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.o$4 */
    class C379624 implements Runnable {
        C379624() {
        }

        public final void run() {
            AppMethodBeat.m2504i(50762);
            if (C1720g.m3531RK()) {
                C9720t all = C37961o.all();
                C4990ab.m7417i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status = 200");
                all.fni.mo10108hY("videoinfo2", r1);
                C37961o.alp().bSd.mo10108hY("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
                C26489l alp = C37961o.alp();
                if (1209600000 <= 0) {
                    C4990ab.m7420w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                    alp.bSd.mo10108hY("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
                } else {
                    C4990ab.m7417i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", Long.valueOf(C5046bo.anU() - 1209600000));
                    alp.bSd.mo10108hY("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(r2)));
                }
                for (C9716j c9716j : C37961o.alp().alf()) {
                    C4990ab.m7417i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", c9716j.field_fileName);
                    C1173e.deleteFile(C1883k.m3987tX(c9716j.field_fileName));
                    C1173e.deleteFile(C1883k.m3988tY(c9716j.field_fileName));
                }
                AppMethodBeat.m2505o(50762);
                return;
            }
            AppMethodBeat.m2505o(50762);
        }
    }

    public C37961o() {
        AppMethodBeat.m2504i(50763);
        AppMethodBeat.m2505o(50763);
    }

    static {
        AppMethodBeat.m2504i(50778);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new C66931());
        eaA.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new C379592());
        eaA.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new C379603());
        AppMethodBeat.m2505o(50778);
    }

    public static C37961o alk() {
        AppMethodBeat.m2504i(50764);
        C37961o c37961o = (C37961o) C7485q.m12925Y(C37961o.class);
        AppMethodBeat.m2505o(50764);
        return c37961o;
    }

    public static synchronized C9720t all() {
        C9720t c9720t;
        synchronized (C37961o.class) {
            AppMethodBeat.m2504i(50765);
            if (C1720g.m3531RK()) {
                if (C37961o.alk().fWF == null) {
                    C37961o.alk().fWF = new C9720t(C1720g.m3536RP().eJN);
                }
                c9720t = C37961o.alk().fWF;
                AppMethodBeat.m2505o(50765);
            } else {
                C1819b c1819b = new C1819b();
                AppMethodBeat.m2505o(50765);
                throw c1819b;
            }
        }
        return c9720t;
    }

    public static C45150e alm() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(50766);
        C1720g.m3534RN().mo5159QU();
        if (C37961o.alk().fWN == null) {
            C37961o.alk().fWN = new C45150e();
        }
        if (C37461f.afy().fyE == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            C8941a afy = C37461f.afy();
            C45150e c45150e = C37961o.alk().fWN;
            afy.fyE = c45150e;
            String str = "MicroMsg.CdnTransportEngine";
            String str2 = "set cdn online video callback hash[%d] onlineVideoCallback[%d]";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(afy.hashCode());
            if (c45150e != null) {
                i2 = c45150e.hashCode();
            }
            objArr[1] = Integer.valueOf(i2);
            C4990ab.m7417i(str, str2, objArr);
        }
        C45150e c45150e2 = C37961o.alk().fWN;
        AppMethodBeat.m2505o(50766);
        return c45150e2;
    }

    public static C32847i aln() {
        AppMethodBeat.m2504i(50767);
        C1720g.m3534RN().mo5159QU();
        if (C37961o.alk().fWO == null) {
            C37961o.alk().fWO = new C32847i();
        }
        C32847i c32847i = C37961o.alk().fWO;
        AppMethodBeat.m2505o(50767);
        return c32847i;
    }

    public static C42228x alo() {
        AppMethodBeat.m2504i(50768);
        if (C1720g.m3531RK()) {
            if (C37961o.alk().fWG == null) {
                C37961o.alk().fWG = new C42228x(C1720g.m3536RP().eJN);
            }
            C42228x c42228x = C37961o.alk().fWG;
            AppMethodBeat.m2505o(50768);
            return c42228x;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(50768);
        throw c1819b;
    }

    public static synchronized C26489l alp() {
        C26489l c26489l;
        synchronized (C37961o.class) {
            AppMethodBeat.m2504i(50769);
            if (C1720g.m3531RK()) {
                if (C37961o.alk().fWI == null) {
                    C37961o.alk().fWI = new C26489l(C1720g.m3536RP().eJN);
                }
                c26489l = C37961o.alk().fWI;
                AppMethodBeat.m2505o(50769);
            } else {
                C1819b c1819b = new C1819b();
                AppMethodBeat.m2505o(50769);
                throw c1819b;
            }
        }
        return c26489l;
    }

    public static C26495a alq() {
        AppMethodBeat.m2504i(50770);
        if (C1720g.m3531RK()) {
            if (C37961o.alk().fWH == null) {
                C37961o.alk().fWH = new C26495a();
            }
            C26495a c26495a = C37961o.alk().fWH;
            AppMethodBeat.m2505o(50770);
            return c26495a;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(50770);
        throw c1819b;
    }

    public static C18709m alr() {
        AppMethodBeat.m2504i(50771);
        if (C1720g.m3531RK()) {
            if (C37961o.alk().fWK == null) {
                C37961o.alk().fWK = new C18709m();
            }
            C18709m c18709m = C37961o.alk().fWK;
            AppMethodBeat.m2505o(50771);
            return c18709m;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(50771);
        throw c1819b;
    }

    private static void als() {
        boolean z = false;
        AppMethodBeat.m2504i(50772);
        if (fWM == null || fWL == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(fWM != null);
            if (fWL != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = C5046bo.dpG();
            C4990ab.m7421w(str, str2, objArr);
            if (fWM != null) {
                fWM.removeCallbacksAndMessages(null);
            }
            if (fWL != null) {
                fWL.mo10301a(null);
            } else {
                fWL = new C5004al("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            fWM = new C7306ak(fWL.oAl.getLooper());
            AppMethodBeat.m2505o(50772);
            return;
        }
        AppMethodBeat.m2505o(50772);
    }

    /* renamed from: i */
    public static boolean m64222i(Runnable runnable, long j) {
        AppMethodBeat.m2504i(50773);
        if (runnable == null) {
            AppMethodBeat.m2505o(50773);
            return false;
        }
        C37961o.als();
        if (j > 0) {
            fWM.postDelayed(runnable, j);
        } else {
            fWM.post(runnable);
        }
        AppMethodBeat.m2505o(50773);
        return true;
    }

    /* renamed from: y */
    public static boolean m64223y(Runnable runnable) {
        AppMethodBeat.m2504i(50774);
        if (runnable == null) {
            AppMethodBeat.m2505o(50774);
            return true;
        }
        C37961o.als();
        if (fWM == null) {
            C4990ab.m7412e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            AppMethodBeat.m2505o(50774);
            return false;
        }
        fWM.removeCallbacks(runnable);
        AppMethodBeat.m2505o(50774);
        return true;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(50775);
        C4990ab.m7417i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", Integer.valueOf(hashCode()));
        C37961o.alq().mo44281b(this.fWP);
        try {
            if (C37961o.alk().fWH != null) {
                C1202f c1202f = C37961o.alk().fWH;
                c1202f.cqV = 0;
                if (c1202f.fXN != null) {
                    C1720g.m3540Rg().mo14547c(c1202f.fXN);
                }
                if (c1202f.fXO != null) {
                    C1720g.m3540Rg().mo14547c(c1202f.fXO);
                }
                C1720g.m3540Rg().mo14546b(149, c1202f);
                C1720g.m3540Rg().mo14546b(150, c1202f);
                C37961o.all().mo21052a(c1202f);
            }
            if (C37961o.alk().fWK != null) {
                C18709m c18709m = C37961o.alk().fWK;
                c18709m.cqV = 0;
                C4990ab.m7417i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", c18709m.fWi);
                if (!C5046bo.isNullOrNil(c18709m.fWi)) {
                    C37461f.afx().mo51227rN(c18709m.fWi);
                }
            }
            if (C37961o.alk().fWO != null) {
                C32847i c32847i = C37961o.alk().fWO;
                c32847i.stopDownload();
                c32847i.fVS.clear();
            }
            if (C37961o.alk().fWN != null) {
                C37961o.alk().fWN.release();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SubCoreVideo", e, "", new Object[0]);
        }
        C1200d.m2637b(Integer.valueOf(43), this.fWE);
        C1200d.m2637b(Integer.valueOf(44), this.fWE);
        C1200d.m2637b(Integer.valueOf(62), this.fWE);
        if (fWM != null) {
            fWM.removeCallbacksAndMessages(null);
        }
        try {
            C26495a alq = C37961o.alq();
            C4990ab.m7417i("MicroMsg.VideoService", "quitVideoSendThread: %s", alq.fXH);
            if (alq.fXH != null) {
                try {
                    alq.fXH.quit();
                    alq.fXJ = false;
                    alq.fXI = null;
                    alq.fXH = null;
                    AppMethodBeat.m2505o(50775);
                    return;
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.VideoService", "quitVideoSendThread error: %s", e2.getMessage());
                }
            }
            AppMethodBeat.m2505o(50775);
        } catch (Exception e22) {
            C4990ab.m7413e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", e22.getMessage());
            AppMethodBeat.m2505o(50775);
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(50776);
        C4990ab.m7417i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", Integer.valueOf(hashCode()));
        C37961o.alq().mo44277a(this.fWP);
        C1200d.m2636a(Integer.valueOf(43), this.fWE);
        C1200d.m2636a(Integer.valueOf(44), this.fWE);
        C1200d.m2636a(Integer.valueOf(62), this.fWE);
        if (fWM != null) {
            fWM.removeCallbacksAndMessages(null);
        }
        C1720g.m3539RS().mo10302aa(new C379624());
        File file = new File(C1883k.ale());
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(50776);
    }

    public static String getAccVideoPath() {
        AppMethodBeat.m2504i(50777);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("video/").toString();
        AppMethodBeat.m2505o(50777);
        return stringBuilder2;
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
