package com.tencent.tencentmap.mapsdk.maps.a;

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
import com.tencent.tencentmap.mapsdk.a.ac;
import com.tencent.tencentmap.mapsdk.a.aj;
import com.tencent.tencentmap.mapsdk.a.ch;
import com.tencent.tencentmap.mapsdk.a.cp;
import com.tencent.tencentmap.mapsdk.a.cw;
import com.tencent.tencentmap.mapsdk.a.cy;
import java.util.ArrayList;
import java.util.List;

public class lf implements OnItemClickListener, le, com.tencent.tencentmap.mapsdk.maps.a.lg.a {
    private static final int p = Color.argb(200, 56, 56, 56);
    public boolean a = false;
    private RelativeLayout b;
    private lg c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private Bitmap h;
    private Bitmap i;
    private float j = 1.0f;
    private final int k = 45;
    private final int l = 4;
    private final int m = 90;
    private final int n = 10;
    private int o = 0;
    private a q;
    private Context r;
    private ac s;
    private int t = -1;
    private int u = 0;
    private cw v;
    private String w;
    private boolean x = false;
    private ch y;
    private a z = null;

    class a extends BaseAdapter {
        private Context b;
        private List<cy> c;

        public class a {
            public TextView a;
            public ImageView b;

            public a(TextView textView, ImageView imageView) {
                this.a = textView;
                this.b = imageView;
            }
        }

        public a(Context context, List<cy> list) {
            this.b = context;
            this.c = list;
        }

        public int getCount() {
            AppMethodBeat.i(100335);
            if (this.c == null) {
                AppMethodBeat.o(100335);
                return 0;
            }
            int size = this.c.size();
            AppMethodBeat.o(100335);
            return size;
        }

        public Object getItem(int i) {
            AppMethodBeat.i(100336);
            if (this.c == null) {
                AppMethodBeat.o(100336);
                return null;
            }
            Object obj = this.c.get(i);
            AppMethodBeat.o(100336);
            return obj;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(100337);
            if (this.c == null || this.c.size() == 0) {
                AppMethodBeat.o(100337);
                return null;
            }
            TextView textView;
            ImageView imageView;
            if (view != null) {
                a aVar = (a) view.getTag();
                textView = aVar.a;
                imageView = aVar.b;
            } else {
                view = new FrameLayout(this.b);
                ImageView imageView2 = new ImageView(this.b);
                if (lf.this.i != null) {
                    imageView2.setImageBitmap(lf.this.i);
                }
                LayoutParams layoutParams = new LayoutParams(lf.this.c.getMeasuredWidth(), (int) (lf.this.j * 45.0f));
                layoutParams.gravity = 17;
                view.addView(imageView2, layoutParams);
                textView = new TextView(this.b);
                textView.setGravity(17);
                layoutParams = new LayoutParams(-2, (int) (lf.this.j * 45.0f));
                layoutParams.gravity = 17;
                view.addView(textView, layoutParams);
                view.setTag(new a(textView, imageView2));
                imageView = imageView2;
            }
            textView.setText(((cy) this.c.get(i)).a());
            if (i != lf.this.t) {
                textView.setTextColor(lf.p);
                imageView.setVisibility(4);
            } else {
                textView.setTextColor(-1);
                imageView.setVisibility(0);
            }
            AppMethodBeat.o(100337);
            return view;
        }

        public void a(List<cy> list) {
            AppMethodBeat.i(100338);
            this.c = list;
            notifyDataSetChanged();
            AppMethodBeat.o(100338);
        }
    }

    static {
        AppMethodBeat.i(100357);
        AppMethodBeat.o(100357);
    }

    public lf(Context context, ac acVar) {
        AppMethodBeat.i(100339);
        this.s = acVar;
        this.r = context.getApplicationContext();
        this.x = true;
        AppMethodBeat.o(100339);
    }

    private void e() {
        AppMethodBeat.i(100340);
        if (this.b == null) {
            this.q = new a(this.r, new ArrayList());
            a(this.r);
            b(this.r);
            a(this.r, this.q);
            if (!(this.s.getMap() == null || this.s.getMap().c() == null || this.s.getMap().c().l() == null)) {
                this.y = this.s.getMap().c().l().E();
            }
        }
        AppMethodBeat.o(100340);
    }

