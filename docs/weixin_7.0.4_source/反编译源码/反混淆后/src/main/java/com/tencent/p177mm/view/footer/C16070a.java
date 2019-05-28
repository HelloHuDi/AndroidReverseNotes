package com.tencent.p177mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p1639ch.C45281a;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.p226e.C9268b;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.view.footer.a */
public abstract class C16070a extends View {
    public static final int[] AcD = new int[]{-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    protected Paint Aat;
    protected Rect AcA;
    protected boolean AcB;
    protected Paint AcC;
    protected int AcE = -1;
    protected int AcF = -1;
    private boolean AcG = true;
    private final float Acn = getResources().getDimension(C25738R.dimen.a23);
    private Bitmap Aco;
    private Bitmap Acp;
    private Bitmap Acq;
    private Bitmap Acr;
    private Bitmap Acs;
    private Bitmap Act;
    protected Bitmap Acu;
    protected Bitmap Acv;
    protected int Acw = -1;
    protected int Acx = -1;
    private Rect[] Acy;
    private Rect[] Acz;
    private C18117b cjc;
    private Paint eHe;
    protected int jpc = -1;

    /* renamed from: com.tencent.mm.view.footer.a$2 */
    class C57422 implements AnimationListener {
        C57422() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116424);
            C16070a.this.setVisibility(8);
            AppMethodBeat.m2505o(116424);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.footer.a$1 */
    class C160691 implements AnimationListener {
        C160691() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116423);
            C16070a.this.setVisibility(0);
            AppMethodBeat.m2505o(116423);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: a */
    public abstract Bitmap mo28488a(C32247e c32247e, boolean z);

    public C16070a(Context context, C18117b c18117b) {
        super(context);
        setId(2131820578);
        this.cjc = c18117b;
        dMO();
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        mo28503n(canvas);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                while (i < getFeatureCount()) {
                    if (this.Acy[i].contains(x, y)) {
                        this.AcE = i;
                        postInvalidate();
                        break;
                    }
                    if (dMP()) {
                        if (this.AcA == null || !this.AcA.contains(x, y)) {
                            mo28501hJ(x, y);
                        } else {
                            this.AcB = true;
                            postInvalidate();
                        }
                    }
                    i++;
                }
                break;
            case 1:
            case 3:
                int i2 = 0;
                while (i2 < getFeatureCount()) {
                    if (this.Acy[i2].contains(x, y) && this.AcE == i2) {
                        if (mo28487QG(i2)) {
                            if (this.AcE != this.jpc) {
                                this.jpc = this.AcE;
                            } else {
                                this.jpc = -1;
                            }
                        }
                        this.Acx = this.Acw;
                        if (mo28487QG(i2)) {
                            this.Acw = this.jpc;
                            getPresenter().getSelectedFeatureListener().mo4525a(mo28486QF(this.jpc));
                        } else {
                            this.Acw = i2;
                            getPresenter().getSelectedFeatureListener().mo4525a(mo28486QF(i2));
                        }
                        if (dMP()) {
                            if (this.AcA != null && this.AcA.contains(x, y) && this.AcB) {
                                getPresenter().getSelectedFeatureListener().mo4526a(mo28486QF(this.jpc), -1);
                            } else {
                                mo28502hK(x, y);
                            }
                        }
                        this.AcB = false;
                        this.AcE = -1;
                        requestLayout();
                        postInvalidate();
                        break;
                    }
                    i2++;
                }
                if (dMP()) {
                }
                this.AcB = false;
                this.AcE = -1;
                requestLayout();
                postInvalidate();
                break;
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int dimension = (int) getResources().getDimension(C25738R.dimen.a26);
        if (dMP()) {
            dimension += getDetailHeight();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(dimension, ErrorDialogData.SUPPRESSED));
        dMQ();
    }

    /* Access modifiers changed, original: protected */
    public C18117b getPresenter() {
        return this.cjc;
    }

    /* Access modifiers changed, original: protected */
    public void dMO() {
        this.Aat = new Paint(1);
        this.Aat.setColor(-16711936);
        this.AcC = new Paint(1);
        this.AcC.setColor(getResources().getColor(C25738R.color.f11946ml));
        this.AcC.setStrokeWidth(0.6f);
        this.eHe = new Paint(1);
        this.eHe.setStyle(Style.FILL);
        this.eHe.setStrokeCap(Cap.ROUND);
        this.Acv = C5056d.m7668v(getResources().getDrawable(C1318a.undo_press));
        this.Acu = C5056d.m7668v(getResources().getDrawable(C1318a.undo_normal));
        this.Aco = C5056d.m7668v(getResources().getDrawable(C1318a.doodle_unselected));
        this.Acp = C5056d.m7668v(getResources().getDrawable(C1318a.doodle_selected));
        this.Acq = C5056d.m7668v(getResources().getDrawable(C1318a.text_unselected));
        this.Acr = C5056d.m7668v(getResources().getDrawable(C1318a.text_selected));
        this.Acs = BitmapFactory.decodeResource(getResources(), C25738R.drawable.emoji_unselected);
        this.Act = BitmapFactory.decodeResource(getResources(), C25738R.drawable.emoji_selected);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: hJ */
    public void mo28501hJ(int i, int i2) {
        switch (mo28486QF(this.jpc)) {
            case DOODLE:
                if (this.Acz != null) {
                    for (int i3 = 0; i3 < this.Acz.length; i3++) {
                        if (this.Acz[i3].contains(i, i2)) {
                            this.AcF = i3;
                            this.AcG = false;
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: hK */
    public void mo28502hK(int i, int i2) {
        switch (mo28486QF(this.jpc)) {
            case DOODLE:
                int i3 = 0;
                while (this.Acz != null && i3 < this.Acz.length) {
                    if (this.Acz[i3].contains(i, i2) && i3 == this.AcF) {
                        getPresenter().getSelectedFeatureListener().mo4526a(C32247e.DOODLE, i3);
                        return;
                    }
                    i3++;
                }
                return;
            default:
                return;
        }
    }

    private boolean dMP() {
        return getDetailHeight() > 0;
    }

    /* renamed from: b */
    private Bitmap m24381b(C32247e c32247e, boolean z) {
        Bitmap bitmap = null;
        switch (c32247e) {
            case DOODLE:
                if (!z) {
                    bitmap = this.Aco;
                    break;
                }
                bitmap = this.Acp;
                break;
            case TEXT:
                if (!z) {
                    bitmap = this.Acq;
                    break;
                }
                bitmap = this.Acr;
                break;
            case EMOJI:
                if (!z) {
                    bitmap = this.Acs;
                    break;
                }
                bitmap = this.Act;
                break;
        }
        if (bitmap == null) {
            return mo28488a(c32247e, z);
        }
        return bitmap;
    }

    /* Access modifiers changed, original: protected */
    public int getFeatureCount() {
        return getPresenter().getFeatures().length;
    }

    /* Access modifiers changed, original: protected */
    public float getIconWidth() {
        Bitmap b = m24381b(C32247e.DOODLE, false);
        return b == null ? 0.0f : (float) b.getWidth();
    }

    public static int getColor(int i) {
        if (i < 0 || i >= AcD.length) {
            return -65536;
        }
        return AcD[i];
    }

    public int getPaddingLeftAndRight() {
        return (int) (2.0f * this.Acn);
    }

    /* Access modifiers changed, original: protected */
    public float getWidthSpacing() {
        return ((((float) getMeasuredWidth()) - (((float) getFeatureCount()) * getIconWidth())) - ((float) getPaddingLeftAndRight())) / ((float) (getFeatureCount() - 1));
    }

    /* Access modifiers changed, original: protected */
    public float getHeightSpacing() {
        return (((float) (getMeasuredHeight() - getDetailHeight())) - getIconWidth()) / 2.0f;
    }

    /* Access modifiers changed, original: protected */
    public int getDetailHeight() {
        if (mo28486QF(this.jpc) == C32247e.DOODLE) {
            return (int) getResources().getDimension(C25738R.dimen.a25);
        }
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: QF */
    public final C32247e mo28486QF(int i) {
        if (i < 0 || i >= getFeatureCount()) {
            return C32247e.DEFAULT;
        }
        return getPresenter().getFeatures()[i];
    }

    /* Access modifiers changed, original: protected */
    public void dMQ() {
        if (this.Acy == null) {
            this.Acy = new Rect[getFeatureCount()];
        }
        int iconWidth = (int) (this.Acn + (getIconWidth() / 2.0f));
        int iconWidth2 = (int) getIconWidth();
        for (int i = 0; i < getFeatureCount(); i++) {
            this.Acy[i] = new Rect(iconWidth - iconWidth2, getDetailHeight(), iconWidth + iconWidth2, getDetailHeight() + getMeasuredHeight());
            iconWidth = (int) (((float) iconWidth) + (getWidthSpacing() + getIconWidth()));
        }
        if (mo28486QF(this.jpc) == C32247e.DOODLE) {
            dMR();
        }
    }

    private void dMR() {
        int i;
        if (this.Acz == null) {
            this.Acz = new Rect[AcD.length];
        }
        if (this.AcA == null) {
            this.AcA = new Rect();
        }
        float dimension = getResources().getDimension(C25738R.dimen.f10371zf);
        float measuredWidth = (((float) ((getMeasuredWidth() - getPaddingLeftAndRight()) - this.Acu.getWidth())) - ((2.0f * dimension) * ((float) AcD.length))) / ((float) AcD.length);
        int i2 = (int) (dimension * 2.0f);
        int paddingLeftAndRight = (int) ((((float) (getPaddingLeftAndRight() / 2)) + dimension) + 5.0f);
        int detailHeight = (int) (((((float) getDetailHeight()) - (dimension * 2.0f)) / 2.0f) + dimension);
        for (i = 0; i < AcD.length; i++) {
            this.Acz[i] = new Rect(paddingLeftAndRight - i2, detailHeight - i2, paddingLeftAndRight + i2, detailHeight + i2);
            paddingLeftAndRight = (int) (((float) paddingLeftAndRight) + ((2.0f * dimension) + measuredWidth));
        }
        i = (getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - (this.Acu.getWidth() / 2);
        this.AcA.set(i - this.Acu.getWidth(), 0, i + this.Acu.getWidth(), getDetailHeight());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: n */
    public void mo28503n(Canvas canvas) {
        if (dMP()) {
            canvas.drawLine(0.0f, (float) getDetailHeight(), (float) getMeasuredWidth(), (float) getDetailHeight(), this.AcC);
            mo28504o(canvas);
        }
        float f = this.Acn;
        float heightSpacing = getHeightSpacing() + ((float) getDetailHeight());
        int i = 0;
        while (i < getFeatureCount()) {
            boolean z;
            C32247e c32247e = getPresenter().getFeatures()[i];
            if (this.AcE == i || i == this.jpc) {
                z = true;
            } else {
                z = false;
            }
            Bitmap b = m24381b(c32247e, z);
            if (b != null) {
                canvas.drawBitmap(b, f, heightSpacing, null);
            }
            f += getWidthSpacing() + getIconWidth();
            i++;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: o */
    public void mo28504o(Canvas canvas) {
        if (mo28486QF(this.jpc) == C32247e.DOODLE) {
            float dimension = getResources().getDimension(C25738R.dimen.f10371zf);
            float measuredWidth = (((float) ((getMeasuredWidth() - getPaddingLeftAndRight()) - this.Acu.getWidth())) - ((2.0f * dimension) * ((float) AcD.length))) / ((float) AcD.length);
            float bu = ((float) C45281a.m83492bu(1.5f)) + (((float) (getPaddingLeftAndRight() / 2)) + dimension);
            float detailHeight = ((((float) getDetailHeight()) - (dimension * 2.0f)) / 2.0f) + dimension;
            int i = 0;
            while (i < AcD.length) {
                float f = 0.0f;
                if (this.AcF == i) {
                    f = (float) C45281a.m83492bu(2.0f);
                    this.AcG = false;
                } else if (this.AcG && i == 2) {
                    f = (float) C45281a.m83492bu(2.0f);
                }
                this.eHe.setColor(-1);
                canvas.drawCircle(bu, detailHeight, (((float) C45281a.m83492bu(1.5f)) + dimension) + f, this.eHe);
                this.eHe.setColor(AcD[i]);
                canvas.drawCircle(bu, detailHeight, f + dimension, this.eHe);
                bu += (2.0f * dimension) + measuredWidth;
                i++;
            }
            Paint paint = new Paint();
            if (mo28485CL()) {
                paint.setAlpha(255);
            } else {
                paint.setAlpha(160);
            }
            Bitmap bitmap = (this.AcB && mo28485CL()) ? this.Acv : this.Acu;
            canvas.drawBitmap(bitmap, (float) ((getMeasuredWidth() - (getPaddingLeftAndRight() / 2)) - this.Acu.getWidth()), (float) ((getDetailHeight() - this.Acu.getHeight()) / 2), paint);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: CL */
    public final boolean mo28485CL() {
        C9268b b = getPresenter().mo33566b(getCurFeatureType());
        return b == null ? false : b.mo4949CL();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: QG */
    public boolean mo28487QG(int i) {
        switch (mo28486QF(i)) {
            case DOODLE:
                return true;
            default:
                return false;
        }
    }

    public C32247e getCurFeatureType() {
        return mo28486QF(this.Acw);
    }

    public void setCurFeatureType(C32247e c32247e) {
        int i = 0;
        while (i < getFeatureCount()) {
            if (getPresenter().getFeatures()[i] == c32247e) {
                break;
            }
            i++;
        }
        i = -1;
        if (mo28487QG(i)) {
            this.jpc = i;
        } else {
            this.jpc = -1;
        }
        this.Acw = i;
        requestLayout();
        invalidate();
    }

    public final void dMS() {
        this.Acw = this.Acx;
        requestLayout();
        invalidate();
    }

    public void setFooterVisible(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8288n);
            loadAnimation.setAnimationListener(new C160691());
            startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8289o);
        loadAnimation.setAnimationListener(new C57422());
        startAnimation(loadAnimation);
    }
}
