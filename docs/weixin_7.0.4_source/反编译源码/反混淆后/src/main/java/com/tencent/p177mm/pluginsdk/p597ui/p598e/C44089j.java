package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.j */
public final class C44089j {
    static LinkedList<C44086g> vrX = new LinkedList();
    private static boolean vrY = C5046bo.m7558gT(C4996ah.getContext());

    static {
        AppMethodBeat.m2504i(79849);
        AppMethodBeat.m2505o(79849);
    }

    /* renamed from: a */
    public static void m79291a(C44086g c44086g) {
        AppMethodBeat.m2504i(79819);
        vrX.add(c44086g);
        AppMethodBeat.m2505o(79819);
    }

    /* renamed from: b */
    public static void m79297b(C44086g c44086g) {
        AppMethodBeat.m2504i(79820);
        vrX.remove(c44086g);
        AppMethodBeat.m2505o(79820);
    }

    /* renamed from: a */
    public static SpannableString m79288a(Context context, CharSequence charSequence, int i, boolean z, Object obj) {
        AppMethodBeat.m2504i(79821);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsK = true;
        c40488p.vsM = true;
        c40488p.vsQ = 1;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        c40488p = c40488p.mo64022m(null);
        c40488p.vsH = true;
        c40488p.vsJ = true;
        c40488p.vsT = obj;
        SpannableString b = c40488p.mo64021b(charSequence, i, z);
        AppMethodBeat.m2505o(79821);
        return b;
    }

    /* renamed from: a */
    public static SpannableString m79289a(TextView textView, Object obj) {
        AppMethodBeat.m2504i(79822);
        SpannableString a = C44089j.m79290a(textView, true, obj);
        AppMethodBeat.m2505o(79822);
        return a;
    }

    /* renamed from: a */
    public static SpannableString m79290a(TextView textView, boolean z, Object obj) {
        AppMethodBeat.m2504i(79823);
        SpannableString spannableString;
        if (textView == null) {
            C4990ab.m7412e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(79823);
            return spannableString;
        }
        spannableString = C44089j.m79281a(textView.getContext(), textView, (int) textView.getTextSize(), z, obj);
        AppMethodBeat.m2505o(79823);
        return spannableString;
    }

    /* renamed from: h */
    public static SpannableString m79307h(TextView textView, int i) {
        AppMethodBeat.m2504i(79824);
        SpannableString spannableString;
        if (textView == null) {
            C4990ab.m7412e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(79824);
            return spannableString;
        }
        int textSize = (int) textView.getTextSize();
        C40488p c40488p = new C40488p(textView.getContext());
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsQ = i;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        C40488p m = c40488p.mo64022m(textView);
        if (i == 1) {
            m.vsH = true;
            m.vsJ = true;
        } else if (i == 2) {
            m.vsH = false;
            m.vsJ = false;
        }
        spannableString = m.mo64021b(textView.getText(), textSize, true);
        AppMethodBeat.m2505o(79824);
        return spannableString;
    }

    /* renamed from: b */
    public static SpannableString m79296b(TextView textView, Object obj) {
        AppMethodBeat.m2504i(79825);
        SpannableString spannableString;
        if (textView == null) {
            C4990ab.m7412e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(79825);
            return spannableString;
        }
        int textSize = (int) textView.getTextSize();
        C40488p c40488p = new C40488p(textView.getContext());
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsQ = 1;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        C40488p m = c40488p.mo64022m(textView);
        m.vsT = obj;
        m.hcl = null;
        m.vsH = true;
        m.vsJ = true;
        spannableString = m.mo64021b(textView.getText(), textSize, true);
        AppMethodBeat.m2505o(79825);
        return spannableString;
    }

    /* renamed from: a */
    private static SpannableString m79281a(Context context, TextView textView, int i, boolean z, Object obj) {
        AppMethodBeat.m2504i(79828);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsK = true;
        c40488p.vsM = true;
        c40488p.vsQ = 1;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        c40488p = c40488p.mo64022m(textView);
        c40488p.vsH = true;
        c40488p.vsJ = true;
        if (obj != null) {
            c40488p.vsT = obj;
        }
        SpannableString b = c40488p.mo64021b(textView.getText(), i, z);
        AppMethodBeat.m2505o(79828);
        return b;
    }

