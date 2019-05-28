package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.LinkedList;

public final class d {
    private static HashMap<String, a> ezU = new HashMap();
    private static HashMap<String, k> mTT = new HashMap();
    private static LinkedList<String> mTU = new LinkedList();

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(135834);
            Bundle bundle = (Bundle) obj;
            switch (bundle.getInt("action_id")) {
                case 1:
                    String string = bundle.getString("preload_url");
                    Class cls = (Class) bundle.getSerializable("webcore_impl_class");
                    if (!(TextUtils.isEmpty(string) || cls == null)) {
                        d.a(cls, string, new a() {
                            public final void wM() {
                                AppMethodBeat.i(135833);
                                cVar.ao(new Bundle());
                                AppMethodBeat.o(135833);
                            }
                        });
                        AppMethodBeat.o(135834);
                        return;
                    }
                case 2:
                    d.destroy();
                    break;
            }
            AppMethodBeat.o(135834);
        }
    }

    public interface a {
        void wM();
    }

    static {
        AppMethodBeat.i(135839);
        AppMethodBeat.o(135839);
    }

    public static void a(final Class<? extends com.tencent.luggage.webview.a> cls, final String str, final a aVar) {
        AppMethodBeat.i(135835);
        if (!ah.doF()) {
            Bundle bundle = new Bundle();
            bundle.putInt("action_id", 1);
            bundle.putString("preload_url", str);
            bundle.putSerializable("webcore_impl_class", cls);
            ToolsProcessIPCService.a(bundle, b.class, new c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(135831);
                    if (aVar != null) {
                        aVar.wM();
                    }
                    AppMethodBeat.o(135831);
                }
            });
            AppMethodBeat.o(135835);
        } else if (mTU.contains(str)) {
            ab.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
            aVar.wM();
            AppMethodBeat.o(135835);
        } else {
            mTU.add(str);
            l.q(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(135832);
                    k kVar = new k(ah.getContext(), cls);
                    d.mTT.put(str, kVar);
                    d.mTU.remove(str);
                    if (!TextUtils.isEmpty(str)) {
                        ab.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", str);
                        kVar.loadUrl(str);
                    }
                    if (aVar != null) {
                        aVar.wM();
                    }
                    AppMethodBeat.o(135832);
                }
            });
            AppMethodBeat.o(135835);
        }
    }

    public static k aq(Context context, String str) {
        AppMethodBeat.i(135836);
        k kVar = (k) mTT.remove(str);
        if (kVar != null) {
            kVar.setContext(context);
        }
        AppMethodBeat.o(135836);
        return kVar;
    }

    public static k NO(String str) {
        AppMethodBeat.i(135837);
        k kVar = (k) mTT.get(str);
        AppMethodBeat.o(135837);
        return kVar;
    }

    public static void destroy() {
        AppMethodBeat.i(135838);
        if (ah.doF()) {
            for (k destroy : mTT.values()) {
                destroy.destroy();
            }
            mTT.clear();
            AppMethodBeat.o(135838);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action_id", 2);
        ToolsProcessIPCService.a(bundle, b.class, null);
        AppMethodBeat.o(135838);
    }
}
