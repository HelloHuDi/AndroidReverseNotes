package com.tencent.p177mm.audio.mix.p830a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C37486c;
import com.tencent.p177mm.audio.mix.p1181b.C41772b;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.tencent.mm.audio.mix.a.c */
public final class C37484c {
    private static long ckE = 0;
    private static long ckF = 0;
    private String appId;
    private long bufferSize = 0;
    public int channels = 2;
    public boolean ckA;
    public boolean ckB = false;
    private C9049a ckC;
    public String ckD;
    public int cku = 2;
    private ArrayList<C45164d> ckx = new ArrayList();
    public boolean cky;
    public String ckz;
    private int count = 0;
    public long duration;
    private int index = 0;
    public int sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;

    public C37484c(String str) {
        AppMethodBeat.m2504i(136961);
        this.ckz = str;
        AppMethodBeat.m2505o(136961);
    }

    public final synchronized void reset() {
        AppMethodBeat.m2504i(136962);
        int size = this.ckx.size();
        for (int i = size - 1; i >= 0; i--) {
            C45164d c45164d = (C45164d) this.ckx.remove(i);
            if (c45164d != null) {
                c45164d.ckD = null;
                c45164d.ckv = null;
            }
        }
        m63247gu(size);
        AppMethodBeat.m2505o(136962);
    }

    public final synchronized void recycle() {
        AppMethodBeat.m2504i(136963);
        int size = this.ckx.size();
        for (int i = size - 1; i >= 0; i--) {
            C45164d c45164d = (C45164d) this.ckx.remove(i);
            if (c45164d != null) {
                C37486c.m63255Dk().mo60405b(c45164d);
            }
        }
        m63247gu(size);
        AppMethodBeat.m2505o(136963);
    }

