package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;

public final class c implements OnClickListener {
    private Context context;
    private a gxm;

    public interface a {
        void dm(boolean z);
    }

    public static class b {
        public String gxo;
        public int position;
    }

    public c(Context context, a aVar) {
        this.context = context;
        this.gxm = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(108570);
        b bVar = (b) view.getTag();
        String str = bVar.gxo;
        final int i = bVar.position;
        new g(this.context, new com.tencent.mm.plugin.account.friend.ui.g.a() {
            public final void e(boolean z, String str) {
                AppMethodBeat.i(108569);
                c.this.gxm.dm(z);
                AppMethodBeat.o(108569);
            }
        }).m(new int[]{p.cB(str)});
        AppMethodBeat.o(108570);
    }
}
