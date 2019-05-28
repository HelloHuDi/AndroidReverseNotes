package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class t extends a {
    final SparseArray<u> iPq = new SparseArray();
    private final ArrayList<?> iPr;
    private LayoutInflater mInflater;

    t(ArrayList<?> arrayList) {
        AppMethodBeat.i(133553);
        this.iPr = arrayList;
        AppMethodBeat.o(133553);
    }

    /* Access modifiers changed, original: final */
    public final boolean isEmpty() {
        AppMethodBeat.i(133554);
        if (this.iPr == null || bo.ek(this.iPr)) {
            AppMethodBeat.o(133554);
            return true;
        }
        AppMethodBeat.o(133554);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final Object pW(int i) {
        AppMethodBeat.i(133555);
        if (i < 0 || i >= getItemCount()) {
            AppMethodBeat.o(133555);
            return null;
        }
        Object obj = this.iPr.get(i);
        AppMethodBeat.o(133555);
        return obj;
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(133556);
        u uVar = (u) this.iPq.get(i);
        if (uVar == null) {
            AppMethodBeat.o(133556);
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(context);
        }
        v a = uVar.a(this.mInflater, viewGroup);
        AppMethodBeat.o(133556);
        return a;
    }

    public final void a(v vVar, int i) {
        AppMethodBeat.i(133557);
        u uVar = (u) this.iPq.get(getItemViewType(i));
        if (uVar != null) {
            uVar.c(vVar, pW(i));
        }
        AppMethodBeat.o(133557);
    }

    public final void a(v vVar, int i, List list) {
        AppMethodBeat.i(133558);
        u uVar = (u) this.iPq.get(getItemViewType(i));
        if (uVar == null) {
            super.a(vVar, i, list);
            AppMethodBeat.o(133558);
            return;
        }
        if (list.size() > 0) {
            pW(i);
            if (uVar.b(vVar, list.get(0))) {
                AppMethodBeat.o(133558);
                return;
            }
        }
        uVar.c(vVar, pW(i));
        AppMethodBeat.o(133558);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(133559);
        Object pW = pW(i);
        if (pW == null) {
            AppMethodBeat.o(133559);
            return 0;
        }
        int hashCode = pW.getClass().hashCode();
        AppMethodBeat.o(133559);
        return hashCode;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(133560);
        Object pW = pW(i);
        u uVar = (u) this.iPq.get(getItemViewType(i));
        if (pW == null || uVar == null) {
            AppMethodBeat.o(133560);
            return 0;
        }
        long bA = uVar.bA(pW);
        AppMethodBeat.o(133560);
        return bA;
    }

    public final int getItemCount() {
        AppMethodBeat.i(133561);
        if (this.iPr == null) {
            AppMethodBeat.o(133561);
            return 0;
        }
        int size = this.iPr.size();
        AppMethodBeat.o(133561);
        return size;
    }
}
