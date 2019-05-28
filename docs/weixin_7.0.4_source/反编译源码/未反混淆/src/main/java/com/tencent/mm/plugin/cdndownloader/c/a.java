package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements com.tencent.mm.i.b.a {
    private static a kta = null;
    private al eKj = new al();
    Queue<String> fyK = new LinkedList();
    public Map<String, g> fyL = new ConcurrentHashMap();
    public Map<String, g> fyM = new ConcurrentHashMap();
    public Map<String, Integer> fyN = new ConcurrentHashMap();
    private String fyO = "";
    private long fyP = 0;
    public HashSet<String> fyQ = new HashSet();
    private com.tencent.mm.al.a ktb = null;

    static /* synthetic */ com.tencent.mm.al.a e(a aVar) {
        AppMethodBeat.i(888);
        com.tencent.mm.al.a afy = aVar.afy();
        AppMethodBeat.o(888);
        return afy;
    }

    public a() {
        AppMethodBeat.i(879);
        AppMethodBeat.o(879);
    }

    public static synchronized a beU() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(880);
            if (kta == null) {
                kta = new a();
            }
            aVar = kta;
            AppMethodBeat.o(880);
        }
        return aVar;
    }

    public final com.tencent.mm.al.a afy() {
        AppMethodBeat.i(881);
        if (this.ktb == null) {
            if (ah.bqo()) {
                ab.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
                this.ktb = f.afy();
            } else {
                ab.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
                this.ktb = new com.tencent.mm.al.a(ah.getContext().getFilesDir() + "/NativeCDNInfo", this);
            }
        }
        com.tencent.mm.al.a aVar = this.ktb;
        AppMethodBeat.o(881);
        return aVar;
    }

    public static boolean HD(String str) {
        AppMethodBeat.i(883);
        ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", str, Integer.valueOf(CdnLogic.pauseHttpMultiSocketDownloadTask(str)));
        if (CdnLogic.pauseHttpMultiSocketDownloadTask(str) == 0) {
            AppMethodBeat.o(883);
            return true;
        }
        AppMethodBeat.o(883);
        return false;
    }

    public final int a(String str, c cVar, d dVar) {
        AppMethodBeat.i(884);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
            AppMethodBeat.o(884);
            return -1;
        } else if (cVar == null && dVar == null) {
            ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
            AppMethodBeat.o(884);
            return -2;
        } else {
            if (cVar != null) {
                ab.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", Integer.valueOf(cVar.field_toltalLength), Integer.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify), Boolean.valueOf(cVar.field_isUploadTask));
            }
            final boolean z = cVar != null ? cVar.field_isUploadTask : false;
            this.fyP = bo.anU();
            this.fyO = str;
            final String str2 = str;
            final c cVar2 = cVar;
            final d dVar2 = dVar;
            this.eKj.aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(876);
                    g gVar = (g) a.this.fyM.get(str2);
                    if (gVar == null) {
                        ab.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str2);
                        AppMethodBeat.o(876);
                        return;
                    }
                    if (cVar2 != null) {
                        cVar2.cHr = str2;
                        ab.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", Integer.valueOf(cVar2.field_toltalLength), Integer.valueOf(cVar2.field_finishedLength), Boolean.valueOf(cVar2.field_mtlnotify), Boolean.valueOf(gVar.cRY), Boolean.valueOf(cVar2.field_isUploadTask), Boolean.valueOf(z));
                        if (z != gVar.cRY) {
                            AppMethodBeat.o(876);
                            return;
                        }
                    }
                    if (dVar2 != null) {
                        dVar2.cHr = str2;
                    }
                    if (gVar.egl != null) {
                        long anU = bo.anU();
                        if (dVar2 != null || cVar2 == null || cVar2.field_mtlnotify || at.getNetWorkType(ah.getContext()) != -1) {
                            gVar.field_lastProgressCallbackTime = anU;
                            gVar.egl.a(str2, 0, cVar2, dVar2, gVar.field_onlycheckexist);
                        } else {
                            AppMethodBeat.o(876);
                            return;
                        }
                    }
                    if (a.a(cVar2)) {
                        a.this.fyN.remove(str2);
                    }
                    if (dVar2 != null) {
                        a.this.fyM.remove(str2);
                        if (dVar2.field_retCode == -5103011) {
                            ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            h.pYm.a(546, 4, 1, true);
                            a.e(a.this).keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                    AppMethodBeat.o(876);
                }

                public final String toString() {
                    AppMethodBeat.i(877);
                    String str = super.toString() + "|callback";
                    AppMethodBeat.o(877);
                    return str;
                }
            });
            AppMethodBeat.o(884);
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(885);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
            AppMethodBeat.o(885);
            return;
        }
        g gVar = (g) this.fyM.get(str);
        if (gVar == null) {
            ab.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(885);
        } else if (gVar.egl != null) {
            gVar.egl.a(str, byteArrayOutputStream);
            AppMethodBeat.o(885);
        } else {
            ab.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
            AppMethodBeat.o(885);
        }
    }

    public final byte[] l(String str, byte[] bArr) {
        AppMethodBeat.i(886);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
            AppMethodBeat.o(886);
            return null;
        }
        g gVar = (g) this.fyM.get(str);
        if (gVar == null) {
            ab.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(886);
            return null;
        } else if (gVar.egl != null) {
            byte[] l = gVar.egl.l(str, bArr);
            AppMethodBeat.o(886);
            return l;
        } else {
            ab.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
            AppMethodBeat.o(886);
            return null;
        }
    }

    public final void a(final String str, final d dVar) {
        AppMethodBeat.i(887);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(887);
            return;
        }
        this.eKj.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(878);
                g gVar = (g) a.this.fyM.get(str);
                if (gVar == null) {
                    ab.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str);
                    AppMethodBeat.o(878);
                    return;
                }
                if (gVar.egz != null) {
                    gVar.egz.a(str, dVar);
                }
                AppMethodBeat.o(878);
            }
        });
        AppMethodBeat.o(887);
    }

    public final int f(final g gVar) {
        AppMethodBeat.i(882);
        if (bo.isNullOrNil(gVar.field_mediaId)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
            AppMethodBeat.o(882);
            return -1;
        }
        if (gVar.field_fileId == null) {
            gVar.field_fileId = "";
        }
        if (gVar.field_aesKey == null) {
            gVar.field_aesKey = "";
        }
        if (this.fyK.contains(gVar.field_fileId)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
            AppMethodBeat.o(882);
            return -2;
        } else if (this.fyL.containsKey(gVar.field_fileId)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
            AppMethodBeat.o(882);
            return -2;
        } else if (this.fyM.containsKey(gVar.field_fileId)) {
            ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
            AppMethodBeat.o(882);
            return -2;
        } else {
            gVar.cRY = false;
            this.eKj.aa(new Runnable() {
                final /* synthetic */ int fyS = -1;

                public final void run() {
                    AppMethodBeat.i(874);
                    if (this.fyS != -1) {
                        a.this.fyN.put(gVar.field_mediaId, Integer.valueOf(this.fyS));
                    }
                    a.this.fyK.add(gVar.field_mediaId);
                    a.this.fyL.put(gVar.field_mediaId, gVar);
                    a aVar = a.this;
                    ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", Integer.valueOf(aVar.fyK.size()));
                    while (!aVar.fyK.isEmpty()) {
                        g gVar = (g) aVar.fyL.remove((String) aVar.fyK.poll());
                        if (gVar == null) {
                            ab.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
                            AppMethodBeat.o(874);
                            return;
                        }
                        ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", gVar.field_mediaId, Boolean.valueOf(gVar.field_autostart), Integer.valueOf(gVar.field_chattype));
                        gVar.field_startTime = bo.anU();
                        String str;
                        int i;
                        int b;
                        if (gVar.cRY) {
                            String str2 = "MicroMsg.CdnDownloadNativeService";
                            str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                            Object[] objArr = new Object[7];
                            if (gVar.field_fullpath == null) {
                                i = -1;
                            } else {
                                i = gVar.field_fullpath.length();
                            }
                            objArr[0] = Integer.valueOf(i);
                            if (gVar.field_thumbpath == null) {
                                i = -1;
                            } else {
                                i = gVar.field_thumbpath.length();
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = bo.anv(gVar.field_svr_signature);
                            objArr[3] = bo.anv(gVar.field_aesKey);
                            objArr[4] = Integer.valueOf(gVar.field_fileType);
                            objArr[5] = gVar.field_mediaId;
                            objArr[6] = Boolean.valueOf(gVar.field_onlycheckexist);
                            ab.i(str2, str, objArr);
                            if (gVar.field_fullpath == null) {
                                gVar.field_fullpath = "";
                            }
                            if (gVar.field_thumbpath == null) {
                                gVar.field_thumbpath = "";
                            }
                            b = aVar.afy().b(gVar);
                            if (b != 0) {
                                ab.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(b), gVar.field_mediaId);
                                if (gVar.egl != null) {
                                    gVar.egl.a(gVar.field_mediaId, b, null, null, gVar.field_onlycheckexist);
                                }
                            } else {
                                ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", gVar.field_mediaId);
                                aVar.fyM.put(gVar.field_mediaId, gVar);
                            }
                        } else {
                            i = -1;
                            String str3;
                            Object[] objArr2;
                            int i2;
                            if (gVar.field_fileType == com.tencent.mm.i.a.efP || gVar.field_fileType == com.tencent.mm.i.a.efR || gVar.field_fileType == com.tencent.mm.i.a.efS || gVar.field_fileType == com.tencent.mm.i.a.efT || gVar.field_fileType == com.tencent.mm.i.a.efU || gVar.field_fileType == com.tencent.mm.i.a.efV) {
                                if (!(gVar.field_fullpath == null || gVar.field_fullpath.isEmpty())) {
                                    i = aVar.afy().a(gVar.field_mediaId, gVar.egm, gVar.field_fullpath, gVar.field_fileType, gVar.egn, gVar.ego, gVar.egp, gVar.egq);
                                }
                                str = "MicroMsg.CdnDownloadNativeService";
                                str3 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d";
                                objArr2 = new Object[5];
                                if (gVar.field_fullpath == null) {
                                    i2 = -1;
                                } else {
                                    i2 = gVar.field_fullpath.length();
                                }
                                objArr2[0] = Integer.valueOf(i2);
                                objArr2[1] = gVar.field_mediaId;
                                objArr2[2] = gVar.egm;
                                objArr2[3] = Integer.valueOf(gVar.field_fileType);
                                objArr2[4] = Integer.valueOf(i);
                                ab.i(str, str3, objArr2);
                                b = i;
                            } else if (gVar.egs) {
                                if (!(gVar.field_fullpath == null || gVar.field_fullpath.isEmpty())) {
                                    i = aVar.afy().a(gVar.field_mediaId, gVar.field_fullpath, gVar.egm, gVar.egt, gVar.egu, gVar.allow_mobile_net_download, gVar.egn, gVar.ego, gVar.is_resume_task, gVar.egr, gVar.egp);
                                }
                                str = "MicroMsg.CdnDownloadNativeService";
                                str3 = "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]";
                                objArr2 = new Object[4];
                                objArr2[0] = gVar.field_fullpath == null ? "" : gVar.field_fullpath;
                                objArr2[1] = gVar.field_mediaId;
                                objArr2[2] = gVar.egm;
                                objArr2[3] = gVar.egt;
                                ab.i(str, str3, objArr2);
                                b = i;
                            } else {
                                str = "MicroMsg.CdnDownloadNativeService";
                                str3 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                                objArr2 = new Object[7];
                                if (gVar.field_fullpath == null) {
                                    i2 = -1;
                                } else {
                                    i2 = gVar.field_fullpath.length();
                                }
                                objArr2[0] = Integer.valueOf(i2);
                                if (gVar.field_thumbpath == null) {
                                    i2 = -1;
                                } else {
                                    i2 = gVar.field_thumbpath.length();
                                }
                                objArr2[1] = Integer.valueOf(i2);
                                objArr2[2] = gVar.field_svr_signature;
                                objArr2[3] = gVar.field_aesKey;
                                objArr2[4] = Integer.valueOf(gVar.field_fileType);
                                objArr2[5] = gVar.field_mediaId;
                                objArr2[6] = Boolean.valueOf(gVar.field_onlycheckexist);
                                ab.i(str, str3, objArr2);
                                if (gVar.egx != 2) {
                                    b = aVar.afy().c(gVar);
                                } else if (gVar instanceof com.tencent.mm.i.h) {
                                    com.tencent.mm.i.h hVar = (com.tencent.mm.i.h) gVar;
                                    if (hVar.Jr()) {
                                        b = aVar.afy().a(gVar, 2);
                                    } else {
                                        if (hVar.Jp()) {
                                            i = aVar.afy().a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.egD, hVar.ege, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.field_preloadRatio, hVar.field_requestVideoFormat, 1);
                                        }
                                        b = i;
                                    }
                                } else {
                                    b = -1;
                                }
                            }
                            if (b != 0) {
                                ab.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(b), gVar.field_mediaId);
                                if (gVar.egl != null) {
                                    gVar.egl.a(gVar.field_mediaId, b, null, null, gVar.field_onlycheckexist);
                                }
                            } else {
                                ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", gVar.field_mediaId);
                                aVar.fyM.put(gVar.field_mediaId, gVar);
                            }
                        }
                    }
                    AppMethodBeat.o(874);
                }

                public final String toString() {
                    AppMethodBeat.i(875);
                    String str = super.toString() + "|addRecvTask";
                    AppMethodBeat.o(875);
                    return str;
                }
            });
            AppMethodBeat.o(882);
            return 0;
        }
    }
}
