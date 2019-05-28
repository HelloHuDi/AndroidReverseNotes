package com.tencent.tencentmap.mapsdk.maps.p667a;

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
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.basemap.data.C8885a;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44533le.C36531b;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44533le.C41072a;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lh */
public class C24406lh implements C44533le {
    /* renamed from: A */
    private static List<C46802lp> f4781A = new CopyOnWriteArrayList();
    /* renamed from: B */
    private static ConcurrentHashMap<String, Bitmap> f4782B = new ConcurrentHashMap();
    /* renamed from: C */
    private static List<String> f4783C = new CopyOnWriteArrayList();
    /* renamed from: F */
    private static ReentrantReadWriteLock f4784F = new ReentrantReadWriteLock();
    /* renamed from: H */
    private static final int[] f4785H = new int[]{1, 2, 5};
    /* renamed from: D */
    private String f4786D = null;
    /* renamed from: E */
    private AtomicInteger f4787E = new AtomicInteger(0);
    /* renamed from: G */
    private int f4788G = 0;
    /* renamed from: I */
    private String f4789I = "50m";
    /* renamed from: J */
    private int f4790J = 11;
    /* renamed from: K */
    private int f4791K = 109;
    /* renamed from: L */
    private float f4792L = 1.0f;
    /* renamed from: M */
    private int f4793M;
    /* renamed from: N */
    private double f4794N;
    /* renamed from: O */
    private C24405b f4795O;
    /* renamed from: P */
    private boolean f4796P = true;
    /* renamed from: Q */
    private LinearLayout f4797Q;
    /* renamed from: R */
    private LinearLayout f4798R;
    /* renamed from: S */
    private final int f4799S;
    /* renamed from: T */
    private final int f4800T;
    /* renamed from: U */
    private final int f4801U = 18;
    /* renamed from: V */
    private float f4802V = Float.MIN_VALUE;
    /* renamed from: W */
    private Animation f4803W;
    /* renamed from: X */
    private int f4804X = 40;
    /* renamed from: Y */
    private List<C24404a> f4805Y = new ArrayList();
    /* renamed from: Z */
    private int f4806Z = -1;
    /* renamed from: a */
    private final int f4807a = 500;
    /* renamed from: aa */
    private int f4808aa = -1;
    /* renamed from: ab */
    private int f4809ab = -1;
    /* renamed from: ac */
    private int f4810ac = -1;
    /* renamed from: ad */
    private boolean f4811ad = true;
    /* renamed from: b */
    private final int f4812b = 1000;
    /* renamed from: c */
    private Context f4813c;
    /* renamed from: d */
    private ImageView f4814d;
    /* renamed from: e */
    private Bitmap f4815e;
    /* renamed from: f */
    private Bitmap f4816f;
    /* renamed from: g */
    private C36531b f4817g = C36531b.RIGHT_BOTTOM;
    /* renamed from: h */
    private C36531b f4818h = C36531b.LEFT_BOTTOM;
    /* renamed from: i */
    private boolean f4819i = true;
    /* renamed from: j */
    private ViewGroup f4820j;
    /* renamed from: k */
    private float[] f4821k = new float[]{-1.0f, -1.0f, -1.0f, -1.0f};
    /* renamed from: l */
    private int[] f4822l = new int[]{-1, -1, -1, -1};
    /* renamed from: m */
    private int[] f4823m = new int[]{-1, -1, -1, -1};
    /* renamed from: n */
    private int[] f4824n = new int[C41072a.values().length];
    /* renamed from: o */
    private int[] f4825o = new int[C41072a.values().length];
    /* renamed from: p */
    private float[] f4826p = new float[]{0.02f, 0.02f, 0.012f, 0.012f};
    /* renamed from: q */
    private float[] f4827q = new float[]{0.022f, 0.022f, 0.0125f, 0.0125f};
    /* renamed from: r */
    private float[] f4828r = new float[]{0.0185f, 0.0185f, 0.0104f, 0.0104f};
    /* renamed from: s */
    private int f4829s = 0;
    /* renamed from: t */
    private int f4830t = 0;
    /* renamed from: u */
    private int f4831u = 0;
    /* renamed from: v */
    private int f4832v = 0;
    /* renamed from: w */
    private int f4833w = 0;
    /* renamed from: x */
    private int f4834x = 0;
    /* renamed from: y */
    private boolean f4835y = false;
    /* renamed from: z */
    private TextView f4836z;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lh$a */
    public interface C24404a {
        /* renamed from: a */
        void mo40692a(View view, Rect rect, boolean z);

        /* renamed from: a */
        void mo40693a(C24406lh c24406lh);

        /* renamed from: b */
        void mo40694b(View view, Rect rect, boolean z);

        /* renamed from: b */
        void mo40695b(C24406lh c24406lh);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lh$b */
    class C24405b extends View {
        /* renamed from: b */
        private Paint f4779b = new Paint();
        /* renamed from: c */
        private Paint f4780c;

