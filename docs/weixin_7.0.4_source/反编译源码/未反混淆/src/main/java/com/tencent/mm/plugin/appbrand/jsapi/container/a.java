package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 509;
    public static final String NAME = "insertPositioningContainer";

    public final View a(e eVar, JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.i(126277);
        View appBrandNativeContainerView = new AppBrandNativeContainerView(eVar.getContext());
        appBrandNativeContainerView.setBackgroundColor(0);
        boolean optBoolean = jSONObject.optBoolean("visible", true);
        boolean optBoolean2 = jSONObject.optBoolean("canFullScreenByChild", false);
        int a = g.a(jSONObject, "contentOffsetLeft", 0);
        int a2 = g.a(jSONObject, "contentOffsetTop", 0);
        appBrandNativeContainerView.setX((float) (-a));
        appBrandNativeContainerView.setY((float) (-a2));
        WrapperNativeContainerView wrapperNativeContainerView = new WrapperNativeContainerView(eVar.getContext(), appBrandNativeContainerView);
        if (!optBoolean) {
            i = 4;
        }
        wrapperNativeContainerView.setVisibility(i);
        wrapperNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.setFullscreenWithChild(optBoolean2);
        AppMethodBeat.o(126277);
        return wrapperNativeContainerView;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126278);
        int i = jSONObject.getInt("containerId");
        AppMethodBeat.o(126278);
        return i;
    }

    public final void a(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126279);
        view.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(126276);
                if (motionEvent.getAction() != 0) {
                    d.a((ViewGroup) view, motionEvent);
                }
                AppMethodBeat.o(126276);
                return false;
            }
        });
        AppMethodBeat.o(126279);
    }
}
