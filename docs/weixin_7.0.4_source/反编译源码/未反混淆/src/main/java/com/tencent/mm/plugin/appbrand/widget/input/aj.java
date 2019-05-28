package com.tencent.mm.plugin.appbrand.widget.input;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;
import java.util.Locale;

public enum aj {
    ;
    
    static final Class jha = null;

    enum a {
        private static final /* synthetic */ a[] jhc = null;

        static {
            jhc = new a[0];
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(123844);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(123844);
            return aVar;
        }

        public static a[] values() {
            AppMethodBeat.i(123843);
            a[] aVarArr = (a[]) jhc.clone();
            AppMethodBeat.o(123843);
            return aVarArr;
        }

        static void c(EditText editText) {
            AppMethodBeat.i(123845);
            if (editText == null) {
                AppMethodBeat.o(123845);
                return;
            }
            aj.cS(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 2);
            AppMethodBeat.o(123845);
        }

        static void setNoSystemInputOnEditText(EditText editText) {
            AppMethodBeat.i(123846);
            if (editText == null) {
                AppMethodBeat.o(123846);
            } else if (VERSION.SDK_INT >= 21) {
                editText.setShowSoftInputOnFocus(false);
                AppMethodBeat.o(123846);
            } else {
                Class cls = EditText.class;
                try {
                    Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(editText, new Object[]{Boolean.FALSE});
                    method.setAccessible(false);
                    AppMethodBeat.o(123846);
                } catch (NoSuchMethodException e) {
                    ab.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                    try {
                        Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                        method2.setAccessible(true);
                        method2.invoke(editText, new Object[]{Boolean.FALSE});
                        method2.setAccessible(false);
                        AppMethodBeat.o(123846);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", bo.l(e2));
                        if (editText.getContext() != null && (editText.getContext() instanceof ad)) {
                            ((ad) editText.getContext()).hideVKB(editText);
                        }
                        AppMethodBeat.o(123846);
                    }
                } catch (Exception e22) {
                    ab.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", bo.l(e22));
                    AppMethodBeat.o(123846);
                }
            }
        }

        static int a(EditText editText, float f, float f2) {
            AppMethodBeat.i(123847);
            int paddingTop = editText.getPaddingTop();
            Layout layout = editText.getLayout();
            if (layout == null) {
                AppMethodBeat.o(123847);
                return -1;
            }
            Editable editableText = editText.getEditableText();
            if (editableText == null) {
                AppMethodBeat.o(123847);
                return -1;
            }
            TextPaint paint = editText.getPaint();
            if (paint == null) {
                AppMethodBeat.o(123847);
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
                            AppMethodBeat.o(123847);
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
                                AppMethodBeat.o(123847);
                                return i2;
                            } else if (f3 >= f || i == charSequence.length() - 1) {
                                i2 = lineStart + i;
                                AppMethodBeat.o(123847);
                            } else {
                                i++;
                            }
                        }
                        continue;
                    }
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.o(123847);
                    return -1;
                }
            }
            i2 = lineStart + i;
            AppMethodBeat.o(123847);
            return i2;
        }
    }

    static {
        Class cls = null;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e) {
            ab.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", e);
        }
        jha = cls;
        AppMethodBeat.o(123857);
    }

    static Spannable C(CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.i(123850);
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2 instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence2;
            AppMethodBeat.o(123850);
            return spannable;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        AppMethodBeat.o(123850);
        return spannableStringBuilder;
    }

    public static boolean D(CharSequence charSequence) {
        AppMethodBeat.i(123851);
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Object[] spans = spanned.getSpans(0, spanned.length(), jha);
            if (spans == null || spans.length <= 0) {
                AppMethodBeat.o(123851);
                return false;
            }
            AppMethodBeat.o(123851);
            return true;
        }
        AppMethodBeat.o(123851);
        return false;
    }

    static boolean bM(Object obj) {
        AppMethodBeat.i(123852);
        boolean isInstance = jha.isInstance(obj);
        AppMethodBeat.o(123852);
        return isInstance;
    }

    /* JADX WARNING: Missing block: B:3:0x000c, code skipped:
            if (r0 == null) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static InputMethodManager cS(View view) {
        Context context;
        AppMethodBeat.i(123853);
        if (view != null) {
            context = view.getContext();
        }
        context = ah.getContext();
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        AppMethodBeat.o(123853);
        return inputMethodManager;
    }

    public static void cT(View view) {
        String str;
        AppMethodBeat.i(123854);
        InputMethodManager cS = cS(view);
        if (cS == null) {
            str = "NULL Imm";
        } else {
            View view2 = (View) org.a.a.ep(cS).get("mServedView");
            View view3 = (View) org.a.a.ep(cS).get("mNextServedView");
            str = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", new Object[]{view2, view3});
        }
        ab.i("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", str);
        AppMethodBeat.o(123854);
    }

    public static boolean f(View view, View view2) {
        AppMethodBeat.i(123855);
        if (view == null || view2 == null) {
            AppMethodBeat.o(123855);
            return false;
        }
        View parent = view2.getParent();
        while (view != parent) {
            parent = parent.getParent();
            if (parent == null) {
                AppMethodBeat.o(123855);
                return false;
            }
        }
        AppMethodBeat.o(123855);
        return true;
    }

    public static boolean g(Boolean bool) {
        AppMethodBeat.i(123856);
        if (bool == null || !bool.booleanValue()) {
            AppMethodBeat.o(123856);
            return false;
        }
        AppMethodBeat.o(123856);
        return true;
    }
}
