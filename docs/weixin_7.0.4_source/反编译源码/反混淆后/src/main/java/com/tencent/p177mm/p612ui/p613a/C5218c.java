package com.tencent.p177mm.p612ui.p613a;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.p613a.C5216a.C52141;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
/* renamed from: com.tencent.mm.ui.a.c */
public final class C5218c extends AccessibilityDelegate {
    private boolean yra = false;

    public C5218c() {
        boolean z;
        AppMethodBeat.m2504i(106143);
        C5216a dzk = C5215a.yqY;
        AudioManager audioManager = (AudioManager) dzk.f1297Gn.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!dzk.dzj() || (Secure.getInt(dzk.f1297Gn.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            z = false;
        } else {
            z = true;
        }
        this.yra = z;
        AppMethodBeat.m2505o(106143);
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return true;
    }

    public final void sendAccessibilityEvent(View view, int i) {
        AppMethodBeat.m2504i(106144);
        if (this.yra) {
            if (view != null && (i == 128 || i == 1)) {
                CharSequence text;
                if (view instanceof EditText) {
                    EditText editText = (EditText) view;
                    text = !C5046bo.m7519ac(editText.getText()) ? editText.getText() : !C5046bo.m7519ac(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
                } else {
                    text = view instanceof TextView ? C5046bo.m7519ac(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription() : view.getContentDescription();
                }
                C4990ab.m7411d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", text);
                if (C5046bo.m7519ac(text)) {
                    AppMethodBeat.m2505o(106144);
                    return;
                }
                C5216a dzk = C5215a.yqY;
                String charSequence = text.toString();
                if (dzk.yqU == null) {
                    dzk.yqU = new TextToSpeech(dzk.f1297Gn, new C52141(charSequence));
                } else {
                    dzk.yqU.setLanguage(C4988aa.don() ? Locale.CHINESE : Locale.ENGLISH);
                    dzk.yqU.speak(charSequence, 0, null);
                }
                Class cls = View.class;
                try {
                    Method method = cls.getMethod("clearAccessibilityFocus", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(view, new Object[0]);
                    Method method2 = cls.getMethod("requestAccessibilityFocus", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(view, new Object[0]);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", e, "", new Object[0]);
                }
                if (dzk.kgA != null) {
                    dzk.kgA = (Vibrator) C4996ah.getContext().getSystemService("vibrator");
                }
                if (dzk.kgA != null) {
                    dzk.kgA.vibrate(50);
                }
            }
            AppMethodBeat.m2505o(106144);
            return;
        }
        AppMethodBeat.m2505o(106144);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}
