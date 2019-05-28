package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.logreport.GetSettingEngine;
import com.tencent.tmassistantsdk.logreport.LogReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TMQQDownloaderOpenSDK extends BaseQQDownloaderOpenSDK implements IDownloadStateChangedListener {
    public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
    public static final Uri CONTENT_URI = DownloadInfos.CONTENT_URI;
    protected static final String TAG = "QQDownloaderOpenSDK";
    protected static TMQQDownloaderOpenSDK mInstance = null;
    Map<String, TMQQDownloaderOpenSDKParam> mDownloadParams;
    protected int sdkAPILevel;

    private TMQQDownloaderOpenSDK() {
        AppMethodBeat.m2504i(75856);
        this.sdkAPILevel = 1;
        this.mDownloadParams = null;
        this.mDownloadParams = new ConcurrentHashMap();
        AppMethodBeat.m2505o(75856);
    }

    public static synchronized TMQQDownloaderOpenSDK getInstance() {
        TMQQDownloaderOpenSDK tMQQDownloaderOpenSDK;
        synchronized (TMQQDownloaderOpenSDK.class) {
            AppMethodBeat.m2504i(75857);
            if (mInstance == null) {
                mInstance = new TMQQDownloaderOpenSDK();
            }
            tMQQDownloaderOpenSDK = mInstance;
            AppMethodBeat.m2505o(75857);
        }
        return tMQQDownloaderOpenSDK;
    }

    public void destroyQQDownloaderOpenSDK() {
        AppMethodBeat.m2504i(75858);
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GetSettingEngine.getInstance().cancleRequest();
        LogReportManager.getInstance().cancleReport();
        LogReportManager.getInstance().destory();
        if (this.mContext != null) {
            DownloadStateChangedReceiver.getInstance().unRegisteReceiver(this.mContext);
            DownloadStateChangedReceiver.getInstance().removeDownloadStateChangedListener(this);
        }
        GlobalUtil.getInstance().destroy();
        this.mContext = null;
        AppMethodBeat.m2505o(75858);
    }

    public static boolean isExistActoin(long j) {
        AppMethodBeat.m2504i(75859);
        if (j < 0) {
            AppMethodBeat.m2505o(75859);
            return false;
        }
        ArrayList channelDataItemList = new TMAssistantSDKChannel().getChannelDataItemList();
        if (channelDataItemList != null && channelDataItemList.size() > 0) {
            Iterator it = channelDataItemList.iterator();
            while (it.hasNext()) {
                TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem) it.next();
                if (((long) tMAssistantSDKChannelDataItem.mDBIdentity) == j && tMAssistantSDKChannelDataItem.mDataItemEndTime - tMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000) {
                    AppMethodBeat.m2505o(75859);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(75859);
        return false;
    }

    public int checkQQDownloaderInstalled(int i) {
        AppMethodBeat.m2504i(75860);
        if (this.mContext == null) {
            Exception exception = new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
            AppMethodBeat.m2505o(75860);
            throw exception;
        }
        String str = "com.tencent.android.qqdownloader";
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            try {
                if (packageManager.getPackageInfo(str, 0) != null) {
                    int qQDownloaderVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
                    if (this.sdkAPILevel > GlobalUtil.getInstance().getQQDownloaderAPILevel()) {
                        AppMethodBeat.m2505o(75860);
                        return 2;
                    } else if (i > qQDownloaderVersionCode) {
                        AppMethodBeat.m2505o(75860);
                        return 2;
                    } else {
                        AppMethodBeat.m2505o(75860);
                        return 0;
                    }
                }
                AppMethodBeat.m2505o(75860);
                return 1;
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75860);
        return 1;
    }

    public void startQQDownloader(Context context) {
        AppMethodBeat.m2504i(75861);
        if (context != null) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
            if (context instanceof Application) {
                launchIntentForPackage.addFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        }
        AppMethodBeat.m2505o(75861);
    }

    public void startToDownloadTaskList(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75862);
        if (context == null) {
            Exception exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75862);
            throw exception;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            AppMethodBeat.m2505o(75862);
        } else {
            String uuid = UUID.randomUUID().toString();
            if (this.mDownloadParams != null) {
                this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
            }
            if (z) {
                DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                createNewChunkLogInfo.UUID = uuid;
                createNewChunkLogInfo.requestUrl = "";
                createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
                DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            }
            Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            AppMethodBeat.m2505o(75862);
        }
    }

    public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75863);
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 1);
        AppMethodBeat.m2505o(75863);
        return buildAddDBData;
    }

    public void startToAppDetail(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75864);
        if (context == null) {
            Exception exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75864);
            throw exception;
        }
        String uuid = UUID.randomUUID().toString();
        if (this.mDownloadParams != null) {
            this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
        }
        if (z) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
        }
        Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, z, z2);
        formatMapParams.put("taskid", uuid);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, formatMapParams)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(75864);
    }

    public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, boolean z, boolean z2) {
        AppMethodBeat.m2504i(75865);
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, z, z2, tMQQDownloaderOpenSDKParam.actionFlag, null, 2);
        AppMethodBeat.m2505o(75865);
        return buildAddDBData;
    }

    public void startToAuthorized(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.m2504i(75866);
        Exception exception;
        if (context == null) {
            exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75866);
            throw exception;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            exception = new Exception("QQDownloaderParam param cann't be null!");
            AppMethodBeat.m2505o(75866);
            throw exception;
        } else {
            String uuid = UUID.randomUUID().toString();
            if (this.mDownloadParams != null) {
                this.mDownloadParams.put(uuid, tMQQDownloaderOpenSDKParam);
            }
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
            createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
            createNewChunkLogInfo.UUID = uuid;
            createNewChunkLogInfo.appId = tMQQDownloaderOpenSDKParam.taskAppId;
            createNewChunkLogInfo.resultState = 1;
            DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
            Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, true, true);
            formatMapParams.put("verifytype", str);
            formatMapParams.put("taskid", uuid);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, formatMapParams)));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            AppMethodBeat.m2505o(75866);
        }
    }

    public void startToAuthorized(Context context, String str) {
        AppMethodBeat.m2504i(75867);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(str)));
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(75867);
    }

    public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.m2504i(75868);
        if (!(this.mDownloadParams == null || tMQQDownloaderOpenSDKParam == null)) {
            this.mDownloadParams.put(UUID.randomUUID().toString(), tMQQDownloaderOpenSDKParam);
        }
        long buildAddDBData = super.buildAddDBData(tMQQDownloaderOpenSDKParam, true, true, tMQQDownloaderOpenSDKParam.actionFlag, str, 3);
        AppMethodBeat.m2505o(75868);
        return buildAddDBData;
    }

    public long addDownloadTaskFromAuthorize(String str) {
        AppMethodBeat.m2504i(75869);
        String formatEncryptUrl = super.formatEncryptUrl(str);
        long currentTimeMillis = System.currentTimeMillis();
        long AddDataItem = this.sdkChannel.AddDataItem(this.hostPackageName, this.hostVersionCode, "", 0, formatEncryptUrl, currentTimeMillis, currentTimeMillis + 300000, 0, null);
        AppMethodBeat.m2505o(75869);
        return AddDataItem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0214 A:{Splitter:B:22:0x013a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:61:0x0214, code skipped:
            r2 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        Throwable e;
        Cursor cursor;
        Throwable th;
        AppMethodBeat.m2504i(75870);
        Exception exception;
        if (this.mContext == null) {
            exception = new Exception("Context shouldn't be null !");
            AppMethodBeat.m2505o(75870);
            throw exception;
        } else if (tMQQDownloaderOpenSDKParam == null) {
            exception = new Exception("QQDownloaderParam param cann't is null!");
            AppMethodBeat.m2505o(75870);
            throw exception;
        } else {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(CONTENT_URI, null, "packageName=? and versionCode=? and channelId=?", new String[]{tMQQDownloaderOpenSDKParam.taskPackageName, String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion), tMQQDownloaderOpenSDKParam.channelId}, null);
                try {
                    TMLog.m60586d(TAG, "getDownloadTaskState from qqdownloader , taskPackageName = " + tMQQDownloaderOpenSDKParam.taskPackageName + ", taskVersion=" + String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion) + ", channelId=" + tMQQDownloaderOpenSDKParam.channelId);
                    if (query == null || !query.moveToFirst()) {
                        tMAssistantDownloadTaskInfo = null;
                    } else {
                        TMLog.m60588i(TAG, "relate to qqdownloader , packageName = " + tMQQDownloaderOpenSDKParam.taskPackageName);
                        long j = query.getLong(query.getColumnIndex(DownloadInfoColumns.APKID));
                        String str = (String) GlobalUtil.String2List(query.getString(query.getColumnIndex(DownloadInfoColumns.APPURLS))).get(0);
                        String string = query.getString(query.getColumnIndex("filePath"));
                        long j2 = query.getLong(query.getColumnIndex(DownloadInfoColumns.RECEIVEDLENGTH));
                        long j3 = query.getLong(query.getColumnIndex(DownloadInfoColumns.TOTALLENGTH));
                        String str2 = "application/vnd.android.package-archive";
                        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(query.getInt(query.getColumnIndex("state")));
                        TMLog.m60588i(TAG, "getDownloadTaskState state = ".concat(String.valueOf(assistantState2SDKState)));
                        if (4 != assistantState2SDKState || isFileExist(string)) {
                            try {
                                tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(str, string, assistantState2SDKState, j2, j3, str2);
                                if (assistantState2SDKState == 5 || assistantState2SDKState == 4 || assistantState2SDKState == 3) {
                                    DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 1);
                                    createNewChunkLogInfo.via = tMQQDownloaderOpenSDKParam.via;
                                    createNewChunkLogInfo.appId = String.valueOf(j);
                                    createNewChunkLogInfo.resultState = assistantState2SDKState;
                                    createNewChunkLogInfo.requestUrl = str;
                                    DownloadReportManager.getInstance().addLogData(createNewChunkLogInfo);
                                }
                                if (this.mDownloadParams != null) {
                                    Object obj;
                                    for (Entry value : this.mDownloadParams.entrySet()) {
                                        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = (TMQQDownloaderOpenSDKParam) value.getValue();
                                        if (tMQQDownloaderOpenSDKParam2 != null && tMQQDownloaderOpenSDKParam2.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName) && tMQQDownloaderOpenSDKParam2.taskVersion == tMQQDownloaderOpenSDKParam.taskVersion) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                    obj = null;
                                    if (obj == null) {
                                        TMLog.m60588i(TAG, "relate to qqdownloader , packageName = " + tMQQDownloaderOpenSDKParam.taskPackageName);
                                        str = UUID.randomUUID().toString();
                                        tMQQDownloaderOpenSDKParam.taskApkId = String.valueOf(j);
                                        this.mDownloadParams.put(str, tMQQDownloaderOpenSDKParam);
                                        relateToQQDownloader(this.mContext, tMQQDownloaderOpenSDKParam, str);
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor = query;
                                try {
                                    C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    AppMethodBeat.m2505o(75870);
                                    return tMAssistantDownloadTaskInfo;
                                } catch (Throwable th2) {
                                    th = th2;
                                    query = cursor;
                                    if (query != null) {
                                    }
                                    AppMethodBeat.m2505o(75870);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                            }
                        } else {
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(75870);
                            return null;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = query;
                    tMAssistantDownloadTaskInfo = null;
                    C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    if (cursor != null) {
                    }
                    AppMethodBeat.m2505o(75870);
                    return tMAssistantDownloadTaskInfo;
                } catch (Throwable th32) {
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
                tMAssistantDownloadTaskInfo = null;
            } catch (Throwable th4) {
                th = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.m2505o(75870);
                throw th;
            }
            AppMethodBeat.m2505o(75870);
            return tMAssistantDownloadTaskInfo;
        }
    }

    private void relateToQQDownloader(Context context, TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, String str) {
        AppMethodBeat.m2504i(75871);
        Map formatMapParams = super.formatMapParams(tMQQDownloaderOpenSDKParam, false, false);
        formatMapParams.put("taskid", str);
        String formatIntentUriPath = super.formatIntentUriPath(4, formatMapParams);
        Intent intent = new Intent("com.tencent.android.qqdownloader.action.RELATED");
        intent.setPackage("com.tencent.android.qqdownloader");
        intent.putExtra("command", "cmd_updatedownload");
        intent.putExtra("relatedurl", formatIntentUriPath);
        context.sendBroadcast(intent);
        AppMethodBeat.m2505o(75871);
    }

    private boolean isFileExist(String str) {
        AppMethodBeat.m2504i(75872);
        if (new File(str).exists()) {
            AppMethodBeat.m2505o(75872);
            return true;
        }
        AppMethodBeat.m2505o(75872);
        return false;
    }

    public void onDownloadStateChanged(TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam) {
        AppMethodBeat.m2504i(75873);
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = tMQQDownloaderStateChangeParam.param;
        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(tMQQDownloaderStateChangeParam.state);
        int assistantErrorCode2SDKErrorCode = GlobalUtil.assistantErrorCode2SDKErrorCode(tMQQDownloaderStateChangeParam.errorCode);
        String str = tMQQDownloaderStateChangeParam.errorMsg;
        String str2 = tMQQDownloaderStateChangeParam.taskId;
        TMLog.m60588i(TAG, "onDownloadStateChanged state = ".concat(String.valueOf(assistantState2SDKState)));
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam2 = null;
        if (str2 != null && str2.trim().length() > 0) {
            tMQQDownloaderOpenSDKParam2 = (TMQQDownloaderOpenSDKParam) this.mDownloadParams.get(str2);
        }
        if (tMQQDownloaderOpenSDKParam2 != null) {
            onStateChanged(tMQQDownloaderOpenSDKParam2, assistantState2SDKState, assistantErrorCode2SDKErrorCode, str);
        } else {
            TMLog.m60588i(TAG, "onDownloadStateChanged storeParam = null");
        }
        if (6 == assistantState2SDKState) {
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this.mDownloadParams.entrySet()) {
                TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam3 = (TMQQDownloaderOpenSDKParam) entry.getValue();
                String str3 = (String) entry.getKey();
                if (tMQQDownloaderOpenSDKParam3 != null && !TextUtils.isEmpty(tMQQDownloaderOpenSDKParam.taskPackageName) && tMQQDownloaderOpenSDKParam3.taskPackageName.equals(tMQQDownloaderOpenSDKParam.taskPackageName) && tMQQDownloaderOpenSDKParam3.taskVersion == tMQQDownloaderOpenSDKParam.taskVersion) {
                    arrayList.add(str3);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mDownloadParams.remove((String) it.next());
            }
        }
        AppMethodBeat.m2505o(75873);
    }

    public void initQQDownloaderOpenSDK(Context context) {
        AppMethodBeat.m2504i(75874);
        this.mContext = context;
        this.hostPackageName = context.getPackageName();
        this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
        GlobalUtil.getInstance().setContext(this.mContext);
        this.sdkAPILevel = 1;
        DownloadStateChangedReceiver.getInstance().registeReceiver(this.mContext);
        DownloadStateChangedReceiver.getInstance().addDownloadStateChangedListener(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        GetSettingEngine.getInstance().sendRequest();
        LogReportManager.getInstance().reportLog();
        AppMethodBeat.m2505o(75874);
    }

    public static String about() {
        return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
    }

    public void startToWebView(Context context, String str) {
        AppMethodBeat.m2504i(75875);
        Exception exception;
        if (context == null) {
            exception = new Exception("you must input an application or activity context!");
            AppMethodBeat.m2505o(75875);
            throw exception;
        } else if (TextUtils.isEmpty(str)) {
            exception = new Exception("param url shouldn't be null!");
            AppMethodBeat.m2505o(75875);
            throw exception;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            String formatIntentUriPath = super.formatIntentUriPath(5, hashMap);
            TMLog.m60588i(TAG, "startToWebView finalPath:".concat(String.valueOf(formatIntentUriPath)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(formatIntentUriPath));
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            AppMethodBeat.m2505o(75875);
        }
    }
}
