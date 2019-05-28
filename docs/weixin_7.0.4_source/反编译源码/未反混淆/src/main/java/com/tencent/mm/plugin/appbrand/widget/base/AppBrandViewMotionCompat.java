package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.support.annotation.Keep;
import android.support.v4.widget.j;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandViewMotionCompat {
    public static boolean cB(View view) {
        AppMethodBeat.i(91196);
        if (view != null && (view instanceof c) && ((c) view).aOQ()) {
            AppMethodBeat.o(91196);
            return true;
        }
        AppMethodBeat.o(91196);
        return false;
    }

    public static boolean cC(View view) {
        AppMethodBeat.i(91197);
        if (view.getVisibility() == 0 || view.getAnimation() != null) {
            AppMethodBeat.o(91197);
            return true;
        }
        AppMethodBeat.o(91197);
        return false;
    }

    @TargetApi(11)
    public static boolean a(ViewGroup viewGroup, float f, float f2, View view) {
        AppMethodBeat.i(91198);
        float[] fArr = new float[]{0.0f, 0.0f};
        fArr[0] = ((float) (viewGroup.getScrollX() - view.getLeft())) + f;
        fArr[1] = ((float) (viewGroup.getScrollY() - view.getTop())) + f2;
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.invert(matrix);
            matrix.mapPoints(fArr);
        }
        if (fArr[0] < 0.0f || fArr[1] < 0.0f || fArr[0] >= ((float) (view.getRight() - view.getLeft())) || fArr[1] >= ((float) (view.getBottom() - view.getTop()))) {
            AppMethodBeat.o(91198);
            return false;
        }
        AppMethodBeat.o(91198);
        return true;
    }

    @Keep
    @TargetApi(11)
    public static boolean dispatchTransformedTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent, boolean z, View view, int i) {
        AppMethodBeat.i(91199);
        if (viewGroup == null || motionEvent == null) {
            AppMethodBeat.o(91199);
            return false;
        }
        int action = motionEvent.getAction();
        boolean dispatchTouchEvent;
        if (z || action == 3) {
            motionEvent.setAction(3);
            if (view == null) {
                AppMethodBeat.o(91199);
                return false;
            }
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            AppMethodBeat.o(91199);
            return dispatchTouchEvent;
        }
        int i2;
        action = 0;
        for (i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            action |= 1 << motionEvent.getPointerId(i2);
        }
        int i3 = action & i;
        if (i3 == 0) {
            AppMethodBeat.o(91199);
            return false;
        }
        MotionEvent motionEvent2;
        if (i3 != action) {
            IllegalArgumentException illegalArgumentException;
            try {
                int pointerCount = motionEvent.getPointerCount();
                PointerProperties[] pointerPropertiesArr = new PointerProperties[pointerCount];
                PointerCoords[] pointerCoordsArr = new PointerCoords[pointerCount];
                int[] iArr = new int[pointerCount];
                int action2 = motionEvent.getAction();
                int i4 = action2 & 255;
                int i5 = (65280 & action2) >> 8;
                i2 = -1;
                int i6 = 0;
                for (action = 0; action < pointerCount; action++) {
                    motionEvent.getPointerProperties(action, pointerPropertiesArr[i6]);
                    if (((1 << pointerPropertiesArr[i6].id) & i3) != 0) {
                        if (action == i5) {
                            i2 = i6;
                        }
                        iArr[i6] = action;
                        i6++;
                    }
                }
                if (i6 == 0) {
                    illegalArgumentException = new IllegalArgumentException("idBits did not match any ids in the event");
                    AppMethodBeat.o(91199);
                    throw illegalArgumentException;
                }
                if (i4 == 5 || i4 == 6) {
                    if (i2 < 0) {
                        action2 = 2;
                    } else if (i6 == 1) {
                        action2 = i4 == 5 ? 0 : 1;
                    } else {
                        action2 = i4 | (i2 << 8);
                    }
                }
                MotionEvent motionEvent3 = null;
                int historySize = motionEvent.getHistorySize();
                int i7 = 0;
                while (i7 <= historySize) {
                    action = i7 == historySize ? j.INVALID_ID : i7;
                    for (i3 = 0; i3 < i6; i3++) {
                        motionEvent.getHistoricalPointerCoords(iArr[i3], action, pointerCoordsArr[i3]);
                    }
                    long historicalEventTime = motionEvent.getHistoricalEventTime(action);
                    if (i7 == 0) {
                        motionEvent3 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), action2, i6, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                        motionEvent3.offsetLocation(motionEvent3.getX() - motionEvent3.getRawX(), motionEvent3.getY() - motionEvent3.getRawY());
                    } else {
                        motionEvent3.addBatch(historicalEventTime, pointerCoordsArr, 0);
                    }
                    i7++;
                }
                motionEvent2 = motionEvent3;
            } catch (IllegalArgumentException illegalArgumentException2) {
                d.w("MicroMsg.AppBrandViewMotionCompat", "dispatchTransformedTouchEvent e=%s", illegalArgumentException2.getMessage());
                AppMethodBeat.o(91199);
                return false;
            }
        } else if (view != null && !view.getMatrix().isIdentity()) {
            motionEvent2 = MotionEvent.obtain(motionEvent);
        } else if (view == null) {
            AppMethodBeat.o(91199);
            return false;
        } else {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            AppMethodBeat.o(91199);
            return dispatchTouchEvent;
        }
        if (view == null) {
            AppMethodBeat.o(91199);
            return false;
        }
        motionEvent2.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            matrix.invert(matrix);
            motionEvent2.transform(matrix);
        }
        dispatchTouchEvent = view.dispatchTouchEvent(motionEvent2);
        motionEvent2.recycle();
        AppMethodBeat.o(91199);
        return dispatchTouchEvent;
    }
}
