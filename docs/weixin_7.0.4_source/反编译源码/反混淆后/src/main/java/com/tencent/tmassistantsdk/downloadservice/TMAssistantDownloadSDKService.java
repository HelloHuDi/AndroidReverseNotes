package com.tencent.tmassistantsdk.downloadservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.IServiceDownloadTaskManagerListener;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTaskManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;
import java.util.Map;

public class TMAssistantDownloadSDKService extends Service implements IServiceDownloadTaskManagerListener {
    protected static final String TAG = "TMAssistantDownloadSDKService";
    protected final TMAssistantDownloadSDKServiceImpl downloadSDKServiceImpl = new TMAssistantDownloadSDKServiceImpl();
    protected final HashMap<ITMAssistantDownloadSDKServiceCallback, String> mCallbackHashMap = new HashMap();
    protected final RemoteCallbackList<ITMAssistantDownloadSDKServiceCallback> mCallbacks = new RemoteCallbackList();
    ServiceDownloadTaskManager mServiceDownloadTaskManager = null;

    protected class TMAssistantDownloadSDKServiceImpl extends Stub {
        protected TMAssistantDownloadSDKServiceImpl() {
        }

        public int getServiceVersion() {
            return 1;
        }

        public void setServiceSetingIsTaskAutoResume(boolean z) {
            AppMethodBeat.m2504i(75779);
            DownloadSetting.getInstance().setIsTaskAutoResume(z);
            AppMethodBeat.m2505o(75779);
        }

        public void setServiceSetingIsDownloadWifiOnly(boolean z) {
            AppMethodBeat.m2504i(75780);
            DownloadSetting.getInstance().setIsDownloadWifiOnly(z);
            AppMethodBeat.m2505o(75780);
        }

        public void setServiceSetingMaxTaskNum(int i) {
            AppMethodBeat.m2504i(75781);
            DownloadSetting.getInstance().setMaxTaskNum(i);
            AppMethodBeat.m2505o(75781);
        }

        public boolean isAllDownloadFinished() {
            AppMethodBeat.m2504i(75782);
            boolean booleanValue = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
            AppMethodBeat.m2505o(75782);
            return booleanValue;
        }

