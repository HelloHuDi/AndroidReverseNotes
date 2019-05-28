package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadStateChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "DownloadStateChangedReceiver";
    protected static DownloadStateChangedReceiver mInstance = null;
    protected C7306ak handler = null;
    protected HandlerThread handlerThread = new HandlerThread("downloadStateChangedThread");
    protected boolean isRegisted = false;
    ArrayList<IDownloadStateChangedListener> mListeners = new ArrayList();

    public DownloadStateChangedReceiver() {
        AppMethodBeat.m2504i(75840);
        this.handlerThread.start();
        this.handler = new C7306ak(this.handlerThread.getLooper());
        AppMethodBeat.m2505o(75840);
    }

    public static synchronized DownloadStateChangedReceiver getInstance() {
        DownloadStateChangedReceiver downloadStateChangedReceiver;
        synchronized (DownloadStateChangedReceiver.class) {
            AppMethodBeat.m2504i(75841);
            if (mInstance == null) {
                mInstance = new DownloadStateChangedReceiver();
            }
            downloadStateChangedReceiver = mInstance;
            AppMethodBeat.m2505o(75841);
        }
        return downloadStateChangedReceiver;
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.m2504i(75842);
        if (this.handler != null) {
            this.handler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(75839);
                    TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
                    tMQQDownloaderStateChangeParam.hostPackageName = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_PAGECKAGENAME);
                    tMQQDownloaderStateChangeParam.hostVersion = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_VERSION);
                    tMQQDownloaderStateChangeParam.taskId = intent.getStringExtra("taskId");
                    tMQQDownloaderStateChangeParam.errorCode = C5046bo.getInt(intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE), 0);
                    tMQQDownloaderStateChangeParam.errorMsg = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                    tMQQDownloaderStateChangeParam.state = C5046bo.getInt(intent.getStringExtra("state"), 0);
                    TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
                    tMQQDownloaderOpenSDKParam.SNGAppId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_SNGAPPID);
                    tMQQDownloaderOpenSDKParam.taskAppId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                    tMQQDownloaderOpenSDKParam.taskApkId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                    tMQQDownloaderOpenSDKParam.taskPackageName = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                    tMQQDownloaderOpenSDKParam.taskVersion = C5046bo.getInt(intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_VERSION), 0);
                    tMQQDownloaderOpenSDKParam.via = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_VIA);
                    tMQQDownloaderOpenSDKParam.uin = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UIN);
                    tMQQDownloaderOpenSDKParam.uinType = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                    tMQQDownloaderStateChangeParam.param = tMQQDownloaderOpenSDKParam;
                    Iterator it = DownloadStateChangedReceiver.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((IDownloadStateChangedListener) it.next()).onDownloadStateChanged(tMQQDownloaderStateChangeParam);
                    }
                    AppMethodBeat.m2505o(75839);
                }
            });
        }
        AppMethodBeat.m2505o(75842);
    }

    public void registeReceiver(Context context) {
        AppMethodBeat.m2504i(75843);
        if (!this.isRegisted) {
            TMLog.m60588i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                TMLog.m60588i(TAG, String.valueOf(context.registerReceiver(this, new IntentFilter(OpenSDKTool4Assistant.OPENSDK_ACTION_NAME))));
                this.isRegisted = true;
                AppMethodBeat.m2505o(75843);
                return;
            } catch (Throwable th) {
                TMLog.m60588i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75843);
    }

    public void unRegisteReceiver(Context context) {
        AppMethodBeat.m2504i(75844);
        if (context == null || mInstance == null) {
            AppMethodBeat.m2505o(75844);
            return;
        }
        if (this.isRegisted) {
            TMLog.m60588i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                context.unregisterReceiver(this);
                this.isRegisted = false;
                AppMethodBeat.m2505o(75844);
                return;
            } catch (Throwable th) {
                TMLog.m60588i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75844);
    }

    public void addDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        AppMethodBeat.m2504i(75845);
        if (!(iDownloadStateChangedListener == null || this.mListeners.contains(iDownloadStateChangedListener))) {
            this.mListeners.add(iDownloadStateChangedListener);
        }
        AppMethodBeat.m2505o(75845);
    }

    public void removeDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        AppMethodBeat.m2504i(75846);
        if (iDownloadStateChangedListener != null) {
            this.mListeners.remove(iDownloadStateChangedListener);
        }
        AppMethodBeat.m2505o(75846);
    }
}
