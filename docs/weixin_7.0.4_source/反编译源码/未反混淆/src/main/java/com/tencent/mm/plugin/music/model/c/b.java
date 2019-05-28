package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.music.f.a.a;
import com.tencent.mm.plugin.music.f.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements c {
    public final boolean load(String str) {
        AppMethodBeat.i(105004);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary lib_name is null");
            AppMethodBeat.o(105004);
            return false;
        } else if (k.kx(str)) {
            AppMethodBeat.o(105004);
            return true;
        } else {
            ab.i("MicroMsg.Music.WechatMusicLoadLibrary", "load library %s", str);
            ClassLoader classLoader = a.class.getClassLoader();
            if (TextUtils.isEmpty(k.ky(str))) {
                ab.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary can't find the lib %s so", str);
                AppMethodBeat.o(105004);
                return false;
            }
            ab.i("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary find and load the lib %s so", k.ky(str));
            k.a(str, classLoader);
            AppMethodBeat.o(105004);
            return true;
        }
    }

    public final String findLibPath(String str) {
        AppMethodBeat.i(105005);
        if (!str.startsWith("lib")) {
            str = "lib".concat(String.valueOf(str));
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        AppMethodBeat.o(105005);
        return str;
    }

    public final boolean Tn(String str) {
        AppMethodBeat.i(105006);
        boolean kx = k.kx(str);
        AppMethodBeat.o(105006);
        return kx;
    }
}
