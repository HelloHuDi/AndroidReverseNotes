package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    private static final List<Integer> aIN = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1)});
    private static final List<Integer> aIO = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
    private static final List<Integer> aIP = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1)});
    private static final List<Integer> aIQ = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
    private static final List<Integer> aIR = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4)});
    public static int aJk = BaseClientBuilder.API_PRIORITY_OTHER;
    private static Config aKp = Config.ARGB_8888;
    private static com.davemorrissey.labs.subscaleview.c.a aKq = new com.davemorrissey.labs.subscaleview.b.a();
    private static com.davemorrissey.labs.subscaleview.c.d aKr = new com.davemorrissey.labs.subscaleview.b.c();
    private static com.davemorrissey.labs.subscaleview.c.c aKs = new com.davemorrissey.labs.subscaleview.b.b();
    private final String TAG = (SubsamplingScaleImageView.class.getSimpleName() + hashCode());
    public int aIJ;
    public int aIK;
    private Rect aIL;
    private boolean aIS;
    private boolean aIT;
    private boolean aIU;
    private int aIV;
    private int aIW;
    private boolean aIX;
    private int aIY;
    private boolean aIZ = true;
    private final ReadWriteLock aIo = new ReentrantReadWriteLock(true);
    private com.davemorrissey.labs.subscaleview.a.d aIw;
    private PointF aJA;
    private PointF aJB;
    private boolean aJC;
    private a aJD;
    private a aJE;
    private int aJF;
    private int aJG = 0;
    private Rect aJH;
    private boolean aJI;
    private boolean aJJ;
    private boolean aJK;
    private int aJL;
    private GestureDetector aJM;
    private SimpleOnGestureListener aJN;
    private GestureDetector aJO;
    private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aJP = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aJQ = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    private PointF aJR;
    private float aJS;
    private final float aJT;
    private float aJU;
    private boolean aJV;
    private PointF aJW;
    private PointF aJX;
    private PointF aJY;
    private a aJZ;
    private long aJa = -1;
    private long aJb = -1;
    private Bitmap aJc;
    private Map<Integer, List<com.davemorrissey.labs.subscaleview.c.e>> aJd;
    private boolean aJe = false;
    private float aJf = 2.0f;
    private float aJg = oJ();
    private int aJh = -1;
    private int aJi = 1;
    private int aJj = 3;
    private int aJl = aJk;
    private int aJm = aJk;
    private boolean aJn = true;
    private boolean aJo = true;
    private boolean aJp = true;
    private boolean aJq = true;
    private float aJr = 2.0f;
    private int aJs = 1;
    private int aJt = 200;
    private int aJu = 200;
    private float aJv;
    private PointF aJw;
    private PointF aJx;
    private PointF aJy;
    private Float aJz;
    private float aKA;
    private float aKB = 1.0f;
    private float aKC = 20.0f;
    private boolean aKD = true;
    private boolean aKE = false;
    private PointF aKF;
    private OnAttachStateChangeListener aKG;
    private com.davemorrissey.labs.subscaleview.d.a aKH = new com.davemorrissey.labs.subscaleview.d.a();
    private c aKI = new c() {
    };
    private boolean aKJ = false;
    private boolean aKK = false;
    private boolean aKL = false;
    private float aKM;
    private float aKN;
    private boolean aKa;
    private boolean aKb;
    private e aKc;
    private f aKd;
    private OnLongClickListener aKe;
    private Paint aKf;
    private Paint aKg;
    private Paint aKh;
    private Paint aKi;
    private g aKj;
    private Matrix aKk;
    private RectF aKl;
    private float[] aKm = new float[8];
    private float[] aKn = new float[8];
    private Matrix aKo;
    private LinkedList<com.davemorrissey.labs.subscaleview.c.b> aKt = new LinkedList();
    private int aKu;
    private int aKv;
    private float aKw;
    private float aKx;
    public float aKy;
    private float aKz;
    private Bitmap bitmap;
    private boolean cancelled = false;
    private float density = getResources().getDisplayMetrics().density;
    public Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
    private Handler handler;
    private int orientation = -1;
    private float scale;
    private Uri uri;

    public interface d {
    }

    static class a {
        float aJv;
        float aKU;
        PointF aKV;
        PointF aKW;
        PointF aKX;
        PointF aKY;
        PointF aKZ;
        boolean aLa;
        int aLb;
        int aLc;
        d aLd;
        long duration;
        long time;

        private a() {
            AppMethodBeat.i(115650);
            this.duration = 200;
            this.aLa = true;
            this.aLb = 2;
            this.aLc = 1;
            this.time = System.currentTimeMillis();
            AppMethodBeat.o(115650);
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface c {
    }

    public final class b {
        boolean aLa;
        int aLb;
        int aLc;
        private d aLd;
        private final float aLe;
        private final PointF aLf;
        private final PointF aLg;
        boolean aLh;
        long duration;

        /* synthetic */ b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2, byte b) {
            this(f, pointF, pointF2);
        }

        private b(PointF pointF) {
            AppMethodBeat.i(115651);
            this.duration = 500;
            this.aLb = 2;
            this.aLc = 1;
            this.aLa = true;
            this.aLh = true;
            this.aLe = SubsamplingScaleImageView.this.scale;
            this.aLf = pointF;
            this.aLg = null;
            AppMethodBeat.o(115651);
        }

        private b(float f, PointF pointF) {
            this.duration = 500;
            this.aLb = 2;
            this.aLc = 1;
            this.aLa = true;
            this.aLh = true;
            this.aLe = f;
            this.aLf = pointF;
            this.aLg = null;
        }

        private b(float f, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.aLb = 2;
            this.aLc = 1;
            this.aLa = true;
            this.aLh = true;
            this.aLe = f;
            this.aLf = pointF;
            this.aLg = pointF2;
        }

        public final void start() {
            AppMethodBeat.i(115652);
            if (!(SubsamplingScaleImageView.this.aJZ == null || SubsamplingScaleImageView.this.aJZ.aLd == null)) {
                try {
                    SubsamplingScaleImageView.this.aJZ;
                } catch (Exception e) {
                    ab.w(SubsamplingScaleImageView.this.TAG, "Error thrown by animation listener", e);
                }
            }
            int width = (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2) + SubsamplingScaleImageView.this.getPaddingLeft();
            int height = (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2) + SubsamplingScaleImageView.this.getPaddingTop();
            float b = SubsamplingScaleImageView.b(SubsamplingScaleImageView.this, this.aLe);
            PointF a = this.aLh ? SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, this.aLf.x, this.aLf.y, b, new PointF()) : this.aLf;
            SubsamplingScaleImageView.this.aJZ = new a();
            SubsamplingScaleImageView.this.aJZ.aJv = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.aJZ.aKU = b;
            SubsamplingScaleImageView.this.aJZ.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.aJZ.aKX = a;
            SubsamplingScaleImageView.this.aJZ.aKV = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.aJZ.aKW = a;
            SubsamplingScaleImageView.this.aJZ.aKY = SubsamplingScaleImageView.this.c(a);
            SubsamplingScaleImageView.this.aJZ.aKZ = new PointF((float) width, (float) height);
            SubsamplingScaleImageView.this.aJZ.duration = this.duration;
            SubsamplingScaleImageView.this.aJZ.aLa = this.aLa;
            SubsamplingScaleImageView.this.aJZ.aLb = this.aLb;
            SubsamplingScaleImageView.this.aJZ.aLc = this.aLc;
            SubsamplingScaleImageView.this.aJZ.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.aJZ.aLd = this.aLd;
            if (this.aLg != null) {
                float f = this.aLg.x - (SubsamplingScaleImageView.this.aJZ.aKV.x * b);
                float f2 = this.aLg.y - (SubsamplingScaleImageView.this.aJZ.aKV.y * b);
                g gVar = new g(b, new PointF(f, f2), (byte) 0);
                SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, gVar);
                SubsamplingScaleImageView.this.aJZ.aKZ = new PointF((gVar.aJw.x - f) + this.aLg.x, (gVar.aJw.y - f2) + this.aLg.y);
            }
            SubsamplingScaleImageView.this.invalidate();
            AppMethodBeat.o(115652);
        }
    }

    public interface e {
        void a(com.davemorrissey.labs.subscaleview.a.c cVar);

        void b(com.davemorrissey.labs.subscaleview.a.c cVar);

        void c(com.davemorrissey.labs.subscaleview.a.c cVar);

        void l(Bitmap bitmap);

        void oL();

        void oM();
    }

    static class g {
        PointF aJw;
        float scale;

        /* synthetic */ g(float f, PointF pointF, byte b) {
            this(f, pointF);
        }

        private g(float f, PointF pointF) {
            this.scale = f;
            this.aJw = pointF;
        }
    }

    public interface f {
    }

    static {
        AppMethodBeat.i(115738);
        AppMethodBeat.o(115738);
    }

    /* renamed from: do */
    public final synchronized void m1do(int i) {
        AppMethodBeat.i(115653);
        if (this.aKH != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aKH;
            aVar.aIF += i;
            ab.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(aVar.aIF));
        }
        AppMethodBeat.o(115653);
    }

    public final synchronized void dp(int i) {
        AppMethodBeat.i(115654);
        if (this.aKH != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aKH;
            aVar.aIE += i;
            ab.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(aVar.aIE));
        }
        AppMethodBeat.o(115654);
    }

    public final synchronized void dq(int i) {
        AppMethodBeat.i(115655);
        if (this.aKH != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aKH;
            aVar.aIG += i;
            ab.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(aVar.aIG));
        }
        AppMethodBeat.o(115655);
    }

    public synchronized com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord() {
        return this.aKH;
    }

    public void setEdgeSwipeListener(c cVar) {
        this.aKI = cVar;
    }

    public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.aKG = onAttachStateChangeListener;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(115656);
        super.onAttachedToWindow();
        if (this.aKG != null) {
            this.aKG.onViewAttachedToWindow(this);
        }
        this.cancelled = false;
        AppMethodBeat.o(115656);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(115657);
        super.onDetachedFromWindow();
        if (!this.cancelled) {
            this.cancelled = true;
            ab.i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", Integer.valueOf(this.aKt.size()));
            Iterator it = this.aKt.iterator();
            while (it.hasNext()) {
                ((com.davemorrissey.labs.subscaleview.c.b) it.next()).cancel();
            }
            this.aKt.clear();
        }
        if (this.aKG != null) {
            this.aKG.onViewDetachedFromWindow(this);
        }
        AppMethodBeat.o(115657);
    }

    private void a(com.davemorrissey.labs.subscaleview.c.e eVar) {
        AppMethodBeat.i(115658);
        if (this.cancelled) {
            ab.i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
            AppMethodBeat.o(115658);
            return;
        }
        com.davemorrissey.labs.subscaleview.c.b a = aKr.a(this, this.aIw, eVar);
        a.ou();
        this.aKt.add(a);
        AppMethodBeat.o(115658);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115659);
        setDoubleTapZoomScale(2.0f);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.aKo = new Matrix();
        this.handler = new Handler(new Callback() {
            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(115640);
                if (message.what == 1 && SubsamplingScaleImageView.this.aKe != null) {
                    SubsamplingScaleImageView.this.aJL = 0;
                    SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.aKe);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.d(SubsamplingScaleImageView.this);
                }
                AppMethodBeat.o(115640);
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(1)) {
                String string = obtainStyledAttributes.getString(1);
                if (string != null && string.length() > 0) {
                    if (string == null) {
                        NullPointerException nullPointerException = new NullPointerException("Asset name must not be null");
                        AppMethodBeat.o(115659);
                        throw nullPointerException;
                    }
                    setImage(a.af("file:///android_asset/".concat(String.valueOf(string))).ox());
                }
            }
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId > 0) {
                    setImage(new a(resourceId).ox());
                }
            }
            if (obtainStyledAttributes.hasValue(2)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(2, true));
            }
            if (obtainStyledAttributes.hasValue(3)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(3, true));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(4, true));
            }
            if (obtainStyledAttributes.hasValue(5)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(5, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.aJT = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.aKB = f;
        }
        AppMethodBeat.o(115659);
    }

    public ReadWriteLock getDecoderLock() {
        return this.aIo;
    }

    public int getFullImageSampleSize() {
        return this.aIY;
    }

    public Bitmap getFullImageBitmap() {
        return this.aJc;
    }

    public void setPreviewDone(boolean z) {
        AppMethodBeat.i(115660);
        this.aKD = z;
        invalidate();
        AppMethodBeat.o(115660);
    }

    public static Config getPreferredBitmapConfig() {
        return aKp;
    }

    public static void setPreferredBitmapConfig(Config config) {
        aKp = config;
    }

    public final void setOrientation(int i) {
        AppMethodBeat.i(115661);
        if (aIN.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(false);
            invalidate();
            requestLayout();
            AppMethodBeat.o(115661);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid orientation: ".concat(String.valueOf(i)));
        AppMethodBeat.o(115661);
        throw illegalArgumentException;
    }

    public Rect getsRegion() {
        return this.aIL;
    }

    public void setsRegion(Rect rect) {
        this.aIL = rect;
    }

    public void setScaleRate(float f) {
        AppMethodBeat.i(115662);
        this.aKy = f;
        this.aJf = 2.0f;
        this.aJg = 1.0f;
        oz();
        oA();
        AppMethodBeat.o(115662);
    }

    private void oy() {
        AppMethodBeat.i(115663);
        ab.i(this.TAG, "alvinluo initScaleRate: %f", Float.valueOf(this.aKy));
        oz();
        oA();
        AppMethodBeat.o(115663);
    }

    private void oz() {
        AppMethodBeat.i(115664);
        this.aJf = (getDoubleTapZoomScale() * 2.0f) * this.aKB;
        AppMethodBeat.o(115664);
    }

    private void oA() {
        AppMethodBeat.i(115665);
        this.aJg = Math.min(oJ(), this.aKy * 0.75f);
        AppMethodBeat.o(115665);
    }

    public void setImageMatrix(Matrix matrix) {
        Object matrix2;
        AppMethodBeat.i(115666);
        if (matrix2 != null && matrix2.isIdentity()) {
            matrix2 = null;
        }
        if ((matrix2 == null && !this.aKo.isIdentity()) || !(matrix2 == null || this.aKo.equals(matrix2))) {
            this.aKo.set(matrix2);
            invalidate();
        }
        AppMethodBeat.o(115666);
    }

    public final void setImage(a aVar) {
        AppMethodBeat.i(115667);
        a(aVar, null);
        AppMethodBeat.o(115667);
    }

    public static void setBitmapLoaderImp(com.davemorrissey.labs.subscaleview.c.a aVar) {
        aKq = aVar;
    }

    public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c cVar) {
        aKs = cVar;
    }

    public static void setTileLoaderImp(com.davemorrissey.labs.subscaleview.c.d dVar) {
        aKr = dVar;
    }

    public final void a(a aVar, a aVar2) {
        AppMethodBeat.i(115668);
        if (aVar == null) {
            NullPointerException nullPointerException = new NullPointerException("imageSource must not be null");
            AppMethodBeat.o(115668);
            throw nullPointerException;
        }
        reset(true);
        this.aJD = aVar;
        this.aJE = aVar2;
        if (aVar.uri != null) {
            this.aJF = h(getContext(), aVar.uri.toString());
        }
        if (aVar2 != null) {
            if (aVar.aIJ <= 0 || aVar.aIK <= 0) {
                ab.e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.aIJ = aVar.aIJ;
                this.aIK = aVar.aIK;
                this.aJH = aVar2.aIL;
                if (aVar2.bitmap != null) {
                    this.aIX = aVar2.aIM;
                    a(aVar2.bitmap, Integer.valueOf(0));
                } else {
                    Uri uri = aVar2.uri;
                    if (uri == null && aVar2.aIH != null) {
                        uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar2.aIH);
                    }
                    aKq.a(this, getContext(), this.aJP, uri, true).ou();
                }
            }
        }
        if (aVar.bitmap != null && aVar.aIL != null) {
            b(Bitmap.createBitmap(aVar.bitmap, aVar.aIL.left, aVar.aIL.top, aVar.aIL.width(), aVar.aIL.height()), 0, false);
            AppMethodBeat.o(115668);
        } else if (aVar.bitmap != null) {
            b(aVar.bitmap, 0, aVar.aIM);
            AppMethodBeat.o(115668);
        } else {
            this.aIL = aVar.aIL;
            this.uri = aVar.uri;
            if (this.uri == null && aVar.aIH != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar.aIH);
            }
            if (aVar.aII || this.aIL != null) {
                aKs.a(this, getContext(), this.aJQ, this.uri).ou();
                AppMethodBeat.o(115668);
                return;
            }
            aKq.a(this, getContext(), this.aJP, this.uri, false).ou();
            AppMethodBeat.o(115668);
        }
    }

    private void reset(boolean z) {
        AppMethodBeat.i(115669);
        j("reset newImage=".concat(String.valueOf(z)), new Object[0]);
        this.scale = 0.0f;
        this.aJv = 0.0f;
        this.aJw = null;
        this.aJx = null;
        this.aJy = null;
        this.aJz = Float.valueOf(0.0f);
        this.aJA = null;
        this.aJB = null;
        this.aJI = false;
        this.aJJ = false;
        this.aJK = false;
        this.aJL = 0;
        this.aIY = 0;
        this.aJR = null;
        this.aJS = 0.0f;
        this.aJU = 0.0f;
        this.aJV = false;
        this.aJX = null;
        this.aJW = null;
        this.aJY = null;
        this.aJZ = null;
        this.aKj = null;
        this.aKk = null;
        this.aKl = null;
        if (z) {
            if (this.aKH != null) {
                com.davemorrissey.labs.subscaleview.d.a aVar = this.aKH;
                aVar.aIG = 0;
                aVar.aIE = 0;
                aVar.aIG = 0;
            }
            this.uri = null;
            this.aIo.writeLock().lock();
            try {
                if (this.aIw != null) {
                    this.aIw.recycle();
                    this.aIw = null;
                }
                this.aIo.writeLock().unlock();
                if (!(this.bitmap == null || this.aIX)) {
                    this.bitmap.recycle();
                }
                if (!(this.bitmap == null || !this.aIX || this.aKc == null)) {
                    this.aKc.oM();
                }
                this.aIJ = 0;
                this.aIK = 0;
                this.aJF = 0;
                this.aIL = null;
                this.aJH = null;
                this.aKa = false;
                this.aKb = false;
                this.bitmap = null;
                this.aIS = false;
                this.aIX = false;
                this.aIT = false;
                this.aIU = false;
                this.aIZ = true;
            } catch (Throwable th) {
                this.aIo.writeLock().unlock();
                AppMethodBeat.o(115669);
            }
        }
        if (this.aJd != null) {
            for (Entry value : this.aJd.entrySet()) {
                for (com.davemorrissey.labs.subscaleview.c.e eVar : (List) value.getValue()) {
                    eVar.aIB = false;
                    if (eVar.bitmap != null) {
                        eVar.bitmap.recycle();
                        eVar.bitmap = null;
                    }
                }
            }
            this.aJd = null;
        }
        setGestureDetector(getContext());
        AppMethodBeat.o(115669);
    }

    public e getOnImageEventListener() {
        return this.aKc;
    }

    public void setGestureDetectorListener(SimpleOnGestureListener simpleOnGestureListener) {
        this.aJN = simpleOnGestureListener;
    }

    private void setGestureDetector(final Context context) {
        AppMethodBeat.i(115670);
        this.aJM = new GestureDetector(context, new SimpleOnGestureListener() {
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                AppMethodBeat.i(115641);
                if (!SubsamplingScaleImageView.this.aJo || !SubsamplingScaleImageView.this.aKa || SubsamplingScaleImageView.this.aJw == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.this.aJI))) {
                    boolean onFling = super.onFling(motionEvent, motionEvent2, f, f2);
                    AppMethodBeat.o(115641);
                    return onFling;
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.aJw.x + (f * 0.25f), SubsamplingScaleImageView.this.aJw.y + (0.25f * f2));
                b bVar = new b(SubsamplingScaleImageView.this, new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale), (byte) 0);
                if (SubsamplingScaleImageView.aIP.contains(Integer.valueOf(1))) {
                    bVar.aLb = 1;
                    bVar.aLh = false;
                    bVar.aLc = 3;
                    bVar.start();
                    AppMethodBeat.o(115641);
                    return true;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown easing type: 1");
                AppMethodBeat.o(115641);
                throw illegalArgumentException;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.i(115642);
                if (SubsamplingScaleImageView.this.aJN != null) {
                    boolean onSingleTapConfirmed = SubsamplingScaleImageView.this.aJN.onSingleTapConfirmed(motionEvent);
                    if (onSingleTapConfirmed) {
                        AppMethodBeat.o(115642);
                        return onSingleTapConfirmed;
                    }
                }
                SubsamplingScaleImageView.this.performClick();
                AppMethodBeat.o(115642);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(115643);
                if (SubsamplingScaleImageView.this.aJp && SubsamplingScaleImageView.this.aKa && SubsamplingScaleImageView.this.aJw != null) {
                    SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, context);
                    ab.i(SubsamplingScaleImageView.this.TAG, "alvinluo onDoubleTap, quickScaledEnabled: %b", Boolean.valueOf(SubsamplingScaleImageView.this.aJq));
                    if (SubsamplingScaleImageView.this.aJq) {
                        SubsamplingScaleImageView.this.aJR = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.aJx = new PointF(SubsamplingScaleImageView.this.aJw.x, SubsamplingScaleImageView.this.aJw.y);
                        SubsamplingScaleImageView.this.aJv = SubsamplingScaleImageView.this.scale;
                        SubsamplingScaleImageView.this.aJK = true;
                        SubsamplingScaleImageView.this.aJI = true;
                        SubsamplingScaleImageView.this.aJU = -1.0f;
                        SubsamplingScaleImageView.this.aJX = SubsamplingScaleImageView.this.b(SubsamplingScaleImageView.this.aJR);
                        SubsamplingScaleImageView.this.aJY = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.aJW = new PointF(SubsamplingScaleImageView.this.aJX.x, SubsamplingScaleImageView.this.aJX.y);
                        SubsamplingScaleImageView.this.aJV = false;
                        AppMethodBeat.o(115643);
                        return false;
                    }
                    SubsamplingScaleImageView.a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.b(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    AppMethodBeat.o(115643);
                    return true;
                }
                boolean onDoubleTapEvent = super.onDoubleTapEvent(motionEvent);
                AppMethodBeat.o(115643);
                return onDoubleTapEvent;
            }
        });
        this.aJO = new GestureDetector(context, new SimpleOnGestureListener() {
            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.i(115644);
                SubsamplingScaleImageView.this.performClick();
                AppMethodBeat.o(115644);
                return true;
            }
        });
        AppMethodBeat.o(115670);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(115671);
        j("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.scale), this.aJz, Boolean.valueOf(this.aJC));
        oy();
        PointF center = getCenter();
        if ((this.aKa || this.aJC) && center != null) {
            this.aJZ = null;
            if (!this.aJC) {
                this.aJz = Float.valueOf(this.scale);
                this.aJA = center;
            }
        }
        AppMethodBeat.o(115671);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(115672);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = mode != ErrorDialogData.SUPPRESSED ? 1 : 0;
        if (mode2 != ErrorDialogData.SUPPRESSED) {
            mode = 1;
        } else {
            mode = 0;
        }
        if (this.aIJ > 0 && this.aIK > 0) {
            if (i3 == 0 || mode == 0) {
                if (mode != 0) {
                    mode = (int) ((((double) oI()) / ((double) oH())) * ((double) size));
                } else if (i3 != 0) {
                    size = (int) ((((double) oH()) / ((double) oI())) * ((double) size2));
                    mode = size2;
                }
                size2 = Math.max(size, getSuggestedMinimumWidth());
                mode = Math.max(mode, getSuggestedMinimumHeight());
                setMeasuredDimension(size2, mode);
                this.aKu = size2;
                this.aKv = mode;
                ab.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKu));
                AppMethodBeat.o(115672);
            }
            size2 = oH();
            mode = oI();
            size = size2;
            size2 = Math.max(size, getSuggestedMinimumWidth());
            mode = Math.max(mode, getSuggestedMinimumHeight());
            setMeasuredDimension(size2, mode);
            this.aKu = size2;
            this.aKv = mode;
            ab.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKu));
            AppMethodBeat.o(115672);
        }
        mode = size2;
        size2 = Math.max(size, getSuggestedMinimumWidth());
        mode = Math.max(mode, getSuggestedMinimumHeight());
        setMeasuredDimension(size2, mode);
        this.aKu = size2;
        this.aKv = mode;
        ab.d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKu));
        AppMethodBeat.o(115672);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(115673);
        ab.d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(115673);
        return dispatchTouchEvent;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(115674);
        ab.d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", Integer.valueOf(motionEvent.getAction()));
        if (this.aJZ == null || this.aJZ.aLa) {
            this.aJZ = null;
            if (this.aJw == null) {
                if (this.aJO != null) {
                    this.aJO.onTouchEvent(motionEvent);
                }
                AppMethodBeat.o(115674);
                return true;
            } else if (this.aJK || !(this.aJM == null || this.aJM.onTouchEvent(motionEvent))) {
                boolean z;
                if (this.aJx == null) {
                    this.aJx = new PointF(0.0f, 0.0f);
                }
                if (this.aJy == null) {
                    this.aJy = new PointF(0.0f, 0.0f);
                }
                if (this.aJR == null) {
                    this.aJR = new PointF(0.0f, 0.0f);
                }
                this.aJy.set(this.aJw);
                int pointerCount = motionEvent.getPointerCount();
                float b;
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                    case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                        this.aKM = motionEvent.getRawX();
                        this.aKN = motionEvent.getRawY();
                        this.aJZ = null;
                        requestDisallowInterceptTouchEvent(true);
                        this.aJL = Math.max(this.aJL, pointerCount);
                        if (pointerCount >= 2) {
                            if (this.aJp) {
                                b = b(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                this.aJv = this.scale;
                                this.aJS = b;
                                this.aJx.set(this.aJw.x, this.aJw.y);
                                this.aJR.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                            } else {
                                this.aJL = 0;
                            }
                            this.handler.removeMessages(1);
                        } else if (!this.aJK) {
                            this.aJx.set(this.aJw.x, this.aJw.y);
                            this.aJR.set(motionEvent.getX(), motionEvent.getY());
                            this.handler.sendEmptyMessageDelayed(1, 600);
                        }
                        z = true;
                        break;
                    case 1:
                    case 6:
                    case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                        this.handler.removeMessages(1);
                        if (this.aJK) {
                            this.aJK = false;
                            if (!this.aJV) {
                                a(this.aJX, this.aJR);
                            }
                        }
                        if (this.aJL > 0 && (this.aJI || this.aJJ)) {
                            if (this.aJI && pointerCount == 2) {
                                this.aJJ = true;
                                this.aJx.set(this.aJw.x, this.aJw.y);
                                if (motionEvent.getActionIndex() == 1) {
                                    this.aJR.set(motionEvent.getX(0), motionEvent.getY(0));
                                } else {
                                    this.aJR.set(motionEvent.getX(1), motionEvent.getY(1));
                                }
                                if (this.scale <= this.aKy) {
                                    ab.i(this.TAG, "alvinluo scale %f less than %f, and need to reset", Float.valueOf(this.scale), Float.valueOf(this.aKy));
                                    PointF pointF = new PointF((float) (this.aKu / 2), (float) (this.aKv / 2));
                                    b(pointF, pointF, this.aKy);
                                    this.aJJ = false;
                                } else if (this.scale > getDoubleTapZoomScale() * 2.0f) {
                                    ab.i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", Float.valueOf(this.scale), Float.valueOf(this.aJf), Float.valueOf(getDoubleTapZoomScale() * 2.0f));
                                    b(b(this.aKF), this.aKF, getDoubleTapZoomScale() * 2.0f);
                                }
                            }
                            if (pointerCount < 3) {
                                this.aJI = false;
                            }
                            if (pointerCount < 2) {
                                this.aJJ = false;
                                this.aJL = 0;
                            }
                            az(true);
                            z = true;
                            break;
                        }
                        if (pointerCount == 1) {
                            this.aJI = false;
                            this.aJJ = false;
                            this.aJL = 0;
                        }
                        z = false;
                        break;
                        break;
                    case 2:
                        z = false;
                        if (this.aJL > 0) {
                            float b2;
                            float x;
                            if (pointerCount >= 2) {
                                b2 = b(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                this.aKF = new PointF(x, y);
                                if (this.aJp && (b(this.aJR.x, x, this.aJR.y, y) > 5.0f || Math.abs(b2 - this.aJS) > 5.0f || this.aJJ)) {
                                    this.aJI = true;
                                    this.aJJ = true;
                                    double d = (double) this.scale;
                                    b = (b2 / this.aJS) * this.aJv;
                                    if (b >= this.aJf * 2.0f) {
                                        b = ((b - this.aJf) * 0.1f) + (this.aJf * 2.0f);
                                    }
                                    this.scale = b;
                                    ab.i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(oJ()), Float.valueOf(this.aJf));
                                    if (this.scale <= oJ()) {
                                        this.aJS = b2;
                                        this.aJv = oJ();
                                        this.aJR.set(x, y);
                                        this.aJx.set(this.aJw);
                                    } else if (this.aJo) {
                                        float f = (this.aJR.y - this.aJx.y) * (this.scale / this.aJv);
                                        this.aJw.x = x - ((this.aJR.x - this.aJx.x) * (this.scale / this.aJv));
                                        this.aJw.y = y - f;
                                        if ((((double) oI()) * d < ((double) getHeight()) && this.scale * ((float) oI()) >= ((float) getHeight())) || (d * ((double) oH()) < ((double) getWidth()) && this.scale * ((float) oH()) >= ((float) getWidth()))) {
                                            aA(true);
                                            this.aJR.set(x, y);
                                            this.aJx.set(this.aJw);
                                            this.aJv = this.scale;
                                            this.aJS = b2;
                                        }
                                    } else if (this.aJB != null) {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * this.aJB.x);
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * this.aJB.y);
                                    } else {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (oH() / 2)));
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (oI() / 2)));
                                    }
                                    aA(true);
                                    az(this.aJn);
                                    z = true;
                                }
                            } else if (this.aJK) {
                                b2 = (Math.abs(this.aJY.y - motionEvent.getY()) * 2.0f) + this.aJT;
                                if (this.aJU == -1.0f) {
                                    this.aJU = b2;
                                }
                                Object obj = motionEvent.getY() > this.aJW.y ? 1 : null;
                                this.aJW.set(0.0f, motionEvent.getY());
                                x = 0.5f * Math.abs(1.0f - (b2 / this.aJU));
                                if (x > 0.03f || this.aJV) {
                                    this.aJV = true;
                                    if (this.aJU <= 0.0f) {
                                        b = 1.0f;
                                    } else if (obj != null) {
                                        b = 1.0f + x;
                                    } else {
                                        b = 1.0f - x;
                                    }
                                    double d2 = (double) this.scale;
                                    this.scale = Math.max(oJ(), Math.min(this.aJf, b * this.scale));
                                    if (this.aJo) {
                                        float f2 = (this.aJR.y - this.aJx.y) * (this.scale / this.aJv);
                                        this.aJw.x = this.aJR.x - ((this.aJR.x - this.aJx.x) * (this.scale / this.aJv));
                                        this.aJw.y = this.aJR.y - f2;
                                        if ((((double) oI()) * d2 >= ((double) getHeight()) || this.scale * ((float) oI()) < ((float) getHeight())) && (((double) oH()) * d2 >= ((double) getWidth()) || this.scale * ((float) oH()) < ((float) getWidth()))) {
                                            b = b2;
                                        } else {
                                            aA(true);
                                            this.aJR.set(c(this.aJX));
                                            this.aJx.set(this.aJw);
                                            this.aJv = this.scale;
                                            b = 0.0f;
                                        }
                                        b2 = b;
                                    } else if (this.aJB != null) {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * this.aJB.x);
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * this.aJB.y);
                                    } else {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (oH() / 2)));
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (oI() / 2)));
                                    }
                                }
                                this.aJU = b2;
                                aA(true);
                                az(this.aJn);
                                z = true;
                            } else if (!this.aJI) {
                                float abs = Math.abs(motionEvent.getX() - this.aJR.x);
                                float abs2 = Math.abs(motionEvent.getY() - this.aJR.y);
                                float f3 = this.density * 5.0f;
                                if (abs > f3 || abs2 > f3 || this.aJJ) {
                                    this.aJw.x = this.aJx.x + (motionEvent.getX() - this.aJR.x);
                                    this.aJw.y = this.aJx.y + (motionEvent.getY() - this.aJR.y);
                                    b = this.aJw.x;
                                    b2 = this.aJw.y;
                                    aA(true);
                                    z = b != this.aJw.x;
                                    boolean z2 = b2 != this.aJw.y;
                                    boolean z3 = z && abs > abs2 && !this.aJJ;
                                    boolean z4 = z2 && abs2 > abs && !this.aJJ;
                                    boolean z5 = b2 == this.aJw.y && abs2 > 3.0f * f3;
                                    ab.i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(this.aJJ), Float.valueOf(abs), Float.valueOf(abs2), Float.valueOf(f3));
                                    if (!z3 && !z4 && (!z || !z2 || z5 || this.aJJ)) {
                                        this.aJJ = true;
                                    } else if (abs > f3 || abs2 > f3) {
                                        this.aJL = 0;
                                        this.handler.removeMessages(1);
                                        requestDisallowInterceptTouchEvent(false);
                                    }
                                    if (!this.aJo) {
                                        this.aJw.x = this.aJx.x;
                                        this.aJw.y = this.aJx.y;
                                        requestDisallowInterceptTouchEvent(false);
                                    }
                                    az(this.aJn);
                                    z = true;
                                }
                            }
                        }
                        ab.d(this.TAG, "alvinluo Action_Move consumed: %b", Boolean.valueOf(z));
                        if (z) {
                            this.handler.removeMessages(1);
                            invalidate();
                            z = true;
                            break;
                        }
                        break;
                    default:
                        z = false;
                        break;
                }
                d(this.aJy);
                ab.i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", Boolean.valueOf(super.onTouchEvent(motionEvent)), Boolean.valueOf(z));
                if (z || r1) {
                    AppMethodBeat.o(115674);
                    return true;
                }
                AppMethodBeat.o(115674);
                return false;
            } else {
                this.aJI = false;
                this.aJJ = false;
                this.aJL = 0;
                AppMethodBeat.o(115674);
                return true;
            }
        }
        requestDisallowInterceptTouchEvent(true);
        AppMethodBeat.o(115674);
        return true;
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        AppMethodBeat.i(115675);
        ViewParent parent = getParent();
        if (parent != null) {
            ab.i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", Boolean.valueOf(z));
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(115675);
    }

    private float getDoubleTapZoomScale() {
        float f = this.aKy;
        if (this.aKw * 0.7f > f) {
            f = this.aKw;
        } else if (this.aKx * 0.7f > f) {
            f = this.aKx;
        } else {
            f = this.aKy * this.aJr;
        }
        if (((double) f) < 1.0d) {
            f = 1.0f;
        }
        if (f > this.aJf) {
            return this.aJf;
        }
        return f;
    }

    private void a(PointF pointF, PointF pointF2) {
        int i;
        AppMethodBeat.i(115676);
        if (!this.aJo) {
            if (this.aJB != null) {
                pointF.x = this.aJB.x;
                pointF.y = this.aJB.y;
            } else {
                pointF.x = (float) (oH() / 2);
                pointF.y = (float) (oI() / 2);
            }
        }
        float doubleTapZoomScale = getDoubleTapZoomScale();
        ab.i(this.TAG, "alvinluo doubleTapZoom %f", Float.valueOf(doubleTapZoomScale));
        if (((double) this.scale) <= ((double) doubleTapZoomScale) * 0.9d || this.scale == this.aKy) {
            i = 1;
        } else {
            i = 0;
        }
        float f = i != 0 ? doubleTapZoomScale : this.aKy;
        if (this.aJs == 3) {
            a(f, pointF);
        } else if (this.aJs == 2 || i == 0 || !this.aJo) {
            b bVar = new b(this, f, pointF, (byte) 0);
            bVar.aLa = false;
            bVar.duration = (long) this.aJt;
            bVar.aLc = 4;
            bVar.start();
        } else if (this.aJs == 1) {
            b bVar2 = new b(this, doubleTapZoomScale, pointF, pointF2, (byte) 0);
            bVar2.aLa = false;
            bVar2.duration = (long) this.aJt;
            bVar2.aLc = 4;
            bVar2.start();
        }
        invalidate();
        AppMethodBeat.o(115676);
    }

    private void b(PointF pointF, PointF pointF2, float f) {
        AppMethodBeat.i(115677);
        b bVar = new b(this, f, pointF, pointF2, (byte) 0);
        bVar.aLa = false;
        bVar.duration = (long) this.aJu;
        bVar.aLc = 2;
        bVar.start();
        AppMethodBeat.o(115677);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(115678);
        super.onDraw(canvas);
        System.currentTimeMillis();
        if (this.aKf == null) {
            this.aKf = new Paint();
            this.aKf.setAntiAlias(true);
            this.aKf.setFilterBitmap(true);
            this.aKf.setDither(true);
        }
        if ((this.aKg == null || this.aKh == null) && this.aJe) {
            this.aKg = new Paint();
            this.aKg.setTextSize((float) px(20));
            this.aKg.setColor(-65281);
            this.aKg.setStyle(Style.FILL);
            this.aKh = new Paint();
            this.aKh.setColor(-65281);
            this.aKh.setStyle(Style.STROKE);
            this.aKh.setStrokeWidth((float) px(1));
        }
        if (this.aIJ == 0 || this.aIK == 0 || getWidth() == 0 || getHeight() == 0) {
            AppMethodBeat.o(115678);
            return;
        }
        int min;
        int min2;
        if (this.aJd == null && this.aIw != null) {
            min = Math.min(canvas.getMaximumBitmapWidth(), this.aJl);
            min2 = Math.min(canvas.getMaximumBitmapHeight(), this.aJm);
            if (min > Downloads.MIN_WAIT_FOR_NETWORK) {
                min = Downloads.MIN_WAIT_FOR_NETWORK;
            }
            if (min2 > Downloads.MIN_WAIT_FOR_NETWORK) {
                min2 = Downloads.MIN_WAIT_FOR_NETWORK;
            }
            ab.i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", Integer.valueOf(min), Integer.valueOf(min2));
            b(new Point(min, min2));
        }
        if (oC()) {
            float a;
            PointF pointF;
            oE();
            if (!(this.aJZ == null || this.aJZ.aKY == null)) {
                if (this.aJy == null) {
                    this.aJy = new PointF(0.0f, 0.0f);
                }
                this.aJy.set(this.aJw);
                long currentTimeMillis = System.currentTimeMillis() - this.aJZ.time;
                boolean z = currentTimeMillis > this.aJZ.duration;
                currentTimeMillis = Math.min(currentTimeMillis, this.aJZ.duration);
                this.scale = a(this.aJZ.aLb, currentTimeMillis, this.aJZ.aJv, this.aJZ.aKU - this.aJZ.aJv, this.aJZ.duration);
                float a2 = a(this.aJZ.aLb, currentTimeMillis, this.aJZ.aKY.x, this.aJZ.aKZ.x - this.aJZ.aKY.x, this.aJZ.duration);
                a = a(this.aJZ.aLb, currentTimeMillis, this.aJZ.aKY.y, this.aJZ.aKZ.y - this.aJZ.aKY.y, this.aJZ.duration);
                pointF = this.aJw;
                pointF.x -= Q(this.aJZ.aKW.x) - a2;
                pointF = this.aJw;
                pointF.y -= R(this.aJZ.aKW.y) - a;
                boolean z2 = z || this.aJZ.aJv == this.aJZ.aKU;
                aA(z2);
                d(this.aJy);
                az(z);
                if (z) {
                    this.aJZ = null;
                }
                invalidate();
            }
            if (this.aJd != null && oB() && this.aKD) {
                Entry entry;
                int min3 = Math.min(this.aIY, N(this.scale));
                Object obj = null;
                Iterator it = this.aJd.entrySet().iterator();
                while (true) {
                    Object obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    entry = (Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() == min3) {
                        for (com.davemorrissey.labs.subscaleview.c.e eVar : (List) entry.getValue()) {
                            if (eVar.aIB && (eVar.aIA || eVar.bitmap == null)) {
                                obj2 = 1;
                            }
                        }
                    }
                    obj = obj2;
                }
                for (Entry entry2 : this.aJd.entrySet()) {
                    if (((Integer) entry2.getKey()).intValue() == min3 || obj2 != null) {
                        for (com.davemorrissey.labs.subscaleview.c.e eVar2 : (List) entry2.getValue()) {
                            Rect rect = eVar2.aIz;
                            eVar2.aIC.set((int) Q((float) rect.left), (int) R((float) rect.top), (int) Q((float) rect.right), (int) R((float) rect.bottom));
                            if (!eVar2.aIA && eVar2.bitmap != null) {
                                if (this.aKi != null) {
                                    canvas.drawRect(eVar2.aIC, this.aKi);
                                }
                                if (this.aKk == null) {
                                    this.aKk = new Matrix();
                                }
                                this.aKk.reset();
                                a(this.aKm, 0.0f, 0.0f, (float) eVar2.bitmap.getWidth(), 0.0f, (float) eVar2.bitmap.getWidth(), (float) eVar2.bitmap.getHeight(), 0.0f, (float) eVar2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    a(this.aKn, (float) eVar2.aIC.left, (float) eVar2.aIC.top, (float) eVar2.aIC.right, (float) eVar2.aIC.top, (float) eVar2.aIC.right, (float) eVar2.aIC.bottom, (float) eVar2.aIC.left, (float) eVar2.aIC.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    a(this.aKn, (float) eVar2.aIC.right, (float) eVar2.aIC.top, (float) eVar2.aIC.right, (float) eVar2.aIC.bottom, (float) eVar2.aIC.left, (float) eVar2.aIC.bottom, (float) eVar2.aIC.left, (float) eVar2.aIC.top);
                                } else if (getRequiredRotation() == 180) {
                                    a(this.aKn, (float) eVar2.aIC.right, (float) eVar2.aIC.bottom, (float) eVar2.aIC.left, (float) eVar2.aIC.bottom, (float) eVar2.aIC.left, (float) eVar2.aIC.top, (float) eVar2.aIC.right, (float) eVar2.aIC.top);
                                } else if (getRequiredRotation() == 270) {
                                    a(this.aKn, (float) eVar2.aIC.left, (float) eVar2.aIC.bottom, (float) eVar2.aIC.left, (float) eVar2.aIC.top, (float) eVar2.aIC.right, (float) eVar2.aIC.top, (float) eVar2.aIC.right, (float) eVar2.aIC.bottom);
                                }
                                this.aKk.setPolyToPoly(this.aKm, 0, this.aKn, 0, 4);
                                if (!eVar2.bitmap.isRecycled()) {
                                    canvas.drawBitmap(eVar2.bitmap, this.aKk, this.aKf);
                                }
                                if (this.aJe) {
                                    canvas.drawRect(eVar2.aIC, this.aKh);
                                }
                            } else if (eVar2.aIA && this.aJe) {
                                canvas.drawText("LOADING", (float) (eVar2.aIC.left + px(5)), (float) (eVar2.aIC.top + px(35)), this.aKg);
                            }
                            if (eVar2.aIB && this.aJe) {
                                canvas.drawText("ISS " + eVar2.sampleSize + " RECT " + eVar2.aIz.top + "," + eVar2.aIz.left + "," + eVar2.aIz.bottom + "," + eVar2.aIz.right, (float) (eVar2.aIC.left + px(5)), (float) (eVar2.aIC.top + px(15)), this.aKg);
                            }
                        }
                    }
                }
            } else if (!(this.bitmap == null || this.bitmap.isRecycled())) {
                ab.d(this.TAG, "alvinluo onDraw bitmap scale: %f", Float.valueOf(this.scale));
                if (!this.aIS || this.aIU) {
                    if (this.aKk == null) {
                        this.aKk = new Matrix();
                    }
                    this.aKk.reset();
                    min2 = this.bitmap.getWidth();
                    min = this.bitmap.getHeight();
                    if (this.aJG == 90 || this.aJG == 270) {
                        min2 = this.bitmap.getHeight();
                        min = this.bitmap.getWidth();
                    }
                    if (this.aIS) {
                        this.aKk.postScale(this.aKz, this.aKA, ((float) min2) / 2.0f, ((float) min) / 2.0f);
                    }
                    this.aKk.postTranslate((float) ((this.aKu - this.bitmap.getWidth()) / 2), (float) ((this.aKv - this.bitmap.getHeight()) / 2));
                    ab.d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", Float.valueOf(r0), Float.valueOf(a));
                    if (this.aKi != null) {
                        if (this.aKl == null) {
                            this.aKl = new RectF();
                        }
                        this.aKl.set(0.0f, 0.0f, this.aIS ? (float) this.bitmap.getWidth() : (float) this.aIJ, this.aIS ? (float) this.bitmap.getHeight() : (float) this.aIK);
                        this.aKk.mapRect(this.aKl);
                        canvas.drawRect(this.aKl, this.aKi);
                    }
                    canvas.drawBitmap(this.bitmap, this.aKk, this.aKf);
                }
            }
            if (this.aJe) {
                ab.d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", Float.valueOf(this.aJw.x), Float.valueOf(this.aJw.y));
                canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.scale)}) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(oJ())}) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.aJf)}) + ")", (float) px(5), (float) px(15), this.aKg);
                canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.aJw.x)}) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.aJw.y)}), (float) px(5), (float) px(30), this.aKg);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.x)}) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.y)}), (float) px(5), (float) px(45), this.aKg);
                if (this.aJZ != null) {
                    center = c(this.aJZ.aKV);
                    PointF c = c(this.aJZ.aKX);
                    pointF = c(this.aJZ.aKW);
                    canvas.drawCircle(center.x, center.y, (float) px(10), this.aKh);
                    this.aKh.setColor(-65536);
                    canvas.drawCircle(c.x, c.y, (float) px(20), this.aKh);
                    this.aKh.setColor(-16776961);
                    canvas.drawCircle(pointF.x, pointF.y, (float) px(25), this.aKh);
                    this.aKh.setColor(-16711681);
                    canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) px(30), this.aKh);
                }
                if (this.aJR != null) {
                    this.aKh.setColor(-65536);
                    canvas.drawCircle(this.aJR.x, this.aJR.y, (float) px(20), this.aKh);
                }
                if (this.aJX != null) {
                    this.aKh.setColor(-16776961);
                    canvas.drawCircle(Q(this.aJX.x), R(this.aJX.y), (float) px(35), this.aKh);
                }
                if (this.aJY != null && this.aJK) {
                    this.aKh.setColor(-16711681);
                    canvas.drawCircle(this.aJY.x, this.aJY.y, (float) px(30), this.aKh);
                }
                this.aKh.setColor(-65281);
            }
            AppMethodBeat.o(115678);
            return;
        }
        AppMethodBeat.o(115678);
    }

    private static void a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean oB() {
        boolean z = true;
        AppMethodBeat.i(115679);
        if (this.bitmap != null && !this.aIS) {
            AppMethodBeat.o(115679);
            return true;
        } else if (this.aJd != null) {
            Iterator it = this.aJd.entrySet().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() == this.aIY) {
                        for (com.davemorrissey.labs.subscaleview.c.e eVar : (List) entry.getValue()) {
                            if (eVar.aIA || eVar.bitmap == null) {
                                z2 = false;
                            }
                        }
                    }
                    z = z2;
                } else {
                    AppMethodBeat.o(115679);
                    return z2;
                }
            }
        } else {
            AppMethodBeat.o(115679);
            return false;
        }
    }

    private boolean oC() {
        AppMethodBeat.i(115680);
        boolean z = getWidth() > 0 && getHeight() > 0 && this.aIJ > 0 && this.aIK > 0 && (this.bitmap != null || oB());
        if (!this.aKa && z) {
            oE();
            this.aKa = true;
        }
        AppMethodBeat.o(115680);
        return z;
    }

    private boolean oD() {
        AppMethodBeat.i(115681);
        boolean oB = oB();
        if (!this.aKb && oB) {
            oE();
            this.aKb = true;
            ab.i(this.TAG, "alvinluo onImageLoaded");
            oy();
            a(this.aKy, new PointF(0.0f, 0.0f));
            if (this.aJa != -1) {
                this.aJb = System.currentTimeMillis();
                dq((int) (this.aJb - this.aJa));
            }
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(115649);
                    if (!(SubsamplingScaleImageView.this.aJc == null || SubsamplingScaleImageView.this.aJc.isRecycled())) {
                        ab.i(SubsamplingScaleImageView.this.TAG, "alvinluo rotateAndScale fullImageBitmap");
                        SubsamplingScaleImageView.this.aJc = SubsamplingScaleImageView.this.a(SubsamplingScaleImageView.this.aJc, SubsamplingScaleImageView.this.aJF);
                    }
                    SubsamplingScaleImageView.this.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(115648);
                            if (SubsamplingScaleImageView.this.aKc != null) {
                                SubsamplingScaleImageView.this.aKc.l(SubsamplingScaleImageView.this.aJc);
                            }
                            AppMethodBeat.o(115648);
                        }
                    });
                    AppMethodBeat.o(115649);
                }
            }, "rotateAndScaleFullImageBitmap");
        }
        AppMethodBeat.o(115681);
        return oB;
    }

    private synchronized void b(Point point) {
        AppMethodBeat.i(115682);
        j("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aKj = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        a(true, this.aKj);
        this.aIY = N(this.aKj.scale);
        c(point);
        for (com.davemorrissey.labs.subscaleview.c.e eVar : (List) this.aJd.get(Integer.valueOf(this.aIY))) {
            ab.i(this.TAG, "alvinluo tile fullSampleSize: %d", Integer.valueOf(this.aIY));
            a(eVar);
        }
        az(true);
        AppMethodBeat.o(115682);
    }

    private void az(boolean z) {
        AppMethodBeat.i(115683);
        if (this.aIw == null || this.aJd == null) {
            AppMethodBeat.o(115683);
            return;
        }
        int min = Math.min(this.aIY, N(this.scale));
        for (Entry value : this.aJd.entrySet()) {
            for (com.davemorrissey.labs.subscaleview.c.e eVar : (List) value.getValue()) {
                if (eVar.sampleSize < min || (eVar.sampleSize > min && eVar.sampleSize != this.aIY)) {
                    eVar.aIB = false;
                    if (eVar.bitmap != null) {
                        eVar.bitmap.recycle();
                        eVar.bitmap = null;
                    }
                }
                if (eVar.sampleSize == min) {
                    boolean z2;
                    float O = O(0.0f);
                    float O2 = O((float) getWidth());
                    float P = P(0.0f);
                    float P2 = P((float) getHeight());
                    if (O > ((float) eVar.aIz.right) || ((float) eVar.aIz.left) > O2 || P > ((float) eVar.aIz.bottom) || ((float) eVar.aIz.top) > P2) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        eVar.aIB = true;
                        if (!eVar.aIA && eVar.bitmap == null && z) {
                            a(eVar);
                        }
                    } else if (eVar.sampleSize != this.aIY) {
                        eVar.aIB = false;
                        if (eVar.bitmap != null) {
                            eVar.bitmap.recycle();
                            eVar.bitmap = null;
                        }
                    }
                } else if (eVar.sampleSize == this.aIY) {
                    eVar.aIB = true;
                }
            }
        }
        AppMethodBeat.o(115683);
    }

    private void oE() {
        AppMethodBeat.i(115684);
        if (getWidth() == 0 || getHeight() == 0 || this.aIJ <= 0 || this.aIK <= 0) {
            AppMethodBeat.o(115684);
            return;
        }
        if (!(this.aJA == null || this.aJz == null)) {
            this.scale = this.aJz.floatValue();
            if (this.aJw == null) {
                this.aJw = new PointF();
            }
            this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * this.aJA.x);
            this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * this.aJA.y);
            this.aJA = null;
            this.aJz = null;
            this.aJC = false;
            aA(true);
            az(true);
        }
        aA(false);
        AppMethodBeat.o(115684);
    }

    private int N(float f) {
        AppMethodBeat.i(115685);
        if (this.aJh > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.aJh) / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int oH = (int) (((float) oH()) * f);
        int oI = (int) (((float) oI()) * f);
        if (oH == 0 || oI == 0) {
            AppMethodBeat.o(115685);
            return 32;
        }
        if (oI() > oI || oH() > oH) {
            oI = Math.round(((float) oI()) / ((float) oI));
            oH = Math.round(((float) oH()) / ((float) oH));
            if (oI >= oH) {
                oI = oH;
            }
        } else {
            oI = 1;
        }
        oH = 1;
        while (oH * 2 < oI) {
            oH *= 2;
        }
        AppMethodBeat.o(115685);
        return oH;
    }

    private void a(boolean z, g gVar) {
        float paddingLeft;
        float max;
        float f = 0.5f;
        AppMethodBeat.i(115686);
        if (this.aJi == 2 && this.aKa) {
            z = false;
        }
        PointF pointF = gVar.aJw;
        float S = S(gVar.scale);
        float oH = S * ((float) oH());
        float oI = S * ((float) oI());
        if (this.aJi == 3 && this.aKa) {
            pointF.x = Math.max(pointF.x, ((float) (getWidth() / 2)) - oH);
            pointF.y = Math.max(pointF.y, ((float) (getHeight() / 2)) - oI);
        } else if (z) {
            pointF.x = Math.max(pointF.x, ((float) getWidth()) - oH);
            pointF.y = Math.max(pointF.y, ((float) getHeight()) - oI);
        } else {
            pointF.x = Math.max(pointF.x, -oH);
            pointF.y = Math.max(pointF.y, -oI);
        }
        if (getPaddingLeft() > 0 || getPaddingRight() > 0) {
            paddingLeft = ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight()));
        } else {
            paddingLeft = 0.5f;
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.aJi == 3 && this.aKa) {
            paddingLeft = (float) Math.max(0, getWidth() / 2);
            max = (float) Math.max(0, getHeight() / 2);
        } else if (z) {
            paddingLeft = Math.max(0.0f, (((float) getWidth()) - oH) * paddingLeft);
            max = Math.max(0.0f, (((float) getHeight()) - oI) * f);
        } else {
            paddingLeft = (float) Math.max(0, getWidth());
            max = (float) Math.max(0, getHeight());
        }
        pointF.x = Math.min(pointF.x, paddingLeft);
        pointF.y = Math.min(pointF.y, max);
        gVar.scale = S;
        AppMethodBeat.o(115686);
    }

    private void aA(boolean z) {
        byte b;
        AppMethodBeat.i(115687);
        if (this.aJw == null) {
            b = (byte) 1;
            this.aJw = new PointF(0.0f, 0.0f);
        } else {
            b = (byte) 0;
        }
        if (this.aKj == null) {
            this.aKj = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aKj.scale = this.scale;
        this.aKj.aJw.set(this.aJw);
        a(z, this.aKj);
        this.scale = this.aKj.scale;
        this.aJw.set(this.aKj.aJw);
        if (!(b == (byte) 0 || this.aJj == 4)) {
            this.aJw.set(g((float) (oH() / 2), (float) (oI() / 2), this.scale));
        }
        AppMethodBeat.o(115687);
    }

    private void c(Point point) {
        AppMethodBeat.i(115688);
        j("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aJd = new LinkedHashMap();
        int i = this.aIY;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int oH = oH() / i2;
            int oI = oI() / i3;
            int i4 = oH / i;
            int i5 = oI / i;
            while (true) {
                if ((i4 + i2) + 1 > point.x || (((double) i4) > ((double) getWidth()) * 1.25d && i < this.aIY)) {
                    i2++;
                    oH = oH() / i2;
                    i4 = oH / i;
                }
            }
            i4 = i5;
            while (true) {
                if ((i4 + i3) + 1 > point.y || (((double) i4) > ((double) getHeight()) * 1.25d && i < this.aIY)) {
                    i3++;
                    i5 = oI() / i3;
                    i4 = i5 / i;
                    oI = i5;
                }
            }
            ArrayList arrayList = new ArrayList(i2 * i3);
            int i6 = 0;
            while (i6 < i2) {
                for (int i7 = 0; i7 < i3; i7++) {
                    com.davemorrissey.labs.subscaleview.c.e eVar = new com.davemorrissey.labs.subscaleview.c.e();
                    eVar.sampleSize = i;
                    eVar.aIB = i == this.aIY;
                    int i8 = i6 * oH;
                    int i9 = i7 * oI;
                    i5 = i6 == i2 + -1 ? oH() : (i6 + 1) * oH;
                    if (i7 == i3 - 1) {
                        i4 = oI();
                    } else {
                        i4 = (i7 + 1) * oI;
                    }
                    eVar.aIz = new Rect(i8, i9, i5, i4);
                    eVar.aIC = new Rect(0, 0, 0, 0);
                    eVar.aID = new Rect(eVar.aIz);
                    arrayList.add(eVar);
                }
                i6++;
            }
            this.aJd.put(Integer.valueOf(i), arrayList);
            if (i != 1) {
                i /= 2;
            } else {
                AppMethodBeat.o(115688);
                return;
            }
        }
    }

    public final synchronized void a(com.davemorrissey.labs.subscaleview.a.d dVar, int i, int i2, int i3) {
        AppMethodBeat.i(115689);
        j("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.aIJ), Integer.valueOf(this.aIK), Integer.valueOf(i3));
        if (this.aIJ > 0 && this.aIK > 0 && !(this.aIJ == i && this.aIK == i2)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.aIX) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aKc != null && this.aIX) {
                    this.aKc.oM();
                }
                this.aIS = false;
                this.aIX = false;
            }
        }
        this.aIw = dVar;
        this.aIJ = i;
        this.aIK = i2;
        this.aJF = i3;
        oC();
        if (!oD() && this.aJl > 0 && this.aJl != aJk && this.aJm > 0 && this.aJm != aJk && getWidth() > 0 && getHeight() > 0) {
            b(new Point(this.aJl, this.aJm));
        }
        invalidate();
        requestLayout();
        System.currentTimeMillis();
        AppMethodBeat.o(115689);
    }

    private void setFullImageBitmap(final Bitmap bitmap) {
        AppMethodBeat.i(115690);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115645);
                if (bitmap != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SubsamplingScaleImageView.this.aJc = SubsamplingScaleImageView.this.a(bitmap, SubsamplingScaleImageView.this.aJF);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ab.i(SubsamplingScaleImageView.this.TAG, "alvinluo rotate and scale fullImageBitmap cost: %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                }
                AppMethodBeat.o(115645);
            }
        }, "rotateAndScaleBitmap");
        AppMethodBeat.o(115690);
    }

    public final synchronized void b(com.davemorrissey.labs.subscaleview.c.e eVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(115691);
            this.aJa = System.currentTimeMillis();
            String str = this.TAG;
            String str2 = "alvinluo onTileLoaded sampleSize: %d, bitmap == null: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(eVar.sampleSize);
            if (eVar.bitmap != null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.d(str, str2, objArr);
            if (eVar.sampleSize == this.aIY && eVar.bitmap != null && this.aIZ) {
                ab.i(this.TAG, "alvinluo onTileLoaded set fullImageBitmap");
                this.aIZ = false;
                this.aJc = eVar.bitmap;
            }
            oC();
            oD();
            if (oB() && this.bitmap != null) {
                if (!this.aIX) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aKc != null && this.aIX) {
                    this.aKc.oM();
                }
                this.aIS = false;
                this.aIX = false;
            }
            invalidate();
            AppMethodBeat.o(115691);
        }
    }

    public final Bitmap a(Bitmap bitmap, int i) {
        AppMethodBeat.i(115692);
        if (bitmap == null) {
            ab.e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
            AppMethodBeat.o(115692);
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 1.0f);
        if (i != 0) {
            matrix.postRotate((float) i);
        }
        ab.d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", Boolean.valueOf(matrix.isIdentity()));
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(115692);
            return null;
        } else if (matrix.isIdentity()) {
            AppMethodBeat.o(115692);
            return bitmap;
        } else {
            try {
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                AppMethodBeat.o(115692);
                return bitmap;
            } catch (OutOfMemoryError e) {
                ab.printErrStackTrace(this.TAG, e, "alvinluo createBitmap oom", new Object[0]);
                aKp = Config.RGB_565;
                AppMethodBeat.o(115692);
                return null;
            }
        }
    }

    public final synchronized void a(Bitmap bitmap, Integer num) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(115693);
            ab.i(this.TAG, "alvinluo onPreviewLoaded");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aKb) {
                if (this.bitmap != null) {
                    this.bitmap.recycle();
                }
                AppMethodBeat.o(115693);
            } else {
                if (this.aJH == null) {
                    if (num != null) {
                        this.aJG = num.intValue();
                    }
                    this.bitmap = bitmap;
                } else if (this.aJH.width() > 0 && this.aJH.height() > 0) {
                    this.bitmap = Bitmap.createBitmap(bitmap, this.aJH.left, this.aJH.top, this.aJH.width(), this.aJH.height());
                    this.aJG = 0;
                }
                this.aIS = true;
                this.aIU = false;
                this.aIV = this.bitmap.getWidth();
                this.aIW = this.bitmap.getHeight();
                if (this.bitmap != null && this.aIS) {
                    boolean z2;
                    int oH = oH();
                    int oI = oI();
                    boolean z3 = ((float) oH) > ((float) oI) * 2.2f;
                    if (((float) oI) > ((float) oH) * 2.2f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z3 || oH <= this.aKu) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z2 || oI <= this.aKv) {
                        z = false;
                    }
                    oy();
                    if (z) {
                        this.aKz = (((float) this.aKu) * 1.0f) / ((float) oF());
                        this.aKA = (((float) this.aKv) * 1.0f) / ((float) oG());
                    } else if (z3) {
                        this.aKz = (((float) this.aKu) * 1.0f) / ((float) oF());
                        this.aKA = (this.aKy * ((float) oI())) / ((float) oG());
                    } else {
                        this.aKz = (this.aKy * ((float) oH())) / ((float) oF());
                        this.aKA = (this.aKy * ((float) oI())) / ((float) oG());
                    }
                    ab.i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b", Float.valueOf(this.aKz), Float.valueOf(this.aKA), Integer.valueOf(oG()), Integer.valueOf(oF()), Boolean.valueOf(z), Boolean.valueOf(z3));
                }
                this.aIU = true;
                if (oC()) {
                    invalidate();
                    requestLayout();
                }
                dp((int) (System.currentTimeMillis() - currentTimeMillis));
                ab.i(this.TAG, "alvinluo onPreviewLoaded");
                if (!(this.aIT || this.aKc == null)) {
                    this.aKc.oL();
                }
                AppMethodBeat.o(115693);
            }
        }
    }

    public int getPreviewOrientation() {
        return this.aJG;
    }

    public int getPreviewWidth() {
        return this.aIV;
    }

    public int getPreviewHeight() {
        return this.aIW;
    }

    public final synchronized void b(Bitmap bitmap, int i, boolean z) {
        AppMethodBeat.i(115694);
        j("onImageLoaded has bitmap", new Object[0]);
        if (this.aIJ > 0 && this.aIK > 0 && !(this.aIJ == bitmap.getWidth() && this.aIK == bitmap.getHeight())) {
            reset(false);
        }
        if (!(this.bitmap == null || this.aIX)) {
            this.bitmap.recycle();
        }
        if (!(this.bitmap == null || !this.aIX || this.aKc == null)) {
            this.aKc.oM();
        }
        this.aIS = false;
        this.aIX = z;
        this.bitmap = bitmap;
        this.aIJ = bitmap.getWidth();
        this.aIK = bitmap.getHeight();
        this.aJF = i;
        final boolean oC = oC();
        final boolean oD = oD();
        final int i2 = i;
        final Bitmap bitmap2 = bitmap;
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115647);
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 != 0) {
                    SubsamplingScaleImageView.this.bitmap = SubsamplingScaleImageView.this.a(bitmap2, i2);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ab.i(SubsamplingScaleImageView.this.TAG, "alvinluo onImageLoaded rotaeAndScaleBitmap %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                SubsamplingScaleImageView.this.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(115646);
                        if (oC || oD) {
                            SubsamplingScaleImageView.this.invalidate();
                            SubsamplingScaleImageView.this.requestLayout();
                        }
                        AppMethodBeat.o(115646);
                    }
                });
                AppMethodBeat.o(115647);
            }
        }, "rotateAndScaleBitmap");
        AppMethodBeat.o(115694);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int h(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        int i = 0;
        AppMethodBeat.i(115695);
        int i2;
        if (str.startsWith(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT)) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            i2 = query.getInt(0);
                            if (!aIN.contains(Integer.valueOf(i2)) || i2 == -1) {
                                ab.w(this.TAG, "Unsupported orientation: ".concat(String.valueOf(i2)));
                            }
                            if (query != null) {
                                query.close();
                                i = i2;
                            }
                            i = i2;
                        }
                    } catch (Exception e) {
                        cursor = query;
                        try {
                            ab.w(this.TAG, "Could not get orientation of image from media store");
                            if (cursor != null) {
                                cursor.close();
                                AppMethodBeat.o(115695);
                                return i;
                            }
                            i2 = 0;
                            i = i2;
                            AppMethodBeat.o(115695);
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            AppMethodBeat.o(115695);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        AppMethodBeat.o(115695);
                        throw th;
                    }
                }
                i2 = 0;
                if (query != null) {
                }
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th32) {
                th = th32;
                if (cursor2 != null) {
                }
                AppMethodBeat.o(115695);
                throw th;
            }
            i = i2;
        } else if (str.startsWith("file:///") && !str.startsWith("file:///android_asset/")) {
            try {
                i2 = new android.support.d.a(str.substring(7)).getAttributeInt(android.support.d.a.TAG_ORIENTATION, 1);
                if (!(i2 == 1 || i2 == 0)) {
                    if (i2 == 6) {
                        i = 90;
                    } else if (i2 == 3) {
                        i = 180;
                    } else if (i2 == 8) {
                        i = 270;
                    } else {
                        ab.w(this.TAG, "Unsupported EXIF orientation: ".concat(String.valueOf(i2)));
                    }
                }
            } catch (Exception e3) {
                ab.w(this.TAG, "Could not get EXIF orientation of image");
            }
        }
        AppMethodBeat.o(115695);
        return i;
    }

    public void setMaxTileSize(int i) {
        this.aJl = i;
        this.aJm = i;
    }

    private int oF() {
        AppMethodBeat.i(115696);
        if (this.bitmap == null || !this.aIS) {
            AppMethodBeat.o(115696);
            return 0;
        }
        int i = this.aJG;
        if (i == 90 || i == 270) {
            i = this.bitmap.getHeight();
            AppMethodBeat.o(115696);
            return i;
        }
        i = this.bitmap.getWidth();
        AppMethodBeat.o(115696);
        return i;
    }

    private int oG() {
        AppMethodBeat.i(115697);
        if (this.bitmap == null || !this.aIS) {
            AppMethodBeat.o(115697);
            return 0;
        }
        int i = this.aJG;
        if (i == 90 || i == 270) {
            i = this.bitmap.getWidth();
            AppMethodBeat.o(115697);
            return i;
        }
        i = this.bitmap.getHeight();
        AppMethodBeat.o(115697);
        return i;
    }

    private int oH() {
        AppMethodBeat.i(115698);
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            requiredRotation = this.aIK;
            AppMethodBeat.o(115698);
            return requiredRotation;
        }
        requiredRotation = this.aIJ;
        AppMethodBeat.o(115698);
        return requiredRotation;
    }

    private int oI() {
        AppMethodBeat.i(115699);
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            requiredRotation = this.aIJ;
            AppMethodBeat.o(115699);
            return requiredRotation;
        }
        requiredRotation = this.aIK;
        AppMethodBeat.o(115699);
        return requiredRotation;
    }

    public int getRequiredRotation() {
        if (this.orientation == -1) {
            return this.aJF;
        }
        return this.orientation;
    }

    private static float b(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(115700);
        float f5 = f - f2;
        float f6 = f3 - f4;
        f5 = (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
        AppMethodBeat.o(115700);
        return f5;
    }

    private float O(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (f - this.aJw.x) / this.scale;
    }

    private float P(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (f - this.aJw.y) / this.scale;
    }

    public final PointF b(PointF pointF) {
        AppMethodBeat.i(115701);
        PointF a = a(pointF.x, pointF.y, new PointF());
        AppMethodBeat.o(115701);
        return a;
    }

    private PointF a(float f, float f2, PointF pointF) {
        AppMethodBeat.i(115702);
        if (this.aJw == null) {
            AppMethodBeat.o(115702);
            return null;
        }
        pointF.set(O(f), P(f2));
        AppMethodBeat.o(115702);
        return pointF;
    }

    private float Q(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.aJw.x;
    }

    private float R(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.aJw.y;
    }

    public final PointF c(PointF pointF) {
        AppMethodBeat.i(115703);
        PointF b = b(pointF.x, pointF.y, new PointF());
        AppMethodBeat.o(115703);
        return b;
    }

    private PointF b(float f, float f2, PointF pointF) {
        AppMethodBeat.i(115704);
        if (this.aJw == null) {
            AppMethodBeat.o(115704);
            return null;
        }
        pointF.set(Q(f), R(f2));
        AppMethodBeat.o(115704);
        return pointF;
    }

    private PointF g(float f, float f2, float f3) {
        AppMethodBeat.i(115705);
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.aKj == null) {
            this.aKj = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aKj.scale = f3;
        this.aKj.aJw.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        a(true, this.aKj);
        PointF pointF = this.aKj.aJw;
        AppMethodBeat.o(115705);
        return pointF;
    }

    private float oJ() {
        AppMethodBeat.i(115706);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        float max;
        if (this.aJj == 2 || this.aJj == 4) {
            max = Math.max(((float) (getWidth() - paddingLeft)) / ((float) oH()), ((float) (getHeight() - paddingBottom)) / ((float) oI()));
            AppMethodBeat.o(115706);
            return max;
        } else if (this.aJj != 3 || this.aJg <= 0.0f) {
            max = Math.min(((float) (getWidth() - paddingLeft)) / ((float) oH()), ((float) (getHeight() - paddingBottom)) / ((float) oI()));
            AppMethodBeat.o(115706);
            return max;
        } else {
            max = this.aJg;
            AppMethodBeat.o(115706);
            return max;
        }
    }

    private float S(float f) {
        AppMethodBeat.i(115707);
        float max = Math.max(oJ(), f);
        AppMethodBeat.o(115707);
        return max;
    }

    private static float a(int i, long j, float f, float f2, long j2) {
        AppMethodBeat.i(115708);
        float c;
        switch (i) {
            case 1:
                c = c(j, f, f2, j2);
                AppMethodBeat.o(115708);
                return c;
            case 2:
                c = d(j, f, f2, j2);
                AppMethodBeat.o(115708);
                return c;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unexpected easing type: ".concat(String.valueOf(i)));
                AppMethodBeat.o(115708);
                throw illegalStateException;
        }
    }

    private static float c(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((f3 - 2.0f) * ((-f2) * f3)) + f;
    }

    private static float d(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / (((float) j2) / 2.0f);
        if (f3 < 1.0f) {
            return (f3 * ((f2 / 2.0f) * f3)) + f;
        }
        f3 -= 1.0f;
        return (((f3 * (f3 - 2.0f)) - 1.0f) * ((-f2) / 2.0f)) + f;
    }

    public final void j(String str, Object... objArr) {
        AppMethodBeat.i(115709);
        ab.d(this.TAG, String.format(str, objArr));
        AppMethodBeat.o(115709);
    }

    private int px(int i) {
        return (int) (this.density * ((float) i));
    }

    public final void setRegionDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> cls) {
        AppMethodBeat.i(115710);
        if (cls == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder class cannot be set to null");
            AppMethodBeat.o(115710);
            throw illegalArgumentException;
        }
        this.aJQ = new com.davemorrissey.labs.subscaleview.a.a(cls);
        AppMethodBeat.o(115710);
    }

    public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> bVar) {
        AppMethodBeat.i(115711);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder factory cannot be set to null");
            AppMethodBeat.o(115711);
            throw illegalArgumentException;
        }
        this.aJQ = bVar;
        AppMethodBeat.o(115711);
    }

    public final void setBitmapDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> cls) {
        AppMethodBeat.i(115712);
        if (cls == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder class cannot be set to null");
            AppMethodBeat.o(115712);
            throw illegalArgumentException;
        }
        this.aJP = new com.davemorrissey.labs.subscaleview.a.a(cls);
        AppMethodBeat.o(115712);
    }

    public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> bVar) {
        AppMethodBeat.i(115713);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder factory cannot be set to null");
            AppMethodBeat.o(115713);
            throw illegalArgumentException;
        }
        this.aJP = bVar;
        AppMethodBeat.o(115713);
    }

    public final void setPanLimit(int i) {
        AppMethodBeat.i(115714);
        if (aIQ.contains(Integer.valueOf(i))) {
            this.aJi = i;
            if (this.aKa) {
                aA(true);
                invalidate();
            }
            AppMethodBeat.o(115714);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(i)));
        AppMethodBeat.o(115714);
        throw illegalArgumentException;
    }

    public final void setMinimumScaleType(int i) {
        AppMethodBeat.i(115715);
        if (aIR.contains(Integer.valueOf(i))) {
            this.aJj = i;
            if (this.aKa) {
                aA(true);
                invalidate();
            }
            AppMethodBeat.o(115715);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(i)));
        AppMethodBeat.o(115715);
        throw illegalArgumentException;
    }

    public final void setMaxScale(float f) {
        this.aJf = f;
    }

    public final void setMinScale(float f) {
        this.aJg = f;
    }

    public final void setMinimumDpi(int i) {
        AppMethodBeat.i(115716);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
        AppMethodBeat.o(115716);
    }

    public final void setMaximumDpi(int i) {
        AppMethodBeat.i(115717);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
        AppMethodBeat.o(115717);
    }

    public float getMaxScale() {
        return this.aJf;
    }

    public final float getMinScale() {
        AppMethodBeat.i(115718);
        float oJ = oJ();
        AppMethodBeat.o(115718);
        return oJ;
    }

    public void setMinimumTileDpi(int i) {
        AppMethodBeat.i(115719);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aJh = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, (float) i);
        if (this.aKa) {
            reset(false);
            invalidate();
        }
        AppMethodBeat.o(115719);
    }

    public final PointF getCenter() {
        AppMethodBeat.i(115720);
        PointF a = a((float) (getWidth() / 2), (float) (getHeight() / 2), new PointF());
        AppMethodBeat.o(115720);
        return a;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void a(float f, PointF pointF) {
        AppMethodBeat.i(115721);
        this.aJZ = null;
        this.aJC = true;
        this.aJz = Float.valueOf(f);
        this.aJA = pointF;
        this.aJB = pointF;
        invalidate();
        AppMethodBeat.o(115721);
    }

    public final int getSWidth() {
        return this.aIJ;
    }

    public final int getSHeight() {
        return this.aIK;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        AppMethodBeat.i(115722);
        int requiredRotation = getRequiredRotation();
        AppMethodBeat.o(115722);
        return requiredRotation;
    }

    public final b getState() {
        AppMethodBeat.i(115723);
        if (this.aJw == null || this.aIJ <= 0 || this.aIK <= 0) {
            AppMethodBeat.o(115723);
            return null;
        }
        b bVar = new b(getScale(), getCenter(), getOrientation());
        AppMethodBeat.o(115723);
        return bVar;
    }

    public final void setZoomEnabled(boolean z) {
        this.aJp = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.aJq = z;
    }

    public final void setPanEnabled(boolean z) {
        AppMethodBeat.i(115724);
        this.aJo = z;
        if (!(z || this.aJw == null)) {
            this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (oH() / 2)));
            this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (oI() / 2)));
            if (this.aKa) {
                az(true);
                invalidate();
            }
        }
        AppMethodBeat.o(115724);
    }

    public final void setTileBackgroundColor(int i) {
        AppMethodBeat.i(115725);
        if (Color.alpha(i) == 0) {
            this.aKi = null;
        } else {
            this.aKi = new Paint();
            this.aKi.setStyle(Style.FILL);
            this.aKi.setColor(i);
        }
        invalidate();
        AppMethodBeat.o(115725);
    }

    public final void setDoubleTapZoomScale(float f) {
        this.aJr = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        AppMethodBeat.i(115726);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
        AppMethodBeat.o(115726);
    }

    public final void setDoubleTapZoomStyle(int i) {
        AppMethodBeat.i(115727);
        if (aIO.contains(Integer.valueOf(i))) {
            this.aJs = i;
            AppMethodBeat.o(115727);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(i)));
        AppMethodBeat.o(115727);
        throw illegalArgumentException;
    }

    public final void setDoubleTapZoomDuration(int i) {
        AppMethodBeat.i(115728);
        this.aJt = Math.max(0, i);
        AppMethodBeat.o(115728);
    }

    public void setExecutor(Executor executor) {
        AppMethodBeat.i(115729);
        if (executor == null) {
            NullPointerException nullPointerException = new NullPointerException("Executor must not be null");
            AppMethodBeat.o(115729);
            throw nullPointerException;
        }
        this.executor = executor;
        AppMethodBeat.o(115729);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.aJn = z;
    }

    public final void setDebug(boolean z) {
        this.aJe = z;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.aKe = onLongClickListener;
    }

    public void setOnImageEventListener(e eVar) {
        this.aKc = eVar;
    }

    public void setOnStateChangedListener(f fVar) {
        this.aKd = fVar;
    }

    private void d(PointF pointF) {
        AppMethodBeat.i(115730);
        if (!(this.aKd == null || this.aJw.equals(pointF))) {
            getCenter();
        }
        AppMethodBeat.o(115730);
    }
}
