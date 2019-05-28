package com.google.android.gms.common.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputMethodUtils {
    private InputMethodUtils() {
    }

    public static boolean hideSoftInput(Context context, View view) {
        AppMethodBeat.i(90239);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            zzf.hideSoftInputFromWindow(view.getWindowToken(), 0);
            AppMethodBeat.o(90239);
            return true;
        }
        AppMethodBeat.o(90239);
        return false;
    }

    public static boolean isAcceptingText(Context context) {
        AppMethodBeat.i(90241);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            boolean isAcceptingText = zzf.isAcceptingText();
            AppMethodBeat.o(90241);
            return isAcceptingText;
        }
        AppMethodBeat.o(90241);
        return false;
    }

    public static void restart(Context context, View view) {
        AppMethodBeat.i(90240);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            zzf.restartInput(view);
        }
        AppMethodBeat.o(90240);
    }

    public static boolean showSoftInput(Context context, View view) {
        AppMethodBeat.i(90238);
        InputMethodManager zzf = zzf(context);
        if (zzf != null) {
            zzf.showSoftInput(view, 0);
            AppMethodBeat.o(90238);
            return true;
        }
        AppMethodBeat.o(90238);
        return false;
    }

    private static InputMethodManager zzf(Context context) {
        AppMethodBeat.i(90237);
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        AppMethodBeat.o(90237);
        return inputMethodManager;
    }
}
