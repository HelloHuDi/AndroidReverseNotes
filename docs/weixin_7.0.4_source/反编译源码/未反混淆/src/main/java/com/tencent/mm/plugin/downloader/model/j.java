package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;

public final class j extends h {
    private static final String kMy = (b.eSn + "WebNetFile");
    private HashMap<String, Long> kMA = new HashMap();
    private a kNz = new a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(2468);
            String str3 = "MicroMsg.FileWebNetDownloader";
            String str4 = "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
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
                ab.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(2468);
            } else if (i != 0) {
                ab.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                j.a(j.this, str, 4, i);
                AppMethodBeat.o(2468);
            } else if (cVar != null) {
                j.a(j.this, str, (long) cVar.field_finishedLength, (long) cVar.field_toltalLength);
                AppMethodBeat.o(2468);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        j.a(j.this, str, 4, dVar.field_retCode);
                    } else {
                        ab.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", str);
                        j.a(j.this, str, 3, 0);
                    }
                }
                AppMethodBeat.o(2468);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    private Context mContext = ah.getContext();

    static {
        AppMethodBeat.i(2477);
        AppMethodBeat.o(2477);
    }

    public j(b bVar) {
        super(bVar);
        AppMethodBeat.i(2469);
        AppMethodBeat.o(2469);
    }

    public final long a(com.tencent.mm.plugin.downloader.f.a aVar) {
        return 0;
    }

    public final long a(e eVar) {
        AppMethodBeat.i(2470);
        if (eVar == null || bo.isNullOrNil(eVar.gUx)) {
            ab.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
            AppMethodBeat.o(2470);
            return -1;
        }
        long j;
        ab.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", eVar.gUx);
        String str = eVar.gUx;
        com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
        if (Iq != null) {
            FileDownloadTaskInfo hm = hm(Iq.field_downloadId);
            ab.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + hm.status);
            if (hm.status == 1) {
                j = hm.id;
                AppMethodBeat.o(2470);
                return j;
            }
        }
        c.Io(str);
        c.Ip(eVar.mAppId);
        com.tencent.mm.plugin.downloader.f.a c = f.c(eVar);
        c.field_downloadId = System.currentTimeMillis();
        c.field_downloaderType = 4;
        c.field_filePath = kMy + "/" + ag.ck(str);
        if (Iq != null) {
            str = c.field_filePath;
            String str2 = Iq.field_filePath;
            if (!(str == null || str2 == null || str.equals(str2))) {
                ab.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", str, str2);
                if (new File(str2).exists()) {
                    ab.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", Boolean.valueOf(new File(str2).delete()));
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
                    ab.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", parentFile.getAbsolutePath());
                }
            }
            ab.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", Boolean.valueOf(file.mkdirs()));
        }
        g gVar = new g();
        gVar.egm = eVar.gUx;
        gVar.field_mediaId = eVar.gUx;
        if (eVar.kNb == 2) {
            gVar.field_fileType = com.tencent.mm.i.a.efR;
            gVar.egn = 20;
            gVar.ego = 90;
        }
        gVar.field_fullpath = c.field_filePath;
        gVar.egl = this.kNz;
        boolean b = f.afx().b(gVar, -1);
        ab.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(b)));
        if (b) {
            c.field_status = 1;
            c.d(c);
            this.kMT.j(c.field_downloadId, c.field_filePath);
        } else {
            c.field_status = 4;
            c.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJQ;
            c.d(c);
            this.kMT.d(c.field_downloadId, c.field_errCode, false);
        }
        j = c.field_downloadId;
        AppMethodBeat.o(2470);
        return j;
    }

    public final FileDownloadTaskInfo hm(long j) {
        AppMethodBeat.i(2471);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(hv.field_downloadUrl);
            if (hv.field_status != 1 || (httpMultiSocketDownloadTaskState != null && (httpMultiSocketDownloadTaskState.taskState == 100 || httpMultiSocketDownloadTaskState.taskState == 101))) {
                fileDownloadTaskInfo.status = hv.field_status;
            } else {
                fileDownloadTaskInfo.status = 0;
            }
            fileDownloadTaskInfo.kNr = hv.field_downloadedSize;
            fileDownloadTaskInfo.jrb = hv.field_totalSize;
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.cBA = hv.field_downloaderType;
            fileDownloadTaskInfo.kNs = hv.field_autoDownload;
            fileDownloadTaskInfo.path = hv.field_filePath;
            fileDownloadTaskInfo.url = hv.field_downloadUrl;
            fileDownloadTaskInfo.cvZ = hv.field_md5;
        }
        AppMethodBeat.o(2471);
        return fileDownloadTaskInfo;
    }

    public final int hl(final long j) {
        AppMethodBeat.i(2472);
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2465);
                com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
                if (hv == null) {
                    AppMethodBeat.o(2465);
                    return;
                }
                f.afx().rO(hv.field_downloadUrl);
                if (hv.field_status != 5) {
                    hv.field_status = 5;
                    c.e(hv);
                    j.this.kMT.hr(j);
                }
                AppMethodBeat.o(2465);
            }
        }).start();
        AppMethodBeat.o(2472);
        return 1;
    }

    public final boolean hn(final long j) {
        AppMethodBeat.i(2473);
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2466);
                ab.d("MicroMsg.FileWebNetDownloader", JsApiPauseDownloadTask.NAME);
                FileDownloadTaskInfo hm = j.this.hm(j);
                if (hm != null && hm.status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(hm.url);
                    com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
                    if (hv != null) {
                        hv.field_status = 2;
                        c.e(hv);
                    }
                    j.this.kMT.hs(j);
                }
                AppMethodBeat.o(2466);
            }
        }).start();
        AppMethodBeat.o(2473);
        return true;
    }

    public final boolean ho(final long j) {
        AppMethodBeat.i(2474);
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null || hv.field_status != 2) {
            AppMethodBeat.o(2474);
            return false;
        }
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2467);
                int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(hv.field_downloadUrl);
                ab.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(resumeHttpMultiSocketDownloadTask)));
                hv.field_startTime = System.currentTimeMillis();
                hv.field_startState = com.tencent.mm.plugin.downloader.a.b.kKd;
                hv.field_startSize = hv.field_downloadedSize;
                if (resumeHttpMultiSocketDownloadTask == 0) {
                    hv.field_status = 1;
                    hv.field_errCode = 0;
                    c.e(hv);
                    j.this.kMT.k(j, hv.field_filePath);
                    AppMethodBeat.o(2467);
                    return;
                }
                hv.field_status = 4;
                hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJR;
                c.e(hv);
                j.this.kMT.d(j, hv.field_errCode, false);
                AppMethodBeat.o(2467);
            }
        }).start();
        AppMethodBeat.o(2474);
        return true;
    }
}
