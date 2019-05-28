package com.tencent.p177mm.plugin.p468n;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;

/* renamed from: com.tencent.mm.plugin.n.i */
public final class C34602i {
    Looper orS;
    C7306ak orT;
    HandlerThread orU;
    HandlerThread orV;
    HandlerThread orW;
    public C34603j orX;
    public C39453c orY;
    private C4998a orZ;

    /* renamed from: com.tencent.mm.plugin.n.i$1 */
    class C346011 implements C4998a {
        C346011() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(117875);
            switch (message.what) {
                case 1:
                    C4990ab.m7417i("MicroMsg.VideoPlayer", "%s call prepared ", C34602i.this.aZm());
                    if (C34602i.this.orY != null) {
                        C34602i.this.orY.mo39086pL();
                        break;
                    }
                    break;
                case 2:
                    C4990ab.m7417i("MicroMsg.VideoPlayer", "%s call completion ", C34602i.this.aZm());
                    if (C34602i.this.orY != null) {
                        C34602i.this.orY.mo39082EA();
                        break;
                    }
                    break;
                case 3:
                    C4990ab.m7417i("MicroMsg.VideoPlayer", "%s call seek completion ", C34602i.this.aZm());
                    if (C34602i.this.orY != null) {
                        C34602i.this.orY.bnT();
                        break;
                    }
                    break;
                case 4:
                    C4990ab.m7417i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", C34602i.this.aZm(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(((Integer) message.obj).intValue()));
                    if (C34602i.this.orY != null) {
                        C34602i.this.orY.mo39083S(message.arg1, message.arg2, ((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 5:
                    C4990ab.m7413e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", C34602i.this.aZm(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                    if (C34602i.this.orY != null) {
                        C34602i.this.orY.onError(message.arg1, message.arg2);
                        break;
                    }
                    break;
                case 6:
                    try {
                        C34602i c34602i = C34602i.this;
                        C4990ab.m7417i("MicroMsg.VideoPlayer", "%s clear now.", c34602i.aZm());
                        c34602i.orU.quit();
                        c34602i.orV.quit();
                        if (c34602i.orW != null) {
                            c34602i.orW.quit();
                        }
                        c34602i.orT.removeMessages(1);
                        c34602i.orT.removeMessages(2);
                        c34602i.orT.removeMessages(3);
                        c34602i.orT.removeMessages(4);
                        c34602i.orT.removeMessages(5);
                        c34602i.orU = null;
                        c34602i.orV = null;
                        c34602i.orT = null;
                        c34602i.orS = null;
                        c34602i.orY = null;
                        c34602i.orX = null;
                        break;
                    } catch (Exception e) {
                        break;
                    }
                default:
                    C4990ab.m7421w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", C34602i.this.aZm(), Integer.valueOf(message.what));
                    break;
            }
            AppMethodBeat.m2505o(117875);
            return false;
        }
    }

    public C34602i(Looper looper) {
        this(looper, (byte) 0);
    }

    private C34602i(Looper looper, byte b) {
        AppMethodBeat.m2504i(117876);
        this.orZ = new C346011();
        this.orU = C7305d.m12297ek("VideoPlayer:inner", -16);
        this.orU.start();
        this.orV = C7305d.m12297ek("VideoPlayer:video", -16);
        this.orV.start();
        this.orW = C7305d.m12297ek("VideoPlayer:audio", -16);
        this.orW.start();
        this.orS = looper;
        this.orT = new C7306ak(this.orS, this.orZ);
        this.orX = new C34603j(this.orT, this.orU.getLooper(), this.orV.getLooper(), this.orW != null ? this.orW.getLooper() : null);
        AppMethodBeat.m2505o(117876);
    }

    public final void setPath(String str) {
        AppMethodBeat.m2504i(117877);
        C4990ab.m7417i("MicroMsg.VideoPlayer", "%s video player set path %s", aZm(), str);
        C34603j c34603j = this.orX;
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s set path %s", c34603j.orH.aZm(), str);
        c34603j.osg.setPath(str);
        if (c34603j.osi != null) {
            c34603j.osi.setPath(str);
        }
        AppMethodBeat.m2505o(117877);
    }

    /* renamed from: a */
    public final void mo55166a(C39453c c39453c) {
        this.orY = c39453c;
    }

    public final void setIOnlineCache(C43332b c43332b) {
        if (c43332b != null && this.orX != null) {
            this.orX.osg.orK = c43332b;
        }
    }

    /* renamed from: iU */
    public final void mo55172iU(boolean z) {
        this.orX.osg.osp = z;
    }

    public final void setNeedResetExtractor(boolean z) {
        AppMethodBeat.m2504i(117878);
        if (this.orX != null) {
            C34603j c34603j = this.orX;
            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", c34603j.orH.aZm(), Boolean.valueOf(z));
            if (c34603j.orH != null) {
                c34603j.orH.llI = z;
            }
        }
        AppMethodBeat.m2505o(117878);
    }

    public final void setIsOnlineVideoType(boolean z) {
        AppMethodBeat.m2504i(117879);
        if (this.orX != null) {
            C34603j c34603j = this.orX;
            if (c34603j.orH != null) {
                C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", c34603j.orH.aZm(), Boolean.valueOf(z));
                c34603j.orH.llJ = z;
            }
        }
        AppMethodBeat.m2505o(117879);
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.m2504i(117880);
        if (surface != null) {
            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", this.orX.orH.aZm(), Integer.valueOf(surface.hashCode()));
            r0.osg.aOO = surface;
        }
        AppMethodBeat.m2505o(117880);
    }

    /* renamed from: f */
    public final void mo55170f(Surface surface) {
        AppMethodBeat.m2504i(117881);
        if (surface != null) {
            C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", this.orX.orH.aZm(), Integer.valueOf(surface.hashCode()));
            C46108k c46108k = r0.osg;
            C4990ab.m7417i("MicroMsg.VideoTrackDataSource", "%s set out put surface", c46108k.aZm());
            c46108k.aOO = surface;
            if (C1443d.m3068iW(23)) {
                c46108k.bPe();
                AppMethodBeat.m2505o(117881);
                return;
            }
            c46108k.bPf();
        }
        AppMethodBeat.m2505o(117881);
    }

    public final boolean prepare() {
        AppMethodBeat.m2504i(117882);
        C34603j c34603j = this.orX;
        C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", c34603j.orH.aZm());
        c34603j.osb.obtainMessage(1).sendToTarget();
        if (c34603j.osi != null) {
            c34603j.osc.obtainMessage(1).sendToTarget();
        }
        AppMethodBeat.m2505o(117882);
        return true;
    }

    public final void start() {
        AppMethodBeat.m2504i(117883);
        C4990ab.m7411d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", aZm(), Integer.valueOf(this.orX.state), C5046bo.dpG());
        if (C46107d.m86023yE(this.orX.state) || C46107d.m86021yC(this.orX.state)) {
            C4990ab.m7421w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", aZm());
            AppMethodBeat.m2505o(117883);
            return;
        }
        this.orX.start();
        AppMethodBeat.m2505o(117883);
    }

    public final void pause() {
        AppMethodBeat.m2504i(117884);
        C4990ab.m7411d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", aZm(), Integer.valueOf(this.orX.state), C5046bo.dpG());
        if (C46107d.m86023yE(this.orX.state) || C46107d.m86021yC(this.orX.state)) {
            C4990ab.m7421w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", aZm());
            AppMethodBeat.m2505o(117884);
            return;
        }
        this.orX.pause();
        AppMethodBeat.m2505o(117884);
    }

    /* renamed from: yI */
    public final void mo55186yI(int i) {
        AppMethodBeat.m2504i(117885);
        this.orX.mo55194yI(i);
        AppMethodBeat.m2505o(117885);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(117886);
        try {
            if (this.orX != null) {
                C34603j c34603j = this.orX;
                if (c34603j.osi != null) {
                    C4990ab.m7417i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", c34603j.orH.aZm(), Boolean.valueOf(z));
                    c34603j.osi.setMute(z);
                }
            }
            AppMethodBeat.m2505o(117886);
        } catch (Exception e) {
            AppMethodBeat.m2505o(117886);
        }
    }

    public final void stop() {
        AppMethodBeat.m2504i(117887);
        this.orX.stop();
        AppMethodBeat.m2505o(117887);
    }

    public final void release() {
        AppMethodBeat.m2504i(117888);
        try {
            this.orX.release();
            AppMethodBeat.m2505o(117888);
        } catch (Exception e) {
            AppMethodBeat.m2505o(117888);
        }
    }

    public final long bPa() {
        return this.orX.bfi;
    }

    public final int bPb() {
        int i;
        AppMethodBeat.m2504i(117889);
        C34603j c34603j = this.orX;
        if (c34603j.orH != null) {
            i = (int) (c34603j.orH.orz / 1000);
            int i2 = (int) c34603j.orH.ory;
            if (i2 != -1) {
                i = i2;
            }
            if (((long) i) < c34603j.orH.orA / 1000) {
                i = (int) (c34603j.orH.orA / 1000);
            }
            C4990ab.m7411d("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", c34603j.orH.aZm(), Integer.valueOf(i), Long.valueOf(c34603j.orH.orz), Long.valueOf(c34603j.orH.orA));
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(117889);
        return i;
    }

    public final void setPlayRate(float f) {
        if (this.orX != null) {
            C34603j c34603j = this.orX;
            if (c34603j.osg != null) {
                C46108k c46108k = c34603j.osg;
                if (f > 0.0f) {
                    c46108k.iac = f;
                }
            }
        }
    }

    public final float getPlayRate() {
        if (this.orX == null) {
            return 1.0f;
        }
        C34603j c34603j = this.orX;
        if (c34603j.osg != null) {
            return c34603j.osg.iac;
        }
        return 1.0f;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(117890);
        boolean yB = C46107d.m86020yB(this.orX.state);
        AppMethodBeat.m2505o(117890);
        return yB;
    }

    public final String aZm() {
        AppMethodBeat.m2504i(117891);
        String aZm;
        if (this.orX != null) {
            aZm = this.orX.orH.aZm();
            AppMethodBeat.m2505o(117891);
            return aZm;
        }
        aZm = "has no player!";
        AppMethodBeat.m2505o(117891);
        return aZm;
    }
}
