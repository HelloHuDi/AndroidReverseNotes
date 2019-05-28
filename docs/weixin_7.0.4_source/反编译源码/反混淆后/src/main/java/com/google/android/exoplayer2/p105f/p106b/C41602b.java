package com.google.android.exoplayer2.p105f.p106b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.SparseArray;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.b.b */
final class C41602b {
    private static final byte[] bmB = new byte[]{(byte) 0, (byte) 7, (byte) 8, (byte) 15};
    private static final byte[] bmC = new byte[]{(byte) 0, (byte) 119, (byte) -120, (byte) -1};
    private static final byte[] bmD = new byte[]{(byte) 0, (byte) 17, (byte) 34, (byte) 51, (byte) 68, (byte) 85, (byte) 102, (byte) 119, (byte) -120, (byte) -103, (byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
    private Bitmap bitmap;
    private final Paint bmE = new Paint();
    private final Paint bmF;
    private final Canvas bmG;
    private final C32045b bmH;
    private final C37250a bmI;
    final C37251h bmJ;

    /* renamed from: com.google.android.exoplayer2.f.b.b$c */
    static final class C0853c {
        public final boolean bmR;
        public final byte[] bmS;
        public final byte[] bmT;
        /* renamed from: id */
        public final int f1034id;

        public C0853c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f1034id = i;
            this.bmR = z;
            this.bmS = bArr;
            this.bmT = bArr2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$d */
    static final class C0854d {
        public final int bmU;
        public final SparseArray<C8671e> bmV;
        public final int state;
        public final int version;

        public C0854d(int i, int i2, int i3, SparseArray<C8671e> sparseArray) {
            this.bmU = i;
            this.version = i2;
            this.state = i3;
            this.bmV = sparseArray;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$f */
    static final class C0855f {
        public final boolean bmY;
        public final int bmZ;
        public final int bna;
        public final int bnb;
        public final int bnc;
        public final int bnd;
        public final int bne;
        public final SparseArray<C32046g> bnf;
        public final int height;
        /* renamed from: id */
        public final int f1035id;
        public final int width;

        public C0855f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<C32046g> sparseArray) {
            this.f1035id = i;
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

        /* renamed from: a */
        public final void mo2573a(C0855f c0855f) {
            AppMethodBeat.m2504i(95624);
            if (c0855f == null) {
                AppMethodBeat.m2505o(95624);
                return;
            }
            SparseArray sparseArray = c0855f.bnf;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.bnf.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
            AppMethodBeat.m2505o(95624);
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$e */
    static final class C8671e {
        public final int bmW;
        public final int bmX;

        public C8671e(int i, int i2) {
            this.bmW = i;
            this.bmX = i2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$b */
    static final class C32045b {
        public final int bmN;
        public final int bmO;
        public final int bmP;
        public final int bmQ;
        public final int height;
        public final int width;

        public C32045b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.bmN = i3;
            this.bmO = i4;
            this.bmP = i5;
            this.bmQ = i6;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$g */
    static final class C32046g {
        public final int bng;
        public final int bnh;
        public final int bni;
        public final int bnj;
        public final int bnk;
        public final int type;

        public C32046g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.bng = i2;
            this.bnh = i3;
            this.bni = i4;
            this.bnj = i5;
            this.bnk = i6;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$a */
    static final class C37250a {
        public final int[] bmK;
        public final int[] bmL;
        public final int[] bmM;
        /* renamed from: id */
        public final int f15848id;

        public C37250a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f15848id = i;
            this.bmK = iArr;
            this.bmL = iArr2;
            this.bmM = iArr3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$h */
    static final class C37251h {
        public final SparseArray<C0855f> bmV = new SparseArray();
        public final int bnl;
        public final int bnm;
        public final SparseArray<C37250a> bnn = new SparseArray();
        public final SparseArray<C0853c> bno = new SparseArray();
        public final SparseArray<C37250a> bnp = new SparseArray();
        public final SparseArray<C0853c> bnq = new SparseArray();
        public C32045b bnr;
        public C0854d bns;

        public C37251h(int i, int i2) {
            AppMethodBeat.m2504i(95625);
            this.bnl = i;
            this.bnm = i2;
            AppMethodBeat.m2505o(95625);
        }
    }

    public C41602b(int i, int i2) {
        AppMethodBeat.m2504i(95626);
        this.bmE.setStyle(Style.FILL_AND_STROKE);
        this.bmE.setXfermode(new PorterDuffXfermode(Mode.SRC));
        this.bmE.setPathEffect(null);
        this.bmF = new Paint();
        this.bmF.setStyle(Style.FILL);
        this.bmF.setXfermode(new PorterDuffXfermode(Mode.DST_OVER));
        this.bmF.setPathEffect(null);
        this.bmG = new Canvas();
        this.bmH = new C32045b(719, 575, 0, 719, 0, 575);
        this.bmI = new C37250a(0, C41602b.m72874sY(), C41602b.m72875sZ(), C41602b.m72876ta());
        this.bmJ = new C37251h(i, i2);
        AppMethodBeat.m2505o(95626);
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x02e1 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0279  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final List<C32044a> mo66736g(byte[] bArr, int i) {
        int ed;
        int ed2;
        int ty;
        int ed3;
        int ed4;
        C37250a b;
        AppMethodBeat.m2504i(95627);
        C32064k c32064k = new C32064k(bArr, i);
        while (c32064k.mo52362tx() >= 48 && c32064k.mo52354ed(8) == 15) {
            C37251h c37251h = this.bmJ;
            ed = c32064k.mo52354ed(8);
            int ed5 = c32064k.mo52354ed(16);
            ed2 = c32064k.mo52354ed(16);
            ty = c32064k.mo52363ty() + ed2;
            if (ed2 * 8 > c32064k.mo52362tx()) {
                c32064k.mo52355ee(c32064k.mo52362tx());
            } else {
                int ed6;
                int ed7;
                C0854d c0854d;
                switch (ed) {
                    case 16:
                        if (ed5 == c37251h.bnl) {
                            C0854d c0854d2 = c37251h.bns;
                            ed3 = c32064k.mo52354ed(8);
                            ed4 = c32064k.mo52354ed(4);
                            ed6 = c32064k.mo52354ed(2);
                            c32064k.mo52355ee(2);
                            ed = ed2 - 2;
                            SparseArray sparseArray = new SparseArray();
                            while (ed > 0) {
                                ed7 = c32064k.mo52354ed(8);
                                c32064k.mo52355ee(8);
                                ed -= 6;
                                sparseArray.put(ed7, new C8671e(c32064k.mo52354ed(16), c32064k.mo52354ed(16)));
                            }
                            c0854d = new C0854d(ed3, ed4, ed6, sparseArray);
                            if (c0854d.state == 0) {
                                if (!(c0854d2 == null || c0854d2.version == c0854d.version)) {
                                    c37251h.bns = c0854d;
                                    break;
                                }
                            }
                            c37251h.bns = c0854d;
                            c37251h.bmV.clear();
                            c37251h.bnn.clear();
                            c37251h.bno.clear();
                            break;
                        }
                        break;
                    case 17:
                        c0854d = c37251h.bns;
                        if (ed5 == c37251h.bnl && c0854d != null) {
                            C0855f a = C41602b.m72868a(c32064k, ed2);
                            if (c0854d.state == 0) {
                                a.mo2573a((C0855f) c37251h.bmV.get(a.f1035id));
                            }
                            c37251h.bmV.put(a.f1035id, a);
                            break;
                        }
                    case 18:
                        if (ed5 != c37251h.bnl) {
                            if (ed5 == c37251h.bnm) {
                                b = C41602b.m72871b(c32064k, ed2);
                                c37251h.bnp.put(b.f15848id, b);
                                break;
                            }
                        }
                        b = C41602b.m72871b(c32064k, ed2);
                        c37251h.bnn.put(b.f15848id, b);
                        break;
                        break;
                    case 19:
                        C0853c b2;
                        if (ed5 != c37251h.bnl) {
                            if (ed5 == c37251h.bnm) {
                                b2 = C41602b.m72872b(c32064k);
                                c37251h.bnq.put(b2.f1034id, b2);
                                break;
                            }
                        }
                        b2 = C41602b.m72872b(c32064k);
                        c37251h.bno.put(b2.f1034id, b2);
                        break;
                        break;
                    case 20:
                        if (ed5 == c37251h.bnl) {
                            c32064k.mo52355ee(4);
                            boolean rl = c32064k.mo52358rl();
                            c32064k.mo52355ee(3);
                            ed5 = c32064k.mo52354ed(16);
                            ed2 = c32064k.mo52354ed(16);
                            if (rl) {
                                ed3 = c32064k.mo52354ed(16);
                                ed4 = c32064k.mo52354ed(16);
                                ed6 = c32064k.mo52354ed(16);
                                ed7 = c32064k.mo52354ed(16);
                            } else {
                                ed3 = 0;
                                ed6 = 0;
                                ed7 = ed2;
                                ed4 = ed5;
                            }
                            c37251h.bnr = new C32045b(ed5, ed2, ed3, ed4, ed6, ed7);
                            break;
                        }
                        break;
                }
                ed5 = ty - c32064k.mo52363ty();
                C45039a.checkState(c32064k.baG == 0);
                c32064k.baF += ed5;
                c32064k.mo52359rm();
            }
        }
        if (this.bmJ.bns == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(95627);
            return emptyList;
        }
        C32045b c32045b;
        if (this.bmJ.bnr != null) {
            c32045b = this.bmJ.bnr;
        } else {
            c32045b = this.bmH;
        }
        if (!(this.bitmap != null && c32045b.width + 1 == this.bitmap.getWidth() && c32045b.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(c32045b.width + 1, c32045b.height + 1, Config.ARGB_8888);
            this.bmG.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = this.bmJ.bns.bmV;
        ed = 0;
        while (true) {
            ty = ed;
            if (ty < sparseArray2.size()) {
                C37250a c37250a;
                SparseArray sparseArray3;
                int i2;
                C8671e c8671e = (C8671e) sparseArray2.valueAt(ty);
                C0855f c0855f = (C0855f) this.bmJ.bmV.get(sparseArray2.keyAt(ty));
                int i3 = c8671e.bmW + c32045b.bmN;
                int i4 = c8671e.bmX + c32045b.bmP;
                this.bmG.clipRect((float) i3, (float) i4, (float) Math.min(c0855f.width + i3, c32045b.bmO), (float) Math.min(c0855f.height + i4, c32045b.bmQ), Op.REPLACE);
                b = (C37250a) this.bmJ.bnn.get(c0855f.bnb);
                if (b == null) {
                    b = (C37250a) this.bmJ.bnp.get(c0855f.bnb);
                    if (b == null) {
                        c37250a = this.bmI;
                        sparseArray3 = c0855f.bnf;
                        ed = 0;
                        while (true) {
                            i2 = ed;
                            if (i2 >= sparseArray3.size()) {
                                C0853c c0853c;
                                ed2 = sparseArray3.keyAt(i2);
                                C32046g c32046g = (C32046g) sparseArray3.valueAt(i2);
                                C0853c c0853c2 = (C0853c) this.bmJ.bno.get(ed2);
                                if (c0853c2 == null) {
                                    c0853c = (C0853c) this.bmJ.bnq.get(ed2);
                                } else {
                                    c0853c = c0853c2;
                                }
                                if (c0853c != null) {
                                    Paint paint;
                                    int[] iArr;
                                    if (c0853c.bmR) {
                                        paint = null;
                                    } else {
                                        paint = this.bmE;
                                    }
                                    ed2 = c0855f.bna;
                                    ed3 = i3 + c32046g.bnh;
                                    ed4 = i4 + c32046g.bni;
                                    Canvas canvas = this.bmG;
                                    if (ed2 == 3) {
                                        iArr = c37250a.bmM;
                                    } else if (ed2 == 2) {
                                        iArr = c37250a.bmL;
                                    } else {
                                        iArr = c37250a.bmK;
                                    }
                                    C41602b.m72869a(c0853c.bmS, iArr, ed2, ed3, ed4, paint, canvas);
                                    C41602b.m72869a(c0853c.bmT, iArr, ed2, ed3, ed4 + 1, paint, canvas);
                                }
                                ed = i2 + 1;
                            } else {
                                if (c0855f.bmY) {
                                    if (c0855f.bna == 3) {
                                        ed = c37250a.bmM[c0855f.bnc];
                                    } else if (c0855f.bna == 2) {
                                        ed = c37250a.bmL[c0855f.bnd];
                                    } else {
                                        ed = c37250a.bmK[c0855f.bne];
                                    }
                                    this.bmF.setColor(ed);
                                    this.bmG.drawRect((float) i3, (float) i4, (float) (c0855f.width + i3), (float) (c0855f.height + i4), this.bmF);
                                }
                                arrayList.add(new C32044a(Bitmap.createBitmap(this.bitmap, i3, i4, c0855f.width, c0855f.height), ((float) i3) / ((float) c32045b.width), ((float) i4) / ((float) c32045b.height), ((float) c0855f.width) / ((float) c32045b.width), ((float) c0855f.height) / ((float) c32045b.height)));
                                this.bmG.drawColor(0, Mode.CLEAR);
                                ed = ty + 1;
                            }
                        }
                    }
                }
                c37250a = b;
                sparseArray3 = c0855f.bnf;
                ed = 0;
                while (true) {
                    i2 = ed;
                    if (i2 >= sparseArray3.size()) {
                    }
                    ed = i2 + 1;
                }
            } else {
                AppMethodBeat.m2505o(95627);
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    private static C0855f m72868a(C32064k c32064k, int i) {
        AppMethodBeat.m2504i(95628);
        int ed = c32064k.mo52354ed(8);
        c32064k.mo52355ee(4);
        boolean rl = c32064k.mo52358rl();
        c32064k.mo52355ee(3);
        int ed2 = c32064k.mo52354ed(16);
        int ed3 = c32064k.mo52354ed(16);
        int ed4 = c32064k.mo52354ed(3);
        int ed5 = c32064k.mo52354ed(3);
        c32064k.mo52355ee(2);
        int ed6 = c32064k.mo52354ed(8);
        int ed7 = c32064k.mo52354ed(8);
        int ed8 = c32064k.mo52354ed(4);
        int ed9 = c32064k.mo52354ed(2);
        c32064k.mo52355ee(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int ed10 = c32064k.mo52354ed(16);
            int ed11 = c32064k.mo52354ed(2);
            int ed12 = c32064k.mo52354ed(2);
            int ed13 = c32064k.mo52354ed(12);
            c32064k.mo52355ee(4);
            int ed14 = c32064k.mo52354ed(12);
            int i3 = i2 - 6;
            int i4 = 0;
            int i5 = 0;
            if (ed11 == 1 || ed11 == 2) {
                i4 = c32064k.mo52354ed(8);
                i5 = c32064k.mo52354ed(8);
                i3 -= 2;
            }
            i2 = i3;
            sparseArray.put(ed10, new C32046g(ed11, ed12, ed13, ed14, i4, i5));
        }
        C0855f c0855f = new C0855f(ed, rl, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, sparseArray);
        AppMethodBeat.m2505o(95628);
        return c0855f;
    }

    /* renamed from: b */
    private static C37250a m72871b(C32064k c32064k, int i) {
        AppMethodBeat.m2504i(95629);
        int ed = c32064k.mo52354ed(8);
        c32064k.mo52355ee(8);
        int i2 = i - 2;
        int[] sY = C41602b.m72874sY();
        int[] sZ = C41602b.m72875sZ();
        int[] ta = C41602b.m72876ta();
        while (i2 > 0) {
            int[] iArr;
            int ed2;
            int ed3;
            int ed4;
            int ed5 = c32064k.mo52354ed(8);
            int ed6 = c32064k.mo52354ed(8);
            i2 -= 2;
            if ((ed6 & 128) != 0) {
                iArr = sY;
            } else if ((ed6 & 64) != 0) {
                iArr = sZ;
            } else {
                iArr = ta;
            }
            if ((ed6 & 1) != 0) {
                ed2 = c32064k.mo52354ed(8);
                ed3 = c32064k.mo52354ed(8);
                ed4 = c32064k.mo52354ed(8);
                ed6 = c32064k.mo52354ed(8);
                i2 -= 4;
            } else {
                ed2 = c32064k.mo52354ed(6) << 2;
                ed3 = c32064k.mo52354ed(4) << 4;
                ed4 = c32064k.mo52354ed(4) << 4;
                ed6 = c32064k.mo52354ed(2) << 6;
                i2 -= 2;
            }
            if (ed2 == 0) {
                ed3 = 0;
                ed4 = 0;
                ed6 = 255;
            }
            iArr[ed5] = C41602b.m72873n((byte) (255 - (ed6 & 255)), C17675v.m27578u((int) (((double) ed2) + (1.402d * ((double) (ed3 - 128)))), 0, 255), C17675v.m27578u((int) ((((double) ed2) - (0.34414d * ((double) (ed4 - 128)))) - (0.71414d * ((double) (ed3 - 128)))), 0, 255), C17675v.m27578u((int) (((double) ed2) + (1.772d * ((double) (ed4 - 128)))), 0, 255));
        }
        C37250a c37250a = new C37250a(ed, sY, sZ, ta);
        AppMethodBeat.m2505o(95629);
        return c37250a;
    }

    /* renamed from: b */
    private static C0853c m72872b(C32064k c32064k) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = null;
        AppMethodBeat.m2504i(95630);
        int ed = c32064k.mo52354ed(16);
        c32064k.mo52355ee(4);
        int ed2 = c32064k.mo52354ed(2);
        boolean rl = c32064k.mo52358rl();
        c32064k.mo52355ee(1);
        if (ed2 == 1) {
            c32064k.mo52355ee(c32064k.mo52354ed(8) * 16);
            bArr = null;
            bArr2 = null;
        } else if (ed2 == 0) {
            ed2 = c32064k.mo52354ed(16);
            int ed3 = c32064k.mo52354ed(16);
            if (ed2 > 0) {
                bArr3 = new byte[ed2];
                c32064k.mo52357p(bArr3, ed2);
            }
            if (ed3 > 0) {
                bArr = new byte[ed3];
                c32064k.mo52357p(bArr, ed3);
                bArr2 = bArr3;
            } else {
                bArr = bArr3;
                bArr2 = bArr3;
            }
        } else {
            bArr = null;
            bArr2 = null;
        }
        C0853c c0853c = new C0853c(ed, rl, bArr2, bArr);
        AppMethodBeat.m2505o(95630);
        return c0853c;
    }

    /* renamed from: sY */
    private static int[] m72874sY() {
        return new int[]{0, -1, WebView.NIGHT_MODE_COLOR, -8421505};
    }

    /* renamed from: sZ */
    private static int[] m72875sZ() {
        AppMethodBeat.m2504i(95631);
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
                iArr[i] = C41602b.m72873n(255, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = C41602b.m72873n(255, (i & 1) != 0 ? C31128d.MIC_SketchMark : 0, (i & 2) != 0 ? C31128d.MIC_SketchMark : 0, (i & 4) != 0 ? C31128d.MIC_SketchMark : 0);
            }
        }
        AppMethodBeat.m2505o(95631);
        return iArr;
    }

    /* renamed from: ta */
    private static int[] m72876ta() {
        AppMethodBeat.m2504i(95632);
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i >= 8) {
                switch (i & C19395n.CTRL_INDEX) {
                    case 0:
                        iArr[i] = C41602b.m72873n(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 64) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 8:
                        iArr[i] = C41602b.m72873n(C31128d.MIC_SketchMark, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0), ((i & 64) != 0 ? ErrorCode.NEEDDOWNLOAD_TRUE : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 128:
                        iArr[i] = C41602b.m72873n(255, (((i & 1) != 0 ? 43 : 0) + C31128d.MIC_SketchMark) + ((i & 16) != 0 ? 85 : 0), (((i & 2) != 0 ? 43 : 0) + C31128d.MIC_SketchMark) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + (((i & 4) != 0 ? 43 : 0) + C31128d.MIC_SketchMark));
                        break;
                    case C19395n.CTRL_INDEX /*136*/:
                        iArr[i] = C41602b.m72873n(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + ((i & 4) != 0 ? 43 : 0));
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
            iArr[i] = C41602b.m72873n(63, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
        }
        AppMethodBeat.m2505o(95632);
        return iArr;
    }

    /* renamed from: n */
    private static int m72873n(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    /* renamed from: a */
    private static void m72869a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        AppMethodBeat.m2504i(95633);
        C32064k c32064k = new C32064k(bArr);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        int i4 = i2;
        while (c32064k.mo52362tx() != 0) {
            int ed;
            byte[] bArr4;
            Object obj;
            int i5;
            int i6;
            int i7;
            Object i72;
            switch (c32064k.mo52354ed(8)) {
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
                        ed = c32064k.mo52354ed(2);
                        if (ed == 0) {
                            if (!c32064k.mo52358rl()) {
                                if (!c32064k.mo52358rl()) {
                                    switch (c32064k.mo52354ed(2)) {
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
                                            i4 = c32064k.mo52354ed(4) + 12;
                                            ed = c32064k.mo52354ed(2);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        case 3:
                                            i4 = c32064k.mo52354ed(8) + 29;
                                            ed = c32064k.mo52354ed(2);
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
                                i4 = c32064k.mo52354ed(3) + 3;
                                ed = c32064k.mo52354ed(2);
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
                            c32064k.mo52361tA();
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
                        ed = c32064k.mo52354ed(4);
                        if (ed == 0) {
                            if (c32064k.mo52358rl()) {
                                if (c32064k.mo52358rl()) {
                                    switch (c32064k.mo52354ed(2)) {
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
                                            i4 = c32064k.mo52354ed(4) + 9;
                                            ed = c32064k.mo52354ed(4);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        case 3:
                                            i4 = c32064k.mo52354ed(8) + 25;
                                            ed = c32064k.mo52354ed(4);
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
                                i4 = c32064k.mo52354ed(2) + 4;
                                ed = c32064k.mo52354ed(4);
                                i6 = i4;
                                i72 = obj;
                            } else {
                                ed = c32064k.mo52354ed(3);
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
                            c32064k.mo52361tA();
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
                        ed = c32064k.mo52354ed(8);
                        if (ed != 0) {
                            i5 = 1;
                            i72 = obj;
                        } else if (c32064k.mo52358rl()) {
                            i4 = c32064k.mo52354ed(7);
                            ed = c32064k.mo52354ed(8);
                            i5 = i4;
                            i72 = obj;
                        } else {
                            int ed2 = c32064k.mo52354ed(7);
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
                    bArr3 = C41602b.m72870a(4, 4, c32064k);
                    continue;
                case 33:
                    bArr2 = C41602b.m72870a(4, 8, c32064k);
                    continue;
                case 34:
                    bArr2 = C41602b.m72870a(16, 8, c32064k);
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
        AppMethodBeat.m2505o(95633);
    }

    /* renamed from: a */
    private static byte[] m72870a(int i, int i2, C32064k c32064k) {
        AppMethodBeat.m2504i(95634);
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c32064k.mo52354ed(i2);
        }
        AppMethodBeat.m2505o(95634);
        return bArr;
    }
}
