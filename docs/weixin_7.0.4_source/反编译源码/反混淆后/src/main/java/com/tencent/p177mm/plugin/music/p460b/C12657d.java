package com.tencent.p177mm.plugin.music.p460b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.jni.SilkResampleJni;
import com.tencent.p177mm.audio.mix.p1181b.p1182a.C37485b;
import com.tencent.p177mm.audio.mix.p1181b.p1182a.C41770d;
import com.tencent.p177mm.audio.mix.p196e.C17961c;
import com.tencent.p177mm.audio.mix.p196e.C37489g;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p831d.C37487a;
import com.tencent.p177mm.audio.mix.p832f.C32317c;
import com.tencent.p177mm.audio.mix.p832f.C45172d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.b.d */
public final class C12657d {
    private static C12657d oJt = null;

    private C12657d() {
        AppMethodBeat.m2504i(137262);
        C28543f.bSz();
        AppMethodBeat.m2505o(137262);
    }

    public static synchronized void init() {
        synchronized (C12657d.class) {
            AppMethodBeat.m2504i(137263);
            if (oJt != null) {
                AppMethodBeat.m2505o(137263);
            } else {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerCoreService", "create");
                oJt = new C12657d();
                AppMethodBeat.m2505o(137263);
            }
        }
    }

    public static synchronized void release() {
        synchronized (C12657d.class) {
            AppMethodBeat.m2504i(137264);
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerCoreService", "release");
            C28543f bSA = C28543f.bSA();
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
            bSA.bSB();
            bSA.bSK();
            C32317c c32317c = bSA.oJP;
            c32317c.cnp.mo60406Du();
            C45172d c45172d = c32317c.cno;
            C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
            c45172d.cnB.mo33500DT();
            c45172d.mo73148Ep();
            c45172d.mo73145El();
            c32317c = bSA.oJP;
            C37487a c37487a = c32317c.cnp;
            c37487a.mo60406Du();
            c37487a.clearCache();
            c37487a.clB = null;
            C45172d c45172d2 = c32317c.cno;
            C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
            c45172d2.cnu.set(false);
            c45172d2.mo73148Ep();
            c45172d2.mo73145El();
            C17961c c17961c = c45172d2.cnB;
            C45174b.m83209i("MicroMsg.Mix.AudioMixController", "onRelease");
            c17961c.mo33505Eb();
            c17961c.clearCache();
            c45172d2.cnp = null;
            c45172d2.clearCache();
            SilkResampleJni.clearResampleAll();
            C37489g.m63274Eg();
            c32317c.clearCache();
            c32317c = bSA.oJP;
            C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", c32317c.appId);
            C41770d.m73729a(new C37485b(r3), "AudioPcmDataTrackCleanTask");
            c32317c.cnq.clear();
            bSA.oJP.mo53027a(null);
            bSA.oJP.mo53028a(null);
            oJt = null;
            AppMethodBeat.m2505o(137264);
        }
    }
}
