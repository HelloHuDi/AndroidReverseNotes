package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class StaticTextView extends View implements a {
    protected g eNP = new g(this, SQ());

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105716);
        this.eNP.init();
        AppMethodBeat.o(105716);
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(105717);
        this.eNP.init();
        AppMethodBeat.o(105717);
    }

    public a getConfig() {
        if (this.eNP == null) {
            return null;
        }
        return this.eNP.eNR;
    }

    /* Access modifiers changed, original: protected */
    public a SQ() {
        AppMethodBeat.i(105718);
        a aVar = new a();
        AppMethodBeat.o(105718);
        return aVar;
    }

    /* Access modifiers changed, original: protected */
    public void setConfig(a aVar) {
        this.eNP.eNR = aVar;
    }

    public void setTextSize(float f) {
        AppMethodBeat.i(105719);
        this.eNP.setTextSize(0, f);
        AppMethodBeat.o(105719);
    }

    public final void setTextSize$255e752(float f) {
        AppMethodBeat.i(105720);
        this.eNP.setTextSize(1, f);
        AppMethodBeat.o(105720);
    }

    public void setTextLayout(f fVar) {
        AppMethodBeat.i(105721);
        this.eNP.setTextLayout(fVar);
        AppMethodBeat.o(105721);
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(105722);
        this.eNP.setTextColor(i);
        AppMethodBeat.o(105722);
    }

    public void setGravity(int i) {
        AppMethodBeat.i(105723);
        this.eNP.setGravity(i);
        AppMethodBeat.o(105723);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.i(105724);
        this.eNP.setMaxLines(i);
        AppMethodBeat.o(105724);
    }

    public int getMaxLines() {
        AppMethodBeat.i(105725);
        int maxLines = this.eNP.getMaxLines();
        AppMethodBeat.o(105725);
        return maxLines;
    }

    public void setMinLines(int i) {
        AppMethodBeat.i(105726);
        this.eNP.setMinLines(i);
        AppMethodBeat.o(105726);
    }

    public void setLines(int i) {
        AppMethodBeat.i(105727);
        this.eNP.setLines(i);
        AppMethodBeat.o(105727);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(105728);
        this.eNP.setSingleLine(z);
        AppMethodBeat.o(105728);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        AppMethodBeat.i(105729);
        this.eNP.setText(charSequence, z);
        setContentDescription(charSequence);
        AppMethodBeat.o(105729);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.i(105730);
        setText(charSequence, true);
        AppMethodBeat.o(105730);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        AppMethodBeat.i(105731);
        if (this.eNP != null) {
            this.eNP.SR();
        }
        super.setLayoutParams(layoutParams);
        AppMethodBeat.o(105731);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105732);
        if (this.eNP != null) {
            this.eNP.SR();
        }
        super.setPadding(i, i2, i3, i4);
        AppMethodBeat.o(105732);
    }

    public CharSequence getText() {
        AppMethodBeat.i(105733);
        CharSequence text = this.eNP.getText();
        AppMethodBeat.o(105733);
        return text;
    }

    public float getTextSize() {
        AppMethodBeat.i(105734);
        float textSize = this.eNP.getTextSize();
        AppMethodBeat.o(105734);
        return textSize;
    }

    public int getTextColor() {
        AppMethodBeat.i(105735);
        int textColor = this.eNP.getTextColor();
        AppMethodBeat.o(105735);
        return textColor;
    }

    public Layout getTvLayout() {
        AppMethodBeat.i(105736);
        Layout tvLayout = this.eNP.getTvLayout();
        AppMethodBeat.o(105736);
        return tvLayout;
    }

    public f getLayoutWrapper() {
        AppMethodBeat.i(105737);
        if (this.eNP == null) {
            AppMethodBeat.o(105737);
            return null;
        }
        f layoutWrapper = this.eNP.getLayoutWrapper();
        AppMethodBeat.o(105737);
        return layoutWrapper;
    }

    public int getLineCount() {
        AppMethodBeat.i(105738);
        int lineCount = this.eNP.getLineCount();
        AppMethodBeat.o(105738);
        return lineCount;
    }

    public int getLineHeight() {
        AppMethodBeat.i(105739);
        int lineHeight = this.eNP.getLineHeight();
        AppMethodBeat.o(105739);
        return lineHeight;
    }

    public int getSelectionStart() {
        AppMethodBeat.i(105740);
        int selectionStart = this.eNP.getSelectionStart();
        AppMethodBeat.o(105740);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(105741);
        int selectionEnd = this.eNP.getSelectionEnd();
        AppMethodBeat.o(105741);
        return selectionEnd;
    }

    public void setHandleClickableSpan(boolean z) {
        this.eNP.eNY = z;
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(105742);
        super.setClickable(z);
        if (this.eNP != null) {
            this.eNP.eNX = z;
        }
        AppMethodBeat.o(105742);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105743);
        if (getTvLayout() == null) {
            AppMethodBeat.o(105743);
            return false;
        }
        boolean t = this.eNP.t(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (t) {
            AppMethodBeat.o(105743);
            return true;
        }
        AppMethodBeat.o(105743);
        return onTouchEvent;
    }

    public boolean performClick() {
        AppMethodBeat.i(105744);
        if (this.eNP == null) {
            AppMethodBeat.o(105744);
            return false;
        } else if (this.eNP.performClick()) {
            boolean performClick = super.performClick();
            AppMethodBeat.o(105744);
            return performClick;
        } else {
            AppMethodBeat.o(105744);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(105745);
        super.onDraw(canvas);
        if (this.eNP != null) {
            this.eNP.onDraw(canvas);
        }
        AppMethodBeat.o(105745);
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
        AppMethodBeat.i(105746);
        if (this.eNP == null) {
            super.onMeasure(i, i2);
            AppMethodBeat.o(105746);
            return;
        }
        Point ce = this.eNP.ce(i, i2);
        if (ce != null) {
            setMeasuredDimension(ce.x, ce.y);
            AppMethodBeat.o(105746);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(105746);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(105747);
        super.onAttachedToWindow();
        AppMethodBeat.o(105747);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(105748);
        super.onDetachedFromWindow();
        AppMethodBeat.o(105748);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.i(105749);
        super.onStartTemporaryDetach();
        AppMethodBeat.o(105749);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.i(105750);
        super.onFinishTemporaryDetach();
        AppMethodBeat.o(105750);
    }

    public int getOrientation() {
        AppMethodBeat.i(105751);
        int i = getResources().getConfiguration().orientation;
        ab.i("MicroMsg.StaticTextView", "test test getOrientation ".concat(String.valueOf(i)));
        AppMethodBeat.o(105751);
        return i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(105752);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(105752);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(105753);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!bo.ac(getText())) {
            accessibilityEvent.getText().add(getText());
        }
        AppMethodBeat.o(105753);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(105754);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!bo.ac(getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (d.iW(18)) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && d.iW(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(32768);
            accessibilityNodeInfo.addAction(65536);
        }
        if (d.iW(19) && this.eNP.getMaxLines() > 1) {
            accessibilityNodeInfo.setMultiLine(true);
        }
        AppMethodBeat.o(105754);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(105755);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
            if (!bo.ac(getText())) {
                accessibilityEvent.setItemCount(getText().length());
            }
        }
        AppMethodBeat.o(105755);
    }
}
