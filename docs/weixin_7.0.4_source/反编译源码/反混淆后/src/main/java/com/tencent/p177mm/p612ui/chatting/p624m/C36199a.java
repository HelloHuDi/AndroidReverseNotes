package com.tencent.p177mm.p612ui.chatting.p624m;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12517b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.chatting.m.a */
public abstract class C36199a {
    WeakReference<C30557b> zaF = null;

    /* renamed from: com.tencent.mm.ui.chatting.m.a$a */
    public class C15705a {
        public String link;
        public String username;
    }

    /* renamed from: com.tencent.mm.ui.chatting.m.a$b */
    public interface C30557b {
        /* renamed from: a */
        void mo48964a(View view, C15705a c15705a);

        /* renamed from: aL */
        void mo48965aL(LinkedList<String> linkedList);
    }

    /* renamed from: com.tencent.mm.ui.chatting.m.a$1 */
    class C362001 implements C12517b {
        C362001() {
        }

        /* renamed from: a */
        public final CharSequence mo7904a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
            AppMethodBeat.m2504i(32740);
            String string = bundle.getString("conv_talker_username", "");
            if (map == null) {
                C4990ab.m7420w("MicroMsg.SysMsgHandlerBase", "hy: non map!!");
                AppMethodBeat.m2505o(32740);
                return null;
            } else if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.SysMsgHandlerBase", "hy: non header!!");
                AppMethodBeat.m2505o(32740);
                return null;
            } else if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7420w("MicroMsg.SysMsgHandlerBase", "hy: not resolved talker!!");
                AppMethodBeat.m2505o(32740);
                return null;
            } else {
                CharSequence b = C36199a.this.mo10981b(map, str, bundle, weakReference);
                AppMethodBeat.m2505o(32740);
                return b;
            }
        }
    }

    /* renamed from: b */
    public abstract CharSequence mo10981b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference);

    public abstract String dHh();

    public C36199a(C30557b c30557b) {
        Assert.assertNotNull(c30557b);
        this.zaF = new WeakReference(c30557b);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24439a(dHh(), new C362001());
    }

    public final void release() {
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24434QB(dHh());
    }
}
