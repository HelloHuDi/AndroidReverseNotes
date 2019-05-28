package com.tencent.p177mm.p612ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.ui.gridviewheaders.f */
public final class C40876f extends BaseAdapter implements C24009b {
    private C46688e zyX;
    private List<C36297b> zyY;

    /* renamed from: com.tencent.mm.ui.gridviewheaders.f$b */
    class C36297b {
        int mCount = 0;
        int zzA;

        public C36297b(int i) {
            this.zzA = i;
        }
    }

    /* renamed from: com.tencent.mm.ui.gridviewheaders.f$a */
    final class C40875a extends DataSetObserver {
        private C40875a() {
        }

        /* synthetic */ C40875a(C40876f c40876f, byte b) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(107412);
            C40876f.this.zyY = C40876f.this.mo64452a(C40876f.this.zyX);
            C40876f.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(107412);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(107413);
            C40876f.this.zyY = C40876f.this.mo64452a(C40876f.this.zyX);
            C40876f.this.notifyDataSetInvalidated();
            AppMethodBeat.m2505o(107413);
        }
    }

    public C40876f(C46688e c46688e) {
        AppMethodBeat.m2504i(107414);
        this.zyX = c46688e;
        c46688e.registerDataSetObserver(new C40875a(this, (byte) 0));
        this.zyY = mo64452a(c46688e);
        AppMethodBeat.m2505o(107414);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(107415);
        int count = this.zyX.getCount();
        AppMethodBeat.m2505o(107415);
        return count;
    }

    /* renamed from: PA */
    public final int mo39816PA(int i) {
        AppMethodBeat.m2504i(107416);
        try {
            int i2 = ((C36297b) this.zyY.get(i)).mCount;
            AppMethodBeat.m2505o(107416);
            return i2;
        } catch (IndexOutOfBoundsException e) {
            AppMethodBeat.m2505o(107416);
            return 0;
        }
    }

    /* renamed from: a */
    public final View mo39817a(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107417);
        View a = this.zyX.mo23142a(((C36297b) this.zyY.get(i)).zzA, view, viewGroup);
        AppMethodBeat.m2505o(107417);
        return a;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(107418);
        Object item = this.zyX.getItem(i);
        AppMethodBeat.m2505o(107418);
        return item;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(107419);
        long itemId = this.zyX.getItemId(i);
        AppMethodBeat.m2505o(107419);
        return itemId;
    }

    public final int dJh() {
        AppMethodBeat.m2504i(107420);
        int size = this.zyY.size();
        AppMethodBeat.m2505o(107420);
        return size;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107421);
        View view2 = this.zyX.getView(i, view, viewGroup);
        AppMethodBeat.m2505o(107421);
        return view2;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final List<C36297b> mo64452a(C46688e c46688e) {
        AppMethodBeat.m2504i(107422);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < c46688e.getCount()) {
                long tw = c46688e.mo23150tw(i2);
                C36297b c36297b = (C36297b) hashMap.get(Long.valueOf(tw));
                if (c36297b == null) {
                    c36297b = new C36297b(i2);
                    arrayList.add(c36297b);
                }
                c36297b.mCount++;
                hashMap.put(Long.valueOf(tw), c36297b);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(107422);
                return arrayList;
            }
        }
    }
}
