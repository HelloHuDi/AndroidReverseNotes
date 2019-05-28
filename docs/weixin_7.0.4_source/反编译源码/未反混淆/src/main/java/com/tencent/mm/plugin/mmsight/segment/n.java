package com.tencent.mm.plugin.mmsight.segment;

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
import com.tencent.mm.R;

public final class n extends View {
    private Paint borderPaint;
    private int borderWidth;
    private OnTouchListener mNa;
    private a oyL;
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

    public interface a {
        void bQm();

        void bQn();

        void iZ(boolean z);
    }

    class b extends Drawable {
        boolean ozq = false;
        private Drawable ozr;
        private Drawable ozs;

        public b(Drawable drawable, Drawable drawable2) {
            this.ozr = drawable;
            this.ozs = drawable2;
            this.ozq = false;
        }

        public final void draw(Canvas canvas) {
            Drawable drawable;
            AppMethodBeat.i(55013);
            if (this.ozq) {
                drawable = this.ozr;
            } else {
                drawable = this.ozs;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
            AppMethodBeat.o(55013);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.i(55014);
            this.ozr.setAlpha(i);
            this.ozs.setAlpha(i);
            AppMethodBeat.o(55014);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(55015);
            this.ozr.setColorFilter(colorFilter);
            this.ozs.setColorFilter(colorFilter);
            AppMethodBeat.o(55015);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.n$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int ozi;
        final /* synthetic */ int ozj;
        final /* synthetic */ int ozk;

        AnonymousClass1(int i, int i2, int i3) {
            this.ozi = i;
            this.ozj = i2;
            this.ozk = i3;
        }

        public final void run() {
            AppMethodBeat.i(55011);
            if (this.ozi <= n.this.oyS * 2) {
                IllegalStateException illegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
                AppMethodBeat.o(55011);
                throw illegalStateException;
            }
            n.this.oyM = true;
            n.this.padding = this.ozj;
            n.this.oyO = Math.min(this.ozi, n.this.getWidth() - (this.ozj * 2));
            n.this.oyP = Math.max(this.ozk, n.this.oyS * 2);
            n.this.oyQ.setBounds(this.ozj, 0, this.ozj + n.this.oyS, n.this.getHeight());
            n.this.oyR.setBounds((this.ozj + n.this.oyO) - n.this.oyS, 0, n.this.oyO + this.ozj, n.this.getHeight());
            if (n.this.ozg == null && n.this.ozh == null) {
                n.this.ozg = n.this.oyQ.getBounds();
                n.this.ozh = n.this.oyR.getBounds();
            }
            n.this.invalidate();
            AppMethodBeat.o(55011);
        }
    }

    public n(Context context) {
        super(context);
        AppMethodBeat.i(55016);
        this.oyM = false;
        this.oyN = false;
        this.oyV = -1.0f;
        this.ozd = -1.0f;
        this.oze = -1.0f;
        this.padding = 0;
        this.mNa = new OnTouchListener() {
            float hke;
            float hkf;
            int ozm = -1;
            int ozn = -1;
            int ozo;
            int ozp;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(55012);
                if (n.this.oyM) {
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                        case 5:
                            this.ozp = motionEvent.getActionIndex();
                            this.ozo = motionEvent.getPointerId(this.ozp);
                            this.hke = motionEvent.getX(this.ozp);
                            this.hkf = motionEvent.getY(this.ozp);
                            if (n.a(n.this, n.this.oyQ, this.hke, this.hkf)) {
                                if (n.a(n.this, true)) {
                                    AppMethodBeat.o(55012);
                                    return false;
                                }
                                if (n.this.oyL != null) {
                                    n.this.oyL.bQm();
                                }
                                this.ozm = this.ozo;
                                n.this.ozd = (float) n.this.oyQ.getBounds().left;
                                n.a(n.this, true, true);
                                AppMethodBeat.o(55012);
                                return true;
                            } else if (!n.a(n.this, n.this.oyR, this.hke, this.hkf)) {
                                AppMethodBeat.o(55012);
                                return false;
                            } else if (n.a(n.this, false)) {
                                AppMethodBeat.o(55012);
                                return false;
                            } else {
                                if (n.this.oyL != null) {
                                    n.this.oyL.bQm();
                                }
                                this.ozn = this.ozo;
                                n.this.oze = (float) n.this.oyR.getBounds().right;
                                n.a(n.this, false, true);
                                AppMethodBeat.o(55012);
                                return true;
                            }
                        case 1:
                        case 3:
                        case 6:
                            this.ozo = motionEvent.getPointerId(motionEvent.getActionIndex());
                            if (this.ozo == this.ozm || this.ozo == this.ozn) {
                                if (n.this.oyL != null) {
                                    n.this.oyL.bQn();
                                }
                                n.a(n.this, this.ozo == this.ozm, false);
                                if (this.ozo == this.ozm) {
                                    this.ozm = -1;
                                } else {
                                    this.ozn = -1;
                                }
                                AppMethodBeat.o(55012);
                                return true;
                            }
                            AppMethodBeat.o(55012);
                            return false;
                        case 2:
                            if (!n.a(n.this, true) && !n.a(n.this, false)) {
                                AppMethodBeat.o(55012);
                                return false;
                            } else if (n.this.oyN) {
                                AppMethodBeat.o(55012);
                                return true;
                            } else {
                                this.ozp = 0;
                                boolean z = false;
                                while (this.ozp < motionEvent.getPointerCount()) {
                                    this.ozo = motionEvent.getPointerId(this.ozp);
                                    if (this.ozo == this.ozm || this.ozo == this.ozn) {
                                        n nVar = n.this;
                                        if (this.ozo == this.ozm) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        n.a(nVar, z, motionEvent.getX(this.ozp));
                                        if (n.this.oyL != null) {
                                            a j = n.this.oyL;
                                            if (this.ozo == this.ozm) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            j.iZ(z);
                                        }
                                        z = true;
                                    }
                                    this.ozp++;
                                }
                                AppMethodBeat.o(55012);
                                return z;
                            }
                        default:
                            AppMethodBeat.o(55012);
                            return false;
                    }
                }
                AppMethodBeat.o(55012);
                return false;
            }
        };
        this.oyS = com.tencent.mm.bz.a.fromDPToPix(getContext(), 8);
        this.oyT = ((float) this.oyS) * 0.5f;
        this.ozf = com.tencent.mm.bz.a.fromDPToPix(getContext(), 8);
        this.oyQ = new b(com.tencent.mm.bz.a.g(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.bz.a.g(getContext(), R.raw.video_clip_slider_normal));
        this.oyR = new b(com.tencent.mm.bz.a.g(getContext(), R.raw.video_clip_slider_selected), com.tencent.mm.bz.a.g(getContext(), R.raw.video_clip_slider_normal));
        this.oyU = com.tencent.mm.bz.a.fromDPToPix(getContext(), 1);
        this.oyW = com.tencent.mm.bz.a.al(getContext(), R.dimen.aa1);
        this.oyV = -1.0f;
        this.oyX = new Paint();
        this.oyX.setColor(com.tencent.mm.bz.a.i(getContext(), R.color.a69));
        this.oyX.setAlpha(102);
        this.oyZ = new Paint();
        this.oyZ.setColor(com.tencent.mm.bz.a.i(getContext(), R.color.h4));
        this.oyZ.setAlpha(102);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(com.tencent.mm.bz.a.i(getContext(), R.color.a69));
        this.borderPaint.setStyle(Style.STROKE);
        this.borderWidth = ew(getContext());
        this.borderPaint.setStrokeWidth((float) this.borderWidth);
        this.oyY = ((float) this.borderWidth) * 0.5f;
        this.oza = new Paint();
        this.oza.setColor(com.tencent.mm.bz.a.i(getContext(), R.color.a69));
        this.oza.setStyle(Style.STROKE);
        this.ozb = ew(getContext());
        this.ozc = ((float) this.ozb) * 0.5f;
        this.oza.setStrokeWidth((float) this.ozb);
        this.oza.setAlpha(178);
        setOnTouchListener(this.mNa);
        AppMethodBeat.o(55016);
    }

