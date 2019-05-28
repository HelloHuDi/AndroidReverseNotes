package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44535lg.C24403a;
import com.tencent.tencentmap.mapsdk.p666a.C24339ch;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj;
import com.tencent.tencentmap.mapsdk.p666a.C31000cw;
import com.tencent.tencentmap.mapsdk.p666a.C36456ac;
import com.tencent.tencentmap.mapsdk.p666a.C36473cy;
import com.tencent.tencentmap.mapsdk.p666a.C5841cp;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lf */
public class C44829lf implements OnItemClickListener, C44533le, C24403a {
    /* renamed from: p */
    private static final int f17586p = Color.argb(200, 56, 56, 56);
    /* renamed from: a */
    public boolean f17587a = false;
    /* renamed from: b */
    private RelativeLayout f17588b;
    /* renamed from: c */
    private C44535lg f17589c;
    /* renamed from: d */
    private TextView f17590d;
    /* renamed from: e */
    private View f17591e;
    /* renamed from: f */
    private View f17592f;
    /* renamed from: g */
    private View f17593g;
    /* renamed from: h */
    private Bitmap f17594h;
    /* renamed from: i */
    private Bitmap f17595i;
    /* renamed from: j */
    private float f17596j = 1.0f;
    /* renamed from: k */
    private final int f17597k = 45;
    /* renamed from: l */
    private final int f17598l = 4;
    /* renamed from: m */
    private final int f17599m = 90;
    /* renamed from: n */
    private final int f17600n = 10;
    /* renamed from: o */
    private int f17601o = 0;
    /* renamed from: q */
    private C44534a f17602q;
    /* renamed from: r */
    private Context f17603r;
    /* renamed from: s */
    private C36456ac f17604s;
    /* renamed from: t */
    private int f17605t = -1;
    /* renamed from: u */
    private int f17606u = 0;
    /* renamed from: v */
    private C31000cw f17607v;
    /* renamed from: w */
    private String f17608w;
    /* renamed from: x */
    private boolean f17609x = false;
    /* renamed from: y */
    private C24339ch f17610y;
    /* renamed from: z */
    private C24402a f17611z = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lf$a */
    class C44534a extends BaseAdapter {
        /* renamed from: b */
        private Context f17481b;
        /* renamed from: c */
        private List<C36473cy> f17482c;

        /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lf$a$a */
        public class C24402a {
            /* renamed from: a */
            public TextView f4775a;
            /* renamed from: b */
            public ImageView f4776b;

            public C24402a(TextView textView, ImageView imageView) {
                this.f4775a = textView;
                this.f4776b = imageView;
            }
        }

        public C44534a(Context context, List<C36473cy> list) {
            this.f17481b = context;
            this.f17482c = list;
        }

        public int getCount() {
            AppMethodBeat.m2504i(100335);
            if (this.f17482c == null) {
                AppMethodBeat.m2505o(100335);
                return 0;
            }
            int size = this.f17482c.size();
            AppMethodBeat.m2505o(100335);
            return size;
        }

        public Object getItem(int i) {
            AppMethodBeat.m2504i(100336);
            if (this.f17482c == null) {
                AppMethodBeat.m2505o(100336);
                return null;
            }
            Object obj = this.f17482c.get(i);
            AppMethodBeat.m2505o(100336);
            return obj;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(100337);
            if (this.f17482c == null || this.f17482c.size() == 0) {
                AppMethodBeat.m2505o(100337);
                return null;
            }
            TextView textView;
            ImageView imageView;
            if (view != null) {
                C24402a c24402a = (C24402a) view.getTag();
                textView = c24402a.f4775a;
                imageView = c24402a.f4776b;
            } else {
                view = new FrameLayout(this.f17481b);
                ImageView imageView2 = new ImageView(this.f17481b);
                if (C44829lf.this.f17595i != null) {
                    imageView2.setImageBitmap(C44829lf.this.f17595i);
                }
                LayoutParams layoutParams = new LayoutParams(C44829lf.this.f17589c.getMeasuredWidth(), (int) (C44829lf.this.f17596j * 45.0f));
                layoutParams.gravity = 17;
                view.addView(imageView2, layoutParams);
                textView = new TextView(this.f17481b);
                textView.setGravity(17);
                layoutParams = new LayoutParams(-2, (int) (C44829lf.this.f17596j * 45.0f));
                layoutParams.gravity = 17;
                view.addView(textView, layoutParams);
                view.setTag(new C24402a(textView, imageView2));
                imageView = imageView2;
            }
            textView.setText(((C36473cy) this.f17482c.get(i)).mo57703a());
            if (i != C44829lf.this.f17605t) {
                textView.setTextColor(C44829lf.f17586p);
                imageView.setVisibility(4);
            } else {
                textView.setTextColor(-1);
                imageView.setVisibility(0);
            }
            AppMethodBeat.m2505o(100337);
            return view;
        }

