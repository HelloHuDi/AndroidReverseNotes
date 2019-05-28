package com.tencent.p177mm.plugin.p468n;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;

/* renamed from: com.tencent.mm.plugin.n.j */
public final class C34603j {
    long aOw;
    public long bfi;
    boolean eif;
    public C3546g orH;
    C7306ak orI;
    C7306ak osb;
    C7306ak osc;
    C7306ak osd;
    long ose;
    boolean osf = false;
    public C46108k osg;
    boolean osh = false;
    C39452a osi;
    private C4998a osj = new C285881();
    private C4998a osk = new C126942();
    private C4998a osl = new C346043();
    int state;

    /* renamed from: com.tencent.mm.plugin.n.j$2 */
    class C126942 implements C4998a {
        C126942() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(117893);
            switch (message.what) {
                case 1:
                    if (!C34603j.this.osg.prepare()) {
                        C34603j.this.orI.obtainMessage(5, -1, -1).sendToTarget();
                        AppMethodBeat.m2505o(117893);
                        break;
                    }
                    C34603j.this.bfi = C34603j.this.osg.bfi;
                    C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                case 2:
                    C3546g c3546g = C34603j.this.orH;
                    long az = C5046bo.m7525az(c3546g.orB);
                    if (c3546g.orB > 0 && az >= 30) {
                        C4990ab.m7421w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", c3546g.aZm(), Long.valueOf(c3546g.orB), Long.valueOf(az));
                        c3546g.orC = 0;
                    }
                    if (C46107d.m86022yD(C34603j.this.osg.state)) {
                        C34603j.this.osd.obtainMessage(9).sendToTarget();
                        C34603j.this.osb.removeMessages(2);
                    } else {
                        int i;
                        int M = C34603j.this.osg.mo24676M(C34603j.this.aOw, C34603j.this.ose);
                        if (C46107d.m86019yA(M)) {
                            C34603j.this.osd.obtainMessage(2).sendToTarget();
                        }
                        if (M == 7) {
                            i = 1;
                        } else {
                            boolean i2 = false;
                        }
                        if (i2 != 0) {
                            C34603j.this.osd.obtainMessage(7).sendToTarget();
                            C34603j.this.osb.removeMessages(2);
                        } else if (C46107d.m86024yF(M)) {
                            C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                            C34603j.this.orH.orB = C5046bo.m7588yz();
                        } else {
                            if (C34603j.this.state == 3) {
                                C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), C34603j.this.orH.orC);
                            } else if (C34603j.this.state == 5) {
                                C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else if (C34603j.this.state == 1) {
                                C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else if (C34603j.this.state == 0) {
                                C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else if (C34603j.this.state == 6) {
                                C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                            } else {
                                C34603j.this.osb.removeMessages(2);
                            }
                            C34603j.this.orH.orB = C5046bo.m7588yz();
                        }
                    }
                    AppMethodBeat.m2505o(117893);
                    break;
                case 3:
                    C34603j.this.mo55195yJ(3);
                    C34603j.this.osg.start();
                    C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                    AppMethodBeat.m2505o(117893);
                    break;
                case 4:
                    C34603j.this.mo55195yJ(4);
                    C34603j.m56741a(C34603j.this, C34603j.this.osb, SystemClock.elapsedRealtime(), 0);
                    C34603j.this.osg.pause();
                    AppMethodBeat.m2505o(117893);
                    break;
                case 7:
                    C34603j.this.osg.release();
                    C34603j.this.osf = true;
                    C34603j.this.osd.obtainMessage(0).sendToTarget();
                    AppMethodBeat.m2505o(117893);
                    break;
            }
            AppMethodBeat.m2505o(117893);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.n.j$1 */
    class C285881 implements C4998a {
        C285881() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(117892);
            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", C34603j.this.orH.aZm(), Integer.valueOf(message.what), Integer.valueOf(C34603j.this.state), Integer.valueOf(C34603j.this.osg.state));
            boolean yA;
            switch (message.what) {
                case 0:
                    if (C34603j.this.osf && (C34603j.this.eif || C34603j.this.osh)) {
                        C34603j.this.orI.obtainMessage(6).sendToTarget();
                    }
                case 2:
                    int i;
                    if (C34603j.this.state < 2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        AppMethodBeat.m2505o(117892);
                        break;
                    }
                    yA = C46107d.m86019yA(C34603j.this.osg.state);
                    if (C34603j.this.osi != null) {
                        yA &= C46107d.m86019yA(C34603j.this.osi.state);
                    }
                    if (yA) {
                        C34603j.this.setState(2);
                        C34603j.this.orI.obtainMessage(1).sendToTarget();
                    }
                case 7:
                    C34603j.m56740a(C34603j.this);
                    AppMethodBeat.m2505o(117892);
                    break;
                case 9:
                    if (C46107d.m86022yD(C34603j.this.state)) {
                        AppMethodBeat.m2505o(117892);
                        break;
                    } else if (C46107d.m86023yE(C34603j.this.state) || C46107d.m86021yC(C34603j.this.state)) {
                        C34603j.this.setState(9);
                        C34603j.this.orI.obtainMessage(2).sendToTarget();
                        AppMethodBeat.m2505o(117892);
                        break;
                    } else {
                        yA = C46107d.m86022yD(C34603j.this.osg.state);
                        if (C34603j.this.osi != null) {
                            yA &= C46107d.m86022yD(C34603j.this.osi.state);
                        }
                        if (yA) {
                            C34603j.this.setState(9);
                            C34603j.this.orI.obtainMessage(2).sendToTarget();
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(117892);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.n.j$3 */
    class C346043 implements C4998a {
        C346043() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(117894);
            if (C34603j.this.osi == null) {
                AppMethodBeat.m2505o(117894);
            } else {
                switch (message.what) {
                    case 1:
                        if (!C34603j.this.osi.prepare()) {
                            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", C34603j.this.orH.aZm());
                            C34603j.this.osi.release();
                            C34603j.this.osh = true;
                            C34603j.this.osi = null;
                        }
                        C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!C46107d.m86022yD(C34603j.this.osi.state)) {
                            if (C46107d.m86019yA(C34603j.this.osi.mo24676M(C34603j.this.aOw, C34603j.this.ose))) {
                                C34603j.this.osd.sendMessageDelayed(C34603j.this.osd.obtainMessage(2), 10);
                            }
                            if (C34603j.this.state != 3) {
                                if (C34603j.this.state != 5) {
                                    if (C34603j.this.state != 1) {
                                        if (C34603j.this.state != 0) {
                                            C34603j.this.osc.removeMessages(2);
                                            break;
                                        }
                                        C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                    C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                                C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), 0);
                                break;
                            }
                            C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), C34603j.this.orH.orC);
                            break;
                        }
                        C34603j.this.osd.obtainMessage(9).sendToTarget();
                        C34603j.this.osc.removeMessages(2);
                        break;
                    case 3:
                        C34603j.this.osi.start();
                        C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        C34603j.m56741a(C34603j.this, C34603j.this.osc, SystemClock.elapsedRealtime(), 0);
                        C34603j.this.osi.pause();
                        break;
                    case 7:
                        C34603j.this.osi.release();
                        C34603j.this.osh = true;
                        C34603j.this.osd.obtainMessage(0).sendToTarget();
                        break;
                }
                AppMethodBeat.m2505o(117894);
            }
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m56741a(C34603j c34603j, C7306ak c7306ak, long j, long j2) {
        AppMethodBeat.m2504i(117907);
        c34603j.m56742a(c7306ak, j, j2);
        AppMethodBeat.m2505o(117907);
    }

    public C34603j(C7306ak c7306ak, Looper looper, Looper looper2, Looper looper3) {
        AppMethodBeat.m2504i(117895);
        this.orI = c7306ak;
        this.eif = false;
        this.orH = new C3546g(this.eif);
        this.osd = new C7306ak(looper, this.osj);
        this.osg = new C46108k(this.orH, this.orI);
        this.osb = new C7306ak(looper2, this.osk);
        if (looper3 != null) {
            this.osi = new C39452a(this.orH, this.orI);
            this.osc = new C7306ak(looper3, this.osl);
        }
        AppMethodBeat.m2505o(117895);
    }

    public final void bPc() {
        AppMethodBeat.m2504i(117896);
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", this.orH.aZm(), Long.valueOf(this.orH.orz));
        if (this.osg != null) {
            this.osg.mo24677N(this.orH.orz, -1);
            this.osg.bOY();
            this.osg.orL = 0;
        }
        AppMethodBeat.m2505o(117896);
    }

    public final void bPd() {
        AppMethodBeat.m2504i(117897);
        if (this.osg != null) {
            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s player flush surface", this.orH.aZm());
            this.osg.setState(10);
            m56742a(this.osb, SystemClock.elapsedRealtime(), 0);
        }
        AppMethodBeat.m2505o(117897);
    }

    public final void start() {
        AppMethodBeat.m2504i(117898);
        setState(3);
        this.osb.obtainMessage(3).sendToTarget();
        if (this.osi != null) {
            this.osc.obtainMessage(3).sendToTarget();
        }
        AppMethodBeat.m2505o(117898);
    }

    public final void pause() {
        AppMethodBeat.m2504i(117899);
        setState(4);
        this.osb.obtainMessage(4).sendToTarget();
        if (this.osi != null) {
            this.osc.obtainMessage(4).sendToTarget();
        }
        AppMethodBeat.m2505o(117899);
    }

    /* renamed from: yI */
    public final void mo55194yI(int i) {
        AppMethodBeat.m2504i(117900);
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", this.orH.aZm(), Integer.valueOf(i), Boolean.TRUE);
        this.osg.pause();
        this.osb.removeMessages(4);
        if (this.osi != null) {
            this.osi.pause();
            this.osc.removeMessages(4);
        }
        if (((long) i) >= this.bfi) {
            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", Integer.valueOf(i), Long.valueOf(this.bfi));
            setState(6);
            this.osd.obtainMessage(9).sendToTarget();
            AppMethodBeat.m2505o(117900);
            return;
        }
        long yH = this.osg.mo24697yH(i);
        boolean z = yH >= 0 && yH < ((long) i);
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", this.orH.aZm(), Boolean.valueOf(z), Long.valueOf(yH), Integer.valueOf(i));
        this.osg.setState(6);
        setState(6);
        if (z) {
            this.orH.ory = (long) i;
        } else {
            this.orH.ory = yH;
        }
        mo55195yJ(6);
        m56742a(this.osb, SystemClock.elapsedRealtime(), 0);
        AppMethodBeat.m2505o(117900);
    }

    public final void stop() {
        AppMethodBeat.m2504i(117901);
        setState(8);
        AppMethodBeat.m2505o(117901);
    }

    public final void release() {
        AppMethodBeat.m2504i(117902);
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
            C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", r0.aZm(), Boolean.valueOf(this.osg.osn));
            if (this.osg.osn && C1443d.m3069iX(19)) {
                this.osg.mo24692sI();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoPlayerImpl", e, "%s release error %s", this.orH.aZm(), e.toString());
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
        C3546g c3546g = this.orH;
        c3546g.cTh = 0;
        c3546g.orx = 0;
        c3546g.ory = -1;
        c3546g.aOw = 0;
        c3546g.orz = 0;
        c3546g.orA = 0;
        AppMethodBeat.m2505o(117902);
    }

    /* Access modifiers changed, original: protected|final */
    public final void setState(int i) {
        AppMethodBeat.m2504i(117903);
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", this.orH.aZm(), Integer.valueOf(this.state), Integer.valueOf(i), C5046bo.dpG());
        this.state = i;
        this.orH.orB = 0;
        AppMethodBeat.m2505o(117903);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: yJ */
    public final void mo55195yJ(int i) {
        AppMethodBeat.m2504i(117904);
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", this.orH.aZm(), Integer.valueOf(i), Long.valueOf(this.orH.cTh), Long.valueOf(this.orH.orx), Long.valueOf(this.orH.aOw));
        C3546g c3546g;
        switch (i) {
            case 3:
                if (this.orH.orx > 0) {
                    c3546g = this.orH;
                    c3546g.aOw += this.orH.orx - this.orH.cTh;
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
                c3546g = this.orH;
                this.orH.orA = 0;
                c3546g.orz = 0;
                break;
            case 6:
                this.orH.aOw = this.orH.ory;
                c3546g = this.orH;
                this.orH.orx = 0;
                c3546g.cTh = 0;
                c3546g = this.orH;
                this.orH.orA = 0;
                c3546g.orz = 0;
                break;
            case 7:
                this.orH.aOw = this.orH.ory;
                c3546g = this.orH;
                this.orH.orx = 0;
                c3546g.cTh = 0;
                break;
        }
        this.ose = this.orH.cTh;
        this.aOw = this.orH.aOw;
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", this.orH.aZm(), Integer.valueOf(i), Long.valueOf(this.ose), Long.valueOf(this.aOw));
        AppMethodBeat.m2505o(117904);
    }

    /* renamed from: a */
    private void m56742a(C7306ak c7306ak, long j, long j2) {
        AppMethodBeat.m2504i(117905);
        if (C46107d.m86022yD(this.state)) {
            AppMethodBeat.m2505o(117905);
            return;
        }
        try {
            Thread thread = c7306ak.getLooper().getThread();
            if (!(thread == null || thread.isAlive())) {
                AppMethodBeat.m2505o(117905);
                return;
            }
        } catch (Exception e) {
        }
        c7306ak.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            c7306ak.sendEmptyMessage(2);
            AppMethodBeat.m2505o(117905);
            return;
        }
        c7306ak.sendEmptyMessageDelayed(2, elapsedRealtime);
        AppMethodBeat.m2505o(117905);
    }

    /* renamed from: a */
    static /* synthetic */ void m56740a(C34603j c34603j) {
        AppMethodBeat.m2504i(117906);
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s seek done", c34603j.orH.aZm());
        c34603j.osg.setState(5);
        if (c34603j.osi != null) {
            c34603j.orH.orA = c34603j.osi.mo24697yH((int) c34603j.orH.ory);
            c34603j.osi.setState(5);
        }
        c34603j.mo55195yJ(7);
        c34603j.setState(4);
        c34603j.orI.obtainMessage(3, 0, 0).sendToTarget();
        c34603j.orH.orz = c34603j.orH.ory * 1000;
        c34603j.orH.ory = -1;
        AppMethodBeat.m2505o(117906);
    }
}
