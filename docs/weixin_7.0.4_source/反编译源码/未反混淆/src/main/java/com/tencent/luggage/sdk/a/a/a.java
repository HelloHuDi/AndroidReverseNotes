package com.tencent.luggage.sdk.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.HashMap;
import java.util.Map;

public class a extends u implements h {
    public final Runnable bQS = new Runnable() {
        public final void run() {
            AppMethodBeat.i(101632);
            a.this.xQ();
            AppMethodBeat.o(101632);
        }
    };
    public final Map<String, Object> bQT = new HashMap();

    static final class a extends p {
        static final int CTRL_INDEX = 429;
        static final String NAME = "onPageNotFound";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(101639);
        AppMethodBeat.o(101639);
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(101655);
        aVar.xS();
        AppMethodBeat.o(101655);
    }

    public /* synthetic */ i getRuntime() {
        AppMethodBeat.i(101653);
        b xL = xL();
        AppMethodBeat.o(101653);
        return xL;
    }

    public /* synthetic */ q xT() {
        AppMethodBeat.i(101652);
        b xM = xM();
        AppMethodBeat.o(101652);
        return xM;
    }

    public b xL() {
        AppMethodBeat.i(101640);
        b bVar = (b) super.getRuntime();
        AppMethodBeat.o(101640);
        return bVar;
    }

    public b xM() {
        AppMethodBeat.i(101641);
        b bVar = (b) super.xT();
        AppMethodBeat.o(101641);
        return bVar;
    }

    public void xN() {
        AppMethodBeat.i(101642);
        super.xN();
        al.af(this.bQS);
        AppMethodBeat.o(101642);
    }

    public void a(Context context, i iVar) {
        AppMethodBeat.i(101643);
        super.a(context, iVar);
        aJz().setOnTrimListener(new ae() {
            public final boolean xU() {
                AppMethodBeat.i(101631);
                boolean e = t.e(a.this);
                if (e) {
                    a.this.xO();
                }
                AppMethodBeat.o(101631);
                return e;
            }
        });
        AppMethodBeat.o(101643);
    }

    /* Access modifiers changed, original: protected */
    public void xO() {
        AppMethodBeat.i(101644);
        aBf().removeAll();
        AppMethodBeat.o(101644);
    }

    public final boolean xP() {
        AppMethodBeat.i(101645);
        boolean xP = super.xP();
        if (xP) {
            t.d(this);
        }
        AppMethodBeat.o(101645);
        return xP;
    }

    public final void xQ() {
        AppMethodBeat.i(101647);
        aJG();
        if (xL().asV().getPageCount() < 2) {
            xL().gNR = true;
        }
        aBk().addView(new e(this.mContext, xL()));
        AppMethodBeat.o(101647);
    }

