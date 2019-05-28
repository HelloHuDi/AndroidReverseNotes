package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v.c;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.v;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class u implements e {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(95165);
            e[] eVarArr = new e[]{new u()};
            AppMethodBeat.o(95165);
            return eVarArr;
        }
    };
    private static final long bdr = ((long) v.aT("AC-3"));
    private static final long bds = ((long) v.aT("EAC3"));
    private static final long bdt = ((long) v.aT("HEVC"));
    private g baf;
    private int bdA;
    private boolean bdB;
    private v bdC;
    private final List<s> bdu;
    private final l bdv;
    private final SparseIntArray bdw;
    private final c bdx;
    private final SparseArray<v> bdy;
    private final SparseBooleanArray bdz;
    private final int mode;

    class b implements q {
        private final k bdF = new k(new byte[5]);
        private final SparseArray<v> bdG = new SparseArray();
        private final SparseIntArray bdH = new SparseIntArray();
        private final int pid;

        public b(int i) {
            AppMethodBeat.i(95168);
            this.pid = i;
            AppMethodBeat.o(95168);
        }

        public final void a(s sVar, g gVar, d dVar) {
        }

        public final void t(l lVar) {
            AppMethodBeat.i(95169);
            if (lVar.readUnsignedByte() != 2) {
                AppMethodBeat.o(95169);
                return;
            }
            s sVar;
            int ed;
            int i;
            int i2;
            if (u.this.mode == 1 || u.this.mode == 2 || u.this.bdA == 1) {
                sVar = (s) u.this.bdu.get(0);
            } else {
                sVar = new s(((s) u.this.bdu.get(0)).bbh);
                u.this.bdu.add(sVar);
            }
            lVar.eM(2);
            int readUnsignedShort = lVar.readUnsignedShort();
            lVar.eM(5);
            lVar.c(this.bdF, 2);
            this.bdF.ee(4);
            lVar.eM(this.bdF.ed(12));
            if (u.this.mode == 2 && u.this.bdC == null) {
                u.this.bdC = u.this.bdx.a(21, new com.google.android.exoplayer2.c.f.v.b(21, null, null, new byte[0]));
                u.this.bdC.a(sVar, u.this.baf, new d(readUnsignedShort, 21, Utility.DEFAULT_STREAM_BUFFER_SIZE));
            }
            this.bdG.clear();
            this.bdH.clear();
            int tB = lVar.tB();
            while (tB > 0) {
                int i3;
                lVar.c(this.bdF, 5);
                ed = this.bdF.ed(8);
                this.bdF.ee(3);
                int ed2 = this.bdF.ed(13);
                this.bdF.ee(4);
                int ed3 = this.bdF.ed(12);
                int i4 = lVar.position;
                int i5 = i4 + ed3;
                i = -1;
                String str = null;
                List list = null;
                while (lVar.position < i5) {
                    int readUnsignedByte = lVar.readUnsignedByte();
                    int readUnsignedByte2 = lVar.readUnsignedByte() + lVar.position;
                    if (readUnsignedByte == 5) {
                        long cM = lVar.cM();
                        if (cM == u.bdr) {
                            i = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                        } else if (cM == u.bds) {
                            i = com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX;
                        } else if (cM == u.bdt) {
                            i = 36;
                        }
                    } else if (readUnsignedByte == 106) {
                        i = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                    } else if (readUnsignedByte == 122) {
                        i = com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX;
                    } else if (readUnsignedByte == 123) {
                        i = 138;
                    } else if (readUnsignedByte == 10) {
                        str = lVar.readString(3).trim();
                    } else if (readUnsignedByte == 89) {
                        i = 89;
                        list = new ArrayList();
                        while (lVar.position < readUnsignedByte2) {
                            String trim = lVar.readString(3).trim();
                            int readUnsignedByte3 = lVar.readUnsignedByte();
                            byte[] bArr = new byte[4];
                            lVar.readBytes(bArr, 0, 4);
                            list.add(new com.google.android.exoplayer2.c.f.v.a(trim, readUnsignedByte3, bArr));
                        }
                    }
                    lVar.eM(readUnsignedByte2 - lVar.position);
                }
                lVar.setPosition(i5);
                com.google.android.exoplayer2.c.f.v.b bVar = new com.google.android.exoplayer2.c.f.v.b(i, str, list, Arrays.copyOfRange(lVar.data, i4, i5));
                if (ed == 6) {
                    i3 = bVar.streamType;
                } else {
                    i3 = ed;
                }
                i = tB - (ed3 + 5);
                i2 = u.this.mode == 2 ? i3 : ed2;
                if (u.this.bdz.get(i2)) {
                    tB = i;
                } else {
                    Object f;
                    if (u.this.mode == 2 && i3 == 21) {
                        f = u.this.bdC;
                    } else {
                        f = u.this.bdx.a(i3, bVar);
                    }
                    if (u.this.mode != 2 || ed2 < this.bdH.get(i2, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                        this.bdH.put(i2, ed2);
                        this.bdG.put(i2, f);
                    }
                    tB = i;
                }
            }
            i = this.bdH.size();
            for (i2 = 0; i2 < i; i2++) {
                ed = this.bdH.keyAt(i2);
                u.this.bdz.put(ed, true);
                v vVar = (v) this.bdG.valueAt(i2);
                if (vVar != null) {
                    if (vVar != u.this.bdC) {
                        vVar.a(sVar, u.this.baf, new d(readUnsignedShort, ed, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    }
                    u.this.bdy.put(this.bdH.valueAt(i2), vVar);
                }
            }
            if (u.this.mode != 2) {
                u.this.bdy.remove(this.pid);
                u.this.bdA = u.this.mode == 1 ? 0 : u.this.bdA - 1;
                if (u.this.bdA == 0) {
                    u.this.baf.rb();
                    u.this.bdB = true;
                }
            } else if (!u.this.bdB) {
                u.this.baf.rb();
                u.this.bdA = 0;
                u.this.bdB = true;
                AppMethodBeat.o(95169);
                return;
            }
            AppMethodBeat.o(95169);
        }
    }

    class a implements q {
        private final k bdD = new k(new byte[4]);

        public a() {
            AppMethodBeat.i(95166);
            AppMethodBeat.o(95166);
        }

        public final void a(s sVar, g gVar, d dVar) {
        }

        public final void t(l lVar) {
            AppMethodBeat.i(95167);
            if (lVar.readUnsignedByte() != 0) {
                AppMethodBeat.o(95167);
                return;
            }
            lVar.eM(7);
            int tB = lVar.tB() / 4;
            for (int i = 0; i < tB; i++) {
                lVar.c(this.bdD, 4);
                int ed = this.bdD.ed(16);
                this.bdD.ee(3);
                if (ed == 0) {
                    this.bdD.ee(13);
                } else {
                    ed = this.bdD.ed(13);
                    u.this.bdy.put(ed, new r(new b(ed)));
                    u.this.bdA = u.this.bdA + 1;
                }
            }
            if (u.this.mode != 2) {
                u.this.bdy.remove(0);
            }
            AppMethodBeat.o(95167);
        }
    }

    static {
        AppMethodBeat.i(95177);
        AppMethodBeat.o(95177);
    }

    public u() {
        this((byte) 0);
    }

    private u(byte b) {
        this(1, 0);
    }

    public u(int i, int i2) {
        this(i, new s(0), new e(i2));
        AppMethodBeat.i(95170);
        AppMethodBeat.o(95170);
    }

    public u(int i, s sVar, c cVar) {
        AppMethodBeat.i(95171);
        this.bdx = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.bdu = Collections.singletonList(sVar);
        } else {
            this.bdu = new ArrayList();
            this.bdu.add(sVar);
        }
        this.bdv = new l(9400);
        this.bdz = new SparseBooleanArray();
        this.bdy = new SparseArray();
        this.bdw = new SparseIntArray();
        rw();
        AppMethodBeat.o(95171);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(95172);
        byte[] bArr = this.bdv.data;
        fVar.b(bArr, 0, 940);
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
            fVar.dG(i);
            AppMethodBeat.o(95172);
            return true;
        }
        AppMethodBeat.o(95172);
        return false;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(95173);
        this.baf = gVar;
        gVar.a(new com.google.android.exoplayer2.c.l.a(-9223372036854775807L));
        AppMethodBeat.o(95173);
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(95174);
        int size = this.bdu.size();
        for (int i = 0; i < size; i++) {
            ((s) this.bdu.get(i)).brL = -9223372036854775807L;
        }
        this.bdv.reset();
        this.bdw.clear();
        rw();
        AppMethodBeat.o(95174);
    }

    /* JADX WARNING: Missing block: B:42:0x00c0, code skipped:
            if (r7 != ((r9 + 1) & 15)) goto L_0x00c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(f fVar, com.google.android.exoplayer2.c.k kVar) {
        int tB;
        int read;
        int i = 1;
        AppMethodBeat.i(95175);
        byte[] bArr = this.bdv.data;
        if (9400 - this.bdv.position < 188) {
            tB = this.bdv.tB();
            if (tB > 0) {
                System.arraycopy(bArr, this.bdv.position, bArr, 0, tB);
            }
            this.bdv.n(bArr, tB);
        }
        while (this.bdv.tB() < 188) {
            tB = this.bdv.limit;
            read = fVar.read(bArr, tB, 9400 - tB);
            if (read == -1) {
                AppMethodBeat.o(95175);
                return -1;
            }
            this.bdv.eL(tB + read);
        }
        read = this.bdv.limit;
        int i2 = this.bdv.position;
        while (i2 < read && bArr[i2] != (byte) 71) {
            i2++;
        }
        this.bdv.setPosition(i2);
        int i3 = i2 + 188;
        if (i3 > read) {
            AppMethodBeat.o(95175);
            return 0;
        }
        int readInt = this.bdv.readInt();
        if ((8388608 & readInt) != 0) {
            this.bdv.setPosition(i3);
            AppMethodBeat.o(95175);
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
                    AppMethodBeat.o(95175);
                    return 0;
                }
            }
        }
        i = 0;
        if (i4 != 0) {
            this.bdv.eM(this.bdv.readUnsignedByte());
        }
        if (i2 != 0) {
            v vVar = (v) this.bdy.get(i5);
            if (vVar != null) {
                if (i != 0) {
                    vVar.rn();
                }
                this.bdv.eL(i3);
                vVar.a(this.bdv, z);
                this.bdv.eL(read);
            }
        }
        this.bdv.setPosition(i3);
        AppMethodBeat.o(95175);
        return 0;
    }

    private void rw() {
        AppMethodBeat.i(95176);
        this.bdz.clear();
        this.bdy.clear();
        SparseArray rv = this.bdx.rv();
        int size = rv.size();
        for (int i = 0; i < size; i++) {
            this.bdy.put(rv.keyAt(i), rv.valueAt(i));
        }
        this.bdy.put(0, new r(new a()));
        this.bdC = null;
        AppMethodBeat.o(95176);
    }
}
