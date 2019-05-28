package com.tencent.luggage.g;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static boolean az(Context context) {
        AppMethodBeat.i(90905);
        if (context == null) {
            AppMethodBeat.o(90905);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(90905);
            return false;
        }
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            AppMethodBeat.o(90905);
            return false;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(90905);
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(90905);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            hideSoftInputFromWindow = false;
        }
        AppMethodBeat.o(90905);
        return hideSoftInputFromWindow;
    }
}
