package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.a;
import java.util.LinkedList;

public final class j {
    static LinkedList<g> vrX = new LinkedList();
    private static boolean vrY = bo.gT(ah.getContext());

    static {
        AppMethodBeat.i(79849);
        AppMethodBeat.o(79849);
    }

    public static void a(g gVar) {
        AppMethodBeat.i(79819);
        vrX.add(gVar);
        AppMethodBeat.o(79819);
    }

    public static void b(g gVar) {
        AppMethodBeat.i(79820);
        vrX.remove(gVar);
        AppMethodBeat.o(79820);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, boolean z, Object obj) {
        AppMethodBeat.i(79821);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsK = true;
        pVar.vsM = true;
        pVar.vsQ = 1;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        pVar = pVar.m(null);
        pVar.vsH = true;
        pVar.vsJ = true;
        pVar.vsT = obj;
        SpannableString b = pVar.b(charSequence, i, z);
        AppMethodBeat.o(79821);
        return b;
    }

    public static SpannableString a(TextView textView, Object obj) {
        AppMethodBeat.i(79822);
        SpannableString a = a(textView, true, obj);
        AppMethodBeat.o(79822);
        return a;
    }

    public static SpannableString a(TextView textView, boolean z, Object obj) {
        AppMethodBeat.i(79823);
        SpannableString spannableString;
        if (textView == null) {
            ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.o(79823);
            return spannableString;
        }
        spannableString = a(textView.getContext(), textView, (int) textView.getTextSize(), z, obj);
        AppMethodBeat.o(79823);
        return spannableString;
    }

    public static SpannableString h(TextView textView, int i) {
        AppMethodBeat.i(79824);
        SpannableString spannableString;
        if (textView == null) {
            ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.o(79824);
            return spannableString;
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsQ = i;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        p m = pVar.m(textView);
        if (i == 1) {
            m.vsH = true;
            m.vsJ = true;
        } else if (i == 2) {
            m.vsH = false;
            m.vsJ = false;
        }
        spannableString = m.b(textView.getText(), textSize, true);
        AppMethodBeat.o(79824);
        return spannableString;
    }

    public static SpannableString b(TextView textView, Object obj) {
        AppMethodBeat.i(79825);
        SpannableString spannableString;
        if (textView == null) {
            ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.o(79825);
            return spannableString;
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsQ = 1;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        p m = pVar.m(textView);
        m.vsT = obj;
        m.hcl = null;
        m.vsH = true;
        m.vsJ = true;
        spannableString = m.b(textView.getText(), textSize, true);
        AppMethodBeat.o(79825);
        return spannableString;
    }

    private static SpannableString a(Context context, TextView textView, int i, boolean z, Object obj) {
        AppMethodBeat.i(79828);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsK = true;
        pVar.vsM = true;
        pVar.vsQ = 1;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        pVar = pVar.m(textView);
        pVar.vsH = true;
        pVar.vsJ = true;
        if (obj != null) {
            pVar.vsT = obj;
        }
        SpannableString b = pVar.b(textView.getText(), i, z);
        AppMethodBeat.o(79828);
        return b;
    }

    public static SpannableString b(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79829);
        SpannableString a = a(context, charSequence, i, true);
        AppMethodBeat.o(79829);
        return a;
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(79830);
        SpannableString a = a(context, charSequence, (int) f, true);
        AppMethodBeat.o(79830);
        return a;
    }

    public static SpannableString d(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(79831);
        SpannableString a = a(context, charSequence, (int) f, false);
        AppMethodBeat.o(79831);
        return a;
    }

    public static SpannableString c(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79832);
        p pVar = new p(context);
        pVar.vsG = false;
        pVar.vsH = false;
        pVar.vsC = false;
        pVar.vsI = false;
        pVar.vsQ = i;
        pVar.vsF = false;
        pVar.vsS = false;
        SpannableString b = pVar.b(charSequence, 0, true);
        d(b);
        AppMethodBeat.o(79832);
        return b;
    }

    private static void d(Spannable spannable) {
        int i = 0;
        AppMethodBeat.i(79833);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
        AppMethodBeat.o(79833);
    }

