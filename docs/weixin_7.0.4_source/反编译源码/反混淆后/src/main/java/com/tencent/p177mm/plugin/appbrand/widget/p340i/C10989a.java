package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a */
public class C10989a extends FrameLayout {
    public C33614f joU = new C33614f();
    protected LinearLayout joV;
    private ImageView joW;
    protected String joX;
    protected int joY;
    protected int joZ;
    protected LinkedList<C10996a> jpa = new LinkedList();
    public LinkedList<Pair<C33612d, C33612d>> jpb = new LinkedList();
    private int jpc = 0;
    private C10988b jpd;
    private int mHeight = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$5 */
    class C109875 extends C33611c {
        C109875() {
        }

        /* renamed from: a */
        public final void mo6339a(String str, C33612d c33612d) {
            AppMethodBeat.m2504i(87534);
            super.mo6339a(str, c33612d);
            C4990ab.m7412e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(87534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$b */
    public interface C10988b {
        /* renamed from: Z */
        void mo22637Z(int i, String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$12 */
    class C1099112 implements Runnable {
        C1099112() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87541);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < C10989a.this.jpa.size()) {
                    C10989a.this.mo22640a(C10989a.this.joV.getChildAt(i2), (C10996a) C10989a.this.jpa.get(i2));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(87541);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$7 */
    class C109927 implements OnClickListener {
        C109927() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(87536);
            C10989a.this.mo22649re(C10989a.this.joV.indexOfChild(view));
            C10989a.this.aSe();
            AppMethodBeat.m2505o(87536);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$6 */
    class C109946 extends C33611c {
        C109946() {
        }

        /* renamed from: a */
        public final void mo6339a(String str, C33612d c33612d) {
            AppMethodBeat.m2504i(87535);
            super.mo6339a(str, c33612d);
            C4990ab.m7412e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(87535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$a */
    public static class C10996a {
        public C33612d jpm;
        public C33612d jpn;
        public boolean jpo = false;
        public boolean jpp;
        public String jpq;
        public int jpr;
        public int jps;
        public String mText;
        public String mUrl;

        public C10996a() {
            AppMethodBeat.m2504i(87542);
            aSf();
            AppMethodBeat.m2505o(87542);
        }

        /* Access modifiers changed, original: final */
        public final void aSf() {
            this.jpp = false;
            this.jpq = "";
            this.jpr = 0;
            this.jps = -1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.a$9 */
    class C109979 implements Runnable {
        C109979() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87538);
            C10989a.this.setVisibility(8);
            AppMethodBeat.m2505o(87538);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m18732a(C10989a c10989a) {
        AppMethodBeat.m2504i(87559);
        c10989a.refreshView();
        AppMethodBeat.m2505o(87559);
    }

    public C10989a(Context context) {
        super(context);
        AppMethodBeat.m2504i(87543);
        setLayoutParams(new LayoutParams(-1, -2));
        this.joW = new ImageView(context);
        this.joW.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.joW);
        this.joV = new LinearLayout(context);
        this.joV.setOrientation(0);
        this.joV.setGravity(16);
        this.joV.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.joV);
        AppMethodBeat.m2505o(87543);
    }

    public void setPosition(String str) {
        this.joX = str;
    }

    public String getPosition() {
        return this.joX;
    }

    /* renamed from: g */
    public final void mo22646g(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(87544);
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87530);
                C10989a.m18734a(C10989a.this, str5, str6);
                C10989a.m18735b(C10989a.this, str7, str8);
                C10989a.m18732a(C10989a.this);
                AppMethodBeat.m2505o(87530);
            }
        });
        AppMethodBeat.m2505o(87544);
    }

    public void setClickListener(C10988b c10988b) {
        this.jpd = c10988b;
    }

    /* renamed from: h */
    public final void mo22648h(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(87545);
        C10996a c10996a = new C10996a();
        c10996a.jpm = new C36737b(str3, new C109875());
        c10996a.jpn = new C36737b(str4, new C109946());
        c10996a.mText = str2;
        c10996a.mUrl = str;
        this.jpb.add(new Pair(c10996a.jpm, c10996a.jpn));
        if (c10996a.mText == null && (c10996a.jpm.aSh() == null || c10996a.jpn.aSh() == null)) {
            C4990ab.m7412e("MicroMsg.AppBrandPageTabBar", "illegal data");
            AppMethodBeat.m2505o(87545);
            return;
        }
        View view = (ViewGroup) LayoutInflater.from(getContext()).inflate(2130968739, this.joV, false);
        mo22640a(view, c10996a);
        view.setOnClickListener(new C109927());
        this.jpa.add(c10996a);
        this.joV.addView(view);
        AppMethodBeat.m2505o(87545);
    }

    /* renamed from: re */
    public final void mo22649re(int i) {
        AppMethodBeat.m2504i(87546);
        ((C10996a) this.jpa.get(this.jpc)).jpo = false;
        if (i <= 0 || i >= this.jpa.size()) {
            this.jpc = 0;
        } else {
            this.jpc = i;
        }
        ((C10996a) this.jpa.get(this.jpc)).jpo = true;
        refreshView();
        AppMethodBeat.m2505o(87546);
    }

    /* renamed from: a */
    public final void mo22639a(int i, String str, C33612d c33612d, C33612d c33612d2) {
        AppMethodBeat.m2504i(87547);
        if (i >= this.jpa.size()) {
            AppMethodBeat.m2505o(87547);
            return;
        }
        C10996a c10996a = (C10996a) this.jpa.get(i);
        if (str == null) {
            str = c10996a.mText;
        }
        c10996a.mText = str;
        if (c33612d != null) {
            if (c33612d.aSh() == null) {
                c33612d = c10996a.jpm;
            }
            c10996a.jpm = c33612d;
        }
        if (c33612d2 != null) {
            if (c33612d2.aSh() == null) {
                c33612d2 = c10996a.jpn;
            }
            c10996a.jpn = c33612d2;
        }
        refreshView();
        AppMethodBeat.m2505o(87547);
    }

    /* renamed from: c */
    public final void mo22644c(int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(87548);
        int bx = C10732w.m18401bx(str3, 0);
        int bx2 = C10732w.m18401bx(str4, -1);
        for (int i2 = 0; i2 < this.jpa.size(); i2++) {
            if (i2 == i) {
                ((C10996a) this.jpa.get(i2)).aSf();
                if ("redDot".equals(str)) {
                    ((C10996a) this.jpa.get(i2)).jpp = true;
                } else if ("text".equals(str)) {
                    ((C10996a) this.jpa.get(i2)).jpq = str2;
                    ((C10996a) this.jpa.get(i2)).jpr = bx;
                    ((C10996a) this.jpa.get(i2)).jps = bx2;
                } else if ("none".equals(str)) {
                    ((C10996a) this.jpa.get(i2)).jpp = false;
                    ((C10996a) this.jpa.get(i2)).jpq = "";
                }
            }
        }
        refreshView();
        AppMethodBeat.m2505o(87548);
    }

    /* renamed from: fi */
    public final void mo22645fi(final boolean z) {
        AppMethodBeat.m2504i(87549);
        if (C5004al.isMainThread()) {
            String str = "translationY";
            float[] fArr = new float[2];
            fArr[0] = 0.0f;
            fArr[1] = (float) (("top".equals(this.joX) ? -1 : 1) * getHeight());
            Animator ofFloat = ObjectAnimator.ofFloat(this, str, fArr);
            ofFloat.setDuration(z ? 250 : 0);
            m18731a(ofFloat, new C109979());
            AppMethodBeat.m2505o(87549);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87537);
                C10989a.this.mo22645fi(z);
                AppMethodBeat.m2505o(87537);
            }
        });
        AppMethodBeat.m2505o(87549);
    }

    /* renamed from: av */
    public final void mo22642av(boolean z) {
        AppMethodBeat.m2504i(87550);
        String str = "translationY";
        float[] fArr = new float[2];
        fArr[0] = (float) (("top".equals(this.joX) ? -1 : 1) * getHeight());
        fArr[1] = 0.0f;
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, str, fArr);
        ofFloat.setDuration(z ? 250 : 0);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87539);
                C10989a.this.setVisibility(0);
                C10989a.m18733a(C10989a.this, ofFloat);
                AppMethodBeat.m2505o(87539);
            }
        });
        AppMethodBeat.m2505o(87550);
    }

    /* renamed from: a */
    private void m18731a(Animator animator, final Runnable runnable) {
        AppMethodBeat.m2504i(87551);
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(87540);
                if (runnable != null) {
                    C10989a.this.post(runnable);
                }
                AppMethodBeat.m2505o(87540);
            }
        });
        animator.start();
        AppMethodBeat.m2505o(87551);
    }

    private void refreshView() {
        AppMethodBeat.m2504i(87552);
        post(new C1099112());
        AppMethodBeat.m2505o(87552);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aSe() {
        AppMethodBeat.m2504i(87553);
        if (this.jpd != null) {
            this.jpd.mo22637Z(this.jpc, ((C10996a) this.jpa.get(this.jpc)).mUrl);
        }
        AppMethodBeat.m2505o(87553);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo22640a(View view, C10996a c10996a) {
        int i = 0;
        AppMethodBeat.m2504i(87554);
        final ImageView imageView = (ImageView) view.findViewById(2131820915);
        TextView textView = (TextView) view.findViewById(2131821393);
        ImageView imageView2 = (ImageView) view.findViewById(2131821394);
        TextView textView2 = (TextView) view.findViewById(2131820674);
        View findViewById = view.findViewById(2131821395);
        if ("top".equals(this.joX)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, C10989a.fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView2.setTextSize(1, 14.0f);
            if (c10996a.jpo) {
                findViewById.setBackgroundColor(this.joZ);
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(4);
            }
        } else {
            if (c10996a.jpm.aSh() != null) {
                if (c10996a.mText != null) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, C10989a.fromDPToPix(getContext(), 54), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = C10989a.fromDPToPix(getContext(), 32);
                    imageView.getLayoutParams().height = C10989a.fromDPToPix(getContext(), 28);
                    textView2.setVisibility(0);
                    textView2.setTextSize(1, 12.0f);
                } else {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, C10989a.fromDPToPix(getContext(), 48), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = C10989a.fromDPToPix(getContext(), 36);
                    imageView.getLayoutParams().height = C10989a.fromDPToPix(getContext(), 36);
                    textView2.setVisibility(8);
                }
            } else if (c10996a.mText != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, C10989a.fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setTextSize(1, 16.0f);
            }
            findViewById.setVisibility(4);
        }
        Drawable background = textView.getBackground();
        if (background != null) {
            background.setColorFilter(c10996a.jpr, Mode.SRC_ATOP);
        }
        textView.setVisibility(c10996a.jpq.isEmpty() ? 4 : 0);
        textView.setText(c10996a.jpq);
        textView.setTextColor(c10996a.jps);
        if (!c10996a.jpp) {
            i = 4;
        }
        imageView2.setVisibility(i);
        if (!c10996a.jpo || c10996a.jpn.aSh() == null) {
            c10996a.jpm.mo54185a(new C38594e() {
                /* renamed from: a */
                public final void mo22659a(Bitmap bitmap, C33612d c33612d) {
                    AppMethodBeat.m2504i(87532);
                    super.mo22659a(bitmap, c33612d);
                    C10989a.this.mo22643b(bitmap, imageView);
                    AppMethodBeat.m2505o(87532);
                }
            });
            c10996a.jpm.aSg();
        } else {
            c10996a.jpn.mo54185a(new C38594e() {
                /* renamed from: a */
                public final void mo22659a(Bitmap bitmap, C33612d c33612d) {
                    AppMethodBeat.m2504i(87531);
                    super.mo22659a(bitmap, c33612d);
                    C10989a.this.mo22643b(bitmap, imageView);
                    AppMethodBeat.m2505o(87531);
                }
            });
            c10996a.jpn.aSg();
        }
        textView2.setText(c10996a.mText);
        if (c10996a.jpo) {
            textView2.setTextColor(this.joZ);
            AppMethodBeat.m2505o(87554);
            return;
        }
        textView2.setTextColor(this.joY);
        AppMethodBeat.m2505o(87554);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo22643b(final Bitmap bitmap, final ImageView imageView) {
        AppMethodBeat.m2504i(87555);
        imageView.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87533);
                imageView.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(87533);
            }
        });
        AppMethodBeat.m2505o(87555);
    }

    /* renamed from: EV */
    public final int mo22638EV(String str) {
        Object obj;
        AppMethodBeat.m2504i(87556);
        LinkedList linkedList = this.jpa;
        String bO = C8874h.m15847bO(str);
        Iterator it = this.jpa.iterator();
        while (it.hasNext()) {
            obj = (C10996a) it.next();
            if (C8874h.m15847bO(obj.mUrl).equals(bO)) {
                break;
            }
        }
        obj = null;
        int indexOf = linkedList.indexOf(obj);
        AppMethodBeat.m2505o(87556);
        return indexOf;
    }

    private static int fromDPToPix(Context context, int i) {
        AppMethodBeat.m2504i(138234);
        int round = Math.round(context.getResources().getDisplayMetrics().density * ((float) i));
        AppMethodBeat.m2505o(138234);
        return round;
    }

    /* renamed from: a */
    static /* synthetic */ void m18734a(C10989a c10989a, String str, String str2) {
        AppMethodBeat.m2504i(87557);
        c10989a.joY = C10732w.m18401bx(str, c10989a.getResources().getColor(C25738R.color.f12212w4));
        c10989a.joZ = C10732w.m18401bx(str2, c10989a.getResources().getColor(C25738R.color.a61));
        AppMethodBeat.m2505o(87557);
    }

    /* renamed from: b */
    static /* synthetic */ void m18735b(C10989a c10989a, String str, String str2) {
        int i;
        AppMethodBeat.m2504i(87558);
        float fromDPToPix = (float) C10989a.fromDPToPix(c10989a.getContext(), 1);
        if (fromDPToPix / 2.0f > 1.0f) {
            i = (int) (fromDPToPix / 2.0f);
        } else {
            i = 1;
        }
        new GradientDrawable().setColor(C10732w.m18401bx(str, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        if ("white".equals(str2)) {
            gradientDrawable.setStroke(i, Color.parseColor("#33ffffff"));
        } else {
            gradientDrawable.setStroke(i, Color.parseColor("#33000000"));
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{r2, gradientDrawable});
        if ("top".equals(c10989a.joX)) {
            layerDrawable.setLayerInset(1, -i, -i, -i, -i);
        } else {
            layerDrawable.setLayerInset(1, -i, 0, -i, -i);
        }
        c10989a.joW.setImageDrawable(layerDrawable);
        AppMethodBeat.m2505o(87558);
    }
}
