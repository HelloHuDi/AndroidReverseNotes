package com.tencent.p177mm.plugin.fts.p419a.p420a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20839d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20841c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20842b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.a.d */
public final class C39127d {
    public TextPaint eNN;
    public boolean mDA;
    public boolean mDC;
    public C28108a mDD = C28108a.Foreground;
    public int mDE = Color.parseColor("#07C160");
    public float mDF;
    public CharSequence mDG = "";
    public CharSequence mDH = "";
    public String mDI = "";
    public String mDJ = "";
    public CharSequence mDy;
    public C20840g mDz;

    /* renamed from: com.tencent.mm.plugin.fts.a.a.d$b */
    public static class C12025b implements Comparable<C12025b> {
        public C20841c mDO;
        public int mDP = -1;
        public int mDQ = -1;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.mDP - ((C12025b) obj).mDP;
        }

        public final boolean isAvailable() {
            return (this.mDP == -1 || this.mDQ == -1) ? false : true;
        }

        public final String bAk() {
            AppMethodBeat.m2504i(114241);
            if (this.mDO != null && this.mDO.mEg.size() > 0) {
                for (C20842b c20842b : this.mDO.mEg) {
                    if (c20842b.mEe == C20839d.OTHER) {
                        String str = c20842b.content;
                        AppMethodBeat.m2505o(114241);
                        return str;
                    }
                }
            }
            AppMethodBeat.m2505o(114241);
            return null;
        }

        public final String toString() {
            AppMethodBeat.m2504i(114242);
            String str = "FTSQueryHLRequest.Item %s %d %d";
            Object[] objArr = new Object[3];
            objArr[0] = this.mDO == null ? "" : this.mDO.bAn().replaceAll("​", ",");
            objArr[1] = Integer.valueOf(this.mDP);
            objArr[2] = Integer.valueOf(this.mDQ);
            String format = String.format(str, objArr);
            AppMethodBeat.m2505o(114242);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.a.d$a */
    public enum C28108a {
        Foreground,
        Background,
        CustomTag;

        static {
            AppMethodBeat.m2505o(114240);
        }
    }

    public C39127d() {
        AppMethodBeat.m2504i(114243);
        AppMethodBeat.m2505o(114243);
    }

    /* renamed from: a */
    public static final C39127d m66571a(CharSequence charSequence, List<String> list) {
        AppMethodBeat.m2504i(114244);
        C39127d b = C39127d.m66573b(charSequence, C5046bo.m7536c((List) list, " "));
        AppMethodBeat.m2505o(114244);
        return b;
    }

    /* renamed from: b */
    public static final C39127d m66573b(CharSequence charSequence, String str) {
        AppMethodBeat.m2504i(114245);
        C39127d c39127d = new C39127d();
        c39127d.mDy = charSequence;
        c39127d.mDz = C20840g.m32052aO(str, false);
        c39127d.mDA = false;
        c39127d.mDC = false;
        AppMethodBeat.m2505o(114245);
        return c39127d;
    }

    /* renamed from: a */
    public static final C39127d m66566a(CharSequence charSequence, C20840g c20840g) {
        AppMethodBeat.m2504i(114246);
        C39127d c39127d = new C39127d();
        c39127d.mDy = charSequence;
        c39127d.mDz = c20840g;
        AppMethodBeat.m2505o(114246);
        return c39127d;
    }

    /* renamed from: a */
    public static final C39127d m66568a(CharSequence charSequence, C20840g c20840g, boolean z, boolean z2) {
        AppMethodBeat.m2504i(114247);
        C39127d a = C39127d.m66569a(charSequence, c20840g, z, z2, 0.0f, null);
        AppMethodBeat.m2505o(114247);
        return a;
    }

    /* renamed from: a */
    public static final C39127d m66567a(CharSequence charSequence, C20840g c20840g, float f, TextPaint textPaint) {
        AppMethodBeat.m2504i(114248);
        C39127d a = C39127d.m66569a(charSequence, c20840g, false, false, f, textPaint);
        AppMethodBeat.m2505o(114248);
        return a;
    }

    /* renamed from: a */
    public static final C39127d m66569a(CharSequence charSequence, C20840g c20840g, boolean z, boolean z2, float f, TextPaint textPaint) {
        AppMethodBeat.m2504i(114249);
        C39127d c39127d = new C39127d();
        c39127d.mDy = charSequence;
        c39127d.mDz = c20840g;
        c39127d.mDA = z;
        c39127d.mDC = z2;
        c39127d.mDF = f;
        c39127d.eNN = textPaint;
        AppMethodBeat.m2505o(114249);
        return c39127d;
    }

    /* renamed from: a */
    public static final C39127d m66570a(CharSequence charSequence, C20840g c20840g, boolean z, boolean z2, TextPaint textPaint, CharSequence charSequence2, CharSequence charSequence3) {
        AppMethodBeat.m2504i(114250);
        C39127d c39127d = new C39127d();
        c39127d.mDy = charSequence;
        c39127d.mDz = c20840g;
        c39127d.mDA = z;
        c39127d.mDC = z2;
        c39127d.mDF = 400.0f;
        c39127d.eNN = textPaint;
        c39127d.mDG = charSequence2;
        c39127d.mDH = charSequence3;
        AppMethodBeat.m2505o(114250);
        return c39127d;
    }

    /* renamed from: a */
    public static final C39127d m66572a(CharSequence charSequence, List<String> list, C28108a c28108a, int i) {
        AppMethodBeat.m2504i(114251);
        C39127d a = C39127d.m66571a(charSequence, (List) list);
        a.mDD = c28108a;
        a.mDE = i;
        AppMethodBeat.m2505o(114251);
        return a;
    }
}
