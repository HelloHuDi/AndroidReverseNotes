package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MMGestureGallery extends Gallery {
    private float aKM = 0.0f;
    private float aKN = 0.0f;
    private int apF;
    private int apG;
    private float ccB;
    private int count = 0;
    private ak handler = new ak(Looper.getMainLooper());
    private int ieu;
    private int iev;
    private MultiTouchImageView mSF;
    private long mSj = 0;
    private long mSk = 0;
    private float mSl = 0.0f;
    private float mSm = 0.0f;
    private long mSn = 0;
    private boolean mSp = false;
    private OverScroller mSq;
    private GestureDetector mSr;
    private RectF mSs = new RectF();
    private float mSu;
    private boolean mSv = false;
    private boolean mSw = false;
    private boolean mSx = false;
    private boolean mSy = false;
    private VelocityTracker mVelocityTracker;
    private boolean rvb = false;
    private boolean rvc = false;
    private boolean rvd = false;
    private final int yyA = 60;
    private final int yyB = 500;
    public boolean yyh = false;
    private boolean yyi = false;
    private boolean yyj = false;
    private boolean yyk = false;
    private boolean yyl = false;
    private int yym = 0;
    public l zFB;
    public l zFC;
    public l zFD;
    private a zFE;
    private f zFF;
    private c zFG;
    private e zFH;
    private boolean zFI = true;
    private b zFJ;

    class d extends SimpleOnGestureListener {
        private d() {
        }

        /* synthetic */ d(MMGestureGallery mMGestureGallery, byte b) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }
    }

    public interface e {
        void ctp();
    }

    class g extends a {
        float[] v = new float[9];

        public g() {
            super();
            AppMethodBeat.i(107663);
            AppMethodBeat.o(107663);
        }

        public final void play() {
            AppMethodBeat.i(107664);
            MMGestureGallery.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107662);
                    MMGestureGallery.this.mSF.getImageMatrix().getValues(g.this.v);
                    float imageHeight = ((float) MMGestureGallery.this.mSF.getImageHeight()) * MMGestureGallery.this.mSF.getScale();
                    float f = g.this.v[5] + imageHeight;
                    float d = (float) MMGestureGallery.this.iev;
                    if (imageHeight < ((float) MMGestureGallery.this.iev)) {
                        d = (((float) MMGestureGallery.this.iev) / 2.0f) + (imageHeight / 2.0f);
                    }
                    d -= f;
                    if (d <= 0.0f) {
                        g.this.cco = true;
                    } else if (Math.abs(d) <= 5.0f) {
                        g.this.cco = true;
                    } else {
                        d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMGestureGallery.this.mSF.aj(0.0f, d);
                    AppMethodBeat.o(107662);
                }
            });
            AppMethodBeat.o(107664);
        }
    }

    abstract class a {
        protected boolean cco = false;

        public abstract void play();

        public final boolean bCR() {
            return this.cco;
        }
    }

    public interface c {
        void bvE();
    }

    public interface f {
        void bcX();
    }

    class i extends a {
        float[] v = new float[9];

        public i() {
            super();
            AppMethodBeat.i(107669);
            AppMethodBeat.o(107669);
        }

        public final void play() {
            AppMethodBeat.i(107670);
            MMGestureGallery.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107668);
                    MMGestureGallery.this.mSF.getImageMatrix().getValues(i.this.v);
                    float f = i.this.v[2];
                    float scale = MMGestureGallery.this.mSF.getScale() * ((float) MMGestureGallery.this.mSF.getImageWidth());
                    if (scale < ((float) MMGestureGallery.this.ieu)) {
                        scale = (((float) MMGestureGallery.this.ieu) / 2.0f) - (scale / 2.0f);
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
                    MMGestureGallery.this.mSF.aj(scale, 0.0f);
                    AppMethodBeat.o(107668);
                }
            });
            AppMethodBeat.o(107670);
        }
    }

    public interface b {
        void aa(float f, float f2);

        void ab(float f, float f2);
    }

    class j extends a {
        float[] v = new float[9];

        public j() {
            super();
            AppMethodBeat.i(107672);
            AppMethodBeat.o(107672);
        }

        public final void play() {
            AppMethodBeat.i(107673);
            MMGestureGallery.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107671);
                    MMGestureGallery.this.mSF.getImageMatrix().getValues(j.this.v);
                    float imageWidth = ((float) MMGestureGallery.this.mSF.getImageWidth()) * MMGestureGallery.this.mSF.getScale();
                    float f = j.this.v[2] + imageWidth;
                    float b = (float) MMGestureGallery.this.ieu;
                    if (imageWidth < ((float) MMGestureGallery.this.ieu)) {
                        b = (((float) MMGestureGallery.this.ieu) / 2.0f) + (imageWidth / 2.0f);
                    }
                    b -= f;
                    if (b <= 0.0f) {
                        j.this.cco = true;
                    } else if (Math.abs(b) <= 5.0f) {
                        j.this.cco = true;
                    } else {
                        b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMGestureGallery.this.mSF.aj(b, 0.0f);
                    AppMethodBeat.o(107671);
                }
            });
            AppMethodBeat.o(107673);
        }
    }

    public static class l extends ak {
        private boolean cOV;
        private long mSL;
        WeakReference<MMGestureGallery> yyI;

        public l(WeakReference<MMGestureGallery> weakReference) {
            this.yyI = weakReference;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(107679);
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.yyI != null) {
                final MMGestureGallery mMGestureGallery = (MMGestureGallery) this.yyI.get();
                if (mMGestureGallery != null) {
                    if (message.what == 0) {
                        if (mMGestureGallery.count == 1 || this.cOV) {
                            ab.d("MicroMsg.MMGestureGallery", "single click over!");
                            if (mMGestureGallery.zFF != null) {
                                mMGestureGallery.handler.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(107677);
                                        mMGestureGallery.zFF.bcX();
                                        AppMethodBeat.o(107677);
                                    }
                                });
                            }
                        }
                        mMGestureGallery.count = 0;
                        AppMethodBeat.o(107679);
                        return;
                    } else if (message.what != 1) {
                        removeMessages(2);
                        if (mMGestureGallery.zFG != null) {
                            mMGestureGallery.handler.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(107678);
                                    mMGestureGallery.zFG.bvE();
                                    AppMethodBeat.o(107678);
                                }
                            });
                        }
                    } else if (mMGestureGallery.zFE == null || mMGestureGallery.zFE.bCR()) {
                        MMGestureGallery.S(mMGestureGallery);
                        AppMethodBeat.o(107679);
                        return;
                    } else {
                        mMGestureGallery.zFE.play();
                        sendEmptyMessageDelayed(message.what, this.mSL);
                        AppMethodBeat.o(107679);
                        return;
                    }
                }
            }
            AppMethodBeat.o(107679);
        }

        public final void j(int i, long j, long j2) {
            AppMethodBeat.i(107680);
            this.mSL = j2;
            sendEmptyMessageDelayed(i, j);
            AppMethodBeat.o(107680);
        }

        public final void D(long j, boolean z) {
            AppMethodBeat.i(107681);
            this.cOV = z;
            j(0, j, 0);
            AppMethodBeat.o(107681);
        }

        public final void release() {
            AppMethodBeat.i(107682);
            removeMessages(0);
            removeMessages(1);
            removeMessages(2);
            AppMethodBeat.o(107682);
        }
    }

    class h extends a {
        float[] v = new float[9];

        public h() {
            super();
            AppMethodBeat.i(107666);
            AppMethodBeat.o(107666);
        }

        public final void play() {
            AppMethodBeat.i(107667);
            MMGestureGallery.this.handler.post(new Runnable() {
                public final void run() {
                    float b;
                    AppMethodBeat.i(107665);
                    MMGestureGallery.this.mSF.getImageMatrix().getValues(h.this.v);
                    float scale = MMGestureGallery.this.mSF.getScale() * ((float) MMGestureGallery.this.mSF.getImageWidth());
                    float imageHeight = ((float) MMGestureGallery.this.mSF.getImageHeight()) * MMGestureGallery.this.mSF.getScale();
                    float f = h.this.v[2];
                    float f2 = h.this.v[5];
                    float f3 = h.this.v[2] + scale;
                    float f4 = h.this.v[5] + imageHeight;
                    float f5 = 0.0f;
                    float d = (float) MMGestureGallery.this.iev;
                    float f6 = 0.0f;
                    float b2 = (float) MMGestureGallery.this.ieu;
                    if (imageHeight < ((float) MMGestureGallery.this.iev)) {
                        f5 = (((float) MMGestureGallery.this.iev) / 2.0f) - (imageHeight / 2.0f);
                        imageHeight = (((float) MMGestureGallery.this.iev) / 2.0f) + (imageHeight / 2.0f);
                    } else {
                        imageHeight = d;
                    }
                    d = f5 - f2;
                    imageHeight -= f4;
                    if (d >= 0.0f) {
                        if (imageHeight > 0.0f) {
                            d = imageHeight;
                        } else {
                            d = 0.0f;
                        }
                    }
                    if (scale < ((float) MMGestureGallery.this.ieu)) {
                        b = (((float) MMGestureGallery.this.ieu) / 2.0f) + (scale / 2.0f);
                        f6 = (((float) MMGestureGallery.this.ieu) / 2.0f) - (scale / 2.0f);
                    } else {
                        b = b2;
                    }
                    imageHeight = f6 - f;
                    b -= f3;
                    if (imageHeight >= 0.0f) {
                        if (b > 0.0f) {
                            imageHeight = b;
                        } else {
                            imageHeight = 0.0f;
                        }
                    }
                    if (Math.abs(imageHeight) > 5.0f || Math.abs(d) > 5.0f) {
                        if (imageHeight >= 0.0f) {
                            imageHeight = ((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            imageHeight = (-((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (d >= 0.0f) {
                            d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            d = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        h.this.cco = true;
                    }
                    MMGestureGallery.this.mSF.aj(imageHeight, d);
                    AppMethodBeat.o(107665);
                }
            });
            AppMethodBeat.o(107667);
        }
    }

    class k extends a {
        float[] v = new float[9];

        public k() {
            super();
            AppMethodBeat.i(107675);
            AppMethodBeat.o(107675);
        }

        public final void play() {
            AppMethodBeat.i(107676);
            MMGestureGallery.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107674);
                    MMGestureGallery.this.mSF.getImageMatrix().getValues(k.this.v);
                    float f = k.this.v[5];
                    float scale = MMGestureGallery.this.mSF.getScale() * ((float) MMGestureGallery.this.mSF.getImageHeight());
                    if (scale < ((float) MMGestureGallery.this.iev)) {
                        scale = (((float) MMGestureGallery.this.iev) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        k.this.cco = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        k.this.cco = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    MMGestureGallery.this.mSF.aj(0.0f, scale);
                    AppMethodBeat.o(107674);
                }
            });
            AppMethodBeat.o(107676);
        }
    }

    static /* synthetic */ void S(MMGestureGallery mMGestureGallery) {
        AppMethodBeat.i(107700);
        mMGestureGallery.bCP();
        AppMethodBeat.o(107700);
    }

    public void setSingleClickOverListener(f fVar) {
        this.zFF = fVar;
    }

    public void setLongClickOverListener(c cVar) {
        this.zFG = cVar;
    }

    public void setScrollLeftRightListener(e eVar) {
        this.zFH = eVar;
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107683);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(107683);
    }

    private void bCP() {
        AppMethodBeat.i(107684);
        this.zFB.removeMessages(1);
        AppMethodBeat.o(107684);
    }

    public void setGalleryScaleListener(b bVar) {
        this.zFJ = bVar;
    }

    public void setLoadQuit(boolean z) {
        this.zFI = z;
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107685);
        setStaticTransformationsEnabled(true);
        this.mSr = new GestureDetector(context, new d(this, (byte) 0));
        this.zFB = new l(new WeakReference(this));
        this.zFC = new l(new WeakReference(this));
        this.zFD = new l(new WeakReference(this));
        this.mSq = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.yym = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        setOnTouchListener(new OnTouchListener() {
            private void dJM() {
                AppMethodBeat.i(107658);
                dJN();
                MMGestureGallery.this.zFD.j(2, 500, 0);
                AppMethodBeat.o(107658);
            }

            private void dJN() {
                AppMethodBeat.i(107659);
                MMGestureGallery.this.zFD.removeMessages(2);
                AppMethodBeat.o(107659);
            }

            /* JADX WARNING: Missing block: B:42:0x00da, code skipped:
            if (r0 == null) goto L_0x00dc;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(107660);
                if (MMGestureGallery.this.mVelocityTracker == null) {
                    MMGestureGallery.this.mVelocityTracker = VelocityTracker.obtain();
                }
                MMGestureGallery.this.mVelocityTracker.addMovement(motionEvent);
                View selectedView = MMGestureGallery.this.getSelectedView();
                if (selectedView instanceof ViewGroup) {
                    if (motionEvent.getAction() == 0) {
                        MMGestureGallery.this.mSl = com.tencent.mm.ui.base.f.c(motionEvent, 0);
                        MMGestureGallery.this.mSm = com.tencent.mm.ui.base.f.d(motionEvent, 0);
                    }
                    View findViewById = selectedView.findViewById(R.id.bl);
                    if (!(findViewById == null || findViewById.getVisibility() != 0 || (findViewById instanceof MultiTouchImageView))) {
                        if (motionEvent.getAction() == 0) {
                            dJM();
                        }
                        if (motionEvent.getAction() == 1) {
                            dJN();
                        }
                    }
                    selectedView = selectedView.findViewById(R.id.bm);
                    if ((selectedView == null || selectedView.getVisibility() == 8) && MMGestureGallery.this.zFI && MMGestureGallery.this.zFF != null && motionEvent.getAction() == 1 && Math.abs(MMGestureGallery.this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) < 10.0f && Math.abs(MMGestureGallery.this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) < 10.0f && !MMGestureGallery.this.rvd) {
                        qP(true);
                    }
                    if (motionEvent.getAction() == 1) {
                        MMGestureGallery.this.rvd = false;
                    }
                    if (selectedView != null) {
                        selectedView = selectedView.findViewById(R.id.bl);
                    }
                    AppMethodBeat.o(107660);
                    return false;
                }
                if (selectedView instanceof MultiTouchImageView) {
                    float c;
                    float d;
                    MMGestureGallery.this.mSF = (MultiTouchImageView) selectedView;
                    ab.d("dktest", "MMGestureGallery onTouch event.getAction():" + motionEvent.getAction());
                    if (motionEvent.getAction() == 0) {
                        dJM();
                        MMGestureGallery.this.mSF.dzB();
                        MMGestureGallery.this.aKM = motionEvent.getX();
                        MMGestureGallery.this.aKN = motionEvent.getY();
                        MMGestureGallery.this.ccB = 0.0f;
                        MMGestureGallery.this.mSu = MMGestureGallery.this.mSF.getScale();
                        ab.d("dktest", "originalScale :" + MMGestureGallery.this.mSu);
                        MMGestureGallery.this.mSp = false;
                        MMGestureGallery.this.count = MMGestureGallery.this.count + 1;
                        if (MMGestureGallery.this.count == 1) {
                            MMGestureGallery.this.mSj = System.currentTimeMillis();
                            MMGestureGallery.this.mSl = com.tencent.mm.ui.base.f.c(motionEvent, 0);
                            MMGestureGallery.this.mSm = com.tencent.mm.ui.base.f.d(motionEvent, 0);
                        } else if (MMGestureGallery.this.count == 2) {
                            MMGestureGallery.this.mSn = System.currentTimeMillis();
                            if (MMGestureGallery.this.mSn - MMGestureGallery.this.mSk >= 350) {
                                MMGestureGallery.this.count = 1;
                            } else if (Math.abs(MMGestureGallery.this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) >= 35.0f || Math.abs(MMGestureGallery.this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) >= 35.0f) {
                                MMGestureGallery.this.count = 1;
                            } else {
                                MMGestureGallery.this.count = 0;
                                ab.d("MicroMsg.MMGestureGallery", "double click!");
                                if (MMGestureGallery.this.mSF.getScale() <= MMGestureGallery.this.mSF.getScaleRate()) {
                                    MMGestureGallery.this.mSF.ai(com.tencent.mm.ui.base.f.c(motionEvent, 0), com.tencent.mm.ui.base.f.d(motionEvent, 0));
                                } else {
                                    MMGestureGallery.this.mSF.ah(com.tencent.mm.ui.base.f.c(motionEvent, 0), com.tencent.mm.ui.base.f.d(motionEvent, 0));
                                    MMGestureGallery.this.mSF.dAp();
                                }
                            }
                        }
                    }
                    if (motionEvent.getAction() == 6 || motionEvent.getAction() == com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM) {
                        dJN();
                        MMGestureGallery.this.ccB = 0.0f;
                        MMGestureGallery.this.mSu = MMGestureGallery.this.mSF.getScale();
                        MMGestureGallery.this.mSp = true;
                        if (MMGestureGallery.this.mSu < MMGestureGallery.this.mSF.getScaleRate()) {
                            MMGestureGallery.this.mSF.ah((com.tencent.mm.ui.base.f.c(motionEvent, 0) - com.tencent.mm.ui.base.f.c(motionEvent, 1)) + com.tencent.mm.ui.base.f.c(motionEvent, 1), (com.tencent.mm.ui.base.f.d(motionEvent, 0) - com.tencent.mm.ui.base.f.d(motionEvent, 1)) + com.tencent.mm.ui.base.f.d(motionEvent, 1));
                        }
                        if (MMGestureGallery.this.mSu > MMGestureGallery.this.mSF.getDoubleTabScale() * 2.0f) {
                            c = com.tencent.mm.ui.base.f.c(motionEvent, 0) - com.tencent.mm.ui.base.f.c(motionEvent, 1);
                            d = com.tencent.mm.ui.base.f.d(motionEvent, 0) - com.tencent.mm.ui.base.f.d(motionEvent, 1);
                            MMGestureGallery.this.mSF.setMaxZoomLimit(MMGestureGallery.this.mSF.getDoubleTabScale() * 2.0f);
                            MMGestureGallery.this.mSF.k(MMGestureGallery.this.mSF.getDoubleTabScale() * 2.0f, c + com.tencent.mm.ui.base.f.c(motionEvent, 1), d + com.tencent.mm.ui.base.f.d(motionEvent, 1));
                        }
                    }
                    if (motionEvent.getAction() == 1) {
                        dJN();
                        MMGestureGallery.this.yyi = false;
                        MMGestureGallery.this.yyj = false;
                        MMGestureGallery.this.rvd = false;
                        if ((MMGestureGallery.this.mSx || MMGestureGallery.this.mSy || MMGestureGallery.this.yyk || MMGestureGallery.this.yyl) && (MMGestureGallery.this.mSv || MMGestureGallery.this.mSw)) {
                            MMGestureGallery.this.zFE = new h();
                            MMGestureGallery.z(MMGestureGallery.this);
                            MMGestureGallery.this.mSx = false;
                            MMGestureGallery.this.mSy = false;
                            MMGestureGallery.this.yyk = false;
                            MMGestureGallery.this.yyl = false;
                            MMGestureGallery.this.mSv = false;
                            MMGestureGallery.this.mSw = false;
                        } else {
                            if (MMGestureGallery.this.yyk || MMGestureGallery.this.mSx) {
                                MMGestureGallery.this.yyk = false;
                                MMGestureGallery.this.mSx = false;
                                MMGestureGallery.this.zFE = new i();
                                MMGestureGallery.z(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.yyl || MMGestureGallery.this.mSy) {
                                MMGestureGallery.this.yyl = false;
                                MMGestureGallery.this.mSy = false;
                                MMGestureGallery.this.zFE = new j();
                                MMGestureGallery.z(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.mSv) {
                                MMGestureGallery.this.mSv = false;
                                MMGestureGallery.this.zFE = new k();
                                MMGestureGallery.z(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.mSw) {
                                MMGestureGallery.this.mSw = false;
                                MMGestureGallery.this.zFE = new g();
                                MMGestureGallery.z(MMGestureGallery.this);
                            }
                            if (MMGestureGallery.this.rvc) {
                                if (MMGestureGallery.this.zFJ != null) {
                                    MMGestureGallery.this.zFJ.aa(0.0f, 0.0f);
                                }
                                MMGestureGallery.this.rvb = false;
                            }
                            if (MMGestureGallery.this.rvb && !MMGestureGallery.this.yyh) {
                                MMGestureGallery.this.zFC.D(0, true);
                                MMGestureGallery.this.rvb = false;
                            }
                        }
                        MMGestureGallery.this.ccB = 0.0f;
                        MMGestureGallery.this.mSu = MMGestureGallery.this.mSF.getScale();
                        if (MMGestureGallery.this.count == 1) {
                            MMGestureGallery.this.mSk = System.currentTimeMillis();
                            if (MMGestureGallery.this.mSk - MMGestureGallery.this.mSj >= 350) {
                                MMGestureGallery.this.count = 0;
                                ab.d("MicroMsg.MMGestureGallery", "single long click over!");
                            } else if (Math.abs(MMGestureGallery.this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) < 10.0f && Math.abs(MMGestureGallery.this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) < 10.0f) {
                                qP(false);
                            }
                        }
                    }
                    if (motionEvent.getAction() == 5 || motionEvent.getAction() == com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW) {
                        MMGestureGallery.this.ccB = 0.0f;
                        MMGestureGallery.this.mSu = MMGestureGallery.this.mSF.getScale();
                        MMGestureGallery.this.mSp = true;
                    }
                    if (motionEvent.getAction() == 2) {
                        float sqrt;
                        if (com.tencent.mm.ui.base.f.O(motionEvent) == 2) {
                            dJN();
                            if (MMGestureGallery.this.yyj || MMGestureGallery.this.yyk || MMGestureGallery.this.yyl) {
                                AppMethodBeat.o(107660);
                                return true;
                            }
                            MMGestureGallery.this.mSp = true;
                            MMGestureGallery.this.count = 0;
                            c = com.tencent.mm.ui.base.f.c(motionEvent, 0) - com.tencent.mm.ui.base.f.c(motionEvent, 1);
                            d = com.tencent.mm.ui.base.f.d(motionEvent, 0) - com.tencent.mm.ui.base.f.d(motionEvent, 1);
                            sqrt = (float) Math.sqrt((double) ((c * c) + (d * d)));
                            if (MMGestureGallery.this.ccB == 0.0f) {
                                MMGestureGallery.this.ccB = sqrt;
                            } else {
                                sqrt /= MMGestureGallery.this.ccB;
                                if (MMGestureGallery.this.mSp) {
                                    MMGestureGallery.this.mSF.k(sqrt * MMGestureGallery.this.mSu, c + com.tencent.mm.ui.base.f.c(motionEvent, 1), com.tencent.mm.ui.base.f.d(motionEvent, 1) + d);
                                }
                            }
                        } else {
                            VelocityTracker f = MMGestureGallery.this.mVelocityTracker;
                            f.computeCurrentVelocity(1000);
                            int xVelocity = (int) f.getXVelocity();
                            int yVelocity = (int) f.getYVelocity();
                            sqrt = motionEvent.getX() - MMGestureGallery.this.aKM;
                            float y = motionEvent.getY() - MMGestureGallery.this.aKN;
                            if (!(MMGestureGallery.this.zFJ == null || MMGestureGallery.this.yyh || MMGestureGallery.this.mSp || MMGestureGallery.this.mSu > MMGestureGallery.this.mSF.getScaleRate())) {
                                MMGestureGallery.this.zFJ.ab(sqrt, y);
                                if ((Math.abs(sqrt) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || MMGestureGallery.this.rvd) && !MMGestureGallery.this.rvb) {
                                    MMGestureGallery.this.rvb = false;
                                } else {
                                    MMGestureGallery.this.zFJ.aa(sqrt, y);
                                    MMGestureGallery.this.rvb = true;
                                }
                                if (y > 200.0f) {
                                    MMGestureGallery.this.rvc = false;
                                } else {
                                    MMGestureGallery.this.rvc = true;
                                }
                            }
                            if (MMGestureGallery.this.mVelocityTracker != null) {
                                MMGestureGallery.this.mVelocityTracker.recycle();
                                MMGestureGallery.this.mVelocityTracker = null;
                            }
                            if (Math.abs(MMGestureGallery.this.mSl - com.tencent.mm.ui.base.f.c(motionEvent, 0)) > 35.0f || Math.abs(MMGestureGallery.this.mSm - com.tencent.mm.ui.base.f.d(motionEvent, 0)) > 35.0f) {
                                dJN();
                                MMGestureGallery.this.count = 0;
                            }
                        }
                    }
                }
                AppMethodBeat.o(107660);
                return false;
            }

            private void qP(boolean z) {
                AppMethodBeat.i(107661);
                MMGestureGallery.this.zFC.D(350, z);
                AppMethodBeat.o(107661);
            }
        });
        AppMethodBeat.o(107685);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107686);
        super.onMeasure(i, i2);
        this.ieu = MeasureSpec.getSize(i);
        this.iev = MeasureSpec.getSize(i2);
        this.mSs.set(0.0f, 0.0f, (float) this.ieu, (float) this.iev);
        ab.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.ieu + " height:" + this.iev);
        AppMethodBeat.o(107686);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(107687);
        if (this.yyi) {
            AppMethodBeat.o(107687);
            return true;
        }
        this.yyj = true;
        if (this.zFH != null) {
            this.zFH.ctp();
        }
        boolean onScroll = super.onScroll(motionEvent, motionEvent2, f, f2);
        AppMethodBeat.o(107687);
        return onScroll;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(107689);
        if (this.mSp || this.rvb) {
            AppMethodBeat.o(107689);
            return true;
        }
        boolean a;
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            View findViewById = selectedView.findViewById(R.id.bm);
            if (findViewById == null || findViewById.getVisibility() == 8) {
                a = a(motionEvent, motionEvent2, f, f2);
                AppMethodBeat.o(107689);
                return a;
            }
            selectedView = findViewById.findViewById(R.id.bl);
            if (selectedView == null) {
                a = a(motionEvent, motionEvent2, f, f2);
                AppMethodBeat.o(107689);
                return a;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            this.mSF = (MultiTouchImageView) selectedView;
            float[] fArr = new float[9];
            this.mSF.getImageMatrix().getValues(fArr);
            float scale = this.mSF.getScale() * ((float) this.mSF.getImageWidth());
            float scale2 = this.mSF.getScale() * ((float) this.mSF.getImageHeight());
            float f3 = fArr[2];
            float f4 = f3 + scale;
            float f5 = fArr[5];
            float f6 = f5 + scale2;
            this.mSF.getGlobalVisibleRect(new Rect());
            if (((int) scale) > this.ieu || ((int) scale2) > this.iev) {
                if (((int) scale) > this.ieu || ((int) scale2) <= this.iev) {
                    if (((int) scale) <= this.ieu || ((int) scale2) > this.iev) {
                        if (Math.abs(f2) > Math.abs(f)) {
                            if (f != 0.0f) {
                                this.yyj = true;
                                if (f < 0.0f) {
                                    if (f3 > this.mSs.left) {
                                        this.mSx = true;
                                    }
                                    if (f3 > this.mSs.left && f4 >= ((float) this.ieu)) {
                                        if (f3 > this.mSs.left && f3 < ((float) this.ieu) * 0.3f) {
                                            f *= 0.3f;
                                        }
                                    }
                                    if (f2 != 0.0f) {
                                        this.yyi = true;
                                        if (f2 < 0.0f) {
                                            if (f5 > this.mSs.top) {
                                                this.mSv = true;
                                            }
                                            if (f5 > this.mSs.top && f6 >= ((float) this.iev)) {
                                                if (f5 > this.mSs.top && f5 < ((float) this.iev) * 0.3f) {
                                                    f2 *= 0.3f;
                                                }
                                            }
                                            this.mSF.aj(-f, -f2);
                                            AppMethodBeat.o(107689);
                                            return true;
                                        }
                                        if (f6 < this.mSs.bottom) {
                                            this.mSw = true;
                                        }
                                        if (f5 <= 0.0f && f6 < ((float) this.iev)) {
                                            if (f6 > ((float) this.iev) * 0.7f && f6 < ((float) this.iev)) {
                                                f2 *= 0.3f;
                                            }
                                        }
                                        this.mSF.aj(-f, -f2);
                                        AppMethodBeat.o(107689);
                                        return true;
                                    }
                                    f2 = 0.0f;
                                    this.mSF.aj(-f, -f2);
                                    AppMethodBeat.o(107689);
                                    return true;
                                }
                                if (f4 < this.mSs.right) {
                                    this.mSy = true;
                                }
                                if (f3 <= 0.0f && f4 < ((float) this.ieu)) {
                                    if (f4 > ((float) this.ieu) * 0.7f && f4 < ((float) this.ieu)) {
                                        f *= 0.3f;
                                    }
                                }
                                if (f2 != 0.0f) {
                                }
                                f2 = 0.0f;
                                this.mSF.aj(-f, -f2);
                                AppMethodBeat.o(107689);
                                return true;
                            }
                            f = 0.0f;
                            if (f2 != 0.0f) {
                            }
                            f2 = 0.0f;
                            this.mSF.aj(-f, -f2);
                            AppMethodBeat.o(107689);
                            return true;
                        } else if (a(f3, f4, selectedView, f)) {
                            AppMethodBeat.o(107689);
                            return true;
                        } else {
                            if (f > 0.0f) {
                                if (f4 <= ((float) this.ieu)) {
                                    a = a(motionEvent, motionEvent2, f, 0.0f);
                                    AppMethodBeat.o(107689);
                                    return a;
                                }
                            } else if (f3 >= 0.0f) {
                                a = a(motionEvent, motionEvent2, f, 0.0f);
                                AppMethodBeat.o(107689);
                                return a;
                            }
                            if (!this.yyj) {
                                this.mSF.aj(-f, -f2);
                            }
                            AppMethodBeat.o(107689);
                            return true;
                        }
                    } else if (a(f3, f4, selectedView, f)) {
                        AppMethodBeat.o(107689);
                        return true;
                    } else {
                        if (f > 0.0f) {
                            if (f4 <= ((float) this.ieu)) {
                                a = a(motionEvent, motionEvent2, f, 0.0f);
                                AppMethodBeat.o(107689);
                                return a;
                            }
                        } else if (f3 >= 0.0f) {
                            a = a(motionEvent, motionEvent2, f, 0.0f);
                            AppMethodBeat.o(107689);
                            return a;
                        }
                        if (!this.yyj) {
                            this.mSF.aj(-f, 0.0f);
                        }
                        AppMethodBeat.o(107689);
                        return true;
                    }
                } else if (Math.abs(f2) > Math.abs(f)) {
                    if (this.yyj || this.yyk || this.yyl) {
                        AppMethodBeat.o(107689);
                        return true;
                    }
                    this.yyi = true;
                    float f7 = 0.0f;
                    float f8 = 0.0f;
                    if (f2 < 0.0f) {
                        if (f5 > this.mSs.top) {
                            this.mSv = true;
                        }
                        if (f5 <= this.mSs.top || f6 < ((float) this.iev)) {
                            f8 = -f2;
                        } else if (f5 > this.mSs.top && f5 < ((float) this.iev) * 0.3f) {
                            f8 = -(0.3f * f2);
                        }
                    } else {
                        if (f6 < this.mSs.bottom) {
                            this.mSw = true;
                        }
                        if (f5 > 0.0f || f6 >= ((float) this.iev)) {
                            f8 = -f2;
                        } else if (f6 > ((float) this.iev) * 0.7f && f6 < ((float) this.iev)) {
                            f8 = -(0.3f * f2);
                        }
                    }
                    if (f < 0.0f && f3 > this.mSs.left) {
                        this.mSx = true;
                        f7 = -(0.3f * f);
                    } else if (f > 0.0f && f4 < this.mSs.right) {
                        this.mSy = true;
                        f7 = -(0.3f * f);
                    }
                    this.mSF.aj(f7, f8);
                    AppMethodBeat.o(107689);
                    return true;
                } else if (a(f3, f4, selectedView, f)) {
                    AppMethodBeat.o(107689);
                    return true;
                } else {
                    if (f > 0.0f) {
                        if (f4 <= ((float) this.ieu)) {
                            if (f4 > ((float) this.ieu) * 0.7f) {
                                a = a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                                AppMethodBeat.o(107689);
                                return a;
                            }
                            a = a(motionEvent, motionEvent2, 0.0f, 0.0f);
                            AppMethodBeat.o(107689);
                            return a;
                        }
                    } else if (f3 >= 0.0f) {
                        if (f3 < ((float) this.ieu) * 0.3f) {
                            a = a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                            AppMethodBeat.o(107689);
                            return a;
                        }
                        a = a(motionEvent, motionEvent2, 0.0f, 0.0f);
                        AppMethodBeat.o(107689);
                        return a;
                    }
                    if (!this.yyj) {
                        this.mSF.aj(-f, 0.0f);
                    }
                    AppMethodBeat.o(107689);
                    return true;
                }
            } else if (a(f3, f4, selectedView, f)) {
                AppMethodBeat.o(107689);
                return true;
            } else {
                if (f > 0.0f) {
                    if (f4 <= ((float) this.ieu)) {
                        a = a(motionEvent, motionEvent2, f, 0.0f);
                        AppMethodBeat.o(107689);
                        return a;
                    }
                } else if (f3 >= 0.0f) {
                    a = a(motionEvent, motionEvent2, f, 0.0f);
                    AppMethodBeat.o(107689);
                    return a;
                }
                if (!this.yyj) {
                    this.mSF.aj(-f, 0.0f);
                }
                AppMethodBeat.o(107689);
                return true;
            }
        }
        a = a(motionEvent, motionEvent2, f, f2);
        AppMethodBeat.o(107689);
        return a;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(107690);
        if (this.mSq != null) {
            this.mSq.forceFinished(true);
        }
        boolean onDown = super.onDown(motionEvent);
        AppMethodBeat.o(107690);
        return onDown;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(107691);
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            selectedView = selectedView.findViewById(R.id.bm);
            if (selectedView == null || selectedView.getVisibility() == 8) {
                a(motionEvent, motionEvent2, f);
                AppMethodBeat.o(107691);
                return false;
            }
            selectedView = selectedView.findViewById(R.id.bl);
            if (selectedView == null) {
                a(motionEvent, motionEvent2, f);
                AppMethodBeat.o(107691);
                return false;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            float scale = multiTouchImageView.getScale() * ((float) multiTouchImageView.getImageWidth());
            float scale2 = multiTouchImageView.getScale() * ((float) multiTouchImageView.getImageHeight());
            if (multiTouchImageView.yzk || multiTouchImageView.yzl || ((int) scale) > this.ieu || ((int) scale2) > this.iev) {
                float f3;
                r4 = new float[9];
                multiTouchImageView.getImageMatrix().getValues(r4);
                float f4 = r4[2];
                float f5 = f4 + scale;
                float f6 = r4[5];
                float f7 = f6 + scale2;
                ab.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(b(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2));
                if (((float) Math.round(f4)) >= this.mSs.left || ((float) Math.round(f5)) <= this.mSs.right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= this.mSs.top || ((float) Math.round(f7)) <= this.mSs.bottom) {
                    f2 = 0.0f;
                }
                if (((float) Math.round(f6)) < this.mSs.top) {
                    this.yyh = true;
                } else {
                    this.yyh = false;
                }
                int i = (int) (this.mSs.right - scale);
                int i2 = (int) (scale + this.mSs.right);
                int i3 = (int) (this.mSs.bottom - scale2);
                int i4 = (int) (this.mSs.bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) this.yym)) {
                        f3 = (float) this.yym;
                    }
                    f6 = f3;
                } else {
                    if (Math.abs(f3) >= ((float) this.yym)) {
                        f3 = (float) (-this.yym);
                    }
                    f6 = f3;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) this.yym)) {
                        f2 = (float) this.yym;
                    }
                } else if (Math.abs(f2) >= ((float) this.yym)) {
                    f2 = (float) (-this.yym);
                }
                this.mSq.forceFinished(true);
                this.mSq.fling(this.mSq.getCurrX(), this.mSq.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!b(motionEvent, motionEvent2) || f4 < 0.0f) && (b(motionEvent, motionEvent2) || f5 > ((float) this.ieu))) {
                    AppMethodBeat.o(107691);
                    return true;
                }
            }
        }
        if (this.mSp) {
            AppMethodBeat.o(107691);
            return true;
        }
        a(motionEvent, motionEvent2, f);
        AppMethodBeat.o(107691);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(107692);
        this.rvd = true;
        super.onLongPress(motionEvent);
        AppMethodBeat.o(107692);
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(107693);
        if (motionEvent.getX() - motionEvent2.getX() < 0.0f) {
            AppMethodBeat.o(107693);
            return true;
        }
        AppMethodBeat.o(107693);
        return false;
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        AppMethodBeat.i(107694);
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b = b(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f) {
            AppMethodBeat.o(107694);
        } else if (x < 60.0f) {
            AppMethodBeat.o(107694);
        } else if (x < y) {
            AppMethodBeat.o(107694);
        } else if (b) {
            onKeyDown(21, null);
            AppMethodBeat.o(107694);
        } else {
            onKeyDown(22, null);
            AppMethodBeat.o(107694);
        }
    }

    public int getScreenWidth() {
        return this.ieu;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(107695);
        this.mSr.onTouchEvent(motionEvent);
        ab.d("dktest", "onTouchEvent event.getAction()" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 1:
                View selectedView = getSelectedView();
                if (selectedView instanceof MultiTouchImageView) {
                    this.mSF = (MultiTouchImageView) selectedView;
                    float scale = this.mSF.getScale() * ((float) this.mSF.getImageWidth());
                    float scale2 = this.mSF.getScale() * ((float) this.mSF.getImageHeight());
                    if (((int) scale) <= this.ieu && ((int) scale2) <= this.iev) {
                        ab.i("dktest", "onTouchEvent width:" + scale + "height:" + scale2);
                        break;
                    }
                    float[] fArr = new float[9];
                    this.mSF.getImageMatrix().getValues(fArr);
                    scale = fArr[5];
                    ab.d("dktest", "onTouchEvent top:" + scale + " height:" + scale2 + " bottom:" + (scale + scale2));
                    break;
                }
                break;
        }
        computeScroll();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(107695);
        return onTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AppMethodBeat.i(107696);
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
        AppMethodBeat.o(107696);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(107697);
        if (z) {
            super.onWindowFocusChanged(z);
        }
        AppMethodBeat.o(107697);
    }

    public void computeScroll() {
        int i = 0;
        AppMethodBeat.i(107698);
        if (this.mSF == null) {
            AppMethodBeat.o(107698);
            return;
        }
        if (this.mSq.computeScrollOffset()) {
            int currX = this.mSq.getCurrX() - this.apF;
            int currY = this.mSq.getCurrY() - this.apG;
            this.apF = this.mSq.getCurrX();
            this.apG = this.mSq.getCurrY();
            float scale = this.mSF.getScale() * ((float) this.mSF.getImageWidth());
            float scale2 = this.mSF.getScale() * ((float) this.mSF.getImageHeight());
            float[] fArr = new float[9];
            this.mSF.getImageMatrix().getValues(fArr);
            float f = fArr[2];
            scale += f;
            float f2 = fArr[5];
            float f3 = f2 + scale2;
            if (currX < 0 && ((float) currX) < this.mSs.right - ((float) Math.round(scale))) {
                currX = (int) (this.mSs.right - ((float) Math.round(scale)));
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
            if (((float) Math.round(f)) >= this.mSs.left || ((float) Math.round(scale)) <= this.mSs.right) {
                currX = 0;
            } else if (((float) Math.round(f2)) >= this.mSs.top || ((float) Math.round(f3)) <= this.mSs.bottom) {
                currY = 0;
            }
            if (scale2 >= ((float) this.iev)) {
                i = currY;
            }
            this.mSF.aj((float) currX, (float) i);
            postInvalidate();
        }
        AppMethodBeat.o(107698);
    }

    public boolean isFocused() {
        return true;
    }

    public int getXDown() {
        return (int) this.aKM;
    }

    public int getYDown() {
        return (int) this.aKN;
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        AppMethodBeat.i(107688);
        if (this.yyj || this.yyi) {
            z = false;
        } else {
            if (getPositionForView(view) == getAdapter().getCount() - 1) {
                if (this.yyl) {
                    if (f3 > 0.0f) {
                        if (f2 >= ((float) this.ieu)) {
                            this.mSF.aj(-f3, 0.0f);
                        } else if (f2 > ((float) this.ieu) * 0.7f && f2 < ((float) this.iev)) {
                            this.mSF.aj(-(f3 * 0.3f), 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 > 0.0f) {
                    if (f2 < ((float) this.ieu)) {
                        this.yyl = true;
                    }
                    if (f2 >= ((float) this.ieu)) {
                        this.mSF.aj(-f3, 0.0f);
                    } else if (f2 > ((float) this.ieu) * 0.7f && f2 < ((float) this.iev)) {
                        this.mSF.aj(-(f3 * 0.3f), 0.0f);
                    }
                    z = true;
                }
            }
            this.yyl = false;
            z = false;
        }
        if (z) {
            AppMethodBeat.o(107688);
            return true;
        }
        if (this.yyj || this.yyi) {
            z = false;
        } else {
            if (getPositionForView(view) == 0) {
                if (this.yyk) {
                    if (f3 < 0.0f) {
                        if (f > 0.0f && f < ((float) this.ieu) * 0.3f) {
                            this.mSF.aj(-(f3 * 0.3f), 0.0f);
                        } else if (f <= 0.0f) {
                            this.mSF.aj(-f3, 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.yyk = true;
                    }
                    if (f > 0.0f && f < ((float) this.ieu) * 0.3f) {
                        this.mSF.aj(-(f3 * 0.3f), 0.0f);
                    } else if (f <= 0.0f) {
                        this.mSF.aj(-f3, 0.0f);
                    }
                    z = true;
                }
            }
            this.yyk = false;
            z = false;
        }
        if (z) {
            AppMethodBeat.o(107688);
            return true;
        }
        AppMethodBeat.o(107688);
        return false;
    }

    static /* synthetic */ void z(MMGestureGallery mMGestureGallery) {
        AppMethodBeat.i(107699);
        mMGestureGallery.bCP();
        mMGestureGallery.zFB.j(1, 15, 15);
        AppMethodBeat.o(107699);
    }
}
