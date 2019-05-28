package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a {
    public String cBb;
    public int cBc;
    public String cwz;
    private HashMap<String, c> fBy;
    public String ikS;
    public String ikT;

    public static class a {
        private static a ikU = new a();

        static {
            AppMethodBeat.i(137836);
            AppMethodBeat.o(137836);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        AppMethodBeat.i(137837);
        this.fBy = new HashMap();
        AppMethodBeat.o(137837);
    }

    public final boolean cD(String str, String str2) {
        AppMethodBeat.i(137838);
        if (str2.equalsIgnoreCase("play")) {
            ab.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", str, this.ikS);
            AppMethodBeat.o(137838);
            return true;
        }
        if (str.equalsIgnoreCase(this.ikS)) {
            e aih = com.tencent.mm.aw.a.aih();
            if (aih != null && aih.fJU.equals(this.ikT)) {
                AppMethodBeat.o(137838);
                return true;
            }
        }
        AppMethodBeat.o(137838);
        return false;
    }

    public final void a(c cVar, String str) {
        AppMethodBeat.i(137839);
        if (this.fBy.get(str) != null) {
            ab.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", str);
            AppMethodBeat.o(137839);
            return;
        }
        com.tencent.mm.sdk.b.a.xxA.c(cVar);
        this.fBy.put(str, cVar);
        AppMethodBeat.o(137839);
    }

    public final void Cv(String str) {
        AppMethodBeat.i(137840);
        if (this.fBy.get(str) == null) {
            ab.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", str);
            AppMethodBeat.o(137840);
            return;
        }
        com.tencent.mm.sdk.b.a.xxA.d((c) this.fBy.remove(str));
        this.fBy.remove(str);
        AppMethodBeat.o(137840);
    }

    public final boolean Cw(String str) {
        AppMethodBeat.i(137841);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            AppMethodBeat.o(137841);
            return false;
        } else if (!str.equalsIgnoreCase(this.ikS)) {
            ab.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            AppMethodBeat.o(137841);
            return false;
        } else if (TextUtils.isEmpty(this.ikT)) {
            ab.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            AppMethodBeat.o(137841);
            return false;
        } else {
            e aih = com.tencent.mm.aw.a.aih();
            if (aih == null) {
                ab.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                AppMethodBeat.o(137841);
                return false;
            } else if (!this.ikT.equalsIgnoreCase(aih.fJU)) {
                ab.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                AppMethodBeat.o(137841);
                return false;
            } else if (com.tencent.mm.aw.a.aie()) {
                AppMethodBeat.o(137841);
                return true;
            } else {
                ab.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                AppMethodBeat.o(137841);
                return false;
            }
        }
    }
}
