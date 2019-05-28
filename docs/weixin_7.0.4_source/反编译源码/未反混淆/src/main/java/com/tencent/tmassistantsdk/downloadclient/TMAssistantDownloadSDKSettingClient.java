package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;

public class TMAssistantDownloadSDKSettingClient extends TMAssistantDownloadSDKClientBase {
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.TMAssistantDownloadSDKService";

    public TMAssistantDownloadSDKSettingClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
    }

    public synchronized int getVersion() {
        int serviceVersion;
        AppMethodBeat.i(75663);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            serviceVersion = iTMAssistantDownloadSDKServiceInterface.getServiceVersion();
            AppMethodBeat.o(75663);
        } else {
            super.initTMAssistantDownloadSDK();
            serviceVersion = 0;
            AppMethodBeat.o(75663);
        }
        return serviceVersion;
    }

    public synchronized void setDownloadSDKWifiOnly(boolean z) {
        AppMethodBeat.i(75664);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
            AppMethodBeat.o(75664);
        } else {
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.o(75664);
        }
    }

    public synchronized void setDownloadSDKMaxTaskNum(int i) {
        AppMethodBeat.i(75665);
        if (i <= 0 || i > 10) {
            AppMethodBeat.o(75665);
        } else {
            ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
            if (iTMAssistantDownloadSDKServiceInterface != null) {
                iTMAssistantDownloadSDKServiceInterface.setServiceSetingMaxTaskNum(i);
                AppMethodBeat.o(75665);
            } else {
                super.initTMAssistantDownloadSDK();
                AppMethodBeat.o(75665);
            }
        }
    }

    public synchronized boolean isAllDownloadFinished() {
        boolean isAllDownloadFinished;
        AppMethodBeat.i(75666);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            isAllDownloadFinished = iTMAssistantDownloadSDKServiceInterface.isAllDownloadFinished();
        } else {
            super.initTMAssistantDownloadSDK();
            isAllDownloadFinished = false;
        }
        AppMethodBeat.o(75666);
        return isAllDownloadFinished;
    }

    /* Access modifiers changed, original: protected */
    public void onDownloadSDKServiceInvalid() {
    }

    /* Access modifiers changed, original: protected */
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.i(75667);
        this.mServiceInterface = Stub.asInterface(iBinder);
        AppMethodBeat.o(75667);
    }

    /* Access modifiers changed, original: protected */
    public void registerServiceCallback() {
        AppMethodBeat.i(75668);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(75668);
    }

    /* Access modifiers changed, original: protected */
    public Intent getBindServiceIntent() {
        AppMethodBeat.i(75669);
        Intent intent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
        AppMethodBeat.o(75669);
        return intent;
    }

    /* Access modifiers changed, original: protected */
    public void unRegisterServiceCallback() {
        AppMethodBeat.i(75670);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.o(75670);
    }
}
