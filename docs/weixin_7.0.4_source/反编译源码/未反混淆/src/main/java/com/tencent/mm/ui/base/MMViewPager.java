package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager extends WxViewPager {
    private float aKM = 0.0f;
    private float aKN = 0.0f;
    private int aaF = -1;
    private int alh = -1;
    private int apF;
    private int apG;
    private float ccB;
    private ak handler = new ak(Looper.getMainLooper());
    private GestureDetector iay;
    private int ieu;
    private int iev;
    private OnTouchListener jZu;
    private boolean mSp = false;
    private OverScroller mSq;
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
    private g yye;
    private WxImageView yyf;
    private k yyg;
    private boolean yyh = false;
    private boolean yyi = false;
    private boolean yyj = false;
    private boolean yyk = false;
    private boolean yyl = false;
    private int yym = 0;
    private a yyn;
    private e yyo;
    private c yyp;
    private OnPageChangeListener yyq = null;
    private float yyr = 0.0f;
    private float yys;
    private float yyt;
    private VelocityTracker yyu = null;
    private MotionEvent yyv;
    private long yyw = 0;
    private b yyx;
    private SimpleOnGestureListener yyy = new d(this, (byte) 0);
    private OnLongClickListener yyz = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(106899);
            if (MMViewPager.this.yyp != null) {
                MMViewPager.this.yyp.bvE();
            }
            AppMethodBeat.o(106899);
            return true;
        }
    };

    public interface e {
        void bCN();

        void bcX();
    }

    public interface c {
        void bvE();
    }

    public interface b {
        void aa(float f, float f2);

        void ab(float f, float f2);
    }

    class d extends SimpleOnGestureListener {
        private d() {
        }

        /* synthetic */ d(MMViewPager mMViewPager, byte b) {
            this();
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(106900);
            if (MMViewPager.this.yyo != null) {
                MMViewPager.this.yyo.bcX();
            }
            AppMethodBeat.o(106900);
            return true;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(106901);
            if (MMViewPager.this.mSq != null) {
                MMViewPager.this.mSq.forceFinished(true);
            }
            boolean onDown = super.onDown(motionEvent);
            AppMethodBeat.o(106901);
            return onDown;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(106902);
            MMViewPager.this.rvd = true;
            if (MMViewPager.this.yyp != null) {
                MMViewPager.this.yyp.bvE();
            }
            AppMethodBeat.o(106902);
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(106903);
            if (MMViewPager.this.yye == null) {
                AppMethodBeat.o(106903);
                return false;
            }
            if (MMViewPager.this.yye.getScale() <= MMViewPager.this.yye.getScaleRate()) {
                MMViewPager.this.yye.ai(f.c(motionEvent, 0), f.d(motionEvent, 0));
            } else {
                MMViewPager.this.yye.ah(f.c(motionEvent, 0), f.d(motionEvent, 0));
            }
            AppMethodBeat.o(106903);
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(106904);
            ab.d("MicroMsg.MMViewPager", "onFling");
            g selectedImageView = MMViewPager.this.getSelectedImageView();
            if (selectedImageView != null) {
                ab.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
                if (selectedImageView instanceof MultiTouchImageView) {
                    selectedImageView = (MultiTouchImageView) selectedImageView;
                } else if (selectedImageView instanceof WxImageView) {
                    WxImageView selectedImageView2 = (WxImageView) selectedImageView2;
                }
                float scale = selectedImageView2.getScale() * ((float) selectedImageView2.getImageWidth());
                float scale2 = selectedImageView2.getScale() * ((float) selectedImageView2.getImageHeight());
                if (selectedImageView2.dzy() || selectedImageView2.dzz() || ((int) scale) > MMViewPager.this.ieu || ((int) scale2) > MMViewPager.this.iev) {
                    float f3;
                    r6 = new float[9];
                    selectedImageView2.getImageMatrix().getValues(r6);
                    float f4 = r6[2];
                    float f5 = f4 + scale;
                    float f6 = r6[5];
                    float f7 = f6 + scale2;
                    ab.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.c(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2));
                    if (((float) Math.round(f4)) >= MMViewPager.this.mSs.left || ((float) Math.round(f5)) <= MMViewPager.this.mSs.right) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (((float) Math.round(f6)) >= MMViewPager.this.mSs.top || ((float) Math.round(f7)) <= MMViewPager.this.mSs.bottom) {
                        f2 = 0.0f;
                    }
                    int i = (int) (MMViewPager.this.mSs.right - scale);
                    int i2 = (int) (scale + MMViewPager.this.mSs.right);
                    int i3 = (int) (MMViewPager.this.mSs.bottom - scale2);
                    int i4 = (int) (MMViewPager.this.mSs.bottom + scale2);
                    if (f3 >= 0.0f) {
                        if (Math.abs(f3) >= ((float) MMViewPager.this.yym)) {
                            f3 = (float) MMViewPager.this.yym;
                        }
                        f6 = f3;
                    } else {
                        if (Math.abs(f3) >= ((float) MMViewPager.this.yym)) {
                            f3 = (float) (-MMViewPager.this.yym);
                        }
                        f6 = f3;
                    }
                    if (f2 >= 0.0f) {
                        if (Math.abs(f2) >= ((float) MMViewPager.this.yym)) {
                            f2 = (float) MMViewPager.this.yym;
                        }
                    } else if (Math.abs(f2) >= ((float) MMViewPager.this.yym)) {
                        f2 = (float) (-MMViewPager.this.yym);
                    }
                    MMViewPager.this.mSq.fling(MMViewPager.this.mSq.getCurrX(), MMViewPager.this.mSq.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                    if ((!MMViewPager.c(motionEvent, motionEvent2) || f4 < 0.0f) && (MMViewPager.c(motionEvent, motionEvent2) || f5 > ((float) MMViewPager.this.ieu))) {
                        AppMethodBeat.o(106904);
                        return false;
                    }
                }
            }
            if (MMViewPager.this.mSp) {
                AppMethodBeat.o(106904);
                return false;
            }
            boolean a = MMViewPager.a(MMViewPager.this, motionEvent, motionEvent2, f);
            AppMethodBeat.o(106904);
            return a;
        }
    }

    public static class k extends ak {
        long mSL;
        WeakReference<MMViewPager> yyI;

        public k(WeakReference<MMViewPager> weakReference) {
            this.yyI = weakReference;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(106920);
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.yyI != null) {
                MMViewPager mMViewPager = (MMViewPager) this.yyI.get();
                if (mMViewPager != null && message.what == 1) {
                    if (mMViewPager.yyn == null || mMViewPager.yyn.bCR()) {
                        MMViewPager.w(mMViewPager);
                    } else {
                        mMViewPager.yyn.play();
                        sendEmptyMessageDelayed(message.what, this.mSL);
                        AppMethodBeat.o(106920);
                        return;
                    }
                }
            }
            AppMethodBeat.o(106920);
        }
    }

    abstract class a {
        protected boolean cco = false;

        public abstract void play();

        public final boolean bCR() {
            return this.cco;
        }
    }

    class h extends a {
        float[] v = new float[9];

        public h() {
            super();
            AppMethodBeat.i(106912);
            AppMethodBeat.o(106912);
        }

        public final void play() {
            AppMethodBeat.i(106913);
            MMViewPager.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106911);
                    MMViewPager.this.yye.getImageMatrix().getValues(h.this.v);
                    float f = h.this.v[2];
                    float scale = MMViewPager.this.yye.getScale() * ((float) MMViewPager.this.yye.getImageWidth());
                    if (scale < ((float) MMViewPager.this.ieu)) {
                        scale = (((float) MMViewPager.this.ieu) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        scale = -((WxImageView) MMViewPager.this.yye).getTranslationX();
                    }
                    if (scale >= 0.0f) {
                        h.this.cco = true;
                        f = scale;
                    } else if (Math.abs(scale) <= 5.0f) {
                        h.this.cco = true;
                        f = scale;
                    } else {
                        f = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    MMViewPager.this.yye.aj(f, 0.0f);
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.yye).translate(f, 0.0f);
                    }
                    AppMethodBeat.o(106911);
                }
            });
            AppMethodBeat.o(106913);
        }
    }

    class j extends a {
        float[] v = new float[9];

        public j() {
            super();
            AppMethodBeat.i(106918);
            AppMethodBeat.o(106918);
        }

        public final void play() {
            AppMethodBeat.i(106919);
            MMViewPager.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106917);
                    MMViewPager.this.yye.getImageMatrix().getValues(j.this.v);
                    float f = j.this.v[5];
                    float scale = MMViewPager.this.yye.getScale() * ((float) MMViewPager.this.yye.getImageHeight());
                    if (scale < ((float) MMViewPager.this.iev)) {
                        scale = (((float) MMViewPager.this.iev) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        scale = -((WxImageView) MMViewPager.this.yye).getTranslationY();
                    }
                    if (scale >= 0.0f) {
                        j.this.cco = true;
                        f = scale;
                    } else if (Math.abs(scale) <= 5.0f) {
                        j.this.cco = true;
                        f = scale;
                    } else {
                        f = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    MMViewPager.this.yye.aj(0.0f, f);
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.yye).translate(0.0f, f);
                    }
                    AppMethodBeat.o(106917);
                }
            });
            AppMethodBeat.o(106919);
        }
    }

    class f extends a {
        float[] v = new float[9];

        public f() {
            super();
            AppMethodBeat.i(106906);
            AppMethodBeat.o(106906);
        }

        public final void play() {
            AppMethodBeat.i(106907);
            MMViewPager.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106905);
                    MMViewPager.this.yye.getImageMatrix().getValues(f.this.v);
                    float imageHeight = ((float) MMViewPager.this.yye.getImageHeight()) * MMViewPager.this.yye.getScale();
                    float f = f.this.v[5] + imageHeight;
                    float d = (float) MMViewPager.this.iev;
                    if (imageHeight < ((float) MMViewPager.this.iev)) {
                        d = (((float) MMViewPager.this.iev) / 2.0f) + (imageHeight / 2.0f);
                    }
                    d -= f;
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        d = -((WxImageView) MMViewPager.this.yye).getTranslationY();
                    }
                    if (d <= 0.0f) {
                        f.this.cco = true;
                        imageHeight = d;
                    } else if (Math.abs(d) <= 5.0f) {
                        f.this.cco = true;
                        imageHeight = d;
                    } else {
                        imageHeight = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMViewPager.this.yye.aj(0.0f, imageHeight);
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.yye).translate(0.0f, imageHeight);
                    }
                    AppMethodBeat.o(106905);
                }
            });
            AppMethodBeat.o(106907);
        }
    }

    class g extends a {
        float[] v = new float[9];

        public g() {
            super();
            AppMethodBeat.i(106909);
            AppMethodBeat.o(106909);
        }

        public final void play() {
            AppMethodBeat.i(106910);
            MMViewPager.this.handler.post(new Runnable() {
                public final void run() {
                    float b;
                    AppMethodBeat.i(106908);
                    MMViewPager.this.yye.getImageMatrix().getValues(g.this.v);
                    float scale = MMViewPager.this.yye.getScale() * ((float) MMViewPager.this.yye.getImageWidth());
                    float imageHeight = ((float) MMViewPager.this.yye.getImageHeight()) * MMViewPager.this.yye.getScale();
                    float f = g.this.v[2];
                    float f2 = g.this.v[5];
                    float f3 = g.this.v[2] + scale;
                    float f4 = g.this.v[5] + imageHeight;
                    float f5 = 0.0f;
                    float d = (float) MMViewPager.this.iev;
                    float f6 = 0.0f;
                    float b2 = (float) MMViewPager.this.ieu;
                    if (imageHeight < ((float) MMViewPager.this.iev)) {
                        f5 = (((float) MMViewPager.this.iev) / 2.0f) - (imageHeight / 2.0f);
                        imageHeight = (((float) MMViewPager.this.iev) / 2.0f) + (imageHeight / 2.0f);
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
                    if (scale < ((float) MMViewPager.this.ieu)) {
                        b = (((float) MMViewPager.this.ieu) / 2.0f) + (scale / 2.0f);
                        f6 = (((float) MMViewPager.this.ieu) / 2.0f) - (scale / 2.0f);
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
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        imageHeight = ((WxImageView) MMViewPager.this.yye).getTranslationX();
                        d = ((WxImageView) MMViewPager.this.yye).getTranslationY();
                    }
                    if (Math.abs(imageHeight) > 5.0f || Math.abs(d) > 5.0f) {
                        if (imageHeight >= 0.0f) {
                            imageHeight = ((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            imageHeight = (-((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (d >= 0.0f) {
                            b = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            b = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        g.this.cco = true;
                        b = d;
                    }
                    MMViewPager.this.yye.aj(imageHeight, b);
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.yye).translate(-imageHeight, -b);
                    }
                    AppMethodBeat.o(106908);
                }
            });
            AppMethodBeat.o(106910);
        }
    }

    class i extends a {
        float[] v = new float[9];

        public i() {
            super();
            AppMethodBeat.i(106915);
            AppMethodBeat.o(106915);
        }

        public final void play() {
            AppMethodBeat.i(106916);
            MMViewPager.this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106914);
                    MMViewPager.this.yye.getImageMatrix().getValues(i.this.v);
                    float imageWidth = ((float) MMViewPager.this.yye.getImageWidth()) * MMViewPager.this.yye.getScale();
                    float f = i.this.v[2] + imageWidth;
                    float b = (float) MMViewPager.this.ieu;
                    if (imageWidth < ((float) MMViewPager.this.ieu)) {
                        b = (((float) MMViewPager.this.ieu) / 2.0f) + (imageWidth / 2.0f);
                    }
                    b -= f;
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        b = -((WxImageView) MMViewPager.this.yye).getTranslationX();
                    }
                    if (b <= 0.0f) {
                        i.this.cco = true;
                        imageWidth = b;
                    } else if (Math.abs(b) <= 5.0f) {
                        i.this.cco = true;
                        imageWidth = b;
                    } else {
                        imageWidth = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    MMViewPager.this.yye.aj(imageWidth, 0.0f);
                    if (MMViewPager.this.yye instanceof WxImageView) {
                        ((WxImageView) MMViewPager.this.yye).translate(imageWidth, 0.0f);
                    }
                    AppMethodBeat.o(106914);
                }
            });
            AppMethodBeat.o(106916);
        }
    }

    static /* synthetic */ boolean g(MMViewPager mMViewPager) {
        AppMethodBeat.i(106946);
        boolean dAj = mMViewPager.dAj();
        AppMethodBeat.o(106946);
        return dAj;
    }

    static /* synthetic */ void h(MMViewPager mMViewPager) {
        AppMethodBeat.i(106947);
        mMViewPager.dAi();
        AppMethodBeat.o(106947);
    }

    static /* synthetic */ void w(MMViewPager mMViewPager) {
        AppMethodBeat.i(106953);
        mMViewPager.bCP();
        AppMethodBeat.o(106953);
    }

    public void setSingleClickOverListener(e eVar) {
        this.yyo = eVar;
    }

    public void setLongClickOverListener(c cVar) {
        this.yyp = cVar;
    }

    public MMViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(106921);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(106921);
    }

    private void bCP() {
        AppMethodBeat.i(106922);
        this.yyg.removeMessages(1);
        AppMethodBeat.o(106922);
    }

    private void bCQ() {
        AppMethodBeat.i(106923);
        bCP();
        k kVar = this.yyg;
        kVar.mSL = 15;
        kVar.sendEmptyMessageDelayed(1, 15);
        AppMethodBeat.o(106923);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.yyq = onPageChangeListener;
    }

    public MMViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106924);
        setStaticTransformationsEnabled(true);
        this.yyg = new k(new WeakReference(this));
        this.iay = new GestureDetector(context, new d(this, (byte) 0));
        this.mSq = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.yym = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        super.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageSelected(int i) {
                AppMethodBeat.i(106895);
                MMViewPager.this.aaF = MMViewPager.this.alh;
                MMViewPager.this.alh = i;
                if (MMViewPager.this.yyq != null) {
                    MMViewPager.this.yyq.onPageSelected(i);
                }
                if (MMViewPager.g(MMViewPager.this)) {
                    MMViewPager.h(MMViewPager.this);
                    AppMethodBeat.o(106895);
                    return;
                }
                MMViewPager.this.yyf = null;
                AppMethodBeat.o(106895);
            }

            public final void onPageScrolled(int i, float f, int i2) {
                AppMethodBeat.i(106896);
                if (MMViewPager.this.yyq != null) {
                    MMViewPager.this.yyq.onPageScrolled(i, f, i2);
                }
                MMViewPager.this.yyr = f;
                if (i2 == 0 && MMViewPager.this.aaF != -1) {
                    MMViewPager.c(MMViewPager.this, MMViewPager.this.aaF);
                }
                AppMethodBeat.o(106896);
            }

            public final void onPageScrollStateChanged(int i) {
                AppMethodBeat.i(106897);
                if (MMViewPager.this.yyq != null) {
                    MMViewPager.this.yyq.onPageScrollStateChanged(i);
                }
                if (i == 0) {
                    MMViewPager.this.yyr = 0.0f;
                }
                AppMethodBeat.o(106897);
            }
        });
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onTouch;
                AppMethodBeat.i(106898);
                ab.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", Integer.valueOf(MMViewPager.this.getCurrentItem()));
                if (MMViewPager.this.jZu != null) {
                    onTouch = MMViewPager.this.jZu.onTouch(view, motionEvent);
                } else {
                    onTouch = false;
                }
                g selectedImageView = MMViewPager.this.getSelectedImageView();
                if (selectedImageView == null) {
                    MMViewPager.a(MMViewPager.this, motionEvent);
                    MMViewPager.this.yyv = null;
                    MMViewPager.this.iay.onTouchEvent(motionEvent);
                    if (MMViewPager.this.mSp || MMViewPager.this.rvb) {
                        AppMethodBeat.o(106898);
                        return true;
                    }
                    AppMethodBeat.o(106898);
                    return onTouch;
                }
                MMViewPager.this.yye = selectedImageView;
                boolean c = MMViewPager.c(MMViewPager.this, motionEvent);
                if (MMViewPager.this.yyv != null) {
                    MMViewPager.this.yyv.recycle();
                }
                MMViewPager.this.yyv = MotionEvent.obtainNoHistory(motionEvent);
                MMViewPager.this.iay.onTouchEvent(motionEvent);
                MMViewPager.this.computeScroll();
                if (c || onTouch) {
                    AppMethodBeat.o(106898);
                    return true;
                }
                AppMethodBeat.o(106898);
                return false;
            }
        });
        AppMethodBeat.o(106924);
    }

    private void dAi() {
        AppMethodBeat.i(106925);
        this.yyf = getSelectedWxImageView();
        if (this.yyf != null) {
            ab.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
            this.yyf.setGestureDetectorListener(this.yyy);
            this.yyf.setOnLongClickListener(this.yyz);
            this.yyf.dzA();
        }
        AppMethodBeat.o(106925);
    }

    private boolean dAj() {
        AppMethodBeat.i(106926);
        g selectedImageView = getSelectedImageView();
        if (selectedImageView == null || !(selectedImageView instanceof WxImageView)) {
            AppMethodBeat.o(106926);
            return false;
        }
        AppMethodBeat.o(106926);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(106927);
        try {
            ab.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", Integer.valueOf(motionEvent.getAction()));
            if (this.yyf == null) {
                dAi();
            }
            z = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(106927);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMViewPager", e, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
            AppMethodBeat.o(106927);
        }
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106928);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (!dAj()) {
            AppMethodBeat.o(106928);
        } else if (onInterceptTouchEvent) {
            AppMethodBeat.o(106928);
        } else {
            if (this.yyu == null) {
                this.yyu = VelocityTracker.obtain();
            }
            this.yyu.addMovement(motionEvent);
            VelocityTracker velocityTracker = this.yyu;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            int yVelocity = (int) velocityTracker.getYVelocity();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.yys = motionEvent.getRawX();
                    this.yyt = motionEvent.getRawY();
                    onInterceptTouchEvent = false;
                    break;
                case 1:
                    onInterceptTouchEvent = false;
                    break;
                case 2:
                    float rawY = motionEvent.getRawY() - this.yyt;
                    ab.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", Float.valueOf(motionEvent.getRawX() - this.yys), Float.valueOf(rawY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                    if (Math.abs(motionEvent.getRawX() - this.yys) <= 250.0f && Math.abs(yVelocity) > Math.abs(xVelocity) && Math.abs(yVelocity) > 0) {
                        ab.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", Integer.valueOf(motionEvent.getAction()));
                        onInterceptTouchEvent = true;
                        break;
                    }
                    onInterceptTouchEvent = false;
                    break;
                    break;
                default:
                    onInterceptTouchEvent = false;
                    break;
            }
            if (onInterceptTouchEvent) {
                this.aKM = motionEvent.getRawX();
                this.aKN = motionEvent.getRawY();
                this.mSu = this.yyf.getScale();
            }
            AppMethodBeat.o(106928);
        }
        return onInterceptTouchEvent;
    }

    public void setGalleryScaleListener(b bVar) {
        this.yyx = bVar;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.jZu = onTouchListener;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106929);
        super.onMeasure(i, i2);
        this.ieu = MeasureSpec.getSize(i);
        this.iev = MeasureSpec.getSize(i2);
        this.mSs.set(0.0f, 0.0f, (float) this.ieu, (float) this.iev);
        AppMethodBeat.o(106929);
    }

    private boolean dAk() {
        AppMethodBeat.i(106930);
        ab.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
        if (this.yyi) {
            AppMethodBeat.o(106930);
            return true;
        }
        this.yyj = true;
        AppMethodBeat.o(106930);
        return false;
    }

    private boolean a(float f, View view, float f2) {
        AppMethodBeat.i(106931);
        if (getAdapter().getItemPosition(view) == firstItemPosForDetermine()) {
            if (this.yye instanceof WxImageView) {
                float f3 = f2 * 0.3f;
                ab.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", Float.valueOf(f3), Float.valueOf(((WxImageView) this.yye).getTranslationX()));
                if (f3 < 0.0f && r0 - f3 > 0.0f) {
                    this.yyk = true;
                }
                if (this.yyk) {
                    ((WxImageView) this.yye).translate(-f3, 0.0f);
                    AppMethodBeat.o(106931);
                    return true;
                }
                AppMethodBeat.o(106931);
                return false;
            } else if (this.yyk) {
                if (f2 < 0.0f) {
                    if (f <= this.mSs.left) {
                        this.yye.aj(-f2, 0.0f);
                    } else if (f > this.mSs.left && f < ((float) this.ieu) * 0.3f) {
                        this.yye.aj(-(f2 * 0.3f), 0.0f);
                        AppMethodBeat.o(106931);
                        return true;
                    }
                }
                AppMethodBeat.o(106931);
                return false;
            } else if (f2 < 0.0f) {
                if (f > 0.0f) {
                    this.yyk = true;
                }
                if (f <= this.mSs.left) {
                    this.yye.aj(-f2, 0.0f);
                } else if (f > this.mSs.left && f < ((float) this.ieu) * 0.3f) {
                    this.yye.aj(-(f2 * 0.3f), 0.0f);
                    AppMethodBeat.o(106931);
                    return true;
                }
            }
        }
        if (this.yyj || this.yyi) {
            AppMethodBeat.o(106931);
            return false;
        }
        this.yyk = false;
        AppMethodBeat.o(106931);
        return false;
    }

    private boolean b(float f, View view, float f2) {
        AppMethodBeat.i(106932);
        if (getAdapter().getItemPosition(view) == lastItemPosForDetermine()) {
            if (this.yye instanceof WxImageView) {
                float f3 = f2 * 0.3f;
                ab.d("MicroMsg.MMViewPager", "alvinluo scrollLast current is WxImageView, distanceX: %f, translateRight: %f", Float.valueOf(f3), Float.valueOf(((WxImageView) this.yye).getTranslationX()));
                if (f3 > 0.0f && r0 - f3 < 0.0f) {
                    this.yyl = true;
                }
                if (this.yyl) {
                    ((WxImageView) this.yye).translate(-f3, 0.0f);
                    AppMethodBeat.o(106932);
                    return true;
                }
                AppMethodBeat.o(106932);
                return false;
            } else if (this.yyl) {
                if (f2 > 0.0f) {
                    if (f >= ((float) this.ieu)) {
                        this.yye.aj(-f2, 0.0f);
                    } else if (f > ((float) this.ieu) * 0.7f && f < ((float) this.iev)) {
                        this.yye.aj(-(f2 * 0.3f), 0.0f);
                        AppMethodBeat.o(106932);
                        return true;
                    }
                }
                AppMethodBeat.o(106932);
                return false;
            } else if (f2 > 0.0f) {
                if (f < ((float) this.ieu)) {
                    this.yyl = true;
                }
                if (f >= ((float) this.ieu)) {
                    this.yye.aj(-f2, 0.0f);
                } else if (f > ((float) this.ieu) * 0.7f && f < ((float) this.iev)) {
                    this.yye.aj(-(f2 * 0.3f), 0.0f);
                    AppMethodBeat.o(106932);
                    return true;
                }
            }
        }
        if (this.yyj || this.yyi) {
            AppMethodBeat.o(106932);
            return false;
        }
        this.yyl = false;
        AppMethodBeat.o(106932);
        return false;
    }

    private boolean a(float f, float f2, View view, float f3) {
        AppMethodBeat.i(106933);
        if (b(f2, view, f3)) {
            AppMethodBeat.o(106933);
            return true;
        } else if (a(f, view, f3)) {
            AppMethodBeat.o(106933);
            return true;
        } else {
            AppMethodBeat.o(106933);
            return false;
        }
    }

    private View getSelectedView() {
        AppMethodBeat.i(106934);
        View Fp = ((u) getAdapter()).Fp(getCurrentItem());
        AppMethodBeat.o(106934);
        return Fp;
    }

    public g getSelectedImageView() {
        AppMethodBeat.i(106935);
        MultiTouchImageView selectedMultiTouchImageView = getSelectedMultiTouchImageView();
        if (selectedMultiTouchImageView != null) {
            AppMethodBeat.o(106935);
            return selectedMultiTouchImageView;
        }
        g selectedWxImageView = getSelectedWxImageView();
        AppMethodBeat.o(106935);
        return selectedWxImageView;
    }

    private MultiTouchImageView getSelectedMultiTouchImageView() {
        AppMethodBeat.i(106936);
        MultiTouchImageView wx = ((u) getAdapter()).wx(getCurrentItem());
        AppMethodBeat.o(106936);
        return wx;
    }

    private WxImageView getSelectedWxImageView() {
        AppMethodBeat.i(106937);
        WxImageView wy = ((u) getAdapter()).wy(getCurrentItem());
        if (wy != null) {
            wy = wy;
            AppMethodBeat.o(106937);
            return wy;
        }
        AppMethodBeat.o(106937);
        return null;
    }

    public void setAdapter(p pVar) {
        AppMethodBeat.i(106938);
        if (pVar instanceof u) {
            super.setAdapter(pVar);
            AppMethodBeat.o(106938);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("must be MMViewPagerAdapter");
        AppMethodBeat.o(106938);
        throw illegalArgumentException;
    }

    private int getCurrentX() {
        AppMethodBeat.i(106939);
        if (getAdapter() == null) {
            AppMethodBeat.o(106939);
            return -1;
        }
        int scrollX = getScrollX() - (this.ieu * ((getAdapter().getCount() - getCurrentItem()) - 1));
        AppMethodBeat.o(106939);
        return scrollX;
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(106940);
        if (motionEvent == null || motionEvent2 == null) {
            AppMethodBeat.o(106940);
            return false;
        } else if (motionEvent.getX() - motionEvent2.getX() < 0.0f) {
            AppMethodBeat.o(106940);
            return true;
        } else {
            AppMethodBeat.o(106940);
            return false;
        }
    }

    public void computeScroll() {
        int i = 0;
        AppMethodBeat.i(106941);
        super.computeScroll();
        if (this.yye == null) {
            AppMethodBeat.o(106941);
            return;
        }
        float scale = this.yye.getScale() * ((float) this.yye.getImageWidth());
        float scale2 = this.yye.getScale() * ((float) this.yye.getImageHeight());
        if (this.mSq.computeScrollOffset()) {
            int currX = this.mSq.getCurrX() - this.apF;
            int currY = this.mSq.getCurrY() - this.apG;
            this.apF = this.mSq.getCurrX();
            this.apG = this.mSq.getCurrY();
            float[] fArr = new float[9];
            this.yye.getImageMatrix().getValues(fArr);
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
            this.yye.aj((float) currX, (float) i);
            postInvalidate();
        }
        AppMethodBeat.o(106941);
    }

    public int getScreenWidth() {
        return this.ieu;
    }

    /* Access modifiers changed, original: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AppMethodBeat.i(106942);
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
        AppMethodBeat.o(106942);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(106943);
        if (z) {
            super.onWindowFocusChanged(z);
        }
        AppMethodBeat.o(106943);
    }

    public boolean isFocused() {
        return true;
    }

    public int firstItemPosForDetermine() {
        AppMethodBeat.i(106944);
        int firstItemPosForDetermine = ((u) getAdapter()).firstItemPosForDetermine();
        if (firstItemPosForDetermine >= 0) {
            AppMethodBeat.o(106944);
            return firstItemPosForDetermine;
        }
        firstItemPosForDetermine = super.firstItemPosForDetermine();
        AppMethodBeat.o(106944);
        return firstItemPosForDetermine;
    }

    public int lastItemPosForDetermine() {
        AppMethodBeat.i(106945);
        int lastItemPosForDetermine = ((u) getAdapter()).lastItemPosForDetermine();
        if (lastItemPosForDetermine >= 0) {
            AppMethodBeat.o(106945);
            return lastItemPosForDetermine;
        }
        lastItemPosForDetermine = super.lastItemPosForDetermine();
        AppMethodBeat.o(106945);
        return lastItemPosForDetermine;
    }
}
