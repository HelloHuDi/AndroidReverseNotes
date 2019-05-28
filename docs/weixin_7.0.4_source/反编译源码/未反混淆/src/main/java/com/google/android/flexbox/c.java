package com.google.android.flexbox;

import android.support.v4.view.f;
import android.support.v4.widget.j;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class c {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
    private final a btt;
    private boolean[] btu;
    int[] btv;
    long[] btw;
    private long[] btx;

    static class a {
        List<b> bty;
        int btz;

        a() {
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.bty = null;
            this.btz = 0;
        }
    }

    static class b implements Comparable<b> {
        int index;
        int order;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            if (this.order != bVar.order) {
                return this.order - bVar.order;
            }
            return this.index - bVar.index;
        }

        public final String toString() {
            AppMethodBeat.i(54679);
            String str = "Order{order=" + this.order + ", index=" + this.index + '}';
            AppMethodBeat.o(54679);
            return str;
        }
    }

    static {
        AppMethodBeat.i(54727);
        AppMethodBeat.o(54727);
    }

    c(a aVar) {
        this.btt = aVar;
    }

    /* Access modifiers changed, original: final */
    public final int[] a(View view, int i, LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        AppMethodBeat.i(54680);
        int flexItemCount = this.btt.getFlexItemCount();
        List eW = eW(flexItemCount);
        b bVar = new b();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            bVar.order = 1;
        } else {
            bVar.order = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount) {
            bVar.index = flexItemCount;
        } else if (i < this.btt.getFlexItemCount()) {
            bVar.index = i;
            while (i < flexItemCount) {
                b bVar2 = (b) eW.get(i);
                bVar2.index++;
                i++;
            }
        } else {
            bVar.index = flexItemCount;
        }
        eW.add(bVar);
        int[] a = a(flexItemCount + 1, eW, sparseIntArray);
        AppMethodBeat.o(54680);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final int[] a(SparseIntArray sparseIntArray) {
        AppMethodBeat.i(54681);
        int flexItemCount = this.btt.getFlexItemCount();
        int[] a = a(flexItemCount, eW(flexItemCount), sparseIntArray);
        AppMethodBeat.o(54681);
        return a;
    }

    private List<b> eW(int i) {
        AppMethodBeat.i(54682);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.btt.eU(i2).getLayoutParams();
            b bVar = new b();
            bVar.order = flexItem.getOrder();
            bVar.index = i2;
            arrayList.add(bVar);
        }
        AppMethodBeat.o(54682);
        return arrayList;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(SparseIntArray sparseIntArray) {
        AppMethodBeat.i(54683);
        int flexItemCount = this.btt.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            AppMethodBeat.o(54683);
            return true;
        }
        int i = 0;
        while (i < flexItemCount) {
            View eU = this.btt.eU(i);
            if (eU == null || ((FlexItem) eU.getLayoutParams()).getOrder() == sparseIntArray.get(i)) {
                i++;
            } else {
                AppMethodBeat.o(54683);
                return true;
            }
        }
        AppMethodBeat.o(54683);
        return false;
    }

    private static int[] a(int i, List<b> list, SparseIntArray sparseIntArray) {
        AppMethodBeat.i(54684);
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        Iterator it = list.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                b bVar = (b) it.next();
                iArr[i3] = bVar.index;
                sparseIntArray.append(bVar.index, bVar.order);
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(54684);
                return iArr;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar, int i, int i2, int i3, int i4, List<b> list) {
        AppMethodBeat.i(54685);
        a(aVar, i, i2, i3, i4, -1, (List) list);
        AppMethodBeat.o(54685);
    }

    /* Access modifiers changed, original: final */
    public final void b(a aVar, int i, int i2, int i3, int i4, List<b> list) {
        AppMethodBeat.i(54686);
        a(aVar, i, i2, i3, 0, i4, (List) list);
        AppMethodBeat.o(54686);
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar, int i, int i2) {
        AppMethodBeat.i(54687);
        a(aVar, i2, i, (int) BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
        AppMethodBeat.o(54687);
    }

    /* Access modifiers changed, original: final */
    public final void c(a aVar, int i, int i2, int i3, int i4, List<b> list) {
        AppMethodBeat.i(54688);
        a(aVar, i2, i, i3, i4, -1, (List) list);
        AppMethodBeat.o(54688);
    }

    /* Access modifiers changed, original: final */
    public final void d(a aVar, int i, int i2, int i3, int i4, List<b> list) {
        AppMethodBeat.i(54689);
        a(aVar, i2, i, i3, 0, i4, (List) list);
        AppMethodBeat.o(54689);
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar, int i, int i2, int i3, int i4, int i5, List<b> list) {
        List list2;
        int combineMeasuredStates;
        AppMethodBeat.i(54690);
        boolean ua = this.btt.ua();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int i6 = 0;
        if (list2 == null) {
            list2 = new ArrayList();
        }
        aVar.bty = list2;
        Object obj = i5 == -1 ? 1 : null;
        int aO = aO(ua);
        int aP = aP(ua);
        int aQ = aQ(ua);
        int aR = aR(ua);
        int i7 = j.INVALID_ID;
        int i8 = 0;
        int i9 = 0;
        b bVar = new b();
        bVar.btr = i4;
        bVar.bti = aO + aP;
        int flexItemCount = this.btt.getFlexItemCount();
        Object obj2 = obj;
        int i10 = i4;
        while (i10 < flexItemCount) {
            int i11;
            View eV = this.btt.eV(i10);
            if (eV == null) {
                if (a(i10, flexItemCount, bVar)) {
                    a(list2, bVar, i10, i8);
                    obj = obj2;
                    i11 = i6;
                }
                obj = obj2;
                i11 = i6;
            } else if (eV.getVisibility() == 8) {
                bVar.btl++;
                bVar.apt++;
                if (a(i10, flexItemCount, bVar)) {
                    a(list2, bVar, i10, i8);
                    obj = obj2;
                    i11 = i6;
                }
                obj = obj2;
                i11 = i6;
            } else {
                int w;
                int i12;
                int i13;
                b bVar2;
                FlexItem flexItem = (FlexItem) eV.getLayoutParams();
                if (flexItem.ud() == 4) {
                    bVar.btq.add(Integer.valueOf(i10));
                }
                int a = a(flexItem, ua);
                if (flexItem.uf() != -1.0f && mode == ErrorDialogData.SUPPRESSED) {
                    a = Math.round(((float) size) * flexItem.uf());
                }
                if (ua) {
                    a = this.btt.v(i, ((aO + aP) + c(flexItem, true)) + d(flexItem, true), a);
                    w = this.btt.w(i2, (((aQ + aR) + e(flexItem, true)) + f(flexItem, true)) + i8, b(flexItem, true));
                    eV.measure(a, w);
                    a(i10, a, w, eV);
                    i12 = a;
                } else {
                    w = this.btt.v(i2, (((aQ + aR) + e(flexItem, false)) + f(flexItem, false)) + i8, b(flexItem, false));
                    a = this.btt.w(i, ((aO + aP) + c(flexItem, false)) + d(flexItem, false), a);
                    eV.measure(w, a);
                    a(i10, w, a, eV);
                    i12 = a;
                }
                this.btt.a(i10, eV);
                C(eV, i10);
                combineMeasuredStates = View.combineMeasuredStates(i6, eV.getMeasuredState());
                if (a(eV, mode, size, bVar.bti, d(flexItem, ua) + (j(eV, ua) + c(flexItem, ua)), flexItem, i10, i9, list2.size())) {
                    if (bVar.uk() > 0) {
                        a(list2, bVar, i10 > 0 ? i10 - 1 : 0, i8);
                        i9 = i8 + bVar.btk;
                    } else {
                        i9 = i8;
                    }
                    a aVar2;
                    if (ua) {
                        if (flexItem.getHeight() == -1) {
                            aVar2 = this.btt;
                            eV.measure(i12, aVar2.w(i2, (((aVar2.getPaddingTop() + this.btt.getPaddingBottom()) + flexItem.uh()) + flexItem.uj()) + i9, flexItem.getHeight()));
                            C(eV, i10);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        aVar2 = this.btt;
                        eV.measure(aVar2.v(i2, (((aVar2.getPaddingLeft() + this.btt.getPaddingRight()) + flexItem.ug()) + flexItem.ui()) + i9, flexItem.getWidth()), i12);
                        C(eV, i10);
                    }
                    b bVar3 = new b();
                    bVar3.apt = 1;
                    bVar3.bti = aO + aP;
                    bVar3.btr = i10;
                    w = 0;
                    i13 = j.INVALID_ID;
                    bVar2 = bVar3;
                } else {
                    bVar.apt++;
                    bVar2 = bVar;
                    w = i9 + 1;
                    i9 = i8;
                    i13 = i7;
                }
                if (this.btv != null) {
                    this.btv[i10] = list2.size();
                }
                bVar2.bti += (j(eV, ua) + c(flexItem, ua)) + d(flexItem, ua);
                bVar2.btm += flexItem.ub();
                bVar2.btn += flexItem.uc();
                this.btt.a(eV, i10, w, bVar2);
                i7 = Math.max(i13, ((k(eV, ua) + e(flexItem, ua)) + f(flexItem, ua)) + this.btt.ca(eV));
                bVar2.btk = Math.max(bVar2.btk, i7);
                if (ua) {
                    if (this.btt.getFlexWrap() != 2) {
                        bVar2.bto = Math.max(bVar2.bto, eV.getBaseline() + flexItem.uh());
                    } else {
                        bVar2.bto = Math.max(bVar2.bto, (eV.getMeasuredHeight() - eV.getBaseline()) + flexItem.uj());
                    }
                }
                if (a(i10, flexItemCount, bVar2)) {
                    a(list2, bVar2, i10, i9);
                    i8 = i9 + bVar2.btk;
                } else {
                    i8 = i9;
                }
                if (i5 != -1 && list2.size() > 0) {
                    if (((b) list2.get(list2.size() - 1)).bts >= i5 && i10 >= i5 && obj2 == null) {
                        i8 = -bVar2.btk;
                        obj = 1;
                        if (i8 <= i3 && r2 != null) {
                            break;
                        }
                        bVar = bVar2;
                        i9 = w;
                        i11 = combineMeasuredStates;
                    }
                }
                obj = obj2;
                if (i8 <= i3) {
                }
                bVar = bVar2;
                i9 = w;
                i11 = combineMeasuredStates;
            }
            i10++;
            obj2 = obj;
            i6 = i11;
        }
        combineMeasuredStates = i6;
        aVar.btz = combineMeasuredStates;
        AppMethodBeat.o(54690);
    }

    private int aO(boolean z) {
        AppMethodBeat.i(54691);
        int paddingStart;
        if (z) {
            paddingStart = this.btt.getPaddingStart();
            AppMethodBeat.o(54691);
            return paddingStart;
        }
        paddingStart = this.btt.getPaddingTop();
        AppMethodBeat.o(54691);
        return paddingStart;
    }

    private int aP(boolean z) {
        AppMethodBeat.i(54692);
        int paddingEnd;
        if (z) {
            paddingEnd = this.btt.getPaddingEnd();
            AppMethodBeat.o(54692);
            return paddingEnd;
        }
        paddingEnd = this.btt.getPaddingBottom();
        AppMethodBeat.o(54692);
        return paddingEnd;
    }

    private int aQ(boolean z) {
        AppMethodBeat.i(54693);
        int paddingTop;
        if (z) {
            paddingTop = this.btt.getPaddingTop();
            AppMethodBeat.o(54693);
            return paddingTop;
        }
        paddingTop = this.btt.getPaddingStart();
        AppMethodBeat.o(54693);
        return paddingTop;
    }

    private int aR(boolean z) {
        AppMethodBeat.i(54694);
        int paddingBottom;
        if (z) {
            paddingBottom = this.btt.getPaddingBottom();
            AppMethodBeat.o(54694);
            return paddingBottom;
        }
        paddingBottom = this.btt.getPaddingEnd();
        AppMethodBeat.o(54694);
        return paddingBottom;
    }

    private static int j(View view, boolean z) {
        AppMethodBeat.i(54695);
        int measuredWidth;
        if (z) {
            measuredWidth = view.getMeasuredWidth();
            AppMethodBeat.o(54695);
            return measuredWidth;
        }
        measuredWidth = view.getMeasuredHeight();
        AppMethodBeat.o(54695);
        return measuredWidth;
    }

    private static int k(View view, boolean z) {
        AppMethodBeat.i(54696);
        int measuredHeight;
        if (z) {
            measuredHeight = view.getMeasuredHeight();
            AppMethodBeat.o(54696);
            return measuredHeight;
        }
        measuredHeight = view.getMeasuredWidth();
        AppMethodBeat.o(54696);
        return measuredHeight;
    }

    private static int a(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(54697);
        int width;
        if (z) {
            width = flexItem.getWidth();
            AppMethodBeat.o(54697);
            return width;
        }
        width = flexItem.getHeight();
        AppMethodBeat.o(54697);
        return width;
    }

    private static int b(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(54698);
        int height;
        if (z) {
            height = flexItem.getHeight();
            AppMethodBeat.o(54698);
            return height;
        }
        height = flexItem.getWidth();
        AppMethodBeat.o(54698);
        return height;
    }

    private static int c(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(54699);
        int ug;
        if (z) {
            ug = flexItem.ug();
            AppMethodBeat.o(54699);
            return ug;
        }
        ug = flexItem.uh();
        AppMethodBeat.o(54699);
        return ug;
    }

    private static int d(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(54700);
        int ui;
        if (z) {
            ui = flexItem.ui();
            AppMethodBeat.o(54700);
            return ui;
        }
        ui = flexItem.uj();
        AppMethodBeat.o(54700);
        return ui;
    }

    private static int e(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(54701);
        int uh;
        if (z) {
            uh = flexItem.uh();
            AppMethodBeat.o(54701);
            return uh;
        }
        uh = flexItem.ug();
        AppMethodBeat.o(54701);
        return uh;
    }

    private static int f(FlexItem flexItem, boolean z) {
        AppMethodBeat.i(54702);
        int uj;
        if (z) {
            uj = flexItem.uj();
            AppMethodBeat.o(54702);
            return uj;
        }
        uj = flexItem.ui();
        AppMethodBeat.o(54702);
        return uj;
    }

    private boolean a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        AppMethodBeat.i(54703);
        if (this.btt.getFlexWrap() == 0) {
            AppMethodBeat.o(54703);
            return false;
        } else if (flexItem.ue()) {
            AppMethodBeat.o(54703);
            return true;
        } else if (i == 0) {
            AppMethodBeat.o(54703);
            return false;
        } else {
            int maxLine = this.btt.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                maxLine = this.btt.m(view, i5, i6);
                if (maxLine > 0) {
                    i4 += maxLine;
                }
                if (i2 < i3 + i4) {
                    AppMethodBeat.o(54703);
                    return true;
                }
                AppMethodBeat.o(54703);
                return false;
            }
            AppMethodBeat.o(54703);
            return false;
        }
    }

    private static boolean a(int i, int i2, b bVar) {
        AppMethodBeat.i(54704);
        if (i != i2 - 1 || bVar.uk() == 0) {
            AppMethodBeat.o(54704);
            return false;
        }
        AppMethodBeat.o(54704);
        return true;
    }

    private void a(List<b> list, b bVar, int i, int i2) {
        AppMethodBeat.i(54705);
        bVar.btp = i2;
        this.btt.a(bVar);
        bVar.bts = i;
        list.add(bVar);
        AppMethodBeat.o(54705);
    }

    private void C(View view, int i) {
        int minHeight;
        Object obj = 1;
        AppMethodBeat.i(54706);
        Object obj2 = null;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
            obj2 = 1;
        } else if (measuredWidth > flexItem.getMaxWidth()) {
            measuredWidth = flexItem.getMaxWidth();
            int obj22 = 1;
        }
        if (measuredHeight < flexItem.getMinHeight()) {
            minHeight = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            minHeight = flexItem.getMaxHeight();
        } else {
            minHeight = measuredHeight;
            obj = obj22;
        }
        if (obj != null) {
            measuredWidth = MeasureSpec.makeMeasureSpec(measuredWidth, ErrorDialogData.SUPPRESSED);
            minHeight = MeasureSpec.makeMeasureSpec(minHeight, ErrorDialogData.SUPPRESSED);
            view.measure(measuredWidth, minHeight);
            a(i, measuredWidth, minHeight, view);
            this.btt.a(i, view);
        }
        AppMethodBeat.o(54706);
    }

    /* Access modifiers changed, original: final */
    public final void bk(int i, int i2) {
        AppMethodBeat.i(54707);
        x(i, i2, 0);
        AppMethodBeat.o(54707);
    }

    /* Access modifiers changed, original: final */
    public final void x(int i, int i2, int i3) {
        AppMethodBeat.i(54708);
        eX(this.btt.getFlexItemCount());
        if (i3 >= this.btt.getFlexItemCount()) {
            AppMethodBeat.o(54708);
            return;
        }
        int paddingLeft;
        int i4;
        int flexDirection = this.btt.getFlexDirection();
        int mode;
        switch (this.btt.getFlexDirection()) {
            case 0:
            case 1:
                mode = MeasureSpec.getMode(i);
                flexDirection = MeasureSpec.getSize(i);
                if (mode != ErrorDialogData.SUPPRESSED) {
                    flexDirection = this.btt.getLargestMainSize();
                }
                paddingLeft = this.btt.getPaddingLeft() + this.btt.getPaddingRight();
                i4 = flexDirection;
                break;
            case 2:
            case 3:
                mode = MeasureSpec.getMode(i2);
                flexDirection = MeasureSpec.getSize(i2);
                if (mode != ErrorDialogData.SUPPRESSED) {
                    flexDirection = this.btt.getLargestMainSize();
                }
                paddingLeft = this.btt.getPaddingTop() + this.btt.getPaddingBottom();
                i4 = flexDirection;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                AppMethodBeat.o(54708);
                throw illegalArgumentException;
        }
        if (this.btv != null) {
            flexDirection = this.btv[i3];
        } else {
            boolean z = false;
        }
        List flexLinesInternal = this.btt.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i5 = flexDirection; i5 < size; i5++) {
            b bVar = (b) flexLinesInternal.get(i5);
            if (bVar.bti < i4) {
                a(i, i2, bVar, i4, paddingLeft, false);
            } else {
                b(i, i2, bVar, i4, paddingLeft, false);
            }
        }
        AppMethodBeat.o(54708);
    }

    private void eX(int i) {
        AppMethodBeat.i(54709);
        if (this.btu == null) {
            if (i < 10) {
                i = 10;
            }
            this.btu = new boolean[i];
            AppMethodBeat.o(54709);
        } else if (this.btu.length < i) {
            int length = this.btu.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btu = new boolean[i];
            AppMethodBeat.o(54709);
        } else {
            Arrays.fill(this.btu, false);
            AppMethodBeat.o(54709);
        }
    }

    private void a(int i, int i2, b bVar, int i3, int i4, boolean z) {
        AppMethodBeat.i(54710);
        while (bVar.btm > 0.0f && i3 >= bVar.bti) {
            int i5 = bVar.bti;
            Object obj = null;
            float f = ((float) (i3 - bVar.bti)) / bVar.btm;
            bVar.bti = bVar.btj + i4;
            int i6 = 0;
            if (!z) {
                bVar.btk = j.INVALID_ID;
            }
            float f2 = 0.0f;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= bVar.apt) {
                    break;
                }
                int i9 = bVar.btr + i8;
                View eV = this.btt.eV(i9);
                if (!(eV == null || eV.getVisibility() == 8)) {
                    Object obj2;
                    float f3;
                    FlexItem flexItem = (FlexItem) eV.getLayoutParams();
                    int flexDirection = this.btt.getFlexDirection();
                    int measuredHeight;
                    int i10;
                    float ub;
                    float f4;
                    int round;
                    Object obj3;
                    int maxWidth;
                    int makeMeasureSpec;
                    if (flexDirection == 0 || flexDirection == 1) {
                        flexDirection = eV.getMeasuredWidth();
                        if (this.btx != null) {
                            flexDirection = (int) this.btx[i9];
                        }
                        measuredHeight = eV.getMeasuredHeight();
                        if (this.btx != null) {
                            measuredHeight = (int) (this.btx[i9] >> 32);
                        }
                        if (this.btu[i9] || flexItem.ub() <= 0.0f) {
                            i9 = measuredHeight;
                            i10 = flexDirection;
                            obj2 = obj;
                            f3 = f2;
                        } else {
                            ub = ((float) flexDirection) + (flexItem.ub() * f);
                            if (i8 == bVar.apt - 1) {
                                f4 = 0.0f;
                                ub = f2 + ub;
                            } else {
                                f4 = f2;
                            }
                            round = Math.round(ub);
                            if (round > flexItem.getMaxWidth()) {
                                obj3 = 1;
                                maxWidth = flexItem.getMaxWidth();
                                this.btu[i9] = true;
                                bVar.btm -= flexItem.ub();
                                round = maxWidth;
                            } else {
                                f4 += ub - ((float) round);
                                if (((double) f4) > 1.0d) {
                                    round++;
                                    f4 = (float) (((double) f4) - 1.0d);
                                    obj3 = obj;
                                } else if (((double) f4) < -1.0d) {
                                    round--;
                                    f4 = (float) (((double) f4) + 1.0d);
                                    obj3 = obj;
                                } else {
                                    obj3 = obj;
                                }
                            }
                            i10 = b(i2, flexItem, bVar.btp);
                            makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                            eV.measure(makeMeasureSpec, i10);
                            round = eV.getMeasuredWidth();
                            maxWidth = eV.getMeasuredHeight();
                            a(i9, makeMeasureSpec, i10, eV);
                            this.btt.a(i9, eV);
                            i9 = maxWidth;
                            i10 = round;
                            obj2 = obj3;
                            f3 = f4;
                        }
                        i6 = Math.max(i6, ((flexItem.uh() + i9) + flexItem.uj()) + this.btt.ca(eV));
                        bVar.bti = (flexItem.ui() + (flexItem.ug() + i10)) + bVar.bti;
                        i7 = i6;
                    } else {
                        flexDirection = eV.getMeasuredHeight();
                        if (this.btx != null) {
                            flexDirection = (int) (this.btx[i9] >> 32);
                        }
                        measuredHeight = eV.getMeasuredWidth();
                        if (this.btx != null) {
                            measuredHeight = (int) this.btx[i9];
                        }
                        if (this.btu[i9] || flexItem.ub() <= 0.0f) {
                            i9 = measuredHeight;
                            i10 = flexDirection;
                            obj2 = obj;
                            f3 = f2;
                        } else {
                            ub = ((float) flexDirection) + (flexItem.ub() * f);
                            if (i8 == bVar.apt - 1) {
                                f4 = 0.0f;
                                ub = f2 + ub;
                            } else {
                                f4 = f2;
                            }
                            round = Math.round(ub);
                            if (round > flexItem.getMaxHeight()) {
                                obj3 = 1;
                                maxWidth = flexItem.getMaxHeight();
                                this.btu[i9] = true;
                                bVar.btm -= flexItem.ub();
                                round = maxWidth;
                            } else {
                                f4 += ub - ((float) round);
                                if (((double) f4) > 1.0d) {
                                    round++;
                                    f4 = (float) (((double) f4) - 1.0d);
                                    obj3 = obj;
                                } else if (((double) f4) < -1.0d) {
                                    round--;
                                    f4 = (float) (((double) f4) + 1.0d);
                                    obj3 = obj;
                                } else {
                                    obj3 = obj;
                                }
                            }
                            i10 = a(i, flexItem, bVar.btp);
                            makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                            eV.measure(i10, makeMeasureSpec);
                            maxWidth = eV.getMeasuredWidth();
                            round = eV.getMeasuredHeight();
                            a(i9, i10, makeMeasureSpec, eV);
                            this.btt.a(i9, eV);
                            i9 = maxWidth;
                            i10 = round;
                            obj2 = obj3;
                            f3 = f4;
                        }
                        i6 = Math.max(i6, ((flexItem.ug() + i9) + flexItem.ui()) + this.btt.ca(eV));
                        bVar.bti = (flexItem.uj() + (flexItem.uh() + i10)) + bVar.bti;
                        i7 = i6;
                    }
                    bVar.btk = Math.max(bVar.btk, i7);
                    i6 = i7;
                    obj = obj2;
                    f2 = f3;
                }
                i7 = i8 + 1;
            }
            if (obj == null || i5 == bVar.bti) {
                AppMethodBeat.o(54710);
                return;
            }
            z = true;
        }
        AppMethodBeat.o(54710);
    }

    /* JADX WARNING: Missing block: B:87:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int i, int i2, b bVar, int i3, int i4, boolean z) {
        AppMethodBeat.i(54711);
        while (true) {
            int i5 = bVar.bti;
            if (bVar.btn <= 0.0f || i3 > bVar.bti) {
                AppMethodBeat.o(54711);
            } else {
                Object obj = null;
                float f = ((float) (bVar.bti - i3)) / bVar.btn;
                float f2 = 0.0f;
                bVar.bti = bVar.btj + i4;
                int i6 = 0;
                if (!z) {
                    bVar.btk = j.INVALID_ID;
                }
                int i7 = 0;
                while (true) {
                    int i8 = i6;
                    if (i7 >= bVar.apt) {
                        break;
                    }
                    int i9 = bVar.btr + i7;
                    View eV = this.btt.eV(i9);
                    if (eV == null || eV.getVisibility() == 8) {
                        i6 = i8;
                    } else {
                        float f3;
                        FlexItem flexItem = (FlexItem) eV.getLayoutParams();
                        int flexDirection = this.btt.getFlexDirection();
                        int measuredHeight;
                        float uc;
                        float f4;
                        int round;
                        int b;
                        int makeMeasureSpec;
                        if (flexDirection == 0 || flexDirection == 1) {
                            flexDirection = eV.getMeasuredWidth();
                            if (this.btx != null) {
                                flexDirection = (int) this.btx[i9];
                            }
                            measuredHeight = eV.getMeasuredHeight();
                            if (this.btx != null) {
                                measuredHeight = (int) (this.btx[i9] >> 32);
                            }
                            if (this.btu[i9] || flexItem.uc() <= 0.0f) {
                                i9 = measuredHeight;
                                f3 = f2;
                            } else {
                                uc = ((float) flexDirection) - (flexItem.uc() * f);
                                if (i7 == bVar.apt - 1) {
                                    f4 = 0.0f;
                                    uc = f2 + uc;
                                } else {
                                    f4 = f2;
                                }
                                round = Math.round(uc);
                                if (round < flexItem.getMinWidth()) {
                                    obj = 1;
                                    round = flexItem.getMinWidth();
                                    this.btu[i9] = true;
                                    bVar.btn -= flexItem.uc();
                                } else {
                                    f4 += uc - ((float) round);
                                    if (((double) f4) > 1.0d) {
                                        round++;
                                        f4 -= 1.0f;
                                    } else if (((double) f4) < -1.0d) {
                                        round--;
                                        f4 += 1.0f;
                                    }
                                }
                                b = b(i2, flexItem, bVar.btp);
                                makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                                eV.measure(makeMeasureSpec, b);
                                flexDirection = eV.getMeasuredWidth();
                                round = eV.getMeasuredHeight();
                                a(i9, makeMeasureSpec, b, eV);
                                this.btt.a(i9, eV);
                                i9 = round;
                                f3 = f4;
                            }
                            i8 = Math.max(i8, ((flexItem.uh() + i9) + flexItem.uj()) + this.btt.ca(eV));
                            bVar.bti = (flexItem.ui() + (flexDirection + flexItem.ug())) + bVar.bti;
                            i6 = i8;
                        } else {
                            flexDirection = eV.getMeasuredHeight();
                            if (this.btx != null) {
                                flexDirection = (int) (this.btx[i9] >> 32);
                            }
                            measuredHeight = eV.getMeasuredWidth();
                            if (this.btx != null) {
                                measuredHeight = (int) this.btx[i9];
                            }
                            if (this.btu[i9] || flexItem.uc() <= 0.0f) {
                                i9 = measuredHeight;
                                f3 = f2;
                            } else {
                                uc = ((float) flexDirection) - (flexItem.uc() * f);
                                if (i7 == bVar.apt - 1) {
                                    f4 = 0.0f;
                                    uc = f2 + uc;
                                } else {
                                    f4 = f2;
                                }
                                round = Math.round(uc);
                                if (round < flexItem.getMinHeight()) {
                                    obj = 1;
                                    round = flexItem.getMinHeight();
                                    this.btu[i9] = true;
                                    bVar.btn -= flexItem.uc();
                                } else {
                                    f4 += uc - ((float) round);
                                    if (((double) f4) > 1.0d) {
                                        round++;
                                        f4 -= 1.0f;
                                    } else if (((double) f4) < -1.0d) {
                                        round--;
                                        f4 += 1.0f;
                                    }
                                }
                                b = a(i, flexItem, bVar.btp);
                                makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                                eV.measure(b, makeMeasureSpec);
                                round = eV.getMeasuredWidth();
                                flexDirection = eV.getMeasuredHeight();
                                a(i9, b, makeMeasureSpec, eV);
                                this.btt.a(i9, eV);
                                i9 = round;
                                f3 = f4;
                            }
                            i8 = Math.max(i8, ((flexItem.ug() + i9) + flexItem.ui()) + this.btt.ca(eV));
                            bVar.bti = (flexItem.uj() + (flexDirection + flexItem.uh())) + bVar.bti;
                            i6 = i8;
                        }
                        bVar.btk = Math.max(bVar.btk, i6);
                        f2 = f3;
                    }
                    i7++;
                }
                if (obj == null || i5 == bVar.bti) {
                    AppMethodBeat.o(54711);
                } else {
                    z = true;
                }
            }
        }
        AppMethodBeat.o(54711);
    }

    private int a(int i, FlexItem flexItem, int i2) {
        AppMethodBeat.i(54712);
        a aVar = this.btt;
        int v = aVar.v(i, (((aVar.getPaddingLeft() + this.btt.getPaddingRight()) + flexItem.ug()) + flexItem.ui()) + i2, flexItem.getWidth());
        int size = MeasureSpec.getSize(v);
        if (size > flexItem.getMaxWidth()) {
            v = MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), MeasureSpec.getMode(v));
        } else if (size < flexItem.getMinWidth()) {
            v = MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), MeasureSpec.getMode(v));
        }
        AppMethodBeat.o(54712);
        return v;
    }

    private int b(int i, FlexItem flexItem, int i2) {
        AppMethodBeat.i(54713);
        a aVar = this.btt;
        int w = aVar.w(i, (((aVar.getPaddingTop() + this.btt.getPaddingBottom()) + flexItem.uh()) + flexItem.uj()) + i2, flexItem.getHeight());
        int size = MeasureSpec.getSize(w);
        if (size > flexItem.getMaxHeight()) {
            w = MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), MeasureSpec.getMode(w));
        } else if (size < flexItem.getMinHeight()) {
            w = MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), MeasureSpec.getMode(w));
        }
        AppMethodBeat.o(54713);
        return w;
    }

    /* Access modifiers changed, original: final */
    public final void y(int i, int i2, int i3) {
        int size;
        AppMethodBeat.i(54714);
        int flexDirection = this.btt.getFlexDirection();
        switch (flexDirection) {
            case 0:
            case 1:
                flexDirection = MeasureSpec.getMode(i2);
                size = MeasureSpec.getSize(i2);
                break;
            case 2:
            case 3:
                flexDirection = MeasureSpec.getMode(i);
                size = MeasureSpec.getSize(i);
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                AppMethodBeat.o(54714);
                throw illegalArgumentException;
        }
        List<b> flexLinesInternal = this.btt.getFlexLinesInternal();
        if (flexDirection == ErrorDialogData.SUPPRESSED) {
            flexDirection = this.btt.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() != 1) {
                if (flexLinesInternal.size() >= 2) {
                    float f;
                    b bVar;
                    switch (this.btt.getAlignContent()) {
                        case 1:
                            flexDirection = size - flexDirection;
                            b bVar2 = new b();
                            bVar2.btk = flexDirection;
                            flexLinesInternal.add(0, bVar2);
                            break;
                        case 2:
                            this.btt.setFlexLines(b((List) flexLinesInternal, size, flexDirection));
                            AppMethodBeat.o(54714);
                            return;
                        case 3:
                            if (flexDirection < size) {
                                float size2 = ((float) (size - flexDirection)) / ((float) (flexLinesInternal.size() - 1));
                                f = 0.0f;
                                ArrayList arrayList = new ArrayList();
                                int size3 = flexLinesInternal.size();
                                int i4 = 0;
                                while (i4 < size3) {
                                    float f2;
                                    arrayList.add((b) flexLinesInternal.get(i4));
                                    if (i4 != flexLinesInternal.size() - 1) {
                                        b bVar3 = new b();
                                        if (i4 == flexLinesInternal.size() - 2) {
                                            bVar3.btk = Math.round(size2 + f);
                                            f2 = 0.0f;
                                        } else {
                                            bVar3.btk = Math.round(size2);
                                            f2 = f;
                                        }
                                        f2 += size2 - ((float) bVar3.btk);
                                        if (f2 > 1.0f) {
                                            bVar3.btk++;
                                            f2 -= 1.0f;
                                        } else if (f2 < -1.0f) {
                                            bVar3.btk--;
                                            f2 += 1.0f;
                                        }
                                        arrayList.add(bVar3);
                                    } else {
                                        f2 = f;
                                    }
                                    i4++;
                                    f = f2;
                                }
                                this.btt.setFlexLines(arrayList);
                                AppMethodBeat.o(54714);
                                return;
                            }
                            break;
                        case 4:
                            if (flexDirection >= size) {
                                this.btt.setFlexLines(b((List) flexLinesInternal, size, flexDirection));
                                AppMethodBeat.o(54714);
                                return;
                            }
                            flexDirection = (size - flexDirection) / (flexLinesInternal.size() * 2);
                            ArrayList arrayList2 = new ArrayList();
                            b bVar4 = new b();
                            bVar4.btk = flexDirection;
                            for (b bVar5 : flexLinesInternal) {
                                arrayList2.add(bVar4);
                                arrayList2.add(bVar5);
                                arrayList2.add(bVar4);
                            }
                            this.btt.setFlexLines(arrayList2);
                            AppMethodBeat.o(54714);
                            return;
                        case 5:
                            if (flexDirection < size) {
                                float size4 = ((float) (size - flexDirection)) / ((float) flexLinesInternal.size());
                                float f3 = 0.0f;
                                int size5 = flexLinesInternal.size();
                                for (int i5 = 0; i5 < size5; i5++) {
                                    bVar5 = (b) flexLinesInternal.get(i5);
                                    f = ((float) bVar5.btk) + size4;
                                    if (i5 == flexLinesInternal.size() - 1) {
                                        f += f3;
                                        f3 = 0.0f;
                                    }
                                    int round = Math.round(f);
                                    f3 += f - ((float) round);
                                    if (f3 > 1.0f) {
                                        size = round + 1;
                                        f3 -= 1.0f;
                                    } else if (f3 < -1.0f) {
                                        size = round - 1;
                                        f3 += 1.0f;
                                    } else {
                                        size = round;
                                    }
                                    bVar5.btk = size;
                                }
                                AppMethodBeat.o(54714);
                                return;
                            }
                            break;
                    }
                }
            }
            ((b) flexLinesInternal.get(0)).btk = size - i3;
            AppMethodBeat.o(54714);
            return;
        }
        AppMethodBeat.o(54714);
    }

    private static List<b> b(List<b> list, int i, int i2) {
        AppMethodBeat.i(54715);
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.btk = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add((b) list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        AppMethodBeat.o(54715);
        return arrayList;
    }

    /* Access modifiers changed, original: final */
    public final void ul() {
        AppMethodBeat.i(54716);
        eY(0);
        AppMethodBeat.o(54716);
    }

    /* Access modifiers changed, original: final */
    public final void eY(int i) {
        AppMethodBeat.i(54717);
        if (i >= this.btt.getFlexItemCount()) {
            AppMethodBeat.o(54717);
            return;
        }
        int flexDirection = this.btt.getFlexDirection();
        IllegalArgumentException illegalArgumentException;
        if (this.btt.getAlignItems() == 4) {
            int i2 = 0;
            if (this.btv != null) {
                i2 = this.btv[i];
            }
            List flexLinesInternal = this.btt.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i3 = i2; i3 < size; i3++) {
                b bVar = (b) flexLinesInternal.get(i3);
                int i4 = bVar.apt;
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = bVar.btr + i5;
                    if (i5 < this.btt.getFlexItemCount()) {
                        View eV = this.btt.eV(i6);
                        if (!(eV == null || eV.getVisibility() == 8)) {
                            FlexItem flexItem = (FlexItem) eV.getLayoutParams();
                            if (flexItem.ud() == -1 || flexItem.ud() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        n(eV, bVar.btk, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        o(eV, bVar.btk, i6);
                                        break;
                                    default:
                                        illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                        AppMethodBeat.o(54717);
                                        throw illegalArgumentException;
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(54717);
            return;
        }
        for (b bVar2 : this.btt.getFlexLinesInternal()) {
            for (Integer num : bVar2.btq) {
                View eV2 = this.btt.eV(num.intValue());
                switch (flexDirection) {
                    case 0:
                    case 1:
                        n(eV2, bVar2.btk, num.intValue());
                        break;
                    case 2:
                    case 3:
                        o(eV2, bVar2.btk, num.intValue());
                        break;
                    default:
                        illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                        AppMethodBeat.o(54717);
                        throw illegalArgumentException;
                }
            }
        }
        AppMethodBeat.o(54717);
    }

    private void n(View view, int i, int i2) {
        int i3;
        AppMethodBeat.i(54718);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.uh()) - flexItem.uj()) - this.btt.ca(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.btx != null) {
            i3 = (int) this.btx[i2];
        } else {
            i3 = view.getMeasuredWidth();
        }
        i3 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
        min = MeasureSpec.makeMeasureSpec(min, ErrorDialogData.SUPPRESSED);
        view.measure(i3, min);
        a(i2, i3, min, view);
        this.btt.a(i2, view);
        AppMethodBeat.o(54718);
    }

    private void o(View view, int i, int i2) {
        int i3;
        AppMethodBeat.i(54719);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.ug()) - flexItem.ui()) - this.btt.ca(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.btx != null) {
            i3 = (int) (this.btx[i2] >> 32);
        } else {
            i3 = view.getMeasuredHeight();
        }
        i3 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
        min = MeasureSpec.makeMeasureSpec(min, ErrorDialogData.SUPPRESSED);
        view.measure(min, i3);
        a(i2, min, i3, view);
        this.btt.a(i2, view);
        AppMethodBeat.o(54719);
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, b bVar, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(54720);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.btt.getAlignItems();
        if (flexItem.ud() != -1) {
            alignItems = flexItem.ud();
        }
        int i5 = bVar.btk;
        int measuredHeight;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.btt.getFlexWrap() != 2) {
                    view.layout(i, flexItem.uh() + i2, i3, flexItem.uh() + i4);
                    AppMethodBeat.o(54720);
                    return;
                }
                view.layout(i, i2 - flexItem.uj(), i3, i4 - flexItem.uj());
                AppMethodBeat.o(54720);
                return;
            case 1:
                if (this.btt.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.uj(), i3, (i5 + i2) - flexItem.uj());
                    AppMethodBeat.o(54720);
                    return;
                }
                view.layout(i, ((i2 - i5) + view.getMeasuredHeight()) + flexItem.uh(), i3, flexItem.uh() + ((i4 - i5) + view.getMeasuredHeight()));
                AppMethodBeat.o(54720);
                return;
            case 2:
                measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.uh()) - flexItem.uj()) / 2;
                if (this.btt.getFlexWrap() == 2) {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    break;
                }
                view.layout(i, i2 + measuredHeight, i3, (measuredHeight + i2) + view.getMeasuredHeight());
                AppMethodBeat.o(54720);
                return;
            case 3:
                if (this.btt.getFlexWrap() != 2) {
                    measuredHeight = Math.max(bVar.bto - view.getBaseline(), flexItem.uh());
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i4);
                    AppMethodBeat.o(54720);
                    return;
                }
                measuredHeight = Math.max((bVar.bto - view.getMeasuredHeight()) + view.getBaseline(), flexItem.uj());
                view.layout(i, i2 - measuredHeight, i3, i4 - measuredHeight);
                AppMethodBeat.o(54720);
                return;
        }
        AppMethodBeat.o(54720);
    }

    /* Access modifiers changed, original: final */
    public final void a(View view, b bVar, boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(54721);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.btt.getAlignItems();
        if (flexItem.ud() != -1) {
            alignItems = flexItem.ud();
        }
        int i5 = bVar.btk;
        switch (alignItems) {
            case 0:
            case 3:
            case 4:
                if (z) {
                    view.layout(i - flexItem.ui(), i2, i3 - flexItem.ui(), i4);
                    AppMethodBeat.o(54721);
                    return;
                }
                view.layout(flexItem.ug() + i, i2, flexItem.ug() + i3, i4);
                AppMethodBeat.o(54721);
                return;
            case 1:
                if (z) {
                    view.layout(((i - i5) + view.getMeasuredWidth()) + flexItem.ug(), i2, flexItem.ug() + ((i3 - i5) + view.getMeasuredWidth()), i4);
                    AppMethodBeat.o(54721);
                    return;
                }
                view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.ui(), i2, ((i5 + i3) - view.getMeasuredWidth()) - flexItem.ui(), i4);
                AppMethodBeat.o(54721);
                return;
            case 2:
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + f.a(marginLayoutParams)) - f.b(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    break;
                }
                view.layout(i + measuredWidth, i2, measuredWidth + i3, i4);
                AppMethodBeat.o(54721);
                return;
        }
        AppMethodBeat.o(54721);
    }

    /* Access modifiers changed, original: final */
    public final void eZ(int i) {
        AppMethodBeat.i(54722);
        if (this.btx == null) {
            if (i < 10) {
                i = 10;
            }
            this.btx = new long[i];
            AppMethodBeat.o(54722);
            return;
        }
        if (this.btx.length < i) {
            int length = this.btx.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btx = Arrays.copyOf(this.btx, i);
        }
        AppMethodBeat.o(54722);
    }

    /* Access modifiers changed, original: final */
    public final void fa(int i) {
        AppMethodBeat.i(54723);
        if (this.btw == null) {
            if (i < 10) {
                i = 10;
            }
            this.btw = new long[i];
            AppMethodBeat.o(54723);
            return;
        }
        if (this.btw.length < i) {
            int length = this.btw.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btw = Arrays.copyOf(this.btw, i);
        }
        AppMethodBeat.o(54723);
    }

    static int at(long j) {
        return (int) j;
    }

    static int au(long j) {
        return (int) (j >> 32);
    }

    private static long bl(int i, int i2) {
        return (((long) i2) << 32) | (((long) i) & 4294967295L);
    }

    private void a(int i, int i2, int i3, View view) {
        AppMethodBeat.i(54724);
        if (this.btw != null) {
            this.btw[i] = bl(i2, i3);
        }
        if (this.btx != null) {
            this.btx[i] = bl(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        AppMethodBeat.o(54724);
    }

    /* Access modifiers changed, original: final */
    public final void fb(int i) {
        AppMethodBeat.i(54725);
        if (this.btv == null) {
            if (i < 10) {
                i = 10;
            }
            this.btv = new int[i];
            AppMethodBeat.o(54725);
            return;
        }
        if (this.btv.length < i) {
            int length = this.btv.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btv = Arrays.copyOf(this.btv, i);
        }
        AppMethodBeat.o(54725);
    }

    /* Access modifiers changed, original: final */
    public final void d(List<b> list, int i) {
        AppMethodBeat.i(54726);
        AssertionError assertionError;
        if (!$assertionsDisabled && this.btv == null) {
            assertionError = new AssertionError();
            AppMethodBeat.o(54726);
            throw assertionError;
        } else if ($assertionsDisabled || this.btw != null) {
            int i2 = this.btv[i];
            if (i2 == -1) {
                i2 = 0;
            }
            for (int size = list.size() - 1; size >= i2; size--) {
                list.remove(size);
            }
            i2 = this.btv.length - 1;
            if (i > i2) {
                Arrays.fill(this.btv, -1);
            } else {
                Arrays.fill(this.btv, i, i2, -1);
            }
            i2 = this.btw.length - 1;
            if (i > i2) {
                Arrays.fill(this.btw, 0);
                AppMethodBeat.o(54726);
                return;
            }
            Arrays.fill(this.btw, i, i2, 0);
            AppMethodBeat.o(54726);
        } else {
            assertionError = new AssertionError();
            AppMethodBeat.o(54726);
            throw assertionError;
        }
    }
}
