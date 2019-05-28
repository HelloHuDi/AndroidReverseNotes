package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver extends BroadcastReceiver {
    protected static final int MSG_DELAY_TIME = 3500;
    protected static final int MSG_resumeDownloadTime = 67;
    protected static final String TAG = "NetworkMonitorReceiver";
    protected static NetworkMonitorReceiver mInstance = null;
    protected boolean isRegisterReceiver = false;
    protected final C7306ak mNetworkChangedHandler = new C244381();
    ArrayList<INetworkChangedObserver> mObs = new ArrayList();

    public interface INetworkChangedObserver {
        void onNetworkChanged();
    }

    /* renamed from: com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver$1 */
    class C244381 extends C7306ak {
        C244381() {
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(75770);
            super.handleMessage(message);
            switch (message.what) {
                case 67:
                    NetworkMonitorReceiver.this.notifyNetworkChanged();
                    break;
            }
            AppMethodBeat.m2505o(75770);
        }
    }

    public NetworkMonitorReceiver() {
        AppMethodBeat.m2504i(75771);
        AppMethodBeat.m2505o(75771);
    }

    public static synchronized NetworkMonitorReceiver getInstance() {
        NetworkMonitorReceiver networkMonitorReceiver;
        synchronized (NetworkMonitorReceiver.class) {
            AppMethodBeat.m2504i(75772);
            if (mInstance == null) {
                mInstance = new NetworkMonitorReceiver();
            }
            networkMonitorReceiver = mInstance;
            AppMethodBeat.m2505o(75772);
        }
        return networkMonitorReceiver;
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(75773);
        TMLog.m60588i(TAG, "network changed!");
        this.mNetworkChangedHandler.removeMessages(67);
        Message obtain = Message.obtain();
        obtain.what = 67;
        this.mNetworkChangedHandler.sendMessageDelayed(obtain, 3500);
        AppMethodBeat.m2505o(75773);
    }

    public void registerReceiver() {
        AppMethodBeat.m2504i(75774);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.m2505o(75774);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(this, intentFilter);
            this.isRegisterReceiver = true;
            AppMethodBeat.m2505o(75774);
        } catch (Throwable th) {
            this.isRegisterReceiver = false;
            C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.m2505o(75774);
        }
    }

    public void unregisterReceiver() {
        AppMethodBeat.m2504i(75775);
        if (mInstance == null) {
            AppMethodBeat.m2505o(75775);
            return;
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.m2505o(75775);
            return;
        }
        try {
            if (this.isRegisterReceiver) {
                context.unregisterReceiver(this);
                this.isRegisterReceiver = false;
            }
            AppMethodBeat.m2505o(75775);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.m2505o(75775);
        }
    }

    public void addNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        AppMethodBeat.m2504i(75776);
        if (!(this.mObs.contains(iNetworkChangedObserver) || iNetworkChangedObserver == null)) {
            this.mObs.add(iNetworkChangedObserver);
        }
        AppMethodBeat.m2505o(75776);
    }

    public void removeNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        AppMethodBeat.m2504i(75777);
        if (iNetworkChangedObserver != null) {
            this.mObs.remove(iNetworkChangedObserver);
        }
        AppMethodBeat.m2505o(75777);
    }

    public void notifyNetworkChanged() {
        AppMethodBeat.m2504i(75778);
        Iterator it = this.mObs.iterator();
        while (it.hasNext()) {
            ((INetworkChangedObserver) it.next()).onNetworkChanged();
        }
        AppMethodBeat.m2505o(75778);
    }
}
