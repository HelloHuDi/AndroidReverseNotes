package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class d extends b {
    private int bOs;
    WeakReference<e> hUk;
    private m hxE;

    public abstract void C(JSONObject jSONObject);

    d() {
    }

    /* Access modifiers changed, original: final */
    public final void a(m mVar, e eVar, JSONObject jSONObject, int i) {
        this.hxE = mVar;
        this.hUk = new WeakReference(eVar);
        this.bOs = i;
        C(jSONObject);
    }

    public final View aEK() {
        return this.hUk == null ? null : ((e) this.hUk.get()).aBf().ius;
    }

    /* Access modifiers changed, original: final */
    public final void l(String str, Map<String, Object> map) {
        if (this.hUk != null && this.hUk.get() != null && this.hxE != null) {
            ((e) this.hUk.get()).M(this.bOs, this.hxE.j(str, map));
        }
    }

    /* Access modifiers changed, original: final */
    public final void aEL() {
        an(AppBrandEmptyPickerView.class);
        this.jks.setOnResultListener(new a() {
            public final void b(boolean z, Object obj) {
                AppMethodBeat.i(126344);
                d.this.jks.hide();
                AppMethodBeat.o(126344);
            }
        });
        this.jks.show();
    }
}
