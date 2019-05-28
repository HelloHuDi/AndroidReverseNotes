package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView extends TextView {
    private boolean gLJ = true;
    public int maxLines;
    private Paint zBH;
    private String zBI;
    private Rect zBJ = new Rect();
    private LinkedList<String> zBK = new LinkedList();
    public int zBL;
    private Drawable zBM;
    public boolean zBN;
    private int zBO = 0;

    public CustomFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107617);
        AppMethodBeat.o(107617);
    }

    public CustomFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107618);
        AppMethodBeat.o(107618);
    }

    public final void a(String str, int i, boolean z, int i2, int i3) {
        AppMethodBeat.i(107619);
        this.maxLines = i;
        this.zBI = str;
        if (this.zBI == null) {
            ab.w("MicroMsg.CustomFitTextView", "ori text is null");
            this.zBI = "";
        }
        if (this.maxLines <= 0) {
            ab.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
            this.maxLines = 2;
        }
        this.zBO = getResources().getDimensionPixelSize(R.dimen.f15do);
        this.zBN = z;
        this.zBL = i2;
        if (this.zBN) {
            this.zBM = getResources().getDrawable(this.zBL);
        }
        this.zBH = new Paint();
        this.zBH.set(getPaint());
        this.zBH.setAntiAlias(true);
        this.zBH.setColor(i3);
        eG(this.zBI, getWidth());
        setHeight(Math.max(dJK(), a.fromDPToPix(getContext(), 32)));
        AppMethodBeat.o(107619);
    }

    private int dJK() {
        AppMethodBeat.i(107620);
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        int size = ((int) ((((fontMetrics.leading + (fontMetrics.bottom - fontMetrics.top)) * ((float) this.zBK.size())) + ((float) getPaddingTop())) + ((float) getPaddingBottom()))) + (Math.max(0, this.zBK.size() - 1) * this.zBO);
        AppMethodBeat.o(107620);
        return size;
    }

    private boolean eG(String str, int i) {
        AppMethodBeat.i(107621);
        if (!this.gLJ || i <= 0 || str == null || "".equals(str)) {
            AppMethodBeat.o(107621);
            return false;
        }
        int ceil;
        this.zBK.clear();
        int i2 = 0;
        int length = str.length();
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.zBN ? this.zBM.getIntrinsicWidth() : 0;
        float measureText = ((float) intrinsicWidth) + getPaint().measureText(str, 0, length);
        int i3 = this.maxLines;
        if (Float.compare(measureText, (float) (this.maxLines * paddingLeft)) < 0) {
            ceil = (int) Math.ceil((double) (measureText / ((float) paddingLeft)));
        } else {
            ceil = i3;
        }
        for (int i4 = 0; i4 < ceil; i4++) {
            if (i4 == ceil - 1) {
                asf(str.substring(i2, d(str, i2, length, intrinsicWidth, paddingLeft)).trim());
            } else {
                i3 = d(str, i2, length, 0, paddingLeft);
                asf(str.substring(i2, i3).trim());
                if (i3 >= length) {
                    ab.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
                    break;
                }
                i2 = i3;
            }
        }
        AppMethodBeat.o(107621);
        return true;
    }

    private void asf(String str) {
        AppMethodBeat.i(107622);
        if (this.zBK != null) {
            if (str == null || "".equals(str)) {
                AppMethodBeat.o(107622);
                return;
            }
            this.zBK.add(str);
        }
        AppMethodBeat.o(107622);
    }

    private int d(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107623);
        if (i2 <= i) {
            i2 = i + 1;
            AppMethodBeat.o(107623);
            return i2;
        } else if (getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            AppMethodBeat.o(107623);
            return i2;
        } else {
            int length = str.length();
            while (getPaint().measureText(str, i, i2) + ((float) i3) > ((float) i4)) {
                i2 = (i2 + i) >> 1;
            }
            while (i2 <= length && getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
                i2++;
            }
            int min = Math.min(length, i2) - 1;
            length = min;
            while (length >= 0 && bo.z(str.charAt(length))) {
                length--;
            }
            if (length < 0 || length == min) {
                i2--;
                AppMethodBeat.o(107623);
                return i2;
            }
            i2 = length + 1;
            AppMethodBeat.o(107623);
            return i2;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107624);
        if (!this.gLJ) {
            AppMethodBeat.o(107624);
        } else if (this.zBI == null || "".equals(this.zBI) || this.zBK.size() == 0) {
            AppMethodBeat.o(107624);
        } else {
            FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f = fontMetrics.descent - fontMetrics.ascent;
            float paddingLeft = (float) getPaddingLeft();
            float paddingTop = (float) getPaddingTop();
            Iterator it = this.zBK.iterator();
            float f2 = paddingTop;
            while (it.hasNext()) {
                float f3 = (fontMetrics.leading + f) + f2;
                canvas.drawText((String) it.next(), paddingLeft, f3, this.zBH);
                f2 = f3;
            }
            if (this.zBN) {
                getPaint().getTextBounds((String) this.zBK.getLast(), 0, ((String) this.zBK.getLast()).length(), this.zBJ);
                int paddingLeft2 = getPaddingLeft() + this.zBJ.right;
                int i = (int) ((f2 - f) - fontMetrics.leading);
                this.zBM.setBounds(paddingLeft2, i, this.zBM.getIntrinsicWidth() + paddingLeft2, this.zBM.getIntrinsicHeight() + i);
                this.zBM.draw(canvas);
            }
            AppMethodBeat.o(107624);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107625);
        boolean z = (i == i3 && i2 == i4) ? false : true;
        this.gLJ = z;
        if (this.gLJ) {
            eG(this.zBI, i);
        }
        AppMethodBeat.o(107625);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107626);
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        if (eG(this.zBI, size)) {
            fromDPToPix = Math.max(dJK(), fromDPToPix);
        }
        setMeasuredDimension(size, fromDPToPix);
        AppMethodBeat.o(107626);
    }
}
