package com.tencent.p177mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.opensdk.utils.c */
public final class C18752c {

    /* renamed from: com.tencent.mm.opensdk.utils.c$a */
    public static final class C18751a {
        /* renamed from: a */
        public static Object m29303a(int i, String str) {
            AppMethodBeat.m2504i(128070);
            switch (i) {
                case 1:
                    Integer valueOf = Integer.valueOf(str);
                    AppMethodBeat.m2505o(128070);
                    return valueOf;
                case 2:
                    Long valueOf2 = Long.valueOf(str);
                    AppMethodBeat.m2505o(128070);
                    return valueOf2;
                case 3:
                    AppMethodBeat.m2505o(128070);
                    return str;
                case 4:
                    Boolean valueOf3 = Boolean.valueOf(str);
                    AppMethodBeat.m2505o(128070);
                    return valueOf3;
                case 5:
                    Float valueOf4 = Float.valueOf(str);
                    AppMethodBeat.m2505o(128070);
                    return valueOf4;
                case 6:
                    Double valueOf5 = Double.valueOf(str);
                    AppMethodBeat.m2505o(128070);
                    return valueOf5;
                default:
                    try {
                        Log.m4140e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                        break;
                    } catch (Exception e) {
                        Log.m4140e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                        break;
                    }
            }
            AppMethodBeat.m2505o(128070);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.opensdk.utils.c$b */
    public static final class C18753b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");

        static {
            AppMethodBeat.m2504i(128064);
            AppMethodBeat.m2505o(128064);
        }
    }
}