        /* renamed from: a */
        public void mo70919a(List<C36473cy> list) {
            AppMethodBeat.m2504i(100338);
            this.f17482c = list;
            notifyDataSetChanged();
            AppMethodBeat.m2505o(100338);
        }
    }

    static {
        AppMethodBeat.m2504i(100357);
        AppMethodBeat.m2505o(100357);
    }

    public C44829lf(Context context, C36456ac c36456ac) {
        AppMethodBeat.m2504i(100339);
        this.f17604s = c36456ac;
        this.f17603r = context.getApplicationContext();
        this.f17609x = true;
        AppMethodBeat.m2505o(100339);
    }

    /* renamed from: e */
    private void m82018e() {
        AppMethodBeat.m2504i(100340);
        if (this.f17588b == null) {
            this.f17602q = new C44534a(this.f17603r, new ArrayList());
            m82010a(this.f17603r);
            m82014b(this.f17603r);
            m82011a(this.f17603r, this.f17602q);
            if (!(this.f17604s.getMap() == null || this.f17604s.getMap().mo50132c() == null || this.f17604s.getMap().mo50132c().mo41910l() == null)) {
                this.f17610y = this.f17604s.getMap().mo50132c().mo41910l().mo50412E();
            }
        }
        AppMethodBeat.m2505o(100340);
    }

    /* renamed from: a */
    private void m82010a(Context context) {
        AppMethodBeat.m2504i(100341);
        this.f17596j = context.getApplicationContext().getResources().getDisplayMetrics().density;
        this.f17601o = (int) (234.0d * ((double) this.f17596j));
        AppMethodBeat.m2505o(100341);
    }

    /* renamed from: b */
    private void m82014b(Context context) {
        AppMethodBeat.m2504i(100342);
        this.f17594h = C36520ic.m60482b(context, "indoor_background.9.png");
        this.f17595i = C36520ic.m60482b(context, "item_selected_background.png");
        AppMethodBeat.m2505o(100342);
    }

    /* renamed from: b */
    public boolean mo72033b() {
        return this.f17609x;
    }

    /* renamed from: a */
    public void mo72031a(boolean z) {
        AppMethodBeat.m2504i(100343);
        if (this.f17604s == null || this.f17604s.getMap() == null) {
            AppMethodBeat.m2505o(100343);
            return;
        }
        if (z) {
            this.f17609x = true;
        } else {
            this.f17609x = false;
        }
        mo72032b(this.f17609x);
        AppMethodBeat.m2505o(100343);
    }

    /* renamed from: a */
    public void mo72030a(C31000cw c31000cw) {
        AppMethodBeat.m2504i(100344);
        if (c31000cw == null) {
            AppMethodBeat.m2505o(100344);
            return;
        }
        if (this.f17588b == null) {
            m82018e();
        }
        this.f17607v = c31000cw;
        m82012a(c31000cw.mo50192c());
        AppMethodBeat.m2505o(100344);
    }

