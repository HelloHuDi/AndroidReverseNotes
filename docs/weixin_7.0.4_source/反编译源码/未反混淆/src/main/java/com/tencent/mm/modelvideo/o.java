package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.b;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;

public class o implements at {
    private static HashMap<Integer, d> eaA;
    private static al fWL = null;
    private static ak fWM = null;
    private volatile v fWE = new v();
    private volatile t fWF;
    private volatile x fWG;
    private volatile a fWH = null;
    private volatile l fWI = null;
    private volatile k fWJ = null;
    private volatile m fWK = null;
    private e fWN = null;
    private i fWO = null;
    private p fWP = new p();

    public o() {
        AppMethodBeat.i(50763);
        AppMethodBeat.o(50763);
    }

    static {
        AppMethodBeat.i(50778);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return t.fnj;
            }
        });
        eaA.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return x.fnj;
            }
        });
        eaA.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return l.fnj;
            }
        });
        AppMethodBeat.o(50778);
    }

    public static o alk() {
        AppMethodBeat.i(50764);
        o oVar = (o) q.Y(o.class);
        AppMethodBeat.o(50764);
        return oVar;
    }

    public static synchronized t all() {
        t tVar;
        synchronized (o.class) {
            AppMethodBeat.i(50765);
            if (g.RK()) {
                if (alk().fWF == null) {
                    alk().fWF = new t(g.RP().eJN);
                }
                tVar = alk().fWF;
                AppMethodBeat.o(50765);
            } else {
                b bVar = new b();
                AppMethodBeat.o(50765);
                throw bVar;
            }
        }
        return tVar;
    }

    public static e alm() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(50766);
        g.RN().QU();
        if (alk().fWN == null) {
            alk().fWN = new e();
        }
        if (f.afy().fyE == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.tencent.mm.al.a afy = f.afy();
            e eVar = alk().fWN;
            afy.fyE = eVar;
            String str = "MicroMsg.CdnTransportEngine";
            String str2 = "set cdn online video callback hash[%d] onlineVideoCallback[%d]";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(afy.hashCode());
            if (eVar != null) {
                i2 = eVar.hashCode();
            }
            objArr[1] = Integer.valueOf(i2);
            ab.i(str, str2, objArr);
        }
        e eVar2 = alk().fWN;
        AppMethodBeat.o(50766);
        return eVar2;
    }

    public static i aln() {
        AppMethodBeat.i(50767);
        g.RN().QU();
        if (alk().fWO == null) {
            alk().fWO = new i();
        }
        i iVar = alk().fWO;
        AppMethodBeat.o(50767);
        return iVar;
    }

    public static x alo() {
        AppMethodBeat.i(50768);
        if (g.RK()) {
            if (alk().fWG == null) {
                alk().fWG = new x(g.RP().eJN);
            }
            x xVar = alk().fWG;
            AppMethodBeat.o(50768);
            return xVar;
        }
        b bVar = new b();
        AppMethodBeat.o(50768);
        throw bVar;
    }

    public static synchronized l alp() {
        l lVar;
        synchronized (o.class) {
            AppMethodBeat.i(50769);
            if (g.RK()) {
                if (alk().fWI == null) {
                    alk().fWI = new l(g.RP().eJN);
                }
                lVar = alk().fWI;
                AppMethodBeat.o(50769);
            } else {
                b bVar = new b();
                AppMethodBeat.o(50769);
                throw bVar;
            }
        }
        return lVar;
    }

    public static a alq() {
        AppMethodBeat.i(50770);
        if (g.RK()) {
            if (alk().fWH == null) {
                alk().fWH = new a();
            }
            a aVar = alk().fWH;
            AppMethodBeat.o(50770);
            return aVar;
        }
        b bVar = new b();
        AppMethodBeat.o(50770);
        throw bVar;
    }

    public static m alr() {
        AppMethodBeat.i(50771);
        if (g.RK()) {
            if (alk().fWK == null) {
                alk().fWK = new m();
            }
            m mVar = alk().fWK;
            AppMethodBeat.o(50771);
            return mVar;
        }
        b bVar = new b();
        AppMethodBeat.o(50771);
        throw bVar;
    }

    private static void als() {
        boolean z = false;
        AppMethodBeat.i(50772);
        if (fWM == null || fWL == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(fWM != null);
            if (fWL != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bo.dpG();
            ab.w(str, str2, objArr);
            if (fWM != null) {
                fWM.removeCallbacksAndMessages(null);
            }
            if (fWL != null) {
                fWL.a(null);
            } else {
                fWL = new al("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            fWM = new ak(fWL.oAl.getLooper());
            AppMethodBeat.o(50772);
            return;
        }
        AppMethodBeat.o(50772);
    }

    public static boolean i(Runnable runnable, long j) {
        AppMethodBeat.i(50773);
        if (runnable == null) {
            AppMethodBeat.o(50773);
            return false;
        }
        als();
        if (j > 0) {
            fWM.postDelayed(runnable, j);
        } else {
            fWM.post(runnable);
        }
        AppMethodBeat.o(50773);
        return true;
    }

    public static boolean y(Runnable runnable) {
        AppMethodBeat.i(50774);
        if (runnable == null) {
            AppMethodBeat.o(50774);
            return true;
        }
        als();
        if (fWM == null) {
            ab.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            AppMethodBeat.o(50774);
            return false;
        }
        fWM.removeCallbacks(runnable);
        AppMethodBeat.o(50774);
        return true;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(50775);
        ab.i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", Integer.valueOf(hashCode()));
        alq().b(this.fWP);
        try {
            if (alk().fWH != null) {
                com.tencent.mm.ai.f fVar = alk().fWH;
                fVar.cqV = 0;
                if (fVar.fXN != null) {
                    g.Rg().c(fVar.fXN);
                }
                if (fVar.fXO != null) {
                    g.Rg().c(fVar.fXO);
                }
                g.Rg().b(149, fVar);
                g.Rg().b(150, fVar);
                all().a(fVar);
            }
            if (alk().fWK != null) {
                m mVar = alk().fWK;
                mVar.cqV = 0;
                ab.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", mVar.fWi);
                if (!bo.isNullOrNil(mVar.fWi)) {
                    f.afx().rN(mVar.fWi);
                }
            }
            if (alk().fWO != null) {
                i iVar = alk().fWO;
                iVar.stopDownload();
                iVar.fVS.clear();
            }
            if (alk().fWN != null) {
                alk().fWN.release();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SubCoreVideo", e, "", new Object[0]);
        }
        com.tencent.mm.ai.e.d.b(Integer.valueOf(43), this.fWE);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(44), this.fWE);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(62), this.fWE);
        if (fWM != null) {
            fWM.removeCallbacksAndMessages(null);
        }
        try {
            a alq = alq();
            ab.i("MicroMsg.VideoService", "quitVideoSendThread: %s", alq.fXH);
            if (alq.fXH != null) {
                try {
                    alq.fXH.quit();
                    alq.fXJ = false;
                    alq.fXI = null;
                    alq.fXH = null;
                    AppMethodBeat.o(50775);
                    return;
                } catch (Exception e2) {
                    ab.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", e2.getMessage());
                }
            }
            AppMethodBeat.o(50775);
        } catch (Exception e22) {
            ab.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", e22.getMessage());
            AppMethodBeat.o(50775);
        }
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(50776);
        ab.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", Integer.valueOf(hashCode()));
        alq().a(this.fWP);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(43), this.fWE);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(44), this.fWE);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(62), this.fWE);
        if (fWM != null) {
            fWM.removeCallbacksAndMessages(null);
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50762);
                if (g.RK()) {
                    t all = o.all();
                    ab.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status = 200");
                    all.fni.hY("videoinfo2", r1);
                    o.alp().bSd.hY("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
                    l alp = o.alp();
                    if (1209600000 <= 0) {
                        ab.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                        alp.bSd.hY("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
                    } else {
                        ab.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", Long.valueOf(bo.anU() - 1209600000));
                        alp.bSd.hY("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(r2)));
                    }
                    for (j jVar : o.alp().alf()) {
                        ab.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", jVar.field_fileName);
                        com.tencent.mm.a.e.deleteFile(k.tX(jVar.field_fileName));
                        com.tencent.mm.a.e.deleteFile(k.tY(jVar.field_fileName));
                    }
                    AppMethodBeat.o(50762);
                    return;
                }
                AppMethodBeat.o(50762);
            }
        });
        File file = new File(k.ale());
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        AppMethodBeat.o(50776);
    }

    public static String getAccVideoPath() {
        AppMethodBeat.i(50777);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("video/").toString();
        AppMethodBeat.o(50777);
        return stringBuilder2;
    }

    public final void bA(boolean z) {
    }
}
