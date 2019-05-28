package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;
import java.util.Map;

public final class a implements f {
    a ueQ = new a(this, (byte) 0);
    private c ueR = new c<mq>() {
        {
            AppMethodBeat.i(5649);
            this.xxI = mq.class.getName().hashCode();
            AppMethodBeat.o(5649);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(5650);
            mq mqVar = (mq) bVar;
            if (mqVar instanceof mq) {
                a.this.ueQ.a(mqVar.cIt.type, mqVar.cIt.query, mqVar.cIt.cIu, mqVar.cIt.cIv, mqVar.cIt.cIw);
                AppMethodBeat.o(5650);
                return true;
            }
            AppMethodBeat.o(5650);
            return false;
        }
    };

    class a {
        boolean cxT;
        boolean isRunning;
        private b ueT;
        private String ueU;
        private long ueV;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        private static String dz(String str, int i) {
            AppMethodBeat.i(5651);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            String x = g.x(stringBuffer.toString().getBytes());
            AppMethodBeat.o(5651);
            return x;
        }

        public final void a(int i, String str, String str2, int i2, long j) {
            AppMethodBeat.i(5652);
            if (bo.isNullOrNil(str)) {
                String str3 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str4 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str2 == null ? "" : str2.toString();
                ab.i(str3, str4, objArr);
                AppMethodBeat.o(5652);
                return;
            }
            String dz = dz(str, i);
            if (!bo.isNullOrNil(this.ueU) && this.ueU.equals(dz) && System.currentTimeMillis() - this.ueV <= 8000 && bo.isNullOrNil(str2)) {
                if (this.cxT) {
                    ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", str);
                    h.JR(i2).a(this.ueT.cWk().wWr, true, aa.b(this.ueT.cWk().wok), this.ueT.cWk().won);
                    AppMethodBeat.o(5652);
                    return;
                } else if (this.isRunning) {
                    if (this.ueT != null) {
                        this.ueT.ueW = i2;
                    }
                    ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    AppMethodBeat.o(5652);
                    return;
                } else {
                    ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", str, dz, Integer.valueOf(i2));
            if (this.ueT != null) {
                com.tencent.mm.kernel.g.Rg().c(this.ueT);
            }
            this.ueU = dz;
            this.ueV = System.currentTimeMillis();
            this.isRunning = true;
            this.cxT = false;
            com.tencent.mm.kernel.g.Rg().a((int) d.MIC_PTU_FENGJING, a.this);
            this.ueT = new b(i, str, str2.getBytes(), i2, j);
            com.tencent.mm.kernel.g.Rg().a(this.ueT, 0);
            AppMethodBeat.o(5652);
        }
    }

    public a() {
        AppMethodBeat.i(5653);
        com.tencent.mm.sdk.b.a.xxA.c(this.ueR);
        AppMethodBeat.o(5653);
    }

    public final boolean ar(Map<String, Object> map) {
        long j;
        AppMethodBeat.i(5654);
        ab.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", map.toString());
        String t = t(map, "keyword");
        String t2 = t(map, "nextPageBuffer");
        int v = v(map, "type");
        int v2 = v(map, "webview_instance_id");
        String t3 = t(map, "searchID");
        if (bo.isNullOrNil(t3)) {
            j = 0;
        } else {
            j = Long.valueOf(t3).longValue();
        }
        this.ueQ.a(v, t, t2, v2, j);
        AppMethodBeat.o(5654);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(5655);
        if (mVar instanceof b) {
            com.tencent.mm.kernel.g.Rg().b((int) d.MIC_PTU_FENGJING, (f) this);
            this.ueQ.isRunning = false;
            b bVar = (b) mVar;
            if (i == 0 && i2 == 0) {
                this.ueQ.cxT = true;
            } else {
                this.ueQ.cxT = false;
                h.JR(bVar.ueW).a("{}", bVar.ueX, "", 0);
            }
            h.JR(bVar.ueW).a(bVar.cWk().wWr, bVar.ueX, aa.b(bVar.cWk().wok), bVar.cWk().won);
        }
        AppMethodBeat.o(5655);
    }

    public static String t(Map<String, Object> map, String str) {
        AppMethodBeat.i(5656);
        String str2;
        if (!map.containsKey(str)) {
            str2 = "";
            AppMethodBeat.o(5656);
            return str2;
        } else if (map.get(str) != null) {
            str2 = map.get(str).toString();
            AppMethodBeat.o(5656);
            return str2;
        } else {
            str2 = "";
            AppMethodBeat.o(5656);
            return str2;
        }
    }

    public static int v(Map<String, Object> map, String str) {
        AppMethodBeat.i(5657);
        String t = t(map, str);
        if (bo.isNullOrNil(t)) {
            AppMethodBeat.o(5657);
            return 0;
        }
        int intValue = Integer.valueOf(t).intValue();
        AppMethodBeat.o(5657);
        return intValue;
    }
}
