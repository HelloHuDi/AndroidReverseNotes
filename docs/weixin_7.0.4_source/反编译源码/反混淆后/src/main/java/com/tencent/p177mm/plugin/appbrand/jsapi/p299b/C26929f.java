package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.f */
public final class C26929f extends C45577a {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(103853);
        Context context = c33303e.getContext();
        View appBrandDrawableView = new AppBrandDrawableView(context);
        appBrandDrawableView.getDrawContext().hcK = (C2103e) c33303e.mo5936B(C2103e.class);
        appBrandDrawableView.getDrawContext().hcM = c33303e;
        appBrandDrawableView.setContentDescription(context.getString(C25738R.string.f8827g5));
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, appBrandDrawableView);
        AppMethodBeat.m2505o(103853);
        return coverViewContainer;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103854);
        int i = jSONObject.getInt("canvasId");
        AppMethodBeat.m2505o(103854);
        return i;
    }

    public final boolean aCF() {
        return true;
    }

    public final boolean aCG() {
        return true;
    }
}
