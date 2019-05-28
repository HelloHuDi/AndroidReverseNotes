package com.tencent.p177mm.plugin.music.model.p1554c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.plugin.music.p463f.p464a.C12665a;
import com.tencent.p177mm.plugin.music.p463f.p464a.C12670c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.model.c.b */
public final class C39442b implements C12670c {
    public final boolean load(String str) {
        AppMethodBeat.m2504i(105004);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary lib_name is null");
            AppMethodBeat.m2505o(105004);
            return false;
        } else if (C1449k.m3080kx(str)) {
            AppMethodBeat.m2505o(105004);
            return true;
        } else {
            C4990ab.m7417i("MicroMsg.Music.WechatMusicLoadLibrary", "load library %s", str);
            ClassLoader classLoader = C12665a.class.getClassLoader();
            if (TextUtils.isEmpty(C1449k.m3081ky(str))) {
                C4990ab.m7413e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary can't find the lib %s so", str);
                AppMethodBeat.m2505o(105004);
                return false;
            }
            C4990ab.m7417i("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary find and load the lib %s so", C1449k.m3081ky(str));
            C1449k.m3079a(str, classLoader);
            AppMethodBeat.m2505o(105004);
            return true;
        }
    }

    public final String findLibPath(String str) {
        AppMethodBeat.m2504i(105005);
        if (!str.startsWith("lib")) {
            str = "lib".concat(String.valueOf(str));
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        AppMethodBeat.m2505o(105005);
        return str;
    }

    /* renamed from: Tn */
    public final boolean mo24626Tn(String str) {
        AppMethodBeat.m2504i(105006);
        boolean kx = C1449k.m3080kx(str);
        AppMethodBeat.m2505o(105006);
        return kx;
    }
}
