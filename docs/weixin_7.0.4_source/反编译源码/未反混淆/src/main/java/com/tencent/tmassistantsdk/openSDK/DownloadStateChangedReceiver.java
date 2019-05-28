package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadStateChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "DownloadStateChangedReceiver";
    protected static DownloadStateChangedReceiver mInstance = null;
    protected ak handler = null;
    protected HandlerThread handlerThread = new HandlerThread("downloadStateChangedThread");
    protected boolean isRegisted = false;
    ArrayList<IDownloadStateChangedListener> mListeners = new ArrayList();

    public DownloadStateChangedReceiver() {
        AppMethodBeat.i(75840);
        this.handlerThread.start();
        this.handler = new ak(this.handlerThread.getLooper());
        AppMethodBeat.o(75840);
    }

    public static synchronized DownloadStateChangedReceiver getInstance() {
        DownloadStateChangedReceiver downloadStateChangedReceiver;
        synchronized (DownloadStateChangedReceiver.class) {
            AppMethodBeat.i(75841);
            if (mInstance == null) {
                mInstance = new DownloadStateChangedReceiver();
            }
            downloadStateChangedReceiver = mInstance;
            AppMethodBeat.o(75841);
        }
        return downloadStateChangedReceiver;
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.i(75842);
        if (this.handler != null) {
            this.handler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(75839);
                    TMQQDownloaderStateChangeParam tMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
                    tMQQDownloaderStateChangeParam.hostPackageName = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_PAGECKAGENAME);
                    tMQQDownloaderStateChangeParam.hostVersion = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_HOST_VERSION);
                    tMQQDownloaderStateChangeParam.taskId = intent.getStringExtra("taskId");
                    tMQQDownloaderStateChangeParam.errorCode = bo.getInt(intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_CODE), 0);
                    tMQQDownloaderStateChangeParam.errorMsg = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                    tMQQDownloaderStateChangeParam.state = bo.getInt(intent.getStringExtra("state"), 0);
                    TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam();
                    tMQQDownloaderOpenSDKParam.SNGAppId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_SNGAPPID);
                    tMQQDownloaderOpenSDKParam.taskAppId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                    tMQQDownloaderOpenSDKParam.taskApkId = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                    tMQQDownloaderOpenSDKParam.taskPackageName = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                    tMQQDownloaderOpenSDKParam.taskVersion = bo.getInt(intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_TASK_VERSION), 0);
                    tMQQDownloaderOpenSDKParam.via = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_VIA);
                    tMQQDownloaderOpenSDKParam.uin = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UIN);
                    tMQQDownloaderOpenSDKParam.uinType = intent.getStringExtra(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                    tMQQDownloaderStateChangeParam.param = tMQQDownloaderOpenSDKParam;
                    Iterator it = DownloadStateChangedReceiver.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((IDownloadStateChangedListener) it.next()).onDownloadStateChanged(tMQQDownloaderStateChangeParam);
                    }
                    AppMethodBeat.o(75839);
                }
            });
        }
        AppMethodBeat.o(75842);
    }

    public void registeReceiver(Context context) {
        AppMethodBeat.i(75843);
        if (!this.isRegisted) {
            TMLog.i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                TMLog.i(TAG, String.valueOf(context.registerReceiver(this, new IntentFilter(OpenSDKTool4Assistant.OPENSDK_ACTION_NAME))));
                this.isRegisted = true;
                AppMethodBeat.o(75843);
                return;
            } catch (Throwable th) {
                TMLog.i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                ab.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(75843);
    }

    public void unRegisteReceiver(Context context) {
        AppMethodBeat.i(75844);
        if (context == null || mInstance == null) {
            AppMethodBeat.o(75844);
            return;
        }
        if (this.isRegisted) {
            TMLog.i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                context.unregisterReceiver(this);
                this.isRegisted = false;
                AppMethodBeat.o(75844);
                return;
            } catch (Throwable th) {
                TMLog.i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                ab.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(75844);
    }

    public void addDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        AppMethodBeat.i(75845);
        if (!(iDownloadStateChangedListener == null || this.mListeners.contains(iDownloadStateChangedListener))) {
            this.mListeners.add(iDownloadStateChangedListener);
        }
        AppMethodBeat.o(75845);
    }

    public void removeDownloadStateChangedListener(IDownloadStateChangedListener iDownloadStateChangedListener) {
        AppMethodBeat.i(75846);
        if (iDownloadStateChangedListener != null) {
            this.mListeners.remove(iDownloadStateChangedListener);
        }
        AppMethodBeat.o(75846);
    }
}
