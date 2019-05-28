package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.cdndownloader.a.b;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class CDNDownloadService extends Service implements a {
    private static b ktn;
    private static g.a ktz = new g.a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(948);
            String str3 = "MicroMsg.CDNDownloadService";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = cVar == null ? BuildConfig.COMMAND : cVar.toString();
            if (dVar == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = dVar.toString();
            }
            objArr[3] = str2;
            ab.d(str3, str4, objArr);
            if (i == -21006) {
                ab.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(948);
            } else if (i != 0) {
                ab.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                CDNDownloadService.O(str, 4, i);
                AppMethodBeat.o(948);
            } else if (cVar != null) {
                CDNDownloadService.n(str, (long) cVar.field_finishedLength, (long) cVar.field_toltalLength);
                AppMethodBeat.o(948);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        CDNDownloadService.O(str, 4, dVar.field_retCode);
                    } else {
                        ab.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", str);
                        CDNDownloadService.O(str, 3, 0);
                    }
                }
                AppMethodBeat.o(948);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    private final com.tencent.mm.plugin.cdndownloader.a.a.a kty = new com.tencent.mm.plugin.cdndownloader.a.a.a() {
        public final int a(CDNTaskInfo cDNTaskInfo) {
            AppMethodBeat.i(938);
            ab.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", cDNTaskInfo.downloadUrl, cDNTaskInfo.filePath);
            g gVar = new g();
            gVar.egs = cDNTaskInfo.egs;
            gVar.field_mediaId = cDNTaskInfo.cHr;
            gVar.field_fullpath = cDNTaskInfo.filePath;
            gVar.egm = com.tencent.mm.plugin.downloader.a.c.Ij(cDNTaskInfo.downloadUrl);
            gVar.egt = com.tencent.mm.plugin.downloader.a.c.Ij(cDNTaskInfo.ktq);
            gVar.egl = CDNDownloadService.ktz;
            gVar.egn = cDNTaskInfo.kts;
            gVar.ego = cDNTaskInfo.ktt;
            gVar.allow_mobile_net_download = cDNTaskInfo.ktu;
            gVar.egr = cDNTaskInfo.ktv;
            CDNDownloadService.a(gVar, cDNTaskInfo.ktr);
            int f = com.tencent.mm.plugin.cdndownloader.c.a.beU().f(gVar);
            ab.i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(f)));
            AppMethodBeat.o(938);
            return f;
        }

        public final int b(CDNTaskInfo cDNTaskInfo) {
            int resumeHttpMultiSocketDownloadTask;
            AppMethodBeat.i(939);
            ab.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", cDNTaskInfo.downloadUrl);
            g gVar = new g();
            gVar.egs = cDNTaskInfo.egs;
            gVar.field_mediaId = cDNTaskInfo.cHr;
            gVar.field_fullpath = cDNTaskInfo.filePath;
            gVar.egm = com.tencent.mm.plugin.downloader.a.c.Ij(cDNTaskInfo.downloadUrl);
            gVar.egt = com.tencent.mm.plugin.downloader.a.c.Ij(cDNTaskInfo.ktq);
            gVar.egl = CDNDownloadService.ktz;
            gVar.egn = cDNTaskInfo.kts;
            gVar.ego = cDNTaskInfo.ktt;
            gVar.egr = cDNTaskInfo.ktv;
            gVar.allow_mobile_net_download = cDNTaskInfo.ktu;
            CDNDownloadService.a(gVar, cDNTaskInfo.ktr);
            com.tencent.mm.plugin.cdndownloader.c.a beU = com.tencent.mm.plugin.cdndownloader.c.a.beU();
            if (beU.fyM.containsKey(gVar.field_mediaId)) {
                resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(gVar.field_mediaId);
                ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", gVar.field_mediaId, Integer.valueOf(resumeHttpMultiSocketDownloadTask));
            } else {
                ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", gVar.field_mediaId);
                resumeHttpMultiSocketDownloadTask = beU.f(gVar);
            }
            ab.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(resumeHttpMultiSocketDownloadTask)));
            AppMethodBeat.o(939);
            return resumeHttpMultiSocketDownloadTask;
        }

        public final boolean HA(String str) {
            AppMethodBeat.i(940);
            com.tencent.mm.plugin.cdndownloader.c.a.beU();
            boolean HD = com.tencent.mm.plugin.cdndownloader.c.a.HD(str);
            ab.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: ".concat(String.valueOf(HD)));
            AppMethodBeat.o(940);
            return HD;
        }

        public final boolean HB(String str) {
            AppMethodBeat.i(941);
            com.tencent.mm.plugin.cdndownloader.c.a beU = com.tencent.mm.plugin.cdndownloader.c.a.beU();
            g gVar = (g) beU.fyM.remove(str);
            if (gVar != null) {
                if (gVar.field_fileType == com.tencent.mm.i.a.efP || gVar.field_fileType == com.tencent.mm.i.a.efR) {
                    beU.afy();
                    com.tencent.mm.al.a.rK(str);
                } else if (gVar.egs) {
                    beU.afy();
                    com.tencent.mm.al.a.rL(str);
                } else {
                    beU.afy();
                    com.tencent.mm.al.a.rG(str);
                }
                h.pYm.e(10769, Integer.valueOf(com.tencent.mm.al.c.fzg), Integer.valueOf(gVar.field_fileType), Long.valueOf(bo.anU() - gVar.field_startTime));
            }
            beU.fyL.remove(str);
            beU.fyN.remove(str);
            ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, gVar, Integer.valueOf(0));
            ab.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
            AppMethodBeat.o(941);
            return true;
        }

        public final CDNTaskState HC(String str) {
            AppMethodBeat.i(942);
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(str);
            CDNTaskState cDNTaskState = new CDNTaskState();
            if (httpMultiSocketDownloadTaskState != null) {
                cDNTaskState.taskState = httpMultiSocketDownloadTaskState.taskState;
                cDNTaskState.fileTotalSize = httpMultiSocketDownloadTaskState.fileTotalSize;
                cDNTaskState.completeSize = httpMultiSocketDownloadTaskState.completeSize;
            }
            AppMethodBeat.o(942);
            return cDNTaskState;
        }

        public final void a(b bVar) {
            AppMethodBeat.i(943);
            ab.i("MicroMsg.CDNDownloadService", "registerCallback");
            CDNDownloadService.ktn = bVar;
            AppMethodBeat.o(943);
        }

        public final void b(b bVar) {
            AppMethodBeat.i(944);
            CDNDownloadService.ktn = null;
            AppMethodBeat.o(944);
        }

        public final void tr(int i) {
            AppMethodBeat.i(945);
            ab.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(i)));
            BaseEvent.onNetworkChange();
            AppMethodBeat.o(945);
        }

        public final void beS() {
            AppMethodBeat.i(947);
            ab.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
            com.tencent.mm.ipcinvoker.wx_extension.b.b.a.eGP.b(CDNDownloadService.this);
            AppMethodBeat.o(947);
        }

        public final void beT() {
        }

        public final void beR() {
            AppMethodBeat.i(946);
            if (!com.tencent.mm.ipcinvoker.wx_extension.b.b.a.eGP.c(CDNDownloadService.this)) {
                ab.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
                com.tencent.mm.ipcinvoker.wx_extension.b.b.a.eGP.a(CDNDownloadService.this);
            }
            AppMethodBeat.o(946);
        }
    };

    public CDNDownloadService() {
        AppMethodBeat.i(949);
        AppMethodBeat.o(949);
    }

    static {
        AppMethodBeat.i(957);
        AppMethodBeat.o(957);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(950);
        ab.i("MicroMsg.CDNDownloadService", "onBind");
        com.tencent.mm.plugin.cdndownloader.a.a.a aVar = this.kty;
        AppMethodBeat.o(950);
        return aVar;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(951);
        ab.i("MicroMsg.CDNDownloadService", "onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(951);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.i(952);
        super.onCreate();
        ab.i("MicroMsg.CDNDownloadService", "onCreate");
        AppMethodBeat.o(952);
    }

    public void onDestroy() {
        AppMethodBeat.i(953);
        super.onDestroy();
        ab.i("MicroMsg.CDNDownloadService", "onDestroy");
        com.tencent.mm.ipcinvoker.wx_extension.b.b.a.eGP.b(this);
        h.pYm.a(710, 1, 1, false);
        AppMethodBeat.o(953);
    }

    static /* synthetic */ void a(g gVar, String str) {
        AppMethodBeat.i(954);
        if (!bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                gVar.egu = new HashMap();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    gVar.egu.put(str2, jSONObject.optString(str2));
                }
                AppMethodBeat.o(954);
                return;
            } catch (JSONException e) {
                ab.e("MicroMsg.CDNDownloadService", "addVerifyHeaders: " + e.getMessage());
            }
        }
        AppMethodBeat.o(954);
    }

    static /* synthetic */ void O(String str, int i, int i2) {
        AppMethodBeat.i(955);
        ab.i("MicroMsg.CDNDownloadService", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), null);
        try {
            ktn.e(str, i, i2, null);
            AppMethodBeat.o(955);
        } catch (RemoteException e) {
            ab.e("MicroMsg.CDNDownloadService", "updateDownloadState: ".concat(String.valueOf(e)));
            AppMethodBeat.o(955);
        }
    }

    static /* synthetic */ void n(String str, long j, long j2) {
        AppMethodBeat.i(956);
        try {
            ktn.l(str, j, j2);
            AppMethodBeat.o(956);
        } catch (RemoteException e) {
            ab.e("MicroMsg.CDNDownloadService", "updateProgressChange: ".concat(String.valueOf(e)));
            AppMethodBeat.o(956);
        }
    }
}
