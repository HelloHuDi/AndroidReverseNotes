package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApkDownloadManager implements INetworkChangedObserver {
    protected static final long INTERVAL = 180000;
    protected static final String TAG = "ApkDownloadManager";
    protected static ApkDownloadManager mApkDownloadManager = null;
    final Map<String, DownloadInfo> mDownloads = new ConcurrentHashMap();

    public static ApkDownloadManager getInstance() {
        AppMethodBeat.m2504i(75680);
        if (mApkDownloadManager == null) {
            mApkDownloadManager = new ApkDownloadManager();
        }
        ApkDownloadManager apkDownloadManager = mApkDownloadManager;
        AppMethodBeat.m2505o(75680);
        return apkDownloadManager;
    }

    private ApkDownloadManager() {
        AppMethodBeat.m2504i(75681);
        AppMethodBeat.m2505o(75681);
    }

    public void init() {
        AppMethodBeat.m2504i(75682);
        TMLog.m60588i(TAG, "Start to load DownloadInfo list.");
        this.mDownloads.clear();
        ArrayList queryDownloadInfoList = DBManager.getInstance().queryDownloadInfoList();
        if (queryDownloadInfoList != null) {
            TMLog.m60588i(TAG, "The size of downloadinfo_list: " + queryDownloadInfoList.size());
            Iterator it = queryDownloadInfoList.iterator();
            while (it.hasNext()) {
                DownloadInfo downloadInfo = (DownloadInfo) it.next();
                TMLog.m60588i(TAG, "---------------load download info---------------");
                downloadInfo.dump(TAG);
                this.mDownloads.put(downloadInfo.mURL, downloadInfo);
                if (!downloadInfo.hasFinished()) {
                    downloadInfo.updateStatus(3, false);
                }
            }
        }
        TMLog.m60588i(TAG, "Add NetworkChangedObserver to NetworkMonitorReceiver");
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
        AppMethodBeat.m2505o(75682);
    }

    public void uninit() {
        AppMethodBeat.m2504i(75683);
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this);
        ArrayList arrayList = new ArrayList();
        if (!this.mDownloads.isEmpty()) {
            for (Object obj : this.mDownloads.keySet()) {
                DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(obj);
                if (downloadInfo.mStatus == 2) {
                    pauseDownload(downloadInfo.mURL);
                }
                arrayList.add(downloadInfo);
            }
        }
        TMLog.m60588i(TAG, "Start to save DownloadInfo list.");
        DBManager.getInstance().saveDownloadInfoList(arrayList);
        AppMethodBeat.m2505o(75683);
    }

    public int startDownload(String str, String str2, long j, int i, String str3, String str4, Map<String, String> map) {
        AppMethodBeat.m2504i(75684);
        TMLog.m60588i(TAG, "call startDownload, url: " + str + "priority: " + i);
        if (!DownloadHelper.isNetworkConncted()) {
            TMLog.m60588i(TAG, "call startDownload, return errCode: 1");
            AppMethodBeat.m2505o(75684);
            return 1;
        } else if (!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi") && DownloadSetting.getInstance().getIsDownloadWifiOnly()) {
            TMLog.m60588i(TAG, "call startDownload, return errCode: 2");
            AppMethodBeat.m2505o(75684);
            return 2;
        } else if (!DownloadHelper.isValidURL(str)) {
            TMLog.m60588i(TAG, "call startDownload, return errCode: 3");
            AppMethodBeat.m2505o(75684);
            return 3;
        } else if (DownloadHelper.isDownloadFileExisted(str, str3)) {
            TMLog.m60588i(TAG, "call startDownload, return errCode: 4");
            AppMethodBeat.m2505o(75684);
            return 4;
        } else {
            DownloadInfo queryDownloadInfoByUrl;
            boolean isDownloadFileExisted;
            DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(str);
            if (downloadInfo == null) {
                queryDownloadInfoByUrl = DBManager.getInstance().queryDownloadInfoByUrl(str);
                if (queryDownloadInfoByUrl == null) {
                    queryDownloadInfoByUrl = new DownloadInfo(str, str2, j, i, str3);
                    if (queryDownloadInfoByUrl.mContentType.equals("resource/tm.android.unknown")) {
                        queryDownloadInfoByUrl.mFileName = str4;
                    }
                } else {
                    if (queryDownloadInfoByUrl.mContentType.equals("application/tm.android.apkdiff")) {
                        isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(str, queryDownloadInfoByUrl.mContentType);
                    } else {
                        isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(queryDownloadInfoByUrl.mFileName);
                    }
                    if (isDownloadFileExisted) {
                        TMLog.m60588i(TAG, "call startDownload, return errCode: 4");
                        AppMethodBeat.m2505o(75684);
                        return 4;
                    }
                }
                this.mDownloads.put(str, queryDownloadInfoByUrl);
            } else {
                queryDownloadInfoByUrl = downloadInfo;
            }
            queryDownloadInfoByUrl.setHeaderParams((HashMap) map);
            if (queryDownloadInfoByUrl.mContentType.equals("application/tm.android.apkdiff")) {
                isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(str, queryDownloadInfoByUrl.mContentType);
            } else {
                isDownloadFileExisted = DownloadHelper.isDownloadFileExisted(queryDownloadInfoByUrl.mFileName);
            }
            TMLog.m60588i(TAG, "fileExited = ".concat(String.valueOf(isDownloadFileExisted)));
            if (isDownloadFileExisted) {
                AppMethodBeat.m2505o(75684);
                return 4;
            }
            if (queryDownloadInfoByUrl.hasReceivedAllDataBytes() && !isDownloadFileExisted) {
                this.mDownloads.remove(str);
                DBManager.getInstance().deleteDownloadInfo(str);
                queryDownloadInfoByUrl = new DownloadInfo(str, str2, j, i, str3);
                if (queryDownloadInfoByUrl.mContentType.equals("resource/tm.android.unknown")) {
                    queryDownloadInfoByUrl.mFileName = str4;
                }
                queryDownloadInfoByUrl.setHeaderParams((HashMap) map);
                this.mDownloads.put(str, queryDownloadInfoByUrl);
            }
            int startDownloadIfReady = queryDownloadInfoByUrl.startDownloadIfReady();
            TMLog.m60588i(TAG, "call startDownload, return errCode: ".concat(String.valueOf(startDownloadIfReady)));
            AppMethodBeat.m2505o(75684);
            return startDownloadIfReady;
        }
    }

    public void pauseDownload(String str) {
        AppMethodBeat.m2504i(75685);
        TMLog.m60588i(TAG, "call pauseDownload, url: ".concat(String.valueOf(str)));
        DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(str);
        if (downloadInfo != null) {
            downloadInfo.pauseDownload();
        }
        AppMethodBeat.m2505o(75685);
    }

    public void cancelDownload(String str) {
        AppMethodBeat.m2504i(75686);
        TMLog.m60588i(TAG, "call cancelDownload, url: ".concat(String.valueOf(str)));
        DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.remove(str);
        if (downloadInfo != null) {
            downloadInfo.stopDownload();
        }
        AppMethodBeat.m2505o(75686);
    }

    public DownloadInfo queryDownloadInfo(String str) {
        AppMethodBeat.m2504i(75687);
        TMLog.m60588i(TAG, "call queryDownloadInfo, url: ".concat(String.valueOf(str)));
        DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(str);
        if (downloadInfo == null) {
            downloadInfo = DBManager.getInstance().queryDownloadInfoByUrl(str);
        }
        boolean z = false;
        if (downloadInfo != null) {
            if (downloadInfo.mContentType.equals("application/tm.android.apkdiff")) {
                z = DownloadHelper.isDownloadFileExisted(str, downloadInfo.mContentType);
            } else {
                z = DownloadHelper.isDownloadFileExisted(downloadInfo.mFileName);
            }
        }
        if (!(downloadInfo == null || !downloadInfo.hasReceivedAllDataBytes() || z)) {
            this.mDownloads.remove(str);
            DBManager.getInstance().deleteDownloadInfo(str);
            downloadInfo = null;
        }
        AppMethodBeat.m2505o(75687);
        return downloadInfo;
    }

    public Boolean isAllDownloadFinished() {
        Boolean bool;
        AppMethodBeat.m2504i(75688);
        for (Object obj : this.mDownloads.keySet()) {
            if (!((DownloadInfo) this.mDownloads.get(obj)).hasFinished()) {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(75688);
                return bool;
            }
        }
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(75688);
        return bool;
    }

    public void AddDownloadListener(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.m2504i(75689);
        TMLog.m60588i(TAG, "call AddDownloadListener, dl: ".concat(String.valueOf(iDownloadManagerListener)));
        DownloadListenerManager.getInstance().Add(iDownloadManagerListener);
        AppMethodBeat.m2505o(75689);
    }

    public void RemoveDownloadListener(IDownloadManagerListener iDownloadManagerListener) {
        AppMethodBeat.m2504i(75690);
        TMLog.m60588i(TAG, "call RemoveDownloadListener, dl: ".concat(String.valueOf(iDownloadManagerListener)));
        DownloadListenerManager.getInstance().Remove(iDownloadManagerListener);
        AppMethodBeat.m2505o(75690);
    }

    public void onNetworkChanged() {
        AppMethodBeat.m2504i(75691);
        TMLog.m60588i(TAG, "onNetworkChanged");
        if (DownloadHelper.isNetworkConncted() && DownloadSetting.getInstance().isAutoDownload()) {
            String netStatus = DownloadHelper.getNetStatus();
            TMLog.m60588i(TAG, "currentNetType = ".concat(String.valueOf(netStatus)));
            for (Object obj : this.mDownloads.keySet()) {
                DownloadInfo downloadInfo = (DownloadInfo) this.mDownloads.get(obj);
                if (DownloadSetting.getInstance().isAutoDownload(downloadInfo.mNetType, netStatus)) {
                    TMLog.m60588i(TAG, "onNetworkChanged, errCode = " + downloadInfo.mDownloadFailedErrCode);
                    if (downloadInfo.mDownloadFailedErrCode == 601 || downloadInfo.mDownloadFailedErrCode == 602 || downloadInfo.mDownloadFailedErrCode == 605 || downloadInfo.mDownloadFailedErrCode == 603 || downloadInfo.mDownloadFailedErrCode == 606) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TMLog.m60588i(TAG, "onNetworkChanged, currentTime = " + currentTimeMillis + ", DownloadFailedTime = " + downloadInfo.mDownloadFailedTime);
                        if (currentTimeMillis - downloadInfo.mDownloadFailedTime < INTERVAL) {
                            downloadInfo.startDownloadIfReady(true);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(75691);
    }
}