    private static int ew(Context context) {
        AppMethodBeat.i(55017);
        int round = Math.round(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        AppMethodBeat.o(55017);
        return round;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(55018);
        if (this.oyV > 0.0f) {
            float width = ((float) getWidth()) * this.oyV;
            canvas.drawRect(width - (((float) this.oyU) * 0.5f), 0.0f, (((float) this.oyU) * 0.5f) + width, (float) this.oyW, this.oyX);
        }
        if (this.oyM) {
            int centerX = this.oyQ.getBounds().centerX();
            int centerX2 = this.oyR.getBounds().centerX();
            if (ja(true) || ja(false)) {
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
            AppMethodBeat.o(55018);
            return;
        }
        AppMethodBeat.o(55018);
    }

    public final void setCursorPos(float f) {
        AppMethodBeat.i(55019);
        if (this.oyM) {
            this.oyV = f;
            invalidate();
            AppMethodBeat.o(55019);
            return;
        }
        AppMethodBeat.o(55019);
    }

    private boolean ja(boolean z) {
        AppMethodBeat.i(55020);
        boolean a;
        if (z) {
            a = ((b) this.oyQ).ozq;
            AppMethodBeat.o(55020);
            return a;
        }
        a = ((b) this.oyR).ozq;
        AppMethodBeat.o(55020);
        return a;
    }

    public final int getLeftSliderBound() {
        AppMethodBeat.i(55021);
        int i = this.oyQ.getBounds().left;
        AppMethodBeat.o(55021);
        return i;
    }

    public final int getRightSliderBound() {
        AppMethodBeat.i(55022);
        int i = this.oyR.getBounds().right;
        AppMethodBeat.o(55022);
        return i;
    }

    public final void setOnSliderTouchListener(a aVar) {
        this.oyL = aVar;
    }

    static /* synthetic */ boolean a(n nVar, Drawable drawable, float f, float f2) {
        AppMethodBeat.i(55026);
        if (!nVar.oyM || drawable == null) {
            AppMethodBeat.o(55026);
            return false;
        }
        Rect bounds = drawable.getBounds();
        if (f2 > ((float) (bounds.bottom + nVar.ozf)) || f2 < ((float) (bounds.top - nVar.ozf)) || f < ((float) (bounds.left - nVar.ozf)) || f > ((float) (bounds.right + nVar.ozf))) {
            AppMethodBeat.o(55026);
            return false;
        }
        AppMethodBeat.o(55026);
        return true;
    }
}
