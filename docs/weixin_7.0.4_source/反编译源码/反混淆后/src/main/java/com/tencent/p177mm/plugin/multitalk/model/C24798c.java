package com.tencent.p177mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver.C14032a;
import com.tencent.p177mm.plugin.voip.model.C29495b;
import com.tencent.p177mm.plugin.voip.model.C29496c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.multitalk.model.c */
public final class C24798c implements C1406a, C14032a {
    boolean cFy = false;
    C45293b gar = new C45293b(C4996ah.getContext());
    C29496c kzq = null;
    final Object kzr = new Object();
    HeadsetPlugReceiver kzs = new HeadsetPlugReceiver();
    private boolean kzt = false;
    private boolean kzu = false;
    private int kzv;
    C1446a kzw = new C1446a();
    private final Object nxa = new Object();

    public C24798c() {
        AppMethodBeat.m2504i(53885);
        AppMethodBeat.m2505o(53885);
    }

    /* renamed from: a */
    public final int mo41656a(C29495b c29495b, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(53886);
        synchronized (this.kzr) {
            try {
                if (this.cFy) {
                    C4990ab.m7410d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                    i3 = -1;
                } else {
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", Integer.valueOf(hashCode()));
                    if (this.kzq == null) {
                        this.kzq = new C29496c();
                        this.kzq.mo47750G(i, 1, i2, 0);
                    }
                    this.kzq.mo47759x(C4996ah.getContext(), false);
                    this.kzq.sNt = c29495b;
                    C1407g.m2946KK().mo4828a((C1406a) this);
                    this.kzt = C1407g.m2946KK().mo4822KV();
                    this.kzu = C1407g.m2946KK().mo4819KP();
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", Boolean.valueOf(this.kzt), Boolean.valueOf(this.kzu), Integer.valueOf(hashCode()));
                    this.gar.requestFocus();
                    this.kzs.mo26276a(C4996ah.getContext(), this);
                    if (this.kzt || this.kzu) {
                        C34572p.bSf().mo24589ji(false);
                        if (this.kzu) {
                            C1407g.m2946KK().mo4817KM();
                        }
                        C34572p.bSe().mo46533jj(true);
                    } else {
                        C34572p.bSe().mo46533jj(false);
                    }
                    C4990ab.m7416i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
                    this.cFy = true;
                    this.kzw.evE = SystemClock.elapsedRealtime();
                    i3 = this.kzq.cIp();
                    C4990ab.m7416i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.kzw.mo4908Mr());
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", Integer.valueOf(i3));
                    AppMethodBeat.m2505o(53886);
                }
            } finally {
                AppMethodBeat.m2505o(53886);
            }
        }
        return i3;
    }

    /* renamed from: io */
    public final void mo41657io(boolean z) {
        AppMethodBeat.m2504i(53887);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        C1407g.m2946KK().mo4832bF(z);
        if (this.kzq != null && this.kzq.sNi) {
            this.kzq.mo47758mj(z);
        }
        AppMethodBeat.m2505o(53887);
    }

    /* renamed from: fS */
    public final void mo9263fS(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(53888);
        if (this.kzt != z) {
            this.kzt = z;
            C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", Boolean.valueOf(this.kzt), Boolean.valueOf(C34572p.bSf().oGb), Boolean.valueOf(C34572p.bSf().oGc), Boolean.valueOf(C34572p.bSf().nwe.mo38019DB()), Boolean.valueOf(this.kzu));
            boolean z3 = C34572p.bSf().nwe.mo38019DB() && !this.kzt;
            if (z) {
                C34572p.bSf().mo24589ji(false);
            }
            if (C34572p.bSf().nwe.mo38019DB() && !this.kzt) {
                z3 = C34572p.bSf().oGc;
            }
            if (this.kzu) {
                z3 = false;
            }
            mo41657io(z3);
            C34572p.bSf().mo24591jo(z3);
            if (!z) {
                C34572p.bSf().mo24589ji(true);
            }
            C28535d bSe = C34572p.bSe();
            if (this.kzu || !z) {
                z2 = false;
            }
            bSe.mo46533jj(z2);
        }
        AppMethodBeat.m2505o(53888);
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(53889);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", Integer.valueOf(i), Boolean.valueOf(this.cFy));
        boolean bRi;
        switch (i) {
            case 1:
                if (i != this.kzv) {
                    this.kzu = true;
                    C34572p.bSf().mo24589ji(false);
                    mo41657io(false);
                    C34572p.bSf().mo24591jo(false);
                    C34572p.bSe().mo46533jj(true);
                    break;
                }
                break;
            case 2:
                if (i != this.kzv) {
                    this.kzu = false;
                    bRi = bRi();
                    mo41657io(bRi);
                    C34572p.bSf().mo24591jo(bRi);
                    C34572p.bSf().mo24589ji(true);
                    break;
                }
                break;
            case 3:
                this.kzu = true;
                C1407g.m2946KK().mo4817KM();
                break;
            case 4:
                if (i != this.kzv) {
                    this.kzu = false;
                    C1407g.m2946KK().mo4818KN();
                    bRi = bRi();
                    mo41657io(bRi);
                    C34572p.bSf().mo24591jo(bRi);
                    C34572p.bSf().mo24589ji(true);
                    break;
                }
                break;
            case 5:
                C1407g.m2946KK().mo4817KM();
                break;
        }
        this.kzv = i;
        AppMethodBeat.m2505o(53889);
    }

    private boolean bRi() {
        AppMethodBeat.m2504i(53890);
        boolean z = C34572p.bSf().nwe.mo38019DB() && !this.kzt;
        if (C34572p.bSf().nwe.mo38019DB() && !this.kzt) {
            z = C34572p.bSf().oGc;
        }
        C34572p.bSe().mo46533jj(false);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkAudioPlayer", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", Boolean.valueOf(this.kzt), Boolean.valueOf(C34572p.bSf().oGb), Boolean.valueOf(C34572p.bSf().oGc), Boolean.valueOf(C34572p.bSf().nwe.mo38019DB()), Boolean.valueOf(this.kzu), Boolean.valueOf(z));
        AppMethodBeat.m2505o(53890);
        return z;
    }
}
