package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static void a(String str, String str2, MotionEvent motionEvent) {
        AppMethodBeat.i(77394);
        if (ab.getLogLevel() > 0) {
            AppMethodBeat.o(77394);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2).append(' ');
        stringBuilder.append("[apptouch] MotionEvent { action=").append(actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            stringBuilder.append(", x[").append(i).append("]=").append(motionEvent.getX(i));
            stringBuilder.append(", y[").append(i).append("]=").append(motionEvent.getY(i));
        }
        stringBuilder.append(", downTime=").append(motionEvent.getDownTime());
        stringBuilder.append(" }");
        ab.v(str, stringBuilder.toString());
        AppMethodBeat.o(77394);
    }

    public static String D(MotionEvent motionEvent) {
        AppMethodBeat.i(77395);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MotionEvent { action=").append(actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            stringBuilder.append(", x[").append(i).append("]=").append(motionEvent.getX(i));
            stringBuilder.append(", y[").append(i).append("]=").append(motionEvent.getY(i));
        }
        stringBuilder.append(", downTime=").append(motionEvent.getDownTime());
        stringBuilder.append(" }");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(77395);
        return stringBuilder2;
    }

    private static String actionToString(int i) {
        AppMethodBeat.i(77396);
        String str;
        switch (i) {
            case 0:
                str = "ACTION_DOWN";
                AppMethodBeat.o(77396);
                return str;
            case 1:
                str = "ACTION_UP";
                AppMethodBeat.o(77396);
                return str;
            case 2:
                str = "ACTION_MOVE";
                AppMethodBeat.o(77396);
                return str;
            case 3:
                str = "ACTION_CANCEL";
                AppMethodBeat.o(77396);
                return str;
            case 4:
                str = "ACTION_OUTSIDE";
                AppMethodBeat.o(77396);
                return str;
            case 7:
                str = "ACTION_HOVER_MOVE";
                AppMethodBeat.o(77396);
                return str;
            case 8:
                str = "ACTION_SCROLL";
                AppMethodBeat.o(77396);
                return str;
            case 9:
                str = "ACTION_HOVER_ENTER";
                AppMethodBeat.o(77396);
                return str;
            case 10:
                str = "ACTION_HOVER_EXIT";
                AppMethodBeat.o(77396);
                return str;
            case 11:
                str = "ACTION_BUTTON_PRESS";
                AppMethodBeat.o(77396);
                return str;
            case 12:
                str = "ACTION_BUTTON_RELEASE";
                AppMethodBeat.o(77396);
                return str;
            default:
                int i2 = (65280 & i) >> 8;
                switch (i & 255) {
                    case 5:
                        str = "ACTION_POINTER_DOWN(" + i2 + ")";
                        AppMethodBeat.o(77396);
                        return str;
                    case 6:
                        str = "ACTION_POINTER_UP(" + i2 + ")";
                        AppMethodBeat.o(77396);
                        return str;
                    default:
                        str = Integer.toString(i);
                        AppMethodBeat.o(77396);
                        return str;
                }
        }
    }
}
