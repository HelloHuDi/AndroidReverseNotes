package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.C25290b.C25291a;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.View;

public class Placeholder extends View {
    /* renamed from: fq */
    int f15633fq = -1;
    /* renamed from: fs */
    View f15634fs = null;
    /* renamed from: ft */
    int f15635ft = 4;

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m62046b(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m62046b(attributeSet);
    }

    /* renamed from: b */
    private void m62046b(AttributeSet attributeSet) {
        super.setVisibility(this.f15635ft);
        this.f15633fq = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C25291a.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.f15633fq = obtainStyledAttributes.getResourceId(index, this.f15633fq);
                } else if (index == 1) {
                    this.f15635ft = obtainStyledAttributes.getInt(index, this.f15635ft);
                }
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.f15635ft = i;
    }

    public int getEmptyVisibility() {
        return this.f15635ft;
    }

    public View getContent() {
        return this.f15634fs;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Align.LEFT);
            String str = "?";
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i) {
        if (this.f15633fq != i) {
            if (this.f15634fs != null) {
                this.f15634fs.setVisibility(0);
                ((LayoutParams) this.f15634fs.getLayoutParams()).f14474ew = false;
                this.f15634fs = null;
            }
            this.f15633fq = i;
            if (i != -1) {
                View findViewById = ((View) getParent()).findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }
}
