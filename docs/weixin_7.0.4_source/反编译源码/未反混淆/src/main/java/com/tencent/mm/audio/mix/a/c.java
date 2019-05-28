package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;
import java.util.Arrays;

public final class c {
    private static long ckE = 0;
    private static long ckF = 0;
    private String appId;
    private long bufferSize = 0;
    public int channels = 2;
    public boolean ckA;
    public boolean ckB = false;
    private a ckC;
    public String ckD;
    public int cku = 2;
    private ArrayList<d> ckx = new ArrayList();
    public boolean cky;
    public String ckz;
    private int count = 0;
    public long duration;
    private int index = 0;
    public int sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;

    public c(String str) {
        AppMethodBeat.i(136961);
        this.ckz = str;
        AppMethodBeat.o(136961);
    }

    public final synchronized void reset() {
        AppMethodBeat.i(136962);
        int size = this.ckx.size();
        for (int i = size - 1; i >= 0; i--) {
            d dVar = (d) this.ckx.remove(i);
            if (dVar != null) {
                dVar.ckD = null;
                dVar.ckv = null;
            }
        }
        gu(size);
        AppMethodBeat.o(136962);
    }

    public final synchronized void recycle() {
        AppMethodBeat.i(136963);
        int size = this.ckx.size();
        for (int i = size - 1; i >= 0; i--) {
            d dVar = (d) this.ckx.remove(i);
            if (dVar != null) {
                com.tencent.mm.audio.mix.b.c.Dk().b(dVar);
            }
        }
        gu(size);
        AppMethodBeat.o(136963);
    }