    @TargetApi(9)
    /* renamed from: a */
    private void m82011a(Context context, C44534a c44534a) {
        AppMethodBeat.m2504i(100345);
        this.f17588b = new RelativeLayout(context);
        this.f17590d = new TextView(context);
        this.f17590d.setSingleLine(true);
        this.f17591e = new View(context);
        this.f17589c = new C44535lg(context);
        this.f17592f = new View(context);
        this.f17593g = new View(context);
        this.f17589c.setChoiceMode(1);
        this.f17589c.setAdapter(c44534a);
        this.f17589c.setOnItemClickListener(this);
        this.f17589c.setVerticalScrollBarEnabled(false);
        this.f17589c.setHorizontalScrollBarEnabled(false);
        this.f17589c.setOverScrollMode(2);
        this.f17589c.setDivider(null);
        this.f17589c.setDividerHeight(0);
        this.f17589c.setOnDataChangedListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (30.0f * this.f17596j), -2);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) (this.f17596j * 6.0f);
        this.f17590d.setId(this.f17590d.hashCode());
        this.f17590d.setText("楼层");
        this.f17590d.setTextSize(12.0f);
        this.f17590d.setGravity(17);
        this.f17590d.setTextColor(Color.argb(200, 56, 56, 56));
        this.f17588b.addView(this.f17590d, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams((int) (30.0f * this.f17596j), (int) (1.0f * this.f17596j));
        layoutParams.addRule(3, this.f17590d.getId());
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) (this.f17596j * 6.0f);
        this.f17591e.setBackgroundColor(-3355444);
        this.f17591e.setId(this.f17591e.hashCode());
        this.f17588b.addView(this.f17591e, layoutParams);
        if (this.f17594h != null) {
            byte[] ninePatchChunk = this.f17594h.getNinePatchChunk();
            C31055hn a = C31055hn.m49931a(ninePatchChunk);
            Rect rect = new Rect();
            if (a != null) {
                rect = a.f14156a;
            }
            this.f17588b.setBackgroundDrawable(new NinePatchDrawable(this.f17603r.getResources(), this.f17594h, ninePatchChunk, rect, null));
        }
        layoutParams = new RelativeLayout.LayoutParams((int) (25.0f * this.f17596j), (int) (180.0f * this.f17596j));
        layoutParams.addRule(3, this.f17591e.getId());
        layoutParams.addRule(14, -1);
        this.f17588b.addView(this.f17589c, layoutParams);
        mo40708a(this.f17604s);
        this.f17588b.measure(0, 0);
        this.f17588b.setVisibility(8);
        AppMethodBeat.m2505o(100345);
    }

    /* renamed from: a */
    public void mo40422a(int i, int i2) {
        AppMethodBeat.m2504i(100346);
        if (!this.f17609x || ((float) i2) >= ((float) this.f17601o) + (90.0f * this.f17596j)) {
            this.f17588b.setVisibility(0);
            AppMethodBeat.m2505o(100346);
            return;
        }
        this.f17588b.setVisibility(8);
        AppMethodBeat.m2505o(100346);
    }

    /* renamed from: a */
    public void mo40698a() {
        AppMethodBeat.m2504i(100347);
        if (this.f17594h != null) {
            this.f17594h.recycle();
        }
        if (this.f17595i != null) {
            this.f17595i.recycle();
        }
        AppMethodBeat.m2505o(100347);
    }

    /* renamed from: a */
    public boolean mo40708a(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(100348);
        if (viewGroup.indexOfChild(this.f17588b) < 0) {
            viewGroup.addView(this.f17588b, m82019f());
        }
        m82021h();
        AppMethodBeat.m2505o(100348);
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(100349);
        C30982aj map = this.f17604s.getMap();
        if (map == null) {
            AppMethodBeat.m2505o(100349);
            return;
        }
        if (this.f17611z != null) {
            this.f17611z.f4775a.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.f17611z.f4776b.setVisibility(4);
        }
        C24402a c24402a = (C24402a) view.getTag();
        c24402a.f4775a.setTextColor(-1);
        c24402a.f4776b.setVisibility(0);
        this.f17611z = c24402a;
        this.f17605t = i;
        this.f17587a = true;
        map.mo50133c(i);
        AppMethodBeat.m2505o(100349);
    }

    /* renamed from: f */
    private LayoutParams m82019f() {
        AppMethodBeat.m2504i(100350);
        LayoutParams layoutParams = new LayoutParams(-2, this.f17601o);
        layoutParams.gravity = 83;
        layoutParams.leftMargin = (int) (10.0f * this.f17596j);
        layoutParams.bottomMargin = (int) (90.0f * this.f17596j);
        AppMethodBeat.m2505o(100350);
        return layoutParams;
    }

    /* renamed from: b */
    public void mo72032b(boolean z) {
        AppMethodBeat.m2504i(100351);
        if (this.f17604s == null || this.f17604s.getMap() == null) {
            AppMethodBeat.m2505o(100351);
            return;
        }
        if (this.f17588b == null) {
            m82018e();
        }
        C30982aj map = this.f17604s.getMap();
        C5841cp d = map.mo50136d();
        if (this.f17609x && z && d != null && this.f17610y != null && this.f17610y.mo40470a()) {
            if (this.f17588b.getVisibility() != 0) {
                this.f17588b.setVisibility(0);
                mo72030a(map.mo50132c().mo41904c(d.f1462a));
                AppMethodBeat.m2505o(100351);
                return;
            }
        } else if (this.f17588b.getVisibility() == 0) {
            this.f17588b.setVisibility(8);
        }
        AppMethodBeat.m2505o(100351);
    }

    /* renamed from: a */
    private void m82012a(List<C36473cy> list) {
        AppMethodBeat.m2504i(100352);
        LayoutParams layoutParams;
        if (list.size() < 4 && list.size() != this.f17606u) {
            layoutParams = (LayoutParams) this.f17588b.getLayoutParams();
            layoutParams.height = (int) (((float) this.f17601o) - (((float) ((4 - list.size()) * 45)) * this.f17596j));
            this.f17604s.updateViewLayout(this.f17588b, layoutParams);
        } else if (list.size() != this.f17606u && this.f17606u < 4) {
            layoutParams = (LayoutParams) this.f17588b.getLayoutParams();
            layoutParams.height = this.f17601o;
            this.f17604s.updateViewLayout(this.f17588b, layoutParams);
        }
        this.f17606u = list.size();
        if (this.f17602q != null) {
            this.f17602q.mo70919a(list);
        }
        AppMethodBeat.m2505o(100352);
    }

    /* renamed from: g */
    private void m82020g() {
        AppMethodBeat.m2504i(100353);
        if (this.f17607v == null) {
            AppMethodBeat.m2505o(100353);
            return;
        }
        int d = this.f17607v.mo50193d();
        List c = this.f17607v.mo50192c();
        if (c == null || d >= c.size() || d == -1) {
            AppMethodBeat.m2505o(100353);
        } else if (((C36473cy) c.get(d)) == null) {
            AppMethodBeat.m2505o(100353);
        } else {
            if (this.f17608w != null && this.f17587a && this.f17608w.equals(this.f17607v.mo50190a())) {
                this.f17589c.setItemChecked(d, true);
                this.f17587a = false;
            } else {
                this.f17589c.setSelectionFromTop(d, ((int) (((double) (45.0f * this.f17596j)) + 0.5d)) * 2);
            }
            this.f17605t = d;
            this.f17608w = this.f17607v.mo50190a();
            AppMethodBeat.m2505o(100353);
        }
    }

    /* renamed from: h */
    private void m82021h() {
        AppMethodBeat.m2504i(100354);
        if (this.f17589c != null) {
            ((RelativeLayout.LayoutParams) this.f17589c.getLayoutParams()).width = m82008a(this.f17602q);
            this.f17589c.requestLayout();
        }
        AppMethodBeat.m2505o(100354);
    }

    /* renamed from: a */
    private int m82008a(Adapter adapter) {
        AppMethodBeat.m2504i(100355);
        this.f17590d.measure(0, 0);
        int measuredWidth = this.f17590d.getMeasuredWidth();
        int count = adapter.getCount();
        int i = 0;
        View view = null;
        while (i < count) {
            view = adapter.getView(i, view, this.f17589c);
            view.measure(0, 0);
            int measuredWidth2 = view.getMeasuredWidth();
            if (measuredWidth2 <= measuredWidth) {
                measuredWidth2 = measuredWidth;
            }
            i++;
            measuredWidth = measuredWidth2;
        }
        AppMethodBeat.m2505o(100355);
        return measuredWidth;
    }

    /* renamed from: c */
    public void mo40691c() {
        AppMethodBeat.m2504i(100356);
        m82021h();
        m82020g();
        AppMethodBeat.m2505o(100356);
    }
}
