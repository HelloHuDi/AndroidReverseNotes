package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MultiGestureImageView extends LinearLayout {
    private int apF;
    private int apG;
    private float ccB;
    private int count = 0;
    private int ieu;
    private int iev;
    private j mSA;
    private j mSB;
    private d mSC;
    private b mSD;
    private MultiTouchImageView mSi;
    private long mSj = 0;
    private long mSk = 0;
    private float mSl = 0.0f;
    private float mSm = 0.0f;
    private long mSn = 0;
    private boolean mSp = false;
    private OverScroller mSq;
    private GestureDetector mSr;
    private RectF mSs = new RectF();
    private a mSt;
    private float mSu;
    private boolean mSv = false;
    private boolean mSw = false;
    private boolean mSx = false;
    private boolean mSy = false;
    private j mSz;

    class e extends a {
        MultiTouchImageView mSF;
        float[] v = new float[9];

        public e(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(21622);
            this.mSF = multiTouchImageView;
            AppMethodBeat.o(21622);
        }

        public final void play() {
            AppMethodBeat.i(21623);
            MultiGestureImageView.this.mSi.getHandler().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21621);
                    e.this.mSF.getImageMatrix().getValues(e.this.v);
                    float imageHeight = ((float) e.this.mSF.getImageHeight()) * e.this.mSF.getScale();
                    float f = e.this.v[5] + imageHeight;
                    float i = (float) MultiGestureImageView.this.iev;
                    if (imageHeight < ((float) MultiGestureImageView.this.iev)) {
                        i = (((float) MultiGestureImageView.this.iev) / 2.0f) + (imageHeight / 2.0f);
                    }
                    i -= f;
                    if (i <= 0.0f) {
                        e.this.cco = true;
                    } else if (Math.abs(i) <= 5.0f) {
                        e.this.cco = true;
                    } else {
                        i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    e.this.mSF.aj(0.0f, i);
                    AppMethodBeat.o(21621);
                }
            });
            AppMethodBeat.o(21623);
        }
    }

    class g extends a {
        MultiTouchImageView mSF;
        float[] v = new float[9];

        public g(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(21628);
            this.mSF = multiTouchImageView;
            AppMethodBeat.o(21628);
        }

        public final void play() {
            AppMethodBeat.i(21629);
            MultiGestureImageView.this.mSi.getHandler().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21627);
                    g.this.mSF.getImageMatrix().getValues(g.this.v);
                    float f = g.this.v[2];
                    float scale = g.this.mSF.getScale() * ((float) g.this.mSF.getImageWidth());
                    if (scale < ((float) MultiGestureImageView.this.ieu)) {
                        scale = (((float) MultiGestureImageView.this.ieu) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        g.this.cco = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        g.this.cco = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    g.this.mSF.aj(scale, 0.0f);
                    AppMethodBeat.o(21627);
                }
            });
            AppMethodBeat.o(21629);
        }
    }

    class i extends a {
        MultiTouchImageView mSF;
        float[] v = new float[9];

        public i(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(21634);
            this.mSF = multiTouchImageView;
            AppMethodBeat.o(21634);
        }

        public final void play() {
            AppMethodBeat.i(21635);
            MultiGestureImageView.this.mSi.getHandler().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21633);
                    i.this.mSF.getImageMatrix().getValues(i.this.v);
                    float f = i.this.v[5];
                    float scale = i.this.mSF.getScale() * ((float) i.this.mSF.getImageHeight());
                    if (scale < ((float) MultiGestureImageView.this.iev)) {
                        scale = (((float) MultiGestureImageView.this.iev) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        i.this.cco = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        i.this.cco = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    i.this.mSF.aj(0.0f, scale);
                    AppMethodBeat.o(21633);
                }
            });
            AppMethodBeat.o(21635);
        }
    }

    class f extends a {
        MultiTouchImageView mSF;
        float[] v = new float[9];

        public f(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(21625);
            this.mSF = multiTouchImageView;
            AppMethodBeat.o(21625);
        }

        public final void play() {
            AppMethodBeat.i(21626);
            MultiGestureImageView.this.mSi.getHandler().post(new Runnable() {
                public final void run() {
                    float g;
                    AppMethodBeat.i(21624);
                    f.this.mSF.getImageMatrix().getValues(f.this.v);
                    float scale = f.this.mSF.getScale() * ((float) f.this.mSF.getImageWidth());
                    float imageHeight = ((float) f.this.mSF.getImageHeight()) * f.this.mSF.getScale();
                    float f = f.this.v[2];
                    float f2 = f.this.v[5];
                    float f3 = f.this.v[2] + scale;
                    float f4 = f.this.v[5] + imageHeight;
                    float f5 = 0.0f;
                    float i = (float) MultiGestureImageView.this.iev;
                    float f6 = 0.0f;
                    float g2 = (float) MultiGestureImageView.this.ieu;
                    if (imageHeight < ((float) MultiGestureImageView.this.iev)) {
                        f5 = (((float) MultiGestureImageView.this.iev) / 2.0f) - (imageHeight / 2.0f);
                        imageHeight = (((float) MultiGestureImageView.this.iev) / 2.0f) + (imageHeight / 2.0f);
                    } else {
                        imageHeight = i;
                    }
                    i = f5 - f2;
                    imageHeight -= f4;
                    if (i >= 0.0f) {
                        if (imageHeight > 0.0f) {
                            i = imageHeight;
                        } else {
                            i = 0.0f;
                        }
                    }
                    if (scale < ((float) MultiGestureImageView.this.ieu)) {
                        g = (((float) MultiGestureImageView.this.ieu) / 2.0f) + (scale / 2.0f);
                        f6 = (((float) MultiGestureImageView.this.ieu) / 2.0f) - (scale / 2.0f);
                    } else {
                        g = g2;
                    }
                    imageHeight = f6 - f;
                    g -= f3;
                    if (imageHeight >= 0.0f) {
                        if (g > 0.0f) {
                            imageHeight = g;
                        } else {
                            imageHeight = 0.0f;
                        }
                    }
                    if (Math.abs(imageHeight) > 5.0f || Math.abs(i) > 5.0f) {
                        if (imageHeight >= 0.0f) {
                            imageHeight = ((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            imageHeight = (-((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (i >= 0.0f) {
                            i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            i = (-((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        f.this.cco = true;
                    }
                    f.this.mSF.aj(imageHeight, i);
                    AppMethodBeat.o(21624);
                }
            });
            AppMethodBeat.o(21626);
        }
    }

    class h extends a {
        MultiTouchImageView mSF;
        float[] v = new float[9];

        public h(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.i(21631);
            this.mSF = multiTouchImageView;
            AppMethodBeat.o(21631);
        }

        public final void play() {
            AppMethodBeat.i(21632);
            MultiGestureImageView.this.mSi.getHandler().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21630);
                    h.this.mSF.getImageMatrix().getValues(h.this.v);
                    float imageWidth = ((float) h.this.mSF.getImageWidth()) * h.this.mSF.getScale();
                    float f = h.this.v[2] + imageWidth;
                    float g = (float) MultiGestureImageView.this.ieu;
                    if (imageWidth < ((float) MultiGestureImageView.this.ieu)) {
                        g = (((float) MultiGestureImageView.this.ieu) / 2.0f) + (imageWidth / 2.0f);
                    }
                    g -= f;
                    if (g <= 0.0f) {
                        h.this.cco = true;
                    } else if (Math.abs(g) <= 5.0f) {
                        h.this.cco = true;
                    } else {
                        g = ((float) (((double) Math.abs(g)) - Math.pow(Math.sqrt((double) Math.abs(g)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    h.this.mSF.aj(g, 0.0f);
                    AppMethodBeat.o(21630);
                }
            });
            AppMethodBeat.o(21632);
        }
    }

    public interface b {
    }

    class c extends SimpleOnGestureListener {
        private c() {
        }

        /* synthetic */ c(MultiGestureImageView multiGestureImageView, byte b) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }
    }

    public interface d {
    }

    public class j extends ak {
        WeakReference<MultiGestureImageView> aIp;
        boolean cOV;
        private long mSL;

        public j(WeakReference<MultiGestureImageView> weakReference) {
            this.aIp = weakReference;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(21638);
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.aIp != null) {
                final MultiGestureImageView multiGestureImageView = (MultiGestureImageView) this.aIp.get();
                if (multiGestureImageView != null) {
                    if (message.what == 0) {
                        if (multiGestureImageView.count == 1 || this.cOV) {
                            ab.d("MicroMsg.MuitlGestureImageView", "single click over!");
                            if (multiGestureImageView.mSC != null) {
                                multiGestureImageView.getHandler().post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(21636);
                                        multiGestureImageView.mSC;
                                        AppMethodBeat.o(21636);
                                    }
                                });
                            }
                        }
                        MultiGestureImageView.this.count = 0;
                        AppMethodBeat.o(21638);
                        return;
                    } else if (message.what != 1) {
                        removeMessages(2);
                        if (multiGestureImageView.mSD != null) {
                            multiGestureImageView.getHandler().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(21637);
                                    multiGestureImageView.mSD;
                                    AppMethodBeat.o(21637);
                                }
                            });
                        }
                    } else if (MultiGestureImageView.this.mSt == null || MultiGestureImageView.this.mSt.bCR()) {
                        MultiGestureImageView.e(multiGestureImageView);
                        AppMethodBeat.o(21638);
                        return;
                    } else {
                        MultiGestureImageView.this.mSt.play();
                        sendEmptyMessageDelayed(message.what, this.mSL);
                        AppMethodBeat.o(21638);
                        return;
                    }
                }
            }
            AppMethodBeat.o(21638);
        }

        public final void j(int i, long j, long j2) {
            AppMethodBeat.i(21639);
            this.mSL = j2;
            sendEmptyMessageDelayed(i, j);
            AppMethodBeat.o(21639);
        }
    }

    abstract class a {
        protected boolean cco = false;

        public abstract void play();

        public final boolean bCR() {
            return this.cco;
        }
    }

    static /* synthetic */ void e(MultiGestureImageView multiGestureImageView) {
        AppMethodBeat.i(21654);
        multiGestureImageView.bCP();
        AppMethodBeat.o(21654);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(21640);
        init(context, attributeSet);
        AppMethodBeat.o(21640);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(21641);
        init(context, attributeSet);
        AppMethodBeat.o(21641);
    }

    public void setSingleClickOverListener(d dVar) {
        this.mSC = dVar;
    }

    public void setLongClickOverListener(b bVar) {
        this.mSD = bVar;
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(21642);
        this.mSi = new MultiTouchImageView(context, attributeSet);
        this.mSr = new GestureDetector(context, new c(this, (byte) 0));
        this.mSq = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.mSi.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.mSi);
        this.mSz = new j(new WeakReference(this));
        this.mSA = new j(new WeakReference(this));
        this.mSB = new j(new WeakReference(this));
        AppMethodBeat.o(21642);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(21643);
        super.onMeasure(i, i2);
        this.ieu = MeasureSpec.getSize(i);
        this.iev = MeasureSpec.getSize(i2);
        this.mSs.set(0.0f, 0.0f, (float) this.ieu, (float) this.iev);
        ab.v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.ieu + " height:" + this.iev);
        AppMethodBeat.o(21643);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(21644);
        this.mSr.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.mSq.forceFinished(true);
            this.mSB.removeMessages(2);
            this.mSB.j(2, 500, 0);
            this.mSi.dzB();
            this.count++;
            if (this.count == 1) {
                this.mSj = System.currentTimeMillis();
                this.mSl = com.tencent.mm.ui.base.f.c(motionEvent, 0);
                this.mSm = com.tencent.mm.ui.base.f.d(motionEvent, 0);
            } else if (this.count == 2) {
                this.mSn = System.currentTimeMillis();
                if (this.mSn - this.mSk >= 350) {
                    this.count = 1;
                } else if (Math.abs(this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) >= 35.0f || Math.abs(this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) >= 35.0f) {
                    this.count = 1;
                } else {
                    this.count = 0;
                    ab.d("MicroMsg.MuitlGestureImageView", "double click!");
                    if (this.mSi.getScale() <= this.mSi.getScaleRate()) {
                        this.mSi.ai(com.tencent.mm.ui.base.f.c(motionEvent, 0), com.tencent.mm.ui.base.f.d(motionEvent, 0));
                    } else {
                        this.mSi.ah(com.tencent.mm.ui.base.f.c(motionEvent, 0), com.tencent.mm.ui.base.f.d(motionEvent, 0));
                        this.mSi.dAp();
                    }
                }
            }
        }
        if (motionEvent.getAction() == 6 || motionEvent.getAction() == com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM) {
            this.mSB.removeMessages(2);
            this.ccB = 0.0f;
            this.mSu = this.mSi.getScale();
            this.mSp = true;
            if (this.mSu < this.mSi.getScaleRate()) {
                this.mSi.ah((com.tencent.mm.ui.base.f.c(motionEvent, 0) - com.tencent.mm.ui.base.f.c(motionEvent, 1)) + com.tencent.mm.ui.base.f.c(motionEvent, 1), (com.tencent.mm.ui.base.f.d(motionEvent, 0) - com.tencent.mm.ui.base.f.d(motionEvent, 1)) + com.tencent.mm.ui.base.f.d(motionEvent, 1));
            }
            if (this.mSu > this.mSi.getDoubleTabScale()) {
                this.mSi.ai((com.tencent.mm.ui.base.f.c(motionEvent, 0) - com.tencent.mm.ui.base.f.c(motionEvent, 1)) + com.tencent.mm.ui.base.f.c(motionEvent, 1), (com.tencent.mm.ui.base.f.d(motionEvent, 0) - com.tencent.mm.ui.base.f.d(motionEvent, 1)) + com.tencent.mm.ui.base.f.d(motionEvent, 1));
            }
        }
        if (motionEvent.getAction() == 1) {
            this.mSB.removeMessages(2);
            if ((this.mSx || this.mSy) && (this.mSv || this.mSw)) {
                this.mSt = new f(this.mSi);
                bCQ();
                this.mSx = false;
                this.mSy = false;
                this.mSv = false;
                this.mSw = false;
            } else {
                if (this.mSx) {
                    this.mSx = false;
                    this.mSt = new g(this.mSi);
                    bCQ();
                }
                if (this.mSy) {
                    this.mSy = false;
                    this.mSt = new h(this.mSi);
                    bCQ();
                }
                if (this.mSv) {
                    this.mSv = false;
                    this.mSt = new i(this.mSi);
                    bCQ();
                }
                if (this.mSw) {
                    this.mSw = false;
                    this.mSt = new e(this.mSi);
                    bCQ();
                }
            }
            this.ccB = 0.0f;
            this.mSu = this.mSi.getScale();
            if (this.count == 1) {
                this.mSk = System.currentTimeMillis();
                if (this.mSk - this.mSj >= 350) {
                    this.count = 0;
                    ab.d("MicroMsg.MuitlGestureImageView", "single long click over!");
                } else if (Math.abs(this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) < 10.0f && Math.abs(this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) < 10.0f) {
                    j jVar = this.mSA;
                    jVar.cOV = false;
                    jVar.j(0, 350, 0);
                }
            }
        }
        if (motionEvent.getAction() == 5 || motionEvent.getAction() == com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW) {
            this.ccB = 0.0f;
            this.mSu = this.mSi.getScale();
            this.mSp = true;
        }
        if (motionEvent.getAction() == 2) {
            if (com.tencent.mm.ui.base.f.O(motionEvent) == 2) {
                this.mSB.removeMessages(2);
                this.mSp = true;
                this.count = 0;
                float c = com.tencent.mm.ui.base.f.c(motionEvent, 0) - com.tencent.mm.ui.base.f.c(motionEvent, 1);
                float d = com.tencent.mm.ui.base.f.d(motionEvent, 0) - com.tencent.mm.ui.base.f.d(motionEvent, 1);
                float sqrt = (float) Math.sqrt((double) ((c * c) + (d * d)));
                if (this.ccB == 0.0f) {
                    this.ccB = sqrt;
                } else {
                    sqrt /= this.ccB;
                    if (this.mSp) {
                        this.mSi.k(sqrt * this.mSu, c + com.tencent.mm.ui.base.f.c(motionEvent, 1), d + com.tencent.mm.ui.base.f.d(motionEvent, 1));
                    }
                }
            } else if (Math.abs(this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) > 10.0f || Math.abs(this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) > 10.0f) {
                this.mSB.removeMessages(2);
                this.count = 0;
                computeScroll();
            }
        }
        AppMethodBeat.o(21644);
        return true;
    }

    public void computeScroll() {
        int i = 0;
        AppMethodBeat.i(21645);
        if (this.mSi == null) {
            AppMethodBeat.o(21645);
            return;
        }
        if (this.mSq.computeScrollOffset()) {
            int currX = this.mSq.getCurrX() - this.apF;
            int currY = this.mSq.getCurrY() - this.apG;
            this.apF = this.mSq.getCurrX();
            this.apG = this.mSq.getCurrY();
            float scale = this.mSi.getScale();
            float imageWidth = ((float) this.mSi.getImageWidth()) * scale;
            scale *= (float) this.mSi.getImageHeight();
            float[] fArr = new float[9];
            this.mSi.getImageMatrix().getValues(fArr);
            float f = fArr[2];
            imageWidth += f;
            float f2 = fArr[5];
            float f3 = f2 + scale;
            if (currX < 0 && ((float) currX) < this.mSs.right - ((float) Math.round(imageWidth))) {
                currX = (int) (this.mSs.right - ((float) Math.round(imageWidth)));
            }
            if (currX > 0 && ((float) currX) > this.mSs.left - ((float) Math.round(f))) {
                currX = (int) (this.mSs.left - ((float) Math.round(f)));
            }
            if (currY < 0 && ((float) currY) < this.mSs.bottom - ((float) Math.round(f3))) {
                currY = (int) (this.mSs.bottom - ((float) Math.round(f3)));
            }
            if (currY > 0 && ((float) currY) > this.mSs.top - ((float) Math.round(f2))) {
                currY = (int) (this.mSs.top - ((float) Math.round(f2)));
            }
            if (((float) Math.round(f)) >= this.mSs.left || ((float) Math.round(imageWidth)) <= this.mSs.right) {
                currX = 0;
            } else if (((float) Math.round(f2)) >= this.mSs.top || ((float) Math.round(f3)) <= this.mSs.bottom) {
                currY = 0;
            }
            if (scale >= ((float) this.iev)) {
                i = currY;
            }
            this.mSi.aj((float) currX, (float) i);
            postInvalidate();
        }
        AppMethodBeat.o(21645);
    }

    private void bCP() {
        AppMethodBeat.i(21646);
        this.mSz.removeMessages(1);
        AppMethodBeat.o(21646);
    }

    private void bCQ() {
        AppMethodBeat.i(21647);
        bCP();
        this.mSz.j(1, 15, 15);
        AppMethodBeat.o(21647);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        AppMethodBeat.i(21648);
        this.mSi.setEnableHorLongBmpMode(z);
        AppMethodBeat.o(21648);
    }

    public int getImageWidth() {
        AppMethodBeat.i(21649);
        int imageWidth = this.mSi.getImageWidth();
        AppMethodBeat.o(21649);
        return imageWidth;
    }

    public void setImageWidth(int i) {
        AppMethodBeat.i(21650);
        this.mSi.setImageWidth(i);
        AppMethodBeat.o(21650);
    }

    public int getImageHeight() {
        AppMethodBeat.i(21651);
        int imageHeight = this.mSi.getImageHeight();
        AppMethodBeat.o(21651);
        return imageHeight;
    }

    public void setImageHeight(int i) {
        AppMethodBeat.i(21652);
        this.mSi.setImageHeight(i);
        AppMethodBeat.o(21652);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(21653);
        this.mSi.setImageBitmap(bitmap);
        this.mSi.dzA();
        AppMethodBeat.o(21653);
    }
}
