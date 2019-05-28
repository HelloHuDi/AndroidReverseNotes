package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public final class c {
    private static float aQH = 0.0f;
    public AudioTrack aQf = null;
    Context context;
    private Timer cqh = null;
    private boolean cqi = false;
    private int eqg = 3;
    int fZK = 2;
    private int fZL = 0;
    private Runnable fZM;
    private int fZO = 0;
    int fZP = 20;
    private boolean fZQ = false;
    private int iWl = 0;
    private int nSamplerate = 0;
    private int sNA = 0;
    private int sNB = 0;
    private int sNC = 1;
    private int sND = 0;
    private long sNE = 0;
    private long sNF = 0;
    private int sNG = 1;
    private int sNH = 0;
    private int sNI = -1;
    private int sNJ = 0;
    private long sNK = 0;
    private int sNL = 1;
    private int sNM = 0;
    private final Object sNN = new Object();
    private int sNO = 0;
    private int sNP = 0;
    private int sNQ = 0;
    private int sNR = 0;
    public boolean sNi = false;
    boolean sNj = false;
    boolean sNk = true;
    k sNl = null;
    private int sNm = 0;
    private byte[] sNn = null;
    private byte[] sNo = null;
    private byte[] sNp = null;
    private byte[] sNq = null;
    private byte[] sNr = null;
    private int sNs = 0;
    public b sNt = null;
    private int sNu = 1;
    private int sNv = 1;
    private int sNw = 0;
    private int sNx = 0;
    private int sNy = 0;
    private int sNz = 0;

    class a extends TimerTask {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(4322);
            System.currentTimeMillis();
            if (c.this.sNw == 1 && c.this.sNi) {
                System.currentTimeMillis();
                if (c.this.sNz + c.this.fZP < c.this.sNm && c.this.sNR == 0) {
                    c.this.sNQ = 1;
                    int N = c.this.sNt.N(c.this.sNr, c.this.fZP);
                    c.this.sNQ = 0;
                    if (N < 0) {
                        ab.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(N)));
                        AppMethodBeat.o(4322);
                        return;
                    }
                    synchronized (c.this.sNN) {
                        try {
                            System.arraycopy(c.this.sNr, 0, c.this.sNo, c.this.sNz, c.this.fZP);
                            c.this.sNz = c.this.sNz + c.this.fZP;
                            c.this.sNy = c.this.sNy + (c.this.fZP >> 1);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(4322);
                        }
                    }
                    return;
                }
            }
            AppMethodBeat.o(4322);
        }
    }

    public c() {
        AppMethodBeat.i(4323);
        AppMethodBeat.o(4323);
    }

    static /* synthetic */ void j(c cVar, int i) {
        if (cVar.sNP != -1 && i < 0) {
            cVar.sNP++;
            if (cVar.sNP >= 50) {
                cVar.sNO = 5;
                cVar.sNP = -1;
            }
        }
    }

    public final int cIn() {
        return (this.sNM / this.fZP) * this.fZL;
    }

    public final int x(Context context, boolean z) {
        AppMethodBeat.i(4324);
        ab.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.sNs == 2) {
            this.fZK = 3;
        } else {
            this.fZK = 2;
        }
        this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
        if (this.fZO == -2 || this.fZO == -1) {
            this.sNO = 1;
            AppMethodBeat.o(4324);
            return -1;
        }
        this.sNB = this.fZO;
        this.sNH = this.sNB * this.sNG;
        this.fZO *= this.sNL;
        float f = ((float) (this.sNB >> 1)) / ((float) this.nSamplerate);
        int Lw = m.Lw();
        int i = q.etd.eqz;
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            ab.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: ".concat(String.valueOf(i)));
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.iWl != 0) {
            i = 0;
        }
        this.sNk = i != 0;
        ab.d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.fZO + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.sNk);
        int mk = mk(z);
        try {
            if (this.aQf != null) {
                try {
                    this.aQf.release();
                } catch (Exception e) {
                }
            }
            this.aQf = new e(mk, this.nSamplerate, this.fZK, this.fZO);
        } catch (Exception e2) {
            ab.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", e2);
            this.sNO = 6;
        }
        if (this.aQf == null || this.aQf.getState() == 0) {
            this.sNO = 2;
            ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.aQf != null) {
                this.aQf.release();
            }
            if (mk == 0) {
                this.aQf = new e(3, this.nSamplerate, this.fZK, this.fZO);
            } else {
                this.aQf = new e(0, this.nSamplerate, this.fZK, this.fZO);
            }
        }
        if (this.aQf == null) {
            this.sNO = 3;
            ab.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            AppMethodBeat.o(4324);
            return -1;
        } else if (this.aQf.getState() == 0) {
            this.sNO = 3;
            ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.aQf.release();
            this.aQf = null;
            AppMethodBeat.o(4324);
            return -1;
        } else {
            this.sNn = new byte[this.fZO];
            if (this.sNn == null) {
                ab.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                AppMethodBeat.o(4324);
                return -1;
            }
            this.sNq = new byte[this.fZP];
            if (this.sNq == null) {
                ab.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                AppMethodBeat.o(4324);
                return -1;
            }
            if (this.sNk) {
                this.sNm = this.fZO;
                this.sNo = new byte[this.sNm];
                if (this.sNo == null) {
                    ab.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    AppMethodBeat.o(4324);
                    return -1;
                }
                this.sNp = new byte[this.sNm];
                if (this.sNp == null) {
                    ab.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    AppMethodBeat.o(4324);
                    return -1;
                }
                this.sNr = new byte[this.fZP];
                if (this.sNr == null) {
                    ab.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    AppMethodBeat.o(4324);
                    return -1;
                }
            }
            this.sNi = false;
            this.sNj = false;
            ab.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(g.KK().eoY.getMode()), Boolean.valueOf(g.KK().eoY.isSpeakerphoneOn()), Integer.valueOf(mk), Integer.valueOf(this.fZO), Integer.valueOf(this.nSamplerate));
            i = (this.fZO * 1000) / (this.nSamplerate * 2);
            AppMethodBeat.o(4324);
            return i;
        }
    }

    public final boolean mj(boolean z) {
        AppMethodBeat.i(4325);
        ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int mk = mk(z);
        if (g.KK().KP()) {
            mk = 0;
        }
        ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + mk);
        if (this.aQf == null || mk != this.aQf.getStreamType()) {
            cIr();
            this.fZQ = true;
            if (this.sNs == 2) {
                this.fZK = 3;
            } else {
                this.fZK = 2;
            }
            this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
            if (this.fZO == -2 || this.fZO == -1) {
                this.fZQ = false;
                AppMethodBeat.o(4325);
                return false;
            }
            this.sNx = 0;
            this.sNA = 0;
            this.sNC = 1;
            this.sND = 0;
            this.sNE = 0;
            this.sNF = 0;
            this.sNG = 1;
            this.sNI = -1;
            this.sNJ = 0;
            this.sNB = this.fZO;
            this.sNH = this.sNB * this.sNG;
            this.fZO *= this.sNL;
            ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.fZO + "  MinBufSizeInMs:" + (((float) this.sNB) / 16.0f));
            if (this.aQf != null) {
                try {
                    this.aQf.stop();
                } catch (Exception e) {
                    ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", e.getMessage());
                }
                this.aQf.release();
                this.aQf = null;
            }
            ab.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(g.KK().eoY.getMode()), Boolean.valueOf(g.KK().eoY.isSpeakerphoneOn()), Integer.valueOf(mk), Integer.valueOf(this.fZO), Integer.valueOf(this.nSamplerate));
            this.aQf = new e(mk, this.nSamplerate, this.fZK, this.fZO);
            if (this.aQf == null || this.aQf.getState() != 0) {
                ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.aQf != null) {
                    this.fZQ = false;
                    cIp();
                    AppMethodBeat.o(4325);
                    return true;
                }
                this.fZQ = false;
                AppMethodBeat.o(4325);
                return false;
            }
            ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.aQf.release();
            this.aQf = null;
            AppMethodBeat.o(4325);
            return false;
        }
        ab.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        AppMethodBeat.o(4325);
        return false;
    }

    private int mk(boolean z) {
        AppMethodBeat.i(4326);
        int i = 0;
        if (q.etd.epH > 0) {
            i = g.KK().bE(z);
        } else if (q.etd.eqi >= 0) {
            i = q.etd.eqi;
        }
        if (z && q.etd.eqj >= 0) {
            i = q.etd.eqj;
        } else if (!z && q.etd.eqk >= 0) {
            i = q.etd.eqk;
        }
        if (1 == this.iWl) {
            if (q.etd.eqJ >= 0) {
                i = q.etd.eqJ;
            }
            if (z && q.etd.eqK >= 0) {
                i = q.etd.eqK;
            } else if (!z && q.etd.eqL >= 0) {
                i = q.etd.eqL;
            }
        }
        AppMethodBeat.o(4326);
        return i;
    }

    public final int cIo() {
        AppMethodBeat.i(4327);
        if (this.aQf != null) {
            this.aQf.release();
            this.aQf = null;
        }
        this.sNi = false;
        this.sNj = false;
        AppMethodBeat.o(4327);
        return 1;
    }

    public final int G(int i, int i2, int i3, int i4) {
        if (true == this.sNi) {
            return 0;
        }
        this.nSamplerate = i;
        this.sNs = i2;
        this.fZL = i3;
        this.iWl = i4;
        this.fZP = (((this.nSamplerate / 1000) * i2) * this.fZL) * 2;
        this.sNJ = (this.nSamplerate * 60) / 1000;
        return 1;
    }

    public final int cIp() {
        AppMethodBeat.i(4328);
        if (true == this.sNi) {
            AppMethodBeat.o(4328);
            return 1;
        } else if (this.aQf == null) {
            ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            AppMethodBeat.o(4328);
            return 0;
        } else {
            this.sNi = true;
            try {
                this.aQf.play();
            } catch (Exception e) {
                ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", e.getMessage());
            }
            if (this.aQf.getPlayState() != 3) {
                this.sNO = 4;
                ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
                AppMethodBeat.o(4328);
                return 0;
            } else if (this.aQf.getState() == 0) {
                ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
                AppMethodBeat.o(4328);
                return 0;
            } else {
                if (this.sNk) {
                    int i;
                    if (this.cqi || this.cqh != null) {
                        ab.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.cqi);
                        i = -1;
                    } else {
                        this.cqh = new Timer();
                        if (this.cqh == null) {
                            i = -1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        ab.e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
                        AppMethodBeat.o(4328);
                        return 0;
                    }
                    this.cqh.scheduleAtFixedRate(new a(), 0, 20);
                    this.cqi = true;
                }
                this.fZM = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4321);
                        Process.setThreadPriority(-19);
                        ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
                        int i = 0;
                        while (c.this.sNi && c.this.aQf != null) {
                            int playbackHeadPosition;
                            int m;
                            try {
                                playbackHeadPosition = c.this.aQf.getPlaybackHeadPosition();
                            } catch (Exception e) {
                                ab.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", e);
                                c.this.sNO = 7;
                                playbackHeadPosition = 0;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            c.this.sNA = c.this.sNx - playbackHeadPosition;
                            if (c.this.sNC == 1) {
                                c.this.sND = playbackHeadPosition;
                                c.this.sNE = currentTimeMillis;
                                c.this.sNF = currentTimeMillis;
                                c.this.sNC = 0;
                                c.this.sNK = currentTimeMillis;
                            } else {
                                m = playbackHeadPosition - c.this.sND;
                                if (m > c.this.sNI) {
                                    c.this.sNI = m;
                                } else {
                                    c.this.sNI = (int) (((((float) c.this.sNI) * 49999.0f) / 50000.0f) + (((float) m) / 50000.0f));
                                }
                                c.this.sNK = currentTimeMillis;
                                if (c.this.sNA == 0) {
                                    c.this.sNH = c.this.sNH + c.this.sNB;
                                } else if (currentTimeMillis > c.this.sNF + 5000) {
                                    c.this.sNF = currentTimeMillis;
                                    if (c.this.sNI < (c.this.sNH >> 1)) {
                                        c.this.sNH = c.this.sNH - (c.this.sNB >> 2);
                                    }
                                    if (c.this.sNI > c.this.sNH) {
                                        c.this.sNH = c.this.sNI;
                                    }
                                }
                                if (c.this.sNH < c.this.sNJ) {
                                    c.this.sNH = c.this.sNJ;
                                }
                                if (c.this.sNH < c.this.sNB) {
                                    c.this.sNH = c.this.sNB;
                                }
                                if (m > 0) {
                                    c.this.sND = playbackHeadPosition;
                                }
                            }
                            if (playbackHeadPosition != 0 && c.this.sNk) {
                                c.this.sNw = 1;
                            }
                            if (c.this.sNt != null) {
                                c.this.sNM = c.this.sNM + c.this.fZP;
                                if (c.this.sNw == 0) {
                                    playbackHeadPosition = c.this.sNt.N(c.this.sNq, c.this.fZP);
                                } else {
                                    System.currentTimeMillis();
                                    if (c.this.sNz >= c.this.fZP) {
                                        synchronized (c.this.sNN) {
                                            try {
                                                System.arraycopy(c.this.sNo, 0, c.this.sNq, 0, c.this.fZP);
                                                m = c.this.sNz - c.this.fZP;
                                                System.arraycopy(c.this.sNo, c.this.fZP, c.this.sNp, 0, m);
                                                System.arraycopy(c.this.sNp, 0, c.this.sNo, 0, m);
                                                c.this.sNz = c.this.sNz - c.this.fZP;
                                            } catch (Throwable th) {
                                                AppMethodBeat.o(4321);
                                            }
                                        }
                                        playbackHeadPosition = 0;
                                    } else if (c.this.sNA >= (c.this.nSamplerate * 5) / 1000 || c.this.sNQ != 0) {
                                        com.tencent.mm.plugin.voip.a.a.GG(2);
                                    } else {
                                        c.this.sNR = 1;
                                        playbackHeadPosition = c.this.sNt.N(c.this.sNq, c.this.fZP);
                                        c.this.sNR = 0;
                                    }
                                }
                                if (playbackHeadPosition < 0) {
                                    com.tencent.mm.plugin.voip.a.a.GG(5);
                                    ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(playbackHeadPosition)));
                                } else if (c.this.fZQ) {
                                    ab.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + c.this.fZQ);
                                    com.tencent.mm.plugin.voip.a.a.GG(10);
                                } else {
                                    c.this.sNE = currentTimeMillis;
                                    if (c.this.fZO < c.this.fZP) {
                                        System.arraycopy(c.this.sNq, 0, c.this.sNn, i, c.this.fZO - i);
                                        playbackHeadPosition = c.this.aQf.write(c.this.sNn, 0, c.this.sNn.length);
                                        if (playbackHeadPosition < 0) {
                                            c.j(c.this, playbackHeadPosition);
                                            ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(playbackHeadPosition)));
                                        }
                                        c.this.sNx = c.this.sNx + (c.this.sNn.length >> 1);
                                        i = c.this.fZO - i;
                                        playbackHeadPosition = c.this.fZP - i;
                                        while (playbackHeadPosition >= c.this.fZO) {
                                            c.this.aQf.write(c.this.sNq, i, c.this.fZO);
                                            i += c.this.fZO;
                                            playbackHeadPosition -= c.this.fZO;
                                            c.this.sNx = c.this.sNx + (c.this.fZO >> 1);
                                        }
                                        System.arraycopy(c.this.sNq, i, c.this.sNn, 0, playbackHeadPosition);
                                        i = playbackHeadPosition;
                                    } else if (!c.this.fZQ) {
                                        playbackHeadPosition = c.this.aQf.write(c.this.sNq, 0, c.this.fZP);
                                        if (playbackHeadPosition < 0) {
                                            c.j(c.this, playbackHeadPosition);
                                            ab.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(playbackHeadPosition)));
                                        }
                                        c.this.sNx = c.this.sNx + (c.this.fZP >> 1);
                                    }
                                }
                            } else {
                                com.tencent.mm.plugin.voip.a.a.GG(10);
                            }
                        }
                        AppMethodBeat.o(4321);
                    }
                };
                d.f(this.fZM, "AudioPlayer_play");
                AppMethodBeat.o(4328);
                return 1;
            }
        }
    }

    public final int cIq() {
        int i = 0;
        AppMethodBeat.i(4329);
        if (this.nSamplerate == 0) {
            ab.e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
            AppMethodBeat.o(4329);
            return i;
        } else if (this.aQf == null) {
            ab.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.sNB + ",nSamplerate:" + this.nSamplerate);
            i = (this.sNB * 1000) / this.nSamplerate;
            AppMethodBeat.o(4329);
            return i;
        } else if (!this.sNi || this.aQf.getState() == 0) {
            i = (this.sNB * 1000) / this.nSamplerate;
            AppMethodBeat.o(4329);
            return i;
        } else {
            try {
                i = ((this.sNx - this.aQf.getPlaybackHeadPosition()) * 1000) / this.nSamplerate;
                AppMethodBeat.o(4329);
                return i;
            } catch (Exception e) {
                ab.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", e.getMessage());
                i = (this.sNB * 1000) / this.nSamplerate;
                AppMethodBeat.o(4329);
                return i;
            }
        }
    }

    public final int cIr() {
        AppMethodBeat.i(4330);
        if (this.cqi && this.cqh != null) {
            this.cqh.cancel();
            this.cqi = false;
        }
        if (this.sNi) {
            this.sNi = false;
            this.sNM = 0;
            try {
                if (this.fZM != null) {
                    try {
                        d.xDG.an(this.fZM);
                    } catch (ExecutionException e) {
                        ab.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
                    }
                }
            } catch (InterruptedException e2) {
                ab.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e2, "", new Object[0]);
            }
            try {
                if (this.aQf != null) {
                    this.aQf.stop();
                    this.aQf.release();
                    ab.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e3) {
                ab.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", e3.getMessage());
            }
            AppMethodBeat.o(4330);
        } else {
            AppMethodBeat.o(4330);
        }
        return 1;
    }

    public final int cIs() {
        AppMethodBeat.i(4331);
        ab.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.sNO);
        int i = this.sNO;
        AppMethodBeat.o(4331);
        return i;
    }

    public final int cIt() {
        AppMethodBeat.i(4332);
        int streamType;
        if (this.aQf != null) {
            streamType = this.aQf.getStreamType();
            AppMethodBeat.o(4332);
            return streamType;
        }
        streamType = mk(true);
        AppMethodBeat.o(4332);
        return streamType;
    }
}