    public c<Bitmap> xR() {
        AppMethodBeat.i(101648);
        c f = f.dMn().f(new com.tencent.mm.vending.c.a<Bitmap, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101635);
                d.d("MicroMsg.AppBrandPageViewLU", "getScreenshotForSharing entered");
                final View contentView = a.this.aJz().getContentView();
                if (contentView == null) {
                    AppMethodBeat.o(101635);
                } else {
                    final int width = a.this.aJz().getWidth();
                    final int height = a.this.aJz().getHeight();
                    final int webScrollX = a.this.aJz().getWebScrollX();
                    final int webScrollY = a.this.aJz().getWebScrollY();
                    if (width == 0 || height == 0) {
                        AppMethodBeat.o(101635);
                    } else {
                        contentView.scrollTo(0, 0);
                        final com.tencent.mm.vending.g.b dMo = f.dMo();
                        a.this.aJz().H(new Runnable() {
                            public final void run() {
                                int i = -1;
                                AppMethodBeat.i(101634);
                                Bitmap aBo = a.this.aBo();
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
                                    d.e(str, str2, objArr);
                                    dMo.B(null);
                                } else {
                                    i2 = Math.min(aBo.getWidth(), width);
                                    i = Math.min(aBo.getHeight(), height);
                                    dMo.B(Bitmap.createBitmap(aBo, 0, 0, i2, i));
                                    aBo.recycle();
                                }
                                a.this.a((com.tencent.mm.plugin.appbrand.jsapi.f.d) new com.tencent.mm.plugin.appbrand.jsapi.f.d() {
                                    public final void wU() {
                                        AppMethodBeat.i(101633);
                                        a.this.b((com.tencent.mm.plugin.appbrand.jsapi.f.d) this);
                                        contentView.scrollTo(webScrollX, webScrollY);
                                        AppMethodBeat.o(101633);
                                    }
                                });
                                AppMethodBeat.o(101634);
                            }
                        });
                        AppMethodBeat.o(101635);
                    }
                }
                return null;
            }
        });
        AppMethodBeat.o(101648);
        return f;
    }

    private void xS() {
        AppMethodBeat.i(101649);
        FrameLayout frameLayout = (FrameLayout) aBk().findViewById(R.id.a1);
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
        AppMethodBeat.o(101649);
    }

    public <T> T a(int i, Bundle bundle, Object... objArr) {
        AppMethodBeat.i(101650);
        if (1 == i) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(101636);
                    if (a.this.aJz().getWebScrollY() == 0) {
                        AppMethodBeat.o(101636);
                        return;
                    }
                    a.a(a.this);
                    a.this.aJz().setVerticalScrollBarEnabled(false);
                    AppMethodBeat.o(101636);
                }
            });
            a((com.tencent.mm.plugin.appbrand.jsapi.f.d) new com.tencent.mm.plugin.appbrand.jsapi.f.d() {
                public final void wU() {
                    AppMethodBeat.i(101637);
                    a.this.b((com.tencent.mm.plugin.appbrand.jsapi.f.d) this);
                    a.b(a.this);
                    a.this.aJz().setVerticalScrollBarEnabled(true);
                    AppMethodBeat.o(101637);
                }
            });
        }
        Object a = super.a(i, bundle, objArr);
        AppMethodBeat.o(101650);
        return a;
    }

    public final void d(final String str, final Map<String, Object> map) {
        AppMethodBeat.i(101651);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(101638);
                if (map != null) {
                    a.this.bQT.putAll(map);
                }
                a.a(a.this, str);
                AppMethodBeat.o(101638);
            }
        });
        AppMethodBeat.o(101651);
    }

    public void bN(String str) {
        AppMethodBeat.i(101646);
        if (xL().xY().b(this, a.class)) {
            d.i("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", str);
            HashMap hashMap = new HashMap();
            hashMap.put("path", com.tencent.luggage.g.h.bO(str));
            hashMap.put(SearchIntents.EXTRA_QUERY, com.tencent.luggage.g.h.bP(str));
            hashMap.put("rawPath", str);
            hashMap.put("isEntryPage", Boolean.valueOf(bo.nullAsNil(str).equals(xL().atc())));
            b(new a().t(hashMap));
            al.n(this.bQS, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(101646);
            return;
        }
        xQ();
        AppMethodBeat.o(101646);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(101654);
        FrameLayout frameLayout = (FrameLayout) aVar.aBk().findViewById(R.id.a1);
        if (frameLayout == null) {
            frameLayout = new FrameLayout(aVar.mContext);
            frameLayout.setId(R.id.a1);
            aVar.aBk().addView(frameLayout, -1, -1);
        }
        frameLayout.setBackground(null);
        frameLayout.setVisibility(0);
        frameLayout.bringToFront();
        try {
            d.d("MicroMsg.AppBrandPageViewLU", "showScreenshotCover get screenshot");
            frameLayout.setBackground(new BitmapDrawable(aVar.mContext.getResources(), aVar.aBo()));
            AppMethodBeat.o(101654);
        } catch (OutOfMemoryError e) {
            d.e("MicroMsg.AppBrandPageViewLU", "showScreenshotCover oom, appId = %s, path = %s", aVar.getAppId(), aVar.getURL());
            aVar.xS();
            AppMethodBeat.o(101654);
        }
    }
}
