package com.tencent.p177mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p856b.C32719a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p856b.C32720b.C9558a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C42873a.C42874a;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C45803b;
import com.tencent.p177mm.plugin.cdndownloader.p934c.C11365a;
import com.tencent.p177mm.plugin.downloader.p939a.C38842c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService */
public class CDNDownloadService extends Service implements C32719a {
    private static C45803b ktn;
    private static C1628a ktz = new C113712();
    private final C42874a kty = new C113701();

    /* renamed from: com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService$1 */
    class C113701 extends C42874a {
        C113701() {
        }

        /* renamed from: a */
        public final int mo23082a(CDNTaskInfo cDNTaskInfo) {
            AppMethodBeat.m2504i(938);
            C4990ab.m7417i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", cDNTaskInfo.downloadUrl, cDNTaskInfo.filePath);
            C42130g c42130g = new C42130g();
            c42130g.egs = cDNTaskInfo.egs;
            c42130g.field_mediaId = cDNTaskInfo.cHr;
            c42130g.field_fullpath = cDNTaskInfo.filePath;
            c42130g.egm = C38842c.m65894Ij(cDNTaskInfo.downloadUrl);
            c42130g.egt = C38842c.m65894Ij(cDNTaskInfo.ktq);
            c42130g.egl = CDNDownloadService.ktz;
            c42130g.egn = cDNTaskInfo.kts;
            c42130g.ego = cDNTaskInfo.ktt;
            c42130g.allow_mobile_net_download = cDNTaskInfo.ktu;
            c42130g.egr = cDNTaskInfo.ktv;
            CDNDownloadService.m31248a(c42130g, cDNTaskInfo.ktr);
            int f = C11365a.beU().mo23097f(c42130g);
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(f)));
            AppMethodBeat.m2505o(938);
            return f;
        }

        /* renamed from: b */
        public final int mo23085b(CDNTaskInfo cDNTaskInfo) {
            int resumeHttpMultiSocketDownloadTask;
            AppMethodBeat.m2504i(939);
            C4990ab.m7417i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", cDNTaskInfo.downloadUrl);
            C42130g c42130g = new C42130g();
            c42130g.egs = cDNTaskInfo.egs;
            c42130g.field_mediaId = cDNTaskInfo.cHr;
            c42130g.field_fullpath = cDNTaskInfo.filePath;
            c42130g.egm = C38842c.m65894Ij(cDNTaskInfo.downloadUrl);
            c42130g.egt = C38842c.m65894Ij(cDNTaskInfo.ktq);
            c42130g.egl = CDNDownloadService.ktz;
            c42130g.egn = cDNTaskInfo.kts;
            c42130g.ego = cDNTaskInfo.ktt;
            c42130g.egr = cDNTaskInfo.ktv;
            c42130g.allow_mobile_net_download = cDNTaskInfo.ktu;
            CDNDownloadService.m31248a(c42130g, cDNTaskInfo.ktr);
            C11365a beU = C11365a.beU();
            if (beU.fyM.containsKey(c42130g.field_mediaId)) {
                resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(c42130g.field_mediaId);
                C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", c42130g.field_mediaId, Integer.valueOf(resumeHttpMultiSocketDownloadTask));
            } else {
                C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", c42130g.field_mediaId);
                resumeHttpMultiSocketDownloadTask = beU.mo23097f(c42130g);
            }
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(resumeHttpMultiSocketDownloadTask)));
            AppMethodBeat.m2505o(939);
            return resumeHttpMultiSocketDownloadTask;
        }

        /* renamed from: HA */
        public final boolean mo23079HA(String str) {
            AppMethodBeat.m2504i(940);
            C11365a.beU();
            boolean HD = C11365a.m19106HD(str);
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "pauseDownloadTask: ".concat(String.valueOf(HD)));
            AppMethodBeat.m2505o(940);
            return HD;
        }

        /* renamed from: HB */
        public final boolean mo23080HB(String str) {
            AppMethodBeat.m2504i(941);
            C11365a beU = C11365a.beU();
            C42130g c42130g = (C42130g) beU.fyM.remove(str);
            if (c42130g != null) {
                if (c42130g.field_fileType == C42129a.efP || c42130g.field_fileType == C42129a.efR) {
                    beU.afy();
                    C8941a.m16131rK(str);
                } else if (c42130g.egs) {
                    beU.afy();
                    C8941a.m16132rL(str);
                } else {
                    beU.afy();
                    C8941a.m16127rG(str);
                }
                C7060h.pYm.mo8381e(10769, Integer.valueOf(C37458c.fzg), Integer.valueOf(c42130g.field_fileType), Long.valueOf(C5046bo.anU() - c42130g.field_startTime));
            }
            beU.fyL.remove(str);
            beU.fyN.remove(str);
            C4990ab.m7417i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, c42130g, Integer.valueOf(0));
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
            AppMethodBeat.m2505o(941);
            return true;
        }

        /* renamed from: HC */
        public final CDNTaskState mo23081HC(String str) {
            AppMethodBeat.m2504i(942);
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(str);
            CDNTaskState cDNTaskState = new CDNTaskState();
            if (httpMultiSocketDownloadTaskState != null) {
                cDNTaskState.taskState = httpMultiSocketDownloadTaskState.taskState;
                cDNTaskState.fileTotalSize = httpMultiSocketDownloadTaskState.fileTotalSize;
                cDNTaskState.completeSize = httpMultiSocketDownloadTaskState.completeSize;
            }
            AppMethodBeat.m2505o(942);
            return cDNTaskState;
        }

        /* renamed from: a */
        public final void mo23083a(C45803b c45803b) {
            AppMethodBeat.m2504i(943);
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "registerCallback");
            CDNDownloadService.ktn = c45803b;
            AppMethodBeat.m2505o(943);
        }

        /* renamed from: b */
        public final void mo23086b(C45803b c45803b) {
            AppMethodBeat.m2504i(944);
            CDNDownloadService.ktn = null;
            AppMethodBeat.m2505o(944);
        }

        /* renamed from: tr */
        public final void mo23090tr(int i) {
            AppMethodBeat.m2504i(945);
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(i)));
            BaseEvent.onNetworkChange();
            AppMethodBeat.m2505o(945);
        }

        public final void beS() {
            AppMethodBeat.m2504i(947);
            C4990ab.m7416i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
            C9558a.eGP.mo53238b(CDNDownloadService.this);
            AppMethodBeat.m2505o(947);
        }

        public final void beT() {
        }

        public final void beR() {
            AppMethodBeat.m2504i(946);
            if (!C9558a.eGP.mo53239c(CDNDownloadService.this)) {
                C4990ab.m7416i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
                C9558a.eGP.mo53237a(CDNDownloadService.this);
            }
            AppMethodBeat.m2505o(946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService$2 */
    static class C113712 implements C1628a {
        C113712() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            AppMethodBeat.m2504i(948);
            String str3 = "MicroMsg.CDNDownloadService";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = c18496c == null ? BuildConfig.COMMAND : c18496c.toString();
            if (c9545d == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = c9545d.toString();
            }
            objArr[3] = str2;
            C4990ab.m7411d(str3, str4, objArr);
            if (i == -21006) {
                C4990ab.m7417i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.m2505o(948);
            } else if (i != 0) {
                C4990ab.m7413e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                CDNDownloadService.m31247O(str, 4, i);
                AppMethodBeat.m2505o(948);
            } else if (c18496c != null) {
                CDNDownloadService.m31250n(str, (long) c18496c.field_finishedLength, (long) c18496c.field_toltalLength);
                AppMethodBeat.m2505o(948);
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                        CDNDownloadService.m31247O(str, 4, c9545d.field_retCode);
                    } else {
                        C4990ab.m7417i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", str);
                        CDNDownloadService.m31247O(str, 3, 0);
                    }
                }
                AppMethodBeat.m2505o(948);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public CDNDownloadService() {
        AppMethodBeat.m2504i(949);
        AppMethodBeat.m2505o(949);
    }

    static {
        AppMethodBeat.m2504i(957);
        AppMethodBeat.m2505o(957);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(950);
        C4990ab.m7416i("MicroMsg.CDNDownloadService", "onBind");
        C42874a c42874a = this.kty;
        AppMethodBeat.m2505o(950);
        return c42874a;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(951);
        C4990ab.m7416i("MicroMsg.CDNDownloadService", "onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(951);
        return onUnbind;
    }

    public void onCreate() {
        AppMethodBeat.m2504i(952);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.CDNDownloadService", "onCreate");
        AppMethodBeat.m2505o(952);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(953);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.CDNDownloadService", "onDestroy");
        C9558a.eGP.mo53238b(this);
        C7060h.pYm.mo8378a(710, 1, 1, false);
        AppMethodBeat.m2505o(953);
    }

    /* renamed from: a */
    static /* synthetic */ void m31248a(C42130g c42130g, String str) {
        AppMethodBeat.m2504i(954);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                c42130g.egu = new HashMap();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    c42130g.egu.put(str2, jSONObject.optString(str2));
                }
                AppMethodBeat.m2505o(954);
                return;
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.CDNDownloadService", "addVerifyHeaders: " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(954);
    }

    /* renamed from: O */
    static /* synthetic */ void m31247O(String str, int i, int i2) {
        AppMethodBeat.m2504i(955);
        C4990ab.m7417i("MicroMsg.CDNDownloadService", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), null);
        try {
            ktn.mo6910e(str, i, i2, null);
            AppMethodBeat.m2505o(955);
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.CDNDownloadService", "updateDownloadState: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(955);
        }
    }

    /* renamed from: n */
    static /* synthetic */ void m31250n(String str, long j, long j2) {
        AppMethodBeat.m2504i(956);
        try {
            ktn.mo6911l(str, j, j2);
            AppMethodBeat.m2505o(956);
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.CDNDownloadService", "updateProgressChange: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(956);
        }
    }
}