        public C24405b(Context context) {
            super(context);
            AppMethodBeat.m2504i(100365);
            this.f4779b.setAntiAlias(true);
            this.f4779b.setColor(WebView.NIGHT_MODE_COLOR);
            this.f4779b.setStrokeWidth(1.0f * C24406lh.this.f4792L);
            this.f4779b.setStyle(Style.STROKE);
            this.f4780c = new Paint(65);
            this.f4780c.setStyle(Style.FILL);
            this.f4780c.setColor(0);
            AppMethodBeat.m2505o(100365);
        }

        public void draw(Canvas canvas) {
            AppMethodBeat.m2504i(100366);
            super.draw(canvas);
            m37919a(canvas, getHeight());
            AppMethodBeat.m2505o(100366);
        }

        /* Access modifiers changed, original: protected */
        public void onMeasure(int i, int i2) {
            AppMethodBeat.m2504i(100367);
            super.onMeasure(i, i2);
            setMeasuredDimension(Math.min(Math.round(((float) C24406lh.this.f4791K) + (12.0f * C24406lh.this.f4792L)), C24406lh.this.f4829s / 2), Math.round(((float) C24406lh.this.f4790J) * C24406lh.this.f4792L));
            AppMethodBeat.m2505o(100367);
        }

        /* renamed from: a */
        private void m37919a(Canvas canvas, int i) {
            AppMethodBeat.m2504i(100368);
            int c = (int) (6.0f * C24406lh.this.f4792L);
            int i2 = i / 2;
            canvas.drawPaint(this.f4780c);
            canvas.drawLine((float) c, (float) i2, (float) (C24406lh.this.f4791K + c), (float) i2, this.f4779b);
            canvas.drawLine((float) c, ((float) i2) - (C24406lh.this.f4792L * 3.0f), (float) c, (float) (i2 + 1), this.f4779b);
            canvas.drawLine((float) (C24406lh.this.f4791K + c), ((float) i2) - (C24406lh.this.f4792L * 3.0f), (float) (C24406lh.this.f4791K + c), (float) (i2 + 1), this.f4779b);
            AppMethodBeat.m2505o(100368);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lh$1 */
    class C244091 implements AnimationListener {
        C244091() {
        }

        public void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(100359);
            if (C24406lh.this.f4798R != null) {
                C24406lh.this.f4798R.setVisibility(0);
            }
            AppMethodBeat.m2505o(100359);
        }

        public void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(100360);
            if (C24406lh.this.f4798R != null) {
                C24406lh.this.f4798R.setVisibility(8);
            }
            AppMethodBeat.m2505o(100360);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m37924a(C24406lh c24406lh, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(100410);
        boolean a = c24406lh.m37925a(str, bitmap);
        AppMethodBeat.m2505o(100410);
        return a;
    }

    static {
        AppMethodBeat.m2504i(100411);
        AppMethodBeat.m2505o(100411);
    }

    public C24406lh(Context context, int i, int i2) {
        AppMethodBeat.m2504i(100369);
        this.f4813c = context;
        this.f4799S = i;
        this.f4800T = i2;
        this.f4792L = context.getResources().getDisplayMetrics().density;
        this.f4804X = (int) (((double) (40.0f * this.f4792L)) + 0.5d);
        this.f4814d = new ImageView(context);
        this.f4795O = new C24405b(this.f4813c);
        this.f4836z = new TextView(this.f4813c);
        this.f4836z.setText(this.f4789I);
        this.f4836z.setContentDescription("地图");
        this.f4836z.setTextSize(12.0f);
        this.f4836z.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.f4836z.setGravity(1);
        if (this.f4792L <= 0.0f) {
            this.f4792L = 1.0f;
        }
        this.f4797Q = new LinearLayout(this.f4813c);
        this.f4797Q.setOrientation(1);
        this.f4797Q.setGravity(16);
        this.f4798R = new LinearLayout(this.f4813c);
        this.f4798R.setOrientation(1);
        this.f4798R.setGravity(16);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.f4798R.addView(this.f4836z, layoutParams);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.f4798R.addView(this.f4795O, layoutParams);
        this.f4798R.setVisibility(8);
        m37936o();
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.f4797Q.addView(this.f4814d, layoutParams);
        mo40706a(C24414lq.m37996g());
        AppMethodBeat.m2505o(100369);
    }

    /* renamed from: o */
    private void m37936o() {
        AppMethodBeat.m2504i(100370);
        this.f4803W = new AlphaAnimation(1.0f, 0.0f);
        this.f4803W.setDuration(1000);
        this.f4803W.setStartOffset(500);
        this.f4803W.setAnimationListener(new C244091());
        AppMethodBeat.m2505o(100370);
    }

    /* renamed from: a */
    public boolean mo40708a(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(100371);
        if (viewGroup == null) {
            AppMethodBeat.m2505o(100371);
            return false;
        }
        if (this.f4835y) {
            this.f4835y = false;
            C31015v.m49800a(this.f4816f);
            int[] b = m37928b(this.f4833w, this.f4834x);
            this.f4816f = C24388ht.m37843a(this.f4815e, this.f4813c, b[0], b[1]);
            try {
                this.f4814d.setImageBitmap(this.f4816f);
            } catch (Throwable th) {
                Log.getStackTraceString(th);
            }
        }
        this.f4820j = viewGroup;
        FrameLayout.LayoutParams s = m37940s();
        if (viewGroup.indexOfChild(this.f4797Q) < 0) {
            viewGroup.addView(this.f4797Q, s);
        } else {
            viewGroup.updateViewLayout(this.f4797Q, s);
        }
        s = m37941t();
        if (viewGroup.indexOfChild(this.f4798R) < 0) {
            viewGroup.addView(this.f4798R, s);
        } else {
            viewGroup.updateViewLayout(this.f4798R, s);
        }
        if (!(this.f4836z == null || this.f4795O == null)) {
            LayoutParams layoutParams = (LayoutParams) this.f4836z.getLayoutParams();
            this.f4795O.measure(0, 0);
            this.f4836z.measure(0, 0);
            layoutParams.leftMargin = (int) (((((float) this.f4791K) + (6.0f * this.f4792L)) - ((float) this.f4836z.getWidth())) / 2.0f);
            this.f4798R.updateViewLayout(this.f4836z, layoutParams);
            this.f4798R.updateViewLayout(this.f4795O, this.f4795O.getLayoutParams());
        }
        this.f4814d.setVisibility(this.f4819i ? 0 : 4);
        if (this.f4805Y != null) {
            this.f4797Q.requestLayout();
            this.f4798R.requestLayout();
            for (C24404a c24404a : this.f4805Y) {
                c24404a.mo40692a(this.f4797Q, new Rect(this.f4806Z, this.f4808aa, 0, 0), this.f4819i);
                c24404a.mo40694b(this.f4798R, new Rect(this.f4809ab, this.f4810ac, 0, 0), this.f4796P);
            }
        }
        viewGroup.requestLayout();
        AppMethodBeat.m2505o(100371);
        return true;
    }

    /* renamed from: p */
    private void m37937p() {
        AppMethodBeat.m2504i(100372);
        mo40708a(this.f4820j);
        AppMethodBeat.m2505o(100372);
    }

    /* renamed from: a */
    public void mo40702a(C8885a c8885a, int i) {
        AppMethodBeat.m2504i(100373);
        int c = (int) c8885a.mo20123c();
        if (c > 18) {
            c = 18;
        }
        for (C46802lp c46802lp : f4781A) {
            if (c >= c46802lp.mo75521a() && c <= c46802lp.mo75523b()) {
                break;
            }
        }
        C46802lp c46802lp2 = null;
        if (c46802lp2 == null) {
            AppMethodBeat.m2505o(100373);
            return;
        }
        String[] a = c46802lp2.mo75522a(c8885a, i);
        if (a == null) {
            AppMethodBeat.m2505o(100373);
            return;
        }
        String str = a[0];
        String str2 = a[1];
        if ((!StringUtil.isEqual(str, this.f4786D) ? 1 : 0) != 0) {
            Bitmap bitmap = (Bitmap) f4782B.get(str);
            if (bitmap != null) {
                if (bitmap.isRecycled()) {
                    f4782B.remove(str);
                } else {
                    m37921a(bitmap);
                    this.f4786D = str;
                    AppMethodBeat.m2505o(100373);
                    return;
                }
            }
            bitmap = m37930c(str);
            if (bitmap != null) {
                this.f4786D = str;
                f4782B.put(this.f4786D, bitmap);
                m37921a(bitmap);
                AppMethodBeat.m2505o(100373);
                return;
            }
            this.f4786D = null;
            m37923a(str2, str);
        }
        AppMethodBeat.m2505o(100373);
    }

    /* renamed from: a */
    private void m37923a(final String str, final String str2) {
        AppMethodBeat.m2504i(100374);
        if (f4783C.contains(str2)) {
            AppMethodBeat.m2505o(100374);
            return;
        }
        f4783C.add(str2);
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                Throwable th;
                HttpURLConnection httpURLConnection;
                AppMethodBeat.m2504i(100362);
                super.run();
                HttpURLConnection httpURLConnection2;
                try {
                    httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                        if (httpURLConnection2.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection2.getInputStream());
                            if (decodeStream != null) {
                                C24406lh.f4782B.put(str2, decodeStream);
                            }
                            if (C24406lh.this.f4814d != null) {
                                C24406lh.this.f4814d.post(new Runnable() {
                                    public void run() {
                                        AppMethodBeat.m2504i(100361);
                                        C24406lh.m37922a(C24406lh.this, decodeStream);
                                        AppMethodBeat.m2505o(100361);
                                    }
                                });
                            }
                            C24406lh.m37924a(C24406lh.this, str2, decodeStream);
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        C24406lh.f4783C.remove(str2);
                        AppMethodBeat.m2505o(100362);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        C24406lh.f4783C.remove(str2);
                        AppMethodBeat.m2505o(100362);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                    if (httpURLConnection != null) {
                    }
                    C24406lh.f4783C.remove(str2);
                    AppMethodBeat.m2505o(100362);
                    throw th;
                }
            }
        }.start();
        AppMethodBeat.m2505o(100374);
    }