    public final synchronized boolean du(String str) {
        boolean z;
        AppMethodBeat.i(136964);
        if (this.ckB) {
            b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", this.ckz);
            AppMethodBeat.o(136964);
            z = true;
        } else {
            this.appId = str;
            int size = this.ckx.size();
            if (size > 0) {
                De();
            }
            if (this.ckC == null) {
                b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
                this.ckB = false;
                AppMethodBeat.o(136964);
                z = false;
            } else {
                d dVar;
                for (int i = 0; i < size; i++) {
                    dVar = (d) this.ckx.get(i);
                    if (i == 0) {
                        this.ckD = dVar.ckD;
                        this.sampleRate = dVar.sampleRate;
                        this.cku = dVar.cku;
                        this.channels = dVar.channels;
                    }
                    if (dVar != null) {
                        byte[] bArr = dVar.ckv;
                        long j = (long) (i * 3536);
                        int length = dVar.ckv.length;
                        if (this.ckC != null) {
                            z = this.ckC.c(bArr, j, length);
                        } else {
                            z = false;
                        }
                        if (!z) {
                            Df();
                            b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
                            this.ckB = false;
                            AppMethodBeat.o(136964);
                            z = false;
                            break;
                        }
                    }
                }
                this.ckB = true;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    dVar = (d) this.ckx.remove(i2);
                    if (dVar != null) {
                        com.tencent.mm.audio.mix.b.c.Dk().b(dVar);
                    }
                }
                b.i("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish");
                AppMethodBeat.o(136964);
                z = true;
            }
        }
        return z;
    }

    private void gu(int i) {
        AppMethodBeat.i(136965);
        b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", this.ckz, Integer.valueOf(i), Boolean.valueOf(this.cky), Long.valueOf(this.duration), Boolean.valueOf(this.ckA), Long.valueOf(this.bufferSize));
        this.ckx.clear();
        this.cky = false;
        this.duration = 0;
        this.ckA = false;
        this.index = 0;
        this.bufferSize = 0;
        Db();
        AppMethodBeat.o(136965);
    }

    public final d gv(int i) {
        AppMethodBeat.i(136966);
        d gw;
        if (this.ckB && this.ckC != null) {
            gw = gw(i);
            AppMethodBeat.o(136966);
            return gw;
        } else if (this.ckB && this.ckC == null) {
            Dd();
            gw = gw(i);
            AppMethodBeat.o(136966);
            return gw;
        } else if (this.ckx == null || this.ckx.size() == 0) {
            AppMethodBeat.o(136966);
            return null;
        } else if (i >= this.ckx.size()) {
            AppMethodBeat.o(136966);
            return null;
        } else {
            gw = (d) this.ckx.get(i);
            AppMethodBeat.o(136966);
            return gw;
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(136967);
        this.index++;
        dVar.ckG = (long) (this.index * 20);
        if (this.ckx != null) {
            this.ckx.add(dVar);
        }
        AppMethodBeat.o(136967);
    }

    public final int size() {
        AppMethodBeat.i(136968);
        int size;
        if (this.count <= 0 || !this.cky) {
            size = this.ckx.size();
            AppMethodBeat.o(136968);
            return size;
        }
        size = this.count;
        AppMethodBeat.o(136968);
        return size;
    }

    public final void complete() {
        AppMethodBeat.i(136969);
        this.cky = true;
        this.count = size();
        b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", this.ckz);
        AppMethodBeat.o(136969);
    }

    public final long Da() {
        AppMethodBeat.i(136970);
        long j;
        if (this.bufferSize > 0) {
            j = this.bufferSize;
            AppMethodBeat.o(136970);
            return j;
        }
        this.bufferSize = (long) (size() * 3536);
        j = this.bufferSize;
        AppMethodBeat.o(136970);
        return j;
    }

    private void Db() {
        AppMethodBeat.i(136971);
        this.ckB = false;
        Df();
        AppMethodBeat.o(136971);
    }

    public final synchronized void Dc() {
        AppMethodBeat.i(136972);
        if (this.ckC != null) {
            b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
            this.ckC.close();
            this.ckC = null;
        }
        AppMethodBeat.o(136972);
    }

    private synchronized void Dd() {
        AppMethodBeat.i(136973);
        De();
        AppMethodBeat.o(136973);
    }

    private void De() {
        AppMethodBeat.i(136974);
        if (this.ckC == null) {
            this.ckC = new a(this.appId, this.ckz);
            if (this.ckC.open()) {
                b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
                this.ckC.setLength(Da());
                AppMethodBeat.o(136974);
                return;
            }
            b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
            this.ckB = false;
            Df();
        }
        AppMethodBeat.o(136974);
    }

    private void Df() {
        AppMethodBeat.i(136975);
        if (this.ckC != null) {
            this.ckC.close();
            this.ckC.CZ();
            this.ckC = null;
        }
        AppMethodBeat.o(136975);
    }

    private int b(byte[] bArr, long j, int i) {
        AppMethodBeat.i(136976);
        if (this.ckC != null) {
            int b = this.ckC.b(bArr, j, i);
            AppMethodBeat.o(136976);
            return b;
        }
        AppMethodBeat.o(136976);
        return 0;
    }

    private d gw(int i) {
        AppMethodBeat.i(136977);
        if (i >= this.count) {
            AppMethodBeat.o(136977);
            return null;
        } else if (this.ckC == null) {
            AppMethodBeat.o(136977);
            return null;
        } else {
            int i2 = i * 3536;
            if (i2 > this.ckC.getLength()) {
                AppMethodBeat.o(136977);
                return null;
            }
            d Dj = com.tencent.mm.audio.mix.b.b.Di().Dj();
            if (Dj == null) {
                AppMethodBeat.o(136977);
                return null;
            }
            if (Dj.ckv == null) {
                Dj.ckv = new byte[3536];
            } else {
                Arrays.fill(Dj.ckv, 0, Dj.ckv.length, (byte) 0);
            }
            System.nanoTime();
            if (b(Dj.ckv, (long) i2, Dj.ckv.length) <= 0) {
                com.tencent.mm.audio.mix.b.b.Di().b(Dj);
                AppMethodBeat.o(136977);
                return null;
            }
            Dj.ckD = this.ckD;
            Dj.sampleRate = this.sampleRate;
            Dj.channels = this.channels;
            Dj.cku = this.cku;
            Dj.ckG = (long) (i * 20);
            AppMethodBeat.o(136977);
            return Dj;
        }
    }
}
