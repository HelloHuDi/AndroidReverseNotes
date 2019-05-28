package com.tencent.p177mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.p057v4.widget.C8415j;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C18525b;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.kiss.widget.textview.p857b.C9563b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.kiss.widget.textview.g */
public final class C26349g {
    protected C37874f eNQ;
    public C42149a eNR;
    protected StaticLayout eNS;
    protected boolean eNT = false;
    int eNU;
    int eNV;
    private boolean eNW = false;
    boolean eNX = false;
    boolean eNY = false;
    private boolean eNZ = false;
    private View eOa;
    private int eOb = 0;
    private int eOc = 0;
    protected CharSequence text = null;

    public C26349g(View view, C42149a c42149a) {
        this.eOa = view;
        this.eNR = c42149a;
    }

    public final void init() {
        AppMethodBeat.m2504i(105756);
        this.text = "";
        this.eOa.setWillNotDraw(false);
        AppMethodBeat.m2505o(105756);
    }

    public final void setSingleLine(boolean z) {
        int i;
        AppMethodBeat.m2504i(105757);
        if (z) {
            i = 1;
        } else {
            i = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (this.eNR.maxLines != i) {
            this.eNR.maxLines = i;
            this.eNT = true;
            mo44127SR();
            this.eOa.requestLayout();
            this.eOa.invalidate();
        }
        AppMethodBeat.m2505o(105757);
    }

    public final void setLines(int i) {
        AppMethodBeat.m2504i(105758);
        if (!(this.eNR.maxLines == i && this.eNR.minLines == i)) {
            this.eNT = true;
            mo44127SR();
            this.eNR.maxLines = i;
            this.eNR.minLines = i;
            this.eOa.requestLayout();
            this.eOa.invalidate();
            if (C18527h.DEBUG) {
                C4990ab.m7416i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
        AppMethodBeat.m2505o(105758);
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        AppMethodBeat.m2504i(105759);
        Context context = C4996ah.getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        AppMethodBeat.m2505o(105759);
    }

    private void setRawTextSize(float f) {
        AppMethodBeat.m2504i(105760);
        if (!(f == 0.0f || this.eNR == null || f == this.eNR.eOg)) {
            this.eNR.eOg = f;
            this.eNT = true;
            if (C18527h.DEBUG) {
                C4990ab.m7416i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
        AppMethodBeat.m2505o(105760);
    }

    public final void setTextLayout(C37874f c37874f) {
        AppMethodBeat.m2504i(105761);
        if (c37874f == null || c37874f.eNO == null) {
            this.eNQ = null;
            AppMethodBeat.m2505o(105761);
            return;
        }
        if (this.eNR == null) {
            C18525b c18525b = new C18525b();
            c18525b.eNR = new C42149a();
            c18525b.eNR.maxLines = c37874f.maxLines;
            c18525b.eNR.maxLength = c37874f.maxLength;
            c18525b.eNR.eNN = c37874f.eNN;
            c18525b.eNR.eNC = c37874f.eNC;
            c18525b.eNR.eND = c37874f.eND;
            c18525b.eNR.gravity = c37874f.gravity;
            c18525b.eNR.eOg = c37874f.eNN.getTextSize();
            c18525b.eNR.textColor = c37874f.eNN.getColor();
            this.eNR = c18525b.eNR;
        }
        mo44127SR();
        this.eOa.setWillNotDraw(false);
        this.eNQ = c37874f;
        this.eNS = c37874f.eNO;
        this.text = c37874f.text;
        this.eNW = this.text instanceof Spannable;
        if (this.eNW) {
            this.text = this.eNQ.text;
            C9563b.m17029SV();
            C9563b.m17030a((Spannable) this.text);
        }
        this.eOa.requestLayout();
        this.eOa.invalidate();
        AppMethodBeat.m2505o(105761);
    }

    public final void setTextColor(int i) {
        AppMethodBeat.m2504i(105762);
        if (!(this.eNR == null || i == this.eNR.textColor)) {
            this.eNR.textColor = i;
            this.eNT = true;
            if (C18527h.DEBUG) {
                C4990ab.m7416i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
        AppMethodBeat.m2505o(105762);
    }

    public final void setGravity(int i) {
        AppMethodBeat.m2504i(105763);
        if (!(this.eNR == null || i == this.eNR.gravity)) {
            this.eNR.gravity = i;
            this.eNT = true;
            if (C18527h.DEBUG) {
                C4990ab.m7416i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
        AppMethodBeat.m2505o(105763);
    }

    public final void setMaxLines(int i) {
        AppMethodBeat.m2504i(105764);
        if (!(this.eNR == null || i == this.eNR.maxLines)) {
            this.eNR.maxLines = i;
            this.eNT = true;
            mo44127SR();
            if (C18527h.DEBUG) {
                C4990ab.m7416i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.eOa.requestLayout();
            this.eOa.invalidate();
        }
        AppMethodBeat.m2505o(105764);
    }

    public final int getMaxLines() {
        if (this.eNR != null) {
            return this.eNR.maxLines;
        }
        return -1;
    }

    public final void setMinLines(int i) {
        AppMethodBeat.m2504i(105765);
        if (this.eNR.minLines != i) {
            this.eNR.minLines = i;
            mo44127SR();
            this.eOa.requestLayout();
            this.eOa.invalidate();
        }
        AppMethodBeat.m2505o(105765);
    }

    public final int getLineHeight() {
        AppMethodBeat.m2504i(105766);
        TextPaint paint = this.eNQ.eNO.getPaint();
        if (paint == null) {
            paint = this.eNR.eNN;
        }
        int round = Math.round((((float) paint.getFontMetricsInt(null)) * this.eNR.eNH) + this.eNR.eNG);
        AppMethodBeat.m2505o(105766);
        return round;
    }

    public final void setText(CharSequence charSequence, boolean z) {
        AppMethodBeat.m2504i(105767);
        if (charSequence == null) {
            AppMethodBeat.m2505o(105767);
            return;
        }
        if (this.text == null || !this.text.equals(charSequence) || z) {
            this.text = charSequence;
            this.eNT = true;
            this.eOa.requestLayout();
            this.eOa.invalidate();
            if (C18527h.DEBUG) {
                C4990ab.m7416i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + charSequence + " hashcode " + hashCode() + " " + C5046bo.dpG().toString());
            }
        }
        AppMethodBeat.m2505o(105767);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: SR */
    public final void mo44127SR() {
        this.eOc = 0;
        this.eOb = 0;
        this.eNU = 0;
        this.eNV = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        AppMethodBeat.m2504i(105768);
        float textSize;
        if (this.eNQ != null) {
            textSize = this.eNQ.eNN.getTextSize();
            AppMethodBeat.m2505o(105768);
            return textSize;
        } else if (this.eNR != null) {
            textSize = this.eNR.eOg;
            AppMethodBeat.m2505o(105768);
            return textSize;
        } else {
            AppMethodBeat.m2505o(105768);
            return 0.0f;
        }
    }

    public final int getTextColor() {
        AppMethodBeat.m2504i(105769);
        int color;
        if (this.eNQ != null) {
            color = this.eNQ.eNN.getColor();
            AppMethodBeat.m2505o(105769);
            return color;
        } else if (this.eNR != null) {
            color = this.eNR.textColor;
            AppMethodBeat.m2505o(105769);
            return color;
        } else {
            AppMethodBeat.m2505o(105769);
            return 0;
        }
    }

    public final Layout getTvLayout() {
        return this.eNS;
    }

    public final C37874f getLayoutWrapper() {
        return this.eNQ;
    }

    public final int getLineCount() {
        AppMethodBeat.m2504i(105770);
        if (this.eNS == null) {
            AppMethodBeat.m2505o(105770);
            return 0;
        }
        int lineCount = this.eNS.getLineCount();
        AppMethodBeat.m2505o(105770);
        return lineCount;
    }

    public final int getSelectionStart() {
        AppMethodBeat.m2504i(105771);
        if (this.text == null) {
            AppMethodBeat.m2505o(105771);
            return -1;
        }
        int selectionStart = Selection.getSelectionStart(this.text);
        AppMethodBeat.m2505o(105771);
        return selectionStart;
    }

    public final int getSelectionEnd() {
        AppMethodBeat.m2504i(105772);
        if (this.text == null) {
            AppMethodBeat.m2505o(105772);
            return -1;
        }
        int selectionEnd = Selection.getSelectionEnd(this.text);
        AppMethodBeat.m2505o(105772);
        return selectionEnd;
    }

    /* renamed from: t */
    public final boolean mo44151t(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(105773);
        boolean z2 = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (this.eOa.isEnabled() && this.eNW) {
            C9563b.m17029SV();
            boolean a = C9563b.m17031a(this.eOa, this.eNS, (Spannable) this.text, motionEvent);
            this.eNZ = a;
            if (this.eNY && z2) {
                boolean z3;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (x < ((float) this.eNU) || x > ((float) (this.eNS.getWidth() + this.eNU))) {
                    z3 = false;
                } else if (y < ((float) this.eNV) || y > ((float) (this.eNS.getHeight() + this.eNV))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) this.text).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
                    if (clickableSpanArr.length > 0) {
                        C4990ab.m7410d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                        clickableSpanArr[0].onClick(this.eOa);
                        z = true;
                    }
                }
            }
            z = a;
        }
        AppMethodBeat.m2505o(105773);
        return z;
    }

    public final boolean performClick() {
        if (this.eNZ || !this.eNX) {
            return false;
        }
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(105774);
        if (this.eNS == null || this.eNQ == null) {
            boolean jT = m41926jT(this.eOa.getMeasuredWidth());
            if (C18527h.DEBUG) {
                C4990ab.m7411d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.eNS, this.eNQ, Boolean.valueOf(jT));
            }
            if (jT) {
                this.eOa.requestLayout();
                this.eOa.invalidate();
            }
            AppMethodBeat.m2505o(105774);
            return;
        }
        long j = 0;
        if (C18527h.DEBUG) {
            j = System.nanoTime();
        }
        canvas.save();
        canvas.clipRect(this.eOa.getPaddingLeft(), this.eOa.getPaddingTop(), (this.eOa.getRight() - this.eOa.getLeft()) - this.eOa.getPaddingRight(), (this.eOa.getBottom() - this.eOa.getTop()) - this.eOa.getPaddingBottom());
        if (this.eNU == 0 || this.eNV == 0) {
            int paddingLeft = this.eOa.getPaddingLeft();
            int right = ((this.eOa.getRight() - this.eOa.getLeft()) - this.eOa.getPaddingLeft()) - this.eOa.getPaddingRight();
            int width = this.eNS.getWidth();
            if (width > right) {
                right = paddingLeft;
            } else {
                switch (this.eNQ.gravity & 8388615) {
                    case 1:
                    case 17:
                        right = (right / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        right = 0;
                        break;
                    case 5:
                    case 8388613:
                        right -= width;
                        break;
                    default:
                        right = 0;
                        break;
                }
                right += paddingLeft;
            }
            this.eNU = right;
            paddingLeft = this.eOa.getPaddingTop();
            width = ((this.eOa.getBottom() - this.eOa.getTop()) - this.eOa.getPaddingTop()) - this.eOa.getPaddingBottom();
            right = 0;
            int height = this.eNS.getHeight();
            if (height > width) {
                right = paddingLeft;
            } else {
                switch (this.eNQ.gravity & 112) {
                    case 16:
                        right = (width / 2) - (height / 2);
                        break;
                    case 48:
                        right = 0;
                        break;
                    case 80:
                        right = width - height;
                        break;
                }
                right += paddingLeft;
            }
            this.eNV = right;
        }
        canvas.translate((float) this.eNU, (float) this.eNV);
        this.eNS.draw(canvas, null, null, 0);
        canvas.restore();
        if (C18527h.DEBUG) {
            C4990ab.m7411d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        }
        AppMethodBeat.m2505o(105774);
    }

    /* renamed from: jT */
    private boolean m41926jT(int i) {
        AppMethodBeat.m2504i(105775);
        if (this.eNT || this.eNQ == null || this.eNS == null) {
            if (this.eNR == null) {
                AppMethodBeat.m2505o(105775);
                return false;
            } else if (i > 0) {
                mo44127SR();
                long j = 0;
                if (C18527h.DEBUG) {
                    j = System.nanoTime();
                }
                this.eNQ = C45416d.m83643a(this.text, i, this.eNR).mo73210SO();
                this.eNS = this.eNQ.eNO;
                this.eNT = false;
                if (C18527h.DEBUG) {
                    long nanoTime = System.nanoTime();
                    C4990ab.m7411d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i), Integer.valueOf(hashCode()), Double.valueOf(((double) (nanoTime - j)) / 1000000.0d), this.text);
                }
                AppMethodBeat.m2505o(105775);
                return true;
            }
        }
        AppMethodBeat.m2505o(105775);
        return false;
    }

    /* renamed from: ce */
    public final Point mo44128ce(int i, int i2) {
        Point point;
        AppMethodBeat.m2504i(105776);
        long j = 0;
        if (C18527h.DEBUG) {
            j = System.nanoTime();
        }
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        m41926jT(size);
        if (this.eNS != null) {
            int i3;
            int i4;
            if (mode != ErrorDialogData.SUPPRESSED) {
                i3 = 0;
                if (this.eNR.eND == null) {
                    StaticLayout staticLayout = this.eNS;
                    if (this.eOb != 0) {
                        i3 = this.eOb;
                    } else {
                        int lineCount = staticLayout.getLineCount();
                        CharSequence text = staticLayout.getText();
                        float f = 0.0f;
                        for (i4 = 0; i4 < lineCount - 1; i4++) {
                            if (text.charAt(staticLayout.getLineEnd(i4) - 1) != 10) {
                                i3 = -1;
                                break;
                            }
                        }
                        for (i4 = 0; i4 < lineCount; i4++) {
                            f = Math.max(f, staticLayout.getLineWidth(i4));
                        }
                        this.eOb = (int) Math.ceil((double) f);
                        this.eOb += this.eOa.getPaddingLeft() + this.eOa.getPaddingRight();
                        i3 = this.eOb;
                    }
                }
                i4 = (int) Math.ceil((double) Layout.getDesiredWidth(this.eNS.getText(), this.eNS.getPaint()));
                if (i4 > i3) {
                    i3 = i4;
                }
                if (C18527h.DEBUG) {
                    C4990ab.m7411d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                if (mode == C8415j.INVALID_ID) {
                    size = Math.min(size, i3);
                } else {
                    size = i3;
                }
            }
            if (mode2 == ErrorDialogData.SUPPRESSED) {
                i3 = size2;
            } else {
                StaticLayout staticLayout2 = this.eNS;
                if (this.eOc != 0) {
                    i3 = this.eOc;
                } else {
                    i3 = staticLayout2.getLineCount();
                    if (this.eNQ.maxLines > 0 && this.eNQ.maxLines < i3) {
                        i3 = this.eNQ.maxLines;
                    }
                    mode = this.eOa.getPaddingTop() + this.eOa.getPaddingBottom();
                    i4 = staticLayout2.getLineTop(i3);
                    if (this.eNR.minLines <= 0 || i3 >= this.eNR.minLines) {
                        i3 = i4;
                    } else {
                        i3 = ((this.eNR.minLines - i3) * getLineHeight()) + i4;
                    }
                    this.eOc = i3 + mode;
                    i3 = this.eOc;
                }
                if (mode2 == C8415j.INVALID_ID) {
                    i3 = Math.min(i3, size2);
                }
            }
            point = new Point(size, i3);
        } else {
            point = null;
        }
        if (C18527h.DEBUG) {
            String str = "MicroMsg.StaticTextViewHolder";
            String str2 = "onMeasure used: %fms, hashCode: %d, text: %s result: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? "" : point.toString();
            C4990ab.m7411d(str, str2, objArr);
        }
        AppMethodBeat.m2505o(105776);
        return point;
    }
}
