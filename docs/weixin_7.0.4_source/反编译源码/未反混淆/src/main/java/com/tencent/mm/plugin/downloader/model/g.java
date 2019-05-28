package com.tencent.mm.plugin.downloader.model;

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
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class g extends h {
    ap gyS = new ap(new a() {
        public final boolean BI() {
            boolean z;
            AppMethodBeat.i(2453);
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    AppMethodBeat.i(2454);
                    try {
                        Iterator it = g.this.kNw.iterator();
                        while (it.hasNext()) {
                            long longValue = ((Long) it.next()).longValue();
                            g gVar = g.this;
                            Long valueOf = Long.valueOf(longValue);
                            ab.d("MicroMsg.FileDownloaderImpl23", "updateDownloadStatus");
                            com.tencent.mm.plugin.downloader.f.a hv = c.hv(valueOf.longValue());
                            if (hv != null) {
                                Query query = new Query();
                                query.setFilterById(new long[]{hv.field_sysDownloadId});
                                try {
                                    Cursor query2 = gVar.kNv.query(query);
                                    if (query2 == null) {
                                        ab.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                                        gVar.kNw.remove(valueOf);
                                        hv.field_status = 4;
                                        c.e(hv);
                                    } else {
                                        if (query2.moveToFirst()) {
                                            int columnIndex = query2.getColumnIndex("status");
                                            int columnIndex2 = query2.getColumnIndex("local_uri");
                                            int columnIndex3 = query2.getColumnIndex("bytes_so_far");
                                            int columnIndex4 = query2.getColumnIndex("total_size");
                                            if (columnIndex != -1) {
                                                try {
                                                    ab.d("MicroMsg.FileDownloaderImpl23", "status = %d", Integer.valueOf(query2.getInt(columnIndex)));
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
                                                            c.e(hv);
                                                            gVar.kMT.ht(valueOf.longValue());
                                                        case 4:
                                                            gVar.kNw.remove(valueOf);
                                                            hv.field_status = 2;
                                                            c.e(hv);
                                                            gVar.kMT.hs(valueOf.longValue());
                                                        case 8:
                                                            gVar.kNw.remove(valueOf);
                                                            if (columnIndex2 != -1) {
                                                                if (bo.isNullOrNil(hv.field_filePath) || !e.ct(hv.field_filePath)) {
                                                                    ab.e("MicroMsg.FileDownloaderImpl23", "path not exists, path = %s", hv.field_filePath);
                                                                    hv.field_status = 4;
                                                                    c.e(hv);
                                                                    continue;
                                                                } else {
                                                                    Intent intent = new Intent();
                                                                    intent.setClass(ah.getContext(), FileDownloadService.class);
                                                                    intent.putExtra(FileDownloadService.EXTRA_ID, hv.field_downloadId);
                                                                    intent.putExtra(FileDownloadService.kNn, 1);
                                                                    d.aH(intent);
                                                                }
                                                            }
                                                            break;
                                                        case 16:
                                                            gVar.kNw.remove(valueOf);
                                                            columnIndex = com.tencent.mm.plugin.downloader.a.a.kKb;
                                                            hv.field_status = 4;
                                                            c.e(hv);
                                                            gVar.kMT.d(valueOf.longValue(), columnIndex, false);
                                                            query2.close();
                                                            break;
                                                    }
                                                } catch (Exception e) {
                                                    gVar.kNw.remove(valueOf);
                                                    hv.field_status = 4;
                                                    c.e(hv);
                                                    ab.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                                                }
                                            }
                                        }
                                        query2.close();
                                    }
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), valueOf);
                                    gVar.kNw.remove(valueOf);
                                    hv.field_status = 4;
                                    c.e(hv);
                                }
                            }
                        }
                        AppMethodBeat.o(2454);
                    } catch (Exception e22) {
                        ab.e("MicroMsg.FileDownloaderImpl23", e22.getMessage());
                        AppMethodBeat.o(2454);
                    }
                }
            });
            g gVar = g.this;
            if (gVar.kNw == null || gVar.kNw.size() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ab.d("MicroMsg.FileDownloaderImpl23", "timer stop");
                AppMethodBeat.o(2453);
            } else {
                g.this.gyS.ae(1000, 1000);
                AppMethodBeat.o(2453);
            }
            return false;
        }
    }, false);
    DownloadManager kNv = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> kNw = new CopyOnWriteArraySet();
    private Context mContext = ah.getContext();

    public g(b bVar) {
        super(bVar);
        AppMethodBeat.i(2455);
        AppMethodBeat.o(2455);
    }

    public final long a(com.tencent.mm.plugin.downloader.f.a aVar) {
        return aVar.field_downloadId;
    }

    public final long a(final e eVar) {
        AppMethodBeat.i(2456);
        if (eVar == null || bo.isNullOrNil(eVar.gUx)) {
            ab.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            AppMethodBeat.o(2456);
            return -1;
        } else if (eVar.kNe) {
            ab.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", eVar.mAppId);
            AppMethodBeat.o(2456);
            return -1;
        } else {
            long j;
            String str = eVar.gUx;
            String str2 = "";
            com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(str);
            if (Iq != null) {
                FileDownloadTaskInfo hB = hB(Iq.field_sysDownloadId);
                if (hB.status == 1) {
                    j = hB.id;
                    AppMethodBeat.o(2456);
                    return j;
                }
                str2 = Iq.field_filePath;
                this.kNv.remove(new long[]{Iq.field_sysDownloadId});
            }
            String absolutePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!bo.isNullOrNil(absolutePath)) {
                b bVar = new b(absolutePath);
                if (!bVar.exists()) {
                    boolean mkdirs = bVar.mkdirs();
                    ab.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", Boolean.valueOf(mkdirs));
                }
            }
            if (!bo.isNullOrNil(str2)) {
                File file = new File(str2);
                if (file.exists()) {
                    boolean delete = file.delete();
                    ab.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", Boolean.valueOf(delete));
                }
            }
            c.Io(str);
            c.Ip(eVar.mAppId);
            final com.tencent.mm.plugin.downloader.f.a c = f.c(eVar);
            c.field_downloadId = System.currentTimeMillis();
            c.field_status = 0;
            c.field_downloaderType = 1;
            c.field_filePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + ag.ck(str);
            c.field_startTime = System.currentTimeMillis();
            c.d(c);
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(2452);
                    if (eVar.kNd) {
                        c.field_md5 = f.Iy(c.field_downloadUrl);
                    }
                    long g = g.this.g(c);
                    if (g > 0) {
                        c.field_sysDownloadId = g;
                        c.field_status = 1;
                        c.e(c);
                        g.this.kMT.j(c.field_downloadId, c.field_filePath);
                        d.bij();
                        if (d.hx(c.field_downloadId)) {
                            d.bij();
                            d.G(c.field_downloadId, g);
                        }
                        g.this.kNw.add(Long.valueOf(c.field_downloadId));
                        if (g.this.gyS.doT()) {
                            g.this.gyS.ae(100, 100);
                        }
                        ab.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(c.field_downloadId), c.field_downloadUrl, c.field_filePath);
                        AppMethodBeat.o(2452);
                        return;
                    }
                    c.field_status = 4;
                    c.e(c);
                    g.this.kMT.d(c.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kKb, false);
                    ab.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
                    AppMethodBeat.o(2452);
                }
            });
            j = c.field_downloadId;
            AppMethodBeat.o(2456);
            return j;
        }
    }

    public final int hl(long j) {
        Exception e;
        AppMethodBeat.i(2457);
        d.bij();
        int remove;
        if (d.hx(j)) {
            d.bij();
            long hy = d.hy(j);
            remove = this.kNv.remove(new long[]{hy});
            AppMethodBeat.o(2457);
            return remove;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            ab.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            AppMethodBeat.o(2457);
            return 0;
        }
        try {
            remove = this.kNv.remove(new long[]{hv.field_sysDownloadId});
            try {
                ab.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", Long.valueOf(j));
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
                e.deleteFile(hv.field_filePath);
                ab.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", hv.field_filePath);
                hv.field_status = 5;
                c.e(hv);
                this.kMT.hr(j);
                this.kNw.remove(Long.valueOf(j));
                AppMethodBeat.o(2457);
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
        }
        e.deleteFile(hv.field_filePath);
        ab.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", hv.field_filePath);
        hv.field_status = 5;
        c.e(hv);
        this.kMT.hr(j);
        this.kNw.remove(Long.valueOf(j));
        AppMethodBeat.o(2457);
        return remove;
    }

    public final FileDownloadTaskInfo hm(long j) {
        AppMethodBeat.i(2458);
        d.bij();
        FileDownloadTaskInfo hB;
        if (d.hx(j)) {
            d.bij();
            hB = hB(d.hy(j));
            hB.id = j;
            hB.cBA = 1;
            AppMethodBeat.o(2458);
            return hB;
        }
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            hB = new FileDownloadTaskInfo();
            AppMethodBeat.o(2458);
            return hB;
        }
        if (hv.field_status == 4 || hv.field_status == 2 || hv.field_status == 5 || hv.field_status == 3) {
            this.kNw.remove(Long.valueOf(j));
        }
        hB = new FileDownloadTaskInfo();
        hB.id = hv.field_downloadId;
        hB.url = hv.field_downloadUrl;
        hB.status = hv.field_status;
        hB.path = hv.field_filePath;
        hB.cvZ = hv.field_md5;
        hB.kNs = hv.field_autoDownload;
        hB.cBA = hv.field_downloaderType;
        hB.kNr = hv.field_downloadedSize;
        hB.jrb = hv.field_totalSize;
        AppMethodBeat.o(2458);
        return hB;
    }

    /* Access modifiers changed, original: final */
    public final long g(com.tencent.mm.plugin.downloader.f.a aVar) {
        AppMethodBeat.i(2459);
        try {
            Request request = new Request(Uri.parse(aVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(aVar.field_showNotification);
            request.setVisibleInDownloadsUi(aVar.field_showNotification);
            if (!bo.isNullOrNil(aVar.field_fileName)) {
                request.setTitle(aVar.field_fileName);
            }
            request.setDestinationUri(e.asY(aVar.field_filePath));
            long enqueue = this.kNv.enqueue(request);
            if (enqueue > 0) {
                AppMethodBeat.o(2459);
                return enqueue;
            }
            ab.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            AppMethodBeat.o(2459);
            return -1;
        } catch (Exception e) {
            ab.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", e.toString(), aVar.field_downloadUrl);
            AppMethodBeat.o(2459);
            return -1;
        }
    }

    private FileDownloadTaskInfo hB(long j) {
        AppMethodBeat.i(2460);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.kNv.query(query);
            if (query2 == null) {
                ab.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                AppMethodBeat.o(2460);
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
                            ab.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (bo.isNullOrNil(string)) {
                            ab.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            ab.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", string);
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            ab.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", fileDownloadTaskInfo.path);
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
                ab.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
                AppMethodBeat.o(2460);
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), Long.valueOf(j));
            AppMethodBeat.o(2460);
        }
        return fileDownloadTaskInfo;
    }

    public final boolean hn(long j) {
        AppMethodBeat.i(2461);
        FileDownloadTaskInfo hm = hm(j);
        if (hm == null) {
            ab.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.o(2461);
            return false;
        }
        this.kNw.remove(Long.valueOf(j));
        if (hm.status != 1) {
            ab.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", Long.valueOf(j));
            AppMethodBeat.o(2461);
            return true;
        }
        ab.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", Long.valueOf(j), Integer.valueOf(hl(j)));
        if (hl(j) > 0) {
            AppMethodBeat.o(2461);
            return true;
        }
        AppMethodBeat.o(2461);
        return false;
    }

    public final boolean ho(long j) {
        AppMethodBeat.i(2462);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            AppMethodBeat.o(2462);
            return false;
        } else if (hv.field_downloaderType != 1) {
            ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", Long.valueOf(j));
            e.deleteFile(hv.field_filePath);
            ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", hv.field_filePath);
            c.hw(j);
            AppMethodBeat.o(2462);
            return false;
        } else if (hv.field_status == 1) {
            ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", Long.valueOf(j));
            AppMethodBeat.o(2462);
            return false;
        } else {
            this.kNv.remove(new long[]{hv.field_sysDownloadId});
            long g = g(hv);
            if (g > 0) {
                this.kNw.add(Long.valueOf(hv.field_downloadId));
                if (this.gyS.doT()) {
                    this.gyS.ae(100, 100);
                }
                hv.field_sysDownloadId = g;
                hv.field_status = 1;
                c.e(hv);
                AppMethodBeat.o(2462);
                return true;
            }
            ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            AppMethodBeat.o(2462);
            return false;
        }
    }
}
