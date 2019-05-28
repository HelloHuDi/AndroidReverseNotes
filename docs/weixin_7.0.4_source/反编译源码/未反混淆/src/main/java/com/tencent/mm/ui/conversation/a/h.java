package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class h extends b {
    public h(Context context) {
        super(context);
        AppMethodBeat.i(34656);
        if (this.view != null) {
            this.view.findViewById(R.id.bob).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34655);
                    aw.ZK();
                    c.Ry().set(65833, Integer.valueOf(0));
                    ((Context) h.this.vlu.get()).startActivity(new Intent((Context) h.this.vlu.get(), FacebookFriendUI.class));
                    h.this.view.setVisibility(8);
                    AppMethodBeat.o(34655);
                }
            });
        }
        AppMethodBeat.o(34656);
    }

    public final int getLayoutId() {
        AppMethodBeat.i(34657);
        com.tencent.mm.au.b.ahN();
        AppMethodBeat.o(34657);
        return -1;
    }

    public final void destroy() {
    }
}
