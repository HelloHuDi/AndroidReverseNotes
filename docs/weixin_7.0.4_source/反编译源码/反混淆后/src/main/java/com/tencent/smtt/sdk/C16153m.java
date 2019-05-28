package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

/* renamed from: com.tencent.smtt.sdk.m */
final class C16153m implements TbsDownloaderCallback {
    /* renamed from: a */
    final /* synthetic */ Context f3033a;
    /* renamed from: b */
    final /* synthetic */ PreInitCallback f3034b;

    C16153m(Context context, PreInitCallback preInitCallback) {
        this.f3033a = context;
        this.f3034b = preInitCallback;
    }

    public final void onNeedDownloadFinish(boolean z, int i) {
        AppMethodBeat.m2504i(63990);
        if (TbsShareManager.findCoreForThirdPartyApp(this.f3033a) != 0 || TbsShareManager.getCoreDisabled()) {
            if (QbSdk.f16247i && TbsShareManager.isThirdPartyApp(this.f3033a)) {
                TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.f3033a);
            }
            QbSdk.preInit(this.f3033a, this.f3034b);
        } else {
            TbsShareManager.forceToLoadX5ForThirdApp(this.f3033a, false);
            if (QbSdk.f16247i && TbsShareManager.isThirdPartyApp(this.f3033a)) {
                TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.f3033a);
                AppMethodBeat.m2505o(63990);
                return;
            }
        }
        AppMethodBeat.m2505o(63990);
    }
}
