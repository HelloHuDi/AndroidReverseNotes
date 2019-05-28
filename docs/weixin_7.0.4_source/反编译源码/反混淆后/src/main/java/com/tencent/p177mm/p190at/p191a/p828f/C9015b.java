package com.tencent.p177mm.p190at.p191a.p828f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p190at.p191a.C25817c;
import com.tencent.p177mm.p190at.p191a.C9012b;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p193c.C1283o;
import com.tencent.p177mm.p190at.p191a.p193c.C25816a;
import com.tencent.p177mm.p190at.p191a.p193c.C32279e;
import com.tencent.p177mm.p190at.p191a.p193c.C32280j;
import com.tencent.p177mm.p190at.p191a.p193c.C32281k;
import com.tencent.p177mm.p190at.p191a.p193c.C32282l;
import com.tencent.p177mm.p190at.p191a.p193c.C32283m;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.p190at.p191a.p193c.C37475d;
import com.tencent.p177mm.p190at.p191a.p193c.C37476n;
import com.tencent.p177mm.p190at.p191a.p193c.C9013f;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p829g.C25819a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C40922d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.at.a.f.b */
public final class C9015b implements Runnable {
    private final C17926b fGK = this.fHp.fGK;
    public final C25814c fGS;
    private final C32283m fGT;
    private final C25816a fGU;
    private final C37474b fGV;
    private final C32280j fGX;
    private final C32279e fGZ;
    private final C37476n fHc;
    private final C1283o fHk;
    private final C9012b fHp;
    public final C25817c fHr;
    private final C7306ak fHs;
    private final C1282i fHt;
    private final C9014g fHu;
    private final C9013f fHv;
    private final C32281k fHw;
    private final C37475d fHx;
    private final C32282l fHy;
    public final String url;

