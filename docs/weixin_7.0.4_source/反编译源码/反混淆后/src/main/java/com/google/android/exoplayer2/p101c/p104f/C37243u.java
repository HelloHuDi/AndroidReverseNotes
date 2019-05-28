package com.google.android.exoplayer2.p101c.p104f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C25529a;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C25530c;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8660b;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p111i.C45042s;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.u */
public final class C37243u implements C32034e {
    public static final C32039h aTh = new C255281();
    private static final long bdr = ((long) C17675v.m27562aT("AC-3"));
    private static final long bds = ((long) C17675v.m27562aT("EAC3"));
    private static final long bdt = ((long) C17675v.m27562aT("HEVC"));
    private C8662g baf;
    private int bdA;
    private boolean bdB;
    private C37245v bdC;
    private final List<C45042s> bdu;
    private final C32065l bdv;
    private final SparseIntArray bdw;
    private final C25530c bdx;
    private final SparseArray<C37245v> bdy;
    private final SparseBooleanArray bdz;
    private final int mode;

    /* renamed from: com.google.android.exoplayer2.c.f.u$1 */
    static class C255281 implements C32039h {
        C255281() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(95165);
            C32034e[] c32034eArr = new C32034e[]{new C37243u()};
            AppMethodBeat.m2505o(95165);
            return c32034eArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.u$b */
    class C37242b implements C17642q {
        private final C32064k bdF = new C32064k(new byte[5]);
        private final SparseArray<C37245v> bdG = new SparseArray();
        private final SparseIntArray bdH = new SparseIntArray();
        private final int pid;

        public C37242b(int i) {
            AppMethodBeat.m2504i(95168);
            this.pid = i;
            AppMethodBeat.m2505o(95168);
        }

        /* renamed from: a */
        public final void mo32324a(C45042s c45042s, C8662g c8662g, C8661d c8661d) {
        }

