package com.tencent.p177mm.p187al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C8941a.C8943a;
import com.tencent.p177mm.p230g.p231a.C18307jv;
import com.tencent.p177mm.p230g.p231a.C32594lp;
import com.tencent.p177mm.p230g.p231a.C32594lp.C9414a;
import com.tencent.p177mm.p230g.p232b.p233a.C32662an;
import com.tencent.p177mm.p230g.p232b.p233a.C32676s;
import com.tencent.p177mm.p230g.p232b.p233a.C9501ai;
import com.tencent.p177mm.p230g.p232b.p233a.C9505bm;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.video.C14013c;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.al.e */
public final class C45150e implements C1202f, C8943a {
    Queue<String> fyK = new LinkedList();
    Map<String, C44686h> fyL = new HashMap();
    Map<String, C44686h> fyM = new HashMap();
    Map<String, C44686h> fzq = new HashMap();
    Map<String, C9545d> fzr = new HashMap();

    /* renamed from: com.tencent.mm.al.e$1 */
    class C89461 implements Runnable {
        C89461() {
        }

        public final void run() {
            AppMethodBeat.m2504i(50558);
            C45150e.this.mo73061cK(true);
            AppMethodBeat.m2505o(50558);
        }
    }

    public C45150e() {
        AppMethodBeat.m2504i(50568);
        C1720g.m3540Rg().mo14539a(379, (C1202f) this);
        AppMethodBeat.m2505o(50568);
    }

    public final void release() {
        AppMethodBeat.m2504i(50569);
        C1720g.m3540Rg().mo14546b(379, (C1202f) this);
        AppMethodBeat.m2505o(50569);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(50570);
        if (c1207m.getType() != 379) {
            AppMethodBeat.m2505o(50570);
            return;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", Integer.valueOf(i), Integer.valueOf(i2));
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3539RS().mo10302aa(new C89461());
        }
        AppMethodBeat.m2505o(50570);
    }

