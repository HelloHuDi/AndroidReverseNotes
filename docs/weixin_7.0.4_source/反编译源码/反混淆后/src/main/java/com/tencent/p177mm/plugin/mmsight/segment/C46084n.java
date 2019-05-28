package com.tencent.p177mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.n */
public final class C46084n extends View {
    private Paint borderPaint;
    private int borderWidth;
    private OnTouchListener mNa;
    private C12582a oyL;
    private boolean oyM;
    boolean oyN;
    private int oyO;
    private int oyP;
    Drawable oyQ;
    Drawable oyR;
    private int oyS;
    private float oyT;
    private int oyU;
    float oyV;
    private int oyW;
    private Paint oyX;
    private float oyY;
    private Paint oyZ;
    private Paint oza;
    private int ozb;
    private float ozc;
    private float ozd;
    private float oze;
    private int ozf;
    Rect ozg;
    Rect ozh;
    private int padding;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.n$a */
    public interface C12582a {
        void bQm();

        void bQn();

        /* renamed from: iZ */
        void mo7947iZ(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.n$b */
    class C12583b extends Drawable {
        boolean ozq = false;
        private Drawable ozr;
        private Drawable ozs;

        public C12583b(Drawable drawable, Drawable drawable2) {
            this.ozr = drawable;
            this.ozs = drawable2;
            this.ozq = false;
        }

        public final void draw(Canvas canvas) {
            Drawable drawable;
            AppMethodBeat.m2504i(55013);
            if (this.ozq) {
                drawable = this.ozr;
            } else {
                drawable = this.ozs;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
            AppMethodBeat.m2505o(55013);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.m2504i(55014);
            this.ozr.setAlpha(i);
            this.ozs.setAlpha(i);
            AppMethodBeat.m2505o(55014);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.m2504i(55015);
            this.ozr.setColorFilter(colorFilter);
            this.ozs.setColorFilter(colorFilter);
            AppMethodBeat.m2505o(55015);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.n$1 */
    class C285191 implements Runnable {
        final /* synthetic */ int ozi;
        final /* synthetic */ int ozj;
        final /* synthetic */ int ozk;

        C285191(int i, int i2, int i3) {
            this.ozi = i;
            this.ozj = i2;
            this.ozk = i3;
        }

        public final void run() {
            AppMethodBeat.m2504i(55011);
            if (this.ozi <= C46084n.this.oyS * 2) {
                IllegalStateException illegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
                AppMethodBeat.m2505o(55011);
                throw illegalStateException;
            }
            C46084n.this.oyM = true;
            C46084n.this.padding = this.ozj;
            C46084n.this.oyO = Math.min(this.ozi, C46084n.this.getWidth() - (this.ozj * 2));
            C46084n.this.oyP = Math.max(this.ozk, C46084n.this.oyS * 2);
            C46084n.this.oyQ.setBounds(this.ozj, 0, this.ozj + C46084n.this.oyS, C46084n.this.getHeight());
            C46084n.this.oyR.setBounds((this.ozj + C46084n.this.oyO) - C46084n.this.oyS, 0, C46084n.this.oyO + this.ozj, C46084n.this.getHeight());
            if (C46084n.this.ozg == null && C46084n.this.ozh == null) {
                C46084n.this.ozg = C46084n.this.oyQ.getBounds();
                C46084n.this.ozh = C46084n.this.oyR.getBounds();
            }
            C46084n.this.invalidate();
            AppMethodBeat.m2505o(55011);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.n$2 */
    class C433132 implements OnTouchListener {
        float hke;
        float hkf;
        int ozm = -1;
        int ozn = -1;
        int ozo;
        int ozp;

        C433132() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(55012);
            if (C46084n.this.oyM) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 5:
                        this.ozp = motionEvent.getActionIndex();
                        this.ozo = motionEvent.getPointerId(this.ozp);
                        this.hke = motionEvent.getX(this.ozp);
                        this.hkf = motionEvent.getY(this.ozp);
                        if (C46084n.m85883a(C46084n.this, C46084n.this.oyQ, this.hke, this.hkf)) {
                            if (C46084n.m85884a(C46084n.this, true)) {
                                AppMethodBeat.m2505o(55012);
                                return false;
                            }
                            if (C46084n.this.oyL != null) {
                                C46084n.this.oyL.bQm();
                            }
                            this.ozm = this.ozo;
                            C46084n.this.ozd = (float) C46084n.this.oyQ.getBounds().left;
                            C46084n.m85882a(C46084n.this, true, true);
                            AppMethodBeat.m2505o(55012);
                            return true;
                        } else if (!C46084n.m85883a(C46084n.this, C46084n.this.oyR, this.hke, this.hkf)) {
                            AppMethodBeat.m2505o(55012);
                            return false;
                        } else if (C46084n.m85884a(C46084n.this, false)) {
                            AppMethodBeat.m2505o(55012);
                            return false;
                        } else {
                            if (C46084n.this.oyL != null) {
                                C46084n.this.oyL.bQm();
                            }
                            this.ozn = this.ozo;
                            C46084n.this.oze = (float) C46084n.this.oyR.getBounds().right;
                            C46084n.m85882a(C46084n.this, false, true);
                            AppMethodBeat.m2505o(55012);
                            return true;
                        }
                    case 1:
                    case 3:
                    case 6:
                        this.ozo = motionEvent.getPointerId(motionEvent.getActionIndex());
                        if (this.ozo == this.ozm || this.ozo == this.ozn) {
                            if (C46084n.this.oyL != null) {
                                C46084n.this.oyL.bQn();
                            }
                            C46084n.m85882a(C46084n.this, this.ozo == this.ozm, false);
                            if (this.ozo == this.ozm) {
                                this.ozm = -1;
                            } else {
                                this.ozn = -1;
                            }
                            AppMethodBeat.m2505o(55012);
                            return true;
                        }
                        AppMethodBeat.m2505o(55012);
                        return false;
                    case 2:
                        if (!C46084n.m85884a(C46084n.this, true) && !C46084n.m85884a(C46084n.this, false)) {
                            AppMethodBeat.m2505o(55012);
                            return false;
                        } else if (C46084n.this.oyN) {
                            AppMethodBeat.m2505o(55012);
                            return true;
                        } else {
                            this.ozp = 0;
                            boolean z = false;
                            while (this.ozp < motionEvent.getPointerCount()) {
                                this.ozo = motionEvent.getPointerId(this.ozp);
                                if (this.ozo == this.ozm || this.ozo == this.ozn) {
                                    C46084n c46084n = C46084n.this;
                                    if (this.ozo == this.ozm) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    C46084n.m85881a(c46084n, z, motionEvent.getX(this.ozp));
                                    if (C46084n.this.oyL != null) {
                                        C12582a j = C46084n.this.oyL;
                                        if (this.ozo == this.ozm) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        j.mo7947iZ(z);
                                    }
                                    z = true;
                                }
                                this.ozp++;
                            }
                            AppMethodBeat.m2505o(55012);
                            return z;
                        }
                    default:
                        AppMethodBeat.m2505o(55012);
                        return false;
                }
            }
            AppMethodBeat.m2505o(55012);
            return false;
        }
    }

    public C46084n(Context context) {
        super(context);
        AppMethodBeat.m2504i(55016);
        this.oyM = false;
        this.oyN = false;
        this.oyV = -1.0f;
        this.ozd = -1.0f;
        this.oze = -1.0f;
        this.padding = 0;
        this.mNa = new C433132();
        this.oyS = C1338a.fromDPToPix(getContext(), 8);
        this.oyT = ((float) this.oyS) * 0.5f;
        this.ozf = C1338a.fromDPToPix(getContext(), 8);
        this.oyQ = new C12583b(C1338a.m2864g(getContext(), C1318a.video_clip_slider_selected), C1338a.m2864g(getContext(), C1318a.video_clip_slider_normal));
        this.oyR = new C12583b(C1338a.m2864g(getContext(), C1318a.video_clip_slider_selected), C1338a.m2864g(getContext(), C1318a.video_clip_slider_normal));
        this.oyU = C1338a.fromDPToPix(getContext(), 1);
        this.oyW = C1338a.m2856al(getContext(), C25738R.dimen.aa1);
        this.oyV = -1.0f;
        this.oyX = new Paint();
        this.oyX.setColor(C1338a.m2872i(getContext(), C25738R.color.a69));
        this.oyX.setAlpha(102);
        this.oyZ = new Paint();
        this.oyZ.setColor(C1338a.m2872i(getContext(), C25738R.color.f11782h4));
        this.oyZ.setAlpha(102);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(C1338a.m2872i(getContext(), C25738R.color.a69));
        this.borderPaint.setStyle(Style.STROKE);
        this.borderWidth = C46084n.m85893ew(getContext());
        this.borderPaint.setStrokeWidth((float) this.borderWidth);
        this.oyY = ((float) this.borderWidth) * 0.5f;
        this.oza = new Paint();
        this.oza.setColor(C1338a.m2872i(getContext(), C25738R.color.a69));
        this.oza.setStyle(Style.STROKE);
        this.ozb = C46084n.m85893ew(getContext());
        this.ozc = ((float) this.ozb) * 0.5f;
        this.oza.setStrokeWidth((float) this.ozb);
        this.oza.setAlpha(178);
        setOnTouchListener(this.mNa);
        AppMethodBeat.m2505o(55016);
    }

    /* renamed from: ew */
    private static int m85893ew(Context context) {
        AppMethodBeat.m2504i(55017);
        int round = Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        AppMethodBeat.m2505o(55017);
        return round;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(55018);
        if (this.oyV > 0.0f) {
            float width = ((float) getWidth()) * this.oyV;
            canvas.drawRect(width - (((float) this.oyU) * 0.5f), 0.0f, (((float) this.oyU) * 0.5f) + width, (float) this.oyW, this.oyX);
        }
        if (this.oyM) {
            int centerX = this.oyQ.getBounds().centerX();
            int centerX2 = this.oyR.getBounds().centerX();
            if (m85899ja(true) || m85899ja(false)) {
                canvas.drawRect(((float) this.padding) + this.ozc, this.ozc, ((float) (getWidth() - this.padding)) - this.ozc, ((float) getBottom()) - this.ozc, this.oza);
            }
            if (this.oyQ.getBounds().left > 0) {
                canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.oyZ);
            }
            if (this.oyR.getBounds().right < getWidth()) {
                canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.oyZ);
            }
            canvas.drawLine((float) centerX, this.oyY, (float) centerX2, this.oyY, this.borderPaint);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.oyY, (float) centerX2, ((float) getHeight()) - this.oyY, this.borderPaint);
            this.oyQ.draw(canvas);
            this.oyR.draw(canvas);
            AppMethodBeat.m2505o(55018);
            return;
        }
        AppMethodBeat.m2505o(55018);
    }

