package com.tencent.p177mm.p190at;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C18129e.C18130a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelsfs.SFSContext;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p190at.C17940d.C17941b;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C45161i.C179446;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C42039qa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;

/* renamed from: com.tencent.mm.at.o */
public class C32291o implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C45160g fGm;
    private C45161i fGn;
    private C17937c fGo;
    private C9019j fGp = new C9019j();
    private C17940d fGq = null;
    private C37479h fGr = new C37479h();
    private C25820b fGs = null;
    private C32292p fGt = null;
    private C4884c fGu = new C258271();
    private C25815a fGv = null;
    private SFSContext fGw = null;
    private SFSContext fGx = null;

    /* renamed from: com.tencent.mm.at.o$2 */
    static class C179472 implements C1366d {
        C179472() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45160g.fnj;
        }
    }

    /* renamed from: com.tencent.mm.at.o$1 */
    class C258271 extends C4884c<C42039qa> {
        C258271() {
            AppMethodBeat.m2504i(78381);
            this.xxI = C42039qa.class.getName().hashCode();
            AppMethodBeat.m2505o(78381);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78382);
            C7620bi c7620bi = ((C42039qa) c4883b).cMp.csG;
            C45161i ahj = C32291o.ahj();
            C25822e fJ = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
            fJ.mo43795lr(0);
            C32291o.ahl().mo73077a(Long.valueOf(fJ.fDy), fJ);
            int i = fJ.agQ() ? 1 : 0;
            String q = C32291o.ahl().mo73118q(fJ.fDz, "", "");
            if (q == null || q.equals("") || !C1173e.m2561ct(q)) {
                C4990ab.m7412e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                C5004al.m7441d(new C179446(fJ, i));
            }
            AppMethodBeat.m2505o(78382);
            return false;
        }
    }

    public C32291o() {
        AppMethodBeat.m2504i(78383);
        AppMethodBeat.m2505o(78383);
    }

    private static synchronized C32291o ahi() {
        C32291o c32291o;
        synchronized (C32291o.class) {
            AppMethodBeat.m2504i(78384);
            c32291o = (C32291o) C7485q.m12925Y(C32291o.class);
            AppMethodBeat.m2505o(78384);
        }
        return c32291o;
    }

    public static C45161i ahj() {
        AppMethodBeat.m2504i(78385);
        if (C32291o.ahi().fGn == null) {
            C32291o.ahi().fGn = new C45161i();
        }
        C45161i c45161i = C32291o.ahi().fGn;
        AppMethodBeat.m2505o(78385);
        return c45161i;
    }

    public static C17937c ahk() {
        AppMethodBeat.m2504i(78386);
        C1720g.m3534RN().mo5159QU();
        if (C32291o.ahi().fGo == null) {
            C32291o.ahi().fGo = new C17937c();
        }
        C17937c c17937c = C32291o.ahi().fGo;
        AppMethodBeat.m2505o(78386);
        return c17937c;
    }

    public static C45160g ahl() {
        AppMethodBeat.m2504i(78387);
        C1720g.m3534RN().mo5159QU();
        if (C32291o.ahi().fGm == null) {
            C32291o.ahi().fGm = new C45160g(C1720g.m3536RP().eJN);
        }
        C45160g c45160g = C32291o.ahi().fGm;
        AppMethodBeat.m2505o(78387);
        return c45160g;
    }

    public static C17940d ahm() {
        AppMethodBeat.m2504i(78388);
        C1720g.m3534RN().mo5159QU();
        if (C32291o.ahi().fGq == null) {
            C32291o.ahi().fGq = new C17940d();
        }
        C17940d c17940d = C32291o.ahi().fGq;
        AppMethodBeat.m2505o(78388);
        return c17940d;
    }

    public static C25820b ahn() {
        AppMethodBeat.m2504i(78389);
        C1720g.m3534RN().mo5159QU();
        if (C32291o.ahi().fGs == null) {
            C32291o.ahi().fGs = new C25820b(Looper.getMainLooper());
        }
        C25820b c25820b = C32291o.ahi().fGs;
        AppMethodBeat.m2505o(78389);
        return c25820b;
    }

    public static C32292p aho() {
        AppMethodBeat.m2504i(78390);
        C1720g.m3534RN().mo5159QU();
        if (C32291o.ahi().fGt == null) {
            C32291o.ahi().fGt = new C32292p();
        }
        C32292p c32292p = C32291o.ahi().fGt;
        AppMethodBeat.m2505o(78390);
        return c32292p;
    }

    public static C25815a ahp() {
        AppMethodBeat.m2504i(78391);
        C1720g.m3534RN().mo5159QU();
        if (C32291o.ahi().fGv == null) {
            C32291o.ahi().fGv = C25815a.ahv();
        }
        C25815a c25815a = C32291o.ahi().fGv;
        AppMethodBeat.m2505o(78391);
        return c25815a;
    }

    public static SFSContext ahq() {
        return null;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(78392);
        C32291o ahi = C32291o.ahi();
        if (ahi.fGn != null) {
            C1202f c1202f = ahi.fGn;
            c1202f.cqV = 0;
            C1720g.m3535RO().eJo.mo14546b(110, c1202f);
        }
        if (ahi.fGs != null) {
            C9017a c9017a = ahi.fGs;
            synchronized (c9017a.fCV) {
                try {
                    c9017a.fCV.clear();
                    c9017a.fCW = 0;
                    C32291o.ahm().mo33465a(c9017a);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78392);
                    }
                }
            }
            C4879a.xxA.mo10053d(c9017a.fDh);
            C4879a.xxA.mo10053d(c9017a.fDi);
        }
        if (ahi.fGq != null) {
            C1202f c1202f2 = ahi.fGq;
            C4990ab.m7416i("ModelImage.DownloadImgService", "on detach");
            C4990ab.m7416i("ModelImage.DownloadImgService", "cancel all net scene");
            c1202f2.fDr = true;
            c1202f2.mo33470b(c1202f2.fDp);
            while (c1202f2.fDn.size() > 0) {
                c1202f2.mo33470b((C17941b) c1202f2.fDn.get(0));
            }
            c1202f2.agN();
            C1720g.m3535RO().eJo.mo14546b(109, c1202f2);
        }
        if (ahi.fGt != null) {
            C32292p c32292p = ahi.fGt;
            C4990ab.m7416i("MicroMsg.UrlImageCacheService", "detach");
            c32292p.fGz.clear();
            c32292p.fGB = true;
        }
        C45160g c45160g = C32291o.ahi().fGm;
        if (c45160g != null) {
            C4990ab.m7417i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", C5046bo.dpG());
            c45160g.fEh.clear();
        }
        C25815a c25815a = C32291o.ahi().fGv;
        if (c25815a != null) {
            c25815a.detach();
        }
        C1200d.m2637b(Integer.valueOf(3), this.fGr);
        C1200d.m2637b(Integer.valueOf(23), this.fGr);
        C18130a.m28565a("local_cdn_img_cache", null);
        C4879a.xxA.mo10053d(this.fGu);
        if (ahi.fGv != null) {
            ahi.fGv.detach();
            ahi.fGv = null;
        }
        if (ahi.fGw != null) {
            ahi.fGw.release();
            ahi.fGw = null;
        }
        if (ahi.fGx != null) {
            ahi.fGx.release();
            ahi.fGx = null;
        }
        AppMethodBeat.m2505o(78392);
    }

    static {
        AppMethodBeat.m2504i(78394);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new C179472());
        AppMethodBeat.m2505o(78394);
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
        AppMethodBeat.m2504i(78393);
        C1200d.m2636a(Integer.valueOf(3), this.fGr);
        C1200d.m2636a(Integer.valueOf(23), this.fGr);
        C18130a.m28565a("local_cdn_img_cache", this.fGp);
        C4879a.xxA.mo10052c(this.fGu);
        AppMethodBeat.m2505o(78393);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
