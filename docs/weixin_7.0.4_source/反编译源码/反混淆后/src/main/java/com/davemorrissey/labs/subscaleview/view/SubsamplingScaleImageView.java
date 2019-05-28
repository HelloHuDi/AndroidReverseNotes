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
import android.support.p056d.C0252a;
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
import com.davemorrissey.labs.subscaleview.C45006a.C37201a;
import com.davemorrissey.labs.subscaleview.p1158a.C17564b;
import com.davemorrissey.labs.subscaleview.p1158a.C17565d;
import com.davemorrissey.labs.subscaleview.p1158a.C24650a;
import com.davemorrissey.labs.subscaleview.p1158a.C25467c;
import com.davemorrissey.labs.subscaleview.p1158a.C37202e;
import com.davemorrissey.labs.subscaleview.p1447d.C31984a;
import com.davemorrissey.labs.subscaleview.p1519c.C37203b;
import com.davemorrissey.labs.subscaleview.p1519c.C37204e;
import com.davemorrissey.labs.subscaleview.p1519c.C41575c;
import com.davemorrissey.labs.subscaleview.p1519c.C41576d;
import com.davemorrissey.labs.subscaleview.p1519c.C45007a;
import com.davemorrissey.labs.subscaleview.p793b.C17566a;
import com.davemorrissey.labs.subscaleview.p793b.C25468b;
import com.davemorrissey.labs.subscaleview.p793b.C44646c;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
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
    private static C45007a aKq = new C17566a();
    private static C41576d aKr = new C44646c();
    private static C41575c aKs = new C25468b();
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
    private C17565d aIw;
    private PointF aJA;
    private PointF aJB;
    private boolean aJC;
    private C31985a aJD;
    private C31985a aJE;
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
    private C17564b<? extends C17565d> aJP = new C24650a(C37202e.class);
    private C17564b<? extends C17565d> aJQ = new C24650a(C37202e.class);
    private PointF aJR;
    private float aJS;
    private final float aJT;
    private float aJU;
    private boolean aJV;
    private PointF aJW;
    private PointF aJX;
    private PointF aJY;
    private C0790a aJZ;
    private long aJa = -1;
    private long aJb = -1;
    private Bitmap aJc;
    private Map<Integer, List<C37204e>> aJd;
    private boolean aJe = false;
    private float aJf = 2.0f;
    private float aJg = m1844oJ();
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
    private C31984a aKH = new C31984a();
    private C0791c aKI = new C07971();
    private boolean aKJ = false;
    private boolean aKK = false;
    private boolean aKL = false;
    private float aKM;
    private float aKN;
    private boolean aKa;
    private boolean aKb;
    private C0795e aKc;
    private C0799f aKd;
    private OnLongClickListener aKe;
    private Paint aKf;
    private Paint aKg;
    private Paint aKh;
    private Paint aKi;
    private C0796g aKj;
    private Matrix aKk;
    private RectF aKl;
    private float[] aKm = new float[8];
    private float[] aKn = new float[8];
    private Matrix aKo;
    private LinkedList<C37203b> aKt = new LinkedList();
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

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$d */
    public interface C0786d {
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$a */
    static class C0790a {
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
        C0786d aLd;
        long duration;
        long time;

        private C0790a() {
            AppMethodBeat.m2504i(115650);
            this.duration = 200;
            this.aLa = true;
            this.aLb = 2;
            this.aLc = 1;
            this.time = System.currentTimeMillis();
            AppMethodBeat.m2505o(115650);
        }

        /* synthetic */ C0790a(byte b) {
            this();
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$c */
    public interface C0791c {
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$7 */
    class C07927 implements Runnable {

        /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$7$1 */
        class C07931 implements Runnable {
            C07931() {
            }

            public final void run() {
                AppMethodBeat.m2504i(115648);
                if (SubsamplingScaleImageView.this.aKc != null) {
                    SubsamplingScaleImageView.this.aKc.mo2344l(SubsamplingScaleImageView.this.aJc);
                }
                AppMethodBeat.m2505o(115648);
            }
        }

        C07927() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115649);
            if (!(SubsamplingScaleImageView.this.aJc == null || SubsamplingScaleImageView.this.aJc.isRecycled())) {
                C4990ab.m7416i(SubsamplingScaleImageView.this.TAG, "alvinluo rotateAndScale fullImageBitmap");
                SubsamplingScaleImageView.this.aJc = SubsamplingScaleImageView.this.mo2260a(SubsamplingScaleImageView.this.aJc, SubsamplingScaleImageView.this.aJF);
            }
            SubsamplingScaleImageView.this.post(new C07931());
            AppMethodBeat.m2505o(115649);
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$b */
    public final class C0794b {
        boolean aLa;
        int aLb;
        int aLc;
        private C0786d aLd;
        private final float aLe;
        private final PointF aLf;
        private final PointF aLg;
        boolean aLh;
        long duration;

        /* synthetic */ C0794b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2, byte b) {
            this(f, pointF, pointF2);
        }

        private C0794b(PointF pointF) {
            AppMethodBeat.m2504i(115651);
            this.duration = 500;
            this.aLb = 2;
            this.aLc = 1;
            this.aLa = true;
            this.aLh = true;
            this.aLe = SubsamplingScaleImageView.this.scale;
            this.aLf = pointF;
            this.aLg = null;
            AppMethodBeat.m2505o(115651);
        }

        private C0794b(float f, PointF pointF) {
            this.duration = 500;
            this.aLb = 2;
            this.aLc = 1;
            this.aLa = true;
            this.aLh = true;
            this.aLe = f;
            this.aLf = pointF;
            this.aLg = null;
        }

        private C0794b(float f, PointF pointF, PointF pointF2) {
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
            AppMethodBeat.m2504i(115652);
            if (!(SubsamplingScaleImageView.this.aJZ == null || SubsamplingScaleImageView.this.aJZ.aLd == null)) {
                try {
                    SubsamplingScaleImageView.this.aJZ;
                } catch (Exception e) {
                    C4990ab.m7421w(SubsamplingScaleImageView.this.TAG, "Error thrown by animation listener", e);
                }
            }
            int width = (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2) + SubsamplingScaleImageView.this.getPaddingLeft();
            int height = (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2) + SubsamplingScaleImageView.this.getPaddingTop();
            float b = SubsamplingScaleImageView.m1807b(SubsamplingScaleImageView.this, this.aLe);
            PointF a = this.aLh ? SubsamplingScaleImageView.m1793a(SubsamplingScaleImageView.this, this.aLf.x, this.aLf.y, b, new PointF()) : this.aLf;
            SubsamplingScaleImageView.this.aJZ = new C0790a();
            SubsamplingScaleImageView.this.aJZ.aJv = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.aJZ.aKU = b;
            SubsamplingScaleImageView.this.aJZ.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.aJZ.aKX = a;
            SubsamplingScaleImageView.this.aJZ.aKV = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.aJZ.aKW = a;
            SubsamplingScaleImageView.this.aJZ.aKY = SubsamplingScaleImageView.this.mo2268c(a);
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
                C0796g c0796g = new C0796g(b, new PointF(f, f2), (byte) 0);
                SubsamplingScaleImageView.m1801a(SubsamplingScaleImageView.this, c0796g);
                SubsamplingScaleImageView.this.aJZ.aKZ = new PointF((c0796g.aJw.x - f) + this.aLg.x, (c0796g.aJw.y - f2) + this.aLg.y);
            }
            SubsamplingScaleImageView.this.invalidate();
            AppMethodBeat.m2505o(115652);
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$e */
    public interface C0795e {
        /* renamed from: a */
        void mo2341a(C25467c c25467c);

        /* renamed from: b */
        void mo2342b(C25467c c25467c);

        /* renamed from: c */
        void mo2343c(C25467c c25467c);

        /* renamed from: l */
        void mo2344l(Bitmap bitmap);

        /* renamed from: oL */
        void mo2345oL();

        /* renamed from: oM */
        void mo2346oM();
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$g */
    static class C0796g {
        PointF aJw;
        float scale;

        /* synthetic */ C0796g(float f, PointF pointF, byte b) {
            this(f, pointF);
        }

        private C0796g(float f, PointF pointF) {
            this.scale = f;
            this.aJw = pointF;
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$1 */
    class C07971 implements C0791c {
        C07971() {
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$f */
    public interface C0799f {
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$2 */
    class C08002 implements Callback {
        C08002() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(115640);
            if (message.what == 1 && SubsamplingScaleImageView.this.aKe != null) {
                SubsamplingScaleImageView.this.aJL = 0;
                SubsamplingScaleImageView.m1800a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.aKe);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.m1821d(SubsamplingScaleImageView.this);
            }
            AppMethodBeat.m2505o(115640);
            return true;
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$4 */
    class C08014 extends SimpleOnGestureListener {
        C08014() {
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(115644);
            SubsamplingScaleImageView.this.performClick();
            AppMethodBeat.m2505o(115644);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(115738);
        AppMethodBeat.m2505o(115738);
    }

    /* renamed from: do */
    public final synchronized void mo2270do(int i) {
        AppMethodBeat.m2504i(115653);
        if (this.aKH != null) {
            C31984a c31984a = this.aKH;
            c31984a.aIF += i;
            C4990ab.m7411d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(c31984a.aIF));
        }
        AppMethodBeat.m2505o(115653);
    }

    /* renamed from: dp */
    public final synchronized void mo2271dp(int i) {
        AppMethodBeat.m2504i(115654);
        if (this.aKH != null) {
            C31984a c31984a = this.aKH;
            c31984a.aIE += i;
            C4990ab.m7411d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(c31984a.aIE));
        }
        AppMethodBeat.m2505o(115654);
    }

    /* renamed from: dq */
    public final synchronized void mo2272dq(int i) {
        AppMethodBeat.m2504i(115655);
        if (this.aKH != null) {
            C31984a c31984a = this.aKH;
            c31984a.aIG += i;
            C4990ab.m7411d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(c31984a.aIG));
        }
        AppMethodBeat.m2505o(115655);
    }

    public synchronized C31984a getImageDecodeRecord() {
        return this.aKH;
    }

    public void setEdgeSwipeListener(C0791c c0791c) {
        this.aKI = c0791c;
    }

    public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.aKG = onAttachStateChangeListener;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(115656);
        super.onAttachedToWindow();
        if (this.aKG != null) {
            this.aKG.onViewAttachedToWindow(this);
        }
        this.cancelled = false;
        AppMethodBeat.m2505o(115656);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(115657);
        super.onDetachedFromWindow();
        if (!this.cancelled) {
            this.cancelled = true;
            C4990ab.m7417i(this.TAG, "alvinluo cancelAllTileLoadTask, task size: %d", Integer.valueOf(this.aKt.size()));
            Iterator it = this.aKt.iterator();
            while (it.hasNext()) {
                ((C37203b) it.next()).cancel();
            }
            this.aKt.clear();
        }
        if (this.aKG != null) {
            this.aKG.onViewDetachedFromWindow(this);
        }
        AppMethodBeat.m2505o(115657);
    }

    /* renamed from: a */
    private void m1797a(C37204e c37204e) {
        AppMethodBeat.m2504i(115658);
        if (this.cancelled) {
            C4990ab.m7416i(this.TAG, "alvinluo newLoadTask, has cancelled and ignore");
            AppMethodBeat.m2505o(115658);
            return;
        }
        C37203b a = aKr.mo66600a(this, this.aIw, c37204e);
        a.mo18684ou();
        this.aKt.add(a);
        AppMethodBeat.m2505o(115658);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(115659);
        setDoubleTapZoomScale(2.0f);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.aKo = new Matrix();
        this.handler = new Handler(new C08002());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C37201a.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(1)) {
                String string = obtainStyledAttributes.getString(1);
                if (string != null && string.length() > 0) {
                    if (string == null) {
                        NullPointerException nullPointerException = new NullPointerException("Asset name must not be null");
                        AppMethodBeat.m2505o(115659);
                        throw nullPointerException;
                    }
                    setImage(C31985a.m51974af("file:///android_asset/".concat(String.valueOf(string))).mo52092ox());
                }
            }
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId > 0) {
                    setImage(new C31985a(resourceId).mo52092ox());
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
        AppMethodBeat.m2505o(115659);
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
        AppMethodBeat.m2504i(115660);
        this.aKD = z;
        invalidate();
        AppMethodBeat.m2505o(115660);
    }

    public static Config getPreferredBitmapConfig() {
        return aKp;
    }

    public static void setPreferredBitmapConfig(Config config) {
        aKp = config;
    }

    public final void setOrientation(int i) {
        AppMethodBeat.m2504i(115661);
        if (aIN.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(false);
            invalidate();
            requestLayout();
            AppMethodBeat.m2505o(115661);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid orientation: ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(115661);
        throw illegalArgumentException;
    }

    public Rect getsRegion() {
        return this.aIL;
    }

    public void setsRegion(Rect rect) {
        this.aIL = rect;
    }

    public void setScaleRate(float f) {
        AppMethodBeat.m2504i(115662);
        this.aKy = f;
        this.aJf = 2.0f;
        this.aJg = 1.0f;
        m1847oz();
        m1835oA();
        AppMethodBeat.m2505o(115662);
    }

    /* renamed from: oy */
    private void m1846oy() {
        AppMethodBeat.m2504i(115663);
        C4990ab.m7417i(this.TAG, "alvinluo initScaleRate: %f", Float.valueOf(this.aKy));
        m1847oz();
        m1835oA();
        AppMethodBeat.m2505o(115663);
    }

    /* renamed from: oz */
    private void m1847oz() {
        AppMethodBeat.m2504i(115664);
        this.aJf = (getDoubleTapZoomScale() * 2.0f) * this.aKB;
        AppMethodBeat.m2505o(115664);
    }

    /* renamed from: oA */
    private void m1835oA() {
        AppMethodBeat.m2504i(115665);
        this.aJg = Math.min(m1844oJ(), this.aKy * 0.75f);
        AppMethodBeat.m2505o(115665);
    }

    public void setImageMatrix(Matrix matrix) {
        Object matrix2;
        AppMethodBeat.m2504i(115666);
        if (matrix2 != null && matrix2.isIdentity()) {
            matrix2 = null;
        }
        if ((matrix2 == null && !this.aKo.isIdentity()) || !(matrix2 == null || this.aKo.equals(matrix2))) {
            this.aKo.set(matrix2);
            invalidate();
        }
        AppMethodBeat.m2505o(115666);
    }

    public final void setImage(C31985a c31985a) {
        AppMethodBeat.m2504i(115667);
        mo2264a(c31985a, null);
        AppMethodBeat.m2505o(115667);
    }

    public static void setBitmapLoaderImp(C45007a c45007a) {
        aKq = c45007a;
    }

    public static void setTileInitLoaderImp(C41575c c41575c) {
        aKs = c41575c;
    }

    public static void setTileLoaderImp(C41576d c41576d) {
        aKr = c41576d;
    }

    /* renamed from: a */
    public final void mo2264a(C31985a c31985a, C31985a c31985a2) {
        AppMethodBeat.m2504i(115668);
        if (c31985a == null) {
            NullPointerException nullPointerException = new NullPointerException("imageSource must not be null");
            AppMethodBeat.m2505o(115668);
            throw nullPointerException;
        }
        reset(true);
        this.aJD = c31985a;
        this.aJE = c31985a2;
        if (c31985a.uri != null) {
            this.aJF = mo2292h(getContext(), c31985a.uri.toString());
        }
        if (c31985a2 != null) {
            if (c31985a.aIJ <= 0 || c31985a.aIK <= 0) {
                C4990ab.m7412e(this.TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.aIJ = c31985a.aIJ;
                this.aIK = c31985a.aIK;
                this.aJH = c31985a2.aIL;
                if (c31985a2.bitmap != null) {
                    this.aIX = c31985a2.aIM;
                    mo2262a(c31985a2.bitmap, Integer.valueOf(0));
                } else {
                    Uri uri = c31985a2.uri;
                    if (uri == null && c31985a2.aIH != null) {
                        uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + c31985a2.aIH);
                    }
                    aKq.mo32000a(this, getContext(), this.aJP, uri, true).mo18684ou();
                }
            }
        }
        if (c31985a.bitmap != null && c31985a.aIL != null) {
            mo2266b(Bitmap.createBitmap(c31985a.bitmap, c31985a.aIL.left, c31985a.aIL.top, c31985a.aIL.width(), c31985a.aIL.height()), 0, false);
            AppMethodBeat.m2505o(115668);
        } else if (c31985a.bitmap != null) {
            mo2266b(c31985a.bitmap, 0, c31985a.aIM);
            AppMethodBeat.m2505o(115668);
        } else {
            this.aIL = c31985a.aIL;
            this.uri = c31985a.uri;
            if (this.uri == null && c31985a.aIH != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + c31985a.aIH);
            }
            if (c31985a.aII || this.aIL != null) {
                aKs.mo42520a(this, getContext(), this.aJQ, this.uri).mo18684ou();
                AppMethodBeat.m2505o(115668);
                return;
            }
            aKq.mo32000a(this, getContext(), this.aJP, this.uri, false).mo18684ou();
            AppMethodBeat.m2505o(115668);
        }
    }

    private void reset(boolean z) {
        AppMethodBeat.m2504i(115669);
        mo2293j("reset newImage=".concat(String.valueOf(z)), new Object[0]);
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
                C31984a c31984a = this.aKH;
                c31984a.aIG = 0;
                c31984a.aIE = 0;
                c31984a.aIG = 0;
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
                    this.aKc.mo2346oM();
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
                AppMethodBeat.m2505o(115669);
            }
        }
        if (this.aJd != null) {
            for (Entry value : this.aJd.entrySet()) {
                for (C37204e c37204e : (List) value.getValue()) {
                    c37204e.aIB = false;
                    if (c37204e.bitmap != null) {
                        c37204e.bitmap.recycle();
                        c37204e.bitmap = null;
                    }
                }
            }
            this.aJd = null;
        }
        setGestureDetector(getContext());
        AppMethodBeat.m2505o(115669);
    }

    public C0795e getOnImageEventListener() {
        return this.aKc;
    }

    public void setGestureDetectorListener(SimpleOnGestureListener simpleOnGestureListener) {
        this.aJN = simpleOnGestureListener;
    }

    private void setGestureDetector(final Context context) {
        AppMethodBeat.m2504i(115670);
        this.aJM = new GestureDetector(context, new SimpleOnGestureListener() {
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                AppMethodBeat.m2504i(115641);
                if (!SubsamplingScaleImageView.this.aJo || !SubsamplingScaleImageView.this.aKa || SubsamplingScaleImageView.this.aJw == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.this.aJI))) {
                    boolean onFling = super.onFling(motionEvent, motionEvent2, f, f2);
                    AppMethodBeat.m2505o(115641);
                    return onFling;
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.aJw.x + (f * 0.25f), SubsamplingScaleImageView.this.aJw.y + (0.25f * f2));
                C0794b c0794b = new C0794b(SubsamplingScaleImageView.this, new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale), (byte) 0);
                if (SubsamplingScaleImageView.aIP.contains(Integer.valueOf(1))) {
                    c0794b.aLb = 1;
                    c0794b.aLh = false;
                    c0794b.aLc = 3;
                    c0794b.start();
                    AppMethodBeat.m2505o(115641);
                    return true;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown easing type: 1");
                AppMethodBeat.m2505o(115641);
                throw illegalArgumentException;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.m2504i(115642);
                if (SubsamplingScaleImageView.this.aJN != null) {
                    boolean onSingleTapConfirmed = SubsamplingScaleImageView.this.aJN.onSingleTapConfirmed(motionEvent);
                    if (onSingleTapConfirmed) {
                        AppMethodBeat.m2505o(115642);
                        return onSingleTapConfirmed;
                    }
                }
                SubsamplingScaleImageView.this.performClick();
                AppMethodBeat.m2505o(115642);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.m2504i(115643);
                if (SubsamplingScaleImageView.this.aJp && SubsamplingScaleImageView.this.aKa && SubsamplingScaleImageView.this.aJw != null) {
                    SubsamplingScaleImageView.m1798a(SubsamplingScaleImageView.this, context);
                    C4990ab.m7417i(SubsamplingScaleImageView.this.TAG, "alvinluo onDoubleTap, quickScaledEnabled: %b", Boolean.valueOf(SubsamplingScaleImageView.this.aJq));
                    if (SubsamplingScaleImageView.this.aJq) {
                        SubsamplingScaleImageView.this.aJR = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.aJx = new PointF(SubsamplingScaleImageView.this.aJw.x, SubsamplingScaleImageView.this.aJw.y);
                        SubsamplingScaleImageView.this.aJv = SubsamplingScaleImageView.this.scale;
                        SubsamplingScaleImageView.this.aJK = true;
                        SubsamplingScaleImageView.this.aJI = true;
                        SubsamplingScaleImageView.this.aJU = -1.0f;
                        SubsamplingScaleImageView.this.aJX = SubsamplingScaleImageView.this.mo2265b(SubsamplingScaleImageView.this.aJR);
                        SubsamplingScaleImageView.this.aJY = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.aJW = new PointF(SubsamplingScaleImageView.this.aJX.x, SubsamplingScaleImageView.this.aJX.y);
                        SubsamplingScaleImageView.this.aJV = false;
                        AppMethodBeat.m2505o(115643);
                        return false;
                    }
                    SubsamplingScaleImageView.m1799a(SubsamplingScaleImageView.this, SubsamplingScaleImageView.this.mo2265b(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    AppMethodBeat.m2505o(115643);
                    return true;
                }
                boolean onDoubleTapEvent = super.onDoubleTapEvent(motionEvent);
                AppMethodBeat.m2505o(115643);
                return onDoubleTapEvent;
            }
        });
        this.aJO = new GestureDetector(context, new C08014());
        AppMethodBeat.m2505o(115670);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(115671);
        mo2293j("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.scale), this.aJz, Boolean.valueOf(this.aJC));
        m1846oy();
        PointF center = getCenter();
        if ((this.aKa || this.aJC) && center != null) {
            this.aJZ = null;
            if (!this.aJC) {
                this.aJz = Float.valueOf(this.scale);
                this.aJA = center;
            }
        }
        AppMethodBeat.m2505o(115671);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(115672);
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
                    mode = (int) ((((double) m1843oI()) / ((double) m1842oH())) * ((double) size));
                } else if (i3 != 0) {
                    size = (int) ((((double) m1842oH()) / ((double) m1843oI())) * ((double) size2));
                    mode = size2;
                }
                size2 = Math.max(size, getSuggestedMinimumWidth());
                mode = Math.max(mode, getSuggestedMinimumHeight());
                setMeasuredDimension(size2, mode);
                this.aKu = size2;
                this.aKv = mode;
                C4990ab.m7411d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKu));
                AppMethodBeat.m2505o(115672);
            }
            size2 = m1842oH();
            mode = m1843oI();
            size = size2;
            size2 = Math.max(size, getSuggestedMinimumWidth());
            mode = Math.max(mode, getSuggestedMinimumHeight());
            setMeasuredDimension(size2, mode);
            this.aKu = size2;
            this.aKv = mode;
            C4990ab.m7411d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKu));
            AppMethodBeat.m2505o(115672);
        }
        mode = size2;
        size2 = Math.max(size, getSuggestedMinimumWidth());
        mode = Math.max(mode, getSuggestedMinimumHeight());
        setMeasuredDimension(size2, mode);
        this.aKu = size2;
        this.aKv = mode;
        C4990ab.m7411d(this.TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKu));
        AppMethodBeat.m2505o(115672);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(115673);
        C4990ab.m7410d(this.TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(115673);
        return dispatchTouchEvent;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(115674);
        C4990ab.m7411d(this.TAG, "alvinluo SubSamplingScaleImageView onTouchEvent: %d", Integer.valueOf(motionEvent.getAction()));
        if (this.aJZ == null || this.aJZ.aLa) {
            this.aJZ = null;
            if (this.aJw == null) {
                if (this.aJO != null) {
                    this.aJO.onTouchEvent(motionEvent);
                }
                AppMethodBeat.m2505o(115674);
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
                    case C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                        this.aKM = motionEvent.getRawX();
                        this.aKN = motionEvent.getRawY();
                        this.aJZ = null;
                        requestDisallowInterceptTouchEvent(true);
                        this.aJL = Math.max(this.aJL, pointerCount);
                        if (pointerCount >= 2) {
                            if (this.aJp) {
                                b = m1806b(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
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
                    case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                        this.handler.removeMessages(1);
                        if (this.aJK) {
                            this.aJK = false;
                            if (!this.aJV) {
                                m1796a(this.aJX, this.aJR);
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
                                    C4990ab.m7417i(this.TAG, "alvinluo scale %f less than %f, and need to reset", Float.valueOf(this.scale), Float.valueOf(this.aKy));
                                    PointF pointF = new PointF((float) (this.aKu / 2), (float) (this.aKv / 2));
                                    m1813b(pointF, pointF, this.aKy);
                                    this.aJJ = false;
                                } else if (this.scale > getDoubleTapZoomScale() * 2.0f) {
                                    C4990ab.m7417i(this.TAG, "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f", Float.valueOf(this.scale), Float.valueOf(this.aJf), Float.valueOf(getDoubleTapZoomScale() * 2.0f));
                                    m1813b(mo2265b(this.aKF), this.aKF, getDoubleTapZoomScale() * 2.0f);
                                }
                            }
                            if (pointerCount < 3) {
                                this.aJI = false;
                            }
                            if (pointerCount < 2) {
                                this.aJJ = false;
                                this.aJL = 0;
                            }
                            m1805az(true);
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
                                b2 = m1806b(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                                x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                                float y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                                this.aKF = new PointF(x, y);
                                if (this.aJp && (m1806b(this.aJR.x, x, this.aJR.y, y) > 5.0f || Math.abs(b2 - this.aJS) > 5.0f || this.aJJ)) {
                                    this.aJI = true;
                                    this.aJJ = true;
                                    double d = (double) this.scale;
                                    b = (b2 / this.aJS) * this.aJv;
                                    if (b >= this.aJf * 2.0f) {
                                        b = ((b - this.aJf) * 0.1f) + (this.aJf * 2.0f);
                                    }
                                    this.scale = b;
                                    C4990ab.m7417i(this.TAG, "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f", Double.valueOf(d), Float.valueOf(this.scale), Float.valueOf(m1844oJ()), Float.valueOf(this.aJf));
                                    if (this.scale <= m1844oJ()) {
                                        this.aJS = b2;
                                        this.aJv = m1844oJ();
                                        this.aJR.set(x, y);
                                        this.aJx.set(this.aJw);
                                    } else if (this.aJo) {
                                        float f = (this.aJR.y - this.aJx.y) * (this.scale / this.aJv);
                                        this.aJw.x = x - ((this.aJR.x - this.aJx.x) * (this.scale / this.aJv));
                                        this.aJw.y = y - f;
                                        if ((((double) m1843oI()) * d < ((double) getHeight()) && this.scale * ((float) m1843oI()) >= ((float) getHeight())) || (d * ((double) m1842oH()) < ((double) getWidth()) && this.scale * ((float) m1842oH()) >= ((float) getWidth()))) {
                                            m1804aA(true);
                                            this.aJR.set(x, y);
                                            this.aJx.set(this.aJw);
                                            this.aJv = this.scale;
                                            this.aJS = b2;
                                        }
                                    } else if (this.aJB != null) {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * this.aJB.x);
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * this.aJB.y);
                                    } else {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (m1842oH() / 2)));
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (m1843oI() / 2)));
                                    }
                                    m1804aA(true);
                                    m1805az(this.aJn);
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
                                    this.scale = Math.max(m1844oJ(), Math.min(this.aJf, b * this.scale));
                                    if (this.aJo) {
                                        float f2 = (this.aJR.y - this.aJx.y) * (this.scale / this.aJv);
                                        this.aJw.x = this.aJR.x - ((this.aJR.x - this.aJx.x) * (this.scale / this.aJv));
                                        this.aJw.y = this.aJR.y - f2;
                                        if ((((double) m1843oI()) * d2 >= ((double) getHeight()) || this.scale * ((float) m1843oI()) < ((float) getHeight())) && (((double) m1842oH()) * d2 >= ((double) getWidth()) || this.scale * ((float) m1842oH()) < ((float) getWidth()))) {
                                            b = b2;
                                        } else {
                                            m1804aA(true);
                                            this.aJR.set(mo2268c(this.aJX));
                                            this.aJx.set(this.aJw);
                                            this.aJv = this.scale;
                                            b = 0.0f;
                                        }
                                        b2 = b;
                                    } else if (this.aJB != null) {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * this.aJB.x);
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * this.aJB.y);
                                    } else {
                                        this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (m1842oH() / 2)));
                                        this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (m1843oI() / 2)));
                                    }
                                }
                                this.aJU = b2;
                                m1804aA(true);
                                m1805az(this.aJn);
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
                                    m1804aA(true);
                                    z = b != this.aJw.x;
                                    boolean z2 = b2 != this.aJw.y;
                                    boolean z3 = z && abs > abs2 && !this.aJJ;
                                    boolean z4 = z2 && abs2 > abs && !this.aJJ;
                                    boolean z5 = b2 == this.aJw.y && abs2 > 3.0f * f3;
                                    C4990ab.m7417i(this.TAG, "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(this.aJJ), Float.valueOf(abs), Float.valueOf(abs2), Float.valueOf(f3));
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
                                    m1805az(this.aJn);
                                    z = true;
                                }
                            }
                        }
                        C4990ab.m7411d(this.TAG, "alvinluo Action_Move consumed: %b", Boolean.valueOf(z));
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
                m1820d(this.aJy);
                C4990ab.m7417i(this.TAG, "alvinluo onTouchEvent super: %b, handled: %b", Boolean.valueOf(super.onTouchEvent(motionEvent)), Boolean.valueOf(z));
                if (z || r1) {
                    AppMethodBeat.m2505o(115674);
                    return true;
                }
                AppMethodBeat.m2505o(115674);
                return false;
            } else {
                this.aJI = false;
                this.aJJ = false;
                this.aJL = 0;
                AppMethodBeat.m2505o(115674);
                return true;
            }
        }
        requestDisallowInterceptTouchEvent(true);
        AppMethodBeat.m2505o(115674);
        return true;
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        AppMethodBeat.m2504i(115675);
        ViewParent parent = getParent();
        if (parent != null) {
            C4990ab.m7417i(this.TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", Boolean.valueOf(z));
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.m2505o(115675);
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

    /* renamed from: a */
    private void m1796a(PointF pointF, PointF pointF2) {
        int i;
        AppMethodBeat.m2504i(115676);
        if (!this.aJo) {
            if (this.aJB != null) {
                pointF.x = this.aJB.x;
                pointF.y = this.aJB.y;
            } else {
                pointF.x = (float) (m1842oH() / 2);
                pointF.y = (float) (m1843oI() / 2);
            }
        }
        float doubleTapZoomScale = getDoubleTapZoomScale();
        C4990ab.m7417i(this.TAG, "alvinluo doubleTapZoom %f", Float.valueOf(doubleTapZoomScale));
        if (((double) this.scale) <= ((double) doubleTapZoomScale) * 0.9d || this.scale == this.aKy) {
            i = 1;
        } else {
            i = 0;
        }
        float f = i != 0 ? doubleTapZoomScale : this.aKy;
        if (this.aJs == 3) {
            mo2261a(f, pointF);
        } else if (this.aJs == 2 || i == 0 || !this.aJo) {
            C0794b c0794b = new C0794b(this, f, pointF, (byte) 0);
            c0794b.aLa = false;
            c0794b.duration = (long) this.aJt;
            c0794b.aLc = 4;
            c0794b.start();
        } else if (this.aJs == 1) {
            C0794b c0794b2 = new C0794b(this, doubleTapZoomScale, pointF, pointF2, (byte) 0);
            c0794b2.aLa = false;
            c0794b2.duration = (long) this.aJt;
            c0794b2.aLc = 4;
            c0794b2.start();
        }
        invalidate();
        AppMethodBeat.m2505o(115676);
    }

    /* renamed from: b */
    private void m1813b(PointF pointF, PointF pointF2, float f) {
        AppMethodBeat.m2504i(115677);
        C0794b c0794b = new C0794b(this, f, pointF, pointF2, (byte) 0);
        c0794b.aLa = false;
        c0794b.duration = (long) this.aJu;
        c0794b.aLc = 2;
        c0794b.start();
        AppMethodBeat.m2505o(115677);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(115678);
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
            this.aKg.setTextSize((float) m1849px(20));
            this.aKg.setColor(-65281);
            this.aKg.setStyle(Style.FILL);
            this.aKh = new Paint();
            this.aKh.setColor(-65281);
            this.aKh.setStyle(Style.STROKE);
            this.aKh.setStrokeWidth((float) m1849px(1));
        }
        if (this.aIJ == 0 || this.aIK == 0 || getWidth() == 0 || getHeight() == 0) {
            AppMethodBeat.m2505o(115678);
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
            C4990ab.m7417i(this.TAG, "alvinluo getMaxBitmapDimensions %d, %d", Integer.valueOf(min), Integer.valueOf(min2));
            m1812b(new Point(min, min2));
        }
        if (m1837oC()) {
            float a;
            PointF pointF;
            m1839oE();
            if (!(this.aJZ == null || this.aJZ.aKY == null)) {
                if (this.aJy == null) {
                    this.aJy = new PointF(0.0f, 0.0f);
                }
                this.aJy.set(this.aJw);
                long currentTimeMillis = System.currentTimeMillis() - this.aJZ.time;
                boolean z = currentTimeMillis > this.aJZ.duration;
                currentTimeMillis = Math.min(currentTimeMillis, this.aJZ.duration);
                this.scale = m1789a(this.aJZ.aLb, currentTimeMillis, this.aJZ.aJv, this.aJZ.aKU - this.aJZ.aJv, this.aJZ.duration);
                float a2 = m1789a(this.aJZ.aLb, currentTimeMillis, this.aJZ.aKY.x, this.aJZ.aKZ.x - this.aJZ.aKY.x, this.aJZ.duration);
                a = m1789a(this.aJZ.aLb, currentTimeMillis, this.aJZ.aKY.y, this.aJZ.aKZ.y - this.aJZ.aKY.y, this.aJZ.duration);
                pointF = this.aJw;
                pointF.x -= m1786Q(this.aJZ.aKW.x) - a2;
                pointF = this.aJw;
                pointF.y -= m1787R(this.aJZ.aKW.y) - a;
                boolean z2 = z || this.aJZ.aJv == this.aJZ.aKU;
                m1804aA(z2);
                m1820d(this.aJy);
                m1805az(z);
                if (z) {
                    this.aJZ = null;
                }
                invalidate();
            }
            if (this.aJd != null && m1836oB() && this.aKD) {
                Entry entry;
                int min3 = Math.min(this.aIY, m1783N(this.scale));
                Object obj = null;
                Iterator it = this.aJd.entrySet().iterator();
                while (true) {
                    Object obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    entry = (Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() == min3) {
                        for (C37204e c37204e : (List) entry.getValue()) {
                            if (c37204e.aIB && (c37204e.aIA || c37204e.bitmap == null)) {
                                obj2 = 1;
                            }
                        }
                    }
                    obj = obj2;
                }
                for (Entry entry2 : this.aJd.entrySet()) {
                    if (((Integer) entry2.getKey()).intValue() == min3 || obj2 != null) {
                        for (C37204e c37204e2 : (List) entry2.getValue()) {
                            Rect rect = c37204e2.aIz;
                            c37204e2.aIC.set((int) m1786Q((float) rect.left), (int) m1787R((float) rect.top), (int) m1786Q((float) rect.right), (int) m1787R((float) rect.bottom));
                            if (!c37204e2.aIA && c37204e2.bitmap != null) {
                                if (this.aKi != null) {
                                    canvas.drawRect(c37204e2.aIC, this.aKi);
                                }
                                if (this.aKk == null) {
                                    this.aKk = new Matrix();
                                }
                                this.aKk.reset();
                                m1803a(this.aKm, 0.0f, 0.0f, (float) c37204e2.bitmap.getWidth(), 0.0f, (float) c37204e2.bitmap.getWidth(), (float) c37204e2.bitmap.getHeight(), 0.0f, (float) c37204e2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    m1803a(this.aKn, (float) c37204e2.aIC.left, (float) c37204e2.aIC.top, (float) c37204e2.aIC.right, (float) c37204e2.aIC.top, (float) c37204e2.aIC.right, (float) c37204e2.aIC.bottom, (float) c37204e2.aIC.left, (float) c37204e2.aIC.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    m1803a(this.aKn, (float) c37204e2.aIC.right, (float) c37204e2.aIC.top, (float) c37204e2.aIC.right, (float) c37204e2.aIC.bottom, (float) c37204e2.aIC.left, (float) c37204e2.aIC.bottom, (float) c37204e2.aIC.left, (float) c37204e2.aIC.top);
                                } else if (getRequiredRotation() == 180) {
                                    m1803a(this.aKn, (float) c37204e2.aIC.right, (float) c37204e2.aIC.bottom, (float) c37204e2.aIC.left, (float) c37204e2.aIC.bottom, (float) c37204e2.aIC.left, (float) c37204e2.aIC.top, (float) c37204e2.aIC.right, (float) c37204e2.aIC.top);
                                } else if (getRequiredRotation() == 270) {
                                    m1803a(this.aKn, (float) c37204e2.aIC.left, (float) c37204e2.aIC.bottom, (float) c37204e2.aIC.left, (float) c37204e2.aIC.top, (float) c37204e2.aIC.right, (float) c37204e2.aIC.top, (float) c37204e2.aIC.right, (float) c37204e2.aIC.bottom);
                                }
                                this.aKk.setPolyToPoly(this.aKm, 0, this.aKn, 0, 4);
                                if (!c37204e2.bitmap.isRecycled()) {
                                    canvas.drawBitmap(c37204e2.bitmap, this.aKk, this.aKf);
                                }
                                if (this.aJe) {
                                    canvas.drawRect(c37204e2.aIC, this.aKh);
                                }
                            } else if (c37204e2.aIA && this.aJe) {
                                canvas.drawText("LOADING", (float) (c37204e2.aIC.left + m1849px(5)), (float) (c37204e2.aIC.top + m1849px(35)), this.aKg);
                            }
                            if (c37204e2.aIB && this.aJe) {
                                canvas.drawText("ISS " + c37204e2.sampleSize + " RECT " + c37204e2.aIz.top + "," + c37204e2.aIz.left + "," + c37204e2.aIz.bottom + "," + c37204e2.aIz.right, (float) (c37204e2.aIC.left + m1849px(5)), (float) (c37204e2.aIC.top + m1849px(15)), this.aKg);
                            }
                        }
                    }
                }
            } else if (!(this.bitmap == null || this.bitmap.isRecycled())) {
                C4990ab.m7411d(this.TAG, "alvinluo onDraw bitmap scale: %f", Float.valueOf(this.scale));
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
                    C4990ab.m7411d(this.TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", Float.valueOf(r0), Float.valueOf(a));
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
                C4990ab.m7411d(this.TAG, "alvinluo onDraw debug vTranslate %f, %f", Float.valueOf(this.aJw.x), Float.valueOf(this.aJw.y));
                canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.scale)}) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(m1844oJ())}) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.aJf)}) + ")", (float) m1849px(5), (float) m1849px(15), this.aKg);
                canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.aJw.x)}) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.aJw.y)}), (float) m1849px(5), (float) m1849px(30), this.aKg);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.x)}) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.y)}), (float) m1849px(5), (float) m1849px(45), this.aKg);
                if (this.aJZ != null) {
                    center = mo2268c(this.aJZ.aKV);
                    PointF c = mo2268c(this.aJZ.aKX);
                    pointF = mo2268c(this.aJZ.aKW);
                    canvas.drawCircle(center.x, center.y, (float) m1849px(10), this.aKh);
                    this.aKh.setColor(-65536);
                    canvas.drawCircle(c.x, c.y, (float) m1849px(20), this.aKh);
                    this.aKh.setColor(-16776961);
                    canvas.drawCircle(pointF.x, pointF.y, (float) m1849px(25), this.aKh);
                    this.aKh.setColor(-16711681);
                    canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) m1849px(30), this.aKh);
                }
                if (this.aJR != null) {
                    this.aKh.setColor(-65536);
                    canvas.drawCircle(this.aJR.x, this.aJR.y, (float) m1849px(20), this.aKh);
                }
                if (this.aJX != null) {
                    this.aKh.setColor(-16776961);
                    canvas.drawCircle(m1786Q(this.aJX.x), m1787R(this.aJX.y), (float) m1849px(35), this.aKh);
                }
                if (this.aJY != null && this.aJK) {
                    this.aKh.setColor(-16711681);
                    canvas.drawCircle(this.aJY.x, this.aJY.y, (float) m1849px(30), this.aKh);
                }
                this.aKh.setColor(-65281);
            }
            AppMethodBeat.m2505o(115678);
            return;
        }
        AppMethodBeat.m2505o(115678);
    }

    /* renamed from: a */
    private static void m1803a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    /* renamed from: oB */
    private boolean m1836oB() {
        boolean z = true;
        AppMethodBeat.m2504i(115679);
        if (this.bitmap != null && !this.aIS) {
            AppMethodBeat.m2505o(115679);
            return true;
        } else if (this.aJd != null) {
            Iterator it = this.aJd.entrySet().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() == this.aIY) {
                        for (C37204e c37204e : (List) entry.getValue()) {
                            if (c37204e.aIA || c37204e.bitmap == null) {
                                z2 = false;
                            }
                        }
                    }
                    z = z2;
                } else {
                    AppMethodBeat.m2505o(115679);
                    return z2;
                }
            }
        } else {
            AppMethodBeat.m2505o(115679);
            return false;
        }
    }

    /* renamed from: oC */
    private boolean m1837oC() {
        AppMethodBeat.m2504i(115680);
        boolean z = getWidth() > 0 && getHeight() > 0 && this.aIJ > 0 && this.aIK > 0 && (this.bitmap != null || m1836oB());
        if (!this.aKa && z) {
            m1839oE();
            this.aKa = true;
        }
        AppMethodBeat.m2505o(115680);
        return z;
    }

    /* renamed from: oD */
    private boolean m1838oD() {
        AppMethodBeat.m2504i(115681);
        boolean oB = m1836oB();
        if (!this.aKb && oB) {
            m1839oE();
            this.aKb = true;
            C4990ab.m7416i(this.TAG, "alvinluo onImageLoaded");
            m1846oy();
            mo2261a(this.aKy, new PointF(0.0f, 0.0f));
            if (this.aJa != -1) {
                this.aJb = System.currentTimeMillis();
                mo2272dq((int) (this.aJb - this.aJa));
            }
            C7305d.post(new C07927(), "rotateAndScaleFullImageBitmap");
        }
        AppMethodBeat.m2505o(115681);
        return oB;
    }

    /* renamed from: b */
    private synchronized void m1812b(Point point) {
        AppMethodBeat.m2504i(115682);
        mo2293j("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aKj = new C0796g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        m1802a(true, this.aKj);
        this.aIY = m1783N(this.aKj.scale);
        m1817c(point);
        for (C37204e c37204e : (List) this.aJd.get(Integer.valueOf(this.aIY))) {
            C4990ab.m7417i(this.TAG, "alvinluo tile fullSampleSize: %d", Integer.valueOf(this.aIY));
            m1797a(c37204e);
        }
        m1805az(true);
        AppMethodBeat.m2505o(115682);
    }

    /* renamed from: az */
    private void m1805az(boolean z) {
        AppMethodBeat.m2504i(115683);
        if (this.aIw == null || this.aJd == null) {
            AppMethodBeat.m2505o(115683);
            return;
        }
        int min = Math.min(this.aIY, m1783N(this.scale));
        for (Entry value : this.aJd.entrySet()) {
            for (C37204e c37204e : (List) value.getValue()) {
                if (c37204e.sampleSize < min || (c37204e.sampleSize > min && c37204e.sampleSize != this.aIY)) {
                    c37204e.aIB = false;
                    if (c37204e.bitmap != null) {
                        c37204e.bitmap.recycle();
                        c37204e.bitmap = null;
                    }
                }
                if (c37204e.sampleSize == min) {
                    boolean z2;
                    float O = m1784O(0.0f);
                    float O2 = m1784O((float) getWidth());
                    float P = m1785P(0.0f);
                    float P2 = m1785P((float) getHeight());
                    if (O > ((float) c37204e.aIz.right) || ((float) c37204e.aIz.left) > O2 || P > ((float) c37204e.aIz.bottom) || ((float) c37204e.aIz.top) > P2) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        c37204e.aIB = true;
                        if (!c37204e.aIA && c37204e.bitmap == null && z) {
                            m1797a(c37204e);
                        }
                    } else if (c37204e.sampleSize != this.aIY) {
                        c37204e.aIB = false;
                        if (c37204e.bitmap != null) {
                            c37204e.bitmap.recycle();
                            c37204e.bitmap = null;
                        }
                    }
                } else if (c37204e.sampleSize == this.aIY) {
                    c37204e.aIB = true;
                }
            }
        }
        AppMethodBeat.m2505o(115683);
    }

    /* renamed from: oE */
    private void m1839oE() {
        AppMethodBeat.m2504i(115684);
        if (getWidth() == 0 || getHeight() == 0 || this.aIJ <= 0 || this.aIK <= 0) {
            AppMethodBeat.m2505o(115684);
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
            m1804aA(true);
            m1805az(true);
        }
        m1804aA(false);
        AppMethodBeat.m2505o(115684);
    }

    /* renamed from: N */
    private int m1783N(float f) {
        AppMethodBeat.m2504i(115685);
        if (this.aJh > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.aJh) / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int oH = (int) (((float) m1842oH()) * f);
        int oI = (int) (((float) m1843oI()) * f);
        if (oH == 0 || oI == 0) {
            AppMethodBeat.m2505o(115685);
            return 32;
        }
        if (m1843oI() > oI || m1842oH() > oH) {
            oI = Math.round(((float) m1843oI()) / ((float) oI));
            oH = Math.round(((float) m1842oH()) / ((float) oH));
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
        AppMethodBeat.m2505o(115685);
        return oH;
    }

    /* renamed from: a */
    private void m1802a(boolean z, C0796g c0796g) {
        float paddingLeft;
        float max;
        float f = 0.5f;
        AppMethodBeat.m2504i(115686);
        if (this.aJi == 2 && this.aKa) {
            z = false;
        }
        PointF pointF = c0796g.aJw;
        float S = m1788S(c0796g.scale);
        float oH = S * ((float) m1842oH());
        float oI = S * ((float) m1843oI());
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
        c0796g.scale = S;
        AppMethodBeat.m2505o(115686);
    }

    /* renamed from: aA */
    private void m1804aA(boolean z) {
        byte b;
        AppMethodBeat.m2504i(115687);
        if (this.aJw == null) {
            b = (byte) 1;
            this.aJw = new PointF(0.0f, 0.0f);
        } else {
            b = (byte) 0;
        }
        if (this.aKj == null) {
            this.aKj = new C0796g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aKj.scale = this.scale;
        this.aKj.aJw.set(this.aJw);
        m1802a(z, this.aKj);
        this.scale = this.aKj.scale;
        this.aJw.set(this.aKj.aJw);
        if (!(b == (byte) 0 || this.aJj == 4)) {
            this.aJw.set(m1825g((float) (m1842oH() / 2), (float) (m1843oI() / 2), this.scale));
        }
        AppMethodBeat.m2505o(115687);
    }

    /* renamed from: c */
    private void m1817c(Point point) {
        AppMethodBeat.m2504i(115688);
        mo2293j("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aJd = new LinkedHashMap();
        int i = this.aIY;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int oH = m1842oH() / i2;
            int oI = m1843oI() / i3;
            int i4 = oH / i;
            int i5 = oI / i;
            while (true) {
                if ((i4 + i2) + 1 > point.x || (((double) i4) > ((double) getWidth()) * 1.25d && i < this.aIY)) {
                    i2++;
                    oH = m1842oH() / i2;
                    i4 = oH / i;
                }
            }
            i4 = i5;
            while (true) {
                if ((i4 + i3) + 1 > point.y || (((double) i4) > ((double) getHeight()) * 1.25d && i < this.aIY)) {
                    i3++;
                    i5 = m1843oI() / i3;
                    i4 = i5 / i;
                    oI = i5;
                }
            }
            ArrayList arrayList = new ArrayList(i2 * i3);
            int i6 = 0;
            while (i6 < i2) {
                for (int i7 = 0; i7 < i3; i7++) {
                    C37204e c37204e = new C37204e();
                    c37204e.sampleSize = i;
                    c37204e.aIB = i == this.aIY;
                    int i8 = i6 * oH;
                    int i9 = i7 * oI;
                    i5 = i6 == i2 + -1 ? m1842oH() : (i6 + 1) * oH;
                    if (i7 == i3 - 1) {
                        i4 = m1843oI();
                    } else {
                        i4 = (i7 + 1) * oI;
                    }
                    c37204e.aIz = new Rect(i8, i9, i5, i4);
                    c37204e.aIC = new Rect(0, 0, 0, 0);
                    c37204e.aID = new Rect(c37204e.aIz);
                    arrayList.add(c37204e);
                }
                i6++;
            }
            this.aJd.put(Integer.valueOf(i), arrayList);
            if (i != 1) {
                i /= 2;
            } else {
                AppMethodBeat.m2505o(115688);
                return;
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo2263a(C17565d c17565d, int i, int i2, int i3) {
        AppMethodBeat.m2504i(115689);
        mo2293j("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.aIJ), Integer.valueOf(this.aIK), Integer.valueOf(i3));
        if (this.aIJ > 0 && this.aIK > 0 && !(this.aIJ == i && this.aIK == i2)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.aIX) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aKc != null && this.aIX) {
                    this.aKc.mo2346oM();
                }
                this.aIS = false;
                this.aIX = false;
            }
        }
        this.aIw = c17565d;
        this.aIJ = i;
        this.aIK = i2;
        this.aJF = i3;
        m1837oC();
        if (!m1838oD() && this.aJl > 0 && this.aJl != aJk && this.aJm > 0 && this.aJm != aJk && getWidth() > 0 && getHeight() > 0) {
            m1812b(new Point(this.aJl, this.aJm));
        }
        invalidate();
        requestLayout();
        System.currentTimeMillis();
        AppMethodBeat.m2505o(115689);
    }

    private void setFullImageBitmap(final Bitmap bitmap) {
        AppMethodBeat.m2504i(115690);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(115645);
                if (bitmap != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SubsamplingScaleImageView.this.aJc = SubsamplingScaleImageView.this.mo2260a(bitmap, SubsamplingScaleImageView.this.aJF);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    C4990ab.m7417i(SubsamplingScaleImageView.this.TAG, "alvinluo rotate and scale fullImageBitmap cost: %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                }
                AppMethodBeat.m2505o(115645);
            }
        }, "rotateAndScaleBitmap");
        AppMethodBeat.m2505o(115690);
    }

    /* renamed from: b */
    public final synchronized void mo2267b(C37204e c37204e) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(115691);
            this.aJa = System.currentTimeMillis();
            String str = this.TAG;
            String str2 = "alvinluo onTileLoaded sampleSize: %d, bitmap == null: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(c37204e.sampleSize);
            if (c37204e.bitmap != null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7411d(str, str2, objArr);
            if (c37204e.sampleSize == this.aIY && c37204e.bitmap != null && this.aIZ) {
                C4990ab.m7416i(this.TAG, "alvinluo onTileLoaded set fullImageBitmap");
                this.aIZ = false;
                this.aJc = c37204e.bitmap;
            }
            m1837oC();
            m1838oD();
            if (m1836oB() && this.bitmap != null) {
                if (!this.aIX) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aKc != null && this.aIX) {
                    this.aKc.mo2346oM();
                }
                this.aIS = false;
                this.aIX = false;
            }
            invalidate();
            AppMethodBeat.m2505o(115691);
        }
    }

    /* renamed from: a */
    public final Bitmap mo2260a(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(115692);
        if (bitmap == null) {
            C4990ab.m7412e(this.TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
            AppMethodBeat.m2505o(115692);
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 1.0f);
        if (i != 0) {
            matrix.postRotate((float) i);
        }
        C4990ab.m7411d(this.TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", Boolean.valueOf(matrix.isIdentity()));
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.m2505o(115692);
            return null;
        } else if (matrix.isIdentity()) {
            AppMethodBeat.m2505o(115692);
            return bitmap;
        } else {
            try {
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                AppMethodBeat.m2505o(115692);
                return bitmap;
            } catch (OutOfMemoryError e) {
                C4990ab.printErrStackTrace(this.TAG, e, "alvinluo createBitmap oom", new Object[0]);
                aKp = Config.RGB_565;
                AppMethodBeat.m2505o(115692);
                return null;
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo2262a(Bitmap bitmap, Integer num) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(115693);
            C4990ab.m7416i(this.TAG, "alvinluo onPreviewLoaded");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aKb) {
                if (this.bitmap != null) {
                    this.bitmap.recycle();
                }
                AppMethodBeat.m2505o(115693);
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
                    int oH = m1842oH();
                    int oI = m1843oI();
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
                    m1846oy();
                    if (z) {
                        this.aKz = (((float) this.aKu) * 1.0f) / ((float) m1840oF());
                        this.aKA = (((float) this.aKv) * 1.0f) / ((float) m1841oG());
                    } else if (z3) {
                        this.aKz = (((float) this.aKu) * 1.0f) / ((float) m1840oF());
                        this.aKA = (this.aKy * ((float) m1843oI())) / ((float) m1841oG());
                    } else {
                        this.aKz = (this.aKy * ((float) m1842oH())) / ((float) m1840oF());
                        this.aKA = (this.aKy * ((float) m1843oI())) / ((float) m1841oG());
                    }
                    C4990ab.m7417i(this.TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f, previewHeight: %d, previewWidth: %d, verticalLong: %b, horizontalLong: %b", Float.valueOf(this.aKz), Float.valueOf(this.aKA), Integer.valueOf(m1841oG()), Integer.valueOf(m1840oF()), Boolean.valueOf(z), Boolean.valueOf(z3));
                }
                this.aIU = true;
                if (m1837oC()) {
                    invalidate();
                    requestLayout();
                }
                mo2271dp((int) (System.currentTimeMillis() - currentTimeMillis));
                C4990ab.m7416i(this.TAG, "alvinluo onPreviewLoaded");
                if (!(this.aIT || this.aKc == null)) {
                    this.aKc.mo2345oL();
                }
                AppMethodBeat.m2505o(115693);
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

    /* renamed from: b */
    public final synchronized void mo2266b(Bitmap bitmap, int i, boolean z) {
        AppMethodBeat.m2504i(115694);
        mo2293j("onImageLoaded has bitmap", new Object[0]);
        if (this.aIJ > 0 && this.aIK > 0 && !(this.aIJ == bitmap.getWidth() && this.aIK == bitmap.getHeight())) {
            reset(false);
        }
        if (!(this.bitmap == null || this.aIX)) {
            this.bitmap.recycle();
        }
        if (!(this.bitmap == null || !this.aIX || this.aKc == null)) {
            this.aKc.mo2346oM();
        }
        this.aIS = false;
        this.aIX = z;
        this.bitmap = bitmap;
        this.aIJ = bitmap.getWidth();
        this.aIK = bitmap.getHeight();
        this.aJF = i;
        final boolean oC = m1837oC();
        final boolean oD = m1838oD();
        final int i2 = i;
        final Bitmap bitmap2 = bitmap;
        C7305d.post(new Runnable() {

            /* renamed from: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView$6$1 */
            class C07891 implements Runnable {
                C07891() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(115646);
                    if (oC || oD) {
                        SubsamplingScaleImageView.this.invalidate();
                        SubsamplingScaleImageView.this.requestLayout();
                    }
                    AppMethodBeat.m2505o(115646);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(115647);
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 != 0) {
                    SubsamplingScaleImageView.this.bitmap = SubsamplingScaleImageView.this.mo2260a(bitmap2, i2);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                C4990ab.m7417i(SubsamplingScaleImageView.this.TAG, "alvinluo onImageLoaded rotaeAndScaleBitmap %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                SubsamplingScaleImageView.this.post(new C07891());
                AppMethodBeat.m2505o(115647);
            }
        }, "rotateAndScaleBitmap");
        AppMethodBeat.m2505o(115694);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public final int mo2292h(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        int i = 0;
        AppMethodBeat.m2504i(115695);
        int i2;
        if (str.startsWith(C8741b.CONTENT)) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            i2 = query.getInt(0);
                            if (!aIN.contains(Integer.valueOf(i2)) || i2 == -1) {
                                C4990ab.m7420w(this.TAG, "Unsupported orientation: ".concat(String.valueOf(i2)));
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
                            C4990ab.m7420w(this.TAG, "Could not get orientation of image from media store");
                            if (cursor != null) {
                                cursor.close();
                                AppMethodBeat.m2505o(115695);
                                return i;
                            }
                            i2 = 0;
                            i = i2;
                            AppMethodBeat.m2505o(115695);
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            AppMethodBeat.m2505o(115695);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        AppMethodBeat.m2505o(115695);
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
                AppMethodBeat.m2505o(115695);
                throw th;
            }
            i = i2;
        } else if (str.startsWith("file:///") && !str.startsWith("file:///android_asset/")) {
            try {
                i2 = new C0252a(str.substring(7)).getAttributeInt(C0252a.TAG_ORIENTATION, 1);
                if (!(i2 == 1 || i2 == 0)) {
                    if (i2 == 6) {
                        i = 90;
                    } else if (i2 == 3) {
                        i = 180;
                    } else if (i2 == 8) {
                        i = 270;
                    } else {
                        C4990ab.m7420w(this.TAG, "Unsupported EXIF orientation: ".concat(String.valueOf(i2)));
                    }
                }
            } catch (Exception e3) {
                C4990ab.m7420w(this.TAG, "Could not get EXIF orientation of image");
            }
        }
        AppMethodBeat.m2505o(115695);
        return i;
    }

    public void setMaxTileSize(int i) {
        this.aJl = i;
        this.aJm = i;
    }

    /* renamed from: oF */
    private int m1840oF() {
        AppMethodBeat.m2504i(115696);
        if (this.bitmap == null || !this.aIS) {
            AppMethodBeat.m2505o(115696);
            return 0;
        }
        int i = this.aJG;
        if (i == 90 || i == 270) {
            i = this.bitmap.getHeight();
            AppMethodBeat.m2505o(115696);
            return i;
        }
        i = this.bitmap.getWidth();
        AppMethodBeat.m2505o(115696);
        return i;
    }

    /* renamed from: oG */
    private int m1841oG() {
        AppMethodBeat.m2504i(115697);
        if (this.bitmap == null || !this.aIS) {
            AppMethodBeat.m2505o(115697);
            return 0;
        }
        int i = this.aJG;
        if (i == 90 || i == 270) {
            i = this.bitmap.getWidth();
            AppMethodBeat.m2505o(115697);
            return i;
        }
        i = this.bitmap.getHeight();
        AppMethodBeat.m2505o(115697);
        return i;
    }

    /* renamed from: oH */
    private int m1842oH() {
        AppMethodBeat.m2504i(115698);
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            requiredRotation = this.aIK;
            AppMethodBeat.m2505o(115698);
            return requiredRotation;
        }
        requiredRotation = this.aIJ;
        AppMethodBeat.m2505o(115698);
        return requiredRotation;
    }

    /* renamed from: oI */
    private int m1843oI() {
        AppMethodBeat.m2504i(115699);
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            requiredRotation = this.aIJ;
            AppMethodBeat.m2505o(115699);
            return requiredRotation;
        }
        requiredRotation = this.aIK;
        AppMethodBeat.m2505o(115699);
        return requiredRotation;
    }

    public int getRequiredRotation() {
        if (this.orientation == -1) {
            return this.aJF;
        }
        return this.orientation;
    }

    /* renamed from: b */
    private static float m1806b(float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(115700);
        float f5 = f - f2;
        float f6 = f3 - f4;
        f5 = (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
        AppMethodBeat.m2505o(115700);
        return f5;
    }

    /* renamed from: O */
    private float m1784O(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (f - this.aJw.x) / this.scale;
    }

    /* renamed from: P */
    private float m1785P(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (f - this.aJw.y) / this.scale;
    }

    /* renamed from: b */
    public final PointF mo2265b(PointF pointF) {
        AppMethodBeat.m2504i(115701);
        PointF a = m1792a(pointF.x, pointF.y, new PointF());
        AppMethodBeat.m2505o(115701);
        return a;
    }

    /* renamed from: a */
    private PointF m1792a(float f, float f2, PointF pointF) {
        AppMethodBeat.m2504i(115702);
        if (this.aJw == null) {
            AppMethodBeat.m2505o(115702);
            return null;
        }
        pointF.set(m1784O(f), m1785P(f2));
        AppMethodBeat.m2505o(115702);
        return pointF;
    }

    /* renamed from: Q */
    private float m1786Q(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.aJw.x;
    }

    /* renamed from: R */
    private float m1787R(float f) {
        if (this.aJw == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.aJw.y;
    }

    /* renamed from: c */
    public final PointF mo2268c(PointF pointF) {
        AppMethodBeat.m2504i(115703);
        PointF b = m1809b(pointF.x, pointF.y, new PointF());
        AppMethodBeat.m2505o(115703);
        return b;
    }

    /* renamed from: b */
    private PointF m1809b(float f, float f2, PointF pointF) {
        AppMethodBeat.m2504i(115704);
        if (this.aJw == null) {
            AppMethodBeat.m2505o(115704);
            return null;
        }
        pointF.set(m1786Q(f), m1787R(f2));
        AppMethodBeat.m2505o(115704);
        return pointF;
    }

    /* renamed from: g */
    private PointF m1825g(float f, float f2, float f3) {
        AppMethodBeat.m2504i(115705);
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.aKj == null) {
            this.aKj = new C0796g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aKj.scale = f3;
        this.aKj.aJw.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        m1802a(true, this.aKj);
        PointF pointF = this.aKj.aJw;
        AppMethodBeat.m2505o(115705);
        return pointF;
    }

    /* renamed from: oJ */
    private float m1844oJ() {
        AppMethodBeat.m2504i(115706);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        float max;
        if (this.aJj == 2 || this.aJj == 4) {
            max = Math.max(((float) (getWidth() - paddingLeft)) / ((float) m1842oH()), ((float) (getHeight() - paddingBottom)) / ((float) m1843oI()));
            AppMethodBeat.m2505o(115706);
            return max;
        } else if (this.aJj != 3 || this.aJg <= 0.0f) {
            max = Math.min(((float) (getWidth() - paddingLeft)) / ((float) m1842oH()), ((float) (getHeight() - paddingBottom)) / ((float) m1843oI()));
            AppMethodBeat.m2505o(115706);
            return max;
        } else {
            max = this.aJg;
            AppMethodBeat.m2505o(115706);
            return max;
        }
    }

    /* renamed from: S */
    private float m1788S(float f) {
        AppMethodBeat.m2504i(115707);
        float max = Math.max(m1844oJ(), f);
        AppMethodBeat.m2505o(115707);
        return max;
    }

    /* renamed from: a */
    private static float m1789a(int i, long j, float f, float f2, long j2) {
        AppMethodBeat.m2504i(115708);
        float c;
        switch (i) {
            case 1:
                c = m1814c(j, f, f2, j2);
                AppMethodBeat.m2505o(115708);
                return c;
            case 2:
                c = m1818d(j, f, f2, j2);
                AppMethodBeat.m2505o(115708);
                return c;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unexpected easing type: ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(115708);
                throw illegalStateException;
        }
    }

    /* renamed from: c */
    private static float m1814c(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((f3 - 2.0f) * ((-f2) * f3)) + f;
    }

    /* renamed from: d */
    private static float m1818d(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / (((float) j2) / 2.0f);
        if (f3 < 1.0f) {
            return (f3 * ((f2 / 2.0f) * f3)) + f;
        }
        f3 -= 1.0f;
        return (((f3 * (f3 - 2.0f)) - 1.0f) * ((-f2) / 2.0f)) + f;
    }

    /* renamed from: j */
    public final void mo2293j(String str, Object... objArr) {
        AppMethodBeat.m2504i(115709);
        C4990ab.m7410d(this.TAG, String.format(str, objArr));
        AppMethodBeat.m2505o(115709);
    }

    /* renamed from: px */
    private int m1849px(int i) {
        return (int) (this.density * ((float) i));
    }

    public final void setRegionDecoderClass(Class<? extends C17565d> cls) {
        AppMethodBeat.m2504i(115710);
        if (cls == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder class cannot be set to null");
            AppMethodBeat.m2505o(115710);
            throw illegalArgumentException;
        }
        this.aJQ = new C24650a(cls);
        AppMethodBeat.m2505o(115710);
    }

    public final void setRegionDecoderFactory(C17564b<? extends C17565d> c17564b) {
        AppMethodBeat.m2504i(115711);
        if (c17564b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder factory cannot be set to null");
            AppMethodBeat.m2505o(115711);
            throw illegalArgumentException;
        }
        this.aJQ = c17564b;
        AppMethodBeat.m2505o(115711);
    }

    public final void setBitmapDecoderClass(Class<? extends C17565d> cls) {
        AppMethodBeat.m2504i(115712);
        if (cls == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder class cannot be set to null");
            AppMethodBeat.m2505o(115712);
            throw illegalArgumentException;
        }
        this.aJP = new C24650a(cls);
        AppMethodBeat.m2505o(115712);
    }

    public final void setBitmapDecoderFactory(C17564b<? extends C17565d> c17564b) {
        AppMethodBeat.m2504i(115713);
        if (c17564b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Decoder factory cannot be set to null");
            AppMethodBeat.m2505o(115713);
            throw illegalArgumentException;
        }
        this.aJP = c17564b;
        AppMethodBeat.m2505o(115713);
    }

    public final void setPanLimit(int i) {
        AppMethodBeat.m2504i(115714);
        if (aIQ.contains(Integer.valueOf(i))) {
            this.aJi = i;
            if (this.aKa) {
                m1804aA(true);
                invalidate();
            }
            AppMethodBeat.m2505o(115714);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid pan limit: ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(115714);
        throw illegalArgumentException;
    }

    public final void setMinimumScaleType(int i) {
        AppMethodBeat.m2504i(115715);
        if (aIR.contains(Integer.valueOf(i))) {
            this.aJj = i;
            if (this.aKa) {
                m1804aA(true);
                invalidate();
            }
            AppMethodBeat.m2505o(115715);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid scale type: ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(115715);
        throw illegalArgumentException;
    }

    public final void setMaxScale(float f) {
        this.aJf = f;
    }

    public final void setMinScale(float f) {
        this.aJg = f;
    }

    public final void setMinimumDpi(int i) {
        AppMethodBeat.m2504i(115716);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
        AppMethodBeat.m2505o(115716);
    }

    public final void setMaximumDpi(int i) {
        AppMethodBeat.m2504i(115717);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
        AppMethodBeat.m2505o(115717);
    }

    public float getMaxScale() {
        return this.aJf;
    }

    public final float getMinScale() {
        AppMethodBeat.m2504i(115718);
        float oJ = m1844oJ();
        AppMethodBeat.m2505o(115718);
        return oJ;
    }

    public void setMinimumTileDpi(int i) {
        AppMethodBeat.m2504i(115719);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aJh = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, (float) i);
        if (this.aKa) {
            reset(false);
            invalidate();
        }
        AppMethodBeat.m2505o(115719);
    }

    public final PointF getCenter() {
        AppMethodBeat.m2504i(115720);
        PointF a = m1792a((float) (getWidth() / 2), (float) (getHeight() / 2), new PointF());
        AppMethodBeat.m2505o(115720);
        return a;
    }

    public final float getScale() {
        return this.scale;
    }

    /* renamed from: a */
    public final void mo2261a(float f, PointF pointF) {
        AppMethodBeat.m2504i(115721);
        this.aJZ = null;
        this.aJC = true;
        this.aJz = Float.valueOf(f);
        this.aJA = pointF;
        this.aJB = pointF;
        invalidate();
        AppMethodBeat.m2505o(115721);
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
        AppMethodBeat.m2504i(115722);
        int requiredRotation = getRequiredRotation();
        AppMethodBeat.m2505o(115722);
        return requiredRotation;
    }

    public final C0802b getState() {
        AppMethodBeat.m2504i(115723);
        if (this.aJw == null || this.aIJ <= 0 || this.aIK <= 0) {
            AppMethodBeat.m2505o(115723);
            return null;
        }
        C0802b c0802b = new C0802b(getScale(), getCenter(), getOrientation());
        AppMethodBeat.m2505o(115723);
        return c0802b;
    }

    public final void setZoomEnabled(boolean z) {
        this.aJp = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.aJq = z;
    }

    public final void setPanEnabled(boolean z) {
        AppMethodBeat.m2504i(115724);
        this.aJo = z;
        if (!(z || this.aJw == null)) {
            this.aJw.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (m1842oH() / 2)));
            this.aJw.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (m1843oI() / 2)));
            if (this.aKa) {
                m1805az(true);
                invalidate();
            }
        }
        AppMethodBeat.m2505o(115724);
    }

    public final void setTileBackgroundColor(int i) {
        AppMethodBeat.m2504i(115725);
        if (Color.alpha(i) == 0) {
            this.aKi = null;
        } else {
            this.aKi = new Paint();
            this.aKi.setStyle(Style.FILL);
            this.aKi.setColor(i);
        }
        invalidate();
        AppMethodBeat.m2505o(115725);
    }

    public final void setDoubleTapZoomScale(float f) {
        this.aJr = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        AppMethodBeat.m2504i(115726);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
        AppMethodBeat.m2505o(115726);
    }

    public final void setDoubleTapZoomStyle(int i) {
        AppMethodBeat.m2504i(115727);
        if (aIO.contains(Integer.valueOf(i))) {
            this.aJs = i;
            AppMethodBeat.m2505o(115727);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid zoom style: ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(115727);
        throw illegalArgumentException;
    }

    public final void setDoubleTapZoomDuration(int i) {
        AppMethodBeat.m2504i(115728);
        this.aJt = Math.max(0, i);
        AppMethodBeat.m2505o(115728);
    }

    public void setExecutor(Executor executor) {
        AppMethodBeat.m2504i(115729);
        if (executor == null) {
            NullPointerException nullPointerException = new NullPointerException("Executor must not be null");
            AppMethodBeat.m2505o(115729);
            throw nullPointerException;
        }
        this.executor = executor;
        AppMethodBeat.m2505o(115729);
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

    public void setOnImageEventListener(C0795e c0795e) {
        this.aKc = c0795e;
    }

    public void setOnStateChangedListener(C0799f c0799f) {
        this.aKd = c0799f;
    }

    /* renamed from: d */
    private void m1820d(PointF pointF) {
        AppMethodBeat.m2504i(115730);
        if (!(this.aKd == null || this.aJw.equals(pointF))) {
            getCenter();
        }
        AppMethodBeat.m2505o(115730);
    }
}
