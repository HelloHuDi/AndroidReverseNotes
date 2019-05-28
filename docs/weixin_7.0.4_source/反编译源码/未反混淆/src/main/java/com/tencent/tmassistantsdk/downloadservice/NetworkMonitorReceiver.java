package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
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
    protected final ak mNetworkChangedHandler = new ak() {
        public void handleMessage(Message message) {
            AppMethodBeat.i(75770);
            super.handleMessage(message);
            switch (message.what) {
                case 67:
                    NetworkMonitorReceiver.this.notifyNetworkChanged();
                    break;
            }
            AppMethodBeat.o(75770);
        }
    };
    ArrayList<INetworkChangedObserver> mObs = new ArrayList();

    public interface INetworkChangedObserver {
        void onNetworkChanged();
    }

    public NetworkMonitorReceiver() {
        AppMethodBeat.i(75771);
        AppMethodBeat.o(75771);
    }

    public static synchronized NetworkMonitorReceiver getInstance() {
        NetworkMonitorReceiver networkMonitorReceiver;
        synchronized (NetworkMonitorReceiver.class) {
            AppMethodBeat.i(75772);
            if (mInstance == null) {
                mInstance = new NetworkMonitorReceiver();
            }
            networkMonitorReceiver = mInstance;
            AppMethodBeat.o(75772);
        }
        return networkMonitorReceiver;
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(75773);
        TMLog.i(TAG, "network changed!");
        this.mNetworkChangedHandler.removeMessages(67);
        Message obtain = Message.obtain();
        obtain.what = 67;
        this.mNetworkChangedHandler.sendMessageDelayed(obtain, 3500);
        AppMethodBeat.o(75773);
    }

    public void registerReceiver() {
        AppMethodBeat.i(75774);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.o(75774);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(this, intentFilter);
            this.isRegisterReceiver = true;
            AppMethodBeat.o(75774);
        } catch (Throwable th) {
            this.isRegisterReceiver = false;
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(75774);
        }
    }

    public void unregisterReceiver() {
        AppMethodBeat.i(75775);
        if (mInstance == null) {
            AppMethodBeat.o(75775);
            return;
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.o(75775);
            return;
        }
        try {
            if (this.isRegisterReceiver) {
                context.unregisterReceiver(this);
                this.isRegisterReceiver = false;
            }
            AppMethodBeat.o(75775);
        } catch (Throwable th) {
            ab.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(75775);
        }
    }

    public void addNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        AppMethodBeat.i(75776);
        if (!(this.mObs.contains(iNetworkChangedObserver) || iNetworkChangedObserver == null)) {
            this.mObs.add(iNetworkChangedObserver);
        }
        AppMethodBeat.o(75776);
    }

    public void removeNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        AppMethodBeat.i(75777);
        if (iNetworkChangedObserver != null) {
            this.mObs.remove(iNetworkChangedObserver);
        }
        AppMethodBeat.o(75777);
    }

    public void notifyNetworkChanged() {
        AppMethodBeat.i(75778);
        Iterator it = this.mObs.iterator();
        while (it.hasNext()) {
            ((INetworkChangedObserver) it.next()).onNetworkChanged();
        }
        AppMethodBeat.o(75778);
    }
}
