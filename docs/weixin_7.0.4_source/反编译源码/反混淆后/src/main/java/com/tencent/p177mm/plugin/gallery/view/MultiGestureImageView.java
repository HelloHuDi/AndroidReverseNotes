package com.tencent.p177mm.plugin.gallery.view;

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
import com.tencent.p177mm.p612ui.base.C46631f;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView */
public class MultiGestureImageView extends LinearLayout {
    private int apF;
    private int apG;
    private float ccB;
    private int count = 0;
    private int ieu;
    private int iev;
    private C43153j mSA;
    private C43153j mSB;
    private C43152d mSC;
    private C39181b mSD;
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
    private C45982a mSt;
    private float mSu;
    private boolean mSv = false;
    private boolean mSw = false;
    private boolean mSx = false;
    private boolean mSy = false;
    private C43153j mSz;

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$e */
    class C20923e extends C45982a {
        MultiTouchImageView mSF;
        /* renamed from: v */
        float[] f4379v = new float[9];

        /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$e$1 */
        class C32181 implements Runnable {
            C32181() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21621);
                C20923e.this.mSF.getImageMatrix().getValues(C20923e.this.f4379v);
                float imageHeight = ((float) C20923e.this.mSF.getImageHeight()) * C20923e.this.mSF.getScale();
                float f = C20923e.this.f4379v[5] + imageHeight;
                float i = (float) MultiGestureImageView.this.iev;
                if (imageHeight < ((float) MultiGestureImageView.this.iev)) {
                    i = (((float) MultiGestureImageView.this.iev) / 2.0f) + (imageHeight / 2.0f);
                }
                i -= f;
                if (i <= 0.0f) {
                    C20923e.this.cco = true;
                } else if (Math.abs(i) <= 5.0f) {
                    C20923e.this.cco = true;
                } else {
                    i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
                }
                C20923e.this.mSF.mo10843aj(0.0f, i);
                AppMethodBeat.m2505o(21621);
            }
        }

        public C20923e(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.m2504i(21622);
            this.mSF = multiTouchImageView;
            AppMethodBeat.m2505o(21622);
        }

        public final void play() {
            AppMethodBeat.m2504i(21623);
            MultiGestureImageView.this.mSi.getHandler().post(new C32181());
            AppMethodBeat.m2505o(21623);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$g */
    class C20924g extends C45982a {
        MultiTouchImageView mSF;
        /* renamed from: v */
        float[] f4380v = new float[9];

        /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$g$1 */
        class C209251 implements Runnable {
            C209251() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21627);
                C20924g.this.mSF.getImageMatrix().getValues(C20924g.this.f4380v);
                float f = C20924g.this.f4380v[2];
                float scale = C20924g.this.mSF.getScale() * ((float) C20924g.this.mSF.getImageWidth());
                if (scale < ((float) MultiGestureImageView.this.ieu)) {
                    scale = (((float) MultiGestureImageView.this.ieu) / 2.0f) - (scale / 2.0f);
                } else {
                    scale = 0.0f;
                }
                scale -= f;
                if (scale >= 0.0f) {
                    C20924g.this.cco = true;
                } else if (Math.abs(scale) <= 5.0f) {
                    C20924g.this.cco = true;
                } else {
                    scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                }
                C20924g.this.mSF.mo10843aj(scale, 0.0f);
                AppMethodBeat.m2505o(21627);
            }
        }

        public C20924g(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.m2504i(21628);
            this.mSF = multiTouchImageView;
            AppMethodBeat.m2505o(21628);
        }

        public final void play() {
            AppMethodBeat.m2504i(21629);
            MultiGestureImageView.this.mSi.getHandler().post(new C209251());
            AppMethodBeat.m2505o(21629);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$i */
    class C20927i extends C45982a {
        MultiTouchImageView mSF;
        /* renamed from: v */
        float[] f4381v = new float[9];

        /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$i$1 */
        class C209261 implements Runnable {
            C209261() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21633);
                C20927i.this.mSF.getImageMatrix().getValues(C20927i.this.f4381v);
                float f = C20927i.this.f4381v[5];
                float scale = C20927i.this.mSF.getScale() * ((float) C20927i.this.mSF.getImageHeight());
                if (scale < ((float) MultiGestureImageView.this.iev)) {
                    scale = (((float) MultiGestureImageView.this.iev) / 2.0f) - (scale / 2.0f);
                } else {
                    scale = 0.0f;
                }
                scale -= f;
                if (scale >= 0.0f) {
                    C20927i.this.cco = true;
                } else if (Math.abs(scale) <= 5.0f) {
                    C20927i.this.cco = true;
                } else {
                    scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                }
                C20927i.this.mSF.mo10843aj(0.0f, scale);
                AppMethodBeat.m2505o(21633);
            }
        }

        public C20927i(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.m2504i(21634);
            this.mSF = multiTouchImageView;
            AppMethodBeat.m2505o(21634);
        }

        public final void play() {
            AppMethodBeat.m2504i(21635);
            MultiGestureImageView.this.mSi.getHandler().post(new C209261());
            AppMethodBeat.m2505o(21635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$f */
    class C28173f extends C45982a {
        MultiTouchImageView mSF;
        /* renamed from: v */
        float[] f13695v = new float[9];

        /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$f$1 */
        class C281741 implements Runnable {
            C281741() {
            }

            public final void run() {
                float g;
                AppMethodBeat.m2504i(21624);
                C28173f.this.mSF.getImageMatrix().getValues(C28173f.this.f13695v);
                float scale = C28173f.this.mSF.getScale() * ((float) C28173f.this.mSF.getImageWidth());
                float imageHeight = ((float) C28173f.this.mSF.getImageHeight()) * C28173f.this.mSF.getScale();
                float f = C28173f.this.f13695v[2];
                float f2 = C28173f.this.f13695v[5];
                float f3 = C28173f.this.f13695v[2] + scale;
                float f4 = C28173f.this.f13695v[5] + imageHeight;
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
                    C28173f.this.cco = true;
                }
                C28173f.this.mSF.mo10843aj(imageHeight, i);
                AppMethodBeat.m2505o(21624);
            }
        }

        public C28173f(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.m2504i(21625);
            this.mSF = multiTouchImageView;
            AppMethodBeat.m2505o(21625);
        }

        public final void play() {
            AppMethodBeat.m2504i(21626);
            MultiGestureImageView.this.mSi.getHandler().post(new C281741());
            AppMethodBeat.m2505o(21626);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$h */
    class C34258h extends C45982a {
        MultiTouchImageView mSF;
        /* renamed from: v */
        float[] f15048v = new float[9];

        /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$h$1 */
        class C342591 implements Runnable {
            C342591() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21630);
                C34258h.this.mSF.getImageMatrix().getValues(C34258h.this.f15048v);
                float imageWidth = ((float) C34258h.this.mSF.getImageWidth()) * C34258h.this.mSF.getScale();
                float f = C34258h.this.f15048v[2] + imageWidth;
                float g = (float) MultiGestureImageView.this.ieu;
                if (imageWidth < ((float) MultiGestureImageView.this.ieu)) {
                    g = (((float) MultiGestureImageView.this.ieu) / 2.0f) + (imageWidth / 2.0f);
                }
                g -= f;
                if (g <= 0.0f) {
                    C34258h.this.cco = true;
                } else if (Math.abs(g) <= 5.0f) {
                    C34258h.this.cco = true;
                } else {
                    g = ((float) (((double) Math.abs(g)) - Math.pow(Math.sqrt((double) Math.abs(g)) - 1.0d, 2.0d))) * 2.0f;
                }
                C34258h.this.mSF.mo10843aj(g, 0.0f);
                AppMethodBeat.m2505o(21630);
            }
        }

        public C34258h(MultiTouchImageView multiTouchImageView) {
            super();
            AppMethodBeat.m2504i(21631);
            this.mSF = multiTouchImageView;
            AppMethodBeat.m2505o(21631);
        }

        public final void play() {
            AppMethodBeat.m2504i(21632);
            MultiGestureImageView.this.mSi.getHandler().post(new C342591());
            AppMethodBeat.m2505o(21632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$b */
    public interface C39181b {
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$c */
    class C43151c extends SimpleOnGestureListener {
        private C43151c() {
        }

        /* synthetic */ C43151c(MultiGestureImageView multiGestureImageView, byte b) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$d */
    public interface C43152d {
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$j */
    public class C43153j extends C7306ak {
        WeakReference<MultiGestureImageView> aIp;
        boolean cOV;
        private long mSL;

        public C43153j(WeakReference<MultiGestureImageView> weakReference) {
            this.aIp = weakReference;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(21638);
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.aIp != null) {
                final MultiGestureImageView multiGestureImageView = (MultiGestureImageView) this.aIp.get();
                if (multiGestureImageView != null) {
                    if (message.what == 0) {
                        if (multiGestureImageView.count == 1 || this.cOV) {
                            C4990ab.m7410d("MicroMsg.MuitlGestureImageView", "single click over!");
                            if (multiGestureImageView.mSC != null) {
                                multiGestureImageView.getHandler().post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(21636);
                                        multiGestureImageView.mSC;
                                        AppMethodBeat.m2505o(21636);
                                    }
                                });
                            }
                        }
                        MultiGestureImageView.this.count = 0;
                        AppMethodBeat.m2505o(21638);
                        return;
                    } else if (message.what != 1) {
                        removeMessages(2);
                        if (multiGestureImageView.mSD != null) {
                            multiGestureImageView.getHandler().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(21637);
                                    multiGestureImageView.mSD;
                                    AppMethodBeat.m2505o(21637);
                                }
                            });
                        }
                    } else if (MultiGestureImageView.this.mSt == null || MultiGestureImageView.this.mSt.bCR()) {
                        MultiGestureImageView.m85424e(multiGestureImageView);
                        AppMethodBeat.m2505o(21638);
                        return;
                    } else {
                        MultiGestureImageView.this.mSt.play();
                        sendEmptyMessageDelayed(message.what, this.mSL);
                        AppMethodBeat.m2505o(21638);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(21638);
        }

        /* renamed from: j */
        public final void mo68674j(int i, long j, long j2) {
            AppMethodBeat.m2504i(21639);
            this.mSL = j2;
            sendEmptyMessageDelayed(i, j);
            AppMethodBeat.m2505o(21639);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.view.MultiGestureImageView$a */
    abstract class C45982a {
        protected boolean cco = false;

        public abstract void play();

        public final boolean bCR() {
            return this.cco;
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m85424e(MultiGestureImageView multiGestureImageView) {
        AppMethodBeat.m2504i(21654);
        multiGestureImageView.bCP();
        AppMethodBeat.m2505o(21654);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(21640);
        init(context, attributeSet);
        AppMethodBeat.m2505o(21640);
    }

    public MultiGestureImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(21641);
        init(context, attributeSet);
        AppMethodBeat.m2505o(21641);
    }

    public void setSingleClickOverListener(C43152d c43152d) {
        this.mSC = c43152d;
    }

    public void setLongClickOverListener(C39181b c39181b) {
        this.mSD = c39181b;
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(21642);
        this.mSi = new MultiTouchImageView(context, attributeSet);
        this.mSr = new GestureDetector(context, new C43151c(this, (byte) 0));
        this.mSq = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.mSi.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.mSi);
        this.mSz = new C43153j(new WeakReference(this));
        this.mSA = new C43153j(new WeakReference(this));
        this.mSB = new C43153j(new WeakReference(this));
        AppMethodBeat.m2505o(21642);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(21643);
        super.onMeasure(i, i2);
        this.ieu = MeasureSpec.getSize(i);
        this.iev = MeasureSpec.getSize(i2);
        this.mSs.set(0.0f, 0.0f, (float) this.ieu, (float) this.iev);
        C4990ab.m7418v("MicroMsg.MuitlGestureImageView", "MMGestureGallery width:" + this.ieu + " height:" + this.iev);
        AppMethodBeat.m2505o(21643);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(21644);
        this.mSr.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.mSq.forceFinished(true);
            this.mSB.removeMessages(2);
            this.mSB.mo68674j(2, 500, 0);
            this.mSi.dzB();
            this.count++;
            if (this.count == 1) {
                this.mSj = System.currentTimeMillis();
                this.mSl = C46631f.m88235c(motionEvent, 0);
                this.mSm = C46631f.m88237d(motionEvent, 0);
            } else if (this.count == 2) {
                this.mSn = System.currentTimeMillis();
                if (this.mSn - this.mSk >= 350) {
                    this.count = 1;
                } else if (Math.abs(this.mSl - C46631f.m88235c(motionEvent, 0)) >= 35.0f || Math.abs(this.mSm - C46631f.m88237d(motionEvent, 0)) >= 35.0f) {
                    this.count = 1;
                } else {
                    this.count = 0;
                    C4990ab.m7410d("MicroMsg.MuitlGestureImageView", "double click!");
                    if (this.mSi.getScale() <= this.mSi.getScaleRate()) {
                        this.mSi.mo10842ai(C46631f.m88235c(motionEvent, 0), C46631f.m88237d(motionEvent, 0));
                    } else {
                        this.mSi.mo10841ah(C46631f.m88235c(motionEvent, 0), C46631f.m88237d(motionEvent, 0));
                        this.mSi.dAp();
                    }
                }
            }
        }
        if (motionEvent.getAction() == 6 || motionEvent.getAction() == C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM) {
            this.mSB.removeMessages(2);
            this.ccB = 0.0f;
            this.mSu = this.mSi.getScale();
            this.mSp = true;
            if (this.mSu < this.mSi.getScaleRate()) {
                this.mSi.mo10841ah((C46631f.m88235c(motionEvent, 0) - C46631f.m88235c(motionEvent, 1)) + C46631f.m88235c(motionEvent, 1), (C46631f.m88237d(motionEvent, 0) - C46631f.m88237d(motionEvent, 1)) + C46631f.m88237d(motionEvent, 1));
            }
            if (this.mSu > this.mSi.getDoubleTabScale()) {
                this.mSi.mo10842ai((C46631f.m88235c(motionEvent, 0) - C46631f.m88235c(motionEvent, 1)) + C46631f.m88235c(motionEvent, 1), (C46631f.m88237d(motionEvent, 0) - C46631f.m88237d(motionEvent, 1)) + C46631f.m88237d(motionEvent, 1));
            }
        }
        if (motionEvent.getAction() == 1) {
            this.mSB.removeMessages(2);
            if ((this.mSx || this.mSy) && (this.mSv || this.mSw)) {
                this.mSt = new C28173f(this.mSi);
                bCQ();
                this.mSx = false;
                this.mSy = false;
                this.mSv = false;
                this.mSw = false;
            } else {
                if (this.mSx) {
                    this.mSx = false;
                    this.mSt = new C20924g(this.mSi);
                    bCQ();
                }
                if (this.mSy) {
                    this.mSy = false;
                    this.mSt = new C34258h(this.mSi);
                    bCQ();
                }
                if (this.mSv) {
                    this.mSv = false;
                    this.mSt = new C20927i(this.mSi);
                    bCQ();
                }
                if (this.mSw) {
                    this.mSw = false;
                    this.mSt = new C20923e(this.mSi);
                    bCQ();
                }
            }
            this.ccB = 0.0f;
            this.mSu = this.mSi.getScale();
            if (this.count == 1) {
                this.mSk = System.currentTimeMillis();
                if (this.mSk - this.mSj >= 350) {
                    this.count = 0;
                    C4990ab.m7410d("MicroMsg.MuitlGestureImageView", "single long click over!");
                } else if (Math.abs(this.mSl - C46631f.m88235c(motionEvent, 0)) < 10.0f && Math.abs(this.mSm - C46631f.m88237d(motionEvent, 0)) < 10.0f) {
                    C43153j c43153j = this.mSA;
                    c43153j.cOV = false;
                    c43153j.mo68674j(0, 350, 0);
                }
            }
        }
        if (motionEvent.getAction() == 5 || motionEvent.getAction() == C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW) {
            this.ccB = 0.0f;
            this.mSu = this.mSi.getScale();
            this.mSp = true;
        }
        if (motionEvent.getAction() == 2) {
            if (C46631f.m88232O(motionEvent) == 2) {
                this.mSB.removeMessages(2);
                this.mSp = true;
                this.count = 0;
                float c = C46631f.m88235c(motionEvent, 0) - C46631f.m88235c(motionEvent, 1);
                float d = C46631f.m88237d(motionEvent, 0) - C46631f.m88237d(motionEvent, 1);
                float sqrt = (float) Math.sqrt((double) ((c * c) + (d * d)));
                if (this.ccB == 0.0f) {
                    this.ccB = sqrt;
                } else {
                    sqrt /= this.ccB;
                    if (this.mSp) {
                        this.mSi.mo10861k(sqrt * this.mSu, c + C46631f.m88235c(motionEvent, 1), d + C46631f.m88237d(motionEvent, 1));
                    }
                }
            } else if (Math.abs(this.mSl - C46631f.m88235c(motionEvent, 0)) > 10.0f || Math.abs(this.mSm - C46631f.m88237d(motionEvent, 0)) > 10.0f) {
                this.mSB.removeMessages(2);
                this.count = 0;
                computeScroll();
            }
        }
        AppMethodBeat.m2505o(21644);
        return true;
    }

    public void computeScroll() {
        int i = 0;
        AppMethodBeat.m2504i(21645);
        if (this.mSi == null) {
            AppMethodBeat.m2505o(21645);
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
            this.mSi.mo10843aj((float) currX, (float) i);
            postInvalidate();
        }
        AppMethodBeat.m2505o(21645);
    }

    private void bCP() {
        AppMethodBeat.m2504i(21646);
        this.mSz.removeMessages(1);
        AppMethodBeat.m2505o(21646);
    }

    private void bCQ() {
        AppMethodBeat.m2504i(21647);
        bCP();
        this.mSz.mo68674j(1, 15, 15);
        AppMethodBeat.m2505o(21647);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        AppMethodBeat.m2504i(21648);
        this.mSi.setEnableHorLongBmpMode(z);
        AppMethodBeat.m2505o(21648);
    }

    public int getImageWidth() {
        AppMethodBeat.m2504i(21649);
        int imageWidth = this.mSi.getImageWidth();
        AppMethodBeat.m2505o(21649);
        return imageWidth;
    }

    public void setImageWidth(int i) {
        AppMethodBeat.m2504i(21650);
        this.mSi.setImageWidth(i);
        AppMethodBeat.m2505o(21650);
    }

    public int getImageHeight() {
        AppMethodBeat.m2504i(21651);
        int imageHeight = this.mSi.getImageHeight();
        AppMethodBeat.m2505o(21651);
        return imageHeight;
    }

    public void setImageHeight(int i) {
        AppMethodBeat.m2504i(21652);
        this.mSi.setImageHeight(i);
        AppMethodBeat.m2505o(21652);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(21653);
        this.mSi.setImageBitmap(bitmap);
        this.mSi.dzA();
        AppMethodBeat.m2505o(21653);
    }
}
