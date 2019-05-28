package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    WeakReference<b> zaF = null;

    public class a {
        public String link;
        public String username;
    }

    public interface b {
        void a(View view, a aVar);

        void aL(LinkedList<String> linkedList);
    }

    public abstract CharSequence b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference);

    public abstract String dHh();

    public a(b bVar) {
        Assert.assertNotNull(bVar);
        this.zaF = new WeakReference(bVar);
        ((e) g.K(e.class)).a(dHh(), new com.tencent.mm.plugin.messenger.a.e.b() {
            public final CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
                AppMethodBeat.i(32740);
                String string = bundle.getString("conv_talker_username", "");
                if (map == null) {
                    ab.w("MicroMsg.SysMsgHandlerBase", "hy: non map!!");
                    AppMethodBeat.o(32740);
                    return null;
                } else if (bo.isNullOrNil(str)) {
                    ab.w("MicroMsg.SysMsgHandlerBase", "hy: non header!!");
                    AppMethodBeat.o(32740);
                    return null;
                } else if (bo.isNullOrNil(string)) {
                    ab.w("MicroMsg.SysMsgHandlerBase", "hy: not resolved talker!!");
                    AppMethodBeat.o(32740);
                    return null;
                } else {
                    CharSequence b = a.this.b(map, str, bundle, weakReference);
                    AppMethodBeat.o(32740);
                    return b;
                }
            }
        });
    }

    public final void release() {
        ((e) g.K(e.class)).QB(dHh());
    }
}
