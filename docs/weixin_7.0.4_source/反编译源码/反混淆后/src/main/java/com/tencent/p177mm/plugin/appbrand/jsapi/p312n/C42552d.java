package com.tencent.p177mm.plugin.appbrand.jsapi.p312n;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C38475s;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n.C11025a;
import com.tencent.p177mm.plugin.appbrand.widget.p916h.C10981a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.d */
public final class C42552d extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    C7564ap gGo;
    View hVf;
    C11025a hVg = null;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(74800);
        final C38492q c38492q = (C38492q) c2241c;
        final C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView == null) {
            C4990ab.m7420w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74800);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiShowToast", "showToast:%s", jSONObject);
        final int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1500);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("icon", "success");
        final String optString3 = jSONObject.optString("image");
        final boolean optBoolean = jSONObject.optBoolean("mask");
        if (!(C5046bo.isNullOrNil(optString2) && C5046bo.isNullOrNil(optString3))) {
            z = false;
        }
        if (this.hVg == null) {
            this.hVg = new C11025a() {
                public final void aEM() {
                    AppMethodBeat.m2504i(74794);
                    if (C42552d.this.hVf == null) {
                        AppMethodBeat.m2505o(74794);
                        return;
                    }
                    C44709u currentPageView = c38492q.getCurrentPageView();
                    if (currentPageView == null) {
                        C4990ab.m7420w("MicroMsg.JsApiShowToast", "current page view is null.");
                        AppMethodBeat.m2505o(74794);
                        return;
                    }
                    FrameLayout aBk = currentPageView.aBk();
                    if (aBk == null) {
                        C4990ab.m7420w("MicroMsg.JsApiShowToast", "pageArea is null, err");
                        AppMethodBeat.m2505o(74794);
                        return;
                    }
                    C42552d.m75344a(C42552d.this, aBk);
                    AppMethodBeat.m2505o(74794);
                }
            };
            C33183g.m54274a(c38492q.getAppId(), new C33186c() {
                public final void onDestroy() {
                    AppMethodBeat.m2504i(74795);
                    C4990ab.m7416i("MicroMsg.JsApiShowToast", "destory");
                    C33183g.m54276b(c38492q.getAppId(), this);
                    if (C42552d.this.hVf != null) {
                        C42552d.m75345cn(C42552d.this.hVf);
                        C42552d.this.hVf = null;
                    }
                    if (C42552d.this.gGo != null) {
                        C42552d.this.gGo.stopTimer();
                        C42552d.this.gGo = null;
                    }
                    AppMethodBeat.m2505o(74795);
                }
            });
        }
        final int i2 = i;
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.d$3$2 */
            class C194522 implements OnTouchListener {
                C194522() {
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.d$3$1 */
            class C194531 implements C5015a {
                C194531() {
                }

                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(74796);
                    C42552d.m75345cn(C42552d.this.hVf);
                    C42552d.this.hVf = null;
                    C37922v.m64076Zp().mo60674nV(c38492q.hashCode() + "toast_name");
                    C4990ab.m7410d("MicroMsg.JsApiShowToast", "on timer expired!");
                    C42740n cG = C42740n.m75740cG(currentPageView.aBk());
                    if (cG != null) {
                        C11025a c11025a = C42552d.this.hVg;
                        if (c11025a != null && cG.jeO.contains(c11025a)) {
                            cG.jeO.remove(c11025a);
                        }
                    }
                    AppMethodBeat.m2505o(74796);
                    return true;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(74798);
                if (C42552d.this.hVf != null) {
                    C42552d.m75345cn(C42552d.this.hVf);
                    C42552d.this.hVf = null;
                }
                if (C42552d.this.gGo != null) {
                    C42552d.this.gGo.stopTimer();
                }
                if (c38492q.isRunning()) {
                    if (z) {
                        C42552d.this.hVf = LayoutInflater.from(currentPageView.mContext).inflate(2130968734, null);
                    } else {
                        C42552d.this.hVf = LayoutInflater.from(currentPageView.mContext).inflate(2130968735, null);
                    }
                    FrameLayout aBk = currentPageView.aBk();
                    if (aBk == null) {
                        C4990ab.m7412e("MicroMsg.JsApiShowToast", "the page may be destroy");
                        C42552d.this.hVf = null;
                        AppMethodBeat.m2505o(74798);
                        return;
                    }
                    C42552d.m75344a(C42552d.this, aBk);
                    C37922v.m64076Zp().mo60676y(c38492q.hashCode() + "toast_name", true).mo53356j("toast_view", C42552d.this.hVf);
                    if (optBoolean) {
                        C42552d.this.hVf.setLayoutParams(new LayoutParams(-1, -1));
                        ((LinearLayout) C42552d.this.hVf.findViewById(2131821368)).setBackgroundColor(0);
                        C42552d.this.hVf.setOnTouchListener(new C194522());
                    }
                    TextView textView = (TextView) C42552d.this.hVf.findViewById(2131820678);
                    final int fromDPToPix = C1338a.fromDPToPix(textView.getContext(), 18);
                    if (C5046bo.isNullOrNil(optString)) {
                        textView.setVisibility(4);
                    } else {
                        textView.setLineSpacing(0.0f, 1.0f);
                        textView.setSpannableFactory(new Factory() {
                            public final Spannable newSpannable(CharSequence charSequence) {
                                AppMethodBeat.m2504i(74797);
                                Spannable newSpannable = super.newSpannable(charSequence);
                                if (!TextUtils.isEmpty(newSpannable)) {
                                    newSpannable.setSpan(new C10981a((float) fromDPToPix), 0, newSpannable.length(), 18);
                                }
                                AppMethodBeat.m2505o(74797);
                                return newSpannable;
                            }
                        });
                        textView.setText(optString, BufferType.SPANNABLE);
                        textView.setVisibility(0);
                        if (!z) {
                            C42552d.this.hVf.findViewById(2131821369).setPadding(0, C1338a.fromDPToPix(textView.getContext(), 27), 0, 0);
                        }
                    }
                    if (!z) {
                        ImageView imageView = (ImageView) C42552d.this.hVf.findViewById(2131821371);
                        ProgressBar progressBar = (ProgressBar) C42552d.this.hVf.findViewById(2131821370);
                        if (optString2.equals("loading")) {
                            imageView.setVisibility(8);
                            progressBar.setVisibility(0);
                        } else {
                            Drawable drawable;
                            imageView.setVisibility(0);
                            progressBar.setVisibility(8);
                            if (C5046bo.isNullOrNil(optString3)) {
                                drawable = c38492q.getContext().getResources().getDrawable(C25738R.drawable.awb);
                            } else {
                                Bitmap j = C38475s.m65114j(c38492q.getRuntime(), optString3);
                                drawable = (j == null || j.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), j);
                            }
                            if (drawable != null) {
                                imageView.setImageDrawable(drawable);
                                imageView.setScaleType(ScaleType.FIT_CENTER);
                            }
                        }
                    }
                    aBk.addView(C42552d.this.hVf);
                    C42740n cG = C42740n.m75740cG(currentPageView.aBk());
                    if (cG != null) {
                        C11025a c11025a = C42552d.this.hVg;
                        if (!(c11025a == null || cG.jeO.contains(c11025a))) {
                            cG.jeO.add(c11025a);
                        }
                    }
                    C42552d.this.gGo = new C7564ap(new C194531(), false);
                    long j2 = (long) optInt;
                    C42552d.this.gGo.mo16770ae(j2, j2);
                    c38492q.mo6107M(i2, C42552d.this.mo73394j("ok", null));
                    AppMethodBeat.m2505o(74798);
                    return;
                }
                C4990ab.m7420w("MicroMsg.JsApiShowToast", "service is not running");
                AppMethodBeat.m2505o(74798);
            }
        });
        AppMethodBeat.m2505o(74800);
    }

    /* renamed from: ov */
    private void m75346ov(int i) {
        AppMethodBeat.m2504i(74799);
        LinearLayout linearLayout = (LinearLayout) this.hVf.findViewById(2131821369);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            C4990ab.m7420w("MicroMsg.JsApiShowToast", "layoutParams is null");
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(74799);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m75344a(C42552d c42552d, FrameLayout frameLayout) {
        AppMethodBeat.m2504i(74801);
        C42740n cG = C42740n.m75740cG(frameLayout);
        if (cG == null) {
            C4990ab.m7412e("MicroMsg.JsApiShowToast", "appBrandInputRootFrameLayout is null : the page may be destroy");
            AppMethodBeat.m2505o(74801);
            return true;
        }
        View currentBottomPanel = cG.getCurrentBottomPanel();
        boolean z = currentBottomPanel != null && currentBottomPanel.isShown();
        C4990ab.m7417i("MicroMsg.JsApiShowToast", "isKeyBoardShown:%b", Boolean.valueOf(z));
        if (z) {
            ((LinearLayout) c42552d.hVf).setGravity(80);
            C4990ab.m7411d("MicroMsg.JsApiShowToast", "bottomMargin:%d", Integer.valueOf((frameLayout.getHeight() / 2) - frameLayout.getScrollY()));
            c42552d.m75346ov(r0);
        } else {
            ((LinearLayout) c42552d.hVf).setGravity(17);
            c42552d.m75346ov(0);
        }
        AppMethodBeat.m2505o(74801);
        return false;
    }

    /* renamed from: cn */
    static /* synthetic */ void m75345cn(View view) {
        AppMethodBeat.m2504i(74802);
        if (view == null) {
            AppMethodBeat.m2505o(74802);
            return;
        }
        view.setVisibility(8);
        if (ViewGroup.class.isInstance(view.getParent())) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        AppMethodBeat.m2505o(74802);
    }
}