        public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
            AppMethodBeat.m2504i(75783);
            TMLog.m60588i(TMAssistantDownloadSDKService.TAG, "getDownloadTaskInfo");
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                TMAssistantDownloadTaskInfo downloadTaskInfo = TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.getDownloadTaskInfo(str, str2);
                AppMethodBeat.m2505o(75783);
                return downloadTaskInfo;
            }
            AppMethodBeat.m2505o(75783);
            return null;
        }

        public int startDownloadTask(String str, String str2, String str3, long j, int i, String str4, String str5, Map map) {
            AppMethodBeat.m2504i(75784);
            TMLog.m60588i(TMAssistantDownloadSDKService.TAG, "startDownloadTask，clientkey:" + str + ",url:" + str2 + ",manager:" + TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager + ",fileName:" + str5);
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                DBManager.getInstance().saveClientInfo(str, str2);
                int startDownload = TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.startDownload(str, str2, str3, j, i, str4, str5, map);
                AppMethodBeat.m2505o(75784);
                return startDownload;
            }
            AppMethodBeat.m2505o(75784);
            return 3;
        }

        public void pauseDownloadTask(String str, String str2) {
            AppMethodBeat.m2504i(75785);
            TMLog.m60588i(TMAssistantDownloadSDKService.TAG, JsApiPauseDownloadTask.NAME);
            try {
                if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                    TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.pauseDownload(str, str2);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TMAssistantDownloadSDKService.TAG, e, "", new Object[0]);
            }
            TMLog.m60588i(TMAssistantDownloadSDKService.TAG, "pauseDownloadTask end");
            AppMethodBeat.m2505o(75785);
        }

        public void cancelDownloadTask(String str, String str2) {
            AppMethodBeat.m2504i(75786);
            if (TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager != null) {
                TMAssistantDownloadSDKService.this.mServiceDownloadTaskManager.cancelDownload(str, str2);
            }
            AppMethodBeat.m2505o(75786);
        }

        public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            AppMethodBeat.m2504i(75787);
            TMLog.m60588i(TMAssistantDownloadSDKService.TAG, "registerDownloadTaskCallback,clientKey:".concat(String.valueOf(str)));
            if (str == null || iTMAssistantDownloadSDKServiceCallback == null) {
                AppMethodBeat.m2505o(75787);
                return;
            }
            TMAssistantDownloadSDKService.this.mCallbacks.register(iTMAssistantDownloadSDKServiceCallback);
            synchronized (this) {
                try {
                    TMAssistantDownloadSDKService.this.mCallbackHashMap.put(iTMAssistantDownloadSDKServiceCallback, str);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(75787);
                }
            }
        }

        public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            AppMethodBeat.m2504i(75788);
            TMLog.m60588i(TMAssistantDownloadSDKService.TAG, "unregisterDownloadTaskCallback,clientKey:".concat(String.valueOf(str)));
            if (str == null || iTMAssistantDownloadSDKServiceCallback == null) {
                AppMethodBeat.m2505o(75788);
                return;
            }
            TMAssistantDownloadSDKService.this.mCallbacks.unregister(iTMAssistantDownloadSDKServiceCallback);
            synchronized (this) {
                try {
                    TMAssistantDownloadSDKService.this.mCallbackHashMap.remove(iTMAssistantDownloadSDKServiceCallback);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(75788);
                }
            }
        }
    }

    public TMAssistantDownloadSDKService() {
        AppMethodBeat.m2504i(75789);
        AppMethodBeat.m2505o(75789);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(75790);
        super.onCreate();
        GlobalUtil.getInstance().setContext(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        this.mServiceDownloadTaskManager = new ServiceDownloadTaskManager(DBManager.getInstance().queryWaitingAndDownloadingTaskList());
        this.mServiceDownloadTaskManager.setListener(this);
        this.mServiceDownloadTaskManager.registerApkDownloadManagerListener();
        ApkDownloadManager.getInstance().init();
        TMLog.m60588i(TAG, "onCreate");
        AppMethodBeat.m2505o(75790);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(75791);
        TMLog.m60588i(TAG, "onBind ,intent:".concat(String.valueOf(intent)));
        TMAssistantDownloadSDKServiceImpl tMAssistantDownloadSDKServiceImpl = this.downloadSDKServiceImpl;
        AppMethodBeat.m2505o(75791);
        return tMAssistantDownloadSDKServiceImpl;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(75792);
        TMLog.m60588i(TAG, "onUnbind ,intent:".concat(String.valueOf(intent)));
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(75792);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(75793);
        TMLog.m60588i(TAG, "onDestroy");
        super.onDestroy();
        ApkDownloadManager.getInstance().uninit();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        this.mServiceDownloadTaskManager.unRegisterApkDownloadManagerListener();
        this.mServiceDownloadTaskManager.setListener(null);
        this.mServiceDownloadTaskManager = null;
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GlobalUtil.getInstance().destroy();
        SystemClock.sleep(300);
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(75793);
    }

    public void OnDownloadStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75794);
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback) this.mCallbacks.getBroadcastItem(i3);
                    String str4 = (String) this.mCallbackHashMap.get(iTMAssistantDownloadSDKServiceCallback);
                    if (str4 != null && str4.equals(str)) {
                        TMLog.m60588i(TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ",url:" + str2);
                        iTMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskStateChanged(str, str2, i, i2, str3, z, z2);
                        break;
                    }
                } catch (RemoteException e) {
                }
            }
            this.mCallbacks.finishBroadcast();
            AppMethodBeat.m2505o(75794);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(75794);
        }
    }

    public void OnDownloadProgressChanged(String str, String str2, long j, long j2) {
        AppMethodBeat.m2504i(75795);
        try {
            int beginBroadcast = this.mCallbacks.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback = (ITMAssistantDownloadSDKServiceCallback) this.mCallbacks.getBroadcastItem(i);
                    String str3 = (String) this.mCallbackHashMap.get(iTMAssistantDownloadSDKServiceCallback);
                    if (str3 != null && str3.equals(str)) {
                        TMLog.m60588i(TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",url:" + str2);
                        iTMAssistantDownloadSDKServiceCallback.OnDownloadSDKServiceTaskProgressChanged(str, str2, j, j2);
                        break;
                    }
                } catch (RemoteException e) {
                }
            }
            this.mCallbacks.finishBroadcast();
            AppMethodBeat.m2505o(75795);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(75795);
        }
    }
}
