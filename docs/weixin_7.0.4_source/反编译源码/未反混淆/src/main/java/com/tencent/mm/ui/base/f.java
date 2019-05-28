package com.tencent.mm.ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static boolean dzs() {
        return VERSION.SDK_INT >= 5;
    }

    private static boolean M(MotionEvent motionEvent) {
        AppMethodBeat.i(106277);
        if (!dzs()) {
            AppMethodBeat.o(106277);
            return false;
        } else if (motionEvent.getPointerCount() >= 2) {
            AppMethodBeat.o(106277);
            return true;
        } else {
            AppMethodBeat.o(106277);
            return false;
        }
    }

    public static float N(MotionEvent motionEvent) {
        AppMethodBeat.i(106278);
        float c = c(motionEvent, 0) - c(motionEvent, 1);
        float d = d(motionEvent, 0) - d(motionEvent, 1);
        c = (float) Math.sqrt((double) ((c * c) + (d * d)));
        AppMethodBeat.o(106278);
        return c;
    }

    public static void a(PointF pointF, MotionEvent motionEvent) {
        AppMethodBeat.i(106279);
        if (pointF == null || motionEvent == null) {
            AppMethodBeat.o(106279);
            return;
        }
        pointF.set((c(motionEvent, 0) + c(motionEvent, 1)) / 2.0f, (d(motionEvent, 0) + d(motionEvent, 1)) / 2.0f);
        AppMethodBeat.o(106279);
    }

    public static void a(PointF pointF, Bitmap bitmap) {
        AppMethodBeat.i(106280);
        if (pointF == null || bitmap == null) {
            AppMethodBeat.o(106280);
            return;
        }
        pointF.set(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        AppMethodBeat.o(106280);
    }

    public static float c(MotionEvent motionEvent, int i) {
        AppMethodBeat.i(106281);
        float x;
        if (M(motionEvent)) {
            e eVar = new e();
            x = motionEvent.getX(i);
            AppMethodBeat.o(106281);
            return x;
        }
        x = motionEvent.getX();
        AppMethodBeat.o(106281);
        return x;
    }

    public static float d(MotionEvent motionEvent, int i) {
        AppMethodBeat.i(106282);
        float y;
        if (M(motionEvent)) {
            e eVar = new e();
            y = motionEvent.getY(i);
            AppMethodBeat.o(106282);
            return y;
        }
        y = motionEvent.getY();
        AppMethodBeat.o(106282);
        return y;
    }

    public static int O(MotionEvent motionEvent) {
        AppMethodBeat.i(106283);
        if (dzs()) {
            e eVar = new e();
            int pointerCount = motionEvent.getPointerCount();
            AppMethodBeat.o(106283);
            return pointerCount;
        }
        AppMethodBeat.o(106283);
        return 1;
    }

    public static void c(KeyEvent keyEvent) {
        AppMethodBeat.i(106284);
        if (dzs()) {
            e eVar = new e();
            keyEvent.startTracking();
        }
        AppMethodBeat.o(106284);
    }

    public static boolean d(KeyEvent keyEvent) {
        AppMethodBeat.i(106285);
        if (dzs()) {
            e eVar = new e();
            boolean isTracking = keyEvent.isTracking();
            AppMethodBeat.o(106285);
            return isTracking;
        }
        AppMethodBeat.o(106285);
        return false;
    }

    public static boolean e(KeyEvent keyEvent) {
        AppMethodBeat.i(106286);
        if (dzs()) {
            e eVar = new e();
            boolean isCanceled = keyEvent.isCanceled();
            AppMethodBeat.o(106286);
            return isCanceled;
        }
        AppMethodBeat.o(106286);
        return false;
    }
}
