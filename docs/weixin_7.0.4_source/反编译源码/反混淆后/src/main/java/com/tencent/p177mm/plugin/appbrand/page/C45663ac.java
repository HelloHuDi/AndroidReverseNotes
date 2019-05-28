package com.tencent.p177mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.p177mm.plugin.appbrand.jsapi.container.WrapperNativeContainerView;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.C38287n;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.C45592o;
import com.tencent.p177mm.plugin.appbrand.page.C2408ao.C2409a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.page.ac */
public class C45663ac {
    C38464c isR;
    private AppBrandPageFullScreenView iuA;
    public ViewGroup ius;
    List<C33466b> iut;
    int iuu = -1;
    float[] iuv;
    View iuw;
    C38462an iux;
    int iuy = -1;
    private C38460ak iuz;
    private C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.ac$a */
    static final class C10660a implements C2409a {
        float iuK;
        float iuL;
        View view;
        /* renamed from: x */
        float f2877x;
        /* renamed from: y */
        float f2878y;

        private C10660a() {
        }

        /* synthetic */ C10660a(byte b) {
            this();
        }

        /* renamed from: dk */
        public final void mo6321dk(int i, int i2) {
            AppMethodBeat.m2504i(91095);
            this.iuK = (float) i;
            this.iuL = (float) i2;
            this.view.setX(this.f2877x + ((float) i));
            this.view.setY(this.f2878y + ((float) i2));
            AppMethodBeat.m2505o(91095);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.ac$1 */
    class C334641 extends C19623ai {
        C334641() {
        }

        public final void aDI() {
            AppMethodBeat.m2504i(91087);
            C45663ac c45663ac = C45663ac.this;
            C33466b py = c45663ac.mo73452py(c45663ac.iuy);
            float[] fArr = c45663ac.iuv;
            if (!(py == null || py.iuM == null || fArr == null)) {
                View view = (View) py.iuM.get();
                if (view != null) {
                    if (c45663ac.iuy != c45663ac.iuu) {
                        C33466b py2 = c45663ac.mo73452py(c45663ac.iuu);
                        if (!(py2 == null || py2.iuM == null)) {
                            View view2 = (View) py2.iuM.get();
                            if (view2 != null) {
                                c45663ac.mo73444b(c45663ac.iuu, fArr, view2.getVisibility(), Boolean.valueOf(py.iuO), Boolean.FALSE);
                            }
                        }
                    }
                    int i = c45663ac.iuy;
                    c45663ac.iuu = -1;
                    c45663ac.iuy = -1;
                    c45663ac.mo73444b(i, fArr, view.getVisibility(), Boolean.valueOf(py.iuO), Boolean.FALSE);
                }
            }
            if (C45663ac.this.iux != null) {
                C45663ac.this.iux.aDI();
                C45663ac.this.iux = null;
            }
            AppMethodBeat.m2505o(91087);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.ac$b */
    public static class C33466b {
        boolean hfz;
        /* renamed from: id */
        int f15035id;
        WeakReference<View> iuM;
        public int iuN;
        boolean iuO;
        C10660a iuP;
        /* renamed from: z */
        int f15036z;

        public C33466b(View view, int i, int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.m2504i(91096);
            this.iuM = new WeakReference(view);
            this.f15035id = i;
            this.iuN = i2;
            this.f15036z = i3;
            this.iuO = z;
            this.hfz = z2;
            AppMethodBeat.m2505o(91096);
        }
    }

    public C45663ac(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(91097);
        this.ius = viewGroup;
        this.mHandler = new C7306ak(Looper.getMainLooper());
        this.iut = new LinkedList();
        this.iuw = new View(viewGroup.getContext());
        AppMethodBeat.m2505o(91097);
    }

    public final void setFullscreenImpl(C38464c c38464c) {
        AppMethodBeat.m2504i(91098);
        this.isR = c38464c;
        this.isR.mo61149a(new C334641());
        AppMethodBeat.m2505o(91098);
    }

    /* renamed from: a */
    public final void mo73440a(C38460ak c38460ak) {
        AppMethodBeat.m2504i(138260);
        C4990ab.m7417i("MicroMsg.AppBrandWebViewCustomViewContainer", "setFullScreenViewObtainer fullScreenViewAttacher:%b", Boolean.TRUE);
        this.iuz = c38460ak;
        if (this.iuA != null) {
            this.iuz.mo22214a(this.iuA);
        }
        AppMethodBeat.m2505o(138260);
    }

    /* renamed from: a */
    public final boolean mo73443a(View view, int i, int i2, float[] fArr, int i3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(91100);
        final View view2 = view;
        final int i4 = i;
        final int i5 = i2;
        final float[] fArr2 = fArr;
        final int i6 = i3;
        final boolean z3 = z;
        final boolean z4 = z2;
        C67822 c67822 = new C5039bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(91088);
                Boolean valueOf = Boolean.valueOf(C45663ac.this.mo73445b(view2, i4, i5, fArr2, i6, z3, z4));
                AppMethodBeat.m2505o(91088);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) c67822.mo10372b(null)).booleanValue();
            AppMethodBeat.m2505o(91100);
            return booleanValue;
        }
        booleanValue = ((Boolean) c67822.mo10372b(this.mHandler)).booleanValue();
        AppMethodBeat.m2505o(91100);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo73445b(View view, int i, int i2, float[] fArr, int i3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(91101);
        if (view == null || fArr == null || fArr.length < 5) {
            AppMethodBeat.m2505o(91101);
            return false;
        }
        ViewGroup I = mo73438I(i2, z2);
        if (I == null) {
            AppMethodBeat.m2505o(91101);
            return false;
        } else if (mo73454q(i) != null) {
            AppMethodBeat.m2505o(91101);
            return false;
        } else {
            int i4;
            float f;
            float f2;
            float f3 = fArr[0];
            float f4 = fArr[1];
            int i5 = (int) fArr[4];
            LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
            int dj = m84318dj(i2, i5);
            if (dj < 0) {
                i4 = 0;
            } else {
                i4 = dj;
            }
            if (I instanceof C38287n) {
                dj = ((C38287n) I).getTargetViewChildCount();
            } else {
                dj = I.getChildCount();
            }
            if (i4 > dj) {
                i4 = dj;
            }
            if (i3 >= 0) {
                view.setVisibility(i3 == 0 ? 0 : 4);
            }
            I.addView(view, i4, layoutParams);
            C33466b c33466b = new C33466b(view, i, i2, i5, z, z2);
            this.iut.add(c33466b);
            if (i2 == 0 && (I instanceof C2408ao) && z) {
                C10660a c10660a = new C10660a();
                c10660a.view = view;
                c10660a.f2877x = f3;
                c10660a.f2878y = f4;
                c10660a.iuK = (float) this.ius.getScrollX();
                c10660a.iuL = (float) this.ius.getScrollY();
                f = f3 + c10660a.iuK;
                float f5 = c10660a.iuL + f4;
                ((C2408ao) I).mo6319a(c10660a);
                c33466b.iuP = c10660a;
                f2 = f5;
            } else {
                f2 = f4;
                f = f3;
            }
            view.setX(f);
            view.setY(f2);
            AppMethodBeat.m2505o(91101);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: I */
    public final ViewGroup mo73438I(int i, boolean z) {
        AppMethodBeat.m2504i(91102);
        ViewGroup aKf;
        if (z) {
            aKf = aKf();
            AppMethodBeat.m2505o(91102);
            return aKf;
        } else if (i == 0) {
            aKf = this.ius;
            AppMethodBeat.m2505o(91102);
            return aKf;
        } else {
            C33466b py = mo73452py(i);
            if (py == null) {
                AppMethodBeat.m2505o(91102);
                return null;
            }
            View view = (View) py.iuM.get();
            if ((view instanceof WrapperNativeContainerView) && (view instanceof C45592o) && (view instanceof ViewGroup)) {
                aKf = (ViewGroup) ((WrapperNativeContainerView) view).mo60996ah(AppBrandNativeContainerView.class);
                AppMethodBeat.m2505o(91102);
                return aKf;
            } else if ((view instanceof C45592o) && (view instanceof ViewGroup)) {
                aKf = (ViewGroup) view;
                AppMethodBeat.m2505o(91102);
                return aKf;
            } else {
                AppMethodBeat.m2505o(91102);
                return null;
            }
        }
    }

    /* renamed from: pv */
    public final boolean mo73450pv(final int i) {
        AppMethodBeat.m2504i(91103);
        C67833 c67833 = new C5039bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(91089);
                Boolean valueOf = Boolean.valueOf(C45663ac.this.mo73451pw(i));
                AppMethodBeat.m2505o(91089);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) c67833.mo10372b(null)).booleanValue();
            AppMethodBeat.m2505o(91103);
            return booleanValue;
        }
        booleanValue = ((Boolean) c67833.mo10372b(this.mHandler)).booleanValue();
        AppMethodBeat.m2505o(91103);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pw */
    public final boolean mo73451pw(int i) {
        AppMethodBeat.m2504i(91104);
        C33466b py = mo73452py(i);
        if (py == null) {
            AppMethodBeat.m2505o(91104);
            return false;
        }
        mo73449pD(i);
        m84316a(py);
        ViewGroup I = mo73438I(py.iuN, py.hfz);
        if (I != null) {
            this.iut.remove(py);
            I.removeView((View) py.iuM.get());
            if (py.iuN == 0 && (I instanceof C2408ao) && py.iuO) {
                ((C2408ao) I).mo6320b(py.iuP);
            }
            AppMethodBeat.m2505o(91104);
            return true;
        }
        AppMethodBeat.m2505o(91104);
        return false;
    }

    public final void removeAll() {
        AppMethodBeat.m2504i(91105);
        C67844 c67844 = new C5039bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(91091);
                Boolean aKg = aKg();
                AppMethodBeat.m2505o(91091);
                return aKg;
            }

            private Boolean aKg() {
                AppMethodBeat.m2504i(91090);
                try {
                    C45663ac c45663ac = C45663ac.this;
                    LinkedList linkedList = new LinkedList();
                    for (C33466b add : c45663ac.iut) {
                        linkedList.add(add);
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        c45663ac.mo73451pw(((C33466b) it.next()).f15035id);
                    }
                    linkedList.clear();
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error ".concat(String.valueOf(e)));
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.m2505o(91090);
                return bool;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c67844.mo10372b(null);
        }
        c67844.mo10372b(this.mHandler);
        AppMethodBeat.m2505o(91105);
    }

    /* renamed from: a */
    public final boolean mo73442a(int i, float[] fArr, int i2, Boolean bool, Boolean bool2) {
        AppMethodBeat.m2504i(91106);
        final int i3 = i;
        final float[] fArr2 = fArr;
        final int i4 = i2;
        final Boolean bool3 = bool;
        final Boolean bool4 = bool2;
        C67855 c67855 = new C5039bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(91092);
                Boolean valueOf = Boolean.valueOf(C45663ac.this.mo73444b(i3, fArr2, i4, bool3, bool4));
                AppMethodBeat.m2505o(91092);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) c67855.mo10372b(null)).booleanValue();
            AppMethodBeat.m2505o(91106);
            return booleanValue;
        }
        booleanValue = ((Boolean) c67855.mo10372b(this.mHandler)).booleanValue();
        AppMethodBeat.m2505o(91106);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final boolean mo73444b(int i, float[] fArr, int i2, Boolean bool, Boolean bool2) {
        AppMethodBeat.m2504i(91107);
        if (mo73447pB(i)) {
            AppMethodBeat.m2505o(91107);
            return true;
        }
        C33466b py = mo73452py(i);
        if (py == null) {
            AppMethodBeat.m2505o(91107);
            return false;
        }
        View view = (View) py.iuM.get();
        boolean booleanValue = bool2 != null ? bool2.booleanValue() : py.hfz;
        ViewGroup I = mo73438I(py.iuN, booleanValue);
        if (I == null) {
            AppMethodBeat.m2505o(91107);
            return false;
        }
        if (i2 >= 0) {
            view.setVisibility(i2 == 0 ? 0 : 4);
        }
        if (fArr == null || fArr.length < 5) {
            AppMethodBeat.m2505o(91107);
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        boolean booleanValue2 = bool != null ? bool.booleanValue() : py.iuO;
        if (py.f15036z == i3 && py.hfz == booleanValue) {
            C10660a c10660a;
            float f5;
            float f6;
            LayoutParams layoutParams;
            C2409a c2409a = py.iuP;
            if (py.iuN == 0 && (I instanceof C2408ao) && booleanValue2 != py.iuO) {
                if (booleanValue2) {
                    if (c2409a == null) {
                        c10660a = new C10660a();
                        c10660a.view = view;
                        py.iuP = c10660a;
                        c2409a = c10660a;
                    }
                    ((C2408ao) I).mo6319a(c2409a);
                    c10660a = c2409a;
                    if (c10660a == null) {
                        c10660a.f2877x = f;
                        c10660a.f2878y = f2;
                        c10660a.iuK = (float) this.ius.getScrollX();
                        c10660a.iuL = (float) this.ius.getScrollY();
                        f5 = c10660a.iuK + f;
                        f6 = c10660a.iuL + f2;
                    } else {
                        f6 = f2;
                        f5 = f;
                    }
                    layoutParams = view.getLayoutParams();
                    layoutParams.width = (int) f3;
                    layoutParams.height = (int) f4;
                    view.setX(f5);
                    view.setY(f6);
                    view.requestLayout();
                    i3 = I.indexOfChild(this.iuw);
                    if (I.indexOfChild(view) == -1 && i3 != -1) {
                        I.addView(view, i3);
                        I.removeView(this.iuw);
                    }
                    AppMethodBeat.m2505o(91107);
                    return true;
                }
                ((C2408ao) I).mo6320b(py.iuP);
            }
            C2409a c2409a2 = c2409a;
            if (c10660a == null) {
            }
            layoutParams = view.getLayoutParams();
            layoutParams.width = (int) f3;
            layoutParams.height = (int) f4;
            view.setX(f5);
            view.setY(f6);
            view.requestLayout();
            i3 = I.indexOfChild(this.iuw);
            I.addView(view, i3);
            I.removeView(this.iuw);
            AppMethodBeat.m2505o(91107);
            return true;
        }
        this.iut.remove(py);
        I.removeView(view);
        if (view.getParent() != null) {
            if (py.iuP != null && (view.getParent() instanceof C2408ao)) {
                ((C2408ao) view.getParent()).mo6320b(py.iuP);
            }
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (mo73445b(view, i, py.iuN, fArr, i2, booleanValue2, booleanValue)) {
            AppMethodBeat.m2505o(91107);
            return true;
        }
        m84316a(py);
        AppMethodBeat.m2505o(91107);
        return false;
    }

    /* renamed from: a */
    private void m84316a(C33466b c33466b) {
        AppMethodBeat.m2504i(91108);
        this.iut.removeAll(m84317b(c33466b));
        AppMethodBeat.m2505o(91108);
    }

    /* renamed from: b */
    private List<C33466b> m84317b(C33466b c33466b) {
        AppMethodBeat.m2504i(91109);
        LinkedList linkedList = new LinkedList();
        for (C33466b c33466b2 : this.iut) {
            if (c33466b2.iuN == c33466b.f15035id) {
                linkedList.addAll(m84317b(c33466b2));
            }
        }
        linkedList.add(c33466b);
        AppMethodBeat.m2505o(91109);
        return linkedList;
    }

    /* renamed from: dj */
    private int m84318dj(int i, int i2) {
        AppMethodBeat.m2504i(91110);
        int i3 = 0;
        Iterator it = this.iut.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                C33466b c33466b = (C33466b) it.next();
                if (i == c33466b.iuN && i2 >= c33466b.f15036z) {
                    i4++;
                }
                i3 = i4;
            } else {
                AppMethodBeat.m2505o(91110);
                return i4;
            }
        }
    }

