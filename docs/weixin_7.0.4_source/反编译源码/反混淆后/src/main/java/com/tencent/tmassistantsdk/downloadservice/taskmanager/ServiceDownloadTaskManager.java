package com.tencent.tmassistantsdk.downloadservice.taskmanager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.ApkDownloadManager;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.IDownloadManagerListener;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ServiceDownloadTaskManager implements IDownloadManagerListener {
    protected static final String TAG = "ServiceDownloadTaskManager";
    protected IServiceDownloadTaskManagerListener mListener = null;
    protected ArrayList<ServiceDownloadTask> mServiceTaskList = new ArrayList();

    public ServiceDownloadTaskManager(ArrayList<ServiceDownloadTask> arrayList) {
        AppMethodBeat.m2504i(75796);
        if (arrayList != null && arrayList.size() > 0) {
            this.mServiceTaskList.addAll(arrayList);
        }
        AppMethodBeat.m2505o(75796);
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
        AppMethodBeat.m2504i(75797);
        DownloadInfo queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(str2);
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        String str3;
        String generateFileNameFromURL;
        String saveFilePath;
        TMAssistantFile tMAssistantFile;
        if (queryDownloadInfo != null) {
            tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(queryDownloadInfo.mURL, TMAssistantFile.getSaveFilePath(queryDownloadInfo.mFileName), queryDownloadInfo.mStatus, queryDownloadInfo.mReceivedBytes, queryDownloadInfo.getTotalSize(), queryDownloadInfo.mContentType);
            AppMethodBeat.m2505o(75797);
            return tMAssistantDownloadTaskInfo;
        } else if (DownloadHelper.isDownloadFileExisted(str2, "application/vnd.android.package-archive")) {
            str3 = "application/vnd.android.package-archive";
            generateFileNameFromURL = DownloadHelper.generateFileNameFromURL(str2, str3);
            saveFilePath = TMAssistantFile.getSaveFilePath(generateFileNameFromURL);
            tMAssistantFile = new TMAssistantFile(generateFileNameFromURL, generateFileNameFromURL);
            tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(str2, saveFilePath, 4, tMAssistantFile.length(), tMAssistantFile.length(), str3);
            AppMethodBeat.m2505o(75797);
            return tMAssistantDownloadTaskInfo;
        } else if (DownloadHelper.isDownloadFileExisted(str2, "application/tm.android.apkdiff")) {
            str3 = "application/tm.android.apkdiff";
            generateFileNameFromURL = DownloadHelper.generateFileNameFromURL(str2, str3);
            saveFilePath = TMAssistantFile.getSaveFilePath(generateFileNameFromURL);
            tMAssistantFile = new TMAssistantFile(generateFileNameFromURL, generateFileNameFromURL);
            tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(str2, saveFilePath, 4, tMAssistantFile.length(), tMAssistantFile.length(), str3);
            AppMethodBeat.m2505o(75797);
            return tMAssistantDownloadTaskInfo;
        } else {
            removeDownloadTask(str2);
            AppMethodBeat.m2505o(75797);
            return null;
        }
    }

    public int startDownload(String str, String str2, String str3, long j, int i, String str4, String str5, Map<String, String> map) {
        AppMethodBeat.m2504i(75798);
        if (str == null || str2 == null) {
            AppMethodBeat.m2505o(75798);
            return 3;
        }
        TMLog.m60588i(TAG, "startDownload,clientKey:".concat(String.valueOf(str)));
        int startDownload;
        if (findDownloadTask(str, str2) != null) {
            TMLog.m60588i(TAG, "startDownload,clientKey:" + str + ",taskItem isn't null");
            startDownload = ApkDownloadManager.getInstance().startDownload(str2, str3, j, i, str4, str5, map);
            AppMethodBeat.m2505o(75798);
            return startDownload;
        }
        ArrayList findDownloadTask = findDownloadTask(str2);
        int i2 = 0;
        ServiceDownloadTask serviceDownloadTask = new ServiceDownloadTask(str, str2);
        serviceDownloadTask.mState = 1;
        this.mServiceTaskList.add(serviceDownloadTask);
        TMLog.m60588i(TAG, "startDownload,clientKey:" + str + ",add newTask");
        Iterator it = findDownloadTask.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ServiceDownloadTask serviceDownloadTask2 = (ServiceDownloadTask) it.next();
            if (serviceDownloadTask2.mState == 2) {
                i3 = 1;
            } else {
                if (serviceDownloadTask2.mState == 1) {
                    startDownload = 1;
                } else {
                    startDownload = i2;
                }
                i2 = startDownload;
            }
        }
        if (i3 == 1 || i2 == 1) {
            if (i3 == 1) {
                serviceDownloadTask.mState = 2;
            } else if (i2 == 1) {
                serviceDownloadTask.mState = 1;
            }
            if (this.mListener != null) {
                this.mListener.OnDownloadStateChanged(str, str2, serviceDownloadTask.mState, 0, null, false, false);
            }
            TMLog.m60588i(TAG, "startDownload,clientKey:" + str + ",newTask is downloading, state = " + serviceDownloadTask.mState);
            AppMethodBeat.m2505o(75798);
            return 0;
        }
        TMLog.m60588i(TAG, "startDownload,clientKey:" + str + ",start newTask download");
        startDownload = ApkDownloadManager.getInstance().startDownload(str2, str3, j, i, str4, str5, map);
        AppMethodBeat.m2505o(75798);
        return startDownload;
    }

    public void pauseDownload(String str, String str2) {
        AppMethodBeat.m2504i(75799);
        if (str == null || str2 == null) {
            AppMethodBeat.m2505o(75799);
            return;
        }
        TMLog.m60588i(TAG, "pauseDownload,clientKey:".concat(String.valueOf(str)));
        ServiceDownloadTask findDownloadTask = findDownloadTask(str, str2);
        if (findDownloadTask != null) {
            findDownloadTask.mState = 3;
            this.mServiceTaskList.remove(findDownloadTask);
            TMLog.m60588i(TAG, "pauseDownload,clientKey:" + str + ",remove taskItem");
            ArrayList findDownloadTask2 = findDownloadTask(str2);
            if (findDownloadTask2 == null || findDownloadTask2.size() == 0) {
                TMLog.m60588i(TAG, "pauseDownload,clientKey:" + str + ",taskItem is the only on pauseAll");
                ApkDownloadManager.getInstance().pauseDownload(str2);
                TMLog.m60588i(TAG, "pauseDownload end,clientKey:" + str + ",taskItem is the only on pauseAll");
            }
            if (this.mListener != null) {
                this.mListener.OnDownloadStateChanged(str, str2, findDownloadTask.mState, 0, null, false, false);
            }
        } else {
            TMLog.m60590w(TAG, "pauseDownload,clientKey:" + str + ",taskItem is null");
        }
        TMLog.m60588i(TAG, "pauseDownload end,clientKey:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(75799);
    }

    public void cancelDownload(String str, String str2) {
        AppMethodBeat.m2504i(75800);
        if (str == null || str2 == null) {
            AppMethodBeat.m2505o(75800);
            return;
        }
        TMLog.m60588i(TAG, "cancelDownload,clientKey:".concat(String.valueOf(str)));
        ServiceDownloadTask findDownloadTask = findDownloadTask(str, str2);
        if (findDownloadTask != null) {
            this.mServiceTaskList.remove(findDownloadTask);
            TMLog.m60588i(TAG, "cancelDownload,clientKey:" + str + ",remove taskItem");
        } else {
            TMLog.m60590w(TAG, "cancelDownload,clientKey:" + str + ",taskItem is null");
        }
        ArrayList findDownloadTask2 = findDownloadTask(str2);
        if (findDownloadTask2 == null || findDownloadTask2.size() == 0) {
            TMLog.m60588i(TAG, "cancelDownload,clientKey:" + str + ",taskItem is the only on cancelAll");
            ApkDownloadManager.getInstance().cancelDownload(str2);
        }
        AppMethodBeat.m2505o(75800);
    }

    public void registerApkDownloadManagerListener() {
        AppMethodBeat.m2504i(75801);
        ApkDownloadManager.getInstance().AddDownloadListener(this);
        AppMethodBeat.m2505o(75801);
    }

    public void unRegisterApkDownloadManagerListener() {
        AppMethodBeat.m2504i(75802);
        ApkDownloadManager.getInstance().RemoveDownloadListener(this);
        AppMethodBeat.m2505o(75802);
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized ServiceDownloadTask findDownloadTask(String str, String str2) {
        ServiceDownloadTask serviceDownloadTask;
        AppMethodBeat.m2504i(75803);
        if (str == null || str2 == null) {
            AppMethodBeat.m2505o(75803);
            serviceDownloadTask = null;
        } else {
            Iterator it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.mClientKey != null && serviceDownloadTask.mClientKey.equals(str) && serviceDownloadTask.mUrl.equals(str2)) {
                    AppMethodBeat.m2505o(75803);
                    break;
                }
            }
            AppMethodBeat.m2505o(75803);
            serviceDownloadTask = null;
        }
        return serviceDownloadTask;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized ArrayList<ServiceDownloadTask> findDownloadTask(String str) {
        ArrayList<ServiceDownloadTask> arrayList;
        AppMethodBeat.m2504i(75804);
        if (str == null) {
            arrayList = null;
            AppMethodBeat.m2505o(75804);
        } else {
            ArrayList<ServiceDownloadTask> arrayList2 = new ArrayList();
            Iterator it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.mUrl.equals(str)) {
                    arrayList2.add(serviceDownloadTask);
                }
            }
            AppMethodBeat.m2505o(75804);
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void removeDownloadTask(String str) {
        AppMethodBeat.m2504i(75805);
        if (str == null) {
            AppMethodBeat.m2505o(75805);
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.mServiceTaskList.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.mUrl.equals(str)) {
                    arrayList.add(serviceDownloadTask);
                }
            }
            if (arrayList.size() > 0) {
                this.mServiceTaskList.removeAll(arrayList);
            }
            AppMethodBeat.m2505o(75805);
        }
    }

    public void setListener(IServiceDownloadTaskManagerListener iServiceDownloadTaskManagerListener) {
        this.mListener = iServiceDownloadTaskManagerListener;
    }

    public void OnDownloadStateChanged(String str, int i, int i2, String str2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75806);
        if (this.mListener == null) {
            AppMethodBeat.m2505o(75806);
            return;
        }
        ArrayList findDownloadTask = findDownloadTask(str);
        if (findDownloadTask != null && findDownloadTask.size() > 0) {
            Iterator it = findDownloadTask.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                TMLog.m60588i(TAG, "OnDownloadStateChanged,clientKey:" + serviceDownloadTask.mClientKey + ",state:" + i + ",errorcode:" + i2 + ",url:" + str.hashCode());
                serviceDownloadTask.mState = i;
                this.mListener.OnDownloadStateChanged(serviceDownloadTask.mClientKey, str, i, i2, str2, z, z2);
            }
        }
        AppMethodBeat.m2505o(75806);
    }

    public void OnDownloadProgressChanged(String str, long j, long j2) {
        AppMethodBeat.m2504i(75807);
        if (this.mListener == null) {
            AppMethodBeat.m2505o(75807);
            return;
        }
        ArrayList findDownloadTask = findDownloadTask(str);
        if (findDownloadTask != null && findDownloadTask.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = findDownloadTask.iterator();
            while (it.hasNext()) {
                ServiceDownloadTask serviceDownloadTask = (ServiceDownloadTask) it.next();
                if (serviceDownloadTask.checkIsNeedUpdateProgress(j, j2, currentTimeMillis)) {
                    TMLog.m60588i(TAG, "OnDownloadProgressChanged,clientKey:" + serviceDownloadTask.mClientKey + ",receivedLen:" + j + ",url:" + str.hashCode());
                    this.mListener.OnDownloadProgressChanged(serviceDownloadTask.mClientKey, str, j, j2);
                }
            }
        }
        AppMethodBeat.m2505o(75807);
    }
}
