package com.tencent.p177mm.plugin.cdndownloader.p934c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C26324b.C26323a;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.cdndownloader.c.a */
public final class C11365a implements C26323a {
    private static C11365a kta = null;
    private C5004al eKj = new C5004al();
    Queue<String> fyK = new LinkedList();
    public Map<String, C42130g> fyL = new ConcurrentHashMap();
    public Map<String, C42130g> fyM = new ConcurrentHashMap();
    public Map<String, Integer> fyN = new ConcurrentHashMap();
    private String fyO = "";
    private long fyP = 0;
    public HashSet<String> fyQ = new HashSet();
    private C8941a ktb = null;

    /* renamed from: e */
    static /* synthetic */ C8941a m19112e(C11365a c11365a) {
        AppMethodBeat.m2504i(888);
        C8941a afy = c11365a.afy();
        AppMethodBeat.m2505o(888);
        return afy;
    }

    public C11365a() {
        AppMethodBeat.m2504i(879);
        AppMethodBeat.m2505o(879);
    }

    public static synchronized C11365a beU() {
        C11365a c11365a;
        synchronized (C11365a.class) {
            AppMethodBeat.m2504i(880);
            if (kta == null) {
                kta = new C11365a();
            }
            c11365a = kta;
            AppMethodBeat.m2505o(880);
        }
        return c11365a;
    }

    public final C8941a afy() {
        AppMethodBeat.m2504i(881);
        if (this.ktb == null) {
            if (C4996ah.bqo()) {
                C4990ab.m7416i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
                this.ktb = C37461f.afy();
            } else {
                C4990ab.m7416i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
                this.ktb = new C8941a(C4996ah.getContext().getFilesDir() + "/NativeCDNInfo", this);
            }
        }
        C8941a c8941a = this.ktb;
        AppMethodBeat.m2505o(881);
        return c8941a;
    }

    /* renamed from: HD */
    public static boolean m19106HD(String str) {
        AppMethodBeat.m2504i(883);
        C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", str, Integer.valueOf(CdnLogic.pauseHttpMultiSocketDownloadTask(str)));
        if (CdnLogic.pauseHttpMultiSocketDownloadTask(str) == 0) {
            AppMethodBeat.m2505o(883);
            return true;
        }
        AppMethodBeat.m2505o(883);
        return false;
    }

