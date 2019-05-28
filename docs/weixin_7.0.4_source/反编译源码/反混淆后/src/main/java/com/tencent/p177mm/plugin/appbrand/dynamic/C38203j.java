package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.p854d.C9547a;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j */
public final class C38203j {
    private static C38203j hlJ = new C38203j();
    public Map<String, C38205b> hlB = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j$a */
    static class C38204a implements C37866a<Bundle, Bundle> {
        private C38204a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10703);
            Bundle bundle = (Bundle) obj;
            C38205b c38205b = new C38205b();
            c38205b.fromBundle(bundle);
            C38203j.azE().hlB.put(c38205b.hlE, c38205b);
            AppMethodBeat.m2505o(10703);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j$b */
    public static class C38205b implements C9547a {
        String appId = "";
        int css;
        String czZ;
        int fmr;
        String hlE = "";

        public C38205b(String str, String str2, int i, String str3, int i2) {
            this.hlE = str;
            this.appId = str2;
            this.css = i;
            this.czZ = str3;
            this.fmr = i2;
        }

        public final Bundle toBundle() {
            AppMethodBeat.m2504i(10704);
            Bundle bundle = new Bundle();
            bundle.putString("widgetId", this.hlE);
            bundle.putString("appid", this.appId);
            bundle.putInt("appState", this.css);
            bundle.putString("reqKey", this.czZ);
            bundle.putInt("serviceType", this.fmr);
            AppMethodBeat.m2505o(10704);
            return bundle;
        }

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(10705);
            this.hlE = bundle.getString("widgetId");
            this.appId = bundle.getString("appid");
            this.css = bundle.getInt("appState");
            this.czZ = bundle.getString("reqKey");
            this.fmr = bundle.getInt("serviceType");
            AppMethodBeat.m2505o(10705);
        }
    }

    public C38203j() {
        AppMethodBeat.m2504i(10706);
        AppMethodBeat.m2505o(10706);
    }

    static {
        AppMethodBeat.m2504i(10712);
        AppMethodBeat.m2505o(10712);
    }

    public static C38203j azE() {
        return hlJ;
    }

    /* renamed from: ba */
    public final void mo60939ba(String str, int i) {
        AppMethodBeat.m2504i(10707);
        mo60938E(m64650zY(str), JsApiShowImageOperateSheet.CTRL_INDEX, i);
        AppMethodBeat.m2505o(10707);
    }

    /* renamed from: E */
    public final void mo60938E(String str, int i, int i2) {
        AppMethodBeat.m2504i(10708);
        if (((C38205b) this.hlB.get(str)) != null) {
            C26340b.m41917i("WidgetReporter_14443", "report %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(i2));
            C7060h.pYm.mo8381e(14443, r0.appId, Integer.valueOf(0), Integer.valueOf(r0.css), Integer.valueOf(2), r0.czZ, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(r0.fmr));
        }
        AppMethodBeat.m2505o(10708);
    }

    /* renamed from: zX */
    public final void mo60940zX(String str) {
        AppMethodBeat.m2504i(10709);
        mo60938E(m64650zY(str), JsApiShowImageOperateSheet.CTRL_INDEX, 7);
        AppMethodBeat.m2505o(10709);
    }

    /* renamed from: zY */
    private String m64650zY(String str) {
        AppMethodBeat.m2504i(10710);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(10710);
            return str2;
        }
        for (Entry entry : this.hlB.entrySet()) {
            if (entry.getValue() != null && str.equals(((C38205b) entry.getValue()).appId)) {
                str2 = (String) entry.getKey();
                AppMethodBeat.m2505o(10710);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(10710);
        return str2;
    }

    /* renamed from: zZ */
    public final void mo60941zZ(String str) {
        AppMethodBeat.m2504i(10711);
        mo60938E(str, JsApiShowImageOperateSheet.CTRL_INDEX, 26);
        AppMethodBeat.m2505o(10711);
    }
}
