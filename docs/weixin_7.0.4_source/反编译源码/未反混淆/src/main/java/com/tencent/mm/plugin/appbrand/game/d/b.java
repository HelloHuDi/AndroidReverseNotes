package com.tencent.mm.plugin.appbrand.game.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends WebView {
    private MBRuntime bSv;
    boolean hrA = false;
    public View hrB;
    private LinkedList<String> hrC;
    private boolean hrD = false;

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(130169);
        bVar.Av(str);
        AppMethodBeat.o(130169);
    }

    static /* synthetic */ int c(b bVar) {
        AppMethodBeat.i(130170);
        int displayHeight = bVar.getDisplayHeight();
        AppMethodBeat.o(130170);
        return displayHeight;
    }

    public b(MBRuntime mBRuntime, Context context) {
        super(context);
        AppMethodBeat.i(130165);
        this.bSv = mBRuntime;
        getSettings().setJavaScriptEnabled(true);
        this.hrB = new a(getContext());
        this.hrB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(130155);
                b bVar = b.this;
                ValueAnimator ofFloat;
                if (bVar.hrA) {
                    ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                    ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                        int height = b.c(b.this);

                        {
                            AppMethodBeat.i(130161);
                            AppMethodBeat.o(130161);
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(130162);
                            if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 1.0f) {
                                b.this.setVisibility(8);
                                AppMethodBeat.o(130162);
                                return;
                            }
                            b.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
                            b.this.requestLayout();
                            AppMethodBeat.o(130162);
                        }
                    });
                    ofFloat.start();
                    bVar.hrA = false;
                    AppMethodBeat.o(130155);
                    return;
                }
                bVar.setTranslationY((float) bVar.getDisplayHeight());
                bVar.setVisibility(0);
                ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                    int height = b.c(b.this);

                    {
                        AppMethodBeat.i(130163);
                        AppMethodBeat.o(130163);
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(130164);
                        b.this.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
                        b.this.requestLayout();
                        AppMethodBeat.o(130164);
                    }
                });
                ofFloat.start();
                bVar.hrA = true;
                AppMethodBeat.o(130155);
            }
        });
        setWebViewClient(new s() {
            public final o c(WebView webView, String str) {
                AppMethodBeat.i(130156);
                o Aw = AnonymousClass2.Aw(str);
                AppMethodBeat.o(130156);
                return Aw;
            }

            public final o a(WebView webView, n nVar) {
                AppMethodBeat.i(130157);
                o Aw = AnonymousClass2.Aw(nVar.getUrl().toString());
                AppMethodBeat.o(130157);
                return Aw;
            }

            public final o a(WebView webView, n nVar, Bundle bundle) {
                AppMethodBeat.i(130158);
                o Aw = AnonymousClass2.Aw(nVar.getUrl().toString());
                AppMethodBeat.o(130158);
                return Aw;
            }

            private static o Aw(String str) {
                AppMethodBeat.i(130159);
                if ("wagame://WAGameVConsole.html".equals(str)) {
                    o xv = WxaCommLibRuntimeReader.xv("WAGameVConsole.html");
                    AppMethodBeat.o(130159);
                    return xv;
                }
                AppMethodBeat.o(130159);
                return null;
            }

            public final void b(WebView webView, String str) {
                AppMethodBeat.i(130160);
                b.this.hrD = true;
                if (!(b.this.hrC == null || b.this.hrC.isEmpty())) {
                    Iterator it = b.this.hrC.iterator();
                    while (it.hasNext()) {
                        b.a(b.this, (String) it.next());
                    }
                }
                AppMethodBeat.o(130160);
            }
        });
        loadUrl("wagame://WAGameVConsole.html");
        setTranslationY(100000.0f);
        setVisibility(8);
        AppMethodBeat.o(130165);
    }

    /* Access modifiers changed, original: final */
    public final int getDisplayHeight() {
        AppMethodBeat.i(130166);
        int systemDisplayHeight = ((int) (((float) this.bSv.getSystemDisplayHeight()) * getContext().getResources().getDisplayMetrics().density)) + 1;
        AppMethodBeat.o(130166);
        return systemDisplayHeight;
    }

    public final void log(String str) {
        AppMethodBeat.i(130167);
        if (this.hrD) {
            Av(str);
            AppMethodBeat.o(130167);
            return;
        }
        if (this.hrC == null) {
            this.hrC = new LinkedList();
        }
        this.hrC.add(str);
        AppMethodBeat.o(130167);
    }

    private void Av(String str) {
        AppMethodBeat.i(130168);
        String Ej = l.Ej(str);
        if (VERSION.SDK_INT >= 19) {
            evaluateJavascript("console._log('" + Ej + "')", null);
            AppMethodBeat.o(130168);
            return;
        }
        loadUrl("javascript:console._log('" + Ej + "')");
        AppMethodBeat.o(130168);
    }
}
