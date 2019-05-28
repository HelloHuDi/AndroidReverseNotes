package com.tencent.p177mm.plugin.setting.p505ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.setting.p505ui.setting.SetTextSizeUI;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.widget.FontSelectorView */
public class FontSelectorView extends View {
    private static SoftReference<Bitmap> qqG = null;
    private static int qqP = 8;
    private int bCp = 0;
    private int eCL = 0;
    private float neG = 0.0f;
    private float neH = 0.0f;
    private List<C13244b> qqH = new ArrayList(8);
    private int qqI = 0;
    private int qqJ = 0;
    private int qqK = 0;
    private int qqL = 0;
    private int qqM = 0;
    private int qqN = 0;
    private C28982a qqO = null;
    private boolean qqQ = false;
    private boolean qqR = false;
    private int topOffset = 0;

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.FontSelectorView$b */
    static class C13244b {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private C13244b() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        /* synthetic */ C13244b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.FontSelectorView$a */
    public interface C28982a {
        /* renamed from: Cl */
        void mo47084Cl(int i);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(127690);
        AppMethodBeat.m2505o(127690);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(127691);
        AppMethodBeat.m2505o(127691);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(127692);
        super.onLayout(z, i, i2, i3, i4);
        cjs();
        this.qqH.clear();
        setClickable(true);
        this.qqI = C1338a.fromDPToPix(getContext(), 30);
        this.topOffset = C1338a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.bCp = (getHeight() / 2) + this.topOffset;
        qqP = 8;
        this.eCL = (width - (this.qqI * 2)) / (qqP - 1);
        Bitmap bitmap = (Bitmap) qqG.get();
        for (int i5 = 0; i5 < qqP; i5++) {
            C13244b c13244b = new C13244b();
            c13244b.left = (this.qqI + (this.eCL * i5)) - (bitmap.getWidth() / 2);
            c13244b.top = this.bCp - (bitmap.getHeight() / 2);
            c13244b.right = (this.qqI + (this.eCL * i5)) + (bitmap.getWidth() / 2);
            c13244b.bottom = this.bCp + (bitmap.getHeight() / 2);
            this.qqH.add(c13244b);
        }
        this.qqJ = this.qqN;
        if (this.qqM >= 0) {
            this.qqK = ((C13244b) this.qqH.get(this.qqJ)).left;
        } else if (this.qqK <= ((C13244b) this.qqH.get(this.qqJ)).right - (this.eCL / 2)) {
            this.qqK = ((C13244b) this.qqH.get(this.qqJ)).left;
        } else {
            this.qqK = ((C13244b) this.qqH.get(this.qqJ)).right;
        }
        this.qqL = ((C13244b) this.qqH.get(this.qqJ)).top;
        invalidate();
        AppMethodBeat.m2505o(127692);
    }

    public static void cjr() {
        qqP = 8;
    }

