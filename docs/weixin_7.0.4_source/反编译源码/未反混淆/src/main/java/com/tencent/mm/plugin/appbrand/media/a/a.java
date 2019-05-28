package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static Map<String, c> ikF = new ConcurrentHashMap();
    private static Map<String, c> ikG = new HashMap();
    private static ArrayList<String> ikH = new ArrayList();
    private static Map<String, Boolean> ikI = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(137803);
        AppMethodBeat.o(137803);
    }

    public static void onCreate(String str) {
        AppMethodBeat.i(137795);
        ab.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        ikF.clear();
        b.onCreate(str);
        ikI.put(str, Boolean.TRUE);
        AppMethodBeat.o(137795);
    }

    public static void AO(String str) {
        AppMethodBeat.i(137796);
        ab.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
        b.AO(str);
        ikF.clear();
        Iterator it = ikH.iterator();
        while (it.hasNext()) {
            c cVar = (c) ikG.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xxA.d(cVar);
            }
        }
        ikG.clear();
        ikH.clear();
        ikI.remove(str);
        AppMethodBeat.o(137796);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(137797);
        ikF.put(str, cVar);
        AppMethodBeat.o(137797);
    }

    public static c Cr(String str) {
        AppMethodBeat.i(137798);
        c cVar = (c) ikF.get(str);
        AppMethodBeat.o(137798);
        return cVar;
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(137799);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
            AppMethodBeat.o(137799);
        } else if (cVar == null) {
            ab.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
            AppMethodBeat.o(137799);
        } else {
            if (ikG.containsKey(str)) {
                Cs(str);
            }
            ab.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", str);
            ikG.put(str, cVar);
            if (!ikH.contains(str)) {
                ikH.add(str);
            }
            com.tencent.mm.sdk.b.a.xxA.b(cVar);
            AppMethodBeat.o(137799);
        }
    }

    public static void Cs(String str) {
        AppMethodBeat.i(137800);
        if (ikG.containsKey(str)) {
            ab.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", str);
            ikH.remove(str);
            c cVar = (c) ikG.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xxA.d(cVar);
            }
            AppMethodBeat.o(137800);
            return;
        }
        ab.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", str);
        AppMethodBeat.o(137800);
    }

    public static boolean Ct(String str) {
        AppMethodBeat.i(137801);
        if (ikI.containsKey(str)) {
            boolean booleanValue = ((Boolean) ikI.get(str)).booleanValue();
            AppMethodBeat.o(137801);
            return booleanValue;
        }
        AppMethodBeat.o(137801);
        return false;
    }

    public static void ao(String str, boolean z) {
        AppMethodBeat.i(137802);
        ikI.put(str, Boolean.valueOf(z));
        AppMethodBeat.o(137802);
    }
}
