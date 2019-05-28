package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Method;
import java.util.Locale;
import org.p1430a.C41166a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.aj */
public enum C45720aj {
    ;
    
    static final Class jha = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.aj$a */
    enum C42731a {
        private static final /* synthetic */ C42731a[] jhc = null;

        static {
            jhc = new C42731a[0];
        }

        public static C42731a valueOf(String str) {
            AppMethodBeat.m2504i(123844);
            C42731a c42731a = (C42731a) Enum.valueOf(C42731a.class, str);
            AppMethodBeat.m2505o(123844);
            return c42731a;
        }

        public static C42731a[] values() {
            AppMethodBeat.m2504i(123843);
            C42731a[] c42731aArr = (C42731a[]) jhc.clone();
            AppMethodBeat.m2505o(123843);
            return c42731aArr;
        }

        /* renamed from: c */
        static void m75727c(EditText editText) {
            AppMethodBeat.m2504i(123845);
            if (editText == null) {
                AppMethodBeat.m2505o(123845);
                return;
            }
            C45720aj.m84475cS(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 2);
            AppMethodBeat.m2505o(123845);
        }

        static void setNoSystemInputOnEditText(EditText editText) {
            AppMethodBeat.m2504i(123846);
            if (editText == null) {
                AppMethodBeat.m2505o(123846);
            } else if (VERSION.SDK_INT >= 21) {
                editText.setShowSoftInputOnFocus(false);
                AppMethodBeat.m2505o(123846);
            } else {
                Class cls = EditText.class;
                try {
                    Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(editText, new Object[]{Boolean.FALSE});
                    method.setAccessible(false);
                    AppMethodBeat.m2505o(123846);
                } catch (NoSuchMethodException e) {
                    C4990ab.m7417i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                    try {
                        Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                        method2.setAccessible(true);
                        method2.invoke(editText, new Object[]{Boolean.FALSE});
                        method2.setAccessible(false);
                        AppMethodBeat.m2505o(123846);
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", C5046bo.m7574l(e2));
                        if (editText.getContext() != null && (editText.getContext() instanceof C2559ad)) {
                            ((C2559ad) editText.getContext()).hideVKB(editText);
                        }
                        AppMethodBeat.m2505o(123846);
                    }
                } catch (Exception e22) {
                    C4990ab.m7413e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", C5046bo.m7574l(e22));
                    AppMethodBeat.m2505o(123846);
                }
            }
        }

