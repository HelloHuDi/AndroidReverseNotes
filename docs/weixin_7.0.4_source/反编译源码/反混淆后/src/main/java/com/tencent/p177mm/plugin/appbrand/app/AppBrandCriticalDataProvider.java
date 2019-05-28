package com.tencent.p177mm.plugin.appbrand.app;

import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.appbrand.config.C10183o;
import com.tencent.p177mm.sdk.p603e.C4927e;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "()V", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.app.AppBrandCriticalDataProvider */
public final class AppBrandCriticalDataProvider extends WxaCriticalDataProvider {
    /* renamed from: yo */
    public final C4927e mo67857yo() {
        AppMethodBeat.m2504i(134454);
        C1953a auK = C42340f.auK();
        if (auK != null) {
            mo72937b(C10183o.class, C42340f.auO());
        } else {
            auK = null;
        }
        C4927e c4927e = auK;
        AppMethodBeat.m2505o(134454);
        return c4927e;
    }
}
