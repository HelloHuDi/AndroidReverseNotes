package com.tencent.mm.plugin.appbrand.widget.i;

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
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.s.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.LinkedList;

public class a extends FrameLayout {
    public f joU = new f();
    protected LinearLayout joV;
    private ImageView joW;
    protected String joX;
    protected int joY;
    protected int joZ;
    protected LinkedList<a> jpa = new LinkedList();
    public LinkedList<Pair<d, d>> jpb = new LinkedList();
    private int jpc = 0;
    private b jpd;
    private int mHeight = 0;

    public interface b {
        void Z(int i, String str);
    }

    public static class a {
        public d jpm;
        public d jpn;
        public boolean jpo = false;
        public boolean jpp;
        public String jpq;
        public int jpr;
        public int jps;
        public String mText;
        public String mUrl;

        public a() {
            AppMethodBeat.i(87542);
            aSf();
            AppMethodBeat.o(87542);
        }

        /* Access modifiers changed, original: final */
        public final void aSf() {
            this.jpp = false;
            this.jpq = "";
            this.jpr = 0;
            this.jps = -1;
        }
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(87559);
        aVar.refreshView();
        AppMethodBeat.o(87559);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(87543);
        setLayoutParams(new LayoutParams(-1, -2));
        this.joW = new ImageView(context);
        this.joW.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.joW);
        this.joV = new LinearLayout(context);
        this.joV.setOrientation(0);
        this.joV.setGravity(16);
        this.joV.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.joV);
        AppMethodBeat.o(87543);
    }

    public void setPosition(String str) {
        this.joX = str;
    }

    public String getPosition() {
        return this.joX;
    }

    public final void g(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(87544);
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87530);
                a.a(a.this, str5, str6);
                a.b(a.this, str7, str8);
                a.a(a.this);
                AppMethodBeat.o(87530);
            }
        });
        AppMethodBeat.o(87544);
    }

    public void setClickListener(b bVar) {
        this.jpd = bVar;
    }

    public final void h(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(87545);
        a aVar = new a();
        aVar.jpm = new b(str3, new c() {
            public final void a(String str, d dVar) {
                AppMethodBeat.i(87534);
                super.a(str, dVar);
                ab.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
                AppMethodBeat.o(87534);
            }
        });
        aVar.jpn = new b(str4, new c() {
            public final void a(String str, d dVar) {
                AppMethodBeat.i(87535);
                super.a(str, dVar);
                ab.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
                AppMethodBeat.o(87535);
            }
        });
        aVar.mText = str2;
        aVar.mUrl = str;
        this.jpb.add(new Pair(aVar.jpm, aVar.jpn));
        if (aVar.mText == null && (aVar.jpm.aSh() == null || aVar.jpn.aSh() == null)) {
            ab.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            AppMethodBeat.o(87545);
            return;
        }
        View view = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.dp, this.joV, false);
        a(view, aVar);
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(87536);
                a.this.re(a.this.joV.indexOfChild(view));
                a.this.aSe();
                AppMethodBeat.o(87536);
            }
        });
        this.jpa.add(aVar);
        this.joV.addView(view);
        AppMethodBeat.o(87545);
    }

    public final void re(int i) {
        AppMethodBeat.i(87546);
        ((a) this.jpa.get(this.jpc)).jpo = false;
        if (i <= 0 || i >= this.jpa.size()) {
            this.jpc = 0;
        } else {
            this.jpc = i;
        }
        ((a) this.jpa.get(this.jpc)).jpo = true;
        refreshView();
        AppMethodBeat.o(87546);
    }

    public final void a(int i, String str, d dVar, d dVar2) {
        AppMethodBeat.i(87547);
        if (i >= this.jpa.size()) {
            AppMethodBeat.o(87547);
            return;
        }
        a aVar = (a) this.jpa.get(i);
        if (str == null) {
            str = aVar.mText;
        }
        aVar.mText = str;
        if (dVar != null) {
            if (dVar.aSh() == null) {
                dVar = aVar.jpm;
            }
            aVar.jpm = dVar;
        }
        if (dVar2 != null) {
            if (dVar2.aSh() == null) {
                dVar2 = aVar.jpn;
            }
            aVar.jpn = dVar2;
        }
        refreshView();
        AppMethodBeat.o(87547);
    }

    public final void c(int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(87548);
        int bx = w.bx(str3, 0);
        int bx2 = w.bx(str4, -1);
        for (int i2 = 0; i2 < this.jpa.size(); i2++) {
            if (i2 == i) {
                ((a) this.jpa.get(i2)).aSf();
                if ("redDot".equals(str)) {
                    ((a) this.jpa.get(i2)).jpp = true;
                } else if ("text".equals(str)) {
                    ((a) this.jpa.get(i2)).jpq = str2;
                    ((a) this.jpa.get(i2)).jpr = bx;
                    ((a) this.jpa.get(i2)).jps = bx2;
                } else if ("none".equals(str)) {
                    ((a) this.jpa.get(i2)).jpp = false;
                    ((a) this.jpa.get(i2)).jpq = "";
                }
            }
        }
        refreshView();
        AppMethodBeat.o(87548);
    }

    public final void fi(final boolean z) {
        AppMethodBeat.i(87549);
        if (al.isMainThread()) {
            String str = "translationY";
            float[] fArr = new float[2];
            fArr[0] = 0.0f;
            fArr[1] = (float) (("top".equals(this.joX) ? -1 : 1) * getHeight());
            Animator ofFloat = ObjectAnimator.ofFloat(this, str, fArr);
            ofFloat.setDuration(z ? 250 : 0);
            a(ofFloat, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87538);
                    a.this.setVisibility(8);
                    AppMethodBeat.o(87538);
                }
            });
            AppMethodBeat.o(87549);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87537);
                a.this.fi(z);
                AppMethodBeat.o(87537);
            }
        });
        AppMethodBeat.o(87549);
    }

    public final void av(boolean z) {
        AppMethodBeat.i(87550);
        String str = "translationY";
        float[] fArr = new float[2];
        fArr[0] = (float) (("top".equals(this.joX) ? -1 : 1) * getHeight());
        fArr[1] = 0.0f;
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, str, fArr);
        ofFloat.setDuration(z ? 250 : 0);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87539);
                a.this.setVisibility(0);
                a.a(a.this, ofFloat);
                AppMethodBeat.o(87539);
            }
        });
        AppMethodBeat.o(87550);
    }

    private void a(Animator animator, final Runnable runnable) {
        AppMethodBeat.i(87551);
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(87540);
                if (runnable != null) {
                    a.this.post(runnable);
                }
                AppMethodBeat.o(87540);
            }
        });
        animator.start();
        AppMethodBeat.o(87551);
    }

    private void refreshView() {
        AppMethodBeat.i(87552);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87541);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.this.jpa.size()) {
                        a.this.a(a.this.joV.getChildAt(i2), (a) a.this.jpa.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(87541);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.o(87552);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aSe() {
        AppMethodBeat.i(87553);
        if (this.jpd != null) {
            this.jpd.Z(this.jpc, ((a) this.jpa.get(this.jpc)).mUrl);
        }
        AppMethodBeat.o(87553);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, a aVar) {
        int i = 0;
        AppMethodBeat.i(87554);
        final ImageView imageView = (ImageView) view.findViewById(R.id.jb);
        TextView textView = (TextView) view.findViewById(R.id.w9);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.w_);
        TextView textView2 = (TextView) view.findViewById(R.id.ct);
        View findViewById = view.findViewById(R.id.wa);
        if ("top".equals(this.joX)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView2.setTextSize(1, 14.0f);
            if (aVar.jpo) {
                findViewById.setBackgroundColor(this.joZ);
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(4);
            }
        } else {
            if (aVar.jpm.aSh() != null) {
                if (aVar.mText != null) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 54), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = fromDPToPix(getContext(), 32);
                    imageView.getLayoutParams().height = fromDPToPix(getContext(), 28);
                    textView2.setVisibility(0);
                    textView2.setTextSize(1, 12.0f);
                } else {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 48), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = fromDPToPix(getContext(), 36);
                    imageView.getLayoutParams().height = fromDPToPix(getContext(), 36);
                    textView2.setVisibility(8);
                }
            } else if (aVar.mText != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setTextSize(1, 16.0f);
            }
            findViewById.setVisibility(4);
        }
        Drawable background = textView.getBackground();
        if (background != null) {
            background.setColorFilter(aVar.jpr, Mode.SRC_ATOP);
        }
        textView.setVisibility(aVar.jpq.isEmpty() ? 4 : 0);
        textView.setText(aVar.jpq);
        textView.setTextColor(aVar.jps);
        if (!aVar.jpp) {
            i = 4;
        }
        imageView2.setVisibility(i);
        if (!aVar.jpo || aVar.jpn.aSh() == null) {
            aVar.jpm.a(new e() {
                public final void a(Bitmap bitmap, d dVar) {
                    AppMethodBeat.i(87532);
                    super.a(bitmap, dVar);
                    a.this.b(bitmap, imageView);
                    AppMethodBeat.o(87532);
                }
            });
            aVar.jpm.aSg();
        } else {
            aVar.jpn.a(new e() {
                public final void a(Bitmap bitmap, d dVar) {
                    AppMethodBeat.i(87531);
                    super.a(bitmap, dVar);
                    a.this.b(bitmap, imageView);
                    AppMethodBeat.o(87531);
                }
            });
            aVar.jpn.aSg();
        }
        textView2.setText(aVar.mText);
        if (aVar.jpo) {
            textView2.setTextColor(this.joZ);
            AppMethodBeat.o(87554);
            return;
        }
        textView2.setTextColor(this.joY);
        AppMethodBeat.o(87554);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(final Bitmap bitmap, final ImageView imageView) {
        AppMethodBeat.i(87555);
        imageView.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87533);
                imageView.setImageBitmap(bitmap);
                AppMethodBeat.o(87533);
            }
        });
        AppMethodBeat.o(87555);
    }

    public final int EV(String str) {
        Object obj;
        AppMethodBeat.i(87556);
        LinkedList linkedList = this.jpa;
        String bO = h.bO(str);
        Iterator it = this.jpa.iterator();
        while (it.hasNext()) {
            obj = (a) it.next();
            if (h.bO(obj.mUrl).equals(bO)) {
                break;
            }
        }
        obj = null;
        int indexOf = linkedList.indexOf(obj);
        AppMethodBeat.o(87556);
        return indexOf;
    }

    private static int fromDPToPix(Context context, int i) {
        AppMethodBeat.i(138234);
        int round = Math.round(context.getResources().getDisplayMetrics().density * ((float) i));
        AppMethodBeat.o(138234);
        return round;
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        AppMethodBeat.i(87557);
        aVar.joY = w.bx(str, aVar.getResources().getColor(R.color.w4));
        aVar.joZ = w.bx(str2, aVar.getResources().getColor(R.color.a61));
        AppMethodBeat.o(87557);
    }

    static /* synthetic */ void b(a aVar, String str, String str2) {
        int i;
        AppMethodBeat.i(87558);
        float fromDPToPix = (float) fromDPToPix(aVar.getContext(), 1);
        if (fromDPToPix / 2.0f > 1.0f) {
            i = (int) (fromDPToPix / 2.0f);
        } else {
            i = 1;
        }
        new GradientDrawable().setColor(w.bx(str, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        if ("white".equals(str2)) {
            gradientDrawable.setStroke(i, Color.parseColor("#33ffffff"));
        } else {
            gradientDrawable.setStroke(i, Color.parseColor("#33000000"));
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{r2, gradientDrawable});
        if ("top".equals(aVar.joX)) {
            layerDrawable.setLayerInset(1, -i, -i, -i, -i);
        } else {
            layerDrawable.setLayerInset(1, -i, 0, -i, -i);
        }
        aVar.joW.setImageDrawable(layerDrawable);
        AppMethodBeat.o(87558);
    }
}
