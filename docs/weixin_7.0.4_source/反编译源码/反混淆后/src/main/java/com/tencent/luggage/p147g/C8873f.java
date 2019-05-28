package com.tencent.luggage.p147g;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.g.f */
public final class C8873f {
    /* renamed from: az */
    public static boolean m15846az(Context context) {
        AppMethodBeat.m2504i(90905);
        if (context == null) {
            AppMethodBeat.m2505o(90905);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(90905);
            return false;
        }
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            AppMethodBeat.m2505o(90905);
            return false;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.m2505o(90905);
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.m2505o(90905);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            hideSoftInputFromWindow = false;
        }
        AppMethodBeat.m2505o(90905);
        return hideSoftInputFromWindow;
    }
}
