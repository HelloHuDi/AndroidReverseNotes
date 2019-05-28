package com.tencent.p177mm.audio.mix.p831d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p1458g.C36694a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p832f.C45172d;
import com.tencent.p177mm.p1176ag.C17875b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.audio.mix.d.a */
public final class C37487a {
    public Object ckQ = new Object();
    public C45172d clB;
    public HashMap<String, C25839b> clC = new HashMap();
    public HashMap<String, C17875b> clD = new HashMap();
    public List<String> clE = new ArrayList();
    public LinkedList<String> clF = new LinkedList();

    /* renamed from: com.tencent.mm.audio.mix.d.a$1 */
    class C258381 implements C17958j {
        C258381() {
        }

        /* renamed from: a */
        public final void mo33496a(C17959k c17959k) {
            AppMethodBeat.m2504i(137036);
            if (c17959k == null) {
                C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
                AppMethodBeat.m2505o(137036);
                return;
            }
            C17875b DM = c17959k.mo20513DM();
            c17959k.mo20506DF();
            c17959k.mo20503DC();
            c17959k.release();
            synchronized (C37487a.this.ckQ) {
                if (DM != null) {
                    try {
                        if (C37487a.this.clE.contains(DM.filePath)) {
                            C37487a.this.clE.remove(DM.filePath);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(137036);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(137036);
        }

        /* renamed from: a */
        public final void mo33495a(C25839b c25839b) {
            AppMethodBeat.m2504i(137037);
            C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
            C41777h.m73747b(c25839b);
            AppMethodBeat.m2505o(137037);
        }
    }

    public C37487a(C45172d c45172d) {
        AppMethodBeat.m2504i(137038);
        this.clB = c45172d;
        C45166d.m83168Dm().clearCache();
        AppMethodBeat.m2505o(137038);
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(137039);
        this.clC.clear();
        this.clF.clear();
        this.clD.clear();
        AppMethodBeat.m2505o(137039);
    }

    /* renamed from: dB */
    public final boolean mo60409dB(String str) {
        boolean contains;
        AppMethodBeat.m2504i(137040);
        synchronized (this.ckQ) {
            try {
                contains = this.clE.contains(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137040);
            }
        }
        return contains;
    }

    /* renamed from: Du */
    public final void mo60406Du() {
        AppMethodBeat.m2504i(137041);
        C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
        Iterator it = this.clF.iterator();
        while (it.hasNext()) {
            C25839b c25839b = (C25839b) this.clC.get((String) it.next());
            if (!(c25839b == null || c25839b.clI || c25839b.mo43827Dv())) {
                C17959k c17959k = c25839b.clJ;
                if (c17959k != null) {
                    c17959k.stop();
                }
            }
        }
        AppMethodBeat.m2505o(137041);
    }

    /* renamed from: dC */
    public final void mo60410dC(String str) {
        AppMethodBeat.m2504i(137042);
        C45174b.m83210i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", str);
        mo60407b(str, false, false);
        AppMethodBeat.m2505o(137042);
    }

    /* renamed from: dD */
    public final void mo60411dD(String str) {
        AppMethodBeat.m2504i(137043);
        C45174b.m83210i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", str);
        C25839b c25839b = (C25839b) this.clC.get(str);
        if (c25839b == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.m2505o(137043);
        } else if (c25839b.clI) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.m2505o(137043);
        } else {
            C17959k c17959k = c25839b.clJ;
            if (c17959k != null) {
                c17959k.stop();
                c25839b.clJ = null;
                this.clC.remove(str);
            }
            AppMethodBeat.m2505o(137043);
        }
    }

    /* renamed from: b */
    public final boolean mo60407b(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(137044);
        C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
        if (this.clB == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
            AppMethodBeat.m2505o(137044);
            return false;
        }
        C17875b c17875b = (C17875b) this.clD.get(str);
        if (c17875b == null) {
            C45174b.m83208e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            AppMethodBeat.m2505o(137044);
            return false;
        }
        C25839b c25839b = (C25839b) this.clC.get(str);
        if (c25839b != null) {
            if (c25839b.clI && !this.clB.cnB.mo33497DB() && !this.clB.cnB.mo33514dM(str)) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
                AppMethodBeat.m2505o(137044);
                return true;
            } else if (c25839b.clI) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
                c25839b.clI = false;
                c25839b.mo43828b(C45167f.m83175a(this.clB, new C36694a(c17875b), z2));
                C41777h.m73746a(c25839b);
                AppMethodBeat.m2505o(137044);
                return true;
            } else {
                C17959k c17959k = c25839b.clJ;
                if (c17959k != null && z) {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
                    c17959k.stop();
                } else if (c17959k != null && c17959k.mo20501DA() && !c17959k.mo20502DB()) {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
                    c17959k.resume();
                    AppMethodBeat.m2505o(137044);
                    return true;
                } else if (c17959k != null && c17959k.mo20502DB()) {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
                    c25839b.clI = false;
                    c25839b.mo43828b(C45167f.m83175a(this.clB, new C36694a(c17875b), z2));
                    C41777h.m73746a(c25839b);
                    AppMethodBeat.m2505o(137044);
                    return true;
                } else if (c17959k != null) {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
                    AppMethodBeat.m2505o(137044);
                    return true;
                }
            }
        }
        C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
        C17959k a = C45167f.m83175a(this.clB, new C36694a(c17875b), z2);
        c25839b = new C25839b(new C258381(), str);
        c25839b.mo43828b(a);
        C41777h.m73746a(c25839b);
        this.clC.put(str, c25839b);
        AppMethodBeat.m2505o(137044);
        return true;
    }

