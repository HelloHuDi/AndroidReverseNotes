package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: android.support.v7.widget.p */
final class C0725p {
    private static final RectF agA = new RectF();
    private static ConcurrentHashMap<String, Method> agB = new ConcurrentHashMap();
    int agC = 0;
    private boolean agD = false;
    float agE = -1.0f;
    float agF = -1.0f;
    float agG = -1.0f;
    int[] agH = new int[0];
    boolean agI = false;
    private TextPaint agJ;
    final Context mContext;
    /* renamed from: sW */
    private final TextView f1023sW;

    C0725p(TextView textView) {
        this.f1023sW = textView;
        this.mContext = this.f1023sW.getContext();
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeWithDefaults(int i) {
        if (mo2113hP()) {
            switch (i) {
                case 0:
                    m1644hN();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    mo2108f(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (mo2110hL()) {
                        mo2111hM();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(i)));
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (mo2113hP()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            mo2108f(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (mo2110hL()) {
                mo2111hM();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        int i2 = 0;
        if (mo2113hP()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                this.agH = C0725p.m1643f(iArr2);
                if (!mo2109hK()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            }
            this.agI = false;
            if (mo2110hL()) {
                mo2111hM();
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hK */
    public final boolean mo2109hK() {
        int length = this.agH.length;
        this.agI = length > 0;
        if (this.agI) {
            this.agC = 1;
            this.agF = (float) this.agH[0];
            this.agG = (float) this.agH[length - 1];
            this.agE = -1.0f;
        }
        return this.agI;
    }

    /* renamed from: f */
    static int[] m1643f(int[] iArr) {
        int size;
        if (size != 0) {
            int i;
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (size != arrayList.size()) {
                size = arrayList.size();
                iArr = new int[size];
                for (i = 0; i < size; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        }
        return iArr;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final void mo2108f(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        } else {
            this.agC = 1;
            this.agF = f;
            this.agG = f2;
            this.agE = f3;
            this.agI = false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hL */
    public final boolean mo2110hL() {
        if (mo2113hP() && this.agC == 1) {
            if (!this.agI || this.agH.length == 0) {
                float round = (float) Math.round(this.agF);
                int i = 1;
                while (Math.round(this.agE + round) <= Math.round(this.agG)) {
                    i++;
                    round += this.agE;
                }
                int[] iArr = new int[i];
                float f = this.agF;
                int i2 = 0;
                while (i2 < i) {
                    iArr[i2] = Math.round(f);
                    i2++;
                    f = this.agE + f;
                }
                this.agH = C0725p.m1643f(iArr);
            }
            this.agD = true;
        } else {
            this.agD = false;
        }
        return this.agD;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hM */
    public final void mo2111hM() {
        if (mo2112hO()) {
            if (this.agD) {
                if (this.f1023sW.getMeasuredHeight() > 0 && this.f1023sW.getMeasuredWidth() > 0) {
                    int i;
                    if (((Boolean) C0725p.m1641a(this.f1023sW, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
                        i = 1048576;
                    } else {
                        i = (this.f1023sW.getMeasuredWidth() - this.f1023sW.getTotalPaddingLeft()) - this.f1023sW.getTotalPaddingRight();
                    }
                    int height = (this.f1023sW.getHeight() - this.f1023sW.getCompoundPaddingBottom()) - this.f1023sW.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        synchronized (agA) {
                            agA.setEmpty();
                            agA.right = (float) i;
                            agA.bottom = (float) height;
                            float a = (float) m1638a(agA);
                            if (a != this.f1023sW.getTextSize()) {
                                mo2107e(0, a);
                            }
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            this.agD = true;
        }
    }

    /* renamed from: hN */
    private void m1644hN() {
        this.agC = 0;
        this.agF = -1.0f;
        this.agG = -1.0f;
        this.agE = -1.0f;
        this.agH = new int[0];
        this.agD = false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo2107e(int i, float f) {
        Resources system;
        if (this.mContext == null) {
            system = Resources.getSystem();
        } else {
            system = this.mContext.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (f != this.f1023sW.getPaint().getTextSize()) {
            boolean isInLayout;
            this.f1023sW.getPaint().setTextSize(f);
            if (VERSION.SDK_INT >= 18) {
                isInLayout = this.f1023sW.isInLayout();
            } else {
                isInLayout = false;
            }
            if (this.f1023sW.getLayout() != null) {
                this.agD = false;
                try {
                    Method R = C0725p.m1637R("nullLayouts");
                    if (R != null) {
                        R.invoke(this.f1023sW, new Object[0]);
                    }
                } catch (Exception e) {
                }
                if (isInLayout) {
                    this.f1023sW.forceLayout();
                } else {
                    this.f1023sW.requestLayout();
                }
                this.f1023sW.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m1638a(RectF rectF) {
        int length = this.agH.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 1;
        int i2 = length - 1;
        length = 0;
        while (i <= i2) {
            int i3 = (i + i2) / 2;
            if (m1642a(this.agH[i3], rectF)) {
                length = i;
                i = i3 + 1;
            } else {
                i3--;
                length = i3;
                i2 = i3;
            }
        }
        return this.agH[length];
    }

    /* renamed from: a */
    private boolean m1642a(int i, RectF rectF) {
        StaticLayout a;
        CharSequence text = this.f1023sW.getText();
        TransformationMethod transformationMethod = this.f1023sW.getTransformationMethod();
        if (transformationMethod != null) {
            CharSequence transformation = transformationMethod.getTransformation(text, this.f1023sW);
            if (transformation != null) {
                text = transformation;
            }
        }
        int maxLines = VERSION.SDK_INT >= 16 ? this.f1023sW.getMaxLines() : -1;
        if (this.agJ == null) {
            this.agJ = new TextPaint();
        } else {
            this.agJ.reset();
        }
        this.agJ.set(this.f1023sW.getPaint());
        this.agJ.setTextSize((float) i);
        Alignment alignment = (Alignment) C0725p.m1641a(this.f1023sW, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
        if (VERSION.SDK_INT >= 23) {
            a = m1640a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            a = m1639a(text, alignment, Math.round(rectF.right));
        }
        if (maxLines != -1 && (a.getLineCount() > maxLines || a.getLineEnd(a.getLineCount() - 1) != text.length())) {
            return false;
        }
        if (((float) a.getHeight()) > rectF.bottom) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private StaticLayout m1640a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) C0725p.m1641a(this.f1023sW, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.agJ, i).setAlignment(alignment).setLineSpacing(this.f1023sW.getLineSpacingExtra(), this.f1023sW.getLineSpacingMultiplier()).setIncludePad(this.f1023sW.getIncludeFontPadding()).setBreakStrategy(this.f1023sW.getBreakStrategy()).setHyphenationFrequency(this.f1023sW.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* renamed from: a */
    private StaticLayout m1639a(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.f1023sW.getLineSpacingMultiplier();
            lineSpacingExtra = this.f1023sW.getLineSpacingExtra();
            includeFontPadding = this.f1023sW.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) C0725p.m1641a(this.f1023sW, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) C0725p.m1641a(this.f1023sW, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) C0725p.m1641a(this.f1023sW, "getIncludeFontPadding", Boolean.TRUE)).booleanValue();
        }
        return new StaticLayout(charSequence, this.agJ, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    /* renamed from: a */
    private static <T> T m1641a(Object obj, String str, T t) {
        try {
            t = C0725p.m1637R(str).invoke(obj, new Object[0]);
            if (t == null) {
            }
        } catch (Exception e) {
            new StringBuilder("Failed to invoke TextView#").append(str).append("() method");
        }
        return t;
    }

    /* renamed from: R */
    private static Method m1637R(String str) {
        try {
            Method method = (Method) agB.get(str);
            if (method != null) {
                return method;
            }
            method = TextView.class.getDeclaredMethod(str, new Class[0]);
            if (method == null) {
                return method;
            }
            method.setAccessible(true);
            agB.put(str, method);
            return method;
        } catch (Exception e) {
            new StringBuilder("Failed to retrieve TextView#").append(str).append("() method");
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hO */
    public final boolean mo2112hO() {
        return mo2113hP() && this.agC != 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hP */
    public final boolean mo2113hP() {
        return !(this.f1023sW instanceof AppCompatEditText);
    }
}
