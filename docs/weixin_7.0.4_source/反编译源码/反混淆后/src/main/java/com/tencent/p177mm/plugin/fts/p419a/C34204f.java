package com.tencent.p177mm.plugin.fts.p419a;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20839d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20841c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20842b;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.C12025b;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.C28108a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45965e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.f */
public final class C34204f {
    /* renamed from: a */
    public static final C45965e m56087a(String str, String str2, C39127d c39127d) {
        AppMethodBeat.m2504i(114218);
        C45965e a = C34204f.m56086a(c39127d);
        a.mDR = TextUtils.concat(new CharSequence[]{str, a.mDR, str2});
        AppMethodBeat.m2505o(114218);
        return a;
    }

    /* renamed from: j */
    public static final SpannableString m56095j(CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(114219);
        SpannableString spannableString = new SpannableString(charSequence);
        C12025b c12025b = new C12025b();
        c12025b.mDP = 0;
        c12025b.mDQ = i;
        C34204f.m56092b(spannableString, c12025b, new C39127d());
        AppMethodBeat.m2505o(114219);
        return spannableString;
    }

    /* renamed from: a */
    public static final C45965e m56086a(C39127d c39127d) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(114220);
        C45965e c45965e = new C45965e();
        Spannable spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{c39127d.mDG, c39127d.mDy, c39127d.mDH}));
        c45965e.bFZ = -1;
        c45965e.mDR = spannableString;
        if (C5046bo.m7519ac(c39127d.mDy) || c39127d.mDz == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(114220);
            return c45965e;
        }
        List aM;
        Object aM2;
        String Nb = C3161d.m5404Nb(c39127d.mDy.toString());
        ArrayList arrayList = new ArrayList();
        if (c39127d.mDA) {
            aM2 = C34204f.m56091aM(Nb, c39127d.mDC);
        } else {
            aM2 = arrayList;
        }
        C12025b c12025b;
        C45965e b;
        if (c39127d.mDz.mEc.size() == 1 || C34204f.m56090a(spannableString, c39127d)) {
            c12025b = new C12025b();
            if (c39127d.mDz.mEc.size() == 1) {
                c12025b.mDO = (C20841c) c39127d.mDz.mEc.get(0);
                if (c39127d.mDA) {
                    C34204f.m56089a(aM2, c12025b, c39127d);
                } else {
                    C34204f.m56088a(Nb, c12025b, c39127d);
                }
                if (c12025b.isAvailable()) {
                    try {
                        b = C34204f.m56092b(spannableString, c12025b, c39127d);
                    } catch (Exception e) {
                        c45965e.mDR = spannableString;
                        b = c45965e;
                    }
                    AppMethodBeat.m2505o(114220);
                    return b;
                }
                AppMethodBeat.m2505o(114220);
                return c45965e;
            }
            c12025b.mDO = (C20841c) c39127d.mDz.mEc.get(0);
            if (c39127d.mDA) {
                C34204f.m56089a(aM2, c12025b, c39127d);
            } else {
                C34204f.m56088a(Nb, c12025b, c39127d);
            }
            if (c12025b.isAvailable()) {
                try {
                    c45965e = C34204f.m56092b(spannableString, c12025b, c39127d);
                } catch (Exception e2) {
                    c45965e.mDR = spannableString;
                }
            }
            String charSequence = c45965e.mDR.toString();
            arrayList = new ArrayList();
            if (c39127d.mDA) {
                aM2 = C34204f.m56091aM(charSequence, c39127d.mDC);
            } else {
                aM2 = arrayList;
            }
            while (i2 < c39127d.mDz.mEc.size()) {
                c12025b.mDO = (C20841c) c39127d.mDz.mEc.get(i2);
                if (c39127d.mDA) {
                    C34204f.m56089a(aM2, c12025b, c39127d);
                } else {
                    C34204f.m56088a(charSequence, c12025b, c39127d);
                }
                if (c12025b.isAvailable()) {
                    try {
                        c45965e = C34204f.m56092b((Spannable) c45965e.mDR, c12025b, c39127d);
                    } catch (Exception e3) {
                        c45965e.mDR = spannableString;
                    }
                }
                i2++;
            }
            AppMethodBeat.m2505o(114220);
            return c45965e;
        }
        C12025b c12025b2 = new C12025b();
        c12025b2.mDO = new C20841c();
        C20842b c20842b = new C20842b();
        c20842b.mEe = C20839d.OTHER;
        c20842b.content = c39127d.mDz.mDZ;
        c12025b2.mDO.mEg.add(c20842b);
        if (c39127d.mDA) {
            C34204f.m56089a(aM2, c12025b2, c39127d);
        } else {
            C34204f.m56088a(Nb, c12025b2, c39127d);
        }
        if (c12025b2.isAvailable()) {
            try {
                c45965e = C34204f.m56092b(spannableString, c12025b2, c39127d);
            } catch (Exception e4) {
                c45965e.mDR = spannableString;
            }
            AppMethodBeat.m2505o(114220);
            return c45965e;
        }
        ArrayList<C12025b> arrayList2 = new ArrayList();
        for (C20841c c20841c : c39127d.mDz.mEc) {
            c12025b = new C12025b();
            c12025b.mDO = c20841c;
            arrayList2.add(c12025b);
        }
        for (C12025b c12025b22 : arrayList2) {
            if (c39127d.mDA) {
                C34204f.m56089a(aM2, c12025b22, c39127d);
            } else {
                C34204f.m56088a(Nb, c12025b22, c39127d);
            }
        }
        for (C12025b c12025b222 : arrayList2) {
            if (c12025b222.isAvailable()) {
                b = C34204f.m56092b(spannableString, c12025b222, c39127d);
                if (b.bFZ == 0) {
                    c45965e = b;
                }
            }
        }
        AppMethodBeat.m2505o(114220);
        return c45965e;
    }

    /* renamed from: a */
    private static boolean m56090a(Spannable spannable, C39127d c39127d) {
        AppMethodBeat.m2504i(114221);
        if (c39127d.mDF <= 0.0f || c39127d.eNN == null) {
            AppMethodBeat.m2505o(114221);
            return false;
        } else if (c39127d.mDF - (c39127d.eNN.getTextSize() * 2.0f) < c39127d.eNN.measureText(spannable.toString())) {
            AppMethodBeat.m2505o(114221);
            return true;
        } else {
            AppMethodBeat.m2505o(114221);
            return false;
        }
    }

    /* renamed from: a */
    private static C45965e m56085a(Spannable spannable, C12025b c12025b, C39127d c39127d) {
        AppMethodBeat.m2504i(114222);
        C45965e c45965e = new C45965e();
        float textSize = c39127d.mDF - (c39127d.eNN.getTextSize() * 2.0f);
        float measureText = c39127d.eNN.measureText("…");
        float measureText2 = c39127d.eNN.measureText(spannable, 0, c12025b.mDP);
        float measureText3 = c39127d.eNN.measureText(spannable, c12025b.mDP, c12025b.mDQ);
        float measureText4 = c39127d.eNN.measureText(spannable, c12025b.mDQ, spannable.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            C45965e c = C34204f.m56093c(spannable, c12025b, c39127d);
            AppMethodBeat.m2505o(114222);
            return c;
        }
        CharSequence spannableString;
        CharSequence subSequence = spannable.subSequence(c12025b.mDP, c12025b.mDQ);
        if (c39127d.mDD == C28108a.CustomTag) {
            spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{c39127d.mDI, subSequence, c39127d.mDJ}));
        } else {
            Object backgroundColorSpan;
            if (c39127d.mDD == C28108a.Background) {
                backgroundColorSpan = new BackgroundColorSpan(c39127d.mDE);
            } else {
                backgroundColorSpan = new ForegroundColorSpan(c39127d.mDE);
            }
            CharSequence spannableString2 = new SpannableString(subSequence);
            try {
                spannableString2.setSpan(backgroundColorSpan, 0, spannableString2.length(), 33);
                spannableString = spannableString2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", c12025b.toString());
                c45965e.bFZ = -1;
                c45965e.mDR = spannable;
                AppMethodBeat.m2505o(114222);
                return c45965e;
            }
        }
        SpannableStringBuilder spannableStringBuilder;
        if ((measureText2 + measureText3) + measureText < textSize) {
            spannableStringBuilder = new SpannableStringBuilder(spannable, 0, c12025b.mDP);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(c12025b.mDQ, spannable.length()), c39127d.eNN, (textSize - measureText2) - measureText3, TruncateAt.END));
            c45965e.mDR = spannableStringBuilder;
        } else if ((measureText + measureText3) + measureText4 < textSize) {
            spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(0, c12025b.mDP), c39127d.eNN, (textSize - measureText3) - measureText4, TruncateAt.START));
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(spannable, c12025b.mDQ, spannable.length());
            c45965e.mDR = spannableStringBuilder;
        } else if ((measureText + measureText3) + measureText >= textSize) {
            spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(TextUtils.ellipsize(spannableString, c39127d.eNN, textSize, TruncateAt.END));
            c45965e.mDR = spannableStringBuilder;
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
            textSize = (textSize - measureText3) / 2.0f;
            CharSequence subSequence2 = spannable.subSequence(0, c12025b.mDP);
            CharSequence subSequence3 = spannable.subSequence(c12025b.mDQ, spannable.length());
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence2, c39127d.eNN, textSize, TruncateAt.START));
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence3, c39127d.eNN, textSize, TruncateAt.END));
            c45965e.mDR = spannableStringBuilder;
        }
        c45965e.bFZ = 0;
        AppMethodBeat.m2505o(114222);
        return c45965e;
    }

    /* renamed from: b */
    private static C45965e m56092b(Spannable spannable, C12025b c12025b, C39127d c39127d) {
        AppMethodBeat.m2504i(114223);
        C45965e a;
        if (C34204f.m56090a(spannable, c39127d)) {
            a = C34204f.m56085a(spannable, c12025b, c39127d);
            AppMethodBeat.m2505o(114223);
            return a;
        }
        a = C34204f.m56093c(spannable, c12025b, c39127d);
        AppMethodBeat.m2505o(114223);
        return a;
    }

    /* renamed from: c */
    private static C45965e m56093c(Spannable spannable, C12025b c12025b, C39127d c39127d) {
        AppMethodBeat.m2504i(114224);
        C45965e c45965e = new C45965e();
        if (c39127d.mDD == C28108a.CustomTag) {
            String obj = spannable.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.substring(0, c12025b.mDP));
            stringBuffer.append(c39127d.mDI);
            stringBuffer.append(obj.substring(c12025b.mDP, c12025b.mDQ));
            stringBuffer.append(c39127d.mDJ);
            if (c12025b.mDQ < obj.length()) {
                stringBuffer.append(obj.substring(c12025b.mDQ, obj.length()));
            }
            c45965e.mDR = stringBuffer.toString();
            c45965e.bFZ = 0;
        } else {
            Object backgroundColorSpan;
            if (c39127d.mDD == C28108a.Background) {
                backgroundColorSpan = new BackgroundColorSpan(c39127d.mDE);
            } else {
                backgroundColorSpan = new ForegroundColorSpan(c39127d.mDE);
            }
            try {
                spannable.setSpan(backgroundColorSpan, c12025b.mDP, c12025b.mDQ, 18);
                c45965e.mDR = spannable;
                c45965e.bFZ = 0;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", c12025b.toString());
                c45965e.mDR = spannable;
                c45965e.bFZ = -1;
            }
        }
        AppMethodBeat.m2505o(114224);
        return c45965e;
    }

    /* renamed from: a */
    private static void m56088a(String str, C12025b c12025b, C39127d c39127d) {
        AppMethodBeat.m2504i(114225);
        String bAk = c12025b.bAk();
        if (C5046bo.isNullOrNil(bAk)) {
            AppMethodBeat.m2505o(114225);
            return;
        }
        int indexOf = str.indexOf(bAk);
        if (indexOf >= 0) {
            c12025b.mDP = indexOf;
            c12025b.mDQ = bAk.length() + indexOf;
        }
        if (c12025b.isAvailable() && c39127d.mDG != null) {
            c12025b.mDP += c39127d.mDG.length();
            c12025b.mDQ += c39127d.mDG.length();
        }
        AppMethodBeat.m2505o(114225);
    }

    /* renamed from: a */
    private static void m56089a(List<List<String>> list, C12025b c12025b, C39127d c39127d) {
        AppMethodBeat.m2504i(114226);
        C20842b c20842b;
        if (c39127d.mDC) {
            for (C20842b c20842b2 : c12025b.mDO.mEg) {
                if (c20842b2.mEe == C20839d.ShortPY) {
                    break;
                }
            }
            c20842b2 = null;
            if (c20842b2 == null) {
                AppMethodBeat.m2505o(114226);
                return;
            }
            int h = C34204f.m56094h(list, c20842b2.mEf);
            if (h >= 0) {
                c12025b.mDP = h;
                c12025b.mDQ = c20842b2.mEf.size() + h;
            }
        } else {
            for (C20842b c20842b22 : c12025b.mDO.mEg) {
                if (c20842b22.mEe == C20839d.FullPY) {
                    int h2 = C34204f.m56094h(list, c20842b22.mEf);
                    if (h2 >= 0) {
                        c12025b.mDP = h2;
                        c12025b.mDQ = c20842b22.mEf.size() + h2;
                        break;
                    }
                }
            }
        }
        if (c12025b.isAvailable() && c39127d.mDG != null) {
            c12025b.mDP += c39127d.mDG.length();
            c12025b.mDQ += c39127d.mDG.length();
        }
        AppMethodBeat.m2505o(114226);
    }

    /* renamed from: h */
    private static int m56094h(List<List<String>> list, List<String> list2) {
        AppMethodBeat.m2504i(114227);
        int i = 0;
        int i2 = 0;
        while (i < (list.size() - list2.size()) + 1) {
            Object obj;
            while (true) {
                int i3 = i2;
                if (i3 >= list2.size()) {
                    int obj2 = 1;
                    i2 = i3;
                    break;
                }
                List<String> list3 = (List) list.get(i + i3);
                String str = (String) list2.get(i3);
                if (!list3.contains(str)) {
                    if (i3 != list2.size() - 1) {
                        obj2 = null;
                        i2 = 0;
                        break;
                    }
                    for (String startsWith : list3) {
                        if (startsWith.startsWith(str)) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        obj2 = null;
                        i2 = 0;
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (obj2 != null) {
                break;
            }
            i++;
        }
        i = -1;
        AppMethodBeat.m2505o(114227);
        return i;
    }

    /* renamed from: aM */
    private static List<List<String>> m56091aM(String str, boolean z) {
        AppMethodBeat.m2504i(114228);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            ArrayList arrayList2 = new ArrayList(2);
            if (C34205g.m56097t(charAt)) {
                String[] strArr = (String[]) C34205g.mDn.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(arrayList2);
                } else {
                    for (Object obj : strArr) {
                        Object obj2;
                        if (z) {
                            obj2 = obj2.substring(0, 1);
                        }
                        if (!arrayList2.contains(obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList.add(arrayList2);
            }
        }
        AppMethodBeat.m2505o(114228);
        return arrayList;
    }

    @Deprecated
    /* renamed from: a */
    public static Spannable m56084a(CharSequence charSequence, String str) {
        AppMethodBeat.m2504i(114229);
        C45965e a = C34204f.m56086a(C39127d.m66573b(charSequence, str));
        Spannable spannable;
        if (a.mDR instanceof Spannable) {
            spannable = (Spannable) a.mDR;
            AppMethodBeat.m2505o(114229);
            return spannable;
        }
        spannable = new SpannableString(a.mDR);
        AppMethodBeat.m2505o(114229);
        return spannable;
    }
}
