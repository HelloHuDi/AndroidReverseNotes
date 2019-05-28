package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.audio.mix.f.c;
import com.tencent.mm.audio.mix.f.g;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    private static f oJQ;
    com.tencent.mm.ag.a csM = new com.tencent.mm.ag.a();
    Object lrj = new Object();
    private HashMap<String, String> oJA = new HashMap();
    HashMap<String, LinkedList<String>> oJB = new HashMap();
    HashMap<String, b> oJC = new HashMap();
    private HashMap<String, d> oJD = new HashMap();
    private LinkedList<String> oJE = new LinkedList();
    HashMap<String, Integer> oJF = new HashMap();
    private LinkedList<String> oJG = new LinkedList();
    boolean oJH = false;
    private boolean oJI = false;
    long oJJ = 0;
    private long oJK = 0;
    com.tencent.mm.plugin.music.b.a.d oJL;
    private com.tencent.mm.plugin.music.b.b.a oJM = new com.tencent.mm.plugin.music.b.b.a();
    private HashMap<String, String> oJN = new HashMap();
    HashMap<String, Integer> oJO = new HashMap();
    c oJP;
    private c oJR = new c() {
        public final void onStart(String str) {
            AppMethodBeat.i(137266);
            h SB = f.this.SB(str);
            if (SB == null) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
                AppMethodBeat.o(137266);
                return;
            }
            f.this.e(str, SB);
            synchronized (f.this.lrj) {
                try {
                    f.this.oJH = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(137266);
                }
            }
            al.af(f.this.oJT);
        }

        public final void Ss(String str) {
            AppMethodBeat.i(137267);
            h SB = f.this.SB(str);
            if (SB == null) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
                AppMethodBeat.o(137267);
                return;
            }
            f.this.b(str, SB);
            f.this.f(str, SB);
            f.a(f.this);
            f.this.bSD();
            AppMethodBeat.o(137267);
        }

        public final void Lu(String str) {
            AppMethodBeat.i(137268);
            h SB = f.this.SB(str);
            if (SB == null) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
                AppMethodBeat.o(137268);
                return;
            }
            f.this.b(str, SB);
            f.this.f(str, SB);
            f.a(f.this);
            f.this.bSD();
            f.a(f.this, str);
            f.this.SM(str);
            AppMethodBeat.o(137268);
        }

        public final void dO(String str) {
            AppMethodBeat.i(137269);
            h SB = f.this.SB(str);
            if (SB == null) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
                AppMethodBeat.o(137269);
                return;
            }
            f.this.b(str, SB);
            f.this.f(str, SB);
            f.a(f.this);
            f.this.bSD();
            f.a(f.this, str);
            f.this.SM(str);
            AppMethodBeat.o(137269);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(String str) {
            AppMethodBeat.i(137270);
            h SB = f.this.SB(str);
            if (SB == null) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
                AppMethodBeat.o(137270);
                return;
            }
            int intValue;
            Object obj;
            f.this.b(str, SB);
            f fVar = f.this;
            int i = SB.lqz;
            if (fVar.oJF.containsKey(str)) {
                intValue = ((Integer) fVar.oJF.get(str)).intValue();
            } else {
                intValue = 0;
            }
            if (intValue > 0) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
                fVar.oJF.remove(str);
            } else if (66 != i) {
                fVar.oJF.remove(str);
            } else if (fVar.SL(str)) {
                fVar.oJF.put(str, Integer.valueOf(intValue + 1));
                obj = 1;
                if (obj == null) {
                    ab.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
                    f.this.bSH();
                    f.this.b(str, null);
                    AppMethodBeat.o(137270);
                    return;
                }
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
                f.this.f(str, SB);
                f.a(f.this);
                f.this.bSD();
                AppMethodBeat.o(137270);
                return;
            }
            obj = null;
            if (obj == null) {
            }
        }
    };
    private Runnable oJS = new Runnable() {
        public final void run() {
            AppMethodBeat.i(137271);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
            Iterator it = f.this.oJz.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (f.this.SA(str) == 0) {
                    f.this.SC(str);
                }
            }
            AppMethodBeat.o(137271);
        }
    };
    Runnable oJT = new Runnable() {
        public final void run() {
            AppMethodBeat.i(137272);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
            Iterator it = f.this.oJz.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (f.this.SA(str) == 0) {
                    f fVar = f.this;
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", str);
                    LinkedList linkedList = (LinkedList) fVar.oJB.get(str);
                    if (linkedList == null || linkedList.size() == 0) {
                        ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
                    } else {
                        synchronized (fVar.lrj) {
                            try {
                                Iterator it2 = linkedList.iterator();
                                while (it2.hasNext()) {
                                    String str2 = (String) it2.next();
                                    if (fVar.oJP.dR(str2)) {
                                        fVar.oJP.dV(str2);
                                    }
                                    h hVar = (h) fVar.oJv.remove(str2);
                                    fVar.oJw.remove(str2);
                                    if (hVar != null) {
                                        fVar.b(str2, hVar);
                                        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                                        if (hVar.fqY) {
                                            f.d(str2, hVar);
                                        } else {
                                            f.c(str2, hVar);
                                        }
                                    }
                                }
                                Iterator it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    str = (String) it3.next();
                                    if (fVar.oJP.dR(str)) {
                                        fVar.oJP.dV(str);
                                    }
                                    h hVar2 = (h) fVar.oJx.remove(str);
                                    fVar.oJy.remove(str);
                                    if (hVar2 != null) {
                                        fVar.b(str, hVar2);
                                        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                                        if (hVar2.fqY) {
                                            f.d(str, hVar2);
                                        } else {
                                            f.c(str, hVar2);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(137272);
                            }
                        }
                    }
                    i2 = 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i == 0) {
                synchronized (f.this.lrj) {
                    try {
                        f.this.oJH = true;
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(137272);
                        }
                    }
                }
                f.this.oJJ = System.currentTimeMillis();
                al.n(f.this.oJT, 1800000);
            }
            AppMethodBeat.o(137272);
        }
    };
    private com.tencent.mm.audio.mix.f.b oJU = new com.tencent.mm.audio.mix.f.b() {
        public final void b(u uVar) {
            AppMethodBeat.i(137274);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137274);
        }

        public final void c(u uVar) {
            AppMethodBeat.i(137275);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137275);
        }

        public final void d(u uVar) {
            AppMethodBeat.i(137276);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137276);
        }

        public final void e(u uVar) {
            AppMethodBeat.i(137277);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137277);
        }

        public final void f(u uVar) {
            AppMethodBeat.i(137278);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137278);
        }

        public final void g(u uVar) {
            AppMethodBeat.i(137279);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137279);
        }

        public final void h(u uVar) {
            AppMethodBeat.i(137280);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137280);
        }

        public final void i(u uVar) {
            AppMethodBeat.i(137281);
            com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            AppMethodBeat.o(137281);
        }

        public final void j(u uVar) {
            AppMethodBeat.i(137282);
            int i = uVar.csP.errCode;
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", Integer.valueOf(i));
            if (i == 709 || i == 702 || i == 703 || i == 705 || i == 706) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
            } else {
                com.tencent.mm.sdk.b.a.xxA.a((com.tencent.mm.sdk.b.b) uVar, Looper.getMainLooper());
            }
            if (f.this.oJL != null) {
                b bVar = (b) f.this.oJC.get(uVar.csP.ckD);
                if (bVar == null) {
                    AppMethodBeat.o(137282);
                    return;
                }
                f.this.oJL.zr(uVar.csP.errCode);
                if (!f.this.oJP.ee(bVar.filePath)) {
                    if (f.this.oJO.containsKey(bVar.filePath)) {
                        f.this.oJO.put(bVar.filePath, Integer.valueOf(((Integer) f.this.oJO.get(bVar.filePath)).intValue() + 1));
                        AppMethodBeat.o(137282);
                        return;
                    }
                    f.this.oJO.put(bVar.filePath, Integer.valueOf(1));
                }
            }
            AppMethodBeat.o(137282);
        }

        public final void k(u uVar) {
            AppMethodBeat.i(137283);
            if (f.this.oJL != null) {
                b bVar = (b) f.this.oJC.get(uVar.csP.ckD);
                if (bVar == null) {
                    AppMethodBeat.o(137283);
                    return;
                }
                if (bVar.fqQ > 1000000) {
                    ab.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", bVar.ckD, Long.valueOf(bVar.fqQ));
                }
                String str = uVar.csP.clP;
                if (TextUtils.isEmpty(str)) {
                    str = bVar.clP;
                }
                f.this.oJL.a(bVar.ckD, str, System.currentTimeMillis() - bVar.fqO, bVar.fqP, bVar.fqQ, false, bVar.filePath, (long) f.this.oJP.ea(bVar.ckD), bVar.fileSize, com.tencent.mm.audio.mix.b.d.Dm().dy(bVar.filePath));
                if (f.this.oJO.containsKey(bVar.filePath)) {
                    f.this.oJO.remove(bVar.filePath);
                }
            }
            AppMethodBeat.o(137283);
        }
    };
    private g oJV = new g() {
        public final void gD(int i) {
            AppMethodBeat.i(137284);
            if (f.this.oJL != null) {
                f.this.oJL.zq(i);
            }
            AppMethodBeat.o(137284);
        }
    };
    private LinkedList<String> oJu = new LinkedList();
    HashMap<String, h> oJv = new HashMap();
    LinkedList<String> oJw = new LinkedList();
    HashMap<String, h> oJx = new HashMap();
    LinkedList<String> oJy = new LinkedList();
    LinkedList<String> oJz = new LinkedList();

    public class a implements Comparator<b> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            b bVar = (b) obj;
            b bVar2 = (b) obj2;
            if (bVar.fqM > bVar2.fqM) {
                return 1;
            }
            if (bVar.fqM < bVar2.fqM) {
                return -1;
            }
            return 0;
        }
    }

    public static synchronized void bSz() {
        synchronized (f.class) {
            AppMethodBeat.i(137285);
            if (oJQ != null) {
                AppMethodBeat.o(137285);
            } else {
                oJQ = new f();
                AppMethodBeat.o(137285);
            }
        }
    }

    public static f bSA() {
        AppMethodBeat.i(137286);
        if (oJQ == null) {
            oJQ = new f();
        }
        f fVar = oJQ;
        AppMethodBeat.o(137286);
        return fVar;
    }

    private f() {
        AppMethodBeat.i(137287);
        bSB();
        this.oJP = new c();
        this.oJP.a(this.oJU);
        this.oJP.a(this.oJV);
        AppMethodBeat.o(137287);
    }

    public final void bSB() {
        AppMethodBeat.i(137288);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
        this.oJu.clear();
        synchronized (this.lrj) {
            try {
                String str;
                Iterator it = this.oJw.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    c(str, (h) this.oJv.remove(str));
                }
                this.oJw.clear();
                this.oJv.clear();
                it = this.oJy.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    c(str, (h) this.oJx.remove(str));
                }
                this.oJy.clear();
                this.oJx.clear();
            } finally {
                AppMethodBeat.o(137288);
            }
        }
        Iterator it2 = this.oJz.iterator();
        while (it2.hasNext()) {
            LinkedList linkedList = (LinkedList) this.oJB.remove((String) it2.next());
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.oJz.clear();
        this.oJA.clear();
        this.oJB.clear();
        this.oJC.clear();
        this.oJD.clear();
        this.oJF.clear();
        this.oJG.clear();
        al.af(this.oJS);
        al.af(this.oJT);
        this.oJH = false;
        this.oJI = false;
    }

    private void a(String str, b bVar) {
        AppMethodBeat.i(137289);
        if (bVar == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", str);
            AppMethodBeat.o(137289);
            return;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", str);
        this.oJA.put(bVar.appId, bVar.processName);
        this.oJC.put(bVar.ckD, bVar);
        fj(bVar.appId, str);
        this.oJF.remove(str);
        AppMethodBeat.o(137289);
    }

    private void fj(String str, String str2) {
        AppMethodBeat.i(137290);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(137290);
            return;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", str, str2);
        if (!this.oJz.contains(str)) {
            this.oJz.add(str);
        }
        if (!this.oJu.contains(str2)) {
            this.oJu.add(str2);
        }
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!linkedList.contains(str2)) {
            linkedList.add(str2);
        }
        this.oJB.put(str, linkedList);
        AppMethodBeat.o(137290);
    }

    public final String fk(String str, String str2) {
        int i;
        AppMethodBeat.i(137291);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        synchronized (this.lrj) {
            if (linkedList != null) {
                try {
                    if (linkedList.contains(str2) && (this.oJw.contains(str2) || this.oJy.contains(str2))) {
                        i = 1;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(137291);
                    }
                }
            }
            i = 0;
        }
        int SA = SA(str);
        if (TextUtils.isEmpty(str2)) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            aS(604, str2);
            AppMethodBeat.o(137291);
            return null;
        } else if (SA >= 10) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", Integer.valueOf(SA));
            fj(str, str2);
            AppMethodBeat.o(137291);
            return null;
        } else if (i != 0) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            aS(603, str2);
            AppMethodBeat.o(137291);
            return null;
        } else {
            fj(str, str2);
            SH(str2);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", str, str2);
            AppMethodBeat.o(137291);
            return str2;
        }
    }

    public final boolean g(b bVar) {
        AppMethodBeat.i(137292);
        if (bVar == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
            AppMethodBeat.o(137292);
            return false;
        }
        b bVar2 = (b) this.oJC.get(bVar.ckD);
        if (bVar2 != null) {
            bVar2.f(bVar);
        } else {
            this.oJC.put(bVar.ckD, bVar);
            bVar2 = bVar;
        }
        h SB = SB(bVar.ckD);
        if (SB != null) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
            SB.b(bVar2);
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
        }
        if (b.bSx()) {
            if (this.oJP.dR(bVar.ckD)) {
                this.oJP.c(bVar);
            } else {
                this.oJP.b(bVar);
            }
        }
        AppMethodBeat.o(137292);
        return true;
    }

    public final boolean h(b bVar) {
        AppMethodBeat.i(137293);
        if (bVar == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
            aS(605, "");
            AppMethodBeat.o(137293);
            return false;
        } else if (TextUtils.isEmpty(bVar.ckD)) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
            aS(604, bVar.ckD);
            AppMethodBeat.o(137293);
            return false;
        } else if (this.oJu.contains(bVar.ckD)) {
            h SB;
            if (bVar.fqK) {
                j(bVar);
            }
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
            String SF = SF(bVar.ckD);
            b pO = pO(bVar.ckD);
            if (SA(SF) >= 10) {
                ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", Integer.valueOf(SA(SF)));
                this.oJC.put(bVar.ckD, bVar);
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", Boolean.valueOf(bVar.fqK));
                if (bVar.fqK && SJ(bVar.ckD)) {
                    bSH();
                } else if (bVar.fqK) {
                    aS(600, bVar.ckD);
                    bSL();
                    AppMethodBeat.o(137293);
                    return false;
                } else {
                    ab.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
                    SB = SB(bVar.ckD);
                    if (SB != null) {
                        SB.b(bVar);
                        SB.bSR();
                    }
                    AppMethodBeat.o(137293);
                    return true;
                }
            }
            SH(bVar.ckD);
            bSI();
            this.oJA.put(SF, bVar.processName);
            this.oJC.put(bVar.ckD, bVar);
            if (TextUtils.isEmpty(bVar.filePath) && this.oJN.containsKey(bVar.clP)) {
                bVar.filePath = (String) this.oJN.get(bVar.clP);
            }
            SB = SB(bVar.ckD);
            boolean bSx = b.bSx();
            if (bSx) {
                boolean a = a(SB);
                boolean z = (!TextUtils.isEmpty(bVar.filePath) && this.oJP.ee(bVar.filePath)) || (pO != null && bVar.e(pO) && !TextUtils.isEmpty(pO.filePath) && this.oJP.ee(pO.filePath));
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a), Boolean.valueOf(z), bVar.ckD);
                if (a && z) {
                    a(bVar, pO);
                    AppMethodBeat.o(137293);
                    return true;
                }
            }
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
            b(bVar, pO);
            if (bSx) {
                i(bVar);
            }
            AppMethodBeat.o(137293);
            return true;
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
            aS(601, bVar.ckD);
            AppMethodBeat.o(137293);
            return false;
        }
    }

    private void i(b bVar) {
        AppMethodBeat.i(137294);
        if (this.oJP.dR(bVar.ckD)) {
            this.oJP.c(bVar);
        } else {
            this.oJP.b(bVar);
        }
        if (!TextUtils.isEmpty(bVar.filePath)) {
            SM(bVar.ckD);
        }
        AppMethodBeat.o(137294);
    }

    private void a(b bVar, b bVar2) {
        AppMethodBeat.i(137295);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
        SG(bVar.ckD);
        k(bVar);
        if (TextUtils.isEmpty(bVar.filePath) && bVar2 != null && bVar2.e(bVar)) {
            bVar.filePath = bVar2.filePath;
        }
        if (!bVar.fqK) {
            if (this.oJP.dR(bVar.ckD)) {
                this.oJP.c(bVar);
            } else {
                this.oJP.b(bVar);
            }
            if (!(bVar2 == null || bVar2.e(bVar))) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
                if (this.oJP.dF(bVar.ckD) || this.oJP.dW(bVar.ckD) || this.oJP.dX(bVar.ckD) || this.oJP.dY(bVar.ckD) || this.oJP.isPaused(bVar.ckD)) {
                    this.oJP.dV(bVar.ckD);
                }
            }
            this.oJP.i(7, bVar.ckD);
            AppMethodBeat.o(137295);
        } else if (bVar2 != null && !bVar2.e(bVar)) {
            a(bVar, true, false);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
            if (this.oJP.dF(bVar.ckD) || this.oJP.dW(bVar.ckD) || this.oJP.dX(bVar.ckD) || this.oJP.dY(bVar.ckD) || this.oJP.isPaused(bVar.ckD)) {
                this.oJP.dV(bVar.ckD);
            }
            this.oJP.a(bVar);
            AppMethodBeat.o(137295);
        } else if (this.oJP.dF(bVar.ckD)) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
            AppMethodBeat.o(137295);
        } else if (this.oJP.dW(bVar.ckD) && this.oJP.isPaused(bVar.ckD)) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
            a(bVar, true, false);
            this.oJP.dT(bVar.ckD);
            AppMethodBeat.o(137295);
        } else if (this.oJP.dY(bVar.ckD)) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
            a(bVar, true, false);
            this.oJP.dT(bVar.ckD);
            AppMethodBeat.o(137295);
        } else if (this.oJP.dX(bVar.ckD)) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
            AppMethodBeat.o(137295);
        } else {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
            a(bVar, true, false);
            this.oJP.a(bVar);
            AppMethodBeat.o(137295);
        }
    }

    private void b(b bVar, b bVar2) {
        int i = 1;
        AppMethodBeat.i(137296);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
        h SB = SB(bVar.ckD);
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", bVar.ckD);
            h bSC = bSC();
            bSC.a(this.oJR);
            bSC.SN(bVar.ckD);
            bSC.b(bVar);
            if (bVar.fqK) {
                a(bVar, true, true);
                e(bVar.ckD, bSC);
                bVar.fqM = System.currentTimeMillis();
                bSC.l(bVar);
                AppMethodBeat.o(137296);
                return;
            }
            f(bVar.ckD, bSC);
            bSC.bSR();
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
            AppMethodBeat.o(137296);
            return;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", bVar.ckD);
        if (bVar.fqK) {
            e(bVar.ckD, SB);
            bVar.fqM = System.currentTimeMillis();
            SB.b(bVar);
            if (bVar2 != null && !bVar2.e(bVar)) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
                if (SB.aie() || SB.aig() || SB.bTc() || SB.bTd() || SB.isPaused()) {
                    SB.stopPlay();
                }
                a(bVar, true, true);
                SB.l(bVar);
                AppMethodBeat.o(137296);
                return;
            } else if (SB.aie()) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
                AppMethodBeat.o(137296);
                return;
            } else if (SB.aig() && SB.isPaused()) {
                a(bVar, true, true);
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
                SB.resume();
                AppMethodBeat.o(137296);
                return;
            } else if (SB.bTd()) {
                a(bVar, true, true);
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
                SB.resume();
                AppMethodBeat.o(137296);
                return;
            } else if (SB.bTc()) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
                AppMethodBeat.o(137296);
                return;
            } else {
                a(bVar, true, true);
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
                SB.l(bVar);
                AppMethodBeat.o(137296);
                return;
            }
        }
        synchronized (this.lrj) {
            try {
                if (!this.oJw.contains(bVar.ckD)) {
                    i = 0;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137296);
                }
            }
        }
        if (i == 0) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
            f(bVar.ckD, SB);
        } else {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
        }
        SB.b(bVar);
        if (!(bVar2 == null || bVar2.e(bVar))) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if (SB.aie() || SB.aig() || SB.bTc() || SB.bTd() || SB.isPaused()) {
                SB.stopPlay();
            }
        }
        SB.bSR();
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
        AppMethodBeat.o(137296);
    }

    public final boolean b(String str, b bVar) {
        AppMethodBeat.i(137297);
        b bVar2 = (b) this.oJC.get(str);
        if ((!this.oJu.contains(str) || bVar2 == null) && bVar != null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", str);
            a(str, bVar);
            if (bVar2 == null) {
                bVar2 = bVar;
            }
        } else if (!this.oJu.contains(str)) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
            aS(601, str);
            AppMethodBeat.o(137297);
            return false;
        } else if (bVar2 == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
            aS(602, str);
            AppMethodBeat.o(137297);
            return false;
        }
        j(bVar2);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", str);
        if (SA(SF(str)) >= 10) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", Integer.valueOf(SA(SF(str))));
            if (SJ(str)) {
                bSH();
            } else {
                bSL();
                aS(600, str);
                AppMethodBeat.o(137297);
                return false;
            }
        }
        bSI();
        this.oJC.put(str, bVar2);
        h SB = SB(str);
        if (b.bSx()) {
            boolean a = a(SB);
            boolean z = this.oJP.dR(str) && this.oJP.ed(str);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a), Boolean.valueOf(z), bVar2.ckD);
            if (a && z) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
                SG(bVar2.ckD);
                k(bVar2);
                if (this.oJP.dF(bVar2.ckD)) {
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
                } else if (this.oJP.dX(bVar2.ckD)) {
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
                    bVar2.fqK = true;
                    SB.b(bVar2);
                } else {
                    a(bVar2, false, false);
                    this.oJP.dS(str);
                }
                AppMethodBeat.o(137297);
                return true;
            }
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
            SH(str);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", str);
            h bSC = bSC();
            bSC.a(this.oJR);
            bSC.SN(str);
            e(str, bSC);
            bVar2.fqK = true;
            bVar2.startTime = 0;
            bVar2.fqM = System.currentTimeMillis();
            a(bVar2, false, true);
            bSC.l(bVar2);
            AppMethodBeat.o(137297);
            return true;
        }
        e(str, SB);
        if (SB.aig() && !SB.aie()) {
            a(bVar2, false, true);
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
            SB.resume();
        } else if (SB.bTd()) {
            a(bVar2, false, true);
            bVar2.fqK = true;
            bVar2.fqM = System.currentTimeMillis();
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
            SB.resume();
            bVar2.startTime = 0;
            SB.b(bVar2);
        } else if (SB.bTc()) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
            bVar2.fqK = true;
            bVar2.fqM = System.currentTimeMillis();
            SB.b(bVar2);
        } else if (SB.aig()) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
            AppMethodBeat.o(137297);
            return false;
        } else {
            a(bVar2, false, true);
            bVar2.fqK = true;
            bVar2.fqM = System.currentTimeMillis();
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
            SB.l(bVar2);
            bVar2.startTime = 0;
        }
        AppMethodBeat.o(137297);
        return true;
    }

    public final boolean St(String str) {
        AppMethodBeat.i(137298);
        h SB = SB(str);
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
            if (this.oJP.dR(str)) {
                this.oJP.dU(str);
                AppMethodBeat.o(137298);
                return true;
            }
            AppMethodBeat.o(137298);
            return false;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", str);
        SB.pause();
        b(str, SB);
        f(str, SB);
        AppMethodBeat.o(137298);
        return true;
    }

    public final boolean Su(String str) {
        AppMethodBeat.i(137299);
        h SB = SB(str);
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
            if (this.oJP.dR(str)) {
                this.oJP.dV(str);
                AppMethodBeat.o(137299);
                return true;
            }
            AppMethodBeat.o(137299);
            return false;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", str);
        SB.stopPlay();
        b bVar = (b) this.oJC.get(str);
        if (bVar != null) {
            bVar.startTime = 0;
            bVar.fqK = true;
        }
        b(str, SB);
        f(str, SB);
        AppMethodBeat.o(137299);
        return true;
    }

    public final boolean Sv(String str) {
        AppMethodBeat.i(137300);
        if (this.oJP.dR(str)) {
            this.oJP.dV(str);
        }
        h SB = SB(str);
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
            AppMethodBeat.o(137300);
            return false;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", str);
        SB.bTg();
        b bVar = (b) this.oJC.get(str);
        if (bVar != null) {
            bVar.startTime = 0;
            bVar.fqK = true;
        }
        b(str, SB);
        f(str, SB);
        AppMethodBeat.o(137300);
        return true;
    }

    public final boolean Sw(String str) {
        AppMethodBeat.i(137301);
        this.oJP.dV(str);
        this.oJP.remove(str);
        h SB = SB(str);
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
            AppMethodBeat.o(137301);
            return false;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", str);
        c(str, SB);
        synchronized (this.lrj) {
            try {
                this.oJv.remove(str);
                this.oJw.remove(str);
                this.oJx.remove(str);
                this.oJy.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137301);
                }
            }
        }
        this.oJu.remove(str);
        Iterator it = this.oJz.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oJB.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                linkedList.remove(str);
                if (linkedList.size() == 0) {
                    this.oJB.remove(str2);
                    this.oJz.remove(str2);
                    this.oJA.remove(str2);
                }
                this.oJC.remove(str);
                this.oJD.remove(str);
                AppMethodBeat.o(137301);
                return true;
            }
        }
        this.oJC.remove(str);
        this.oJD.remove(str);
        AppMethodBeat.o(137301);
        return true;
    }

    public final boolean cF(String str, int i) {
        AppMethodBeat.i(137302);
        h SB = SB(str);
        boolean cG;
        if (SB == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
            if (this.oJP.dR(str)) {
                this.oJP.w(str, i);
            }
            cG = cG(str, i);
            AppMethodBeat.o(137302);
            return cG;
        } else if (i < 0) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(SB.getDuration()));
            AppMethodBeat.o(137302);
            return false;
        } else if (SB.getDuration() <= 0) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(SB.getDuration()));
            SB.bSW();
            cG = cG(str, i);
            AppMethodBeat.o(137302);
            return cG;
        } else if (i <= 0 || i <= SB.getDuration()) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", str, Integer.valueOf(i));
            if (SB.aie() || SB.aig() || SB.isPaused()) {
                cG = SB.lP(i);
                AppMethodBeat.o(137302);
                return cG;
            }
            SB.bSW();
            cG = cG(str, i);
            AppMethodBeat.o(137302);
            return cG;
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(SB.getDuration()));
            AppMethodBeat.o(137302);
            return false;
        }
    }

    private boolean cG(String str, int i) {
        AppMethodBeat.i(137303);
        b bVar = (b) this.oJC.get(str);
        if (bVar != null) {
            bVar.startTime = i;
            AppMethodBeat.o(137303);
            return true;
        }
        AppMethodBeat.o(137303);
        return false;
    }

    public final boolean Sx(String str) {
        AppMethodBeat.i(137304);
        h SB = SB(str);
        boolean aig;
        if (SB != null) {
            aig = SB.aig();
            AppMethodBeat.o(137304);
            return aig;
        } else if (this.oJP.dR(str)) {
            aig = this.oJP.dW(str);
            AppMethodBeat.o(137304);
            return aig;
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
            AppMethodBeat.o(137304);
            return false;
        }
    }

    public final boolean pN(String str) {
        AppMethodBeat.i(137305);
        h SB = SB(str);
        boolean aie;
        if (SB != null) {
            aie = SB.aie();
            AppMethodBeat.o(137305);
            return aie;
        } else if (this.oJP.dR(str)) {
            aie = this.oJP.dF(str);
            AppMethodBeat.o(137305);
            return aie;
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
            AppMethodBeat.o(137305);
            return false;
        }
    }

    public final boolean dZ(String str) {
        AppMethodBeat.i(137306);
        h SB = SB(str);
        boolean isStopped;
        if (SB != null) {
            isStopped = SB.isStopped();
            AppMethodBeat.o(137306);
            return isStopped;
        } else if (this.oJP.dR(str)) {
            isStopped = this.oJP.dZ(str);
            AppMethodBeat.o(137306);
            return isStopped;
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
            AppMethodBeat.o(137306);
            return true;
        }
    }

    public final boolean Sy(String str) {
        AppMethodBeat.i(137307);
        h SB = SB(str);
        boolean z;
        if (SB != null) {
            z = SB.fqY;
            AppMethodBeat.o(137307);
            return z;
        } else if (this.oJP.dR(str)) {
            z = this.oJP.Ei();
            AppMethodBeat.o(137307);
            return z;
        } else {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
            d Sz = Sz(str);
            if (Sz != null) {
                z = Sz.fqY;
                AppMethodBeat.o(137307);
                return z;
            }
            AppMethodBeat.o(137307);
            return false;
        }
    }

    public final d Sz(String str) {
        AppMethodBeat.i(137308);
        h SB = SB(str);
        d bTj;
        if (SB != null) {
            bTj = SB.bTj();
            AppMethodBeat.o(137308);
            return bTj;
        }
        if (this.oJP.dR(str)) {
            bTj = this.oJP.eb(str);
            if (bTj != null) {
                AppMethodBeat.o(137308);
                return bTj;
            }
        }
        bTj = (d) this.oJD.get(str);
        AppMethodBeat.o(137308);
        return bTj;
    }

    public final int SA(String str) {
        int size;
        AppMethodBeat.i(137309);
        int bSE = bSE();
        synchronized (this.lrj) {
            try {
                int size2 = this.oJu.size();
                size = this.oJv.size();
                int size3 = this.oJx.size();
                LinkedList linkedList = (LinkedList) this.oJB.get(str);
                int size4 = linkedList == null ? 0 : linkedList.size();
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(size4), Integer.valueOf(bSE));
            } finally {
                AppMethodBeat.o(137309);
            }
        }
        return size;
    }

    public final b pO(String str) {
        AppMethodBeat.i(137310);
        if (this.oJC.containsKey(str)) {
            b bVar = (b) this.oJC.get(str);
            AppMethodBeat.o(137310);
            return bVar;
        }
        AppMethodBeat.o(137310);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final h SB(String str) {
        AppMethodBeat.i(137311);
        h hVar;
        if (this.oJv.containsKey(str)) {
            hVar = (h) this.oJv.get(str);
            AppMethodBeat.o(137311);
            return hVar;
        } else if (this.oJx.containsKey(str)) {
            hVar = (h) this.oJx.get(str);
            AppMethodBeat.o(137311);
            return hVar;
        } else {
            AppMethodBeat.o(137311);
            return null;
        }
    }

    public final void SC(String str) {
        AppMethodBeat.i(137312);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", str);
        this.oJP.Eh();
        bSK();
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        long Ek = this.oJP.Ek();
        long Dn = com.tencent.mm.audio.mix.b.d.Dm().Dn();
        long Dl = Dn + com.tencent.mm.audio.mix.b.c.Dk().Dl();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", Long.valueOf(Ek), Long.valueOf(Dn), Long.valueOf(com.tencent.mm.audio.mix.b.c.Dk().Dl()));
        this.oJL = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.b.a.d.class);
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
            AppMethodBeat.o(137312);
        } else if (this.oJv.isEmpty() && this.oJx.isEmpty()) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
            if (this.oJL != null) {
                this.oJL.b(str, Ek, Dl, Dn);
            }
            AppMethodBeat.o(137312);
        } else {
            LinkedList linkedList2 = new LinkedList();
            synchronized (this.lrj) {
                try {
                    linkedList2.addAll(linkedList);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(137312);
                    }
                }
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                h hVar = (h) this.oJx.get(str2);
                if (hVar != null) {
                    a(str2, hVar);
                }
            }
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", Integer.valueOf(this.oJv.size()));
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                h hVar2 = (h) this.oJv.get(str3);
                if (hVar2 != null) {
                    a(str3, hVar2);
                    f(str3, hVar2);
                }
            }
            if (this.oJL != null) {
                this.oJL.b(str, Ek, Dl, Dn);
            }
            AppMethodBeat.o(137312);
        }
    }

    public final void SD(String str) {
        AppMethodBeat.i(137313);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", str);
        bSK();
        LinkedList linkedList = (LinkedList) this.oJB.remove(str);
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            AppMethodBeat.o(137313);
            return;
        }
        synchronized (this.lrj) {
            try {
                String str2;
                h hVar;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    hVar = (h) this.oJv.remove(str2);
                    this.oJw.remove(str2);
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
                    c(str2, hVar);
                    this.oJC.remove(str2);
                    this.oJD.remove(str2);
                    if (this.oJP.dR(str2)) {
                        this.oJP.dV(str2);
                        this.oJP.remove(str2);
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    hVar = (h) this.oJx.remove(str2);
                    this.oJy.remove(str2);
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                    c(str2, hVar);
                    this.oJC.remove(str2);
                    this.oJD.remove(str2);
                    if (this.oJP.dR(str2)) {
                        this.oJP.dV(str2);
                        this.oJP.remove(str2);
                    }
                }
            } finally {
                AppMethodBeat.o(137313);
            }
        }
        this.oJu.removeAll(linkedList);
        this.oJz.remove(str);
        this.oJA.remove(str);
        this.oJP.clearCache();
        this.oJP.Ej();
        this.oJN.clear();
        this.oJO.clear();
    }

    private void SE(String str) {
        AppMethodBeat.i(137314);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", str);
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            AppMethodBeat.o(137314);
            return;
        }
        synchronized (this.lrj) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.oJP.dR(str2)) {
                        this.oJP.dV(str2);
                    }
                    h hVar = (h) this.oJx.remove(str2);
                    this.oJy.remove(str2);
                    if (hVar != null) {
                        b(str2, hVar);
                        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                        if (hVar.fqY) {
                            d(str2, hVar);
                        } else {
                            c(str2, hVar);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137314);
            }
        }
    }

    private void aS(int i, String str) {
        AppMethodBeat.i(137315);
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", Integer.valueOf(i), str);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
            str = e.bSy();
        }
        com.tencent.mm.sdk.b.b uVar = new u();
        uVar.csP.action = 4;
        uVar.csP.state = "error";
        uVar.csP.errCode = e.zS(i);
        uVar.csP.aIm = e.ph(i);
        uVar.csP.ckD = str;
        uVar.csP.appId = SF(str);
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        AppMethodBeat.o(137315);
    }

    /* JADX WARNING: Missing block: B:25:0x006c, code skipped:
            if (r6 != null) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:68:?, code skipped:
            return r5;
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            return r5;
     */
    /* JADX WARNING: Missing block: B:73:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0);
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private h bSC() {
        AppMethodBeat.i(137316);
        int i = "createOrReusePlayer";
        ab.i("MicroMsg.Audio.AudioPlayerMgr", i);
        synchronized (this.lrj) {
            int size;
            try {
                size = this.oJx.size();
                h hVar;
                if (size == 0) {
                    hVar = new h();
                } else {
                    hVar = null;
                    Object obj = "";
                    long j = 0;
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = this.oJy.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        i = (h) this.oJx.get(str);
                        if (i != null) {
                            if (!(i.fqY || i.isCompleted() || i.isStopped())) {
                                Object obj2;
                                if (i.oKc == null) {
                                    obj2 = null;
                                } else if (i.oKc.getPlayerState() == 9) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                            }
                            if (j == 0 || i.eDL < j) {
                                j = i.eDL;
                                obj = str;
                                hVar = i;
                            }
                            str = obj;
                            i = hVar;
                            obj = str;
                            hVar = i;
                        }
                    }
                    if (hVar == null || currentTimeMillis - j <= 500) {
                        hVar = new h();
                        AppMethodBeat.o(137316);
                        return hVar;
                    }
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", obj);
                    i = this.lrj;
                    synchronized (i) {
                        if (this.oJy.contains(obj)) {
                            this.oJx.remove(obj);
                            this.oJy.remove(obj);
                        }
                        size = this.oJw.contains(obj);
                        if (size == true) {
                            this.oJw.remove(obj);
                            size = this.oJv;
                            size.remove(obj);
                        }
                    }
                }
            } catch (Throwable th) {
                size = th;
                AppMethodBeat.o(i);
            } finally {
                while (true) {
                }
                i = 137316;
                AppMethodBeat.o(137316);
            }
        }
    }

    private String SF(String str) {
        String str2;
        AppMethodBeat.i(137317);
        Iterator it = this.oJz.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oJB.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                AppMethodBeat.o(137317);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.o(137317);
        return str2;
    }

    private void a(String str, h hVar) {
        AppMethodBeat.i(137318);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", str);
        b bVar = (b) this.oJC.get(str);
        if (bVar != null && hVar.aie() && hVar.aig()) {
            bVar.fqK = true;
            bVar.startTime = hVar.bTi();
        } else if (bVar != null && hVar.aig()) {
            bVar.fqK = true;
            bVar.startTime = hVar.bTi();
        } else if (bVar != null) {
            bVar.fqK = true;
            bVar.startTime = 0;
        }
        b(str, hVar);
        d Sz = Sz(str);
        if (Sz != null && hVar.aie()) {
            Sz.rw = true;
        }
        if (hVar.aie() || hVar.aig() || hVar.bTc() || hVar.bTd() || hVar.isPaused()) {
            hVar.bTf();
            AppMethodBeat.o(137318);
            return;
        }
        hVar.bTe();
        AppMethodBeat.o(137318);
    }

    /* Access modifiers changed, original: final */
    public final void b(String str, h hVar) {
        AppMethodBeat.i(137319);
        this.oJD.put(str, hVar.bTj());
        AppMethodBeat.o(137319);
    }

    static void c(String str, h hVar) {
        AppMethodBeat.i(137320);
        if (hVar == null) {
            ab.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", str);
            AppMethodBeat.o(137320);
            return;
        }
        if (hVar.aie() || hVar.aig() || hVar.bTc() || hVar.bTd() || hVar.isPaused()) {
            hVar.stopPlay();
        }
        hVar.release();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", str);
        AppMethodBeat.o(137320);
    }

    static void d(String str, h hVar) {
        AppMethodBeat.i(137321);
        ab.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
        c(str, hVar);
        AppMethodBeat.o(137321);
    }

    /* Access modifiers changed, original: final */
    public final void e(String str, h hVar) {
        AppMethodBeat.i(137322);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", str);
        synchronized (this.lrj) {
            try {
                if (this.oJy.contains(str)) {
                    this.oJx.remove(str);
                    this.oJy.remove(str);
                }
                if (!this.oJw.contains(str)) {
                    this.oJw.add(str);
                    this.oJv.put(str, hVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137322);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void f(String str, h hVar) {
        AppMethodBeat.i(137323);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", str);
        synchronized (this.lrj) {
            try {
                if (this.oJw.contains(str)) {
                    this.oJv.remove(str);
                    this.oJw.remove(str);
                }
                if (!this.oJy.contains(str)) {
                    this.oJy.add(str);
                    this.oJx.put(str, hVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137323);
            }
        }
    }

    private boolean SG(String str) {
        AppMethodBeat.i(137324);
        h SB = SB(str);
        if (SB == null) {
            AppMethodBeat.o(137324);
            return false;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", str);
        c(str, SB);
        synchronized (this.lrj) {
            try {
                this.oJv.remove(str);
                this.oJw.remove(str);
                this.oJx.remove(str);
                this.oJy.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137324);
            }
        }
        return true;
    }

    private static boolean a(h hVar) {
        AppMethodBeat.i(137325);
        if (hVar == null) {
            AppMethodBeat.o(137325);
            return true;
        }
        boolean z;
        if (hVar.aie() || hVar.isPaused() || hVar.bTc() || hVar.bTd() || hVar.aig()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(137325);
            return false;
        }
        AppMethodBeat.o(137325);
        return true;
    }

    public final void bSD() {
        AppMethodBeat.i(137326);
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.oJH || currentTimeMillis - this.oJJ >= 10000) {
            this.oJJ = currentTimeMillis;
            synchronized (this.lrj) {
                try {
                    this.oJH = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(137326);
                }
            }
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", Integer.valueOf(1800000));
            al.af(this.oJT);
            al.n(this.oJT, 1800000);
            return;
        }
        AppMethodBeat.o(137326);
    }

    private int bSE() {
        int i;
        AppMethodBeat.i(137327);
        synchronized (this.lrj) {
            try {
                Iterator it = this.oJy.iterator();
                i = 0;
                while (it.hasNext()) {
                    boolean z;
                    int i2;
                    String str = (String) it.next();
                    h SB = SB(str);
                    if (SB == null) {
                        ab.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
                        d Sz = Sz(str);
                        if (Sz != null) {
                            z = Sz.rw;
                        } else {
                            z = false;
                        }
                    } else {
                        z = SB.isPaused();
                    }
                    if (z) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137327);
            }
        }
        return i;
    }

    private void SH(String str) {
        AppMethodBeat.i(137328);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
        int size = this.oJv.size();
        int size2 = this.oJx.size();
        int bSE = bSE();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(bSE));
        if (size >= 10) {
            bSF();
        } else if (bSE >= 6) {
            bSF();
        } else if (size + bSE >= 8) {
            bSF();
        }
        String SF = SF(str);
        bSE = this.oJv.size();
        size = this.oJx.size();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(bSE), Integer.valueOf(size));
        Iterator it;
        String str2;
        if (size >= 50) {
            it = this.oJz.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(SF))) {
                    SI(str2);
                }
            }
        } else if (size + bSE >= 50) {
            it = this.oJz.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(SF))) {
                    SI(str2);
                }
            }
        } else {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
        }
        size = this.oJx.size();
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(bSE), Integer.valueOf(size));
        if (size >= 50) {
            bSG();
            AppMethodBeat.o(137328);
        } else if (size + bSE >= 50) {
            bSG();
            AppMethodBeat.o(137328);
        } else {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
            AppMethodBeat.o(137328);
        }
    }

    private void bSF() {
        AppMethodBeat.i(137329);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
        synchronized (this.lrj) {
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.oJy);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    h hVar = (h) this.oJx.get(str);
                    if (hVar != null && hVar.isPaused()) {
                        a(str, hVar);
                    }
                }
            } finally {
                AppMethodBeat.o(137329);
            }
        }
    }

    private void bSG() {
        AppMethodBeat.i(137330);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
        synchronized (this.lrj) {
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.oJy);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    h hVar = (h) this.oJx.remove(str);
                    this.oJy.remove(str);
                    if (hVar != null) {
                        if (hVar.fqY) {
                            b(str, hVar);
                            d(str, hVar);
                        } else if (!hVar.isPaused()) {
                            b(str, hVar);
                            c(str, hVar);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137330);
            }
        }
    }

    private void SI(String str) {
        AppMethodBeat.i(137331);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
        SE(str);
        AppMethodBeat.o(137331);
    }

    /* JADX WARNING: Missing block: B:29:0x00d9, code skipped:
            r4 = "";
            r6 = com.tencent.mm.plugin.music.cache.g.bTA();
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", java.lang.Integer.valueOf(r6));
            r10 = r3.iterator();
            r3 = r6;
     */
    /* JADX WARNING: Missing block: B:31:0x00fc, code skipped:
            if (r10.hasNext() == false) goto L_0x0133;
     */
    /* JADX WARNING: Missing block: B:32:0x00fe, code skipped:
            r1 = (java.lang.String) r10.next();
            r2 = ((java.lang.Integer) r7.get(r1)).intValue();
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", java.lang.Integer.valueOf(r2), r1);
     */
    /* JADX WARNING: Missing block: B:33:0x0124, code skipped:
            if (r2 < r6) goto L_0x0258;
     */
    /* JADX WARNING: Missing block: B:34:0x0126, code skipped:
            r5 = true;
     */
    /* JADX WARNING: Missing block: B:35:0x0127, code skipped:
            if (r3 >= r2) goto L_0x0255;
     */
    /* JADX WARNING: Missing block: B:36:0x0129, code skipped:
            r4 = r1;
     */
    /* JADX WARNING: Missing block: B:38:0x012e, code skipped:
            if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0131;
     */
    /* JADX WARNING: Missing block: B:39:0x0130, code skipped:
            r4 = r1;
     */
    /* JADX WARNING: Missing block: B:40:0x0131, code skipped:
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:41:0x0133, code skipped:
            if (r5 == false) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:42:0x0135, code skipped:
            r1 = (com.tencent.mm.ag.b) r16.oJC.get(r17);
     */
    /* JADX WARNING: Missing block: B:43:0x0141, code skipped:
            if (r1 == null) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:44:0x0143, code skipped:
            if (r4 == null) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:46:0x014b, code skipped:
            if (r4.equalsIgnoreCase(r1.clP) == false) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:47:0x014d, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:48:0x0158, code skipped:
            if (r2 == false) goto L_0x0241;
     */
    /* JADX WARNING: Missing block: B:49:0x015a, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
            r1 = (java.util.ArrayList) r8.get(r4);
     */
    /* JADX WARNING: Missing block: B:50:0x0169, code skipped:
            if (r1 == null) goto L_0x020d;
     */
    /* JADX WARNING: Missing block: B:52:0x016f, code skipped:
            if (r1.size() <= 0) goto L_0x020d;
     */
    /* JADX WARNING: Missing block: B:53:0x0171, code skipped:
            r3 = new java.util.LinkedList();
            r4 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:55:0x017e, code skipped:
            if (r4.hasNext() == false) goto L_0x0196;
     */
    /* JADX WARNING: Missing block: B:56:0x0180, code skipped:
            r1 = (com.tencent.mm.ag.b) r16.oJC.get((java.lang.String) r4.next());
     */
    /* JADX WARNING: Missing block: B:57:0x0190, code skipped:
            if (r1 == null) goto L_0x017a;
     */
    /* JADX WARNING: Missing block: B:58:0x0192, code skipped:
            r3.add(r1);
     */
    /* JADX WARNING: Missing block: B:59:0x0196, code skipped:
            java.util.Collections.sort(r3, new com.tencent.mm.plugin.music.b.f.a(r16));
            r4 = new java.util.LinkedList();
            r3 = r3.iterator();
     */
    /* JADX WARNING: Missing block: B:61:0x01ad, code skipped:
            if (r3.hasNext() == false) goto L_0x01bb;
     */
    /* JADX WARNING: Missing block: B:62:0x01af, code skipped:
            r4.add(((com.tencent.mm.ag.b) r3.next()).ckD);
     */
    /* JADX WARNING: Missing block: B:63:0x01bb, code skipped:
            r1 = r9 - 10;
     */
    /* JADX WARNING: Missing block: B:64:0x01bd, code skipped:
            if (r1 <= 0) goto L_0x0216;
     */
    /* JADX WARNING: Missing block: B:66:0x01c3, code skipped:
            if (r4.size() <= r1) goto L_0x0216;
     */
    /* JADX WARNING: Missing block: B:67:0x01c5, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", java.lang.Integer.valueOf(r1 + 1));
            r1 = r4.size() - r1;
     */
    /* JADX WARNING: Missing block: B:68:0x01e0, code skipped:
            if (r1 >= 0) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:69:0x01e2, code skipped:
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:70:0x01e3, code skipped:
            r16.oJE.addAll(r4.subList(r1, r4.size()));
     */
    /* JADX WARNING: Missing block: B:71:0x01f2, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", java.lang.Integer.valueOf(r16.oJE.size()));
     */
    /* JADX WARNING: Missing block: B:72:0x020d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(137332);
     */
    /* JADX WARNING: Missing block: B:73:0x0216, code skipped:
            if (r1 <= 0) goto L_0x022f;
     */
    /* JADX WARNING: Missing block: B:75:0x021c, code skipped:
            if (r4.size() >= r1) goto L_0x022f;
     */
    /* JADX WARNING: Missing block: B:76:0x021e, code skipped:
            r16.oJE.addAll(r4.subList(1, r4.size()));
     */
    /* JADX WARNING: Missing block: B:77:0x022f, code skipped:
            r16.oJE.add(r4.get(r4.size() - 1));
     */
    /* JADX WARNING: Missing block: B:78:0x0241, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
            r16.oJE.clear();
     */
    /* JADX WARNING: Missing block: B:79:0x0252, code skipped:
            r2 = r5;
     */
    /* JADX WARNING: Missing block: B:80:0x0255, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:81:0x0258, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:98:?, code skipped:
            return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean SJ(String str) {
        AppMethodBeat.i(137332);
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.lrj) {
            try {
                int size = this.oJv.size();
                if (size < 10) {
                    this.oJE.clear();
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", Integer.valueOf(size));
                } else {
                    Iterator it = this.oJw.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) this.oJC.get((String) it.next());
                        if (!(bVar == null || bVar.clP == null)) {
                            ArrayList arrayList2;
                            if (hashMap.containsKey(bVar.clP)) {
                                hashMap.put(bVar.clP, Integer.valueOf(((Integer) hashMap.get(bVar.clP)).intValue() + 1));
                                arrayList2 = (ArrayList) hashMap2.get(bVar.clP);
                                if (!arrayList2.contains(bVar.ckD)) {
                                    arrayList2.add(bVar.ckD);
                                }
                                hashMap2.put(bVar.clP, arrayList2);
                            } else {
                                hashMap.put(bVar.clP, Integer.valueOf(1));
                                arrayList2 = new ArrayList();
                                arrayList2.add(bVar.ckD);
                                hashMap2.put(bVar.clP, arrayList2);
                            }
                            if (!arrayList.contains(bVar.clP)) {
                                arrayList.add(bVar.clP);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137332);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bSH() {
        AppMethodBeat.i(137333);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
        Iterator it = this.oJE.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", (String) it.next());
            Su(r0);
            bSL();
        }
        it = this.oJG.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", (String) it.next());
            Su(r0);
            bSL();
        }
        this.oJE.clear();
        this.oJG.clear();
        AppMethodBeat.o(137333);
    }

    public final void SK(String str) {
        AppMethodBeat.i(137334);
        if (this.oJz.size() == 0) {
            AppMethodBeat.o(137334);
            return;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", str);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.oJz);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String str3 = (String) this.oJA.get(str2);
            if (str != null && str.equalsIgnoreCase(str3)) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
                SD(str2);
            }
        }
        AppMethodBeat.o(137334);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:29:0x00d2, code skipped:
            r0 = (com.tencent.mm.ag.b) r13.oJC.get(r14);
            r2 = r5.iterator();
     */
    /* JADX WARNING: Missing block: B:31:0x00e2, code skipped:
            if (r2.hasNext() == false) goto L_0x0108;
     */
    /* JADX WARNING: Missing block: B:32:0x00e4, code skipped:
            r1 = (java.lang.String) r2.next();
     */
    /* JADX WARNING: Missing block: B:33:0x00ea, code skipped:
            if (r0 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:34:0x00ec, code skipped:
            if (r1 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:36:0x00f4, code skipped:
            if (r1.equalsIgnoreCase(r0.clP) == false) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:37:0x00f6, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
            com.tencent.matrix.trace.core.AppMethodBeat.o(137335);
     */
    /* JADX WARNING: Missing block: B:38:0x0108, code skipped:
            r3 = "";
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", java.lang.Integer.valueOf(2));
            r2 = 2;
            r5 = r5.iterator();
     */
    /* JADX WARNING: Missing block: B:40:0x0128, code skipped:
            if (r5.hasNext() == false) goto L_0x0160;
     */
    /* JADX WARNING: Missing block: B:41:0x012a, code skipped:
            r0 = (java.lang.String) r5.next();
            r1 = ((java.lang.Integer) r6.get(r0)).intValue();
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", java.lang.Integer.valueOf(r1), r0);
     */
    /* JADX WARNING: Missing block: B:42:0x0151, code skipped:
            if (r1 < 2) goto L_0x01f6;
     */
    /* JADX WARNING: Missing block: B:43:0x0153, code skipped:
            r4 = true;
     */
    /* JADX WARNING: Missing block: B:44:0x0154, code skipped:
            if (r2 >= r1) goto L_0x01f3;
     */
    /* JADX WARNING: Missing block: B:45:0x0156, code skipped:
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:47:0x015b, code skipped:
            if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x015e;
     */
    /* JADX WARNING: Missing block: B:48:0x015d, code skipped:
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:49:0x015e, code skipped:
            r2 = r1;
     */
    /* JADX WARNING: Missing block: B:50:0x0160, code skipped:
            if (r4 == false) goto L_0x01e9;
     */
    /* JADX WARNING: Missing block: B:51:0x0162, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
            r0 = (java.util.ArrayList) r7.get(r3);
     */
    /* JADX WARNING: Missing block: B:52:0x0171, code skipped:
            if (r0 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Missing block: B:54:0x0177, code skipped:
            if (r0.size() <= 0) goto L_0x01e1;
     */
    /* JADX WARNING: Missing block: B:55:0x0179, code skipped:
            r1 = new java.util.LinkedList();
            r2 = r0.iterator();
     */
    /* JADX WARNING: Missing block: B:57:0x0186, code skipped:
            if (r2.hasNext() == false) goto L_0x019c;
     */
    /* JADX WARNING: Missing block: B:58:0x0188, code skipped:
            r0 = (com.tencent.mm.ag.b) r13.oJC.get((java.lang.String) r2.next());
     */
    /* JADX WARNING: Missing block: B:59:0x0196, code skipped:
            if (r0 == null) goto L_0x0182;
     */
    /* JADX WARNING: Missing block: B:60:0x0198, code skipped:
            r1.add(r0);
     */
    /* JADX WARNING: Missing block: B:61:0x019c, code skipped:
            java.util.Collections.sort(r1, new com.tencent.mm.plugin.music.b.f.a(r13));
            r2 = new java.util.LinkedList();
            r1 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:63:0x01b1, code skipped:
            if (r1.hasNext() == false) goto L_0x01bf;
     */
    /* JADX WARNING: Missing block: B:64:0x01b3, code skipped:
            r2.add(((com.tencent.mm.ag.b) r1.next()).ckD);
     */
    /* JADX WARNING: Missing block: B:65:0x01bf, code skipped:
            r13.oJG.add(r2.getLast());
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", java.lang.Integer.valueOf(r13.oJG.size()));
     */
    /* JADX WARNING: Missing block: B:66:0x01e1, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(137335);
     */
    /* JADX WARNING: Missing block: B:67:0x01e9, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
     */
    /* JADX WARNING: Missing block: B:68:0x01f3, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:69:0x01f6, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:92:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:93:?, code skipped:
            return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean SL(String str) {
        AppMethodBeat.i(137335);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.lrj) {
            try {
                if (this.oJv.size() <= 5) {
                    ab.i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", Integer.valueOf(this.oJv.size()));
                    z = false;
                } else {
                    Iterator it = this.oJw.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) this.oJC.get((String) it.next());
                        if (!(bVar == null || bVar.clP == null)) {
                            ArrayList arrayList2;
                            if (hashMap.containsKey(bVar.clP)) {
                                hashMap.put(bVar.clP, Integer.valueOf(((Integer) hashMap.get(bVar.clP)).intValue() + 1));
                                arrayList2 = (ArrayList) hashMap2.get(bVar.clP);
                                if (!arrayList2.contains(bVar.ckD)) {
                                    arrayList2.add(bVar.ckD);
                                }
                                hashMap2.put(bVar.clP, arrayList2);
                            } else {
                                hashMap.put(bVar.clP, Integer.valueOf(1));
                                arrayList2 = new ArrayList();
                                arrayList2.add(bVar.ckD);
                                hashMap2.put(bVar.clP, arrayList2);
                            }
                            if (!arrayList.contains(bVar.clP)) {
                                arrayList.add(bVar.clP);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137335);
            }
        }
        return z;
    }

    private void bSI() {
        AppMethodBeat.i(137336);
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", Boolean.valueOf(this.csM.fqI), Boolean.valueOf(this.oJM.oKT));
        if (this.csM.fqI || this.oJM.oKT) {
            if (this.csM.fqI && this.oJM.oKT) {
                ab.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
                bSK();
            }
            AppMethodBeat.o(137336);
            return;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
        bSJ();
        AppMethodBeat.o(137336);
    }

    private void bSL() {
        AppMethodBeat.i(137339);
        this.oJL = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.b.a.d.class);
        if (this.oJL != null) {
            this.oJL.bTm();
        }
        AppMethodBeat.o(137339);
    }

    private void j(b bVar) {
        AppMethodBeat.i(137340);
        this.oJL = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.b.a.d.class);
        if (this.oJL != null) {
            this.oJL.fl(bVar.ckD, bVar.clP);
        }
        AppMethodBeat.o(137340);
    }

    private void a(b bVar, boolean z, boolean z2) {
        long j;
        AppMethodBeat.i(137341);
        this.oJL = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.b.a.d.class);
        if (this.oJL != null) {
            this.oJL.r(bVar.ckD, bVar.clP, z2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        bVar.fqO = currentTimeMillis;
        if (z) {
            j = bVar.fqS;
            bVar.fqP = bVar.fqR;
        } else {
            j = bVar.fqU;
            bVar.fqP = bVar.fqT;
        }
        if (j <= 0 || currentTimeMillis <= j) {
            bVar.fqQ = 0;
            AppMethodBeat.o(137341);
            return;
        }
        bVar.fqQ = currentTimeMillis - j;
        AppMethodBeat.o(137341);
    }

    private static void k(b bVar) {
        AppMethodBeat.i(137343);
        if (bVar.fqV != null) {
            try {
                bVar.fqV.close();
                bVar.fqV = null;
                AppMethodBeat.o(137343);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", e, "closeAudioDataSource", new Object[0]);
            }
        }
        AppMethodBeat.o(137343);
    }

    private void bSJ() {
        AppMethodBeat.i(137337);
        if (this.oJM.oKT) {
            AppMethodBeat.o(137337);
            return;
        }
        ab.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", Boolean.valueOf(this.oJM.requestFocus()));
        AppMethodBeat.o(137337);
    }

    /* Access modifiers changed, original: final */
    public final void bSK() {
        AppMethodBeat.i(137338);
        if (this.oJM.oKT) {
            this.oJM.bSK();
        }
        AppMethodBeat.o(137338);
    }

    public final void SM(final String str) {
        AppMethodBeat.i(137342);
        if (b.bSx()) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(137273);
                    b bVar = (b) f.this.oJC.get(str);
                    if (bVar == null) {
                        ab.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
                    }
                    if (!TextUtils.isEmpty(bVar.filePath) && !f.this.oJP.ee(bVar.filePath)) {
                        Object obj;
                        long ek = com.tencent.mm.audio.mix.h.a.ek(bVar.filePath);
                        ab.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", bVar.filePath, Long.valueOf(ek));
                        long Dn = com.tencent.mm.audio.mix.b.d.Dm().Dn();
                        c cVar = f.this.oJP;
                        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", Long.valueOf(com.tencent.mm.audio.mix.b.d.Dm().Dn()), cVar.appId);
                        if (com.tencent.mm.audio.mix.b.d.Dm().Dn() >= 50000000) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", cVar.appId);
                        }
                        int i = 0;
                        if (f.this.oJO.containsKey(bVar.filePath)) {
                            i = ((Integer) f.this.oJO.get(bVar.filePath)).intValue();
                        }
                        if (obj != null) {
                            ab.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
                            if (f.this.oJL != null) {
                                f.this.oJL.zs(713);
                            }
                            f.this.oJP.ec("");
                        } else if (Dn + ek > 50000000) {
                            ab.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", Long.valueOf(Dn), Long.valueOf(ek));
                            if (f.this.oJL != null) {
                                f.this.oJL.zs(714);
                            }
                            f.this.oJP.ec("");
                        } else if (i >= 30) {
                            ab.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
                        } else if (com.tencent.mm.audio.mix.h.a.ej(bVar.filePath)) {
                            c cVar2 = f.this.oJP;
                            if (cVar2.cnp.dB(bVar.filePath)) {
                                ab.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
                            } else {
                                bVar.fqX = true;
                                bVar.fileSize = ek;
                                f.this.oJP.a(bVar);
                            }
                        } else {
                            ab.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
                        }
                    } else if (TextUtils.isEmpty(bVar.filePath)) {
                        bVar.fqX = false;
                    } else {
                        bVar.fqX = false;
                        if (!f.this.oJP.dR(str)) {
                            f.this.oJP.b(bVar);
                        }
                        bVar.fileSize = com.tencent.mm.audio.mix.h.a.ek(bVar.filePath);
                    }
                    AppMethodBeat.o(137273);
                    return false;
                }
            });
            AppMethodBeat.o(137342);
            return;
        }
        AppMethodBeat.o(137342);
    }
}
