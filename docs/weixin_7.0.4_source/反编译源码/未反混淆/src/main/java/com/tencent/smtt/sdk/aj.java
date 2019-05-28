package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class aj extends Handler {
    aj(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        AppMethodBeat.i(64346);
        switch (message.what) {
            case 100:
                boolean z2 = message.arg1 == 1;
                boolean a = TbsDownloader.a(true, false);
                if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=".concat(String.valueOf(a)));
                    Object obj = "";
                    if (!(TbsDownloader.c == null || TbsDownloader.c.getApplicationContext() == null || TbsDownloader.c.getApplicationContext().getApplicationInfo() == null)) {
                        obj = TbsDownloader.c.getApplicationContext().getApplicationInfo().packageName;
                    }
                    if (!a || z2) {
                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    } else if ("com.tencent.mm".equals(obj) || TbsConfig.APP_QQ.equals(obj)) {
                        TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ".concat(String.valueOf(a)));
                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    }
                }
                if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && a) {
                    TbsDownloader.startDownload(TbsDownloader.c);
                    AppMethodBeat.o(64346);
                    return;
                }
                break;
            case 101:
            case 108:
                FileOutputStream fileOutputStream = null;
                FileLock fileLock = null;
                if (!TbsShareManager.isThirdPartyApp(TbsDownloader.c)) {
                    fileOutputStream = k.b(TbsDownloader.c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                    if (fileOutputStream != null) {
                        fileLock = k.a(TbsDownloader.c, fileOutputStream);
                        if (fileLock == null) {
                            QbSdk.m.onDownloadFinish(ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                            TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                            TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-203);
                            TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                            AppMethodBeat.o(64346);
                            return;
                        }
                    } else if (k.a(TbsDownloader.c)) {
                        TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-204);
                        TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                        AppMethodBeat.o(64346);
                        return;
                    }
                }
                boolean z3 = message.arg1 == 1;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.c);
                if (!TbsDownloader.a(false, z3, 108 == message.what)) {
                    QbSdk.m.onDownloadFinish(110);
                } else if (z3 && an.a().b(TbsDownloader.c, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                    QbSdk.m.onDownloadFinish(122);
                    instance.setDownloadInterruptCode(-213);
                } else if (instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                    TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-215);
                    ag b = TbsDownloader.g;
                    if (108 != message.what) {
                        z = false;
                    }
                    b.b(z3, z);
                } else {
                    QbSdk.m.onDownloadFinish(110);
                }
                TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                k.a(fileLock, fileOutputStream);
                AppMethodBeat.o(64346);
                return;
            case 102:
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                int a2 = TbsShareManager.isThirdPartyApp(TbsDownloader.c) ? TbsShareManager.a(TbsDownloader.c, false) : an.a().n(TbsDownloader.c);
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(a2)));
                TbsDownloader.g.a(a2);
                TbsLogReport.getInstance(TbsDownloader.c).dailyReport();
                AppMethodBeat.o(64346);
                return;
            case 103:
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                if (message.arg1 != 0) {
                    an.a().a((Context) message.obj, false);
                    break;
                }
                an.a().a((Context) message.obj, true);
                AppMethodBeat.o(64346);
                return;
            case 104:
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                TbsLogReport.getInstance(TbsDownloader.c).reportTbsLog();
                AppMethodBeat.o(64346);
                return;
        }
        AppMethodBeat.o(64346);
    }
}
