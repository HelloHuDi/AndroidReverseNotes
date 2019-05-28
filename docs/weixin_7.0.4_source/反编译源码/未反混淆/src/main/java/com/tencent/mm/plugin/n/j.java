package com.tencent.mm.plugin.n;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class j {
    long aOw;
    public long bfi;
    boolean eif;
    public g orH;
    ak orI;
    ak osb;
    ak osc;
    ak osd;
    long ose;
    boolean osf = false;
    public k osg;
    boolean osh = false;
    a osi;
    private a osj = new a() {
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(117892);
            ab.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", j.this.orH.aZm(), Integer.valueOf(message.what), Integer.valueOf(j.this.state), Integer.valueOf(j.this.osg.state));
            boolean yA;
            switch (message.what) {
                case 0:
                    if (j.this.osf && (j.this.eif || j.this.osh)) {
                        j.this.orI.obtainMessage(6).sendToTarget();
                    }
                case 2:
                    int i;
                    if (j.this.state < 2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        AppMethodBeat.o(117892);
                        break;
                    }
                    yA = d.yA(j.this.osg.state);
                    if (j.this.osi != null) {
                        yA &= d.yA(j.this.osi.state);
                    }
                    if (yA) {
                        j.this.setState(2);
                        j.this.orI.obtainMessage(1).sendToTarget();
                    }
                case 7:
                    j.a(j.this);
                    AppMethodBeat.o(117892);
                    break;
                case 9:
                    if (d.yD(j.this.state)) {
                        AppMethodBeat.o(117892);
                        break;
                    } else if (d.yE(j.this.state) || d.yC(j.this.state)) {
                        j.this.setState(9);
                        j.this.orI.obtainMessage(2).sendToTarget();
                        AppMethodBeat.o(117892);
                        break;
                    } else {
                        yA = d.yD(j.this.osg.state);
                        if (j.this.osi != null) {
                            yA &= d.yD(j.this.osi.state);
                        }
                        if (yA) {
                            j.this.setState(9);
                            j.this.orI.obtainMessage(2).sendToTarget();
                        }
                    }
                    break;
            }
            AppMethodBeat.o(117892);
            return false;
        }
    };
    private a osk = new a() {
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(117893);
            switch (message.what) {
                case 1:
                    if (!j.this.osg.prepare()) {
                        j.this.orI.obtainMessage(5, -1, -1).sendToTarget();
                        AppMethodBeat.o(117893);
                        break;
                    }
                    j.this.bfi = j.this.osg.bfi;
                    j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                case 2:
                    g gVar = j.this.orH;
                    long az = bo.az(gVar.orB);
                    if (gVar.orB > 0 && az >= 30) {
                        ab.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", gVar.aZm(), Long.valueOf(gVar.orB), Long.valueOf(az));
                        gVar.orC = 0;
                    }
                    if (d.yD(j.this.osg.state)) {
                        j.this.osd.obtainMessage(9).sendToTarget();
                        j.this.osb.removeMessages(2);
                    } else {
                        int i;
                        int M = j.this.osg.M(j.this.aOw, j.this.ose);
                        if (d.yA(M)) {
                            j.this.osd.obtainMessage(2).sendToTarget();
                        }
                        if (M == 7) {
                            i = 1;
                        } else {
                            boolean i2 = false;
                        }
                        if (i2 != 0) {
                            j.this.osd.obtainMessage(7).sendToTarget();
                            j.this.osb.removeMessages(2);
                        } else if (d.yF(M)) {
                            j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                            j.this.orH.orB = bo.yz();
                        } else {
                            if (j.this.state == 3) {
                                j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), j.this.orH.orC);
                            } else if (j.this.state == 5) {
                                j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else if (j.this.state == 1) {
                                j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else if (j.this.state == 0) {
                                j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else if (j.this.state == 6) {
                                j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else {
                                j.this.osb.removeMessages(2);
                            }
                            j.this.orH.orB = bo.yz();
                        }
                    }
                    AppMethodBeat.o(117893);
                    break;
                case 3:
                    j.this.yJ(3);
                    j.this.osg.start();
                    j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                    AppMethodBeat.o(117893);
                    break;
                case 4:
                    j.this.yJ(4);
                    j.a(j.this, j.this.osb, SystemClock.elapsedRealtime(), 0);
                    j.this.osg.pause();
                    AppMethodBeat.o(117893);
                    break;
                case 7:
                    j.this.osg.release();
                    j.this.osf = true;
                    j.this.osd.obtainMessage(0).sendToTarget();
                    AppMethodBeat.o(117893);
                    break;
            }
            AppMethodBeat.o(117893);
            return false;
        }
    };
    private a osl = new a() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(117894);
            if (j.this.osi == null) {
                AppMethodBeat.o(117894);
            } else {
                switch (message.what) {
                    case 1:
                        if (!j.this.osi.prepare()) {
                            ab.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", j.this.orH.aZm());
                            j.this.osi.release();
                            j.this.osh = true;
                            j.this.osi = null;
                        }
                        j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!d.yD(j.this.osi.state)) {
                            if (d.yA(j.this.osi.M(j.this.aOw, j.this.ose))) {
                                j.this.osd.sendMessageDelayed(j.this.osd.obtainMessage(2), 10);
                            }
                            if (j.this.state != 3) {
                                if (j.this.state != 5) {
                                    if (j.this.state != 1) {
                                        if (j.this.state != 0) {
                                            j.this.osc.removeMessages(2);
                                            break;
                                        }
                                        j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                    j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                                j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), 0);
                                break;
                            }
                            j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), j.this.orH.orC);
                            break;
                        }
                        j.this.osd.obtainMessage(9).sendToTarget();
                        j.this.osc.removeMessages(2);
                        break;
                    case 3:
                        j.this.osi.start();
                        j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        j.a(j.this, j.this.osc, SystemClock.elapsedRealtime(), 0);
                        j.this.osi.pause();
                        break;
                    case 7:
                        j.this.osi.release();
                        j.this.osh = true;
                        j.this.osd.obtainMessage(0).sendToTarget();
                        break;
                }
                AppMethodBeat.o(117894);
            }
            return false;
        }
    };
    int state;

    static /* synthetic */ void a(j jVar, ak akVar, long j, long j2) {
        AppMethodBeat.i(117907);
        jVar.a(akVar, j, j2);
        AppMethodBeat.o(117907);
    }

    public j(ak akVar, Looper looper, Looper looper2, Looper looper3) {
        AppMethodBeat.i(117895);
        this.orI = akVar;
        this.eif = false;
        this.orH = new g(this.eif);
        this.osd = new ak(looper, this.osj);
        this.osg = new k(this.orH, this.orI);
        this.osb = new ak(looper2, this.osk);
        if (looper3 != null) {
            this.osi = new a(this.orH, this.orI);
            this.osc = new ak(looper3, this.osl);
        }
        AppMethodBeat.o(117895);
    }

    public final void bPc() {
        AppMethodBeat.i(117896);
        ab.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", this.orH.aZm(), Long.valueOf(this.orH.orz));
        if (this.osg != null) {
            this.osg.N(this.orH.orz, -1);
            this.osg.bOY();
            this.osg.orL = 0;
        }
        AppMethodBeat.o(117896);
    }

    public final void bPd() {
        AppMethodBeat.i(117897);
        if (this.osg != null) {
            ab.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", this.orH.aZm());
            this.osg.setState(10);
            a(this.osb, SystemClock.elapsedRealtime(), 0);
        }
        AppMethodBeat.o(117897);
    }

    public final void start() {
        AppMethodBeat.i(117898);
        setState(3);
        this.osb.obtainMessage(3).sendToTarget();
        if (this.osi != null) {
            this.osc.obtainMessage(3).sendToTarget();
        }
        AppMethodBeat.o(117898);
    }

    public final void pause() {
        AppMethodBeat.i(117899);
        setState(4);
        this.osb.obtainMessage(4).sendToTarget();
        if (this.osi != null) {
            this.osc.obtainMessage(4).sendToTarget();
        }
        AppMethodBeat.o(117899);
    }

    public final void yI(int i) {
        AppMethodBeat.i(117900);
        ab.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", this.orH.aZm(), Integer.valueOf(i), Boolean.TRUE);
        this.osg.pause();
        this.osb.removeMessages(4);
        if (this.osi != null) {
            this.osi.pause();
            this.osc.removeMessages(4);
        }
        if (((long) i) >= this.bfi) {
            ab.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", Integer.valueOf(i), Long.valueOf(this.bfi));
            setState(6);
            this.osd.obtainMessage(9).sendToTarget();
            AppMethodBeat.o(117900);
            return;
        }
        long yH = this.osg.yH(i);
        boolean z = yH >= 0 && yH < ((long) i);
        ab.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", this.orH.aZm(), Boolean.valueOf(z), Long.valueOf(yH), Integer.valueOf(i));
        this.osg.setState(6);
        setState(6);
        if (z) {
            this.orH.ory = (long) i;
        } else {
            this.orH.ory = yH;
        }
        yJ(6);
        a(this.osb, SystemClock.elapsedRealtime(), 0);
        AppMethodBeat.o(117900);
    }

    public final void stop() {
        AppMethodBeat.i(117901);
        setState(8);
        AppMethodBeat.o(117901);
    }

    public final void release() {
        AppMethodBeat.i(117902);
        setState(9);
        this.osd.removeMessages(2);
        this.osd.removeMessages(9);
        this.osb.removeMessages(1);
        this.osb.removeMessages(2);
        this.osb.removeMessages(3);
        this.osb.removeMessages(4);
        this.osb.removeMessages(6);
        this.osb.removeCallbacksAndMessages(null);
        try {
            this.osg.setState(9);
            ab.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", r0.aZm(), Boolean.valueOf(this.osg.osn));
            if (this.osg.osn && d.iX(19)) {
                this.osg.sI();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoPlayerImpl", e, "%s release error %s", this.orH.aZm(), e.toString());
        }
        this.osb.obtainMessage(7).sendToTarget();
        if (this.osc != null) {
            this.osc.removeMessages(1);
            this.osc.removeMessages(2);
            this.osc.removeMessages(3);
            this.osc.removeMessages(4);
            this.osc.removeMessages(6);
            this.osc.obtainMessage(7).sendToTarget();
        }
        g gVar = this.orH;
        gVar.cTh = 0;
        gVar.orx = 0;
        gVar.ory = -1;
        gVar.aOw = 0;
        gVar.orz = 0;
        gVar.orA = 0;
        AppMethodBeat.o(117902);
    }

    /* Access modifiers changed, original: protected|final */
    public final void setState(int i) {
        AppMethodBeat.i(117903);
        ab.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", this.orH.aZm(), Integer.valueOf(this.state), Integer.valueOf(i), bo.dpG());
        this.state = i;
        this.orH.orB = 0;
        AppMethodBeat.o(117903);
    }

    /* Access modifiers changed, original: final */
    public final void yJ(int i) {
        AppMethodBeat.i(117904);
        ab.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", this.orH.aZm(), Integer.valueOf(i), Long.valueOf(this.orH.cTh), Long.valueOf(this.orH.orx), Long.valueOf(this.orH.aOw));
        g gVar;
        switch (i) {
            case 3:
                if (this.orH.orx > 0) {
                    gVar = this.orH;
                    gVar.aOw += this.orH.orx - this.orH.cTh;
                    this.orH.orx = 0;
                }
                this.orH.cTh = SystemClock.elapsedRealtime();
                break;
            case 4:
                if (this.orH.cTh > 0) {
                    this.orH.orx = SystemClock.elapsedRealtime();
                    break;
                }
                this.orH.orx = 0;
                break;
            case 5:
                this.orH.aOw = this.orH.ory;
                this.orH.cTh = SystemClock.elapsedRealtime();
                this.orH.orx = 0;
                gVar = this.orH;
                this.orH.orA = 0;
                gVar.orz = 0;
                break;
            case 6:
                this.orH.aOw = this.orH.ory;
                gVar = this.orH;
                this.orH.orx = 0;
                gVar.cTh = 0;
                gVar = this.orH;
                this.orH.orA = 0;
                gVar.orz = 0;
                break;
            case 7:
                this.orH.aOw = this.orH.ory;
                gVar = this.orH;
                this.orH.orx = 0;
                gVar.cTh = 0;
                break;
        }
        this.ose = this.orH.cTh;
        this.aOw = this.orH.aOw;
        ab.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", this.orH.aZm(), Integer.valueOf(i), Long.valueOf(this.ose), Long.valueOf(this.aOw));
        AppMethodBeat.o(117904);
    }

    private void a(ak akVar, long j, long j2) {
        AppMethodBeat.i(117905);
        if (d.yD(this.state)) {
            AppMethodBeat.o(117905);
            return;
        }
        try {
            Thread thread = akVar.getLooper().getThread();
            if (!(thread == null || thread.isAlive())) {
                AppMethodBeat.o(117905);
                return;
            }
        } catch (Exception e) {
        }
        akVar.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            akVar.sendEmptyMessage(2);
            AppMethodBeat.o(117905);
            return;
        }
        akVar.sendEmptyMessageDelayed(2, elapsedRealtime);
        AppMethodBeat.o(117905);
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(117906);
        ab.i("MicroMsg.VideoPlayerImpl", "%s seek done", jVar.orH.aZm());
        jVar.osg.setState(5);
        if (jVar.osi != null) {
            jVar.orH.orA = jVar.osi.yH((int) jVar.orH.ory);
            jVar.osi.setState(5);
        }
        jVar.yJ(7);
        jVar.setState(4);
        jVar.orI.obtainMessage(3, 0, 0).sendToTarget();
        jVar.orH.orz = jVar.orH.ory * 1000;
        jVar.orH.ory = -1;
        AppMethodBeat.o(117906);
    }
}
