package com.google.android.flexbox;

import android.support.p057v4.view.C0460f;
import android.support.p057v4.widget.C8415j;
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

/* renamed from: com.google.android.flexbox.c */
class C37287c {
    static final /* synthetic */ boolean $assertionsDisabled = (!C37287c.class.desiredAssertionStatus());
    private final C45055a btt;
    private boolean[] btu;
    int[] btv;
    long[] btw;
    private long[] btx;

    /* renamed from: com.google.android.flexbox.c$a */
    static class C17696a {
        List<C41633b> bty;
        int btz;

        C17696a() {
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.bty = null;
            this.btz = 0;
        }
    }

    /* renamed from: com.google.android.flexbox.c$b */
    static class C37288b implements Comparable<C37288b> {
        int index;
        int order;

        private C37288b() {
        }

        /* synthetic */ C37288b(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            C37288b c37288b = (C37288b) obj;
            if (this.order != c37288b.order) {
                return this.order - c37288b.order;
            }
            return this.index - c37288b.index;
        }

        public final String toString() {
            AppMethodBeat.m2504i(54679);
            String str = "Order{order=" + this.order + ", index=" + this.index + '}';
            AppMethodBeat.m2505o(54679);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(54727);
        AppMethodBeat.m2505o(54727);
    }

    C37287c(C45055a c45055a) {
        this.btt = c45055a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int[] mo59561a(View view, int i, LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        AppMethodBeat.m2504i(54680);
        int flexItemCount = this.btt.getFlexItemCount();
        List eW = m62649eW(flexItemCount);
        C37288b c37288b = new C37288b();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            c37288b.order = 1;
        } else {
            c37288b.order = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount) {
            c37288b.index = flexItemCount;
        } else if (i < this.btt.getFlexItemCount()) {
            c37288b.index = i;
            while (i < flexItemCount) {
                C37288b c37288b2 = (C37288b) eW.get(i);
                c37288b2.index++;
                i++;
            }
        } else {
            c37288b.index = flexItemCount;
        }
        eW.add(c37288b);
        int[] a = C37287c.m62634a(flexItemCount + 1, eW, sparseIntArray);
        AppMethodBeat.m2505o(54680);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int[] mo59560a(SparseIntArray sparseIntArray) {
        AppMethodBeat.m2504i(54681);
        int flexItemCount = this.btt.getFlexItemCount();
        int[] a = C37287c.m62634a(flexItemCount, m62649eW(flexItemCount), sparseIntArray);
        AppMethodBeat.m2505o(54681);
        return a;
    }

    /* renamed from: eW */
    private List<C37288b> m62649eW(int i) {
        AppMethodBeat.m2504i(54682);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.btt.mo19330eU(i2).getLayoutParams();
            C37288b c37288b = new C37288b();
            c37288b.order = flexItem.getOrder();
            c37288b.index = i2;
            arrayList.add(c37288b);
        }
        AppMethodBeat.m2505o(54682);
        return arrayList;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo59563b(SparseIntArray sparseIntArray) {
        AppMethodBeat.m2504i(54683);
        int flexItemCount = this.btt.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            AppMethodBeat.m2505o(54683);
            return true;
        }
        int i = 0;
        while (i < flexItemCount) {
            View eU = this.btt.mo19330eU(i);
            if (eU == null || ((FlexItem) eU.getLayoutParams()).getOrder() == sparseIntArray.get(i)) {
                i++;
            } else {
                AppMethodBeat.m2505o(54683);
                return true;
            }
        }
        AppMethodBeat.m2505o(54683);
        return false;
    }

