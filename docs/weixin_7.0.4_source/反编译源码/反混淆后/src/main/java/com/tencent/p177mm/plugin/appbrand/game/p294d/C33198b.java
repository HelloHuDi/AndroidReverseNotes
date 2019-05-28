package com.tencent.p177mm.plugin.appbrand.game.p294d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.p329s.C42681l;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.game.d.b */
public final class C33198b extends WebView {
    private MBRuntime bSv;
    boolean hrA = false;
    public View hrB;
    private LinkedList<String> hrC;
    private boolean hrD = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.b$2 */
    class C21612 extends C36592s {
        C21612() {
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(130156);
            C31147o Aw = C21612.m4378Aw(str);
            AppMethodBeat.m2505o(130156);
            return Aw;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(130157);
            C31147o Aw = C21612.m4378Aw(c24530n.getUrl().toString());
            AppMethodBeat.m2505o(130157);
            return Aw;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(130158);
            C31147o Aw = C21612.m4378Aw(c24530n.getUrl().toString());
            AppMethodBeat.m2505o(130158);
            return Aw;
        }

        /* renamed from: Aw */
        private static C31147o m4378Aw(String str) {
            AppMethodBeat.m2504i(130159);
            if ("wagame://WAGameVConsole.html".equals(str)) {
                C31147o xv = WxaCommLibRuntimeReader.m42570xv("WAGameVConsole.html");
                AppMethodBeat.m2505o(130159);
                return xv;
            }
            AppMethodBeat.m2505o(130159);
            return null;
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(130160);
            C33198b.this.hrD = true;
            if (!(C33198b.this.hrC == null || C33198b.this.hrC.isEmpty())) {
                Iterator it = C33198b.this.hrC.iterator();
                while (it.hasNext()) {
                    C33198b.m54299a(C33198b.this, (String) it.next());
                }
            }
            AppMethodBeat.m2505o(130160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.b$1 */
    class C102351 implements OnClickListener {
        C102351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(130155);
            C33198b c33198b = C33198b.this;
            ValueAnimator ofFloat;
            if (c33198b.hrA) {
                ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.addUpdateListener(new C331963());
                ofFloat.start();
                c33198b.hrA = false;
                AppMethodBeat.m2505o(130155);
                return;
            }
            c33198b.setTranslationY((float) c33198b.getDisplayHeight());
            c33198b.setVisibility(0);
            ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat.addUpdateListener(new C331974());
            ofFloat.start();
            c33198b.hrA = true;
            AppMethodBeat.m2505o(130155);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.b$3 */
    class C331963 implements AnimatorUpdateListener {
        int height = C33198b.m54302c(C33198b.this);

        C331963() {
            AppMethodBeat.m2504i(130161);
            AppMethodBeat.m2505o(130161);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(130162);
            if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 1.0f) {
                C33198b.this.setVisibility(8);
                AppMethodBeat.m2505o(130162);
                return;
            }
            C33198b.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
            C33198b.this.requestLayout();
            AppMethodBeat.m2505o(130162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.b$4 */
    class C331974 implements AnimatorUpdateListener {
        int height = C33198b.m54302c(C33198b.this);

        C331974() {
            AppMethodBeat.m2504i(130163);
            AppMethodBeat.m2505o(130163);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(130164);
            C33198b.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
            C33198b.this.requestLayout();
            AppMethodBeat.m2505o(130164);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m54299a(C33198b c33198b, String str) {
        AppMethodBeat.m2504i(130169);
        c33198b.m54298Av(str);
        AppMethodBeat.m2505o(130169);
    }

    /* renamed from: c */
    static /* synthetic */ int m54302c(C33198b c33198b) {
        AppMethodBeat.m2504i(130170);
        int displayHeight = c33198b.getDisplayHeight();
        AppMethodBeat.m2505o(130170);
        return displayHeight;
    }

    public C33198b(MBRuntime mBRuntime, Context context) {
        super(context);
        AppMethodBeat.m2504i(130165);
        this.bSv = mBRuntime;
        getSettings().setJavaScriptEnabled(true);
        this.hrB = new C19234a(getContext());
        this.hrB.setOnClickListener(new C102351());
        setWebViewClient(new C21612());
        loadUrl("wagame://WAGameVConsole.html");
        setTranslationY(100000.0f);
        setVisibility(8);
        AppMethodBeat.m2505o(130165);
    }

    /* Access modifiers changed, original: final */
    public final int getDisplayHeight() {
        AppMethodBeat.m2504i(130166);
        int systemDisplayHeight = ((int) (((float) this.bSv.getSystemDisplayHeight()) * getContext().getResources().getDisplayMetrics().density)) + 1;
        AppMethodBeat.m2505o(130166);
        return systemDisplayHeight;
    }

    public final void log(String str) {
        AppMethodBeat.m2504i(130167);
        if (this.hrD) {
            m54298Av(str);
            AppMethodBeat.m2505o(130167);
            return;
        }
        if (this.hrC == null) {
            this.hrC = new LinkedList();
        }
        this.hrC.add(str);
        AppMethodBeat.m2505o(130167);
    }

    /* renamed from: Av */
    private void m54298Av(String str) {
        AppMethodBeat.m2504i(130168);
        String Ej = C42681l.m75588Ej(str);
        if (VERSION.SDK_INT >= 19) {
            evaluateJavascript("console._log('" + Ej + "')", null);
            AppMethodBeat.m2505o(130168);
            return;
        }
        loadUrl("javascript:console._log('" + Ej + "')");
        AppMethodBeat.m2505o(130168);
    }
}