    /* renamed from: a */
    public final boolean mo73060a(final C44686h c44686h, boolean z) {
        AppMethodBeat.m2504i(50571);
        if (c44686h == null) {
            C4990ab.m7412e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            AppMethodBeat.m2505o(50571);
            return false;
        } else if (C5046bo.isNullOrNil(c44686h.field_mediaId)) {
            C4990ab.m7412e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            AppMethodBeat.m2505o(50571);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.OnlineVideoService", "add download task : " + c44686h.field_mediaId + " delay : " + z);
            if (c44686h.field_fileId == null) {
                c44686h.field_fileId = "";
            }
            if (c44686h.field_aesKey == null) {
                c44686h.field_aesKey = "";
            }
            c44686h.cRY = false;
            if (mo73064m(c44686h.field_mediaId, null) || z) {
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(50560);
                        C45150e.this.fyK.add(c44686h.field_mediaId);
                        C45150e.this.fyL.put(c44686h.field_mediaId, c44686h);
                        C45150e.this.mo73061cK(false);
                        AppMethodBeat.m2505o(50560);
                    }
                });
            } else {
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(50561);
                        C45150e.this.fyK.add(c44686h.field_mediaId);
                        C45150e.this.fyL.put(c44686h.field_mediaId, c44686h);
                        C45150e.this.mo73061cK(false);
                        AppMethodBeat.m2505o(50561);
                    }
                });
            }
            AppMethodBeat.m2505o(50571);
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo73059a(final C44686h c44686h) {
        AppMethodBeat.m2504i(50572);
        if (C5046bo.isNullOrNil(c44686h.field_mediaId)) {
            C4990ab.m7412e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            AppMethodBeat.m2505o(50572);
            return false;
        }
        C4990ab.m7416i("MicroMsg.OnlineVideoService", "add download task : " + c44686h.field_mediaId);
        if (c44686h.field_fileId == null) {
            c44686h.field_fileId = "";
        }
        if (c44686h.field_aesKey == null) {
            c44686h.field_aesKey = "";
        }
        c44686h.cRY = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(50562);
                    C45150e.this.fyK.add(c44686h.field_mediaId);
                    C45150e.this.fyL.put(c44686h.field_mediaId, c44686h);
                    C45150e.this.mo73061cK(false);
                    AppMethodBeat.m2505o(50562);
                }
            });
        } else {
            this.fyK.add(c44686h.field_mediaId);
            this.fyL.put(c44686h.field_mediaId, c44686h);
            mo73061cK(false);
        }
        AppMethodBeat.m2505o(50572);
        return true;
    }

    /* renamed from: l */
    public final boolean mo73063l(final String str, final Object[] objArr) {
        boolean z;
        AppMethodBeat.m2504i(50573);
        if (C5046bo.isNullOrNil(str)) {
            z = false;
        } else {
            if (this.fyM.containsKey(str)) {
                z = true;
            } else {
                C37461f.afx().mo51228rO(str);
                z = false;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(50563);
                        C44686h c44686h = (C44686h) C45150e.this.fyM.remove(str);
                        C9545d c9545d;
                        if (c44686h != null) {
                            c9545d = new C9545d();
                            C37461f.afy();
                            if (C8941a.m16121b(c44686h.field_mediaId, c9545d) == 0) {
                                C45150e.m83028a(objArr, c9545d, c44686h, false);
                            } else {
                                C4990ab.m7421w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(C8941a.m16121b(c44686h.field_mediaId, c9545d)), c44686h.field_mediaId);
                            }
                        } else {
                            c44686h = (C44686h) C45150e.this.fzq.remove(str);
                            c9545d = (C9545d) C45150e.this.fzr.remove(str);
                            if (!(c44686h == null || c9545d == null)) {
                                C45150e.m83028a(objArr, c9545d, c44686h, true);
                            }
                        }
                        C45150e.this.fyL.remove(str);
                        AppMethodBeat.m2505o(50563);
                    }
                });
            } else {
                C44686h c44686h = (C44686h) this.fyM.remove(str);
                if (c44686h != null) {
                    C9545d c9545d = new C9545d();
                    C37461f.afy();
                    if (C8941a.m16121b(c44686h.field_mediaId, c9545d) == 0) {
                        C45150e.m83028a(objArr, c9545d, c44686h, false);
                    } else {
                        C4990ab.m7421w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(C8941a.m16121b(c44686h.field_mediaId, c9545d)), c44686h.field_mediaId);
                    }
                } else {
                    c44686h = (C44686h) this.fzq.remove(str);
                    C9545d c9545d2 = (C9545d) this.fzr.remove(str);
                    if (!(c44686h == null || c9545d2 == null)) {
                        C45150e.m83028a(objArr, c9545d2, c44686h, true);
                    }
                }
                this.fyL.remove(str);
            }
        }
        C4990ab.m7416i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + str + " remove : " + z);
        AppMethodBeat.m2505o(50573);
        return z;
    }

    /* renamed from: m */
    public final boolean mo73064m(final String str, final Object[] objArr) {
        AppMethodBeat.m2504i(50574);
        boolean z = false;
        if (!C5046bo.isNullOrNil(str)) {
            if (this.fyM.containsKey(str)) {
                z = true;
            } else {
                C37461f.afx().mo51228rO(str);
            }
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(50564);
                    C44686h c44686h = (C44686h) C45150e.this.fyM.remove(str);
                    C9545d c9545d;
                    if (c44686h != null) {
                        c9545d = new C9545d();
                        C37461f.afy();
                        if (C8941a.m16121b(c44686h.field_mediaId, c9545d) == 0) {
                            C45150e.m83028a(objArr, c9545d, c44686h, false);
                        } else {
                            C4990ab.m7421w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(C8941a.m16121b(c44686h.field_mediaId, c9545d)), c44686h.field_mediaId);
                        }
                    } else {
                        c44686h = (C44686h) C45150e.this.fzq.remove(str);
                        c9545d = (C9545d) C45150e.this.fzr.remove(str);
                        if (!(c44686h == null || c9545d == null)) {
                            C45150e.m83028a(objArr, c9545d, c44686h, true);
                        }
                    }
                    C45150e.this.fyL.remove(str);
                    AppMethodBeat.m2505o(50564);
                }
            });
        }
        C4990ab.m7416i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        AppMethodBeat.m2505o(50574);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        AppMethodBeat.m2504i(50575);
        if (((C44686h) this.fyM.get(str)) == null) {
            C4990ab.m7417i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", str);
            AppMethodBeat.m2505o(50575);
            return false;
        }
        C37461f.afy();
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(C8941a.isVideoDataAvailable(str, i, i2)));
        AppMethodBeat.m2505o(50575);
        return C8941a.isVideoDataAvailable(str, i, i2);
    }

    /* renamed from: k */
    public static int m83031k(String str, int i, int i2) {
        AppMethodBeat.m2504i(50576);
        C37461f.afy();
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(C8941a.m16125k(str, i, i2)));
        AppMethodBeat.m2505o(50576);
        return C8941a.m16125k(str, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cK */
    public final void mo73061cK(boolean z) {
        AppMethodBeat.m2504i(50577);
        if (C1720g.m3531RK()) {
            if (!z && C37461f.afy().afq()) {
                C1720g.m3534RN();
                if (C1668a.m3395QX()) {
                    C4990ab.m7420w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
                    C37461f.afx().mo51223cK(z);
                    AppMethodBeat.m2505o(50577);
                    return;
                }
            }
            C37461f.afx().afs();
            while (!this.fyK.isEmpty()) {
                String str = (String) this.fyK.poll();
                C42130g c42130g = (C44686h) this.fyL.remove(str);
                if (c42130g != null) {
                    c42130g.field_startTime = C5046bo.anU();
                    if (!c42130g.cRY) {
                        Object obj;
                        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                            C4990ab.m7416i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else if (!c42130g.mo67678Js()) {
                            String str2 = c42130g.egB;
                            int i = c42130g.egC;
                            String es = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16778es(str2, i);
                            int asZ = i - ((int) C5730e.asZ(es));
                            if (!C5046bo.isNullOrNil(es) && asZ >= 0 && asZ <= 16) {
                                C4990ab.m7417i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, es);
                                C5730e.m8644y(es, c42130g.field_fullpath);
                                C26493s ut = C26494u.m42268ut(c42130g.filename);
                                C45150e.m83025a(ut, i, str2);
                                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe);
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(jf.field_talker, "update", jf));
                                obj = 1;
                                if (obj == null) {
                                    C32594lp c32594lp = new C32594lp();
                                    c32594lp.cHq.cAd = 6;
                                    c32594lp.cHq.cHr = str;
                                    C4879a.xxA.mo10055m(c32594lp);
                                } else {
                                    int a;
                                    if (c42130g.mo67677Jr()) {
                                        a = C37461f.afy().mo20361a(c42130g, c42130g.egD);
                                    } else if (c42130g.mo67675Jp()) {
                                        a = C37461f.afy().mo20366a(c42130g.field_mediaId, c42130g.url, c42130g.referer, c42130g.field_fullpath, c42130g.egD, c42130g.ege, c42130g.isColdSnsData, c42130g.signalQuality, c42130g.snsScene, c42130g.field_preloadRatio, c42130g.field_requestVideoFormat, 4);
                                    } else if (c42130g.mo67679Jt()) {
                                        a = C37461f.afy().mo20373b(c42130g.field_mediaId, c42130g.url, c42130g.referer, c42130g.field_fullpath, c42130g.egD, c42130g.ege, c42130g.isColdSnsData, c42130g.signalQuality, c42130g.snsScene, c42130g.field_preloadRatio, c42130g.field_requestVideoFormat, 4);
                                    } else if (c42130g.mo67676Jq()) {
                                        a = C37461f.afy().mo20364a(c42130g.field_mediaId, c42130g.url, c42130g.referer, c42130g.field_fullpath, c42130g.egD, c42130g.field_preloadRatio, c42130g.concurrentCount);
                                    } else {
                                        a = C37461f.afy().mo20365a(c42130g.field_mediaId, c42130g.url, c42130g.referer, c42130g.field_fullpath, c42130g.egD, c42130g.ege, c42130g.field_preloadRatio);
                                    }
                                    C4990ab.m7417i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", c42130g, Integer.valueOf(a));
                                    if (a != 0) {
                                        C4990ab.m7420w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + c42130g.field_mediaId);
                                        boolean Jr = c42130g.mo67677Jr();
                                        int i2 = c42130g.egD;
                                        if (Jr) {
                                            C7060h.pYm.mo8378a(354, 3, 1, false);
                                            if (i2 == 1) {
                                                if (a == -21006) {
                                                    C7060h.pYm.mo8378a(354, 100, 1, false);
                                                } else if (a == -20003) {
                                                    C7060h.pYm.mo8378a(354, 101, 1, false);
                                                } else {
                                                    C7060h.pYm.mo8378a(354, 102, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                C7060h.pYm.mo8378a(354, 106, 1, false);
                                            } else if (a == -20003) {
                                                C7060h.pYm.mo8378a(354, 107, 1, false);
                                            } else {
                                                C7060h.pYm.mo8378a(354, 108, 1, false);
                                            }
                                            C7060h.pYm.mo8381e(13836, Integer.valueOf(100), Long.valueOf(C5046bo.anT()), "");
                                        } else {
                                            C7060h.pYm.mo8378a(354, 210, 1, false);
                                            if (i2 == 1) {
                                                C7060h.pYm.mo8378a(354, 211, 1, false);
                                            } else {
                                                C7060h.pYm.mo8378a(354, 212, 1, false);
                                            }
                                            C7060h.pYm.mo8381e(13836, Integer.valueOf(200), Long.valueOf(C5046bo.anT()), "");
                                        }
                                    } else {
                                        c42130g.egA = C5046bo.anU();
                                        if (c42130g.mo67677Jr()) {
                                            C26493s ut2 = C26494u.m42268ut(c42130g.filename);
                                            if (ut2 != null) {
                                                int i3 = ut2.status;
                                                if (!(i3 == 120 || i3 == 122 || i3 == 121)) {
                                                    ut2.status = 120;
                                                    ut2.bJt = 256;
                                                    C37961o.all().mo21060c(ut2);
                                                }
                                            }
                                        }
                                        this.fyM.put(c42130g.field_mediaId, c42130g);
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
            AppMethodBeat.m2505o(50577);
            return;
        }
        AppMethodBeat.m2505o(50577);
    }

    public final void onMoovReady(final String str, final int i, final int i2) {
        AppMethodBeat.m2504i(50578);
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50578);
            return;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                boolean z = false;
                AppMethodBeat.m2504i(50565);
                C44686h c44686h = (C44686h) C45150e.this.fyM.get(str);
                if (c44686h != null) {
                    c44686h.egJ = (long) i;
                    if (c44686h.egK != null) {
                        c44686h.egK.onMoovReady(str, i, i2);
                        AppMethodBeat.m2505o(50565);
                        return;
                    } else if (C26492r.m42228ua(c44686h.field_fullpath)) {
                        C4990ab.m7420w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + c44686h.egD);
                        if (c44686h.egD == 1) {
                            C45150e.m83031k(c44686h.field_mediaId, 0, c44686h.field_totalLen);
                            C7060h.pYm.mo8378a(354, 19, 1, false);
                        }
                        AppMethodBeat.m2505o(50565);
                        return;
                    } else {
                        C32594lp c32594lp = new C32594lp();
                        c32594lp.cHq.cAd = 1;
                        c32594lp.cHq.retCode = 0;
                        c32594lp.cHq.cHr = str;
                        c32594lp.cHq.offset = i;
                        c32594lp.cHq.length = i2;
                        c32594lp.cHq.cHs = c44686h.egA;
                        C9414a c9414a = c32594lp.cHq;
                        if (c44686h.initialDownloadLength > 0) {
                            z = true;
                        }
                        c9414a.cHt = z;
                        C4879a.xxA.mo10055m(c32594lp);
                        C26493s ut = C26494u.m42268ut(c44686h.filename);
                        if (ut != null) {
                            C4990ab.m7416i("MicroMsg.OnlineVideoService", "on moov ready info: " + ut.getFileName() + " status : " + ut.status);
                            if (ut.status == 130) {
                                AppMethodBeat.m2505o(50565);
                                return;
                            } else if (ut.status != 122) {
                                ut = C26494u.m42268ut(c44686h.filename);
                                if (ut != null) {
                                    ut.status = 121;
                                    ut.bJt = 256;
                                    C37961o.all().mo21060c(ut);
                                }
                                if (c44686h.egD == 0) {
                                    C4990ab.m7416i("MicroMsg.OnlineVideoService", "stop download video");
                                    C37961o.alq().alG();
                                    C37961o.alq().run();
                                }
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(50565);
            }
        });
        AppMethodBeat.m2505o(50578);
    }

    public final void onDataAvailable(final String str, final int i, final int i2) {
        AppMethodBeat.m2504i(50579);
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50579);
            return;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(50566);
                C44686h c44686h = (C44686h) C45150e.this.fyM.get(str);
                if (c44686h != null) {
                    if (c44686h.egK != null) {
                        c44686h.egK.onDataAvailable(str, i, i2);
                    }
                    C32594lp c32594lp = new C32594lp();
                    c32594lp.cHq.cAd = 2;
                    c32594lp.cHq.retCode = 0;
                    c32594lp.cHq.cHr = str;
                    c32594lp.cHq.offset = i;
                    c32594lp.cHq.length = i2;
                    C4879a.xxA.mo10055m(c32594lp);
                }
                AppMethodBeat.m2505o(50566);
            }
        });
        AppMethodBeat.m2505o(50579);
    }

    public final void onDownloadToEnd(final String str, final int i, final int i2) {
        AppMethodBeat.m2504i(50580);
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50580);
            return;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(50567);
                C44686h c44686h = (C44686h) C45150e.this.fyM.get(str);
                if (c44686h != null) {
                    C32594lp c32594lp = new C32594lp();
                    c32594lp.cHq.cAd = 3;
                    c32594lp.cHq.retCode = 0;
                    c32594lp.cHq.cHr = str;
                    c32594lp.cHq.offset = i;
                    c32594lp.cHq.length = i2;
                    C4879a.xxA.mo10055m(c32594lp);
                    if (i == 0 && i2 >= c44686h.egC) {
                        C45150e.m83025a(C26494u.m42268ut(c44686h.filename), c44686h.egC, c44686h.egB);
                    }
                }
                AppMethodBeat.m2505o(50567);
            }
        });
        AppMethodBeat.m2505o(50580);
    }

    /* renamed from: a */
    public final int mo20397a(final String str, final C18496c c18496c, final C9545d c9545d) {
        AppMethodBeat.m2504i(50581);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            AppMethodBeat.m2505o(50581);
            return -1;
        } else if (c18496c == null && c9545d == null) {
            C4990ab.m7412e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            AppMethodBeat.m2505o(50581);
            return -2;
        } else {
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(50559);
                    C44686h c44686h = (C44686h) C45150e.this.fyM.get(str);
                    if (c44686h == null) {
                        AppMethodBeat.m2505o(50559);
                    } else if (c44686h.egK != null) {
                        C4990ab.m7417i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", str);
                        if (c18496c != null) {
                            c44686h.egK.mo8706h(str, c18496c.field_finishedLength, c18496c.field_toltalLength);
                            AppMethodBeat.m2505o(50559);
                        } else if (c9545d != null) {
                            C4990ab.m7417i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", str, Integer.valueOf(c9545d.field_retCode));
                            c44686h.egK.mo8705a(str, c9545d.field_retCode, c9545d);
                            C45150e.this.fyM.remove(str);
                            if (c9545d.field_retCode == 0) {
                                C45150e.this.fzq.put(c44686h.field_mediaId, c44686h);
                                C45150e.this.fzr.put(c44686h.field_mediaId, c9545d);
                            }
                            AppMethodBeat.m2505o(50559);
                        } else {
                            AppMethodBeat.m2505o(50559);
                        }
                    } else {
                        C26493s ut = C26494u.m42268ut(c44686h.filename);
                        C32594lp c32594lp;
                        if (ut == null) {
                            C4990ab.m7421w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", c44686h.filename);
                            AppMethodBeat.m2505o(50559);
                        } else if (c44686h.egl != null) {
                            c44686h.egl.mo5082a(str, 0, c18496c, c9545d, c44686h.field_onlycheckexist);
                            if (c9545d != null) {
                                C45150e.this.fyM.remove(str);
                            }
                            AppMethodBeat.m2505o(50559);
                        } else if (c18496c == null) {
                            if (c9545d != null) {
                                C4990ab.m7416i("MicroMsg.OnlineVideoService", "callback result info " + c9545d.field_retCode + ", filesize:" + c9545d.field_fileLength + ",recved:" + c9545d.field_recvedBytes);
                                if (c9545d.field_retCode != 0) {
                                    if (c9545d.field_retCode != -10012) {
                                        C26494u.m42261um(ut.getFileName());
                                    }
                                    boolean Jr = c44686h.mo67677Jr();
                                    int i = c9545d.field_retCode;
                                    int i2 = c44686h.egD;
                                    if (Jr) {
                                        if (i2 == 1) {
                                            if (i == -5103059) {
                                                C7060h.pYm.mo8378a(354, 111, 1, false);
                                            } else if (i == -5103087) {
                                                C7060h.pYm.mo8378a(354, 112, 1, false);
                                            } else if (i == -10012) {
                                                C7060h.pYm.mo8378a(354, 113, 1, false);
                                            } else {
                                                C7060h.pYm.mo8378a(354, 114, 1, false);
                                            }
                                        } else if (i == -5103059) {
                                            C7060h.pYm.mo8378a(354, 116, 1, false);
                                        } else if (i == -5103087) {
                                            C7060h.pYm.mo8378a(354, 117, 1, false);
                                        } else if (i == -10012) {
                                            C7060h.pYm.mo8378a(354, 118, 1, false);
                                        } else {
                                            C7060h.pYm.mo8378a(354, 119, 1, false);
                                        }
                                        C7060h.pYm.mo8381e(13836, Integer.valueOf(101), Long.valueOf(C5046bo.anT()), Integer.valueOf(i));
                                    } else {
                                        C7060h.pYm.mo8378a(354, 213, 1, false);
                                        if (i2 == 1) {
                                            C7060h.pYm.mo8378a(354, 214, 1, false);
                                        } else {
                                            C7060h.pYm.mo8378a(354, 215, 1, false);
                                        }
                                        C7060h.pYm.mo8381e(13836, Integer.valueOf(201), Long.valueOf(C5046bo.anT()), Integer.valueOf(i));
                                    }
                                } else {
                                    C45150e.m83025a(ut, c9545d.field_fileLength, c44686h.egB);
                                    C45150e.this.fzq.put(c44686h.field_mediaId, c44686h);
                                    C45150e.this.fzr.put(c44686h.field_mediaId, c9545d);
                                }
                                c32594lp = new C32594lp();
                                c32594lp.cHq.cAd = 4;
                                c32594lp.cHq.cHr = str;
                                c32594lp.cHq.offset = 0;
                                c32594lp.cHq.retCode = c9545d.field_retCode;
                                c32594lp.cHq.length = c9545d.field_fileLength;
                                C4879a.xxA.mo10055m(c32594lp);
                                C45150e.this.fyM.remove(str);
                            }
                            AppMethodBeat.m2505o(50559);
                        } else if (c18496c.field_finishedLength == ut.frO) {
                            C4990ab.m7416i("MicroMsg.OnlineVideoService", "stream download finish.");
                            AppMethodBeat.m2505o(50559);
                        } else if (ut.status == 130 || ut.fWY <= c18496c.field_finishedLength) {
                            C4990ab.m7416i("MicroMsg.OnlineVideoService", "callback progress info " + c18496c.field_finishedLength);
                            ut.fXb = C5046bo.anT();
                            ut.fWY = c18496c.field_finishedLength;
                            ut.bJt = 1040;
                            C26494u.m42253f(ut);
                            c32594lp = new C32594lp();
                            c32594lp.cHq.cAd = 5;
                            c32594lp.cHq.cHr = str;
                            c32594lp.cHq.offset = c18496c.field_finishedLength;
                            c32594lp.cHq.length = c18496c.field_toltalLength;
                            C4879a.xxA.mo10055m(c32594lp);
                            AppMethodBeat.m2505o(50559);
                        } else {
                            C4990ab.m7421w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", Integer.valueOf(ut.fWY), Integer.valueOf(c18496c.field_finishedLength));
                            AppMethodBeat.m2505o(50559);
                        }
                    }
                }
            });
            if (this.fyM.get(str) != null) {
                AppMethodBeat.m2505o(50581);
                return 1;
            }
            AppMethodBeat.m2505o(50581);
            return 0;
        }
    }

    /* renamed from: a */
    static void m83025a(C26493s c26493s, int i, String str) {
        AppMethodBeat.m2504i(50582);
        C4990ab.m7417i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", Integer.valueOf(i));
        if (c26493s != null) {
            C26494u.m42242ae(c26493s.getFileName(), i);
            C45150e.m83030i(i, str, c26493s.getFileName());
        }
        AppMethodBeat.m2505o(50582);
    }

    /* renamed from: i */
    private static boolean m83030i(int i, String str, String str2) {
        AppMethodBeat.m2504i(50583);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50583);
            return false;
        }
        C37961o.all();
        String uh = C9720t.m17303uh(str2);
        if (C5046bo.isNullOrNil(str) || i <= 0 || C5046bo.isNullOrNil(uh)) {
            C4990ab.m7421w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, uh);
            AppMethodBeat.m2505o(50583);
            return false;
        }
        boolean y = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16779y(str, i, uh);
        AppMethodBeat.m2505o(50583);
        return y;
    }

    /* renamed from: rQ */
    public static C44686h m83032rQ(String str) {
        AppMethodBeat.m2504i(50584);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50584);
            return null;
        }
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            AppMethodBeat.m2505o(50584);
            return null;
        }
        Map z = C5049br.m7595z(ut.alw(), "msg");
        if (z == null) {
            C4990ab.m7420w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
            AppMethodBeat.m2505o(50584);
            return null;
        }
        String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
            AppMethodBeat.m2505o(50584);
            return null;
        }
        int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
        String str3 = (String) z.get(".msg.videomsg.$md5");
        String str4 = (String) z.get(".msg.videomsg.$aeskey");
        String str5 = (String) z.get(".msg.videomsg.$fileparam");
        String a = C37458c.m63162a("downvideo", ut.createTime, ut.getUser(), ut.getFileName());
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7421w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", ut.getFileName());
            AppMethodBeat.m2505o(50584);
            return null;
        }
        int i;
        C37961o.all();
        String uh = C9720t.m17303uh(str);
        C44686h c44686h = new C44686h();
        c44686h.filename = str;
        c44686h.egB = str3;
        c44686h.egC = intValue;
        c44686h.egD = 1;
        c44686h.cEV = ut.alt();
        c44686h.egE = ut.getUser();
        c44686h.cEX = C1855t.m3896kH(ut.getUser()) ? C37921n.m64060mA(ut.getUser()) : 0;
        c44686h.field_mediaId = a;
        c44686h.field_fullpath = uh;
        c44686h.field_fileType = C42129a.MediaType_VIDEO;
        c44686h.field_totalLen = intValue;
        c44686h.field_aesKey = str4;
        c44686h.field_fileId = str2;
        c44686h.field_priority = C42129a.efC;
        c44686h.field_wxmsgparam = str5;
        if (C1855t.m3896kH(ut.getUser())) {
            i = 1;
        } else {
            i = 0;
        }
        c44686h.field_chattype = i;
        c44686h.egF = ut.egF;
        C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(ut.getUser(), ut.cKK);
        C1828b oE = C1829bf.m3758oE(Q.dqJ);
        c44686h.initialDownloadLength = 0;
        c44686h.initialDownloadOffset = 0;
        c44686h.egH = Q.field_createTime;
        c44686h.cKK = Q.field_msgSvrId;
        c44686h.egI = oE != null ? oE.fmG : 0;
        if (c44686h.initialDownloadLength > 0) {
            C7060h.pYm.mo8378a(354, 36, 1, false);
        }
        c44686h.field_autostart = false;
        c44686h.field_requestVideoFormat = C42204d.m74447a(1, ut);
        AppMethodBeat.m2505o(50584);
        return c44686h;
    }

    /* renamed from: a */
    public static C44686h m83024a(C44222az c44222az, String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(50585);
        if (c44222az == null) {
            C4990ab.m7420w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            AppMethodBeat.m2505o(50585);
            return null;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            AppMethodBeat.m2505o(50585);
            return null;
        } else {
            C26493s ut = C26494u.m42268ut(str3);
            if (ut == null) {
                C4990ab.m7421w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", str3);
                AppMethodBeat.m2505o(50585);
                return null;
            }
            String a = C37458c.m63162a("snsvideo", (long) c44222az.oyB, "sns", str);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7421w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", str);
                AppMethodBeat.m2505o(50585);
                return null;
            }
            C44686h c44686h = new C44686h();
            c44686h.filename = str3;
            c44686h.field_fullpath = str2;
            c44686h.field_mediaId = a;
            c44686h.egy = 2;
            c44686h.egD = i;
            c44686h.egF = ut.egF;
            String str4 = "";
            if (c44222az == null) {
                a = "";
            } else if (c44222az.equals(C44222az.xYN)) {
                a = "album_friend";
            } else if (c44222az.equals(C44222az.xYO)) {
                a = "album_self";
            } else if (c44222az.equals(C44222az.xYP)) {
                a = "album_stranger";
            } else if (c44222az.equals(C44222az.xYQ)) {
                a = "profile_friend";
            } else if (c44222az.equals(C44222az.xYR)) {
                a = "profile_stranger";
            } else if (c44222az.equals(C44222az.xYS)) {
                a = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
            } else if (c44222az.equals(C44222az.xYM)) {
                a = "timeline";
            } else if (c44222az.equals(C44222az.xYV)) {
                a = "snssight";
            } else if (c44222az.equals(C44222az.xYX)) {
                a = "storysight";
            } else {
                a = str4;
            }
            String str5 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            r3 = new Object[5];
            C1720g.m3537RQ();
            C1720g.m3534RN();
            r3[1] = C1183p.getString(C1668a.m3383QF());
            r3[2] = Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext()));
            r3[3] = Integer.valueOf(C5023at.getStrength(C4996ah.getContext()));
            r3[4] = !C5046bo.isNullOrNil(a) ? "&scene=".concat(String.valueOf(a)) : "";
            c44686h.referer = String.format(str5, r3);
            c44686h.url = str;
            long j = (long) ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            C4990ab.m7417i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SnsSightDomainList"), Long.valueOf(j), Integer.valueOf(c44222az.oyB));
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = C45150e.m83029a(c44222az, c44686h.url, j, r5);
            try {
                c44686h.host = new URL(c44686h.url).getHost();
                List arrayList = new ArrayList();
                C1897b.m4019a(a2, arrayList, c44686h.host);
                c44686h.ege = new String[arrayList.size()];
                arrayList.toArray(c44686h.ege);
                c44686h.isColdSnsData = C5046bo.m7549fp((long) c44222az.oyB) > j;
                c44686h.signalQuality = C5023at.getStrength(C4996ah.getContext());
                c44686h.snsScene = a;
                if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.mmsns_video_hevc_download_and, false)) {
                    c44686h.field_requestVideoFormat = C42204d.m74455u(i, str2);
                }
                AppMethodBeat.m2505o(50585);
                return c44686h;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", c44686h);
                AppMethodBeat.m2505o(50585);
                return null;
            }
        }
    }

    /* renamed from: a */
    private static boolean m83029a(C44222az c44222az, String str, long j, String str2) {
        AppMethodBeat.m2504i(50586);
        if (str == null) {
            AppMethodBeat.m2505o(50586);
            return false;
        }
        try {
            URL url = new URL(str);
            if (c44222az == null) {
                AppMethodBeat.m2505o(50586);
                return false;
            } else if (str2 == null) {
                AppMethodBeat.m2505o(50586);
                return false;
            } else if (str2.indexOf(url.getHost()) == -1) {
                AppMethodBeat.m2505o(50586);
                return false;
            } else if (c44222az.oyB == 0) {
                AppMethodBeat.m2505o(50586);
                return false;
            } else if (C5046bo.m7549fp((long) c44222az.oyB) > j) {
                AppMethodBeat.m2505o(50586);
                return true;
            } else {
                AppMethodBeat.m2505o(50586);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.OnlineVideoService", "error for check dcip %s", e.getMessage());
            AppMethodBeat.m2505o(50586);
            return false;
        }
    }

    /* renamed from: a */
    public static void m83028a(Object[] objArr, C9545d c9545d, C44686h c44686h, boolean z) {
        AppMethodBeat.m2504i(50587);
        if (c44686h == null || c9545d == null) {
            C4990ab.m7420w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
            AppMethodBeat.m2505o(50587);
        } else if (c44686h.mo67675Jp() || c44686h.mo67677Jr() || c44686h.mo67679Jt()) {
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
            String str = c9545d.field_clientIP;
            C4990ab.m7417i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", Integer.valueOf(c9545d.field_videoFormat), str, Integer.valueOf(c9545d.field_isCrossNet ? 1 : 0));
            if (c9545d.field_videoFormat == 2) {
                C26494u.m42272ux(c44686h.filename);
            }
            if (C5046bo.isNullOrNil(str)) {
                C7060h.pYm.mo8378a(354, 45, 1, false);
            } else {
                C7060h.pYm.mo8378a(354, 46, 1, false);
            }
            if (c9545d.field_isCrossNet) {
                C7060h.pYm.mo8378a(354, 47, 1, false);
            } else {
                C7060h.pYm.mo8378a(354, 48, 1, false);
            }
            boolean Jr = c44686h.mo67677Jr();
            boolean Jt = c44686h.mo67679Jt();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            C26494u.m42241a(c44686h.field_fullpath, pInt, pInt2);
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
            intValue4 = c44686h.egF;
            if (intValue4 <= 0) {
                if (Jr) {
                    intValue4 = 10;
                } else {
                    intValue4 = 31;
                }
            }
            intValue = C5023at.m7472gC(C4996ah.getContext());
            String Jn = c9545d.mo20810Jn();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            C45150e.m83026a(pInt3, pInt4, c44686h.filename, c44686h.egI);
            StringBuffer stringBuffer = new StringBuffer();
            if (Jr) {
                stringBuffer.append(c44686h.field_fileId).append(",").append(c44686h.field_aesKey).append(",");
            } else {
                stringBuffer.append(c44686h.url).append(",").append(c44686h.egG).append(",");
            }
            stringBuffer.append(c9545d.field_fileLength).append(",").append(i4).append(",");
            stringBuffer.append(c9545d.field_recvedBytes).append(",");
            stringBuffer.append(i2 + ",").append(intValue2 + ",").append(intValue3 + ",");
            stringBuffer.append(i + ",").append(intValue5 + ",");
            stringBuffer.append(intValue).append(",");
            stringBuffer.append(intValue4).append(",");
            stringBuffer.append(c9545d.field_startTime).append(",");
            stringBuffer.append(c9545d.field_endTime).append(",");
            if (Jr) {
                stringBuffer.append(c44686h.egE != null ? C1178g.m2591x(c44686h.egE.getBytes()) : Integer.valueOf(0)).append(",");
                stringBuffer.append(C1855t.m3896kH(c44686h.egE) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(c9545d.field_httpStatusCode).append(",");
            }
            stringBuffer.append(c9545d.field_retCode).append(",");
            stringBuffer.append(c9545d.field_enQueueTime).append(",");
            stringBuffer.append(c9545d.field_firstRequestCost).append(",");
            stringBuffer.append(c9545d.field_firstRequestSize).append(",");
            stringBuffer.append(c9545d.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(c9545d.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(c9545d.field_averageSpeed).append(",");
            stringBuffer.append(c9545d.field_averageConnectCost).append(",");
            stringBuffer.append(c9545d.field_firstConnectCost).append(",");
            stringBuffer.append(c9545d.field_netConnectTimes).append(",");
            stringBuffer.append(c9545d.field_moovRequestTimes).append(",");
            stringBuffer.append(c9545d.field_moovCost).append(",");
            stringBuffer.append(c9545d.field_moovSize).append(",");
            stringBuffer.append(c9545d.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(c9545d.field_moovFailReason).append(",");
            stringBuffer.append(intValue6).append(",");
            stringBuffer.append(intValue7).append(",");
            if (Jr) {
                stringBuffer.append(i5).append(",");
            } else {
                stringBuffer.append(i5).append(",");
                stringBuffer.append(c44686h.egE != null ? C1178g.m2591x(c44686h.egE.getBytes()) : Integer.valueOf(0)).append(",");
            }
            stringBuffer.append(Jn).append(",");
            if (Jr) {
                stringBuffer.append(c44686h.egH).append(",");
                stringBuffer.append(c44686h.cKK).append(",");
                stringBuffer.append(c44686h.initialDownloadLength).append(",");
                stringBuffer.append(c9545d.field_videoFormat).append(",");
            } else {
                stringBuffer.append(C14013c.abR(c44686h.cFc)).append(",");
            }
            stringBuffer.append(str).append(",");
            stringBuffer.append(i3).append(",");
            stringBuffer.append(c44686h.egJ).append(",");
            stringBuffer.append(pInt3.value).append(",");
            stringBuffer.append(pInt4.value);
            intValue4 = Jr ? 13570 : 13790;
            if (Jt) {
                intValue4 = 13570;
            }
            String stringBuffer2 = stringBuffer.toString();
            C4990ab.m7417i("MicroMsg.OnlineVideoService", "report online video %d:%s", Integer.valueOf(intValue4), stringBuffer2);
            if (Jr) {
                new C32676s(stringBuffer2).ajK();
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
                    i6 = C5046bo.getInt(objArr[7].toString(), 0);
                    C5046bo.getInt(objArr[8].toString(), 0);
                    i7 = C5046bo.getInt(objArr[9].toString(), 0);
                    str2 = objArr[11].toString();
                    i8 = C5046bo.getInt(objArr[12].toString(), 0);
                    j2 = C5046bo.getLong(objArr[13].toString(), 0);
                    i9 = C5046bo.getInt(objArr[14].toString(), 0);
                    i3 = C5046bo.getInt(objArr[15].toString(), 0);
                    intValue4 = C5046bo.getInt(objArr[16].toString(), 0);
                }
                C9505bm c9505bm = new C9505bm();
                C9505bm gf = c9505bm.mo20787gf(str2);
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
                C9505bm gg = gf.mo20788gg("");
                gg.cVH = (long) (i5 * 1000);
                gg = gg.mo20789gh(c44686h.field_requestVideoFormat);
                gg.cTL = (long) c9545d.field_fileLength;
                gg.dcA = (long) c9545d.field_recvedBytes;
                gg.cXo = c9545d.field_startTime;
                gg.cXp = c9545d.field_endTime;
                gg.dcB = (long) c9545d.field_retCode;
                gg.dcC = c9545d.field_enQueueTime;
                gg.dcD = (long) c9545d.field_moovRequestTimes;
                gg.dcE = (long) c9545d.field_moovCost;
                gg.cXC = (long) c9545d.field_moovSize;
                if (c9545d.field_moovCompleted) {
                    j = 1;
                } else {
                    j = 0;
                }
                gg.dcF = j;
                gg.dcG = (long) c9545d.field_moovFailReason;
                gg.dcH = (long) c9545d.field_firstConnectCost;
                gg.dcI = (long) c9545d.field_firstRequestCost;
                gg.dcJ = (long) c9545d.field_firstRequestSize;
                gg.dcK = (long) c9545d.field_firstRequestDownloadSize;
                if (c9545d.field_firstRequestCompleted) {
                    j = 1;
                } else {
                    j = 0;
                }
                gg.dcL = j;
                gg.dcM = (long) c9545d.field_averageSpeed;
                gg.dcN = (long) c9545d.field_averageConnectCost;
                gg.cXz = (long) c9545d.field_netConnectTimes;
                gg = gg.mo20790gi(c9545d.mo20810Jn()).mo20791gj(c9545d.field_clientIP);
                if (c9545d.field_isCrossNet) {
                    j = 1;
                } else {
                    j = 0;
                }
                gg.dcP = j;
                gg.cXN = c44686h.egJ;
                gg.dcQ = (long) i7;
                gg.cTJ = (long) intValue;
                gg.dcR = j2;
                gg.cVO = (long) i6;
                gg.dcS = (long) intValue4;
                C4990ab.m7411d("MicroMsg.OnlineVideoService", "time distance %d", Long.valueOf(System.currentTimeMillis() - c9505bm.dcR));
                if (System.currentTimeMillis() - c9505bm.dcR > 500) {
                    c9505bm.ajK();
                }
                C32662an c32662an = new C32662an();
                C43528a WR = C21846d.m33388WR(c44686h.field_fullpath);
                if (WR != null) {
                    c32662an.cVG = (long) WR.eWK;
                    c32662an.cVH = (long) WR.videoBitrate;
                    c32662an.cVI = (long) WR.fzS;
                    c32662an.cVJ = (long) WR.eTk;
                    c32662an.cVK = (long) WR.width;
                    c32662an.cVL = (long) WR.height;
                    c32662an.cVN = (long) WR.qwV;
                }
                c32662an.cVF = (long) c9545d.field_fileLength;
                c32662an = c32662an.mo53164ft(c44686h.url);
                C37461f.afy();
                c32662an = c32662an.mo53165fu(C8941a.m16130rJ(c44686h.field_fullpath));
                c32662an.cVD = c9545d.field_startTime;
                c32662an.cVE = c9545d.field_endTime;
                c32662an = c32662an.mo53166fv(Jn);
                c32662an.cVO = (long) i6;
                c32662an.cVP = (long) pInt4.value;
                c32662an.ajK();
            } else {
                new C9501ai(stringBuffer2).ajK();
            }
            if (z) {
                C45150e.m83027a(c44686h.cEV, c44686h.egE, c44686h.cEX, c9545d.field_fileId, intValue, c9545d.field_startTime, c9545d.field_endTime, c44686h.field_fullpath, c9545d.field_usedSvrIps, c44686h.url, pInt3.value, pInt4.value, c44686h.cFc);
            }
            if (Jr) {
                if (c9545d.field_videoFormat == 2) {
                    C7060h.pYm.mo8378a(354, 132, 1, false);
                } else {
                    C7060h.pYm.mo8378a(354, 133, 1, false);
                }
                C26493s ut = C26494u.m42268ut(c44686h.filename);
                if (ut != null) {
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(jf.field_talker, "update", jf));
                }
            }
            AppMethodBeat.m2505o(50587);
        } else {
            AppMethodBeat.m2505o(50587);
        }
    }

    /* renamed from: a */
    private static void m83026a(PInt pInt, PInt pInt2, String str, int i) {
        int i2;
        int i3;
        AppMethodBeat.m2504i(50588);
        int i4 = 0;
        C26493s ut = C26494u.m42268ut(str);
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
            C4990ab.m7411d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) ((((float) i) / 100.0f) * ((float) i2))), Integer.valueOf(i4));
        }
        pInt.value = i4;
        pInt2.value = i3;
        C4990ab.m7411d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        AppMethodBeat.m2505o(50588);
    }

    /* renamed from: a */
    private static void m83027a(String str, String str2, int i, String str3, int i2, long j, long j2, String str4, String[] strArr, String str5, int i3, int i4, String str6) {
        AppMethodBeat.m2504i(50589);
        C18307jv c18307jv = new C18307jv();
        c18307jv.cEU.cEV = str;
        c18307jv.cEU.cEW = str2;
        c18307jv.cEU.cEX = i;
        c18307jv.cEU.fileId = str3;
        c18307jv.cEU.netType = i2;
        c18307jv.cEU.startTime = j;
        c18307jv.cEU.endTime = j2;
        c18307jv.cEU.path = str4;
        c18307jv.cEU.cEY = strArr;
        c18307jv.cEU.cEZ = str5;
        c18307jv.cEU.cFa = i3;
        c18307jv.cEU.cFb = i4;
        c18307jv.cEU.cFc = str6;
        C4879a.xxA.mo10055m(c18307jv);
        AppMethodBeat.m2505o(50589);
    }
}
