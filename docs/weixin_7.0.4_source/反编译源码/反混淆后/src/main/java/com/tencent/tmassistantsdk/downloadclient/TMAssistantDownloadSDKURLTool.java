package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.network.GetAppSimpleDetailEngine;
import com.tencent.tmassistantsdk.protocol.jce.AppDetailParam;
import com.tencent.tmassistantsdk.protocol.jce.AppSimpleDetail;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKURLTool implements ITMAssistantExchangeURLListenner {
    protected static final String TAG = "TMAssistantDownloadSDKExchangeURL";
    protected static TMAssistantDownloadSDKURLTool mInstance = null;
    protected GetAppSimpleDetailEngine engine = null;
    protected ITMAssistantExchangeURLListenner mListener = null;

    private TMAssistantDownloadSDKURLTool(ITMAssistantExchangeURLListenner iTMAssistantExchangeURLListenner) {
        AppMethodBeat.m2504i(75671);
        if (iTMAssistantExchangeURLListenner != null) {
            this.mListener = iTMAssistantExchangeURLListenner;
            this.engine = new GetAppSimpleDetailEngine(this.mListener);
            AppMethodBeat.m2505o(75671);
            return;
        }
        TMLog.m60587e(TAG, "ITMAssistantExchangeURLListenner listener shouldn't be null!");
        AppMethodBeat.m2505o(75671);
    }

    public static synchronized TMAssistantDownloadSDKURLTool getInstance(ITMAssistantExchangeURLListenner iTMAssistantExchangeURLListenner) {
        TMAssistantDownloadSDKURLTool tMAssistantDownloadSDKURLTool;
        synchronized (TMAssistantDownloadSDKURLTool.class) {
            AppMethodBeat.m2504i(75672);
            if (mInstance == null) {
                mInstance = new TMAssistantDownloadSDKURLTool(iTMAssistantExchangeURLListenner);
            }
            tMAssistantDownloadSDKURLTool = mInstance;
            AppMethodBeat.m2505o(75672);
        }
        return tMAssistantDownloadSDKURLTool;
    }

    public void exchangeUrlsFromPackageNames(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(75673);
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split(";");
                if (split != null && split.length > 0) {
                    AppDetailParam appDetailParam = new AppDetailParam();
                    appDetailParam.packageName = split[0];
                    if (split.length > 1) {
                        appDetailParam.channelId = split[1];
                    }
                    arrayList2.add(appDetailParam);
                }
            }
            if (arrayList2.size() > 0 && this.engine != null) {
                this.engine.sendReuqest(arrayList2);
            }
            AppMethodBeat.m2505o(75673);
            return;
        }
        TMLog.m60590w(TAG, "packageNames is null!");
        AppMethodBeat.m2505o(75673);
    }

    public void onExchangedURLSucceed(ArrayList<AppSimpleDetail> arrayList, boolean z) {
        AppMethodBeat.m2504i(75674);
        if (this.mListener != null) {
            this.mListener.onExchangedURLSucceed(arrayList, z);
        }
        AppMethodBeat.m2505o(75674);
    }
}
