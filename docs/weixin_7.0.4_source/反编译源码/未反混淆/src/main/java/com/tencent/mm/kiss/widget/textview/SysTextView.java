package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean eOd = false;
    private static Field eOe = null;
    private g eNP = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105777);
        init();
        AppMethodBeat.o(105777);
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(105778);
        init();
        AppMethodBeat.o(105778);
    }

    private void init() {
        AppMethodBeat.i(105779);
        super.setText(" ", BufferType.SPANNABLE);
        this.eNP.eNR = new a();
        this.eNP.eNR.textColor = super.getTextColors().getDefaultColor();
        this.eNP.eNR.eND = super.getEllipsize();
        this.eNP.eNR.gravity = super.getGravity();
        this.eNP.eNR.eOg = super.getTextSize();
        SS();
        AppMethodBeat.o(105779);
    }

    private void SS() {
        AppMethodBeat.i(105780);
        if (eOd) {
            AppMethodBeat.o(105780);
            return;
        }
        try {
            if (eOe == null) {
                Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                eOe = declaredField;
                declaredField.setAccessible(true);
            }
            if (eOe.getBoolean(this)) {
                this.eNP.eNR.maxLines = 1;
            }
            AppMethodBeat.o(105780);
        } catch (Exception e) {
            ab.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e.getMessage());
            eOd = true;
            AppMethodBeat.o(105780);
        }
    }

    /* Access modifiers changed, original: protected */
    public f getLayoutWrapper() {
        AppMethodBeat.i(105781);
        if (this.eNP == null) {
            AppMethodBeat.o(105781);
            return null;
        }
        f layoutWrapper = this.eNP.getLayoutWrapper();
        AppMethodBeat.o(105781);
        return layoutWrapper;
    }

    public a getConfig() {
        if (this.eNP == null) {
            return null;
        }
        return this.eNP.eNR;
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(105782);
        if (this.eNP == null) {
            AppMethodBeat.o(105782);
            return;
        }
        this.eNP.setSingleLine(z);
        AppMethodBeat.o(105782);
    }

    public void setLines(int i) {
        AppMethodBeat.i(105783);
        if (this.eNP == null) {
            AppMethodBeat.o(105783);
            return;
        }
        this.eNP.setLines(i);
        AppMethodBeat.o(105783);
    }

    public boolean onPreDraw() {
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(105784);
        setText$609c24db(charSequence);
        AppMethodBeat.o(105784);
    }

    public final void setText$609c24db(CharSequence charSequence) {
        AppMethodBeat.i(105785);
        if (this.eNP == null) {
            super.setText("");
            AppMethodBeat.o(105785);
            return;
        }
        this.eNP.setText(charSequence, false);
        AppMethodBeat.o(105785);
    }

    public void setTextSize(float f) {
        AppMethodBeat.i(105786);
        setTextSize(0, f);
        AppMethodBeat.o(105786);
    }

    public void setTextSize(int i, float f) {
        AppMethodBeat.i(105787);
        if (this.eNP == null) {
            AppMethodBeat.o(105787);
            return;
        }
        this.eNP.setTextSize(i, f);
        AppMethodBeat.o(105787);
    }

    public void setTextLayout(f fVar) {
        AppMethodBeat.i(105788);
        if (this.eNP == null) {
            AppMethodBeat.o(105788);
            return;
        }
        this.eNP.setTextLayout(fVar);
        AppMethodBeat.o(105788);
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(105789);
        if (this.eNP == null) {
            AppMethodBeat.o(105789);
            return;
        }
        this.eNP.setTextColor(i);
        AppMethodBeat.o(105789);
    }

    public void setGravity(int i) {
        AppMethodBeat.i(105790);
        if (this.eNP == null) {
            AppMethodBeat.o(105790);
            return;
        }
        this.eNP.setGravity(i);
        AppMethodBeat.o(105790);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.i(105791);
        if (this.eNP == null) {
            AppMethodBeat.o(105791);
            return;
        }
        this.eNP.setMaxLines(i);
        AppMethodBeat.o(105791);
    }

    public void setMinLines(int i) {
        AppMethodBeat.i(105792);
        if (this.eNP == null) {
            AppMethodBeat.o(105792);
            return;
        }
        this.eNP.setMinLines(i);
        AppMethodBeat.o(105792);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        AppMethodBeat.i(105793);
        if (this.eNP != null) {
            this.eNP.SR();
        }
        super.setLayoutParams(layoutParams);
        AppMethodBeat.o(105793);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105794);
        if (this.eNP != null) {
            this.eNP.SR();
        }
        super.setPadding(i, i2, i3, i4);
        AppMethodBeat.o(105794);
    }

    public CharSequence getText() {
        AppMethodBeat.i(105795);
        if (this.eNP == null) {
            AppMethodBeat.o(105795);
            return null;
        }
        CharSequence text = this.eNP.getText();
        AppMethodBeat.o(105795);
        return text;
    }

    public float getTextSize() {
        AppMethodBeat.i(105796);
        if (this.eNP == null) {
            AppMethodBeat.o(105796);
            return 0.0f;
        }
        float textSize = this.eNP.getTextSize();
        AppMethodBeat.o(105796);
        return textSize;
    }

    public int getTextColor() {
        AppMethodBeat.i(105797);
        int textColor = this.eNP.getTextColor();
        AppMethodBeat.o(105797);
        return textColor;
    }

    public Layout getTvLayout() {
        AppMethodBeat.i(105798);
        Layout tvLayout = this.eNP.getTvLayout();
        AppMethodBeat.o(105798);
        return tvLayout;
    }

    public int getLineCount() {
        AppMethodBeat.i(105799);
        if (this.eNP == null) {
            AppMethodBeat.o(105799);
            return 0;
        }
        int lineCount = this.eNP.getLineCount();
        AppMethodBeat.o(105799);
        return lineCount;
    }

    public int getLineHeight() {
        AppMethodBeat.i(105800);
        if (this.eNP == null) {
            AppMethodBeat.o(105800);
            return 0;
        }
        int lineHeight = this.eNP.getLineHeight();
        AppMethodBeat.o(105800);
        return lineHeight;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(105801);
        if (getText() == null) {
            AppMethodBeat.o(105801);
            return -1;
        }
        int selectionStart = Selection.getSelectionStart(getText());
        AppMethodBeat.o(105801);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(105802);
        if (getText() == null) {
            AppMethodBeat.o(105802);
            return -1;
        }
        int selectionEnd = Selection.getSelectionEnd(getText());
        AppMethodBeat.o(105802);
        return selectionEnd;
    }

    public void setHandleClickableSpan(boolean z) {
        this.eNP.eNY = z;
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(105803);
        super.setClickable(z);
        if (this.eNP == null) {
            AppMethodBeat.o(105803);
            return;
        }
        this.eNP.eNX = z;
        AppMethodBeat.o(105803);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105804);
        if (getTvLayout() == null) {
            AppMethodBeat.o(105804);
            return false;
        }
        boolean t = this.eNP.t(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (t) {
            AppMethodBeat.o(105804);
            return true;
        }
        AppMethodBeat.o(105804);
        return onTouchEvent;
    }

    public boolean performClick() {
        AppMethodBeat.i(105805);
        if (this.eNP == null) {
            AppMethodBeat.o(105805);
            return false;
        } else if (this.eNP.performClick()) {
            boolean performClick = super.performClick();
            AppMethodBeat.o(105805);
            return performClick;
        } else {
            AppMethodBeat.o(105805);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(105806);
        try {
            if (this.eNP == null) {
                AppMethodBeat.o(105806);
                return;
            }
            this.eNP.onDraw(canvas);
            AppMethodBeat.o(105806);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            AppMethodBeat.o(105806);
        }
    }

    public int getHorizontalDrawOffset() {
        if (this.eNP == null) {
            return 0;
        }
        return this.eNP.eNU;
    }

    public int getVerticalDrawOffset() {
        if (this.eNP == null) {
            return 0;
        }
        return this.eNP.eNV;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(105807);
        try {
            Point ce = this.eNP.ce(i, i2);
            if (ce != null) {
                setMeasuredDimension(ce.x, ce.y);
                AppMethodBeat.o(105807);
                return;
            }
            super.onMeasure(i, i2);
            AppMethodBeat.o(105807);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SysPLTextView", e, "onMeasure error: %s", e.getMessage());
            AppMethodBeat.o(105807);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            AppMethodBeat.o(105807);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(105808);
        super.onAttachedToWindow();
        AppMethodBeat.o(105808);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(105809);
        super.onDetachedFromWindow();
        AppMethodBeat.o(105809);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(105810);
        super.onStartTemporaryDetach();
        AppMethodBeat.o(105810);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(105811);
        super.onFinishTemporaryDetach();
        AppMethodBeat.o(105811);
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        AppMethodBeat.i(105812);
        try {
            super.onProvideStructure(viewStructure);
            AppMethodBeat.o(105812);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SysPLTextView", e, "onProvideStructure error: %s", e.getMessage());
            AppMethodBeat.o(105812);
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    public int getBaseline() {
        AppMethodBeat.i(105813);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(105813);
            return baseline;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            AppMethodBeat.o(105813);
            return -1;
        }
    }
}