    /* renamed from: q */
    private String m37938q() {
        AppMethodBeat.m2504i(100375);
        String str = this.f4813c.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
        AppMethodBeat.m2505o(100375);
        return str;
    }

    /* renamed from: r */
    private String m37939r() {
        AppMethodBeat.m2504i(100376);
        String str = this.f4813c.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
        AppMethodBeat.m2505o(100376);
        return str;
    }

    /* renamed from: b */
    private String m37927b(String str) {
        AppMethodBeat.m2504i(100377);
        String q = m37938q();
        C31015v.m49802a(q);
        q = q + "/" + str;
        AppMethodBeat.m2505o(100377);
        return q;
    }

    /* renamed from: c */
    private Bitmap m37930c(String str) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(100378);
        f4784F.readLock().lock();
        Closeable fileInputStream;
        try {
            File file = new File(m37927b(str));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap = BitmapFactory.decodeStream(fileInputStream);
                    C31015v.m49801a(fileInputStream);
                    f4784F.readLock().unlock();
                    AppMethodBeat.m2505o(100378);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileInputStream;
                    C31015v.m49801a(closeable);
                    f4784F.readLock().unlock();
                    AppMethodBeat.m2505o(100378);
                    throw th;
                }
            }
            C31015v.m49801a((Closeable) bitmap);
            f4784F.readLock().unlock();
            AppMethodBeat.m2505o(100378);
        } catch (Throwable th3) {
            th = th3;
            closeable = bitmap;
            C31015v.m49801a(closeable);
            f4784F.readLock().unlock();
            AppMethodBeat.m2505o(100378);
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    private boolean m37925a(String str, Bitmap bitmap) {
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        AppMethodBeat.m2504i(100379);
        f4784F.writeLock().lock();
        if (bitmap == null) {
            AppMethodBeat.m2505o(100379);
        } else {
            Closeable fileOutputStream;
            try {
                File file = new File(m37927b(str));
                if (file.exists()) {
                    C31015v.m49801a(null);
                    f4784F.writeLock().unlock();
                    AppMethodBeat.m2505o(100379);
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        z = bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        C31015v.m49801a(fileOutputStream);
                        f4784F.writeLock().unlock();
                        AppMethodBeat.m2505o(100379);
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = fileOutputStream;
                        C31015v.m49801a(closeable);
                        f4784F.writeLock().unlock();
                        AppMethodBeat.m2505o(100379);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                C31015v.m49801a(closeable);
                f4784F.writeLock().unlock();
                AppMethodBeat.m2505o(100379);
                throw th;
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo40706a(String str) {
        AppMethodBeat.m2504i(100380);
        if (str == null) {
            AppMethodBeat.m2505o(100380);
            return;
        }
        f4781A.clear();
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
                        arrayList.add(new C44536lm(jSONObject.getInt("rule"), jSONObject.getInt(DownloadInfo.PRIORITY), jSONObject.getString("logo_name"), jSONObject.getString("logo"), jSONObject.optString("logo_night"), jSONObject.getString("frontier")));
                    }
                    f4781A.add(new C46802lp(i3, i4, arrayList));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(100380);
                    return;
                }
            }
        } catch (Throwable th) {
            AppMethodBeat.m2505o(100380);
        }
    }

    /* renamed from: b */
    public void mo40709b() {
        AppMethodBeat.m2504i(100381);
        f4784F.writeLock().lock();
        f4782B.clear();
        try {
            File file = new File(m37938q());
            if (file.exists()) {
                final File file2 = new File(m37939r());
                if (file.renameTo(file2)) {
                    new Thread() {
                        public void run() {
                            AppMethodBeat.m2504i(100363);
                            super.run();
                            C31015v.m49805c(file2.getAbsolutePath());
                            AppMethodBeat.m2505o(100363);
                        }
                    }.start();
                } else {
                    C31015v.m49805c(file.getAbsolutePath());
                }
            }
            f4784F.writeLock().unlock();
            AppMethodBeat.m2505o(100381);
        } catch (Throwable th) {
            f4784F.writeLock().unlock();
            AppMethodBeat.m2505o(100381);
            throw th;
        }
    }

    /* renamed from: a */
    private void m37921a(Bitmap bitmap) {
        AppMethodBeat.m2504i(100382);
        try {
            this.f4815e = bitmap;
            if (this.f4815e != null) {
                this.f4831u = this.f4815e.getWidth();
                this.f4832v = this.f4815e.getHeight();
            }
            m37942u();
            m37943v();
            AppMethodBeat.m2505o(100382);
        } catch (Exception e) {
            AppMethodBeat.m2505o(100382);
        }
    }

    /* renamed from: a */
    public void mo40422a(int i, int i2) {
        AppMethodBeat.m2504i(100383);
        this.f4829s = i;
        this.f4830t = i2;
        m37942u();
        m37943v();
        AppMethodBeat.m2505o(100383);
    }

    /* renamed from: a */
    public void mo40698a() {
        AppMethodBeat.m2504i(100384);
        if (this.f4787E.decrementAndGet() == 0) {
            if (VERSION.SDK_INT < 11) {
                for (Entry value : f4782B.entrySet()) {
                    Bitmap bitmap = (Bitmap) value.getValue();
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                }
            }
            f4782B.clear();
        }
        C31015v.m49800a(this.f4816f);
        AppMethodBeat.m2505o(100384);
    }

    /* renamed from: a */
    public void mo40704a(C36531b c36531b) {
        AppMethodBeat.m2504i(100385);
        if (this.f4817g != c36531b) {
            m37937p();
        }
        this.f4817g = c36531b;
        AppMethodBeat.m2505o(100385);
    }

    /* renamed from: b */
    public void mo40711b(C36531b c36531b) {
        AppMethodBeat.m2504i(100386);
        if (this.f4818h != c36531b) {
            m37937p();
        }
        this.f4818h = c36531b;
        AppMethodBeat.m2505o(100386);
    }

    /* renamed from: s */
    private FrameLayout.LayoutParams m37940s() {
        AppMethodBeat.m2504i(100387);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.f4816f == null) {
            AppMethodBeat.m2505o(100387);
        } else {
            switch (this.f4817g) {
                case LEFT_BOTTOM:
                    layoutParams.gravity = 83;
                    layoutParams.bottomMargin = this.f4824n[C41072a.BOTTOM.f16539e];
                    layoutParams.leftMargin = this.f4824n[C41072a.LEFT.f16539e];
                    this.f4808aa = (this.f4830t - layoutParams.bottomMargin) - this.f4816f.getHeight();
                    this.f4806Z = layoutParams.leftMargin;
                    break;
                case CENTER_BOTTOM:
                    layoutParams.gravity = 81;
                    layoutParams.bottomMargin = this.f4824n[C41072a.BOTTOM.f16539e];
                    this.f4808aa = (this.f4830t - layoutParams.bottomMargin) - this.f4816f.getHeight();
                    this.f4806Z = (this.f4829s - this.f4816f.getWidth()) / 2;
                    break;
                case RIGHT_BOTTOM:
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = this.f4824n[C41072a.BOTTOM.f16539e];
                    layoutParams.rightMargin = this.f4824n[C41072a.RIGHT.f16539e];
                    this.f4808aa = (this.f4830t - layoutParams.bottomMargin) - this.f4816f.getHeight();
                    this.f4806Z = (this.f4829s - layoutParams.rightMargin) - this.f4816f.getWidth();
                    break;
                case LEFT_TOP:
                    layoutParams.gravity = 51;
                    layoutParams.topMargin = this.f4824n[C41072a.TOP.f16539e];
                    layoutParams.leftMargin = this.f4824n[C41072a.LEFT.f16539e];
                    this.f4808aa = layoutParams.topMargin;
                    this.f4806Z = layoutParams.leftMargin;
                    break;
                case CENTER_TOP:
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.f4824n[C41072a.TOP.f16539e];
                    this.f4808aa = layoutParams.topMargin;
                    this.f4806Z = (this.f4829s - this.f4816f.getWidth()) / 2;
                    break;
                case RIGHT_TOP:
                    layoutParams.gravity = 53;
                    layoutParams.topMargin = this.f4824n[C41072a.TOP.f16539e];
                    layoutParams.rightMargin = this.f4824n[C41072a.RIGHT.f16539e];
                    this.f4808aa = layoutParams.topMargin;
                    this.f4806Z = (this.f4829s - layoutParams.rightMargin) - this.f4816f.getWidth();
                    break;
                default:
                    C1015d.m2290b("Unknown position:" + this.f4817g);
                    break;
            }
            AppMethodBeat.m2505o(100387);
        }
        return layoutParams;
    }

    /* renamed from: t */
    private FrameLayout.LayoutParams m37941t() {
        AppMethodBeat.m2504i(100388);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.f4798R == null) {
            AppMethodBeat.m2505o(100388);
        } else {
            int measuredWidth = this.f4798R.getMeasuredWidth();
            int measuredHeight = this.f4798R.getMeasuredHeight();
            switch (this.f4818h) {
                case LEFT_BOTTOM:
                    layoutParams.gravity = 83;
                    layoutParams.bottomMargin = this.f4825o[C41072a.BOTTOM.f16539e];
                    layoutParams.leftMargin = this.f4825o[C41072a.LEFT.f16539e];
                    this.f4810ac = (this.f4830t - layoutParams.bottomMargin) - measuredHeight;
                    this.f4809ab = layoutParams.leftMargin;
                    break;
                case CENTER_BOTTOM:
                    layoutParams.gravity = 81;
                    layoutParams.bottomMargin = this.f4825o[C41072a.BOTTOM.f16539e];
                    this.f4810ac = (this.f4830t - layoutParams.bottomMargin) - measuredHeight;
                    this.f4809ab = (this.f4829s - measuredWidth) / 2;
                    break;
                case RIGHT_BOTTOM:
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = this.f4825o[C41072a.BOTTOM.f16539e];
                    layoutParams.rightMargin = this.f4825o[C41072a.RIGHT.f16539e];
                    this.f4810ac = (this.f4830t - layoutParams.bottomMargin) - measuredHeight;
                    this.f4809ab = (this.f4829s - layoutParams.rightMargin) - measuredWidth;
                    break;
                case LEFT_TOP:
                    layoutParams.gravity = 51;
                    layoutParams.topMargin = this.f4825o[C41072a.TOP.f16539e];
                    layoutParams.leftMargin = this.f4825o[C41072a.LEFT.f16539e];
                    this.f4810ac = layoutParams.topMargin;
                    this.f4809ab = layoutParams.leftMargin;
                    break;
                case CENTER_TOP:
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.f4825o[C41072a.TOP.f16539e];
                    this.f4810ac = layoutParams.topMargin;
                    this.f4809ab = (this.f4829s - measuredWidth) / 2;
                    break;
                case RIGHT_TOP:
                    layoutParams.gravity = 53;
                    layoutParams.topMargin = this.f4825o[C41072a.TOP.f16539e];
                    layoutParams.rightMargin = this.f4825o[C41072a.RIGHT.f16539e];
                    this.f4810ac = layoutParams.topMargin;
                    this.f4809ab = (this.f4829s - layoutParams.rightMargin) - measuredWidth;
                    break;
                default:
                    C1015d.m2290b("Unknown positionScale:" + this.f4818h);
                    break;
            }
            AppMethodBeat.m2505o(100388);
        }
        return layoutParams;
    }

    /* renamed from: c */
    public Rect mo40713c() {
        AppMethodBeat.m2504i(100389);
        Rect rect = new Rect();
        if (this.f4797Q != null) {
            rect.left = this.f4797Q.getLeft();
            rect.bottom = this.f4797Q.getBottom();
            rect.right = this.f4797Q.getRight();
            rect.top = this.f4797Q.getTop();
        }
        AppMethodBeat.m2505o(100389);
        return rect;
    }

    /* renamed from: a */
    public void mo40703a(C41072a c41072a, int i) {
        this.f4822l[c41072a.f16539e] = i;
    }

    /* renamed from: a */
    public void mo40707a(boolean z) {
        AppMethodBeat.m2504i(100390);
        this.f4819i = z;
        if (this.f4814d != null) {
            this.f4814d.setVisibility(z ? 0 : 4);
        }
        AppMethodBeat.m2505o(100390);
    }

    /* renamed from: b */
    public void mo40710b(C41072a c41072a, int i) {
        AppMethodBeat.m2504i(100391);
        if (this.f4811ad) {
            this.f4811ad = false;
        }
        this.f4823m[c41072a.f16539e] = i;
        m37943v();
        AppMethodBeat.m2505o(100391);
    }

    /* renamed from: d */
    public void mo40715d() {
        AppMethodBeat.m2504i(100392);
        m37942u();
        AppMethodBeat.m2505o(100392);
    }

    /* renamed from: e */
    public void mo40716e() {
        AppMethodBeat.m2504i(100393);
        m37943v();
        AppMethodBeat.m2505o(100393);
    }

    /* renamed from: u */
    private void m37942u() {
        AppMethodBeat.m2504i(100394);
        if (this.f4829s == 0 || this.f4830t == 0) {
            AppMethodBeat.m2505o(100394);
            return;
        }
        this.f4833w = (int) ((((float) this.f4831u) * this.f4792L) / 3.0f);
        this.f4834x = (int) ((((float) this.f4832v) * this.f4792L) / 3.0f);
        float[] fArr = this.f4826p;
        if (this.f4829s >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
            fArr = this.f4828r;
        } else if (this.f4829s >= 720) {
            fArr = this.f4827q;
        }
        int i = C41072a.LEFT.f16539e;
        float f = fArr[i];
        if (this.f4821k[i] >= 0.0f) {
            f = this.f4821k[i];
        }
        this.f4824n[i] = (int) (f * ((float) this.f4829s));
        if (this.f4811ad) {
            this.f4823m[C41072a.BOTTOM.f16539e] = this.f4834x;
        }
        if (this.f4822l[i] >= 0 && this.f4822l[i] < this.f4829s - this.f4833w) {
            this.f4824n[i] = this.f4822l[i];
        }
        i = C41072a.RIGHT.f16539e;
        f = fArr[i];
        if (this.f4821k[i] >= 0.0f) {
            f = this.f4821k[i];
        }
        this.f4824n[i] = (int) (f * ((float) this.f4829s));
        if (this.f4822l[i] >= 0 && this.f4822l[i] < this.f4829s - this.f4833w) {
            this.f4824n[i] = this.f4822l[i];
        }
        i = C41072a.BOTTOM.f16539e;
        f = fArr[i];
        if (this.f4821k[i] >= 0.0f) {
            f = this.f4821k[i];
        }
        this.f4824n[i] = (int) (f * ((float) this.f4830t));
        if (this.f4822l[i] >= 0 && this.f4822l[i] < this.f4830t - this.f4834x) {
            this.f4824n[i] = this.f4822l[i];
        }
        int i2 = C41072a.TOP.f16539e;
        float f2 = fArr[i2];
        if (this.f4821k[i2] >= 0.0f) {
            f2 = this.f4821k[i2];
        }
        this.f4824n[i2] = (int) (f2 * ((float) this.f4830t));
        if (this.f4822l[i2] >= 0 && this.f4822l[i2] < this.f4830t - this.f4834x) {
            this.f4824n[i2] = this.f4822l[i2];
        }
        this.f4835y = true;
        m37937p();
        AppMethodBeat.m2505o(100394);
    }

    /* renamed from: v */
    private void m37943v() {
        AppMethodBeat.m2504i(100395);
        if (this.f4829s == 0 || this.f4830t == 0) {
            AppMethodBeat.m2505o(100395);
            return;
        }
        this.f4798R.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.f4798R.getMeasuredHeight();
        int measuredWidth = this.f4798R.getMeasuredWidth();
        float[] fArr = this.f4826p;
        if (this.f4829s >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
            fArr = this.f4828r;
        } else if (this.f4829s >= 720) {
            fArr = this.f4827q;
        }
        int i = C41072a.LEFT.f16539e;
        float f = fArr[i];
        if (this.f4821k[i] >= 0.0f) {
            f = this.f4821k[i];
        }
        this.f4825o[i] = (int) (f * ((float) this.f4829s));
        if (this.f4823m[i] >= 0 && this.f4823m[i] < this.f4829s - measuredWidth) {
            this.f4825o[i] = this.f4823m[i];
        }
        i = C41072a.RIGHT.f16539e;
        f = fArr[i];
        if (this.f4821k[i] >= 0.0f) {
            f = this.f4821k[i];
        }
        this.f4825o[i] = (int) (f * ((float) this.f4829s));
        if (this.f4823m[i] >= 0 && this.f4823m[i] < this.f4829s - measuredWidth) {
            this.f4825o[i] = this.f4823m[i];
        }
        measuredWidth = C41072a.BOTTOM.f16539e;
        f = fArr[measuredWidth];
        if (this.f4821k[measuredWidth] >= 0.0f) {
            f = this.f4821k[measuredWidth];
        }
        this.f4825o[measuredWidth] = (int) (f * ((float) this.f4830t));
        if (this.f4823m[measuredWidth] >= 0 && this.f4823m[measuredWidth] < this.f4830t - measuredHeight) {
            this.f4825o[measuredWidth] = this.f4823m[measuredWidth];
        }
        int i2 = C41072a.TOP.f16539e;
        float f2 = fArr[i2];
        if (this.f4821k[i2] >= 0.0f) {
            f2 = this.f4821k[i2];
        }
        this.f4825o[i2] = (int) (f2 * ((float) this.f4830t));
        if (this.f4823m[i2] >= 0 && this.f4823m[i2] < this.f4830t - measuredHeight) {
            this.f4825o[i2] = this.f4823m[i2];
        }
        m37937p();
        AppMethodBeat.m2505o(100395);
    }

    /* renamed from: b */
    public void mo40712b(boolean z) {
        AppMethodBeat.m2504i(100396);
        this.f4796P = z;
        if (!(this.f4795O == null || z)) {
            this.f4798R.setVisibility(8);
        }
        if (this.f4805Y != null) {
            for (C24404a b : this.f4805Y) {
                b.mo40694b(this.f4798R, new Rect(this.f4809ab, this.f4810ac, 0, 0), this.f4796P);
            }
        }
        AppMethodBeat.m2505o(100396);
    }

    /* renamed from: f */
    public boolean mo40717f() {
        return this.f4796P;
    }

    /* renamed from: c */
    public void mo40714c(boolean z) {
        AppMethodBeat.m2504i(100397);
        if (this.f4795O != null) {
            this.f4798R.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.m2505o(100397);
    }

    /* renamed from: g */
    public void mo40718g() {
        AppMethodBeat.m2504i(100398);
        if (this.f4796P) {
            if (this.f4795O != null) {
                this.f4795O.postInvalidate();
            }
            if (this.f4798R != null) {
                if (this.f4798R.getVisibility() != 0) {
                    this.f4798R.setVisibility(0);
                    AppMethodBeat.m2505o(100398);
                    return;
                }
                this.f4798R.clearAnimation();
            }
            AppMethodBeat.m2505o(100398);
            return;
        }
        AppMethodBeat.m2505o(100398);
    }

    /* renamed from: h */
    public void mo40719h() {
        AppMethodBeat.m2504i(100399);
        if (this.f4798R.getVisibility() != 0) {
            AppMethodBeat.m2505o(100399);
            return;
        }
        this.f4798R.clearAnimation();
        this.f4803W.reset();
        this.f4798R.startAnimation(this.f4803W);
        AppMethodBeat.m2505o(100399);
    }

    /* renamed from: a */
    public void mo40701a(int i, double d) {
        AppMethodBeat.m2504i(100400);
        this.f4793M = i;
        this.f4794N = d;
        m37944w();
        m37937p();
        AppMethodBeat.m2505o(100400);
    }

    /* renamed from: w */
    private void m37944w() {
        int i = 0;
        AppMethodBeat.m2504i(100401);
        int log10 = (int) Math.log10(((double) this.f4804X) * this.f4794N);
        int pow = (int) (((double) f4785H[0]) * Math.pow(10.0d, (double) log10));
        int i2 = (int) (((double) pow) / this.f4794N);
        if (i2 <= 0 || Double.isNaN(this.f4794N)) {
            AppMethodBeat.m2505o(100401);
            return;
        }
        while (i2 < this.f4804X) {
            i++;
            pow = (int) (((double) f4785H[i % f4785H.length]) * Math.pow(10.0d, (double) ((i / f4785H.length) + log10)));
            i2 = (int) (((double) pow) / this.f4794N);
        }
        String str = "m";
        if (pow >= 1000) {
            pow /= 1000;
            str = "km";
        }
        this.f4789I = pow + str;
        this.f4791K = i2;
        this.f4836z.setText(this.f4789I);
        AppMethodBeat.m2505o(100401);
    }

    @Deprecated
    /* renamed from: a */
    public void mo40700a(int i) {
        AppMethodBeat.m2504i(100402);
        this.f4788G = i;
        this.f4802V = Float.MIN_VALUE;
        mo40715d();
        AppMethodBeat.m2505o(100402);
    }

    /* renamed from: a */
    public void mo40699a(float f) {
        float f2 = 1.3f;
        float f3 = 0.7f;
        AppMethodBeat.m2504i(100403);
        if (f <= 1.3f) {
            f2 = f;
        }
        if (f2 >= 0.7f) {
            f3 = f2;
        }
        this.f4788G = 0;
        this.f4802V = f3;
        mo40715d();
        AppMethodBeat.m2505o(100403);
    }

    /* renamed from: b */
    private int[] m37928b(int i, int i2) {
        int[] iArr = new int[2];
        float f = 1.0f;
        if (this.f4802V == Float.MIN_VALUE) {
            switch (this.f4788G) {
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
        f = this.f4802V;
        iArr[0] = (int) (((float) i) * f);
        iArr[1] = (int) (f * ((float) i2));
        return iArr;
    }

    /* renamed from: i */
    public Bitmap mo40720i() {
        AppMethodBeat.m2504i(100404);
        if (this.f4814d == null) {
            AppMethodBeat.m2505o(100404);
            return null;
        }
        Drawable drawable = this.f4814d.getDrawable();
        if (drawable == null) {
            AppMethodBeat.m2505o(100404);
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        AppMethodBeat.m2505o(100404);
        return bitmap;
    }

    /* renamed from: j */
    public boolean mo40721j() {
        AppMethodBeat.m2504i(100405);
        if (StringUtil.isEmpty(this.f4786D)) {
            AppMethodBeat.m2505o(100405);
            return true;
        } else if (this.f4786D.contains("tencent") || this.f4786D.contains("taiwan")) {
            AppMethodBeat.m2505o(100405);
            return true;
        } else {
            AppMethodBeat.m2505o(100405);
            return false;
        }
    }

    /* renamed from: a */
    public void mo40705a(C24404a c24404a) {
        AppMethodBeat.m2504i(100406);
        if (!(this.f4805Y == null || c24404a == null)) {
            this.f4805Y.add(c24404a);
        }
        AppMethodBeat.m2505o(100406);
    }

    /* renamed from: k */
    public void mo40722k() {
        AppMethodBeat.m2504i(100407);
        if (this.f4805Y != null) {
            for (C24404a a : this.f4805Y) {
                a.mo40693a(this);
            }
        }
        AppMethodBeat.m2505o(100407);
    }

    /* renamed from: l */
    public void mo40723l() {
        AppMethodBeat.m2504i(100408);
        if (this.f4805Y != null) {
            for (C24404a b : this.f4805Y) {
                b.mo40695b(this);
            }
        }
        AppMethodBeat.m2505o(100408);
    }
}
