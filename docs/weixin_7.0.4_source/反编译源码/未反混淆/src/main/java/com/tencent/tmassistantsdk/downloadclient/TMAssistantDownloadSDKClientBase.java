package com.tencent.tmassistantsdk.downloadclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.util.TMLog;

public abstract class TMAssistantDownloadSDKClientBase implements ServiceConnection {
    public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
    public static final String CONNTECTSTATE_FINISH = "FINISH";
    public static final String CONNTECTSTATE_INIT = "INIT";
    protected static final String TAG = "TMAssistantDownloadSDKClient";
    protected String connectState = CONNTECTSTATE_INIT;
    public String mClientKey;
    protected Context mContext;
    protected String mDwonloadServiceName = null;
    protected IInterface mServiceCallback = null;
    protected IInterface mServiceInterface = null;
    protected final Object mThreadlock = new Object();

    public abstract Intent getBindServiceIntent();

    public abstract void onDownloadSDKServiceInvalid();

    public abstract void registerServiceCallback();

    public abstract void stubAsInterface(IBinder iBinder);

    public abstract void unRegisterServiceCallback();

    public TMAssistantDownloadSDKClientBase(Context context, String str, String str2) {
        this.mContext = context;
        this.mClientKey = str;
        this.mDwonloadServiceName = str2;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        TMLog.i(TAG, "onServiceDisconnected,clientKey:" + this.mClientKey);
        synchronized (this) {
            this.mServiceInterface = null;
            this.connectState = CONNTECTSTATE_INIT;
            synchronized (this.mThreadlock) {
                this.mThreadlock.notifyAll();
            }
            onDownloadSDKServiceInvalid();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        stubAsInterface(iBinder);
        this.connectState = CONNTECTSTATE_FINISH;
        synchronized (this.mThreadlock) {
            this.mThreadlock.notifyAll();
        }
        TMLog.i(TAG, "onServiceConnected,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + iBinder + ",threadId:" + Thread.currentThread().getId());
        try {
            if (this.mServiceInterface != null && this.mServiceCallback != null) {
                registerServiceCallback();
            }
        } catch (RemoteException e) {
            TMLog.i(TAG, "onServiceConnected, exception : " + e.getMessage());
            onDownloadSDKServiceInvalid();
        }
    }

    public synchronized boolean initTMAssistantDownloadSDK() {
        boolean z = false;
        synchronized (this) {
            TMLog.i(TAG, "connectState = " + this.connectState);
            if (this.connectState != CONNTECTSTATE_INIT) {
                z = true;
            } else {
                TMLog.i(TAG, "initTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
                this.connectState = CONNTECTSTATE_INIT;
                if (this.mServiceInterface != null) {
                    this.connectState = CONNTECTSTATE_FINISH;
                    z = true;
                } else if (!(this.mContext == null || this.mDwonloadServiceName == null)) {
                    try {
                        z = this.mContext.bindService(getBindServiceIntent(), this, 1);
                    } catch (Exception e) {
                        ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    }
                    TMLog.i(TAG, "initTMAssistantDownloadSDK bindResult:".concat(String.valueOf(z)));
                }
            }
        }
        return z;
    }

    public synchronized void unInitTMAssistantDownloadSDK() {
        TMLog.i(TAG, "unInitTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
        if (!(this.mServiceInterface == null || this.mServiceCallback == null)) {
            try {
                unRegisterServiceCallback();
            } catch (RemoteException e) {
            }
        }
        if (!(this.mContext == null || this.mServiceInterface == null)) {
            this.mContext.unbindService(this);
        }
        this.mServiceInterface = null;
        this.mServiceCallback = null;
        this.connectState = CONNTECTSTATE_INIT;
    }

    /* Access modifiers changed, original: protected */
    public IInterface getServiceInterface() {
        if (this.mContext == null || this.mContext.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
            if (this.mServiceInterface == null) {
                initTMAssistantDownloadSDK();
                this.connectState = CONNTECTSTATE_CONNECTING;
                synchronized (this.mThreadlock) {
                    this.mThreadlock.wait(10000);
                }
            }
            if (this.mServiceInterface != null) {
                return this.mServiceInterface;
            }
            throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
        }
        throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
}