    /* renamed from: a */
    private static int[] m62634a(int i, List<C37288b> list, SparseIntArray sparseIntArray) {
        AppMethodBeat.m2504i(54684);
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        Iterator it = list.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                C37288b c37288b = (C37288b) it.next();
                iArr[i3] = c37288b.index;
                sparseIntArray.append(c37288b.index, c37288b.order);
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(54684);
                return iArr;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59559a(C17696a c17696a, int i, int i2, int i3, int i4, List<C41633b> list) {
        AppMethodBeat.m2504i(54685);
        mo59558a(c17696a, i, i2, i3, i4, -1, (List) list);
        AppMethodBeat.m2505o(54685);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo59562b(C17696a c17696a, int i, int i2, int i3, int i4, List<C41633b> list) {
        AppMethodBeat.m2504i(54686);
        mo59558a(c17696a, i, i2, i3, 0, i4, (List) list);
        AppMethodBeat.m2505o(54686);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59557a(C17696a c17696a, int i, int i2) {
        AppMethodBeat.m2504i(54687);
        mo59558a(c17696a, i2, i, (int) BaseClientBuilder.API_PRIORITY_OTHER, 0, -1, null);
        AppMethodBeat.m2505o(54687);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo59565c(C17696a c17696a, int i, int i2, int i3, int i4, List<C41633b> list) {
        AppMethodBeat.m2504i(54688);
        mo59558a(c17696a, i2, i, i3, i4, -1, (List) list);
        AppMethodBeat.m2505o(54688);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo59566d(C17696a c17696a, int i, int i2, int i3, int i4, List<C41633b> list) {
        AppMethodBeat.m2504i(54689);
        mo59558a(c17696a, i2, i, i3, 0, i4, (List) list);
        AppMethodBeat.m2505o(54689);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59558a(C17696a c17696a, int i, int i2, int i3, int i4, int i5, List<C41633b> list) {
        List list2;
        int combineMeasuredStates;
        AppMethodBeat.m2504i(54690);
        boolean ua = this.btt.mo19366ua();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int i6 = 0;
        if (list2 == null) {
            list2 = new ArrayList();
        }
        c17696a.bty = list2;
        Object obj = i5 == -1 ? 1 : null;
        int aO = m62635aO(ua);
        int aP = m62636aP(ua);
        int aQ = m62637aQ(ua);
        int aR = m62638aR(ua);
        int i7 = C8415j.INVALID_ID;
        int i8 = 0;
        int i9 = 0;
        C41633b c41633b = new C41633b();
        c41633b.btr = i4;
        c41633b.bti = aO + aP;
        int flexItemCount = this.btt.getFlexItemCount();
        Object obj2 = obj;
        int i10 = i4;
        while (i10 < flexItemCount) {
            int i11;
            View eV = this.btt.mo19331eV(i10);
            if (eV == null) {
                if (C37287c.m62632a(i10, flexItemCount, c41633b)) {
                    m62631a(list2, c41633b, i10, i8);
                    obj = obj2;
                    i11 = i6;
                }
                obj = obj2;
                i11 = i6;
            } else if (eV.getVisibility() == 8) {
                c41633b.btl++;
                c41633b.apt++;
                if (C37287c.m62632a(i10, flexItemCount, c41633b)) {
                    m62631a(list2, c41633b, i10, i8);
                    obj = obj2;
                    i11 = i6;
                }
                obj = obj2;
                i11 = i6;
            } else {
                int w;
                int i12;
                int i13;
                C41633b c41633b2;
                FlexItem flexItem = (FlexItem) eV.getLayoutParams();
                if (flexItem.mo19315ud() == 4) {
                    c41633b.btq.add(Integer.valueOf(i10));
                }
                int a = C37287c.m62628a(flexItem, ua);
                if (flexItem.mo19317uf() != -1.0f && mode == ErrorDialogData.SUPPRESSED) {
                    a = Math.round(((float) size) * flexItem.mo19317uf());
                }
                if (ua) {
                    a = this.btt.mo19367v(i, ((aO + aP) + C37287c.m62646c(flexItem, true)) + C37287c.m62647d(flexItem, true), a);
                    w = this.btt.mo19368w(i2, (((aQ + aR) + C37287c.m62648e(flexItem, true)) + C37287c.m62651f(flexItem, true)) + i8, C37287c.m62642b(flexItem, true));
                    eV.measure(a, w);
                    m62629a(i10, a, w, eV);
                    i12 = a;
                } else {
                    w = this.btt.mo19367v(i2, (((aQ + aR) + C37287c.m62648e(flexItem, false)) + C37287c.m62651f(flexItem, false)) + i8, C37287c.m62642b(flexItem, false));
                    a = this.btt.mo19368w(i, ((aO + aP) + C37287c.m62646c(flexItem, false)) + C37287c.m62647d(flexItem, false), a);
                    eV.measure(w, a);
                    m62629a(i10, w, a, eV);
                    i12 = a;
                }
                this.btt.mo19324a(i10, eV);
                m62626C(eV, i10);
                combineMeasuredStates = View.combineMeasuredStates(i6, eV.getMeasuredState());
                if (m62633a(eV, mode, size, c41633b.bti, C37287c.m62647d(flexItem, ua) + (C37287c.m62652j(eV, ua) + C37287c.m62646c(flexItem, ua)), flexItem, i10, i9, list2.size())) {
                    if (c41633b.mo66770uk() > 0) {
                        m62631a(list2, c41633b, i10 > 0 ? i10 - 1 : 0, i8);
                        i9 = i8 + c41633b.btk;
                    } else {
                        i9 = i8;
                    }
                    C45055a c45055a;
                    if (ua) {
                        if (flexItem.getHeight() == -1) {
                            c45055a = this.btt;
                            eV.measure(i12, c45055a.mo19368w(i2, (((c45055a.getPaddingTop() + this.btt.getPaddingBottom()) + flexItem.mo19319uh()) + flexItem.mo19321uj()) + i9, flexItem.getHeight()));
                            m62626C(eV, i10);
                        }
                    } else if (flexItem.getWidth() == -1) {
                        c45055a = this.btt;
                        eV.measure(c45055a.mo19367v(i2, (((c45055a.getPaddingLeft() + this.btt.getPaddingRight()) + flexItem.mo19318ug()) + flexItem.mo19320ui()) + i9, flexItem.getWidth()), i12);
                        m62626C(eV, i10);
                    }
                    C41633b c41633b3 = new C41633b();
                    c41633b3.apt = 1;
                    c41633b3.bti = aO + aP;
                    c41633b3.btr = i10;
                    w = 0;
                    i13 = C8415j.INVALID_ID;
                    c41633b2 = c41633b3;
                } else {
                    c41633b.apt++;
                    c41633b2 = c41633b;
                    w = i9 + 1;
                    i9 = i8;
                    i13 = i7;
                }
                if (this.btv != null) {
                    this.btv[i10] = list2.size();
                }
                c41633b2.bti += (C37287c.m62652j(eV, ua) + C37287c.m62646c(flexItem, ua)) + C37287c.m62647d(flexItem, ua);
                c41633b2.btm += flexItem.mo19313ub();
                c41633b2.btn += flexItem.mo19314uc();
                this.btt.mo19325a(eV, i10, w, c41633b2);
                i7 = Math.max(i13, ((C37287c.m62653k(eV, ua) + C37287c.m62648e(flexItem, ua)) + C37287c.m62651f(flexItem, ua)) + this.btt.mo19328ca(eV));
                c41633b2.btk = Math.max(c41633b2.btk, i7);
                if (ua) {
                    if (this.btt.getFlexWrap() != 2) {
                        c41633b2.bto = Math.max(c41633b2.bto, eV.getBaseline() + flexItem.mo19319uh());
                    } else {
                        c41633b2.bto = Math.max(c41633b2.bto, (eV.getMeasuredHeight() - eV.getBaseline()) + flexItem.mo19321uj());
                    }
                }
                if (C37287c.m62632a(i10, flexItemCount, c41633b2)) {
                    m62631a(list2, c41633b2, i10, i9);
                    i8 = i9 + c41633b2.btk;
                } else {
                    i8 = i9;
                }
                if (i5 != -1 && list2.size() > 0) {
                    if (((C41633b) list2.get(list2.size() - 1)).bts >= i5 && i10 >= i5 && obj2 == null) {
                        i8 = -c41633b2.btk;
                        obj = 1;
                        if (i8 <= i3 && r2 != null) {
                            break;
                        }
                        c41633b = c41633b2;
                        i9 = w;
                        i11 = combineMeasuredStates;
                    }
                }
                obj = obj2;
                if (i8 <= i3) {
                }
                c41633b = c41633b2;
                i9 = w;
                i11 = combineMeasuredStates;
            }
            i10++;
            obj2 = obj;
            i6 = i11;
        }
        combineMeasuredStates = i6;
        c17696a.btz = combineMeasuredStates;
        AppMethodBeat.m2505o(54690);
    }

    /* renamed from: aO */
    private int m62635aO(boolean z) {
        AppMethodBeat.m2504i(54691);
        int paddingStart;
        if (z) {
            paddingStart = this.btt.getPaddingStart();
            AppMethodBeat.m2505o(54691);
            return paddingStart;
        }
        paddingStart = this.btt.getPaddingTop();
        AppMethodBeat.m2505o(54691);
        return paddingStart;
    }

    /* renamed from: aP */
    private int m62636aP(boolean z) {
        AppMethodBeat.m2504i(54692);
        int paddingEnd;
        if (z) {
            paddingEnd = this.btt.getPaddingEnd();
            AppMethodBeat.m2505o(54692);
            return paddingEnd;
        }
        paddingEnd = this.btt.getPaddingBottom();
        AppMethodBeat.m2505o(54692);
        return paddingEnd;
    }

    /* renamed from: aQ */
    private int m62637aQ(boolean z) {
        AppMethodBeat.m2504i(54693);
        int paddingTop;
        if (z) {
            paddingTop = this.btt.getPaddingTop();
            AppMethodBeat.m2505o(54693);
            return paddingTop;
        }
        paddingTop = this.btt.getPaddingStart();
        AppMethodBeat.m2505o(54693);
        return paddingTop;
    }

    /* renamed from: aR */
    private int m62638aR(boolean z) {
        AppMethodBeat.m2504i(54694);
        int paddingBottom;
        if (z) {
            paddingBottom = this.btt.getPaddingBottom();
            AppMethodBeat.m2505o(54694);
            return paddingBottom;
        }
        paddingBottom = this.btt.getPaddingEnd();
        AppMethodBeat.m2505o(54694);
        return paddingBottom;
    }

    /* renamed from: j */
    private static int m62652j(View view, boolean z) {
        AppMethodBeat.m2504i(54695);
        int measuredWidth;
        if (z) {
            measuredWidth = view.getMeasuredWidth();
            AppMethodBeat.m2505o(54695);
            return measuredWidth;
        }
        measuredWidth = view.getMeasuredHeight();
        AppMethodBeat.m2505o(54695);
        return measuredWidth;
    }

    /* renamed from: k */
    private static int m62653k(View view, boolean z) {
        AppMethodBeat.m2504i(54696);
        int measuredHeight;
        if (z) {
            measuredHeight = view.getMeasuredHeight();
            AppMethodBeat.m2505o(54696);
            return measuredHeight;
        }
        measuredHeight = view.getMeasuredWidth();
        AppMethodBeat.m2505o(54696);
        return measuredHeight;
    }

    /* renamed from: a */
    private static int m62628a(FlexItem flexItem, boolean z) {
        AppMethodBeat.m2504i(54697);
        int width;
        if (z) {
            width = flexItem.getWidth();
            AppMethodBeat.m2505o(54697);
            return width;
        }
        width = flexItem.getHeight();
        AppMethodBeat.m2505o(54697);
        return width;
    }

    /* renamed from: b */
    private static int m62642b(FlexItem flexItem, boolean z) {
        AppMethodBeat.m2504i(54698);
        int height;
        if (z) {
            height = flexItem.getHeight();
            AppMethodBeat.m2505o(54698);
            return height;
        }
        height = flexItem.getWidth();
        AppMethodBeat.m2505o(54698);
        return height;
    }

    /* renamed from: c */
    private static int m62646c(FlexItem flexItem, boolean z) {
        AppMethodBeat.m2504i(54699);
        int ug;
        if (z) {
            ug = flexItem.mo19318ug();
            AppMethodBeat.m2505o(54699);
            return ug;
        }
        ug = flexItem.mo19319uh();
        AppMethodBeat.m2505o(54699);
        return ug;
    }

    /* renamed from: d */
    private static int m62647d(FlexItem flexItem, boolean z) {
        AppMethodBeat.m2504i(54700);
        int ui;
        if (z) {
            ui = flexItem.mo19320ui();
            AppMethodBeat.m2505o(54700);
            return ui;
        }
        ui = flexItem.mo19321uj();
        AppMethodBeat.m2505o(54700);
        return ui;
    }

    /* renamed from: e */
    private static int m62648e(FlexItem flexItem, boolean z) {
        AppMethodBeat.m2504i(54701);
        int uh;
        if (z) {
            uh = flexItem.mo19319uh();
            AppMethodBeat.m2505o(54701);
            return uh;
        }
        uh = flexItem.mo19318ug();
        AppMethodBeat.m2505o(54701);
        return uh;
    }

    /* renamed from: f */
    private static int m62651f(FlexItem flexItem, boolean z) {
        AppMethodBeat.m2504i(54702);
        int uj;
        if (z) {
            uj = flexItem.mo19321uj();
            AppMethodBeat.m2505o(54702);
            return uj;
        }
        uj = flexItem.mo19320ui();
        AppMethodBeat.m2505o(54702);
        return uj;
    }

    /* renamed from: a */
    private boolean m62633a(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        AppMethodBeat.m2504i(54703);
        if (this.btt.getFlexWrap() == 0) {
            AppMethodBeat.m2505o(54703);
            return false;
        } else if (flexItem.mo19316ue()) {
            AppMethodBeat.m2505o(54703);
            return true;
        } else if (i == 0) {
            AppMethodBeat.m2505o(54703);
            return false;
        } else {
            int maxLine = this.btt.getMaxLine();
            if (maxLine == -1 || maxLine > i7 + 1) {
                maxLine = this.btt.mo19349m(view, i5, i6);
                if (maxLine > 0) {
                    i4 += maxLine;
                }
                if (i2 < i3 + i4) {
                    AppMethodBeat.m2505o(54703);
                    return true;
                }
                AppMethodBeat.m2505o(54703);
                return false;
            }
            AppMethodBeat.m2505o(54703);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m62632a(int i, int i2, C41633b c41633b) {
        AppMethodBeat.m2504i(54704);
        if (i != i2 - 1 || c41633b.mo66770uk() == 0) {
            AppMethodBeat.m2505o(54704);
            return false;
        }
        AppMethodBeat.m2505o(54704);
        return true;
    }

    /* renamed from: a */
    private void m62631a(List<C41633b> list, C41633b c41633b, int i, int i2) {
        AppMethodBeat.m2504i(54705);
        c41633b.btp = i2;
        this.btt.mo19326a(c41633b);
        c41633b.bts = i;
        list.add(c41633b);
        AppMethodBeat.m2505o(54705);
    }

    /* renamed from: C */
    private void m62626C(View view, int i) {
        int minHeight;
        Object obj = 1;
        AppMethodBeat.m2504i(54706);
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
            m62629a(i, measuredWidth, minHeight, view);
            this.btt.mo19324a(i, view);
        }
        AppMethodBeat.m2505o(54706);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bk */
    public final void mo59564bk(int i, int i2) {
        AppMethodBeat.m2504i(54707);
        mo59573x(i, i2, 0);
        AppMethodBeat.m2505o(54707);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: x */
    public final void mo59573x(int i, int i2, int i3) {
        AppMethodBeat.m2504i(54708);
        m62650eX(this.btt.getFlexItemCount());
        if (i3 >= this.btt.getFlexItemCount()) {
            AppMethodBeat.m2505o(54708);
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
                AppMethodBeat.m2505o(54708);
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
            C41633b c41633b = (C41633b) flexLinesInternal.get(i5);
            if (c41633b.bti < i4) {
                m62630a(i, i2, c41633b, i4, paddingLeft, false);
            } else {
                m62644b(i, i2, c41633b, i4, paddingLeft, false);
            }
        }
        AppMethodBeat.m2505o(54708);
    }

    /* renamed from: eX */
    private void m62650eX(int i) {
        AppMethodBeat.m2504i(54709);
        if (this.btu == null) {
            if (i < 10) {
                i = 10;
            }
            this.btu = new boolean[i];
            AppMethodBeat.m2505o(54709);
        } else if (this.btu.length < i) {
            int length = this.btu.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btu = new boolean[i];
            AppMethodBeat.m2505o(54709);
        } else {
            Arrays.fill(this.btu, false);
            AppMethodBeat.m2505o(54709);
        }
    }

    /* renamed from: a */
    private void m62630a(int i, int i2, C41633b c41633b, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(54710);
        while (c41633b.btm > 0.0f && i3 >= c41633b.bti) {
            int i5 = c41633b.bti;
            Object obj = null;
            float f = ((float) (i3 - c41633b.bti)) / c41633b.btm;
            c41633b.bti = c41633b.btj + i4;
            int i6 = 0;
            if (!z) {
                c41633b.btk = C8415j.INVALID_ID;
            }
            float f2 = 0.0f;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= c41633b.apt) {
                    break;
                }
                int i9 = c41633b.btr + i8;
                View eV = this.btt.mo19331eV(i9);
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
                        if (this.btu[i9] || flexItem.mo19313ub() <= 0.0f) {
                            i9 = measuredHeight;
                            i10 = flexDirection;
                            obj2 = obj;
                            f3 = f2;
                        } else {
                            ub = ((float) flexDirection) + (flexItem.mo19313ub() * f);
                            if (i8 == c41633b.apt - 1) {
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
                                c41633b.btm -= flexItem.mo19313ub();
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
                            i10 = m62641b(i2, flexItem, c41633b.btp);
                            makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                            eV.measure(makeMeasureSpec, i10);
                            round = eV.getMeasuredWidth();
                            maxWidth = eV.getMeasuredHeight();
                            m62629a(i9, makeMeasureSpec, i10, eV);
                            this.btt.mo19324a(i9, eV);
                            i9 = maxWidth;
                            i10 = round;
                            obj2 = obj3;
                            f3 = f4;
                        }
                        i6 = Math.max(i6, ((flexItem.mo19319uh() + i9) + flexItem.mo19321uj()) + this.btt.mo19328ca(eV));
                        c41633b.bti = (flexItem.mo19320ui() + (flexItem.mo19318ug() + i10)) + c41633b.bti;
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
                        if (this.btu[i9] || flexItem.mo19313ub() <= 0.0f) {
                            i9 = measuredHeight;
                            i10 = flexDirection;
                            obj2 = obj;
                            f3 = f2;
                        } else {
                            ub = ((float) flexDirection) + (flexItem.mo19313ub() * f);
                            if (i8 == c41633b.apt - 1) {
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
                                c41633b.btm -= flexItem.mo19313ub();
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
                            i10 = m62627a(i, flexItem, c41633b.btp);
                            makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                            eV.measure(i10, makeMeasureSpec);
                            maxWidth = eV.getMeasuredWidth();
                            round = eV.getMeasuredHeight();
                            m62629a(i9, i10, makeMeasureSpec, eV);
                            this.btt.mo19324a(i9, eV);
                            i9 = maxWidth;
                            i10 = round;
                            obj2 = obj3;
                            f3 = f4;
                        }
                        i6 = Math.max(i6, ((flexItem.mo19318ug() + i9) + flexItem.mo19320ui()) + this.btt.mo19328ca(eV));
                        c41633b.bti = (flexItem.mo19321uj() + (flexItem.mo19319uh() + i10)) + c41633b.bti;
                        i7 = i6;
                    }
                    c41633b.btk = Math.max(c41633b.btk, i7);
                    i6 = i7;
                    obj = obj2;
                    f2 = f3;
                }
                i7 = i8 + 1;
            }
            if (obj == null || i5 == c41633b.bti) {
                AppMethodBeat.m2505o(54710);
                return;
            }
            z = true;
        }
        AppMethodBeat.m2505o(54710);
    }

    /* JADX WARNING: Missing block: B:87:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m62644b(int i, int i2, C41633b c41633b, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(54711);
        while (true) {
            int i5 = c41633b.bti;
            if (c41633b.btn <= 0.0f || i3 > c41633b.bti) {
                AppMethodBeat.m2505o(54711);
            } else {
                Object obj = null;
                float f = ((float) (c41633b.bti - i3)) / c41633b.btn;
                float f2 = 0.0f;
                c41633b.bti = c41633b.btj + i4;
                int i6 = 0;
                if (!z) {
                    c41633b.btk = C8415j.INVALID_ID;
                }
                int i7 = 0;
                while (true) {
                    int i8 = i6;
                    if (i7 >= c41633b.apt) {
                        break;
                    }
                    int i9 = c41633b.btr + i7;
                    View eV = this.btt.mo19331eV(i9);
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
                            if (this.btu[i9] || flexItem.mo19314uc() <= 0.0f) {
                                i9 = measuredHeight;
                                f3 = f2;
                            } else {
                                uc = ((float) flexDirection) - (flexItem.mo19314uc() * f);
                                if (i7 == c41633b.apt - 1) {
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
                                    c41633b.btn -= flexItem.mo19314uc();
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
                                b = m62641b(i2, flexItem, c41633b.btp);
                                makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                                eV.measure(makeMeasureSpec, b);
                                flexDirection = eV.getMeasuredWidth();
                                round = eV.getMeasuredHeight();
                                m62629a(i9, makeMeasureSpec, b, eV);
                                this.btt.mo19324a(i9, eV);
                                i9 = round;
                                f3 = f4;
                            }
                            i8 = Math.max(i8, ((flexItem.mo19319uh() + i9) + flexItem.mo19321uj()) + this.btt.mo19328ca(eV));
                            c41633b.bti = (flexItem.mo19320ui() + (flexDirection + flexItem.mo19318ug())) + c41633b.bti;
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
                            if (this.btu[i9] || flexItem.mo19314uc() <= 0.0f) {
                                i9 = measuredHeight;
                                f3 = f2;
                            } else {
                                uc = ((float) flexDirection) - (flexItem.mo19314uc() * f);
                                if (i7 == c41633b.apt - 1) {
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
                                    c41633b.btn -= flexItem.mo19314uc();
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
                                b = m62627a(i, flexItem, c41633b.btp);
                                makeMeasureSpec = MeasureSpec.makeMeasureSpec(round, ErrorDialogData.SUPPRESSED);
                                eV.measure(b, makeMeasureSpec);
                                round = eV.getMeasuredWidth();
                                flexDirection = eV.getMeasuredHeight();
                                m62629a(i9, b, makeMeasureSpec, eV);
                                this.btt.mo19324a(i9, eV);
                                i9 = round;
                                f3 = f4;
                            }
                            i8 = Math.max(i8, ((flexItem.mo19318ug() + i9) + flexItem.mo19320ui()) + this.btt.mo19328ca(eV));
                            c41633b.bti = (flexItem.mo19321uj() + (flexDirection + flexItem.mo19319uh())) + c41633b.bti;
                            i6 = i8;
                        }
                        c41633b.btk = Math.max(c41633b.btk, i6);
                        f2 = f3;
                    }
                    i7++;
                }
                if (obj == null || i5 == c41633b.bti) {
                    AppMethodBeat.m2505o(54711);
                } else {
                    z = true;
                }
            }
        }
        AppMethodBeat.m2505o(54711);
    }

    /* renamed from: a */
    private int m62627a(int i, FlexItem flexItem, int i2) {
        AppMethodBeat.m2504i(54712);
        C45055a c45055a = this.btt;
        int v = c45055a.mo19367v(i, (((c45055a.getPaddingLeft() + this.btt.getPaddingRight()) + flexItem.mo19318ug()) + flexItem.mo19320ui()) + i2, flexItem.getWidth());
        int size = MeasureSpec.getSize(v);
        if (size > flexItem.getMaxWidth()) {
            v = MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), MeasureSpec.getMode(v));
        } else if (size < flexItem.getMinWidth()) {
            v = MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), MeasureSpec.getMode(v));
        }
        AppMethodBeat.m2505o(54712);
        return v;
    }

    /* renamed from: b */
    private int m62641b(int i, FlexItem flexItem, int i2) {
        AppMethodBeat.m2504i(54713);
        C45055a c45055a = this.btt;
        int w = c45055a.mo19368w(i, (((c45055a.getPaddingTop() + this.btt.getPaddingBottom()) + flexItem.mo19319uh()) + flexItem.mo19321uj()) + i2, flexItem.getHeight());
        int size = MeasureSpec.getSize(w);
        if (size > flexItem.getMaxHeight()) {
            w = MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), MeasureSpec.getMode(w));
        } else if (size < flexItem.getMinHeight()) {
            w = MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), MeasureSpec.getMode(w));
        }
        AppMethodBeat.m2505o(54713);
        return w;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: y */
    public final void mo59574y(int i, int i2, int i3) {
        int size;
        AppMethodBeat.m2504i(54714);
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
                AppMethodBeat.m2505o(54714);
                throw illegalArgumentException;
        }
        List<C41633b> flexLinesInternal = this.btt.getFlexLinesInternal();
        if (flexDirection == ErrorDialogData.SUPPRESSED) {
            flexDirection = this.btt.getSumOfCrossSize() + i3;
            if (flexLinesInternal.size() != 1) {
                if (flexLinesInternal.size() >= 2) {
                    float f;
                    C41633b c41633b;
                    switch (this.btt.getAlignContent()) {
                        case 1:
                            flexDirection = size - flexDirection;
                            C41633b c41633b2 = new C41633b();
                            c41633b2.btk = flexDirection;
                            flexLinesInternal.add(0, c41633b2);
                            break;
                        case 2:
                            this.btt.setFlexLines(C37287c.m62643b((List) flexLinesInternal, size, flexDirection));
                            AppMethodBeat.m2505o(54714);
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
                                    arrayList.add((C41633b) flexLinesInternal.get(i4));
                                    if (i4 != flexLinesInternal.size() - 1) {
                                        C41633b c41633b3 = new C41633b();
                                        if (i4 == flexLinesInternal.size() - 2) {
                                            c41633b3.btk = Math.round(size2 + f);
                                            f2 = 0.0f;
                                        } else {
                                            c41633b3.btk = Math.round(size2);
                                            f2 = f;
                                        }
                                        f2 += size2 - ((float) c41633b3.btk);
                                        if (f2 > 1.0f) {
                                            c41633b3.btk++;
                                            f2 -= 1.0f;
                                        } else if (f2 < -1.0f) {
                                            c41633b3.btk--;
                                            f2 += 1.0f;
                                        }
                                        arrayList.add(c41633b3);
                                    } else {
                                        f2 = f;
                                    }
                                    i4++;
                                    f = f2;
                                }
                                this.btt.setFlexLines(arrayList);
                                AppMethodBeat.m2505o(54714);
                                return;
                            }
                            break;
                        case 4:
                            if (flexDirection >= size) {
                                this.btt.setFlexLines(C37287c.m62643b((List) flexLinesInternal, size, flexDirection));
                                AppMethodBeat.m2505o(54714);
                                return;
                            }
                            flexDirection = (size - flexDirection) / (flexLinesInternal.size() * 2);
                            ArrayList arrayList2 = new ArrayList();
                            C41633b c41633b4 = new C41633b();
                            c41633b4.btk = flexDirection;
                            for (C41633b c41633b5 : flexLinesInternal) {
                                arrayList2.add(c41633b4);
                                arrayList2.add(c41633b5);
                                arrayList2.add(c41633b4);
                            }
                            this.btt.setFlexLines(arrayList2);
                            AppMethodBeat.m2505o(54714);
                            return;
                        case 5:
                            if (flexDirection < size) {
                                float size4 = ((float) (size - flexDirection)) / ((float) flexLinesInternal.size());
                                float f3 = 0.0f;
                                int size5 = flexLinesInternal.size();
                                for (int i5 = 0; i5 < size5; i5++) {
                                    c41633b5 = (C41633b) flexLinesInternal.get(i5);
                                    f = ((float) c41633b5.btk) + size4;
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
                                    c41633b5.btk = size;
                                }
                                AppMethodBeat.m2505o(54714);
                                return;
                            }
                            break;
                    }
                }
            }
            ((C41633b) flexLinesInternal.get(0)).btk = size - i3;
            AppMethodBeat.m2505o(54714);
            return;
        }
        AppMethodBeat.m2505o(54714);
    }

    /* renamed from: b */
    private static List<C41633b> m62643b(List<C41633b> list, int i, int i2) {
        AppMethodBeat.m2504i(54715);
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        C41633b c41633b = new C41633b();
        c41633b.btk = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(c41633b);
            }
            arrayList.add((C41633b) list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(c41633b);
            }
        }
        AppMethodBeat.m2505o(54715);
        return arrayList;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ul */
    public final void mo59572ul() {
        AppMethodBeat.m2504i(54716);
        mo59568eY(0);
        AppMethodBeat.m2505o(54716);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eY */
    public final void mo59568eY(int i) {
        AppMethodBeat.m2504i(54717);
        if (i >= this.btt.getFlexItemCount()) {
            AppMethodBeat.m2505o(54717);
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
                C41633b c41633b = (C41633b) flexLinesInternal.get(i3);
                int i4 = c41633b.apt;
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = c41633b.btr + i5;
                    if (i5 < this.btt.getFlexItemCount()) {
                        View eV = this.btt.mo19331eV(i6);
                        if (!(eV == null || eV.getVisibility() == 8)) {
                            FlexItem flexItem = (FlexItem) eV.getLayoutParams();
                            if (flexItem.mo19315ud() == -1 || flexItem.mo19315ud() == 4) {
                                switch (flexDirection) {
                                    case 0:
                                    case 1:
                                        m62654n(eV, c41633b.btk, i6);
                                        break;
                                    case 2:
                                    case 3:
                                        m62655o(eV, c41633b.btk, i6);
                                        break;
                                    default:
                                        illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                                        AppMethodBeat.m2505o(54717);
                                        throw illegalArgumentException;
                                }
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(54717);
            return;
        }
        for (C41633b c41633b2 : this.btt.getFlexLinesInternal()) {
            for (Integer num : c41633b2.btq) {
                View eV2 = this.btt.mo19331eV(num.intValue());
                switch (flexDirection) {
                    case 0:
                    case 1:
                        m62654n(eV2, c41633b2.btk, num.intValue());
                        break;
                    case 2:
                    case 3:
                        m62655o(eV2, c41633b2.btk, num.intValue());
                        break;
                    default:
                        illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                        AppMethodBeat.m2505o(54717);
                        throw illegalArgumentException;
                }
            }
        }
        AppMethodBeat.m2505o(54717);
    }

    /* renamed from: n */
    private void m62654n(View view, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(54718);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.mo19319uh()) - flexItem.mo19321uj()) - this.btt.mo19328ca(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.btx != null) {
            i3 = (int) this.btx[i2];
        } else {
            i3 = view.getMeasuredWidth();
        }
        i3 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
        min = MeasureSpec.makeMeasureSpec(min, ErrorDialogData.SUPPRESSED);
        view.measure(i3, min);
        m62629a(i2, i3, min, view);
        this.btt.mo19324a(i2, view);
        AppMethodBeat.m2505o(54718);
    }

    /* renamed from: o */
    private void m62655o(View view, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(54719);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.mo19318ug()) - flexItem.mo19320ui()) - this.btt.mo19328ca(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.btx != null) {
            i3 = (int) (this.btx[i2] >> 32);
        } else {
            i3 = view.getMeasuredHeight();
        }
        i3 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
        min = MeasureSpec.makeMeasureSpec(min, ErrorDialogData.SUPPRESSED);
        view.measure(min, i3);
        m62629a(i2, min, i3, view);
        this.btt.mo19324a(i2, view);
        AppMethodBeat.m2505o(54719);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59555a(View view, C41633b c41633b, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(54720);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.btt.getAlignItems();
        if (flexItem.mo19315ud() != -1) {
            alignItems = flexItem.mo19315ud();
        }
        int i5 = c41633b.btk;
        int measuredHeight;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.btt.getFlexWrap() != 2) {
                    view.layout(i, flexItem.mo19319uh() + i2, i3, flexItem.mo19319uh() + i4);
                    AppMethodBeat.m2505o(54720);
                    return;
                }
                view.layout(i, i2 - flexItem.mo19321uj(), i3, i4 - flexItem.mo19321uj());
                AppMethodBeat.m2505o(54720);
                return;
            case 1:
                if (this.btt.getFlexWrap() != 2) {
                    view.layout(i, ((i2 + i5) - view.getMeasuredHeight()) - flexItem.mo19321uj(), i3, (i5 + i2) - flexItem.mo19321uj());
                    AppMethodBeat.m2505o(54720);
                    return;
                }
                view.layout(i, ((i2 - i5) + view.getMeasuredHeight()) + flexItem.mo19319uh(), i3, flexItem.mo19319uh() + ((i4 - i5) + view.getMeasuredHeight()));
                AppMethodBeat.m2505o(54720);
                return;
            case 2:
                measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.mo19319uh()) - flexItem.mo19321uj()) / 2;
                if (this.btt.getFlexWrap() == 2) {
                    view.layout(i, i2 - measuredHeight, i3, (i2 - measuredHeight) + view.getMeasuredHeight());
                    break;
                }
                view.layout(i, i2 + measuredHeight, i3, (measuredHeight + i2) + view.getMeasuredHeight());
                AppMethodBeat.m2505o(54720);
                return;
            case 3:
                if (this.btt.getFlexWrap() != 2) {
                    measuredHeight = Math.max(c41633b.bto - view.getBaseline(), flexItem.mo19319uh());
                    view.layout(i, i2 + measuredHeight, i3, measuredHeight + i4);
                    AppMethodBeat.m2505o(54720);
                    return;
                }
                measuredHeight = Math.max((c41633b.bto - view.getMeasuredHeight()) + view.getBaseline(), flexItem.mo19321uj());
                view.layout(i, i2 - measuredHeight, i3, i4 - measuredHeight);
                AppMethodBeat.m2505o(54720);
                return;
        }
        AppMethodBeat.m2505o(54720);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59556a(View view, C41633b c41633b, boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(54721);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.btt.getAlignItems();
        if (flexItem.mo19315ud() != -1) {
            alignItems = flexItem.mo19315ud();
        }
        int i5 = c41633b.btk;
        switch (alignItems) {
            case 0:
            case 3:
            case 4:
                if (z) {
                    view.layout(i - flexItem.mo19320ui(), i2, i3 - flexItem.mo19320ui(), i4);
                    AppMethodBeat.m2505o(54721);
                    return;
                }
                view.layout(flexItem.mo19318ug() + i, i2, flexItem.mo19318ug() + i3, i4);
                AppMethodBeat.m2505o(54721);
                return;
            case 1:
                if (z) {
                    view.layout(((i - i5) + view.getMeasuredWidth()) + flexItem.mo19318ug(), i2, flexItem.mo19318ug() + ((i3 - i5) + view.getMeasuredWidth()), i4);
                    AppMethodBeat.m2505o(54721);
                    return;
                }
                view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.mo19320ui(), i2, ((i5 + i3) - view.getMeasuredWidth()) - flexItem.mo19320ui(), i4);
                AppMethodBeat.m2505o(54721);
                return;
            case 2:
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + C0460f.m791a(marginLayoutParams)) - C0460f.m792b(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    break;
                }
                view.layout(i + measuredWidth, i2, measuredWidth + i3, i4);
                AppMethodBeat.m2505o(54721);
                return;
        }
        AppMethodBeat.m2505o(54721);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eZ */
    public final void mo59569eZ(int i) {
        AppMethodBeat.m2504i(54722);
        if (this.btx == null) {
            if (i < 10) {
                i = 10;
            }
            this.btx = new long[i];
            AppMethodBeat.m2505o(54722);
            return;
        }
        if (this.btx.length < i) {
            int length = this.btx.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btx = Arrays.copyOf(this.btx, i);
        }
        AppMethodBeat.m2505o(54722);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fa */
    public final void mo59570fa(int i) {
        AppMethodBeat.m2504i(54723);
        if (this.btw == null) {
            if (i < 10) {
                i = 10;
            }
            this.btw = new long[i];
            AppMethodBeat.m2505o(54723);
            return;
        }
        if (this.btw.length < i) {
            int length = this.btw.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btw = Arrays.copyOf(this.btw, i);
        }
        AppMethodBeat.m2505o(54723);
    }

    /* renamed from: at */
    static int m62639at(long j) {
        return (int) j;
    }

    /* renamed from: au */
    static int m62640au(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: bl */
    private static long m62645bl(int i, int i2) {
        return (((long) i2) << 32) | (((long) i) & 4294967295L);
    }

    /* renamed from: a */
    private void m62629a(int i, int i2, int i3, View view) {
        AppMethodBeat.m2504i(54724);
        if (this.btw != null) {
            this.btw[i] = C37287c.m62645bl(i2, i3);
        }
        if (this.btx != null) {
            this.btx[i] = C37287c.m62645bl(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        AppMethodBeat.m2505o(54724);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fb */
    public final void mo59571fb(int i) {
        AppMethodBeat.m2504i(54725);
        if (this.btv == null) {
            if (i < 10) {
                i = 10;
            }
            this.btv = new int[i];
            AppMethodBeat.m2505o(54725);
            return;
        }
        if (this.btv.length < i) {
            int length = this.btv.length * 2;
            if (length >= i) {
                i = length;
            }
            this.btv = Arrays.copyOf(this.btv, i);
        }
        AppMethodBeat.m2505o(54725);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo59567d(List<C41633b> list, int i) {
        AppMethodBeat.m2504i(54726);
        AssertionError assertionError;
        if (!$assertionsDisabled && this.btv == null) {
            assertionError = new AssertionError();
            AppMethodBeat.m2505o(54726);
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
                AppMethodBeat.m2505o(54726);
                return;
            }
            Arrays.fill(this.btw, i, i2, 0);
            AppMethodBeat.m2505o(54726);
        } else {
            assertionError = new AssertionError();
            AppMethodBeat.m2505o(54726);
            throw assertionError;
        }
    }
}
