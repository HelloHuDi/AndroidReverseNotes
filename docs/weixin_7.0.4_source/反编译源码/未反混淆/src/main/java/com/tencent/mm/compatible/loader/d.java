package com.tencent.mm.compatible.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static Map<String, String> eut;

    public static String B(Context context, String str) {
        AppMethodBeat.i(93035);
        long anU = bo.anU();
        if (eut == null) {
            try {
                ab.i("MicroMsg.PluginClassLoader", "ensurePreloadFiles");
                Map amt = u.amt(bo.convertStreamToString(context.getAssets().open("preload/libraries.ini")));
                ab.i("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", r0);
                if (amt == null || amt.size() <= 0) {
                    ab.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
                } else {
                    eut = new HashMap(amt.size());
                    for (Entry entry : amt.entrySet()) {
                        ab.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", entry.getKey(), entry.getValue());
                        eut.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
                ab.printErrStackTrace("MicroMsg.PluginClassLoader", e, "", new Object[0]);
            }
        }
        String absolutePath = context.getDir("lib", 0).getAbsolutePath();
        if (eut == null) {
            ab.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
            AppMethodBeat.o(93035);
            return null;
        }
        String str2 = absolutePath + "/" + str;
        absolutePath = (String) eut.get(str);
        if (absolutePath == null) {
            ab.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
            AppMethodBeat.o(93035);
            return null;
        }
        b bVar = new b(str2);
        if (bVar.exists()) {
            String atg = e.atg(j.w(bVar.mUri));
            if (atg == null || !atg.equalsIgnoreCase(absolutePath)) {
                ab.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", atg, absolutePath);
            } else {
                ab.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", bVar, Long.valueOf(bo.gb(anU)));
                AppMethodBeat.o(93035);
                return str2;
            }
        }
        e.deleteFile(str2);
        if (e.y("assets:///preload/".concat(String.valueOf(str)), str2) < 0) {
            ab.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
            AppMethodBeat.o(93035);
            return null;
        }
        ab.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", Long.valueOf(bo.gb(anU)), str, absolutePath);
        AppMethodBeat.o(93035);
        return str2;
    }
}