    /* renamed from: u */
    public final boolean mo60414u(String str, int i) {
        AppMethodBeat.m2504i(137045);
        if (mo60415v(str, i)) {
            mo60415v(str, i);
            C25839b c25839b = (C25839b) this.clC.get(str);
            if (c25839b == null) {
                C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
                AppMethodBeat.m2505o(137045);
                return false;
            } else if (c25839b.clI) {
                C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
                AppMethodBeat.m2505o(137045);
                return false;
            } else if (c25839b.mo43827Dv()) {
                C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
                AppMethodBeat.m2505o(137045);
                return false;
            } else {
                C17959k c17959k = c25839b.clJ;
                if (c17959k != null) {
                    c17959k.seek(i);
                }
                AppMethodBeat.m2505o(137045);
                return true;
            }
        }
        AppMethodBeat.m2505o(137045);
        return false;
    }

    /* renamed from: v */
    public final boolean mo60415v(String str, int i) {
        AppMethodBeat.m2504i(137046);
        C17875b c17875b = (C17875b) this.clD.get(str);
        if (c17875b == null) {
            C45174b.m83208e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            AppMethodBeat.m2505o(137046);
            return false;
        }
        c17875b.startTime = i;
        AppMethodBeat.m2505o(137046);
        return true;
    }

    /* renamed from: dE */
    public final boolean mo60412dE(String str) {
        AppMethodBeat.m2504i(137047);
        C25839b c25839b = (C25839b) this.clC.get(str);
        if (c25839b == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.m2505o(137047);
            return true;
        } else if (c25839b.clI) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.m2505o(137047);
            return true;
        } else if (c25839b.mo43827Dv()) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            AppMethodBeat.m2505o(137047);
            return true;
        } else {
            AppMethodBeat.m2505o(137047);
            return false;
        }
    }

    /* renamed from: dF */
    public final boolean mo60413dF(String str) {
        AppMethodBeat.m2504i(137048);
        C25839b c25839b = (C25839b) this.clC.get(str);
        if (c25839b == null || !c25839b.clI || this.clB.cnB.mo33497DB() || this.clB.cnB.mo33514dM(str)) {
            AppMethodBeat.m2505o(137048);
            return false;
        }
        C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.m2505o(137048);
        return true;
    }
}
