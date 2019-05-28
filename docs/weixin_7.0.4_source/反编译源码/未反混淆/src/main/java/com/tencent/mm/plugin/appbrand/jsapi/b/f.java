package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    public final View a(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(103853);
        Context context = eVar.getContext();
        View appBrandDrawableView = new AppBrandDrawableView(context);
        appBrandDrawableView.getDrawContext().hcK = (com.tencent.mm.plugin.appbrand.canvas.e) eVar.B(com.tencent.mm.plugin.appbrand.canvas.e.class);
        appBrandDrawableView.getDrawContext().hcM = eVar;
        appBrandDrawableView.setContentDescription(context.getString(R.string.g5));
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, appBrandDrawableView);
        AppMethodBeat.o(103853);
        return coverViewContainer;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(103854);
        int i = jSONObject.getInt("canvasId");
        AppMethodBeat.o(103854);
        return i;
    }

    public final boolean aCF() {
        return true;
    }

    public final boolean aCG() {
        return true;
    }
}
