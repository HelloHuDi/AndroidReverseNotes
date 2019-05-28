package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.c;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.lang.ref.WeakReference;

public final class a {

    public static final class b implements com.tencent.magicbrush.a.d.a {
        private int hro;

        public b() {
            this.hro = -1;
            this.hro = 927;
        }

        public final void fR(int i) {
            AppMethodBeat.i(130128);
            ab.i("MBFontManagerRegistry", "mbfont idkey logid:" + this.hro + ",key:" + i);
            h.pYm.k((long) this.hro, (long) i, 1);
            AppMethodBeat.o(130128);
        }
    }

    public static final class a implements com.tencent.magicbrush.a.a.a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final int n(String str, int i) {
            AppMethodBeat.i(130125);
            int a = a(str, i, null);
            AppMethodBeat.o(130125);
            return a;
        }

        public final Drawable o(String str, int i) {
            AppMethodBeat.i(130126);
            j jVar = new j();
            a(str, i, jVar);
            Drawable a = com.tencent.mm.cb.b.dqD().a((c) jVar.value, true);
            AppMethodBeat.o(130126);
            return a;
        }

        private static int a(String str, int i, j<c> jVar) {
            AppMethodBeat.i(130127);
            if (str == null || i < 0 || i >= str.length()) {
                AppMethodBeat.o(130127);
                return 0;
            }
            int codePointAt = str.codePointAt(i);
            c Mi = com.tencent.mm.cb.b.dqD().Mi(codePointAt);
            int charCount;
            if (Mi != null) {
                if (jVar != null) {
                    jVar.value = Mi;
                }
                charCount = Character.charCount(codePointAt);
                AppMethodBeat.o(130127);
                return charCount;
            }
            int codePointAt2;
            int charCount2 = i + Character.charCount(codePointAt);
            if (charCount2 < str.length()) {
                codePointAt2 = str.codePointAt(charCount2);
            } else {
                codePointAt2 = 0;
            }
            c gY = com.tencent.mm.cb.b.dqD().gY(codePointAt, codePointAt2);
            if (gY == null) {
                AppMethodBeat.o(130127);
                return 0;
            }
            if (gY.jil != 0) {
                codePointAt2 = Character.charCount(codePointAt2) + charCount2;
            } else {
                codePointAt2 = charCount2;
            }
            if (jVar != null) {
                jVar.value = gY;
            }
            charCount = codePointAt2 - i;
            AppMethodBeat.o(130127);
            return charCount;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.a$1 */
    public static class AnonymousClass1 implements com.tencent.magicbrush.handler.glfont.b {
        final /* synthetic */ WeakReference hrn;

        public AnonymousClass1(WeakReference weakReference) {
            this.hrn = weakReference;
        }

        public final Typeface bT(String str) {
            Typeface typeface = null;
            AppMethodBeat.i(130121);
            ab.i("MBFontManagerRegistry", "loadFont at path[%s]", str);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(130121);
            } else {
                try {
                    typeface = Typeface.createFromFile(str);
                } catch (Exception e) {
                    ab.e("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", str);
                }
                AppMethodBeat.o(130121);
            }
            return typeface;
        }

        public final String bU(String str) {
            AppMethodBeat.i(130122);
            ab.i("MBFontManagerRegistry", "getFontPath at path[%s]", str);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(130122);
                return null;
            }
            i iVar = (i) this.hrn.get();
            if (iVar == null) {
                ab.e("MBFontManagerRegistry", "hy: runtime released");
                AppMethodBeat.o(130122);
                return null;
            }
            String f;
            if (str.startsWith("wxfile://")) {
                f = AnonymousClass1.f(iVar, str);
            } else {
                f = AnonymousClass1.g(iVar, str);
            }
            if (f == null) {
                AppMethodBeat.o(130122);
                return null;
            }
            AppMethodBeat.o(130122);
            return f;
        }

        private static String f(i iVar, String str) {
            AppMethodBeat.i(130123);
            String str2 = null;
            try {
                File yg = iVar.asE().yg(str);
                if (yg != null) {
                    str2 = yg.getAbsolutePath();
                } else {
                    ab.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", str);
                }
            } catch (Exception e) {
                ab.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", str);
            }
            AppMethodBeat.o(130123);
            return str2;
        }

        private static String g(i iVar, String str) {
            AppMethodBeat.i(130124);
            String str2 = null;
            try {
                str2 = aw.e(iVar, str);
            } catch (Exception e) {
                ab.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", str);
            }
            AppMethodBeat.o(130124);
            return str2;
        }
    }
}
