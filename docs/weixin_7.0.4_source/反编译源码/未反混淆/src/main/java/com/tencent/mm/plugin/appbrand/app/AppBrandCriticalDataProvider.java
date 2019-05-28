package com.tencent.mm.plugin.appbrand.app;

import a.l;
import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.sdk.e.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "()V", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
public final class AppBrandCriticalDataProvider extends WxaCriticalDataProvider {
    public final e yo() {
        AppMethodBeat.i(134454);
        a auK = f.auK();
        if (auK != null) {
            b(o.class, f.auO());
        } else {
            auK = null;
        }
        e eVar = auK;
        AppMethodBeat.o(134454);
        return eVar;
    }
}
