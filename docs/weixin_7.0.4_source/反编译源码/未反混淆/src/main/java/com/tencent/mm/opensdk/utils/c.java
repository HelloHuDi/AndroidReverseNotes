package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public static final class a {
        public static Object a(int i, String str) {
            AppMethodBeat.i(128070);
            switch (i) {
                case 1:
                    Integer valueOf = Integer.valueOf(str);
                    AppMethodBeat.o(128070);
                    return valueOf;
                case 2:
                    Long valueOf2 = Long.valueOf(str);
                    AppMethodBeat.o(128070);
                    return valueOf2;
                case 3:
                    AppMethodBeat.o(128070);
                    return str;
                case 4:
                    Boolean valueOf3 = Boolean.valueOf(str);
                    AppMethodBeat.o(128070);
                    return valueOf3;
                case 5:
                    Float valueOf4 = Float.valueOf(str);
                    AppMethodBeat.o(128070);
                    return valueOf4;
                case 6:
                    Double valueOf5 = Double.valueOf(str);
                    AppMethodBeat.o(128070);
                    return valueOf5;
                default:
                    try {
                        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                        break;
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                        break;
                    }
            }
            AppMethodBeat.o(128070);
            return null;
        }
    }

    public static final class b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");

        static {
            AppMethodBeat.i(128064);
            AppMethodBeat.o(128064);
        }
    }
}
