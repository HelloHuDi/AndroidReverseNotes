package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C45773c;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.g */
public final class C38754g extends BaseAdapter {
    C45773c kgW;
    List<C42837b> khh;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(88161);
        C42837b sM = mo61628sM(i);
        AppMethodBeat.m2505o(88161);
        return sM;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(88158);
        int size = this.khh.size();
        AppMethodBeat.m2505o(88158);
        return size;
    }

    /* renamed from: sM */
    public final C42837b mo61628sM(int i) {
        AppMethodBeat.m2504i(88159);
        C42837b c42837b = (C42837b) this.khh.get(i);
        AppMethodBeat.m2505o(88159);
        return c42837b;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88160);
        View a = this.kgW.mo6879a(i, view, mo61628sM(i));
        AppMethodBeat.m2505o(88160);
        return a;
    }
}
