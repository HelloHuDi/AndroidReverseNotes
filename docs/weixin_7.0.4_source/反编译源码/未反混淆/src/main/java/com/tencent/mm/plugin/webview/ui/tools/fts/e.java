package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class e {
    private f udN;

    public e(f fVar) {
        this.udN = fVar;
    }

    public final void onResume() {
        AppMethodBeat.i(8625);
        this.udN.onResume();
        AppMethodBeat.o(8625);
    }

    public final void onPause() {
        AppMethodBeat.i(8626);
        this.udN.onPause();
        AppMethodBeat.o(8626);
    }

    public final void b(Bundle bundle, int i) {
        AppMethodBeat.i(8627);
        this.udN.m(bundle.getString("fts_key_json_data"), bundle.getString("fts_key_widget_view_cache_key"), bundle.getInt("websearch_is_test_draw_json"), i);
        AppMethodBeat.o(8627);
    }

    public final void ai(Bundle bundle) {
        AppMethodBeat.i(8628);
        this.udN.adD((String) bundle.get("widgetId"));
        AppMethodBeat.o(8628);
    }

    public final void aj(Bundle bundle) {
        AppMethodBeat.i(8629);
        this.udN.adE(bundle.getString("fts_key_widget_view_cache_key"));
        AppMethodBeat.o(8629);
    }

    public final void ak(Bundle bundle) {
        AppMethodBeat.i(8630);
        this.udN.gR(bundle.getString("fts_key_json_data"), bundle.getString("fts_key_widget_view_cache_key"));
        AppMethodBeat.o(8630);
    }

    public final void onDestroy() {
        AppMethodBeat.i(8631);
        this.udN.onDestroy();
        AppMethodBeat.o(8631);
    }

    public final void al(Bundle bundle) {
        AppMethodBeat.i(8632);
        this.udN.f(bundle.getInt(VideoMaterialUtil.CRAZYFACE_X, -1), bundle.getInt(VideoMaterialUtil.CRAZYFACE_Y, -1), bundle.getString("widgetId"), bundle.getString("eventId"));
        AppMethodBeat.o(8632);
    }
}
