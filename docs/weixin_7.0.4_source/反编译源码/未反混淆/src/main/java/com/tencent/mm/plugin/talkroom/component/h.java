package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.plugin.talkroom.component.e.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends a implements Runnable {
    private static final int sxv = com.tencent.mm.plugin.talkroom.model.a.sxv;
    private AudioTrack aQf;
    private int bufferSize = (((sxv / 1000) * 20) * 2);
    private boolean cAY = true;
    private boolean chf = false;
    private boolean fZQ = false;
    private boolean gbH = true;
    private ak handler = new ak(Looper.getMainLooper());
    private final Object lock = new Object();
    private int nKD = 0;
    private int sxA;
    private long sxB = 0;
    private v2engine sxg;
    private short sxh;
    private short sxi;
    private int sxw = sxv;
    private final c sxx;
    private boolean sxy = false;
    private long sxz = 0;

    public h(v2engine v2engine, c cVar) {
        AppMethodBeat.i(25737);
        this.sxg = v2engine;
        this.sxx = cVar;
        this.fZQ = true;
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.stop();
        }
        if (this.aQf != null) {
            try {
                this.aQf.release();
            } catch (Exception e) {
            }
        }
        v2engine.ZL().f(true, false, false);
        int bE = v2engine.ZL().bE(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.sxw, 2, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            AppMethodBeat.o(25737);
            return;
        }
        this.aQf = new e(bE, this.sxw, 2, minBufferSize * 8);
        this.fZQ = false;
        AppMethodBeat.o(25737);
    }

    public final void cpN() {
        AppMethodBeat.i(25738);
        this.cAY = true;
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.pause();
        }
        AppMethodBeat.o(25738);
    }

    public final void cEf() {
        AppMethodBeat.i(25739);
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.play();
        }
        synchronized (this.lock) {
            try {
                this.cAY = false;
                this.lock.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(25739);
            }
        }
        this.sxi = (short) 0;
        this.sxh = (short) 0;
    }

    public final void release() {
        AppMethodBeat.i(25740);
        ab.i("MicroMsg.TalkRoomPlayer", "release");
        this.chf = true;
        if (this.aQf != null && this.aQf.getState() == 1) {
            this.aQf.stop();
        }
        if (this.aQf != null) {
            this.aQf.release();
        }
        synchronized (this.lock) {
            try {
                this.cAY = false;
                this.lock.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(25740);
            }
        }
    }

    public final void run() {
        AppMethodBeat.i(25741);
        while (!this.chf) {
            if (this.fZQ) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    try {
                        if (this.cAY) {
                            this.lock.wait();
                        }
                    } catch (InterruptedException e2) {
                        ab.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                    } catch (Throwable th) {
                        AppMethodBeat.o(25741);
                    }
                }
                long j = this.sxB;
                this.sxB = bo.yz();
                j = this.sxB - j;
                if (j < 20 && j > 0) {
                    try {
                        synchronized (this.lock) {
                            this.lock.wait(j);
                        }
                    } catch (InterruptedException e22) {
                        ab.printErrStackTrace("MicroMsg.TalkRoomPlayer", e22, "", new Object[0]);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(25741);
                        }
                    }
                }
                try {
                    int GetAudioData;
                    PByteArray pByteArray = new PByteArray();
                    final PInt pInt = new PInt();
                    final PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.sxg.IsSilenceFrame();
                    if (IsSilenceFrame == 0) {
                        GetAudioData = this.sxg.GetAudioData(pByteArray, this.bufferSize, pInt, pInt2);
                    } else {
                        GetAudioData = 0;
                    }
                    if (GetAudioData < 0) {
                        this.nKD++;
                        ab.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", Integer.valueOf(GetAudioData), Integer.valueOf(this.nKD));
                        if (this.nKD >= 100) {
                            this.nKD = 0;
                            this.cAY = true;
                        }
                    } else {
                        boolean z;
                        if (IsSilenceFrame == 0) {
                            if (this.aQf.getPlayState() != 3) {
                                this.aQf.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (GetAudioData = 0; GetAudioData < length / 2; GetAudioData++) {
                                short s = (short) ((bArr[GetAudioData * 2] & 255) | (bArr[(GetAudioData * 2) + 1] << 8));
                                if (s > this.sxh) {
                                    this.sxh = s;
                                }
                            }
                            this.aQf.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.gbH) {
                            this.aQf.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.sxz = bo.yz();
                            z = false;
                        } else if (bo.az(this.sxz) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((!((!this.gbH && this.sxA == pInt2.value) || z || pInt.value == 0) || (!this.gbH && z)) && !this.sxy) {
                            if (!(z || pInt2.value == 0)) {
                                this.sxA = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueueV2(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(25736);
                                    h.this.sxy = true;
                                    try {
                                        h.this.sxx.p(pInt.value, pInt2.value, z);
                                    } catch (RemoteException e) {
                                        ab.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                                    }
                                    h.this.sxy = false;
                                    AppMethodBeat.o(25736);
                                }
                            });
                            this.gbH = z;
                        }
                    }
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.TalkRoomPlayer", e3, "", new Object[0]);
                    ab.e("MicroMsg.TalkRoomPlayer", e3.toString());
                }
            }
        }
        AppMethodBeat.o(25741);
    }

    public final int cEe() {
        if (this.sxi < this.sxh) {
            this.sxi = this.sxh;
        }
        if (this.sxi == (short) 0) {
            return 0;
        }
        short s = (short) ((this.sxh * 100) / this.sxi);
        this.sxh = (short) 0;
        return s;
    }

    public final void start() {
        AppMethodBeat.i(25742);
        d.h((Runnable) this, "TalkRoomPlayer_start").start();
        AppMethodBeat.o(25742);
    }
}
