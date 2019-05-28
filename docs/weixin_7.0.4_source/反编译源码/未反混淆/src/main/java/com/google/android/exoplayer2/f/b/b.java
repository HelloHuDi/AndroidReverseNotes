package com.google.android.exoplayer2.f.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.SparseArray;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {
    private static final byte[] bmB = new byte[]{(byte) 0, (byte) 7, (byte) 8, (byte) 15};
    private static final byte[] bmC = new byte[]{(byte) 0, (byte) 119, (byte) -120, (byte) -1};
    private static final byte[] bmD = new byte[]{(byte) 0, (byte) 17, (byte) 34, (byte) 51, (byte) 68, (byte) 85, (byte) 102, (byte) 119, (byte) -120, (byte) -103, (byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
    private Bitmap bitmap;
    private final Paint bmE = new Paint();
    private final Paint bmF;
    private final Canvas bmG;
    private final b bmH;
    private final a bmI;
    final h bmJ;

    static final class c {
        public final boolean bmR;
        public final byte[] bmS;
        public final byte[] bmT;
        public final int id;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.bmR = z;
            this.bmS = bArr;
            this.bmT = bArr2;
        }
    }

    static final class d {
        public final int bmU;
        public final SparseArray<e> bmV;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.bmU = i;
            this.version = i2;
            this.state = i3;
            this.bmV = sparseArray;
        }
    }

    static final class f {
        public final boolean bmY;
        public final int bmZ;
        public final int bna;
        public final int bnb;
        public final int bnc;
        public final int bnd;
        public final int bne;
        public final SparseArray<g> bnf;
        public final int height;
        public final int id;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.bmY = z;
            this.width = i2;
            this.height = i3;
            this.bmZ = i4;
            this.bna = i5;
            this.bnb = i6;
            this.bnc = i7;
            this.bnd = i8;
            this.bne = i9;
            this.bnf = sparseArray;
        }

        public final void a(f fVar) {
            AppMethodBeat.i(95624);
            if (fVar == null) {
                AppMethodBeat.o(95624);
                return;
            }
            SparseArray sparseArray = fVar.bnf;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.bnf.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
            AppMethodBeat.o(95624);
        }
    }

    static final class e {
        public final int bmW;
        public final int bmX;

        public e(int i, int i2) {
            this.bmW = i;
            this.bmX = i2;
        }
    }

    static final class b {
        public final int bmN;
        public final int bmO;
        public final int bmP;
        public final int bmQ;
        public final int height;
        public final int width;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.bmN = i3;
            this.bmO = i4;
            this.bmP = i5;
            this.bmQ = i6;
        }
    }

    static final class g {
        public final int bng;
        public final int bnh;
        public final int bni;
        public final int bnj;
        public final int bnk;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.bng = i2;
            this.bnh = i3;
            this.bni = i4;
            this.bnj = i5;
            this.bnk = i6;
        }
    }

    static final class a {
        public final int[] bmK;
        public final int[] bmL;
        public final int[] bmM;
        public final int id;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.bmK = iArr;
            this.bmL = iArr2;
            this.bmM = iArr3;
        }
    }

    static final class h {
        public final SparseArray<f> bmV = new SparseArray();
        public final int bnl;
        public final int bnm;
        public final SparseArray<a> bnn = new SparseArray();
        public final SparseArray<c> bno = new SparseArray();
        public final SparseArray<a> bnp = new SparseArray();
        public final SparseArray<c> bnq = new SparseArray();
        public b bnr;
        public d bns;

        public h(int i, int i2) {
            AppMethodBeat.i(95625);
            this.bnl = i;
            this.bnm = i2;
            AppMethodBeat.o(95625);
        }
    }

    public b(int i, int i2) {
        AppMethodBeat.i(95626);
        this.bmE.setStyle(Style.FILL_AND_STROKE);
        this.bmE.setXfermode(new PorterDuffXfermode(Mode.SRC));
        this.bmE.setPathEffect(null);
        this.bmF = new Paint();
        this.bmF.setStyle(Style.FILL);
        this.bmF.setXfermode(new PorterDuffXfermode(Mode.DST_OVER));
        this.bmF.setPathEffect(null);
        this.bmG = new Canvas();
        this.bmH = new b(719, 575, 0, 719, 0, 575);
        this.bmI = new a(0, sY(), sZ(), ta());
        this.bmJ = new h(i, i2);
        AppMethodBeat.o(95626);
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x02e1 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0279  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<com.google.android.exoplayer2.f.a> g(byte[] bArr, int i) {
        int ed;
        int ed2;
        int ty;
        int ed3;
        int ed4;
        a b;
        AppMethodBeat.i(95627);
        k kVar = new k(bArr, i);
        while (kVar.tx() >= 48 && kVar.ed(8) == 15) {
            h hVar = this.bmJ;
            ed = kVar.ed(8);
            int ed5 = kVar.ed(16);
            ed2 = kVar.ed(16);
            ty = kVar.ty() + ed2;
            if (ed2 * 8 > kVar.tx()) {
                kVar.ee(kVar.tx());
            } else {
                int ed6;
                int ed7;
                d dVar;
                switch (ed) {
                    case 16:
                        if (ed5 == hVar.bnl) {
                            d dVar2 = hVar.bns;
                            ed3 = kVar.ed(8);
                            ed4 = kVar.ed(4);
                            ed6 = kVar.ed(2);
                            kVar.ee(2);
                            ed = ed2 - 2;
                            SparseArray sparseArray = new SparseArray();
                            while (ed > 0) {
                                ed7 = kVar.ed(8);
                                kVar.ee(8);
                                ed -= 6;
                                sparseArray.put(ed7, new e(kVar.ed(16), kVar.ed(16)));
                            }
                            dVar = new d(ed3, ed4, ed6, sparseArray);
                            if (dVar.state == 0) {
                                if (!(dVar2 == null || dVar2.version == dVar.version)) {
                                    hVar.bns = dVar;
                                    break;
                                }
                            }
                            hVar.bns = dVar;
                            hVar.bmV.clear();
                            hVar.bnn.clear();
                            hVar.bno.clear();
                            break;
                        }
                        break;
                    case 17:
                        dVar = hVar.bns;
                        if (ed5 == hVar.bnl && dVar != null) {
                            f a = a(kVar, ed2);
                            if (dVar.state == 0) {
                                a.a((f) hVar.bmV.get(a.id));
                            }
                            hVar.bmV.put(a.id, a);
                            break;
                        }
                    case 18:
                        if (ed5 != hVar.bnl) {
                            if (ed5 == hVar.bnm) {
                                b = b(kVar, ed2);
                                hVar.bnp.put(b.id, b);
                                break;
                            }
                        }
                        b = b(kVar, ed2);
                        hVar.bnn.put(b.id, b);
                        break;
                        break;
                    case 19:
                        c b2;
                        if (ed5 != hVar.bnl) {
                            if (ed5 == hVar.bnm) {
                                b2 = b(kVar);
                                hVar.bnq.put(b2.id, b2);
                                break;
                            }
                        }
                        b2 = b(kVar);
                        hVar.bno.put(b2.id, b2);
                        break;
                        break;
                    case 20:
                        if (ed5 == hVar.bnl) {
                            kVar.ee(4);
                            boolean rl = kVar.rl();
                            kVar.ee(3);
                            ed5 = kVar.ed(16);
                            ed2 = kVar.ed(16);
                            if (rl) {
                                ed3 = kVar.ed(16);
                                ed4 = kVar.ed(16);
                                ed6 = kVar.ed(16);
                                ed7 = kVar.ed(16);
                            } else {
                                ed3 = 0;
                                ed6 = 0;
                                ed7 = ed2;
                                ed4 = ed5;
                            }
                            hVar.bnr = new b(ed5, ed2, ed3, ed4, ed6, ed7);
                            break;
                        }
                        break;
                }
                ed5 = ty - kVar.ty();
                com.google.android.exoplayer2.i.a.checkState(kVar.baG == 0);
                kVar.baF += ed5;
                kVar.rm();
            }
        }
        if (this.bmJ.bns == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(95627);
            return emptyList;
        }
        b bVar;
        if (this.bmJ.bnr != null) {
            bVar = this.bmJ.bnr;
        } else {
            bVar = this.bmH;
        }
        if (!(this.bitmap != null && bVar.width + 1 == this.bitmap.getWidth() && bVar.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(bVar.width + 1, bVar.height + 1, Config.ARGB_8888);
            this.bmG.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = this.bmJ.bns.bmV;
        ed = 0;
        while (true) {
            ty = ed;
            if (ty < sparseArray2.size()) {
                a aVar;
                SparseArray sparseArray3;
                int i2;
                e eVar = (e) sparseArray2.valueAt(ty);
                f fVar = (f) this.bmJ.bmV.get(sparseArray2.keyAt(ty));
                int i3 = eVar.bmW + bVar.bmN;
                int i4 = eVar.bmX + bVar.bmP;
                this.bmG.clipRect((float) i3, (float) i4, (float) Math.min(fVar.width + i3, bVar.bmO), (float) Math.min(fVar.height + i4, bVar.bmQ), Op.REPLACE);
                b = (a) this.bmJ.bnn.get(fVar.bnb);
                if (b == null) {
                    b = (a) this.bmJ.bnp.get(fVar.bnb);
                    if (b == null) {
                        aVar = this.bmI;
                        sparseArray3 = fVar.bnf;
                        ed = 0;
                        while (true) {
                            i2 = ed;
                            if (i2 >= sparseArray3.size()) {
                                c cVar;
                                ed2 = sparseArray3.keyAt(i2);
                                g gVar = (g) sparseArray3.valueAt(i2);
                                c cVar2 = (c) this.bmJ.bno.get(ed2);
                                if (cVar2 == null) {
                                    cVar = (c) this.bmJ.bnq.get(ed2);
                                } else {
                                    cVar = cVar2;
                                }
                                if (cVar != null) {
                                    Paint paint;
                                    int[] iArr;
                                    if (cVar.bmR) {
                                        paint = null;
                                    } else {
                                        paint = this.bmE;
                                    }
                                    ed2 = fVar.bna;
                                    ed3 = i3 + gVar.bnh;
                                    ed4 = i4 + gVar.bni;
                                    Canvas canvas = this.bmG;
                                    if (ed2 == 3) {
                                        iArr = aVar.bmM;
                                    } else if (ed2 == 2) {
                                        iArr = aVar.bmL;
                                    } else {
                                        iArr = aVar.bmK;
                                    }
                                    a(cVar.bmS, iArr, ed2, ed3, ed4, paint, canvas);
                                    a(cVar.bmT, iArr, ed2, ed3, ed4 + 1, paint, canvas);
                                }
                                ed = i2 + 1;
                            } else {
                                if (fVar.bmY) {
                                    if (fVar.bna == 3) {
                                        ed = aVar.bmM[fVar.bnc];
                                    } else if (fVar.bna == 2) {
                                        ed = aVar.bmL[fVar.bnd];
                                    } else {
                                        ed = aVar.bmK[fVar.bne];
                                    }
                                    this.bmF.setColor(ed);
                                    this.bmG.drawRect((float) i3, (float) i4, (float) (fVar.width + i3), (float) (fVar.height + i4), this.bmF);
                                }
                                arrayList.add(new com.google.android.exoplayer2.f.a(Bitmap.createBitmap(this.bitmap, i3, i4, fVar.width, fVar.height), ((float) i3) / ((float) bVar.width), ((float) i4) / ((float) bVar.height), ((float) fVar.width) / ((float) bVar.width), ((float) fVar.height) / ((float) bVar.height)));
                                this.bmG.drawColor(0, Mode.CLEAR);
                                ed = ty + 1;
                            }
                        }
                    }
                }
                aVar = b;
                sparseArray3 = fVar.bnf;
                ed = 0;
                while (true) {
                    i2 = ed;
                    if (i2 >= sparseArray3.size()) {
                    }
                    ed = i2 + 1;
                }
            } else {
                AppMethodBeat.o(95627);
                return arrayList;
            }
        }
    }

    private static f a(k kVar, int i) {
        AppMethodBeat.i(95628);
        int ed = kVar.ed(8);
        kVar.ee(4);
        boolean rl = kVar.rl();
        kVar.ee(3);
        int ed2 = kVar.ed(16);
        int ed3 = kVar.ed(16);
        int ed4 = kVar.ed(3);
        int ed5 = kVar.ed(3);
        kVar.ee(2);
        int ed6 = kVar.ed(8);
        int ed7 = kVar.ed(8);
        int ed8 = kVar.ed(4);
        int ed9 = kVar.ed(2);
        kVar.ee(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int ed10 = kVar.ed(16);
            int ed11 = kVar.ed(2);
            int ed12 = kVar.ed(2);
            int ed13 = kVar.ed(12);
            kVar.ee(4);
            int ed14 = kVar.ed(12);
            int i3 = i2 - 6;
            int i4 = 0;
            int i5 = 0;
            if (ed11 == 1 || ed11 == 2) {
                i4 = kVar.ed(8);
                i5 = kVar.ed(8);
                i3 -= 2;
            }
            i2 = i3;
            sparseArray.put(ed10, new g(ed11, ed12, ed13, ed14, i4, i5));
        }
        f fVar = new f(ed, rl, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, sparseArray);
        AppMethodBeat.o(95628);
        return fVar;
    }

    private static a b(k kVar, int i) {
        AppMethodBeat.i(95629);
        int ed = kVar.ed(8);
        kVar.ee(8);
        int i2 = i - 2;
        int[] sY = sY();
        int[] sZ = sZ();
        int[] ta = ta();
        while (i2 > 0) {
            int[] iArr;
            int ed2;
            int ed3;
            int ed4;
            int ed5 = kVar.ed(8);
            int ed6 = kVar.ed(8);
            i2 -= 2;
            if ((ed6 & 128) != 0) {
                iArr = sY;
            } else if ((ed6 & 64) != 0) {
                iArr = sZ;
            } else {
                iArr = ta;
            }
            if ((ed6 & 1) != 0) {
                ed2 = kVar.ed(8);
                ed3 = kVar.ed(8);
                ed4 = kVar.ed(8);
                ed6 = kVar.ed(8);
                i2 -= 4;
            } else {
                ed2 = kVar.ed(6) << 2;
                ed3 = kVar.ed(4) << 4;
                ed4 = kVar.ed(4) << 4;
                ed6 = kVar.ed(2) << 6;
                i2 -= 2;
            }
            if (ed2 == 0) {
                ed3 = 0;
                ed4 = 0;
                ed6 = 255;
            }
            iArr[ed5] = n((byte) (255 - (ed6 & 255)), v.u((int) (((double) ed2) + (1.402d * ((double) (ed3 - 128)))), 0, 255), v.u((int) ((((double) ed2) - (0.34414d * ((double) (ed4 - 128)))) - (0.71414d * ((double) (ed3 - 128)))), 0, 255), v.u((int) (((double) ed2) + (1.772d * ((double) (ed4 - 128)))), 0, 255));
        }
        a aVar = new a(ed, sY, sZ, ta);
        AppMethodBeat.o(95629);
        return aVar;
    }

    private static c b(k kVar) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = null;
        AppMethodBeat.i(95630);
        int ed = kVar.ed(16);
        kVar.ee(4);
        int ed2 = kVar.ed(2);
        boolean rl = kVar.rl();
        kVar.ee(1);
        if (ed2 == 1) {
            kVar.ee(kVar.ed(8) * 16);
            bArr = null;
            bArr2 = null;
        } else if (ed2 == 0) {
            ed2 = kVar.ed(16);
            int ed3 = kVar.ed(16);
            if (ed2 > 0) {
                bArr3 = new byte[ed2];
                kVar.p(bArr3, ed2);
            }
            if (ed3 > 0) {
                bArr = new byte[ed3];
                kVar.p(bArr, ed3);
                bArr2 = bArr3;
            } else {
                bArr = bArr3;
                bArr2 = bArr3;
            }
        } else {
            bArr = null;
            bArr2 = null;
        }
        c cVar = new c(ed, rl, bArr2, bArr);
        AppMethodBeat.o(95630);
        return cVar;
    }

    private static int[] sY() {
        return new int[]{0, -1, WebView.NIGHT_MODE_COLOR, -8421505};
    }

    private static int[] sZ() {
        AppMethodBeat.i(95631);
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                int i2;
                if ((i & 1) != 0) {
                    i2 = 255;
                } else {
                    i2 = 0;
                }
                iArr[i] = n(255, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = n(255, (i & 1) != 0 ? com.tencent.view.d.MIC_SketchMark : 0, (i & 2) != 0 ? com.tencent.view.d.MIC_SketchMark : 0, (i & 4) != 0 ? com.tencent.view.d.MIC_SketchMark : 0);
            }
        }
        AppMethodBeat.o(95631);
        return iArr;
    }

    private static int[] ta() {
        AppMethodBeat.i(95632);
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i >= 8) {
                switch (i & n.CTRL_INDEX) {
                    case 0:
                        iArr[i] = n(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 64) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 8:
                        iArr[i] = n(com.tencent.view.d.MIC_SketchMark, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 64) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 128:
                        iArr[i] = n(255, (((i & 1) != 0 ? 43 : 0) + com.tencent.view.d.MIC_SketchMark) + ((i & 16) != 0 ? 85 : 0), (((i & 2) != 0 ? 43 : 0) + com.tencent.view.d.MIC_SketchMark) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + (((i & 4) != 0 ? 43 : 0) + com.tencent.view.d.MIC_SketchMark));
                        break;
                    case n.CTRL_INDEX /*136*/:
                        iArr[i] = n(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + ((i & 4) != 0 ? 43 : 0));
                        break;
                    default:
                        break;
                }
            }
            int i2;
            if ((i & 1) != 0) {
                i2 = 255;
            } else {
                i2 = 0;
            }
            iArr[i] = n(63, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
        }
        AppMethodBeat.o(95632);
        return iArr;
    }

    private static int n(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        AppMethodBeat.i(95633);
        k kVar = new k(bArr);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        int i4 = i2;
        while (kVar.tx() != 0) {
            int ed;
            byte[] bArr4;
            Object obj;
            int i5;
            int i6;
            int i7;
            Object i72;
            switch (kVar.ed(8)) {
                case 16:
                    if (i == 3) {
                        byte[] bArr5;
                        if (bArr2 == null) {
                            bArr5 = bmC;
                        } else {
                            bArr5 = bArr2;
                        }
                        bArr4 = bArr5;
                    } else if (i == 2) {
                        bArr4 = bArr3 == null ? bmB : bArr3;
                    } else {
                        bArr4 = null;
                    }
                    obj = null;
                    i5 = i4;
                    while (true) {
                        ed = kVar.ed(2);
                        if (ed == 0) {
                            if (!kVar.rl()) {
                                if (!kVar.rl()) {
                                    switch (kVar.ed(2)) {
                                        case 0:
                                            ed = 0;
                                            i6 = 0;
                                            i72 = 1;
                                            break;
                                        case 1:
                                            ed = 0;
                                            i6 = 2;
                                            i72 = obj;
                                            break;
                                        case 2:
                                            i4 = kVar.ed(4) + 12;
                                            ed = kVar.ed(2);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        case 3:
                                            i4 = kVar.ed(8) + 29;
                                            ed = kVar.ed(2);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        default:
                                            ed = 0;
                                            i6 = 0;
                                            i72 = obj;
                                            break;
                                    }
                                }
                                ed = 0;
                                i6 = 1;
                                i72 = obj;
                            } else {
                                i4 = kVar.ed(3) + 3;
                                ed = kVar.ed(2);
                                i6 = i4;
                                i72 = obj;
                            }
                        } else {
                            i6 = 1;
                            i72 = obj;
                        }
                        if (!(i6 == 0 || paint == null)) {
                            if (bArr4 != null) {
                                ed = bArr4[ed];
                            }
                            paint.setColor(iArr[ed]);
                            canvas.drawRect((float) i5, (float) i3, (float) (i5 + i6), (float) (i3 + 1), paint);
                        }
                        ed = i5 + i6;
                        if (i72 != null) {
                            kVar.tA();
                            i4 = ed;
                            continue;
                        } else {
                            obj = i72;
                            i5 = ed;
                        }
                    }
                case 17:
                    if (i == 3) {
                        bArr4 = bmD;
                    } else {
                        bArr4 = null;
                    }
                    obj = null;
                    i5 = i4;
                    while (true) {
                        ed = kVar.ed(4);
                        if (ed == 0) {
                            if (kVar.rl()) {
                                if (kVar.rl()) {
                                    switch (kVar.ed(2)) {
                                        case 0:
                                            ed = 0;
                                            i6 = 1;
                                            i72 = obj;
                                            break;
                                        case 1:
                                            ed = 0;
                                            i6 = 2;
                                            i72 = obj;
                                            break;
                                        case 2:
                                            i4 = kVar.ed(4) + 9;
                                            ed = kVar.ed(4);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        case 3:
                                            i4 = kVar.ed(8) + 25;
                                            ed = kVar.ed(4);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        default:
                                            ed = 0;
                                            i6 = 0;
                                            i72 = obj;
                                            break;
                                    }
                                }
                                i4 = kVar.ed(2) + 4;
                                ed = kVar.ed(4);
                                i6 = i4;
                                i72 = obj;
                            } else {
                                ed = kVar.ed(3);
                                if (ed != 0) {
                                    i4 = ed + 2;
                                    ed = 0;
                                    i6 = i4;
                                    i72 = obj;
                                } else {
                                    ed = 0;
                                    i6 = 0;
                                    i72 = 1;
                                }
                            }
                        } else {
                            i6 = 1;
                            i72 = obj;
                        }
                        if (!(i6 == 0 || paint == null)) {
                            if (bArr4 != null) {
                                ed = bArr4[ed];
                            }
                            paint.setColor(iArr[ed]);
                            canvas.drawRect((float) i5, (float) i3, (float) (i5 + i6), (float) (i3 + 1), paint);
                        }
                        ed = i5 + i6;
                        if (i72 != null) {
                            kVar.tA();
                            i4 = ed;
                            continue;
                        } else {
                            obj = i72;
                            i5 = ed;
                        }
                    }
                case 18:
                    int i8 = i4;
                    obj = null;
                    while (true) {
                        ed = kVar.ed(8);
                        if (ed != 0) {
                            i5 = 1;
                            i72 = obj;
                        } else if (kVar.rl()) {
                            i4 = kVar.ed(7);
                            ed = kVar.ed(8);
                            i5 = i4;
                            i72 = obj;
                        } else {
                            int ed2 = kVar.ed(7);
                            if (ed2 != 0) {
                                ed = 0;
                                i5 = ed2;
                                i72 = obj;
                            } else {
                                ed = 0;
                                i5 = 0;
                                i72 = 1;
                            }
                        }
                        if (!(i5 == 0 || paint == null)) {
                            paint.setColor(iArr[ed]);
                            canvas.drawRect((float) i8, (float) i3, (float) (i8 + i5), (float) (i3 + 1), paint);
                        }
                        ed = i8 + i5;
                        if (i72 != null) {
                            i4 = ed;
                            continue;
                        } else {
                            i8 = ed;
                            obj = i72;
                        }
                    }
                case 32:
                    bArr3 = a(4, 4, kVar);
                    continue;
                case 33:
                    bArr2 = a(4, 8, kVar);
                    continue;
                case 34:
                    bArr2 = a(16, 8, kVar);
                    continue;
                case 240:
                    i3 += 2;
                    ed = i2;
                    break;
                default:
                    ed = i4;
                    break;
            }
            i4 = ed;
        }
        AppMethodBeat.o(95633);
    }

    private static byte[] a(int i, int i2, k kVar) {
        AppMethodBeat.i(95634);
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) kVar.ed(i2);
        }
        AppMethodBeat.o(95634);
        return bArr;
    }
}
