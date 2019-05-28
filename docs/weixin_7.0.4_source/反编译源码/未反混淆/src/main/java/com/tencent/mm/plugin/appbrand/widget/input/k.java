package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.s;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.s.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.Reference;
import java.util.Map;

public class k implements c {
    private static final android.support.v4.f.a<u, k> jeA = new android.support.v4.f.a();
    private static final k jet = new k() {
        public final void qA(int i) {
        }

        public final void qB(int i) {
        }

        public final void onDestroy() {
        }

        public final String toString() {
            AppMethodBeat.i(123652);
            String str = super.toString() + "|DUMMY";
            AppMethodBeat.o(123652);
            return str;
        }
    };
    private final u jdD;
    private final Runnable jeB;
    private final Runnable jeC;
    final Map<a, k> jes;
    private final int jeu;
    private final int jev;
    private int jew;
    private boolean jex;
    private int jey;
    private int jez;

    public interface a {
        void aQL();

        void aQM();
    }

    static /* synthetic */ int f(k kVar) {
        int i = kVar.jew + 1;
        kVar.jew = i;
        return i;
    }

    static /* synthetic */ void g(k kVar) {
        AppMethodBeat.i(123670);
        kVar.fe(false);
        AppMethodBeat.o(123670);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(123659);
        if (aVar == null) {
            AppMethodBeat.o(123659);
            return;
        }
        this.jes.remove(aVar);
        AppMethodBeat.o(123659);
    }

    static {
        AppMethodBeat.i(123673);
        AppMethodBeat.o(123673);
    }

