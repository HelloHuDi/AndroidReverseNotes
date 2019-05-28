package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.websearch.api.C40192f;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.e */
public final class C29915e {
    private C40192f udN;

    public C29915e(C40192f c40192f) {
        this.udN = c40192f;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(8625);
        this.udN.onResume();
        AppMethodBeat.m2505o(8625);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(8626);
        this.udN.onPause();
        AppMethodBeat.m2505o(8626);
    }

    /* renamed from: b */
    public final void mo48161b(Bundle bundle, int i) {
        AppMethodBeat.m2504i(8627);
        this.udN.mo48008m(bundle.getString("fts_key_json_data"), bundle.getString("fts_key_widget_view_cache_key"), bundle.getInt("websearch_is_test_draw_json"), i);
        AppMethodBeat.m2505o(8627);
    }

    /* renamed from: ai */
    public final void mo48157ai(Bundle bundle) {
        AppMethodBeat.m2504i(8628);
        this.udN.adD((String) bundle.get("widgetId"));
        AppMethodBeat.m2505o(8628);
    }

    /* renamed from: aj */
    public final void mo48158aj(Bundle bundle) {
        AppMethodBeat.m2504i(8629);
        this.udN.adE(bundle.getString("fts_key_widget_view_cache_key"));
        AppMethodBeat.m2505o(8629);
    }

    /* renamed from: ak */
    public final void mo48159ak(Bundle bundle) {
        AppMethodBeat.m2504i(8630);
        this.udN.mo48007gR(bundle.getString("fts_key_json_data"), bundle.getString("fts_key_widget_view_cache_key"));
        AppMethodBeat.m2505o(8630);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(8631);
        this.udN.onDestroy();
        AppMethodBeat.m2505o(8631);
    }

    /* renamed from: al */
    public final void mo48160al(Bundle bundle) {
        AppMethodBeat.m2504i(8632);
        this.udN.mo48006f(bundle.getInt(VideoMaterialUtil.CRAZYFACE_X, -1), bundle.getInt(VideoMaterialUtil.CRAZYFACE_Y, -1), bundle.getString("widgetId"), bundle.getString("eventId"));
        AppMethodBeat.m2505o(8632);
    }
}
