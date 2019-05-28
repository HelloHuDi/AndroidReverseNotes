package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class d extends u {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstance";
    private static Vector<String> hzY = new Vector();

    static class a extends a {
        public String appId = "";
        public int bJt = 0;
        public String ckD = "";
        public String hAa = "";

        public final void Dp() {
            AppMethodBeat.i(137719);
            ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", Integer.valueOf(this.bJt));
            this.hAa = "";
            t tVar;
            if (this.bJt == 0) {
                ab.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", this.appId, this.ckD);
                t tVar2 = new t();
                tVar2.csI.action = 10;
                tVar2.csI.appId = r0;
                tVar2.csI.ckD = r1;
                com.tencent.mm.plugin.music.b.a.a(tVar2);
                this.ckD = tVar2.csI.ckD;
                ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", this.ckD);
                if (TextUtils.isEmpty(this.ckD)) {
                    this.hAa = "fail to create audio instance";
                }
            } else if (this.bJt == 1) {
                ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
                ab.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", this.appId);
                tVar = new t();
                tVar.csI.action = 12;
                tVar.csI.appId = r0;
                com.tencent.mm.plugin.music.b.a.a(tVar);
            } else if (this.bJt == 2) {
                ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
                ab.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", this.appId);
                tVar = new t();
                tVar.csI.action = 9;
                tVar.csI.appId = r0;
                com.tencent.mm.plugin.music.b.a.a(tVar);
                com.tencent.mm.plugin.appbrand.media.a.a.Cs(this.appId);
            }
            wM();
            AppMethodBeat.o(137719);
        }

        public final void wM() {
            AppMethodBeat.i(137720);
            super.wM();
            if (this.bJt != 0) {
                if (this.bJt != 1) {
                    ab.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
                }
                AppMethodBeat.o(137720);
            } else if (TextUtils.isEmpty(this.ckD)) {
                ab.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
                AppMethodBeat.o(137720);
            } else {
                ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
                AppMethodBeat.o(137720);
            }
        }
    }

    static {
        AppMethodBeat.i(137722);
        AppMethodBeat.o(137722);
    }

    public final String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(137721);
        final String appId = cVar.getAppId();
        String bSy = e.bSy();
        HashMap hashMap = new HashMap();
        hashMap.put("audioId", bSy);
        ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", appId, bSy);
        a aVar = new a();
        aVar.ckD = bSy;
        aVar.bJt = 0;
        aVar.appId = appId;
        aVar.aCr();
        g.c anonymousClass1 = new g.c() {
            public final void onCreate() {
                AppMethodBeat.i(137715);
                com.tencent.mm.plugin.appbrand.media.a.a.ao(appId, true);
                AppMethodBeat.o(137715);
            }

            public final void onResume() {
                AppMethodBeat.i(137716);
                com.tencent.mm.plugin.appbrand.media.a.a.ao(appId, true);
                AppMethodBeat.o(137716);
            }

            public final void a(com.tencent.mm.plugin.appbrand.g.d dVar) {
                AppMethodBeat.i(137717);
                ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", appId);
                com.tencent.mm.plugin.appbrand.media.a.a.ao(appId, false);
                a aVar = new a();
                aVar.bJt = 1;
                aVar.appId = appId;
                aVar.aCr();
                AppMethodBeat.o(137717);
            }

            public final void onDestroy() {
                AppMethodBeat.i(137718);
                ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", appId);
                a aVar = new a();
                aVar.bJt = 2;
                aVar.appId = appId;
                aVar.aCs();
                g.b(appId, this);
                d.hzY.remove(appId);
                AppMethodBeat.o(137718);
            }
        };
        if (!hzY.contains(appId)) {
            g.a(appId, anonymousClass1);
            hzY.add(appId);
        }
        appId = j("ok", hashMap);
        AppMethodBeat.o(137721);
        return appId;
    }
}
