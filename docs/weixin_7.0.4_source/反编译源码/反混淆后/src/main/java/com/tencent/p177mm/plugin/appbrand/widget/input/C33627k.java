package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.view.C0477s;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.statusbar.C5540a;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.Reference;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.k */
public class C33627k implements C10380c {
    private static final C6197a<C44709u, C33627k> jeA = new C6197a();
    private static final C33627k jet = new C274091();
    private final C44709u jdD;
    private final Runnable jeB;
    private final Runnable jeC;
    final Map<C33628a, C33627k> jes;
    private final int jeu;
    private final int jev;
    private int jew;
    private boolean jex;
    private int jey;
    private int jez;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.k$2 */
    class C110232 implements Runnable {
        C110232() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123653);
            if (C33627k.this.jdD.isRunning()) {
                View b = C33627k.m54903b(C33627k.this);
                if (b != null) {
                    b.scrollTo(0, 0);
                    if (C33627k.this.jez != 0) {
                        C27221aj aJz = C33627k.this.jdD.aJz();
                        if (aJz != null) {
                            b = aJz.getContentView();
                            if (b != null) {
                                b.scrollBy(b.getScrollX(), -C33627k.this.jez);
                            }
                        }
                    }
                    C33627k.m54905d(C33627k.this);
                }
                AppMethodBeat.m2505o(123653);
                return;
            }
            AppMethodBeat.m2505o(123653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.k$1 */
    static class C274091 extends C33627k {
        C274091() {
            super();
        }

        /* renamed from: qA */
        public final void mo45142qA(int i) {
        }

        /* renamed from: qB */
        public final void mo45143qB(int i) {
        }

        public final void onDestroy() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(123652);
            String str = super.toString() + "|DUMMY";
            AppMethodBeat.m2505o(123652);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.k$3 */
    class C274113 implements Runnable {
        C274113() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123655);
            C4990ab.m7418v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
            C45718aa x = C42743o.m75758x(C33627k.this.jdD);
            if (x == null) {
                AppMethodBeat.m2505o(123655);
            } else if (C33627k.this.jdD.isRunning()) {
                C33627k.this.jez = 0;
                if (x.getInputPanel() == null || x.aQo() == null) {
                    AppMethodBeat.m2505o(123655);
                    return;
                }
                EditText aQo = x.aQo();
                View inputPanel = x.getInputPanel();
                if (C10732w.m18402ct(aQo)) {
                    m43490b(x, 0);
                    AppMethodBeat.m2505o(123655);
                    return;
                }
                if (((C45719ac) inputPanel).aQV()) {
                    C33627k.this.jew = 0;
                    C4990ab.m7419v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", Integer.valueOf(inputPanel.getHeight()));
                } else {
                    C4990ab.m7419v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(C33627k.this.jew));
                    if (C33627k.m54907f(C33627k.this) < 5) {
                        C33627k.m54909g(C33627k.this);
                        AppMethodBeat.m2505o(123655);
                        return;
                    }
                }
                m43490b(x, inputPanel.getHeight());
                if (x.aQr()) {
                    int i;
                    int i2;
                    int[] iArr = new int[2];
                    aQo.getLocationOnScreen(iArr);
                    int i3 = iArr[1];
                    C4990ab.m7419v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", Integer.valueOf(aQo.getHeight()), Integer.valueOf(i3), Boolean.valueOf(C0477s.m930av(aQo)));
                    C33627k.m54911i(C33627k.this);
                    int height = aQo.getHeight() + i3;
                    inputPanel.getLocationOnScreen(iArr);
                    int i4 = iArr[1];
                    if (!((C38595ab) aQo).aQP() || aQo.getLayout() == null) {
                        i = height;
                        i2 = i3;
                    } else {
                        i = i3 + ((C38595ab) aQo).mo6598qI(aQo.getLayout().getLineForOffset(aQo.getSelectionStart()));
                        int qI = i3 + ((C38595ab) aQo).mo6598qI(aQo.getLayout().getLineForOffset(aQo.getSelectionStart()) + 1);
                        if (i - i3 >= aQo.getHeight()) {
                            i2 = height - aQo.getLineHeight();
                        } else {
                            i2 = i;
                        }
                        i = qI - i3 >= aQo.getHeight() ? height : qI;
                    }
                    if (!C33627k.this.jdD.aJQ()) {
                        i += x.aQs();
                    }
                    if (i4 != i) {
                        if (i2 < C33627k.this.jeu) {
                            C27221aj aJz = C33627k.this.jdD.aJz();
                            if (aJz != null) {
                                inputPanel = aJz.getContentView();
                                if (!(inputPanel == null || aQo == null)) {
                                    inputPanel.scrollBy(inputPanel.getScrollX(), -(aJz.getWebScrollY() - aQo.getTop()));
                                    AppMethodBeat.m2505o(123655);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(123655);
                            return;
                        }
                        i = Math.max(-aQK(), Math.min(i - i4, i2 - C33627k.this.jeu));
                        C27221aj aJz2 = C33627k.this.jdD.aJz();
                        if (aJz2 != null) {
                            View contentView = aJz2.getContentView();
                            if (!(contentView == null || aQo == null)) {
                                if (((C38595ab) aQo).aQT()) {
                                    m43491qC(aQK() + i);
                                    AppMethodBeat.m2505o(123655);
                                    return;
                                }
                                i3 = aJz2.getHeight();
                                int webScrollY = aJz2.getWebScrollY();
                                height = C42668g.m75571qb(aJz2.getContentHeight());
                                i4 = aQo.getHeight();
                                aQo.getTop();
                                if (((C38595ab) aQo).aQP() || (aQo.getTop() + i4) - webScrollY > i3) {
                                    i2 = Math.max(0, Math.min((height - webScrollY) - i3, i));
                                    contentView.scrollBy(contentView.getScrollX(), i2);
                                    C33627k.this.jez = i2;
                                    m43491qC((i - i2) + aQK());
                                } else {
                                    m43491qC(aQK() + i);
                                    AppMethodBeat.m2505o(123655);
                                    return;
                                }
                            }
                        }
                        AppMethodBeat.m2505o(123655);
                        return;
                    }
                    AppMethodBeat.m2505o(123655);
                    return;
                }
                C4990ab.m7419v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                AppMethodBeat.m2505o(123655);
            } else {
                AppMethodBeat.m2505o(123655);
            }
        }

        /* renamed from: b */
        private void m43490b(final C45718aa c45718aa, final int i) {
            AppMethodBeat.m2504i(123656);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(123654);
                    c45718aa.mo35109qx(i);
                    AppMethodBeat.m2505o(123654);
                }
            });
            AppMethodBeat.m2505o(123656);
        }

        private int aQK() {
            AppMethodBeat.m2504i(123657);
            View b = C33627k.m54903b(C33627k.this);
            if (b != null) {
                int scrollY = b.getScrollY();
                AppMethodBeat.m2505o(123657);
                return scrollY;
            }
            AppMethodBeat.m2505o(123657);
            return 0;
        }

        /* renamed from: qC */
        private void m43491qC(int i) {
            AppMethodBeat.m2504i(123658);
            C4990ab.m7411d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", Integer.valueOf(i));
            View b = C33627k.m54903b(C33627k.this);
            if (b != null) {
                b.scrollTo(0, i);
                C33627k.m54913k(C33627k.this);
            }
            AppMethodBeat.m2505o(123658);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.k$a */
    public interface C33628a {
        void aQL();

        void aQM();
    }

    /* renamed from: f */
    static /* synthetic */ int m54907f(C33627k c33627k) {
        int i = c33627k.jew + 1;
        c33627k.jew = i;
        return i;
    }

    /* renamed from: g */
    static /* synthetic */ void m54909g(C33627k c33627k) {
        AppMethodBeat.m2504i(123670);
        c33627k.m54908fe(false);
        AppMethodBeat.m2505o(123670);
    }

    /* renamed from: a */
    public final void mo54191a(C33628a c33628a) {
        AppMethodBeat.m2504i(123659);
        if (c33628a == null) {
            AppMethodBeat.m2505o(123659);
            return;
        }
        this.jes.remove(c33628a);
        AppMethodBeat.m2505o(123659);
    }

    static {
        AppMethodBeat.m2504i(123673);
        AppMethodBeat.m2505o(123673);
    }

    private C33627k() {
        AppMethodBeat.m2504i(123660);
        this.jes = new C6197a();
        this.jev = 5;
        this.jew = 0;
        this.jex = false;
        this.jey = -1;
        this.jez = 0;
        this.jeB = new C110232();
        this.jeC = new C274113();
        this.jdD = null;
        this.jeu = 0;
        AppMethodBeat.m2505o(123660);
    }

    /* JADX WARNING: Missing block: B:3:0x003c, code skipped:
            if (r0 == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C33627k(C44709u c44709u) {
        Activity context;
        AppMethodBeat.m2504i(123661);
        this.jes = new C6197a();
        this.jev = 5;
        this.jew = 0;
        this.jex = false;
        this.jey = -1;
        this.jez = 0;
        this.jeB = new C110232();
        this.jeC = new C274113();
        this.jdD = c44709u;
        this.jdD.mo53828a((C10380c) this);
        C6750i runtime = c44709u.getRuntime();
        if (runtime != null) {
            context = runtime.getContext();
        }
        Context context2 = c44709u.getContext();
        if (!(context2 instanceof Activity)) {
            context2 = null;
        }
        context = (Activity) context2;
        this.jeu = C5540a.m8359ay(context);
        AppMethodBeat.m2505o(123661);
    }

    /* renamed from: a */
    public static C33627k m54902a(Reference<C44709u> reference) {
        AppMethodBeat.m2504i(123662);
        C33627k u = C33627k.m54914u(reference == null ? null : (C44709u) reference.get());
        AppMethodBeat.m2505o(123662);
        return u;
    }

    /* renamed from: u */
    public static C33627k m54914u(C44709u c44709u) {
        AppMethodBeat.m2504i(123663);
        C33627k c33627k;
        if (c44709u == null || !c44709u.isRunning()) {
            C4990ab.m7408b("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page ".concat(String.valueOf(c44709u)), new Object[0]);
            c33627k = jet;
            AppMethodBeat.m2505o(123663);
            return c33627k;
        }
        c33627k = (C33627k) jeA.get(c44709u);
        if (c33627k == null) {
            c33627k = new C33627k(c44709u);
            jeA.put(c44709u, c33627k);
        }
        AppMethodBeat.m2505o(123663);
        return c33627k;
    }

    /* renamed from: fe */
    private void m54908fe(boolean z) {
        AppMethodBeat.m2504i(123664);
        if (z) {
            this.jew = 0;
            this.jex = false;
        }
        if (!this.jdD.isRunning()) {
            AppMethodBeat.m2505o(123664);
        } else if (this.jex) {
            this.jew = 0;
            AppMethodBeat.m2505o(123664);
        } else if (this.jew == 0) {
            C4990ab.m7419v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", Boolean.valueOf(C0477s.m930av(this.jdD.getContentView())));
            this.jdD.getContentView().post(this.jeC);
            AppMethodBeat.m2505o(123664);
        } else {
            C4990ab.m7419v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", Boolean.valueOf(C0477s.m930av(this.jdD.getContentView())));
            this.jdD.getContentView().postOnAnimationDelayed(this.jeC, 100);
            AppMethodBeat.m2505o(123664);
        }
    }

    /* renamed from: qA */
    public void mo45142qA(int i) {
        AppMethodBeat.m2504i(123665);
        this.jey = i;
        m54908fe(true);
        AppMethodBeat.m2505o(123665);
    }

    /* renamed from: qB */
    public void mo45143qB(int i) {
        AppMethodBeat.m2504i(123666);
        if (!this.jdD.isRunning()) {
            AppMethodBeat.m2505o(123666);
        } else if (i != this.jey) {
            C4990ab.m7421w("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", Integer.valueOf(this.jey), Integer.valueOf(i));
            AppMethodBeat.m2505o(123666);
        } else {
            this.jex = true;
            this.jdD.getContentView().post(this.jeB);
            AppMethodBeat.m2505o(123666);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(123667);
        this.jdD.mo53833b((C10380c) this);
        jeA.remove(this.jdD);
        AppMethodBeat.m2505o(123667);
    }

    /* renamed from: b */
    static /* synthetic */ View m54903b(C33627k c33627k) {
        AppMethodBeat.m2504i(123668);
        if (c33627k.jdD.isRunning()) {
            View aBk = c33627k.jdD.aBk();
            AppMethodBeat.m2505o(123668);
            return aBk;
        }
        AppMethodBeat.m2505o(123668);
        return null;
    }

    /* renamed from: d */
    static /* synthetic */ void m54905d(C33627k c33627k) {
        AppMethodBeat.m2504i(123669);
        if (c33627k.jes.size() > 0) {
            for (C33628a aQM : (C33628a[]) c33627k.jes.keySet().toArray(new C33628a[c33627k.jes.size()])) {
                aQM.aQM();
            }
        }
        AppMethodBeat.m2505o(123669);
    }

    /* renamed from: i */
    static /* synthetic */ int m54911i(C33627k c33627k) {
        AppMethodBeat.m2504i(123671);
        Display defaultDisplay = ((WindowManager) c33627k.jdD.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.y;
        AppMethodBeat.m2505o(123671);
        return i;
    }

    /* renamed from: k */
    static /* synthetic */ void m54913k(C33627k c33627k) {
        AppMethodBeat.m2504i(123672);
        if (c33627k.jes.size() > 0) {
            for (C33628a aQL : (C33628a[]) c33627k.jes.keySet().toArray(new C33628a[c33627k.jes.size()])) {
                aQL.aQL();
            }
        }
        AppMethodBeat.m2505o(123672);
    }
}
