package com.tencent.p177mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.tencent.mm.plugin.downloader.model.g */
final class C38849g extends C45831h {
    C7564ap gyS = new C7564ap(new C388502(), false);
    DownloadManager kNv = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> kNw = new CopyOnWriteArraySet();
    private Context mContext = C4996ah.getContext();

    /* renamed from: com.tencent.mm.plugin.downloader.model.g$3 */
    class C277113 implements Runnable {
        C277113() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(2454);
            try {
                Iterator it = C38849g.this.kNw.iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    C38849g c38849g = C38849g.this;
                    Long valueOf = Long.valueOf(longValue);
                    C4990ab.m7410d("MicroMsg.FileDownloaderImpl23", "updateDownloadStatus");
                    C42911a hv = C2895c.m5147hv(valueOf.longValue());
                    if (hv != null) {
                        Query query = new Query();
                        query.setFilterById(new long[]{hv.field_sysDownloadId});
                        try {
                            Cursor query2 = c38849g.kNv.query(query);
                            if (query2 == null) {
                                C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                                c38849g.kNw.remove(valueOf);
                                hv.field_status = 4;
                                C2895c.m5146e(hv);
                            } else {
                                if (query2.moveToFirst()) {
                                    int columnIndex = query2.getColumnIndex("status");
                                    int columnIndex2 = query2.getColumnIndex("local_uri");
                                    int columnIndex3 = query2.getColumnIndex("bytes_so_far");
                                    int columnIndex4 = query2.getColumnIndex("total_size");
                                    if (columnIndex != -1) {
                                        try {
                                            C4990ab.m7411d("MicroMsg.FileDownloaderImpl23", "status = %d", Integer.valueOf(query2.getInt(columnIndex)));
                                            switch (query2.getInt(columnIndex)) {
                                                case 1:
                                                case 2:
                                                    if (columnIndex3 != -1) {
                                                        hv.field_downloadedSize = query2.getLong(columnIndex3);
                                                    }
                                                    if (columnIndex4 != -1) {
                                                        hv.field_totalSize = query2.getLong(columnIndex4);
                                                    }
                                                    hv.field_status = 1;
                                                    C2895c.m5146e(hv);
                                                    c38849g.kMT.mo7028ht(valueOf.longValue());
                                                case 4:
                                                    c38849g.kNw.remove(valueOf);
                                                    hv.field_status = 2;
                                                    C2895c.m5146e(hv);
                                                    c38849g.kMT.mo7027hs(valueOf.longValue());
                                                case 8:
                                                    c38849g.kNw.remove(valueOf);
                                                    if (columnIndex2 != -1) {
                                                        if (C5046bo.isNullOrNil(hv.field_filePath) || !C5730e.m8628ct(hv.field_filePath)) {
                                                            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "path not exists, path = %s", hv.field_filePath);
                                                            hv.field_status = 4;
                                                            C2895c.m5146e(hv);
                                                            continue;
                                                        } else {
                                                            Intent intent = new Intent();
                                                            intent.setClass(C4996ah.getContext(), FileDownloadService.class);
                                                            intent.putExtra(FileDownloadService.EXTRA_ID, hv.field_downloadId);
                                                            intent.putExtra(FileDownloadService.kNn, 1);
                                                            C25985d.m41463aH(intent);
                                                        }
                                                    }
                                                    break;
                                                case 16:
                                                    c38849g.kNw.remove(valueOf);
                                                    columnIndex = C11498a.kKb;
                                                    hv.field_status = 4;
                                                    C2895c.m5146e(hv);
                                                    c38849g.kMT.mo7025d(valueOf.longValue(), columnIndex, false);
                                                    query2.close();
                                                    break;
                                            }
                                        } catch (Exception e) {
                                            c38849g.kNw.remove(valueOf);
                                            hv.field_status = 4;
                                            C2895c.m5146e(hv);
                                            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                                        }
                                    }
                                }
                                query2.close();
                            }
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), valueOf);
                            c38849g.kNw.remove(valueOf);
                            hv.field_status = 4;
                            C2895c.m5146e(hv);
                        }
                    }
                }
                AppMethodBeat.m2505o(2454);
            } catch (Exception e22) {
                C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", e22.getMessage());
                AppMethodBeat.m2505o(2454);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.model.g$2 */
    class C388502 implements C5015a {
        C388502() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            boolean z;
            AppMethodBeat.m2504i(2453);
            C1720g.m3539RS().mo10302aa(new C277113());
            C38849g c38849g = C38849g.this;
            if (c38849g.kNw == null || c38849g.kNw.size() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                C4990ab.m7410d("MicroMsg.FileDownloaderImpl23", "timer stop");
                AppMethodBeat.m2505o(2453);
            } else {
                C38849g.this.gyS.mo16770ae(1000, 1000);
                AppMethodBeat.m2505o(2453);
            }
            return false;
        }
    }

    public C38849g(C2886b c2886b) {
        super(c2886b);
        AppMethodBeat.m2504i(2455);
        AppMethodBeat.m2505o(2455);
    }

    /* renamed from: a */
    public final long mo23223a(C42911a c42911a) {
        return c42911a.field_downloadId;
    }

    /* renamed from: a */
    public final long mo23224a(final C2900e c2900e) {
        AppMethodBeat.m2504i(2456);
        if (c2900e == null || C5046bo.isNullOrNil(c2900e.gUx)) {
            C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            AppMethodBeat.m2505o(2456);
            return -1;
        } else if (c2900e.kNe) {
            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", c2900e.mAppId);
            AppMethodBeat.m2505o(2456);
            return -1;
        } else {
            long j;
            String str = c2900e.gUx;
            String str2 = "";
            C42911a Iq = C2895c.m5143Iq(str);
            if (Iq != null) {
                FileDownloadTaskInfo hB = m65902hB(Iq.field_sysDownloadId);
                if (hB.status == 1) {
                    j = hB.f16167id;
                    AppMethodBeat.m2505o(2456);
                    return j;
                }
                str2 = Iq.field_filePath;
                this.kNv.remove(new long[]{Iq.field_sysDownloadId});
            }
            String absolutePath = C1448h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!C5046bo.isNullOrNil(absolutePath)) {
                C5728b c5728b = new C5728b(absolutePath);
                if (!c5728b.exists()) {
                    boolean mkdirs = c5728b.mkdirs();
                    C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", Boolean.valueOf(mkdirs));
                }
            }
            if (!C5046bo.isNullOrNil(str2)) {
                File file = new File(str2);
                if (file.exists()) {
                    boolean delete = file.delete();
                    C4990ab.m7417i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", Boolean.valueOf(delete));
                }
            }
            C2895c.m5141Io(str);
            C2895c.m5142Ip(c2900e.mAppId);
            final C42911a c = C33922f.m55522c(c2900e);
            c.field_downloadId = System.currentTimeMillis();
            c.field_status = 0;
            c.field_downloaderType = 1;
            c.field_filePath = C1448h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + C4995ag.m7428ck(str);
            c.field_startTime = System.currentTimeMillis();
            C2895c.m5145d(c);
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(2452);
                    if (c2900e.kNd) {
                        c.field_md5 = C33922f.m55521Iy(c.field_downloadUrl);
                    }
                    long g = C38849g.this.mo61722g(c);
                    if (g > 0) {
                        c.field_sysDownloadId = g;
                        c.field_status = 1;
                        C2895c.m5146e(c);
                        C38849g.this.kMT.mo7030j(c.field_downloadId, c.field_filePath);
                        C2896d.bij();
                        if (C2896d.m5157hx(c.field_downloadId)) {
                            C2896d.bij();
                            C2896d.m5149G(c.field_downloadId, g);
                        }
                        C38849g.this.kNw.add(Long.valueOf(c.field_downloadId));
                        if (C38849g.this.gyS.doT()) {
                            C38849g.this.gyS.mo16770ae(100, 100);
                        }
                        C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(c.field_downloadId), c.field_downloadUrl, c.field_filePath);
                        AppMethodBeat.m2505o(2452);
                        return;
                    }
                    c.field_status = 4;
                    C2895c.m5146e(c);
                    C38849g.this.kMT.mo7025d(c.field_downloadId, C11498a.kKb, false);
                    C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
                    AppMethodBeat.m2505o(2452);
                }
            });
            j = c.field_downloadId;
            AppMethodBeat.m2505o(2456);
            return j;
        }
    }

    /* renamed from: hl */
    public final int mo23225hl(long j) {
        Exception e;
        AppMethodBeat.m2504i(2457);
        C2896d.bij();
        int remove;
        if (C2896d.m5157hx(j)) {
            C2896d.bij();
            long hy = C2896d.m5158hy(j);
            remove = this.kNv.remove(new long[]{hy});
            AppMethodBeat.m2505o(2457);
            return remove;
        }
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            AppMethodBeat.m2505o(2457);
            return 0;
        }
        try {
            remove = this.kNv.remove(new long[]{hv.field_sysDownloadId});
            try {
                C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", Long.valueOf(j));
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
                C5730e.deleteFile(hv.field_filePath);
                C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", hv.field_filePath);
                hv.field_status = 5;
                C2895c.m5146e(hv);
                this.kMT.mo7026hr(j);
                this.kNw.remove(Long.valueOf(j));
                AppMethodBeat.m2505o(2457);
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
        }
        C5730e.deleteFile(hv.field_filePath);
        C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", hv.field_filePath);
        hv.field_status = 5;
        C2895c.m5146e(hv);
        this.kMT.mo7026hr(j);
        this.kNw.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(2457);
        return remove;
    }

    /* renamed from: hm */
    public final FileDownloadTaskInfo mo23226hm(long j) {
        AppMethodBeat.m2504i(2458);
        C2896d.bij();
        FileDownloadTaskInfo hB;
        if (C2896d.m5157hx(j)) {
            C2896d.bij();
            hB = m65902hB(C2896d.m5158hy(j));
            hB.f16167id = j;
            hB.cBA = 1;
            AppMethodBeat.m2505o(2458);
            return hB;
        }
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            hB = new FileDownloadTaskInfo();
            AppMethodBeat.m2505o(2458);
            return hB;
        }
        if (hv.field_status == 4 || hv.field_status == 2 || hv.field_status == 5 || hv.field_status == 3) {
            this.kNw.remove(Long.valueOf(j));
        }
        hB = new FileDownloadTaskInfo();
        hB.f16167id = hv.field_downloadId;
        hB.url = hv.field_downloadUrl;
        hB.status = hv.field_status;
        hB.path = hv.field_filePath;
        hB.cvZ = hv.field_md5;
        hB.kNs = hv.field_autoDownload;
        hB.cBA = hv.field_downloaderType;
        hB.kNr = hv.field_downloadedSize;
        hB.jrb = hv.field_totalSize;
        AppMethodBeat.m2505o(2458);
        return hB;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final long mo61722g(C42911a c42911a) {
        AppMethodBeat.m2504i(2459);
        try {
            Request request = new Request(Uri.parse(c42911a.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(c42911a.field_showNotification);
            request.setVisibleInDownloadsUi(c42911a.field_showNotification);
            if (!C5046bo.isNullOrNil(c42911a.field_fileName)) {
                request.setTitle(c42911a.field_fileName);
            }
            request.setDestinationUri(C5730e.asY(c42911a.field_filePath));
            long enqueue = this.kNv.enqueue(request);
            if (enqueue > 0) {
                AppMethodBeat.m2505o(2459);
                return enqueue;
            }
            C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            AppMethodBeat.m2505o(2459);
            return -1;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", e.toString(), c42911a.field_downloadUrl);
            AppMethodBeat.m2505o(2459);
            return -1;
        }
    }

    /* renamed from: hB */
    private FileDownloadTaskInfo m65902hB(long j) {
        AppMethodBeat.m2504i(2460);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.kNv.query(query);
            if (query2 == null) {
                C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                AppMethodBeat.m2505o(2460);
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex("status");
                    int columnIndex2 = query2.getColumnIndex(ShareConstants.MEDIA_URI);
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 8:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 16:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (C5046bo.isNullOrNil(string)) {
                            C4990ab.m7412e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", string);
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", fileDownloadTaskInfo.path);
                        }
                    }
                    if (columnIndex4 != -1) {
                        fileDownloadTaskInfo.kNr = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fileDownloadTaskInfo.jrb = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
                AppMethodBeat.m2505o(2460);
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), Long.valueOf(j));
            AppMethodBeat.m2505o(2460);
        }
        return fileDownloadTaskInfo;
    }

    /* renamed from: hn */
    public final boolean mo23227hn(long j) {
        AppMethodBeat.m2504i(2461);
        FileDownloadTaskInfo hm = mo23226hm(j);
        if (hm == null) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.m2505o(2461);
            return false;
        }
        this.kNw.remove(Long.valueOf(j));
        if (hm.status != 1) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", Long.valueOf(j));
            AppMethodBeat.m2505o(2461);
            return true;
        }
        C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", Long.valueOf(j), Integer.valueOf(mo23225hl(j)));
        if (mo23225hl(j) > 0) {
            AppMethodBeat.m2505o(2461);
            return true;
        }
        AppMethodBeat.m2505o(2461);
        return false;
    }

    /* renamed from: ho */
    public final boolean mo23228ho(long j) {
        AppMethodBeat.m2504i(2462);
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.m2505o(2462);
            return false;
        } else if (hv.field_downloaderType != 1) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", Long.valueOf(j));
            C5730e.deleteFile(hv.field_filePath);
            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", hv.field_filePath);
            C2895c.m5148hw(j);
            AppMethodBeat.m2505o(2462);
            return false;
        } else if (hv.field_status == 1) {
            C4990ab.m7417i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", Long.valueOf(j));
            AppMethodBeat.m2505o(2462);
            return false;
        } else {
            this.kNv.remove(new long[]{hv.field_sysDownloadId});
            long g = mo61722g(hv);
            if (g > 0) {
                this.kNw.add(Long.valueOf(hv.field_downloadId));
                if (this.gyS.doT()) {
                    this.gyS.mo16770ae(100, 100);
                }
                hv.field_sysDownloadId = g;
                hv.field_status = 1;
                C2895c.m5146e(hv);
                AppMethodBeat.m2505o(2462);
                return true;
            }
            C4990ab.m7416i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            AppMethodBeat.m2505o(2462);
            return false;
        }
    }
}
