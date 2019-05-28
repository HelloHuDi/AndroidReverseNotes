package com.tencent.p177mm.plugin.music.p462e;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1897b.C1896b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.notification.C46106b;
import com.tencent.p177mm.plugin.music.model.notification.C46106b.C126811;
import com.tencent.p177mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.p177mm.plugin.music.model.p1000e.C12680b;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.model.p1553b.C39440b;
import com.tencent.p177mm.plugin.music.model.p1553b.C46102a;
import com.tencent.p177mm.plugin.music.model.p1553b.C46103c;
import com.tencent.p177mm.plugin.music.model.p1554c.C46104a;
import com.tencent.p177mm.plugin.music.model.p466d.C3541d;
import com.tencent.p177mm.plugin.music.model.p998a.C21349b;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C35947rl;
import com.tencent.p177mm.protocal.protobuf.amz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.music.e.m */
public final class C43326m extends C28561g implements C1202f, C28559e {
    private int mode = 1;
    private int oMa;
    private List<String> oMb = new ArrayList();
    private C46106b oMc = new C46106b();
    private C39440b oMd;
    private C46102a oMe;
    private C46103c oMf;
    private boolean oMg;

    /* renamed from: com.tencent.mm.plugin.music.e.m$b */
    class C21344b implements Runnable {
        List<String> oMi;

        private C21344b() {
        }

