package com.tencent.p177mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.webview.C37407a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.luggage.d */
public final class C12146d {
    private static HashMap<String, C12149a> ezU = new HashMap();
    private static HashMap<String, C32186k> mTT = new HashMap();
    private static LinkedList<String> mTU = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.game.luggage.d$b */
    static class C12147b implements C37866a<Bundle, Bundle> {
        private C12147b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(135834);
            Bundle bundle = (Bundle) obj;
            switch (bundle.getInt("action_id")) {
                case 1:
                    String string = bundle.getString("preload_url");
                    Class cls = (Class) bundle.getSerializable("webcore_impl_class");
                    if (!(TextUtils.isEmpty(string) || cls == null)) {
                        C12146d.m20086a(cls, string, new C12149a() {
                            /* renamed from: wM */
                            public final void mo7076wM() {
                                AppMethodBeat.m2504i(135833);
                                c18507c.mo5960ao(new Bundle());
                                AppMethodBeat.m2505o(135833);
                            }
                        });
                        AppMethodBeat.m2505o(135834);
                        return;
                    }
                case 2:
                    C12146d.destroy();
                    break;
            }
            AppMethodBeat.m2505o(135834);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d$a */
    public interface C12149a {
        /* renamed from: wM */
        void mo7076wM();
    }

    static {
        AppMethodBeat.m2504i(135839);
        AppMethodBeat.m2505o(135839);
    }

    /* renamed from: a */
    public static void m20086a(final Class<? extends C37407a> cls, final String str, final C12149a c12149a) {
        AppMethodBeat.m2504i(135835);
        if (!C4996ah.doF()) {
            Bundle bundle = new Bundle();
            bundle.putInt("action_id", 1);
            bundle.putString("preload_url", str);
            bundle.putSerializable("webcore_impl_class", cls);
            ToolsProcessIPCService.m63913a(bundle, C12147b.class, new C18507c<Bundle>() {
                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(135831);
                    if (c12149a != null) {
                        c12149a.mo7076wM();
                    }
                    AppMethodBeat.m2505o(135831);
                }
            });
            AppMethodBeat.m2505o(135835);
        } else if (mTU.contains(str)) {
            C4990ab.m7416i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
            c12149a.mo7076wM();
            AppMethodBeat.m2505o(135835);
        } else {
            mTU.add(str);
            C18514l.m28819q(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(135832);
                    C32186k c32186k = new C32186k(C4996ah.getContext(), cls);
                    C12146d.mTT.put(str, c32186k);
                    C12146d.mTU.remove(str);
                    if (!TextUtils.isEmpty(str)) {
                        C4990ab.m7417i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", str);
                        c32186k.loadUrl(str);
                    }
                    if (c12149a != null) {
                        c12149a.mo7076wM();
                    }
                    AppMethodBeat.m2505o(135832);
                }
            });
            AppMethodBeat.m2505o(135835);
        }
    }

    /* renamed from: aq */
    public static C32186k m20087aq(Context context, String str) {
        AppMethodBeat.m2504i(135836);
        C32186k c32186k = (C32186k) mTT.remove(str);
        if (c32186k != null) {
            c32186k.setContext(context);
        }
        AppMethodBeat.m2505o(135836);
        return c32186k;
    }

    /* renamed from: NO */
    public static C32186k m20085NO(String str) {
        AppMethodBeat.m2504i(135837);
        C32186k c32186k = (C32186k) mTT.get(str);
        AppMethodBeat.m2505o(135837);
        return c32186k;
    }

    public static void destroy() {
        AppMethodBeat.m2504i(135838);
        if (C4996ah.doF()) {
            for (C32186k destroy : mTT.values()) {
                destroy.destroy();
            }
            mTT.clear();
            AppMethodBeat.m2505o(135838);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action_id", 2);
        ToolsProcessIPCService.m63913a(bundle, C12147b.class, null);
        AppMethodBeat.m2505o(135838);
    }
}
