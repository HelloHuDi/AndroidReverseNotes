package com.tencent.mm.plugin.n;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class i {
    Looper orS;
    ak orT;
    HandlerThread orU;
    HandlerThread orV;
    HandlerThread orW;
    public j orX;
    public c orY;
    private a orZ;

    public i(Looper looper) {
        this(looper, (byte) 0);
    }

    private i(Looper looper, byte b) {
        AppMethodBeat.i(117876);
        this.orZ = new a() {
            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(117875);
                switch (message.what) {
                    case 1:
                        ab.i("MicroMsg.VideoPlayer", "%s call prepared ", i.this.aZm());
                        if (i.this.orY != null) {
                            i.this.orY.pL();
                            break;
                        }
                        break;
                    case 2:
                        ab.i("MicroMsg.VideoPlayer", "%s call completion ", i.this.aZm());
                        if (i.this.orY != null) {
                            i.this.orY.EA();
                            break;
                        }
                        break;
                    case 3:
                        ab.i("MicroMsg.VideoPlayer", "%s call seek completion ", i.this.aZm());
                        if (i.this.orY != null) {
                            i.this.orY.bnT();
                            break;
                        }
                        break;
                    case 4:
                        ab.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", i.this.aZm(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(((Integer) message.obj).intValue()));
                        if (i.this.orY != null) {
                            i.this.orY.S(message.arg1, message.arg2, ((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 5:
                        ab.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", i.this.aZm(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                        if (i.this.orY != null) {
                            i.this.orY.onError(message.arg1, message.arg2);
                            break;
                        }
                        break;
                    case 6:
                        try {
                            i iVar = i.this;
                            ab.i("MicroMsg.VideoPlayer", "%s clear now.", iVar.aZm());
                            iVar.orU.quit();
                            iVar.orV.quit();
                            if (iVar.orW != null) {
                                iVar.orW.quit();
                            }
                            iVar.orT.removeMessages(1);
                            iVar.orT.removeMessages(2);
                            iVar.orT.removeMessages(3);
                            iVar.orT.removeMessages(4);
                            iVar.orT.removeMessages(5);
                            iVar.orU = null;
                            iVar.orV = null;
                            iVar.orT = null;
                            iVar.orS = null;
                            iVar.orY = null;
                            iVar.orX = null;
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    default:
                        ab.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", i.this.aZm(), Integer.valueOf(message.what));
                        break;
                }
                AppMethodBeat.o(117875);
                return false;
            }
        };
        this.orU = d.ek("VideoPlayer:inner", -16);
        this.orU.start();
        this.orV = d.ek("VideoPlayer:video", -16);
        this.orV.start();
        this.orW = d.ek("VideoPlayer:audio", -16);
        this.orW.start();
        this.orS = looper;
        this.orT = new ak(this.orS, this.orZ);
        this.orX = new j(this.orT, this.orU.getLooper(), this.orV.getLooper(), this.orW != null ? this.orW.getLooper() : null);
        AppMethodBeat.o(117876);
    }

    public final void setPath(String str) {
        AppMethodBeat.i(117877);
        ab.i("MicroMsg.VideoPlayer", "%s video player set path %s", aZm(), str);
        j jVar = this.orX;
        ab.i("MicroMsg.VideoPlayerImpl", "%s set path %s", jVar.orH.aZm(), str);
        jVar.osg.setPath(str);
        if (jVar.osi != null) {
            jVar.osi.setPath(str);
        }
        AppMethodBeat.o(117877);
    }

    public final void a(c cVar) {
        this.orY = cVar;
    }

    public final void setIOnlineCache(b bVar) {
        if (bVar != null && this.orX != null) {
            this.orX.osg.orK = bVar;
        }
    }

    public final void iU(boolean z) {
        this.orX.osg.osp = z;
    }

    public final void setNeedResetExtractor(boolean z) {
        AppMethodBeat.i(117878);
        if (this.orX != null) {
            j jVar = this.orX;
            ab.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", jVar.orH.aZm(), Boolean.valueOf(z));
            if (jVar.orH != null) {
                jVar.orH.llI = z;
            }
        }
        AppMethodBeat.o(117878);
    }

    public final void setIsOnlineVideoType(boolean z) {
        AppMethodBeat.i(117879);
        if (this.orX != null) {
            j jVar = this.orX;
            if (jVar.orH != null) {
                ab.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", jVar.orH.aZm(), Boolean.valueOf(z));
                jVar.orH.llJ = z;
            }
        }
        AppMethodBeat.o(117879);
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.i(117880);
        if (surface != null) {
            ab.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", this.orX.orH.aZm(), Integer.valueOf(surface.hashCode()));
            r0.osg.aOO = surface;
        }
        AppMethodBeat.o(117880);
    }

    public final void f(Surface surface) {
        AppMethodBeat.i(117881);
        if (surface != null) {
            ab.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", this.orX.orH.aZm(), Integer.valueOf(surface.hashCode()));
            k kVar = r0.osg;
            ab.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", kVar.aZm());
            kVar.aOO = surface;
            if (com.tencent.mm.compatible.util.d.iW(23)) {
                kVar.bPe();
                AppMethodBeat.o(117881);
                return;
            }
            kVar.bPf();
        }
        AppMethodBeat.o(117881);
    }

    public final boolean prepare() {
        AppMethodBeat.i(117882);
        j jVar = this.orX;
        ab.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", jVar.orH.aZm());
        jVar.osb.obtainMessage(1).sendToTarget();
        if (jVar.osi != null) {
            jVar.osc.obtainMessage(1).sendToTarget();
        }
        AppMethodBeat.o(117882);
        return true;
    }

    public final void start() {
        AppMethodBeat.i(117883);
        ab.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", aZm(), Integer.valueOf(this.orX.state), bo.dpG());
        if (d.yE(this.orX.state) || d.yC(this.orX.state)) {
            ab.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", aZm());
            AppMethodBeat.o(117883);
            return;
        }
        this.orX.start();
        AppMethodBeat.o(117883);
    }

    public final void pause() {
        AppMethodBeat.i(117884);
        ab.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", aZm(), Integer.valueOf(this.orX.state), bo.dpG());
        if (d.yE(this.orX.state) || d.yC(this.orX.state)) {
            ab.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", aZm());
            AppMethodBeat.o(117884);
            return;
        }
        this.orX.pause();
        AppMethodBeat.o(117884);
    }

    public final void yI(int i) {
        AppMethodBeat.i(117885);
        this.orX.yI(i);
        AppMethodBeat.o(117885);
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(117886);
        try {
            if (this.orX != null) {
                j jVar = this.orX;
                if (jVar.osi != null) {
                    ab.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", jVar.orH.aZm(), Boolean.valueOf(z));
                    jVar.osi.setMute(z);
                }
            }
            AppMethodBeat.o(117886);
        } catch (Exception e) {
            AppMethodBeat.o(117886);
        }
    }

    public final void stop() {
        AppMethodBeat.i(117887);
        this.orX.stop();
        AppMethodBeat.o(117887);
    }

    public final void release() {
        AppMethodBeat.i(117888);
        try {
            this.orX.release();
            AppMethodBeat.o(117888);
        } catch (Exception e) {
            AppMethodBeat.o(117888);
        }
    }

    public final long bPa() {
        return this.orX.bfi;
    }

    public final int bPb() {
        int i;
        AppMethodBeat.i(117889);
        j jVar = this.orX;
        if (jVar.orH != null) {
            i = (int) (jVar.orH.orz / 1000);
            int i2 = (int) jVar.orH.ory;
            if (i2 != -1) {
                i = i2;
            }
            if (((long) i) < jVar.orH.orA / 1000) {
                i = (int) (jVar.orH.orA / 1000);
            }
            ab.d("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", jVar.orH.aZm(), Integer.valueOf(i), Long.valueOf(jVar.orH.orz), Long.valueOf(jVar.orH.orA));
        } else {
            i = 0;
        }
        AppMethodBeat.o(117889);
        return i;
    }

    public final void setPlayRate(float f) {
        if (this.orX != null) {
            j jVar = this.orX;
            if (jVar.osg != null) {
                k kVar = jVar.osg;
                if (f > 0.0f) {
                    kVar.iac = f;
                }
            }
        }
    }

    public final float getPlayRate() {
        if (this.orX == null) {
            return 1.0f;
        }
        j jVar = this.orX;
        if (jVar.osg != null) {
            return jVar.osg.iac;
        }
        return 1.0f;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(117890);
        boolean yB = d.yB(this.orX.state);
        AppMethodBeat.o(117890);
        return yB;
    }

    public final String aZm() {
        AppMethodBeat.i(117891);
        String aZm;
        if (this.orX != null) {
            aZm = this.orX.orH.aZm();
            AppMethodBeat.o(117891);
            return aZm;
        }
        aZm = "has no player!";
        AppMethodBeat.o(117891);
        return aZm;
    }
}
