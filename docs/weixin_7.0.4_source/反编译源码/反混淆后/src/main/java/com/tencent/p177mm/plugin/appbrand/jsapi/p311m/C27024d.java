package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33640b;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33642d.C33643a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.d */
abstract class C27024d extends C33640b {
    private int bOs;
    WeakReference<C33303e> hUk;
    private C45608m hxE;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.d$1 */
    class C270251 implements C33643a {
        C270251() {
        }

        /* renamed from: b */
        public final void mo6189b(boolean z, Object obj) {
            AppMethodBeat.m2504i(126344);
            C27024d.this.jks.hide();
            AppMethodBeat.m2505o(126344);
        }
    }

    /* renamed from: C */
    public abstract void mo21974C(JSONObject jSONObject);

    C27024d() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo44708a(C45608m c45608m, C33303e c33303e, JSONObject jSONObject, int i) {
        this.hxE = c45608m;
        this.hUk = new WeakReference(c33303e);
        this.bOs = i;
        mo21974C(jSONObject);
    }

    public final View aEK() {
        return this.hUk == null ? null : ((C33303e) this.hUk.get()).aBf().ius;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: l */
    public final void mo44711l(String str, Map<String, Object> map) {
        if (this.hUk != null && this.hUk.get() != null && this.hxE != null) {
            ((C33303e) this.hUk.get()).mo6107M(this.bOs, this.hxE.mo73394j(str, map));
        }
    }

    /* Access modifiers changed, original: final */
    public final void aEL() {
        mo54197an(AppBrandEmptyPickerView.class);
        this.jks.setOnResultListener(new C270251());
        this.jks.show();
    }
}