        /* synthetic */ C21344b(C43326m c43326m, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(104839);
            String K = C12673b.m20670K(C43326m.this.bTQ());
            int a = C43326m.this.oMa;
            int i = 0;
            for (int i2 = 0; i2 < this.oMi.size(); i2++) {
                if (((String) this.oMi.get(i2)).equals(K)) {
                    a = i2;
                    i = 1;
                }
            }
            if (i == 0) {
                AppMethodBeat.m2505o(104839);
                return;
            }
            int i3;
            for (i3 = a + 1; i3 < this.oMi.size(); i3++) {
                C43326m.this.oMb.add(this.oMi.get(i3));
            }
            for (i3 = 0; i3 < a; i3++) {
                C43326m.this.oMb.add(this.oMi.get(i3));
            }
            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", Integer.valueOf(C43326m.this.oMb.size()), Integer.valueOf(C43326m.this.oMa));
            C37752ke c37752ke = new C37752ke();
            c37752ke.cFH.action = 5;
            C4879a.xxA.mo10055m(c37752ke);
            AppMethodBeat.m2505o(104839);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.e.m$a */
    class C43325a implements Runnable {
        private C43325a() {
        }

        /* synthetic */ C43325a(C43326m c43326m, byte b) {
            this();
        }

        public final void run() {
            List list;
            AppMethodBeat.m2504i(104838);
            long currentTimeMillis = System.currentTimeMillis();
            C43326m.this.oMg = true;
            C9058e bTQ = C43326m.this.bTQ();
            ArrayList arrayList = new ArrayList();
            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", Integer.valueOf(bTQ.fJS));
            C45337kd c45337kd;
            switch (bTQ.fJS) {
                case 1:
                    c45337kd = new C45337kd();
                    c45337kd.cFz.action = -5;
                    C4879a.xxA.mo10055m(c45337kd);
                    list = c45337kd.cFA.cAV;
                    break;
                case 4:
                    c45337kd = new C45337kd();
                    c45337kd.cFz.action = -4;
                    C4879a.xxA.mo10055m(c45337kd);
                    list = c45337kd.cFA.cAV;
                    break;
                case 6:
                    C37721gh c37721gh = new C37721gh();
                    c37721gh.cAH.type = 18;
                    C4879a.xxA.mo10055m(c37721gh);
                    list = c37721gh.cAI.cAV;
                    break;
                case 8:
                    c45337kd = new C45337kd();
                    c45337kd.cFz.action = -6;
                    c45337kd.cFz.cFB = bTQ;
                    C4879a.xxA.mo10055m(c45337kd);
                    list = c45337kd.cFA.cAV;
                    break;
                default:
                    list = null;
                    break;
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    C9058e c9058e = (C9058e) list.get(i);
                    if (c9058e == null) {
                        C4990ab.m7412e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
                    } else {
                        C39445e.bUk().mo24657x(c9058e);
                        arrayList.add(C12673b.m20670K(c9058e));
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C43326m.this.oMg = false;
            C21344b c21344b = new C21344b(C43326m.this, (byte) 0);
            c21344b.oMi = arrayList;
            C5004al.m7441d(c21344b);
            AppMethodBeat.m2505o(104838);
        }
    }

    public C43326m() {
        AppMethodBeat.m2504i(104840);
        AppMethodBeat.m2505o(104840);
    }

    public final void init() {
        AppMethodBeat.m2504i(104841);
        super.init();
        C1720g.m3535RO().eJo.mo14539a((int) C41234e.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(769, (C1202f) this);
        C46106b c46106b = this.oMc;
        C4990ab.m7416i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
        c46106b.hAA = new C126811();
        c46106b.hAA.dnU();
        AppMethodBeat.m2505o(104841);
    }

    public final void release() {
        AppMethodBeat.m2504i(104842);
        this.oMb.clear();
        C1720g.m3535RO().eJo.mo14546b((int) C41234e.CTRL_INDEX, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(940, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(769, (C1202f) this);
        C46106b c46106b = this.oMc;
        C4990ab.m7416i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
        Intent intent = new Intent();
        intent.setClass(C4996ah.getContext(), MMMusicPlayerService.class);
        C4996ah.getContext().stopService(intent);
        c46106b.oMK = null;
        c46106b.hAA.dead();
        AppMethodBeat.m2505o(104842);
    }

    /* renamed from: g */
    public final boolean mo46658g(C9058e c9058e) {
        AppMethodBeat.m2504i(104843);
        if (c9058e == null) {
            C4990ab.m7412e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
            AppMethodBeat.m2505o(104843);
            return false;
        }
        C28575a bTU = bTU();
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
                    C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", bTU.field_musicId);
                    this.oLQ.mo46676r(c9058e);
                    C3541d.m5833s(c9058e);
                    AppMethodBeat.m2505o(104843);
                    return false;
                }
                C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", Integer.valueOf(bTU.field_musicType));
                C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", bTU.field_protocol);
                bTU.playUrl = c9058e.playUrl;
                if (this.oMe != null) {
                    C1720g.m3535RO().eJo.mo14547c(this.oMe);
                }
                C1720g.m3535RO().eJo.mo14539a(940, (C1202f) this);
                this.oMe = new C46102a(bTU.field_musicType, bTU);
                C1720g.m3535RO().eJo.mo14541a(this.oMe, 0);
                if (C21349b.m32749b(bTU)) {
                    C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
                    String str = bTU.playUrl;
                    if (TextUtils.isEmpty(str)) {
                        C4990ab.m7412e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
                    } else {
                        if (this.oMf != null) {
                            C1720g.m3535RO().eJo.mo14547c(this.oMf);
                            this.oMf = null;
                        }
                        C4990ab.m7413e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", str);
                        this.oMf = new C46103c(str);
                        C1720g.m3535RO().eJo.mo14541a(this.oMf, 0);
                        C7060h.pYm.mo8378a(558, 213, 1, true);
                    }
                    AppMethodBeat.m2505o(104843);
                    return false;
                }
                AppMethodBeat.m2505o(104843);
                return true;
            }
        }
        C4990ab.m7412e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
        this.oLQ.mo46676r(c9058e);
        AppMethodBeat.m2505o(104843);
        return false;
    }

    /* renamed from: h */
    public final C9058e mo46659h(C9058e c9058e) {
        int i;
        AppMethodBeat.m2504i(104844);
        String K = C12673b.m20670K(c9058e);
        if (this.oMb != null) {
            for (i = 0; i < this.oMb.size(); i++) {
                if (K.equals(this.oMb.get(i))) {
                    this.oMa = i;
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (this.oMb.size() > 1 && c9058e.fKp) {
                this.mode = 2;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            c9058e = bTQ();
        } else {
            this.oMb.clear();
            this.oMb.add(C12673b.m20670K(c9058e));
            this.oMa = 0;
            C39445e.bUk().mo24657x(c9058e);
            if (this.mode == 2) {
                bUi();
            }
        }
        AppMethodBeat.m2505o(104844);
        return c9058e;
    }

    /* renamed from: i */
    public final C9058e mo46660i(C9058e c9058e) {
        AppMethodBeat.m2504i(104845);
        if (c9058e == null && this.oMb.size() == 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
            AppMethodBeat.m2505o(104845);
            return null;
        }
        if (c9058e == null) {
            c9058e = bTQ();
        } else {
            this.oMb.clear();
            this.oMb.add(C12673b.m20670K(c9058e));
            this.oMa = 0;
            C39445e.bUk().mo24657x(c9058e);
            if (this.mode == 2) {
                bUi();
            }
        }
        AppMethodBeat.m2505o(104845);
        return c9058e;
    }

    /* renamed from: m */
    public final C9058e mo46665m(List<C9058e> list, int i) {
        AppMethodBeat.m2504i(104846);
        if (list == null || list.size() == 0 || i >= list.size()) {
            C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
            AppMethodBeat.m2505o(104846);
            return null;
        }
        C9058e c9058e;
        this.oMb.clear();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c9058e = (C9058e) list.get(i2);
            this.oMb.add(C12673b.m20670K(c9058e));
            C39445e.bUk().mo24657x(c9058e);
        }
        this.oMa = i;
        this.mode = 2;
        C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", Integer.valueOf(this.oMa));
        c9058e = bTQ();
        AppMethodBeat.m2505o(104846);
        return c9058e;
    }

    /* renamed from: j */
    public final void mo46662j(C9058e c9058e) {
        AppMethodBeat.m2504i(104847);
        if (c9058e != null) {
            this.oMb.clear();
            this.oMb.add(C12673b.m20670K(c9058e));
            this.oMa = 0;
            C39445e.bUk().mo24657x(c9058e);
            AppMethodBeat.m2505o(104847);
            return;
        }
        C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
        AppMethodBeat.m2505o(104847);
    }

    /* renamed from: d */
    public final synchronized void mo46657d(List<C9058e> list, boolean z) {
        AppMethodBeat.m2504i(104848);
        if (list == null || list.size() == 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
            AppMethodBeat.m2505o(104848);
        } else {
            if (z) {
                this.oMb.clear();
            }
            for (C9058e c9058e : list) {
                this.oMb.add(C12673b.m20670K(c9058e));
                C39445e.bUk().mo24657x(c9058e);
            }
            AppMethodBeat.m2505o(104848);
        }
    }

    public final List<String> bTW() {
        return this.oMb;
    }

    public final C28575a bTU() {
        AppMethodBeat.m2504i(104849);
        if (this.oMb.size() <= this.oMa) {
            AppMethodBeat.m2505o(104849);
            return null;
        }
        C28575a Tp = C39445e.bUk().mo24653Tp((String) this.oMb.get(this.oMa));
        AppMethodBeat.m2505o(104849);
        return Tp;
    }

    public final C9058e bTQ() {
        AppMethodBeat.m2504i(104850);
        if (this.oMb.size() <= this.oMa) {
            AppMethodBeat.m2505o(104850);
            return null;
        }
        C28575a Tp = C39445e.bUk().mo24653Tp((String) this.oMb.get(this.oMa));
        if (Tp != null) {
            C9058e bUw = Tp.bUw();
            AppMethodBeat.m2505o(104850);
            return bUw;
        }
        AppMethodBeat.m2505o(104850);
        return null;
    }

    public final boolean bTV() {
        AppMethodBeat.m2504i(104851);
        C28575a bTU = bTU();
        if (bTU != null) {
            switch (bTU.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                    AppMethodBeat.m2505o(104851);
                    return true;
            }
        }
        AppMethodBeat.m2505o(104851);
        return false;
    }

    public final void bTX() {
        this.mode = 1;
    }

    private void bUi() {
        AppMethodBeat.m2504i(104853);
        C7305d.post(new C43325a(this, (byte) 0), "music_get_list_task");
        AppMethodBeat.m2505o(104853);
    }

    public final int getMode() {
        return this.mode;
    }

    /* renamed from: zH */
    public final void mo46651zH(int i) {
        AppMethodBeat.m2504i(104854);
        if (this.oMb.size() == 0) {
            AppMethodBeat.m2505o(104854);
            return;
        }
        int size = (i - 100000) % this.oMb.size();
        if (size < 0) {
            size += this.oMb.size();
        }
        if (size != this.oMa) {
            this.oMa = size;
            this.oLQ.mo62388p(null);
        }
        AppMethodBeat.m2505o(104854);
    }

    public final void bTY() {
        AppMethodBeat.m2504i(104855);
        if (this.mode == 1) {
            AppMethodBeat.m2505o(104855);
            return;
        }
        this.oMa++;
        this.oMa %= this.oMb.size();
        this.oLQ.mo46674ju(true);
        this.oLQ.mo62388p(null);
        AppMethodBeat.m2505o(104855);
    }

    public final void bTZ() {
        AppMethodBeat.m2504i(104856);
        if (this.mode == 1) {
            AppMethodBeat.m2505o(104856);
            return;
        }
        this.oMa = (this.oMa + this.oMb.size()) - 1;
        this.oMa %= this.oMb.size();
        this.oLQ.mo46674ju(true);
        this.oLQ.mo62388p(null);
        AppMethodBeat.m2505o(104856);
    }

    public final int bUa() {
        return this.oMa;
    }

    public final void bUb() {
        AppMethodBeat.m2504i(104857);
        if (!this.oLQ.bTS().aie()) {
            C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
            this.mode = 1;
        }
        AppMethodBeat.m2505o(104857);
    }

    public final boolean bUc() {
        AppMethodBeat.m2504i(104858);
        if (this.oMb.size() <= 0 || this.mode != 2) {
            AppMethodBeat.m2505o(104858);
            return false;
        }
        AppMethodBeat.m2505o(104858);
        return true;
    }

    /* renamed from: zF */
    public final boolean mo46669zF(int i) {
        AppMethodBeat.m2504i(104859);
        boolean zF = C46104a.m86014zF(i);
        AppMethodBeat.m2505o(104859);
        return zF;
    }

    /* renamed from: Th */
    public final String mo46652Th(String str) {
        AppMethodBeat.m2504i(104860);
        C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", C21349b.m32746Th(str));
        String Tl = C21349b.m32748Tl(Tl);
        AppMethodBeat.m2505o(104860);
        return Tl;
    }

    /* renamed from: Ti */
    public final URL mo46653Ti(String str) {
        AppMethodBeat.m2504i(104861);
        URL url = new C1896b(str).url;
        AppMethodBeat.m2505o(104861);
        return url;
    }

    /* renamed from: k */
    public final void mo46663k(C9058e c9058e) {
        AppMethodBeat.m2504i(104862);
        super.mo46663k(c9058e);
        C3541d.bUs();
        C3541d.fqM = System.currentTimeMillis();
        C3541d.m5832f(bTU());
        AppMethodBeat.m2505o(104862);
    }

    /* renamed from: l */
    public final void mo46664l(C9058e c9058e) {
        AppMethodBeat.m2504i(104863);
        super.mo46664l(c9058e);
        C3541d.fqM = System.currentTimeMillis();
        AppMethodBeat.m2505o(104863);
    }

    /* renamed from: m */
    public final void mo46666m(C9058e c9058e) {
        AppMethodBeat.m2504i(104864);
        super.mo46666m(c9058e);
        C3541d.m5828KX();
        AppMethodBeat.m2505o(104864);
    }

    /* renamed from: n */
    public final void mo46667n(C9058e c9058e) {
        AppMethodBeat.m2504i(104865);
        super.mo46667n(c9058e);
        C3541d.bUs();
        AppMethodBeat.m2505o(104865);
    }

    /* renamed from: o */
    public final void mo46668o(C9058e c9058e) {
        AppMethodBeat.m2504i(104866);
        super.mo46668o(c9058e);
        C3541d.bUs();
        if (this.mode == 2) {
            bTY();
        }
        AppMethodBeat.m2505o(104866);
    }

    /* renamed from: a */
    public final void mo46654a(C9058e c9058e, int i) {
        AppMethodBeat.m2504i(104867);
        super.mo46654a(c9058e, i);
        C3541d.bUs();
        AppMethodBeat.m2505o(104867);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104868);
        String str2;
        C28575a c28575a;
        if (c1207m instanceof C46102a) {
            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", Integer.valueOf(i2));
            C1720g.m3535RO().eJo.mo14546b(940, (C1202f) this);
            if (i == 4 && i2 == -24) {
                C35947rl c35947rl = ((C46102a) c1207m).oMF;
                if (bTU() != null && c35947rl.fJU.equals(bTU().field_musicId)) {
                    this.oLQ.aic();
                }
                C12680b bUk = C39445e.bUk();
                str2 = c35947rl.fJU;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", Integer.valueOf(1));
                bUk.bSd.update("Music", contentValues, "musicId=?", new String[]{str2});
                c28575a = (C28575a) bUk.oNq.get(str2);
                if (c28575a != null) {
                    c28575a.field_isBlock = 1;
                }
                C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", bTU().field_musicId);
                AppMethodBeat.m2505o(104868);
                return;
            }
        } else if (c1207m instanceof C39440b) {
            if (i == 0 && i2 == 0) {
                C39440b c39440b = (C39440b) c1207m;
                amz amz = c39440b.oMG;
                String str3 = c39440b.oMw.field_musicId;
                if (!(amz == null || str3 == null)) {
                    for (String str22 : this.oMb) {
                        if (str22.equals(str3)) {
                            str3 = C1946aa.m4153b(amz.wrD);
                            String b = C1946aa.m4153b(amz.wrE);
                            String b2 = C1946aa.m4153b(amz.wrC);
                            C12680b bUk2 = C39445e.bUk();
                            boolean z = c39440b.oMH;
                            C28575a Tp = bUk2.mo24653Tp(str22);
                            if (Tp == null) {
                                C4990ab.m7413e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", str22);
                            } else {
                                if (!C5046bo.isNullOrNil(str3)) {
                                    Tp.field_songAlbumUrl = str3;
                                }
                                Tp.field_songHAlbumUrl = b;
                                Tp.field_songLyric = b2;
                                bUk2.mo10103c(Tp, "songAlbumUrl", "songHAlbumUrl", "songLyric");
                                bUk2.oNq.put(str22, Tp);
                                bUk2.mo24656c(Tp, z);
                            }
                            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", str3, b, b2);
                            if (!C5046bo.isNullOrNil(b)) {
                                C4883b c37752ke = new C37752ke();
                                c37752ke.cFH.action = 6;
                                c37752ke.cFH.cFI = c39440b.oMw.field_musicId;
                                C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
                                AppMethodBeat.m2505o(104868);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(104868);
                return;
            }
            AppMethodBeat.m2505o(104868);
            return;
        } else if (c1207m instanceof C46103c) {
            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C46103c c46103c = (C46103c) c1207m;
            C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", c46103c.playUrl, c46103c.oMJ);
            if (i == 0 && i2 == 0) {
                C21349b.m32750fq(c46103c.playUrl, c46103c.oMJ);
            } else {
                C7060h.pYm.mo8378a(558, 214, 1, true);
            }
            c28575a = bTU();
            if (c28575a != null && !TextUtils.isEmpty(c28575a.playUrl) && c28575a.playUrl.equalsIgnoreCase(c46103c.playUrl)) {
                C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
                this.oLQ.mo46675q(c28575a.bUw());
                AppMethodBeat.m2505o(104868);
                return;
            } else if (c28575a != null) {
                C4990ab.m7417i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", c28575a.playUrl, c46103c.playUrl);
            }
        }
        AppMethodBeat.m2505o(104868);
    }

    /* renamed from: a */
    public final void mo46639a(C28575a c28575a, boolean z) {
        AppMethodBeat.m2504i(104869);
        if (c28575a == null) {
            AppMethodBeat.m2505o(104869);
            return;
        }
        if (this.oMd != null) {
            C1720g.m3535RO().eJo.mo14547c(this.oMd);
            this.oMd = null;
        }
        if (c28575a.field_songId <= 0) {
            C4990ab.m7412e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId ");
            C7060h.pYm.mo8374X(10911, "1");
            AppMethodBeat.m2505o(104869);
            return;
        }
        this.oMd = new C39440b(c28575a, z);
        C1720g.m3535RO().eJo.mo14541a(this.oMd, 0);
        AppMethodBeat.m2505o(104869);
    }

    /* renamed from: xs */
    public final void mo46650xs(int i) {
        AppMethodBeat.m2504i(104852);
        C7060h.pYm.mo8378a(285, 2, 1, false);
        C37752ke c37752ke;
        if (this.mode != 1) {
            this.mode = 1;
            c37752ke = new C37752ke();
            c37752ke.cFH.action = 5;
            C4879a.xxA.mo10055m(c37752ke);
            C3541d.m5830ad(2, 1, i);
            AppMethodBeat.m2505o(104852);
        } else if (this.oMg) {
            C4990ab.m7416i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
            AppMethodBeat.m2505o(104852);
        } else {
            this.mode = 2;
            if (this.oMb.size() <= 1) {
                bUi();
            } else {
                c37752ke = new C37752ke();
                c37752ke.cFH.action = 5;
                C4879a.xxA.mo10055m(c37752ke);
            }
            C3541d.m5830ad(1, 2, i);
            AppMethodBeat.m2505o(104852);
        }
    }
}