    public C9015b(String str, C25817c c25817c, C7306ak c7306ak, C25814c c25814c, C1282i c1282i, C9012b c9012b, C9014g c9014g) {
        AppMethodBeat.m2504i(116106);
        this.url = str;
        this.fHr = c25817c;
        this.fHs = c7306ak;
        this.fHp = c9012b;
        this.fHu = c9014g;
        if (c25814c == null) {
            this.fGS = this.fGK.fGS;
        } else {
            this.fGS = c25814c;
        }
        this.fHt = c1282i;
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
        AppMethodBeat.m2505o(116106);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:210:0x0607=Splitter:B:210:0x0607, B:61:0x020e=Splitter:B:61:0x020e, B:44:0x019f=Splitter:B:44:0x019f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.m2504i(116107);
        Bitmap bitmap = null;
        C37477b c37477b = new C37477b();
        c37477b.from = 1;
        Bitmap b;
        InputStream inputStream;
        Exception e;
        C37477b c37477b2;
        try {
            C1283o c1283o;
            long currentTimeMillis;
            String sJ = mo20448sJ(this.url);
            C4990ab.m7411d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", this.url);
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.fGS.fHe;
            boolean z = this.fGS.ePP;
            String str = this.fGS.cvZ;
            C4990ab.m7410d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:".concat(String.valueOf(z)));
            C4990ab.m7411d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", Integer.valueOf(i));
            C4990ab.m7411d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", Integer.valueOf(this.fHr.width), Integer.valueOf(this.fHr.height));
            switch (i) {
                case 1:
                    String str2 = this.fGS.thumbPath;
                    if (!this.fGS.fHh || C5046bo.isNullOrNil(str2) || !C5730e.m8628ct(str2)) {
                        if (!C5046bo.isNullOrNil(this.url)) {
                            if (!C5730e.m8628ct(this.url)) {
                                C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.fHw.mo52984aM(str, this.url)) {
                                    C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.fGS.eQa) {
                                b = C25819a.m41098b(this.fHr, this.url, this.fGS.ePN, this.fGS.ePO);
                            } else if (this.fHk != null) {
                                inputStream = null;
                                c1283o = this.fHk;
                                C40922d c40922d = new C40922d(this.url);
                                inputStream = c1283o.ahI();
                                b = C25819a.m41095a(this.fHr, inputStream, this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                    }
                                }
                            } else {
                                b = this.fHx != null ? C25819a.m41097a(this.fHr, this.fHx.mo54509i(this.fGS.eQd), this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ) : C25819a.m41096a(this.fHr, this.url, this.fGS.ePN, this.fGS.ePO);
                            }
                            if (this.fGS.eQh && r4 == null && this.fHy != null) {
                                if (this.fHx != null) {
                                    b = this.fHy.mo52987X(this.fHx.mo54509i(this.fGS.eQd));
                                } else {
                                    b = this.fHy.mo52988sI(this.url);
                                }
                            }
                            if (b != null && this.fGS.density > 0) {
                                b.setDensity(this.fGS.density);
                            }
                            C4990ab.m7410d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.fGS.eQa) {
                        b = C25819a.m41098b(this.fHr, str2, this.fGS.ePN, this.fGS.ePO);
                    } else {
                        b = C25819a.m41096a(this.fHr, str2, this.fGS.ePN, this.fGS.ePO);
                    }
                    try {
                        if (this.fGS.density > 0) {
                            b.setDensity(this.fGS.density);
                            bitmap = b;
                            break;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        c37477b2 = c37477b;
                        break;
                    }
                    break;
                case 2:
                    bitmap = C25819a.m41099c(this.fHr, this.url, this.fGS.ePN, this.fGS.ePO);
                    break;
                case 3:
                    bitmap = C25819a.m41094a(this.fHr, this.fGK.aEH.getIdentifier(this.url, "drawable", this.fGK.packageName), this.fGS.ePN, this.fGS.ePO);
                    break;
                case 4:
                    bitmap = C25819a.m41094a(this.fHr, Integer.valueOf(this.url).intValue(), this.fGS.ePN, this.fGS.ePO);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.fGU.mo43781d(this.url, this.fGS);
                    if (inputStream == null) {
                        b = null;
                    } else if (!z || this.fHw.mo52985b(str, inputStream)) {
                        if (this.fHk != null) {
                            inputStream = this.fHk.ahI();
                        }
                        b = C25819a.m41095a(this.fHr, inputStream, this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ);
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
                        this.fGU.mo43780c(this.url, this.fGS);
                        bitmap = b;
                        break;
                    }
                    break;
                default:
                    C4990ab.m7413e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", Integer.valueOf(i));
                    break;
            }
            bitmap = b;
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                c37477b2 = c37477b;
                b = bitmap;
            }
            Bitmap bitmap2;
            int min;
            C9012b c9012b;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap2 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        C4990ab.m7410d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.fHu != null) {
                            C9014g c9014g = this.fHu;
                            String str3 = this.url;
                            this.fHr.getImageView();
                            c9014g.mo7596sH(str3);
                        }
                        if (this.fHc.mo52983sG(this.url)) {
                            c37477b2 = this.fGV.mo33454sE(this.url);
                        } else {
                            C4990ab.m7416i("MicroMsg.imageloader.ImageLoadTask", "can not download image, over limit");
                            c37477b2 = c37477b;
                        }
                        if (c37477b2 == null) {
                            try {
                                c37477b = new C37477b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                b = bitmap;
                                break;
                            }
                        }
                        c37477b = c37477b2;
                        try {
                            c37477b.from = 2;
                            if (c37477b.data != null) {
                                if (z) {
                                    if (!this.fHw.mo52986p(str, c37477b.data)) {
                                        c37477b.status = 2;
                                        C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap2 = null;
                                        break;
                                    }
                                }
                                C4990ab.m7410d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                byte[] bArr = c37477b.data;
                                if (this.fHk != null) {
                                    c1283o = this.fHk;
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    InputStream ahI = c1283o.ahI();
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
                                b = C25819a.m41097a(this.fHr, bArr, this.fGS.ePN, this.fGS.ePO, this.fGS.ePS, this.fGS.alpha, this.fGS.ePQ);
                                if (b != null) {
                                    byte[] bArr2 = c37477b.data;
                                    if (this.fGS.ePH) {
                                        this.fGU.mo43778a(this.url, bArr2, this.fGS);
                                    }
                                    if (this.fGS.ePG) {
                                        this.fGU.mo43778a(this.url, bArr2, this.fGS);
                                    }
                                    if (this.fGS.eQf) {
                                        if (this.fGS.eQg != 0.0f) {
                                            b = C5056d.m7616a(b, false, this.fGS.eQg);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = C5056d.m7616a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = C5056d.m7649b(b, min, min, true);
                                            b = C5056d.m7616a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    b = m16280a(c37477b, b);
                                    m16281k(sJ, b);
                                    mo20446fN(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap2 = b;
                                    break;
                                }
                                try {
                                    c37477b.status = 3;
                                    bitmap2 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    c37477b2 = c37477b;
                                    break;
                                }
                            }
                            c37477b.status = 1;
                            bitmap2 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            c37477b2 = c37477b;
                            b = bitmap;
                            break;
                        }
                    default:
                        C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap2 = bitmap;
                        break;
                }
                C4990ab.m7413e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", e.toString());
                c37477b = c37477b2;
                bitmap2 = b;
                if (bitmap2 != null || bitmap2.isRecycled()) {
                    C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    C4990ab.m7410d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.fGS.fHf) {
                        bitmap2 = C5056d.m7660e(bitmap2, this.fGS.fHg);
                    }
                    C32284c c32284c = new C32284c(this.url, this.fHr, bitmap2, this.fHp, mo20448sJ(this.url));
                    if (this.fHs != null) {
                        this.fHs.post(c32284c);
                    }
                    c37477b.bitmap = bitmap2;
                    c37477b.status = 0;
                }
                if (!(this.fHu == null || c37477b == null)) {
                    c37477b.bitmap = bitmap2;
                    this.fHu.mo7595b(this.url, this.fHr.getImageView(), c37477b);
                }
                this.fHt.mo4581a(this.url, this.fHr.getImageView(), bitmap2, this.fGS.eQd);
                c9012b = this.fHp;
                if (!(c9012b.fGO == null || this.fHr == null)) {
                    c9012b.fGO.remove(Integer.valueOf(this.fHr.eQF));
                }
                AppMethodBeat.m2505o(116107);
            }
            if (!this.fGS.eQf) {
                b = bitmap;
            } else if (this.fGS.eQg != 0.0f) {
                b = C5056d.m7616a(bitmap, false, this.fGS.eQg);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = C5056d.m7616a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = C5056d.m7649b(bitmap, min, min, true);
                b = C5056d.m7616a(b, false, (float) (b.getWidth() / 2));
            }
            b = m16280a(c37477b, b);
            m16281k(sJ, b);
            mo20446fN(currentTimeMillis - currentTimeMillis2);
            C4990ab.m7410d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap2 = b;
            if (bitmap2 != null) {
            }
            C4990ab.m7420w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            c37477b.bitmap = bitmap2;
            this.fHu.mo7595b(this.url, this.fHr.getImageView(), c37477b);
            this.fHt.mo4581a(this.url, this.fHr.getImageView(), bitmap2, this.fGS.eQd);
            c9012b = this.fHp;
            c9012b.fGO.remove(Integer.valueOf(this.fHr.eQF));
            AppMethodBeat.m2505o(116107);
        } catch (Exception e9) {
            e = e9;
            c37477b2 = c37477b;
            b = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
            AppMethodBeat.m2505o(116107);
        }
    }