    private k() {
        AppMethodBeat.i(123660);
        this.jes = new android.support.v4.f.a();
        this.jev = 5;
        this.jew = 0;
        this.jex = false;
        this.jey = -1;
        this.jez = 0;
        this.jeB = new Runnable() {
            public final void run() {
                AppMethodBeat.i(123653);
                if (k.this.jdD.isRunning()) {
                    View b = k.b(k.this);
                    if (b != null) {
                        b.scrollTo(0, 0);
                        if (k.this.jez != 0) {
                            aj aJz = k.this.jdD.aJz();
                            if (aJz != null) {
                                b = aJz.getContentView();
                                if (b != null) {
                                    b.scrollBy(b.getScrollX(), -k.this.jez);
                                }
                            }
                        }
                        k.d(k.this);
                    }
                    AppMethodBeat.o(123653);
                    return;
                }
                AppMethodBeat.o(123653);
            }
        };
        this.jeC = new Runnable() {
            public final void run() {
                AppMethodBeat.i(123655);
                ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
                aa x = o.x(k.this.jdD);
                if (x == null) {
                    AppMethodBeat.o(123655);
                } else if (k.this.jdD.isRunning()) {
                    k.this.jez = 0;
                    if (x.getInputPanel() == null || x.aQo() == null) {
                        AppMethodBeat.o(123655);
                        return;
                    }
                    EditText aQo = x.aQo();
                    View inputPanel = x.getInputPanel();
                    if (w.ct(aQo)) {
                        b(x, 0);
                        AppMethodBeat.o(123655);
                        return;
                    }
                    if (((ac) inputPanel).aQV()) {
                        k.this.jew = 0;
                        ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", Integer.valueOf(inputPanel.getHeight()));
                    } else {
                        ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(k.this.jew));
                        if (k.f(k.this) < 5) {
                            k.g(k.this);
                            AppMethodBeat.o(123655);
                            return;
                        }
                    }
                    b(x, inputPanel.getHeight());
                    if (x.aQr()) {
                        int i;
                        int i2;
                        int[] iArr = new int[2];
                        aQo.getLocationOnScreen(iArr);
                        int i3 = iArr[1];
                        ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", Integer.valueOf(aQo.getHeight()), Integer.valueOf(i3), Boolean.valueOf(s.av(aQo)));
                        k.i(k.this);
                        int height = aQo.getHeight() + i3;
                        inputPanel.getLocationOnScreen(iArr);
                        int i4 = iArr[1];
                        if (!((ab) aQo).aQP() || aQo.getLayout() == null) {
                            i = height;
                            i2 = i3;
                        } else {
                            i = i3 + ((ab) aQo).qI(aQo.getLayout().getLineForOffset(aQo.getSelectionStart()));
                            int qI = i3 + ((ab) aQo).qI(aQo.getLayout().getLineForOffset(aQo.getSelectionStart()) + 1);
                            if (i - i3 >= aQo.getHeight()) {
                                i2 = height - aQo.getLineHeight();
                            } else {
                                i2 = i;
                            }
                            i = qI - i3 >= aQo.getHeight() ? height : qI;
                        }
                        if (!k.this.jdD.aJQ()) {
                            i += x.aQs();
                        }
                        if (i4 != i) {
                            if (i2 < k.this.jeu) {
                                aj aJz = k.this.jdD.aJz();
                                if (aJz != null) {
                                    inputPanel = aJz.getContentView();
                                    if (!(inputPanel == null || aQo == null)) {
                                        inputPanel.scrollBy(inputPanel.getScrollX(), -(aJz.getWebScrollY() - aQo.getTop()));
                                        AppMethodBeat.o(123655);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(123655);
                                return;
                            }
                            i = Math.max(-aQK(), Math.min(i - i4, i2 - k.this.jeu));
                            aj aJz2 = k.this.jdD.aJz();
                            if (aJz2 != null) {
                                View contentView = aJz2.getContentView();
                                if (!(contentView == null || aQo == null)) {
                                    if (((ab) aQo).aQT()) {
                                        qC(aQK() + i);
                                        AppMethodBeat.o(123655);
                                        return;
                                    }
                                    i3 = aJz2.getHeight();
                                    int webScrollY = aJz2.getWebScrollY();
                                    height = g.qb(aJz2.getContentHeight());
                                    i4 = aQo.getHeight();
                                    aQo.getTop();
                                    if (((ab) aQo).aQP() || (aQo.getTop() + i4) - webScrollY > i3) {
                                        i2 = Math.max(0, Math.min((height - webScrollY) - i3, i));
                                        contentView.scrollBy(contentView.getScrollX(), i2);
                                        k.this.jez = i2;
                                        qC((i - i2) + aQK());
                                    } else {
                                        qC(aQK() + i);
                                        AppMethodBeat.o(123655);
                                        return;
                                    }
                                }
                            }
                            AppMethodBeat.o(123655);
                            return;
                        }
                        AppMethodBeat.o(123655);
                        return;
                    }
                    ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                    AppMethodBeat.o(123655);
                } else {
                    AppMethodBeat.o(123655);
                }
            }

            private void b(final aa aaVar, final int i) {
                AppMethodBeat.i(123656);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(123654);
                        aaVar.qx(i);
                        AppMethodBeat.o(123654);
                    }
                });
                AppMethodBeat.o(123656);
            }

            private int aQK() {
                AppMethodBeat.i(123657);
                View b = k.b(k.this);
                if (b != null) {
                    int scrollY = b.getScrollY();
                    AppMethodBeat.o(123657);
                    return scrollY;
                }
                AppMethodBeat.o(123657);
                return 0;
            }

