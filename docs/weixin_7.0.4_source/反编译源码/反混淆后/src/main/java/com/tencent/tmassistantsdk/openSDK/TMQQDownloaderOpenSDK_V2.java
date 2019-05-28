package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled.IQQDownloaderInstalled;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMQQDownloaderOpenSDK_V2 extends BaseQQDownloaderOpenSDK implements ITMQQDownloaderOpenSDKListener, IQQDownloaderInstalled {
    protected static final String TAG = "QQDownloaderOpenSDK";
    protected static TMQQDownloaderOpenSDK_V2 mInstance = null;
    protected CopyOnWriteArrayList<TMQQDownloaderOpenSDKParam> mTaskList;

    protected TMQQDownloaderOpenSDK_V2() {
        AppMethodBeat.m2504i(75896);
        this.mTaskList = null;
        this.mTaskList = new CopyOnWriteArrayList();
        AppMethodBeat.m2505o(75896);
    }

    public static synchronized TMQQDownloaderOpenSDK_V2 getInstance() {
        TMQQDownloaderOpenSDK_V2 tMQQDownloaderOpenSDK_V2;
        synchronized (TMQQDownloaderOpenSDK_V2.class) {
            AppMethodBeat.m2504i(75897);
            if (mInstance == null) {
                mInstance = new TMQQDownloaderOpenSDK_V2();
            }
            tMQQDownloaderOpenSDK_V2 = mInstance;
            AppMethodBeat.m2505o(75897);
        }
        return tMQQDownloaderOpenSDK_V2;
    }

    public void destroyQQDownloaderOpenSDK() {
        AppMethodBeat.m2504i(75898);
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).unregisterIQQDownloaderOpenSDKListener();
            QQDownloaderInstalled.getInstance().unregisteListener();
            QQDownloaderInstalled.getInstance().unRegisteReceiver(this.mContext);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
        AppMethodBeat.m2505o(75898);
    }

    public void startToDownloadTaskList(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(75899);
        if (context == null) {
            Exception exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75899);
            throw exception;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            AppMethodBeat.m2505o(75899);
        } else {
            String uuid = UUID.randomUUID().toString();
            if (z) {
                DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                createNewChunkLogInfo.UUID = uuid;
                createNewChunkLogInfo.requestUrl = "";
                createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
                DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            }
            if (tMQQDownloaderOpenSDKParam != null) {
                int i2;
                String formatOplist = super.formatOplist(z, z2);
                if (1 == i) {
                    i2 = 2;
                } else {
                    i2 = 5;
                }
                addToTaskList(tMQQDownloaderOpenSDKParam);
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, i2, formatOplist, tMQQDownloaderOpenSDKParam.actionFlag, null);
            }
            AppMethodBeat.m2505o(75899);
        }
    }

    public void startToAppDetail(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(75900);
        if (context == null) {
            Exception exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75900);
            throw exception;
        }
        String uuid = UUID.randomUUID().toString();
        if (z) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        if (tMQQDownloaderOpenSDKParam != null) {
            String formatOplist = super.formatOplist(z, z2);
            if (1 != i) {
                i2 = 4;
            }
            addToTaskList(tMQQDownloaderOpenSDKParam);
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam, i2, formatOplist, tMQQDownloaderOpenSDKParam.actionFlag, null);
        }
        AppMethodBeat.m2505o(75900);
    }

    public void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.m2504i(75901);
        Exception exception;
        if (context == null) {
            exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75901);
            throw exception;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            exception = new Exception("QQDownloaderParam param cann't be null!");
            AppMethodBeat.m2505o(75901);
            throw exception;
        } else {
            String uuid = UUID.randomUUID().toString();
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            if (tMQQDownloaderOpenSDKParam != null) {
                addToTaskList(tMQQDownloaderOpenSDKParam);
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = tMQQDownloaderOpenSDKParam;
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleDownloadTask(tMQQDownloaderOpenSDKParam2, 3, super.formatOplist(true, true), tMQQDownloaderOpenSDKParam.actionFlag, str);
            }
            AppMethodBeat.m2505o(75901);
        }
    }

    public void startToAuthorized(Context context, String str) {
        AppMethodBeat.m2504i(75902);
        String formatEncryptUrl = super.formatEncryptUrl(str);
        if (!(TextUtils.isEmpty(str) || this.mContext == null)) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(formatEncryptUrl);
        }
        AppMethodBeat.m2505o(75902);
    }

    public void startToWebView(Context context, String str) {
        AppMethodBeat.m2504i(75903);
        Exception exception;
        if (context == null) {
            exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75903);
            throw exception;
        } else if (TextUtils.isEmpty(str)) {
            exception = new Exception("param url shouldn't be null!");
            AppMethodBeat.m2505o(75903);
            throw exception;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            String formatIntentUriPath = super.formatIntentUriPath(5, hashMap);
            TMLog.m60588i(TAG, "startToWebView finalPath:".concat(String.valueOf(formatIntentUriPath)));
            if (!(TextUtils.isEmpty(str) || this.mContext == null)) {
                TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleUriAction(formatIntentUriPath);
            }
            AppMethodBeat.m2505o(75903);
        }
    }

    public int startToBatchUpdateOperation(Context context, ArrayList<TMQQDownloaderOpenSDKParam> arrayList, boolean z, int i, String str, String str2, String str3) {
        boolean z2 = true;
        AppMethodBeat.m2504i(75904);
        if (context == null) {
            Exception exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75904);
            throw exception;
        }
        int qQDownloadApiLevel = BaseQQDownloaderOpenSDK.getQQDownloadApiLevel(context);
        if (qQDownloadApiLevel <= 0) {
            AppMethodBeat.m2505o(75904);
            return 1;
        } else if (qQDownloadApiLevel < 4) {
            AppMethodBeat.m2505o(75904);
            return 2;
        } else {
            if (!(arrayList == null || arrayList.size() == 0)) {
                z2 = false;
            }
            qQDownloadApiLevel = getBatchRequestType(z2, i);
            if (!TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).handleBatchRequestAction(qQDownloadApiLevel, arrayList, str, str2, str3)) {
                TMLog.m60590w(TAG, "handleBatchRequestAction return false with batchRequestType=".concat(String.valueOf(qQDownloadApiLevel)));
            }
            AppMethodBeat.m2505o(75904);
            return 0;
        }
    }

    private int getBatchRequestType(boolean z, int i) {
        if (z) {
            switch (i) {
                case 1:
                    return 1;
                case 2:
                    return 6;
                case 3:
                    return 5;
                default:
                    return 2;
            }
        }
        switch (i) {
            case 0:
            case 1:
                return 4;
            case 2:
                return 8;
            case 3:
                return 7;
            default:
                return 2;
        }
    }

    public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskState(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, String str, String str2, String str3) {
        AppMethodBeat.m2504i(75905);
        Exception exception;
        if (this.mContext == null) {
            exception = new Exception("mContext shouldn't be null !");
            AppMethodBeat.m2505o(75905);
            throw exception;
        } else if (arrayList == null || arrayList.size() <= 0) {
            exception = new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
            AppMethodBeat.m2505o(75905);
            throw exception;
        } else {
            int qQDownloadApiLevel = BaseQQDownloaderOpenSDK.getQQDownloadApiLevel(this.mContext);
            ArrayList<TMAssistantDownloadTaskInfo> arrayList2;
            if (qQDownloadApiLevel <= 1) {
                AppMethodBeat.m2505o(75905);
                return null;
            } else if (qQDownloadApiLevel < 4) {
                TMAssistantDownloadTaskInfo downloadTask = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask((TMQQDownloaderOpenSDKParam) arrayList.get(0));
                if (downloadTask != null) {
                    arrayList2 = new ArrayList();
                    arrayList2.add(downloadTask);
                    AppMethodBeat.m2505o(75905);
                    return arrayList2;
                }
                AppMethodBeat.m2505o(75905);
                return null;
            } else {
                arrayList2 = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getBatchTaskInfos(arrayList, str, str2, str3);
                AppMethodBeat.m2505o(75905);
                return arrayList2;
            }
        }
    }

    public long addBatchUpdateOperationToDB(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, boolean z, int i, String str, String str2, String str3) {
        long buildAddDBData;
        AppMethodBeat.m2504i(75906);
        boolean z2 = arrayList == null || arrayList.size() == 0;
        int batchRequestType = getBatchRequestType(z2, i);
        if (!(batchRequestType == 3 || z2)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam) it.next();
                if (tMQQDownloaderOpenSDKParam != null) {
                    addToTaskList(tMQQDownloaderOpenSDKParam);
                }
            }
        }
        BatchDownloadActionRequest buildBatchActionRequest = TMQQDownloaderOpenSDKDataProcessor.buildBatchActionRequest(batchRequestType, arrayList, str, str2, str3);
        if (buildBatchActionRequest != null) {
            byte[] buildSendData = TMQQDownloaderOpenSDKDataProcessor.buildSendData(buildBatchActionRequest);
            if (buildSendData != null) {
                buildAddDBData = buildAddDBData(buildSendData);
                AppMethodBeat.m2505o(75906);
                return buildAddDBData;
            }
        }
        buildAddDBData = -1;
        AppMethodBeat.m2505o(75906);
        return buildAddDBData;
    }

    public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.m2504i(75907);
        Exception exception;
        if (this.mContext == null) {
            exception = new Exception("Context shouldn't be null !");
            AppMethodBeat.m2505o(75907);
            throw exception;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            exception = new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
            AppMethodBeat.m2505o(75907);
            throw exception;
        } else {
            TMAssistantDownloadTaskInfo downloadTask = TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).getDownloadTask(tMQQDownloaderOpenSDKParam);
            AppMethodBeat.m2505o(75907);
            return downloadTask;
        }
    }

    private void onProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
        AppMethodBeat.m2504i(75908);
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.m60588i(TAG, "onDownloadStateChanged listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnDownloadTaskProgressChanged(tMQQDownloaderOpenSDKParam, j, j2);
            }
        }
        AppMethodBeat.m2505o(75908);
    }

    private synchronized void addToTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.m2504i(75909);
        if (!(tMQQDownloaderOpenSDKParam == null || this.mTaskList == null)) {
            Object obj;
            Iterator it = this.mTaskList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = (TMQQDownloaderOpenSDKParam) it.next();
                if (tMQQDownloaderOpenSDKParam2.taskAppId == null) {
                    if (tMQQDownloaderOpenSDKParam2.taskPackageName != null && tMQQDownloaderOpenSDKParam2.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName)) {
                        int obj2 = 1;
                        break;
                    }
                } else if (tMQQDownloaderOpenSDKParam2.taskAppId.equals(tMQQDownloaderOpenSDKParam.taskAppId) && (tMQQDownloaderOpenSDKParam2.taskPackageName == null || tMQQDownloaderOpenSDKParam2.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName))) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                this.mTaskList.add(tMQQDownloaderOpenSDKParam);
            }
        }
        AppMethodBeat.m2505o(75909);
    }

    public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        AppMethodBeat.m2504i(75910);
        if (tMQQDownloaderOpenSDKParam != null) {
            onStateChanged(tMQQDownloaderOpenSDKParam, i, i2, str);
        }
        AppMethodBeat.m2505o(75910);
    }

    public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
        AppMethodBeat.m2504i(75911);
        if (tMQQDownloaderOpenSDKParam != null) {
            onProgressChanged(tMQQDownloaderOpenSDKParam, j, j2);
        }
        AppMethodBeat.m2505o(75911);
    }

    public void OnQQDownloaderInvalid() {
        AppMethodBeat.m2504i(75912);
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.m60588i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnQQDownloaderInvalid();
            }
        }
        AppMethodBeat.m2505o(75912);
    }

    public synchronized void onQQDownloaderInstalled(Context context) {
        AppMethodBeat.m2504i(75913);
        TMLog.m60588i(TAG, "received qqdownload install broadcase!");
        if (this.mTaskList != null) {
            Iterator it = this.mTaskList.iterator();
            while (it.hasNext()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = (TMQQDownloaderOpenSDKParam) it.next();
                if (tMQQDownloaderOpenSDKParam != null) {
                    try {
                        getDownloadTaskState(tMQQDownloaderOpenSDKParam);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    }
                    this.mTaskList.remove(tMQQDownloaderOpenSDKParam);
                }
            }
        }
        AppMethodBeat.m2505o(75913);
    }

    public void OnServiceFree() {
        AppMethodBeat.m2504i(75914);
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener = (ITMQQDownloaderOpenSDKListener) ((WeakReference) it.next()).get();
            if (iTMQQDownloaderOpenSDKListener == null) {
                TMLog.m60588i(TAG, "OnQQDownloaderInvalid listener = null");
            } else {
                iTMQQDownloaderOpenSDKListener.OnServiceFree();
            }
        }
        AppMethodBeat.m2505o(75914);
    }

    public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75915);
        addToTaskList(tMQQDownloaderOpenSDKParam);
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 2);
        AppMethodBeat.m2505o(75915);
        return buildAddDBData;
    }

    public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.m2504i(75916);
        addToTaskList(tMQQDownloaderOpenSDKParam);
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, true, true, tMQQDownloaderOpenSDKParam.actionFlag, str, 3);
        AppMethodBeat.m2505o(75916);
        return buildAddDBData;
    }

    public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75917);
        addToTaskList(tMQQDownloaderOpenSDKParam);
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 1);
        AppMethodBeat.m2505o(75917);
        return buildAddDBData;
    }

    public void initQQDownloaderOpenSDK(Context context) {
        AppMethodBeat.m2504i(75918);
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 2;
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).registerIQQDownloaderOpenSDKListener(this);
            QQDownloaderInstalled.getInstance().registeReceiver(this.mContext);
            QQDownloaderInstalled.getInstance().registeListener(this);
        }
        NetworkMonitorReceiver.getInstance().registerReceiver();
        GetSettingEngine.getInstance().sendRequest();
        LogReportManager.getInstance().reportLog();
        AppMethodBeat.m2505o(75918);
    }

    public static String about() {
        return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
    }

    public void releaseIPCConnected() {
        AppMethodBeat.m2504i(75919);
        if (this.mContext != null) {
            TMQQDownloaderOpenSDKDataProcessor.getInstance(this.mContext).releaseIPCClient();
        }
        AppMethodBeat.m2505o(75919);
    }
}
