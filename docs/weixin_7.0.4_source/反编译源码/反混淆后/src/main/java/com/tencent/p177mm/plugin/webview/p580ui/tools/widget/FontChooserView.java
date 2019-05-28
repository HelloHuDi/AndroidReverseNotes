package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView */
public class FontChooserView extends View {
    private static SoftReference<Bitmap> qqG = null;
    private int bCp = 0;
    private int eCL = 0;
    private float neG = 0.0f;
    private float neH = 0.0f;
    private List<C4652b> qqH = new ArrayList(4);
    private int qqI = 0;
    private int qqJ = 0;
    private int qqK = 0;
    private int qqL = 0;
    private int qqN = 0;
    private boolean qqQ = false;
    private boolean qqR = false;
    private int topOffset = 0;
    private C4653a uJf = null;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView$b */
    static class C4652b {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private C4652b() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        /* synthetic */ C4652b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView$a */
    public interface C4653a {
        /* renamed from: Cl */
        void mo9748Cl(int i);
    }

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(9896);
        AppMethodBeat.m2505o(9896);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(9897);
        AppMethodBeat.m2505o(9897);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int intrinsicWidth;
        int height;
        AppMethodBeat.m2504i(9898);
        super.onLayout(z, i, i2, i3, i4);
        cjs();
        this.qqH.clear();
        setClickable(true);
        this.qqI = C1338a.fromDPToPix(getContext(), 50);
        this.topOffset = C1338a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.bCp = (getHeight() / 2) + this.topOffset;
        this.eCL = (width - (this.qqI * 2)) / 3;
        Bitmap bitmap = (Bitmap) qqG.get();
        if (bitmap == null || bitmap.isRecycled()) {
            Drawable drawable = getResources().getDrawable(C25738R.drawable.b65);
            width = drawable.getIntrinsicHeight();
            intrinsicWidth = drawable.getIntrinsicWidth();
        } else {
            height = bitmap.getHeight();
            intrinsicWidth = bitmap.getWidth();
            width = height;
        }
        for (height = 0; height < 4; height++) {
            C4652b c4652b = new C4652b();
            c4652b.left = (this.qqI + (this.eCL * height)) - (intrinsicWidth / 2);
            c4652b.top = this.bCp - (width / 2);
            c4652b.right = (this.qqI + (this.eCL * height)) + (intrinsicWidth / 2);
            c4652b.bottom = this.bCp + (width / 2);
            this.qqH.add(c4652b);
        }
        this.qqJ = this.qqN;
        this.qqK = ((C4652b) this.qqH.get(this.qqJ)).left;
        this.qqL = ((C4652b) this.qqH.get(this.qqJ)).top;
        invalidate();
        AppMethodBeat.m2505o(9898);
    }

