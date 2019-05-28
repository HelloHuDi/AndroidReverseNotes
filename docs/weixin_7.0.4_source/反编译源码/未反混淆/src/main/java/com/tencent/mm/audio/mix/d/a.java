package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b;
import com.tencent.mm.audio.mix.f.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public Object ckQ = new Object();
    public d clB;
    public HashMap<String, b> clC = new HashMap();
    public HashMap<String, b> clD = new HashMap();
    public List<String> clE = new ArrayList();
    public LinkedList<String> clF = new LinkedList();

    public a(d dVar) {
        AppMethodBeat.i(137038);
        this.clB = dVar;
        com.tencent.mm.audio.mix.b.d.Dm().clearCache();
        AppMethodBeat.o(137038);
    }

    public final void clearCache() {
        AppMethodBeat.i(137039);
        this.clC.clear();
        this.clF.clear();
        this.clD.clear();
        AppMethodBeat.o(137039);
    }

    public final boolean dB(String str) {
        boolean contains;
        AppMethodBeat.i(137040);
        synchronized (this.ckQ) {
            try {
                contains = this.clE.contains(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137040);
            }
        }
        return contains;
    }

    public final void Du() {
        AppMethodBeat.i(137041);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
        Iterator it = this.clF.iterator();
        while (it.hasNext()) {
            b bVar = (b) this.clC.get((String) it.next());
            if (!(bVar == null || bVar.clI || bVar.Dv())) {
                k kVar = bVar.clJ;
                if (kVar != null) {
                    kVar.stop();
                }
            }
        }
        AppMethodBeat.o(137041);
    }

    public final void dC(String str) {
        AppMethodBeat.i(137042);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", str);
        b(str, false, false);
        AppMethodBeat.o(137042);
    }

    public final void dD(String str) {
        AppMethodBeat.i(137043);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", str);
        b bVar = (b) this.clC.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.o(137043);
        } else if (bVar.clI) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.o(137043);
        } else {
            k kVar = bVar.clJ;
            if (kVar != null) {
                kVar.stop();
                bVar.clJ = null;
                this.clC.remove(str);
            }
            AppMethodBeat.o(137043);
        }
    }

    public final boolean b(String str, boolean z, boolean z2) {
        AppMethodBeat.i(137044);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
        if (this.clB == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
            AppMethodBeat.o(137044);
            return false;
        }
        b bVar = (b) this.clD.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            AppMethodBeat.o(137044);
            return false;
        }
        b bVar2 = (b) this.clC.get(str);
        if (bVar2 != null) {
            if (bVar2.clI && !this.clB.cnB.DB() && !this.clB.cnB.dM(str)) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
                AppMethodBeat.o(137044);
                return true;
            } else if (bVar2.clI) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
                bVar2.clI = false;
                bVar2.b(f.a(this.clB, new com.tencent.mm.audio.mix.g.a(bVar), z2));
                h.a(bVar2);
                AppMethodBeat.o(137044);
                return true;
            } else {
                k kVar = bVar2.clJ;
                if (kVar != null && z) {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
                    kVar.stop();
                } else if (kVar != null && kVar.DA() && !kVar.DB()) {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
                    kVar.resume();
                    AppMethodBeat.o(137044);
                    return true;
                } else if (kVar != null && kVar.DB()) {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
                    bVar2.clI = false;
                    bVar2.b(f.a(this.clB, new com.tencent.mm.audio.mix.g.a(bVar), z2));
                    h.a(bVar2);
                    AppMethodBeat.o(137044);
                    return true;
                } else if (kVar != null) {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
                    AppMethodBeat.o(137044);
                    return true;
                }
            }
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
        k a = f.a(this.clB, new com.tencent.mm.audio.mix.g.a(bVar), z2);
        bVar2 = new b(new j() {
            public final void a(k kVar) {
                AppMethodBeat.i(137036);
                if (kVar == null) {
                    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
                    AppMethodBeat.o(137036);
                    return;
                }
                b DM = kVar.DM();
                kVar.DF();
                kVar.DC();
                kVar.release();
                synchronized (a.this.ckQ) {
                    if (DM != null) {
                        try {
                            if (a.this.clE.contains(DM.filePath)) {
                                a.this.clE.remove(DM.filePath);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(137036);
                            }
                        }
                    }
                }
                AppMethodBeat.o(137036);
            }

            public final void a(b bVar) {
                AppMethodBeat.i(137037);
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
                h.b(bVar);
                AppMethodBeat.o(137037);
            }
        }, str);
        bVar2.b(a);
        h.a(bVar2);
        this.clC.put(str, bVar2);
        AppMethodBeat.o(137044);
        return true;
    }

    public final boolean u(String str, int i) {
        AppMethodBeat.i(137045);
        if (v(str, i)) {
            v(str, i);
            b bVar = (b) this.clC.get(str);
            if (bVar == null) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
                AppMethodBeat.o(137045);
                return false;
            } else if (bVar.clI) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
                AppMethodBeat.o(137045);
                return false;
            } else if (bVar.Dv()) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
                AppMethodBeat.o(137045);
                return false;
            } else {
                k kVar = bVar.clJ;
                if (kVar != null) {
                    kVar.seek(i);
                }
                AppMethodBeat.o(137045);
                return true;
            }
        }
        AppMethodBeat.o(137045);
        return false;
    }

    public final boolean v(String str, int i) {
        AppMethodBeat.i(137046);
        b bVar = (b) this.clD.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            AppMethodBeat.o(137046);
            return false;
        }
        bVar.startTime = i;
        AppMethodBeat.o(137046);
        return true;
    }

    public final boolean dE(String str) {
        AppMethodBeat.i(137047);
        b bVar = (b) this.clC.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.o(137047);
            return true;
        } else if (bVar.clI) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.o(137047);
            return true;
        } else if (bVar.Dv()) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            AppMethodBeat.o(137047);
            return true;
        } else {
            AppMethodBeat.o(137047);
            return false;
        }
    }

    public final boolean dF(String str) {
        AppMethodBeat.i(137048);
        b bVar = (b) this.clC.get(str);
        if (bVar == null || !bVar.clI || this.clB.cnB.DB() || this.clB.cnB.dM(str)) {
            AppMethodBeat.o(137048);
            return false;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(137048);
        return true;
    }
}
