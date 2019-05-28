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
        AppMethodBeat.m2504i(75663);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            serviceVersion = iTMAssistantDownloadSDKServiceInterface.getServiceVersion();
            AppMethodBeat.m2505o(75663);
        } else {
            super.initTMAssistantDownloadSDK();
            serviceVersion = 0;
            AppMethodBeat.m2505o(75663);
        }
        return serviceVersion;
    }

    public synchronized void setDownloadSDKWifiOnly(boolean z) {
        AppMethodBeat.m2504i(75664);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            iTMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(z);
            AppMethodBeat.m2505o(75664);
        } else {
            super.initTMAssistantDownloadSDK();
            AppMethodBeat.m2505o(75664);
        }
    }

    public synchronized void setDownloadSDKMaxTaskNum(int i) {
        AppMethodBeat.m2504i(75665);
        if (i <= 0 || i > 10) {
            AppMethodBeat.m2505o(75665);
        } else {
            ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
            if (iTMAssistantDownloadSDKServiceInterface != null) {
                iTMAssistantDownloadSDKServiceInterface.setServiceSetingMaxTaskNum(i);
                AppMethodBeat.m2505o(75665);
            } else {
                super.initTMAssistantDownloadSDK();
                AppMethodBeat.m2505o(75665);
            }
        }
    }

    public synchronized boolean isAllDownloadFinished() {
        boolean isAllDownloadFinished;
        AppMethodBeat.m2504i(75666);
        ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface) super.getServiceInterface();
        if (iTMAssistantDownloadSDKServiceInterface != null) {
            isAllDownloadFinished = iTMAssistantDownloadSDKServiceInterface.isAllDownloadFinished();
        } else {
            super.initTMAssistantDownloadSDK();
            isAllDownloadFinished = false;
        }
        AppMethodBeat.m2505o(75666);
        return isAllDownloadFinished;
    }

    /* Access modifiers changed, original: protected */
    public void onDownloadSDKServiceInvalid() {
    }

    /* Access modifiers changed, original: protected */
    public void stubAsInterface(IBinder iBinder) {
        AppMethodBeat.m2504i(75667);
        this.mServiceInterface = Stub.asInterface(iBinder);
        AppMethodBeat.m2505o(75667);
    }

    /* Access modifiers changed, original: protected */
    public void registerServiceCallback() {
        AppMethodBeat.m2504i(75668);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.m2505o(75668);
    }

    /* Access modifiers changed, original: protected */
    public Intent getBindServiceIntent() {
        AppMethodBeat.m2504i(75669);
        Intent intent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
        AppMethodBeat.m2505o(75669);
        return intent;
    }

    /* Access modifiers changed, original: protected */
    public void unRegisterServiceCallback() {
        AppMethodBeat.m2504i(75670);
        ((ITMAssistantDownloadSDKServiceInterface) this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback) this.mServiceCallback);
        AppMethodBeat.m2505o(75670);
    }
}
