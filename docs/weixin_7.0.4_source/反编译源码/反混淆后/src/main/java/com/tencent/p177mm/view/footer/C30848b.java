package com.tencent.p177mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.view.footer.b */
public final class C30848b extends C16070a {
    private Bitmap AcI;
    private Bitmap AcJ;
    private Bitmap AcK;
    private Bitmap AcL;
    private Bitmap AcM;
    private Bitmap AcN;
    private Bitmap AcO;
    private Bitmap AcP;
    private Bitmap AcQ;
    private Bitmap AcR;
    private Bitmap AcS;
    private Bitmap AcT;
    private Bitmap AcU;
    private Bitmap AcV;
    private Rect[] AcW = new Rect[2];
    private Rect[] AcX = new Rect[4];
    private boolean AcY;
    private boolean AcZ;
    private boolean Ada;
    private boolean Adb;
    private boolean Adc = true;
    private int Add = -1;
    private Paint zAp;

    public C30848b(Context context, C18117b c18117b) {
        super(context, c18117b);
        AppMethodBeat.m2504i(116427);
        AppMethodBeat.m2505o(116427);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dMO() {
        AppMethodBeat.m2504i(116428);
        super.dMO();
        this.zAp = new Paint(1);
        this.zAp.setTextSize(getResources().getDimension(C25738R.dimen.f10329y8));
        this.AcM = BitmapFactory.decodeResource(getResources(), C25738R.drawable.bc9);
        this.AcN = BitmapFactory.decodeResource(getResources(), C25738R.drawable.bc8);
        this.AcO = BitmapFactory.decodeResource(getResources(), C25738R.drawable.bca);
        this.AcP = BitmapFactory.decodeResource(getResources(), C25738R.drawable.bc_);
        this.AcJ = C5056d.m7668v(getResources().getDrawable(C1318a.mosaic_unselected));
        this.AcI = C5056d.m7668v(getResources().getDrawable(C1318a.mosaic_selected));
        this.AcK = C5056d.m7668v(getResources().getDrawable(C1318a.crop_unselected));
        this.AcL = C5056d.m7668v(getResources().getDrawable(C1318a.crop_selected));
        this.AcQ = C5056d.m7668v(getResources().getDrawable(C1318a.rotation_normal));
        this.AcR = C5056d.m7668v(getResources().getDrawable(C1318a.rotation_press));
        this.AcT = C5056d.m7668v(getResources().getDrawable(C1318a.sure_crop_press));
        this.AcS = C5056d.m7668v(getResources().getDrawable(C1318a.sure_crop_normal));
        this.AcU = C5056d.m7668v(getResources().getDrawable(C1318a.cancel_crop_press));
        this.AcV = C5056d.m7668v(getResources().getDrawable(C1318a.cancel_crop_normal));
        AppMethodBeat.m2505o(116428);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(116429);
        if (getCurFeatureType() != C32247e.CROP_PHOTO) {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(116429);
            return;
        }
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(getDetailHeight(), ErrorDialogData.SUPPRESSED));
        dMQ();
        AppMethodBeat.m2505o(116429);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: n */
    public final void mo28503n(Canvas canvas) {
        AppMethodBeat.m2504i(116430);
        if (getCurFeatureType() != C32247e.CROP_PHOTO) {
            super.mo28503n(canvas);
            AppMethodBeat.m2505o(116430);
            return;
        }
        mo28504o(canvas);
        AppMethodBeat.m2505o(116430);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final Bitmap mo28488a(C32247e c32247e, boolean z) {
        if (c32247e == C32247e.CROP_PHOTO) {
            return z ? this.AcL : this.AcK;
        } else {
            if (c32247e == C32247e.MOSAIC) {
                return z ? this.AcI : this.AcJ;
            } else {
                return null;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int getDetailHeight() {
        AppMethodBeat.m2504i(116431);
        int detailHeight = super.getDetailHeight();
        if (detailHeight == 0) {
            if (getCurFeatureType() == C32247e.MOSAIC) {
                detailHeight = (int) getResources().getDimension(C25738R.dimen.a25);
                AppMethodBeat.m2505o(116431);
                return detailHeight;
            } else if (getCurFeatureType() == C32247e.CROP_PHOTO) {
                detailHeight = (int) (getResources().getDimension(C25738R.dimen.a26) + getResources().getDimension(C25738R.dimen.f10330y9));
                AppMethodBeat.m2505o(116431);
                return detailHeight;
            }
        }
        AppMethodBeat.m2505o(116431);
        return detailHeight;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: QG */
    public final boolean mo28487QG(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(116432);
        boolean QG = super.mo28487QG(i);
        switch (mo28486QF(i)) {
            case CROP_PHOTO:
            case MOSAIC:
                break;
            default:
                z = QG;
                break;
        }
        AppMethodBeat.m2505o(116432);
        return z;
    }

    /* Access modifiers changed, original: protected|final */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hJ */
    public final void mo28501hJ(int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(116433);
        super.mo28501hJ(i, i2);
        switch (mo28486QF(this.jpc)) {
            case CROP_PHOTO:
                while (i3 < this.AcX.length) {
                    Rect rect = this.AcX[i3];
                    if (rect == null || !rect.contains(i, i2)) {
                        i3++;
                    } else if (i3 == 0) {
                        this.AcZ = true;
                        AppMethodBeat.m2505o(116433);
                        return;
                    } else if (i3 == 1) {
                        this.AcY = true;
                        AppMethodBeat.m2505o(116433);
                        return;
                    } else if (i3 == 2) {
                        this.Ada = true;
                        AppMethodBeat.m2505o(116433);
                        return;
                    } else if (i3 == 3) {
                        this.Adb = true;
                        AppMethodBeat.m2505o(116433);
                        return;
                    }
                }
                break;
            case MOSAIC:
                int i4 = 0;
                while (i4 < this.AcW.length) {
                    Rect rect2 = this.AcW[i4];
                    if (rect2 == null) {
                        C4990ab.m7413e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", Integer.valueOf(i4));
                    }
                    if (rect2 == null || !rect2.contains(i, i2)) {
                        i4++;
                    } else {
                        this.Add = i4;
                        AppMethodBeat.m2505o(116433);
                        return;
                    }
                }
                AppMethodBeat.m2505o(116433);
                return;
        }
        AppMethodBeat.m2505o(116433);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:3:0x001f, code skipped:
            r0 = r0 + 1;
     */
    /* JADX WARNING: Missing block: B:5:0x0023, code skipped:
            if (r5.AcW == null) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:7:0x0028, code skipped:
            if (r0 >= r5.AcW.length) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:8:0x002a, code skipped:
            r1 = r5.AcW[r0];
     */
    /* JADX WARNING: Missing block: B:9:0x002e, code skipped:
            if (r1 == null) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (r1.contains(r6, r7) == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:13:0x0038, code skipped:
            if (r0 != r5.Add) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:14:0x003a, code skipped:
            getPresenter().getSelectedFeatureListener().mo4526a(com.tencent.p177mm.api.C32247e.MOSAIC, r0);
            r5.Acw = r5.jpc;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(116434);
     */
    /* JADX WARNING: Missing block: B:15:0x004f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(116434);
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hK */
    public final void mo28502hK(int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(116434);
        super.mo28502hK(i, i2);
        switch (mo28486QF(this.jpc)) {
            case CROP_PHOTO:
                int i4 = 0;
                while (this.AcX != null && i4 < this.AcX.length) {
                    Rect rect = this.AcX[i4];
                    if (rect == null || !rect.contains(i, i2)) {
                        i4++;
                    } else {
                        if ((i4 == 0 && this.AcZ) || ((i4 == 1 && this.AcY) || ((i4 == 2 && this.Ada) || (i4 == 3 && this.Adb)))) {
                            getPresenter().getSelectedFeatureListener().mo4526a(C32247e.CROP_PHOTO, i4);
                            this.Acw = this.jpc;
                        }
                        this.AcZ = false;
                        this.AcY = false;
                        this.Ada = false;
                        this.Adb = false;
                        AppMethodBeat.m2505o(116434);
                        return;
                    }
                }
                break;
            case MOSAIC:
                break;
        }
        AppMethodBeat.m2505o(116434);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dMQ() {
        AppMethodBeat.m2504i(116435);
        super.dMQ();
        if (getCurFeatureType() == C32247e.MOSAIC) {
            dMT();
            AppMethodBeat.m2505o(116435);
            return;
        }
        if (getCurFeatureType() == C32247e.CROP_PHOTO) {
            dMU();
        }
        AppMethodBeat.m2505o(116435);
    }

    private void dMT() {
        AppMethodBeat.m2504i(116436);
        if (this.AcW == null) {
            this.AcW = new Rect[2];
        }
        if (this.AcA == null) {
            this.AcA = new Rect();
        }
        float measuredWidth = ((float) ((((getMeasuredWidth() - getPaddingLeftAndRight()) - this.Acu.getWidth()) - this.AcP.getWidth()) - this.AcM.getWidth())) / 3.0f;
        int width = (int) (((float) (this.AcO.getWidth() / 2)) + measuredWidth);
        int detailHeight = ((getDetailHeight() - this.AcO.getWidth()) / 2) + (this.AcO.getWidth() / 2);
        int width2 = this.AcO.getWidth() * 2;
        this.AcW[0] = new Rect(width - width2, detailHeight - width2, width + width2, detailHeight + width2);
        int width3 = (int) ((measuredWidth + ((float) this.AcO.getWidth())) + ((float) width));
        this.AcW[1] = new Rect(width3 - width2, detailHeight - width2, width3 + width2, detailHeight + width2);
        width3 = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.Acu.getWidth() / 2);
        this.AcA.set(width3 - this.Acu.getWidth(), 0, width3 + this.Acu.getWidth(), getDetailHeight());
        AppMethodBeat.m2505o(116436);
    }

    private void dMU() {
        AppMethodBeat.m2504i(116437);
        if (this.AcX == null) {
            this.AcX = new Rect[4];
        }
        int dimension = (int) getResources().getDimension(C25738R.dimen.f10330y9);
        float height = (float) ((dimension / 2) - (this.AcR.getHeight() / 2));
        float dimension2 = ((float) dimension) + ((getResources().getDimension(C25738R.dimen.a26) / 2.0f) - ((float) (this.AcV.getHeight() / 2)));
        int height2 = (int) (height + ((float) (this.AcV.getHeight() / 2)));
        int paddingLeftAndRight = (int) (((1.0f * ((float) getPaddingLeftAndRight())) / 2.0f) + ((float) (this.AcV.getHeight() / 2)));
        int height3 = this.AcV.getHeight();
        this.AcX[0] = new Rect(paddingLeftAndRight - height3, height2 - height3, paddingLeftAndRight + height3, height2 + height3);
        dimension = (int) (dimension2 + ((float) (this.AcV.getHeight() / 2)));
        this.AcX[1] = new Rect(paddingLeftAndRight - height3, dimension - height3, paddingLeftAndRight + height3, dimension + height3);
        height2 = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.AcV.getHeight() / 2);
        this.AcX[2] = new Rect(height2 - height3, dimension - height3, height2 + height3, dimension + height3);
        height2 = getMeasuredWidth() / 2;
        this.AcX[3] = new Rect(height2 - height3, dimension - height3, height2 + height3, dimension + height3);
        AppMethodBeat.m2505o(116437);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: o */
    public final void mo28504o(Canvas canvas) {
        AppMethodBeat.m2504i(116438);
        super.mo28504o(canvas);
        float measuredWidth;
        float detailHeight;
        if (getCurFeatureType() == C32247e.MOSAIC) {
            Paint paint = new Paint();
            if (mo28485CL()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(160);
            }
            Bitmap bitmap = (this.AcB && mo28485CL()) ? this.Acv : this.Acu;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - this.Acu.getWidth()), (float) ((getDetailHeight() - this.Acu.getHeight()) / 2), paint);
            measuredWidth = ((float) ((((getMeasuredWidth() - getPaddingLeftAndRight()) - this.Acu.getWidth()) - this.AcP.getWidth()) - this.AcM.getWidth())) / 3.0f;
            detailHeight = (1.0f * ((float) (getDetailHeight() - this.AcP.getHeight()))) / 2.0f;
            if (this.Adc) {
                this.Add = 0;
                this.Adc = false;
            }
            if (this.Add == 0) {
                canvas.drawBitmap(this.AcN, measuredWidth, detailHeight, null);
                canvas.drawBitmap(this.AcO, (measuredWidth + measuredWidth) + ((float) this.AcP.getWidth()), detailHeight, null);
                AppMethodBeat.m2505o(116438);
                return;
            } else if (this.Add == 1) {
                canvas.drawBitmap(this.AcM, measuredWidth, detailHeight, null);
                canvas.drawBitmap(this.AcP, (measuredWidth + measuredWidth) + ((float) this.AcP.getWidth()), detailHeight, null);
                AppMethodBeat.m2505o(116438);
                return;
            } else {
                canvas.drawBitmap(this.AcM, measuredWidth, detailHeight, null);
                canvas.drawBitmap(this.AcO, (measuredWidth + measuredWidth) + ((float) this.AcP.getWidth()), detailHeight, null);
                AppMethodBeat.m2505o(116438);
                return;
            }
        }
        if (getCurFeatureType() == C32247e.CROP_PHOTO) {
            int dimension = (int) getResources().getDimension(C25738R.dimen.f10330y9);
            canvas.drawLine(0.0f, (float) dimension, (float) getMeasuredWidth(), (float) dimension, this.AcC);
            measuredWidth = ((getResources().getDimension(C25738R.dimen.a26) / 2.0f) - ((float) (this.AcV.getHeight() / 2))) + ((float) dimension);
            detailHeight = (1.0f * ((float) getPaddingLeftAndRight())) / 2.0f;
            float height = (float) ((dimension / 2) - (this.AcR.getHeight() / 2));
            if (this.AcZ) {
                canvas.drawBitmap(this.AcR, detailHeight, height, null);
            } else {
                canvas.drawBitmap(this.AcQ, detailHeight, height, null);
            }
            if (this.Ada) {
                canvas.drawBitmap(this.AcT, (((float) getMeasuredWidth()) - detailHeight) - ((float) this.AcV.getWidth()), measuredWidth, null);
            } else {
                canvas.drawBitmap(this.AcS, (((float) getMeasuredWidth()) - detailHeight) - ((float) this.AcV.getWidth()), measuredWidth, null);
            }
            if (this.AcY) {
                canvas.drawBitmap(this.AcU, detailHeight, measuredWidth, null);
            } else {
                canvas.drawBitmap(this.AcV, detailHeight, measuredWidth, null);
            }
            measuredWidth = getResources().getDimension(C25738R.dimen.f10329y8) * 2.0f;
            detailHeight = (((getResources().getDimension(C25738R.dimen.f10329y8) - 8.0f) / 2.0f) + (getResources().getDimension(C25738R.dimen.a26) / 2.0f)) + ((float) dimension);
            height = (float) (getMeasuredWidth() / 2);
            if (this.Adb) {
                this.zAp.setColor(-1);
                this.zAp.setAlpha(160);
                canvas.drawText(getResources().getString(C25738R.string.b3o), height - (measuredWidth / 2.0f), detailHeight, this.zAp);
                AppMethodBeat.m2505o(116438);
                return;
            } else if (mo28485CL()) {
                this.zAp.setColor(-1);
                this.zAp.setAlpha(255);
                canvas.drawText(getResources().getString(C25738R.string.b3o), height - (measuredWidth / 2.0f), detailHeight, this.zAp);
                AppMethodBeat.m2505o(116438);
                return;
            } else {
                this.zAp.setColor(-1);
                this.zAp.setAlpha(100);
                canvas.drawText(getResources().getString(C25738R.string.b3o), height - (measuredWidth / 2.0f), detailHeight, this.zAp);
            }
        }
        AppMethodBeat.m2505o(116438);
    }
}
