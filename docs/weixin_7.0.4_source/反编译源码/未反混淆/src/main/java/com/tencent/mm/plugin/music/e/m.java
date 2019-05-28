package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.music.model.b.c;
import com.tencent.mm.plugin.music.model.d.d;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class m extends g implements f, e {
    private int mode = 1;
    private int oMa;
    private List<String> oMb = new ArrayList();
    private com.tencent.mm.plugin.music.model.notification.b oMc = new com.tencent.mm.plugin.music.model.notification.b();
    private com.tencent.mm.plugin.music.model.b.b oMd;
    private com.tencent.mm.plugin.music.model.b.a oMe;
    private c oMf;
    private boolean oMg;

    class b implements Runnable {
        List<String> oMi;

        private b() {
        }

        /* synthetic */ b(m mVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(104839);
            String K = com.tencent.mm.plugin.music.h.b.K(m.this.bTQ());
            int a = m.this.oMa;
            int i = 0;
            for (int i2 = 0; i2 < this.oMi.size(); i2++) {
                if (((String) this.oMi.get(i2)).equals(K)) {
                    a = i2;
                    i = 1;
                }
            }
            if (i == 0) {
                AppMethodBeat.o(104839);
                return;
            }
            int i3;
            for (i3 = a + 1; i3 < this.oMi.size(); i3++) {
                m.this.oMb.add(this.oMi.get(i3));
            }
            for (i3 = 0; i3 < a; i3++) {
                m.this.oMb.add(this.oMi.get(i3));
            }
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", Integer.valueOf(m.this.oMb.size()), Integer.valueOf(m.this.oMa));
            ke keVar = new ke();
            keVar.cFH.action = 5;
            com.tencent.mm.sdk.b.a.xxA.m(keVar);
            AppMethodBeat.o(104839);
        }
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }

        public final void run() {
            List list;
            AppMethodBeat.i(104838);
            long currentTimeMillis = System.currentTimeMillis();
            m.this.oMg = true;
            e bTQ = m.this.bTQ();
            ArrayList arrayList = new ArrayList();
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", Integer.valueOf(bTQ.fJS));
            kd kdVar;
            switch (bTQ.fJS) {
                case 1:
                    kdVar = new kd();
                    kdVar.cFz.action = -5;
                    com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                    list = kdVar.cFA.cAV;
                    break;
                case 4:
                    kdVar = new kd();
                    kdVar.cFz.action = -4;
                    com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                    list = kdVar.cFA.cAV;
                    break;
                case 6:
                    gh ghVar = new gh();
                    ghVar.cAH.type = 18;
                    com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                    list = ghVar.cAI.cAV;
                    break;
                case 8:
                    kdVar = new kd();
                    kdVar.cFz.action = -6;
                    kdVar.cFz.cFB = bTQ;
                    com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                    list = kdVar.cFA.cAV;
                    break;
                default:
                    list = null;
                    break;
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    e eVar = (e) list.get(i);
                    if (eVar == null) {
                        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
                    } else {
                        com.tencent.mm.plugin.music.model.e.bUk().x(eVar);
                        arrayList.add(com.tencent.mm.plugin.music.h.b.K(eVar));
                    }
                }
            }
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            m.this.oMg = false;
            b bVar = new b(m.this, (byte) 0);
            bVar.oMi = arrayList;
            al.d(bVar);
            AppMethodBeat.o(104838);
        }
    }

    public m() {
        AppMethodBeat.i(104840);
        AppMethodBeat.o(104840);
    }

    public final void init() {
        AppMethodBeat.i(104841);
        super.init();
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.j.e.CTRL_INDEX, (f) this);
        g.RO().eJo.a(769, (f) this);
        com.tencent.mm.plugin.music.model.notification.b bVar = this.oMc;
        ab.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
        bVar.hAA = new com.tencent.mm.sdk.b.c<ke>() {
            {
                AppMethodBeat.i(104986);
                this.xxI = ke.class.getName().hashCode();
                AppMethodBeat.o(104986);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(104987);
                ke keVar = (ke) bVar;
                if (b.this.oMK != null) {
                    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "event.data.action:%d", Integer.valueOf(keVar.cFH.action));
                    a bTU;
                    switch (keVar.cFH.action) {
                        case 0:
                        case 1:
                        case 11:
                            if (b.this.oMK != null) {
                                bTU = ((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.e.class)).bTU();
                                if (bTU != null) {
                                    b.this.oMK.c(bTU);
                                    break;
                                }
                                ab.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                                break;
                            }
                            break;
                        case 2:
                            if (!(b.this.oMK == null || keVar.cFH.cFK)) {
                                b.this.oMK.stop();
                                break;
                            }
                        case 3:
                            if (b.this.oMK != null) {
                                bTU = ((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.e.class)).bTU();
                                if (bTU != null) {
                                    b.this.oMK.d(bTU);
                                    break;
                                }
                                ab.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                                break;
                            }
                            break;
                        case 4:
                            if (b.this.oMK != null) {
                                b.this.oMK.stop();
                                break;
                            }
                            break;
                        case 7:
                            if (((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.e.class)).getMode() == 1 && b.this.oMK != null) {
                                MMMusicPlayerService mMMusicPlayerService = b.this.oMK;
                                ab.i("MicroMsg.Music.MMMusicPlayerService", "end");
                                a aVar = mMMusicPlayerService.oMS;
                                if (!aVar.bZi) {
                                    ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
                                } else if (aVar.oMK == null) {
                                    ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
                                } else {
                                    ab.i("MicroMsg.Music.MMMusicNotification", "end");
                                    al.af(aVar.oMM);
                                    al.n(aVar.oMM, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                                }
                                al.af(mMMusicPlayerService.oMT);
                                al.n(mMMusicPlayerService.oMT, 60000);
                                break;
                            }
                    }
                }
                b.this.bUr();
                AppMethodBeat.o(104987);
                return false;
            }
        };
        bVar.hAA.dnU();
        AppMethodBeat.o(104841);
    }

    public final void release() {
        AppMethodBeat.i(104842);
        this.oMb.clear();
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.j.e.CTRL_INDEX, (f) this);
        g.RO().eJo.b(940, (f) this);
        g.RO().eJo.b(769, (f) this);
        com.tencent.mm.plugin.music.model.notification.b bVar = this.oMc;
        ab.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
        Intent intent = new Intent();
        intent.setClass(ah.getContext(), MMMusicPlayerService.class);
        ah.getContext().stopService(intent);
        bVar.oMK = null;
        bVar.hAA.dead();
        AppMethodBeat.o(104842);
    }

    public final boolean g(e eVar) {
        AppMethodBeat.i(104843);
        if (eVar == null) {
            ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
            AppMethodBeat.o(104843);
            return false;
        }
        com.tencent.mm.plugin.music.model.e.a bTU = bTU();
        if (bTU != null) {
            int i;
            if (bTU == null) {
                i = 0;
            } else if (TextUtils.isEmpty(bTU.field_songWifiUrl) && TextUtils.isEmpty(bTU.field_songWapLinkUrl) && TextUtils.isEmpty(bTU.field_songWebUrl)) {
                i = 0;
            } else {
                boolean i2 = true;
            }
            if (i2 != 0) {
                if (bTU.field_isBlock == 1) {
                    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", bTU.field_musicId);
                    this.oLQ.r(eVar);
                    d.s(eVar);
                    AppMethodBeat.o(104843);
                    return false;
                }
                ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", Integer.valueOf(bTU.field_musicType));
                ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", bTU.field_protocol);
                bTU.playUrl = eVar.playUrl;
                if (this.oMe != null) {
                    g.RO().eJo.c(this.oMe);
                }
                g.RO().eJo.a(940, (f) this);
                this.oMe = new com.tencent.mm.plugin.music.model.b.a(bTU.field_musicType, bTU);
                g.RO().eJo.a(this.oMe, 0);
                if (com.tencent.mm.plugin.music.model.a.b.b(bTU)) {
                    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
                    String str = bTU.playUrl;
                    if (TextUtils.isEmpty(str)) {
                        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
                    } else {
                        if (this.oMf != null) {
                            g.RO().eJo.c(this.oMf);
                            this.oMf = null;
                        }
                        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", str);
                        this.oMf = new c(str);
                        g.RO().eJo.a(this.oMf, 0);
                        h.pYm.a(558, 213, 1, true);
                    }
                    AppMethodBeat.o(104843);
                    return false;
                }
                AppMethodBeat.o(104843);
                return true;
            }
        }
        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
        this.oLQ.r(eVar);
        AppMethodBeat.o(104843);
        return false;
    }

    public final e h(e eVar) {
        int i;
        AppMethodBeat.i(104844);
        String K = com.tencent.mm.plugin.music.h.b.K(eVar);
        if (this.oMb != null) {
            for (i = 0; i < this.oMb.size(); i++) {
                if (K.equals(this.oMb.get(i))) {
                    this.oMa = i;
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (this.oMb.size() > 1 && eVar.fKp) {
                this.mode = 2;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            eVar = bTQ();
        } else {
            this.oMb.clear();
            this.oMb.add(com.tencent.mm.plugin.music.h.b.K(eVar));
            this.oMa = 0;
            com.tencent.mm.plugin.music.model.e.bUk().x(eVar);
            if (this.mode == 2) {
                bUi();
            }
        }
        AppMethodBeat.o(104844);
        return eVar;
    }

    public final e i(e eVar) {
        AppMethodBeat.i(104845);
        if (eVar == null && this.oMb.size() == 0) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
            AppMethodBeat.o(104845);
            return null;
        }
        if (eVar == null) {
            eVar = bTQ();
        } else {
            this.oMb.clear();
            this.oMb.add(com.tencent.mm.plugin.music.h.b.K(eVar));
            this.oMa = 0;
            com.tencent.mm.plugin.music.model.e.bUk().x(eVar);
            if (this.mode == 2) {
                bUi();
            }
        }
        AppMethodBeat.o(104845);
        return eVar;
    }

    public final e m(List<e> list, int i) {
        AppMethodBeat.i(104846);
        if (list == null || list.size() == 0 || i >= list.size()) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
            AppMethodBeat.o(104846);
            return null;
        }
        e eVar;
        this.oMb.clear();
        for (int i2 = 0; i2 < list.size(); i2++) {
            eVar = (e) list.get(i2);
            this.oMb.add(com.tencent.mm.plugin.music.h.b.K(eVar));
            com.tencent.mm.plugin.music.model.e.bUk().x(eVar);
        }
        this.oMa = i;
        this.mode = 2;
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", Integer.valueOf(this.oMa));
        eVar = bTQ();
        AppMethodBeat.o(104846);
        return eVar;
    }

    public final void j(e eVar) {
        AppMethodBeat.i(104847);
        if (eVar != null) {
            this.oMb.clear();
            this.oMb.add(com.tencent.mm.plugin.music.h.b.K(eVar));
            this.oMa = 0;
            com.tencent.mm.plugin.music.model.e.bUk().x(eVar);
            AppMethodBeat.o(104847);
            return;
        }
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
        AppMethodBeat.o(104847);
    }

    public final synchronized void d(List<e> list, boolean z) {
        AppMethodBeat.i(104848);
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
            AppMethodBeat.o(104848);
        } else {
            if (z) {
                this.oMb.clear();
            }
            for (e eVar : list) {
                this.oMb.add(com.tencent.mm.plugin.music.h.b.K(eVar));
                com.tencent.mm.plugin.music.model.e.bUk().x(eVar);
            }
            AppMethodBeat.o(104848);
        }
    }

    public final List<String> bTW() {
        return this.oMb;
    }

    public final com.tencent.mm.plugin.music.model.e.a bTU() {
        AppMethodBeat.i(104849);
        if (this.oMb.size() <= this.oMa) {
            AppMethodBeat.o(104849);
            return null;
        }
        com.tencent.mm.plugin.music.model.e.a Tp = com.tencent.mm.plugin.music.model.e.bUk().Tp((String) this.oMb.get(this.oMa));
        AppMethodBeat.o(104849);
        return Tp;
    }

    public final e bTQ() {
        AppMethodBeat.i(104850);
        if (this.oMb.size() <= this.oMa) {
            AppMethodBeat.o(104850);
            return null;
        }
        com.tencent.mm.plugin.music.model.e.a Tp = com.tencent.mm.plugin.music.model.e.bUk().Tp((String) this.oMb.get(this.oMa));
        if (Tp != null) {
            e bUw = Tp.bUw();
            AppMethodBeat.o(104850);
            return bUw;
        }
        AppMethodBeat.o(104850);
        return null;
    }

    public final boolean bTV() {
        AppMethodBeat.i(104851);
        com.tencent.mm.plugin.music.model.e.a bTU = bTU();
        if (bTU != null) {
            switch (bTU.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                    AppMethodBeat.o(104851);
                    return true;
            }
        }
        AppMethodBeat.o(104851);
        return false;
    }

    public final void bTX() {
        this.mode = 1;
    }

    private void bUi() {
        AppMethodBeat.i(104853);
        com.tencent.mm.sdk.g.d.post(new a(this, (byte) 0), "music_get_list_task");
        AppMethodBeat.o(104853);
    }

    public final int getMode() {
        return this.mode;
    }

    public final void zH(int i) {
        AppMethodBeat.i(104854);
        if (this.oMb.size() == 0) {
            AppMethodBeat.o(104854);
            return;
        }
        int size = (i - 100000) % this.oMb.size();
        if (size < 0) {
            size += this.oMb.size();
        }
        if (size != this.oMa) {
            this.oMa = size;
            this.oLQ.p(null);
        }
        AppMethodBeat.o(104854);
    }

    public final void bTY() {
        AppMethodBeat.i(104855);
        if (this.mode == 1) {
            AppMethodBeat.o(104855);
            return;
        }
        this.oMa++;
        this.oMa %= this.oMb.size();
        this.oLQ.ju(true);
        this.oLQ.p(null);
        AppMethodBeat.o(104855);
    }

    public final void bTZ() {
        AppMethodBeat.i(104856);
        if (this.mode == 1) {
            AppMethodBeat.o(104856);
            return;
        }
        this.oMa = (this.oMa + this.oMb.size()) - 1;
        this.oMa %= this.oMb.size();
        this.oLQ.ju(true);
        this.oLQ.p(null);
        AppMethodBeat.o(104856);
    }

    public final int bUa() {
        return this.oMa;
    }

    public final void bUb() {
        AppMethodBeat.i(104857);
        if (!this.oLQ.bTS().aie()) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
            this.mode = 1;
        }
        AppMethodBeat.o(104857);
    }

    public final boolean bUc() {
        AppMethodBeat.i(104858);
        if (this.oMb.size() <= 0 || this.mode != 2) {
            AppMethodBeat.o(104858);
            return false;
        }
        AppMethodBeat.o(104858);
        return true;
    }

    public final boolean zF(int i) {
        AppMethodBeat.i(104859);
        boolean zF = com.tencent.mm.plugin.music.model.c.a.zF(i);
        AppMethodBeat.o(104859);
        return zF;
    }

    public final String Th(String str) {
        AppMethodBeat.i(104860);
        ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", com.tencent.mm.plugin.music.model.a.b.Th(str));
        String Tl = com.tencent.mm.plugin.music.model.a.b.Tl(Tl);
        AppMethodBeat.o(104860);
        return Tl;
    }

    public final URL Ti(String str) {
        AppMethodBeat.i(104861);
        URL url = new com.tencent.mm.network.b.b(str).url;
        AppMethodBeat.o(104861);
        return url;
    }

    public final void k(e eVar) {
        AppMethodBeat.i(104862);
        super.k(eVar);
        d.bUs();
        d.fqM = System.currentTimeMillis();
        d.f(bTU());
        AppMethodBeat.o(104862);
    }

    public final void l(e eVar) {
        AppMethodBeat.i(104863);
        super.l(eVar);
        d.fqM = System.currentTimeMillis();
        AppMethodBeat.o(104863);
    }

    public final void m(e eVar) {
        AppMethodBeat.i(104864);
        super.m(eVar);
        d.KX();
        AppMethodBeat.o(104864);
    }

    public final void n(e eVar) {
        AppMethodBeat.i(104865);
        super.n(eVar);
        d.bUs();
        AppMethodBeat.o(104865);
    }

    public final void o(e eVar) {
        AppMethodBeat.i(104866);
        super.o(eVar);
        d.bUs();
        if (this.mode == 2) {
            bTY();
        }
        AppMethodBeat.o(104866);
    }

    public final void a(e eVar, int i) {
        AppMethodBeat.i(104867);
        super.a(eVar, i);
        d.bUs();
        AppMethodBeat.o(104867);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(104868);
        String str2;
        com.tencent.mm.plugin.music.model.e.a aVar;
        if (mVar instanceof com.tencent.mm.plugin.music.model.b.a) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", Integer.valueOf(i2));
            g.RO().eJo.b(940, (f) this);
            if (i == 4 && i2 == -24) {
                rl rlVar = ((com.tencent.mm.plugin.music.model.b.a) mVar).oMF;
                if (bTU() != null && rlVar.fJU.equals(bTU().field_musicId)) {
                    this.oLQ.aic();
                }
                com.tencent.mm.plugin.music.model.e.b bUk = com.tencent.mm.plugin.music.model.e.bUk();
                str2 = rlVar.fJU;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", Integer.valueOf(1));
                bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{str2});
                aVar = (com.tencent.mm.plugin.music.model.e.a) bUk.oNq.get(str2);
                if (aVar != null) {
                    aVar.field_isBlock = 1;
                }
                ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", bTU().field_musicId);
                AppMethodBeat.o(104868);
                return;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.music.model.b.b) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.music.model.b.b bVar = (com.tencent.mm.plugin.music.model.b.b) mVar;
                amz amz = bVar.oMG;
                String str3 = bVar.oMw.field_musicId;
                if (!(amz == null || str3 == null)) {
                    for (String str22 : this.oMb) {
                        if (str22.equals(str3)) {
                            str3 = aa.b(amz.wrD);
                            String b = aa.b(amz.wrE);
                            String b2 = aa.b(amz.wrC);
                            com.tencent.mm.plugin.music.model.e.b bUk2 = com.tencent.mm.plugin.music.model.e.bUk();
                            boolean z = bVar.oMH;
                            com.tencent.mm.plugin.music.model.e.a Tp = bUk2.Tp(str22);
                            if (Tp == null) {
                                ab.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", str22);
                            } else {
                                if (!bo.isNullOrNil(str3)) {
                                    Tp.field_songAlbumUrl = str3;
                                }
                                Tp.field_songHAlbumUrl = b;
                                Tp.field_songLyric = b2;
                                bUk2.c(Tp, "songAlbumUrl", "songHAlbumUrl", "songLyric");
                                bUk2.oNq.put(str22, Tp);
                                bUk2.c(Tp, z);
                            }
                            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", str3, b, b2);
                            if (!bo.isNullOrNil(b)) {
                                com.tencent.mm.sdk.b.b keVar = new ke();
                                keVar.cFH.action = 6;
                                keVar.cFH.cFI = bVar.oMw.field_musicId;
                                com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
                                AppMethodBeat.o(104868);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.o(104868);
                return;
            }
            AppMethodBeat.o(104868);
            return;
        } else if (mVar instanceof c) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            c cVar = (c) mVar;
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", cVar.playUrl, cVar.oMJ);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.music.model.a.b.fq(cVar.playUrl, cVar.oMJ);
            } else {
                h.pYm.a(558, 214, 1, true);
            }
            aVar = bTU();
            if (aVar != null && !TextUtils.isEmpty(aVar.playUrl) && aVar.playUrl.equalsIgnoreCase(cVar.playUrl)) {
                ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
                this.oLQ.q(aVar.bUw());
                AppMethodBeat.o(104868);
                return;
            } else if (aVar != null) {
                ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", aVar.playUrl, cVar.playUrl);
            }
        }
        AppMethodBeat.o(104868);
    }

    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
        AppMethodBeat.i(104869);
        if (aVar == null) {
            AppMethodBeat.o(104869);
            return;
        }
        if (this.oMd != null) {
            g.RO().eJo.c(this.oMd);
            this.oMd = null;
        }
        if (aVar.field_songId <= 0) {
            ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId ");
            h.pYm.X(10911, "1");
            AppMethodBeat.o(104869);
            return;
        }
        this.oMd = new com.tencent.mm.plugin.music.model.b.b(aVar, z);
        g.RO().eJo.a(this.oMd, 0);
        AppMethodBeat.o(104869);
    }

    public final void xs(int i) {
        AppMethodBeat.i(104852);
        h.pYm.a(285, 2, 1, false);
        ke keVar;
        if (this.mode != 1) {
            this.mode = 1;
            keVar = new ke();
            keVar.cFH.action = 5;
            com.tencent.mm.sdk.b.a.xxA.m(keVar);
            d.ad(2, 1, i);
            AppMethodBeat.o(104852);
        } else if (this.oMg) {
            ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
            AppMethodBeat.o(104852);
        } else {
            this.mode = 2;
            if (this.oMb.size() <= 1) {
                bUi();
            } else {
                keVar = new ke();
                keVar.cFH.action = 5;
                com.tencent.mm.sdk.b.a.xxA.m(keVar);
            }
            d.ad(1, 2, i);
            AppMethodBeat.o(104852);
        }
    }
}
