package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.plugin.account.p275ui.FacebookFriendUI;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;

/* renamed from: com.tencent.mm.ui.conversation.a.h */
public final class C46677h extends C14933b {

    /* renamed from: com.tencent.mm.ui.conversation.a.h$1 */
    class C362621 implements OnClickListener {
        C362621() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34655);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(65833, Integer.valueOf(0));
            ((Context) C46677h.this.vlu.get()).startActivity(new Intent((Context) C46677h.this.vlu.get(), FacebookFriendUI.class));
            C46677h.this.view.setVisibility(8);
            AppMethodBeat.m2505o(34655);
        }
    }

    public C46677h(Context context) {
        super(context);
        AppMethodBeat.m2504i(34656);
        if (this.view != null) {
            this.view.findViewById(2131823849).setOnClickListener(new C362621());
        }
        AppMethodBeat.m2505o(34656);
    }

    public final int getLayoutId() {
        AppMethodBeat.m2504i(34657);
        C17950b.ahN();
        AppMethodBeat.m2505o(34657);
        return -1;
    }

    public final void destroy() {
    }
}
