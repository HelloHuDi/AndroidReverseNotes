package com.tencent.p177mm.plugin.appbrand.jsapi.p901s;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26931e;
import com.tencent.p177mm.plugin.appbrand.p328r.C38495l;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d */
public final class C38377d {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d$a */
    public static class C10511a extends C42467ah {
        private static final int CTRL_INDEX = 137;
        private static final String NAME = "onLongPress";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d$b */
    public static class C10512b extends C42467ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchCancel";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d$d */
    public static class C38375d extends C42467ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchMove";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d$f */
    public static class C38376f {
        /* renamed from: id */
        public int f16151id;
        /* renamed from: x */
        public float f16152x;
        /* renamed from: y */
        public float f16153y;

        public C38376f(int i, float f, float f2) {
            this.f16151id = i;
            this.f16152x = f;
            this.f16153y = f2;
        }

        /* renamed from: b */
        public final void mo61035b(int i, float f, float f2) {
            this.f16151id = i;
            this.f16152x = f;
            this.f16153y = f2;
        }

        public final JSONObject toJSONObject() {
            AppMethodBeat.m2504i(91076);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f16151id);
                jSONObject.put(VideoMaterialUtil.CRAZYFACE_X, (double) C42668g.m75556au(this.f16152x));
                jSONObject.put(VideoMaterialUtil.CRAZYFACE_Y, (double) C42668g.m75556au(this.f16153y));
            } catch (JSONException e) {
            }
            AppMethodBeat.m2505o(91076);
            return jSONObject;
        }

        public final String toString() {
            AppMethodBeat.m2504i(91077);
            String jSONObject = toJSONObject().toString();
            AppMethodBeat.m2505o(91077);
            return jSONObject;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d$c */
    public static class C38378c extends C42467ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchStart";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.d$e */
    public static class C38379e extends C42467ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchEnd";
    }

    /* renamed from: co */
    public static C38376f m64950co(View view) {
        AppMethodBeat.m2504i(91078);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        C38376f c38376f = new C38376f(0, (float) iArr[0], (float) iArr[1]);
        AppMethodBeat.m2505o(91078);
        return c38376f;
    }

    /* renamed from: a */
    public static void m64948a(ViewGroup viewGroup, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(91079);
        int childCount = viewGroup.getChildCount();
        int pointerId = viewGroup.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(motionEvent.getActionIndex()) : -1;
        for (childCount--; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (AppBrandViewMotionCompat.m43427cC(childAt) && AppBrandViewMotionCompat.m43425a(viewGroup, x, y, childAt) && childAt.isDuplicateParentStateEnabled()) {
                C38377d.m64949a(viewGroup, motionEvent, childAt, pointerId);
                if ((childAt instanceof C26931e) && ((C26931e) childAt).aCH()) {
                    AppMethodBeat.m2505o(91079);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(91079);
    }

    /* renamed from: a */
    private static boolean m64949a(ViewGroup viewGroup, MotionEvent motionEvent, View view, int i) {
        AppMethodBeat.m2504i(91080);
        if (view == null) {
            C4990ab.m7418v("MicroMsg.ViewMotionHelper", "child is null.");
            AppMethodBeat.m2505o(91080);
            return false;
        }
        int action = motionEvent.getAction();
        boolean dispatchTouchEvent;
        if (action == 3) {
            motionEvent.setAction(3);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            AppMethodBeat.m2505o(91080);
            return dispatchTouchEvent;
        }
        int intValue = ((Integer) C38495l.m65146a(MotionEvent.class, "getPointerIdBits", motionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
        int i2 = intValue & i;
        if (i2 == 0) {
            C4990ab.m7418v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
            AppMethodBeat.m2505o(91080);
            return false;
        }
        MotionEvent obtain;
        boolean booleanValue = ((Boolean) C38495l.m65146a(View.class, "hasIdentityMatrix", view, new Class[0], new Object[0], Boolean.FALSE)).booleanValue();
        if (i2 != intValue) {
            MotionEvent motionEvent2 = (MotionEvent) C38495l.m65147a("split", motionEvent, new Class[]{Integer.class}, new Object[]{Integer.valueOf(i2)});
            obtain = motionEvent2 == null ? MotionEvent.obtain(motionEvent) : motionEvent2;
        } else if (booleanValue) {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            AppMethodBeat.m2505o(91080);
            return dispatchTouchEvent;
        } else {
            obtain = MotionEvent.obtain(motionEvent);
        }
        obtain.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!booleanValue) {
            obtain.transform((Matrix) C38495l.m65146a(View.class, "getInverseMatrix", view, new Class[0], new Object[0], null));
        }
        dispatchTouchEvent = view.dispatchTouchEvent(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(91080);
        return dispatchTouchEvent;
    }
}
