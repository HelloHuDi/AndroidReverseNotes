package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

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

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.d */
public final class C6828d implements C1406a, C14032a {
    boolean cFy = false;
    C45293b gar = new C45293b(C4996ah.getContext());
    C29496c kzq = null;
    final Object kzr = new Object();
    HeadsetPlugReceiver kzs = new HeadsetPlugReceiver();
    boolean kzt = false;
    boolean kzu = false;
    private int kzv;
    C1446a kzw = new C1446a();
    boolean kzx = false;

    public C6828d() {
        AppMethodBeat.m2504i(135472);
        AppMethodBeat.m2505o(135472);
    }

    /* renamed from: a */
    public final int mo15103a(C29495b c29495b, int i, int i2, int i3) {
        int i4;
        AppMethodBeat.m2504i(135473);
        synchronized (this.kzr) {
            try {
                if (this.cFy) {
                    C4990ab.m7410d("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay, already start");
                    i4 = -1;
                } else {
                    C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlay %s", Integer.valueOf(hashCode()));
                    if (this.kzq == null) {
                        this.kzq = new C29496c();
                        this.kzq.mo47750G(i, i2, i3, 0);
                    }
                    this.kzq.mo47759x(C4996ah.getContext(), false);
                    this.kzq.sNt = c29495b;
                    this.kzw.evE = SystemClock.elapsedRealtime();
                    i4 = this.kzq.cIp();
                    C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "startPlaying cost: " + this.kzw.mo4908Mr());
                    C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "set start play");
                    this.cFy = true;
                    C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "finish start play: %s", Integer.valueOf(i4));
                    AppMethodBeat.m2505o(135473);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135473);
            }
        }
        return i4;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fR */
    public final boolean mo15104fR(boolean z) {
        AppMethodBeat.m2504i(135474);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        C1407g.m2946KK().mo4832bF(z);
        if (this.kzq == null || !this.kzq.sNi) {
            AppMethodBeat.m2505o(135474);
            return false;
        }
        boolean mj = this.kzq.mo47758mj(z);
        AppMethodBeat.m2505o(135474);
        return mj;
    }

    /* renamed from: fS */
    public final void mo9263fS(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.m2504i(135475);
        if (this.kzt != z) {
            this.kzt = z;
            C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isBluetoothConnected: %s", Boolean.valueOf(this.kzt), Boolean.valueOf(this.kzu));
            if (this.kzt) {
                z2 = false;
            }
            if (!this.kzu) {
                z3 = z2;
            }
            this.kzx &= mo15104fR(z3);
        }
        AppMethodBeat.m2505o(135475);
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(135476);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", Integer.valueOf(i), Boolean.valueOf(this.cFy));
        switch (i) {
            case 1:
                if (i != this.kzv) {
                    this.kzu = true;
                    this.kzx &= mo15104fR(false);
                    break;
                }
                break;
            case 2:
                if (i != this.kzv) {
                    this.kzu = false;
                    this.kzx &= mo15104fR(true);
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
                    this.kzx &= mo15104fR(true);
                    break;
                }
                break;
            case 5:
                C1407g.m2946KK().mo4817KM();
                break;
        }
        this.kzv = i;
        AppMethodBeat.m2505o(135476);
    }
}
