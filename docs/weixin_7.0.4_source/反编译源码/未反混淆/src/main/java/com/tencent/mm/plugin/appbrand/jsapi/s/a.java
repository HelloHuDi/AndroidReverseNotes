package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class a {
    public static void a(View view, JSONObject jSONObject) {
        AppMethodBeat.i(91066);
        if (view != null && jSONObject != null && jSONObject.has("accessibility") && jSONObject.optBoolean("accessibility", false)) {
            final String optString = jSONObject.optString("ariaLabel", "");
            final String optString2 = jSONObject.optString("ariaRole", "");
            view.setAccessibilityDelegate(new AccessibilityDelegate() {
                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    AppMethodBeat.i(91065);
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    if (!bo.isNullOrNil(optString)) {
                        accessibilityNodeInfo.setContentDescription(optString);
                    }
                    if (bo.isNullOrNil(optString2) || !optString2.equalsIgnoreCase("button")) {
                        accessibilityNodeInfo.setClickable(false);
                        accessibilityNodeInfo.setClassName(TextView.class.getName());
                        AppMethodBeat.o(91065);
                        return;
                    }
                    accessibilityNodeInfo.setClickable(true);
                    accessibilityNodeInfo.setClassName(Button.class.getName());
                    AppMethodBeat.o(91065);
                }
            });
        }
        AppMethodBeat.o(91066);
    }
}
