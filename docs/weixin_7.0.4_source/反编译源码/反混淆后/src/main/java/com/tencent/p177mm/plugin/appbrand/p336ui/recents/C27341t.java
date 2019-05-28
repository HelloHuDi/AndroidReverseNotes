package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.t */
final class C27341t extends C41523a {
    final SparseArray<C42699u> iPq = new SparseArray();
    private final ArrayList<?> iPr;
    private LayoutInflater mInflater;

    C27341t(ArrayList<?> arrayList) {
        AppMethodBeat.m2504i(133553);
        this.iPr = arrayList;
        AppMethodBeat.m2505o(133553);
    }

    /* Access modifiers changed, original: final */
    public final boolean isEmpty() {
        AppMethodBeat.m2504i(133554);
        if (this.iPr == null || C5046bo.m7548ek(this.iPr)) {
            AppMethodBeat.m2505o(133554);
            return true;
        }
        AppMethodBeat.m2505o(133554);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pW */
    public final Object mo45022pW(int i) {
        AppMethodBeat.m2504i(133555);
        if (i < 0 || i >= getItemCount()) {
            AppMethodBeat.m2505o(133555);
            return null;
        }
        Object obj = this.iPr.get(i);
        AppMethodBeat.m2505o(133555);
        return obj;
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(133556);
        C42699u c42699u = (C42699u) this.iPq.get(i);
        if (c42699u == null) {
            AppMethodBeat.m2505o(133556);
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(context);
        }
        C41531v a = c42699u.mo22451a(this.mInflater, viewGroup);
        AppMethodBeat.m2505o(133556);
        return a;
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(133557);
        C42699u c42699u = (C42699u) this.iPq.get(getItemViewType(i));
        if (c42699u != null) {
            c42699u.mo22455c(c41531v, mo45022pW(i));
        }
        AppMethodBeat.m2505o(133557);
    }

    /* renamed from: a */
    public final void mo27742a(C41531v c41531v, int i, List list) {
        AppMethodBeat.m2504i(133558);
        C42699u c42699u = (C42699u) this.iPq.get(getItemViewType(i));
        if (c42699u == null) {
            super.mo27742a(c41531v, i, list);
            AppMethodBeat.m2505o(133558);
            return;
        }
        if (list.size() > 0) {
            mo45022pW(i);
            if (c42699u.mo22453b(c41531v, list.get(0))) {
                AppMethodBeat.m2505o(133558);
                return;
            }
        }
        c42699u.mo22455c(c41531v, mo45022pW(i));
        AppMethodBeat.m2505o(133558);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(133559);
        Object pW = mo45022pW(i);
        if (pW == null) {
            AppMethodBeat.m2505o(133559);
            return 0;
        }
        int hashCode = pW.getClass().hashCode();
        AppMethodBeat.m2505o(133559);
        return hashCode;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(133560);
        Object pW = mo45022pW(i);
        C42699u c42699u = (C42699u) this.iPq.get(getItemViewType(i));
        if (pW == null || c42699u == null) {
            AppMethodBeat.m2505o(133560);
            return 0;
        }
        long bA = c42699u.mo22454bA(pW);
        AppMethodBeat.m2505o(133560);
        return bA;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(133561);
        if (this.iPr == null) {
            AppMethodBeat.m2505o(133561);
            return 0;
        }
        int size = this.iPr.size();
        AppMethodBeat.m2505o(133561);
        return size;
    }
}