    /* renamed from: k */
    private void m16281k(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(116108);
        if (this.fGS.ePF) {
            C4990ab.m7411d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", this.url);
            this.fGT.mo52989c(str, bitmap);
        }
        AppMethodBeat.m2505o(116108);
    }

    /* renamed from: a */
    private Bitmap m16280a(C37477b c37477b, Bitmap bitmap) {
        AppMethodBeat.m2504i(116109);
        if (!(this.fHu == null || c37477b == null)) {
            c37477b.bitmap = bitmap;
            Bitmap a = this.fHu.mo7594a(this.url, this.fHr.getImageView(), c37477b);
            if (!(a == null || a.isRecycled())) {
                AppMethodBeat.m2505o(116109);
                return a;
            }
        }
        AppMethodBeat.m2505o(116109);
        return bitmap;
    }

    /* renamed from: sJ */
    public final String mo20448sJ(String str) {
        AppMethodBeat.m2504i(116110);
        if (C5046bo.isNullOrNil(str) || this.fGS == null) {
            AppMethodBeat.m2505o(116110);
            return null;
        }
        if (this.fGS.eQf) {
            str = str + "round" + this.fGS.eQg;
        }
        if (!C5046bo.isNullOrNil(this.fGS.ePX)) {
            str = str + this.fGS.ePX;
        }
        String str2 = str + "size" + this.fGS.ePN + this.fGS.ePO;
        AppMethodBeat.m2505o(116110);
        return str2;
    }

    /* renamed from: fN */
    public final void mo20446fN(long j) {
        AppMethodBeat.m2504i(116111);
        if (this.fGX != null) {
            this.fGX.mo33455fN(j);
        }
        AppMethodBeat.m2505o(116111);
    }
}
