package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements a {
    boolean VN = false;
    boolean cFy = false;
    boolean fqL = false;
    i oAb = new i(Looper.getMainLooper());
    int oAc;
    int oAd = 0;
    private int oAe = 0;
    a oAf;
    d oAg;
    com.tencent.mm.plugin.mmsight.segment.a.a.b oAh;
    c oAi;

    public b() {
        AppMethodBeat.i(3713);
        i iVar = this.oAb;
        if (iVar.orX != null) {
            j jVar = iVar.orX;
            if (jVar.orH != null) {
                jVar.orH.orD = false;
            }
        }
        this.oAb.setNeedResetExtractor(false);
        this.oAb.orY = new com.tencent.mm.plugin.n.c() {
            public final void pL() {
                AppMethodBeat.i(3708);
                if (b.this.oAh != null) {
                    b.this.oAh.ce(b.this.oAb);
                }
                if (b.this.cFy) {
                    b.this.oAb.start();
                }
                b.this.VN = true;
                AppMethodBeat.o(3708);
            }

            public final void EA() {
                AppMethodBeat.i(3709);
                if (b.this.fqL) {
                    b.this.oAb.yI(b.this.oAd);
                }
                AppMethodBeat.o(3709);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(3710);
                if (b.this.oAf != null) {
                    b.this.oAf.ey(i, i2);
                }
                AppMethodBeat.o(3710);
            }

            public final void bnT() {
                AppMethodBeat.i(3711);
                ab.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", b.this.oAi);
                if (b.this.oAi != null) {
                    b.this.oAi.cf(b.this.oAb);
                    AppMethodBeat.o(3711);
                    return;
                }
                if (b.this.cFy) {
                    b.this.oAb.start();
                }
                AppMethodBeat.o(3711);
            }

            public final void S(int i, int i2, int i3) {
                AppMethodBeat.i(3712);
                b.this.oAc = i3;
                if (b.this.oAg != null) {
                    b.this.oAg.aa(i, i2, i3);
                }
                AppMethodBeat.o(3712);
            }
        };
        AppMethodBeat.o(3713);
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.i(3714);
        this.oAb.setSurface(surface);
        AppMethodBeat.o(3714);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.i(3715);
        this.oAb.setPath(str);
        AppMethodBeat.o(3715);
    }

    public final void prepareAsync() {
        AppMethodBeat.i(3716);
        this.oAb.prepare();
        AppMethodBeat.o(3716);
    }

    public final void start() {
        AppMethodBeat.i(3717);
        if (this.VN) {
            this.oAb.start();
        }
        this.cFy = true;
        AppMethodBeat.o(3717);
    }

    public final void stop() {
        AppMethodBeat.i(3718);
        this.oAb.orX.stop();
        this.cFy = false;
        AppMethodBeat.o(3718);
    }

    public final void pause() {
        AppMethodBeat.i(3719);
        this.oAb.pause();
        AppMethodBeat.o(3719);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(3720);
        boolean isPlaying = this.oAb.isPlaying();
        AppMethodBeat.o(3720);
        return isPlaying;
    }

    public final void seekTo(int i) {
        AppMethodBeat.i(3721);
        if (this.oAb != null) {
            ab.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", Integer.valueOf(i));
            this.oAb.yI(i);
        }
        AppMethodBeat.o(3721);
    }

    public final int getCurrentPosition() {
        AppMethodBeat.i(3722);
        int bPb = this.oAb.bPb();
        AppMethodBeat.o(3722);
        return bPb;
    }

    public final int getDuration() {
        return (int) this.oAb.orX.bfi;
    }

    public final void release() {
        AppMethodBeat.i(3723);
        this.oAb.release();
        AppMethodBeat.o(3723);
    }

    public final void setAudioStreamType(int i) {
    }

    public final void setLooping(boolean z) {
        this.fqL = z;
    }

    public final void setLoop(int i, int i2) {
        this.oAd = i;
        this.oAe = i2;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.b bVar) {
        this.oAh = bVar;
    }

    public final void a(c cVar) {
        this.oAi = cVar;
    }

    public final void a(d dVar) {
        this.oAg = dVar;
    }

    public final void a(a aVar) {
        this.oAf = aVar;
    }
}
