package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.e.b */
public final class C1416b {
    public boolean epG = false;
    public int epH;
    public int epI;
    public int epJ;
    public int epK;
    public int epL;
    public int epM;
    public int epN;
    public int epO;
    public int epP;
    public int epQ;
    public int epR;
    public int epS;
    public int epT;
    public int epU;
    public int epV;
    public int epW;
    public int epX;
    public int epY;
    public int epZ;
    public int eqA;
    public short[] eqB = new short[15];
    public short[] eqC = new short[2];
    public boolean eqD;
    public int eqE;
    public boolean eqF = false;
    public int eqG;
    public int eqH;
    public int eqI;
    public int eqJ;
    public int eqK;
    public int eqL;
    public int eqM;
    public int eqN;
    public int eqO;
    public int eqP;
    public int eqa;
    public int eqb;
    public int eqc;
    public int eqd;
    public int eqe;
    public int eqf;
    public int eqg;
    public int eqh;
    public int eqi;
    public int eqj;
    public int eqk;
    public boolean eql;
    public int eqm;
    public int eqn;
    public int eqo;
    public int eqp;
    public int eqq;
    public int eqr;
    public int eqs;
    public int eqt;
    public int equ;
    public int eqv;
    public int eqw;
    public int eqx;
    public int eqy;
    public int eqz;

    public C1416b() {
        AppMethodBeat.m2504i(92910);
        reset();
        AppMethodBeat.m2505o(92910);
    }

    public final void reset() {
        this.epG = false;
        this.epH = -1;
        this.epI = -1;
        this.epJ = -1;
        this.epK = -1;
        this.epL = -1;
        this.epM = -1;
        this.epN = -1;
        this.epP = -1;
        this.epO = -1;
        this.eqt = -1;
        this.epQ = -1;
        this.epR = -1;
        this.epS = -1;
        this.eqe = -1;
        this.eqf = -1;
        this.eqg = -1;
        this.eqh = -1;
        this.eqi = -1;
        this.eqj = -1;
        this.eqk = -1;
        this.eql = false;
        this.eqm = -1;
        this.eqn = -1;
        this.eqp = -1;
        this.eqo = -1;
        this.eqs = -1;
        this.eqq = -1;
        this.eqr = -1;
        this.equ = -1;
        this.eqv = -1;
        this.eqw = -1;
        this.eqx = -1;
        this.epT = -1;
        this.epU = -1;
        this.epV = -1;
        this.epW = -1;
        this.epZ = -1;
        this.eqa = -1;
        this.eqb = -1;
        this.eqc = -1;
        this.eqy = 0;
        this.eqz = 0;
        this.eqA = -1;
        this.epY = -1;
        this.epX = -1;
        this.eqD = false;
        this.eqC[0] = (short) -1;
        this.eqC[1] = (short) -1;
        this.eqE = -1;
        this.eqM = -1;
        this.eqN = -1;
        this.eqO = -1;
        this.eqP = -1;
        this.eqd = -1;
    }

    /* renamed from: Lg */
    public final boolean mo4849Lg() {
        if ((this.epI < 0 || this.epJ >= 0) && ((this.epI >= 0 || this.epJ < 0) && this.epK <= 0)) {
            return false;
        }
        return true;
    }

    /* renamed from: Lh */
    public final boolean mo4850Lh() {
        return this.epL >= 0;
    }

    /* renamed from: Li */
    public final boolean mo4851Li() {
        return this.epM >= 0;
    }