        /* renamed from: t */
        public final void mo32325t(C32065l c32065l) {
            AppMethodBeat.m2504i(95169);
            if (c32065l.readUnsignedByte() != 2) {
                AppMethodBeat.m2505o(95169);
                return;
            }
            C45042s c45042s;
            int ed;
            int i;
            int i2;
            if (C37243u.this.mode == 1 || C37243u.this.mode == 2 || C37243u.this.bdA == 1) {
                c45042s = (C45042s) C37243u.this.bdu.get(0);
            } else {
                c45042s = new C45042s(((C45042s) C37243u.this.bdu.get(0)).bbh);
                C37243u.this.bdu.add(c45042s);
            }
            c32065l.mo52369eM(2);
            int readUnsignedShort = c32065l.readUnsignedShort();
            c32065l.mo52369eM(5);
            c32065l.mo52365c(this.bdF, 2);
            this.bdF.mo52355ee(4);
            c32065l.mo52369eM(this.bdF.mo52354ed(12));
            if (C37243u.this.mode == 2 && C37243u.this.bdC == null) {
                C37243u.this.bdC = C37243u.this.bdx.mo42786a(21, new C8660b(21, null, null, new byte[0]));
                C37243u.this.bdC.mo42784a(c45042s, C37243u.this.baf, new C8661d(readUnsignedShort, 21, Utility.DEFAULT_STREAM_BUFFER_SIZE));
            }
            this.bdG.clear();
            this.bdH.clear();
            int tB = c32065l.mo52382tB();
            while (tB > 0) {
                int i3;
                c32065l.mo52365c(this.bdF, 5);
                ed = this.bdF.mo52354ed(8);
                this.bdF.mo52355ee(3);
                int ed2 = this.bdF.mo52354ed(13);
                this.bdF.mo52355ee(4);
                int ed3 = this.bdF.mo52354ed(12);
                int i4 = c32065l.position;
                int i5 = i4 + ed3;
                i = -1;
                String str = null;
                List list = null;
                while (c32065l.position < i5) {
                    int readUnsignedByte = c32065l.readUnsignedByte();
                    int readUnsignedByte2 = c32065l.readUnsignedByte() + c32065l.position;
                    if (readUnsignedByte == 5) {
                        long cM = c32065l.mo52366cM();
                        if (cM == C37243u.bdr) {
                            i = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                        } else if (cM == C37243u.bds) {
                            i = C44697b.CTRL_INDEX;
                        } else if (cM == C37243u.bdt) {
                            i = 36;
                        }
                    } else if (readUnsignedByte == 106) {
                        i = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                    } else if (readUnsignedByte == 122) {
                        i = C44697b.CTRL_INDEX;
                    } else if (readUnsignedByte == 123) {
                        i = 138;
                    } else if (readUnsignedByte == 10) {
                        str = c32065l.readString(3).trim();
                    } else if (readUnsignedByte == 89) {
                        i = 89;
                        list = new ArrayList();
                        while (c32065l.position < readUnsignedByte2) {
                            String trim = c32065l.readString(3).trim();
                            int readUnsignedByte3 = c32065l.readUnsignedByte();
                            byte[] bArr = new byte[4];
                            c32065l.readBytes(bArr, 0, 4);
                            list.add(new C25529a(trim, readUnsignedByte3, bArr));
                        }
                    }
                    c32065l.mo52369eM(readUnsignedByte2 - c32065l.position);
                }
                c32065l.setPosition(i5);
                C8660b c8660b = new C8660b(i, str, list, Arrays.copyOfRange(c32065l.data, i4, i5));
                if (ed == 6) {
                    i3 = c8660b.streamType;
                } else {
                    i3 = ed;
                }
                i = tB - (ed3 + 5);
                i2 = C37243u.this.mode == 2 ? i3 : ed2;
                if (C37243u.this.bdz.get(i2)) {
                    tB = i;
                } else {
                    Object f;
                    if (C37243u.this.mode == 2 && i3 == 21) {
                        f = C37243u.this.bdC;
                    } else {
                        f = C37243u.this.bdx.mo42786a(i3, c8660b);
                    }
                    if (C37243u.this.mode != 2 || ed2 < this.bdH.get(i2, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                        this.bdH.put(i2, ed2);
                        this.bdG.put(i2, f);
                    }
                    tB = i;
                }
            }
            i = this.bdH.size();
            for (i2 = 0; i2 < i; i2++) {
                ed = this.bdH.keyAt(i2);
                C37243u.this.bdz.put(ed, true);
                C37245v c37245v = (C37245v) this.bdG.valueAt(i2);
                if (c37245v != null) {
                    if (c37245v != C37243u.this.bdC) {
                        c37245v.mo42784a(c45042s, C37243u.this.baf, new C8661d(readUnsignedShort, ed, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    }
                    C37243u.this.bdy.put(this.bdH.valueAt(i2), c37245v);
                }
            }
            if (C37243u.this.mode != 2) {
                C37243u.this.bdy.remove(this.pid);
                C37243u.this.bdA = C37243u.this.mode == 1 ? 0 : C37243u.this.bdA - 1;
                if (C37243u.this.bdA == 0) {
                    C37243u.this.baf.mo19158rb();
                    C37243u.this.bdB = true;
                }
            } else if (!C37243u.this.bdB) {
                C37243u.this.baf.mo19158rb();
                C37243u.this.bdA = 0;
                C37243u.this.bdB = true;
                AppMethodBeat.m2505o(95169);
                return;
            }
            AppMethodBeat.m2505o(95169);
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.f.u$a */
    class C37244a implements C17642q {
        private final C32064k bdD = new C32064k(new byte[4]);

        public C37244a() {
            AppMethodBeat.m2504i(95166);
            AppMethodBeat.m2505o(95166);
        }

        /* renamed from: a */
        public final void mo32324a(C45042s c45042s, C8662g c8662g, C8661d c8661d) {
        }

        /* renamed from: t */
        public final void mo32325t(C32065l c32065l) {
            AppMethodBeat.m2504i(95167);
            if (c32065l.readUnsignedByte() != 0) {
                AppMethodBeat.m2505o(95167);
                return;
            }
            c32065l.mo52369eM(7);
            int tB = c32065l.mo52382tB() / 4;
            for (int i = 0; i < tB; i++) {
                c32065l.mo52365c(this.bdD, 4);
                int ed = this.bdD.mo52354ed(16);
                this.bdD.mo52355ee(3);
                if (ed == 0) {
                    this.bdD.mo52355ee(13);
                } else {
                    ed = this.bdD.mo52354ed(13);
                    C37243u.this.bdy.put(ed, new C25527r(new C37242b(ed)));
                    C37243u.this.bdA = C37243u.this.bdA + 1;
                }
            }
            if (C37243u.this.mode != 2) {
                C37243u.this.bdy.remove(0);
            }
            AppMethodBeat.m2505o(95167);
        }
    }

    static {
        AppMethodBeat.m2504i(95177);
        AppMethodBeat.m2505o(95177);
    }

    public C37243u() {
        this((byte) 0);
    }

    private C37243u(byte b) {
        this(1, 0);
    }

    public C37243u(int i, int i2) {
        this(i, new C45042s(0), new C37239e(i2));
        AppMethodBeat.m2504i(95170);
        AppMethodBeat.m2505o(95170);
    }

    public C37243u(int i, C45042s c45042s, C25530c c25530c) {
        AppMethodBeat.m2504i(95171);
        this.bdx = (C25530c) C45039a.checkNotNull(c25530c);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.bdu = Collections.singletonList(c45042s);
        } else {
            this.bdu = new ArrayList();
            this.bdu.add(c45042s);
        }
        this.bdv = new C32065l(9400);
        this.bdz = new SparseBooleanArray();
        this.bdy = new SparseArray();
        this.bdw = new SparseIntArray();
        m62482rw();
        AppMethodBeat.m2505o(95171);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(95172);
        byte[] bArr = this.bdv.data;
        c45026f.mo59479b(bArr, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 != 5) {
                if (bArr[(i2 * 188) + i] == (byte) 71) {
                    i2++;
                } else {
                    i++;
                }
            }
            c45026f.mo59482dG(i);
            AppMethodBeat.m2505o(95172);
            return true;
        }
        AppMethodBeat.m2505o(95172);
        return false;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(95173);
        this.baf = c8662g;
        c8662g.mo19156a(new C17646a(-9223372036854775807L));
        AppMethodBeat.m2505o(95173);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(95174);
        int size = this.bdu.size();
        for (int i = 0; i < size; i++) {
            ((C45042s) this.bdu.get(i)).brL = -9223372036854775807L;
        }
        this.bdv.reset();
        this.bdw.clear();
        m62482rw();
        AppMethodBeat.m2505o(95174);
    }

    /* JADX WARNING: Missing block: B:42:0x00c0, code skipped:
            if (r7 != ((r9 + 1) & 15)) goto L_0x00c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        int tB;
        int read;
        int i = 1;
        AppMethodBeat.m2504i(95175);
        byte[] bArr = this.bdv.data;
        if (9400 - this.bdv.position < 188) {
            tB = this.bdv.mo52382tB();
            if (tB > 0) {
                System.arraycopy(bArr, this.bdv.position, bArr, 0, tB);
            }
            this.bdv.mo52371n(bArr, tB);
        }
        while (this.bdv.mo52382tB() < 188) {
            tB = this.bdv.limit;
            read = c45026f.read(bArr, tB, 9400 - tB);
            if (read == -1) {
                AppMethodBeat.m2505o(95175);
                return -1;
            }
            this.bdv.mo52368eL(tB + read);
        }
        read = this.bdv.limit;
        int i2 = this.bdv.position;
        while (i2 < read && bArr[i2] != (byte) 71) {
            i2++;
        }
        this.bdv.setPosition(i2);
        int i3 = i2 + 188;
        if (i3 > read) {
            AppMethodBeat.m2505o(95175);
            return 0;
        }
        int readInt = this.bdv.readInt();
        if ((8388608 & readInt) != 0) {
            this.bdv.setPosition(i3);
            AppMethodBeat.m2505o(95175);
            return 0;
        }
        int i4;
        boolean z = (4194304 & readInt) != 0;
        int i5 = (2096896 & readInt) >> 8;
        if ((readInt & 32) != 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if ((readInt & 16) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.mode != 2) {
            readInt &= 15;
            int i6 = this.bdw.get(i5, readInt - 1);
            this.bdw.put(i5, readInt);
            if (i6 == readInt) {
                if (i2 != 0) {
                    this.bdv.setPosition(i3);
                    AppMethodBeat.m2505o(95175);
                    return 0;
                }
            }
        }
        i = 0;
        if (i4 != 0) {
            this.bdv.mo52369eM(this.bdv.readUnsignedByte());
        }
        if (i2 != 0) {
            C37245v c37245v = (C37245v) this.bdy.get(i5);
            if (c37245v != null) {
                if (i != 0) {
                    c37245v.mo42785rn();
                }
                this.bdv.mo52368eL(i3);
                c37245v.mo42783a(this.bdv, z);
                this.bdv.mo52368eL(read);
            }
        }
        this.bdv.setPosition(i3);
        AppMethodBeat.m2505o(95175);
        return 0;
    }

    /* renamed from: rw */
    private void m62482rw() {
        AppMethodBeat.m2504i(95176);
        this.bdz.clear();
        this.bdy.clear();
        SparseArray rv = this.bdx.mo42787rv();
        int size = rv.size();
        for (int i = 0; i < size; i++) {
            this.bdy.put(rv.keyAt(i), rv.valueAt(i));
        }
        this.bdy.put(0, new C25527r(new C37244a()));
        this.bdC = null;
        AppMethodBeat.m2505o(95176);
    }
}
