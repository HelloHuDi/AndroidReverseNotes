package com.tencent.p177mm.plugin.appbrand.widget.base;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.base.a */
public final class C19810a {
    /* renamed from: a */
    public static void m30644a(String str, String str2, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(77394);
        if (C4990ab.getLogLevel() > 0) {
            AppMethodBeat.m2505o(77394);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2).append(' ');
        stringBuilder.append("[apptouch] MotionEvent { action=").append(C19810a.actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            stringBuilder.append(", x[").append(i).append("]=").append(motionEvent.getX(i));
            stringBuilder.append(", y[").append(i).append("]=").append(motionEvent.getY(i));
        }
        stringBuilder.append(", downTime=").append(motionEvent.getDownTime());
        stringBuilder.append(" }");
        C4990ab.m7418v(str, stringBuilder.toString());
        AppMethodBeat.m2505o(77394);
    }

    /* renamed from: D */
    public static String m30643D(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(77395);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MotionEvent { action=").append(C19810a.actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            stringBuilder.append(", x[").append(i).append("]=").append(motionEvent.getX(i));
            stringBuilder.append(", y[").append(i).append("]=").append(motionEvent.getY(i));
        }
        stringBuilder.append(", downTime=").append(motionEvent.getDownTime());
        stringBuilder.append(" }");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(77395);
        return stringBuilder2;
    }

    private static String actionToString(int i) {
        AppMethodBeat.m2504i(77396);
        String str;
        switch (i) {
            case 0:
                str = "ACTION_DOWN";
                AppMethodBeat.m2505o(77396);
                return str;
            case 1:
                str = "ACTION_UP";
                AppMethodBeat.m2505o(77396);
                return str;
            case 2:
                str = "ACTION_MOVE";
                AppMethodBeat.m2505o(77396);
                return str;
            case 3:
                str = "ACTION_CANCEL";
                AppMethodBeat.m2505o(77396);
                return str;
            case 4:
                str = "ACTION_OUTSIDE";
                AppMethodBeat.m2505o(77396);
                return str;
            case 7:
                str = "ACTION_HOVER_MOVE";
                AppMethodBeat.m2505o(77396);
                return str;
            case 8:
                str = "ACTION_SCROLL";
                AppMethodBeat.m2505o(77396);
                return str;
            case 9:
                str = "ACTION_HOVER_ENTER";
                AppMethodBeat.m2505o(77396);
                return str;
            case 10:
                str = "ACTION_HOVER_EXIT";
                AppMethodBeat.m2505o(77396);
                return str;
            case 11:
                str = "ACTION_BUTTON_PRESS";
                AppMethodBeat.m2505o(77396);
                return str;
            case 12:
                str = "ACTION_BUTTON_RELEASE";
                AppMethodBeat.m2505o(77396);
                return str;
            default:
                int i2 = (65280 & i) >> 8;
                switch (i & 255) {
                    case 5:
                        str = "ACTION_POINTER_DOWN(" + i2 + ")";
                        AppMethodBeat.m2505o(77396);
                        return str;
                    case 6:
                        str = "ACTION_POINTER_UP(" + i2 + ")";
                        AppMethodBeat.m2505o(77396);
                        return str;
                    default:
                        str = Integer.toString(i);
                        AppMethodBeat.m2505o(77396);
                        return str;
                }
        }
    }
}
