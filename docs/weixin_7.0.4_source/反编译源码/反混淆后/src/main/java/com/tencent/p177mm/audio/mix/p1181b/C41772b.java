package com.tencent.p177mm.audio.mix.p1181b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.audio.mix.b.b */
public final class C41772b {
    private static C41772b ckK;
    private ArrayList<C45164d> ckL = new ArrayList();
    private long ckM = 3000000;
    private int count = 0;
    private Object sLock = new Object();
    private int size = 0;

    private C41772b() {
        AppMethodBeat.m2504i(136983);
        AppMethodBeat.m2505o(136983);
    }

    /* renamed from: Di */
    public static C41772b m73733Di() {
        AppMethodBeat.m2504i(136984);
        if (ckK == null) {
            synchronized (C37486c.class) {
                try {
                    if (ckK == null) {
                        ckK = new C41772b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136984);
                    }
                }
            }
        }
        C41772b c41772b = ckK;
        AppMethodBeat.m2505o(136984);
        return c41772b;
    }

    /* renamed from: Dj */
    public final C45164d mo67526Dj() {
        C45164d c45164d;
        AppMethodBeat.m2504i(136985);
        synchronized (this.sLock) {
            try {
                if (this.ckL.size() > 0) {
                    c45164d = (C45164d) this.ckL.remove(this.ckL.size() - 1);
                } else if (((long) this.size) >= this.ckM) {
                    C45174b.m83208e("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", Integer.valueOf(this.size));
                    AppMethodBeat.m2505o(136985);
                    return null;
                } else {
                    this.count++;
                    this.size = this.count * 3536;
                    C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", Integer.valueOf(this.count));
                    c45164d = new C45164d();
                    c45164d.ckH = true;
                    AppMethodBeat.m2505o(136985);
                    return c45164d;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136985);
            }
        }
        return c45164d;
    }

    /* renamed from: b */
    public final void mo67527b(C45164d c45164d) {
        AppMethodBeat.m2504i(136986);
        if (c45164d == null || c45164d.ckv == null) {
            AppMethodBeat.m2505o(136986);
        } else if (c45164d.ckH) {
            c45164d.reset();
            synchronized (this.sLock) {
                try {
                    this.ckL.add(0, c45164d);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(136986);
                }
            }
        } else {
            AppMethodBeat.m2505o(136986);
        }
    }
}
