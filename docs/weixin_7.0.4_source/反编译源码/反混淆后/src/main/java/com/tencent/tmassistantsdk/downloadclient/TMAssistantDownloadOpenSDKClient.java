package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p804b.p805a.p806a.C37311b;
import com.tencent.p804b.p805a.p806a.C37311b.C17720a;
import com.tencent.p804b.p805a.p806a.C45078a;
import com.tencent.p804b.p805a.p806a.C45078a.C17719a;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadOpenSDKClient extends TMAssistantDownloadSDKClientBase {
    protected static final String TAG = "TMAssistantDownloadOpenSDKClient";
    ArrayList<IAssistantOnActionListener> mListeners;
    protected boolean retryBindResult;
    protected int retryCount;

    /* renamed from: com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient$1 */
    class C244361 extends C17720a {
        C244361() {
        }

        public void onActionResult(byte[] bArr) {
            AppMethodBeat.m2504i(75621);
            TMLog.m60588i(TMAssistantDownloadOpenSDKClient.TAG, "onActionResult  callBack data:" + bArr + "  mListeners.size:" + TMAssistantDownloadOpenSDKClient.this.mListeners.size());
            TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(bArr, TMAssistantDownloadOpenSDKClient.this.mListeners);
            AppMethodBeat.m2505o(75621);
        }
    }

    public TMAssistantDownloadOpenSDKClient(Context context, String str, String str2) {
        super(context, str, str2);
        AppMethodBeat.m2504i(75623);
        this.retryBindResult = false;
        this.retryCount = 0;
        this.mListeners = new ArrayList();
        this.mServiceCallback = new C244361();
        AppMethodBeat.m2505o(75623);
    }

    public byte[] sendSyncData(byte[] bArr) {
        AppMethodBeat.m2504i(75624);
        if (!TextUtils.isEmpty(this.mClientKey)) {
            C45078a c45078a = (C45078a) super.getServiceInterface();
            if (c45078a != null) {
                byte[] c = c45078a.mo19811c(this.mClientKey, bArr);
                AppMethodBeat.m2505o(75624);
                return c;
            }
        }
        AppMethodBeat.m2505o(75624);
        return null;
    }

    public void sendAsyncData(byte[] bArr) {
        AppMethodBeat.m2504i(75625);
        if (!TextUtils.isEmpty(this.mClientKey)) {
            C45078a c45078a = (C45078a) super.getServiceInterface();
            if (c45078a != null) {
                c45078a.mo19812d(this.mClientKey, bArr);
            }
        }
        AppMethodBeat.m2505o(75625);
    }

    public void addAssistantOnActionListener(IAssistantOnActionListener iAssistantOnActionListener) {
        AppMethodBeat.m2504i(75626);
        TMLog.m60588i(TAG, "addAssistantOnActionListener");
        if (!(iAssistantOnActionListener == null || this.mListeners.contains(iAssistantOnActionListener))) {
            this.mListeners.add(iAssistantOnActionListener);
        }
        AppMethodBeat.m2505o(75626);
    }

    /* Access modifiers changed, original: protected */
    public void onDownloadSDKServiceInvalid() {
        AppMethodBeat.m2504i(75627);
        if (this.mListeners != null && this.mListeners.size() > 0) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                IAssistantOnActionListener iAssistantOnActionListener = (IAssistantOnActionListener) it.next();
                if (iAssistantOnActionListener != null) {
                    iAssistantOnActionListener.onDownloadSDKServiceInvalid();
                }
            }
        }
        AppMethodBeat.m2505o(75627);
    }

    /* Access modifiers changed, original: protected */
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.m2504i(75628);
        this.mServiceInterface = C17719a.m27644j(iBinder);
        AppMethodBeat.m2505o(75628);
    }

    /* Access modifiers changed, original: protected */
    public void registerServiceCallback() {
        AppMethodBeat.m2504i(75629);
        String encodeToString = Base64.encodeToString(new Cryptor().encrypt(String.valueOf(System.currentTimeMillis()).getBytes(), this.mClientKey.getBytes()), 0);
        int a = ((C45078a) this.mServiceInterface).mo19809a(this.mClientKey, encodeToString, (C37311b) this.mServiceCallback);
        TMLog.m60588i(TAG, "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + encodeToString + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + a);
        if (a == 2) {
            onDownloadSDKServiceInvalid();
        }
        AppMethodBeat.m2505o(75629);
    }

    /* Access modifiers changed, original: protected */
    public Intent getBindServiceIntent() {
        AppMethodBeat.m2504i(75630);
        Intent intent = new Intent(this.mDwonloadServiceName);
        intent.setPackage("com.tencent.android.qqdownloader");
        AppMethodBeat.m2505o(75630);
        return intent;
    }

    /* Access modifiers changed, original: protected */
    public void unRegisterServiceCallback() {
        AppMethodBeat.m2504i(75631);
        if (((C45078a) this.mServiceInterface).mo19808a((C37311b) this.mServiceCallback) == 2) {
            onDownloadSDKServiceInvalid();
        }
        AppMethodBeat.m2505o(75631);
    }

    public synchronized boolean initTMAssistantDownloadSDK() {
        boolean initTMAssistantDownloadSDK;
        AppMethodBeat.m2504i(75632);
        initTMAssistantDownloadSDK = super.initTMAssistantDownloadSDK();
        TMLog.m60588i(TAG, "initTMAssistantDownloadSDK bindResult:".concat(String.valueOf(initTMAssistantDownloadSDK)));
        if (!initTMAssistantDownloadSDK) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
                intent.addFlags(268435456);
                this.mContext.startActivity(intent);
            } catch (Exception e) {
                TMLog.m60590w(TAG, "retry bind service startActivity Exception:" + e.toString());
            }
            HandlerThread handlerThread = new HandlerThread("retry_thread");
            handlerThread.start();
            final Handler handler = new Handler(handlerThread.getLooper());
            handler.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(75622);
                    try {
                        Intent bindServiceIntent = TMAssistantDownloadOpenSDKClient.this.getBindServiceIntent();
                        TMAssistantDownloadOpenSDKClient.this.retryBindResult = TMAssistantDownloadOpenSDKClient.this.mContext.bindService(bindServiceIntent, TMAssistantDownloadOpenSDKClient.this, 1);
                    } catch (Exception e) {
                        TMLog.m60587e(TMAssistantDownloadOpenSDKClient.TAG, "retry bind service Exception:" + e.toString());
                    }
                    TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient = TMAssistantDownloadOpenSDKClient.this;
                    tMAssistantDownloadOpenSDKClient.retryCount++;
                    TMLog.m60588i(TMAssistantDownloadOpenSDKClient.TAG, "retry bind service! retryBindResult:" + TMAssistantDownloadOpenSDKClient.this.retryBindResult + ",retryCount:" + TMAssistantDownloadOpenSDKClient.this.retryCount);
                    if (!TMAssistantDownloadOpenSDKClient.this.retryBindResult && TMAssistantDownloadOpenSDKClient.this.retryCount < 3) {
                        handler.postDelayed(this, 1000);
                    }
                    AppMethodBeat.m2505o(75622);
                }
            }, 1000);
        }
        AppMethodBeat.m2505o(75632);
        return initTMAssistantDownloadSDK;
    }

    public static String about() {
        return "TMAssistantDownloadOpenSDKClient_2014_03_06_11_20_release_25634";
    }
}
