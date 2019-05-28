package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager efi;
    public static HashMap<String, a> efj = new HashMap();
    private static HashSet<com.tencent.mm.e.a> efk = new HashSet();
    public String efl;

    public class a {
        public HashMap<com.tencent.mm.e.a, d> efo = new HashMap();

        public a() {
            AppMethodBeat.i(116208);
            AppMethodBeat.o(116208);
        }

        public final void clearAll() {
            AppMethodBeat.i(116209);
            for (Entry value : this.efo.entrySet()) {
                ((d) value.getValue()).onDestroy();
            }
            AppMethodBeat.o(116209);
        }
    }

    static {
        AppMethodBeat.i(116214);
        AppMethodBeat.o(116214);
    }

    public static ArtistCacheManager Jc() {
        AppMethodBeat.i(116210);
        if (efi == null) {
            efi = new ArtistCacheManager();
        }
        ArtistCacheManager artistCacheManager = efi;
        AppMethodBeat.o(116210);
        return artistCacheManager;
    }

    public final <T extends d> T a(com.tencent.mm.e.a aVar) {
        d dVar = null;
        AppMethodBeat.i(116211);
        if (efj.containsKey(this.efl)) {
            a aVar2 = (a) efj.get(this.efl);
            if (!aVar2.efo.containsKey(aVar)) {
                switch (aVar) {
                    case DOODLE:
                        dVar = new b();
                        break;
                    case EMOJI_AND_TEXT:
                        dVar = new c();
                        break;
                    case MOSAIC:
                        dVar = new g();
                        break;
                    case CROP_PHOTO:
                        dVar = new a();
                        break;
                }
                if (dVar != null) {
                    dVar.onCreate();
                }
                if (!(dVar == null || aVar2.efo.containsKey(aVar))) {
                    aVar2.efo.put(aVar, dVar);
                }
            }
            d dVar2 = (d) aVar2.efo.get(aVar);
            AppMethodBeat.o(116211);
            return dVar2;
        }
        ab.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", this.efl);
        AppMethodBeat.o(116211);
        return null;
    }

    @Deprecated
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(116212);
        ab.i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear")) {
            Jd();
        }
        AppMethodBeat.o(116212);
    }

    public final void Jd() {
        AppMethodBeat.i(116213);
        ab.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
        for (Entry value : efj.entrySet()) {
            ((a) value.getValue()).clearAll();
        }
        efk.clear();
        efi = null;
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(116206);
                com.tencent.mm.ch.a.asR(e.evi);
                AppMethodBeat.o(116206);
            }
        }, "MicroMsg.ArtistCacheManager[clearAllCache]");
        AppMethodBeat.o(116213);
    }
}