    public final void setCursorPos(float f) {
        AppMethodBeat.m2504i(55019);
        if (this.oyM) {
            this.oyV = f;
            invalidate();
            AppMethodBeat.m2505o(55019);
            return;
        }
        AppMethodBeat.m2505o(55019);
    }

    /* renamed from: ja */
    private boolean m85899ja(boolean z) {
        AppMethodBeat.m2504i(55020);
        boolean a;
        if (z) {
            a = ((C12583b) this.oyQ).ozq;
            AppMethodBeat.m2505o(55020);
            return a;
        }
        a = ((C12583b) this.oyR).ozq;
        AppMethodBeat.m2505o(55020);
        return a;
    }

    public final int getLeftSliderBound() {
        AppMethodBeat.m2504i(55021);
        int i = this.oyQ.getBounds().left;
        AppMethodBeat.m2505o(55021);
        return i;
    }

    public final int getRightSliderBound() {
        AppMethodBeat.m2504i(55022);
        int i = this.oyR.getBounds().right;
        AppMethodBeat.m2505o(55022);
        return i;
    }

    public final void setOnSliderTouchListener(C12582a c12582a) {
        this.oyL = c12582a;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m85883a(C46084n c46084n, Drawable drawable, float f, float f2) {
        AppMethodBeat.m2504i(55026);
        if (!c46084n.oyM || drawable == null) {
            AppMethodBeat.m2505o(55026);
            return false;
        }
        Rect bounds = drawable.getBounds();
        if (f2 > ((float) (bounds.bottom + c46084n.ozf)) || f2 < ((float) (bounds.top - c46084n.ozf)) || f < ((float) (bounds.left - c46084n.ozf)) || f > ((float) (bounds.right + c46084n.ozf))) {
            AppMethodBeat.m2505o(55026);
            return false;
        }
        AppMethodBeat.m2505o(55026);
        return true;
    }
}
