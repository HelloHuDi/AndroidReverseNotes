package com.tencent.mm.at.a.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.c.a;
import com.tencent.mm.at.a.c.d;
import com.tencent.mm.at.a.c.e;
import com.tencent.mm.at.a.c.f;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.at.a.c.k;
import com.tencent.mm.at.a.c.l;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.at.a.c.n;
import com.tencent.mm.at.a.c.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b implements Runnable {
    private final com.tencent.mm.at.a.a.b fGK = this.fHp.fGK;
    public final c fGS;
    private final m fGT;
    private final a fGU;
    private final com.tencent.mm.at.a.c.b fGV;
    private final j fGX;
    private final e fGZ;
    private final n fHc;
    private final o fHk;
    private final com.tencent.mm.at.a.b fHp;
    public final com.tencent.mm.at.a.c fHr;
    private final ak fHs;
    private final i fHt;
    private final g fHu;
    private final f fHv;
    private final k fHw;
    private final d fHx;
    private final l fHy;
    public final String url;

    public b(String str, com.tencent.mm.at.a.c cVar, ak akVar, c cVar2, i iVar, com.tencent.mm.at.a.b bVar, g gVar) {
        AppMethodBeat.i(116106);
        this.url = str;
        this.fHr = cVar;
        this.fHs = akVar;
        this.fHp = bVar;
        this.fHu = gVar;
        if (cVar2 == null) {
            this.fGS = this.fGK.fGS;
        } else {
            this.fGS = cVar2;
        }
        this.fHt = iVar;
        this.fGX = this.fGK.fGX;
        if (this.fGS.fGV != null) {
            this.fGV = this.fGS.fGV;
        } else {
            this.fGV = this.fGK.fGV;
        }
        this.fHk = this.fGS.fHk;
        this.fGT = this.fGK.fGT;
        this.fGU = this.fGK.fGU;
        this.fHv = this.fGK.fGW;
        this.fHw = this.fGK.fGY;
        this.fGZ = this.fGK.fGZ;
        this.fHx = null;
        this.fHy = null;
        this.fHc = this.fGK.fHc;
        AppMethodBeat.o(116106);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:210:0x0607=Splitter:B:210:0x0607, B:61:0x020e=Splitter:B:61:0x020e, B:44:0x019f=Splitter:B:44:0x019f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.i(116107);
        Bitmap bitmap = null;
        com.tencent.mm.at.a.d.b bVar = new com.tencent.mm.at.a.d.b();
        bVar.from = 1;
        Bitmap b;
        InputStream inputStream;
        Exception e;
        com.tencent.mm.at.a.d.b bVar2;
        try {
            o oVar;
            long currentTimeMillis;
            String sJ = sJ(this.url);
            ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", this.url);
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.fGS.fHe;
            boolean z = this.fGS.ePP;
            String str = this.fGS.cvZ;
            ab.d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:".concat(String.valueOf(z)));
            ab.d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", Integer.valueOf(i));
            ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", Integer.valueOf(this.fHr.width), Integer.valueOf(this.fHr.height));
            switch (i) {
                case 1:
                    String str2 = this.fGS.thumbPath;
                    if (!this.fGS.fHh || bo.isNullOrNil(str2) || !com.tencent.mm.vfs.e.ct(str2)) {
                        if (!bo.isNullOrNil(this.url)) {
                            if (!com.tencent.mm.vfs.e.ct(this.url)) {
                                ab.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.fHw.aM(str, this.url)) {
                                    ab.w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.fGS.eQa) {
                                b = com.tencent.mm.at.a.g.a.b(this.fHr, this.url, this.fGS.ePN, this.fGS.ePO);
                            } else if (this.fHk != null) {
                                inputStream = null;
                                oVar = this.fHk;
                                com.tencent.mm.vfs.d dVar = new com.tencent.mm.vfs.d(this.url);
                                inputStream = oVar.ahI();
                                b = com.tencent.mm.at.a.g.a.a(this.fHr, inputStream, this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                    }
                                }
                            } else {
                                b = this.fHx != null ? com.tencent.mm.at.a.g.a.a(this.fHr, this.fHx.i(this.fGS.eQd), this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ) : com.tencent.mm.at.a.g.a.a(this.fHr, this.url, this.fGS.ePN, this.fGS.ePO);
                            }
                            if (this.fGS.eQh && r4 == null && this.fHy != null) {
                                if (this.fHx != null) {
                                    b = this.fHy.X(this.fHx.i(this.fGS.eQd));
                                } else {
                                    b = this.fHy.sI(this.url);
                                }
                            }
                            if (b != null && this.fGS.density > 0) {
                                b.setDensity(this.fGS.density);
                            }
                            ab.d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        ab.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.fGS.eQa) {
                        b = com.tencent.mm.at.a.g.a.b(this.fHr, str2, this.fGS.ePN, this.fGS.ePO);
                    } else {
                        b = com.tencent.mm.at.a.g.a.a(this.fHr, str2, this.fGS.ePN, this.fGS.ePO);
                    }
                    try {
                        if (this.fGS.density > 0) {
                            b.setDensity(this.fGS.density);
                            bitmap = b;
                            break;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bVar2 = bVar;
                        break;
                    }
                    break;
                case 2:
                    bitmap = com.tencent.mm.at.a.g.a.c(this.fHr, this.url, this.fGS.ePN, this.fGS.ePO);
                    break;
                case 3:
                    bitmap = com.tencent.mm.at.a.g.a.a(this.fHr, this.fGK.aEH.getIdentifier(this.url, "drawable", this.fGK.packageName), this.fGS.ePN, this.fGS.ePO);
                    break;
                case 4:
                    bitmap = com.tencent.mm.at.a.g.a.a(this.fHr, Integer.valueOf(this.url).intValue(), this.fGS.ePN, this.fGS.ePO);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.fGU.d(this.url, this.fGS);
                    if (inputStream == null) {
                        b = null;
                    } else if (!z || this.fHw.b(str, inputStream)) {
                        if (this.fHk != null) {
                            inputStream = this.fHk.ahI();
                        }
                        b = com.tencent.mm.at.a.g.a.a(this.fHr, inputStream, this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ);
                        obj = 1;
                    } else {
                        obj = 1;
                        b = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (obj != null && b == null) {
                        this.fGU.c(this.url, this.fGS);
                        bitmap = b;
                        break;
                    }
                    break;
                default:
                    ab.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", Integer.valueOf(i));
                    break;
            }
            bitmap = b;
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                bVar2 = bVar;
                b = bitmap;
            }
            Bitmap bitmap2;
            int min;
            com.tencent.mm.at.a.b bVar3;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        ab.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap2 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.fHu != null) {
                            g gVar = this.fHu;
                            String str3 = this.url;
                            this.fHr.getImageView();
                            gVar.sH(str3);
                        }
                        if (this.fHc.sG(this.url)) {
                            bVar2 = this.fGV.sE(this.url);
                        } else {
                            ab.i("MicroMsg.imageloader.ImageLoadTask", "can not download image, over limit");
                            bVar2 = bVar;
                        }
                        if (bVar2 == null) {
                            try {
                                bVar = new com.tencent.mm.at.a.d.b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                b = bitmap;
                                break;
                            }
                        }
                        bVar = bVar2;
                        try {
                            bVar.from = 2;
                            if (bVar.data != null) {
                                if (z) {
                                    if (!this.fHw.p(str, bVar.data)) {
                                        bVar.status = 2;
                                        ab.w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap2 = null;
                                        break;
                                    }
                                }
                                ab.d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                byte[] bArr = bVar.data;
                                if (this.fHk != null) {
                                    oVar = this.fHk;
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    InputStream ahI = oVar.ahI();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                    while (true) {
                                        int read = ahI.read(bArr);
                                        if (read >= 0) {
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        } else {
                                            bArr = byteArrayOutputStream.toByteArray();
                                        }
                                    }
                                }
                                b = com.tencent.mm.at.a.g.a.a(this.fHr, bArr, this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ);
                                if (b != null) {
                                    byte[] bArr2 = bVar.data;
                                    if (this.fGS.ePH) {
                                        this.fGU.a(this.url, bArr2, this.fGS);
                                    }
                                    if (this.fGS.ePG) {
                                        this.fGU.a(this.url, bArr2, this.fGS);
                                    }
                                    if (this.fGS.eQf) {
                                        if (this.fGS.eQg != 0.0f) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, this.fGS.eQg);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = com.tencent.mm.sdk.platformtools.d.b(b, min, min, true);
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    b = a(bVar, b);
                                    k(sJ, b);
                                    fN(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap2 = b;
                                    break;
                                }
                                try {
                                    bVar.status = 3;
                                    bitmap2 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    bVar2 = bVar;
                                    break;
                                }
                            }
                            bVar.status = 1;
                            bitmap2 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            bVar2 = bVar;
                            b = bitmap;
                            break;
                        }
                    default:
                        ab.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap2 = bitmap;
                        break;
                }
                ab.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", e.toString());
                bVar = bVar2;
                bitmap2 = b;
                if (bitmap2 != null || bitmap2.isRecycled()) {
                    ab.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.fGS.fHf) {
                        bitmap2 = com.tencent.mm.sdk.platformtools.d.e(bitmap2, this.fGS.fHg);
                    }
                    c cVar = new c(this.url, this.fHr, bitmap2, this.fHp, sJ(this.url));
                    if (this.fHs != null) {
                        this.fHs.post(cVar);
                    }
                    bVar.bitmap = bitmap2;
                    bVar.status = 0;
                }
                if (!(this.fHu == null || bVar == null)) {
                    bVar.bitmap = bitmap2;
                    this.fHu.b(this.url, this.fHr.getImageView(), bVar);
                }
                this.fHt.a(this.url, this.fHr.getImageView(), bitmap2, this.fGS.eQd);
                bVar3 = this.fHp;
                if (!(bVar3.fGO == null || this.fHr == null)) {
                    bVar3.fGO.remove(Integer.valueOf(this.fHr.eQF));
                }
                AppMethodBeat.o(116107);
            }
            if (!this.fGS.eQf) {
                b = bitmap;
            } else if (this.fGS.eQg != 0.0f) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, this.fGS.eQg);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = com.tencent.mm.sdk.platformtools.d.b(bitmap, min, min, true);
                b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
            }
            b = a(bVar, b);
            k(sJ, b);
            fN(currentTimeMillis - currentTimeMillis2);
            ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap2 = b;
            if (bitmap2 != null) {
            }
            ab.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            bVar.bitmap = bitmap2;
            this.fHu.b(this.url, this.fHr.getImageView(), bVar);
            this.fHt.a(this.url, this.fHr.getImageView(), bitmap2, this.fGS.eQd);
            bVar3 = this.fHp;
            bVar3.fGO.remove(Integer.valueOf(this.fHr.eQF));
            AppMethodBeat.o(116107);
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            b = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
            AppMethodBeat.o(116107);
        }
    }

    private void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(116108);
        if (this.fGS.ePF) {
            ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", this.url);
            this.fGT.c(str, bitmap);
        }
        AppMethodBeat.o(116108);
    }

    private Bitmap a(com.tencent.mm.at.a.d.b bVar, Bitmap bitmap) {
        AppMethodBeat.i(116109);
        if (!(this.fHu == null || bVar == null)) {
            bVar.bitmap = bitmap;
            Bitmap a = this.fHu.a(this.url, this.fHr.getImageView(), bVar);
            if (!(a == null || a.isRecycled())) {
                AppMethodBeat.o(116109);
                return a;
            }
        }
        AppMethodBeat.o(116109);
        return bitmap;
    }

    public final String sJ(String str) {
        AppMethodBeat.i(116110);
        if (bo.isNullOrNil(str) || this.fGS == null) {
            AppMethodBeat.o(116110);
            return null;
        }
        if (this.fGS.eQf) {
            str = str + "round" + this.fGS.eQg;
        }
        if (!bo.isNullOrNil(this.fGS.ePX)) {
            str = str + this.fGS.ePX;
        }
        String str2 = str + "size" + this.fGS.ePN + this.fGS.ePO;
        AppMethodBeat.o(116110);
        return str2;
    }

    public final void fN(long j) {
        AppMethodBeat.i(116111);
        if (this.fGX != null) {
            this.fGX.fN(j);
        }
        AppMethodBeat.o(116111);
    }
}
