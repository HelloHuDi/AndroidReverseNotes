package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.account.friend.p273ui.C9906g.C9907a;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.c */
public final class C45500c implements OnClickListener {
    private Context context;
    private C9900a gxm;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.c$a */
    public interface C9900a {
        /* renamed from: dm */
        void mo21257dm(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.c$b */
    public static class C26598b {
        public String gxo;
        public int position;
    }

    public C45500c(Context context, C9900a c9900a) {
        this.context = context;
        this.gxm = c9900a;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(108570);
        C26598b c26598b = (C26598b) view.getTag();
        String str = c26598b.gxo;
        final int i = c26598b.position;
        new C9906g(this.context, new C9907a() {
            /* renamed from: e */
            public final void mo5748e(boolean z, String str) {
                AppMethodBeat.m2504i(108569);
                C45500c.this.gxm.mo21257dm(z);
                AppMethodBeat.m2505o(108569);
            }
        }).mo21262m(new int[]{C1183p.m2611cB(str)});
        AppMethodBeat.m2505o(108570);
    }
}
