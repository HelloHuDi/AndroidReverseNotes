package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class j {
    private static j hlJ = new j();
    public Map<String, b> hlB = new ConcurrentHashMap();

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10703);
            Bundle bundle = (Bundle) obj;
            b bVar = new b();
            bVar.fromBundle(bundle);
            j.azE().hlB.put(bVar.hlE, bVar);
            AppMethodBeat.o(10703);
        }
    }

    public static class b implements com.tencent.mm.ipcinvoker.d.a {
        String appId = "";
        int css;
        String czZ;
        int fmr;
        String hlE = "";

        public b(String str, String str2, int i, String str3, int i2) {
            this.hlE = str;
            this.appId = str2;
            this.css = i;
            this.czZ = str3;
            this.fmr = i2;
        }

        public final Bundle toBundle() {
            AppMethodBeat.i(10704);
            Bundle bundle = new Bundle();
            bundle.putString("widgetId", this.hlE);
            bundle.putString("appid", this.appId);
            bundle.putInt("appState", this.css);
            bundle.putString("reqKey", this.czZ);
            bundle.putInt("serviceType", this.fmr);
            AppMethodBeat.o(10704);
            return bundle;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(10705);
            this.hlE = bundle.getString("widgetId");
            this.appId = bundle.getString("appid");
            this.css = bundle.getInt("appState");
            this.czZ = bundle.getString("reqKey");
            this.fmr = bundle.getInt("serviceType");
            AppMethodBeat.o(10705);
        }
    }

    public j() {
        AppMethodBeat.i(10706);
        AppMethodBeat.o(10706);
    }

    static {
        AppMethodBeat.i(10712);
        AppMethodBeat.o(10712);
    }

    public static j azE() {
        return hlJ;
    }

    public final void ba(String str, int i) {
        AppMethodBeat.i(10707);
        E(zY(str), JsApiShowImageOperateSheet.CTRL_INDEX, i);
        AppMethodBeat.o(10707);
    }

    public final void E(String str, int i, int i2) {
        AppMethodBeat.i(10708);
        if (((b) this.hlB.get(str)) != null) {
            com.tencent.mm.ipcinvoker.h.b.i("WidgetReporter_14443", "report %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(i2));
            h.pYm.e(14443, r0.appId, Integer.valueOf(0), Integer.valueOf(r0.css), Integer.valueOf(2), r0.czZ, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(r0.fmr));
        }
        AppMethodBeat.o(10708);
    }

    public final void zX(String str) {
        AppMethodBeat.i(10709);
        E(zY(str), JsApiShowImageOperateSheet.CTRL_INDEX, 7);
        AppMethodBeat.o(10709);
    }

    private String zY(String str) {
        AppMethodBeat.i(10710);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(10710);
            return str2;
        }
        for (Entry entry : this.hlB.entrySet()) {
            if (entry.getValue() != null && str.equals(((b) entry.getValue()).appId)) {
                str2 = (String) entry.getKey();
                AppMethodBeat.o(10710);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.o(10710);
        return str2;
    }

    public final void zZ(String str) {
        AppMethodBeat.i(10711);
        E(str, JsApiShowImageOperateSheet.CTRL_INDEX, 26);
        AppMethodBeat.o(10711);
    }
}
