package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class d extends a<q> {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    ap gGo;
    View hVf;
    n.a hVg = null;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        boolean z = true;
        AppMethodBeat.i(74800);
        final q qVar = (q) cVar;
        final u currentPageView = qVar.getCurrentPageView();
        if (currentPageView == null) {
            ab.w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74800);
            return;
        }
        ab.i("MicroMsg.JsApiShowToast", "showToast:%s", jSONObject);
        final int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1500);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("icon", "success");
        final String optString3 = jSONObject.optString("image");
        final boolean optBoolean = jSONObject.optBoolean("mask");
        if (!(bo.isNullOrNil(optString2) && bo.isNullOrNil(optString3))) {
            z = false;
        }
        if (this.hVg == null) {
            this.hVg = new n.a() {
                public final void aEM() {
                    AppMethodBeat.i(74794);
                    if (d.this.hVf == null) {
                        AppMethodBeat.o(74794);
                        return;
                    }
                    u currentPageView = qVar.getCurrentPageView();
                    if (currentPageView == null) {
                        ab.w("MicroMsg.JsApiShowToast", "current page view is null.");
                        AppMethodBeat.o(74794);
                        return;
                    }
                    FrameLayout aBk = currentPageView.aBk();
                    if (aBk == null) {
                        ab.w("MicroMsg.JsApiShowToast", "pageArea is null, err");
                        AppMethodBeat.o(74794);
                        return;
                    }
                    d.a(d.this, aBk);
                    AppMethodBeat.o(74794);
                }
            };
            g.a(qVar.getAppId(), new g.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(74795);
                    ab.i("MicroMsg.JsApiShowToast", "destory");
                    g.b(qVar.getAppId(), this);
                    if (d.this.hVf != null) {
                        d.cn(d.this.hVf);
                        d.this.hVf = null;
                    }
                    if (d.this.gGo != null) {
                        d.this.gGo.stopTimer();
                        d.this.gGo = null;
                    }
                    AppMethodBeat.o(74795);
                }
            });
        }
        final int i2 = i;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74798);
                if (d.this.hVf != null) {
                    d.cn(d.this.hVf);
                    d.this.hVf = null;
                }
                if (d.this.gGo != null) {
                    d.this.gGo.stopTimer();
                }
                if (qVar.isRunning()) {
                    if (z) {
                        d.this.hVf = LayoutInflater.from(currentPageView.mContext).inflate(R.layout.dk, null);
                    } else {
                        d.this.hVf = LayoutInflater.from(currentPageView.mContext).inflate(R.layout.dl, null);
                    }
                    FrameLayout aBk = currentPageView.aBk();
                    if (aBk == null) {
                        ab.e("MicroMsg.JsApiShowToast", "the page may be destroy");
                        d.this.hVf = null;
                        AppMethodBeat.o(74798);
                        return;
                    }
                    d.a(d.this, aBk);
                    v.Zp().y(qVar.hashCode() + "toast_name", true).j("toast_view", d.this.hVf);
                    if (optBoolean) {
                        d.this.hVf.setLayoutParams(new LayoutParams(-1, -1));
                        ((LinearLayout) d.this.hVf.findViewById(R.id.vk)).setBackgroundColor(0);
                        d.this.hVf.setOnTouchListener(new OnTouchListener() {
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                return true;
                            }
                        });
                    }
                    TextView textView = (TextView) d.this.hVf.findViewById(R.id.cx);
                    final int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(textView.getContext(), 18);
                    if (bo.isNullOrNil(optString)) {
                        textView.setVisibility(4);
                    } else {
                        textView.setLineSpacing(0.0f, 1.0f);
                        textView.setSpannableFactory(new Factory() {
                            public final Spannable newSpannable(CharSequence charSequence) {
                                AppMethodBeat.i(74797);
                                Spannable newSpannable = super.newSpannable(charSequence);
                                if (!TextUtils.isEmpty(newSpannable)) {
                                    newSpannable.setSpan(new com.tencent.mm.plugin.appbrand.widget.h.a((float) fromDPToPix), 0, newSpannable.length(), 18);
                                }
                                AppMethodBeat.o(74797);
                                return newSpannable;
                            }
                        });
                        textView.setText(optString, BufferType.SPANNABLE);
                        textView.setVisibility(0);
                        if (!z) {
                            d.this.hVf.findViewById(R.id.vl).setPadding(0, com.tencent.mm.bz.a.fromDPToPix(textView.getContext(), 27), 0, 0);
                        }
                    }
                    if (!z) {
                        ImageView imageView = (ImageView) d.this.hVf.findViewById(R.id.vn);
                        ProgressBar progressBar = (ProgressBar) d.this.hVf.findViewById(R.id.vm);
                        if (optString2.equals("loading")) {
                            imageView.setVisibility(8);
                            progressBar.setVisibility(0);
                        } else {
                            Drawable drawable;
                            imageView.setVisibility(0);
                            progressBar.setVisibility(8);
                            if (bo.isNullOrNil(optString3)) {
                                drawable = qVar.getContext().getResources().getDrawable(R.drawable.awb);
                            } else {
                                Bitmap j = s.j(qVar.getRuntime(), optString3);
                                drawable = (j == null || j.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), j);
                            }
                            if (drawable != null) {
                                imageView.setImageDrawable(drawable);
                                imageView.setScaleType(ScaleType.FIT_CENTER);
                            }
                        }
                    }
                    aBk.addView(d.this.hVf);
                    n cG = n.cG(currentPageView.aBk());
                    if (cG != null) {
                        n.a aVar = d.this.hVg;
                        if (!(aVar == null || cG.jeO.contains(aVar))) {
                            cG.jeO.add(aVar);
                        }
                    }
                    d.this.gGo = new ap(new ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(74796);
                            d.cn(d.this.hVf);
                            d.this.hVf = null;
                            v.Zp().nV(qVar.hashCode() + "toast_name");
                            ab.d("MicroMsg.JsApiShowToast", "on timer expired!");
                            n cG = n.cG(currentPageView.aBk());
                            if (cG != null) {
                                n.a aVar = d.this.hVg;
                                if (aVar != null && cG.jeO.contains(aVar)) {
                                    cG.jeO.remove(aVar);
                                }
                            }
                            AppMethodBeat.o(74796);
                            return true;
                        }
                    }, false);
                    long j2 = (long) optInt;
                    d.this.gGo.ae(j2, j2);
                    qVar.M(i2, d.this.j("ok", null));
                    AppMethodBeat.o(74798);
                    return;
                }
                ab.w("MicroMsg.JsApiShowToast", "service is not running");
                AppMethodBeat.o(74798);
            }
        });
        AppMethodBeat.o(74800);
    }

    private void ov(int i) {
        AppMethodBeat.i(74799);
        LinearLayout linearLayout = (LinearLayout) this.hVf.findViewById(R.id.vl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            ab.w("MicroMsg.JsApiShowToast", "layoutParams is null");
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(74799);
    }

    static /* synthetic */ boolean a(d dVar, FrameLayout frameLayout) {
        AppMethodBeat.i(74801);
        n cG = n.cG(frameLayout);
        if (cG == null) {
            ab.e("MicroMsg.JsApiShowToast", "appBrandInputRootFrameLayout is null : the page may be destroy");
            AppMethodBeat.o(74801);
            return true;
        }
        View currentBottomPanel = cG.getCurrentBottomPanel();
        boolean z = currentBottomPanel != null && currentBottomPanel.isShown();
        ab.i("MicroMsg.JsApiShowToast", "isKeyBoardShown:%b", Boolean.valueOf(z));
        if (z) {
            ((LinearLayout) dVar.hVf).setGravity(80);
            ab.d("MicroMsg.JsApiShowToast", "bottomMargin:%d", Integer.valueOf((frameLayout.getHeight() / 2) - frameLayout.getScrollY()));
            dVar.ov(r0);
        } else {
            ((LinearLayout) dVar.hVf).setGravity(17);
            dVar.ov(0);
        }
        AppMethodBeat.o(74801);
        return false;
    }

    static /* synthetic */ void cn(View view) {
        AppMethodBeat.i(74802);
        if (view == null) {
            AppMethodBeat.o(74802);
            return;
        }
        view.setVisibility(8);
        if (ViewGroup.class.isInstance(view.getParent())) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        AppMethodBeat.o(74802);
    }
}
