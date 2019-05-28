package com.tencent.p177mm.p612ui.p613a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.a.a */
public final class C5216a {
    /* renamed from: Gn */
    public Context f1297Gn;
    Vibrator kgA;
    /* renamed from: mP */
    private AccessibilityManager f1298mP;
    TextToSpeech yqU = null;
    private boolean yqV;
    private long yqW;

    /* renamed from: com.tencent.mm.ui.a.a$1 */
    class C52141 implements OnInitListener {
        final /* synthetic */ String fOH;

        C52141(String str) {
            this.fOH = str;
        }

        public final void onInit(int i) {
            AppMethodBeat.m2504i(106132);
            if (C5216a.this.yqU != null) {
                C5216a.this.yqU.setLanguage(C4988aa.don() ? Locale.CHINESE : Locale.ENGLISH);
                C5216a.this.yqU.speak(this.fOH, 0, null);
            }
            AppMethodBeat.m2505o(106132);
        }
    }

    /* renamed from: com.tencent.mm.ui.a.a$a */
    public static class C5215a {
        private static final C5216a yqY = new C5216a(C4996ah.getContext());

        static {
            AppMethodBeat.m2504i(106133);
            AppMethodBeat.m2505o(106133);
        }
    }

    public C5216a(Context context) {
        AppMethodBeat.m2504i(106134);
        this.f1297Gn = context;
        this.f1298mP = (AccessibilityManager) this.f1297Gn.getSystemService("accessibility");
        AppMethodBeat.m2505o(106134);
    }

    public final boolean dzj() {
        boolean z;
        AppMethodBeat.m2504i(106135);
        if (SystemClock.uptimeMillis() - this.yqW > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            z = this.f1298mP.isEnabled() && this.f1298mP.isTouchExplorationEnabled();
            this.yqV = z;
            this.yqW = SystemClock.uptimeMillis();
        }
        z = this.yqV;
        AppMethodBeat.m2505o(106135);
        return z;
    }

    /* JADX WARNING: Missing block: B:13:0x0033, code skipped:
            if (r0 > 0) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo10715a(View view, String str, String str2, int i) {
        AppMethodBeat.m2504i(106136);
        if (!dzj()) {
            AppMethodBeat.m2505o(106136);
        } else if (C5046bo.isNullOrNil(str) || this.f1297Gn == null) {
            AppMethodBeat.m2505o(106136);
        } else {
            int i2;
            C5217b c5217b = new C5217b();
            c5217b.aqI(str);
            if (!C5046bo.isNullOrNil(str2)) {
                try {
                    i2 = C5046bo.getInt(str2, 0);
                } catch (Exception e) {
                }
            }
            i2 = 0;
            if (i2 > 0) {
                c5217b.aqI(this.f1297Gn.getResources().getQuantityString(C25738R.plurals.f9618a5, 1, new Object[]{Integer.valueOf(i2)}));
            }
            c5217b.aqI(this.f1297Gn.getResources().getQuantityString(C25738R.plurals.f9619a6, 5, new Object[]{Integer.valueOf(3), Integer.valueOf(i + 1)}));
            c5217b.mo10720eD(view);
            AppMethodBeat.m2505o(106136);
        }
    }

    /* renamed from: a */
    public final void mo10714a(View view, String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(106137);
        if (!dzj()) {
            AppMethodBeat.m2505o(106137);
        } else if (this.f1297Gn == null || view == null) {
            AppMethodBeat.m2505o(106137);
        } else if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.m2505o(106137);
        } else {
            C5217b c5217b = new C5217b();
            c5217b.aqI(str);
            if (i > 0) {
                c5217b.aqI(this.f1297Gn.getResources().getQuantityString(C25738R.plurals.f9593e, 1, new Object[]{Integer.valueOf(i)}));
            }
            c5217b.aqI(str2).aqI(str3);
            c5217b.mo10720eD(view);
            AppMethodBeat.m2505o(106137);
        }
    }

    /* renamed from: ah */
    public final void mo10716ah(View view, int i) {
        AppMethodBeat.m2504i(106138);
        if (!dzj()) {
            AppMethodBeat.m2505o(106138);
        } else if (this.f1297Gn == null || view == null) {
            AppMethodBeat.m2505o(106138);
        } else {
            int max = Math.max(i, 1);
            C5217b c5217b = new C5217b();
            c5217b.aqI(this.f1297Gn.getResources().getQuantityString(C25738R.plurals.f9592d, max, new Object[]{Integer.valueOf(max)}));
            c5217b.mo10720eD(view);
            AppMethodBeat.m2505o(106138);
        }
    }

    /* renamed from: h */
    public final void mo10718h(Activity activity, String str) {
        AppMethodBeat.m2504i(106139);
        if (dzj()) {
            AppMethodBeat.m2505o(106139);
        } else if (C5046bo.isNullOrNil(str) || activity == null) {
            AppMethodBeat.m2505o(106139);
        } else {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(C25738R.string.at5) + str);
            AppMethodBeat.m2505o(106139);
        }
    }
}
