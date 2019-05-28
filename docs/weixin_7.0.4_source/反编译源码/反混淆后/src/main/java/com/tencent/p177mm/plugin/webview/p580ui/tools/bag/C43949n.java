package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C14588c.C145891;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h.C22936a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C29879l.C229411;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43940d.C439392;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.n */
public final class C43949n implements C22935h {
    private int gOW = 0;
    private final C43945g uyr;
    private final C43943f uys;
    private C22936a uzE;
    private C43940d uzF;
    private C14588c uzG;
    private String uzH;
    private String uzI;
    private final C43942e uzJ;
    private boolean uzK;
    private boolean uzL;
    private String uzM;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.n$a */
    public static final class C35647a {
        /* renamed from: af */
        public static Bundle m58499af(Bundle bundle) {
            AppMethodBeat.m2504i(8253);
            int i = bundle.getInt("key_action", -1);
            Bundle bundle2 = new Bundle();
            if (C1720g.m3534RN().mo5161QY()) {
                if (9 != i) {
                    C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "MM doBagLogic action:%d", Integer.valueOf(i));
                }
                switch (i) {
                    case 5:
                    case 6:
                        C29879l.uzq.mo48113nV(bundle.getBoolean("key_in_webviewui_from_bag", false));
                        break;
                    case 7:
                        bundle2.putBoolean("key_has_bag", C29879l.uzq.afZ(bundle.getString("key_bag_id")));
                        break;
                    case 8:
                        bundle2.putParcelable("key_current_bag_pos", C29879l.uzq.dbh());
                        break;
                    default:
                        C35647a.m58500v(i, bundle);
                        break;
                }
                AppMethodBeat.m2505o(8253);
            } else {
                C4990ab.m7420w("MicroMsg.WebViewUIBagHelper", "MM doBagLogic not ready");
                AppMethodBeat.m2505o(8253);
            }
            return bundle2;
        }

