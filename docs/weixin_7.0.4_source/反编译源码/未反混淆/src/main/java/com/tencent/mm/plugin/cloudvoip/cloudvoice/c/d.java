package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d implements a, HeadsetPlugReceiver.a {
    boolean cFy = false;
    b gar = new b(ah.getContext());
    c kzq = null;
    final Object kzr = new Object();
    HeadsetPlugReceiver kzs = new HeadsetPlugReceiver();
    boolean kzt = false;
    boolean kzu = false;
    private int kzv;
    g.a kzw = new g.a();
    boolean kzx = false;

    public d() {
        AppMethodBeat.i(135472);
        AppMethodBeat.o(135472);
    }

    public final int a(com.tencent.mm.plugin.voip.model.b bVar, int i, int i2, int i3) {
        int i4;
        AppMethodBeat.i(135473);
        synchronized (this.kzr) {
            try {
                if (this.cFy) {
                    ab.d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
                    i4 = -1;
                } else {
                    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", Integer.valueOf(hashCode()));
                    if (this.kzq == null) {
                        this.kzq = new c();
                        this.kzq.G(i, i2, i3, 0);
                    }
                    this.kzq.x(ah.getContext(), false);
                    this.kzq.sNt = bVar;
                    this.kzw.evE = SystemClock.elapsedRealtime();
                    i4 = this.kzq.cIp();
                    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.kzw.Mr());
                    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
                    this.cFy = true;
                    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", Integer.valueOf(i4));
                    AppMethodBeat.o(135473);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135473);
            }
        }
        return i4;
    }

    /* Access modifiers changed, original: final */
    public final boolean fR(boolean z) {
        AppMethodBeat.i(135474);
        ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        com.tencent.mm.compatible.b.g.KK().bF(z);
        if (this.kzq == null || !this.kzq.sNi) {
            AppMethodBeat.o(135474);
            return false;
        }
        boolean mj = this.kzq.mj(z);
        AppMethodBeat.o(135474);
        return mj;
    }

    public final void fS(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(135475);
        if (this.kzt != z) {
            this.kzt = z;
            ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isBluetoothConnected: %s", Boolean.valueOf(this.kzt), Boolean.valueOf(this.kzu));
            if (this.kzt) {
                z2 = false;
            }
            if (!this.kzu) {
                z3 = z2;
            }
            this.kzx &= fR(z3);
        }
        AppMethodBeat.o(135475);
    }

    public final void gE(int i) {
        AppMethodBeat.i(135476);
        ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", Integer.valueOf(i), Boolean.valueOf(this.cFy));
        switch (i) {
            case 1:
                if (i != this.kzv) {
                    this.kzu = true;
                    this.kzx &= fR(false);
                    break;
                }
                break;
            case 2:
                if (i != this.kzv) {
                    this.kzu = false;
                    this.kzx &= fR(true);
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
                    this.kzx &= fR(true);
                    break;
                }
                break;
            case 5:
                com.tencent.mm.compatible.b.g.KK().KM();
                break;
        }
        this.kzv = i;
        AppMethodBeat.o(135476);
    }
}
