package com.tencent.p177mm.kiss.widget.textview;

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
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.kiss.widget.textview.StaticTextView */
public class StaticTextView extends View implements C18526a {
    protected C26349g eNP = new C26349g(this, mo47418SQ());

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105716);
        this.eNP.init();
        AppMethodBeat.m2505o(105716);
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(105717);
        this.eNP.init();
        AppMethodBeat.m2505o(105717);
    }

    public C42149a getConfig() {
        if (this.eNP == null) {
            return null;
        }
        return this.eNP.eNR;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: SQ */
    public C42149a mo47418SQ() {
        AppMethodBeat.m2504i(105718);
        C42149a c42149a = new C42149a();
        AppMethodBeat.m2505o(105718);
        return c42149a;
    }

    /* Access modifiers changed, original: protected */
    public void setConfig(C42149a c42149a) {
        this.eNP.eNR = c42149a;
    }

    public void setTextSize(float f) {
        AppMethodBeat.m2504i(105719);
        this.eNP.setTextSize(0, f);
        AppMethodBeat.m2505o(105719);
    }

    public final void setTextSize$255e752(float f) {
        AppMethodBeat.m2504i(105720);
        this.eNP.setTextSize(1, f);
        AppMethodBeat.m2505o(105720);
    }

    public void setTextLayout(C37874f c37874f) {
        AppMethodBeat.m2504i(105721);
        this.eNP.setTextLayout(c37874f);
        AppMethodBeat.m2505o(105721);
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(105722);
        this.eNP.setTextColor(i);
        AppMethodBeat.m2505o(105722);
    }

    public void setGravity(int i) {
        AppMethodBeat.m2504i(105723);
        this.eNP.setGravity(i);
        AppMethodBeat.m2505o(105723);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.m2504i(105724);
        this.eNP.setMaxLines(i);
        AppMethodBeat.m2505o(105724);
    }

    public int getMaxLines() {
        AppMethodBeat.m2504i(105725);
        int maxLines = this.eNP.getMaxLines();
        AppMethodBeat.m2505o(105725);
        return maxLines;
    }

    public void setMinLines(int i) {
        AppMethodBeat.m2504i(105726);
        this.eNP.setMinLines(i);
        AppMethodBeat.m2505o(105726);
    }

    public void setLines(int i) {
        AppMethodBeat.m2504i(105727);
        this.eNP.setLines(i);
        AppMethodBeat.m2505o(105727);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.m2504i(105728);
        this.eNP.setSingleLine(z);
        AppMethodBeat.m2505o(105728);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        AppMethodBeat.m2504i(105729);
        this.eNP.setText(charSequence, z);
        setContentDescription(charSequence);
        AppMethodBeat.m2505o(105729);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(105730);
        setText(charSequence, true);
        AppMethodBeat.m2505o(105730);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        AppMethodBeat.m2504i(105731);
        if (this.eNP != null) {
            this.eNP.mo44127SR();
        }
        super.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(105731);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105732);
        if (this.eNP != null) {
            this.eNP.mo44127SR();
        }
        super.setPadding(i, i2, i3, i4);
        AppMethodBeat.m2505o(105732);
    }

    public CharSequence getText() {
        AppMethodBeat.m2504i(105733);
        CharSequence text = this.eNP.getText();
        AppMethodBeat.m2505o(105733);
        return text;
    }

    public float getTextSize() {
        AppMethodBeat.m2504i(105734);
        float textSize = this.eNP.getTextSize();
        AppMethodBeat.m2505o(105734);
        return textSize;
    }

    public int getTextColor() {
        AppMethodBeat.m2504i(105735);
        int textColor = this.eNP.getTextColor();
        AppMethodBeat.m2505o(105735);
        return textColor;
    }

    public Layout getTvLayout() {
        AppMethodBeat.m2504i(105736);
        Layout tvLayout = this.eNP.getTvLayout();
        AppMethodBeat.m2505o(105736);
        return tvLayout;
    }

    public C37874f getLayoutWrapper() {
        AppMethodBeat.m2504i(105737);
        if (this.eNP == null) {
            AppMethodBeat.m2505o(105737);
            return null;
        }
        C37874f layoutWrapper = this.eNP.getLayoutWrapper();
        AppMethodBeat.m2505o(105737);
        return layoutWrapper;
    }

    public int getLineCount() {
        AppMethodBeat.m2504i(105738);
        int lineCount = this.eNP.getLineCount();
        AppMethodBeat.m2505o(105738);
        return lineCount;
    }

    public int getLineHeight() {
        AppMethodBeat.m2504i(105739);
        int lineHeight = this.eNP.getLineHeight();
        AppMethodBeat.m2505o(105739);
        return lineHeight;
    }

    public int getSelectionStart() {
        AppMethodBeat.m2504i(105740);
        int selectionStart = this.eNP.getSelectionStart();
        AppMethodBeat.m2505o(105740);
        return selectionStart;
    }

    public int getSelectionEnd() {
        AppMethodBeat.m2504i(105741);
        int selectionEnd = this.eNP.getSelectionEnd();
        AppMethodBeat.m2505o(105741);
        return selectionEnd;
    }

    public void setHandleClickableSpan(boolean z) {
        this.eNP.eNY = z;
    }

    public void setClickable(boolean z) {
        AppMethodBeat.m2504i(105742);
        super.setClickable(z);
        if (this.eNP != null) {
            this.eNP.eNX = z;
        }
        AppMethodBeat.m2505o(105742);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105743);
        if (getTvLayout() == null) {
            AppMethodBeat.m2505o(105743);
            return false;
        }
        boolean t = this.eNP.mo44151t(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (t) {
            AppMethodBeat.m2505o(105743);
            return true;
        }
        AppMethodBeat.m2505o(105743);
        return onTouchEvent;
    }

    public boolean performClick() {
        AppMethodBeat.m2504i(105744);
        if (this.eNP == null) {
            AppMethodBeat.m2505o(105744);
            return false;
        } else if (this.eNP.performClick()) {
            boolean performClick = super.performClick();
            AppMethodBeat.m2505o(105744);
            return performClick;
        } else {
            AppMethodBeat.m2505o(105744);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(105745);
        super.onDraw(canvas);
        if (this.eNP != null) {
            this.eNP.onDraw(canvas);
        }
        AppMethodBeat.m2505o(105745);
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
        AppMethodBeat.m2504i(105746);
        if (this.eNP == null) {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(105746);
            return;
        }
        Point ce = this.eNP.mo44128ce(i, i2);
        if (ce != null) {
            setMeasuredDimension(ce.x, ce.y);
            AppMethodBeat.m2505o(105746);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(105746);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(105747);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(105747);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(105748);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(105748);
    }

    public void onStartTemporaryDetach() {
        AppMethodBeat.m2504i(105749);
        super.onStartTemporaryDetach();
        AppMethodBeat.m2505o(105749);
    }

    public void onFinishTemporaryDetach() {
        AppMethodBeat.m2504i(105750);
        super.onFinishTemporaryDetach();
        AppMethodBeat.m2505o(105750);
    }

    public int getOrientation() {
        AppMethodBeat.m2504i(105751);
        int i = getResources().getConfiguration().orientation;
        C4990ab.m7416i("MicroMsg.StaticTextView", "test test getOrientation ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(105751);
        return i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(105752);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.m2505o(105752);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(105753);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!C5046bo.m7519ac(getText())) {
            accessibilityEvent.getText().add(getText());
        }
        AppMethodBeat.m2505o(105753);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.m2504i(105754);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!C5046bo.m7519ac(getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (C1443d.m3068iW(18)) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && C1443d.m3068iW(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(32768);
            accessibilityNodeInfo.addAction(65536);
        }
        if (C1443d.m3068iW(19) && this.eNP.getMaxLines() > 1) {
            accessibilityNodeInfo.setMultiLine(true);
        }
        AppMethodBeat.m2505o(105754);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(105755);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
            if (!C5046bo.m7519ac(getText())) {
                accessibilityEvent.setItemCount(getText().length());
            }
        }
        AppMethodBeat.m2505o(105755);
    }
}
