package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.map.lib.d;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public class lh implements le {
    private static List<lp> A = new CopyOnWriteArrayList();
    private static ConcurrentHashMap<String, Bitmap> B = new ConcurrentHashMap();
    private static List<String> C = new CopyOnWriteArrayList();
    private static ReentrantReadWriteLock F = new ReentrantReadWriteLock();
    private static final int[] H = new int[]{1, 2, 5};
    private String D = null;
    private AtomicInteger E = new AtomicInteger(0);
    private int G = 0;
    private String I = "50m";
    private int J = 11;
    private int K = 109;
    private float L = 1.0f;
    private int M;
    private double N;
    private b O;
    private boolean P = true;
    private LinearLayout Q;
    private LinearLayout R;
    private final int S;
    private final int T;
    private final int U = 18;
    private float V = Float.MIN_VALUE;
    private Animation W;
    private int X = 40;
    private List<a> Y = new ArrayList();
    private int Z = -1;
    private final int a = 500;
    private int aa = -1;
    private int ab = -1;
    private int ac = -1;
    private boolean ad = true;
    private final int b = 1000;
    private Context c;
    private ImageView d;
    private Bitmap e;
    private Bitmap f;
    private com.tencent.tencentmap.mapsdk.maps.a.le.b g = com.tencent.tencentmap.mapsdk.maps.a.le.b.RIGHT_BOTTOM;
    private com.tencent.tencentmap.mapsdk.maps.a.le.b h = com.tencent.tencentmap.mapsdk.maps.a.le.b.LEFT_BOTTOM;
    private boolean i = true;
    private ViewGroup j;
    private float[] k = new float[]{-1.0f, -1.0f, -1.0f, -1.0f};
    private int[] l = new int[]{-1, -1, -1, -1};
    private int[] m = new int[]{-1, -1, -1, -1};
    private int[] n = new int[com.tencent.tencentmap.mapsdk.maps.a.le.a.values().length];
    private int[] o = new int[com.tencent.tencentmap.mapsdk.maps.a.le.a.values().length];
    private float[] p = new float[]{0.02f, 0.02f, 0.012f, 0.012f};
    private float[] q = new float[]{0.022f, 0.022f, 0.0125f, 0.0125f};
    private float[] r = new float[]{0.0185f, 0.0185f, 0.0104f, 0.0104f};
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private boolean y = false;
    private TextView z;

    public interface a {
        void a(View view, Rect rect, boolean z);

        void a(lh lhVar);

        void b(View view, Rect rect, boolean z);

        void b(lh lhVar);
    }

    class b extends View {
        private Paint b = new Paint();
        private Paint c;

        public b(Context context) {
            super(context);
            AppMethodBeat.i(100365);
            this.b.setAntiAlias(true);
            this.b.setColor(WebView.NIGHT_MODE_COLOR);
            this.b.setStrokeWidth(1.0f * lh.this.L);
            this.b.setStyle(Style.STROKE);
            this.c = new Paint(65);
            this.c.setStyle(Style.FILL);
            this.c.setColor(0);
            AppMethodBeat.o(100365);
        }

        public void draw(Canvas canvas) {
            AppMethodBeat.i(100366);
            super.draw(canvas);
            a(canvas, getHeight());
            AppMethodBeat.o(100366);
        }

        /* Access modifiers changed, original: protected */
        public void onMeasure(int i, int i2) {
            AppMethodBeat.i(100367);
            super.onMeasure(i, i2);
            setMeasuredDimension(Math.min(Math.round(((float) lh.this.K) + (12.0f * lh.this.L)), lh.this.s / 2), Math.round(((float) lh.this.J) * lh.this.L));
            AppMethodBeat.o(100367);
        }

        private void a(Canvas canvas, int i) {
            AppMethodBeat.i(100368);
            int c = (int) (6.0f * lh.this.L);
            int i2 = i / 2;
            canvas.drawPaint(this.c);
            canvas.drawLine((float) c, (float) i2, (float) (lh.this.K + c), (float) i2, this.b);
            canvas.drawLine((float) c, ((float) i2) - (lh.this.L * 3.0f), (float) c, (float) (i2 + 1), this.b);
            canvas.drawLine((float) (lh.this.K + c), ((float) i2) - (lh.this.L * 3.0f), (float) (lh.this.K + c), (float) (i2 + 1), this.b);
            AppMethodBeat.o(100368);
        }
    }

    static /* synthetic */ boolean a(lh lhVar, String str, Bitmap bitmap) {
        AppMethodBeat.i(100410);
        boolean a = lhVar.a(str, bitmap);
        AppMethodBeat.o(100410);
        return a;
    }

    static {
        AppMethodBeat.i(100411);
        AppMethodBeat.o(100411);
    }

    public lh(Context context, int i, int i2) {
        AppMethodBeat.i(100369);
        this.c = context;
        this.S = i;
        this.T = i2;
        this.L = context.getResources().getDisplayMetrics().density;
        this.X = (int) (((double) (40.0f * this.L)) + 0.5d);
        this.d = new ImageView(context);
        this.O = new b(this.c);
        this.z = new TextView(this.c);
        this.z.setText(this.I);
        this.z.setContentDescription("地图");
        this.z.setTextSize(12.0f);
        this.z.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.z.setGravity(1);
        if (this.L <= 0.0f) {
            this.L = 1.0f;
        }
        this.Q = new LinearLayout(this.c);
        this.Q.setOrientation(1);
        this.Q.setGravity(16);
        this.R = new LinearLayout(this.c);
        this.R.setOrientation(1);
        this.R.setGravity(16);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.R.addView(this.z, layoutParams);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.R.addView(this.O, layoutParams);
        this.R.setVisibility(8);
        o();
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.Q.addView(this.d, layoutParams);
        a(lq.g());
        AppMethodBeat.o(100369);
    }

    private void o() {
        AppMethodBeat.i(100370);
        this.W = new AlphaAnimation(1.0f, 0.0f);
        this.W.setDuration(1000);
        this.W.setStartOffset(500);
        this.W.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
                AppMethodBeat.i(100359);
                if (lh.this.R != null) {
                    lh.this.R.setVisibility(0);
                }
                AppMethodBeat.o(100359);
            }

            public void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(100360);
                if (lh.this.R != null) {
                    lh.this.R.setVisibility(8);
                }
                AppMethodBeat.o(100360);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        AppMethodBeat.o(100370);
    }

    public boolean a(ViewGroup viewGroup) {
        AppMethodBeat.i(100371);
        if (viewGroup == null) {
            AppMethodBeat.o(100371);
            return false;
        }
        if (this.y) {
            this.y = false;
            v.a(this.f);
            int[] b = b(this.w, this.x);
            this.f = ht.a(this.e, this.c, b[0], b[1]);
            try {
                this.d.setImageBitmap(this.f);
            } catch (Throwable th) {
                Log.getStackTraceString(th);
            }
        }
        this.j = viewGroup;
        FrameLayout.LayoutParams s = s();
        if (viewGroup.indexOfChild(this.Q) < 0) {
            viewGroup.addView(this.Q, s);
        } else {
            viewGroup.updateViewLayout(this.Q, s);
        }
        s = t();
        if (viewGroup.indexOfChild(this.R) < 0) {
            viewGroup.addView(this.R, s);
        } else {
            viewGroup.updateViewLayout(this.R, s);
        }
        if (!(this.z == null || this.O == null)) {
            LayoutParams layoutParams = (LayoutParams) this.z.getLayoutParams();
            this.O.measure(0, 0);
            this.z.measure(0, 0);
            layoutParams.leftMargin = (int) (((((float) this.K) + (6.0f * this.L)) - ((float) this.z.getWidth())) / 2.0f);
            this.R.updateViewLayout(this.z, layoutParams);
            this.R.updateViewLayout(this.O, this.O.getLayoutParams());
        }
        this.d.setVisibility(this.i ? 0 : 4);
        if (this.Y != null) {
            this.Q.requestLayout();
            this.R.requestLayout();
            for (a aVar : this.Y) {
                aVar.a(this.Q, new Rect(this.Z, this.aa, 0, 0), this.i);
                aVar.b(this.R, new Rect(this.ab, this.ac, 0, 0), this.P);
            }
        }
        viewGroup.requestLayout();
        AppMethodBeat.o(100371);
        return true;
    }

    private void p() {
        AppMethodBeat.i(100372);
        a(this.j);
        AppMethodBeat.o(100372);
    }

    public void a(com.tencent.map.lib.basemap.data.a aVar, int i) {
        AppMethodBeat.i(100373);
        int c = (int) aVar.c();
        if (c > 18) {
            c = 18;
        }
        for (lp lpVar : A) {
            if (c >= lpVar.a() && c <= lpVar.b()) {
                break;
            }
        }
        lp lpVar2 = null;
        if (lpVar2 == null) {
            AppMethodBeat.o(100373);
            return;
        }
        String[] a = lpVar2.a(aVar, i);
        if (a == null) {
            AppMethodBeat.o(100373);
            return;
        }
        String str = a[0];
        String str2 = a[1];
        if ((!StringUtil.isEqual(str, this.D) ? 1 : 0) != 0) {
            Bitmap bitmap = (Bitmap) B.get(str);
            if (bitmap != null) {
                if (bitmap.isRecycled()) {
                    B.remove(str);
                } else {
                    a(bitmap);
                    this.D = str;
                    AppMethodBeat.o(100373);
                    return;
                }
            }
            bitmap = c(str);
            if (bitmap != null) {
                this.D = str;
                B.put(this.D, bitmap);
                a(bitmap);
                AppMethodBeat.o(100373);
                return;
            }
            this.D = null;
            a(str2, str);
        }
        AppMethodBeat.o(100373);
    }

    private void a(final String str, final String str2) {
        AppMethodBeat.i(100374);
        if (C.contains(str2)) {
            AppMethodBeat.o(100374);
            return;
        }
        C.add(str2);
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                Throwable th;
                HttpURLConnection httpURLConnection;
                AppMethodBeat.i(100362);
                super.run();
                HttpURLConnection httpURLConnection2;
                try {
                    httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                        if (httpURLConnection2.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection2.getInputStream());
                            if (decodeStream != null) {
                                lh.B.put(str2, decodeStream);
                            }
                            if (lh.this.d != null) {
                                lh.this.d.post(new Runnable() {
                                    public void run() {
                                        AppMethodBeat.i(100361);
                                        lh.a(lh.this, decodeStream);
                                        AppMethodBeat.o(100361);
                                    }
                                });
                            }
                            lh.a(lh.this, str2, decodeStream);
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        lh.C.remove(str2);
                        AppMethodBeat.o(100362);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        lh.C.remove(str2);
                        AppMethodBeat.o(100362);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                    if (httpURLConnection != null) {
                    }
                    lh.C.remove(str2);
                    AppMethodBeat.o(100362);
                    throw th;
                }
            }
        }.start();
        AppMethodBeat.o(100374);
    }

    private String q() {
        AppMethodBeat.i(100375);
        String str = this.c.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
        AppMethodBeat.o(100375);
        return str;
    }

    private String r() {
        AppMethodBeat.i(100376);
        String str = this.c.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
        AppMethodBeat.o(100376);
        return str;
    }

    private String b(String str) {
        AppMethodBeat.i(100377);
        String q = q();
        v.a(q);
        q = q + "/" + str;
        AppMethodBeat.o(100377);
        return q;
    }

    private Bitmap c(String str) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.i(100378);
        F.readLock().lock();
        Closeable fileInputStream;
        try {
            File file = new File(b(str));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap = BitmapFactory.decodeStream(fileInputStream);
                    v.a(fileInputStream);
                    F.readLock().unlock();
                    AppMethodBeat.o(100378);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileInputStream;
                    v.a(closeable);
                    F.readLock().unlock();
                    AppMethodBeat.o(100378);
                    throw th;
                }
            }
            v.a((Closeable) bitmap);
            F.readLock().unlock();
            AppMethodBeat.o(100378);
        } catch (Throwable th3) {
            th = th3;
            closeable = bitmap;
            v.a(closeable);
            F.readLock().unlock();
            AppMethodBeat.o(100378);
            throw th;
        }
        return bitmap;
    }

    private boolean a(String str, Bitmap bitmap) {
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        AppMethodBeat.i(100379);
        F.writeLock().lock();
        if (bitmap == null) {
            AppMethodBeat.o(100379);
        } else {
            Closeable fileOutputStream;
            try {
                File file = new File(b(str));
                if (file.exists()) {
                    v.a(null);
                    F.writeLock().unlock();
                    AppMethodBeat.o(100379);
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        z = bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        v.a(fileOutputStream);
                        F.writeLock().unlock();
                        AppMethodBeat.o(100379);
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = fileOutputStream;
                        v.a(closeable);
                        F.writeLock().unlock();
                        AppMethodBeat.o(100379);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                v.a(closeable);
                F.writeLock().unlock();
                AppMethodBeat.o(100379);
                throw th;
            }
        }
        return z;
    }

    public void a(String str) {
        AppMethodBeat.i(100380);
        if (str == null) {
            AppMethodBeat.o(100380);
            return;
        }
        A.clear();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("level");
                    int i3 = jSONArray2.getInt(0);
                    int i4 = jSONArray2.getInt(1);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray3 = jSONObject.getJSONArray("districts");
                    for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                        jSONObject = jSONArray3.getJSONObject(i5);
                        arrayList.add(new lm(jSONObject.getInt("rule"), jSONObject.getInt(DownloadInfo.PRIORITY), jSONObject.getString("logo_name"), jSONObject.getString("logo"), jSONObject.optString("logo_night"), jSONObject.getString("frontier")));
                    }
                    A.add(new lp(i3, i4, arrayList));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(100380);
                    return;
                }
            }
        } catch (Throwable th) {
            AppMethodBeat.o(100380);
        }
    }

    public void b() {
        AppMethodBeat.i(100381);
        F.writeLock().lock();
        B.clear();
        try {
            File file = new File(q());
            if (file.exists()) {
                final File file2 = new File(r());
                if (file.renameTo(file2)) {
                    new Thread() {
                        public void run() {
                            AppMethodBeat.i(100363);
                            super.run();
                            v.c(file2.getAbsolutePath());
                            AppMethodBeat.o(100363);
                        }
                    }.start();
                } else {
                    v.c(file.getAbsolutePath());
                }
            }
            F.writeLock().unlock();
            AppMethodBeat.o(100381);
        } catch (Throwable th) {
            F.writeLock().unlock();
            AppMethodBeat.o(100381);
            throw th;
        }
    }

    private void a(Bitmap bitmap) {
        AppMethodBeat.i(100382);
        try {
            this.e = bitmap;
            if (this.e != null) {
                this.u = this.e.getWidth();
                this.v = this.e.getHeight();
            }
            u();
            v();
            AppMethodBeat.o(100382);
        } catch (Exception e) {
            AppMethodBeat.o(100382);
        }
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(100383);
        this.s = i;
        this.t = i2;
        u();
        v();
        AppMethodBeat.o(100383);
    }

    public void a() {
        AppMethodBeat.i(100384);
        if (this.E.decrementAndGet() == 0) {
            if (VERSION.SDK_INT < 11) {
                for (Entry value : B.entrySet()) {
                    Bitmap bitmap = (Bitmap) value.getValue();
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                }
            }
            B.clear();
        }
        v.a(this.f);
        AppMethodBeat.o(100384);
    }

    public void a(com.tencent.tencentmap.mapsdk.maps.a.le.b bVar) {
        AppMethodBeat.i(100385);
        if (this.g != bVar) {
            p();
        }
        this.g = bVar;
        AppMethodBeat.o(100385);
    }

    public void b(com.tencent.tencentmap.mapsdk.maps.a.le.b bVar) {
        AppMethodBeat.i(100386);
        if (this.h != bVar) {
            p();
        }
        this.h = bVar;
        AppMethodBeat.o(100386);
    }

    private FrameLayout.LayoutParams s() {
        AppMethodBeat.i(100387);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.f == null) {
            AppMethodBeat.o(100387);
        } else {
            switch (this.g) {
                case LEFT_BOTTOM:
                    layoutParams.gravity = 83;
                    layoutParams.bottomMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e];
                    layoutParams.leftMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT.e];
                    this.aa = (this.t - layoutParams.bottomMargin) - this.f.getHeight();
                    this.Z = layoutParams.leftMargin;
                    break;
                case CENTER_BOTTOM:
                    layoutParams.gravity = 81;
                    layoutParams.bottomMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e];
                    this.aa = (this.t - layoutParams.bottomMargin) - this.f.getHeight();
                    this.Z = (this.s - this.f.getWidth()) / 2;
                    break;
                case RIGHT_BOTTOM:
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e];
                    layoutParams.rightMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT.e];
                    this.aa = (this.t - layoutParams.bottomMargin) - this.f.getHeight();
                    this.Z = (this.s - layoutParams.rightMargin) - this.f.getWidth();
                    break;
                case LEFT_TOP:
                    layoutParams.gravity = 51;
                    layoutParams.topMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e];
                    layoutParams.leftMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT.e];
                    this.aa = layoutParams.topMargin;
                    this.Z = layoutParams.leftMargin;
                    break;
                case CENTER_TOP:
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e];
                    this.aa = layoutParams.topMargin;
                    this.Z = (this.s - this.f.getWidth()) / 2;
                    break;
                case RIGHT_TOP:
                    layoutParams.gravity = 53;
                    layoutParams.topMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e];
                    layoutParams.rightMargin = this.n[com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT.e];
                    this.aa = layoutParams.topMargin;
                    this.Z = (this.s - layoutParams.rightMargin) - this.f.getWidth();
                    break;
                default:
                    d.b("Unknown position:" + this.g);
                    break;
            }
            AppMethodBeat.o(100387);
        }
        return layoutParams;
    }

    private FrameLayout.LayoutParams t() {
        AppMethodBeat.i(100388);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.R == null) {
            AppMethodBeat.o(100388);
        } else {
            int measuredWidth = this.R.getMeasuredWidth();
            int measuredHeight = this.R.getMeasuredHeight();
            switch (this.h) {
                case LEFT_BOTTOM:
                    layoutParams.gravity = 83;
                    layoutParams.bottomMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e];
                    layoutParams.leftMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT.e];
                    this.ac = (this.t - layoutParams.bottomMargin) - measuredHeight;
                    this.ab = layoutParams.leftMargin;
                    break;
                case CENTER_BOTTOM:
                    layoutParams.gravity = 81;
                    layoutParams.bottomMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e];
                    this.ac = (this.t - layoutParams.bottomMargin) - measuredHeight;
                    this.ab = (this.s - measuredWidth) / 2;
                    break;
                case RIGHT_BOTTOM:
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e];
                    layoutParams.rightMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT.e];
                    this.ac = (this.t - layoutParams.bottomMargin) - measuredHeight;
                    this.ab = (this.s - layoutParams.rightMargin) - measuredWidth;
                    break;
                case LEFT_TOP:
                    layoutParams.gravity = 51;
                    layoutParams.topMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e];
                    layoutParams.leftMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT.e];
                    this.ac = layoutParams.topMargin;
                    this.ab = layoutParams.leftMargin;
                    break;
                case CENTER_TOP:
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e];
                    this.ac = layoutParams.topMargin;
                    this.ab = (this.s - measuredWidth) / 2;
                    break;
                case RIGHT_TOP:
                    layoutParams.gravity = 53;
                    layoutParams.topMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e];
                    layoutParams.rightMargin = this.o[com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT.e];
                    this.ac = layoutParams.topMargin;
                    this.ab = (this.s - layoutParams.rightMargin) - measuredWidth;
                    break;
                default:
                    d.b("Unknown positionScale:" + this.h);
                    break;
            }
            AppMethodBeat.o(100388);
        }
        return layoutParams;
    }

    public Rect c() {
        AppMethodBeat.i(100389);
        Rect rect = new Rect();
        if (this.Q != null) {
            rect.left = this.Q.getLeft();
            rect.bottom = this.Q.getBottom();
            rect.right = this.Q.getRight();
            rect.top = this.Q.getTop();
        }
        AppMethodBeat.o(100389);
        return rect;
    }

    public void a(com.tencent.tencentmap.mapsdk.maps.a.le.a aVar, int i) {
        this.l[aVar.e] = i;
    }

    public void a(boolean z) {
        AppMethodBeat.i(100390);
        this.i = z;
        if (this.d != null) {
            this.d.setVisibility(z ? 0 : 4);
        }
        AppMethodBeat.o(100390);
    }

    public void b(com.tencent.tencentmap.mapsdk.maps.a.le.a aVar, int i) {
        AppMethodBeat.i(100391);
        if (this.ad) {
            this.ad = false;
        }
        this.m[aVar.e] = i;
        v();
        AppMethodBeat.o(100391);
    }

    public void d() {
        AppMethodBeat.i(100392);
        u();
        AppMethodBeat.o(100392);
    }

    public void e() {
        AppMethodBeat.i(100393);
        v();
        AppMethodBeat.o(100393);
    }

    private void u() {
        AppMethodBeat.i(100394);
        if (this.s == 0 || this.t == 0) {
            AppMethodBeat.o(100394);
            return;
        }
        this.w = (int) ((((float) this.u) * this.L) / 3.0f);
        this.x = (int) ((((float) this.v) * this.L) / 3.0f);
        float[] fArr = this.p;
        if (this.s >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
            fArr = this.r;
        } else if (this.s >= 720) {
            fArr = this.q;
        }
        int i = com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT.e;
        float f = fArr[i];
        if (this.k[i] >= 0.0f) {
            f = this.k[i];
        }
        this.n[i] = (int) (f * ((float) this.s));
        if (this.ad) {
            this.m[com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e] = this.x;
        }
        if (this.l[i] >= 0 && this.l[i] < this.s - this.w) {
            this.n[i] = this.l[i];
        }
        i = com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT.e;
        f = fArr[i];
        if (this.k[i] >= 0.0f) {
            f = this.k[i];
        }
        this.n[i] = (int) (f * ((float) this.s));
        if (this.l[i] >= 0 && this.l[i] < this.s - this.w) {
            this.n[i] = this.l[i];
        }
        i = com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e;
        f = fArr[i];
        if (this.k[i] >= 0.0f) {
            f = this.k[i];
        }
        this.n[i] = (int) (f * ((float) this.t));
        if (this.l[i] >= 0 && this.l[i] < this.t - this.x) {
            this.n[i] = this.l[i];
        }
        int i2 = com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e;
        float f2 = fArr[i2];
        if (this.k[i2] >= 0.0f) {
            f2 = this.k[i2];
        }
        this.n[i2] = (int) (f2 * ((float) this.t));
        if (this.l[i2] >= 0 && this.l[i2] < this.t - this.x) {
            this.n[i2] = this.l[i2];
        }
        this.y = true;
        p();
        AppMethodBeat.o(100394);
    }

    private void v() {
        AppMethodBeat.i(100395);
        if (this.s == 0 || this.t == 0) {
            AppMethodBeat.o(100395);
            return;
        }
        this.R.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.R.getMeasuredHeight();
        int measuredWidth = this.R.getMeasuredWidth();
        float[] fArr = this.p;
        if (this.s >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
            fArr = this.r;
        } else if (this.s >= 720) {
            fArr = this.q;
        }
        int i = com.tencent.tencentmap.mapsdk.maps.a.le.a.LEFT.e;
        float f = fArr[i];
        if (this.k[i] >= 0.0f) {
            f = this.k[i];
        }
        this.o[i] = (int) (f * ((float) this.s));
        if (this.m[i] >= 0 && this.m[i] < this.s - measuredWidth) {
            this.o[i] = this.m[i];
        }
        i = com.tencent.tencentmap.mapsdk.maps.a.le.a.RIGHT.e;
        f = fArr[i];
        if (this.k[i] >= 0.0f) {
            f = this.k[i];
        }
        this.o[i] = (int) (f * ((float) this.s));
        if (this.m[i] >= 0 && this.m[i] < this.s - measuredWidth) {
            this.o[i] = this.m[i];
        }
        measuredWidth = com.tencent.tencentmap.mapsdk.maps.a.le.a.BOTTOM.e;
        f = fArr[measuredWidth];
        if (this.k[measuredWidth] >= 0.0f) {
            f = this.k[measuredWidth];
        }
        this.o[measuredWidth] = (int) (f * ((float) this.t));
        if (this.m[measuredWidth] >= 0 && this.m[measuredWidth] < this.t - measuredHeight) {
            this.o[measuredWidth] = this.m[measuredWidth];
        }
        int i2 = com.tencent.tencentmap.mapsdk.maps.a.le.a.TOP.e;
        float f2 = fArr[i2];
        if (this.k[i2] >= 0.0f) {
            f2 = this.k[i2];
        }
        this.o[i2] = (int) (f2 * ((float) this.t));
        if (this.m[i2] >= 0 && this.m[i2] < this.t - measuredHeight) {
            this.o[i2] = this.m[i2];
        }
        p();
        AppMethodBeat.o(100395);
    }

    public void b(boolean z) {
        AppMethodBeat.i(100396);
        this.P = z;
        if (!(this.O == null || z)) {
            this.R.setVisibility(8);
        }
        if (this.Y != null) {
            for (a b : this.Y) {
                b.b(this.R, new Rect(this.ab, this.ac, 0, 0), this.P);
            }
        }
        AppMethodBeat.o(100396);
    }

    public boolean f() {
        return this.P;
    }

    public void c(boolean z) {
        AppMethodBeat.i(100397);
        if (this.O != null) {
            this.R.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(100397);
    }

    public void g() {
        AppMethodBeat.i(100398);
        if (this.P) {
            if (this.O != null) {
                this.O.postInvalidate();
            }
            if (this.R != null) {
                if (this.R.getVisibility() != 0) {
                    this.R.setVisibility(0);
                    AppMethodBeat.o(100398);
                    return;
                }
                this.R.clearAnimation();
            }
            AppMethodBeat.o(100398);
            return;
        }
        AppMethodBeat.o(100398);
    }

    public void h() {
        AppMethodBeat.i(100399);
        if (this.R.getVisibility() != 0) {
            AppMethodBeat.o(100399);
            return;
        }
        this.R.clearAnimation();
        this.W.reset();
        this.R.startAnimation(this.W);
        AppMethodBeat.o(100399);
    }

    public void a(int i, double d) {
        AppMethodBeat.i(100400);
        this.M = i;
        this.N = d;
        w();
        p();
        AppMethodBeat.o(100400);
    }

    private void w() {
        int i = 0;
        AppMethodBeat.i(100401);
        int log10 = (int) Math.log10(((double) this.X) * this.N);
        int pow = (int) (((double) H[0]) * Math.pow(10.0d, (double) log10));
        int i2 = (int) (((double) pow) / this.N);
        if (i2 <= 0 || Double.isNaN(this.N)) {
            AppMethodBeat.o(100401);
            return;
        }
        while (i2 < this.X) {
            i++;
            pow = (int) (((double) H[i % H.length]) * Math.pow(10.0d, (double) ((i / H.length) + log10)));
            i2 = (int) (((double) pow) / this.N);
        }
        String str = "m";
        if (pow >= 1000) {
            pow /= 1000;
            str = "km";
        }
        this.I = pow + str;
        this.K = i2;
        this.z.setText(this.I);
        AppMethodBeat.o(100401);
    }

    @Deprecated
    public void a(int i) {
        AppMethodBeat.i(100402);
        this.G = i;
        this.V = Float.MIN_VALUE;
        d();
        AppMethodBeat.o(100402);
    }

    public void a(float f) {
        float f2 = 1.3f;
        float f3 = 0.7f;
        AppMethodBeat.i(100403);
        if (f <= 1.3f) {
            f2 = f;
        }
        if (f2 >= 0.7f) {
            f3 = f2;
        }
        this.G = 0;
        this.V = f3;
        d();
        AppMethodBeat.o(100403);
    }

    private int[] b(int i, int i2) {
        int[] iArr = new int[2];
        float f = 1.0f;
        if (this.V == Float.MIN_VALUE) {
            switch (this.G) {
                case -3:
                    f = 0.7f;
                    break;
                case -2:
                    f = 0.8f;
                    break;
                case -1:
                    f = 0.8333333f;
                    break;
                case 1:
                    f = 1.2f;
                    break;
            }
        }
        f = this.V;
        iArr[0] = (int) (((float) i) * f);
        iArr[1] = (int) (f * ((float) i2));
        return iArr;
    }

    public Bitmap i() {
        AppMethodBeat.i(100404);
        if (this.d == null) {
            AppMethodBeat.o(100404);
            return null;
        }
        Drawable drawable = this.d.getDrawable();
        if (drawable == null) {
            AppMethodBeat.o(100404);
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        AppMethodBeat.o(100404);
        return bitmap;
    }

    public boolean j() {
        AppMethodBeat.i(100405);
        if (StringUtil.isEmpty(this.D)) {
            AppMethodBeat.o(100405);
            return true;
        } else if (this.D.contains("tencent") || this.D.contains("taiwan")) {
            AppMethodBeat.o(100405);
            return true;
        } else {
            AppMethodBeat.o(100405);
            return false;
        }
    }

    public void a(a aVar) {
        AppMethodBeat.i(100406);
        if (!(this.Y == null || aVar == null)) {
            this.Y.add(aVar);
        }
        AppMethodBeat.o(100406);
    }

    public void k() {
        AppMethodBeat.i(100407);
        if (this.Y != null) {
            for (a a : this.Y) {
                a.a(this);
            }
        }
        AppMethodBeat.o(100407);
    }

    public void l() {
        AppMethodBeat.i(100408);
        if (this.Y != null) {
            for (a b : this.Y) {
                b.b(this);
            }
        }
        AppMethodBeat.o(100408);
    }
}
