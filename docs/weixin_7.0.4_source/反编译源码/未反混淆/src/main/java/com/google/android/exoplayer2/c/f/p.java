package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.az;

public final class p implements e {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(95148);
            e[] eVarArr = new e[]{new p()};
            AppMethodBeat.o(95148);
            return eVarArr;
        }
    };
    private final s aYf;
    private g baf;
    private final SparseArray<a> bdf;
    private final l bdg;
    private boolean bdh;
    private boolean bdi;
    private boolean bdj;

    static final class a {
        long aSk;
        final s aYf;
        final k bcY = new k(new byte[64]);
        boolean bcZ;
        boolean bda;
        boolean bdb;
        int bdc;
        final h bdk;

        public a(h hVar, s sVar) {
            AppMethodBeat.i(95149);
            this.bdk = hVar;
            this.aYf = sVar;
            AppMethodBeat.o(95149);
        }
    }

    static {
        AppMethodBeat.i(95156);
        AppMethodBeat.o(95156);
    }

    public p() {
        this(new s(0));
        AppMethodBeat.i(95150);
        AppMethodBeat.o(95150);
    }

    private p(s sVar) {
        AppMethodBeat.i(95151);
        this.aYf = sVar;
        this.bdg = new l(4096);
        this.bdf = new SparseArray();
        AppMethodBeat.o(95151);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(95152);
        byte[] bArr = new byte[14];
        fVar.b(bArr, 0, 14);
        if (JsApiInstallDownloadTask.CTRL_INDEX != (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255))) {
            AppMethodBeat.o(95152);
            return false;
        } else if ((bArr[4] & 196) != 68) {
            AppMethodBeat.o(95152);
            return false;
        } else if ((bArr[6] & 4) != 4) {
            AppMethodBeat.o(95152);
            return false;
        } else if ((bArr[8] & 4) != 4) {
            AppMethodBeat.o(95152);
            return false;
        } else if ((bArr[9] & 1) != 1) {
            AppMethodBeat.o(95152);
            return false;
        } else if ((bArr[12] & 3) != 3) {
            AppMethodBeat.o(95152);
            return false;
        } else {
            fVar.dH(bArr[13] & 7);
            fVar.b(bArr, 0, 3);
            if (1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)))) {
                AppMethodBeat.o(95152);
                return true;
            }
            AppMethodBeat.o(95152);
            return false;
        }
    }

    public final void a(g gVar) {
        AppMethodBeat.i(95153);
        this.baf = gVar;
        gVar.a(new com.google.android.exoplayer2.c.l.a(-9223372036854775807L));
        AppMethodBeat.o(95153);
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(95154);
        this.aYf.brL = -9223372036854775807L;
        for (int i = 0; i < this.bdf.size(); i++) {
            a aVar = (a) this.bdf.valueAt(i);
            aVar.bdb = false;
            aVar.bdk.rn();
        }
        AppMethodBeat.o(95154);
    }

    public final int a(f fVar, com.google.android.exoplayer2.c.k kVar) {
        AppMethodBeat.i(95155);
        if (fVar.b(this.bdg.data, 0, 4, true)) {
            this.bdg.setPosition(0);
            int readInt = this.bdg.readInt();
            if (readInt == JsApiQueryDownloadTask.CTRL_INDEX) {
                AppMethodBeat.o(95155);
                return -1;
            } else if (readInt == JsApiInstallDownloadTask.CTRL_INDEX) {
                fVar.b(this.bdg.data, 0, 10);
                this.bdg.setPosition(9);
                fVar.dG((this.bdg.readUnsignedByte() & 7) + 14);
                AppMethodBeat.o(95155);
                return 0;
            } else if (readInt == JsApiPauseDownloadTask.CTRL_INDEX) {
                fVar.b(this.bdg.data, 0, 2);
                this.bdg.setPosition(0);
                fVar.dG(this.bdg.readUnsignedShort() + 6);
                AppMethodBeat.o(95155);
                return 0;
            } else if (((readInt & -256) >> 8) != 1) {
                fVar.dG(1);
                AppMethodBeat.o(95155);
                return 0;
            } else {
                int i = readInt & 255;
                a aVar = (a) this.bdf.get(i);
                if (!this.bdh) {
                    if (aVar == null) {
                        h hVar = null;
                        if (!this.bdi && i == 189) {
                            hVar = new b();
                            this.bdi = true;
                        } else if (!this.bdi && (i & 224) == az.CTRL_INDEX) {
                            hVar = new m();
                            this.bdi = true;
                        } else if (!this.bdj && (i & 240) == 224) {
                            hVar = new i();
                            this.bdj = true;
                        }
                        if (hVar != null) {
                            hVar.a(this.baf, new d(i, 256));
                            aVar = new a(hVar, this.aYf);
                            this.bdf.put(i, aVar);
                        }
                    }
                    if ((this.bdi && this.bdj) || fVar.getPosition() > 1048576) {
                        this.bdh = true;
                        this.baf.rb();
                    }
                }
                fVar.b(this.bdg.data, 0, 2);
                this.bdg.setPosition(0);
                int readUnsignedShort = this.bdg.readUnsignedShort() + 6;
                if (aVar == null) {
                    fVar.dG(readUnsignedShort);
                } else {
                    this.bdg.reset(readUnsignedShort);
                    fVar.readFully(this.bdg.data, 0, readUnsignedShort);
                    this.bdg.setPosition(6);
                    l lVar = this.bdg;
                    lVar.readBytes(aVar.bcY.data, 0, 3);
                    aVar.bcY.setPosition(0);
                    aVar.bcY.ee(8);
                    aVar.bcZ = aVar.bcY.rl();
                    aVar.bda = aVar.bcY.rl();
                    aVar.bcY.ee(6);
                    aVar.bdc = aVar.bcY.ed(8);
                    lVar.readBytes(aVar.bcY.data, 0, aVar.bdc);
                    aVar.bcY.setPosition(0);
                    aVar.aSk = 0;
                    if (aVar.bcZ) {
                        aVar.bcY.ee(4);
                        long ed = ((long) aVar.bcY.ed(3)) << 30;
                        aVar.bcY.ee(1);
                        ed |= (long) (aVar.bcY.ed(15) << 15);
                        aVar.bcY.ee(1);
                        ed |= (long) aVar.bcY.ed(15);
                        aVar.bcY.ee(1);
                        if (!aVar.bdb && aVar.bda) {
                            aVar.bcY.ee(4);
                            long ed2 = ((long) aVar.bcY.ed(3)) << 30;
                            aVar.bcY.ee(1);
                            ed2 |= (long) (aVar.bcY.ed(15) << 15);
                            aVar.bcY.ee(1);
                            ed2 |= (long) aVar.bcY.ed(15);
                            aVar.bcY.ee(1);
                            aVar.aYf.ao(ed2);
                            aVar.bdb = true;
                        }
                        aVar.aSk = aVar.aYf.ao(ed);
                    }
                    aVar.bdk.d(aVar.aSk, true);
                    aVar.bdk.t(lVar);
                    aVar.bdk.ro();
                    this.bdg.eL(this.bdg.capacity());
                }
                AppMethodBeat.o(95155);
                return 0;
            }
        }
        AppMethodBeat.o(95155);
        return -1;
    }
}
