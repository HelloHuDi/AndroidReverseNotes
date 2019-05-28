package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.util.TMLog;

public class QQDownloaderInstalled extends BroadcastReceiver {
    private static final String TAG = "QQDownloaderInstalled";
    protected static QQDownloaderInstalled mInstance = null;
    protected boolean isRegisted = false;
    protected IQQDownloaderInstalled mListener = null;

    public interface IQQDownloaderInstalled {
        void onQQDownloaderInstalled(Context context);
    }

    private QQDownloaderInstalled() {
    }

    public static synchronized QQDownloaderInstalled getInstance() {
        QQDownloaderInstalled qQDownloaderInstalled;
        synchronized (QQDownloaderInstalled.class) {
            AppMethodBeat.m2504i(75852);
            if (mInstance == null) {
                mInstance = new QQDownloaderInstalled();
            }
            qQDownloaderInstalled = mInstance;
            AppMethodBeat.m2505o(75852);
        }
        return qQDownloaderInstalled;
    }

    public void onReceive(final Context context, Intent intent) {
        AppMethodBeat.m2504i(75853);
        TMLog.m60588i(TAG, "onReceive!");
        new Thread() {
            public void run() {
                AppMethodBeat.m2504i(75851);
                if (QQDownloaderInstalled.this.mListener != null) {
                    QQDownloaderInstalled.this.mListener.onQQDownloaderInstalled(context);
                }
                AppMethodBeat.m2505o(75851);
            }
        }.start();
        AppMethodBeat.m2505o(75853);
    }

    public void registeReceiver(Context context) {
        AppMethodBeat.m2504i(75854);
        if (!this.isRegisted) {
            TMLog.m60588i(TAG, "registeReceiver   context" + context + "  receiver:" + this);
            try {
                this.isRegisted = true;
                AppMethodBeat.m2505o(75854);
                return;
            } catch (Throwable th) {
                TMLog.m60588i(TAG, "registeReceiver exception!!!");
                this.isRegisted = false;
                C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75854);
    }

    public void unRegisteReceiver(Context context) {
        AppMethodBeat.m2504i(75855);
        if (context == null || mInstance == null) {
            AppMethodBeat.m2505o(75855);
            return;
        }
        if (this.isRegisted) {
            TMLog.m60588i(TAG, "realy unRegisteReceiver  context:" + context + "  receiver:" + this);
            try {
                this.isRegisted = false;
                AppMethodBeat.m2505o(75855);
                return;
            } catch (Throwable th) {
                TMLog.m60588i(TAG, "unRegisteReceiver exception!!!");
                this.isRegisted = false;
                C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75855);
    }

    public void registeListener(IQQDownloaderInstalled iQQDownloaderInstalled) {
        this.mListener = iQQDownloaderInstalled;
    }

    public void unregisteListener() {
        this.mListener = null;
    }
}
