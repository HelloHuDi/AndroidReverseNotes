package com.tencent.p177mm.plugin.appbrand.jsapi.p901s;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.a */
public final class C27074a {
    /* renamed from: a */
    public static void m43024a(View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(91066);
        if (view != null && jSONObject != null && jSONObject.has("accessibility") && jSONObject.optBoolean("accessibility", false)) {
            final String optString = jSONObject.optString("ariaLabel", "");
            final String optString2 = jSONObject.optString("ariaRole", "");
            view.setAccessibilityDelegate(new AccessibilityDelegate() {
                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    AppMethodBeat.m2504i(91065);
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    if (!C5046bo.isNullOrNil(optString)) {
                        accessibilityNodeInfo.setContentDescription(optString);
                    }
                    if (C5046bo.isNullOrNil(optString2) || !optString2.equalsIgnoreCase("button")) {
                        accessibilityNodeInfo.setClickable(false);
                        accessibilityNodeInfo.setClassName(TextView.class.getName());
                        AppMethodBeat.m2505o(91065);
                        return;
                    }
                    accessibilityNodeInfo.setClickable(true);
                    accessibilityNodeInfo.setClassName(Button.class.getName());
                    AppMethodBeat.m2505o(91065);
                }
            });
        }
        AppMethodBeat.m2505o(91066);
    }
}
