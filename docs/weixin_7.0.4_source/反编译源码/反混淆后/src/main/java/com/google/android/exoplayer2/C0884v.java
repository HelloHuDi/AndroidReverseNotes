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
import com.google.android.exoplayer2.C32067q.C32068a;
import com.google.android.exoplayer2.C37253f.C37248c;
import com.google.android.exoplayer2.metadata.C37267e.C8694a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p099a.C0824b;
import com.google.android.exoplayer2.p099a.C0826e;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p105f.C17661j.C17662a;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p109g.C25538h;
import com.google.android.exoplayer2.source.C45052i;
import com.google.android.exoplayer2.video.C17693e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.v */
public final class C0884v implements C37253f {
    protected final C32069r[] aMQ;
    private final C37253f aNq;
    private final C0885a aOG = new C0885a(this, (byte) 0);
    final CopyOnWriteArraySet<Object> aOH = new CopyOnWriteArraySet();
    final CopyOnWriteArraySet<C17662a> aOI = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet<C8694a> aOJ = new CopyOnWriteArraySet();
    private final int aOK;
    private final int aOL;
    Format aOM;
    Format aON;
    Surface aOO;
    private boolean aOP;
    private int aOQ;
    private SurfaceHolder aOR;
    private TextureView aOS;
    public C0826e aOT;
    C17693e aOU;
    C32021d aOV;
    C32021d aOW;
    int aOX;
    private C0824b aOY;
    private float aOZ;

    /* renamed from: com.google.android.exoplayer2.v$a */
    final class C0885a implements Callback, SurfaceTextureListener, C0826e, C17662a, C8694a, C17693e {
        private C0885a() {
        }

