package com.tencent.p177mm.plugin.webview.fts.p1069ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43871a;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b.C22791b;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.fts.ui.b */
public final class C40222b {
    private MMWebView fow;
    List<C14460a> iut;
    public int iuu = -1;
    public float[] iuv;
    View iuw;
    public int iuy = -1;
    public C7306ak mHandler;
    public C43871a uhu;
    C22791b uhv;

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$5 */
    public class C144595 extends C5039bj<Boolean> {
        final /* synthetic */ int hCN;

        public C144595(Boolean bool, int i) {
            this.hCN = i;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(5916);
            Boolean valueOf = Boolean.valueOf(C40222b.this.mo63573pD(this.hCN));
            AppMethodBeat.m2505o(5916);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$a */
    public static class C14460a {
        /* renamed from: id */
        int f2959id;
        public WeakReference<View> iuM;
        int iuN;
        /* renamed from: z */
        int f2960z;

        public C14460a(View view, int i, int i2, int i3) {
            AppMethodBeat.m2504i(5917);
            this.iuM = new WeakReference(view);
            this.f2959id = i;
            this.iuN = i2;
            this.f2960z = i3;
            AppMethodBeat.m2505o(5917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$3 */
    public class C228103 extends C5039bj<Boolean> {
        final /* synthetic */ int auD;
        final /* synthetic */ int hCN;
        final /* synthetic */ float[] iuD;

        public C228103(Boolean bool, int i, float[] fArr, int i2) {
            this.hCN = i;
            this.iuD = fArr;
            this.auD = i2;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(5914);
            Boolean valueOf = Boolean.valueOf(C40222b.this.mo63570a(this.hCN, this.iuD, this.auD));
            AppMethodBeat.m2505o(5914);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$2 */
    public class C297732 extends C5039bj<Boolean> {
        final /* synthetic */ int hCN;

        public C297732(Boolean bool, int i) {
            this.hCN = i;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            boolean z;
            Boolean valueOf;
            AppMethodBeat.m2504i(5913);
            C40222b c40222b = C40222b.this;
            int i = this.hCN;
            C14460a IC = c40222b.mo63568IC(i);
            if (IC != null) {
                c40222b.mo63573pD(i);
                c40222b.mo63569a(IC);
                ViewGroup IB = c40222b.mo63567IB(IC.iuN);
                if (IB != null) {
                    c40222b.iut.remove(IC);
                    IB.removeView((View) IC.iuM.get());
                    z = true;
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.m2505o(5913);
                    return valueOf;
                }
            }
            z = false;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(5913);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$4 */
    public class C297744 extends C5039bj<Boolean> {
        final /* synthetic */ int hCN;
        final /* synthetic */ C43871a uhx;
        final /* synthetic */ boolean uhy;

        public C297744(Boolean bool, int i, C43871a c43871a, boolean z) {
            this.hCN = i;
            this.uhx = c43871a;
            this.uhy = z;
            super(1000, bool, (byte) 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object run() {
            boolean z;
            AppMethodBeat.m2504i(5915);
            C40222b c40222b = C40222b.this;
            int i = this.hCN;
            C43871a c43871a = this.uhx;
            boolean z2 = this.uhy;
            if (i == c40222b.iuu) {
                z = false;
            } else {
                C14460a IC = c40222b.mo63568IC(i);
                if (IC == null || IC.iuM == null) {
                    z = false;
                } else {
                    View view = (View) IC.iuM.get();
                    if (view == null) {
                        z = false;
                    } else {
                        c40222b.iuy = i;
                        ViewGroup IB = c40222b.mo63567IB(IC.iuN);
                        C14460a IC2 = c40222b.mo63568IC(IC.iuN);
                        if (IC2 != null) {
                            ViewGroup IB2 = c40222b.mo63567IB(IC2.iuN);
                            if (IB2 != null) {
                                View view2 = (View) IC.iuM.get();
                                if (view2 != null) {
                                    LayoutParams layoutParams = view2.getLayoutParams();
                                    layoutParams.width = -1;
                                    layoutParams.height = -1;
                                    view2.setLayoutParams(layoutParams);
                                }
                                c40222b.iuy = IC2.f2959id;
                                IB = IB2;
                                if (IB != null) {
                                    view = (View) IC2.iuM.get();
                                    IB.addView(c40222b.iuw, IB.indexOfChild(view));
                                    IB.removeView(view);
                                }
                                c40222b.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) IC2.f2960z};
                                c40222b.uhv.mo9686s(view, z2);
                                c40222b.iuu = i;
                                c40222b.uhu = c43871a;
                                z = true;
                            }
                        }
                        IC2 = IC;
                        if (IB != null) {
                        }
                        c40222b.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) IC2.f2960z};
                        c40222b.uhv.mo9686s(view, z2);
                        c40222b.iuu = i;
                        c40222b.uhu = c43871a;
                        z = true;
                    }
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(5915);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$1 */
    public class C355881 extends C5039bj<Boolean> {
        final /* synthetic */ int auD;
        final /* synthetic */ int hCN;
        final /* synthetic */ int iuC = 0;
        final /* synthetic */ float[] iuD;
        final /* synthetic */ View val$view;

        public C355881(Boolean bool, View view, int i, float[] fArr, int i2) {
            this.val$view = view;
            this.hCN = i;
            this.iuD = fArr;
            this.auD = i2;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(5912);
            Boolean valueOf = Boolean.valueOf(C40222b.this.mo63571a(this.val$view, this.hCN, this.iuC, this.iuD, this.auD));
            AppMethodBeat.m2505o(5912);
            return valueOf;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public C40222b(MMWebView mMWebView, C22791b c22791b) {
        AppMethodBeat.m2504i(5918);
        this.fow = mMWebView;
        this.mHandler = new C7306ak(Looper.getMainLooper());
        this.iut = new LinkedList();
        this.iuw = new View(mMWebView.getContext());
        this.uhv = c22791b;
        AppMethodBeat.m2505o(5918);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo63571a(View view, int i, int i2, float[] fArr, int i3) {
        int i4 = 0;
        AppMethodBeat.m2504i(5919);
        if (view == null || fArr == null || fArr.length < 5) {
            AppMethodBeat.m2505o(5919);
            return false;
        }
        ViewGroup IB = mo63567IB(i2);
        if (IB == null) {
            AppMethodBeat.m2505o(5919);
            return false;
        } else if (mo63574q(i) != null) {
            AppMethodBeat.m2505o(5919);
            return false;
        } else {
            float f = fArr[0];
            float f2 = fArr[1];
            int i5 = (int) fArr[4];
            LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
            int dj = m68982dj(i2, i5);
            if (dj < 0) {
                dj = 0;
            }
            if (dj > IB.getChildCount()) {
                dj = IB.getChildCount();
            }
            if (i3 != BaseClientBuilder.API_PRIORITY_OTHER && i3 >= 0) {
                if (i3 != 0) {
                    i4 = 8;
                }
                view.setVisibility(i4);
            }
            IB.addView(view, dj, layoutParams);
            view.setX(f);
            view.setY(f2);
            m68981c(view, i, i2, i5);
            AppMethodBeat.m2505o(5919);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: IB */
    public final ViewGroup mo63567IB(int i) {
        AppMethodBeat.m2504i(5920);
        ViewGroup topView;
        if (i == 0) {
            topView = this.fow.getTopView();
            if (topView instanceof AbsoluteLayout) {
                AppMethodBeat.m2505o(5920);
                return topView;
            }
            AppMethodBeat.m2505o(5920);
            return null;
        }
        C14460a IC = mo63568IC(i);
        if (IC == null) {
            AppMethodBeat.m2505o(5920);
            return null;
        }
        View view = (View) IC.iuM.get();
        if (view instanceof ViewGroup) {
            topView = (ViewGroup) view;
            AppMethodBeat.m2505o(5920);
            return topView;
        }
        AppMethodBeat.m2505o(5920);
        return null;
    }

    /* renamed from: a */
    public final boolean mo63570a(int i, float[] fArr, int i2) {
        AppMethodBeat.m2504i(5921);
        if (mo63572pB(i)) {
            AppMethodBeat.m2505o(5921);
            return true;
        }
        C14460a IC = mo63568IC(i);
        if (IC == null) {
            AppMethodBeat.m2505o(5921);
            return false;
        }
        View view = (View) IC.iuM.get();
        ViewGroup IB = mo63567IB(IC.iuN);
        if (IB == null) {
            AppMethodBeat.m2505o(5921);
            return false;
        }
        if (i2 >= 0 && i2 != BaseClientBuilder.API_PRIORITY_OTHER) {
            view.setVisibility(i2 == 0 ? 0 : 8);
        }
        if (fArr == null || fArr.length < 5) {
            AppMethodBeat.m2505o(5921);
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        this.iut.remove(IC);
        if (IC.f2960z != i3) {
            IB.removeView(view);
            if (mo63571a(view, i, IC.iuN, fArr, i2)) {
                AppMethodBeat.m2505o(5921);
                return true;
            }
            mo63569a(IC);
            AppMethodBeat.m2505o(5921);
            return false;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (f3 != Float.MAX_VALUE) {
            layoutParams.width = (int) f3;
        }
        if (f4 != Float.MAX_VALUE) {
            layoutParams.height = (int) f4;
        }
        if (f != Float.MAX_VALUE) {
            view.setX(f);
        }
        if (f2 != Float.MAX_VALUE) {
            view.setY(f2);
        }
        view.requestLayout();
        m68981c(view, i, IC.iuN, i3);
        int indexOfChild = IB.indexOfChild(this.iuw);
        if (IB.indexOfChild(view) == -1 && indexOfChild != -1) {
            IB.addView(view, indexOfChild);
            IB.removeView(this.iuw);
        }
        AppMethodBeat.m2505o(5921);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo63569a(C14460a c14460a) {
        AppMethodBeat.m2504i(5922);
        this.iut.removeAll(m68980b(c14460a));
        AppMethodBeat.m2505o(5922);
    }

    /* renamed from: b */
    private List<C14460a> m68980b(C14460a c14460a) {
        AppMethodBeat.m2504i(5923);
        LinkedList linkedList = new LinkedList();
        for (C14460a c14460a2 : this.iut) {
            if (c14460a2.iuN == c14460a.f2959id) {
                linkedList.addAll(m68980b(c14460a2));
            }
        }
        linkedList.add(c14460a);
        AppMethodBeat.m2505o(5923);
        return linkedList;
    }

    /* renamed from: dj */
    private int m68982dj(int i, int i2) {
        AppMethodBeat.m2504i(5924);
        int i3 = 0;
        Iterator it = this.iut.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                C14460a c14460a = (C14460a) it.next();
                if (i == c14460a.iuN && i2 >= c14460a.f2960z) {
                    i4++;
                }
                i3 = i4;
            } else {
                AppMethodBeat.m2505o(5924);
                return i4;
            }
        }
    }

    /* renamed from: IC */
    public final C14460a mo63568IC(int i) {
        AppMethodBeat.m2504i(5925);
        for (C14460a c14460a : this.iut) {
            if (c14460a.f2959id == i) {
                AppMethodBeat.m2505o(5925);
                return c14460a;
            }
        }
        AppMethodBeat.m2505o(5925);
        return null;
    }

    /* renamed from: q */
    public final View mo63574q(int i) {
        AppMethodBeat.m2504i(5926);
        C14460a IC = mo63568IC(i);
        if (IC == null) {
            AppMethodBeat.m2505o(5926);
            return null;
        }
        View view = (View) IC.iuM.get();
        AppMethodBeat.m2505o(5926);
        return view;
    }

    /* renamed from: c */
    private void m68981c(View view, int i, int i2, int i3) {
        AppMethodBeat.m2504i(5927);
        this.iut.add(new C14460a(view, i, i2, i3));
        AppMethodBeat.m2505o(5927);
    }

    /* renamed from: pB */
    public final boolean mo63572pB(int i) {
        return this.iuy == i || this.iuu == i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pD */
    public final boolean mo63573pD(int i) {
        AppMethodBeat.m2504i(5928);
        if (i != this.iuu) {
            AppMethodBeat.m2505o(5928);
            return false;
        } else if (mo63568IC(i) == null) {
            AppMethodBeat.m2505o(5928);
            return false;
        } else {
            this.uhv.cWA();
            AppMethodBeat.m2505o(5928);
            return true;
        }
    }
}
