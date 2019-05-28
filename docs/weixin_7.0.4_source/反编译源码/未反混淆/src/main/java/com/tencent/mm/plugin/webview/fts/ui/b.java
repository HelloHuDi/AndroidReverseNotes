package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private MMWebView fow;
    List<a> iut;
    public int iuu = -1;
    public float[] iuv;
    View iuw;
    public int iuy = -1;
    public ak mHandler;
    public com.tencent.mm.plugin.webview.fts.c.a uhu;
    com.tencent.mm.plugin.webview.fts.c.b.b uhv;

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$5 */
    public class AnonymousClass5 extends bj<Boolean> {
        final /* synthetic */ int hCN;

        public AnonymousClass5(Boolean bool, int i) {
            this.hCN = i;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.i(5916);
            Boolean valueOf = Boolean.valueOf(b.this.pD(this.hCN));
            AppMethodBeat.o(5916);
            return valueOf;
        }
    }

    public static class a {
        int id;
        public WeakReference<View> iuM;
        int iuN;
        int z;

        public a(View view, int i, int i2, int i3) {
            AppMethodBeat.i(5917);
            this.iuM = new WeakReference(view);
            this.id = i;
            this.iuN = i2;
            this.z = i3;
            AppMethodBeat.o(5917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$3 */
    public class AnonymousClass3 extends bj<Boolean> {
        final /* synthetic */ int auD;
        final /* synthetic */ int hCN;
        final /* synthetic */ float[] iuD;

        public AnonymousClass3(Boolean bool, int i, float[] fArr, int i2) {
            this.hCN = i;
            this.iuD = fArr;
            this.auD = i2;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.i(5914);
            Boolean valueOf = Boolean.valueOf(b.this.a(this.hCN, this.iuD, this.auD));
            AppMethodBeat.o(5914);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$2 */
    public class AnonymousClass2 extends bj<Boolean> {
        final /* synthetic */ int hCN;

        public AnonymousClass2(Boolean bool, int i) {
            this.hCN = i;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            boolean z;
            Boolean valueOf;
            AppMethodBeat.i(5913);
            b bVar = b.this;
            int i = this.hCN;
            a IC = bVar.IC(i);
            if (IC != null) {
                bVar.pD(i);
                bVar.a(IC);
                ViewGroup IB = bVar.IB(IC.iuN);
                if (IB != null) {
                    bVar.iut.remove(IC);
                    IB.removeView((View) IC.iuM.get());
                    z = true;
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(5913);
                    return valueOf;
                }
            }
            z = false;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(5913);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$4 */
    public class AnonymousClass4 extends bj<Boolean> {
        final /* synthetic */ int hCN;
        final /* synthetic */ com.tencent.mm.plugin.webview.fts.c.a uhx;
        final /* synthetic */ boolean uhy;

        public AnonymousClass4(Boolean bool, int i, com.tencent.mm.plugin.webview.fts.c.a aVar, boolean z) {
            this.hCN = i;
            this.uhx = aVar;
            this.uhy = z;
            super(1000, bool, (byte) 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object run() {
            boolean z;
            AppMethodBeat.i(5915);
            b bVar = b.this;
            int i = this.hCN;
            com.tencent.mm.plugin.webview.fts.c.a aVar = this.uhx;
            boolean z2 = this.uhy;
            if (i == bVar.iuu) {
                z = false;
            } else {
                a IC = bVar.IC(i);
                if (IC == null || IC.iuM == null) {
                    z = false;
                } else {
                    View view = (View) IC.iuM.get();
                    if (view == null) {
                        z = false;
                    } else {
                        bVar.iuy = i;
                        ViewGroup IB = bVar.IB(IC.iuN);
                        a IC2 = bVar.IC(IC.iuN);
                        if (IC2 != null) {
                            ViewGroup IB2 = bVar.IB(IC2.iuN);
                            if (IB2 != null) {
                                View view2 = (View) IC.iuM.get();
                                if (view2 != null) {
                                    LayoutParams layoutParams = view2.getLayoutParams();
                                    layoutParams.width = -1;
                                    layoutParams.height = -1;
                                    view2.setLayoutParams(layoutParams);
                                }
                                bVar.iuy = IC2.id;
                                IB = IB2;
                                if (IB != null) {
                                    view = (View) IC2.iuM.get();
                                    IB.addView(bVar.iuw, IB.indexOfChild(view));
                                    IB.removeView(view);
                                }
                                bVar.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) IC2.z};
                                bVar.uhv.s(view, z2);
                                bVar.iuu = i;
                                bVar.uhu = aVar;
                                z = true;
                            }
                        }
                        IC2 = IC;
                        if (IB != null) {
                        }
                        bVar.iuv = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) IC2.z};
                        bVar.uhv.s(view, z2);
                        bVar.iuu = i;
                        bVar.uhu = aVar;
                        z = true;
                    }
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(5915);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$1 */
    public class AnonymousClass1 extends bj<Boolean> {
        final /* synthetic */ int auD;
        final /* synthetic */ int hCN;
        final /* synthetic */ int iuC = 0;
        final /* synthetic */ float[] iuD;
        final /* synthetic */ View val$view;

        public AnonymousClass1(Boolean bool, View view, int i, float[] fArr, int i2) {
            this.val$view = view;
            this.hCN = i;
            this.iuD = fArr;
            this.auD = i2;
            super(1000, bool, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.i(5912);
            Boolean valueOf = Boolean.valueOf(b.this.a(this.val$view, this.hCN, this.iuC, this.iuD, this.auD));
            AppMethodBeat.o(5912);
            return valueOf;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public b(MMWebView mMWebView, com.tencent.mm.plugin.webview.fts.c.b.b bVar) {
        AppMethodBeat.i(5918);
        this.fow = mMWebView;
        this.mHandler = new ak(Looper.getMainLooper());
        this.iut = new LinkedList();
        this.iuw = new View(mMWebView.getContext());
        this.uhv = bVar;
        AppMethodBeat.o(5918);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(View view, int i, int i2, float[] fArr, int i3) {
        int i4 = 0;
        AppMethodBeat.i(5919);
        if (view == null || fArr == null || fArr.length < 5) {
            AppMethodBeat.o(5919);
            return false;
        }
        ViewGroup IB = IB(i2);
        if (IB == null) {
            AppMethodBeat.o(5919);
            return false;
        } else if (q(i) != null) {
            AppMethodBeat.o(5919);
            return false;
        } else {
            float f = fArr[0];
            float f2 = fArr[1];
            int i5 = (int) fArr[4];
            LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
            int dj = dj(i2, i5);
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
            c(view, i, i2, i5);
            AppMethodBeat.o(5919);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final ViewGroup IB(int i) {
        AppMethodBeat.i(5920);
        ViewGroup topView;
        if (i == 0) {
            topView = this.fow.getTopView();
            if (topView instanceof AbsoluteLayout) {
                AppMethodBeat.o(5920);
                return topView;
            }
            AppMethodBeat.o(5920);
            return null;
        }
        a IC = IC(i);
        if (IC == null) {
            AppMethodBeat.o(5920);
            return null;
        }
        View view = (View) IC.iuM.get();
        if (view instanceof ViewGroup) {
            topView = (ViewGroup) view;
            AppMethodBeat.o(5920);
            return topView;
        }
        AppMethodBeat.o(5920);
        return null;
    }

    public final boolean a(int i, float[] fArr, int i2) {
        AppMethodBeat.i(5921);
        if (pB(i)) {
            AppMethodBeat.o(5921);
            return true;
        }
        a IC = IC(i);
        if (IC == null) {
            AppMethodBeat.o(5921);
            return false;
        }
        View view = (View) IC.iuM.get();
        ViewGroup IB = IB(IC.iuN);
        if (IB == null) {
            AppMethodBeat.o(5921);
            return false;
        }
        if (i2 >= 0 && i2 != BaseClientBuilder.API_PRIORITY_OTHER) {
            view.setVisibility(i2 == 0 ? 0 : 8);
        }
        if (fArr == null || fArr.length < 5) {
            AppMethodBeat.o(5921);
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        this.iut.remove(IC);
        if (IC.z != i3) {
            IB.removeView(view);
            if (a(view, i, IC.iuN, fArr, i2)) {
                AppMethodBeat.o(5921);
                return true;
            }
            a(IC);
            AppMethodBeat.o(5921);
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
        c(view, i, IC.iuN, i3);
        int indexOfChild = IB.indexOfChild(this.iuw);
        if (IB.indexOfChild(view) == -1 && indexOfChild != -1) {
            IB.addView(view, indexOfChild);
            IB.removeView(this.iuw);
        }
        AppMethodBeat.o(5921);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        AppMethodBeat.i(5922);
        this.iut.removeAll(b(aVar));
        AppMethodBeat.o(5922);
    }

    private List<a> b(a aVar) {
        AppMethodBeat.i(5923);
        LinkedList linkedList = new LinkedList();
        for (a aVar2 : this.iut) {
            if (aVar2.iuN == aVar.id) {
                linkedList.addAll(b(aVar2));
            }
        }
        linkedList.add(aVar);
        AppMethodBeat.o(5923);
        return linkedList;
    }

    private int dj(int i, int i2) {
        AppMethodBeat.i(5924);
        int i3 = 0;
        Iterator it = this.iut.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                a aVar = (a) it.next();
                if (i == aVar.iuN && i2 >= aVar.z) {
                    i4++;
                }
                i3 = i4;
            } else {
                AppMethodBeat.o(5924);
                return i4;
            }
        }
    }

    public final a IC(int i) {
        AppMethodBeat.i(5925);
        for (a aVar : this.iut) {
            if (aVar.id == i) {
                AppMethodBeat.o(5925);
                return aVar;
            }
        }
        AppMethodBeat.o(5925);
        return null;
    }

    public final View q(int i) {
        AppMethodBeat.i(5926);
        a IC = IC(i);
        if (IC == null) {
            AppMethodBeat.o(5926);
            return null;
        }
        View view = (View) IC.iuM.get();
        AppMethodBeat.o(5926);
        return view;
    }

    private void c(View view, int i, int i2, int i3) {
        AppMethodBeat.i(5927);
        this.iut.add(new a(view, i, i2, i3));
        AppMethodBeat.o(5927);
    }

    public final boolean pB(int i) {
        return this.iuy == i || this.iuu == i;
    }

    /* Access modifiers changed, original: final */
    public final boolean pD(int i) {
        AppMethodBeat.i(5928);
        if (i != this.iuu) {
            AppMethodBeat.o(5928);
            return false;
        } else if (IC(i) == null) {
            AppMethodBeat.o(5928);
            return false;
        } else {
            this.uhv.cWA();
            AppMethodBeat.o(5928);
            return true;
        }
    }
}
