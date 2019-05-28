package android.support.v7.widget;

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

final class p {
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
    private final TextView sW;

    p(TextView textView) {
        this.sW = textView;
        this.mContext = this.sW.getContext();
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeWithDefaults(int i) {
        if (hP()) {
            switch (i) {
                case 0:
                    hN();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    f(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (hL()) {
                        hM();
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
        if (hP()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            f(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (hL()) {
                hM();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        int i2 = 0;
        if (hP()) {
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
                this.agH = f(iArr2);
                if (!hK()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            }
            this.agI = false;
            if (hL()) {
                hM();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean hK() {
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

    static int[] f(int[] iArr) {
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
    public final void f(float f, float f2, float f3) {
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
    public final boolean hL() {
        if (hP() && this.agC == 1) {
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
                this.agH = f(iArr);
            }
            this.agD = true;
        } else {
            this.agD = false;
        }
        return this.agD;
    }

    /* Access modifiers changed, original: final */
    public final void hM() {
        if (hO()) {
            if (this.agD) {
                if (this.sW.getMeasuredHeight() > 0 && this.sW.getMeasuredWidth() > 0) {
                    int i;
                    if (((Boolean) a(this.sW, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
                        i = 1048576;
                    } else {
                        i = (this.sW.getMeasuredWidth() - this.sW.getTotalPaddingLeft()) - this.sW.getTotalPaddingRight();
                    }
                    int height = (this.sW.getHeight() - this.sW.getCompoundPaddingBottom()) - this.sW.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        synchronized (agA) {
                            agA.setEmpty();
                            agA.right = (float) i;
                            agA.bottom = (float) height;
                            float a = (float) a(agA);
                            if (a != this.sW.getTextSize()) {
                                e(0, a);
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

    private void hN() {
        this.agC = 0;
        this.agF = -1.0f;
        this.agG = -1.0f;
        this.agE = -1.0f;
        this.agH = new int[0];
        this.agD = false;
    }

    /* Access modifiers changed, original: final */
    public final void e(int i, float f) {
        Resources system;
        if (this.mContext == null) {
            system = Resources.getSystem();
        } else {
            system = this.mContext.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (f != this.sW.getPaint().getTextSize()) {
            boolean isInLayout;
            this.sW.getPaint().setTextSize(f);
            if (VERSION.SDK_INT >= 18) {
                isInLayout = this.sW.isInLayout();
            } else {
                isInLayout = false;
            }
            if (this.sW.getLayout() != null) {
                this.agD = false;
                try {
                    Method R = R("nullLayouts");
                    if (R != null) {
                        R.invoke(this.sW, new Object[0]);
                    }
                } catch (Exception e) {
                }
                if (isInLayout) {
                    this.sW.forceLayout();
                } else {
                    this.sW.requestLayout();
                }
                this.sW.invalidate();
            }
        }
    }

    private int a(RectF rectF) {
        int length = this.agH.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 1;
        int i2 = length - 1;
        length = 0;
        while (i <= i2) {
            int i3 = (i + i2) / 2;
            if (a(this.agH[i3], rectF)) {
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

    private boolean a(int i, RectF rectF) {
        StaticLayout a;
        CharSequence text = this.sW.getText();
        TransformationMethod transformationMethod = this.sW.getTransformationMethod();
        if (transformationMethod != null) {
            CharSequence transformation = transformationMethod.getTransformation(text, this.sW);
            if (transformation != null) {
                text = transformation;
            }
        }
        int maxLines = VERSION.SDK_INT >= 16 ? this.sW.getMaxLines() : -1;
        if (this.agJ == null) {
            this.agJ = new TextPaint();
        } else {
            this.agJ.reset();
        }
        this.agJ.set(this.sW.getPaint());
        this.agJ.setTextSize((float) i);
        Alignment alignment = (Alignment) a(this.sW, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
        if (VERSION.SDK_INT >= 23) {
            a = a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            a = a(text, alignment, Math.round(rectF.right));
        }
        if (maxLines != -1 && (a.getLineCount() > maxLines || a.getLineEnd(a.getLineCount() - 1) != text.length())) {
            return false;
        }
        if (((float) a.getHeight()) > rectF.bottom) {
            return false;
        }
        return true;
    }

    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) a(this.sW, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.agJ, i).setAlignment(alignment).setLineSpacing(this.sW.getLineSpacingExtra(), this.sW.getLineSpacingMultiplier()).setIncludePad(this.sW.getIncludeFontPadding()).setBreakStrategy(this.sW.getBreakStrategy()).setHyphenationFrequency(this.sW.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.sW.getLineSpacingMultiplier();
            lineSpacingExtra = this.sW.getLineSpacingExtra();
            includeFontPadding = this.sW.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) a(this.sW, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) a(this.sW, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) a(this.sW, "getIncludeFontPadding", Boolean.TRUE)).booleanValue();
        }
        return new StaticLayout(charSequence, this.agJ, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    private static <T> T a(Object obj, String str, T t) {
        try {
            t = R(str).invoke(obj, new Object[0]);
            if (t == null) {
            }
        } catch (Exception e) {
            new StringBuilder("Failed to invoke TextView#").append(str).append("() method");
        }
        return t;
    }

    private static Method R(String str) {
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
    public final boolean hO() {
        return hP() && this.agC != 0;
    }

    /* Access modifiers changed, original: final */
    public final boolean hP() {
        return !(this.sW instanceof AppCompatEditText);
    }
}
