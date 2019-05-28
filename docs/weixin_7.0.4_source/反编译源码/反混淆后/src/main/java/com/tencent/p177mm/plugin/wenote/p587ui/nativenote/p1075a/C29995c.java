package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p1075a;

import android.support.p069v7.widget.RecyclerView.C41523a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b.C29997g;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b.C4689a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.a.c */
public final class C29995c extends C41523a<C4689a> {
    private final String TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    private C46457k uSJ;
    private C29997g uUi;

    public C29995c(C46457k c46457k) {
        AppMethodBeat.m2504i(27143);
        this.uSJ = c46457k;
        this.uUi = new C29997g();
        AppMethodBeat.m2505o(27143);
    }

    /* renamed from: a */
    private synchronized void m47474a(C4689a c4689a, int i) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(27144);
            C44001c Ke = C40380c.dem().mo63750Ke(i);
            if (Ke == null || Ke.getType() != c4689a.dfW()) {
                String str = "MicroMsg.Note.NoteRecyclerViewAdapter";
                String str2 = "onBindViewHolder, item is null %b, position is %d";
                Object[] objArr = new Object[2];
                if (Ke != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(i);
                C4990ab.m7413e(str, str2, objArr);
                AppMethodBeat.m2505o(27144);
            } else {
                c4689a.mo9809a(Ke, i, Ke.getType());
                AppMethodBeat.m2505o(27144);
            }
        }
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(27145);
        C44001c Ke = C40380c.dem().mo63750Ke(i);
        if (Ke != null) {
            int type = Ke.getType();
            AppMethodBeat.m2505o(27145);
            return type;
        }
        C4990ab.m7413e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(27145);
        return 0;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(27146);
        int size = C40380c.dem().size();
        AppMethodBeat.m2505o(27146);
        return size;
    }
}