    /* renamed from: py */
    public final C33466b mo73452py(int i) {
        AppMethodBeat.m2504i(91111);
        for (C33466b c33466b : this.iut) {
            if (c33466b.f15035id == i) {
                AppMethodBeat.m2505o(91111);
                return c33466b;
            }
        }
        AppMethodBeat.m2505o(91111);
        return null;
    }

    /* renamed from: pz */
    public final boolean mo73453pz(int i) {
        AppMethodBeat.m2504i(91112);
        if (mo73452py(i) != null) {
            AppMethodBeat.m2505o(91112);
            return true;
        }
        AppMethodBeat.m2505o(91112);
        return false;
    }

    /* renamed from: q */
    public final View mo73454q(int i) {
        AppMethodBeat.m2504i(91113);
        C33466b py = mo73452py(i);
        if (py == null) {
            AppMethodBeat.m2505o(91113);
            return null;
        }
        View view = (View) py.iuM.get();
        AppMethodBeat.m2505o(91113);
        return view;
    }

    /* renamed from: pA */
    public final C32800b mo73446pA(int i) {
        AppMethodBeat.m2504i(91114);
        C32800b nV = C37922v.m64076Zp().mo60674nV(hashCode() + "#" + i);
        AppMethodBeat.m2505o(91114);
        return nV;
    }

