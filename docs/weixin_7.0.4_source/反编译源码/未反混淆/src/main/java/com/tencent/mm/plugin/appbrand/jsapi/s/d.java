package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {

    public static class a extends ah {
        private static final int CTRL_INDEX = 137;
        private static final String NAME = "onLongPress";
    }

    public static class b extends ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchCancel";
    }

    public static class d extends ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchMove";
    }

    public static class f {
        public int id;
        public float x;
        public float y;

        public f(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final void b(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final JSONObject toJSONObject() {
            AppMethodBeat.i(91076);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.id);
                jSONObject.put(VideoMaterialUtil.CRAZYFACE_X, (double) g.au(this.x));
                jSONObject.put(VideoMaterialUtil.CRAZYFACE_Y, (double) g.au(this.y));
            } catch (JSONException e) {
            }
            AppMethodBeat.o(91076);
            return jSONObject;
        }

        public final String toString() {
            AppMethodBeat.i(91077);
            String jSONObject = toJSONObject().toString();
            AppMethodBeat.o(91077);
            return jSONObject;
        }
    }

    public static class c extends ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchStart";
    }

    public static class e extends ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchEnd";
    }

    public static f co(View view) {
        AppMethodBeat.i(91078);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        f fVar = new f(0, (float) iArr[0], (float) iArr[1]);
        AppMethodBeat.o(91078);
        return fVar;
    }

    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        AppMethodBeat.i(91079);
        int childCount = viewGroup.getChildCount();
        int pointerId = viewGroup.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(motionEvent.getActionIndex()) : -1;
        for (childCount--; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (AppBrandViewMotionCompat.cC(childAt) && AppBrandViewMotionCompat.a(viewGroup, x, y, childAt) && childAt.isDuplicateParentStateEnabled()) {
                a(viewGroup, motionEvent, childAt, pointerId);
                if ((childAt instanceof com.tencent.mm.plugin.appbrand.jsapi.base.e) && ((com.tencent.mm.plugin.appbrand.jsapi.base.e) childAt).aCH()) {
                    AppMethodBeat.o(91079);
                    return;
                }
            }
        }
        AppMethodBeat.o(91079);
    }

    private static boolean a(ViewGroup viewGroup, MotionEvent motionEvent, View view, int i) {
        AppMethodBeat.i(91080);
        if (view == null) {
            ab.v("MicroMsg.ViewMotionHelper", "child is null.");
            AppMethodBeat.o(91080);
            return false;
        }
        int action = motionEvent.getAction();
        boolean dispatchTouchEvent;
        if (action == 3) {
            motionEvent.setAction(3);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            AppMethodBeat.o(91080);
            return dispatchTouchEvent;
        }
        int intValue = ((Integer) l.a(MotionEvent.class, "getPointerIdBits", motionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
        int i2 = intValue & i;
        if (i2 == 0) {
            ab.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
            AppMethodBeat.o(91080);
            return false;
        }
        MotionEvent obtain;
        boolean booleanValue = ((Boolean) l.a(View.class, "hasIdentityMatrix", view, new Class[0], new Object[0], Boolean.FALSE)).booleanValue();
        if (i2 != intValue) {
            MotionEvent motionEvent2 = (MotionEvent) l.a("split", motionEvent, new Class[]{Integer.class}, new Object[]{Integer.valueOf(i2)});
            obtain = motionEvent2 == null ? MotionEvent.obtain(motionEvent) : motionEvent2;
        } else if (booleanValue) {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            AppMethodBeat.o(91080);
            return dispatchTouchEvent;
        } else {
            obtain = MotionEvent.obtain(motionEvent);
        }
        obtain.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!booleanValue) {
            obtain.transform((Matrix) l.a(View.class, "getInverseMatrix", view, new Class[0], new Object[0], null));
        }
        dispatchTouchEvent = view.dispatchTouchEvent(obtain);
        obtain.recycle();
        AppMethodBeat.o(91080);
        return dispatchTouchEvent;
    }
}
