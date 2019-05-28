package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class f extends BaseAdapter implements b {
    private e zyX;
    private List<b> zyY;

    class b {
        int mCount = 0;
        int zzA;

        public b(int i) {
            this.zzA = i;
        }
    }

    final class a extends DataSetObserver {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(107412);
            f.this.zyY = f.this.a(f.this.zyX);
            f.this.notifyDataSetChanged();
            AppMethodBeat.o(107412);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(107413);
            f.this.zyY = f.this.a(f.this.zyX);
            f.this.notifyDataSetInvalidated();
            AppMethodBeat.o(107413);
        }
    }

    public f(e eVar) {
        AppMethodBeat.i(107414);
        this.zyX = eVar;
        eVar.registerDataSetObserver(new a(this, (byte) 0));
        this.zyY = a(eVar);
        AppMethodBeat.o(107414);
    }

    public final int getCount() {
        AppMethodBeat.i(107415);
        int count = this.zyX.getCount();
        AppMethodBeat.o(107415);
        return count;
    }

    public final int PA(int i) {
        AppMethodBeat.i(107416);
        try {
            int i2 = ((b) this.zyY.get(i)).mCount;
            AppMethodBeat.o(107416);
            return i2;
        } catch (IndexOutOfBoundsException e) {
            AppMethodBeat.o(107416);
            return 0;
        }
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107417);
        View a = this.zyX.a(((b) this.zyY.get(i)).zzA, view, viewGroup);
        AppMethodBeat.o(107417);
        return a;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(107418);
        Object item = this.zyX.getItem(i);
        AppMethodBeat.o(107418);
        return item;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(107419);
        long itemId = this.zyX.getItemId(i);
        AppMethodBeat.o(107419);
        return itemId;
    }

    public final int dJh() {
        AppMethodBeat.i(107420);
        int size = this.zyY.size();
        AppMethodBeat.o(107420);
        return size;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107421);
        View view2 = this.zyX.getView(i, view, viewGroup);
        AppMethodBeat.o(107421);
        return view2;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<b> a(e eVar) {
        AppMethodBeat.i(107422);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < eVar.getCount()) {
                long tw = eVar.tw(i2);
                b bVar = (b) hashMap.get(Long.valueOf(tw));
                if (bVar == null) {
                    bVar = new b(i2);
                    arrayList.add(bVar);
                }
                bVar.mCount++;
                hashMap.put(Long.valueOf(tw), bVar);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(107422);
                return arrayList;
            }
        }
    }
}