            private void qC(int i) {
                AppMethodBeat.i(123658);
                ab.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", Integer.valueOf(i));
                View b = k.b(k.this);
                if (b != null) {
                    b.scrollTo(0, i);
                    k.k(k.this);
                }
                AppMethodBeat.o(123658);
            }
        };
        this.jdD = null;
        this.jeu = 0;
        AppMethodBeat.o(123660);
    }

    /* JADX WARNING: Missing block: B:3:0x003c, code skipped:
            if (r0 == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private k(u uVar) {
        Activity context;
        AppMethodBeat.i(123661);
        this.jes = new android.support.v4.f.a();
        this.jev = 5;
        this.jew = 0;
        this.jex = false;
        this.jey = -1;
        this.jez = 0;
        this.jeB = /* anonymous class already generated */;
        this.jeC = /* anonymous class already generated */;
        this.jdD = uVar;
        this.jdD.a((c) this);
        i runtime = uVar.getRuntime();
        if (runtime != null) {
            context = runtime.getContext();
        }
        Context context2 = uVar.getContext();
        if (!(context2 instanceof Activity)) {
            context2 = null;
        }
        context = (Activity) context2;
        this.jeu = com.tencent.mm.ui.statusbar.a.ay(context);
        AppMethodBeat.o(123661);
    }

    public static k a(Reference<u> reference) {
        AppMethodBeat.i(123662);
        k u = u(reference == null ? null : (u) reference.get());
        AppMethodBeat.o(123662);
        return u;
    }

    public static k u(u uVar) {
        AppMethodBeat.i(123663);
        k kVar;
        if (uVar == null || !uVar.isRunning()) {
            ab.b("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page ".concat(String.valueOf(uVar)), new Object[0]);
            kVar = jet;
            AppMethodBeat.o(123663);
            return kVar;
        }
        kVar = (k) jeA.get(uVar);
        if (kVar == null) {
            kVar = new k(uVar);
            jeA.put(uVar, kVar);
        }
        AppMethodBeat.o(123663);
        return kVar;
    }

    private void fe(boolean z) {
        AppMethodBeat.i(123664);
        if (z) {
            this.jew = 0;
            this.jex = false;
        }
        if (!this.jdD.isRunning()) {
            AppMethodBeat.o(123664);
        } else if (this.jex) {
            this.jew = 0;
            AppMethodBeat.o(123664);
        } else if (this.jew == 0) {
            ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", Boolean.valueOf(s.av(this.jdD.getContentView())));
            this.jdD.getContentView().post(this.jeC);
            AppMethodBeat.o(123664);
        } else {
            ab.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", Boolean.valueOf(s.av(this.jdD.getContentView())));
            this.jdD.getContentView().postOnAnimationDelayed(this.jeC, 100);
            AppMethodBeat.o(123664);
        }
    }

    public void qA(int i) {
        AppMethodBeat.i(123665);
        this.jey = i;
        fe(true);
        AppMethodBeat.o(123665);
    }

    public void qB(int i) {
        AppMethodBeat.i(123666);
        if (!this.jdD.isRunning()) {
            AppMethodBeat.o(123666);
        } else if (i != this.jey) {
            ab.w("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", Integer.valueOf(this.jey), Integer.valueOf(i));
            AppMethodBeat.o(123666);
        } else {
            this.jex = true;
            this.jdD.getContentView().post(this.jeB);
            AppMethodBeat.o(123666);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(123667);
        this.jdD.b((c) this);
        jeA.remove(this.jdD);
        AppMethodBeat.o(123667);
    }

    static /* synthetic */ View b(k kVar) {
        AppMethodBeat.i(123668);
        if (kVar.jdD.isRunning()) {
            View aBk = kVar.jdD.aBk();
            AppMethodBeat.o(123668);
            return aBk;
        }
        AppMethodBeat.o(123668);
        return null;
    }

    static /* synthetic */ void d(k kVar) {
        AppMethodBeat.i(123669);
        if (kVar.jes.size() > 0) {
            for (a aQM : (a[]) kVar.jes.keySet().toArray(new a[kVar.jes.size()])) {
                aQM.aQM();
            }
        }
        AppMethodBeat.o(123669);
    }

    static /* synthetic */ int i(k kVar) {
        AppMethodBeat.i(123671);
        Display defaultDisplay = ((WindowManager) kVar.jdD.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.y;
        AppMethodBeat.o(123671);
        return i;
    }

    static /* synthetic */ void k(k kVar) {
        AppMethodBeat.i(123672);
        if (kVar.jes.size() > 0) {
            for (a aQL : (a[]) kVar.jes.keySet().toArray(new a[kVar.jes.size()])) {
                aQL.aQL();
            }
        }
        AppMethodBeat.o(123672);
    }
}
