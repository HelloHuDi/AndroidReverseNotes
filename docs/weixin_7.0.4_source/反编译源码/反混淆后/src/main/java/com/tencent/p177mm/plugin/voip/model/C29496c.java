package com.tencent.p177mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C18171e;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/* renamed from: com.tencent.mm.plugin.voip.model.c */
public final class C29496c {
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
    C14047k sNl = null;
    private int sNm = 0;
    private byte[] sNn = null;
    private byte[] sNo = null;
    private byte[] sNp = null;
    private byte[] sNq = null;
    private byte[] sNr = null;
    private int sNs = 0;
    public C29495b sNt = null;
    private int sNu = 1;
    private int sNv = 1;
    private int sNw = 0;
    private int sNx = 0;
    private int sNy = 0;
    private int sNz = 0;

    /* renamed from: com.tencent.mm.plugin.voip.model.c$1 */
    class C140431 implements Runnable {
        C140431() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4321);
            Process.setThreadPriority(-19);
            C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
            int i = 0;
            while (C29496c.this.sNi && C29496c.this.aQf != null) {
                int playbackHeadPosition;
                int m;
                try {
                    playbackHeadPosition = C29496c.this.aQf.getPlaybackHeadPosition();
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", e);
                    C29496c.this.sNO = 7;
                    playbackHeadPosition = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                C29496c.this.sNA = C29496c.this.sNx - playbackHeadPosition;
                if (C29496c.this.sNC == 1) {
                    C29496c.this.sND = playbackHeadPosition;
                    C29496c.this.sNE = currentTimeMillis;
                    C29496c.this.sNF = currentTimeMillis;
                    C29496c.this.sNC = 0;
                    C29496c.this.sNK = currentTimeMillis;
                } else {
                    m = playbackHeadPosition - C29496c.this.sND;
                    if (m > C29496c.this.sNI) {
                        C29496c.this.sNI = m;
                    } else {
                        C29496c.this.sNI = (int) (((((float) C29496c.this.sNI) * 49999.0f) / 50000.0f) + (((float) m) / 50000.0f));
                    }
                    C29496c.this.sNK = currentTimeMillis;
                    if (C29496c.this.sNA == 0) {
                        C29496c.this.sNH = C29496c.this.sNH + C29496c.this.sNB;
                    } else if (currentTimeMillis > C29496c.this.sNF + 5000) {
                        C29496c.this.sNF = currentTimeMillis;
                        if (C29496c.this.sNI < (C29496c.this.sNH >> 1)) {
                            C29496c.this.sNH = C29496c.this.sNH - (C29496c.this.sNB >> 2);
                        }
                        if (C29496c.this.sNI > C29496c.this.sNH) {
                            C29496c.this.sNH = C29496c.this.sNI;
                        }
                    }
                    if (C29496c.this.sNH < C29496c.this.sNJ) {
                        C29496c.this.sNH = C29496c.this.sNJ;
                    }
                    if (C29496c.this.sNH < C29496c.this.sNB) {
                        C29496c.this.sNH = C29496c.this.sNB;
                    }
                    if (m > 0) {
                        C29496c.this.sND = playbackHeadPosition;
                    }
                }
                if (playbackHeadPosition != 0 && C29496c.this.sNk) {
                    C29496c.this.sNw = 1;
                }
                if (C29496c.this.sNt != null) {
                    C29496c.this.sNM = C29496c.this.sNM + C29496c.this.fZP;
                    if (C29496c.this.sNw == 0) {
                        playbackHeadPosition = C29496c.this.sNt.mo45518N(C29496c.this.sNq, C29496c.this.fZP);
                    } else {
                        System.currentTimeMillis();
                        if (C29496c.this.sNz >= C29496c.this.fZP) {
                            synchronized (C29496c.this.sNN) {
                                try {
                                    System.arraycopy(C29496c.this.sNo, 0, C29496c.this.sNq, 0, C29496c.this.fZP);
                                    m = C29496c.this.sNz - C29496c.this.fZP;
                                    System.arraycopy(C29496c.this.sNo, C29496c.this.fZP, C29496c.this.sNp, 0, m);
                                    System.arraycopy(C29496c.this.sNp, 0, C29496c.this.sNo, 0, m);
                                    C29496c.this.sNz = C29496c.this.sNz - C29496c.this.fZP;
                                } catch (Throwable th) {
                                    AppMethodBeat.m2505o(4321);
                                }
                            }
                            playbackHeadPosition = 0;
                        } else if (C29496c.this.sNA >= (C29496c.this.nSamplerate * 5) / 1000 || C29496c.this.sNQ != 0) {
                            C46317a.m86981GG(2);
                        } else {
                            C29496c.this.sNR = 1;
                            playbackHeadPosition = C29496c.this.sNt.mo45518N(C29496c.this.sNq, C29496c.this.fZP);
                            C29496c.this.sNR = 0;
                        }
                    }
                    if (playbackHeadPosition < 0) {
                        C46317a.m86981GG(5);
                        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(playbackHeadPosition)));
                    } else if (C29496c.this.fZQ) {
                        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "isSwitching " + C29496c.this.fZQ);
                        C46317a.m86981GG(10);
                    } else {
                        C29496c.this.sNE = currentTimeMillis;
                        if (C29496c.this.fZO < C29496c.this.fZP) {
                            System.arraycopy(C29496c.this.sNq, 0, C29496c.this.sNn, i, C29496c.this.fZO - i);
                            playbackHeadPosition = C29496c.this.aQf.write(C29496c.this.sNn, 0, C29496c.this.sNn.length);
                            if (playbackHeadPosition < 0) {
                                C29496c.m46832j(C29496c.this, playbackHeadPosition);
                                C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(playbackHeadPosition)));
                            }
                            C29496c.this.sNx = C29496c.this.sNx + (C29496c.this.sNn.length >> 1);
                            i = C29496c.this.fZO - i;
                            playbackHeadPosition = C29496c.this.fZP - i;
                            while (playbackHeadPosition >= C29496c.this.fZO) {
                                C29496c.this.aQf.write(C29496c.this.sNq, i, C29496c.this.fZO);
                                i += C29496c.this.fZO;
                                playbackHeadPosition -= C29496c.this.fZO;
                                C29496c.this.sNx = C29496c.this.sNx + (C29496c.this.fZO >> 1);
                            }
                            System.arraycopy(C29496c.this.sNq, i, C29496c.this.sNn, 0, playbackHeadPosition);
                            i = playbackHeadPosition;
                        } else if (!C29496c.this.fZQ) {
                            playbackHeadPosition = C29496c.this.aQf.write(C29496c.this.sNq, 0, C29496c.this.fZP);
                            if (playbackHeadPosition < 0) {
                                C29496c.m46832j(C29496c.this, playbackHeadPosition);
                                C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :".concat(String.valueOf(playbackHeadPosition)));
                            }
                            C29496c.this.sNx = C29496c.this.sNx + (C29496c.this.fZP >> 1);
                        }
                    }
                } else {
                    C46317a.m86981GG(10);
                }
            }
            AppMethodBeat.m2505o(4321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.model.c$a */
    class C29497a extends TimerTask {
        C29497a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4322);
            System.currentTimeMillis();
            if (C29496c.this.sNw == 1 && C29496c.this.sNi) {
                System.currentTimeMillis();
                if (C29496c.this.sNz + C29496c.this.fZP < C29496c.this.sNm && C29496c.this.sNR == 0) {
                    C29496c.this.sNQ = 1;
                    int N = C29496c.this.sNt.mo45518N(C29496c.this.sNr, C29496c.this.fZP);
                    C29496c.this.sNQ = 0;
                    if (N < 0) {
                        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :".concat(String.valueOf(N)));
                        AppMethodBeat.m2505o(4322);
                        return;
                    }
                    synchronized (C29496c.this.sNN) {
                        try {
                            System.arraycopy(C29496c.this.sNr, 0, C29496c.this.sNo, C29496c.this.sNz, C29496c.this.fZP);
                            C29496c.this.sNz = C29496c.this.sNz + C29496c.this.fZP;
                            C29496c.this.sNy = C29496c.this.sNy + (C29496c.this.fZP >> 1);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(4322);
                        }
                    }
                    return;
                }
            }
            AppMethodBeat.m2505o(4322);
        }
    }

    public C29496c() {
        AppMethodBeat.m2504i(4323);
        AppMethodBeat.m2505o(4323);
    }

    /* renamed from: j */
    static /* synthetic */ void m46832j(C29496c c29496c, int i) {
        if (c29496c.sNP != -1 && i < 0) {
            c29496c.sNP++;
            if (c29496c.sNP >= 50) {
                c29496c.sNO = 5;
                c29496c.sNP = -1;
            }
        }
    }

    public final int cIn() {
        return (this.sNM / this.fZP) * this.fZL;
    }

    /* renamed from: x */
    public final int mo47759x(Context context, boolean z) {
        AppMethodBeat.m2504i(4324);
        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.sNs == 2) {
            this.fZK = 3;
        } else {
            this.fZK = 2;
        }
        this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
        if (this.fZO == -2 || this.fZO == -1) {
            this.sNO = 1;
            AppMethodBeat.m2505o(4324);
            return -1;
        }
        this.sNB = this.fZO;
        this.sNH = this.sNB * this.sNG;
        this.fZO *= this.sNL;
        float f = ((float) (this.sNB >> 1)) / ((float) this.nSamplerate);
        int Lw = C45290m.m83509Lw();
        int i = C1427q.etd.eqz;
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            C4990ab.m7416i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: ".concat(String.valueOf(i)));
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.iWl != 0) {
            i = 0;
        }
        this.sNk = i != 0;
        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.fZO + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.sNk);
        int mk = m46837mk(z);
        try {
            if (this.aQf != null) {
                try {
                    this.aQf.release();
                } catch (Exception e) {
                }
            }
            this.aQf = new C18171e(mk, this.nSamplerate, this.fZK, this.fZO);
        } catch (Exception e2) {
            C4990ab.m7421w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", e2);
            this.sNO = 6;
        }
        if (this.aQf == null || this.aQf.getState() == 0) {
            this.sNO = 2;
            C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.aQf != null) {
                this.aQf.release();
            }
            if (mk == 0) {
                this.aQf = new C18171e(3, this.nSamplerate, this.fZK, this.fZO);
            } else {
                this.aQf = new C18171e(0, this.nSamplerate, this.fZK, this.fZO);
            }
        }
        if (this.aQf == null) {
            this.sNO = 3;
            C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            AppMethodBeat.m2505o(4324);
            return -1;
        } else if (this.aQf.getState() == 0) {
            this.sNO = 3;
            C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.aQf.release();
            this.aQf = null;
            AppMethodBeat.m2505o(4324);
            return -1;
        } else {
            this.sNn = new byte[this.fZO];
            if (this.sNn == null) {
                C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                AppMethodBeat.m2505o(4324);
                return -1;
            }
            this.sNq = new byte[this.fZP];
            if (this.sNq == null) {
                C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                AppMethodBeat.m2505o(4324);
                return -1;
            }
            if (this.sNk) {
                this.sNm = this.fZO;
                this.sNo = new byte[this.sNm];
                if (this.sNo == null) {
                    C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    AppMethodBeat.m2505o(4324);
                    return -1;
                }
                this.sNp = new byte[this.sNm];
                if (this.sNp == null) {
                    C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    AppMethodBeat.m2505o(4324);
                    return -1;
                }
                this.sNr = new byte[this.fZP];
                if (this.sNr == null) {
                    C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    AppMethodBeat.m2505o(4324);
                    return -1;
                }
            }
            this.sNi = false;
            this.sNj = false;
            C4990ab.m7417i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(C1407g.m2946KK().eoY.getMode()), Boolean.valueOf(C1407g.m2946KK().eoY.isSpeakerphoneOn()), Integer.valueOf(mk), Integer.valueOf(this.fZO), Integer.valueOf(this.nSamplerate));
            i = (this.fZO * 1000) / (this.nSamplerate * 2);
            AppMethodBeat.m2505o(4324);
            return i;
        }
    }

    /* renamed from: mj */
    public final boolean mo47758mj(boolean z) {
        AppMethodBeat.m2504i(4325);
        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int mk = m46837mk(z);
        if (C1407g.m2946KK().mo4819KP()) {
            mk = 0;
        }
        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + mk);
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
                AppMethodBeat.m2505o(4325);
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
            C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.fZO + "  MinBufSizeInMs:" + (((float) this.sNB) / 16.0f));
            if (this.aQf != null) {
                try {
                    this.aQf.stop();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", e.getMessage());
                }
                this.aQf.release();
                this.aQf = null;
            }
            C4990ab.m7417i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(C1407g.m2946KK().eoY.getMode()), Boolean.valueOf(C1407g.m2946KK().eoY.isSpeakerphoneOn()), Integer.valueOf(mk), Integer.valueOf(this.fZO), Integer.valueOf(this.nSamplerate));
            this.aQf = new C18171e(mk, this.nSamplerate, this.fZK, this.fZO);
            if (this.aQf == null || this.aQf.getState() != 0) {
                C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.aQf != null) {
                    this.fZQ = false;
                    cIp();
                    AppMethodBeat.m2505o(4325);
                    return true;
                }
                this.fZQ = false;
                AppMethodBeat.m2505o(4325);
                return false;
            }
            C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.aQf.release();
            this.aQf = null;
            AppMethodBeat.m2505o(4325);
            return false;
        }
        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        AppMethodBeat.m2505o(4325);
        return false;
    }

    /* renamed from: mk */
    private int m46837mk(boolean z) {
        AppMethodBeat.m2504i(4326);
        int i = 0;
        if (C1427q.etd.epH > 0) {
            i = C1407g.m2946KK().mo4831bE(z);
        } else if (C1427q.etd.eqi >= 0) {
            i = C1427q.etd.eqi;
        }
        if (z && C1427q.etd.eqj >= 0) {
            i = C1427q.etd.eqj;
        } else if (!z && C1427q.etd.eqk >= 0) {
            i = C1427q.etd.eqk;
        }
        if (1 == this.iWl) {
            if (C1427q.etd.eqJ >= 0) {
                i = C1427q.etd.eqJ;
            }
            if (z && C1427q.etd.eqK >= 0) {
                i = C1427q.etd.eqK;
            } else if (!z && C1427q.etd.eqL >= 0) {
                i = C1427q.etd.eqL;
            }
        }
        AppMethodBeat.m2505o(4326);
        return i;
    }

    public final int cIo() {
        AppMethodBeat.m2504i(4327);
        if (this.aQf != null) {
            this.aQf.release();
            this.aQf = null;
        }
        this.sNi = false;
        this.sNj = false;
        AppMethodBeat.m2505o(4327);
        return 1;
    }

    /* renamed from: G */
    public final int mo47750G(int i, int i2, int i3, int i4) {
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
        AppMethodBeat.m2504i(4328);
        if (true == this.sNi) {
            AppMethodBeat.m2505o(4328);
            return 1;
        } else if (this.aQf == null) {
            C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            AppMethodBeat.m2505o(4328);
            return 0;
        } else {
            this.sNi = true;
            try {
                this.aQf.play();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", e.getMessage());
            }
            if (this.aQf.getPlayState() != 3) {
                this.sNO = 4;
                C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
                AppMethodBeat.m2505o(4328);
                return 0;
            } else if (this.aQf.getState() == 0) {
                C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
                AppMethodBeat.m2505o(4328);
                return 0;
            } else {
                if (this.sNk) {
                    int i;
                    if (this.cqi || this.cqh != null) {
                        C4990ab.m7420w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.cqi);
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
                        C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "InitAudioRecTimer failed, error code = -1");
                        AppMethodBeat.m2505o(4328);
                        return 0;
                    }
                    this.cqh.scheduleAtFixedRate(new C29497a(), 0, 20);
                    this.cqi = true;
                }
                this.fZM = new C140431();
                C7305d.m12298f(this.fZM, "AudioPlayer_play");
                AppMethodBeat.m2505o(4328);
                return 1;
            }
        }
    }

    public final int cIq() {
        int i = 0;
        AppMethodBeat.m2504i(4329);
        if (this.nSamplerate == 0) {
            C4990ab.m7412e("MicroMsg.Voip.AudioPlayer", "nSamplerate is no init now  ");
            AppMethodBeat.m2505o(4329);
            return i;
        } else if (this.aQf == null) {
            C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.sNB + ",nSamplerate:" + this.nSamplerate);
            i = (this.sNB * 1000) / this.nSamplerate;
            AppMethodBeat.m2505o(4329);
            return i;
        } else if (!this.sNi || this.aQf.getState() == 0) {
            i = (this.sNB * 1000) / this.nSamplerate;
            AppMethodBeat.m2505o(4329);
            return i;
        } else {
            try {
                i = ((this.sNx - this.aQf.getPlaybackHeadPosition()) * 1000) / this.nSamplerate;
                AppMethodBeat.m2505o(4329);
                return i;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", e.getMessage());
                i = (this.sNB * 1000) / this.nSamplerate;
                AppMethodBeat.m2505o(4329);
                return i;
            }
        }
    }

    public final int cIr() {
        AppMethodBeat.m2504i(4330);
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
                        C7305d.xDG.mo10149an(this.fZM);
                    } catch (ExecutionException e) {
                        C4990ab.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
                    }
                }
            } catch (InterruptedException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e2, "", new Object[0]);
            }
            try {
                if (this.aQf != null) {
                    this.aQf.stop();
                    this.aQf.release();
                    C4990ab.m7416i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e3) {
                C4990ab.m7413e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", e3.getMessage());
            }
            AppMethodBeat.m2505o(4330);
        } else {
            AppMethodBeat.m2505o(4330);
        }
        return 1;
    }

    public final int cIs() {
        AppMethodBeat.m2504i(4331);
        C4990ab.m7410d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.sNO);
        int i = this.sNO;
        AppMethodBeat.m2505o(4331);
        return i;
    }

    public final int cIt() {
        AppMethodBeat.m2504i(4332);
        int streamType;
        if (this.aQf != null) {
            streamType = this.aQf.getStreamType();
            AppMethodBeat.m2505o(4332);
            return streamType;
        }
        streamType = m46837mk(true);
        AppMethodBeat.m2505o(4332);
        return streamType;
    }
}