    public static SpannableString b(Context context, CharSequence charSequence) {
        AppMethodBeat.i(79834);
        SpannableString a = a(context, charSequence, 0, true);
        AppMethodBeat.o(79834);
        return a;
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i, boolean z) {
        AppMethodBeat.i(79835);
        p pVar = new p(context);
        pVar.vsG = false;
        pVar.vsH = false;
        pVar.vsC = false;
        pVar.vsI = false;
        pVar.vsF = false;
        pVar.vsS = false;
        SpannableString b = pVar.b(charSequence, i, z);
        d(b);
        AppMethodBeat.o(79835);
        return b;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2, boolean z) {
        AppMethodBeat.i(79836);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsQ = i2;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        if (i2 == 1) {
            pVar.vsH = true;
            pVar.vsJ = true;
        } else if (i2 == 2) {
            pVar.vsH = false;
            pVar.vsJ = false;
            pVar.vsO = z;
        }
        SpannableString b = pVar.b(charSequence, i, true);
        AppMethodBeat.o(79836);
        return b;
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79837);
        SpannableString a = a(context, charSequence, i, 1, false);
        AppMethodBeat.o(79837);
        return a;
    }

    public static SpannableString e(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79838);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsM = true;
        pVar.vsQ = 1;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        pVar.vsT = null;
        pVar.vsH = true;
        pVar.vsJ = true;
        SpannableString b = pVar.b(charSequence, i, true);
        AppMethodBeat.o(79838);
        return b;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj) {
        AppMethodBeat.i(79839);
        SpannableString a = a(context, charSequence, i, obj, false);
        AppMethodBeat.o(79839);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj, boolean z) {
        AppMethodBeat.i(79840);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsM = true;
        pVar.vsQ = 1;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        pVar.vsT = obj;
        pVar.vsP = z;
        pVar.vsH = true;
        pVar.vsJ = true;
        SpannableString b = pVar.b(charSequence, i, false);
        AppMethodBeat.o(79840);
        return b;
    }

    public static SpannableString f(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79841);
        SpannableString b = b(context, charSequence, i, true);
        AppMethodBeat.o(79841);
        return b;
    }

    public static SpannableString e(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(79842);
        SpannableString b = b(context, charSequence, (int) f, false);
        AppMethodBeat.o(79842);
        return b;
    }

    private static SpannableString b(Context context, CharSequence charSequence, int i, boolean z) {
        AppMethodBeat.i(79843);
        p pVar = new p(context);
        pVar.vsF = false;
        pVar.vsC = true;
        pVar.vsK = true;
        pVar.vsL = z;
        pVar.vsM = true;
        pVar.vsQ = 1;
        pVar.vsG = false;
        pVar.vsI = false;
        pVar.vsH = false;
        pVar.vsJ = false;
        pVar.vsS = false;
        SpannableString b = pVar.b(charSequence, i, true);
        AppMethodBeat.o(79843);
        return b;
    }

    public static String ajP(String str) {
        AppMethodBeat.i(79844);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79844);
            return str;
        }
        p pVar = new p(ah.getContext());
        pVar.vsF = false;
        pVar.vsC = true;
        pVar.vsK = true;
        pVar.vsL = true;
        pVar.vsM = true;
        pVar.vsQ = 1;
        pVar.vsG = false;
        pVar.vsI = false;
        pVar.vsH = false;
        pVar.vsJ = false;
        pVar.vsN = false;
        pVar.vsS = false;
        str = pVar.b(str, 0, false).toString();
        AppMethodBeat.o(79844);
        return str;
    }

    public static void clearCache() {
        AppMethodBeat.i(79845);
        ab.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        p.clearCache();
        AppMethodBeat.o(79845);
    }

    public static SpannableString l(TextView textView) {
        AppMethodBeat.i(79846);
        SpannableString spannableString;
        if (textView == null) {
            ab.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            spannableString = new SpannableString("");
            AppMethodBeat.o(79846);
            return spannableString;
        }
        int textSize = (int) textView.getTextSize();
        p pVar = new p(textView.getContext());
        pVar.vsF = false;
        pVar.vsC = false;
        pVar.vsE = false;
        pVar.vsG = false;
        pVar.vsI = false;
        pVar.vsS = true;
        p m = pVar.m(textView);
        m.vsH = false;
        m.vsJ = false;
        spannableString = m.b(textView.getText(), textSize, false);
        AppMethodBeat.o(79846);
        return spannableString;
    }

    public static CharSequence c(Context context, CharSequence charSequence) {
        AppMethodBeat.i(79847);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        int length = charSequence.length();
        int i = length + 1;
        spannableStringBuilder.append(" ");
        Drawable drawable = context.getResources().getDrawable(R.raw.open_im_title_logo);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new a(drawable), length, i, 18);
        AppMethodBeat.o(79847);
        return spannableStringBuilder;
    }

    public static SpannableString g(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79848);
        p pVar = new p(context);
        pVar.vsF = false;
        pVar.vsC = true;
        pVar.vsD = false;
        pVar.vsK = false;
        pVar.vsL = false;
        pVar.vsM = false;
        pVar.vsQ = 1;
        pVar.vsG = false;
        pVar.vsI = false;
        pVar.vsH = false;
        pVar.vsJ = false;
        pVar.vsS = true;
        SpannableString b = pVar.b(charSequence, i, true);
        AppMethodBeat.o(79848);
        return b;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2, Object obj, String str) {
        AppMethodBeat.i(79826);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsQ = i2;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = true;
        pVar = pVar.m(null);
        pVar.vsT = obj;
        pVar.hcl = str;
        if (i2 == 1) {
            pVar.vsH = true;
            pVar.vsJ = true;
        } else if (i2 == 2) {
            pVar.vsH = false;
            pVar.vsJ = false;
        }
        SpannableString b = pVar.b(charSequence, i, true);
        AppMethodBeat.o(79826);
        return b;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i) {
        AppMethodBeat.i(79827);
        p pVar = new p(context);
        pVar.vsF = true;
        pVar.vsC = true;
        pVar.vsE = vrY;
        pVar.vsQ = 1;
        pVar.vsG = true;
        pVar.vsI = false;
        pVar.vsS = false;
        pVar = pVar.m(null);
        pVar.vsT = null;
        pVar.hcl = null;
        pVar.vsH = true;
        pVar.vsJ = true;
        SpannableString b = pVar.b(charSequence, i, true);
        AppMethodBeat.o(79827);
        return b;
    }
}
