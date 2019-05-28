package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.e.g;
import com.tencent.mm.audio.mix.f.c;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    private static d oJt = null;

    private d() {
        AppMethodBeat.i(137262);
        f.bSz();
        AppMethodBeat.o(137262);
    }

    public static synchronized void init() {
        synchronized (d.class) {
            AppMethodBeat.i(137263);
            if (oJt != null) {
                AppMethodBeat.o(137263);
            } else {
                ab.i("MicroMsg.Audio.AudioPlayerCoreService", "create");
                oJt = new d();
                AppMethodBeat.o(137263);
            }
        }
    }

    public static synchronized void release() {
        synchronized (d.class) {
            AppMethodBeat.i(137264);
            ab.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
            f bSA = f.bSA();
            ab.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
            bSA.bSB();
            bSA.bSK();
            c cVar = bSA.oJP;
            cVar.cnp.Du();
            com.tencent.mm.audio.mix.f.d dVar = cVar.cno;
            b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
            dVar.cnB.DT();
            dVar.Ep();
            dVar.El();
            cVar = bSA.oJP;
            a aVar = cVar.cnp;
            aVar.Du();
            aVar.clearCache();
            aVar.clB = null;
            com.tencent.mm.audio.mix.f.d dVar2 = cVar.cno;
            b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
            dVar2.cnu.set(false);
            dVar2.Ep();
            dVar2.El();
            com.tencent.mm.audio.mix.e.c cVar2 = dVar2.cnB;
            b.i("MicroMsg.Mix.AudioMixController", "onRelease");
            cVar2.Eb();
            cVar2.clearCache();
            dVar2.cnp = null;
            dVar2.clearCache();
            SilkResampleJni.clearResampleAll();
            g.Eg();
            cVar.clearCache();
            cVar = bSA.oJP;
            b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", cVar.appId);
            com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.b(r3), "AudioPcmDataTrackCleanTask");
            cVar.cnq.clear();
            bSA.oJP.a(null);
            bSA.oJP.a(null);
            oJt = null;
            AppMethodBeat.o(137264);
        }
    }
}
