package com.tencent.mm.media.editor.view;

import a.f.a.b;
import a.f.b.j;
import a.h.d;
import a.h.h;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, dWq = {"Lcom/tencent/mm/media/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "radiusNormalOuter", "radiusSelectInner", "radiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-mediaeditor_release"})
public final class TextColorSelector extends View {
    private final String TAG;
    private Paint aFY;
    private int biG;
    private final int eVh;
    private float eVi;
    private int[] eVj;
    private int eVk;
    private float eVl;
    private float eVm;
    private float eVn;
    private float eVo;
    private b<? super Integer, y> eVp;

    public TextColorSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(12930);
        this.TAG = "TextColorSelector";
        this.eVh = -1;
        this.aFY = new Paint(1);
        this.eVj = new int[0];
        this.eVk = -1;
        this.biG = -1;
        this.eVl = getResources().getDimension(R.dimen.zl);
        this.eVm = getResources().getDimension(R.dimen.zm);
        this.eVn = getResources().getDimension(R.dimen.zn);
        this.eVo = getResources().getDimension(R.dimen.zo);
        this.aFY.setStyle(Style.FILL);
        AppMethodBeat.o(12930);
    }

    public TextColorSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final b<Integer, y> getColorSelectedCallback() {
        return this.eVp;
    }

    public final void setColorSelectedCallback(b<? super Integer, y> bVar) {
        this.eVp = bVar;
    }

    public final void setColorList(int[] iArr) {
        AppMethodBeat.i(12926);
        j.p(iArr, "colorArray");
        this.eVj = iArr;
        AppMethodBeat.o(12926);
    }

    public final void setSelected(int i) {
        this.biG = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(12927);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        super.onDraw(canvas);
        this.eVi = (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) - (this.eVm * 2.0f)) / ((float) (this.eVj.length - 1));
        float height = ((float) getHeight()) / 2.0f;
        int length = this.eVj.length;
        for (int i = 0; i < length; i++) {
            float paddingLeft = ((this.eVi * ((float) i)) + this.eVm) + ((float) getPaddingLeft());
            this.aFY.setColor(this.eVh);
            if (i == this.biG) {
                canvas.drawCircle(paddingLeft, height, this.eVo, this.aFY);
            } else {
                canvas.drawCircle(paddingLeft, height, this.eVm, this.aFY);
            }
            this.aFY.setColor(this.eVj[i]);
            if (i == this.biG) {
                canvas.drawCircle(paddingLeft, height, this.eVn, this.aFY);
            } else {
                canvas.drawCircle(paddingLeft, height, this.eVl, this.aFY);
            }
        }
        AppMethodBeat.o(12927);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(12928);
        j.p(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.eVk = E(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                int E = E(motionEvent.getX(), motionEvent.getY());
                if (E >= 0 && E == this.eVk) {
                    this.biG = E;
                    b bVar = this.eVp;
                    if (bVar != null) {
                        bVar.am(Integer.valueOf(this.biG));
                    }
                }
                this.eVk = -1;
                postInvalidate();
                break;
            case 3:
                this.eVk = -1;
                break;
        }
        AppMethodBeat.o(12928);
        return true;
    }

    private final int E(float f, float f2) {
        AppMethodBeat.i(12929);
        if (h.a(new d(0, getMeasuredHeight()), f2)) {
            int round = Math.round(((f - ((float) getPaddingLeft())) - this.eVm) / this.eVi);
            if (round >= 0 && round < this.eVj.length) {
                AppMethodBeat.o(12929);
                return round;
            }
        }
        AppMethodBeat.o(12929);
        return -1;
    }
}
