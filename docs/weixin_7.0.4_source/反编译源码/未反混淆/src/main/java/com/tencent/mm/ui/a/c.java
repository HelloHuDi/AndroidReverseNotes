package com.tencent.mm.ui.a;

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
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.a.a.AnonymousClass1;
import com.tencent.mm.ui.a.a.a;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c extends AccessibilityDelegate {
    private boolean yra = false;

    public c() {
        boolean z;
        AppMethodBeat.i(106143);
        a dzk = a.yqY;
        AudioManager audioManager = (AudioManager) dzk.Gn.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!dzk.dzj() || (Secure.getInt(dzk.Gn.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            z = false;
        } else {
            z = true;
        }
        this.yra = z;
        AppMethodBeat.o(106143);
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
        AppMethodBeat.i(106144);
        if (this.yra) {
            if (view != null && (i == 128 || i == 1)) {
                CharSequence text;
                if (view instanceof EditText) {
                    EditText editText = (EditText) view;
                    text = !bo.ac(editText.getText()) ? editText.getText() : !bo.ac(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
                } else {
                    text = view instanceof TextView ? bo.ac(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription() : view.getContentDescription();
                }
                ab.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", text);
                if (bo.ac(text)) {
                    AppMethodBeat.o(106144);
                    return;
                }
                a dzk = a.yqY;
                String charSequence = text.toString();
                if (dzk.yqU == null) {
                    dzk.yqU = new TextToSpeech(dzk.Gn, new AnonymousClass1(charSequence));
                } else {
                    dzk.yqU.setLanguage(aa.don() ? Locale.CHINESE : Locale.ENGLISH);
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
                    ab.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", e, "", new Object[0]);
                }
                if (dzk.kgA != null) {
                    dzk.kgA = (Vibrator) ah.getContext().getSystemService("vibrator");
                }
                if (dzk.kgA != null) {
                    dzk.kgA.vibrate(50);
                }
            }
            AppMethodBeat.o(106144);
            return;
        }
        AppMethodBeat.o(106144);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}