    private void a(Context context) {
        AppMethodBeat.i(100341);
        this.j = context.getApplicationContext().getResources().getDisplayMetrics().density;
        this.o = (int) (234.0d * ((double) this.j));
        AppMethodBeat.o(100341);
    }

    private void b(Context context) {
        AppMethodBeat.i(100342);
        this.h = ic.b(context, "indoor_background.9.png");
        this.i = ic.b(context, "item_selected_background.png");
        AppMethodBeat.o(100342);
    }

    public boolean b() {
        return this.x;
    }

    public void a(boolean z) {
        AppMethodBeat.i(100343);
        if (this.s == null || this.s.getMap() == null) {
            AppMethodBeat.o(100343);
            return;
        }
        if (z) {
            this.x = true;
        } else {
            this.x = false;
        }
        b(this.x);
        AppMethodBeat.o(100343);
    }

    public void a(cw cwVar) {
        AppMethodBeat.i(100344);
        if (cwVar == null) {
            AppMethodBeat.o(100344);
            return;
        }
        if (this.b == null) {
            e();
        }
        this.v = cwVar;
        a(cwVar.c());
        AppMethodBeat.o(100344);
    }

    @TargetApi(9)
    private void a(Context context, a aVar) {
        AppMethodBeat.i(100345);
        this.b = new RelativeLayout(context);
        this.d = new TextView(context);
        this.d.setSingleLine(true);
        this.e = new View(context);
        this.c = new lg(context);
        this.f = new View(context);
        this.g = new View(context);
        this.c.setChoiceMode(1);
        this.c.setAdapter(aVar);
        this.c.setOnItemClickListener(this);
        this.c.setVerticalScrollBarEnabled(false);
        this.c.setHorizontalScrollBarEnabled(false);
        this.c.setOverScrollMode(2);
        this.c.setDivider(null);
        this.c.setDividerHeight(0);
        this.c.setOnDataChangedListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (30.0f * this.j), -2);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) (this.j * 6.0f);
        this.d.setId(this.d.hashCode());
        this.d.setText("楼层");
        this.d.setTextSize(12.0f);
        this.d.setGravity(17);
        this.d.setTextColor(Color.argb(200, 56, 56, 56));
        this.b.addView(this.d, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams((int) (30.0f * this.j), (int) (1.0f * this.j));
        layoutParams.addRule(3, this.d.getId());
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = (int) (this.j * 6.0f);
        this.e.setBackgroundColor(-3355444);
        this.e.setId(this.e.hashCode());
        this.b.addView(this.e, layoutParams);
        if (this.h != null) {
            byte[] ninePatchChunk = this.h.getNinePatchChunk();
            hn a = hn.a(ninePatchChunk);
            Rect rect = new Rect();
            if (a != null) {
                rect = a.a;
            }
            this.b.setBackgroundDrawable(new NinePatchDrawable(this.r.getResources(), this.h, ninePatchChunk, rect, null));
        }
        layoutParams = new RelativeLayout.LayoutParams((int) (25.0f * this.j), (int) (180.0f * this.j));
        layoutParams.addRule(3, this.e.getId());
        layoutParams.addRule(14, -1);
        this.b.addView(this.c, layoutParams);
        a(this.s);
        this.b.measure(0, 0);
        this.b.setVisibility(8);
        AppMethodBeat.o(100345);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(100346);
        if (!this.x || ((float) i2) >= ((float) this.o) + (90.0f * this.j)) {
            this.b.setVisibility(0);
            AppMethodBeat.o(100346);
            return;
        }
        this.b.setVisibility(8);
        AppMethodBeat.o(100346);
    }

    public void a() {
        AppMethodBeat.i(100347);
        if (this.h != null) {
            this.h.recycle();
        }
        if (this.i != null) {
            this.i.recycle();
        }
        AppMethodBeat.o(100347);
    }

    public boolean a(ViewGroup viewGroup) {
        AppMethodBeat.i(100348);
        if (viewGroup.indexOfChild(this.b) < 0) {
            viewGroup.addView(this.b, f());
        }
        h();
        AppMethodBeat.o(100348);
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(100349);
        aj map = this.s.getMap();
        if (map == null) {
            AppMethodBeat.o(100349);
            return;
        }
        if (this.z != null) {
            this.z.a.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.z.b.setVisibility(4);
        }
        a aVar = (a) view.getTag();
        aVar.a.setTextColor(-1);
        aVar.b.setVisibility(0);
        this.z = aVar;
        this.t = i;
        this.a = true;
        map.c(i);
        AppMethodBeat.o(100349);
    }

    private LayoutParams f() {
        AppMethodBeat.i(100350);
        LayoutParams layoutParams = new LayoutParams(-2, this.o);
        layoutParams.gravity = 83;
        layoutParams.leftMargin = (int) (10.0f * this.j);
        layoutParams.bottomMargin = (int) (90.0f * this.j);
        AppMethodBeat.o(100350);
        return layoutParams;
    }

    public void b(boolean z) {
        AppMethodBeat.i(100351);
        if (this.s == null || this.s.getMap() == null) {
            AppMethodBeat.o(100351);
            return;
        }
        if (this.b == null) {
            e();
        }
        aj map = this.s.getMap();
        cp d = map.d();
        if (this.x && z && d != null && this.y != null && this.y.a()) {
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
                a(map.c().c(d.a));
                AppMethodBeat.o(100351);
                return;
            }
        } else if (this.b.getVisibility() == 0) {
            this.b.setVisibility(8);
        }
        AppMethodBeat.o(100351);
    }

    private void a(List<cy> list) {
        AppMethodBeat.i(100352);
        LayoutParams layoutParams;
        if (list.size() < 4 && list.size() != this.u) {
            layoutParams = (LayoutParams) this.b.getLayoutParams();
            layoutParams.height = (int) (((float) this.o) - (((float) ((4 - list.size()) * 45)) * this.j));
            this.s.updateViewLayout(this.b, layoutParams);
        } else if (list.size() != this.u && this.u < 4) {
            layoutParams = (LayoutParams) this.b.getLayoutParams();
            layoutParams.height = this.o;
            this.s.updateViewLayout(this.b, layoutParams);
        }
        this.u = list.size();
        if (this.q != null) {
            this.q.a(list);
        }
        AppMethodBeat.o(100352);
    }

    private void g() {
        AppMethodBeat.i(100353);
        if (this.v == null) {
            AppMethodBeat.o(100353);
            return;
        }
        int d = this.v.d();
        List c = this.v.c();
        if (c == null || d >= c.size() || d == -1) {
            AppMethodBeat.o(100353);
        } else if (((cy) c.get(d)) == null) {
            AppMethodBeat.o(100353);
        } else {
            if (this.w != null && this.a && this.w.equals(this.v.a())) {
                this.c.setItemChecked(d, true);
                this.a = false;
            } else {
                this.c.setSelectionFromTop(d, ((int) (((double) (45.0f * this.j)) + 0.5d)) * 2);
            }
            this.t = d;
            this.w = this.v.a();
            AppMethodBeat.o(100353);
        }
    }

    private void h() {
        AppMethodBeat.i(100354);
        if (this.c != null) {
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).width = a(this.q);
            this.c.requestLayout();
        }
        AppMethodBeat.o(100354);
    }

    private int a(Adapter adapter) {
        AppMethodBeat.i(100355);
        this.d.measure(0, 0);
        int measuredWidth = this.d.getMeasuredWidth();
        int count = adapter.getCount();
        int i = 0;
        View view = null;
        while (i < count) {
            view = adapter.getView(i, view, this.c);
            view.measure(0, 0);
            int measuredWidth2 = view.getMeasuredWidth();
            if (measuredWidth2 <= measuredWidth) {
                measuredWidth2 = measuredWidth;
            }
            i++;
            measuredWidth = measuredWidth2;
        }
        AppMethodBeat.o(100355);
        return measuredWidth;
    }

    public void c() {
        AppMethodBeat.i(100356);
        h();
        g();
        AppMethodBeat.o(100356);
    }
}
