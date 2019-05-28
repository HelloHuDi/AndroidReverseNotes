package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private boolean OH;
    private TextWatcher arx = new a(this, (byte) 0);
    private ArrayList<b> mListeners;
    private TextPaint mPaint;
    private float nnX;
    private int nnY;
    float nnZ;
    float noa;
    float nob;
    boolean noc;
    TextView sW;

    public interface b {
    }

    class a implements TextWatcher {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(112371);
            a.this.bFJ();
            AppMethodBeat.o(112371);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    public static a a(TextView textView, AttributeSet attributeSet) {
        AppMethodBeat.i(112372);
        a aVar = new a(textView);
        if (attributeSet != null) {
            int i = (int) aVar.nnZ;
            aVar.n(0, (float) i).aD(aVar.nob);
        }
        aVar.hV(true);
        AppMethodBeat.o(112372);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        AppMethodBeat.i(112373);
        if (i <= 0 || i == BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.o(112373);
            return;
        }
        int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        if (width <= 0) {
            AppMethodBeat.o(112373);
            return;
        }
        float f4;
        CharSequence text = textView.getText();
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, textView);
        }
        Context context = textView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        textPaint.set(textView.getPaint());
        textPaint.setTextSize(f2);
        if (i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) {
            float f5 = (float) width;
            textPaint.setTextSize(TypedValue.applyDimension(0, f2, displayMetrics));
            if (new StaticLayout(text, textPaint, (int) f5, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount() <= i) {
                f4 = f2;
                if (f4 >= f) {
                    f = f4;
                }
                textView.setTextSize(0, f);
                AppMethodBeat.o(112373);
            }
        }
        f4 = a(text, textPaint, (float) width, i, 0.0f, f2, f3, displayMetrics);
        if (f4 >= f) {
        }
        textView.setTextSize(0, f);
        AppMethodBeat.o(112373);
    }

    private static float a(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        AppMethodBeat.i(112374);
        TextPaint textPaint2 = textPaint;
        CharSequence charSequence2 = charSequence;
        while (true) {
            StaticLayout staticLayout;
            int lineCount;
            float f5 = (f2 + f3) / 2.0f;
            textPaint2.setTextSize(TypedValue.applyDimension(0, f5, displayMetrics));
            if (i != 1) {
                StaticLayout staticLayout2 = new StaticLayout(charSequence2, textPaint2, (int) f, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                staticLayout = staticLayout2;
                lineCount = staticLayout2.getLineCount();
            } else {
                staticLayout = null;
                lineCount = 1;
            }
            if (lineCount > i) {
                if (f3 - f2 < f4) {
                    AppMethodBeat.o(112374);
                    return f2;
                }
                f3 = f5;
            } else if (lineCount < i) {
                f2 = f5;
            } else {
                float f6 = 0.0f;
                if (i == 1) {
                    f6 = textPaint2.measureText(charSequence2, 0, charSequence2.length());
                } else {
                    for (int i2 = 0; i2 < lineCount; i2++) {
                        if (staticLayout.getLineWidth(i2) > f6) {
                            f6 = staticLayout.getLineWidth(i2);
                        }
                    }
                }
                if (f3 - f2 < f4) {
                    AppMethodBeat.o(112374);
                    return f2;
                } else if (f6 > f) {
                    f3 = f5;
                } else if (f6 < f) {
                    f2 = f5;
                } else {
                    AppMethodBeat.o(112374);
                    return f5;
                }
            }
        }
    }

    private a(TextView textView) {
        AppMethodBeat.i(112375);
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.sW = textView;
        this.mPaint = new TextPaint();
        setRawTextSize(textView.getTextSize());
        int i = -1;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            i = 1;
        } else if (VERSION.SDK_INT >= 16) {
            i = textView.getMaxLines();
        }
        this.nnY = i;
        this.nnZ = 8.0f * f;
        this.noa = this.nnX;
        this.nob = 0.5f;
        AppMethodBeat.o(112375);
    }

    public final a a(b bVar) {
        AppMethodBeat.i(112376);
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(bVar);
        AppMethodBeat.o(112376);
        return this;
    }

    public final a aD(float f) {
        AppMethodBeat.i(112377);
        if (this.nob != f) {
            this.nob = f;
            bFJ();
        }
        AppMethodBeat.o(112377);
        return this;
    }

    public final a n(int i, float f) {
        AppMethodBeat.i(112378);
        Context context = this.sW.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        aE(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        AppMethodBeat.o(112378);
        return this;
    }

    private void aE(float f) {
        AppMethodBeat.i(112379);
        if (f != this.nnZ) {
            this.nnZ = f;
            bFJ();
        }
        AppMethodBeat.o(112379);
    }

    public final a wP(int i) {
        AppMethodBeat.i(112380);
        if (this.nnY != i) {
            this.nnY = i;
            bFJ();
        }
        AppMethodBeat.o(112380);
        return this;
    }

    public final a hV(boolean z) {
        AppMethodBeat.i(112381);
        if (this.OH != z) {
            this.OH = z;
            if (z) {
                this.sW.addTextChangedListener(this.arx);
                bFJ();
            } else {
                this.sW.removeTextChangedListener(this.arx);
                this.sW.setTextSize(0, this.nnX);
            }
        }
        AppMethodBeat.o(112381);
        return this;
    }

    /* Access modifiers changed, original: final */
    public final void setRawTextSize(float f) {
        if (this.nnX != f) {
            this.nnX = f;
        }
    }

    public final void bFJ() {
        AppMethodBeat.i(112382);
        float textSize = this.sW.getTextSize();
        this.noc = true;
        a(this.sW, this.mPaint, this.nnZ, this.noa, this.nnY, this.nob);
        this.noc = false;
        if (this.sW.getTextSize() != textSize) {
            bFK();
        }
        AppMethodBeat.o(112382);
    }

    private void bFK() {
        AppMethodBeat.i(112383);
        if (this.mListeners == null) {
            AppMethodBeat.o(112383);
            return;
        }
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(112383);
    }
}
