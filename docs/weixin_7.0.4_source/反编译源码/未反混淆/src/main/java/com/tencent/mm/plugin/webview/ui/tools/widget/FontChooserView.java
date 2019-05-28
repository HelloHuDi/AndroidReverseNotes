package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView extends View {
    private static SoftReference<Bitmap> qqG = null;
    private int bCp = 0;
    private int eCL = 0;
    private float neG = 0.0f;
    private float neH = 0.0f;
    private List<b> qqH = new ArrayList(4);
    private int qqI = 0;
    private int qqJ = 0;
    private int qqK = 0;
    private int qqL = 0;
    private int qqN = 0;
    private boolean qqQ = false;
    private boolean qqR = false;
    private int topOffset = 0;
    private a uJf = null;

    static class b {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private b() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public interface a {
        void Cl(int i);
    }

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(9896);
        AppMethodBeat.o(9896);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(9897);
        AppMethodBeat.o(9897);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int intrinsicWidth;
        int height;
        AppMethodBeat.i(9898);
        super.onLayout(z, i, i2, i3, i4);
        cjs();
        this.qqH.clear();
        setClickable(true);
        this.qqI = com.tencent.mm.bz.a.fromDPToPix(getContext(), 50);
        this.topOffset = com.tencent.mm.bz.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.bCp = (getHeight() / 2) + this.topOffset;
        this.eCL = (width - (this.qqI * 2)) / 3;
        Bitmap bitmap = (Bitmap) qqG.get();
        if (bitmap == null || bitmap.isRecycled()) {
            Drawable drawable = getResources().getDrawable(R.drawable.b65);
            width = drawable.getIntrinsicHeight();
            intrinsicWidth = drawable.getIntrinsicWidth();
        } else {
            height = bitmap.getHeight();
            intrinsicWidth = bitmap.getWidth();
            width = height;
        }
        for (height = 0; height < 4; height++) {
            b bVar = new b();
            bVar.left = (this.qqI + (this.eCL * height)) - (intrinsicWidth / 2);
            bVar.top = this.bCp - (width / 2);
            bVar.right = (this.qqI + (this.eCL * height)) + (intrinsicWidth / 2);
            bVar.bottom = this.bCp + (width / 2);
            this.qqH.add(bVar);
        }
        this.qqJ = this.qqN;
        this.qqK = ((b) this.qqH.get(this.qqJ)).left;
        this.qqL = ((b) this.qqH.get(this.qqJ)).top;
        invalidate();
        AppMethodBeat.o(9898);
    }

    private void cjs() {
        AppMethodBeat.i(9899);
        if (qqG == null || qqG.get() == null) {
            qqG = new SoftReference(BitmapFactory.decodeResource(getResources(), R.drawable.b65));
        }
        AppMethodBeat.o(9899);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(9900);
        super.onDraw(canvas);
        cjs();
        Paint paint = new Paint();
        paint.setARGB(255, 152, 152, 152);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.qqI, (float) this.bCp, (float) (width - this.qqI), (float) this.bCp, paint);
        width = 0;
        while (true) {
            int i = width;
            if (i >= 4) {
                break;
            }
            canvas.drawLine((float) (this.qqI + (this.eCL * i)), (float) (this.bCp - fromDPToPix), (float) (this.qqI + (this.eCL * i)), (float) (this.bCp + fromDPToPix), paint);
            width = i + 1;
        }
        Bitmap bitmap = (Bitmap) qqG.get();
        if (bitmap == null || bitmap.isRecycled()) {
            width = getResources().getDrawable(R.drawable.b65).getIntrinsicHeight();
        } else {
            canvas.drawBitmap(bitmap, (float) this.qqK, (float) this.qqL, null);
            width = bitmap.getHeight();
        }
        String string = getResources().getString(R.string.fyd);
        String string2 = getResources().getString(R.string.fye);
        String string3 = getResources().getString(R.string.fyb);
        String string4 = getResources().getString(R.string.fyc);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a2_);
        Paint paint2 = new Paint();
        paint2.setTextSize((float) dimensionPixelSize);
        fromDPToPix = (int) paint2.measureText(string);
        dimensionPixelSize = JS(dimensionPixelSize);
        paint2.setColor(getResources().getColor(R.color.a5p));
        paint2.setAntiAlias(true);
        canvas.drawText(string, (float) (this.qqI - (fromDPToPix / 2)), (float) ((this.bCp - dimensionPixelSize) - (width / 3)), paint2);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.a2a);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string2, (float) ((this.qqI + (this.eCL * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.bCp - JS(dimensionPixelSize2)) - (width / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.a28);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string3, (float) ((this.qqI + (this.eCL * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.bCp - JS(dimensionPixelSize2)) - (width / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.a29);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string4, (float) ((this.qqI + (this.eCL * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.bCp - JS(dimensionPixelSize2)) - (width / 3)), paint2);
        AppMethodBeat.o(9900);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARNING: Missing block: B:17:0x005c, code skipped:
            r0 = super.onTouchEvent(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(9901);
        b bVar;
        float y;
        b bVar2;
        switch (motionEvent.getAction()) {
            case 0:
                this.neG = motionEvent.getX();
                this.neH = motionEvent.getY();
                bVar = (b) this.qqH.get(this.qqJ);
                if (this.neG >= ((float) bVar.left) && this.neG <= ((float) bVar.right) && this.neH >= ((float) bVar.top) && this.neH <= ((float) bVar.bottom)) {
                    i = 1;
                }
                if (i != 0) {
                    this.qqQ = true;
                    z = true;
                    break;
                }
                this.qqR = true;
            case 1:
                if (!this.qqQ) {
                    if (this.qqR) {
                        float x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.neG) <= 10.0f && Math.abs(y - this.neH) <= 10.0f) {
                            int i2 = 0;
                            while (i2 < 4) {
                                bVar = (b) this.qqH.get(i2);
                                if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                    i2++;
                                } else {
                                    this.qqJ = i2;
                                    this.qqN = this.qqJ;
                                    this.qqK = bVar.left;
                                    if (this.uJf != null) {
                                        this.uJf.Cl(this.qqJ);
                                    }
                                }
                            }
                        }
                        this.qqR = false;
                        invalidate();
                        z = true;
                        break;
                    }
                }
                int i3 = 0;
                while (i3 < 3) {
                    bVar = (b) this.qqH.get(i3);
                    bVar2 = (b) this.qqH.get(i3 + 1);
                    if (this.qqK > bVar.left + (this.eCL / 2) || this.qqK < bVar.left) {
                        if (this.qqK >= bVar2.left - (this.eCL / 2) && this.qqK <= bVar2.left) {
                            this.qqJ = i3 + 1;
                            this.qqK = bVar2.left;
                            this.qqN = this.qqJ;
                            if (this.uJf != null) {
                                this.uJf.Cl(this.qqJ);
                            }
                            invalidate();
                            this.qqQ = false;
                            z = true;
                            break;
                        }
                        i3++;
                    } else {
                        this.qqJ = i3;
                        this.qqK = bVar.left;
                        this.qqN = this.qqJ;
                        if (this.uJf != null) {
                        }
                        invalidate();
                        this.qqQ = false;
                        z = true;
                    }
                }
                this.qqN = this.qqJ;
                if (this.uJf != null) {
                }
                invalidate();
                this.qqQ = false;
                z = true;
                break;
            case 2:
                if (!this.qqQ) {
                    z = super.onTouchEvent(motionEvent);
                    break;
                }
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.qqK += (int) (y - this.neG);
                this.neG = y;
                this.neH = y2;
                bVar = (b) this.qqH.get(0);
                bVar2 = (b) this.qqH.get(3);
                if (this.qqK <= bVar.left) {
                    this.qqK = bVar.left;
                } else if (this.qqK >= bVar2.left) {
                    this.qqK = bVar2.left;
                } else {
                    while (i < 4) {
                        bVar = (b) this.qqH.get(i);
                        if (this.qqK < bVar.left - 5 || this.qqK > bVar.right + 5) {
                            i++;
                        } else {
                            this.qqJ = i;
                            this.qqN = this.qqJ;
                            if (this.uJf != null) {
                                this.uJf.Cl(this.qqJ);
                            }
                        }
                    }
                }
                invalidate();
                z = true;
                break;
            default:
                z = true;
                break;
        }
        AppMethodBeat.o(9901);
        return z;
    }

    private static int JS(int i) {
        AppMethodBeat.i(9902);
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        int ceil = (int) Math.ceil((double) paint.getFontMetrics().bottom);
        AppMethodBeat.o(9902);
        return ceil;
    }

    public void setOnChangeListener(a aVar) {
        this.uJf = aVar;
    }

    public void setSliderIndex(int i) {
        this.qqN = i;
    }
}
