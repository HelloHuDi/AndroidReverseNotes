package com.google.android.exoplayer2.p101c.p104f;

import android.util.SparseArray;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;

/* renamed from: com.google.android.exoplayer2.c.f.p */
public final class C0849p implements C32034e {
    public static final C32039h aTh = new C08501();
    private final C45042s aYf;
    private C8662g baf;
    private final SparseArray<C0851a> bdf;
    private final C32065l bdg;
    private boolean bdh;
    private boolean bdi;
    private boolean bdj;

    /* renamed from: com.google.android.exoplayer2.c.f.p$1 */
    static class C08501 implements C32039h {
        C08501() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(95148);
            C32034e[] c32034eArr = new C32034e[]{new C0849p()};
            AppMethodBeat.m2505o(95148);
            return c32034eArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.p$a */
    static final class C0851a {
        long aSk;
        final C45042s aYf;
        final C32064k bcY = new C32064k(new byte[64]);
        boolean bcZ;
        boolean bda;
        boolean bdb;
        int bdc;
        final C0845h bdk;

        public C0851a(C0845h c0845h, C45042s c45042s) {
            AppMethodBeat.m2504i(95149);
            this.bdk = c0845h;
            this.aYf = c45042s;
            AppMethodBeat.m2505o(95149);
        }
    }

    static {
        AppMethodBeat.m2504i(95156);
        AppMethodBeat.m2505o(95156);
    }

    public C0849p() {
        this(new C45042s(0));
        AppMethodBeat.m2504i(95150);
        AppMethodBeat.m2505o(95150);
    }

