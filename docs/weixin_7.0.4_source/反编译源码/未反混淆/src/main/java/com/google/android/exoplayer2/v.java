package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v implements f {
    protected final r[] aMQ;
    private final f aNq;
    private final a aOG = new a(this, (byte) 0);
    final CopyOnWriteArraySet<Object> aOH = new CopyOnWriteArraySet();
    final CopyOnWriteArraySet<com.google.android.exoplayer2.f.j.a> aOI = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.e.a> aOJ = new CopyOnWriteArraySet();
    private final int aOK;
    private final int aOL;
    Format aOM;
    Format aON;
    Surface aOO;
    private boolean aOP;
    private int aOQ;
    private SurfaceHolder aOR;
    private TextureView aOS;
    public e aOT;
    com.google.android.exoplayer2.video.e aOU;
    d aOV;
    d aOW;
    int aOX;
    private b aOY;
    private float aOZ;

    final class a implements Callback, SurfaceTextureListener, e, com.google.android.exoplayer2.f.j.a, com.google.android.exoplayer2.metadata.e.a, com.google.android.exoplayer2.video.e {
        private a() {
        }

        /* synthetic */ a(v vVar, byte b) {
            this();
        }

        public final void a(d dVar) {
            AppMethodBeat.i(95393);
            v.this.aOV = dVar;
            if (v.this.aOU != null) {
                v.this.aOU.a(dVar);
            }
            AppMethodBeat.o(95393);
        }

        public final void c(Format format) {
            AppMethodBeat.i(95394);
            v.this.aOM = format;
            if (v.this.aOU != null) {
                v.this.aOU.c(format);
            }
            AppMethodBeat.o(95394);
        }

        public final void b(int i, int i2, int i3, float f) {
            AppMethodBeat.i(95395);
            Iterator it = v.this.aOH.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (v.this.aOU != null) {
                v.this.aOU.b(i, i2, i3, f);
            }
            AppMethodBeat.o(95395);
        }

        public final void c(Surface surface) {
            AppMethodBeat.i(95396);
            if (v.this.aOO == surface) {
                Iterator it = v.this.aOH.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (v.this.aOU != null) {
                v.this.aOU.c(surface);
            }
            AppMethodBeat.o(95396);
        }

        public final void b(d dVar) {
            AppMethodBeat.i(95397);
            if (v.this.aOU != null) {
                v.this.aOU.b(dVar);
            }
            v.this.aOM = null;
            v.this.aOV = null;
            AppMethodBeat.o(95397);
        }

        public final void c(d dVar) {
            AppMethodBeat.i(95398);
            v.this.aOW = dVar;
            if (v.this.aOT != null) {
                v.this.aOT.c(dVar);
            }
            AppMethodBeat.o(95398);
        }

        public final void dx(int i) {
            AppMethodBeat.i(95399);
            v.this.aOX = i;
            if (v.this.aOT != null) {
                v.this.aOT.dx(i);
            }
            AppMethodBeat.o(95399);
        }

        public final void b(String str, long j, long j2) {
            AppMethodBeat.i(95400);
            if (v.this.aOT != null) {
                v.this.aOT.b(str, j, j2);
            }
            AppMethodBeat.o(95400);
        }

        public final void d(Format format) {
            AppMethodBeat.i(95401);
            v.this.aON = format;
            if (v.this.aOT != null) {
                v.this.aOT.d(format);
            }
            AppMethodBeat.o(95401);
        }

        public final void d(int i, long j, long j2) {
            AppMethodBeat.i(95402);
            if (v.this.aOT != null) {
                v.this.aOT.d(i, j, j2);
            }
            AppMethodBeat.o(95402);
        }

        public final void d(d dVar) {
            AppMethodBeat.i(95403);
            if (v.this.aOT != null) {
                v.this.aOT.d(dVar);
            }
            v.this.aON = null;
            v.this.aOW = null;
            v.this.aOX = 0;
            AppMethodBeat.o(95403);
        }

        public final void t(List<com.google.android.exoplayer2.f.a> list) {
            AppMethodBeat.i(95404);
            Iterator it = v.this.aOI.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.f.j.a) it.next()).t(list);
            }
            AppMethodBeat.o(95404);
        }

        public final void b(Metadata metadata) {
            AppMethodBeat.i(95405);
            Iterator it = v.this.aOJ.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.metadata.e.a) it.next()).b(metadata);
            }
            AppMethodBeat.o(95405);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(95406);
            v.a(v.this, surfaceHolder.getSurface(), false);
            AppMethodBeat.o(95406);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(95407);
            v.a(v.this, null, false);
            AppMethodBeat.o(95407);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.i(95408);
            v.a(v.this, new Surface(surfaceTexture), true);
            AppMethodBeat.o(95408);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(95409);
            v.a(v.this, null, true);
            AppMethodBeat.o(95409);
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    protected v(u uVar, h hVar, m mVar) {
        AppMethodBeat.i(95410);
        this.aMQ = uVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.aOG, this.aOG, this.aOG, this.aOG);
        int i = 0;
        int i2 = 0;
        for (r trackType : this.aMQ) {
            switch (trackType.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.aOK = i2;
        this.aOL = i;
        this.aOZ = 1.0f;
        this.aOX = 0;
        this.aOY = b.aPz;
        this.aOQ = 1;
        this.aNq = new h(this.aMQ, hVar, mVar);
        AppMethodBeat.o(95410);
    }

    public final void a(com.google.android.exoplayer2.q.a aVar) {
        AppMethodBeat.i(95411);
        this.aNq.a(aVar);
        AppMethodBeat.o(95411);
    }

    public final void b(com.google.android.exoplayer2.q.a aVar) {
        AppMethodBeat.i(95412);
        this.aNq.b(aVar);
        AppMethodBeat.o(95412);
    }

    public final int pO() {
        AppMethodBeat.i(95413);
        int pO = this.aNq.pO();
        AppMethodBeat.o(95413);
        return pO;
    }

    public final void a(i iVar) {
        AppMethodBeat.i(95414);
        this.aNq.a(iVar);
        AppMethodBeat.o(95414);
    }

    public final void aE(boolean z) {
        AppMethodBeat.i(95415);
        this.aNq.aE(z);
        AppMethodBeat.o(95415);
    }

    public final boolean pP() {
        AppMethodBeat.i(95416);
        boolean pP = this.aNq.pP();
        AppMethodBeat.o(95416);
        return pP;
    }

    public final void setRepeatMode(int i) {
        AppMethodBeat.i(95417);
        this.aNq.setRepeatMode(i);
        AppMethodBeat.o(95417);
    }

    public final boolean isLoading() {
        AppMethodBeat.i(95418);
        boolean isLoading = this.aNq.isLoading();
        AppMethodBeat.o(95418);
        return isLoading;
    }

    public final void seekTo(long j) {
        AppMethodBeat.i(95419);
        this.aNq.seekTo(j);
        AppMethodBeat.o(95419);
    }

    public final void stop() {
        AppMethodBeat.i(95420);
        this.aNq.stop();
        AppMethodBeat.o(95420);
    }

    public final void release() {
        AppMethodBeat.i(95421);
        this.aNq.release();
        if (this.aOS != null) {
            if (this.aOS.getSurfaceTextureListener() == this.aOG) {
                this.aOS.setSurfaceTextureListener(null);
            }
            this.aOS = null;
        }
        if (this.aOR != null) {
            this.aOR.removeCallback(this.aOG);
            this.aOR = null;
        }
        if (this.aOO != null) {
            if (this.aOP) {
                this.aOO.release();
            }
            this.aOO = null;
        }
        AppMethodBeat.o(95421);
    }

    public final void a(c... cVarArr) {
        AppMethodBeat.i(95422);
        this.aNq.a(cVarArr);
        AppMethodBeat.o(95422);
    }

    public final void b(c... cVarArr) {
        AppMethodBeat.i(95423);
        this.aNq.b(cVarArr);
        AppMethodBeat.o(95423);
    }

    public final long getDuration() {
        AppMethodBeat.i(95424);
        long duration = this.aNq.getDuration();
        AppMethodBeat.o(95424);
        return duration;
    }

    public final long getCurrentPosition() {
        AppMethodBeat.i(95425);
        long currentPosition = this.aNq.getCurrentPosition();
        AppMethodBeat.o(95425);
        return currentPosition;
    }

    public final long getBufferedPosition() {
        AppMethodBeat.i(95426);
        long bufferedPosition = this.aNq.getBufferedPosition();
        AppMethodBeat.o(95426);
        return bufferedPosition;
    }

    public final int getBufferedPercentage() {
        AppMethodBeat.i(95427);
        int bufferedPercentage = this.aNq.getBufferedPercentage();
        AppMethodBeat.o(95427);
        return bufferedPercentage;
    }

    static /* synthetic */ void a(v vVar, Surface surface, boolean z) {
        AppMethodBeat.i(95428);
        c[] cVarArr = new c[vVar.aOK];
        r[] rVarArr = vVar.aMQ;
        int length = rVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            r rVar = rVarArr[i];
            if (rVar.getTrackType() == 2) {
                i3 = i2 + 1;
                cVarArr[i2] = new c(rVar, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (vVar.aOO == null || vVar.aOO == surface) {
            vVar.aNq.a(cVarArr);
        } else {
            vVar.aNq.b(cVarArr);
            if (vVar.aOP) {
                vVar.aOO.release();
            }
        }
        vVar.aOO = surface;
        vVar.aOP = z;
        AppMethodBeat.o(95428);
    }
}
