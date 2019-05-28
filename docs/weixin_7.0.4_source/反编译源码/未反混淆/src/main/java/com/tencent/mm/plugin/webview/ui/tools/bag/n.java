package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class n implements h {
    private int gOW = 0;
    private final g uyr;
    private final f uys;
    private com.tencent.mm.plugin.webview.ui.tools.bag.h.a uzE;
    private d uzF;
    private c uzG;
    private String uzH;
    private String uzI;
    private final e uzJ;
    private boolean uzK;
    private boolean uzL;
    private String uzM;

    public static final class a {
        public static Bundle af(Bundle bundle) {
            AppMethodBeat.i(8253);
            int i = bundle.getInt("key_action", -1);
            Bundle bundle2 = new Bundle();
            if (g.RN().QY()) {
                if (9 != i) {
                    ab.i("MicroMsg.WebViewUIBagHelper", "MM doBagLogic action:%d", Integer.valueOf(i));
                }
                switch (i) {
                    case 5:
                    case 6:
                        l.uzq.nV(bundle.getBoolean("key_in_webviewui_from_bag", false));
                        break;
                    case 7:
                        bundle2.putBoolean("key_has_bag", l.uzq.afZ(bundle.getString("key_bag_id")));
                        break;
                    case 8:
                        bundle2.putParcelable("key_current_bag_pos", l.uzq.dbh());
                        break;
                    default:
                        v(i, bundle);
                        break;
                }
                AppMethodBeat.o(8253);
            } else {
                ab.w("MicroMsg.WebViewUIBagHelper", "MM doBagLogic not ready");
                AppMethodBeat.o(8253);
            }
            return bundle2;
        }

        private static void v(final int i, final Bundle bundle) {
            AppMethodBeat.i(8254);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8252);
                    switch (i) {
                        case 1:
                            String string = bundle.getString("key_url");
                            String string2 = bundle.getString("key_bag_icon");
                            int i = bundle.getInt("key_scene", 0);
                            boolean z = bundle.getBoolean("key_from_bag", false);
                            Bundle bundle = bundle.getBundle("key_extras");
                            l lVar = l.uzq;
                            if (b.bF(ah.getContext())) {
                                lVar.a(string, i, string2, bundle, z);
                                lVar.nW(false);
                                AppMethodBeat.o(8252);
                                return;
                            }
                            ab.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
                            Context context = ah.getContext();
                            RequestFloatWindowPermissionDialog.a(context, context.getString(R.string.fxw), new com.tencent.mm.plugin.webview.ui.tools.bag.l.AnonymousClass1(string, i, string2, bundle, z));
                            AppMethodBeat.o(8252);
                            return;
                        case 2:
                            l.uzq.cYT();
                            AppMethodBeat.o(8252);
                            return;
                        case 3:
                            l.uzq.nU(false);
                            AppMethodBeat.o(8252);
                            return;
                        case 4:
                            l.uzq.dbg();
                            AppMethodBeat.o(8252);
                            return;
                        case 9:
                            l.uzq.bi(bundle.getFloat("key_alpha", 1.0f));
                            break;
                    }
                    AppMethodBeat.o(8252);
                }
            });
            AppMethodBeat.o(8254);
        }
    }

    static /* synthetic */ Bundle b(n nVar, int i) {
        AppMethodBeat.i(8268);
        Bundle Jz = nVar.Jz(i);
        AppMethodBeat.o(8268);
        return Jz;
    }

    public n(g gVar) {
        AppMethodBeat.i(8255);
        this.uyr = gVar;
        if (this.uyr.getIntent().getExtras() != null) {
            this.gOW = this.uyr.getIntent().getIntExtra("minimize_secene", this.gOW);
        }
        this.uys = new f() {
            public final void d(float f, int i) {
                AppMethodBeat.i(8247);
                ab.i("MicroMsg.WebViewUIBagHelper", "showBag swipedPosX:%f reportScene:%d", Float.valueOf(f), Integer.valueOf(i));
                n.a(n.this, i);
                i.a(n.this.uyr, (Point) n.b(n.this, 8).getParcelable("key_current_bag_pos"), f, n.this.uzJ);
                AppMethodBeat.o(8247);
            }

            public final void bh(float f) {
                AppMethodBeat.i(8248);
                Bundle bundle = new Bundle();
                bundle.putFloat("key_alpha", f);
                n.a(n.this, bundle);
                AppMethodBeat.o(8248);
            }
        };
        this.uzJ = new e() {
            public final void onAnimationEnd() {
                AppMethodBeat.i(8250);
                ab.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationEnd");
                n.this.uzL = true;
                n.this.uyr.mu(false);
                n.b(n.this, 1);
                AppMethodBeat.o(8250);
            }

            public final void dbb() {
                AppMethodBeat.i(8251);
                ab.i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationCancel do default");
                n.this.uzL = true;
                n.this.uyr.mu(true);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8249);
                        n.b(n.this, 1);
                        AppMethodBeat.o(8249);
                    }
                }, 500);
                AppMethodBeat.o(8251);
            }
        };
        this.uzK = this.uyr.getIntent().getBooleanExtra("from_bag", false);
        this.uzM = this.uyr.getIntent().getStringExtra("from_bag_id");
        this.uzI = this.uyr.getIntent().getStringExtra("from_bag_icon");
        if (!cXe()) {
            ab.i("MicroMsg.WebViewUIBagHelper", "not support swipeback");
            AppMethodBeat.o(8255);
        } else if (this.uzK) {
            this.uzG = new c(this.uyr, this.uys);
            AppMethodBeat.o(8255);
        } else {
            ab.i("MicroMsg.WebViewUIBagHelper", "not from bag, can swipe to bag");
            this.uzF = new d(this.uyr, this.uys);
            AppMethodBeat.o(8255);
        }
    }

    public final void a(com.tencent.mm.plugin.webview.ui.tools.bag.h.a aVar) {
        AppMethodBeat.i(8256);
        ab.i("MicroMsg.WebViewUIBagHelper", "onIPCReady");
        this.uzE = aVar;
        if (this.uzK) {
            Jz(5);
            if (cXe() && this.uzG != null) {
                c cVar = this.uzG;
                cVar.uyr.a(new com.tencent.mm.plugin.webview.ui.tools.bag.g.a() {
                    public final void bg(float f) {
                        float f2 = 1.0f;
                        AppMethodBeat.i(8150);
                        f fVar = c.this.uys;
                        if (f < 0.15f) {
                            f2 = 0.0f;
                        } else {
                            float f3 = 2.0f * f;
                            if (f3 <= 1.0f) {
                                f2 = f3;
                            }
                        }
                        fVar.bh(f2);
                        AppMethodBeat.o(8150);
                    }

                    public final void l(MotionEvent motionEvent) {
                        AppMethodBeat.i(8151);
                        c.this.uyt = motionEvent.getRawX();
                        AppMethodBeat.o(8151);
                    }

                    public final boolean ba(boolean z) {
                        AppMethodBeat.i(8152);
                        if (z) {
                            c.this.uys.bh(1.0f);
                            c.this.uys.d(c.this.uyt, 21);
                            AppMethodBeat.o(8152);
                            return true;
                        }
                        c.this.uys.bh(0.0f);
                        AppMethodBeat.o(8152);
                        return false;
                    }
                });
            }
        } else if (cXe() && this.uzF != null) {
            this.uzF.start();
            AppMethodBeat.o(8256);
            return;
        }
        AppMethodBeat.o(8256);
    }

    public final void dbc() {
        AppMethodBeat.i(8257);
        ab.i("MicroMsg.WebViewUIBagHelper", "onWebViewUIDestroy %b", Boolean.valueOf(this.uzK));
        Jz(6);
        if (this.uzF != null) {
            d dVar = this.uzF;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8156);
                    try {
                        if (d.this.uyy.getParent() != null) {
                            ((ViewGroup) d.this.uyy.getParent()).removeView(d.this.uyy);
                        }
                        AppMethodBeat.o(8156);
                    } catch (Exception e) {
                        ab.e("MicroMsg.BagIndicatorController", "removeIndicator exp:%s", e.getLocalizedMessage());
                        AppMethodBeat.o(8156);
                    }
                }
            });
            dVar.uyr.a(null);
            dVar.uyr = null;
        }
        if (this.uzK) {
            Jz(3);
        }
        AppMethodBeat.o(8257);
    }

    public final boolean Jx(int i) {
        AppMethodBeat.i(8258);
        ab.i("MicroMsg.WebViewUIBagHelper", "onWebViewClose hasBag:%b", Boolean.valueOf(dbd()));
        if (dbd()) {
            Jy(i);
            i.a(this.uyr, (Point) Jz(8).getParcelable("key_current_bag_pos"), this.uzJ);
            AppMethodBeat.o(8258);
            return true;
        }
        AppMethodBeat.o(8258);
        return false;
    }

    public final void nT(boolean z) {
        AppMethodBeat.i(8259);
        ab.i("MicroMsg.WebViewUIBagHelper", "onMenuMinimizeSelected cancelCurrentBag:%b", Boolean.valueOf(z));
        if (z) {
            Jz(4);
            if (this.uzG != null) {
                this.uzG.uyr.a(null);
            }
            Jy(18);
            com.tencent.mm.ui.widget.snackbar.b.i(this.uyr.getActivity(), this.uyr.getActivity().getString(R.string.dhn));
            if (cXe()) {
                this.uzF = new d(this.uyr, this.uys);
                this.uzF.start();
            }
            AppMethodBeat.o(8259);
            return;
        }
        Point point;
        Jy(16);
        Bundle Jz = Jz(8);
        if (Jz == null) {
            int i = b.uyk;
            point = new Point(i, i);
        } else {
            point = (Point) Jz.getParcelable("key_current_bag_pos");
        }
        i.a(this.uyr, point, this.uzJ);
        AppMethodBeat.o(8259);
    }

    public final void afX(String str) {
        this.uzI = str;
    }

    public final void afY(String str) {
        AppMethodBeat.i(8260);
        ab.i("MicroMsg.WebViewUIBagHelper", "updateUrl url:%s", str);
        this.uzH = str;
        AppMethodBeat.o(8260);
    }

    public final boolean dbd() {
        AppMethodBeat.i(8261);
        ab.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage fromBag:%b，isTransformBag:%b, hashcode:%d", Boolean.valueOf(this.uzK), Boolean.valueOf(this.uzL), Integer.valueOf(hashCode()));
        if (this.uzL) {
            AppMethodBeat.o(8261);
            return true;
        } else if (this.uzK) {
            Bundle Jz = Jz(7);
            if (Jz == null) {
                AppMethodBeat.o(8261);
                return false;
            }
            ab.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage  hasBag:%b", Boolean.valueOf(Jz.getBoolean("key_has_bag")));
            if (Jz.getBoolean("key_has_bag") && this.uzK) {
                AppMethodBeat.o(8261);
                return true;
            }
            AppMethodBeat.o(8261);
            return false;
        } else {
            AppMethodBeat.o(8261);
            return false;
        }
    }

    private Bundle Jz(int i) {
        AppMethodBeat.i(8262);
        Bundle u = u(i, new Bundle());
        AppMethodBeat.o(8262);
        return u;
    }

    private Bundle u(int i, Bundle bundle) {
        AppMethodBeat.i(8263);
        if (9 != i) {
            ab.i("MicroMsg.WebViewUIBagHelper", "Tools doBagLogic : %d, hashcode:%d", Integer.valueOf(i), Integer.valueOf(hashCode()));
        }
        if (this.uzE == null) {
            ab.w("MicroMsg.WebViewUIBagHelper", "doBagLogic mIPCDelegate null");
            AppMethodBeat.o(8263);
            return null;
        }
        bundle.putInt("key_action", i);
        switch (i) {
            case 1:
                this.uzL = true;
                dbn();
                bundle.putString("key_url", this.uzH);
                bundle.putString("key_bag_icon", this.uzI);
                bundle.putInt("key_scene", this.gOW);
                bundle.putBundle("key_extras", k.aC(this.uyr.getIntent()));
                bundle.putBoolean("key_from_bag", this.uzK);
                break;
            case 4:
                this.uzL = false;
                break;
            case 5:
                bundle.putBoolean("key_in_webviewui_from_bag", true);
                break;
            case 6:
                bundle.putBoolean("key_in_webviewui_from_bag", false);
                break;
            case 7:
                bundle.putString("key_bag_id", this.uzM);
                break;
        }
        Bundle T = this.uzE.T(bundle);
        AppMethodBeat.o(8263);
        return T;
    }

    private void dbn() {
        AppMethodBeat.i(8264);
        if (bo.isNullOrNil(this.uzH)) {
            this.uzH = this.uyr.getUrl();
        }
        AppMethodBeat.o(8264);
    }

    private void Jy(int i) {
        AppMethodBeat.i(8265);
        ab.v("MicroMsg.WebViewUIBagHelper", "kvReport op:%d", Integer.valueOf(i));
        if (this.uzE == null) {
            ab.w("MicroMsg.WebViewUIBagHelper", "kvReport mIPCDelegate null");
            AppMethodBeat.o(8265);
            return;
        }
        dbn();
        this.uzE.y(new Object[]{this.uzH, Integer.valueOf(i), Integer.valueOf(0), this.uzM});
        AppMethodBeat.o(8265);
    }

    private boolean cXe() {
        AppMethodBeat.i(8266);
        boolean cXe = this.uyr.cXe();
        AppMethodBeat.o(8266);
        return cXe;
    }
}