    /* renamed from: J */
    public final C32800b mo73439J(int i, boolean z) {
        AppMethodBeat.m2504i(91115);
        C32800b y = C37922v.m64076Zp().mo60676y(hashCode() + "#" + i, z);
        AppMethodBeat.m2505o(91115);
        return y;
    }

    /* renamed from: pB */
    public final boolean mo73447pB(int i) {
        return this.iuy == i || this.iuu == i;
    }

    /* renamed from: a */
    public final boolean mo73441a(int i, C38462an c38462an, int i2) {
        AppMethodBeat.m2504i(91116);
        final int i3 = i;
        final C38462an c38462an2 = c38462an;
        final int i4 = i2;
        C67866 c67866 = new C5039bj<Boolean>(Boolean.FALSE) {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object run() {
                boolean z;
                AppMethodBeat.m2504i(91093);
                C45663ac c45663ac = C45663ac.this;
                int i = i3;
                C38462an c38462an = c38462an2;
                int i2 = i4;
                if (i == c45663ac.iuu) {
                    z = false;
                } else {
                    C33466b py = c45663ac.mo73452py(i);
                    if (py == null || py.iuM == null) {
                        z = false;
                    } else {
                        View view = (View) py.iuM.get();
                        if (view == null) {
                            z = false;
                        } else {
                            C33466b py2;
                            c45663ac.iuy = i;
                            ViewGroup I = c45663ac.mo73438I(py.iuN, false);
                            if ((I instanceof AppBrandNativeContainerView) && ((AppBrandNativeContainerView) I).hIN) {
                                py2 = c45663ac.mo73452py(py.iuN);
                                if (py2 != null) {
                                    ViewGroup I2 = c45663ac.mo73438I(py2.iuN, false);
                                    if (I2 != null) {
                                        View view2 = (View) py.iuM.get();
                                        if (view2 != null) {
                                            LayoutParams layoutParams = view2.getLayoutParams();
                                            layoutParams.width = -1;
                                            layoutParams.height = -1;
                                            view2.setLayoutParams(layoutParams);
                                        }
                                        c45663ac.iuy = py2.f15035id;
                                        I = I2;
                                        if (I != null) {
                                            view = (View) py2.iuM.get();
                                            int indexOfChild = I.indexOfChild(view);
                                            if (c45663ac.iuw != null) {
                                                ViewGroup viewGroup = (ViewGroup) c45663ac.iuw.getParent();
                                                if (viewGroup != null) {
                                                    viewGroup.removeView(c45663ac.iuw);
                                                }
                                            }
                                            I.addView(c45663ac.iuw, indexOfChild);
                                            I.removeView(view);
                                        }
                                        c45663ac.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) py2.f15036z};
                                        c45663ac.isR.mo61148G(view, i2);
                                        c45663ac.iuu = i;
                                        c45663ac.iux = c38462an;
                                        z = true;
                                    }
                                }
                            }
                            py2 = py;
                            if (I != null) {
                            }
                            c45663ac.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) py2.f15036z};
                            c45663ac.isR.mo61148G(view, i2);
                            c45663ac.iuu = i;
                            c45663ac.iux = c38462an;
                            z = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.m2505o(91093);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) c67866.mo10372b(null)).booleanValue();
            AppMethodBeat.m2505o(91116);
            return booleanValue;
        }
        booleanValue = ((Boolean) c67866.mo10372b(this.mHandler)).booleanValue();
        AppMethodBeat.m2505o(91116);
        return booleanValue;
    }

    /* renamed from: pC */
    public final boolean mo73448pC(final int i) {
        AppMethodBeat.m2504i(91117);
        C334657 c334657 = new C5039bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(91094);
                Boolean valueOf = Boolean.valueOf(C45663ac.this.mo73449pD(i));
                AppMethodBeat.m2505o(91094);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) c334657.mo10372b(null)).booleanValue();
            AppMethodBeat.m2505o(91117);
            return booleanValue;
        }
        booleanValue = ((Boolean) c334657.mo10372b(this.mHandler)).booleanValue();
        AppMethodBeat.m2505o(91117);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pD */
    public final boolean mo73449pD(int i) {
        AppMethodBeat.m2504i(91118);
        if (i != this.iuu) {
            AppMethodBeat.m2505o(91118);
            return false;
        } else if (mo73452py(i) == null) {
            AppMethodBeat.m2505o(91118);
            return false;
        } else {
            this.isR.aIZ();
            AppMethodBeat.m2505o(91118);
            return true;
        }
    }

    private ViewGroup aKf() {
        AppMethodBeat.m2504i(138261);
        if (this.iuA == null) {
            this.iuA = new AppBrandPageFullScreenView(this.ius.getContext());
            if (this.iuz != null) {
                this.iuz.mo22214a(this.iuA);
            }
        }
        AppBrandPageFullScreenView appBrandPageFullScreenView = this.iuA;
        AppMethodBeat.m2505o(138261);
        return appBrandPageFullScreenView;
    }
}