    private C0849p(C45042s c45042s) {
        AppMethodBeat.m2504i(95151);
        this.aYf = c45042s;
        this.bdg = new C32065l(4096);
        this.bdf = new SparseArray();
        AppMethodBeat.m2505o(95151);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(95152);
        byte[] bArr = new byte[14];
        c45026f.mo59479b(bArr, 0, 14);
        if (JsApiInstallDownloadTask.CTRL_INDEX != (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255))) {
            AppMethodBeat.m2505o(95152);
            return false;
        } else if ((bArr[4] & 196) != 68) {
            AppMethodBeat.m2505o(95152);
            return false;
        } else if ((bArr[6] & 4) != 4) {
            AppMethodBeat.m2505o(95152);
            return false;
        } else if ((bArr[8] & 4) != 4) {
            AppMethodBeat.m2505o(95152);
            return false;
        } else if ((bArr[9] & 1) != 1) {
            AppMethodBeat.m2505o(95152);
            return false;
        } else if ((bArr[12] & 3) != 3) {
            AppMethodBeat.m2505o(95152);
            return false;
        } else {
            c45026f.mo59483dH(bArr[13] & 7);
            c45026f.mo59479b(bArr, 0, 3);
            if (1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)))) {
                AppMethodBeat.m2505o(95152);
                return true;
            }
            AppMethodBeat.m2505o(95152);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(95153);
        this.baf = c8662g;
        c8662g.mo19156a(new C17646a(-9223372036854775807L));
        AppMethodBeat.m2505o(95153);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(95154);
        this.aYf.brL = -9223372036854775807L;
        for (int i = 0; i < this.bdf.size(); i++) {
            C0851a c0851a = (C0851a) this.bdf.valueAt(i);
            c0851a.bdb = false;
            c0851a.bdk.mo2557rn();
        }
        AppMethodBeat.m2505o(95154);
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(95155);
        if (c45026f.mo59480b(this.bdg.data, 0, 4, true)) {
            this.bdg.setPosition(0);
            int readInt = this.bdg.readInt();
            if (readInt == JsApiQueryDownloadTask.CTRL_INDEX) {
                AppMethodBeat.m2505o(95155);
                return -1;
            } else if (readInt == JsApiInstallDownloadTask.CTRL_INDEX) {
                c45026f.mo59479b(this.bdg.data, 0, 10);
                this.bdg.setPosition(9);
                c45026f.mo59482dG((this.bdg.readUnsignedByte() & 7) + 14);
                AppMethodBeat.m2505o(95155);
                return 0;
            } else if (readInt == JsApiPauseDownloadTask.CTRL_INDEX) {
                c45026f.mo59479b(this.bdg.data, 0, 2);
                this.bdg.setPosition(0);
                c45026f.mo59482dG(this.bdg.readUnsignedShort() + 6);
                AppMethodBeat.m2505o(95155);
                return 0;
            } else if (((readInt & -256) >> 8) != 1) {
                c45026f.mo59482dG(1);
                AppMethodBeat.m2505o(95155);
                return 0;
            } else {
                int i = readInt & 255;
                C0851a c0851a = (C0851a) this.bdf.get(i);
                if (!this.bdh) {
                    if (c0851a == null) {
                        C0845h c0845h = null;
                        if (!this.bdi && i == 189) {
                            c0845h = new C32035b();
                            this.bdi = true;
                        } else if (!this.bdi && (i & 224) == C33250az.CTRL_INDEX) {
                            c0845h = new C32037m();
                            this.bdi = true;
                        } else if (!this.bdj && (i & 240) == 224) {
                            c0845h = new C25526i();
                            this.bdj = true;
                        }
                        if (c0845h != null) {
                            c0845h.mo2555a(this.baf, new C8661d(i, 256));
                            c0851a = new C0851a(c0845h, this.aYf);
                            this.bdf.put(i, c0851a);
                        }
                    }
                    if ((this.bdi && this.bdj) || c45026f.getPosition() > 1048576) {
                        this.bdh = true;
                        this.baf.mo19158rb();
                    }
                }
                c45026f.mo59479b(this.bdg.data, 0, 2);
                this.bdg.setPosition(0);
                int readUnsignedShort = this.bdg.readUnsignedShort() + 6;
                if (c0851a == null) {
                    c45026f.mo59482dG(readUnsignedShort);
                } else {
                    this.bdg.reset(readUnsignedShort);
                    c45026f.readFully(this.bdg.data, 0, readUnsignedShort);
                    this.bdg.setPosition(6);
                    C32065l c32065l = this.bdg;
                    c32065l.readBytes(c0851a.bcY.data, 0, 3);
                    c0851a.bcY.setPosition(0);
                    c0851a.bcY.mo52355ee(8);
                    c0851a.bcZ = c0851a.bcY.mo52358rl();
                    c0851a.bda = c0851a.bcY.mo52358rl();
                    c0851a.bcY.mo52355ee(6);
                    c0851a.bdc = c0851a.bcY.mo52354ed(8);
                    c32065l.readBytes(c0851a.bcY.data, 0, c0851a.bdc);
                    c0851a.bcY.setPosition(0);
                    c0851a.aSk = 0;
                    if (c0851a.bcZ) {
                        c0851a.bcY.mo52355ee(4);
                        long ed = ((long) c0851a.bcY.mo52354ed(3)) << 30;
                        c0851a.bcY.mo52355ee(1);
                        ed |= (long) (c0851a.bcY.mo52354ed(15) << 15);
                        c0851a.bcY.mo52355ee(1);
                        ed |= (long) c0851a.bcY.mo52354ed(15);
                        c0851a.bcY.mo52355ee(1);
                        if (!c0851a.bdb && c0851a.bda) {
                            c0851a.bcY.mo52355ee(4);
                            long ed2 = ((long) c0851a.bcY.mo52354ed(3)) << 30;
                            c0851a.bcY.mo52355ee(1);
                            ed2 |= (long) (c0851a.bcY.mo52354ed(15) << 15);
                            c0851a.bcY.mo52355ee(1);
                            ed2 |= (long) c0851a.bcY.mo52354ed(15);
                            c0851a.bcY.mo52355ee(1);
                            c0851a.aYf.mo72551ao(ed2);
                            c0851a.bdb = true;
                        }
                        c0851a.aSk = c0851a.aYf.mo72551ao(ed);
                    }
                    c0851a.bdk.mo2556d(c0851a.aSk, true);
                    c0851a.bdk.mo2559t(c32065l);
                    c0851a.bdk.mo2558ro();
                    this.bdg.mo52368eL(this.bdg.capacity());
                }
                AppMethodBeat.m2505o(95155);
                return 0;
            }
        }
        AppMethodBeat.m2505o(95155);
        return -1;
    }
}