    /* renamed from: a */
    public final int mo23093a(String str, C18496c c18496c, C9545d c9545d) {
        AppMethodBeat.m2504i(884);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
            AppMethodBeat.m2505o(884);
            return -1;
        } else if (c18496c == null && c9545d == null) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
            AppMethodBeat.m2505o(884);
            return -2;
        } else {
            if (c18496c != null) {
                C4990ab.m7411d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", Integer.valueOf(c18496c.field_toltalLength), Integer.valueOf(c18496c.field_finishedLength), Boolean.valueOf(c18496c.field_mtlnotify), Boolean.valueOf(c18496c.field_isUploadTask));
            }
            final boolean z = c18496c != null ? c18496c.field_isUploadTask : false;
            this.fyP = C5046bo.anU();
            this.fyO = str;
            final String str2 = str;
            final C18496c c18496c2 = c18496c;
            final C9545d c9545d2 = c9545d;
            this.eKj.mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(876);
                    C42130g c42130g = (C42130g) C11365a.this.fyM.get(str2);
                    if (c42130g == null) {
                        C4990ab.m7413e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str2);
                        AppMethodBeat.m2505o(876);
                        return;
                    }
                    if (c18496c2 != null) {
                        c18496c2.cHr = str2;
                        C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", Integer.valueOf(c18496c2.field_toltalLength), Integer.valueOf(c18496c2.field_finishedLength), Boolean.valueOf(c18496c2.field_mtlnotify), Boolean.valueOf(c42130g.cRY), Boolean.valueOf(c18496c2.field_isUploadTask), Boolean.valueOf(z));
                        if (z != c42130g.cRY) {
                            AppMethodBeat.m2505o(876);
                            return;
                        }
                    }
                    if (c9545d2 != null) {
                        c9545d2.cHr = str2;
                    }
                    if (c42130g.egl != null) {
                        long anU = C5046bo.anU();
                        if (c9545d2 != null || c18496c2 == null || c18496c2.field_mtlnotify || C5023at.getNetWorkType(C4996ah.getContext()) != -1) {
                            c42130g.field_lastProgressCallbackTime = anU;
                            c42130g.egl.mo5082a(str2, 0, c18496c2, c9545d2, c42130g.field_onlycheckexist);
                        } else {
                            AppMethodBeat.m2505o(876);
                            return;
                        }
                    }
                    if (C11365a.m19108a(c18496c2)) {
                        C11365a.this.fyN.remove(str2);
                    }
                    if (c9545d2 != null) {
                        C11365a.this.fyM.remove(str2);
                        if (c9545d2.field_retCode == -5103011) {
                            C4990ab.m7416i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            C7060h.pYm.mo8378a(546, 4, 1, true);
                            C11365a.m19112e(C11365a.this).keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                    AppMethodBeat.m2505o(876);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(877);
                    String str = super.toString() + "|callback";
                    AppMethodBeat.m2505o(877);
                    return str;
                }
            });
            AppMethodBeat.m2505o(884);
            return 0;
        }
    }

    /* renamed from: a */
    public final void mo23095a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.m2504i(885);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
            AppMethodBeat.m2505o(885);
            return;
        }
        C42130g c42130g = (C42130g) this.fyM.get(str);
        if (c42130g == null) {
            C4990ab.m7413e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", str);
            AppMethodBeat.m2505o(885);
        } else if (c42130g.egl != null) {
            c42130g.egl.mo5083a(str, byteArrayOutputStream);
            AppMethodBeat.m2505o(885);
        } else {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
            AppMethodBeat.m2505o(885);
        }
    }

    /* renamed from: l */
    public final byte[] mo23098l(String str, byte[] bArr) {
        AppMethodBeat.m2504i(886);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
            AppMethodBeat.m2505o(886);
            return null;
        }
        C42130g c42130g = (C42130g) this.fyM.get(str);
        if (c42130g == null) {
            C4990ab.m7413e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            AppMethodBeat.m2505o(886);
            return null;
        } else if (c42130g.egl != null) {
            byte[] l = c42130g.egl.mo5084l(str, bArr);
            AppMethodBeat.m2505o(886);
            return l;
        } else {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
            AppMethodBeat.m2505o(886);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo23094a(final String str, final C9545d c9545d) {
        AppMethodBeat.m2504i(887);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(887);
            return;
        }
        this.eKj.mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(878);
                C42130g c42130g = (C42130g) C11365a.this.fyM.get(str);
                if (c42130g == null) {
                    C4990ab.m7413e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str);
                    AppMethodBeat.m2505o(878);
                    return;
                }
                if (c42130g.egz != null) {
                    c42130g.egz.mo5085a(str, c9545d);
                }
                AppMethodBeat.m2505o(878);
            }
        });
        AppMethodBeat.m2505o(887);
    }

    /* renamed from: f */
    public final int mo23097f(final C42130g c42130g) {
        AppMethodBeat.m2504i(882);
        if (C5046bo.isNullOrNil(c42130g.field_mediaId)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
            AppMethodBeat.m2505o(882);
            return -1;
        }
        if (c42130g.field_fileId == null) {
            c42130g.field_fileId = "";
        }
        if (c42130g.field_aesKey == null) {
            c42130g.field_aesKey = "";
        }
        if (this.fyK.contains(c42130g.field_fileId)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
            AppMethodBeat.m2505o(882);
            return -2;
        } else if (this.fyL.containsKey(c42130g.field_fileId)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
            AppMethodBeat.m2505o(882);
            return -2;
        } else if (this.fyM.containsKey(c42130g.field_fileId)) {
            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
            AppMethodBeat.m2505o(882);
            return -2;
        } else {
            c42130g.cRY = false;
            this.eKj.mo10302aa(new Runnable() {
                final /* synthetic */ int fyS = -1;

                public final void run() {
                    AppMethodBeat.m2504i(874);
                    if (this.fyS != -1) {
                        C11365a.this.fyN.put(c42130g.field_mediaId, Integer.valueOf(this.fyS));
                    }
                    C11365a.this.fyK.add(c42130g.field_mediaId);
                    C11365a.this.fyL.put(c42130g.field_mediaId, c42130g);
                    C11365a c11365a = C11365a.this;
                    C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", Integer.valueOf(c11365a.fyK.size()));
                    while (!c11365a.fyK.isEmpty()) {
                        C42130g c42130g = (C42130g) c11365a.fyL.remove((String) c11365a.fyK.poll());
                        if (c42130g == null) {
                            C4990ab.m7412e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
                            AppMethodBeat.m2505o(874);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", c42130g.field_mediaId, Boolean.valueOf(c42130g.field_autostart), Integer.valueOf(c42130g.field_chattype));
                        c42130g.field_startTime = C5046bo.anU();
                        String str;
                        int i;
                        int b;
                        if (c42130g.cRY) {
                            String str2 = "MicroMsg.CdnDownloadNativeService";
                            str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                            Object[] objArr = new Object[7];
                            if (c42130g.field_fullpath == null) {
                                i = -1;
                            } else {
                                i = c42130g.field_fullpath.length();
                            }
                            objArr[0] = Integer.valueOf(i);
                            if (c42130g.field_thumbpath == null) {
                                i = -1;
                            } else {
                                i = c42130g.field_thumbpath.length();
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = C5046bo.anv(c42130g.field_svr_signature);
                            objArr[3] = C5046bo.anv(c42130g.field_aesKey);
                            objArr[4] = Integer.valueOf(c42130g.field_fileType);
                            objArr[5] = c42130g.field_mediaId;
                            objArr[6] = Boolean.valueOf(c42130g.field_onlycheckexist);
                            C4990ab.m7417i(str2, str, objArr);
                            if (c42130g.field_fullpath == null) {
                                c42130g.field_fullpath = "";
                            }
                            if (c42130g.field_thumbpath == null) {
                                c42130g.field_thumbpath = "";
                            }
                            b = c11365a.afy().mo20372b(c42130g);
                            if (b != 0) {
                                C4990ab.m7413e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(b), c42130g.field_mediaId);
                                if (c42130g.egl != null) {
                                    c42130g.egl.mo5082a(c42130g.field_mediaId, b, null, null, c42130g.field_onlycheckexist);
                                }
                            } else {
                                C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", c42130g.field_mediaId);
                                c11365a.fyM.put(c42130g.field_mediaId, c42130g);
                            }
                        } else {
                            i = -1;
                            String str3;
                            Object[] objArr2;
                            int i2;
                            if (c42130g.field_fileType == C42129a.efP || c42130g.field_fileType == C42129a.efR || c42130g.field_fileType == C42129a.efS || c42130g.field_fileType == C42129a.efT || c42130g.field_fileType == C42129a.efU || c42130g.field_fileType == C42129a.efV) {
                                if (!(c42130g.field_fullpath == null || c42130g.field_fullpath.isEmpty())) {
                                    i = c11365a.afy().mo20362a(c42130g.field_mediaId, c42130g.egm, c42130g.field_fullpath, c42130g.field_fileType, c42130g.egn, c42130g.ego, c42130g.egp, c42130g.egq);
                                }
                                str = "MicroMsg.CdnDownloadNativeService";
                                str3 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d";
                                objArr2 = new Object[5];
                                if (c42130g.field_fullpath == null) {
                                    i2 = -1;
                                } else {
                                    i2 = c42130g.field_fullpath.length();
                                }
                                objArr2[0] = Integer.valueOf(i2);
                                objArr2[1] = c42130g.field_mediaId;
                                objArr2[2] = c42130g.egm;
                                objArr2[3] = Integer.valueOf(c42130g.field_fileType);
                                objArr2[4] = Integer.valueOf(i);
                                C4990ab.m7417i(str, str3, objArr2);
                                b = i;
                            } else if (c42130g.egs) {
                                if (!(c42130g.field_fullpath == null || c42130g.field_fullpath.isEmpty())) {
                                    i = c11365a.afy().mo20367a(c42130g.field_mediaId, c42130g.field_fullpath, c42130g.egm, c42130g.egt, c42130g.egu, c42130g.allow_mobile_net_download, c42130g.egn, c42130g.ego, c42130g.is_resume_task, c42130g.egr, c42130g.egp);
                                }
                                str = "MicroMsg.CdnDownloadNativeService";
                                str3 = "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]";
                                objArr2 = new Object[4];
                                objArr2[0] = c42130g.field_fullpath == null ? "" : c42130g.field_fullpath;
                                objArr2[1] = c42130g.field_mediaId;
                                objArr2[2] = c42130g.egm;
                                objArr2[3] = c42130g.egt;
                                C4990ab.m7417i(str, str3, objArr2);
                                b = i;
                            } else {
                                str = "MicroMsg.CdnDownloadNativeService";
                                str3 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                                objArr2 = new Object[7];
                                if (c42130g.field_fullpath == null) {
                                    i2 = -1;
                                } else {
                                    i2 = c42130g.field_fullpath.length();
                                }
                                objArr2[0] = Integer.valueOf(i2);
                                if (c42130g.field_thumbpath == null) {
                                    i2 = -1;
                                } else {
                                    i2 = c42130g.field_thumbpath.length();
                                }
                                objArr2[1] = Integer.valueOf(i2);
                                objArr2[2] = c42130g.field_svr_signature;
                                objArr2[3] = c42130g.field_aesKey;
                                objArr2[4] = Integer.valueOf(c42130g.field_fileType);
                                objArr2[5] = c42130g.field_mediaId;
                                objArr2[6] = Boolean.valueOf(c42130g.field_onlycheckexist);
                                C4990ab.m7417i(str, str3, objArr2);
                                if (c42130g.egx != 2) {
                                    b = c11365a.afy().mo20374c(c42130g);
                                } else if (c42130g instanceof C44686h) {
                                    C44686h c44686h = (C44686h) c42130g;
                                    if (c44686h.mo67677Jr()) {
                                        b = c11365a.afy().mo20361a(c42130g, 2);
                                    } else {
                                        if (c44686h.mo67675Jp()) {
                                            i = c11365a.afy().mo20366a(c44686h.field_mediaId, c44686h.url, c44686h.referer, c44686h.field_fullpath, c44686h.egD, c44686h.ege, c44686h.isColdSnsData, c44686h.signalQuality, c44686h.snsScene, c44686h.field_preloadRatio, c44686h.field_requestVideoFormat, 1);
                                        }
                                        b = i;
                                    }
                                } else {
                                    b = -1;
                                }
                            }
                            if (b != 0) {
                                C4990ab.m7413e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(b), c42130g.field_mediaId);
                                if (c42130g.egl != null) {
                                    c42130g.egl.mo5082a(c42130g.field_mediaId, b, null, null, c42130g.field_onlycheckexist);
                                }
                            } else {
                                C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", c42130g.field_mediaId);
                                c11365a.fyM.put(c42130g.field_mediaId, c42130g);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(874);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(875);
                    String str = super.toString() + "|addRecvTask";
                    AppMethodBeat.m2505o(875);
                    return str;
                }
            });
            AppMethodBeat.m2505o(882);
            return 0;
        }
    }
}
