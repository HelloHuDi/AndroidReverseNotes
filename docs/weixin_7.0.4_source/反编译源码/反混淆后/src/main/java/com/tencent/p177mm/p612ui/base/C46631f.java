package com.tencent.p177mm.p612ui.base;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.f */
public final class C46631f {
    public static boolean dzs() {
        return VERSION.SDK_INT >= 5;
    }

    /* renamed from: M */
    private static boolean m88230M(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106277);
        if (!C46631f.dzs()) {
            AppMethodBeat.m2505o(106277);
            return false;
        } else if (motionEvent.getPointerCount() >= 2) {
            AppMethodBeat.m2505o(106277);
            return true;
        } else {
            AppMethodBeat.m2505o(106277);
            return false;
        }
    }

    /* renamed from: N */
    public static float m88231N(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106278);
        float c = C46631f.m88235c(motionEvent, 0) - C46631f.m88235c(motionEvent, 1);
        float d = C46631f.m88237d(motionEvent, 0) - C46631f.m88237d(motionEvent, 1);
        c = (float) Math.sqrt((double) ((c * c) + (d * d)));
        AppMethodBeat.m2505o(106278);
        return c;
    }

    /* renamed from: a */
    public static void m88234a(PointF pointF, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106279);
        if (pointF == null || motionEvent == null) {
            AppMethodBeat.m2505o(106279);
            return;
        }
        pointF.set((C46631f.m88235c(motionEvent, 0) + C46631f.m88235c(motionEvent, 1)) / 2.0f, (C46631f.m88237d(motionEvent, 0) + C46631f.m88237d(motionEvent, 1)) / 2.0f);
        AppMethodBeat.m2505o(106279);
    }

    /* renamed from: a */
    public static void m88233a(PointF pointF, Bitmap bitmap) {
        AppMethodBeat.m2504i(106280);
        if (pointF == null || bitmap == null) {
            AppMethodBeat.m2505o(106280);
            return;
        }
        pointF.set(((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        AppMethodBeat.m2505o(106280);
    }

    /* renamed from: c */
    public static float m88235c(MotionEvent motionEvent, int i) {
        AppMethodBeat.m2504i(106281);
        float x;
        if (C46631f.m88230M(motionEvent)) {
            C40669e c40669e = new C40669e();
            x = motionEvent.getX(i);
            AppMethodBeat.m2505o(106281);
            return x;
        }
        x = motionEvent.getX();
        AppMethodBeat.m2505o(106281);
        return x;
    }

    /* renamed from: d */
    public static float m88237d(MotionEvent motionEvent, int i) {
        AppMethodBeat.m2504i(106282);
        float y;
        if (C46631f.m88230M(motionEvent)) {
            C40669e c40669e = new C40669e();
            y = motionEvent.getY(i);
            AppMethodBeat.m2505o(106282);
            return y;
        }
        y = motionEvent.getY();
        AppMethodBeat.m2505o(106282);
        return y;
    }

    /* renamed from: O */
    public static int m88232O(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(106283);
        if (C46631f.dzs()) {
            C40669e c40669e = new C40669e();
            int pointerCount = motionEvent.getPointerCount();
            AppMethodBeat.m2505o(106283);
            return pointerCount;
        }
        AppMethodBeat.m2505o(106283);
        return 1;
    }

    /* renamed from: c */
    public static void m88236c(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(106284);
        if (C46631f.dzs()) {
            C40669e c40669e = new C40669e();
            keyEvent.startTracking();
        }
        AppMethodBeat.m2505o(106284);
    }

    /* renamed from: d */
    public static boolean m88238d(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(106285);
        if (C46631f.dzs()) {
            C40669e c40669e = new C40669e();
            boolean isTracking = keyEvent.isTracking();
            AppMethodBeat.m2505o(106285);
            return isTracking;
        }
        AppMethodBeat.m2505o(106285);
        return false;
    }

    /* renamed from: e */
    public static boolean m88239e(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(106286);
        if (C46631f.dzs()) {
            C40669e c40669e = new C40669e();
            boolean isCanceled = keyEvent.isCanceled();
            AppMethodBeat.m2505o(106286);
            return isCanceled;
        }
        AppMethodBeat.m2505o(106286);
        return false;
    }
}
