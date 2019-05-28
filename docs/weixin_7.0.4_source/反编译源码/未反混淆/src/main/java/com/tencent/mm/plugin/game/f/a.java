package com.tencent.mm.plugin.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> nlT;
    public boolean nns;
    private Map<String, Boolean> nnt;

    public static class a {
        private static a nnu = new a();

        static {
            AppMethodBeat.i(112283);
            AppMethodBeat.o(112283);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        AppMethodBeat.i(112284);
        this.nns = false;
        this.nnt = new ConcurrentHashMap();
        AppMethodBeat.o(112284);
    }

    public final synchronized void clearCache() {
        AppMethodBeat.i(112285);
        if (this.nlT != null) {
            this.nlT.clear();
        }
        this.nns = false;
        AppMethodBeat.o(112285);
    }

    public final synchronized void bFB() {
        AppMethodBeat.i(112286);
        if (this.nlT != null) {
            for (com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar : this.nlT.values()) {
                aVar.gBF = false;
            }
        }
        AppMethodBeat.o(112286);
    }

    public final synchronized void bFC() {
        AppMethodBeat.i(112287);
        if (this.nlT == null) {
            this.nlT = new LinkedHashMap();
        }
        if (this.nlT.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = ah.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        ab.e("MicroMsg.GameCacheUtil", "exception:%s", bo.l(e));
                    }
                }
            } catch (IOException e2) {
                ab.e("MicroMsg.GameCacheUtil", "exception:%s", bo.l(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (IOException e22) {
                        ab.e("MicroMsg.GameCacheUtil", "exception:%s", bo.l(e22));
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        ab.e("MicroMsg.GameCacheUtil", "exception:%s", bo.l(e3));
                    }
                }
                AppMethodBeat.o(112287);
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    ab.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", split[r0]);
                } else {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar = new com.tencent.mm.plugin.game.ui.GameRegionPreference.a();
                    aVar.nlQ = split2[0];
                    aVar.nlR = split2[1];
                    aVar.nlS = split2[2];
                    aVar.dui = split2[3];
                    aVar.gBF = false;
                    aVar.isDefault = false;
                    this.nlT.put(aVar.dui, aVar);
                }
            }
            com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar2 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) this.nlT.get(e.bDS());
            if (aVar2 != null) {
                aVar2.nlQ = e.bDT();
                aVar2.nlR = e.bDU();
                aVar2.nlS = e.bDV();
                aVar2.isDefault = true;
            }
        }
        AppMethodBeat.o(112287);
    }

    public final synchronized Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> bFD() {
        Map map;
        AppMethodBeat.i(112288);
        bFC();
        map = this.nlT;
        AppMethodBeat.o(112288);
        return map;
    }

    public final synchronized boolean Op(String str) {
        boolean z;
        AppMethodBeat.i(112289);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(112289);
            z = false;
        } else if (this.nnt.containsKey(str) && ((Boolean) this.nnt.get(str)).booleanValue()) {
            AppMethodBeat.o(112289);
            z = false;
        } else {
            ab.i("MicroMsg.GameCacheUtil", "download entrance image start : %s", str);
            this.nnt.put(str, Boolean.TRUE);
            AppMethodBeat.o(112289);
            z = true;
        }
        return z;
    }

    public final synchronized void Oq(String str) {
        AppMethodBeat.i(112290);
        if (!bo.isNullOrNil(str) && this.nnt.containsKey(str)) {
            ab.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", str);
            this.nnt.remove(str);
        }
        AppMethodBeat.o(112290);
    }
}
