package com.tencent.p177mm.plugin.game.p428f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.p433ui.GameRegionPreference.C3265a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.game.f.a */
public final class C46000a {
    private Map<String, C3265a> nlT;
    public boolean nns;
    private Map<String, Boolean> nnt;

    /* renamed from: com.tencent.mm.plugin.game.f.a$a */
    public static class C3220a {
        private static C46000a nnu = new C46000a();

        static {
            AppMethodBeat.m2504i(112283);
            AppMethodBeat.m2505o(112283);
        }
    }

    /* synthetic */ C46000a(byte b) {
        this();
    }

    private C46000a() {
        AppMethodBeat.m2504i(112284);
        this.nns = false;
        this.nnt = new ConcurrentHashMap();
        AppMethodBeat.m2505o(112284);
    }

    public final synchronized void clearCache() {
        AppMethodBeat.m2504i(112285);
        if (this.nlT != null) {
            this.nlT.clear();
        }
        this.nns = false;
        AppMethodBeat.m2505o(112285);
    }

    public final synchronized void bFB() {
        AppMethodBeat.m2504i(112286);
        if (this.nlT != null) {
            for (C3265a c3265a : this.nlT.values()) {
                c3265a.gBF = false;
            }
        }
        AppMethodBeat.m2505o(112286);
    }

    public final synchronized void bFC() {
        AppMethodBeat.m2504i(112287);
        if (this.nlT == null) {
            this.nlT = new LinkedHashMap();
        }
        if (this.nlT.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = C4996ah.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.GameCacheUtil", "exception:%s", C5046bo.m7574l(e));
                    }
                }
            } catch (IOException e2) {
                C4990ab.m7413e("MicroMsg.GameCacheUtil", "exception:%s", C5046bo.m7574l(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (IOException e22) {
                        C4990ab.m7413e("MicroMsg.GameCacheUtil", "exception:%s", C5046bo.m7574l(e22));
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
                        C4990ab.m7413e("MicroMsg.GameCacheUtil", "exception:%s", C5046bo.m7574l(e3));
                    }
                }
                AppMethodBeat.m2505o(112287);
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    C4990ab.m7413e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", split[r0]);
                } else {
                    C3265a c3265a = new C3265a();
                    c3265a.nlQ = split2[0];
                    c3265a.nlR = split2[1];
                    c3265a.nlS = split2[2];
                    c3265a.dui = split2[3];
                    c3265a.gBF = false;
                    c3265a.isDefault = false;
                    this.nlT.put(c3265a.dui, c3265a);
                }
            }
            C3265a c3265a2 = (C3265a) this.nlT.get(C20993e.bDS());
            if (c3265a2 != null) {
                c3265a2.nlQ = C20993e.bDT();
                c3265a2.nlR = C20993e.bDU();
                c3265a2.nlS = C20993e.bDV();
                c3265a2.isDefault = true;
            }
        }
        AppMethodBeat.m2505o(112287);
    }

    public final synchronized Map<String, C3265a> bFD() {
        Map map;
        AppMethodBeat.m2504i(112288);
        bFC();
        map = this.nlT;
        AppMethodBeat.m2505o(112288);
        return map;
    }

    /* renamed from: Op */
    public final synchronized boolean mo73885Op(String str) {
        boolean z;
        AppMethodBeat.m2504i(112289);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112289);
            z = false;
        } else if (this.nnt.containsKey(str) && ((Boolean) this.nnt.get(str)).booleanValue()) {
            AppMethodBeat.m2505o(112289);
            z = false;
        } else {
            C4990ab.m7417i("MicroMsg.GameCacheUtil", "download entrance image start : %s", str);
            this.nnt.put(str, Boolean.TRUE);
            AppMethodBeat.m2505o(112289);
            z = true;
        }
        return z;
    }

    /* renamed from: Oq */
    public final synchronized void mo73886Oq(String str) {
        AppMethodBeat.m2504i(112290);
        if (!C5046bo.isNullOrNil(str) && this.nnt.containsKey(str)) {
            C4990ab.m7417i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", str);
            this.nnt.remove(str);
        }
        AppMethodBeat.m2505o(112290);
    }
}
