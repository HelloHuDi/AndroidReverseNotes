package com.tencent.mm.audio.mix.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.a.d;
import com.tencent.mm.audio.mix.c.e;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.k;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class c {
    public String appId;
    public d cno = new d();
    public a cnp = new a(this.cno);
    public HashMap<String, Boolean> cnq = new HashMap();
    private e cnr = new e();
    public d cns = new d();

    public c() {
        AppMethodBeat.i(137139);
        AppMethodBeat.o(137139);
    }

    public final void Eh() {
        AppMethodBeat.i(137140);
        a aVar = this.cnp;
        b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
        Iterator it = aVar.clF.iterator();
        while (it.hasNext()) {
            com.tencent.mm.audio.mix.d.b bVar = (com.tencent.mm.audio.mix.d.b) aVar.clC.get((String) it.next());
            if (!(bVar == null || bVar.clI || bVar.Dv())) {
                k kVar = bVar.clJ;
                if (!(kVar == null || kVar.DA())) {
                    kVar.Dx();
                }
            }
        }
        d dVar = this.cno;
        b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
        dVar.cnB.DS();
        dVar.El();
        e eVar = this.cnr;
        if (e.clx == 0) {
            e.clx = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - e.clx <= e.clu.longValue()) {
            b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
        } else {
            e.clx = currentTimeMillis;
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
            h.a(new e.a("clean audio mix convert cache"));
        }
        com.tencent.mm.audio.mix.b.d Dm = com.tencent.mm.audio.mix.b.d.Dm();
        synchronized (Dm.ckQ) {
            try {
                Iterator it2 = Dm.ckO.iterator();
                while (it2.hasNext()) {
                    com.tencent.mm.audio.mix.a.c cVar = (com.tencent.mm.audio.mix.a.c) Dm.ckP.get((String) it2.next());
                    if (cVar != null && cVar.cky && cVar.ckB) {
                        cVar.Dc();
                    }
                }
            } finally {
                AppMethodBeat.o(137140);
            }
        }
    }

    public final void clearCache() {
        AppMethodBeat.i(137141);
        this.cnp.clearCache();
        this.cno.clearCache();
        AppMethodBeat.o(137141);
    }

    public final void a(com.tencent.mm.ag.b bVar) {
        AppMethodBeat.i(137142);
        this.appId = bVar.appId;
        b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", bVar.ckD);
        if (ee(bVar.filePath) && bVar.fqK) {
            d(bVar);
        }
        d dVar = this.cno;
        b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
        if (bVar.fqX || !bVar.fqK) {
            if (bVar.fqX) {
                synchronized (dVar.cnz) {
                    try {
                        if (dVar.cnH.containsKey(bVar.ckD)) {
                            e eVar = (e) dVar.cnH.get(bVar.ckD);
                            if (eVar != null) {
                                if (eVar.g(Integer.valueOf(4))) {
                                    dVar.cnH.remove(bVar.ckD);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(137142);
                    }
                }
            }
        } else if (dVar.cnu.get()) {
            dVar.Em();
        } else if (!dVar.cnu.get()) {
            b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
            dVar.cnu.set(true);
            dVar.cnw.set(false);
            dVar.cnv.set(false);
            dVar.Em();
        }
        dVar.clD.put(bVar.ckD, bVar);
        synchronized (dVar.cnz) {
            try {
                dVar.cmD.put(bVar.ckD, Boolean.FALSE);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137142);
            }
        }
        dVar.cnB.dG(bVar.ckD);
        dVar.cnB.DR();
        a aVar = this.cnp;
        b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (bVar == null) {
            b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
        } else if (TextUtils.isEmpty(bVar.ckD)) {
            b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
            AppMethodBeat.o(137142);
        } else {
            boolean z;
            if (aVar.clF.contains(bVar.ckD)) {
                if (((com.tencent.mm.ag.b) aVar.clD.get(bVar.ckD)).e(bVar)) {
                    b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
                    z = false;
                } else {
                    b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
                    z = true;
                }
                aVar.clD.put(bVar.ckD, bVar);
            } else {
                aVar.clF.add(bVar.ckD);
                aVar.clD.put(bVar.ckD, bVar);
                z = false;
            }
            b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", Integer.valueOf(aVar.clF.size()), Integer.valueOf(aVar.clD.size()));
            if (bVar.fqX) {
                z = aVar.b(bVar.ckD, z, true);
                synchronized (aVar.ckQ) {
                    if (z) {
                        try {
                            if (!aVar.clE.contains(bVar.filePath)) {
                                aVar.clE.add(bVar.filePath);
                            }
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.o(137142);
                            }
                        }
                    }
                }
                AppMethodBeat.o(137142);
            } else if (bVar.fqK) {
                aVar.b(bVar.ckD, z, false);
                AppMethodBeat.o(137142);
            } else {
                z = aVar.b(bVar.ckD, z, true);
                synchronized (aVar.ckQ) {
                    if (z) {
                        try {
                            if (!aVar.clE.contains(bVar.filePath)) {
                                aVar.clE.add(bVar.filePath);
                            }
                        } catch (Throwable th3) {
                            while (true) {
                                AppMethodBeat.o(137142);
                            }
                        }
                    }
                }
                AppMethodBeat.o(137142);
            }
        }
    }

    public final void b(com.tencent.mm.ag.b bVar) {
        AppMethodBeat.i(137143);
        this.cno.clD.put(bVar.ckD, bVar);
        this.cnp.clD.put(bVar.ckD, bVar);
        AppMethodBeat.o(137143);
    }

    public final void c(com.tencent.mm.ag.b bVar) {
        AppMethodBeat.i(137144);
        d dVar = this.cno;
        if (dVar.clD.containsKey(bVar.ckD)) {
            dVar.clD.put(bVar.ckD, bVar);
        }
        a aVar = this.cnp;
        if (aVar.clD.containsKey(bVar.ckD)) {
            aVar.clD.put(bVar.ckD, bVar);
        }
        AppMethodBeat.o(137144);
    }

    private com.tencent.mm.ag.b dQ(String str) {
        AppMethodBeat.i(137145);
        com.tencent.mm.ag.b dQ = this.cno.dQ(str);
        AppMethodBeat.o(137145);
        return dQ;
    }

    public final boolean dR(String str) {
        AppMethodBeat.i(137146);
        if (this.cno.clD.containsKey(str)) {
            AppMethodBeat.o(137146);
            return true;
        }
        AppMethodBeat.o(137146);
        return false;
    }

    public final void dS(String str) {
        AppMethodBeat.i(137147);
        b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.eg(str)));
        d(this.cno.dQ(str));
        d dVar = this.cno;
        dVar.cnw.set(false);
        dVar.cnv.set(false);
        dVar.Eq();
        dVar.Em();
        synchronized (dVar.cnz) {
            try {
                dVar.cmD.put(str, Boolean.FALSE);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137147);
                }
            }
        }
        dVar.cnB.dG(str);
        dVar.cnF.remove(str);
        dVar.cnG.put(str, Boolean.TRUE);
        if (dVar.cnp.dE(str) && dVar.cnp.dF(str)) {
            dVar.i(0, str);
        }
        this.cnp.dC(str);
        AppMethodBeat.o(137147);
    }

    private void d(com.tencent.mm.ag.b bVar) {
        AppMethodBeat.i(137148);
        bVar.ckA = true;
        int ea = this.cno.ea(bVar.ckD);
        int Es = this.cno.Es();
        if (ea <= 2000) {
            bVar.ckA = false;
        }
        if (ea >= 5000 || Es > 5) {
            bVar.ckA = true;
        } else {
            bVar.ckA = false;
        }
        if (bVar.filePath.contains("scale_intro")) {
            bVar.ckA = false;
        }
        if (Es > 5) {
            ArrayList Et = this.cno.Et();
            if (Et.contains(bVar.ckD)) {
                Et.remove(bVar.ckD);
            }
            if (Et.size() > 2) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", Integer.valueOf(Et.size()));
                Iterator it = Et.iterator();
                while (it.hasNext()) {
                    dV((String) it.next());
                }
            }
        }
        b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", Integer.valueOf(Es), Integer.valueOf(ea), Boolean.valueOf(bVar.ckA));
        AppMethodBeat.o(137148);
    }

    public final void dT(String str) {
        AppMethodBeat.i(137149);
        b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.eg(str)));
        d(this.cno.dQ(str));
        d dVar = this.cno;
        dVar.cnw.set(false);
        dVar.cnv.set(false);
        dVar.Eq();
        dVar.Em();
        synchronized (dVar.cnz) {
            try {
                dVar.cmD.put(str, Boolean.FALSE);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137149);
                }
            }
        }
        dVar.cnB.dG(str);
        dVar.cnF.remove(str);
        dVar.cnG.put(str, Boolean.TRUE);
        if (dVar.cnp.dE(str) && dVar.cnp.dF(str)) {
            dVar.i(1, str);
        }
        this.cnp.dC(str);
        AppMethodBeat.o(137149);
    }

    public final void dU(String str) {
        AppMethodBeat.i(137150);
        b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.eg(str)));
        d dVar = this.cno;
        dVar.cnB.dH(str);
        if (dVar.cnp.dE(str) && dVar.cnp.dF(str)) {
            dVar.i(2, str);
        }
        a aVar = this.cnp;
        b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", str);
        com.tencent.mm.audio.mix.d.b bVar = (com.tencent.mm.audio.mix.d.b) aVar.clC.get(str);
        if (bVar == null) {
            b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.o(137150);
        } else if (bVar.clI) {
            b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.o(137150);
        } else if (bVar.Dv()) {
            b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            AppMethodBeat.o(137150);
        } else {
            k kVar = bVar.clJ;
            if (kVar != null) {
                kVar.pause();
            }
            AppMethodBeat.o(137150);
        }
    }

    public final void dV(String str) {
        AppMethodBeat.i(137151);
        b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.eg(str)));
        this.cno.dV(str);
        this.cnp.dD(str);
        AppMethodBeat.o(137151);
    }

    public final void remove(String str) {
        AppMethodBeat.i(137152);
        b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", str);
        d dVar = this.cno;
        dVar.clD.remove(str);
        dVar.cnF.remove(str);
        dVar.cnG.remove(str);
        synchronized (dVar.cnz) {
            try {
                dVar.cnH.remove(str);
                dVar.cmD.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137152);
                }
            }
        }
        dVar.cnI.remove(str);
        a aVar = this.cnp;
        if (aVar.clC.containsKey(str) && aVar.clF.contains(str)) {
            aVar.dD(str);
        }
        aVar.clD.remove(str);
        aVar.clF.remove(str);
        AppMethodBeat.o(137152);
    }

    public final boolean w(String str, int i) {
        AppMethodBeat.i(137153);
        b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", str, Integer.valueOf(i));
        boolean v = this.cnp.v(str, i);
        if (v) {
            boolean z;
            i(10, str);
            long ef = (long) this.cno.ef(str);
            int eg = this.cno.eg(str);
            if (!ed(str)) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
                z = true;
            } else if (ea(str) <= 2000) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
                if (this.cnp.dE(str)) {
                    z = true;
                } else {
                    v = this.cnp.u(str, i);
                    z = true;
                }
            } else if (Math.abs(((long) i) - ef) <= 3000) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
                z = true;
            } else if (eg != 0 && eg != 1 && eg != 2) {
                b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
                z = true;
            } else if (this.cnp.dE(str)) {
                z = this.cno.cnB.w(str, i);
            } else {
                v = this.cnp.u(str, i);
                z = true;
            }
            i(6, str);
            if (z && v) {
                AppMethodBeat.o(137153);
                return true;
            }
            AppMethodBeat.o(137153);
            return false;
        }
        b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", Integer.valueOf(i));
        AppMethodBeat.o(137153);
        return false;
    }

    public final boolean dF(String str) {
        AppMethodBeat.i(137154);
        boolean dF = this.cno.dF(str);
        AppMethodBeat.o(137154);
        return dF;
    }

    public final boolean dW(String str) {
        AppMethodBeat.i(137155);
        d dVar = this.cno;
        if (dVar.cnG.containsKey(str)) {
            boolean booleanValue = ((Boolean) dVar.cnG.get(str)).booleanValue();
            AppMethodBeat.o(137155);
            return booleanValue;
        }
        AppMethodBeat.o(137155);
        return false;
    }

    public final boolean dX(String str) {
        AppMethodBeat.i(137156);
        d dVar = this.cno;
        if (dVar.cnH.containsKey(str)) {
            e eVar = (e) dVar.cnH.get(str);
            if (eVar != null) {
                if (eVar.g(Integer.valueOf(9))) {
                    AppMethodBeat.o(137156);
                    return true;
                }
            }
        }
        AppMethodBeat.o(137156);
        return false;
    }

    public final boolean dY(String str) {
        AppMethodBeat.i(137157);
        d dVar = this.cno;
        if (dVar.cnH.containsKey(str)) {
            e eVar = (e) dVar.cnH.get(str);
            if (eVar != null) {
                if (eVar.g(Integer.valueOf(7))) {
                    AppMethodBeat.o(137157);
                    return true;
                }
            }
        }
        AppMethodBeat.o(137157);
        return false;
    }

    public final boolean isPaused(String str) {
        AppMethodBeat.i(137158);
        d dVar = this.cno;
        if (dVar.cnH.containsKey(str)) {
            e eVar = (e) dVar.cnH.get(str);
            if (eVar != null) {
                if (eVar.g(Integer.valueOf(2))) {
                    AppMethodBeat.o(137158);
                    return true;
                }
            }
        }
        AppMethodBeat.o(137158);
        return false;
    }

    /* JADX WARNING: Missing block: B:9:0x0047, code skipped:
            if (r0.g(java.lang.Integer.valueOf(5)) != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dZ(String str) {
        AppMethodBeat.i(137159);
        d dVar = this.cno;
        if (dVar.cnH.containsKey(str)) {
            e eVar = (e) dVar.cnH.get(str);
            if (eVar != null) {
                if (!eVar.g(Integer.valueOf(3))) {
                    if (!eVar.g(Integer.valueOf(4))) {
                    }
                }
                AppMethodBeat.o(137159);
                return true;
            }
        }
        AppMethodBeat.o(137159);
        return false;
    }

    public final boolean Ei() {
        AppMethodBeat.i(137160);
        boolean z = this.cno.cnw.get();
        AppMethodBeat.o(137160);
        return z;
    }

    public final int ea(String str) {
        AppMethodBeat.i(137161);
        int ea = this.cno.ea(str);
        AppMethodBeat.o(137161);
        return ea;
    }

    public final void a(b bVar) {
        this.cno.cnC = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ag.d eb(String str) {
        com.tencent.mm.ag.d dVar;
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(137162);
        d dVar2 = this.cno;
        if (dVar2.cnI.containsKey(str)) {
            dVar = (com.tencent.mm.ag.d) dVar2.cnI.get(str);
        } else {
            com.tencent.mm.ag.d dVar3 = new com.tencent.mm.ag.d();
            dVar2.cnI.put(str, dVar3);
            dVar = dVar3;
        }
        int ea = dVar2.ea(str);
        int ef = dVar2.ef(str);
        boolean dF = dVar2.dF(str);
        if (dVar2.clD.containsKey(str)) {
            String str2 = ((com.tencent.mm.ag.b) dVar2.clD.get(str)).filePath;
            if (!TextUtils.isEmpty(str2)) {
                com.tencent.mm.audio.mix.a.c dv = com.tencent.mm.audio.mix.b.d.Dm().dv(str2);
                if (dv != null && dv.duration > 0) {
                    i = 100;
                    if (i >= 0) {
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    dVar.csK = ef;
                    dVar.duration = ea;
                    if (dF) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dVar.rw = z;
                    if (!(dVar2.cnF.containsKey(str) && ((Boolean) dVar2.cnF.get(str)).booleanValue())) {
                        z2 = false;
                    }
                    dVar.fqY = z2;
                    dVar.fqZ = (i2 * ea) / 100;
                    if (dVar2.clD.containsKey(str)) {
                        AppMethodBeat.o(137162);
                        return null;
                    }
                    com.tencent.mm.ag.b bVar = (com.tencent.mm.ag.b) dVar2.clD.get(str);
                    dVar.startTime = bVar.fqJ;
                    dVar.ckz = bVar.clP;
                    AppMethodBeat.o(137162);
                    return dVar;
                }
            }
        }
        i = 0;
        if (i >= 0) {
        }
        dVar.csK = ef;
        dVar.duration = ea;
        if (dF) {
        }
        dVar.rw = z;
        z2 = false;
        dVar.fqY = z2;
        dVar.fqZ = (i2 * ea) / 100;
        if (dVar2.clD.containsKey(str)) {
        }
    }

    public final void i(int i, String str) {
        AppMethodBeat.i(137163);
        this.cno.i(i, str);
        AppMethodBeat.o(137163);
    }

    public final void a(g gVar) {
        this.cno.cnE = gVar;
    }

    public final void Ej() {
        AppMethodBeat.i(137164);
        b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", this.appId);
        d.a(new com.tencent.mm.audio.mix.b.a.c(r0), "AudioPcmDataTrackRecycleCacheTask");
        this.cnq.clear();
        AppMethodBeat.o(137164);
    }

    public final void ec(String str) {
        AppMethodBeat.i(137165);
        b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", this.appId, str);
        d.a(new com.tencent.mm.audio.mix.b.a.a(r0, str), "AudioPcmDataTrackCacheToFileTask");
        AppMethodBeat.o(137165);
    }

    public final boolean ed(String str) {
        AppMethodBeat.i(137166);
        com.tencent.mm.ag.b dQ = dQ(str);
        boolean booleanValue;
        if (dQ == null) {
            AppMethodBeat.o(137166);
            return false;
        } else if (this.cnq.containsKey(dQ.filePath)) {
            booleanValue = ((Boolean) this.cnq.get(dQ.filePath)).booleanValue();
            AppMethodBeat.o(137166);
            return booleanValue;
        } else {
            booleanValue = com.tencent.mm.audio.mix.b.d.Dm().dx(dQ.filePath);
            if (booleanValue) {
                this.cnq.put(dQ.filePath, Boolean.valueOf(booleanValue));
            }
            AppMethodBeat.o(137166);
            return booleanValue;
        }
    }

    public final boolean ee(String str) {
        AppMethodBeat.i(137167);
        boolean booleanValue;
        if (this.cnq.containsKey(str)) {
            booleanValue = ((Boolean) this.cnq.get(str)).booleanValue();
            AppMethodBeat.o(137167);
            return booleanValue;
        }
        booleanValue = com.tencent.mm.audio.mix.b.d.Dm().dx(str);
        if (booleanValue) {
            this.cnq.put(str, Boolean.valueOf(booleanValue));
        }
        AppMethodBeat.o(137167);
        return booleanValue;
    }

    public final long Ek() {
        return this.cno.cnB.cmG;
    }
}
