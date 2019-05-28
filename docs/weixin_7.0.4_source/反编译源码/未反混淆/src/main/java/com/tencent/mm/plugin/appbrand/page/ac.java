package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.container.WrapperNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.n;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ac {
    c isR;
    private AppBrandPageFullScreenView iuA;
    public ViewGroup ius;
    List<b> iut;
    int iuu = -1;
    float[] iuv;
    View iuw;
    an iux;
    int iuy = -1;
    private ak iuz;
    private ak mHandler;

    static final class a implements com.tencent.mm.plugin.appbrand.page.ao.a {
        float iuK;
        float iuL;
        View view;
        float x;
        float y;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void dk(int i, int i2) {
            AppMethodBeat.i(91095);
            this.iuK = (float) i;
            this.iuL = (float) i2;
            this.view.setX(this.x + ((float) i));
            this.view.setY(this.y + ((float) i2));
            AppMethodBeat.o(91095);
        }
    }

    public static class b {
        boolean hfz;
        int id;
        WeakReference<View> iuM;
        public int iuN;
        boolean iuO;
        a iuP;
        int z;

        public b(View view, int i, int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(91096);
            this.iuM = new WeakReference(view);
            this.id = i;
            this.iuN = i2;
            this.z = i3;
            this.iuO = z;
            this.hfz = z2;
            AppMethodBeat.o(91096);
        }
    }

    public ac(ViewGroup viewGroup) {
        AppMethodBeat.i(91097);
        this.ius = viewGroup;
        this.mHandler = new ak(Looper.getMainLooper());
        this.iut = new LinkedList();
        this.iuw = new View(viewGroup.getContext());
        AppMethodBeat.o(91097);
    }

    public final void setFullscreenImpl(c cVar) {
        AppMethodBeat.i(91098);
        this.isR = cVar;
        this.isR.a(new ai() {
            public final void aDI() {
                AppMethodBeat.i(91087);
                ac acVar = ac.this;
                b py = acVar.py(acVar.iuy);
                float[] fArr = acVar.iuv;
                if (!(py == null || py.iuM == null || fArr == null)) {
                    View view = (View) py.iuM.get();
                    if (view != null) {
                        if (acVar.iuy != acVar.iuu) {
                            b py2 = acVar.py(acVar.iuu);
                            if (!(py2 == null || py2.iuM == null)) {
                                View view2 = (View) py2.iuM.get();
                                if (view2 != null) {
                                    acVar.b(acVar.iuu, fArr, view2.getVisibility(), Boolean.valueOf(py.iuO), Boolean.FALSE);
                                }
                            }
                        }
                        int i = acVar.iuy;
                        acVar.iuu = -1;
                        acVar.iuy = -1;
                        acVar.b(i, fArr, view.getVisibility(), Boolean.valueOf(py.iuO), Boolean.FALSE);
                    }
                }
                if (ac.this.iux != null) {
                    ac.this.iux.aDI();
                    ac.this.iux = null;
                }
                AppMethodBeat.o(91087);
            }
        });
        AppMethodBeat.o(91098);
    }

    public final void a(ak akVar) {
        AppMethodBeat.i(138260);
        ab.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setFullScreenViewObtainer fullScreenViewAttacher:%b", Boolean.TRUE);
        this.iuz = akVar;
        if (this.iuA != null) {
            this.iuz.a(this.iuA);
        }
        AppMethodBeat.o(138260);
    }

    public final boolean a(View view, int i, int i2, float[] fArr, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(91100);
        final View view2 = view;
        final int i4 = i;
        final int i5 = i2;
        final float[] fArr2 = fArr;
        final int i6 = i3;
        final boolean z3 = z;
        final boolean z4 = z2;
        AnonymousClass2 anonymousClass2 = new bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(91088);
                Boolean valueOf = Boolean.valueOf(ac.this.b(view2, i4, i5, fArr2, i6, z3, z4));
                AppMethodBeat.o(91088);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) anonymousClass2.b(null)).booleanValue();
            AppMethodBeat.o(91100);
            return booleanValue;
        }
        booleanValue = ((Boolean) anonymousClass2.b(this.mHandler)).booleanValue();
        AppMethodBeat.o(91100);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(View view, int i, int i2, float[] fArr, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(91101);
        if (view == null || fArr == null || fArr.length < 5) {
            AppMethodBeat.o(91101);
            return false;
        }
        ViewGroup I = I(i2, z2);
        if (I == null) {
            AppMethodBeat.o(91101);
            return false;
        } else if (q(i) != null) {
            AppMethodBeat.o(91101);
            return false;
        } else {
            int i4;
            float f;
            float f2;
            float f3 = fArr[0];
            float f4 = fArr[1];
            int i5 = (int) fArr[4];
            LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
            int dj = dj(i2, i5);
            if (dj < 0) {
                i4 = 0;
            } else {
                i4 = dj;
            }
            if (I instanceof n) {
                dj = ((n) I).getTargetViewChildCount();
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
            b bVar = new b(view, i, i2, i5, z, z2);
            this.iut.add(bVar);
            if (i2 == 0 && (I instanceof ao) && z) {
                a aVar = new a();
                aVar.view = view;
                aVar.x = f3;
                aVar.y = f4;
                aVar.iuK = (float) this.ius.getScrollX();
                aVar.iuL = (float) this.ius.getScrollY();
                f = f3 + aVar.iuK;
                float f5 = aVar.iuL + f4;
                ((ao) I).a(aVar);
                bVar.iuP = aVar;
                f2 = f5;
            } else {
                f2 = f4;
                f = f3;
            }
            view.setX(f);
            view.setY(f2);
            AppMethodBeat.o(91101);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final ViewGroup I(int i, boolean z) {
        AppMethodBeat.i(91102);
        ViewGroup aKf;
        if (z) {
            aKf = aKf();
            AppMethodBeat.o(91102);
            return aKf;
        } else if (i == 0) {
            aKf = this.ius;
            AppMethodBeat.o(91102);
            return aKf;
        } else {
            b py = py(i);
            if (py == null) {
                AppMethodBeat.o(91102);
                return null;
            }
            View view = (View) py.iuM.get();
            if ((view instanceof WrapperNativeContainerView) && (view instanceof o) && (view instanceof ViewGroup)) {
                aKf = (ViewGroup) ((WrapperNativeContainerView) view).ah(AppBrandNativeContainerView.class);
                AppMethodBeat.o(91102);
                return aKf;
            } else if ((view instanceof o) && (view instanceof ViewGroup)) {
                aKf = (ViewGroup) view;
                AppMethodBeat.o(91102);
                return aKf;
            } else {
                AppMethodBeat.o(91102);
                return null;
            }
        }
    }

    public final boolean pv(final int i) {
        AppMethodBeat.i(91103);
        AnonymousClass3 anonymousClass3 = new bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(91089);
                Boolean valueOf = Boolean.valueOf(ac.this.pw(i));
                AppMethodBeat.o(91089);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) anonymousClass3.b(null)).booleanValue();
            AppMethodBeat.o(91103);
            return booleanValue;
        }
        booleanValue = ((Boolean) anonymousClass3.b(this.mHandler)).booleanValue();
        AppMethodBeat.o(91103);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    public final boolean pw(int i) {
        AppMethodBeat.i(91104);
        b py = py(i);
        if (py == null) {
            AppMethodBeat.o(91104);
            return false;
        }
        pD(i);
        a(py);
        ViewGroup I = I(py.iuN, py.hfz);
        if (I != null) {
            this.iut.remove(py);
            I.removeView((View) py.iuM.get());
            if (py.iuN == 0 && (I instanceof ao) && py.iuO) {
                ((ao) I).b(py.iuP);
            }
            AppMethodBeat.o(91104);
            return true;
        }
        AppMethodBeat.o(91104);
        return false;
    }

    public final void removeAll() {
        AppMethodBeat.i(91105);
        AnonymousClass4 anonymousClass4 = new bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(91091);
                Boolean aKg = aKg();
                AppMethodBeat.o(91091);
                return aKg;
            }

            private Boolean aKg() {
                AppMethodBeat.i(91090);
                try {
                    ac acVar = ac.this;
                    LinkedList linkedList = new LinkedList();
                    for (b add : acVar.iut) {
                        linkedList.add(add);
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        acVar.pw(((b) it.next()).id);
                    }
                    linkedList.clear();
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error ".concat(String.valueOf(e)));
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(91090);
                return bool;
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            anonymousClass4.b(null);
        }
        anonymousClass4.b(this.mHandler);
        AppMethodBeat.o(91105);
    }

    public final boolean a(int i, float[] fArr, int i2, Boolean bool, Boolean bool2) {
        AppMethodBeat.i(91106);
        final int i3 = i;
        final float[] fArr2 = fArr;
        final int i4 = i2;
        final Boolean bool3 = bool;
        final Boolean bool4 = bool2;
        AnonymousClass5 anonymousClass5 = new bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(91092);
                Boolean valueOf = Boolean.valueOf(ac.this.b(i3, fArr2, i4, bool3, bool4));
                AppMethodBeat.o(91092);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) anonymousClass5.b(null)).booleanValue();
            AppMethodBeat.o(91106);
            return booleanValue;
        }
        booleanValue = ((Boolean) anonymousClass5.b(this.mHandler)).booleanValue();
        AppMethodBeat.o(91106);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int i, float[] fArr, int i2, Boolean bool, Boolean bool2) {
        AppMethodBeat.i(91107);
        if (pB(i)) {
            AppMethodBeat.o(91107);
            return true;
        }
        b py = py(i);
        if (py == null) {
            AppMethodBeat.o(91107);
            return false;
        }
        View view = (View) py.iuM.get();
        boolean booleanValue = bool2 != null ? bool2.booleanValue() : py.hfz;
        ViewGroup I = I(py.iuN, booleanValue);
        if (I == null) {
            AppMethodBeat.o(91107);
            return false;
        }
        if (i2 >= 0) {
            view.setVisibility(i2 == 0 ? 0 : 4);
        }
        if (fArr == null || fArr.length < 5) {
            AppMethodBeat.o(91107);
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        boolean booleanValue2 = bool != null ? bool.booleanValue() : py.iuO;
        if (py.z == i3 && py.hfz == booleanValue) {
            a aVar;
            float f5;
            float f6;
            LayoutParams layoutParams;
            com.tencent.mm.plugin.appbrand.page.ao.a aVar2 = py.iuP;
            if (py.iuN == 0 && (I instanceof ao) && booleanValue2 != py.iuO) {
                if (booleanValue2) {
                    if (aVar2 == null) {
                        aVar = new a();
                        aVar.view = view;
                        py.iuP = aVar;
                        aVar2 = aVar;
                    }
                    ((ao) I).a(aVar2);
                    aVar = aVar2;
                    if (aVar == null) {
                        aVar.x = f;
                        aVar.y = f2;
                        aVar.iuK = (float) this.ius.getScrollX();
                        aVar.iuL = (float) this.ius.getScrollY();
                        f5 = aVar.iuK + f;
                        f6 = aVar.iuL + f2;
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
                    AppMethodBeat.o(91107);
                    return true;
                }
                ((ao) I).b(py.iuP);
            }
            com.tencent.mm.plugin.appbrand.page.ao.a aVar3 = aVar2;
            if (aVar == null) {
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
            AppMethodBeat.o(91107);
            return true;
        }
        this.iut.remove(py);
        I.removeView(view);
        if (view.getParent() != null) {
            if (py.iuP != null && (view.getParent() instanceof ao)) {
                ((ao) view.getParent()).b(py.iuP);
            }
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (b(view, i, py.iuN, fArr, i2, booleanValue2, booleanValue)) {
            AppMethodBeat.o(91107);
            return true;
        }
        a(py);
        AppMethodBeat.o(91107);
        return false;
    }

    private void a(b bVar) {
        AppMethodBeat.i(91108);
        this.iut.removeAll(b(bVar));
        AppMethodBeat.o(91108);
    }

    private List<b> b(b bVar) {
        AppMethodBeat.i(91109);
        LinkedList linkedList = new LinkedList();
        for (b bVar2 : this.iut) {
            if (bVar2.iuN == bVar.id) {
                linkedList.addAll(b(bVar2));
            }
        }
        linkedList.add(bVar);
        AppMethodBeat.o(91109);
        return linkedList;
    }

    private int dj(int i, int i2) {
        AppMethodBeat.i(91110);
        int i3 = 0;
        Iterator it = this.iut.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                b bVar = (b) it.next();
                if (i == bVar.iuN && i2 >= bVar.z) {
                    i4++;
                }
                i3 = i4;
            } else {
                AppMethodBeat.o(91110);
                return i4;
            }
        }
    }

    public final b py(int i) {
        AppMethodBeat.i(91111);
        for (b bVar : this.iut) {
            if (bVar.id == i) {
                AppMethodBeat.o(91111);
                return bVar;
            }
        }
        AppMethodBeat.o(91111);
        return null;
    }

    public final boolean pz(int i) {
        AppMethodBeat.i(91112);
        if (py(i) != null) {
            AppMethodBeat.o(91112);
            return true;
        }
        AppMethodBeat.o(91112);
        return false;
    }

    public final View q(int i) {
        AppMethodBeat.i(91113);
        b py = py(i);
        if (py == null) {
            AppMethodBeat.o(91113);
            return null;
        }
        View view = (View) py.iuM.get();
        AppMethodBeat.o(91113);
        return view;
    }

    public final com.tencent.mm.model.v.b pA(int i) {
        AppMethodBeat.i(91114);
        com.tencent.mm.model.v.b nV = v.Zp().nV(hashCode() + "#" + i);
        AppMethodBeat.o(91114);
        return nV;
    }

    public final com.tencent.mm.model.v.b J(int i, boolean z) {
        AppMethodBeat.i(91115);
        com.tencent.mm.model.v.b y = v.Zp().y(hashCode() + "#" + i, z);
        AppMethodBeat.o(91115);
        return y;
    }

    public final boolean pB(int i) {
        return this.iuy == i || this.iuu == i;
    }

    public final boolean a(int i, an anVar, int i2) {
        AppMethodBeat.i(91116);
        final int i3 = i;
        final an anVar2 = anVar;
        final int i4 = i2;
        AnonymousClass6 anonymousClass6 = new bj<Boolean>(Boolean.FALSE) {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object run() {
                boolean z;
                AppMethodBeat.i(91093);
                ac acVar = ac.this;
                int i = i3;
                an anVar = anVar2;
                int i2 = i4;
                if (i == acVar.iuu) {
                    z = false;
                } else {
                    b py = acVar.py(i);
                    if (py == null || py.iuM == null) {
                        z = false;
                    } else {
                        View view = (View) py.iuM.get();
                        if (view == null) {
                            z = false;
                        } else {
                            b py2;
                            acVar.iuy = i;
                            ViewGroup I = acVar.I(py.iuN, false);
                            if ((I instanceof AppBrandNativeContainerView) && ((AppBrandNativeContainerView) I).hIN) {
                                py2 = acVar.py(py.iuN);
                                if (py2 != null) {
                                    ViewGroup I2 = acVar.I(py2.iuN, false);
                                    if (I2 != null) {
                                        View view2 = (View) py.iuM.get();
                                        if (view2 != null) {
                                            LayoutParams layoutParams = view2.getLayoutParams();
                                            layoutParams.width = -1;
                                            layoutParams.height = -1;
                                            view2.setLayoutParams(layoutParams);
                                        }
                                        acVar.iuy = py2.id;
                                        I = I2;
                                        if (I != null) {
                                            view = (View) py2.iuM.get();
                                            int indexOfChild = I.indexOfChild(view);
                                            if (acVar.iuw != null) {
                                                ViewGroup viewGroup = (ViewGroup) acVar.iuw.getParent();
                                                if (viewGroup != null) {
                                                    viewGroup.removeView(acVar.iuw);
                                                }
                                            }
                                            I.addView(acVar.iuw, indexOfChild);
                                            I.removeView(view);
                                        }
                                        acVar.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) py2.z};
                                        acVar.isR.G(view, i2);
                                        acVar.iuu = i;
                                        acVar.iux = anVar;
                                        z = true;
                                    }
                                }
                            }
                            py2 = py;
                            if (I != null) {
                            }
                            acVar.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) py2.z};
                            acVar.isR.G(view, i2);
                            acVar.iuu = i;
                            acVar.iux = anVar;
                            z = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(91093);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) anonymousClass6.b(null)).booleanValue();
            AppMethodBeat.o(91116);
            return booleanValue;
        }
        booleanValue = ((Boolean) anonymousClass6.b(this.mHandler)).booleanValue();
        AppMethodBeat.o(91116);
        return booleanValue;
    }

    public final boolean pC(final int i) {
        AppMethodBeat.i(91117);
        AnonymousClass7 anonymousClass7 = new bj<Boolean>(Boolean.FALSE) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(91094);
                Boolean valueOf = Boolean.valueOf(ac.this.pD(i));
                AppMethodBeat.o(91094);
                return valueOf;
            }
        };
        boolean booleanValue;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            booleanValue = ((Boolean) anonymousClass7.b(null)).booleanValue();
            AppMethodBeat.o(91117);
            return booleanValue;
        }
        booleanValue = ((Boolean) anonymousClass7.b(this.mHandler)).booleanValue();
        AppMethodBeat.o(91117);
        return booleanValue;
    }

    /* Access modifiers changed, original: final */
    public final boolean pD(int i) {
        AppMethodBeat.i(91118);
        if (i != this.iuu) {
            AppMethodBeat.o(91118);
            return false;
        } else if (py(i) == null) {
            AppMethodBeat.o(91118);
            return false;
        } else {
            this.isR.aIZ();
            AppMethodBeat.o(91118);
            return true;
        }
    }

    private ViewGroup aKf() {
        AppMethodBeat.i(138261);
        if (this.iuA == null) {
            this.iuA = new AppBrandPageFullScreenView(this.ius.getContext());
            if (this.iuz != null) {
                this.iuz.a(this.iuA);
            }
        }
        AppBrandPageFullScreenView appBrandPageFullScreenView = this.iuA;
        AppMethodBeat.o(138261);
        return appBrandPageFullScreenView;
    }
}
