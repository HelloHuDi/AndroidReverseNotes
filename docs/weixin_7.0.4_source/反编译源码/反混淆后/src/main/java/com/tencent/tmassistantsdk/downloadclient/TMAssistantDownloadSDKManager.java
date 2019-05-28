package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKManager {
    protected static TMAssistantDownloadSDKManager mInstance = null;
    protected static ArrayList<TMAssistantDownloadOpenSDKClient> mOpenSDKClientList = new ArrayList();
    protected static ArrayList<TMAssistantDownloadSDKClient> mSDKClientList = new ArrayList();
    protected static TMAssistantDownloadSDKSettingClient mSDKSettingClient = null;
    protected Context mContext = null;

    static {
        AppMethodBeat.m2504i(75656);
        AppMethodBeat.m2505o(75656);
    }

    protected TMAssistantDownloadSDKManager(Context context) {
        this.mContext = context;
    }

    public static synchronized TMAssistantDownloadSDKManager getInstance(Context context) {
        TMAssistantDownloadSDKManager tMAssistantDownloadSDKManager;
        synchronized (TMAssistantDownloadSDKManager.class) {
            AppMethodBeat.m2504i(75650);
            if (mInstance == null) {
                mInstance = new TMAssistantDownloadSDKManager(context);
            }
            tMAssistantDownloadSDKManager = mInstance;
            AppMethodBeat.m2505o(75650);
        }
        return tMAssistantDownloadSDKManager;
    }

    public synchronized TMAssistantDownloadSDKClient getDownloadSDKClient(String str) {
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient;
        AppMethodBeat.m2504i(75651);
        if (str == null || str.length() <= 0) {
            tMAssistantDownloadSDKClient = null;
            AppMethodBeat.m2505o(75651);
        } else {
            Iterator it = mSDKClientList.iterator();
            while (it.hasNext()) {
                tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) it.next();
                if (tMAssistantDownloadSDKClient.mClientKey.equals(str)) {
                    AppMethodBeat.m2505o(75651);
                    break;
                }
            }
            tMAssistantDownloadSDKClient = new TMAssistantDownloadSDKClient(this.mContext, str);
            tMAssistantDownloadSDKClient.initTMAssistantDownloadSDK();
            mSDKClientList.add(tMAssistantDownloadSDKClient);
            AppMethodBeat.m2505o(75651);
        }
        return tMAssistantDownloadSDKClient;
    }

    public synchronized TMAssistantDownloadSDKSettingClient getDownloadSDKSettingClient() {
        TMAssistantDownloadSDKSettingClient tMAssistantDownloadSDKSettingClient;
        AppMethodBeat.m2504i(75652);
        if (mSDKSettingClient == null) {
            tMAssistantDownloadSDKSettingClient = new TMAssistantDownloadSDKSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
            mSDKSettingClient = tMAssistantDownloadSDKSettingClient;
            tMAssistantDownloadSDKSettingClient.initTMAssistantDownloadSDK();
        }
        tMAssistantDownloadSDKSettingClient = mSDKSettingClient;
        AppMethodBeat.m2505o(75652);
        return tMAssistantDownloadSDKSettingClient;
    }

    public synchronized TMAssistantDownloadOpenSDKClient getDownloadOpenSDKClient(String str) {
        TMAssistantDownloadOpenSDKClient tMAssistantDownloadOpenSDKClient;
        AppMethodBeat.m2504i(75653);
        Iterator it = mOpenSDKClientList.iterator();
        while (it.hasNext()) {
            tMAssistantDownloadOpenSDKClient = (TMAssistantDownloadOpenSDKClient) it.next();
            if (tMAssistantDownloadOpenSDKClient.mClientKey.equals(str)) {
                AppMethodBeat.m2505o(75653);
                break;
            }
        }
        tMAssistantDownloadOpenSDKClient = new TMAssistantDownloadOpenSDKClient(this.mContext, str, "com.tencent.android.qqdownloader.SDKService");
        if (tMAssistantDownloadOpenSDKClient.initTMAssistantDownloadSDK()) {
            mOpenSDKClientList.add(tMAssistantDownloadOpenSDKClient);
            AppMethodBeat.m2505o(75653);
        } else {
            tMAssistantDownloadOpenSDKClient = null;
            AppMethodBeat.m2505o(75653);
        }
        return tMAssistantDownloadOpenSDKClient;
    }

    public synchronized boolean releaseDownloadSDKClient(String str) {
        boolean z;
        AppMethodBeat.m2504i(75654);
        Iterator it = mSDKClientList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) it.next();
            if (tMAssistantDownloadSDKClient != null && tMAssistantDownloadSDKClient.mClientKey.equals(str)) {
                tMAssistantDownloadSDKClient.unInitTMAssistantDownloadSDK();
                it.remove();
                AppMethodBeat.m2505o(75654);
                z = true;
                break;
            }
        }
        if (mSDKSettingClient == null || !mSDKSettingClient.mClientKey.equals(str)) {
            z = false;
            AppMethodBeat.m2505o(75654);
        } else {
            mSDKSettingClient.unInitTMAssistantDownloadSDK();
            mSDKSettingClient = null;
            AppMethodBeat.m2505o(75654);
            z = true;
        }
        return z;
    }

    public static synchronized void closeAllService(Context context) {
        synchronized (TMAssistantDownloadSDKManager.class) {
            AppMethodBeat.m2504i(75655);
            TMLog.m60588i("TMAssistantDownloadSDKManager", "closeAllService method!");
            if (mInstance == null) {
                TMLog.m60588i("TMAssistantDownloadSDKManager", "manager minstance == null");
                AppMethodBeat.m2505o(75655);
            } else {
                if (mSDKClientList != null && mSDKClientList.size() > 0) {
                    Iterator it = mSDKClientList.iterator();
                    while (it.hasNext()) {
                        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) it.next();
                        if (tMAssistantDownloadSDKClient != null) {
                            tMAssistantDownloadSDKClient.unInitTMAssistantDownloadSDK();
                        }
                    }
                    mSDKClientList.clear();
                }
                if (mSDKSettingClient != null) {
                    mSDKSettingClient.unInitTMAssistantDownloadSDK();
                    mSDKSettingClient = null;
                }
                mInstance = null;
                AppMethodBeat.m2505o(75655);
            }
        }
    }

    public static String about() {
        return "TMAssistantDownloadSDKManager_2014_03_04_17_55_release_25406";
    }
}