    /* renamed from: du */
    public final synchronized boolean mo60398du(String str) {
        boolean z;
        AppMethodBeat.m2504i(136964);
        if (this.ckB) {
            C45174b.m83210i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", this.ckz);
            AppMethodBeat.m2505o(136964);
            z = true;
        } else {
            this.appId = str;
            int size = this.ckx.size();
            if (size > 0) {
                m63244De();
            }
            if (this.ckC == null) {
                C45174b.m83207e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
                this.ckB = false;
                AppMethodBeat.m2505o(136964);
                z = false;
            } else {
                C45164d c45164d;
                for (int i = 0; i < size; i++) {
                    c45164d = (C45164d) this.ckx.get(i);
                    if (i == 0) {
                        this.ckD = c45164d.ckD;
                        this.sampleRate = c45164d.sampleRate;
                        this.cku = c45164d.cku;
                        this.channels = c45164d.channels;
                    }
                    if (c45164d != null) {
                        byte[] bArr = c45164d.ckv;
                        long j = (long) (i * 3536);
                        int length = c45164d.ckv.length;
                        if (this.ckC != null) {
                            z = this.ckC.mo20496c(bArr, j, length);
                        } else {
                            z = false;
                        }
                        if (!z) {
                            m63245Df();
                            C45174b.m83207e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
                            this.ckB = false;
                            AppMethodBeat.m2505o(136964);
                            z = false;
                            break;
                        }
                    }
                }
                this.ckB = true;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    c45164d = (C45164d) this.ckx.remove(i2);
                    if (c45164d != null) {
                        C37486c.m63255Dk().mo60405b(c45164d);
                    }
                }
                C45174b.m83209i("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish");
                AppMethodBeat.m2505o(136964);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: gu */
    private void m63247gu(int i) {
        AppMethodBeat.m2504i(136965);
        C45174b.m83210i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", this.ckz, Integer.valueOf(i), Boolean.valueOf(this.cky), Long.valueOf(this.duration), Boolean.valueOf(this.ckA), Long.valueOf(this.bufferSize));
        this.ckx.clear();
        this.cky = false;
        this.duration = 0;
        this.ckA = false;
        this.index = 0;
        this.bufferSize = 0;
        m63242Db();
        AppMethodBeat.m2505o(136965);
    }

    /* renamed from: gv */
    public final C45164d mo60399gv(int i) {
        AppMethodBeat.m2504i(136966);
        C45164d gw;
        if (this.ckB && this.ckC != null) {
            gw = m63248gw(i);
            AppMethodBeat.m2505o(136966);
            return gw;
        } else if (this.ckB && this.ckC == null) {
            m63243Dd();
            gw = m63248gw(i);
            AppMethodBeat.m2505o(136966);
            return gw;
        } else if (this.ckx == null || this.ckx.size() == 0) {
            AppMethodBeat.m2505o(136966);
            return null;
        } else if (i >= this.ckx.size()) {
            AppMethodBeat.m2505o(136966);
            return null;
        } else {
            gw = (C45164d) this.ckx.get(i);
            AppMethodBeat.m2505o(136966);
            return gw;
        }
    }

    /* renamed from: a */
    public final void mo60396a(C45164d c45164d) {
        AppMethodBeat.m2504i(136967);
        this.index++;
        c45164d.ckG = (long) (this.index * 20);
        if (this.ckx != null) {
            this.ckx.add(c45164d);
        }
        AppMethodBeat.m2505o(136967);
    }

    public final int size() {
        AppMethodBeat.m2504i(136968);
        int size;
        if (this.count <= 0 || !this.cky) {
            size = this.ckx.size();
            AppMethodBeat.m2505o(136968);
            return size;
        }
        size = this.count;
        AppMethodBeat.m2505o(136968);
        return size;
    }

    public final void complete() {
        AppMethodBeat.m2504i(136969);
        this.cky = true;
        this.count = size();
        C45174b.m83210i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", this.ckz);
        AppMethodBeat.m2505o(136969);
    }

    /* renamed from: Da */
    public final long mo60394Da() {
        AppMethodBeat.m2504i(136970);
        long j;
        if (this.bufferSize > 0) {
            j = this.bufferSize;
            AppMethodBeat.m2505o(136970);
            return j;
        }
        this.bufferSize = (long) (size() * 3536);
        j = this.bufferSize;
        AppMethodBeat.m2505o(136970);
        return j;
    }

    /* renamed from: Db */
    private void m63242Db() {
        AppMethodBeat.m2504i(136971);
        this.ckB = false;
        m63245Df();
        AppMethodBeat.m2505o(136971);
    }

    /* renamed from: Dc */
    public final synchronized void mo60395Dc() {
        AppMethodBeat.m2504i(136972);
        if (this.ckC != null) {
            C45174b.m83209i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
            this.ckC.close();
            this.ckC = null;
        }
        AppMethodBeat.m2505o(136972);
    }

    /* renamed from: Dd */
    private synchronized void m63243Dd() {
        AppMethodBeat.m2504i(136973);
        m63244De();
        AppMethodBeat.m2505o(136973);
    }

    /* renamed from: De */
    private void m63244De() {
        AppMethodBeat.m2504i(136974);
        if (this.ckC == null) {
            this.ckC = new C9049a(this.appId, this.ckz);
            if (this.ckC.open()) {
                C45174b.m83209i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
                this.ckC.setLength(mo60394Da());
                AppMethodBeat.m2505o(136974);
                return;
            }
            C45174b.m83209i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
            this.ckB = false;
            m63245Df();
        }
        AppMethodBeat.m2505o(136974);
    }

    /* renamed from: Df */
    private void m63245Df() {
        AppMethodBeat.m2504i(136975);
        if (this.ckC != null) {
            this.ckC.close();
            this.ckC.mo20494CZ();
            this.ckC = null;
        }
        AppMethodBeat.m2505o(136975);
    }

    /* renamed from: b */
    private int m63246b(byte[] bArr, long j, int i) {
        AppMethodBeat.m2504i(136976);
        if (this.ckC != null) {
            int b = this.ckC.mo20495b(bArr, j, i);
            AppMethodBeat.m2505o(136976);
            return b;
        }
        AppMethodBeat.m2505o(136976);
        return 0;
    }

    /* renamed from: gw */
    private C45164d m63248gw(int i) {
        AppMethodBeat.m2504i(136977);
        if (i >= this.count) {
            AppMethodBeat.m2505o(136977);
            return null;
        } else if (this.ckC == null) {
            AppMethodBeat.m2505o(136977);
            return null;
        } else {
            int i2 = i * 3536;
            if (i2 > this.ckC.getLength()) {
                AppMethodBeat.m2505o(136977);
                return null;
            }
            C45164d Dj = C41772b.m73733Di().mo67526Dj();
            if (Dj == null) {
                AppMethodBeat.m2505o(136977);
                return null;
            }
            if (Dj.ckv == null) {
                Dj.ckv = new byte[3536];
            } else {
                Arrays.fill(Dj.ckv, 0, Dj.ckv.length, (byte) 0);
            }
            System.nanoTime();
            if (m63246b(Dj.ckv, (long) i2, Dj.ckv.length) <= 0) {
                C41772b.m73733Di().mo67527b(Dj);
                AppMethodBeat.m2505o(136977);
                return null;
            }
            Dj.ckD = this.ckD;
            Dj.sampleRate = this.sampleRate;
            Dj.channels = this.channels;
            Dj.cku = this.cku;
            Dj.ckG = (long) (i * 20);
            AppMethodBeat.m2505o(136977);
            return Dj;
        }
    }
}