        /* renamed from: a */
        static int m75726a(EditText editText, float f, float f2) {
            AppMethodBeat.m2504i(123847);
            int paddingTop = editText.getPaddingTop();
            Layout layout = editText.getLayout();
            if (layout == null) {
                AppMethodBeat.m2505o(123847);
                return -1;
            }
            Editable editableText = editText.getEditableText();
            if (editableText == null) {
                AppMethodBeat.m2505o(123847);
                return -1;
            }
            TextPaint paint = editText.getPaint();
            if (paint == null) {
                AppMethodBeat.m2505o(123847);
                return -1;
            }
            int lineStart;
            int i;
            Rect rect = new Rect();
            int i2 = 0;
            loop0:
            while (true) {
                int i3 = i2;
                if (i3 < layout.getLineCount()) {
                    layout.getLineBounds(i3, rect);
                    paddingTop += rect.height();
                    if (((float) paddingTop) >= f2) {
                        int max;
                        lineStart = layout.getLineStart(i3);
                        i2 = layout.getLineEnd(i3);
                        if (i3 != layout.getLineCount() - 1) {
                            max = Math.max(i2 - 1, lineStart);
                        } else {
                            max = i2;
                        }
                        if (lineStart == max) {
                            AppMethodBeat.m2505o(123847);
                            return lineStart;
                        }
                        RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) editableText.getSpans(lineStart, max, RelativeSizeSpan.class);
                        float f3 = 1.0f;
                        if (relativeSizeSpanArr != null) {
                            for (RelativeSizeSpan sizeChange : relativeSizeSpanArr) {
                                f3 = sizeChange.getSizeChange();
                            }
                        }
                        float f4 = f3;
                        String charSequence = editableText.subSequence(lineStart, max).toString();
                        float[] fArr = new float[charSequence.length()];
                        paint.getTextWidths(charSequence, fArr);
                        f3 = 0.0f;
                        i = 0;
                        while (i < charSequence.length()) {
                            f3 += fArr[i] * f4;
                            if (i == charSequence.length() - 1 && f >= f3) {
                                i2 = charSequence.length() + lineStart;
                                AppMethodBeat.m2505o(123847);
                                return i2;
                            } else if (f3 >= f || i == charSequence.length() - 1) {
                                i2 = lineStart + i;
                                AppMethodBeat.m2505o(123847);
                            } else {
                                i++;
                            }
                        }
                        continue;
                    }
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.m2505o(123847);
                    return -1;
                }
            }
            i2 = lineStart + i;
            AppMethodBeat.m2505o(123847);
            return i2;
        }
    }

    static {
        Class cls = null;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", e);
        }
        jha = cls;
        AppMethodBeat.m2505o(123857);
    }

    /* renamed from: C */
    static Spannable m84472C(CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.m2504i(123850);
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2 instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence2;
            AppMethodBeat.m2505o(123850);
            return spannable;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        AppMethodBeat.m2505o(123850);
        return spannableStringBuilder;
    }

    /* renamed from: D */
    public static boolean m84473D(CharSequence charSequence) {
        AppMethodBeat.m2504i(123851);
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Object[] spans = spanned.getSpans(0, spanned.length(), jha);
            if (spans == null || spans.length <= 0) {
                AppMethodBeat.m2505o(123851);
                return false;
            }
            AppMethodBeat.m2505o(123851);
            return true;
        }
        AppMethodBeat.m2505o(123851);
        return false;
    }

    /* renamed from: bM */
    static boolean m84474bM(Object obj) {
        AppMethodBeat.m2504i(123852);
        boolean isInstance = jha.isInstance(obj);
        AppMethodBeat.m2505o(123852);
        return isInstance;
    }

    /* JADX WARNING: Missing block: B:3:0x000c, code skipped:
            if (r0 == null) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cS */
    public static InputMethodManager m84475cS(View view) {
        Context context;
        AppMethodBeat.m2504i(123853);
        if (view != null) {
            context = view.getContext();
        }
        context = C4996ah.getContext();
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        AppMethodBeat.m2505o(123853);
        return inputMethodManager;
    }

    /* renamed from: cT */
    public static void m84476cT(View view) {
        String str;
        AppMethodBeat.m2504i(123854);
        InputMethodManager cS = C45720aj.m84475cS(view);
        if (cS == null) {
            str = "NULL Imm";
        } else {
            View view2 = (View) C41166a.m71622ep(cS).get("mServedView");
            View view3 = (View) C41166a.m71622ep(cS).get("mNextServedView");
            str = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", new Object[]{view2, view3});
        }
        C4990ab.m7417i("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", str);
        AppMethodBeat.m2505o(123854);
    }

    /* renamed from: f */
    public static boolean m84477f(View view, View view2) {
        AppMethodBeat.m2504i(123855);
        if (view == null || view2 == null) {
            AppMethodBeat.m2505o(123855);
            return false;
        }
        View parent = view2.getParent();
        while (view != parent) {
            parent = parent.getParent();
            if (parent == null) {
                AppMethodBeat.m2505o(123855);
                return false;
            }
        }
        AppMethodBeat.m2505o(123855);
        return true;
    }

    /* renamed from: g */
    public static boolean m84478g(Boolean bool) {
        AppMethodBeat.m2504i(123856);
        if (bool == null || !bool.booleanValue()) {
            AppMethodBeat.m2505o(123856);
            return false;
        }
        AppMethodBeat.m2505o(123856);
        return true;
    }
}