    /* renamed from: Lj */
    public final int mo4852Lj() {
        AppMethodBeat.m2504i(92911);
        if (mo4850Lh()) {
            int i = (this.epL & 224) >> 5;
            C4990ab.m7410d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.m2505o(92911);
                return -1;
            }
            AppMethodBeat.m2505o(92911);
            return i;
        }
        AppMethodBeat.m2505o(92911);
        return -1;
    }

    /* renamed from: Lk */
    public final boolean mo4853Lk() {
        AppMethodBeat.m2504i(92912);
        if (mo4850Lh()) {
            boolean z;
            int i = this.epL & 16;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7410d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.m2505o(92912);
                return true;
            }
            AppMethodBeat.m2505o(92912);
            return false;
        }
        AppMethodBeat.m2505o(92912);
        return false;
    }

    /* renamed from: Ll */
    public final int mo4854Ll() {
        AppMethodBeat.m2504i(92913);
        if (mo4850Lh()) {
            int i = (this.epL & 14) >> 1;
            C4990ab.m7410d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.m2505o(92913);
                return -1;
            }
            AppMethodBeat.m2505o(92913);
            return i;
        }
        AppMethodBeat.m2505o(92913);
        return -1;
    }

    /* renamed from: Lm */
    public final boolean mo4855Lm() {
        AppMethodBeat.m2504i(92914);
        if (mo4850Lh()) {
            boolean z;
            int i = this.epL & 1;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7410d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.m2505o(92914);
                return true;
            }
            AppMethodBeat.m2505o(92914);
            return false;
        }
        AppMethodBeat.m2505o(92914);
        return false;
    }

    /* renamed from: Ln */
    public final int mo4856Ln() {
        AppMethodBeat.m2504i(92915);
        if (mo4851Li()) {
            int i = (this.epM & 224) >> 5;
            C4990ab.m7410d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.m2505o(92915);
                return -1;
            }
            AppMethodBeat.m2505o(92915);
            return i;
        }
        AppMethodBeat.m2505o(92915);
        return -1;
    }

    /* renamed from: Lo */
    public final boolean mo4857Lo() {
        AppMethodBeat.m2504i(92916);
        if (mo4851Li()) {
            boolean z;
            int i = this.epM & 16;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7410d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.m2505o(92916);
                return true;
            }
            AppMethodBeat.m2505o(92916);
            return false;
        }
        AppMethodBeat.m2505o(92916);
        return false;
    }

    /* renamed from: Lp */
    public final int mo4858Lp() {
        AppMethodBeat.m2504i(92917);
        if (mo4851Li()) {
            int i = (this.epM & 14) >> 1;
            C4990ab.m7410d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.m2505o(92917);
                return -1;
            }
            AppMethodBeat.m2505o(92917);
            return i;
        }
        AppMethodBeat.m2505o(92917);
        return -1;
    }

    /* renamed from: Lq */
    public final boolean mo4859Lq() {
        AppMethodBeat.m2504i(92918);
        if (mo4851Li()) {
            boolean z;
            int i = this.epM & 1;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7410d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.m2505o(92918);
                return true;
            }
            AppMethodBeat.m2505o(92918);
            return false;
        }
        AppMethodBeat.m2505o(92918);
        return false;
    }

    public final void dump() {
        AppMethodBeat.m2504i(92919);
        C4990ab.m7410d("VoipAudioInfo", "streamtype " + this.epH);
        C4990ab.m7410d("VoipAudioInfo", "smode " + this.epI);
        C4990ab.m7410d("VoipAudioInfo", "omode " + this.epJ);
        C4990ab.m7410d("VoipAudioInfo", "ospeaker " + this.epK);
        C4990ab.m7410d("VoipAudioInfo", "operating" + this.epL);
        C4990ab.m7410d("VoipAudioInfo", "moperating" + this.epM);
        C4990ab.m7410d("VoipAudioInfo", "mstreamtype" + this.epN);
        C4990ab.m7410d("VoipAudioInfo", "mVoiceRecordMode" + this.epO);
        C4990ab.m7410d("VoipAudioInfo", "agcMode :" + this.eqt);
        C4990ab.m7410d("VoipAudioInfo", "nsMode:" + this.epR);
        C4990ab.m7410d("VoipAudioInfo", "aecMode:" + this.epQ);
        C4990ab.m7410d("VoipAudioInfo", "volumMode:" + this.epS);
        C4990ab.m7410d("VoipAudioInfo", "micMode:" + this.eqe);
        C4990ab.m7410d("VoipAudioInfo", "sourceMode:" + this.eqf);
        C4990ab.m7410d("VoipAudioInfo", "speakerMode:" + this.eqg);
        C4990ab.m7410d("VoipAudioInfo", "phoneMode:" + this.eqh);
        C4990ab.m7410d("VoipAudioInfo", "voipstreamType:" + this.eqi);
        C4990ab.m7410d("VoipAudioInfo", "speakerstreamtype:" + this.eqj);
        C4990ab.m7410d("VoipAudioInfo", "phonestreamtype:" + this.eqk);
        C4990ab.m7410d("VoipAudioInfo", "ringphonestream:" + this.eqm);
        C4990ab.m7410d("VoipAudioInfo", "ringphonemode:" + this.eqn);
        C4990ab.m7410d("VoipAudioInfo", "ringspeakerstream:" + this.eqo);
        C4990ab.m7410d("VoipAudioInfo", "ringspeakermode:" + this.eqp);
        C4990ab.m7410d("VoipAudioInfo", "agcModeNew :" + this.eqs);
        C4990ab.m7410d("VoipAudioInfo", "nsModeNew:" + this.eqr);
        C4990ab.m7410d("VoipAudioInfo", "aecModeNew:" + this.eqq);
        C4990ab.m7410d("VoipAudioInfo", "agctargetdb:" + this.equ);
        C4990ab.m7410d("VoipAudioInfo", "agcgaindb:" + this.eqv);
        C4990ab.m7410d("VoipAudioInfo", "agcflag:" + this.eqw);
        C4990ab.m7410d("VoipAudioInfo", "agclimiter:" + this.eqx);
        C4990ab.m7410d("VoipAudioInfo", "inputVolumeScale:" + this.epT);
        C4990ab.m7410d("VoipAudioInfo", "outputVolumeScale:" + this.epU);
        C4990ab.m7410d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.epV);
        C4990ab.m7410d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.epW);
        C4990ab.m7410d("VoipAudioInfo", "ehanceHeadsetEC:" + this.epZ);
        C4990ab.m7410d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.eqa);
        C4990ab.m7410d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.eqb);
        C4990ab.m7410d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.eqc);
        C4990ab.m7410d("VoipAudioInfo", "enableRecTimer:" + this.eqy);
        C4990ab.m7410d("VoipAudioInfo", "enablePlayTimer:" + this.eqz);
        C4990ab.m7410d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.eqA);
        C4990ab.m7410d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.epX);
        C4990ab.m7410d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.epY);
        C4990ab.m7410d("VoipAudioInfo", "noisegateon" + this.eqD);
        C4990ab.m7410d("VoipAudioInfo", "noisegatestrength[0]" + this.eqC[0]);
        C4990ab.m7410d("VoipAudioInfo", "noisegatestrength[1]" + this.eqC[1]);
        C4990ab.m7410d("VoipAudioInfo", "spkecenable:" + this.eqE);
        C4990ab.m7410d("VoipAudioInfo", "agcRxFlag:" + this.eqM);
        C4990ab.m7410d("VoipAudioInfo", "agcRxTargetdb:" + this.eqN);
        C4990ab.m7410d("VoipAudioInfo", "agcRxGaindb:" + this.eqO);
        C4990ab.m7410d("VoipAudioInfo", "agcRxLimiter:" + this.eqP);
        C4990ab.m7410d("VoipAudioInfo", "enableXnoiseSup:" + this.eqd);
        AppMethodBeat.m2505o(92919);
    }
}
