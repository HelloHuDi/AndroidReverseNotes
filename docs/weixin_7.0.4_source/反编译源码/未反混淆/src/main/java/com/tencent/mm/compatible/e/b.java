package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
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

    public b() {
        AppMethodBeat.i(92910);
        reset();
        AppMethodBeat.o(92910);
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

    public final boolean Lg() {
        if ((this.epI < 0 || this.epJ >= 0) && ((this.epI >= 0 || this.epJ < 0) && this.epK <= 0)) {
            return false;
        }
        return true;
    }

    public final boolean Lh() {
        return this.epL >= 0;
    }

    public final boolean Li() {
        return this.epM >= 0;
    }

    public final int Lj() {
        AppMethodBeat.i(92911);
        if (Lh()) {
            int i = (this.epL & 224) >> 5;
            ab.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.o(92911);
                return -1;
            }
            AppMethodBeat.o(92911);
            return i;
        }
        AppMethodBeat.o(92911);
        return -1;
    }

    public final boolean Lk() {
        AppMethodBeat.i(92912);
        if (Lh()) {
            boolean z;
            int i = this.epL & 16;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            ab.d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.o(92912);
                return true;
            }
            AppMethodBeat.o(92912);
            return false;
        }
        AppMethodBeat.o(92912);
        return false;
    }

    public final int Ll() {
        AppMethodBeat.i(92913);
        if (Lh()) {
            int i = (this.epL & 14) >> 1;
            ab.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.o(92913);
                return -1;
            }
            AppMethodBeat.o(92913);
            return i;
        }
        AppMethodBeat.o(92913);
        return -1;
    }

    public final boolean Lm() {
        AppMethodBeat.i(92914);
        if (Lh()) {
            boolean z;
            int i = this.epL & 1;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            ab.d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.o(92914);
                return true;
            }
            AppMethodBeat.o(92914);
            return false;
        }
        AppMethodBeat.o(92914);
        return false;
    }

    public final int Ln() {
        AppMethodBeat.i(92915);
        if (Li()) {
            int i = (this.epM & 224) >> 5;
            ab.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.o(92915);
                return -1;
            }
            AppMethodBeat.o(92915);
            return i;
        }
        AppMethodBeat.o(92915);
        return -1;
    }

    public final boolean Lo() {
        AppMethodBeat.i(92916);
        if (Li()) {
            boolean z;
            int i = this.epM & 16;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            ab.d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.o(92916);
                return true;
            }
            AppMethodBeat.o(92916);
            return false;
        }
        AppMethodBeat.o(92916);
        return false;
    }

    public final int Lp() {
        AppMethodBeat.i(92917);
        if (Li()) {
            int i = (this.epM & 14) >> 1;
            ab.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
            if (i == 7) {
                AppMethodBeat.o(92917);
                return -1;
            }
            AppMethodBeat.o(92917);
            return i;
        }
        AppMethodBeat.o(92917);
        return -1;
    }

    public final boolean Lq() {
        AppMethodBeat.i(92918);
        if (Li()) {
            boolean z;
            int i = this.epM & 1;
            String str = "VoipAudioInfo";
            StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            ab.d(str, stringBuilder.append(z).toString());
            if (i > 0) {
                AppMethodBeat.o(92918);
                return true;
            }
            AppMethodBeat.o(92918);
            return false;
        }
        AppMethodBeat.o(92918);
        return false;
    }

    public final void dump() {
        AppMethodBeat.i(92919);
        ab.d("VoipAudioInfo", "streamtype " + this.epH);
        ab.d("VoipAudioInfo", "smode " + this.epI);
        ab.d("VoipAudioInfo", "omode " + this.epJ);
        ab.d("VoipAudioInfo", "ospeaker " + this.epK);
        ab.d("VoipAudioInfo", "operating" + this.epL);
        ab.d("VoipAudioInfo", "moperating" + this.epM);
        ab.d("VoipAudioInfo", "mstreamtype" + this.epN);
        ab.d("VoipAudioInfo", "mVoiceRecordMode" + this.epO);
        ab.d("VoipAudioInfo", "agcMode :" + this.eqt);
        ab.d("VoipAudioInfo", "nsMode:" + this.epR);
        ab.d("VoipAudioInfo", "aecMode:" + this.epQ);
        ab.d("VoipAudioInfo", "volumMode:" + this.epS);
        ab.d("VoipAudioInfo", "micMode:" + this.eqe);
        ab.d("VoipAudioInfo", "sourceMode:" + this.eqf);
        ab.d("VoipAudioInfo", "speakerMode:" + this.eqg);
        ab.d("VoipAudioInfo", "phoneMode:" + this.eqh);
        ab.d("VoipAudioInfo", "voipstreamType:" + this.eqi);
        ab.d("VoipAudioInfo", "speakerstreamtype:" + this.eqj);
        ab.d("VoipAudioInfo", "phonestreamtype:" + this.eqk);
        ab.d("VoipAudioInfo", "ringphonestream:" + this.eqm);
        ab.d("VoipAudioInfo", "ringphonemode:" + this.eqn);
        ab.d("VoipAudioInfo", "ringspeakerstream:" + this.eqo);
        ab.d("VoipAudioInfo", "ringspeakermode:" + this.eqp);
        ab.d("VoipAudioInfo", "agcModeNew :" + this.eqs);
        ab.d("VoipAudioInfo", "nsModeNew:" + this.eqr);
        ab.d("VoipAudioInfo", "aecModeNew:" + this.eqq);
        ab.d("VoipAudioInfo", "agctargetdb:" + this.equ);
        ab.d("VoipAudioInfo", "agcgaindb:" + this.eqv);
        ab.d("VoipAudioInfo", "agcflag:" + this.eqw);
        ab.d("VoipAudioInfo", "agclimiter:" + this.eqx);
        ab.d("VoipAudioInfo", "inputVolumeScale:" + this.epT);
        ab.d("VoipAudioInfo", "outputVolumeScale:" + this.epU);
        ab.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.epV);
        ab.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.epW);
        ab.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.epZ);
        ab.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.eqa);
        ab.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.eqb);
        ab.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.eqc);
        ab.d("VoipAudioInfo", "enableRecTimer:" + this.eqy);
        ab.d("VoipAudioInfo", "enablePlayTimer:" + this.eqz);
        ab.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.eqA);
        ab.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.epX);
        ab.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.epY);
        ab.d("VoipAudioInfo", "noisegateon" + this.eqD);
        ab.d("VoipAudioInfo", "noisegatestrength[0]" + this.eqC[0]);
        ab.d("VoipAudioInfo", "noisegatestrength[1]" + this.eqC[1]);
        ab.d("VoipAudioInfo", "spkecenable:" + this.eqE);
        ab.d("VoipAudioInfo", "agcRxFlag:" + this.eqM);
        ab.d("VoipAudioInfo", "agcRxTargetdb:" + this.eqN);
        ab.d("VoipAudioInfo", "agcRxGaindb:" + this.eqO);
        ab.d("VoipAudioInfo", "agcRxLimiter:" + this.eqP);
        ab.d("VoipAudioInfo", "enableXnoiseSup:" + this.eqd);
        AppMethodBeat.o(92919);
    }
}