    private void cjs() {
        AppMethodBeat.m2504i(9899);
        if (qqG == null || qqG.get() == null) {
            qqG = new SoftReference(BitmapFactory.decodeResource(getResources(), C25738R.drawable.b65));
        }
        AppMethodBeat.m2505o(9899);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(9900);
        super.onDraw(canvas);
        cjs();
        Paint paint = new Paint();
        paint.setARGB(255, 152, 152, 152);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = C1338a.fromDPToPix(getContext(), 5);
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
            width = getResources().getDrawable(C25738R.drawable.b65).getIntrinsicHeight();
        } else {
            canvas.drawBitmap(bitmap, (float) this.qqK, (float) this.qqL, null);
            width = bitmap.getHeight();
        }
        String string = getResources().getString(C25738R.string.fyd);
        String string2 = getResources().getString(C25738R.string.fye);
        String string3 = getResources().getString(C25738R.string.fyb);
        String string4 = getResources().getString(C25738R.string.fyc);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a2_);
        Paint paint2 = new Paint();
        paint2.setTextSize((float) dimensionPixelSize);
        fromDPToPix = (int) paint2.measureText(string);
        dimensionPixelSize = FontChooserView.m7002JS(dimensionPixelSize);
        paint2.setColor(getResources().getColor(C25738R.color.a5p));
        paint2.setAntiAlias(true);
        canvas.drawText(string, (float) (this.qqI - (fromDPToPix / 2)), (float) ((this.bCp - dimensionPixelSize) - (width / 3)), paint2);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.a2a);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string2, (float) ((this.qqI + (this.eCL * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.bCp - FontChooserView.m7002JS(dimensionPixelSize2)) - (width / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.a28);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string3, (float) ((this.qqI + (this.eCL * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.bCp - FontChooserView.m7002JS(dimensionPixelSize2)) - (width / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.a29);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string4, (float) ((this.qqI + (this.eCL * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.bCp - FontChooserView.m7002JS(dimensionPixelSize2)) - (width / 3)), paint2);
        AppMethodBeat.m2505o(9900);
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
        AppMethodBeat.m2504i(9901);
        C4652b c4652b;
        float y;
        C4652b c4652b2;
        switch (motionEvent.getAction()) {
            case 0:
                this.neG = motionEvent.getX();
                this.neH = motionEvent.getY();
                c4652b = (C4652b) this.qqH.get(this.qqJ);
                if (this.neG >= ((float) c4652b.left) && this.neG <= ((float) c4652b.right) && this.neH >= ((float) c4652b.top) && this.neH <= ((float) c4652b.bottom)) {
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
                                c4652b = (C4652b) this.qqH.get(i2);
                                if (x < ((float) (c4652b.left - 5)) || x > ((float) (c4652b.right + 5))) {
                                    i2++;
                                } else {
                                    this.qqJ = i2;
                                    this.qqN = this.qqJ;
                                    this.qqK = c4652b.left;
                                    if (this.uJf != null) {
                                        this.uJf.mo9748Cl(this.qqJ);
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
                    c4652b = (C4652b) this.qqH.get(i3);
                    c4652b2 = (C4652b) this.qqH.get(i3 + 1);
                    if (this.qqK > c4652b.left + (this.eCL / 2) || this.qqK < c4652b.left) {
                        if (this.qqK >= c4652b2.left - (this.eCL / 2) && this.qqK <= c4652b2.left) {
                            this.qqJ = i3 + 1;
                            this.qqK = c4652b2.left;
                            this.qqN = this.qqJ;
                            if (this.uJf != null) {
                                this.uJf.mo9748Cl(this.qqJ);
                            }
                            invalidate();
                            this.qqQ = false;
                            z = true;
                            break;
                        }
                        i3++;
                    } else {
                        this.qqJ = i3;
                        this.qqK = c4652b.left;
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
                c4652b = (C4652b) this.qqH.get(0);
                c4652b2 = (C4652b) this.qqH.get(3);
                if (this.qqK <= c4652b.left) {
                    this.qqK = c4652b.left;
                } else if (this.qqK >= c4652b2.left) {
                    this.qqK = c4652b2.left;
                } else {
                    while (i < 4) {
                        c4652b = (C4652b) this.qqH.get(i);
                        if (this.qqK < c4652b.left - 5 || this.qqK > c4652b.right + 5) {
                            i++;
                        } else {
                            this.qqJ = i;
                            this.qqN = this.qqJ;
                            if (this.uJf != null) {
                                this.uJf.mo9748Cl(this.qqJ);
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
        AppMethodBeat.m2505o(9901);
        return z;
    }

    /* renamed from: JS */
    private static int m7002JS(int i) {
        AppMethodBeat.m2504i(9902);
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        int ceil = (int) Math.ceil((double) paint.getFontMetrics().bottom);
        AppMethodBeat.m2505o(9902);
        return ceil;
    }

    public void setOnChangeListener(C4653a c4653a) {
        this.uJf = c4653a;
    }

    public void setSliderIndex(int i) {
        this.qqN = i;
    }
}