        /* synthetic */ C0885a(C0884v c0884v, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo2632a(C32021d c32021d) {
            AppMethodBeat.m2504i(95393);
            C0884v.this.aOV = c32021d;
            if (C0884v.this.aOU != null) {
                C0884v.this.aOU.mo2632a(c32021d);
            }
            AppMethodBeat.m2505o(95393);
        }

        /* renamed from: c */
        public final void mo2637c(Format format) {
            AppMethodBeat.m2504i(95394);
            C0884v.this.aOM = format;
            if (C0884v.this.aOU != null) {
                C0884v.this.aOU.mo2637c(format);
            }
            AppMethodBeat.m2505o(95394);
        }

        /* renamed from: b */
        public final void mo2633b(int i, int i2, int i3, float f) {
            AppMethodBeat.m2504i(95395);
            Iterator it = C0884v.this.aOH.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (C0884v.this.aOU != null) {
                C0884v.this.aOU.mo2633b(i, i2, i3, f);
            }
            AppMethodBeat.m2505o(95395);
        }

        /* renamed from: c */
        public final void mo2636c(Surface surface) {
            AppMethodBeat.m2504i(95396);
            if (C0884v.this.aOO == surface) {
                Iterator it = C0884v.this.aOH.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (C0884v.this.aOU != null) {
                C0884v.this.aOU.mo2636c(surface);
            }
            AppMethodBeat.m2505o(95396);
        }

        /* renamed from: b */
        public final void mo2634b(C32021d c32021d) {
            AppMethodBeat.m2504i(95397);
            if (C0884v.this.aOU != null) {
                C0884v.this.aOU.mo2634b(c32021d);
            }
            C0884v.this.aOM = null;
            C0884v.this.aOV = null;
            AppMethodBeat.m2505o(95397);
        }

        /* renamed from: c */
        public final void mo2523c(C32021d c32021d) {
            AppMethodBeat.m2504i(95398);
            C0884v.this.aOW = c32021d;
            if (C0884v.this.aOT != null) {
                C0884v.this.aOT.mo2523c(c32021d);
            }
            AppMethodBeat.m2505o(95398);
        }

        /* renamed from: dx */
        public final void mo2527dx(int i) {
            AppMethodBeat.m2504i(95399);
            C0884v.this.aOX = i;
            if (C0884v.this.aOT != null) {
                C0884v.this.aOT.mo2527dx(i);
            }
            AppMethodBeat.m2505o(95399);
        }

        /* renamed from: b */
        public final void mo2522b(String str, long j, long j2) {
            AppMethodBeat.m2504i(95400);
            if (C0884v.this.aOT != null) {
                C0884v.this.aOT.mo2522b(str, j, j2);
            }
            AppMethodBeat.m2505o(95400);
        }

        /* renamed from: d */
        public final void mo2525d(Format format) {
            AppMethodBeat.m2504i(95401);
            C0884v.this.aON = format;
            if (C0884v.this.aOT != null) {
                C0884v.this.aOT.mo2525d(format);
            }
            AppMethodBeat.m2505o(95401);
        }

        /* renamed from: d */
        public final void mo2524d(int i, long j, long j2) {
            AppMethodBeat.m2504i(95402);
            if (C0884v.this.aOT != null) {
                C0884v.this.aOT.mo2524d(i, j, j2);
            }
            AppMethodBeat.m2505o(95402);
        }

        /* renamed from: d */
        public final void mo2526d(C32021d c32021d) {
            AppMethodBeat.m2504i(95403);
            if (C0884v.this.aOT != null) {
                C0884v.this.aOT.mo2526d(c32021d);
            }
            C0884v.this.aON = null;
            C0884v.this.aOW = null;
            C0884v.this.aOX = 0;
            AppMethodBeat.m2505o(95403);
        }

        /* renamed from: t */
        public final void mo2645t(List<C32044a> list) {
            AppMethodBeat.m2504i(95404);
            Iterator it = C0884v.this.aOI.iterator();
            while (it.hasNext()) {
                ((C17662a) it.next()).mo2645t(list);
            }
            AppMethodBeat.m2505o(95404);
        }

        /* renamed from: b */
        public final void mo2635b(Metadata metadata) {
            AppMethodBeat.m2504i(95405);
            Iterator it = C0884v.this.aOJ.iterator();
            while (it.hasNext()) {
                ((C8694a) it.next()).mo2635b(metadata);
            }
            AppMethodBeat.m2505o(95405);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(95406);
            C0884v.m1992a(C0884v.this, surfaceHolder.getSurface(), false);
            AppMethodBeat.m2505o(95406);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(95407);
            C0884v.m1992a(C0884v.this, null, false);
            AppMethodBeat.m2505o(95407);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(95408);
            C0884v.m1992a(C0884v.this, new Surface(surfaceTexture), true);
            AppMethodBeat.m2505o(95408);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(95409);
            C0884v.m1992a(C0884v.this, null, true);
            AppMethodBeat.m2505o(95409);
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    protected C0884v(C0883u c0883u, C25538h c25538h, C8693m c8693m) {
        AppMethodBeat.m2504i(95410);
        this.aMQ = c0883u.mo2614a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.aOG, this.aOG, this.aOG, this.aOG);
        int i = 0;
        int i2 = 0;
        for (C32069r trackType : this.aMQ) {
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
        this.aOY = C0824b.aPz;
        this.aOQ = 1;
        this.aNq = new C41200h(this.aMQ, c25538h, c8693m);
        AppMethodBeat.m2505o(95410);
    }

    /* renamed from: a */
    public final void mo2615a(C32068a c32068a) {
        AppMethodBeat.m2504i(95411);
        this.aNq.mo2615a(c32068a);
        AppMethodBeat.m2505o(95411);
    }

    /* renamed from: b */
    public final void mo2619b(C32068a c32068a) {
        AppMethodBeat.m2504i(95412);
        this.aNq.mo2619b(c32068a);
        AppMethodBeat.m2505o(95412);
    }

    /* renamed from: pO */
    public final int mo2626pO() {
        AppMethodBeat.m2504i(95413);
        int pO = this.aNq.mo2626pO();
        AppMethodBeat.m2505o(95413);
        return pO;
    }

    /* renamed from: a */
    public final void mo2616a(C45052i c45052i) {
        AppMethodBeat.m2504i(95414);
        this.aNq.mo2616a(c45052i);
        AppMethodBeat.m2505o(95414);
    }

    /* renamed from: aE */
    public final void mo2618aE(boolean z) {
        AppMethodBeat.m2504i(95415);
        this.aNq.mo2618aE(z);
        AppMethodBeat.m2505o(95415);
    }

    /* renamed from: pP */
    public final boolean mo2627pP() {
        AppMethodBeat.m2504i(95416);
        boolean pP = this.aNq.mo2627pP();
        AppMethodBeat.m2505o(95416);
        return pP;
    }

    public final void setRepeatMode(int i) {
        AppMethodBeat.m2504i(95417);
        this.aNq.setRepeatMode(i);
        AppMethodBeat.m2505o(95417);
    }

    public final boolean isLoading() {
        AppMethodBeat.m2504i(95418);
        boolean isLoading = this.aNq.isLoading();
        AppMethodBeat.m2505o(95418);
        return isLoading;
    }

    public final void seekTo(long j) {
        AppMethodBeat.m2504i(95419);
        this.aNq.seekTo(j);
        AppMethodBeat.m2505o(95419);
    }

    public final void stop() {
        AppMethodBeat.m2504i(95420);
        this.aNq.stop();
        AppMethodBeat.m2505o(95420);
    }

    public final void release() {
        AppMethodBeat.m2504i(95421);
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
        AppMethodBeat.m2505o(95421);
    }

    /* renamed from: a */
    public final void mo2617a(C37248c... c37248cArr) {
        AppMethodBeat.m2504i(95422);
        this.aNq.mo2617a(c37248cArr);
        AppMethodBeat.m2505o(95422);
    }

    /* renamed from: b */
    public final void mo2620b(C37248c... c37248cArr) {
        AppMethodBeat.m2504i(95423);
        this.aNq.mo2620b(c37248cArr);
        AppMethodBeat.m2505o(95423);
    }

    public final long getDuration() {
        AppMethodBeat.m2504i(95424);
        long duration = this.aNq.getDuration();
        AppMethodBeat.m2505o(95424);
        return duration;
    }

    public final long getCurrentPosition() {
        AppMethodBeat.m2504i(95425);
        long currentPosition = this.aNq.getCurrentPosition();
        AppMethodBeat.m2505o(95425);
        return currentPosition;
    }

    public final long getBufferedPosition() {
        AppMethodBeat.m2504i(95426);
        long bufferedPosition = this.aNq.getBufferedPosition();
        AppMethodBeat.m2505o(95426);
        return bufferedPosition;
    }

    public final int getBufferedPercentage() {
        AppMethodBeat.m2504i(95427);
        int bufferedPercentage = this.aNq.getBufferedPercentage();
        AppMethodBeat.m2505o(95427);
        return bufferedPercentage;
    }

    /* renamed from: a */
    static /* synthetic */ void m1992a(C0884v c0884v, Surface surface, boolean z) {
        AppMethodBeat.m2504i(95428);
        C37248c[] c37248cArr = new C37248c[c0884v.aOK];
        C32069r[] c32069rArr = c0884v.aMQ;
        int length = c32069rArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            C32069r c32069r = c32069rArr[i];
            if (c32069r.getTrackType() == 2) {
                i3 = i2 + 1;
                c37248cArr[i2] = new C37248c(c32069r, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (c0884v.aOO == null || c0884v.aOO == surface) {
            c0884v.aNq.mo2617a(c37248cArr);
        } else {
            c0884v.aNq.mo2620b(c37248cArr);
            if (c0884v.aOP) {
                c0884v.aOO.release();
            }
        }
        c0884v.aOO = surface;
        c0884v.aOP = z;
        AppMethodBeat.m2505o(95428);
    }
}
