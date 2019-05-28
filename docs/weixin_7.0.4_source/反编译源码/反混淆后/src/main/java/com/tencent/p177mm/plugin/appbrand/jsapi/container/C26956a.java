package com.tencent.p177mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.container.a */
public final class C26956a extends C45577a {
    public static final int CTRL_INDEX = 509;
    public static final String NAME = "insertPositioningContainer";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.container.a$1 */
    class C22611 implements OnTouchListener {
        C22611() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(126276);
            if (motionEvent.getAction() != 0) {
                C38377d.m64948a((ViewGroup) view, motionEvent);
            }
            AppMethodBeat.m2505o(126276);
            return false;
        }
    }

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.m2504i(126277);
        View appBrandNativeContainerView = new AppBrandNativeContainerView(c33303e.getContext());
        appBrandNativeContainerView.setBackgroundColor(0);
        boolean optBoolean = jSONObject.optBoolean("visible", true);
        boolean optBoolean2 = jSONObject.optBoolean("canFullScreenByChild", false);
        int a = C42668g.m75555a(jSONObject, "contentOffsetLeft", 0);
        int a2 = C42668g.m75555a(jSONObject, "contentOffsetTop", 0);
        appBrandNativeContainerView.setX((float) (-a));
        appBrandNativeContainerView.setY((float) (-a2));
        WrapperNativeContainerView wrapperNativeContainerView = new WrapperNativeContainerView(c33303e.getContext(), appBrandNativeContainerView);
        if (!optBoolean) {
            i = 4;
        }
        wrapperNativeContainerView.setVisibility(i);
        wrapperNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.setFullscreenWithChild(optBoolean2);
        AppMethodBeat.m2505o(126277);
        return wrapperNativeContainerView;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126278);
        int i = jSONObject.getInt("containerId");
        AppMethodBeat.m2505o(126278);
        return i;
    }

    /* renamed from: a */
    public final void mo6140a(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126279);
        view.setOnTouchListener(new C22611());
        AppMethodBeat.m2505o(126279);
    }
}
