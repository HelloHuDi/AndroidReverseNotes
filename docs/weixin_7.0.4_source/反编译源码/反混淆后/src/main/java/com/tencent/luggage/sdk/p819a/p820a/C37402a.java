package com.tencent.luggage.sdk.p819a.p820a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.page.C27223e;
import com.tencent.p177mm.plugin.appbrand.page.C42643ae;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45666t;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.luggage.sdk.a.a.a */
public class C37402a extends C44709u implements C33327h {
    public final Runnable bQS = new C178242();
    public final Map<String, Object> bQT = new HashMap();

    /* renamed from: com.tencent.luggage.sdk.a.a.a$4 */
    class C88764 implements Runnable {
        C88764() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101636);
            if (C37402a.this.aJz().getWebScrollY() == 0) {
                AppMethodBeat.m2505o(101636);
                return;
            }
            C37402a.m63006a(C37402a.this);
            C37402a.this.aJz().setVerticalScrollBarEnabled(false);
            AppMethodBeat.m2505o(101636);
        }
    }

    /* renamed from: com.tencent.luggage.sdk.a.a.a$2 */
    class C178242 implements Runnable {
        C178242() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101632);
            C37402a.this.mo60250xQ();
            AppMethodBeat.m2505o(101632);
        }
    }

    /* renamed from: com.tencent.luggage.sdk.a.a.a$1 */
    class C256931 implements C42643ae {
        C256931() {
        }

        /* renamed from: xU */
        public final boolean mo43486xU() {
            AppMethodBeat.m2504i(101631);
            boolean e = C45666t.m84356e(C37402a.this);
            if (e) {
                C37402a.this.mo44925xO();
            }
            AppMethodBeat.m2505o(101631);
            return e;
        }
    }

    /* renamed from: com.tencent.luggage.sdk.a.a.a$3 */
    class C256943 implements C5681a<Bitmap, Void> {
        C256943() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(101635);
            C45124d.m82925d("MicroMsg.AppBrandPageViewLU", "getScreenshotForSharing entered");
            final View contentView = C37402a.this.aJz().getContentView();
            if (contentView == null) {
                AppMethodBeat.m2505o(101635);
            } else {
                final int width = C37402a.this.aJz().getWidth();
                final int height = C37402a.this.aJz().getHeight();
                final int webScrollX = C37402a.this.aJz().getWebScrollX();
                final int webScrollY = C37402a.this.aJz().getWebScrollY();
                if (width == 0 || height == 0) {
                    AppMethodBeat.m2505o(101635);
                } else {
                    contentView.scrollTo(0, 0);
                    final C5688b dMo = C5698f.dMo();
                    C37402a.this.aJz().mo22176H(new Runnable() {

                        /* renamed from: com.tencent.luggage.sdk.a.a.a$3$1$1 */
                        class C256961 implements C10381d {
                            C256961() {
                            }

                            /* renamed from: wU */
                            public final void mo6095wU() {
                                AppMethodBeat.m2504i(101633);
                                C37402a.this.mo53834b((C10381d) this);
                                contentView.scrollTo(webScrollX, webScrollY);
                                AppMethodBeat.m2505o(101633);
                            }
                        }

                        public final void run() {
                            int i = -1;
                            AppMethodBeat.m2504i(101634);
                            Bitmap aBo = C37402a.this.aBo();
                            int i2;
                            if (aBo == null || aBo.getWidth() <= 0 || aBo.getHeight() <= 0) {
                                String str = "MicroMsg.AppBrandPageViewLU";
                                String str2 = "getScreenshotWithoutDecor bitmap invalid width(%d), height(%d)";
                                Object[] objArr = new Object[2];
                                if (aBo == null) {
                                    i2 = -1;
                                } else {
                                    i2 = aBo.getWidth();
                                }
                                objArr[0] = Integer.valueOf(i2);
                                if (aBo != null) {
                                    i = aBo.getHeight();
                                }
                                objArr[1] = Integer.valueOf(i);
                                C45124d.m82928e(str, str2, objArr);
                                dMo.mo11581B(null);
                            } else {
                                i2 = Math.min(aBo.getWidth(), width);
                                i = Math.min(aBo.getHeight(), height);
                                dMo.mo11581B(Bitmap.createBitmap(aBo, 0, 0, i2, i));
                                aBo.recycle();
                            }
                            C37402a.this.mo53829a((C10381d) new C256961());
                            AppMethodBeat.m2505o(101634);
                        }
                    });
                    AppMethodBeat.m2505o(101635);
                }
            }
            return null;
        }
    }

    /* renamed from: com.tencent.luggage.sdk.a.a.a$5 */
    class C374035 implements C10381d {
        C374035() {
        }

        /* renamed from: wU */
        public final void mo6095wU() {
            AppMethodBeat.m2504i(101637);
            C37402a.this.mo53834b((C10381d) this);
            C37402a.m63008b(C37402a.this);
            C37402a.this.aJz().setVerticalScrollBarEnabled(true);
            AppMethodBeat.m2505o(101637);
        }
    }

    /* renamed from: com.tencent.luggage.sdk.a.a.a$a */
    static final class C37405a extends C38369p {
        static final int CTRL_INDEX = 429;
        static final String NAME = "onPageNotFound";

        private C37405a() {
        }

        /* synthetic */ C37405a(byte b) {
            this();
        }
    }

    public C37402a() {
        AppMethodBeat.m2504i(101639);
        AppMethodBeat.m2505o(101639);
    }

    /* renamed from: b */
    static /* synthetic */ void m63008b(C37402a c37402a) {
        AppMethodBeat.m2504i(101655);
        c37402a.m63010xS();
        AppMethodBeat.m2505o(101655);
    }

    public /* synthetic */ C6750i getRuntime() {
        AppMethodBeat.m2504i(101653);
        C25697b xL = mo44922xL();
        AppMethodBeat.m2505o(101653);
        return xL;
    }

    /* renamed from: xT */
    public /* synthetic */ C38492q mo44926xT() {
        AppMethodBeat.m2504i(101652);
        C45126b xM = mo44923xM();
        AppMethodBeat.m2505o(101652);
        return xM;
    }

    /* renamed from: xL */
    public C25697b mo44922xL() {
        AppMethodBeat.m2504i(101640);
        C25697b c25697b = (C25697b) super.getRuntime();
        AppMethodBeat.m2505o(101640);
        return c25697b;
    }

    /* renamed from: xM */
    public C45126b mo44923xM() {
        AppMethodBeat.m2504i(101641);
        C45126b c45126b = (C45126b) super.mo44926xT();
        AppMethodBeat.m2505o(101641);
        return c45126b;
    }

    /* renamed from: xN */
    public void mo44924xN() {
        AppMethodBeat.m2504i(101642);
        super.mo44924xN();
        C5004al.m7439af(this.bQS);
        AppMethodBeat.m2505o(101642);
    }

    /* renamed from: a */
    public void mo44895a(Context context, C6750i c6750i) {
        AppMethodBeat.m2504i(101643);
        super.mo44895a(context, c6750i);
        aJz().setOnTrimListener(new C256931());
        AppMethodBeat.m2505o(101643);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xO */
    public void mo44925xO() {
        AppMethodBeat.m2504i(101644);
        aBf().removeAll();
        AppMethodBeat.m2505o(101644);
    }

    /* renamed from: xP */
    public final boolean mo60249xP() {
        AppMethodBeat.m2504i(101645);
        boolean xP = super.mo60249xP();
        if (xP) {
            C45666t.m84355d(this);
        }
        AppMethodBeat.m2505o(101645);
        return xP;
    }

    /* renamed from: xQ */
    public final void mo60250xQ() {
        AppMethodBeat.m2504i(101647);
        aJG();
        if (mo44922xL().asV().getPageCount() < 2) {
            mo44922xL().gNR = true;
        }
        aBk().addView(new C27223e(this.mContext, mo44922xL()));
        AppMethodBeat.m2505o(101647);
    }

    /* renamed from: xR */
    public C7361c<Bitmap> mo53754xR() {
        AppMethodBeat.m2504i(101648);
        C7361c f = C5698f.dMn().mo15896f(new C256943());
        AppMethodBeat.m2505o(101648);
        return f;
    }

    /* renamed from: xS */
    private void m63010xS() {
        AppMethodBeat.m2504i(101649);
        FrameLayout frameLayout = (FrameLayout) aBk().findViewById(2131820571);
        if (frameLayout != null) {
            Bitmap bitmap;
            frameLayout.setVisibility(8);
            if (frameLayout.getBackground() instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) frameLayout.getBackground()).getBitmap();
            } else {
                bitmap = null;
            }
            frameLayout.setBackground(null);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        AppMethodBeat.m2505o(101649);
    }

    /* renamed from: a */
    public <T> T mo53736a(int i, Bundle bundle, Object... objArr) {
        AppMethodBeat.m2504i(101650);
        if (1 == i) {
            runOnUiThread(new C88764());
            mo53829a((C10381d) new C374035());
        }
        Object a = super.mo53736a(i, bundle, objArr);
        AppMethodBeat.m2505o(101650);
        return a;
    }

    /* renamed from: d */
    public final void mo60248d(final String str, final Map<String, Object> map) {
        AppMethodBeat.m2504i(101651);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(101638);
                if (map != null) {
                    C37402a.this.bQT.putAll(map);
                }
                C37402a.m63007a(C37402a.this, str);
                AppMethodBeat.m2505o(101638);
            }
        });
        AppMethodBeat.m2505o(101651);
    }

    /* renamed from: bN */
    public void mo44914bN(String str) {
        AppMethodBeat.m2504i(101646);
        if (mo44922xL().mo43488xY().mo53981b(this, C37405a.class)) {
            C45124d.m82930i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", str);
            HashMap hashMap = new HashMap();
            hashMap.put("path", C8874h.m15847bO(str));
            hashMap.put(SearchIntents.EXTRA_QUERY, C8874h.m15848bP(str));
            hashMap.put("rawPath", str);
            hashMap.put("isEntryPage", Boolean.valueOf(C5046bo.nullAsNil(str).equals(mo44922xL().atc())));
            mo6115b(new C37405a().mo34958t(hashMap));
            C5004al.m7442n(this.bQS, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(101646);
            return;
        }
        mo60250xQ();
        AppMethodBeat.m2505o(101646);
    }

    /* renamed from: a */
    static /* synthetic */ void m63006a(C37402a c37402a) {
        AppMethodBeat.m2504i(101654);
        FrameLayout frameLayout = (FrameLayout) c37402a.aBk().findViewById(2131820571);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(c37402a.mContext);
            frameLayout.setId(2131820571);
            c37402a.aBk().addView(frameLayout, -1, -1);
        }
        frameLayout.setBackground(null);
        frameLayout.setVisibility(0);
        frameLayout.bringToFront();
        try {
            C45124d.m82925d("MicroMsg.AppBrandPageViewLU", "showScreenshotCover get screenshot");
            frameLayout.setBackground(new BitmapDrawable(c37402a.mContext.getResources(), c37402a.aBo()));
            AppMethodBeat.m2505o(101654);
        } catch (OutOfMemoryError e) {
            C45124d.m82928e("MicroMsg.AppBrandPageViewLU", "showScreenshotCover oom, appId = %s, path = %s", c37402a.getAppId(), c37402a.getURL());
            c37402a.m63010xS();
            AppMethodBeat.m2505o(101654);
        }
    }
}
