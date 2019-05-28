package com.tencent.p177mm.audio.mix.p832f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p1181b.p1182a.C41769c;
import com.tencent.p177mm.audio.mix.p1181b.p1182a.C41770d;
import com.tencent.p177mm.audio.mix.p1181b.p1182a.C45165a;
import com.tencent.p177mm.audio.mix.p1183c.C17955e;
import com.tencent.p177mm.audio.mix.p1183c.C17955e.C17954a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p831d.C17959k;
import com.tencent.p177mm.audio.mix.p831d.C25839b;
import com.tencent.p177mm.audio.mix.p831d.C37487a;
import com.tencent.p177mm.audio.mix.p831d.C41777h;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C41729d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.audio.mix.f.c */
public final class C32317c {
    public String appId;
    public C45172d cno = new C45172d();
    public C37487a cnp = new C37487a(this.cno);
    public HashMap<String, Boolean> cnq = new HashMap();
    private C17955e cnr = new C17955e();
    public C41770d cns = new C41770d();

    public C32317c() {
        AppMethodBeat.m2504i(137139);
        AppMethodBeat.m2505o(137139);
    }

    /* renamed from: Eh */
    public final void mo53022Eh() {
        AppMethodBeat.m2504i(137140);
        C37487a c37487a = this.cnp;
        C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
        Iterator it = c37487a.clF.iterator();
        while (it.hasNext()) {
            C25839b c25839b = (C25839b) c37487a.clC.get((String) it.next());
            if (!(c25839b == null || c25839b.clI || c25839b.mo43827Dv())) {
                C17959k c17959k = c25839b.clJ;
                if (!(c17959k == null || c17959k.mo20501DA())) {
                    c17959k.mo20515Dx();
                }
            }
        }
        C45172d c45172d = this.cno;
        C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
        c45172d.cnB.mo33499DS();
        c45172d.mo73145El();
        C17955e c17955e = this.cnr;
        if (C17955e.clx == 0) {
            C17955e.clx = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C17955e.clx <= C17955e.clu.longValue()) {
            C45174b.m83207e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
        } else {
            C17955e.clx = currentTimeMillis;
            C45174b.m83209i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
            C41777h.m73746a(new C17954a("clean audio mix convert cache"));
        }
        C45166d Dm = C45166d.m83168Dm();
        synchronized (Dm.ckQ) {
            try {
                Iterator it2 = Dm.ckO.iterator();
                while (it2.hasNext()) {
                    C37484c c37484c = (C37484c) Dm.ckP.get((String) it2.next());
                    if (c37484c != null && c37484c.cky && c37484c.ckB) {
                        c37484c.mo60395Dc();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137140);
            }
        }
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(137141);
        this.cnp.clearCache();
        this.cno.clearCache();
        AppMethodBeat.m2505o(137141);
    }

    /* renamed from: a */
    public final void mo53026a(C17875b c17875b) {
        AppMethodBeat.m2504i(137142);
        this.appId = c17875b.appId;
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", c17875b.ckD);
        if (mo53046ee(c17875b.filePath) && c17875b.fqK) {
            m52833d(c17875b);
        }
        C45172d c45172d = this.cno;
        C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
        if (c17875b.fqX || !c17875b.fqK) {
            if (c17875b.fqX) {
                synchronized (c45172d.cnz) {
                    try {
                        if (c45172d.cnH.containsKey(c17875b.ckD)) {
                            C37491e c37491e = (C37491e) c45172d.cnH.get(c17875b.ckD);
                            if (c37491e != null) {
                                if (c37491e.mo60422g(Integer.valueOf(4))) {
                                    c45172d.cnH.remove(c17875b.ckD);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(137142);
                    }
                }
            }
        } else if (c45172d.cnu.get()) {
            c45172d.mo73146Em();
        } else if (!c45172d.cnu.get()) {
            C45174b.m83209i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
            c45172d.cnu.set(true);
            c45172d.cnw.set(false);
            c45172d.cnv.set(false);
            c45172d.mo73146Em();
        }
        c45172d.clD.put(c17875b.ckD, c17875b);
        synchronized (c45172d.cnz) {
            try {
                c45172d.cmD.put(c17875b.ckD, Boolean.FALSE);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137142);
            }
        }
        c45172d.cnB.mo33508dG(c17875b.ckD);
        c45172d.cnB.mo33498DR();
        C37487a c37487a = this.cnp;
        C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (c17875b == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
        } else if (TextUtils.isEmpty(c17875b.ckD)) {
            C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
            AppMethodBeat.m2505o(137142);
        } else {
            boolean z;
            if (c37487a.clF.contains(c17875b.ckD)) {
                if (((C17875b) c37487a.clD.get(c17875b.ckD)).mo33376e(c17875b)) {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
                    z = false;
                } else {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
                    z = true;
                }
                c37487a.clD.put(c17875b.ckD, c17875b);
            } else {
                c37487a.clF.add(c17875b.ckD);
                c37487a.clD.put(c17875b.ckD, c17875b);
                z = false;
            }
            C45174b.m83210i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", Integer.valueOf(c37487a.clF.size()), Integer.valueOf(c37487a.clD.size()));
            if (c17875b.fqX) {
                z = c37487a.mo60407b(c17875b.ckD, z, true);
                synchronized (c37487a.ckQ) {
                    if (z) {
                        try {
                            if (!c37487a.clE.contains(c17875b.filePath)) {
                                c37487a.clE.add(c17875b.filePath);
                            }
                        } catch (Throwable th2) {
                            while (true) {
                                AppMethodBeat.m2505o(137142);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(137142);
            } else if (c17875b.fqK) {
                c37487a.mo60407b(c17875b.ckD, z, false);
                AppMethodBeat.m2505o(137142);
            } else {
                z = c37487a.mo60407b(c17875b.ckD, z, true);
                synchronized (c37487a.ckQ) {
                    if (z) {
                        try {
                            if (!c37487a.clE.contains(c17875b.filePath)) {
                                c37487a.clE.add(c17875b.filePath);
                            }
                        } catch (Throwable th3) {
                            while (true) {
                                AppMethodBeat.m2505o(137142);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(137142);
            }
        }
    }

    /* renamed from: b */
    public final void mo53029b(C17875b c17875b) {
        AppMethodBeat.m2504i(137143);
        this.cno.clD.put(c17875b.ckD, c17875b);
        this.cnp.clD.put(c17875b.ckD, c17875b);
        AppMethodBeat.m2505o(137143);
    }

    /* renamed from: c */
    public final void mo53030c(C17875b c17875b) {
        AppMethodBeat.m2504i(137144);
        C45172d c45172d = this.cno;
        if (c45172d.clD.containsKey(c17875b.ckD)) {
            c45172d.clD.put(c17875b.ckD, c17875b);
        }
        C37487a c37487a = this.cnp;
        if (c37487a.clD.containsKey(c17875b.ckD)) {
            c37487a.clD.put(c17875b.ckD, c17875b);
        }
        AppMethodBeat.m2505o(137144);
    }

    /* renamed from: dQ */
    private C17875b m52834dQ(String str) {
        AppMethodBeat.m2504i(137145);
        C17875b dQ = this.cno.mo73156dQ(str);
        AppMethodBeat.m2505o(137145);
        return dQ;
    }

    /* renamed from: dR */
    public final boolean mo53033dR(String str) {
        AppMethodBeat.m2504i(137146);
        if (this.cno.clD.containsKey(str)) {
            AppMethodBeat.m2505o(137146);
            return true;
        }
        AppMethodBeat.m2505o(137146);
        return false;
    }

    /* renamed from: dS */
    public final void mo53034dS(String str) {
        AppMethodBeat.m2504i(137147);
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.mo73161eg(str)));
        m52833d(this.cno.mo73156dQ(str));
        C45172d c45172d = this.cno;
        c45172d.cnw.set(false);
        c45172d.cnv.set(false);
        c45172d.mo73149Eq();
        c45172d.mo73146Em();
        synchronized (c45172d.cnz) {
            try {
                c45172d.cmD.put(str, Boolean.FALSE);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137147);
                }
            }
        }
        c45172d.cnB.mo33508dG(str);
        c45172d.cnF.remove(str);
        c45172d.cnG.put(str, Boolean.TRUE);
        if (c45172d.cnp.mo60412dE(str) && c45172d.cnp.mo60413dF(str)) {
            c45172d.mo73162i(0, str);
        }
        this.cnp.mo60410dC(str);
        AppMethodBeat.m2505o(137147);
    }

    /* renamed from: d */
    private void m52833d(C17875b c17875b) {
        AppMethodBeat.m2504i(137148);
        c17875b.ckA = true;
        int ea = this.cno.mo73159ea(c17875b.ckD);
        int Es = this.cno.mo73151Es();
        if (ea <= 2000) {
            c17875b.ckA = false;
        }
        if (ea >= 5000 || Es > 5) {
            c17875b.ckA = true;
        } else {
            c17875b.ckA = false;
        }
        if (c17875b.filePath.contains("scale_intro")) {
            c17875b.ckA = false;
        }
        if (Es > 5) {
            ArrayList Et = this.cno.mo73152Et();
            if (Et.contains(c17875b.ckD)) {
                Et.remove(c17875b.ckD);
            }
            if (Et.size() > 2) {
                C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", Integer.valueOf(Et.size()));
                Iterator it = Et.iterator();
                while (it.hasNext()) {
                    mo53037dV((String) it.next());
                }
            }
        }
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", Integer.valueOf(Es), Integer.valueOf(ea), Boolean.valueOf(c17875b.ckA));
        AppMethodBeat.m2505o(137148);
    }

    /* renamed from: dT */
    public final void mo53035dT(String str) {
        AppMethodBeat.m2504i(137149);
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.mo73161eg(str)));
        m52833d(this.cno.mo73156dQ(str));
        C45172d c45172d = this.cno;
        c45172d.cnw.set(false);
        c45172d.cnv.set(false);
        c45172d.mo73149Eq();
        c45172d.mo73146Em();
        synchronized (c45172d.cnz) {
            try {
                c45172d.cmD.put(str, Boolean.FALSE);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137149);
                }
            }
        }
        c45172d.cnB.mo33508dG(str);
        c45172d.cnF.remove(str);
        c45172d.cnG.put(str, Boolean.TRUE);
        if (c45172d.cnp.mo60412dE(str) && c45172d.cnp.mo60413dF(str)) {
            c45172d.mo73162i(1, str);
        }
        this.cnp.mo60410dC(str);
        AppMethodBeat.m2505o(137149);
    }

    /* renamed from: dU */
    public final void mo53036dU(String str) {
        AppMethodBeat.m2504i(137150);
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.mo73161eg(str)));
        C45172d c45172d = this.cno;
        c45172d.cnB.mo33509dH(str);
        if (c45172d.cnp.mo60412dE(str) && c45172d.cnp.mo60413dF(str)) {
            c45172d.mo73162i(2, str);
        }
        C37487a c37487a = this.cnp;
        C45174b.m83210i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", str);
        C25839b c25839b = (C25839b) c37487a.clC.get(str);
        if (c25839b == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.m2505o(137150);
        } else if (c25839b.clI) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.m2505o(137150);
        } else if (c25839b.mo43827Dv()) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            AppMethodBeat.m2505o(137150);
        } else {
            C17959k c17959k = c25839b.clJ;
            if (c17959k != null) {
                c17959k.pause();
            }
            AppMethodBeat.m2505o(137150);
        }
    }

    /* renamed from: dV */
    public final void mo53037dV(String str) {
        AppMethodBeat.m2504i(137151);
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", str, Integer.valueOf(this.cno.mo73161eg(str)));
        this.cno.mo73157dV(str);
        this.cnp.mo60411dD(str);
        AppMethodBeat.m2505o(137151);
    }

    public final void remove(String str) {
        AppMethodBeat.m2504i(137152);
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", str);
        C45172d c45172d = this.cno;
        c45172d.clD.remove(str);
        c45172d.cnF.remove(str);
        c45172d.cnG.remove(str);
        synchronized (c45172d.cnz) {
            try {
                c45172d.cnH.remove(str);
                c45172d.cmD.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137152);
                }
            }
        }
        c45172d.cnI.remove(str);
        C37487a c37487a = this.cnp;
        if (c37487a.clC.containsKey(str) && c37487a.clF.contains(str)) {
            c37487a.mo60411dD(str);
        }
        c37487a.clD.remove(str);
        c37487a.clF.remove(str);
        AppMethodBeat.m2505o(137152);
    }

    /* renamed from: w */
    public final boolean mo53050w(String str, int i) {
        AppMethodBeat.m2504i(137153);
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", str, Integer.valueOf(i));
        boolean v = this.cnp.mo60415v(str, i);
        if (v) {
            boolean z;
            mo53047i(10, str);
            long ef = (long) this.cno.mo73160ef(str);
            int eg = this.cno.mo73161eg(str);
            if (!mo53045ed(str)) {
                C45174b.m83209i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
                z = true;
            } else if (mo53042ea(str) <= 2000) {
                C45174b.m83209i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
                if (this.cnp.mo60412dE(str)) {
                    z = true;
                } else {
                    v = this.cnp.mo60414u(str, i);
                    z = true;
                }
            } else if (Math.abs(((long) i) - ef) <= 3000) {
                C45174b.m83209i("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
                z = true;
            } else if (eg != 0 && eg != 1 && eg != 2) {
                C45174b.m83209i("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
                z = true;
            } else if (this.cnp.mo60412dE(str)) {
                z = this.cno.cnB.mo33517w(str, i);
            } else {
                v = this.cnp.mo60414u(str, i);
                z = true;
            }
            mo53047i(6, str);
            if (z && v) {
                AppMethodBeat.m2505o(137153);
                return true;
            }
            AppMethodBeat.m2505o(137153);
            return false;
        }
        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", Integer.valueOf(i));
        AppMethodBeat.m2505o(137153);
        return false;
    }

    /* renamed from: dF */
    public final boolean mo53032dF(String str) {
        AppMethodBeat.m2504i(137154);
        boolean dF = this.cno.mo73155dF(str);
        AppMethodBeat.m2505o(137154);
        return dF;
    }

    /* renamed from: dW */
    public final boolean mo53038dW(String str) {
        AppMethodBeat.m2504i(137155);
        C45172d c45172d = this.cno;
        if (c45172d.cnG.containsKey(str)) {
            boolean booleanValue = ((Boolean) c45172d.cnG.get(str)).booleanValue();
            AppMethodBeat.m2505o(137155);
            return booleanValue;
        }
        AppMethodBeat.m2505o(137155);
        return false;
    }

    /* renamed from: dX */
    public final boolean mo53039dX(String str) {
        AppMethodBeat.m2504i(137156);
        C45172d c45172d = this.cno;
        if (c45172d.cnH.containsKey(str)) {
            C37491e c37491e = (C37491e) c45172d.cnH.get(str);
            if (c37491e != null) {
                if (c37491e.mo60422g(Integer.valueOf(9))) {
                    AppMethodBeat.m2505o(137156);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(137156);
        return false;
    }

    /* renamed from: dY */
    public final boolean mo53040dY(String str) {
        AppMethodBeat.m2504i(137157);
        C45172d c45172d = this.cno;
        if (c45172d.cnH.containsKey(str)) {
            C37491e c37491e = (C37491e) c45172d.cnH.get(str);
            if (c37491e != null) {
                if (c37491e.mo60422g(Integer.valueOf(7))) {
                    AppMethodBeat.m2505o(137157);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(137157);
        return false;
    }

    public final boolean isPaused(String str) {
        AppMethodBeat.m2504i(137158);
        C45172d c45172d = this.cno;
        if (c45172d.cnH.containsKey(str)) {
            C37491e c37491e = (C37491e) c45172d.cnH.get(str);
            if (c37491e != null) {
                if (c37491e.mo60422g(Integer.valueOf(2))) {
                    AppMethodBeat.m2505o(137158);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(137158);
        return false;
    }

    /* JADX WARNING: Missing block: B:9:0x0047, code skipped:
            if (r0.mo60422g(java.lang.Integer.valueOf(5)) != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dZ */
    public final boolean mo53041dZ(String str) {
        AppMethodBeat.m2504i(137159);
        C45172d c45172d = this.cno;
        if (c45172d.cnH.containsKey(str)) {
            C37491e c37491e = (C37491e) c45172d.cnH.get(str);
            if (c37491e != null) {
                if (!c37491e.mo60422g(Integer.valueOf(3))) {
                    if (!c37491e.mo60422g(Integer.valueOf(4))) {
                    }
                }
                AppMethodBeat.m2505o(137159);
                return true;
            }
        }
        AppMethodBeat.m2505o(137159);
        return false;
    }

    /* renamed from: Ei */
    public final boolean mo53023Ei() {
        AppMethodBeat.m2504i(137160);
        boolean z = this.cno.cnw.get();
        AppMethodBeat.m2505o(137160);
        return z;
    }

    /* renamed from: ea */
    public final int mo53042ea(String str) {
        AppMethodBeat.m2504i(137161);
        int ea = this.cno.mo73159ea(str);
        AppMethodBeat.m2505o(137161);
        return ea;
    }

    /* renamed from: a */
    public final void mo53027a(C32316b c32316b) {
        this.cno.cnC = c32316b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: eb */
    public final C41729d mo53043eb(String str) {
        C41729d c41729d;
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(137162);
        C45172d c45172d = this.cno;
        if (c45172d.cnI.containsKey(str)) {
            c41729d = (C41729d) c45172d.cnI.get(str);
        } else {
            C41729d c41729d2 = new C41729d();
            c45172d.cnI.put(str, c41729d2);
            c41729d = c41729d2;
        }
        int ea = c45172d.mo73159ea(str);
        int ef = c45172d.mo73160ef(str);
        boolean dF = c45172d.mo73155dF(str);
        if (c45172d.clD.containsKey(str)) {
            String str2 = ((C17875b) c45172d.clD.get(str)).filePath;
            if (!TextUtils.isEmpty(str2)) {
                C37484c dv = C45166d.m83168Dm().mo73133dv(str2);
                if (dv != null && dv.duration > 0) {
                    i = 100;
                    if (i >= 0) {
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    c41729d.csK = ef;
                    c41729d.duration = ea;
                    if (dF) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c41729d.f17164rw = z;
                    if (!(c45172d.cnF.containsKey(str) && ((Boolean) c45172d.cnF.get(str)).booleanValue())) {
                        z2 = false;
                    }
                    c41729d.fqY = z2;
                    c41729d.fqZ = (i2 * ea) / 100;
                    if (c45172d.clD.containsKey(str)) {
                        AppMethodBeat.m2505o(137162);
                        return null;
                    }
                    C17875b c17875b = (C17875b) c45172d.clD.get(str);
                    c41729d.startTime = c17875b.fqJ;
                    c41729d.ckz = c17875b.clP;
                    AppMethodBeat.m2505o(137162);
                    return c41729d;
                }
            }
        }
        i = 0;
        if (i >= 0) {
        }
        c41729d.csK = ef;
        c41729d.duration = ea;
        if (dF) {
        }
        c41729d.f17164rw = z;
        z2 = false;
        c41729d.fqY = z2;
        c41729d.fqZ = (i2 * ea) / 100;
        if (c45172d.clD.containsKey(str)) {
        }
    }

    /* renamed from: i */
    public final void mo53047i(int i, String str) {
        AppMethodBeat.m2504i(137163);
        this.cno.mo73162i(i, str);
        AppMethodBeat.m2505o(137163);
    }

    /* renamed from: a */
    public final void mo53028a(C9056g c9056g) {
        this.cno.cnE = c9056g;
    }

    /* renamed from: Ej */
    public final void mo53024Ej() {
        AppMethodBeat.m2504i(137164);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", this.appId);
        C41770d.m73729a(new C41769c(r0), "AudioPcmDataTrackRecycleCacheTask");
        this.cnq.clear();
        AppMethodBeat.m2505o(137164);
    }

    /* renamed from: ec */
    public final void mo53044ec(String str) {
        AppMethodBeat.m2504i(137165);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", this.appId, str);
        C41770d.m73729a(new C45165a(r0, str), "AudioPcmDataTrackCacheToFileTask");
        AppMethodBeat.m2505o(137165);
    }

    /* renamed from: ed */
    public final boolean mo53045ed(String str) {
        AppMethodBeat.m2504i(137166);
        C17875b dQ = m52834dQ(str);
        boolean booleanValue;
        if (dQ == null) {
            AppMethodBeat.m2505o(137166);
            return false;
        } else if (this.cnq.containsKey(dQ.filePath)) {
            booleanValue = ((Boolean) this.cnq.get(dQ.filePath)).booleanValue();
            AppMethodBeat.m2505o(137166);
            return booleanValue;
        } else {
            booleanValue = C45166d.m83168Dm().mo73135dx(dQ.filePath);
            if (booleanValue) {
                this.cnq.put(dQ.filePath, Boolean.valueOf(booleanValue));
            }
            AppMethodBeat.m2505o(137166);
            return booleanValue;
        }
    }

    /* renamed from: ee */
    public final boolean mo53046ee(String str) {
        AppMethodBeat.m2504i(137167);
        boolean booleanValue;
        if (this.cnq.containsKey(str)) {
            booleanValue = ((Boolean) this.cnq.get(str)).booleanValue();
            AppMethodBeat.m2505o(137167);
            return booleanValue;
        }
        booleanValue = C45166d.m83168Dm().mo73135dx(str);
        if (booleanValue) {
            this.cnq.put(str, Boolean.valueOf(booleanValue));
        }
        AppMethodBeat.m2505o(137167);
        return booleanValue;
    }

    /* renamed from: Ek */
    public final long mo53025Ek() {
        return this.cno.cnB.cmG;
    }
}
