package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.a.a;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.b.a.ai;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bi;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e implements f, a {
    Queue<String> fyK = new LinkedList();
    Map<String, h> fyL = new HashMap();
    Map<String, h> fyM = new HashMap();
    Map<String, h> fzq = new HashMap();
    Map<String, d> fzr = new HashMap();

    public e() {
        AppMethodBeat.i(50568);
        g.Rg().a(379, (f) this);
        AppMethodBeat.o(50568);
    }

    public final void release() {
        AppMethodBeat.i(50569);
        g.Rg().b(379, (f) this);
        AppMethodBeat.o(50569);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(50570);
        if (mVar.getType() != 379) {
            AppMethodBeat.o(50570);
            return;
        }
        ab.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", Integer.valueOf(i), Integer.valueOf(i2));
        if (g.RN().QY()) {
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(50558);
                    e.this.cK(true);
                    AppMethodBeat.o(50558);
                }
            });
        }
        AppMethodBeat.o(50570);
    }

    public final boolean a(final h hVar, boolean z) {
        AppMethodBeat.i(50571);
        if (hVar == null) {
            ab.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            AppMethodBeat.o(50571);
            return false;
        } else if (bo.isNullOrNil(hVar.field_mediaId)) {
            ab.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            AppMethodBeat.o(50571);
            return false;
        } else {
            ab.i("MicroMsg.OnlineVideoService", "add download task : " + hVar.field_mediaId + " delay : " + z);
            if (hVar.field_fileId == null) {
                hVar.field_fileId = "";
            }
            if (hVar.field_aesKey == null) {
                hVar.field_aesKey = "";
            }
            hVar.cRY = false;
            if (m(hVar.field_mediaId, null) || z) {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(50560);
                        e.this.fyK.add(hVar.field_mediaId);
                        e.this.fyL.put(hVar.field_mediaId, hVar);
                        e.this.cK(false);
                        AppMethodBeat.o(50560);
                    }
                });
            } else {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(50561);
                        e.this.fyK.add(hVar.field_mediaId);
                        e.this.fyL.put(hVar.field_mediaId, hVar);
                        e.this.cK(false);
                        AppMethodBeat.o(50561);
                    }
                });
            }
            AppMethodBeat.o(50571);
            return true;
        }
    }

    public final boolean a(final h hVar) {
        AppMethodBeat.i(50572);
        if (bo.isNullOrNil(hVar.field_mediaId)) {
            ab.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            AppMethodBeat.o(50572);
            return false;
        }
        ab.i("MicroMsg.OnlineVideoService", "add download task : " + hVar.field_mediaId);
        if (hVar.field_fileId == null) {
            hVar.field_fileId = "";
        }
        if (hVar.field_aesKey == null) {
            hVar.field_aesKey = "";
        }
        hVar.cRY = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(50562);
                    e.this.fyK.add(hVar.field_mediaId);
                    e.this.fyL.put(hVar.field_mediaId, hVar);
                    e.this.cK(false);
                    AppMethodBeat.o(50562);
                }
            });
        } else {
            this.fyK.add(hVar.field_mediaId);
            this.fyL.put(hVar.field_mediaId, hVar);
            cK(false);
        }
        AppMethodBeat.o(50572);
        return true;
    }

    public final boolean l(final String str, final Object[] objArr) {
        boolean z;
        AppMethodBeat.i(50573);
        if (bo.isNullOrNil(str)) {
            z = false;
        } else {
            if (this.fyM.containsKey(str)) {
                z = true;
            } else {
                f.afx().rO(str);
                z = false;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(50563);
                        h hVar = (h) e.this.fyM.remove(str);
                        d dVar;
                        if (hVar != null) {
                            dVar = new d();
                            f.afy();
                            if (a.b(hVar.field_mediaId, dVar) == 0) {
                                e.a(objArr, dVar, hVar, false);
                            } else {
                                ab.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(a.b(hVar.field_mediaId, dVar)), hVar.field_mediaId);
                            }
                        } else {
                            hVar = (h) e.this.fzq.remove(str);
                            dVar = (d) e.this.fzr.remove(str);
                            if (!(hVar == null || dVar == null)) {
                                e.a(objArr, dVar, hVar, true);
                            }
                        }
                        e.this.fyL.remove(str);
                        AppMethodBeat.o(50563);
                    }
                });
            } else {
                h hVar = (h) this.fyM.remove(str);
                if (hVar != null) {
                    d dVar = new d();
                    f.afy();
                    if (a.b(hVar.field_mediaId, dVar) == 0) {
                        a(objArr, dVar, hVar, false);
                    } else {
                        ab.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(a.b(hVar.field_mediaId, dVar)), hVar.field_mediaId);
                    }
                } else {
                    hVar = (h) this.fzq.remove(str);
                    d dVar2 = (d) this.fzr.remove(str);
                    if (!(hVar == null || dVar2 == null)) {
                        a(objArr, dVar2, hVar, true);
                    }
                }
                this.fyL.remove(str);
            }
        }
        ab.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + str + " remove : " + z);
        AppMethodBeat.o(50573);
        return z;
    }

    public final boolean m(final String str, final Object[] objArr) {
        AppMethodBeat.i(50574);
        boolean z = false;
        if (!bo.isNullOrNil(str)) {
            if (this.fyM.containsKey(str)) {
                z = true;
            } else {
                f.afx().rO(str);
            }
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(50564);
                    h hVar = (h) e.this.fyM.remove(str);
                    d dVar;
                    if (hVar != null) {
                        dVar = new d();
                        f.afy();
                        if (a.b(hVar.field_mediaId, dVar) == 0) {
                            e.a(objArr, dVar, hVar, false);
                        } else {
                            ab.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(a.b(hVar.field_mediaId, dVar)), hVar.field_mediaId);
                        }
                    } else {
                        hVar = (h) e.this.fzq.remove(str);
                        dVar = (d) e.this.fzr.remove(str);
                        if (!(hVar == null || dVar == null)) {
                            e.a(objArr, dVar, hVar, true);
                        }
                    }
                    e.this.fyL.remove(str);
                    AppMethodBeat.o(50564);
                }
            });
        }
        ab.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        AppMethodBeat.o(50574);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.i(50575);
        if (((h) this.fyM.get(str)) == null) {
            ab.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", str);
            AppMethodBeat.o(50575);
            return false;
        }
        f.afy();
        ab.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(a.isVideoDataAvailable(str, i, i2)));
        AppMethodBeat.o(50575);
        return a.isVideoDataAvailable(str, i, i2);
    }

    public static int k(String str, int i, int i2) {
        AppMethodBeat.i(50576);
        f.afy();
        ab.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(a.k(str, i, i2)));
        AppMethodBeat.o(50576);
        return a.k(str, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cK(boolean z) {
        AppMethodBeat.i(50577);
        if (g.RK()) {
            if (!z && f.afy().afq()) {
                g.RN();
                if (com.tencent.mm.kernel.a.QX()) {
                    ab.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
                    f.afx().cK(z);
                    AppMethodBeat.o(50577);
                    return;
                }
            }
            f.afx().afs();
            while (!this.fyK.isEmpty()) {
                String str = (String) this.fyK.poll();
                com.tencent.mm.i.g gVar = (h) this.fyL.remove(str);
                if (gVar != null) {
                    gVar.field_startTime = bo.anU();
                    if (!gVar.cRY) {
                        Object obj;
                        if (((Integer) g.RP().Ry().get(ac.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                            ab.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else if (!gVar.Js()) {
                            String str2 = gVar.egB;
                            int i = gVar.egC;
                            String es = ((com.tencent.mm.plugin.m.a.a) g.K(com.tencent.mm.plugin.m.a.a.class)).XT().es(str2, i);
                            int asZ = i - ((int) com.tencent.mm.vfs.e.asZ(es));
                            if (!bo.isNullOrNil(es) && asZ >= 0 && asZ <= 16) {
                                ab.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, es);
                                com.tencent.mm.vfs.e.y(es, gVar.field_fullpath);
                                s ut = u.ut(gVar.filename);
                                a(ut, i, str2);
                                bi jf = ((j) g.K(j.class)).bOr().jf((long) ut.fXe);
                                ((j) g.K(j.class)).bOr().a(new c(jf.field_talker, "update", jf));
                                obj = 1;
                                if (obj == null) {
                                    lp lpVar = new lp();
                                    lpVar.cHq.cAd = 6;
                                    lpVar.cHq.cHr = str;
                                    com.tencent.mm.sdk.b.a.xxA.m(lpVar);
                                } else {
                                    int a;
                                    if (gVar.Jr()) {
                                        a = f.afy().a(gVar, gVar.egD);
                                    } else if (gVar.Jp()) {
                                        a = f.afy().a(gVar.field_mediaId, gVar.url, gVar.referer, gVar.field_fullpath, gVar.egD, gVar.ege, gVar.isColdSnsData, gVar.signalQuality, gVar.snsScene, gVar.field_preloadRatio, gVar.field_requestVideoFormat, 4);
                                    } else if (gVar.Jt()) {
                                        a = f.afy().b(gVar.field_mediaId, gVar.url, gVar.referer, gVar.field_fullpath, gVar.egD, gVar.ege, gVar.isColdSnsData, gVar.signalQuality, gVar.snsScene, gVar.field_preloadRatio, gVar.field_requestVideoFormat, 4);
                                    } else if (gVar.Jq()) {
                                        a = f.afy().a(gVar.field_mediaId, gVar.url, gVar.referer, gVar.field_fullpath, gVar.egD, gVar.field_preloadRatio, gVar.concurrentCount);
                                    } else {
                                        a = f.afy().a(gVar.field_mediaId, gVar.url, gVar.referer, gVar.field_fullpath, gVar.egD, gVar.ege, gVar.field_preloadRatio);
                                    }
                                    ab.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", gVar, Integer.valueOf(a));
                                    if (a != 0) {
                                        ab.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + gVar.field_mediaId);
                                        boolean Jr = gVar.Jr();
                                        int i2 = gVar.egD;
                                        if (Jr) {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 3, 1, false);
                                            if (i2 == 1) {
                                                if (a == -21006) {
                                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 100, 1, false);
                                                } else if (a == -20003) {
                                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 101, 1, false);
                                                } else {
                                                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 102, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 106, 1, false);
                                            } else if (a == -20003) {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 107, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 108, 1, false);
                                            }
                                            com.tencent.mm.plugin.report.service.h.pYm.e(13836, Integer.valueOf(100), Long.valueOf(bo.anT()), "");
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 210, 1, false);
                                            if (i2 == 1) {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 211, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 212, 1, false);
                                            }
                                            com.tencent.mm.plugin.report.service.h.pYm.e(13836, Integer.valueOf(200), Long.valueOf(bo.anT()), "");
                                        }
                                    } else {
                                        gVar.egA = bo.anU();
                                        if (gVar.Jr()) {
                                            s ut2 = u.ut(gVar.filename);
                                            if (ut2 != null) {
                                                int i3 = ut2.status;
                                                if (!(i3 == 120 || i3 == 122 || i3 == 121)) {
                                                    ut2.status = 120;
                                                    ut2.bJt = 256;
                                                    o.all().c(ut2);
                                                }
                                            }
                                        }
                                        this.fyM.put(gVar.field_mediaId, gVar);
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    }
                }
            }
            AppMethodBeat.o(50577);
            return;
        }
        AppMethodBeat.o(50577);
    }

    public final void onMoovReady(final String str, final int i, final int i2) {
        AppMethodBeat.i(50578);
        ab.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50578);
            return;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                boolean z = false;
                AppMethodBeat.i(50565);
                h hVar = (h) e.this.fyM.get(str);
                if (hVar != null) {
                    hVar.egJ = (long) i;
                    if (hVar.egK != null) {
                        hVar.egK.onMoovReady(str, i, i2);
                        AppMethodBeat.o(50565);
                        return;
                    } else if (r.ua(hVar.field_fullpath)) {
                        ab.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + hVar.egD);
                        if (hVar.egD == 1) {
                            e.k(hVar.field_mediaId, 0, hVar.field_totalLen);
                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 19, 1, false);
                        }
                        AppMethodBeat.o(50565);
                        return;
                    } else {
                        lp lpVar = new lp();
                        lpVar.cHq.cAd = 1;
                        lpVar.cHq.retCode = 0;
                        lpVar.cHq.cHr = str;
                        lpVar.cHq.offset = i;
                        lpVar.cHq.length = i2;
                        lpVar.cHq.cHs = hVar.egA;
                        lp.a aVar = lpVar.cHq;
                        if (hVar.initialDownloadLength > 0) {
                            z = true;
                        }
                        aVar.cHt = z;
                        com.tencent.mm.sdk.b.a.xxA.m(lpVar);
                        s ut = u.ut(hVar.filename);
                        if (ut != null) {
                            ab.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ut.getFileName() + " status : " + ut.status);
                            if (ut.status == 130) {
                                AppMethodBeat.o(50565);
                                return;
                            } else if (ut.status != 122) {
                                ut = u.ut(hVar.filename);
                                if (ut != null) {
                                    ut.status = 121;
                                    ut.bJt = 256;
                                    o.all().c(ut);
                                }
                                if (hVar.egD == 0) {
                                    ab.i("MicroMsg.OnlineVideoService", "stop download video");
                                    o.alq().alG();
                                    o.alq().run();
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.o(50565);
            }
        });
        AppMethodBeat.o(50578);
    }

    public final void onDataAvailable(final String str, final int i, final int i2) {
        AppMethodBeat.i(50579);
        ab.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50579);
            return;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50566);
                h hVar = (h) e.this.fyM.get(str);
                if (hVar != null) {
                    if (hVar.egK != null) {
                        hVar.egK.onDataAvailable(str, i, i2);
                    }
                    lp lpVar = new lp();
                    lpVar.cHq.cAd = 2;
                    lpVar.cHq.retCode = 0;
                    lpVar.cHq.cHr = str;
                    lpVar.cHq.offset = i;
                    lpVar.cHq.length = i2;
                    com.tencent.mm.sdk.b.a.xxA.m(lpVar);
                }
                AppMethodBeat.o(50566);
            }
        });
        AppMethodBeat.o(50579);
    }

    public final void onDownloadToEnd(final String str, final int i, final int i2) {
        AppMethodBeat.i(50580);
        ab.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50580);
            return;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50567);
                h hVar = (h) e.this.fyM.get(str);
                if (hVar != null) {
                    lp lpVar = new lp();
                    lpVar.cHq.cAd = 3;
                    lpVar.cHq.retCode = 0;
                    lpVar.cHq.cHr = str;
                    lpVar.cHq.offset = i;
                    lpVar.cHq.length = i2;
                    com.tencent.mm.sdk.b.a.xxA.m(lpVar);
                    if (i == 0 && i2 >= hVar.egC) {
                        e.a(u.ut(hVar.filename), hVar.egC, hVar.egB);
                    }
                }
                AppMethodBeat.o(50567);
            }
        });
        AppMethodBeat.o(50580);
    }

    public final int a(final String str, final com.tencent.mm.i.c cVar, final d dVar) {
        AppMethodBeat.i(50581);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            AppMethodBeat.o(50581);
            return -1;
        } else if (cVar == null && dVar == null) {
            ab.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            AppMethodBeat.o(50581);
            return -2;
        } else {
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(50559);
                    h hVar = (h) e.this.fyM.get(str);
                    if (hVar == null) {
                        AppMethodBeat.o(50559);
                    } else if (hVar.egK != null) {
                        ab.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", str);
                        if (cVar != null) {
                            hVar.egK.h(str, cVar.field_finishedLength, cVar.field_toltalLength);
                            AppMethodBeat.o(50559);
                        } else if (dVar != null) {
                            ab.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", str, Integer.valueOf(dVar.field_retCode));
                            hVar.egK.a(str, dVar.field_retCode, dVar);
                            e.this.fyM.remove(str);
                            if (dVar.field_retCode == 0) {
                                e.this.fzq.put(hVar.field_mediaId, hVar);
                                e.this.fzr.put(hVar.field_mediaId, dVar);
                            }
                            AppMethodBeat.o(50559);
                        } else {
                            AppMethodBeat.o(50559);
                        }
                    } else {
                        s ut = u.ut(hVar.filename);
                        lp lpVar;
                        if (ut == null) {
                            ab.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", hVar.filename);
                            AppMethodBeat.o(50559);
                        } else if (hVar.egl != null) {
                            hVar.egl.a(str, 0, cVar, dVar, hVar.field_onlycheckexist);
                            if (dVar != null) {
                                e.this.fyM.remove(str);
                            }
                            AppMethodBeat.o(50559);
                        } else if (cVar == null) {
                            if (dVar != null) {
                                ab.i("MicroMsg.OnlineVideoService", "callback result info " + dVar.field_retCode + ", filesize:" + dVar.field_fileLength + ",recved:" + dVar.field_recvedBytes);
                                if (dVar.field_retCode != 0) {
                                    if (dVar.field_retCode != -10012) {
                                        u.um(ut.getFileName());
                                    }
                                    boolean Jr = hVar.Jr();
                                    int i = dVar.field_retCode;
                                    int i2 = hVar.egD;
                                    if (Jr) {
                                        if (i2 == 1) {
                                            if (i == -5103059) {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 111, 1, false);
                                            } else if (i == -5103087) {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 112, 1, false);
                                            } else if (i == -10012) {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 113, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.h.pYm.a(354, 114, 1, false);
                                            }
                                        } else if (i == -5103059) {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 116, 1, false);
                                        } else if (i == -5103087) {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 117, 1, false);
                                        } else if (i == -10012) {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 118, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 119, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.h.pYm.e(13836, Integer.valueOf(101), Long.valueOf(bo.anT()), Integer.valueOf(i));
                                    } else {
                                        com.tencent.mm.plugin.report.service.h.pYm.a(354, 213, 1, false);
                                        if (i2 == 1) {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 214, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.pYm.a(354, 215, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.h.pYm.e(13836, Integer.valueOf(201), Long.valueOf(bo.anT()), Integer.valueOf(i));
                                    }
                                } else {
                                    e.a(ut, dVar.field_fileLength, hVar.egB);
                                    e.this.fzq.put(hVar.field_mediaId, hVar);
                                    e.this.fzr.put(hVar.field_mediaId, dVar);
                                }
                                lpVar = new lp();
                                lpVar.cHq.cAd = 4;
                                lpVar.cHq.cHr = str;
                                lpVar.cHq.offset = 0;
                                lpVar.cHq.retCode = dVar.field_retCode;
                                lpVar.cHq.length = dVar.field_fileLength;
                                com.tencent.mm.sdk.b.a.xxA.m(lpVar);
                                e.this.fyM.remove(str);
                            }
                            AppMethodBeat.o(50559);
                        } else if (cVar.field_finishedLength == ut.frO) {
                            ab.i("MicroMsg.OnlineVideoService", "stream download finish.");
                            AppMethodBeat.o(50559);
                        } else if (ut.status == 130 || ut.fWY <= cVar.field_finishedLength) {
                            ab.i("MicroMsg.OnlineVideoService", "callback progress info " + cVar.field_finishedLength);
                            ut.fXb = bo.anT();
                            ut.fWY = cVar.field_finishedLength;
                            ut.bJt = 1040;
                            u.f(ut);
                            lpVar = new lp();
                            lpVar.cHq.cAd = 5;
                            lpVar.cHq.cHr = str;
                            lpVar.cHq.offset = cVar.field_finishedLength;
                            lpVar.cHq.length = cVar.field_toltalLength;
                            com.tencent.mm.sdk.b.a.xxA.m(lpVar);
                            AppMethodBeat.o(50559);
                        } else {
                            ab.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", Integer.valueOf(ut.fWY), Integer.valueOf(cVar.field_finishedLength));
                            AppMethodBeat.o(50559);
                        }
                    }
                }
            });
            if (this.fyM.get(str) != null) {
                AppMethodBeat.o(50581);
                return 1;
            }
            AppMethodBeat.o(50581);
            return 0;
        }
    }

    static void a(s sVar, int i, String str) {
        AppMethodBeat.i(50582);
        ab.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", Integer.valueOf(i));
        if (sVar != null) {
            u.ae(sVar.getFileName(), i);
            i(i, str, sVar.getFileName());
        }
        AppMethodBeat.o(50582);
    }

    private static boolean i(int i, String str, String str2) {
        AppMethodBeat.i(50583);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50583);
            return false;
        }
        o.all();
        String uh = t.uh(str2);
        if (bo.isNullOrNil(str) || i <= 0 || bo.isNullOrNil(uh)) {
            ab.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, uh);
            AppMethodBeat.o(50583);
            return false;
        }
        boolean y = ((com.tencent.mm.plugin.m.a.a) g.K(com.tencent.mm.plugin.m.a.a.class)).XT().y(str, i, uh);
        AppMethodBeat.o(50583);
        return y;
    }

    public static h rQ(String str) {
        AppMethodBeat.i(50584);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50584);
            return null;
        }
        s ut = u.ut(str);
        if (ut == null) {
            AppMethodBeat.o(50584);
            return null;
        }
        Map z = br.z(ut.alw(), "msg");
        if (z == null) {
            ab.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
            AppMethodBeat.o(50584);
            return null;
        }
        String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
        if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
            AppMethodBeat.o(50584);
            return null;
        }
        int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
        String str3 = (String) z.get(".msg.videomsg.$md5");
        String str4 = (String) z.get(".msg.videomsg.$aeskey");
        String str5 = (String) z.get(".msg.videomsg.$fileparam");
        String a = c.a("downvideo", ut.createTime, ut.getUser(), ut.getFileName());
        if (bo.isNullOrNil(a)) {
            ab.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", ut.getFileName());
            AppMethodBeat.o(50584);
            return null;
        }
        int i;
        o.all();
        String uh = t.uh(str);
        h hVar = new h();
        hVar.filename = str;
        hVar.egB = str3;
        hVar.egC = intValue;
        hVar.egD = 1;
        hVar.cEV = ut.alt();
        hVar.egE = ut.getUser();
        hVar.cEX = com.tencent.mm.model.t.kH(ut.getUser()) ? n.mA(ut.getUser()) : 0;
        hVar.field_mediaId = a;
        hVar.field_fullpath = uh;
        hVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        hVar.field_totalLen = intValue;
        hVar.field_aesKey = str4;
        hVar.field_fileId = str2;
        hVar.field_priority = com.tencent.mm.i.a.efC;
        hVar.field_wxmsgparam = str5;
        if (com.tencent.mm.model.t.kH(ut.getUser())) {
            i = 1;
        } else {
            i = 0;
        }
        hVar.field_chattype = i;
        hVar.egF = ut.egF;
        bi Q = ((j) g.K(j.class)).bOr().Q(ut.getUser(), ut.cKK);
        b oE = bf.oE(Q.dqJ);
        hVar.initialDownloadLength = 0;
        hVar.initialDownloadOffset = 0;
        hVar.egH = Q.field_createTime;
        hVar.cKK = Q.field_msgSvrId;
        hVar.egI = oE != null ? oE.fmG : 0;
        if (hVar.initialDownloadLength > 0) {
            com.tencent.mm.plugin.report.service.h.pYm.a(354, 36, 1, false);
        }
        hVar.field_autostart = false;
        hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, ut);
        AppMethodBeat.o(50584);
        return hVar;
    }

    public static h a(az azVar, String str, String str2, String str3, int i) {
        AppMethodBeat.i(50585);
        if (azVar == null) {
            ab.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            AppMethodBeat.o(50585);
            return null;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            AppMethodBeat.o(50585);
            return null;
        } else {
            s ut = u.ut(str3);
            if (ut == null) {
                ab.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", str3);
                AppMethodBeat.o(50585);
                return null;
            }
            String a = c.a("snsvideo", (long) azVar.oyB, "sns", str);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", str);
                AppMethodBeat.o(50585);
                return null;
            }
            h hVar = new h();
            hVar.filename = str3;
            hVar.field_fullpath = str2;
            hVar.field_mediaId = a;
            hVar.egy = 2;
            hVar.egD = i;
            hVar.egF = ut.egF;
            String str4 = "";
            if (azVar == null) {
                a = "";
            } else if (azVar.equals(az.xYN)) {
                a = "album_friend";
            } else if (azVar.equals(az.xYO)) {
                a = "album_self";
            } else if (azVar.equals(az.xYP)) {
                a = "album_stranger";
            } else if (azVar.equals(az.xYQ)) {
                a = "profile_friend";
            } else if (azVar.equals(az.xYR)) {
                a = "profile_stranger";
            } else if (azVar.equals(az.xYS)) {
                a = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
            } else if (azVar.equals(az.xYM)) {
                a = "timeline";
            } else if (azVar.equals(az.xYV)) {
                a = "snssight";
            } else if (azVar.equals(az.xYX)) {
                a = "storysight";
            } else {
                a = str4;
            }
            String str5 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            r3 = new Object[5];
            g.RQ();
            g.RN();
            r3[1] = p.getString(com.tencent.mm.kernel.a.QF());
            r3[2] = Integer.valueOf(at.getNetTypeForStat(ah.getContext()));
            r3[3] = Integer.valueOf(at.getStrength(ah.getContext()));
            r3[4] = !bo.isNullOrNil(a) ? "&scene=".concat(String.valueOf(a)) : "";
            hVar.referer = String.format(str5, r3);
            hVar.url = str;
            long j = (long) ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            ab.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("SnsSightDomainList"), Long.valueOf(j), Integer.valueOf(azVar.oyB));
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = a(azVar, hVar.url, j, r5);
            try {
                hVar.host = new URL(hVar.url).getHost();
                List arrayList = new ArrayList();
                com.tencent.mm.network.b.a(a2, arrayList, hVar.host);
                hVar.ege = new String[arrayList.size()];
                arrayList.toArray(hVar.ege);
                hVar.isColdSnsData = bo.fp((long) azVar.oyB) > j;
                hVar.signalQuality = at.getStrength(ah.getContext());
                hVar.snsScene = a;
                if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.mmsns_video_hevc_download_and, false)) {
                    hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.u(i, str2);
                }
                AppMethodBeat.o(50585);
                return hVar;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", hVar);
                AppMethodBeat.o(50585);
                return null;
            }
        }
    }

    private static boolean a(az azVar, String str, long j, String str2) {
        AppMethodBeat.i(50586);
        if (str == null) {
            AppMethodBeat.o(50586);
            return false;
        }
        try {
            URL url = new URL(str);
            if (azVar == null) {
                AppMethodBeat.o(50586);
                return false;
            } else if (str2 == null) {
                AppMethodBeat.o(50586);
                return false;
            } else if (str2.indexOf(url.getHost()) == -1) {
                AppMethodBeat.o(50586);
                return false;
            } else if (azVar.oyB == 0) {
                AppMethodBeat.o(50586);
                return false;
            } else if (bo.fp((long) azVar.oyB) > j) {
                AppMethodBeat.o(50586);
                return true;
            } else {
                AppMethodBeat.o(50586);
                return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.OnlineVideoService", "error for check dcip %s", e.getMessage());
            AppMethodBeat.o(50586);
            return false;
        }
    }

    public static void a(Object[] objArr, d dVar, h hVar, boolean z) {
        AppMethodBeat.i(50587);
        if (hVar == null || dVar == null) {
            ab.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
            AppMethodBeat.o(50587);
        } else if (hVar.Jp() || hVar.Jr() || hVar.Jt()) {
            int intValue;
            int intValue2;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            int intValue7;
            int i;
            int i2;
            int i3;
            String str = dVar.field_clientIP;
            ab.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", Integer.valueOf(dVar.field_videoFormat), str, Integer.valueOf(dVar.field_isCrossNet ? 1 : 0));
            if (dVar.field_videoFormat == 2) {
                u.ux(hVar.filename);
            }
            if (bo.isNullOrNil(str)) {
                com.tencent.mm.plugin.report.service.h.pYm.a(354, 45, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(354, 46, 1, false);
            }
            if (dVar.field_isCrossNet) {
                com.tencent.mm.plugin.report.service.h.pYm.a(354, 47, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(354, 48, 1, false);
            }
            boolean Jr = hVar.Jr();
            boolean Jt = hVar.Jt();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            u.a(hVar.field_fullpath, pInt, pInt2);
            int i4 = pInt.value * 1000;
            int i5 = pInt2.value;
            if (objArr != null) {
                intValue = ((Integer) objArr[0]).intValue() * 1000;
                intValue2 = ((Integer) objArr[1]).intValue();
                intValue3 = ((Integer) objArr[2]).intValue();
                intValue4 = ((Integer) objArr[3]).intValue();
                intValue5 = ((Integer) objArr[4]).intValue();
                intValue6 = ((Integer) objArr[5]).intValue();
                intValue7 = ((Integer) objArr[6]).intValue();
                i = intValue4;
                i2 = intValue;
            } else {
                i = 0;
                intValue5 = 0;
                intValue6 = 0;
                intValue7 = 0;
                i2 = 0;
                intValue2 = 0;
                intValue3 = 0;
            }
            intValue4 = hVar.egF;
            if (intValue4 <= 0) {
                if (Jr) {
                    intValue4 = 10;
                } else {
                    intValue4 = 31;
                }
            }
            intValue = at.gC(ah.getContext());
            String Jn = dVar.Jn();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            a(pInt3, pInt4, hVar.filename, hVar.egI);
            StringBuffer stringBuffer = new StringBuffer();
            if (Jr) {
                stringBuffer.append(hVar.field_fileId).append(",").append(hVar.field_aesKey).append(",");
            } else {
                stringBuffer.append(hVar.url).append(",").append(hVar.egG).append(",");
            }
            stringBuffer.append(dVar.field_fileLength).append(",").append(i4).append(",");
            stringBuffer.append(dVar.field_recvedBytes).append(",");
            stringBuffer.append(i2 + ",").append(intValue2 + ",").append(intValue3 + ",");
            stringBuffer.append(i + ",").append(intValue5 + ",");
            stringBuffer.append(intValue).append(",");
            stringBuffer.append(intValue4).append(",");
            stringBuffer.append(dVar.field_startTime).append(",");
            stringBuffer.append(dVar.field_endTime).append(",");
            if (Jr) {
                stringBuffer.append(hVar.egE != null ? com.tencent.mm.a.g.x(hVar.egE.getBytes()) : Integer.valueOf(0)).append(",");
                stringBuffer.append(com.tencent.mm.model.t.kH(hVar.egE) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(dVar.field_httpStatusCode).append(",");
            }
            stringBuffer.append(dVar.field_retCode).append(",");
            stringBuffer.append(dVar.field_enQueueTime).append(",");
            stringBuffer.append(dVar.field_firstRequestCost).append(",");
            stringBuffer.append(dVar.field_firstRequestSize).append(",");
            stringBuffer.append(dVar.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(dVar.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(dVar.field_averageSpeed).append(",");
            stringBuffer.append(dVar.field_averageConnectCost).append(",");
            stringBuffer.append(dVar.field_firstConnectCost).append(",");
            stringBuffer.append(dVar.field_netConnectTimes).append(",");
            stringBuffer.append(dVar.field_moovRequestTimes).append(",");
            stringBuffer.append(dVar.field_moovCost).append(",");
            stringBuffer.append(dVar.field_moovSize).append(",");
            stringBuffer.append(dVar.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(dVar.field_moovFailReason).append(",");
            stringBuffer.append(intValue6).append(",");
            stringBuffer.append(intValue7).append(",");
            if (Jr) {
                stringBuffer.append(i5).append(",");
            } else {
                stringBuffer.append(i5).append(",");
                stringBuffer.append(hVar.egE != null ? com.tencent.mm.a.g.x(hVar.egE.getBytes()) : Integer.valueOf(0)).append(",");
            }
            stringBuffer.append(Jn).append(",");
            if (Jr) {
                stringBuffer.append(hVar.egH).append(",");
                stringBuffer.append(hVar.cKK).append(",");
                stringBuffer.append(hVar.initialDownloadLength).append(",");
                stringBuffer.append(dVar.field_videoFormat).append(",");
            } else {
                stringBuffer.append(com.tencent.mm.plugin.video.c.abR(hVar.cFc)).append(",");
            }
            stringBuffer.append(str).append(",");
            stringBuffer.append(i3).append(",");
            stringBuffer.append(hVar.egJ).append(",");
            stringBuffer.append(pInt3.value).append(",");
            stringBuffer.append(pInt4.value);
            intValue4 = Jr ? 13570 : 13790;
            if (Jt) {
                intValue4 = 13570;
            }
            String stringBuffer2 = stringBuffer.toString();
            ab.i("MicroMsg.OnlineVideoService", "report online video %d:%s", Integer.valueOf(intValue4), stringBuffer2);
            if (Jr) {
                new com.tencent.mm.g.b.a.s(stringBuffer2).ajK();
            } else if (Jt) {
                long j;
                int i6 = 0;
                int i7 = 0;
                String str2 = "";
                long j2 = 0;
                int i8 = 0;
                int i9 = 0;
                i3 = 0;
                intValue4 = 0;
                if (objArr != null && objArr.length >= 11) {
                    i6 = bo.getInt(objArr[7].toString(), 0);
                    bo.getInt(objArr[8].toString(), 0);
                    i7 = bo.getInt(objArr[9].toString(), 0);
                    str2 = objArr[11].toString();
                    i8 = bo.getInt(objArr[12].toString(), 0);
                    j2 = bo.getLong(objArr[13].toString(), 0);
                    i9 = bo.getInt(objArr[14].toString(), 0);
                    i3 = bo.getInt(objArr[15].toString(), 0);
                    intValue4 = bo.getInt(objArr[16].toString(), 0);
                }
                bm bmVar = new bm();
                bm gf = bmVar.gf(str2);
                gf.dcr = (long) i8;
                gf.dcs = (long) i3;
                gf.dct = (long) i9;
                gf.cVG = (long) i4;
                gf.dcu = (long) (i2 / 1000);
                gf.cXi = (long) intValue2;
                gf.cXj = (long) intValue3;
                gf.dcv = (long) i;
                gf.cXl = (long) intValue5;
                gf.dcw = 0;
                gf.cXF = (long) intValue6;
                gf.dcx = (long) intValue7;
                bm gg = gf.gg("");
                gg.cVH = (long) (i5 * 1000);
                gg = gg.gh(hVar.field_requestVideoFormat);
                gg.cTL = (long) dVar.field_fileLength;
                gg.dcA = (long) dVar.field_recvedBytes;
                gg.cXo = dVar.field_startTime;
                gg.cXp = dVar.field_endTime;
                gg.dcB = (long) dVar.field_retCode;
                gg.dcC = dVar.field_enQueueTime;
                gg.dcD = (long) dVar.field_moovRequestTimes;
                gg.dcE = (long) dVar.field_moovCost;
                gg.cXC = (long) dVar.field_moovSize;
                if (dVar.field_moovCompleted) {
                    j = 1;
                } else {
                    j = 0;
                }
                gg.dcF = j;
                gg.dcG = (long) dVar.field_moovFailReason;
                gg.dcH = (long) dVar.field_firstConnectCost;
                gg.dcI = (long) dVar.field_firstRequestCost;
                gg.dcJ = (long) dVar.field_firstRequestSize;
                gg.dcK = (long) dVar.field_firstRequestDownloadSize;
                if (dVar.field_firstRequestCompleted) {
                    j = 1;
                } else {
                    j = 0;
                }
                gg.dcL = j;
                gg.dcM = (long) dVar.field_averageSpeed;
                gg.dcN = (long) dVar.field_averageConnectCost;
                gg.cXz = (long) dVar.field_netConnectTimes;
                gg = gg.gi(dVar.Jn()).gj(dVar.field_clientIP);
                if (dVar.field_isCrossNet) {
                    j = 1;
                } else {
                    j = 0;
                }
                gg.dcP = j;
                gg.cXN = hVar.egJ;
                gg.dcQ = (long) i7;
                gg.cTJ = (long) intValue;
                gg.dcR = j2;
                gg.cVO = (long) i6;
                gg.dcS = (long) intValue4;
                ab.d("MicroMsg.OnlineVideoService", "time distance %d", Long.valueOf(System.currentTimeMillis() - bmVar.dcR));
                if (System.currentTimeMillis() - bmVar.dcR > 500) {
                    bmVar.ajK();
                }
                an anVar = new an();
                com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(hVar.field_fullpath);
                if (WR != null) {
                    anVar.cVG = (long) WR.eWK;
                    anVar.cVH = (long) WR.videoBitrate;
                    anVar.cVI = (long) WR.fzS;
                    anVar.cVJ = (long) WR.eTk;
                    anVar.cVK = (long) WR.width;
                    anVar.cVL = (long) WR.height;
                    anVar.cVN = (long) WR.qwV;
                }
                anVar.cVF = (long) dVar.field_fileLength;
                anVar = anVar.ft(hVar.url);
                f.afy();
                anVar = anVar.fu(a.rJ(hVar.field_fullpath));
                anVar.cVD = dVar.field_startTime;
                anVar.cVE = dVar.field_endTime;
                anVar = anVar.fv(Jn);
                anVar.cVO = (long) i6;
                anVar.cVP = (long) pInt4.value;
                anVar.ajK();
            } else {
                new ai(stringBuffer2).ajK();
            }
            if (z) {
                a(hVar.cEV, hVar.egE, hVar.cEX, dVar.field_fileId, intValue, dVar.field_startTime, dVar.field_endTime, hVar.field_fullpath, dVar.field_usedSvrIps, hVar.url, pInt3.value, pInt4.value, hVar.cFc);
            }
            if (Jr) {
                if (dVar.field_videoFormat == 2) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 132, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 133, 1, false);
                }
                s ut = u.ut(hVar.filename);
                if (ut != null) {
                    bi jf = ((j) g.K(j.class)).bOr().jf((long) ut.fXe);
                    ((j) g.K(j.class)).bOr().a(new c(jf.field_talker, "update", jf));
                }
            }
            AppMethodBeat.o(50587);
        } else {
            AppMethodBeat.o(50587);
        }
    }

    private static void a(PInt pInt, PInt pInt2, String str, int i) {
        int i2;
        int i3;
        AppMethodBeat.i(50588);
        int i4 = 0;
        s ut = u.ut(str);
        if (ut != null) {
            i4 = ut.cFa;
            i2 = ut.frO;
        } else {
            i2 = 0;
        }
        if (i <= 0) {
            i3 = 1;
        } else {
            if (i4 < ((int) ((((float) i) / 100.0f) * ((float) i2)))) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            ab.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) ((((float) i) / 100.0f) * ((float) i2))), Integer.valueOf(i4));
        }
        pInt.value = i4;
        pInt2.value = i3;
        ab.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        AppMethodBeat.o(50588);
    }

    private static void a(String str, String str2, int i, String str3, int i2, long j, long j2, String str4, String[] strArr, String str5, int i3, int i4, String str6) {
        AppMethodBeat.i(50589);
        jv jvVar = new jv();
        jvVar.cEU.cEV = str;
        jvVar.cEU.cEW = str2;
        jvVar.cEU.cEX = i;
        jvVar.cEU.fileId = str3;
        jvVar.cEU.netType = i2;
        jvVar.cEU.startTime = j;
        jvVar.cEU.endTime = j2;
        jvVar.cEU.path = str4;
        jvVar.cEU.cEY = strArr;
        jvVar.cEU.cEZ = str5;
        jvVar.cEU.cFa = i3;
        jvVar.cEU.cFb = i4;
        jvVar.cEU.cFc = str6;
        com.tencent.mm.sdk.b.a.xxA.m(jvVar);
        AppMethodBeat.o(50589);
    }
}