    private void cjs() {
        AppMethodBeat.m2504i(127693);
        if (qqG == null || qqG.get() == null) {
            qqG = new SoftReference(BitmapFactory.decodeResource(getResources(), C25738R.drawable.b65));
        }
        AppMethodBeat.m2505o(127693);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(127694);
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
            if (i < qqP) {
                canvas.drawLine((float) (this.qqI + (this.eCL * i)), (float) (this.bCp - fromDPToPix), (float) (this.qqI + (this.eCL * i)), (float) (this.bCp + fromDPToPix), paint);
                width = i + 1;
            } else {
                Bitmap bitmap = (Bitmap) qqG.get();
                canvas.drawBitmap(bitmap, (float) this.qqK, (float) this.qqL, null);
                String str = "A";
                String string = getResources().getString(C25738R.string.e4e);
                getResources().getString(C25738R.string.e4d);
                getResources().getString(C25738R.string.e4g);
                String str2 = "A";
                float aU = m86377aU(SetTextSizeUI.m57243aS(0.875f));
                paint = new Paint();
                paint.setTextSize(aU);
                i = (int) paint.measureText(str);
                int aV = FontSelectorView.m86378aV(aU);
                paint.setColor(getResources().getColor(C25738R.color.f11782h4));
                paint.setAntiAlias(true);
                canvas.drawText(str, (float) (this.qqI - (i / 2)), (float) ((this.bCp - aV) - (bitmap.getHeight() / 3)), paint);
                float aU2 = m86377aU(SetTextSizeUI.m57243aS(1.0f));
                paint.setTextSize(aU2);
                canvas.drawText(string, (float) ((this.qqI + (this.eCL * 1)) - (((int) paint.measureText(string)) / 2)), (float) ((this.bCp - FontSelectorView.m86378aV(aU2)) - (bitmap.getHeight() / 3)), paint);
                aU2 = m86377aU(SetTextSizeUI.m57243aS(2.025f));
                paint.setTextSize(aU2);
                canvas.drawText(str2, (float) ((this.qqI + (this.eCL * (qqP - 1))) - (((int) paint.measureText(str2)) / 2)), (float) ((this.bCp - FontSelectorView.m86378aV(aU2)) - (bitmap.getHeight() / 3)), paint);
                AppMethodBeat.m2505o(127694);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0121  */
    /* JADX WARNING: Missing block: B:17:0x0059, code skipped:
            r0 = super.onTouchEvent(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(127695);
        C13244b c13244b;
        float y;
        int i2;
        C13244b c13244b2;
        switch (motionEvent.getAction()) {
            case 0:
                this.neG = motionEvent.getX();
                this.neH = motionEvent.getY();
                c13244b = (C13244b) this.qqH.get(this.qqJ);
                if (this.neG >= ((float) c13244b.left) && this.neG <= ((float) c13244b.right) && this.neH >= ((float) c13244b.top) && this.neH <= ((float) c13244b.bottom)) {
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
                            i2 = 0;
                            while (i2 < qqP) {
                                c13244b = (C13244b) this.qqH.get(i2);
                                if (x < ((float) (c13244b.left - 5)) || x > ((float) (c13244b.right + 5))) {
                                    i2++;
                                } else {
                                    this.qqJ = i2;
                                    this.qqN = this.qqJ;
                                    this.qqK = c13244b.left;
                                    if (this.qqO != null) {
                                        this.qqO.mo47084Cl(this.qqJ);
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
                while (i3 < qqP - 1) {
                    c13244b = (C13244b) this.qqH.get(i3);
                    c13244b2 = (C13244b) this.qqH.get(i3 + 1);
                    if (this.qqK > c13244b.left + (this.eCL / 2) || this.qqK < c13244b.left) {
                        if (this.qqK >= c13244b2.left - (this.eCL / 2) && this.qqK <= c13244b2.left) {
                            this.qqJ = i3 + 1;
                            this.qqK = c13244b2.left;
                            this.qqN = this.qqJ;
                            if (this.qqO != null) {
                                this.qqO.mo47084Cl(this.qqJ);
                            }
                            invalidate();
                            this.qqQ = false;
                            z = true;
                            break;
                        }
                        i3++;
                    } else {
                        this.qqJ = i3;
                        this.qqK = c13244b.left;
                        this.qqN = this.qqJ;
                        if (this.qqO != null) {
                        }
                        invalidate();
                        this.qqQ = false;
                        z = true;
                    }
                }
                this.qqN = this.qqJ;
                if (this.qqO != null) {
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
                this.qqM = (int) (y - this.neG);
                this.qqK = (int) (y - ((float) this.qqI));
                this.neG = y;
                this.neH = y2;
                c13244b = (C13244b) this.qqH.get(0);
                c13244b2 = (C13244b) this.qqH.get(qqP - 1);
                if (this.qqK <= c13244b.left) {
                    this.qqK = c13244b.left;
                } else if (this.qqK >= c13244b2.left) {
                    this.qqK = c13244b2.left;
                } else {
                    i2 = 0;
                    while (i2 < qqP) {
                        c13244b = (C13244b) this.qqH.get(i2);
                        if (this.qqK < c13244b.left - 5 || this.qqK > c13244b.right + 5) {
                            i2++;
                        } else {
                            this.qqJ = i2;
                            this.qqN = this.qqJ;
                            if (this.qqO != null) {
                                this.qqO.mo47084Cl(this.qqJ);
                            }
                        }
                    }
                }
                invalidate();
                z = true;
                break;
                break;
            default:
                z = true;
                break;
        }
        AppMethodBeat.m2505o(127695);
        return z;
    }

    /* renamed from: aU */
    private float m86377aU(float f) {
        AppMethodBeat.m2504i(127696);
        float applyDimension = TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        AppMethodBeat.m2505o(127696);
        return applyDimension;
    }

    /* renamed from: aV */
    private static int m86378aV(float f) {
        AppMethodBeat.m2504i(127697);
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        int ceil = (int) Math.ceil((double) paint.getFontMetrics().bottom);
        AppMethodBeat.m2505o(127697);
        return ceil;
    }

    public void setOnChangeListener(C28982a c28982a) {
        this.qqO = c28982a;
    }

    public void setSliderIndex(int i) {
        this.qqN = i;
    }
}
