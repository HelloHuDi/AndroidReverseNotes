package com.tencent.tmassistantsdk.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadclient.IAssistantOnActionListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.param.IPCPackageTools;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.BatchDownloadActionResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.GetDownloadProgressResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.GetDownloadStateResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCBaseParam;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCDownloadParam;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCQueryDownloadInfo;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.OperateDownloadTaskRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.QueryDownloadTaskResponse;
import com.tencent.tmassistantsdk.openSDK.param.jce.URIActionRequest;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.UUID;

public class TMQQDownloaderOpenSDKDataProcessor implements IAssistantOnActionListener {
    protected static final String TAG = "QQDownloaderOpenSDKDataProcessor";
    protected static TMQQDownloaderOpenSDKDataProcessor mOpenSDKDataProcessor = null;
    protected ITMQQDownloaderOpenSDKListener callback = null;
    String clientKey = UUID.randomUUID().toString();
    protected TMAssistantDownloadOpenSDKClient openSDKClient = null;

    public TMQQDownloaderOpenSDKDataProcessor() {
        AppMethodBeat.i(75876);
        AppMethodBeat.o(75876);
    }

    private TMQQDownloaderOpenSDKDataProcessor(Context context) {
        AppMethodBeat.i(75877);
        if (context != null) {
            getOpenSDKClient(context);
        }
        AppMethodBeat.o(75877);
    }

    public static synchronized TMQQDownloaderOpenSDKDataProcessor getInstance(Context context) {
        TMQQDownloaderOpenSDKDataProcessor tMQQDownloaderOpenSDKDataProcessor;
        synchronized (TMQQDownloaderOpenSDKDataProcessor.class) {
            AppMethodBeat.i(75878);
            if (mOpenSDKDataProcessor == null) {
                mOpenSDKDataProcessor = new TMQQDownloaderOpenSDKDataProcessor(context);
            }
            tMQQDownloaderOpenSDKDataProcessor = mOpenSDKDataProcessor;
            AppMethodBeat.o(75878);
        }
        return tMQQDownloaderOpenSDKDataProcessor;
    }

    public void registerIQQDownloaderOpenSDKListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        this.callback = iTMQQDownloaderOpenSDKListener;
    }

    public void unregisterIQQDownloaderOpenSDKListener() {
        AppMethodBeat.i(75879);
        this.callback = null;
        Context context = GlobalUtil.getInstance().getContext();
        if (context != null) {
            TMAssistantDownloadSDKManager.getInstance(context).releaseDownloadSDKClient(this.clientKey);
        }
        this.openSDKClient = null;
        AppMethodBeat.o(75879);
    }

    public boolean handleDownloadTask(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, String str, String str2, String str3) {
        AppMethodBeat.i(75880);
        TMLog.i(TAG, "handleDownloadTask requestType:" + i + "  param.sngAppid:" + tMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + tMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + tMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + tMQQDownloaderOpenSDKParam.taskVersion + "| param.actionFlag:" + str2 + " | verifyType:" + str3);
        OperateDownloadTaskRequest operateDownloadTaskRequest = new OperateDownloadTaskRequest();
        IPCBaseParam QQParam2BasePram = QQParam2BasePram(tMQQDownloaderOpenSDKParam);
        operateDownloadTaskRequest.requestType = i;
        operateDownloadTaskRequest.baseParam = QQParam2BasePram;
        operateDownloadTaskRequest.actionFlag = str2;
        operateDownloadTaskRequest.verifyType = str3;
        operateDownloadTaskRequest.opList = str;
        byte[] buildSendData = buildSendData(operateDownloadTaskRequest);
        if (buildSendData == null || buildSendData.length <= 0) {
            TMLog.i(TAG, "handleDownloadTask sendData = null");
            AppMethodBeat.o(75880);
            return false;
        }
        try {
            getOpenSDKClient(GlobalUtil.getInstance().getContext());
            if (this.openSDKClient != null) {
                this.openSDKClient.sendAsyncData(buildSendData);
                AppMethodBeat.o(75880);
                return true;
            }
            AppMethodBeat.o(75880);
            return false;
        } catch (Throwable th) {
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(75880);
            return false;
        }
    }

    public boolean handleUriAction(String str) {
        AppMethodBeat.i(75881);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75881);
        } else {
            byte[] buildSendData = buildSendData(new URIActionRequest(str));
            if (buildSendData == null || buildSendData.length <= 0) {
                TMLog.i(TAG, "handleUriAction sendData = null");
                AppMethodBeat.o(75881);
            } else {
                try {
                    getOpenSDKClient(GlobalUtil.getInstance().getContext());
                    if (this.openSDKClient != null) {
                        this.openSDKClient.sendAsyncData(buildSendData);
                    }
                    AppMethodBeat.o(75881);
                } catch (Throwable th) {
                    ab.printErrStackTrace(TAG, th, "", new Object[0]);
                    AppMethodBeat.o(75881);
                }
            }
        }
        return false;
    }

    public boolean handleBatchRequestAction(int i, ArrayList<TMQQDownloaderOpenSDKParam> arrayList, String str, String str2, String str3) {
        AppMethodBeat.i(75882);
        TMLog.i(TAG, "handleBatchUpdateAction batchRequestType:" + i + "|appList:" + arrayList);
        byte[] buildSendData = buildSendData(buildBatchActionRequest(i, arrayList, str, str2, str3));
        if (buildSendData == null || buildSendData.length <= 0) {
            TMLog.i(TAG, "handleBatchUpdateAction sendData = null or length = 0");
            AppMethodBeat.o(75882);
            return false;
        }
        try {
            getOpenSDKClient(GlobalUtil.getInstance().getContext());
            if (this.openSDKClient != null) {
                this.openSDKClient.sendAsyncData(buildSendData);
                AppMethodBeat.o(75882);
                return true;
            }
            AppMethodBeat.o(75882);
            return false;
        } catch (Throwable th) {
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(75882);
            return false;
        }
    }

    public ArrayList<TMAssistantDownloadTaskInfo> getBatchTaskInfos(ArrayList<TMQQDownloaderOpenSDKParam> arrayList, String str, String str2, String str3) {
        AppMethodBeat.i(75883);
        if (arrayList == null) {
            AppMethodBeat.o(75883);
            return null;
        }
        TMLog.i(TAG, "getBatchTaskInfos appList.size:" + arrayList.size());
        byte[] buildSendData = buildSendData(buildBatchActionRequest(3, arrayList, str, str2, str3));
        byte[] bArr = null;
        if (buildSendData == null || buildSendData.length <= 0) {
            TMLog.i(TAG, "getBatchTaskInfos sendData = null or length = 0");
        } else {
            try {
                getOpenSDKClient(GlobalUtil.getInstance().getContext());
                if (this.openSDKClient != null) {
                    bArr = this.openSDKClient.sendSyncData(buildSendData);
                }
            } catch (Throwable th) {
                ab.printErrStackTrace(TAG, th, "", new Object[0]);
                AppMethodBeat.o(75883);
                return null;
            }
        }
        ArrayList<TMAssistantDownloadTaskInfo> arrayList2 = null;
        IPCResponse unpackPackage = IPCPackageTools.unpackPackage(bArr);
        if (unpackPackage != null) {
            BatchDownloadActionResponse batchDownloadActionResponse = (BatchDownloadActionResponse) IPCPackageTools.unpackBodyStruct(unpackPackage);
            if (batchDownloadActionResponse != null) {
                ArrayList<TMAssistantDownloadTaskInfo> arrayList3;
                String str4;
                String str5 = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + batchDownloadActionResponse.batchRequestType;
                if (batchDownloadActionResponse.batchData != null) {
                    String str6 = str5 + "response.batchData.size:" + batchDownloadActionResponse.batchData.size();
                    ArrayList<TMAssistantDownloadTaskInfo> arrayList4 = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= batchDownloadActionResponse.batchData.size()) {
                            break;
                        }
                        IPCQueryDownloadInfo iPCQueryDownloadInfo = (IPCQueryDownloadInfo) batchDownloadActionResponse.batchData.get(i2);
                        int assistantState2SDKState = GlobalUtil.assistantState2SDKState(iPCQueryDownloadInfo.state);
                        if (iPCQueryDownloadInfo != null) {
                            arrayList4.add(new TMAssistantDownloadTaskInfo(iPCQueryDownloadInfo.url, iPCQueryDownloadInfo.savePath, assistantState2SDKState, iPCQueryDownloadInfo.receivedLen, iPCQueryDownloadInfo.totalLen, "application/vnd.android.package-archive"));
                        }
                        i = i2 + 1;
                    }
                    arrayList3 = arrayList4;
                    str4 = str6;
                } else {
                    str4 = str5 + "response.batchData = null";
                    arrayList3 = null;
                }
                TMLog.i(TAG, str4);
                arrayList2 = arrayList3;
            } else {
                TMLog.i(TAG, "getBatchTaskInfos BatchDownloadActionResponse response = null");
            }
        } else {
            TMLog.i(TAG, "getBatchTaskInfos IPCResponse resp = null");
        }
        AppMethodBeat.o(75883);
        return arrayList2;
    }

    public TMAssistantDownloadTaskInfo getDownloadTask(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.i(75884);
        TMLog.i(TAG, "getDownloadTask param.sngAppid:" + tMQQDownloaderOpenSDKParam.SNGAppId + "|param.appid:" + tMQQDownloaderOpenSDKParam.taskAppId + "| param.taskPackageName:" + tMQQDownloaderOpenSDKParam.taskPackageName + "|param.taskVersion:" + tMQQDownloaderOpenSDKParam.taskVersion);
        IPCBaseParam QQParam2BasePram = QQParam2BasePram(tMQQDownloaderOpenSDKParam);
        QueryDownloadTaskRequest queryDownloadTaskRequest = new QueryDownloadTaskRequest();
        queryDownloadTaskRequest.baseParam = QQParam2BasePram;
        byte[] buildSendData = buildSendData(queryDownloadTaskRequest);
        if (buildSendData == null || buildSendData.length <= 0) {
            TMLog.i(TAG, "getDownloadTask sendData = null");
            buildSendData = null;
        } else {
            try {
                getOpenSDKClient(GlobalUtil.getInstance().getContext());
                if (this.openSDKClient != null) {
                    buildSendData = this.openSDKClient.sendSyncData(buildSendData);
                }
                buildSendData = null;
            } catch (Throwable th) {
                ab.printErrStackTrace(TAG, th, "", new Object[0]);
                AppMethodBeat.o(75884);
                return null;
            }
        }
        IPCResponse unpackPackage = IPCPackageTools.unpackPackage(buildSendData);
        if (unpackPackage != null) {
            QueryDownloadTaskResponse queryDownloadTaskResponse = (QueryDownloadTaskResponse) IPCPackageTools.unpackBodyStruct(unpackPackage);
            TMLog.i(TAG, "QueryDownloadTaskResponse downloadTask:".concat(String.valueOf(queryDownloadTaskResponse)));
            int assistantState2SDKState = GlobalUtil.assistantState2SDKState(queryDownloadTaskResponse.state);
            if (queryDownloadTaskResponse != null) {
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(queryDownloadTaskResponse.url, queryDownloadTaskResponse.savePath, assistantState2SDKState, queryDownloadTaskResponse.receivedLen, queryDownloadTaskResponse.totalLen, "application/vnd.android.package-archive");
                AppMethodBeat.o(75884);
                return tMAssistantDownloadTaskInfo;
            }
        }
        TMLog.i(TAG, "getDownloadTask IPCResponse = null");
        AppMethodBeat.o(75884);
        return null;
    }

    protected static BatchDownloadActionRequest buildBatchActionRequest(int i, ArrayList<TMQQDownloaderOpenSDKParam> arrayList, String str, String str2, String str3) {
        AppMethodBeat.i(75885);
        BatchDownloadActionRequest batchDownloadActionRequest = new BatchDownloadActionRequest();
        batchDownloadActionRequest.batchRequestType = i;
        if (str != null) {
            batchDownloadActionRequest.via = str;
        }
        if (str2 != null) {
            batchDownloadActionRequest.uin = str2;
        }
        if (str3 != null) {
            batchDownloadActionRequest.uinType = str3;
        }
        batchDownloadActionRequest.batchData = new ArrayList();
        String str4 = "appList {";
        if (arrayList != null) {
            str4 = str4 + "appList.size=" + arrayList.size() + IOUtils.LINE_SEPARATOR_UNIX;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= arrayList.size()) {
                    break;
                }
                IPCBaseParam QQParam2BasePram = QQParam2BasePram((TMQQDownloaderOpenSDKParam) arrayList.get(i3));
                IPCDownloadParam iPCDownloadParam = new IPCDownloadParam();
                iPCDownloadParam.baseParam = QQParam2BasePram;
                batchDownloadActionRequest.batchData.add(iPCDownloadParam);
                str4 = str4 + "element:" + i3 + "IPCDownloadParam {IPCBaseParam {hostAppId:" + iPCDownloadParam.baseParam.hostAppId + "|taskAppId:" + iPCDownloadParam.baseParam.taskAppId + "|taskPackageName:" + iPCDownloadParam.baseParam.taskPackageName + "|taskVersion:" + iPCDownloadParam.baseParam.taskVersion + "}|actionFlag:" + iPCDownloadParam.actionFlag + "|verifyType:" + iPCDownloadParam.verifyType + "}\n";
                i2 = i3 + 1;
            }
        }
        TMLog.i(TAG, str4 + "}");
        AppMethodBeat.o(75885);
        return batchDownloadActionRequest;
    }

    protected static byte[] buildSendData(JceStruct jceStruct) {
        AppMethodBeat.i(75886);
        IPCRequest buildIpcRequest = IPCPackageTools.buildIpcRequest(jceStruct);
        if (buildIpcRequest != null) {
            byte[] buildPostData = IPCPackageTools.buildPostData(buildIpcRequest);
            if (buildPostData == null || buildPostData.length <= 0) {
                TMLog.i(TAG, "handleUriAction sendData = null");
                AppMethodBeat.o(75886);
                return null;
            }
            AppMethodBeat.o(75886);
            return buildPostData;
        }
        TMLog.i(TAG, "handleUriAction IPCRequest = null");
        AppMethodBeat.o(75886);
        return null;
    }

    private static IPCBaseParam QQParam2BasePram(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.i(75887);
        if (tMQQDownloaderOpenSDKParam == null) {
            AppMethodBeat.o(75887);
            return null;
        }
        IPCBaseParam iPCBaseParam = new IPCBaseParam();
        iPCBaseParam.hostAppId = tMQQDownloaderOpenSDKParam.SNGAppId;
        iPCBaseParam.taskAppId = tMQQDownloaderOpenSDKParam.taskAppId;
        iPCBaseParam.taskPackageName = tMQQDownloaderOpenSDKParam.taskPackageName;
        iPCBaseParam.taskVersion = String.valueOf(tMQQDownloaderOpenSDKParam.taskVersion);
        iPCBaseParam.uin = tMQQDownloaderOpenSDKParam.uin;
        iPCBaseParam.uinType = tMQQDownloaderOpenSDKParam.uinType;
        iPCBaseParam.via = tMQQDownloaderOpenSDKParam.via;
        iPCBaseParam.channelId = tMQQDownloaderOpenSDKParam.channelId;
        AppMethodBeat.o(75887);
        return iPCBaseParam;
    }

    private TMQQDownloaderOpenSDKParam baseParam2QQParam(IPCBaseParam iPCBaseParam) {
        AppMethodBeat.i(75888);
        if (iPCBaseParam == null) {
            AppMethodBeat.o(75888);
            return null;
        }
        TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
        tMQQDownloaderOpenSDKParam.SNGAppId = iPCBaseParam.hostAppId;
        tMQQDownloaderOpenSDKParam.taskAppId = iPCBaseParam.taskAppId;
        tMQQDownloaderOpenSDKParam.taskPackageName = iPCBaseParam.taskPackageName;
        try {
            tMQQDownloaderOpenSDKParam.taskVersion = Integer.valueOf(iPCBaseParam.taskVersion).intValue();
        } catch (Exception e) {
            TMLog.i(TAG, "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
        }
        tMQQDownloaderOpenSDKParam.uin = iPCBaseParam.uin;
        tMQQDownloaderOpenSDKParam.uinType = iPCBaseParam.uinType;
        tMQQDownloaderOpenSDKParam.via = iPCBaseParam.via;
        tMQQDownloaderOpenSDKParam.channelId = iPCBaseParam.channelId;
        AppMethodBeat.o(75888);
        return tMQQDownloaderOpenSDKParam;
    }

    public void onActionResult(byte[] bArr) {
        AppMethodBeat.i(75889);
        if (bArr == null || bArr.length <= 0) {
            TMLog.i(TAG, "onActionResult reponseData = null");
            AppMethodBeat.o(75889);
            return;
        }
        IPCResponse unpackPackage = IPCPackageTools.unpackPackage(bArr);
        JceStruct unpackBodyStruct = IPCPackageTools.unpackBodyStruct(unpackPackage);
        switch (unpackPackage.head.cmdId) {
            case 2:
                if (unpackBodyStruct != null) {
                    onStateChanged((GetDownloadStateResponse) unpackBodyStruct);
                    AppMethodBeat.o(75889);
                    return;
                }
                break;
            case 3:
                if (unpackBodyStruct != null) {
                    onProgressChanged((GetDownloadProgressResponse) unpackBodyStruct);
                    AppMethodBeat.o(75889);
                    return;
                }
                break;
            case 8:
                onServiceFreed();
                break;
        }
        AppMethodBeat.o(75889);
    }

    public void onDownloadSDKServiceInvalid() {
        AppMethodBeat.i(75890);
        if (this.callback != null) {
            this.callback.OnQQDownloaderInvalid();
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context != null) {
            TMAssistantDownloadSDKManager.getInstance(context).releaseDownloadSDKClient(this.clientKey);
        }
        this.openSDKClient = null;
        AppMethodBeat.o(75890);
    }

    public void releaseIPCClient() {
        AppMethodBeat.i(75891);
        if (this.openSDKClient != null) {
            Context context = GlobalUtil.getInstance().getContext();
            if (context != null) {
                TMAssistantDownloadSDKManager.getInstance(context).releaseDownloadSDKClient(this.clientKey);
            }
            this.openSDKClient = null;
        }
        AppMethodBeat.o(75891);
    }

    /* Access modifiers changed, original: 0000 */
    public void onStateChanged(GetDownloadStateResponse getDownloadStateResponse) {
        AppMethodBeat.i(75892);
        TMQQDownloaderOpenSDKParam baseParam2QQParam = baseParam2QQParam(getDownloadStateResponse.requestParam);
        if (!(baseParam2QQParam == null || this.callback == null)) {
            TMLog.i(TAG, "状态回调：GetDownloadStateResponse param.taskAppId:" + baseParam2QQParam.taskAppId + ",param.taskPackageName:" + baseParam2QQParam.taskPackageName + ",state:" + getDownloadStateResponse.state + ",response.errorCode" + getDownloadStateResponse.errorCode);
            this.callback.OnDownloadTaskStateChanged(baseParam2QQParam, GlobalUtil.assistantState2SDKState(getDownloadStateResponse.state), GlobalUtil.assistantErrorCode2SDKErrorCode(getDownloadStateResponse.errorCode), getDownloadStateResponse.errorMsg);
        }
        AppMethodBeat.o(75892);
    }

    /* Access modifiers changed, original: 0000 */
    public void onProgressChanged(GetDownloadProgressResponse getDownloadProgressResponse) {
        AppMethodBeat.i(75893);
        TMQQDownloaderOpenSDKParam baseParam2QQParam = baseParam2QQParam(getDownloadProgressResponse.requestParam);
        if (!(baseParam2QQParam == null || this.callback == null)) {
            TMLog.i(TAG, "进度回调：GetDownloadProgressResponse response.receivedLen:" + getDownloadProgressResponse.receivedLen + ",response.totalLen" + getDownloadProgressResponse.totalLen);
            this.callback.OnDownloadTaskProgressChanged(baseParam2QQParam, getDownloadProgressResponse.receivedLen, getDownloadProgressResponse.totalLen);
        }
        AppMethodBeat.o(75893);
    }

    /* Access modifiers changed, original: 0000 */
    public void onServiceFreed() {
        AppMethodBeat.i(75894);
        if (this.callback != null) {
            this.callback.OnServiceFree();
        }
        AppMethodBeat.o(75894);
    }

    public synchronized void getOpenSDKClient(Context context) {
        AppMethodBeat.i(75895);
        if (this.openSDKClient == null && context != null) {
            this.openSDKClient = TMAssistantDownloadSDKManager.getInstance(context).getDownloadOpenSDKClient(this.clientKey);
            if (this.openSDKClient != null) {
                this.openSDKClient.addAssistantOnActionListener(this);
            }
        }
        AppMethodBeat.o(75895);
    }
}
