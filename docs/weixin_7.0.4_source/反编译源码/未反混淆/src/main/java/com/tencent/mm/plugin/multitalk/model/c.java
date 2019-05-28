package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c implements a, HeadsetPlugReceiver.a {
    boolean cFy = false;
    b gar = new b(ah.getContext());
    com.tencent.mm.plugin.voip.model.c kzq = null;
    final Object kzr = new Object();
    HeadsetPlugReceiver kzs = new HeadsetPlugReceiver();
    private boolean kzt = false;
    private boolean kzu = false;
    private int kzv;
    g.a kzw = new g.a();
    private final Object nxa = new Object();

    public c() {
        AppMethodBeat.i(53885);
        AppMethodBeat.o(53885);
    }

    public final int a(com.tencent.mm.plugin.voip.model.b bVar, int i, int i2) {
        int i3;
        AppMethodBeat.i(53886);
        synchronized (this.kzr) {
            try {
                if (this.cFy) {
                    ab.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                    i3 = -1;
                } else {
                    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", Integer.valueOf(hashCode()));
                    if (this.kzq == null) {
                        this.kzq = new com.tencent.mm.plugin.voip.model.c();
                        this.kzq.G(i, 1, i2, 0);
                    }
                    this.kzq.x(ah.getContext(), false);
                    this.kzq.sNt = bVar;
                    com.tencent.mm.compatible.b.g.KK().a((a) this);
                    this.kzt = com.tencent.mm.compatible.b.g.KK().KV();
                    this.kzu = com.tencent.mm.compatible.b.g.KK().KP();
                    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", Boolean.valueOf(this.kzt), Boolean.valueOf(this.kzu), Integer.valueOf(hashCode()));
                    this.gar.requestFocus();
                    this.kzs.a(ah.getContext(), this);
                    if (this.kzt || this.kzu) {
                        p.bSf().ji(false);
                        if (this.kzu) {
                            com.tencent.mm.compatible.b.g.KK().KM();
                        }
                        p.bSe().jj(true);
                    } else {
                        p.bSe().jj(false);
                    }
                    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
                    this.cFy = true;
                    this.kzw.evE = SystemClock.elapsedRealtime();
                    i3 = this.kzq.cIp();
                    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.kzw.Mr());
                    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", Integer.valueOf(i3));
                    AppMethodBeat.o(53886);
                }
            } finally {
                AppMethodBeat.o(53886);
            }
        }
        return i3;
    }

    public final void io(boolean z) {
        AppMethodBeat.i(53887);
        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        com.tencent.mm.compatible.b.g.KK().bF(z);
        if (this.kzq != null && this.kzq.sNi) {
            this.kzq.mj(z);
        }
        AppMethodBeat.o(53887);
    }

    public final void fS(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(53888);
        if (this.kzt != z) {
            this.kzt = z;
            ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", Boolean.valueOf(this.kzt), Boolean.valueOf(p.bSf().oGb), Boolean.valueOf(p.bSf().oGc), Boolean.valueOf(p.bSf().nwe.DB()), Boolean.valueOf(this.kzu));
            boolean z3 = p.bSf().nwe.DB() && !this.kzt;
            if (z) {
                p.bSf().ji(false);
            }
            if (p.bSf().nwe.DB() && !this.kzt) {
                z3 = p.bSf().oGc;
            }
            if (this.kzu) {
                z3 = false;
            }
            io(z3);
            p.bSf().jo(z3);
            if (!z) {
                p.bSf().ji(true);
            }
            d bSe = p.bSe();
            if (this.kzu || !z) {
                z2 = false;
            }
            bSe.jj(z2);
        }
        AppMethodBeat.o(53888);
    }

    public final void gE(int i) {
        AppMethodBeat.i(53889);
        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", Integer.valueOf(i), Boolean.valueOf(this.cFy));
        boolean bRi;
        switch (i) {
            case 1:
                if (i != this.kzv) {
                    this.kzu = true;
                    p.bSf().ji(false);
                    io(false);
                    p.bSf().jo(false);
                    p.bSe().jj(true);
                    break;
                }
                break;
            case 2:
                if (i != this.kzv) {
                    this.kzu = false;
                    bRi = bRi();
                    io(bRi);
                    p.bSf().jo(bRi);
                    p.bSf().ji(true);
                    break;
                }
                break;
            case 3:
                this.kzu = true;
                com.tencent.mm.compatible.b.g.KK().KM();
                break;
            case 4:
                if (i != this.kzv) {
                    this.kzu = false;
                    com.tencent.mm.compatible.b.g.KK().KN();
                    bRi = bRi();
                    io(bRi);
                    p.bSf().jo(bRi);
                    p.bSf().ji(true);
                    break;
                }
                break;
            case 5:
                com.tencent.mm.compatible.b.g.KK().KM();
                break;
        }
        this.kzv = i;
        AppMethodBeat.o(53889);
    }

    private boolean bRi() {
        AppMethodBeat.i(53890);
        boolean z = p.bSf().nwe.DB() && !this.kzt;
        if (p.bSf().nwe.DB() && !this.kzt) {
            z = p.bSf().oGc;
        }
        p.bSe().jj(false);
        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", Boolean.valueOf(this.kzt), Boolean.valueOf(p.bSf().oGb), Boolean.valueOf(p.bSf().oGc), Boolean.valueOf(p.bSf().nwe.DB()), Boolean.valueOf(this.kzu), Boolean.valueOf(z));
        AppMethodBeat.o(53890);
        return z;
    }
}
