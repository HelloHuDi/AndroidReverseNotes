package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.ab.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends y {
    private a iTW;
    private float ibD;
    private final InputFilter jfd = new InputFilter() {
        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.i(123701);
            if (TextUtils.isEmpty(charSequence) || q.this.iTW == null) {
                AppMethodBeat.o(123701);
                return null;
            }
            Spannable spannable;
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                Object spannable2 = new SpannableStringBuilder(charSequence);
            }
            spannable2.setSpan(q.this.iTW, 0, spannable2.length(), 18);
            AppMethodBeat.o(123701);
            return spannable2;
        }
    };
    private float jfe = 0.0f;
    private float jff = 1.2f;
    private float jfg = getTextSize();
    private boolean jfh = false;
    private MotionEvent jfi;
    private boolean jfj = false;
    final ag<q> jfk = new ag(this);

    public q(Context context) {
        super(context);
        AppMethodBeat.i(123702);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new Factory() {
            public final Spannable newSpannable(CharSequence charSequence) {
                AppMethodBeat.i(123698);
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(q.this.iTW == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(q.this.iTW, 0, newSpannable.length(), 18);
                }
                AppMethodBeat.o(123698);
                return newSpannable;
            }
        });
        super.a(new c() {
            public final void aQS() {
                AppMethodBeat.i(123699);
                q.this.aQO();
                AppMethodBeat.o(123699);
            }
        });
        super.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(123700);
                boolean aOQ = q.this.aOQ();
                AppMethodBeat.o(123700);
                return aOQ;
            }
        });
        this.ibD = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        setAutoHeight(false);
        b(0.0f, false);
        AppMethodBeat.o(123702);
    }

    /* Access modifiers changed, original: final */
    public final Editable c(Editable editable) {
        AppMethodBeat.i(123703);
        Editable c = super.c(editable);
        if (!(this.iTW == null || TextUtils.isEmpty(c))) {
            c.setSpan(this.iTW, 0, c.length(), 18);
        }
        AppMethodBeat.o(123703);
        return c;
    }

    public final void setAutoHeight(boolean z) {
        AppMethodBeat.i(123704);
        this.jfh = z;
        setVerticalScrollBarEnabled(!this.jfh);
        AppMethodBeat.o(123704);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aQO() {
        AppMethodBeat.i(123705);
        if (this.jfh) {
            if (getMeasuredHeight() > getMaxHeight()) {
                setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
                AppMethodBeat.o(123705);
                return;
            } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
                setMeasuredDimension(getMeasuredWidth(), getMinHeight());
            }
        }
        AppMethodBeat.o(123705);
    }

    public final void setGravity(int i) {
        AppMethodBeat.i(123706);
        super.setGravity(((i & -81) & -17) | 48);
        AppMethodBeat.o(123706);
    }

    public final void setSingleLine(boolean z) {
    }

    public final void setInputType(int i) {
        AppMethodBeat.i(123707);
        super.setInputType(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | i);
        AppMethodBeat.o(123707);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        AppMethodBeat.i(123708);
        if (this.jfd != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.jfd;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
        AppMethodBeat.o(123708);
    }

    private void b(float f, boolean z) {
        AppMethodBeat.i(123709);
        if (f <= 0.0f) {
            f = (this.jff * this.jfg) + this.jfe;
        }
        if (this.iTW == null || this.iTW.ax(f)) {
            this.iTW = new a(f);
            if (!z) {
                AppMethodBeat.o(123709);
                return;
            } else if (hasFocus()) {
                invalidate();
                AppMethodBeat.o(123709);
                return;
            } else {
                aRl();
                AppMethodBeat.o(123709);
                return;
            }
        }
        AppMethodBeat.o(123709);
    }

    @Deprecated
    public final float getLineSpacingMultiplier() {
        AppMethodBeat.i(123710);
        float lineSpacingMultiplier = super.getLineSpacingMultiplier();
        AppMethodBeat.o(123710);
        return lineSpacingMultiplier;
    }

    @Deprecated
    public final float getLineSpacingExtra() {
        AppMethodBeat.i(123711);
        float lineSpacingExtra = super.getLineSpacingExtra();
        AppMethodBeat.o(123711);
        return lineSpacingExtra;
    }

    public final void setTextSize(int i, float f) {
        AppMethodBeat.i(123712);
        super.setTextSize(i, f);
        this.jfg = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
        b(0.0f, true);
        AppMethodBeat.o(123712);
    }

    public final int getLineHeight() {
        AppMethodBeat.i(123713);
        int i;
        if (this.iTW != null) {
            i = this.iTW.height;
            AppMethodBeat.o(123713);
            return i;
        }
        i = super.getLineHeight();
        AppMethodBeat.o(123713);
        return i;
    }

    public final void setLineSpacing(float f, float f2) {
        AppMethodBeat.i(123714);
        this.jfe = f;
        this.jff = f2;
        b(0.0f, true);
        AppMethodBeat.o(123714);
    }

    public final void setLineSpace(float f) {
        AppMethodBeat.i(123715);
        setLineSpacing(f, this.jff);
        AppMethodBeat.o(123715);
    }

    public final void setLineHeight(float f) {
        AppMethodBeat.i(123716);
        if (f <= 0.0f) {
            AppMethodBeat.o(123716);
            return;
        }
        b(f, true);
        AppMethodBeat.o(123716);
    }

    public final View getInputPanel() {
        AppMethodBeat.i(123717);
        w cN = w.cN(this);
        AppMethodBeat.o(123717);
        return cN;
    }

    public final boolean aQP() {
        return true;
    }

    public final boolean aQQ() {
        return false;
    }

    public final void aQR() {
        AppMethodBeat.i(123718);
        aj.cS(this).restartInput(this);
        AppMethodBeat.o(123718);
    }

    public final boolean aOQ() {
        AppMethodBeat.i(123719);
        if (!this.jfh) {
            aRh();
            getMeasuredHeight();
        }
        if (isFocusable() || aQT()) {
            AppMethodBeat.o(123719);
            return false;
        }
        AppMethodBeat.o(123719);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123720);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(123720);
    }

    public final void scrollTo(int i, int i2) {
        AppMethodBeat.i(123721);
        super.scrollTo(i, i2);
        AppMethodBeat.o(123721);
    }

    public final void scrollBy(int i, int i2) {
        AppMethodBeat.i(123722);
        super.scrollBy(i, i2);
        AppMethodBeat.o(123722);
    }

    public final boolean canScrollVertically(int i) {
        AppMethodBeat.i(123723);
        if (aRh() <= getHeight()) {
            AppMethodBeat.o(123723);
            return false;
        }
        boolean canScrollVertically = super.canScrollVertically(i);
        AppMethodBeat.o(123723);
        return canScrollVertically;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(123724);
        int a;
        float x;
        float y;
        boolean onTouchEvent;
        if (!aOQ() || !(getParent() instanceof d)) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.jfi = MotionEvent.obtain(motionEvent);
                    this.jfj = true;
                    break;
                case 1:
                case 3:
                    this.jfj = false;
                    if (this.jfi != null) {
                        this.jfi.recycle();
                        this.jfi = null;
                    }
                    if (this.jfj) {
                        a = a.a(this, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()));
                        if (a >= 0) {
                            setSelection(a);
                        }
                    }
                    if (getParent() == null) {
                        AppMethodBeat.o(123724);
                        return true;
                    }
                    break;
                case 2:
                    if (this.jfj) {
                        float x2 = this.jfi.getX(this.jfi.getActionIndex());
                        float y2 = this.jfi.getY(this.jfi.getActionIndex());
                        x = motionEvent.getX(motionEvent.getActionIndex());
                        y = motionEvent.getY(motionEvent.getActionIndex());
                        if (Math.abs(x2 - x) > this.ibD || Math.abs(y2 - y) > this.ibD) {
                            cancelLongPress();
                            setPressed(false);
                            this.jfj = false;
                            break;
                        }
                    }
                    break;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(123724);
            return onTouchEvent;
        } else if (motionEvent.getActionMasked() != 0 || ((d) getParent()).E(motionEvent)) {
            ag agVar = this.jfk;
            com.tencent.mm.plugin.appbrand.widget.base.a.a(agVar.TAG, "processTouchEvent", motionEvent);
            EditText editText = agVar.jgG;
            int actionIndex = motionEvent.getActionIndex();
            x = motionEvent.getX(actionIndex);
            y = motionEvent.getY(actionIndex);
            if (motionEvent.getActionMasked() == 0 || agVar.jgJ != null) {
                Object obj;
                actionIndex = 0;
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        Object obj2;
                        agVar.jgJ = MotionEvent.obtain(motionEvent);
                        agVar.jgI = com.tencent.mm.plugin.appbrand.jsapi.s.d.co(editText);
                        if (editText != null) {
                            ViewParent parent = editText.getParent();
                            while (parent != null && (parent instanceof ViewGroup)) {
                                if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                                    obj2 = 1;
                                    editText.removeCallbacks(agVar.jgL);
                                    if (obj2 == null) {
                                        editText.postDelayed(agVar.jgL, (long) ViewConfiguration.getTapTimeout());
                                    } else {
                                        agVar.jgL.run();
                                    }
                                    actionIndex = 1;
                                    break;
                                }
                                parent = parent.getParent();
                            }
                        }
                        obj2 = null;
                        editText.removeCallbacks(agVar.jgL);
                        if (obj2 == null) {
                        }
                        actionIndex = 1;
                        break;
                    case 1:
                        ab.v(agVar.TAG, "[apptouch] ACTION_UP, pointerDown %B", Boolean.valueOf(agVar.jgK));
                        if (agVar.jgK && agVar.jgJ != null) {
                            f co = com.tencent.mm.plugin.appbrand.jsapi.s.d.co(agVar.jgG);
                            if (agVar.jgI == null || Math.abs(agVar.jgI.x - co.x) > 1.0f || Math.abs(agVar.jgI.y - co.y) > 1.0f) {
                                ab.v(agVar.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
                            } else if (agVar.a(agVar.jgJ, motionEvent)) {
                                ((ab) editText).N(x, y);
                            } else {
                                ab.v(agVar.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
                            }
                        }
                        agVar.aRq();
                        break;
                    case 2:
                        float f = agVar.jgH;
                        if (x < (-f) || y < (-f) || x >= ((float) editText.getWidth()) + f || y >= ((float) editText.getHeight()) + f) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null && agVar.a(agVar.jgJ, motionEvent)) {
                            actionIndex = 1;
                            break;
                        }
                        agVar.jgK = false;
                        editText.removeCallbacks(agVar.jgL);
                        editText.removeCallbacks(agVar.jgM);
                        break;
                        break;
                    case 3:
                        agVar.aRq();
                        break;
                }
                EditText editText2 = agVar.jgG;
                Editable text = agVar.jgG.getText();
                if (editText2.canScrollVertically(-1) || editText2.canScrollVertically(1)) {
                    a[] aVarArr;
                    int scaledTouchSlop;
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            aVarArr = (a[]) text.getSpans(0, text.length(), a.class);
                            for (Object removeSpan : aVarArr) {
                                text.removeSpan(removeSpan);
                            }
                            text.setSpan(new a(motionEvent.getX(), motionEvent.getY(), editText2.getScrollX(), editText2.getScrollY()), 0, 0, 17);
                            a = 1;
                            break;
                        case 1:
                        case 3:
                            aVarArr = ai.g(editText2);
                            if (aVarArr != null && aVarArr.length > 0 && aVarArr[0].jgY) {
                                a = 1;
                                break;
                            }
                            a = 0;
                            break;
                        case 2:
                            aVarArr = (a[]) text.getSpans(0, text.length(), a.class);
                            if (aVarArr.length > 0) {
                                if (!aVarArr[0].jgX) {
                                    scaledTouchSlop = ViewConfiguration.get(editText2.getContext()).getScaledTouchSlop();
                                    if (Math.abs(motionEvent.getX() - aVarArr[0].avX) >= ((float) scaledTouchSlop) || Math.abs(motionEvent.getY() - aVarArr[0].avY) >= ((float) scaledTouchSlop)) {
                                        aVarArr[0].jgX = true;
                                    }
                                }
                                if (aVarArr[0].jgX) {
                                    aVarArr[0].jgY = true;
                                    obj = ((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(text, 1) != 1 && MetaKeyKeyListener.getMetaState(text, 2048) == 0) ? null : 1;
                                    if (obj != null) {
                                        y = motionEvent.getX() - aVarArr[0].avX;
                                        x = motionEvent.getY() - aVarArr[0].avY;
                                    } else {
                                        y = aVarArr[0].avX - motionEvent.getX();
                                        x = aVarArr[0].avY - motionEvent.getY();
                                    }
                                    aVarArr[0].avX = motionEvent.getX();
                                    aVarArr[0].avY = motionEvent.getY();
                                    if (aVarArr[0].jgZ) {
                                        aVarArr[0].jgZ = false;
                                        aVarArr[0].jgX = false;
                                    } else {
                                        int scrollX = ((int) y) + editText2.getScrollX();
                                        scaledTouchSlop = ((int) x) + editText2.getScrollY();
                                        int totalPaddingTop = editText2.getTotalPaddingTop() + editText2.getTotalPaddingBottom();
                                        Layout layout = editText2.getLayout();
                                        totalPaddingTop = Math.max(Math.min(scaledTouchSlop, layout.getHeight() - (editText2.getHeight() - totalPaddingTop)), 0);
                                        int scrollX2 = editText2.getScrollX();
                                        int scrollY = editText2.getScrollY();
                                        int width = editText2.getWidth() - (editText2.getTotalPaddingLeft() + editText2.getTotalPaddingRight());
                                        scaledTouchSlop = layout.getLineForVertical(totalPaddingTop);
                                        Alignment paragraphAlignment = layout.getParagraphAlignment(scaledTouchSlop);
                                        if (layout.getParagraphDirection(scaledTouchSlop) > 0) {
                                            obj = 1;
                                        } else {
                                            obj = null;
                                        }
                                        int i = width + 0;
                                        if (i >= width) {
                                            scaledTouchSlop = Math.max(Math.min(scrollX, 0), 0);
                                        } else if (paragraphAlignment == Alignment.ALIGN_CENTER) {
                                            scaledTouchSlop = 0 - ((width - i) / 2);
                                        } else if ((obj == null || paragraphAlignment != Alignment.ALIGN_OPPOSITE) && !(obj == null && paragraphAlignment == Alignment.ALIGN_NORMAL)) {
                                            scaledTouchSlop = 0;
                                        } else {
                                            scaledTouchSlop = 0 - (width - i);
                                        }
                                        editText2.scrollTo(scaledTouchSlop, totalPaddingTop);
                                        if (scrollX2 != editText2.getScrollX() || scrollY != editText2.getScrollY()) {
                                            editText2.cancelLongPress();
                                            aVarArr[0].arP = true;
                                            a = 1;
                                            break;
                                        } else if (aVarArr[0].arP) {
                                            a = 1;
                                            break;
                                        } else {
                                            ai.g(editText2);
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
                a = 0;
                onTouchEvent = a | actionIndex;
                com.tencent.mm.plugin.appbrand.widget.base.a.a(agVar.TAG, "[textscroll] handled | ".concat(String.valueOf(onTouchEvent)), motionEvent);
                AppMethodBeat.o(123724);
                return onTouchEvent;
            }
            ab.v(agVar.TAG, "[textscroll] no pointer down before, just return");
            agVar.aRq();
            AppMethodBeat.o(123724);
            return false;
        } else {
            AppMethodBeat.o(123724);
            return false;
        }
    }

    public final void N(float f, float f2) {
        AppMethodBeat.i(123725);
        if (isEnabled()) {
            if (aOQ()) {
                int a = a.a(this, f, f2);
                if (a >= 0) {
                    setSelection(a);
                }
            }
            super.performClick();
            AppMethodBeat.o(123725);
            return;
        }
        AppMethodBeat.o(123725);
    }

    public final boolean performHapticFeedback(int i, int i2) {
        AppMethodBeat.i(123726);
        boolean performHapticFeedback = super.performHapticFeedback(i, i2);
        AppMethodBeat.o(123726);
        return performHapticFeedback;
    }
}
