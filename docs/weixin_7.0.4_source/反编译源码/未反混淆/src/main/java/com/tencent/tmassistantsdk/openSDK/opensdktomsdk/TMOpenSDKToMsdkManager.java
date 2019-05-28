package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.network.GetAuthorizedHttpRequest;
import com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TMOpenSDKToMsdkManager {
    protected static final String CLIENT_NAME = "downloadSDKClient";
    protected static final String TAG = "OpensdkToMsdkManager";
    protected static TMOpenSDKToMsdkManager mInstance = null;
    protected int authorizedState = 0;
    protected PopDialog dialog = null;
    protected boolean hasNotify = false;
    protected long insertActionId = -1;
    protected boolean isInstallFinished = false;
    protected TMOpenSDKAuthorizedInfo mAuthorizedInfo = null;
    protected TMAssistantDownloadSDKClient mClient = null;
    protected Context mContext = null;
    protected ITMAssistantDownloadSDKClientListener mDownloadSDKListener = new ITMAssistantDownloadSDKClientListener() {
        public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
        }

        public void OnDownloadSDKTaskStateChanged(final TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, final String str, int i, int i2, String str2, boolean z, boolean z2) {
            AppMethodBeat.i(75929);
            TMLog.i(TMOpenSDKToMsdkManager.TAG, "OnDownloadSDKTaskStateChanged client:" + tMAssistantDownloadSDKClient + " | state:" + i + " | errorcode:" + i2 + " | errorMsg:" + str2);
            if (tMAssistantDownloadSDKClient == null || TextUtils.isEmpty(str)) {
                AppMethodBeat.o(75929);
            } else if (4 == i) {
                TMOpenSDKToMsdkManager.this.mSubMessageHandler.post(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(75928);
                        try {
                            String str = tMAssistantDownloadSDKClient.getDownloadTaskState(str).mSavePath;
                            if (!TextUtils.isEmpty(str)) {
                                Message message = new Message();
                                message.what = 0;
                                message.obj = str;
                                TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                            }
                            AppMethodBeat.o(75928);
                        } catch (Exception e) {
                            ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                            AppMethodBeat.o(75928);
                        }
                    }
                });
                AppMethodBeat.o(75929);
            } else {
                if (5 == i) {
                    Message message = new Message();
                    message.what = 3;
                    TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                }
                AppMethodBeat.o(75929);
            }
        }

        public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            AppMethodBeat.i(75930);
            Message message = new Message();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putLong("receiveDataLen", j);
            bundle.putLong("totalDataLen", j2);
            message.setData(bundle);
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
            AppMethodBeat.o(75930);
        }
    };
    protected String mDownloadUrl = null;
    protected GetAuthorizedHttpRequest mHttpRequest = null;
    protected ak mMainMessageHandler = null;
    protected TMQQDownloaderOpenSDK mOpenSDK = null;
    protected IGetAuthorizedHttpRequestListenner mRequestListener = new IGetAuthorizedHttpRequestListenner() {
        public void onGetAuthorizedRequestFinished(AuthorizedResult authorizedResult, int i) {
            AppMethodBeat.i(75921);
            Message message = new Message();
            if (i != 0) {
                message.what = 5;
                message.obj = Integer.valueOf(i);
            } else if (authorizedResult == null) {
                AppMethodBeat.o(75921);
                return;
            } else {
                message.what = 4;
                message.obj = authorizedResult;
            }
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
            AppMethodBeat.o(75921);
        }
    };
    protected ak mSubMessageHandler = null;
    protected HandlerThread mSubMessagehandlerThread = null;
    protected int mSupportVersionCode = 0;
    protected ITMOpenSDKToMsdkListener mToMsdkListener = null;
    protected OnClickListener negativeBtnListenner = new OnClickListener() {
        public void onClick(View view) {
            AppMethodBeat.i(75924);
            if (TMOpenSDKToMsdkManager.this.dialog.isShowing()) {
                TMOpenSDKToMsdkManager.this.dialog.dismiss();
                TMOpenSDKToMsdkManager.this.mHttpRequest = null;
            }
            TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            createTipsInfoLog.cancelBtnClickCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
            try {
                if (TMOpenSDKToMsdkManager.this.mClient != null) {
                    TMOpenSDKToMsdkManager.this.pauseDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
            }
            if (TMOpenSDKToMsdkManager.this.authorizedState == 2) {
                TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(true, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                AppMethodBeat.o(75924);
                return;
            }
            TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(false, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            AppMethodBeat.o(75924);
        }
    };
    protected OnClickListener positiveBtnListener = new OnClickListener() {
        public void onClick(View view) {
            AppMethodBeat.i(75925);
            if (TMOpenSDKToMsdkManager.this.mContext == null) {
                AppMethodBeat.o(75925);
                return;
            }
            ActionButton actionButton = (ActionButton) view.getTag();
            try {
                switch (TMOpenSDKToMsdkManager.this.mOpenSDK.checkQQDownloaderInstalled(TMOpenSDKToMsdkManager.this.mSupportVersionCode)) {
                    case 0:
                        try {
                            TMOpenSDKToMsdkManager.this.startToQQDownloaderAuthorized(actionButton.jumpUrl);
                            AppMethodBeat.o(75925);
                            return;
                        } catch (Exception e) {
                            ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                            AppMethodBeat.o(75925);
                            return;
                        }
                    case 1:
                        TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, actionButton.jumpUrl);
                        break;
                    case 2:
                        TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, actionButton.jumpUrl);
                        AppMethodBeat.o(75925);
                        return;
                }
                AppMethodBeat.o(75925);
            } catch (Exception e2) {
                ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                AppMethodBeat.o(75925);
            }
        }
    };
    protected OnClickListener retryBtnListener = new OnClickListener() {
        public void onClick(View view) {
            AppMethodBeat.i(75923);
            if (TMOpenSDKToMsdkManager.this.mAuthorizedInfo == null) {
                AppMethodBeat.o(75923);
                return;
            }
            if (TMOpenSDKToMsdkManager.this.mContext != null) {
                TMOpenSDKToMsdkManager.this.getUserAuthorizedInfo(TMOpenSDKToMsdkManager.this.mAuthorizedInfo, TMOpenSDKToMsdkManager.this.mContext);
            }
            TMOpenSDKToMsdkManager.this.dialog.dismiss();
            AppMethodBeat.o(75923);
        }
    };
    protected TMAssistantSDKChannel sdkChannel = null;

    private TMOpenSDKToMsdkManager(Context context) {
        AppMethodBeat.i(75931);
        this.mContext = context;
        AppMethodBeat.o(75931);
    }

    public static synchronized TMOpenSDKToMsdkManager getInstance(Context context) {
        TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager;
        synchronized (TMOpenSDKToMsdkManager.class) {
            AppMethodBeat.i(75932);
            if (mInstance == null) {
                mInstance = new TMOpenSDKToMsdkManager(context);
            }
            tMOpenSDKToMsdkManager = mInstance;
            AppMethodBeat.o(75932);
        }
        return tMOpenSDKToMsdkManager;
    }

    public void initOpenSDK(ITMOpenSDKToMsdkListener iTMOpenSDKToMsdkListener) {
        AppMethodBeat.i(75933);
        this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
        this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
        this.mToMsdkListener = iTMOpenSDKToMsdkListener;
        this.sdkChannel = new TMAssistantSDKChannel();
        this.mSubMessagehandlerThread = new HandlerThread("OpenSDKToMsdkManager");
        this.mSubMessagehandlerThread.start();
        this.mSubMessageHandler = new ak(this.mSubMessagehandlerThread.getLooper());
        this.mMainMessageHandler = new ak(Looper.getMainLooper(), new a() {
            public boolean handleMessage(Message message) {
                AppMethodBeat.i(75920);
                Bundle data;
                switch (message.what) {
                    case 0:
                        int i = message.arg1;
                        TMOpenSDKToMsdkManager.this.handleInstall(message.obj.toString(), i);
                        break;
                    case 1:
                        data = message.getData();
                        if (data != null) {
                            TMOpenSDKToMsdkManager.this.handleDownloading(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                            break;
                        }
                        break;
                    case 3:
                        TMOpenSDKToMsdkManager.this.handleDownloadFailed();
                        break;
                    case 4:
                        AuthorizedResult authorizedResult = (AuthorizedResult) message.obj;
                        if (authorizedResult != null) {
                            TMOpenSDKToMsdkManager.this.onNetworkFinishedSuccess(authorizedResult);
                            break;
                        }
                        break;
                    case 5:
                        TMOpenSDKToMsdkManager.this.onNetworkFinishedFailed(((Integer) message.obj).intValue());
                        break;
                    case 6:
                        data = message.getData();
                        if (data != null) {
                            TMOpenSDKToMsdkManager.this.handleDownloadContinue(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(75920);
                return false;
            }
        });
        AppMethodBeat.o(75933);
    }

    public void onDestroy() {
        AppMethodBeat.i(75934);
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (this.mOpenSDK != null) {
            this.mOpenSDK.destroyQQDownloaderOpenSDK();
        }
        this.mToMsdkListener = null;
        this.hasNotify = false;
        this.isInstallFinished = false;
        this.authorizedState = 0;
        this.mHttpRequest = null;
        this.mAuthorizedInfo = null;
        this.sdkChannel = null;
        this.insertActionId = -1;
        if (this.mContext != null) {
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
        }
        this.mClient = null;
        AppMethodBeat.o(75934);
    }

    public void onResume() {
        AppMethodBeat.i(75935);
        tryToCloseDialog();
        if (this.hasNotify) {
            AppMethodBeat.o(75935);
        } else if (this.authorizedState == 2) {
            AppMethodBeat.o(75935);
        } else {
            if ((this.authorizedState == 3 || this.authorizedState == 0) && this.mContext != null) {
                getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
            }
            AppMethodBeat.o(75935);
        }
    }

    public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo, Context context) {
        AppMethodBeat.i(75936);
        if (context != null) {
            this.mContext = context;
        }
        TMLog.i(TAG, "getUserAuthorizedInfo method called!");
        this.hasNotify = false;
        if (this.mHttpRequest != null) {
            TMLog.i(TAG, "mHttpRequest != null, request didn't finish!");
            AppMethodBeat.o(75936);
            return;
        }
        if (tMOpenSDKAuthorizedInfo != null) {
            this.mAuthorizedInfo = tMOpenSDKAuthorizedInfo;
            if (this.mHttpRequest == null) {
                this.authorizedState = 1;
                this.mHttpRequest = new GetAuthorizedHttpRequest();
                this.mHttpRequest.setListenner(this.mRequestListener);
                this.mHttpRequest.sendRequest(tMOpenSDKAuthorizedInfo);
                AppMethodBeat.o(75936);
                return;
            }
        }
        TMLog.i(TAG, "AuthorizedInfo object is null!");
        AppMethodBeat.o(75936);
    }

    /* Access modifiers changed, original: protected */
    public void onNetworkFinishedSuccess(AuthorizedResult authorizedResult) {
        AppMethodBeat.i(75937);
        this.mDownloadUrl = authorizedResult.downloadUrl;
        this.mSupportVersionCode = authorizedResult.versionCode;
        this.mHttpRequest = null;
        TMLog.i(TAG, "onNetworkFinishedSuccess! authorizedResult.hasAuthoried=" + authorizedResult.hasAuthoried + "  listenner:" + this.mToMsdkListener + "  authroizedinfo:" + this.mAuthorizedInfo);
        if (authorizedResult.hasAuthoried == 1) {
            this.authorizedState = 2;
            if (authorizedResult.tipsInfo != null) {
                showDialog(authorizedResult.tipsInfo);
                AppMethodBeat.o(75937);
                return;
            }
            notifyAuthorizedFinished(true, this.mAuthorizedInfo);
            AppMethodBeat.o(75937);
            return;
        }
        this.authorizedState = 3;
        if (authorizedResult.tipsInfo != null) {
            showDialog(authorizedResult.tipsInfo);
            AppMethodBeat.o(75937);
            return;
        }
        onServerException(authorizedResult.errorCode);
        TMLog.i(TAG, "not in white list and no tips!");
        AppMethodBeat.o(75937);
    }

    /* Access modifiers changed, original: protected */
    public void onNetworkFinishedFailed(int i) {
        AppMethodBeat.i(75938);
        if (i == 606 || i == 602 || i == 601 || i == 704) {
            onServerException(i);
            AppMethodBeat.o(75938);
            return;
        }
        onNetworkException(i);
        AppMethodBeat.o(75938);
    }

    /* Access modifiers changed, original: protected */
    public void onServerException(int i) {
        AppMethodBeat.i(75939);
        if (this.mContext == null) {
            AppMethodBeat.o(75939);
            return;
        }
        Res res = new Res(this.mContext);
        TipsInfo tipsInfo = new TipsInfo();
        tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
        if (i == 602 || i == 601) {
            tipsInfo.content = this.mContext.getString(res.string("white_list_network_error"));
        } else {
            tipsInfo.content = this.mContext.getString(res.string("white_list_server_error"));
        }
        ArrayList arrayList = new ArrayList();
        ActionButton actionButton = new ActionButton();
        actionButton.jumpType = 4;
        String string = this.mContext.getString(res.string("white_list_positive_retry_again"));
        actionButton.textInstalled = string;
        actionButton.textUninstalled = string;
        ActionButton actionButton2 = new ActionButton();
        actionButton2.jumpType = 3;
        String string2 = this.mContext.getString(res.string("white_list_negtive"));
        actionButton2.textInstalled = string2;
        actionButton2.textUninstalled = string2;
        arrayList.add(actionButton);
        arrayList.add(actionButton2);
        tipsInfo.actionButton = arrayList;
        showDialog(tipsInfo);
        this.mHttpRequest = null;
        this.mDownloadUrl = "";
        this.authorizedState = 3;
        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
        createTipsInfoLog.networkErrorTipsCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        AppMethodBeat.o(75939);
    }

    /* Access modifiers changed, original: protected */
    public void onNetworkException(int i) {
        AppMethodBeat.i(75940);
        if (this.mContext == null) {
            AppMethodBeat.o(75940);
            return;
        }
        String string;
        Res res = new Res(this.mContext);
        if (1 == i) {
            string = this.mContext.getString(res.string("white_list_network_not_connected"));
        } else {
            string = this.mContext.getString(res.string("white_list_network_error"));
        }
        TipsInfo tipsInfo = new TipsInfo();
        tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
        tipsInfo.content = string;
        ArrayList arrayList = new ArrayList();
        ActionButton actionButton = new ActionButton();
        actionButton.jumpType = 3;
        arrayList.add(actionButton);
        String string2 = this.mContext.getString(res.string("white_list_negtive_known"));
        actionButton.textInstalled = string2;
        actionButton.textUninstalled = string2;
        tipsInfo.actionButton = arrayList;
        showDialog(tipsInfo);
        this.mHttpRequest = null;
        this.mDownloadUrl = "";
        this.authorizedState = 3;
        TMLog.i(TAG, "network error happened!");
        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
        createTipsInfoLog.networkErrorTipsCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        AppMethodBeat.o(75940);
    }

    /* Access modifiers changed, original: protected */
    public void notifyAuthorizedFinished(boolean z, TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(75941);
        TMLog.i(TAG, "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
        if (this.mToMsdkListener == null) {
            TMLog.i(TAG, "before notifyAuthorizedFinished: mToMsdkListener = null !");
        }
        if (!(this.mToMsdkListener == null || this.mAuthorizedInfo == null)) {
            TMLog.i(TAG, "notifyAuthorizedFinished: result:".concat(String.valueOf(z)));
            this.mToMsdkListener.onAuthorizedFinished(z, this.mAuthorizedInfo);
            this.mHttpRequest = null;
            this.hasNotify = true;
        }
        AppMethodBeat.o(75941);
    }

    /* Access modifiers changed, original: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showDialog(TipsInfo tipsInfo) {
        AppMethodBeat.i(75942);
        if (this.mContext == null) {
            AppMethodBeat.o(75942);
        } else if (this.dialog != null && this.dialog.isShowing()) {
            AppMethodBeat.o(75942);
        } else if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isFinishing()) {
            TMLog.i(TAG, "context is finishing!  context" + this.mContext);
            AppMethodBeat.o(75942);
        } else {
            Res res = new Res(this.mContext);
            if (tipsInfo != null) {
                ArrayList arrayList = tipsInfo.actionButton;
                if (arrayList != null && arrayList.size() > 0) {
                    this.dialog = new PopDialog(this.mContext, res.style("while_list_dialog"), arrayList.size());
                    this.dialog.show();
                    this.dialog.setTitle(tipsInfo.title);
                    this.dialog.setContent(tipsInfo.content);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ActionButton actionButton = (ActionButton) arrayList.get(i);
                        if (actionButton.jumpType == 3) {
                            this.dialog.setNegativeBtnText(actionButton.textInstalled);
                            this.dialog.setNegativeBtnClickListener(this.negativeBtnListenner);
                        } else if (actionButton.jumpType == 4) {
                            this.dialog.setPositiveBtnText(actionButton.textUninstalled);
                            this.dialog.setPositiveBtnClickListener(this.retryBtnListener);
                        } else {
                            try {
                                switch (this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode)) {
                                    case 0:
                                        this.dialog.setPositiveBtnText(actionButton.textInstalled);
                                        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
                                        createTipsInfoLog.authorizedTipsCount++;
                                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                                        break;
                                    case 1:
                                        this.dialog.setPositiveBtnText(actionButton.textUninstalled);
                                        continueDownload();
                                        break;
                                    case 2:
                                        this.dialog.setPositiveBtnText(this.mContext.getString(res.string("white_list_positive_update")));
                                        continueDownload();
                                        break;
                                }
                            } catch (Exception e) {
                                ab.printErrStackTrace(TAG, e, "", new Object[0]);
                            }
                            this.dialog.setPositiveBtnTag(actionButton);
                            this.dialog.setPositiveBtnClickListener(this.positiveBtnListener);
                        }
                    }
                }
            }
            AppMethodBeat.o(75942);
        }
    }

    /* Access modifiers changed, original: protected */
    public void continueDownload() {
        AppMethodBeat.i(75943);
        this.mSubMessageHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(75922);
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = TMOpenSDKToMsdkManager.this.getClient().getDownloadTaskState(TMOpenSDKToMsdkManager.this.mDownloadUrl);
                    if (downloadTaskState != null) {
                        Message message;
                        if (downloadTaskState.mState == 3) {
                            message = new Message();
                            message.what = 6;
                            Bundle bundle = new Bundle();
                            bundle.putLong("receiveDataLen", downloadTaskState.mReceiveDataLen);
                            bundle.putLong("totalDataLen", downloadTaskState.mTotalDataLen);
                            message.setData(bundle);
                            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                        } else if (downloadTaskState.mState == 4) {
                            message = new Message();
                            message.what = 0;
                            message.arg1 = 1;
                            message.obj = downloadTaskState.mSavePath;
                            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                        }
                    }
                    TipsInfoLog createTipsInfoLog;
                    if (downloadTaskState == null || downloadTaskState.mState != 4) {
                        createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                        createTipsInfoLog.downloadTipsCount++;
                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                        AppMethodBeat.o(75922);
                        return;
                    }
                    createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                    createTipsInfoLog.installTipsCount++;
                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                    AppMethodBeat.o(75922);
                } catch (Exception e) {
                    ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                    AppMethodBeat.o(75922);
                }
            }
        });
        AppMethodBeat.o(75943);
    }

    /* Access modifiers changed, original: protected */
    public void tryToCloseDialog() {
        AppMethodBeat.i(75944);
        if (this.mOpenSDK == null) {
            AppMethodBeat.o(75944);
        } else if (this.mContext == null) {
            AppMethodBeat.o(75944);
        } else {
            try {
                int checkQQDownloaderInstalled = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
                if (this.isInstallFinished && checkQQDownloaderInstalled == 0) {
                    this.mHttpRequest = null;
                    this.isInstallFinished = false;
                    this.mDownloadUrl = null;
                    if (this.dialog.isShowing()) {
                        this.dialog.dismiss();
                    }
                    TMAssistantDownloadSDKManager.closeAllService(this.mContext);
                    this.mClient = null;
                    if (isExitsAction(this.insertActionId)) {
                        this.mOpenSDK.startQQDownloader(this.mContext);
                    }
                }
                AppMethodBeat.o(75944);
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
                AppMethodBeat.o(75944);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean isExitsAction(long j) {
        AppMethodBeat.i(75945);
        if (j < 0) {
            AppMethodBeat.o(75945);
            return false;
        } else if (this.sdkChannel == null) {
            AppMethodBeat.o(75945);
            return false;
        } else {
            Iterator it = this.sdkChannel.getChannelDataItemList().iterator();
            while (it.hasNext()) {
                TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem) it.next();
                if (((long) tMAssistantSDKChannelDataItem.mDBIdentity) == j && tMAssistantSDKChannelDataItem.mDataItemEndTime - tMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000) {
                    AppMethodBeat.o(75945);
                    return true;
                }
            }
            AppMethodBeat.o(75945);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void handleInstall(String str, int i) {
        AppMethodBeat.i(75946);
        if (this.mContext == null) {
            AppMethodBeat.o(75946);
            return;
        }
        Res res = new Res(this.mContext);
        this.dialog.setPositiveBtnEnable(true);
        this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_install")));
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(75946);
            return;
        }
        this.isInstallFinished = true;
        if (i == 1) {
            AppMethodBeat.o(75946);
            return;
        }
        q.a(this.mContext, new File(str), null, false);
        AppMethodBeat.o(75946);
    }

    /* Access modifiers changed, original: protected */
    public void handleDownloadFailed() {
        AppMethodBeat.i(75947);
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(75947);
            return;
        }
        Res res = new Res(this.mContext);
        this.dialog.setPositiveBtnEnable(true);
        this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_retry")));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
        AppMethodBeat.o(75947);
    }

    /* Access modifiers changed, original: protected */
    public void handleDownloading(long j, long j2) {
        AppMethodBeat.i(75948);
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(75948);
            return;
        }
        String string = this.mContext.getString(new Res(this.mContext).string("white_list_positive_downloading"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j)) + 0.0f) / ((float) j2))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j) + 0.0f) / ((float) j2)) * ((float) this.dialog.downloadProgressBar.getMax())));
        TMLog.i(TAG, "handleDownloading : receivedlen:" + j + " | totalLen:" + j2);
        AppMethodBeat.o(75948);
    }

    /* Access modifiers changed, original: protected */
    public void handleDownloadContinue(long j, long j2) {
        AppMethodBeat.i(75949);
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(75949);
            return;
        }
        Res res = new Res(this.mContext);
        String string = this.mContext.getString(res.string("white_list_positive_continue"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j)) + 0.0f) / ((float) j2))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j) + 0.0f) / ((float) j2)) * ((float) this.dialog.downloadProgressBar.getMax())));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
        AppMethodBeat.o(75949);
    }

    /* Access modifiers changed, original: protected */
    public void startToQQDownloaderAuthorized(String str) {
        AppMethodBeat.i(75950);
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.mHttpRequest = null;
        this.isInstallFinished = false;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75950);
            return;
        }
        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
        createTipsInfoLog.authorizedBtnClickCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        if (!(this.mContext == null || this.mOpenSDK == null)) {
            this.mOpenSDK.startToAuthorized(this.mContext, str);
        }
        AppMethodBeat.o(75950);
    }

    /* Access modifiers changed, original: protected */
    public void startDownloadTask(final String str, final String str2) {
        AppMethodBeat.i(75951);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75951);
            return;
        }
        this.dialog.setPositiveBtnEnable(false);
        this.mSubMessageHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(75926);
                if (!(TMOpenSDKToMsdkManager.this.mContext == null || TMOpenSDKToMsdkManager.this.mOpenSDK == null || TextUtils.isEmpty(str2))) {
                    TMOpenSDKToMsdkManager.this.insertActionId = TMOpenSDKToMsdkManager.this.mOpenSDK.addDownloadTaskFromAuthorize(str2);
                }
                TMAssistantDownloadSDKClient client = TMOpenSDKToMsdkManager.this.getClient();
                if (client == null) {
                    AppMethodBeat.o(75926);
                    return;
                }
                try {
                    int startDownloadTask = client.startDownloadTask(str, "application/vnd.android.package-archive");
                    Message message;
                    if (4 == startDownloadTask) {
                        String str = client.getDownloadTaskState(str).mSavePath;
                        Message message2 = new Message();
                        message2.what = 0;
                        message2.obj = str;
                        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message2);
                    } else if (startDownloadTask == 0) {
                        TMLog.i(TMOpenSDKToMsdkManager.TAG, "start success!");
                    } else if (1 == startDownloadTask) {
                        message = new Message();
                        message.what = 5;
                        message.obj = Integer.valueOf(1);
                        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                    } else {
                        message = new Message();
                        message.what = 3;
                        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                    }
                    TipsInfoLog createTipsInfoLog;
                    if (startDownloadTask == 4) {
                        createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                        createTipsInfoLog.installBtnClickCount++;
                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                        AppMethodBeat.o(75926);
                        return;
                    }
                    createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                    createTipsInfoLog.downloadBtnClickCount++;
                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                    AppMethodBeat.o(75926);
                } catch (Exception e) {
                    ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                    AppMethodBeat.o(75926);
                }
            }
        });
        AppMethodBeat.o(75951);
    }

    /* Access modifiers changed, original: protected */
    public void pauseDownloadTask(final String str) {
        AppMethodBeat.i(75952);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75952);
        } else if (this.mAuthorizedInfo == null) {
            AppMethodBeat.o(75952);
        } else {
            this.mSubMessageHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(75927);
                    TMAssistantDownloadSDKClient client = TMOpenSDKToMsdkManager.this.getClient();
                    try {
                        if (client.getDownloadTaskState(str) != null) {
                            client.pauseDownloadTask(str);
                            AppMethodBeat.o(75927);
                            return;
                        }
                        TMLog.i(TMOpenSDKToMsdkManager.TAG, "getDownloadTaskState taskinfo is null!");
                        AppMethodBeat.o(75927);
                    } catch (Exception e) {
                        ab.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                        AppMethodBeat.o(75927);
                    }
                }
            });
            AppMethodBeat.o(75952);
        }
    }

    /* Access modifiers changed, original: protected */
    public TMAssistantDownloadSDKClient getClient() {
        AppMethodBeat.i(75953);
        if (this.mContext != null) {
            TMAssistantDownloadSDKClient downloadSDKClient;
            if (this.mClient == null) {
                downloadSDKClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient(CLIENT_NAME);
                downloadSDKClient.registerDownloadTaskListener(this.mDownloadSDKListener);
                this.mClient = downloadSDKClient;
            } else {
                downloadSDKClient = this.mClient;
            }
            AppMethodBeat.o(75953);
            return downloadSDKClient;
        }
        AppMethodBeat.o(75953);
        return null;
    }

    public static String about() {
        return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
    }
}
