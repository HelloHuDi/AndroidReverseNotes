package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.b.a;
import android.util.AttributeSet;
import android.view.View;

public class Placeholder extends View {
    int fq = -1;
    View fs = null;
    int ft = 4;

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        super.setVisibility(this.ft);
        this.fq = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.fq = obtainStyledAttributes.getResourceId(index, this.fq);
                } else if (index == 1) {
                    this.ft = obtainStyledAttributes.getInt(index, this.ft);
                }
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.ft = i;
    }

    public int getEmptyVisibility() {
        return this.ft;
    }

    public View getContent() {
        return this.fs;
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
        if (this.fq != i) {
            if (this.fs != null) {
                this.fs.setVisibility(0);
                ((LayoutParams) this.fs.getLayoutParams()).ew = false;
                this.fs = null;
            }
            this.fq = i;
            if (i != -1) {
                View findViewById = ((View) getParent()).findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }
}