        /* renamed from: v */
        private static void m58500v(final int i, final Bundle bundle) {
            AppMethodBeat.m2504i(8254);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8252);
                    switch (i) {
                        case 1:
                            String string = bundle.getString("key_url");
                            String string2 = bundle.getString("key_bag_icon");
                            int i = bundle.getInt("key_scene", 0);
                            boolean z = bundle.getBoolean("key_from_bag", false);
                            Bundle bundle = bundle.getBundle("key_extras");
                            C29879l c29879l = C29879l.uzq;
                            if (C37657b.m63684bF(C4996ah.getContext())) {
                                c29879l.mo48105a(string, i, string2, bundle, z);
                                c29879l.mo48114nW(false);
                                AppMethodBeat.m2505o(8252);
                                return;
                            }
                            C4990ab.m7420w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
                            Context context = C4996ah.getContext();
                            RequestFloatWindowPermissionDialog.m58702a(context, context.getString(C25738R.string.fxw), new C229411(string, i, string2, bundle, z));
                            AppMethodBeat.m2505o(8252);
                            return;
                        case 2:
                            C29879l.uzq.cYT();
                            AppMethodBeat.m2505o(8252);
                            return;
                        case 3:
                            C29879l.uzq.mo48112nU(false);
                            AppMethodBeat.m2505o(8252);
                            return;
                        case 4:
                            C29879l.uzq.dbg();
                            AppMethodBeat.m2505o(8252);
                            return;
                        case 9:
                            C29879l.uzq.mo48107bi(bundle.getFloat("key_alpha", 1.0f));
                            break;
                    }
                    AppMethodBeat.m2505o(8252);
                }
            });
            AppMethodBeat.m2505o(8254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.n$2 */
    class C402902 implements C43942e {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.n$2$1 */
        class C229431 implements Runnable {
            C229431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(8249);
                C43949n.m78883b(C43949n.this, 1);
                AppMethodBeat.m2505o(8249);
            }
        }

        C402902() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(8250);
            C4990ab.m7416i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationEnd");
            C43949n.this.uzL = true;
            C43949n.this.uyr.mo38466mu(false);
            C43949n.m78883b(C43949n.this, 1);
            AppMethodBeat.m2505o(8250);
        }

        public final void dbb() {
            AppMethodBeat.m2504i(8251);
            C4990ab.m7416i("MicroMsg.WebViewUIBagHelper", "bag transformation onAnimationCancel do default");
            C43949n.this.uzL = true;
            C43949n.this.uyr.mo38466mu(true);
            C5004al.m7442n(new C229431(), 500);
            AppMethodBeat.m2505o(8251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.n$1 */
    class C439501 implements C43943f {
        C439501() {
        }

        /* renamed from: d */
        public final void mo69626d(float f, int i) {
            AppMethodBeat.m2504i(8247);
            C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "showBag swipedPosX:%f reportScene:%d", Float.valueOf(f), Integer.valueOf(i));
            C43949n.m78882a(C43949n.this, i);
            C35645i.m58496a(C43949n.this.uyr, (Point) C43949n.m78883b(C43949n.this, 8).getParcelable("key_current_bag_pos"), f, C43949n.this.uzJ);
            AppMethodBeat.m2505o(8247);
        }

        /* renamed from: bh */
        public final void mo69625bh(float f) {
            AppMethodBeat.m2504i(8248);
            Bundle bundle = new Bundle();
            bundle.putFloat("key_alpha", f);
            C43949n.m78880a(C43949n.this, bundle);
            AppMethodBeat.m2505o(8248);
        }
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m78883b(C43949n c43949n, int i) {
        AppMethodBeat.m2504i(8268);
        Bundle Jz = c43949n.m78879Jz(i);
        AppMethodBeat.m2505o(8268);
        return Jz;
    }

    public C43949n(C43945g c43945g) {
        AppMethodBeat.m2504i(8255);
        this.uyr = c43945g;
        if (this.uyr.getIntent().getExtras() != null) {
            this.gOW = this.uyr.getIntent().getIntExtra("minimize_secene", this.gOW);
        }
        this.uys = new C439501();
        this.uzJ = new C402902();
        this.uzK = this.uyr.getIntent().getBooleanExtra("from_bag", false);
        this.uzM = this.uyr.getIntent().getStringExtra("from_bag_id");
        this.uzI = this.uyr.getIntent().getStringExtra("from_bag_icon");
        if (!cXe()) {
            C4990ab.m7416i("MicroMsg.WebViewUIBagHelper", "not support swipeback");
            AppMethodBeat.m2505o(8255);
        } else if (this.uzK) {
            this.uzG = new C14588c(this.uyr, this.uys);
            AppMethodBeat.m2505o(8255);
        } else {
            C4990ab.m7416i("MicroMsg.WebViewUIBagHelper", "not from bag, can swipe to bag");
            this.uzF = new C43940d(this.uyr, this.uys);
            AppMethodBeat.m2505o(8255);
        }
    }

    /* renamed from: a */
    public final void mo38527a(C22936a c22936a) {
        AppMethodBeat.m2504i(8256);
        C4990ab.m7416i("MicroMsg.WebViewUIBagHelper", "onIPCReady");
        this.uzE = c22936a;
        if (this.uzK) {
            m78879Jz(5);
            if (cXe() && this.uzG != null) {
                C14588c c14588c = this.uzG;
                c14588c.uyr.mo38458a(new C145891());
            }
        } else if (cXe() && this.uzF != null) {
            this.uzF.start();
            AppMethodBeat.m2505o(8256);
            return;
        }
        AppMethodBeat.m2505o(8256);
    }

    public final void dbc() {
        AppMethodBeat.m2504i(8257);
        C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "onWebViewUIDestroy %b", Boolean.valueOf(this.uzK));
        m78879Jz(6);
        if (this.uzF != null) {
            C43940d c43940d = this.uzF;
            C5004al.m7441d(new C439392());
            c43940d.uyr.mo38458a(null);
            c43940d.uyr = null;
        }
        if (this.uzK) {
            m78879Jz(3);
        }
        AppMethodBeat.m2505o(8257);
    }

    /* renamed from: Jx */
    public final boolean mo38526Jx(int i) {
        AppMethodBeat.m2504i(8258);
        C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "onWebViewClose hasBag:%b", Boolean.valueOf(dbd()));
        if (dbd()) {
            m78878Jy(i);
            C35645i.m58497a(this.uyr, (Point) m78879Jz(8).getParcelable("key_current_bag_pos"), this.uzJ);
            AppMethodBeat.m2505o(8258);
            return true;
        }
        AppMethodBeat.m2505o(8258);
        return false;
    }

    /* renamed from: nT */
    public final void mo38532nT(boolean z) {
        AppMethodBeat.m2504i(8259);
        C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "onMenuMinimizeSelected cancelCurrentBag:%b", Boolean.valueOf(z));
        if (z) {
            m78879Jz(4);
            if (this.uzG != null) {
                this.uzG.uyr.mo38458a(null);
            }
            m78878Jy(18);
            C5670b.m8523i(this.uyr.getActivity(), this.uyr.getActivity().getString(C25738R.string.dhn));
            if (cXe()) {
                this.uzF = new C43940d(this.uyr, this.uys);
                this.uzF.start();
            }
            AppMethodBeat.m2505o(8259);
            return;
        }
        Point point;
        m78878Jy(16);
        Bundle Jz = m78879Jz(8);
        if (Jz == null) {
            int i = C29876b.uyk;
            point = new Point(i, i);
        } else {
            point = (Point) Jz.getParcelable("key_current_bag_pos");
        }
        C35645i.m58497a(this.uyr, point, this.uzJ);
        AppMethodBeat.m2505o(8259);
    }

    public final void afX(String str) {
        this.uzI = str;
    }

    public final void afY(String str) {
        AppMethodBeat.m2504i(8260);
        C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "updateUrl url:%s", str);
        this.uzH = str;
        AppMethodBeat.m2505o(8260);
    }

    public final boolean dbd() {
        AppMethodBeat.m2504i(8261);
        C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage fromBag:%b，isTransformBag:%b, hashcode:%d", Boolean.valueOf(this.uzK), Boolean.valueOf(this.uzL), Integer.valueOf(hashCode()));
        if (this.uzL) {
            AppMethodBeat.m2505o(8261);
            return true;
        } else if (this.uzK) {
            Bundle Jz = m78879Jz(7);
            if (Jz == null) {
                AppMethodBeat.m2505o(8261);
                return false;
            }
            C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage  hasBag:%b", Boolean.valueOf(Jz.getBoolean("key_has_bag")));
            if (Jz.getBoolean("key_has_bag") && this.uzK) {
                AppMethodBeat.m2505o(8261);
                return true;
            }
            AppMethodBeat.m2505o(8261);
            return false;
        } else {
            AppMethodBeat.m2505o(8261);
            return false;
        }
    }

    /* renamed from: Jz */
    private Bundle m78879Jz(int i) {
        AppMethodBeat.m2504i(8262);
        Bundle u = m78886u(i, new Bundle());
        AppMethodBeat.m2505o(8262);
        return u;
    }

    /* renamed from: u */
    private Bundle m78886u(int i, Bundle bundle) {
        AppMethodBeat.m2504i(8263);
        if (9 != i) {
            C4990ab.m7417i("MicroMsg.WebViewUIBagHelper", "Tools doBagLogic : %d, hashcode:%d", Integer.valueOf(i), Integer.valueOf(hashCode()));
        }
        if (this.uzE == null) {
            C4990ab.m7420w("MicroMsg.WebViewUIBagHelper", "doBagLogic mIPCDelegate null");
            AppMethodBeat.m2505o(8263);
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
                bundle.putBundle("key_extras", C22939k.m34817aC(this.uyr.getIntent()));
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
        Bundle T = this.uzE.mo38533T(bundle);
        AppMethodBeat.m2505o(8263);
        return T;
    }

    private void dbn() {
        AppMethodBeat.m2504i(8264);
        if (C5046bo.isNullOrNil(this.uzH)) {
            this.uzH = this.uyr.getUrl();
        }
        AppMethodBeat.m2505o(8264);
    }

    /* renamed from: Jy */
    private void m78878Jy(int i) {
        AppMethodBeat.m2504i(8265);
        C4990ab.m7419v("MicroMsg.WebViewUIBagHelper", "kvReport op:%d", Integer.valueOf(i));
        if (this.uzE == null) {
            C4990ab.m7420w("MicroMsg.WebViewUIBagHelper", "kvReport mIPCDelegate null");
            AppMethodBeat.m2505o(8265);
            return;
        }
        dbn();
        this.uzE.mo38534y(new Object[]{this.uzH, Integer.valueOf(i), Integer.valueOf(0), this.uzM});
        AppMethodBeat.m2505o(8265);
    }

    private boolean cXe() {
        AppMethodBeat.m2504i(8266);
        boolean cXe = this.uyr.cXe();
        AppMethodBeat.m2505o(8266);
        return cXe;
    }
}
