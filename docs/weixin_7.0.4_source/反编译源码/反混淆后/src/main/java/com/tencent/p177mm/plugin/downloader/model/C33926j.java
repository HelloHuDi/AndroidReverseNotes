package com.tencent.p177mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader.p939a.C33901b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.downloader.model.j */
public final class C33926j extends C45831h {
    private static final String kMy = (C1761b.eSn + "WebNetFile");
    private HashMap<String, Long> kMA = new HashMap();
    private C1628a kNz = new C339254();
    private Context mContext = C4996ah.getContext();

    /* renamed from: com.tencent.mm.plugin.downloader.model.j$4 */
    class C339254 implements C1628a {
        C339254() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            AppMethodBeat.m2504i(2468);
            String str3 = "MicroMsg.FileWebNetDownloader";
            String str4 = "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
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
                C4990ab.m7417i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.m2505o(2468);
            } else if (i != 0) {
                C4990ab.m7413e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                C33926j.m55526a(C33926j.this, str, 4, i);
                AppMethodBeat.m2505o(2468);
            } else if (c18496c != null) {
                C33926j.m55527a(C33926j.this, str, (long) c18496c.field_finishedLength, (long) c18496c.field_toltalLength);
                AppMethodBeat.m2505o(2468);
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                        C33926j.m55526a(C33926j.this, str, 4, c9545d.field_retCode);
                    } else {
                        C4990ab.m7417i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", str);
                        C33926j.m55526a(C33926j.this, str, 3, 0);
                    }
                }
                AppMethodBeat.m2505o(2468);
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

    static {
        AppMethodBeat.m2504i(2477);
        AppMethodBeat.m2505o(2477);
    }

    public C33926j(C2886b c2886b) {
        super(c2886b);
        AppMethodBeat.m2504i(2469);
        AppMethodBeat.m2505o(2469);
    }

    /* renamed from: a */
    public final long mo23223a(C42911a c42911a) {
        return 0;
    }

    /* renamed from: a */
    public final long mo23224a(C2900e c2900e) {
        AppMethodBeat.m2504i(2470);
        if (c2900e == null || C5046bo.isNullOrNil(c2900e.gUx)) {
            C4990ab.m7412e("MicroMsg.FileWebNetDownloader", "Invalid Request");
            AppMethodBeat.m2505o(2470);
            return -1;
        }
        long j;
        C4990ab.m7417i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", c2900e.gUx);
        String str = c2900e.gUx;
        C42911a Iq = C2895c.m5143Iq(str);
        if (Iq != null) {
            FileDownloadTaskInfo hm = mo23226hm(Iq.field_downloadId);
            C4990ab.m7416i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + hm.status);
            if (hm.status == 1) {
                j = hm.f16167id;
                AppMethodBeat.m2505o(2470);
                return j;
            }
        }
        C2895c.m5141Io(str);
        C2895c.m5142Ip(c2900e.mAppId);
        C42911a c = C33922f.m55522c(c2900e);
        c.field_downloadId = System.currentTimeMillis();
        c.field_downloaderType = 4;
        c.field_filePath = kMy + "/" + C4995ag.m7428ck(str);
        if (Iq != null) {
            str = c.field_filePath;
            String str2 = Iq.field_filePath;
            if (!(str == null || str2 == null || str.equals(str2))) {
                C4990ab.m7417i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", str, str2);
                if (new File(str2).exists()) {
                    C4990ab.m7417i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", Boolean.valueOf(new File(str2).delete()));
                }
            }
        }
        c.field_startTime = System.currentTimeMillis();
        File file = new File(kMy);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    C4990ab.m7413e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", parentFile.getAbsolutePath());
                }
            }
            C4990ab.m7417i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", Boolean.valueOf(file.mkdirs()));
        }
        C42130g c42130g = new C42130g();
        c42130g.egm = c2900e.gUx;
        c42130g.field_mediaId = c2900e.gUx;
        if (c2900e.kNb == 2) {
            c42130g.field_fileType = C42129a.efR;
            c42130g.egn = 20;
            c42130g.ego = 90;
        }
        c42130g.field_fullpath = c.field_filePath;
        c42130g.egl = this.kNz;
        boolean b = C37461f.afx().mo51222b(c42130g, -1);
        C4990ab.m7416i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(b)));
        if (b) {
            c.field_status = 1;
            C2895c.m5145d(c);
            this.kMT.mo7030j(c.field_downloadId, c.field_filePath);
        } else {
            c.field_status = 4;
            c.field_errCode = C11498a.kJQ;
            C2895c.m5145d(c);
            this.kMT.mo7025d(c.field_downloadId, c.field_errCode, false);
        }
        j = c.field_downloadId;
        AppMethodBeat.m2505o(2470);
        return j;
    }

    /* renamed from: hm */
    public final FileDownloadTaskInfo mo23226hm(long j) {
        AppMethodBeat.m2504i(2471);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(hv.field_downloadUrl);
            if (hv.field_status != 1 || (httpMultiSocketDownloadTaskState != null && (httpMultiSocketDownloadTaskState.taskState == 100 || httpMultiSocketDownloadTaskState.taskState == 101))) {
                fileDownloadTaskInfo.status = hv.field_status;
            } else {
                fileDownloadTaskInfo.status = 0;
            }
            fileDownloadTaskInfo.kNr = hv.field_downloadedSize;
            fileDownloadTaskInfo.jrb = hv.field_totalSize;
            fileDownloadTaskInfo.f16167id = j;
            fileDownloadTaskInfo.cBA = hv.field_downloaderType;
            fileDownloadTaskInfo.kNs = hv.field_autoDownload;
            fileDownloadTaskInfo.path = hv.field_filePath;
            fileDownloadTaskInfo.url = hv.field_downloadUrl;
            fileDownloadTaskInfo.cvZ = hv.field_md5;
        }
        AppMethodBeat.m2505o(2471);
        return fileDownloadTaskInfo;
    }

    /* renamed from: hl */
    public final int mo23225hl(final long j) {
        AppMethodBeat.m2504i(2472);
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2465);
                C42911a hv = C2895c.m5147hv(j);
                if (hv == null) {
                    AppMethodBeat.m2505o(2465);
                    return;
                }
                C37461f.afx().mo51228rO(hv.field_downloadUrl);
                if (hv.field_status != 5) {
                    hv.field_status = 5;
                    C2895c.m5146e(hv);
                    C33926j.this.kMT.mo7026hr(j);
                }
                AppMethodBeat.m2505o(2465);
            }
        }).start();
        AppMethodBeat.m2505o(2472);
        return 1;
    }

    /* renamed from: hn */
    public final boolean mo23227hn(final long j) {
        AppMethodBeat.m2504i(2473);
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2466);
                C4990ab.m7410d("MicroMsg.FileWebNetDownloader", JsApiPauseDownloadTask.NAME);
                FileDownloadTaskInfo hm = C33926j.this.mo23226hm(j);
                if (hm != null && hm.status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(hm.url);
                    C42911a hv = C2895c.m5147hv(j);
                    if (hv != null) {
                        hv.field_status = 2;
                        C2895c.m5146e(hv);
                    }
                    C33926j.this.kMT.mo7027hs(j);
                }
                AppMethodBeat.m2505o(2466);
            }
        }).start();
        AppMethodBeat.m2505o(2473);
        return true;
    }

    /* renamed from: ho */
    public final boolean mo23228ho(final long j) {
        AppMethodBeat.m2504i(2474);
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null || hv.field_status != 2) {
            AppMethodBeat.m2505o(2474);
            return false;
        }
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2467);
                int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(hv.field_downloadUrl);
                C4990ab.m7416i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(resumeHttpMultiSocketDownloadTask)));
                hv.field_startTime = System.currentTimeMillis();
                hv.field_startState = C33901b.kKd;
                hv.field_startSize = hv.field_downloadedSize;
                if (resumeHttpMultiSocketDownloadTask == 0) {
                    hv.field_status = 1;
                    hv.field_errCode = 0;
                    C2895c.m5146e(hv);
                    C33926j.this.kMT.mo7031k(j, hv.field_filePath);
                    AppMethodBeat.m2505o(2467);
                    return;
                }
                hv.field_status = 4;
                hv.field_errCode = C11498a.kJR;
                C2895c.m5146e(hv);
                C33926j.this.kMT.mo7025d(j, hv.field_errCode, false);
                AppMethodBeat.m2505o(2467);
            }
        }).start();
        AppMethodBeat.m2505o(2474);
        return true;
    }
}
