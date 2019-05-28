package com.tencent.mm.at;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.i.AnonymousClass6;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;

public class o implements at {
    private static HashMap<Integer, d> eaA;
    private g fGm;
    private i fGn;
    private c fGo;
    private j fGp = new j();
    private d fGq = null;
    private h fGr = new h();
    private b fGs = null;
    private p fGt = null;
    private c fGu = new c<qa>() {
        {
            AppMethodBeat.i(78381);
            this.xxI = qa.class.getName().hashCode();
            AppMethodBeat.o(78381);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(78382);
            bi biVar = ((qa) bVar).cMp.csG;
            i ahj = o.ahj();
            e fJ = o.ahl().fJ(biVar.field_msgId);
            fJ.lr(0);
            o.ahl().a(Long.valueOf(fJ.fDy), fJ);
            int i = fJ.agQ() ? 1 : 0;
            String q = o.ahl().q(fJ.fDz, "", "");
            if (q == null || q.equals("") || !e.ct(q)) {
                ab.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                al.d(new AnonymousClass6(fJ, i));
            }
            AppMethodBeat.o(78382);
            return false;
        }
    };
    private a fGv = null;
    private SFSContext fGw = null;
    private SFSContext fGx = null;

    public o() {
        AppMethodBeat.i(78383);
        AppMethodBeat.o(78383);
    }

    private static synchronized o ahi() {
        o oVar;
        synchronized (o.class) {
            AppMethodBeat.i(78384);
            oVar = (o) q.Y(o.class);
            AppMethodBeat.o(78384);
        }
        return oVar;
    }

    public static i ahj() {
        AppMethodBeat.i(78385);
        if (ahi().fGn == null) {
            ahi().fGn = new i();
        }
        i iVar = ahi().fGn;
        AppMethodBeat.o(78385);
        return iVar;
    }

    public static c ahk() {
        AppMethodBeat.i(78386);
        g.RN().QU();
        if (ahi().fGo == null) {
            ahi().fGo = new c();
        }
        c cVar = ahi().fGo;
        AppMethodBeat.o(78386);
        return cVar;
    }

    public static g ahl() {
        AppMethodBeat.i(78387);
        g.RN().QU();
        if (ahi().fGm == null) {
            ahi().fGm = new g(g.RP().eJN);
        }
        g gVar = ahi().fGm;
        AppMethodBeat.o(78387);
        return gVar;
    }

    public static d ahm() {
        AppMethodBeat.i(78388);
        g.RN().QU();
        if (ahi().fGq == null) {
            ahi().fGq = new d();
        }
        d dVar = ahi().fGq;
        AppMethodBeat.o(78388);
        return dVar;
    }

    public static b ahn() {
        AppMethodBeat.i(78389);
        g.RN().QU();
        if (ahi().fGs == null) {
            ahi().fGs = new b(Looper.getMainLooper());
        }
        b bVar = ahi().fGs;
        AppMethodBeat.o(78389);
        return bVar;
    }

    public static p aho() {
        AppMethodBeat.i(78390);
        g.RN().QU();
        if (ahi().fGt == null) {
            ahi().fGt = new p();
        }
        p pVar = ahi().fGt;
        AppMethodBeat.o(78390);
        return pVar;
    }

    public static a ahp() {
        AppMethodBeat.i(78391);
        g.RN().QU();
        if (ahi().fGv == null) {
            ahi().fGv = a.ahv();
        }
        a aVar = ahi().fGv;
        AppMethodBeat.o(78391);
        return aVar;
    }

    public static SFSContext ahq() {
        return null;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(78392);
        o ahi = ahi();
        if (ahi.fGn != null) {
            f fVar = ahi.fGn;
            fVar.cqV = 0;
            g.RO().eJo.b(110, fVar);
        }
        if (ahi.fGs != null) {
            d.a aVar = ahi.fGs;
            synchronized (aVar.fCV) {
                try {
                    aVar.fCV.clear();
                    aVar.fCW = 0;
                    ahm().a(aVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78392);
                    }
                }
            }
            com.tencent.mm.sdk.b.a.xxA.d(aVar.fDh);
            com.tencent.mm.sdk.b.a.xxA.d(aVar.fDi);
        }
        if (ahi.fGq != null) {
            f fVar2 = ahi.fGq;
            ab.i("ModelImage.DownloadImgService", "on detach");
            ab.i("ModelImage.DownloadImgService", "cancel all net scene");
            fVar2.fDr = true;
            fVar2.b(fVar2.fDp);
            while (fVar2.fDn.size() > 0) {
                fVar2.b((b) fVar2.fDn.get(0));
            }
            fVar2.agN();
            g.RO().eJo.b(109, fVar2);
        }
        if (ahi.fGt != null) {
            p pVar = ahi.fGt;
            ab.i("MicroMsg.UrlImageCacheService", "detach");
            pVar.fGz.clear();
            pVar.fGB = true;
        }
        g gVar = ahi().fGm;
        if (gVar != null) {
            ab.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", bo.dpG());
            gVar.fEh.clear();
        }
        a aVar2 = ahi().fGv;
        if (aVar2 != null) {
            aVar2.detach();
        }
        com.tencent.mm.ai.e.d.b(Integer.valueOf(3), this.fGr);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(23), this.fGr);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", null);
        com.tencent.mm.sdk.b.a.xxA.d(this.fGu);
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
        AppMethodBeat.o(78392);
    }

    static {
        AppMethodBeat.i(78394);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        AppMethodBeat.o(78394);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(78393);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(3), this.fGr);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(23), this.fGr);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", this.fGp);
        com.tencent.mm.sdk.b.a.xxA.c(this.fGu);
        AppMethodBeat.o(78393);
    }

    public final void bA(boolean z) {
    }
}
