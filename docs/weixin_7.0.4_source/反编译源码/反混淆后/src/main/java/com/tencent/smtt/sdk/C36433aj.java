package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.TbsLog;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* renamed from: com.tencent.smtt.sdk.aj */
final class C36433aj extends Handler {
    C36433aj(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        AppMethodBeat.m2504i(64346);
        switch (message.what) {
            case 100:
                boolean z2 = message.arg1 == 1;
                boolean a = TbsDownloader.m37400a(true, false);
                if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                    TbsLog.m80434i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=".concat(String.valueOf(a)));
                    Object obj = "";
                    if (!(TbsDownloader.f4488c == null || TbsDownloader.f4488c.getApplicationContext() == null || TbsDownloader.f4488c.getApplicationContext().getApplicationInfo() == null)) {
                        obj = TbsDownloader.f4488c.getApplicationContext().getApplicationInfo().packageName;
                    }
                    if (!a || z2) {
                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a, TbsDownloadConfig.getInstance(TbsDownloader.f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    } else if ("com.tencent.mm".equals(obj) || TbsConfig.APP_QQ.equals(obj)) {
                        TbsLog.m80434i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ".concat(String.valueOf(a)));
                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a, TbsDownloadConfig.getInstance(TbsDownloader.f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    }
                }
                if (TbsShareManager.isThirdPartyApp(TbsDownloader.f4488c) && a) {
                    TbsDownloader.startDownload(TbsDownloader.f4488c);
                    AppMethodBeat.m2505o(64346);
                    return;
                }
                break;
            case 101:
            case 108:
                FileOutputStream fileOutputStream = null;
                FileLock fileLock = null;
                if (!TbsShareManager.isThirdPartyApp(TbsDownloader.f4488c)) {
                    fileOutputStream = C30950k.m49563b(TbsDownloader.f4488c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                    if (fileOutputStream != null) {
                        fileLock = C30950k.m49548a(TbsDownloader.f4488c, fileOutputStream);
                        if (fileLock == null) {
                            QbSdk.f16251m.onDownloadFinish(ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                            TbsLog.m80434i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                            TbsDownloadConfig.getInstance(TbsDownloader.f4488c).setDownloadInterruptCode(-203);
                            TbsLog.m80434i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                            AppMethodBeat.m2505o(64346);
                            return;
                        }
                    } else if (C30950k.m49553a(TbsDownloader.f4488c)) {
                        TbsDownloadConfig.getInstance(TbsDownloader.f4488c).setDownloadInterruptCode(-204);
                        TbsLog.m80434i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                        AppMethodBeat.m2505o(64346);
                        return;
                    }
                }
                boolean z3 = message.arg1 == 1;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.f4488c);
                if (!TbsDownloader.m37401a(false, z3, 108 == message.what)) {
                    QbSdk.f16251m.onDownloadFinish(110);
                } else if (z3 && C5813an.m8800a().mo12162b(TbsDownloader.f4488c, TbsDownloadConfig.getInstance(TbsDownloader.f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                    QbSdk.f16251m.onDownloadFinish(122);
                    instance.setDownloadInterruptCode(-213);
                } else if (instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                    TbsDownloadConfig.getInstance(TbsDownloader.f4488c).setDownloadInterruptCode(-215);
                    C36431ag b = TbsDownloader.f4492g;
                    if (108 != message.what) {
                        z = false;
                    }
                    b.mo57533b(z3, z);
                } else {
                    QbSdk.f16251m.onDownloadFinish(110);
                }
                TbsLog.m80434i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                C30950k.m49552a(fileLock, fileOutputStream);
                AppMethodBeat.m2505o(64346);
                return;
            case 102:
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                int a2 = TbsShareManager.isThirdPartyApp(TbsDownloader.f4488c) ? TbsShareManager.m49460a(TbsDownloader.f4488c, false) : C5813an.m8800a().mo12179n(TbsDownloader.f4488c);
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(a2)));
                TbsDownloader.f4492g.mo57528a(a2);
                TbsLogReport.getInstance(TbsDownloader.f4488c).dailyReport();
                AppMethodBeat.m2505o(64346);
                return;
            case 103:
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                if (message.arg1 != 0) {
                    C5813an.m8800a().mo12153a((Context) message.obj, false);
                    break;
                }
                C5813an.m8800a().mo12153a((Context) message.obj, true);
                AppMethodBeat.m2505o(64346);
                return;
            case 104:
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                TbsLogReport.getInstance(TbsDownloader.f4488c).reportTbsLog();
                AppMethodBeat.m2505o(64346);
                return;
        }
        AppMethodBeat.m2505o(64346);
    }
}
