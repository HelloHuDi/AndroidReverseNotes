package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback.Stub;
import com.samsung.android.bezelinteraction.IBezelManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SlookBezelInteraction {
    public static final String SERVICE_NAME = "BezelInteractionService";
    private static final String TAG = "SlookBezelInteraction";
    private static Context mContext = null;
    private static IBezelManager mService = null;
    private final CopyOnWriteArrayList<BezelListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList();

    public interface BezelListener {
        void onItemSelected(BezelEvent bezelEvent);
    }

    static class BezelListenerDelegate extends Stub {
        public Handler mHandler;
        public BezelListener mListener;

        static class ListenerHandler extends Handler {
            public BezelListener mListener = null;

            public ListenerHandler(Looper looper, BezelListener bezelListener) {
                super(looper);
                this.mListener = bezelListener;
            }

            public void handleMessage(Message message) {
                AppMethodBeat.m2504i(117212);
                if (this.mListener != null) {
                    BezelEvent bezelEvent = (BezelEvent) message.obj;
                    if (bezelEvent != null) {
                        this.mListener.onItemSelected(bezelEvent);
                    }
                }
                AppMethodBeat.m2505o(117212);
            }
        }

        BezelListenerDelegate(BezelListener bezelListener, Handler handler) {
            AppMethodBeat.m2504i(117209);
            this.mListener = bezelListener;
            this.mHandler = new ListenerHandler(handler == null ? SlookBezelInteraction.mContext.getMainLooper() : handler.getLooper(), this.mListener);
            AppMethodBeat.m2505o(117209);
        }

        public BezelListener getListener() {
            return this.mListener;
        }

        public void onBezelCallback(BezelEvent bezelEvent) {
            AppMethodBeat.m2504i(117210);
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = bezelEvent;
            this.mHandler.sendMessage(obtain);
            AppMethodBeat.m2505o(117210);
        }

        public String getListenerInfo() {
            AppMethodBeat.m2504i(117211);
            String obj = this.mListener.toString();
            AppMethodBeat.m2505o(117211);
            return obj;
        }
    }

    public SlookBezelInteraction(Context context) {
        AppMethodBeat.m2504i(117204);
        mContext = context;
        getService();
        AppMethodBeat.m2505o(117204);
    }

    private synchronized IBezelManager getService() {
        IBezelManager iBezelManager;
        AppMethodBeat.m2504i(117205);
        if (mService == null) {
            mService = IBezelManager.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        } else if (!mService.asBinder().isBinderAlive()) {
            mService = IBezelManager.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        }
        iBezelManager = mService;
        AppMethodBeat.m2505o(117205);
        return iBezelManager;
    }

    public final void registerListener(BezelListener bezelListener) {
        AppMethodBeat.m2504i(117206);
        if (bezelListener == null) {
            AppMethodBeat.m2505o(117206);
            return;
        }
        synchronized (this.mListenerDelegates) {
            try {
                IBinder iBinder;
                Iterator it = this.mListenerDelegates.iterator();
                while (it.hasNext()) {
                    iBinder = (BezelListenerDelegate) it.next();
                    if (iBinder.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                iBinder = null;
                if (iBinder == null) {
                    iBinder = new BezelListenerDelegate(bezelListener, null);
                    this.mListenerDelegates.add(iBinder);
                }
                try {
                    IBezelManager service = getService();
                    if (service != null) {
                        service.registerCallback(iBinder, new ComponentName(mContext.getPackageName(), mContext.getClass().getCanonicalName()));
                    }
                } catch (RemoteException e) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117206);
            }
        }
    }

    public final void unregisterListener(BezelListener bezelListener) {
        AppMethodBeat.m2504i(117207);
        if (bezelListener == null) {
            AppMethodBeat.m2505o(117207);
            return;
        }
        synchronized (this.mListenerDelegates) {
            try {
                IBinder iBinder;
                Iterator it = this.mListenerDelegates.iterator();
                while (it.hasNext()) {
                    iBinder = (BezelListenerDelegate) it.next();
                    if (iBinder.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                iBinder = null;
                if (iBinder == null) {
                } else {
                    try {
                        IBezelManager service = getService();
                        if (service != null && service.unregisterCallback(iBinder)) {
                            this.mListenerDelegates.remove(iBinder);
                            iBinder.mHandler = null;
                            iBinder.mListener = null;
                        }
                    } catch (RemoteException e) {
                    }
                    AppMethodBeat.m2505o(117207);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117207);
            }
        }
    }

    public final void enableBezelInteraction(boolean z) {
        AppMethodBeat.m2504i(117208);
        try {
            IBezelManager service = getService();
            if (service != null) {
                service.enableBezelInteraction(z);
            }
            AppMethodBeat.m2505o(117208);
        } catch (RemoteException e) {
            AppMethodBeat.m2505o(117208);
        }
    }
}
