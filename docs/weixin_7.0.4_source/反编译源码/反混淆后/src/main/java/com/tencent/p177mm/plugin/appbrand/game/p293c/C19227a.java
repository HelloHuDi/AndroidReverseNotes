package com.tencent.p177mm.plugin.appbrand.game.p293c;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.handler.glfont.C45129b;
import com.tencent.magicbrush.p1173a.C25713d.C17838a;
import com.tencent.magicbrush.p1173a.C37409a.C17835a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p211cb.C45278c;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.game.c.a */
public final class C19227a {

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.a$b */
    public static final class C19228b implements C17838a {
        private int hro;

        public C19228b() {
            this.hro = -1;
            this.hro = 927;
        }

        /* renamed from: fR */
        public final void mo33012fR(int i) {
            AppMethodBeat.m2504i(130128);
            C4990ab.m7416i("MBFontManagerRegistry", "mbfont idkey logid:" + this.hro + ",key:" + i);
            C7060h.pYm.mo15419k((long) this.hro, (long) i, 1);
            AppMethodBeat.m2505o(130128);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.a$a */
    public static final class C19229a implements C17835a {
        private C19229a() {
        }

        public /* synthetic */ C19229a(byte b) {
            this();
        }

        /* renamed from: n */
        public final int mo33009n(String str, int i) {
            AppMethodBeat.m2504i(130125);
            int a = C19229a.m29882a(str, i, null);
            AppMethodBeat.m2505o(130125);
            return a;
        }

        /* renamed from: o */
        public final Drawable mo33010o(String str, int i) {
            AppMethodBeat.m2504i(130126);
            C19681j c19681j = new C19681j();
            C19229a.m29882a(str, i, c19681j);
            Drawable a = C37626b.dqD().mo60447a((C45278c) c19681j.value, true);
            AppMethodBeat.m2505o(130126);
            return a;
        }

        /* renamed from: a */
        private static int m29882a(String str, int i, C19681j<C45278c> c19681j) {
            AppMethodBeat.m2504i(130127);
            if (str == null || i < 0 || i >= str.length()) {
                AppMethodBeat.m2505o(130127);
                return 0;
            }
            int codePointAt = str.codePointAt(i);
            C45278c Mi = C37626b.dqD().mo60446Mi(codePointAt);
            int charCount;
            if (Mi != null) {
                if (c19681j != null) {
                    c19681j.value = Mi;
                }
                charCount = Character.charCount(codePointAt);
                AppMethodBeat.m2505o(130127);
                return charCount;
            }
            int codePointAt2;
            int charCount2 = i + Character.charCount(codePointAt);
            if (charCount2 < str.length()) {
                codePointAt2 = str.codePointAt(charCount2);
            } else {
                codePointAt2 = 0;
            }
            C45278c gY = C37626b.dqD().mo60452gY(codePointAt, codePointAt2);
            if (gY == null) {
                AppMethodBeat.m2505o(130127);
                return 0;
            }
            if (gY.jil != 0) {
                codePointAt2 = Character.charCount(codePointAt2) + charCount2;
            } else {
                codePointAt2 = charCount2;
            }
            if (c19681j != null) {
                c19681j.value = gY;
            }
            charCount = codePointAt2 - i;
            AppMethodBeat.m2505o(130127);
            return charCount;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.a$1 */
    public static class C192301 implements C45129b {
        final /* synthetic */ WeakReference hrn;

        public C192301(WeakReference weakReference) {
            this.hrn = weakReference;
        }

        /* renamed from: bT */
        public final Typeface mo34439bT(String str) {
            Typeface typeface = null;
            AppMethodBeat.m2504i(130121);
            C4990ab.m7417i("MBFontManagerRegistry", "loadFont at path[%s]", str);
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(130121);
            } else {
                try {
                    typeface = Typeface.createFromFile(str);
                } catch (Exception e) {
                    C4990ab.m7413e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", str);
                }
                AppMethodBeat.m2505o(130121);
            }
            return typeface;
        }

        /* renamed from: bU */
        public final String mo34440bU(String str) {
            AppMethodBeat.m2504i(130122);
            C4990ab.m7417i("MBFontManagerRegistry", "getFontPath at path[%s]", str);
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(130122);
                return null;
            }
            C6750i c6750i = (C6750i) this.hrn.get();
            if (c6750i == null) {
                C4990ab.m7412e("MBFontManagerRegistry", "hy: runtime released");
                AppMethodBeat.m2505o(130122);
                return null;
            }
            String f;
            if (str.startsWith("wxfile://")) {
                f = C192301.m29885f(c6750i, str);
            } else {
                f = C192301.m29886g(c6750i, str);
            }
            if (f == null) {
                AppMethodBeat.m2505o(130122);
                return null;
            }
            AppMethodBeat.m2505o(130122);
            return f;
        }

        /* renamed from: f */
        private static String m29885f(C6750i c6750i, String str) {
            AppMethodBeat.m2504i(130123);
            String str2 = null;
            try {
                File yg = c6750i.asE().mo34314yg(str);
                if (yg != null) {
                    str2 = yg.getAbsolutePath();
                } else {
                    C4990ab.m7413e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", str);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MBFontManagerRegistry", "Read [%s] from filesystem failed", str);
            }
            AppMethodBeat.m2505o(130123);
            return str2;
        }

        /* renamed from: g */
        private static String m29886g(C6750i c6750i, String str) {
            AppMethodBeat.m2504i(130124);
            String str2 = null;
            try {
                str2 = C33082aw.m54074e(c6750i, str);
            } catch (Exception e) {
                C4990ab.m7413e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", str);
            }
            AppMethodBeat.m2505o(130124);
            return str2;
        }
    }
}
