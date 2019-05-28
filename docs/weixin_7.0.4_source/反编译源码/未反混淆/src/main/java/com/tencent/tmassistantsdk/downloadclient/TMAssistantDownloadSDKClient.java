package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
    protected static final String TAG = "TMAssistantDownloadSDKClient";
    protected ReferenceQueue<ITMAssistantDownloadSDKClientListener> mListenerReferenceQueue;
    protected ArrayList<WeakReference<ITMAssistantDownloadSDKClientListener>> mWeakListenerArrayList;

    public TMAssistantDownloadSDKClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        AppMethodBeat.i(75635);
        this.mListenerReferenceQueue = new ReferenceQueue();
        this.mWeakListenerArrayList = new ArrayList();
        this.mServiceCallback = new Stub() {
            public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2) {
                AppMethodBeat.i(75633);
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadStateChanged,clientKey:" + str + ",state:" + i + ", errorcode" + i2 + ",url:" + str2);
                Iterator it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskStateChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, i, i2, str3, z, z2);
                }
                AppMethodBeat.o(75633);
            }

            public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j, long j2) {
                AppMethodBeat.i(75634);
                TMLog.i(TMAssistantDownloadSDKClient.TAG, "OnDownloadProgressChanged,clientKey:" + str + ",receivedLen:" + j + ",totalLen:" + j2 + ",url:" + str2);
                Iterator it = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) weakReference.get();
                    if (iTMAssistantDownloadSDKClientListener == null) {
                        TMLog.i(TMAssistantDownloadSDKClient.TAG, " listener = " + iTMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + weakReference);
                    }
                    TMAssistantDownloadSDKMessageThread.getInstance().postTaskProgressChangedMessage(TMAssistantDownloadSDKClient.this, iTMAssistantDownloadSDKClientListener, str2, j, j2);
                }
                AppMethodBeat.o(75634);
            }
        };
        AppMethodBeat.o(75635);
    }

    public synchronized TMAssistantDownloadTaskInfo getDownloadTaskState(String str) {
        TMAssistantDownloadTaskInfo downloadTaskInfo;
        AppMethodBeat.i(75636);
        TMLog.i(TAG, "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
            AppMethodBeat.o(75636);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            downloadTaskInfo = iTMAssistantDownloadSDKServiceInterface.getDownloadTaskInfo(this.mClientKey, str);
            AppMethodBeat.o(75636);
        } else {
            super.initTMAssistantDownloadSDK();
            downloadTaskInfo = null;
            AppMethodBeat.o(75636);
        }
        return downloadTaskInfo;
    }

    public synchronized int startDownloadTask(String str, String str2) {
        int startDownloadTask;
        AppMethodBeat.i(75637);
        startDownloadTask = startDownloadTask(str, "", 0, 0, str2, null, true, null);
        AppMethodBeat.o(75637);
        return startDownloadTask;
    }

    public synchronized int startDownloadTask(String str, String str2, Map<String, String> map) {
        int startDownloadTask;
        AppMethodBeat.i(75638);
        startDownloadTask = startDownloadTask(str, "", 0, 0, str2, null, true, map);
        AppMethodBeat.o(75638);
        return startDownloadTask;
    }

    public synchronized int startDownloadTask(String str, String str2, String str3) {
        int startDownloadTask;
        AppMethodBeat.i(75639);
        startDownloadTask = startDownloadTask(str, "", 0, 0, str2, str3, true, null);
        AppMethodBeat.o(75639);
        return startDownloadTask;
    }

    public synchronized int startDownloadTask(String str, String str2, long j, int i, String str3, String str4, boolean z, Map<String, String> map) {
        int startDownloadTask;
        AppMethodBeat.i(75640);
        TMLog.i(TAG, "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + str + ",contentType:" + str3);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
            AppMethodBeat.o(75640);
            throw illegalArgumentException;
        }
        if (str3.equals("resource/tm.android.unknown") && TextUtils.isEmpty(str4)) {
            illegalArgumentException = new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
            AppMethodBeat.o(75640);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
            startDownloadTask = iTMAssistantDownloadSDKServiceInterface.startDownloadTask(this.mClientKey, str, str2, j, 0, str3, str4, map);
            AppMethodBeat.o(75640);
        } else {
            TMLog.i(TAG, "startDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
            startDownloadTask = 0;
            AppMethodBeat.o(75640);
        }
        return startDownloadTask;
    }

    public synchronized void pauseDownloadTask(String str) {
        AppMethodBeat.i(75641);
        TMLog.i(TAG, "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
            AppMethodBeat.o(75641);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.pauseDownloadTask(this.mClientKey, str);
            AppMethodBeat.o(75641);
        } else {
            TMLog.i(TAG, "pauseDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.o(75641);
        }
    }

    public synchronized void cancelDownloadTask(String str) {
        AppMethodBeat.i(75642);
        TMLog.i(TAG, "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + str);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
            AppMethodBeat.o(75642);
            throw illegalArgumentException;
        }
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.cancelDownloadTask(this.mClientKey, str);
            AppMethodBeat.o(75642);
        } else {
            TMLog.i(TAG, "cancelDownloadTask, serviceInterface is null");
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.o(75642);
        }
    }

    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r2 = r4.mWeakListenerArrayList.iterator();
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code skipped:
            if (r2.hasNext() == false) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:22:0x0045, code skipped:
            if (((com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener) ((java.lang.ref.WeakReference) r2.next()).get()) != r5) goto L_0x0033;
     */
    /* JADX WARNING: Missing block: B:23:0x0047, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(75643);
            r0 = true;
     */
    /* JADX WARNING: Missing block: B:24:0x004f, code skipped:
            r4.mWeakListenerArrayList.add(new java.lang.ref.WeakReference(r5, r4.mListenerReferenceQueue));
            com.tencent.matrix.trace.core.AppMethodBeat.o(75643);
     */
    /* JADX WARNING: Missing block: B:25:0x0061, code skipped:
            r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean registerDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        AppMethodBeat.i(75643);
        if (iTMAssistantDownloadSDKClientListener != null) {
            while (true) {
                Reference poll = this.mListenerReferenceQueue.poll();
                if (poll == null) {
                    break;
                }
                TMLog.i(TAG, "registerDownloadTaskListener removed listener!!!!");
                this.mWeakListenerArrayList.remove(poll);
            }
        } else {
            z = false;
            AppMethodBeat.o(75643);
        }
        return z;
    }

    public synchronized boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        boolean z;
        AppMethodBeat.i(75644);
        if (iTMAssistantDownloadSDKClientListener == null) {
            AppMethodBeat.o(75644);
            z = false;
        } else {
            Iterator it = this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (((ITMAssistantDownloadSDKClientListener) weakReference.get()) == iTMAssistantDownloadSDKClientListener) {
                    this.mWeakListenerArrayList.remove(weakReference);
                    z = true;
                    AppMethodBeat.o(75644);
                    break;
                }
            }
            AppMethodBeat.o(75644);
            z = false;
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    public void onDownloadSDKServiceInvalid() {
        AppMethodBeat.i(75645);
        Iterator it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadSDKMessageThread.getInstance().postSDKServiceInvalidMessage(this, (ITMAssistantDownloadSDKClientListener) ((WeakReference) it.next()).get());
        }
        AppMethodBeat.o(75645);
    }

    /* Access modifiers changed, original: protected */
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.i(75646);
        this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(iBinder);
        AppMethodBeat.o(75646);
    }

    /* Access modifiers changed, original: protected */
    public void registerServiceCallback() {
        AppMethodBeat.i(75647);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(75647);
    }

    /* Access modifiers changed, original: protected */
    public Intent getBindServiceIntent() {
        AppMethodBeat.i(75648);
        Intent intent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
        AppMethodBeat.o(75648);
        return intent;
    }

    /* Access modifiers changed, original: protected */
    public void unRegisterServiceCallback() {
        AppMethodBeat.i(75649);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(75649);
    }

    public static String about() {
        return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
    }
}