    /* renamed from: b */
    public static SpannableString m79294b(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79829);
        SpannableString a = C44089j.m79287a(context, charSequence, i, true);
        AppMethodBeat.m2505o(79829);
        return a;
    }

    /* renamed from: b */
    public static SpannableString m79293b(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(79830);
        SpannableString a = C44089j.m79287a(context, charSequence, (int) f, true);
        AppMethodBeat.m2505o(79830);
        return a;
    }

    /* renamed from: d */
    public static SpannableString m79300d(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(79831);
        SpannableString a = C44089j.m79287a(context, charSequence, (int) f, false);
        AppMethodBeat.m2505o(79831);
        return a;
    }

    /* renamed from: c */
    public static SpannableString m79298c(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79832);
        C40488p c40488p = new C40488p(context);
        c40488p.vsG = false;
        c40488p.vsH = false;
        c40488p.vsC = false;
        c40488p.vsI = false;
        c40488p.vsQ = i;
        c40488p.vsF = false;
        c40488p.vsS = false;
        SpannableString b = c40488p.mo64021b(charSequence, 0, true);
        C44089j.m79302d(b);
        AppMethodBeat.m2505o(79832);
        return b;
    }

    /* renamed from: d */
    private static void m79302d(Spannable spannable) {
        int i = 0;
        AppMethodBeat.m2504i(79833);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
        AppMethodBeat.m2505o(79833);
    }

    /* renamed from: b */
    public static SpannableString m79292b(Context context, CharSequence charSequence) {
        AppMethodBeat.m2504i(79834);
        SpannableString a = C44089j.m79287a(context, charSequence, 0, true);
        AppMethodBeat.m2505o(79834);
        return a;
    }

    /* renamed from: a */
    private static SpannableString m79287a(Context context, CharSequence charSequence, int i, boolean z) {
        AppMethodBeat.m2504i(79835);
        C40488p c40488p = new C40488p(context);
        c40488p.vsG = false;
        c40488p.vsH = false;
        c40488p.vsC = false;
        c40488p.vsI = false;
        c40488p.vsF = false;
        c40488p.vsS = false;
        SpannableString b = c40488p.mo64021b(charSequence, i, z);
        C44089j.m79302d(b);
        AppMethodBeat.m2505o(79835);
        return b;
    }

    /* renamed from: a */
    public static SpannableString m79284a(Context context, CharSequence charSequence, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(79836);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsQ = i2;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        if (i2 == 1) {
            c40488p.vsH = true;
            c40488p.vsJ = true;
        } else if (i2 == 2) {
            c40488p.vsH = false;
            c40488p.vsJ = false;
            c40488p.vsO = z;
        }
        SpannableString b = c40488p.mo64021b(charSequence, i, true);
        AppMethodBeat.m2505o(79836);
        return b;
    }

    /* renamed from: d */
    public static SpannableString m79301d(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79837);
        SpannableString a = C44089j.m79284a(context, charSequence, i, 1, false);
        AppMethodBeat.m2505o(79837);
        return a;
    }

    /* renamed from: e */
    public static SpannableString m79304e(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79838);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsM = true;
        c40488p.vsQ = 1;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        c40488p.vsT = null;
        c40488p.vsH = true;
        c40488p.vsJ = true;
        SpannableString b = c40488p.mo64021b(charSequence, i, true);
        AppMethodBeat.m2505o(79838);
        return b;
    }

    /* renamed from: a */
    public static SpannableString m79285a(Context context, CharSequence charSequence, int i, Object obj) {
        AppMethodBeat.m2504i(79839);
        SpannableString a = C44089j.m79286a(context, charSequence, i, obj, false);
        AppMethodBeat.m2505o(79839);
        return a;
    }

    /* renamed from: a */
    public static SpannableString m79286a(Context context, CharSequence charSequence, int i, Object obj, boolean z) {
        AppMethodBeat.m2504i(79840);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsM = true;
        c40488p.vsQ = 1;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        c40488p.vsT = obj;
        c40488p.vsP = z;
        c40488p.vsH = true;
        c40488p.vsJ = true;
        SpannableString b = c40488p.mo64021b(charSequence, i, false);
        AppMethodBeat.m2505o(79840);
        return b;
    }

    /* renamed from: f */
    public static SpannableString m79305f(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79841);
        SpannableString b = C44089j.m79295b(context, charSequence, i, true);
        AppMethodBeat.m2505o(79841);
        return b;
    }

    /* renamed from: e */
    public static SpannableString m79303e(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(79842);
        SpannableString b = C44089j.m79295b(context, charSequence, (int) f, false);
        AppMethodBeat.m2505o(79842);
        return b;
    }

    /* renamed from: b */
    private static SpannableString m79295b(Context context, CharSequence charSequence, int i, boolean z) {
        AppMethodBeat.m2504i(79843);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = false;
        c40488p.vsC = true;
        c40488p.vsK = true;
        c40488p.vsL = z;
        c40488p.vsM = true;
        c40488p.vsQ = 1;
        c40488p.vsG = false;
        c40488p.vsI = false;
        c40488p.vsH = false;
        c40488p.vsJ = false;
        c40488p.vsS = false;
        SpannableString b = c40488p.mo64021b(charSequence, i, true);
        AppMethodBeat.m2505o(79843);
        return b;
    }

    public static String ajP(String str) {
        AppMethodBeat.m2504i(79844);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79844);
            return str;
        }
        C40488p c40488p = new C40488p(C4996ah.getContext());
        c40488p.vsF = false;
        c40488p.vsC = true;
        c40488p.vsK = true;
        c40488p.vsL = true;
        c40488p.vsM = true;
        c40488p.vsQ = 1;
        c40488p.vsG = false;
        c40488p.vsI = false;
        c40488p.vsH = false;
        c40488p.vsJ = false;
        c40488p.vsN = false;
        c40488p.vsS = false;
        str = c40488p.mo64021b(str, 0, false).toString();
        AppMethodBeat.m2505o(79844);
        return str;
    }

    public static void clearCache() {
        AppMethodBeat.m2504i(79845);
        C4990ab.m7416i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        C40488p.clearCache();
        AppMethodBeat.m2505o(79845);
    }

    /* renamed from: l */
    public static SpannableString m79308l(TextView textView) {
        AppMethodBeat.m2504i(79846);
        SpannableString spannableString;
        if (textView == null) {
            C4990ab.m7412e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.m2505o(79846);
            return spannableString;
        }
        int textSize = (int) textView.getTextSize();
        C40488p c40488p = new C40488p(textView.getContext());
        c40488p.vsF = false;
        c40488p.vsC = false;
        c40488p.vsE = false;
        c40488p.vsG = false;
        c40488p.vsI = false;
        c40488p.vsS = true;
        C40488p m = c40488p.mo64022m(textView);
        m.vsH = false;
        m.vsJ = false;
        spannableString = m.mo64021b(textView.getText(), textSize, false);
        AppMethodBeat.m2505o(79846);
        return spannableString;
    }

    /* renamed from: c */
    public static CharSequence m79299c(Context context, CharSequence charSequence) {
        AppMethodBeat.m2504i(79847);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        int length = charSequence.length();
        int i = length + 1;
        spannableStringBuilder.append(" ");
        Drawable drawable = context.getResources().getDrawable(C1318a.open_im_title_logo);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new C5664a(drawable), length, i, 18);
        AppMethodBeat.m2505o(79847);
        return spannableStringBuilder;
    }

    /* renamed from: g */
    public static SpannableString m79306g(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79848);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = false;
        c40488p.vsC = true;
        c40488p.vsD = false;
        c40488p.vsK = false;
        c40488p.vsL = false;
        c40488p.vsM = false;
        c40488p.vsQ = 1;
        c40488p.vsG = false;
        c40488p.vsI = false;
        c40488p.vsH = false;
        c40488p.vsJ = false;
        c40488p.vsS = true;
        SpannableString b = c40488p.mo64021b(charSequence, i, true);
        AppMethodBeat.m2505o(79848);
        return b;
    }

    /* renamed from: a */
    public static SpannableString m79283a(Context context, CharSequence charSequence, int i, int i2, Object obj, String str) {
        AppMethodBeat.m2504i(79826);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsQ = i2;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = true;
        c40488p = c40488p.mo64022m(null);
        c40488p.vsT = obj;
        c40488p.hcl = str;
        if (i2 == 1) {
            c40488p.vsH = true;
            c40488p.vsJ = true;
        } else if (i2 == 2) {
            c40488p.vsH = false;
            c40488p.vsJ = false;
        }
        SpannableString b = c40488p.mo64021b(charSequence, i, true);
        AppMethodBeat.m2505o(79826);
        return b;
    }

    /* renamed from: a */
    public static SpannableString m79282a(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(79827);
        C40488p c40488p = new C40488p(context);
        c40488p.vsF = true;
        c40488p.vsC = true;
        c40488p.vsE = vrY;
        c40488p.vsQ = 1;
        c40488p.vsG = true;
        c40488p.vsI = false;
        c40488p.vsS = false;
        c40488p = c40488p.mo64022m(null);
        c40488p.vsT = null;
        c40488p.hcl = null;
        c40488p.vsH = true;
        c40488p.vsJ = true;
        SpannableString b = c40488p.mo64021b(charSequence, i, true);
        AppMethodBeat.m2505o(79827);
        return b;
    }
}
