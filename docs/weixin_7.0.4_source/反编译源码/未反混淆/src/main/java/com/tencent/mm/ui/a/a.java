package com.tencent.mm.ui.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Locale;

public final class a {
    public Context Gn;
    Vibrator kgA;
    private AccessibilityManager mP;
    TextToSpeech yqU = null;
    private boolean yqV;
    private long yqW;

    /* renamed from: com.tencent.mm.ui.a.a$1 */
    class AnonymousClass1 implements OnInitListener {
        final /* synthetic */ String fOH;

        AnonymousClass1(String str) {
            this.fOH = str;
        }

        public final void onInit(int i) {
            AppMethodBeat.i(106132);
            if (a.this.yqU != null) {
                a.this.yqU.setLanguage(aa.don() ? Locale.CHINESE : Locale.ENGLISH);
                a.this.yqU.speak(this.fOH, 0, null);
            }
            AppMethodBeat.o(106132);
        }
    }

    public static class a {
        private static final a yqY = new a(ah.getContext());

        static {
            AppMethodBeat.i(106133);
            AppMethodBeat.o(106133);
        }
    }

    public a(Context context) {
        AppMethodBeat.i(106134);
        this.Gn = context;
        this.mP = (AccessibilityManager) this.Gn.getSystemService("accessibility");
        AppMethodBeat.o(106134);
    }

    public final boolean dzj() {
        boolean z;
        AppMethodBeat.i(106135);
        if (SystemClock.uptimeMillis() - this.yqW > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            z = this.mP.isEnabled() && this.mP.isTouchExplorationEnabled();
            this.yqV = z;
            this.yqW = SystemClock.uptimeMillis();
        }
        z = this.yqV;
        AppMethodBeat.o(106135);
        return z;
    }

    /* JADX WARNING: Missing block: B:13:0x0033, code skipped:
            if (r0 > 0) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(View view, String str, String str2, int i) {
        AppMethodBeat.i(106136);
        if (!dzj()) {
            AppMethodBeat.o(106136);
        } else if (bo.isNullOrNil(str) || this.Gn == null) {
            AppMethodBeat.o(106136);
        } else {
            int i2;
            b bVar = new b();
            bVar.aqI(str);
            if (!bo.isNullOrNil(str2)) {
                try {
                    i2 = bo.getInt(str2, 0);
                } catch (Exception e) {
                }
            }
            i2 = 0;
            if (i2 > 0) {
                bVar.aqI(this.Gn.getResources().getQuantityString(R.plurals.a5, 1, new Object[]{Integer.valueOf(i2)}));
            }
            bVar.aqI(this.Gn.getResources().getQuantityString(R.plurals.a6, 5, new Object[]{Integer.valueOf(3), Integer.valueOf(i + 1)}));
            bVar.eD(view);
            AppMethodBeat.o(106136);
        }
    }

    public final void a(View view, String str, int i, String str2, String str3) {
        AppMethodBeat.i(106137);
        if (!dzj()) {
            AppMethodBeat.o(106137);
        } else if (this.Gn == null || view == null) {
            AppMethodBeat.o(106137);
        } else if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(106137);
        } else {
            b bVar = new b();
            bVar.aqI(str);
            if (i > 0) {
                bVar.aqI(this.Gn.getResources().getQuantityString(R.plurals.e, 1, new Object[]{Integer.valueOf(i)}));
            }
            bVar.aqI(str2).aqI(str3);
            bVar.eD(view);
            AppMethodBeat.o(106137);
        }
    }

    public final void ah(View view, int i) {
        AppMethodBeat.i(106138);
        if (!dzj()) {
            AppMethodBeat.o(106138);
        } else if (this.Gn == null || view == null) {
            AppMethodBeat.o(106138);
        } else {
            int max = Math.max(i, 1);
            b bVar = new b();
            bVar.aqI(this.Gn.getResources().getQuantityString(R.plurals.d, max, new Object[]{Integer.valueOf(max)}));
            bVar.eD(view);
            AppMethodBeat.o(106138);
        }
    }

    public final void h(Activity activity, String str) {
        AppMethodBeat.i(106139);
        if (dzj()) {
            AppMethodBeat.o(106139);
        } else if (bo.isNullOrNil(str) || activity == null) {
            AppMethodBeat.o(106139);
        } else {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(R.string.at5) + str);
            AppMethodBeat.o(106139);
        }
    }
}
