package com.tencent.p177mm.p187al;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C8941a.C8944b;
import com.tencent.p177mm.p230g.p231a.C9391jm;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C18497f;
import com.tencent.p177mm.p235i.C26324b;
import com.tencent.p177mm.p235i.C26324b.C26323a;
import com.tencent.p177mm.p235i.C26325e;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.al.b */
public final class C31259b implements C1202f, C26324b, C26323a, C4937b {
    private int fyG = -1;
    C7306ak fyH = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(78030);
            if (C5023at.isConnected(C4996ah.getContext())) {
                C4990ab.m7416i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
                C7060h.pYm.mo8378a(546, 5, 1, true);
                BaseEvent.onNetworkChange();
            }
            AppMethodBeat.m2505o(78030);
        }
    };
    private C4884c<C9391jm> fyI = new C312602();
    private C1923n fyJ = new C312613();
    Queue<String> fyK = new LinkedList();
    public Map<String, C42130g> fyL = new HashMap();
    public Map<String, C42130g> fyM = new ConcurrentHashMap();
    public Map<String, Integer> fyN = new HashMap();
    private String fyO = "";
    private long fyP = 0;
    public HashSet<String> fyQ = new HashSet();

    /* renamed from: com.tencent.mm.al.b$2 */
    class C312602 extends C4884c<C9391jm> {
        C312602() {
            AppMethodBeat.m2504i(78031);
            this.xxI = C9391jm.class.getName().hashCode();
            AppMethodBeat.m2505o(78031);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78032);
            if (C5023at.isConnected(C4996ah.getContext())) {
                C4990ab.m7416i("MicroMsg.CdnTransportService", "cdntra mm on network change callback ");
                C31259b.this.fyH.removeMessages(1);
                C31259b.this.fyH.sendEmptyMessageDelayed(1, 10000);
            }
            AppMethodBeat.m2505o(78032);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.al.b$3 */
    class C312613 extends C1924a {
        C312613() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(78033);
            C4990ab.m7411d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
            if (i != 4 && i != 6) {
                AppMethodBeat.m2505o(78033);
            } else if (C1720g.m3534RN().mo5161QY()) {
                C31259b.this.fyH.removeMessages(1);
                BaseEvent.onNetworkChange();
                AppMethodBeat.m2505o(78033);
            } else {
                AppMethodBeat.m2505o(78033);
            }
        }
    }

    /* renamed from: com.tencent.mm.al.b$4 */
    class C312624 implements Runnable {
        C312624() {
        }

        public final void run() {
            AppMethodBeat.m2504i(78034);
            C31259b.this.mo51223cK(true);
            AppMethodBeat.m2505o(78034);
        }

        public final String toString() {
            AppMethodBeat.m2504i(78035);
            String str = super.toString() + "|onSceneEnd";
            AppMethodBeat.m2505o(78035);
            return str;
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(78043);
        if (C1720g.m3534RN().mo5161QY()) {
            int g = C5046bo.m7550g(obj, 0);
            C4990ab.m7411d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
            if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
                C4990ab.m7413e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
                AppMethodBeat.m2505o(78043);
                return;
            } else if (g != 144385) {
                AppMethodBeat.m2505o(78043);
                return;
            } else {
                C37461f.afu().mo60373li(10);
                AppMethodBeat.m2505o(78043);
                return;
            }
        }
        AppMethodBeat.m2505o(78043);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(78044);
        if (c1207m.getType() != 379) {
            AppMethodBeat.m2505o(78044);
            return;
        }
        C4990ab.m7411d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (C1720g.m3534RN().mo5161QY()) {
            C7305d.xDH.mo10140a(new C312624(), "MicroMsg.CdnTransportService");
        }
        AppMethodBeat.m2505o(78044);
    }

    /* renamed from: lg */
    public static boolean m50439lg(int i) {
        AppMethodBeat.m2504i(78045);
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            C4990ab.m7411d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", Integer.valueOf(r0), Integer.valueOf(i), Integer.valueOf(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(144385, null), 0) & i), Boolean.valueOf(C1947ae.git));
            if (C1947ae.git) {
                AppMethodBeat.m2505o(78045);
                return true;
            } else if ((r0 & i) > 0) {
                AppMethodBeat.m2505o(78045);
                return true;
            } else {
                AppMethodBeat.m2505o(78045);
                return false;
            }
        }
        AppMethodBeat.m2505o(78045);
        return true;
    }

    public C31259b() {
        AppMethodBeat.m2504i(78046);
        C1720g.m3535RO().mo5187a(this.fyJ);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3536RP().mo5239Ry().mo10118a(this);
        }
        C1720g.m3540Rg().mo14539a(379, (C1202f) this);
        C4879a.xxA.mo10052c(this.fyI);
        C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", Integer.valueOf(hashCode()), C5046bo.dpG());
        AppMethodBeat.m2505o(78046);
    }

    public final void release() {
        AppMethodBeat.m2504i(78047);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3536RP().mo5239Ry().mo10121b(this);
        }
        this.fyH.removeCallbacksAndMessages(null);
        C1720g.m3535RO().mo5188b(this.fyJ);
        C1720g.m3535RO().eJo.mo14546b(379, (C1202f) this);
        C4879a.xxA.mo10053d(this.fyI);
        AppMethodBeat.m2505o(78047);
    }

    /* renamed from: lh */
    public final void mo51226lh(int i) {
        this.fyG = i;
    }

    /* renamed from: b */
    public final boolean mo51222b(final C42130g c42130g, final int i) {
        AppMethodBeat.m2504i(78048);
        if (c42130g == null) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            AppMethodBeat.m2505o(78048);
            return false;
        } else if (C5046bo.isNullOrNil(c42130g.field_mediaId)) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            AppMethodBeat.m2505o(78048);
            return false;
        } else {
            if (c42130g.field_fileId == null) {
                c42130g.field_fileId = "";
            }
            if (c42130g.field_aesKey == null) {
                c42130g.field_aesKey = "";
            }
            c42130g.cRY = false;
            C7305d.xDH.mo10140a(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(78036);
                    if (i != -1) {
                        C31259b.this.fyN.put(c42130g.field_mediaId, Integer.valueOf(i));
                    }
                    C4990ab.m7417i("MicroMsg.CdnTransportService", "CdnTransportService replacePizzaWorkerExecute run %s", c42130g.field_mediaId);
                    C31259b.this.fyK.add(c42130g.field_mediaId);
                    C31259b.this.fyL.put(c42130g.field_mediaId, c42130g);
                    C31259b.this.mo51223cK(false);
                    AppMethodBeat.m2505o(78036);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(78037);
                    String str = super.toString() + "|addRecvTask";
                    AppMethodBeat.m2505o(78037);
                    return str;
                }
            }, "MicroMsg.CdnTransportService");
            AppMethodBeat.m2505o(78048);
            return true;
        }
    }

    /* renamed from: d */
    public final boolean mo51224d(C42130g c42130g) {
        AppMethodBeat.m2504i(78049);
        boolean b = mo51222b(c42130g, -1);
        AppMethodBeat.m2505o(78049);
        return b;
    }

    /* renamed from: e */
    public final boolean mo51225e(final C42130g c42130g) {
        AppMethodBeat.m2504i(78050);
        if (C5046bo.isNullOrNil(c42130g.field_mediaId)) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            AppMethodBeat.m2505o(78050);
            return false;
        }
        if (c42130g.field_fileId == null) {
            c42130g.field_fileId = "";
        }
        if (c42130g.field_aesKey == null) {
            c42130g.field_aesKey = "";
        }
        c42130g.cRY = true;
        C7305d.xDH.mo10140a(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78038);
                C31259b.this.fyK.add(c42130g.field_mediaId);
                C31259b.this.fyL.put(c42130g.field_mediaId, c42130g);
                C31259b.this.mo51223cK(false);
                AppMethodBeat.m2505o(78038);
            }

            public final String toString() {
                AppMethodBeat.m2504i(78039);
                String str = super.toString() + "|addSendTask";
                AppMethodBeat.m2505o(78039);
                return str;
            }
        }, "MicroMsg.CdnTransportService");
        AppMethodBeat.m2505o(78050);
        return true;
    }

    /* renamed from: rN */
    public final boolean mo51227rN(String str) {
        AppMethodBeat.m2504i(78051);
        if (((C42130g) this.fyM.remove(str)) != null) {
            C37461f.afy();
            C8941a.m16126rF(str);
            C7060h.pYm.mo8381e(10769, Integer.valueOf(C37458c.fzh), Integer.valueOf(r0.field_fileType), Long.valueOf(C5046bo.anU() - r0.field_startTime));
        }
        this.fyL.remove(str);
        C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(0));
        AppMethodBeat.m2505o(78051);
        return true;
    }

    /* renamed from: rO */
    public final boolean mo51228rO(String str) {
        AppMethodBeat.m2504i(78052);
        C42130g c42130g = (C42130g) this.fyM.remove(str);
        if (c42130g != null) {
            if (c42130g.field_fileType == C42129a.efP || c42130g.field_fileType == C42129a.efR) {
                C37461f.afy();
                C8941a.m16131rK(str);
            } else if (c42130g.egs) {
                C37461f.afy();
                C8941a.m16132rL(str);
            } else {
                C37461f.afy();
                C8941a.m16127rG(str);
            }
            C7060h.pYm.mo8381e(10769, Integer.valueOf(C37458c.fzg), Integer.valueOf(c42130g.field_fileType), Long.valueOf(C5046bo.anU() - c42130g.field_startTime));
        }
        this.fyL.remove(str);
        this.fyN.remove(str);
        C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, c42130g, Integer.valueOf(0));
        AppMethodBeat.m2505o(78052);
        return true;
    }

    /* renamed from: cK */
    public final void mo51223cK(boolean z) {
        AppMethodBeat.m2504i(78053);
        if (!z && C37461f.afy().afq()) {
            C1720g.m3534RN();
            if (C1668a.m3395QX()) {
                C4990ab.m7420w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                C37461f.afu().mo60373li(4);
                AppMethodBeat.m2505o(78053);
                return;
            }
        }
        afs();
        C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", Integer.valueOf(this.fyK.size()));
        while (!this.fyK.isEmpty()) {
            C42130g c42130g = (C42130g) this.fyL.remove((String) this.fyK.poll());
            if (c42130g == null) {
                C4990ab.m7412e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                AppMethodBeat.m2505o(78053);
                return;
            }
            C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", c42130g.field_mediaId, Boolean.valueOf(c42130g.field_autostart), Integer.valueOf(c42130g.field_chattype));
            c42130g.field_startTime = C5046bo.anU();
            String str;
            int i;
            C42130g c42130g2;
            int b;
            String str2;
            Object[] objArr;
            if (c42130g.cRY) {
                String str3;
                String str4 = "MicroMsg.CdnTransportService";
                str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]";
                Object[] objArr2 = new Object[8];
                if (c42130g.field_fullpath == null) {
                    i = -1;
                } else {
                    i = c42130g.field_fullpath.length();
                }
                objArr2[0] = Integer.valueOf(i);
                if (c42130g.field_thumbpath == null) {
                    i = -1;
                } else {
                    i = c42130g.field_thumbpath.length();
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = C5046bo.anv(c42130g.field_svr_signature);
                objArr2[3] = C5046bo.anv(c42130g.field_aesKey);
                objArr2[4] = Integer.valueOf(c42130g.field_fileType);
                objArr2[5] = c42130g.field_mediaId;
                objArr2[6] = Boolean.valueOf(c42130g.field_onlycheckexist);
                objArr2[7] = Integer.valueOf(c42130g.field_largesvideo);
                C4990ab.m7417i(str4, str, objArr2);
                if (c42130g.field_fullpath == null) {
                    c42130g.field_fullpath = "";
                }
                if (c42130g.field_thumbpath == null) {
                    c42130g.field_thumbpath = "";
                }
                c42130g2 = (C42130g) this.fyM.put(c42130g.field_mediaId, c42130g);
                C42130g c42130g3 = (C42130g) this.fyM.get(c42130g.field_mediaId);
                if (c42130g3 == null) {
                    C7060h.pYm.mo8378a(594, 5, 1, true);
                }
                b = C37461f.afy().mo20372b(c42130g);
                str4 = "MicroMsg.CdnTransportService";
                str2 = "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                objArr = new Object[5];
                objArr[0] = c42130g.field_mediaId;
                objArr[1] = Integer.valueOf(b);
                objArr[2] = c42130g2 == null ? null : c42130g2.field_mediaId;
                if (c42130g3 == null) {
                    str3 = null;
                } else {
                    str3 = c42130g3.field_mediaId;
                }
                objArr[3] = str3;
                objArr[4] = Integer.valueOf(hashCode());
                C4990ab.m7417i(str4, str2, objArr);
                if (b != 0) {
                    c42130g2 = (C42130g) this.fyM.remove(c42130g.field_mediaId);
                    C4990ab.m7413e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", Integer.valueOf(b), c42130g.field_mediaId, c42130g2);
                    if (c42130g.egl != null) {
                        c42130g.egl.mo5082a(c42130g.field_mediaId, b, null, null, c42130g.field_onlycheckexist);
                    }
                }
            } else {
                i = -1;
                int i2;
                if (c42130g.field_fileType == CdnLogic.kMediaTypeStoryAudio) {
                    b = C37461f.afy().mo20363a(c42130g.field_mediaId, c42130g.egm, c42130g.field_fullpath, c42130g.field_fileType, c42130g.field_aesKey, c42130g.field_authKey);
                } else if (c42130g.field_fileType == 19) {
                    b = C37461f.afy().mo20363a(c42130g.field_mediaId, c42130g.egm, c42130g.field_fullpath, c42130g.field_fileType, c42130g.field_aesKey, c42130g.field_authKey);
                } else if (c42130g.field_fileType == C42129a.efP || c42130g.field_fileType == C42129a.efR) {
                    if (!(c42130g.field_fullpath == null || c42130g.field_fullpath.isEmpty())) {
                        i = C37461f.afy().mo20362a(c42130g.field_mediaId, c42130g.egm, c42130g.field_fullpath, c42130g.field_fileType, c42130g.egn, c42130g.ego, c42130g.egp, c42130g.egq);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]";
                    objArr = new Object[4];
                    if (c42130g.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = c42130g.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = c42130g.field_mediaId;
                    objArr[2] = c42130g.egm;
                    objArr[3] = Integer.valueOf(c42130g.field_fileType);
                    C4990ab.m7417i(str, str2, objArr);
                    b = i;
                } else if (c42130g.egs) {
                    if (!(c42130g.field_fullpath == null || c42130g.field_fullpath.isEmpty())) {
                        i = C37461f.afy().mo20367a(c42130g.field_mediaId, c42130g.field_fullpath, c42130g.egm, c42130g.egt, c42130g.egu, c42130g.allow_mobile_net_download, c42130g.egn, c42130g.ego, c42130g.is_resume_task, c42130g.egr, c42130g.egp);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr = new Object[4];
                    if (c42130g.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = c42130g.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = c42130g.field_mediaId;
                    objArr[2] = c42130g.egm;
                    objArr[3] = c42130g.egt;
                    C4990ab.m7417i(str, str2, objArr);
                    b = i;
                } else {
                    if (!c42130g.egv) {
                        str = "MicroMsg.CdnTransportService";
                        str2 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                        objArr = new Object[7];
                        if (c42130g.field_fullpath == null) {
                            i2 = -1;
                        } else {
                            i2 = c42130g.field_fullpath.length();
                        }
                        objArr[0] = Integer.valueOf(i2);
                        if (c42130g.field_thumbpath == null) {
                            i2 = -1;
                        } else {
                            i2 = c42130g.field_thumbpath.length();
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = c42130g.field_svr_signature;
                        objArr[3] = c42130g.field_aesKey;
                        objArr[4] = Integer.valueOf(c42130g.field_fileType);
                        objArr[5] = c42130g.field_mediaId;
                        objArr[6] = Boolean.valueOf(c42130g.field_onlycheckexist);
                        C4990ab.m7417i(str, str2, objArr);
                        if (c42130g.egx != 2) {
                            b = C37461f.afy().mo20374c(c42130g);
                        } else if (c42130g instanceof C44686h) {
                            C44686h c44686h = (C44686h) c42130g;
                            if (c44686h.mo67677Jr()) {
                                b = C37461f.afy().mo20361a(c42130g, 2);
                            } else if (c44686h.mo67675Jp()) {
                                b = C37461f.afy().mo20366a(c44686h.field_mediaId, c44686h.url, c44686h.referer, c44686h.field_fullpath, c44686h.egD, c44686h.ege, c44686h.isColdSnsData, c44686h.signalQuality, c44686h.snsScene, c44686h.field_preloadRatio, c44686h.field_requestVideoFormat, 1);
                            } else if (c44686h.mo67676Jq()) {
                                b = C37461f.afy().mo20364a(c44686h.field_mediaId, c44686h.url, c44686h.referer, c44686h.field_fullpath, c44686h.egD, c44686h.field_preloadRatio, c44686h.concurrentCount);
                            } else {
                                if (c44686h.mo67679Jt()) {
                                    i = C37461f.afy().mo20373b(c44686h.field_mediaId, c44686h.url, c44686h.referer, c44686h.field_fullpath, c44686h.egD, c44686h.ege, c44686h.isColdSnsData, c44686h.signalQuality, c44686h.snsScene, c44686h.field_preloadRatio, c44686h.field_requestVideoFormat, c44686h.connectionCount);
                                }
                                b = i;
                            }
                        }
                    } else if (c42130g instanceof C18497f) {
                        b = C37461f.afy().mo20360a((C18497f) c42130g);
                    } else if (c42130g instanceof C26325e) {
                        C26325e c26325e = (C26325e) c42130g;
                        b = C37461f.afy().mo20368a(c26325e.field_mediaId, c26325e.url, c26325e.referer, c26325e.egd, c26325e.ege, c26325e.egf, c26325e.egg, c26325e.egh, c26325e.isColdSnsData, c26325e.signalQuality, c26325e.snsScene, c26325e.snsCipherKey, c26325e.duk, c26325e.egi, c26325e.fileType);
                    }
                    b = -1;
                }
                if (b != 0) {
                    C4990ab.m7413e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(b), c42130g.field_mediaId);
                    if (c42130g.egl != null) {
                        c42130g.egl.mo5082a(c42130g.field_mediaId, b, null, null, c42130g.field_onlycheckexist);
                    }
                } else {
                    c42130g2 = (C42130g) this.fyM.put(c42130g.field_mediaId, c42130g);
                    C42130g c42130g4 = (C42130g) this.fyM.get(c42130g.field_mediaId);
                    if (c42130g4 == null) {
                        C7060h.pYm.mo8378a(594, 6, 1, true);
                    }
                    str2 = "MicroMsg.CdnTransportService";
                    String str5 = "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = c42130g.field_mediaId;
                    objArr3[1] = Integer.valueOf(b);
                    objArr3[2] = c42130g2 == null ? null : c42130g2.field_mediaId;
                    objArr3[3] = c42130g4 == null ? null : c42130g4.field_mediaId;
                    objArr3[4] = Integer.valueOf(hashCode());
                    C4990ab.m7417i(str2, str5, objArr3);
                }
            }
        }
        AppMethodBeat.m2505o(78053);
    }

    public final void afs() {
        AppMethodBeat.m2504i(78054);
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            C8944b afr = C37461f.afy().afr();
            String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableCDNUploadImg");
            String value2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableCDNVerifyConnect");
            String value3 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableStreamUploadVideo");
            String value5 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("C2COverloadDelaySeconds");
            String value6 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SNSOverloadDelaySeconds");
            String value7 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableSnsStreamDownload");
            String value8 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableSnsImageDownload");
            String value9 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ApprovedVideoPrivateProtocolHosts");
            try {
                if (!C5046bo.isNullOrNil(value)) {
                    afr.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!C5046bo.isNullOrNil(value2)) {
                    afr.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!C5046bo.isNullOrNil(value3)) {
                    afr.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!C5046bo.isNullOrNil(value4)) {
                    afr.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!C5046bo.isNullOrNil(value5)) {
                    afr.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!C5046bo.isNullOrNil(value6)) {
                    afr.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!C5046bo.isNullOrNil(value7)) {
                    afr.field_EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                if (!C5046bo.isNullOrNil(value8)) {
                    afr.field_EnableSnsImageDownload = Integer.valueOf(value8).intValue();
                }
                if (!C5046bo.isNullOrNil(value9)) {
                    afr.field_ApprovedVideoHosts = value9;
                }
                C37461f.afx();
                afr.field_EnableSafeCDN = C31259b.m50439lg(256) ? 1 : 0;
                if (afr.field_UseStreamCDN != 0) {
                    value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableJPEGDyncmicETL");
                    if (!C5046bo.isNullOrNil(value)) {
                        afr.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!C5046bo.isNullOrNil(value2)) {
                        afr.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!C5046bo.isNullOrNil(value3)) {
                        afr.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!C5046bo.isNullOrNil(value4)) {
                        afr.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!C5046bo.isNullOrNil(value5)) {
                        afr.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", afr);
                if (this.fyG != -1) {
                    C4990ab.m7421w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", Integer.valueOf(this.fyG));
                    afr.field_EnableSnsImageDownload = this.fyG;
                }
                C37461f.afy();
                C8941a.m16118a(afr);
            } catch (NumberFormatException e) {
                C4990ab.m7412e("MicroMsg.CdnTransportService", e.toString());
            }
            if (C1947ae.giS) {
                int i;
                C4990ab.m7420w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                afr.field_UseStreamCDN = C1947ae.giO ? 1 : 0;
                if (afr.field_UseStreamCDN != 0) {
                    afr.field_onlysendETL = C1947ae.giP;
                    afr.field_onlyrecvPtl = C1947ae.giQ;
                    if (!C5046bo.isNullOrNil(C1947ae.giL)) {
                        afr.field_WifiEtl = Integer.valueOf(C1947ae.giL).intValue();
                    }
                    if (!C5046bo.isNullOrNil(C1947ae.giM)) {
                        afr.field_noWifiEtl = Integer.valueOf(C1947ae.giM).intValue();
                    }
                    if (!C5046bo.isNullOrNil(C1947ae.giN)) {
                        afr.field_Ptl = Integer.valueOf(C1947ae.giN).intValue();
                    }
                }
                afr.field_EnableCDNVerifyConnect = C1947ae.giT ? 1 : 0;
                if (C1947ae.giU) {
                    i = 1;
                } else {
                    i = 0;
                }
                afr.field_EnableCDNVideoRedirectOC = i;
                C4990ab.m7417i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", afr);
                C37461f.afy();
                C8941a.m16118a(afr);
            }
        }
        AppMethodBeat.m2505o(78054);
    }

    /* renamed from: a */
    public final int mo23093a(final String str, final C18496c c18496c, final C9545d c9545d) {
        AppMethodBeat.m2504i(78055);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
            AppMethodBeat.m2505o(78055);
            return -1;
        } else if (c18496c == null && c9545d == null) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "cdn callback info all null");
            AppMethodBeat.m2505o(78055);
            return -2;
        } else {
            if (c18496c != null) {
                C4990ab.m7411d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", Integer.valueOf(c18496c.field_toltalLength), Integer.valueOf(c18496c.field_finishedLength), Boolean.valueOf(c18496c.field_mtlnotify));
            }
            this.fyP = C5046bo.anU();
            this.fyO = str;
            C7305d.xDH.mo10140a(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.m2504i(78040);
                    C42130g c42130g = (C42130g) C31259b.this.fyM.get(str);
                    if (c42130g == null) {
                        C4990ab.m7411d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", str, Integer.valueOf(C31259b.this.hashCode()));
                        C7060h.pYm.mo8378a(594, 7, 1, true);
                        AppMethodBeat.m2505o(78040);
                        return;
                    }
                    C18497f c18497f;
                    if (c18496c != null) {
                        c18496c.cHr = str;
                        C4990ab.m7417i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(c18496c.field_toltalLength), Integer.valueOf(c18496c.field_finishedLength), Boolean.valueOf(c18496c.field_mtlnotify));
                    }
                    if (c9545d != null) {
                        c9545d.cHr = str;
                    }
                    if (c42130g.egl != null) {
                        long anU = C5046bo.anU();
                        if (c9545d != null || c18496c == null || c18496c.field_mtlnotify || C5023at.getNetWorkType(C4996ah.getContext()) != -1) {
                            c42130g.field_lastProgressCallbackTime = anU;
                            c42130g.egl.mo5082a(str, 0, c18496c, c9545d, c42130g.field_onlycheckexist);
                        } else {
                            AppMethodBeat.m2505o(78040);
                            return;
                        }
                    }
                    if (c42130g instanceof C18497f) {
                        c18497f = (C18497f) c42130g;
                    } else {
                        c18497f = null;
                    }
                    C18496c c18496c = c18496c;
                    if (c18496c == null || c18496c.field_finishedLength == c18496c.field_toltalLength) {
                        i = 1;
                    }
                    if (i != 0 && (c18497f == null || c18497f.mo33736Jo())) {
                        C31259b.this.fyN.remove(str);
                    }
                    if (c9545d != null) {
                        if (c18497f == null || c18497f.mo33736Jo()) {
                            C31259b.this.fyM.remove(str);
                        }
                        if (c9545d.field_retCode == -5103011) {
                            C4990ab.m7416i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            C7060h.pYm.mo8378a(546, 4, 1, true);
                            C37461f.afy().keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                    AppMethodBeat.m2505o(78040);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(78041);
                    String str = super.toString() + "|callback";
                    AppMethodBeat.m2505o(78041);
                    return str;
                }
            }, "MicroMsg.CdnTransportService");
            AppMethodBeat.m2505o(78055);
            return 0;
        }
    }

    /* renamed from: a */
    public final void mo23095a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.m2504i(78056);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            AppMethodBeat.m2505o(78056);
            return;
        }
        C42130g c42130g = (C42130g) this.fyM.get(str);
        if (c42130g == null) {
            C4990ab.m7413e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", str);
            AppMethodBeat.m2505o(78056);
        } else if (c42130g.egl != null) {
            c42130g.egl.mo5083a(str, byteArrayOutputStream);
            AppMethodBeat.m2505o(78056);
        } else {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
            AppMethodBeat.m2505o(78056);
        }
    }

    /* renamed from: l */
    public final byte[] mo23098l(String str, byte[] bArr) {
        AppMethodBeat.m2504i(78057);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            AppMethodBeat.m2505o(78057);
            return null;
        }
        C42130g c42130g = (C42130g) this.fyM.get(str);
        if (c42130g == null) {
            C4990ab.m7413e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            AppMethodBeat.m2505o(78057);
            return null;
        } else if (c42130g.egl != null) {
            byte[] l = c42130g.egl.mo5084l(str, bArr);
            AppMethodBeat.m2505o(78057);
            return l;
        } else {
            C4990ab.m7412e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            AppMethodBeat.m2505o(78057);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo23094a(final String str, final C9545d c9545d) {
        AppMethodBeat.m2504i(78058);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78058);
            return;
        }
        C7305d.xDH.mo10140a(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78042);
                C42130g c42130g = (C42130g) C31259b.this.fyM.get(str);
                if (c42130g == null) {
                    C4990ab.m7411d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                    AppMethodBeat.m2505o(78042);
                    return;
                }
                if (c42130g.egz != null) {
                    c42130g.egz.mo5085a(str, c9545d);
                }
                AppMethodBeat.m2505o(78042);
            }
        }, "MicroMsg.CdnTransportService");
        AppMethodBeat.m2505o(78058);
    }
}
