package com.tencent.p177mm.compatible.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5066u;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.compatible.loader.d */
public final class C26049d {
    private static Map<String, String> eut;

    /* renamed from: B */
    public static String m41592B(Context context, String str) {
        AppMethodBeat.m2504i(93035);
        long anU = C5046bo.anU();
        if (eut == null) {
            try {
                C4990ab.m7416i("MicroMsg.PluginClassLoader", "ensurePreloadFiles");
                Map amt = C5066u.amt(C5046bo.convertStreamToString(context.getAssets().open("preload/libraries.ini")));
                C4990ab.m7417i("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", r0);
                if (amt == null || amt.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
                } else {
                    eut = new HashMap(amt.size());
                    for (Entry entry : amt.entrySet()) {
                        C4990ab.m7411d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", entry.getKey(), entry.getValue());
                        eut.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.PluginClassLoader", "load preload libraries failed");
                C4990ab.printErrStackTrace("MicroMsg.PluginClassLoader", e, "", new Object[0]);
            }
        }
        String absolutePath = context.getDir("lib", 0).getAbsolutePath();
        if (eut == null) {
            C4990ab.m7412e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
            AppMethodBeat.m2505o(93035);
            return null;
        }
        String str2 = absolutePath + "/" + str;
        absolutePath = (String) eut.get(str);
        if (absolutePath == null) {
            C4990ab.m7420w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
            AppMethodBeat.m2505o(93035);
            return null;
        }
        C5728b c5728b = new C5728b(str2);
        if (c5728b.exists()) {
            String atg = C5730e.atg(C5736j.m8649w(c5728b.mUri));
            if (atg == null || !atg.equalsIgnoreCase(absolutePath)) {
                C4990ab.m7413e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", atg, absolutePath);
            } else {
                C4990ab.m7411d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", c5728b, Long.valueOf(C5046bo.m7566gb(anU)));
                AppMethodBeat.m2505o(93035);
                return str2;
            }
        }
        C5730e.deleteFile(str2);
        if (C5730e.m8644y("assets:///preload/".concat(String.valueOf(str)), str2) < 0) {
            C4990ab.m7414f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
            AppMethodBeat.m2505o(93035);
            return null;
        }
        C4990ab.m7417i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", Long.valueOf(C5046bo.m7566gb(anU)), str, absolutePath);
        AppMethodBeat.m2505o(93035);
        return str2;
    }
}
