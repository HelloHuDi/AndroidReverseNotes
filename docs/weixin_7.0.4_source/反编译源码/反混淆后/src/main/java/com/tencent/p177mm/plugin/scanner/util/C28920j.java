package com.tencent.p177mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.scanner.util.j */
public final class C28920j extends C3771b {
    private Object cli = new Object();
    private byte[] hHh;
    private boolean isDecoding = false;
    private int outHeight;
    private int outWidth;
    public boolean ovx = true;
    private boolean qdM = false;
    private final int qih = 25;
    private boolean qii = false;
    private final int qij = 1;
    private int qik = 0;
    private boolean qil;
    private volatile boolean qim;
    public volatile boolean qin;
    private long qio;
    private int quality = 50;

    /* renamed from: com.tencent.mm.plugin.scanner.util.j$1 */
    class C289211 implements C41932a {
        C289211() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d0 A:{SYNTHETIC, Splitter:B:21:0x00d0} */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00fa A:{SYNTHETIC, Splitter:B:32:0x00fa} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            IOException e;
            Throwable th;
            FileOutputStream fileOutputStream = null;
            AppMethodBeat.m2504i(81451);
            YuvImage yuvImage = new YuvImage(C28920j.this.hHh, 17, C28920j.this.outWidth, C28920j.this.outHeight, null);
            C4990ab.m7410d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by YuvImage");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, C28920j.this.outWidth, C28920j.this.outHeight), C28920j.this.quality, byteArrayOutputStream);
            C28920j.this.qhk = byteArrayOutputStream.toByteArray();
            try {
                FileOutputStream fileOutputStream2;
                if (C1947ae.gin) {
                    fileOutputStream2 = new FileOutputStream(new File(C1448h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage.JPEG"));
                    try {
                        fileOutputStream2.write(C28920j.this.qhk);
                        fileOutputStream2.flush();
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            C4990ab.m7413e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                            }
                            try {
                                byteArrayOutputStream.close();
                                AppMethodBeat.m2505o(81451);
                            } catch (IOException e3) {
                                C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3, "", new Object[0]);
                                AppMethodBeat.m2505o(81451);
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e4, "", new Object[0]);
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e42) {
                                C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e42, "", new Object[0]);
                            }
                            AppMethodBeat.m2505o(81451);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        byteArrayOutputStream.close();
                        AppMethodBeat.m2505o(81451);
                        throw th;
                    }
                }
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e32) {
                        C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e32, "", new Object[0]);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(81451);
                } catch (IOException e322) {
                    C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                    AppMethodBeat.m2505o(81451);
                }
            } catch (IOException e5) {
                e322 = e5;
                C4990ab.m7413e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", e322.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3222) {
                        C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
                    }
                }
                byteArrayOutputStream.close();
                AppMethodBeat.m2505o(81451);
            }
        }
    }

    public C28920j(C3772a c3772a, int i, boolean z, boolean z2) {
        super(c3772a);
        AppMethodBeat.m2504i(81452);
        this.quality = i;
        this.ovx = z2;
        this.qil = z;
        C4990ab.m7417i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], needRotate = [%s], ocrMode=[%s]", Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z));
        AppMethodBeat.m2505o(81452);
    }

    @TargetApi(8)
    /* renamed from: a */
    public final boolean mo8442a(byte[] bArr, Point point, Rect rect) {
        AppMethodBeat.m2504i(81453);
        if (this.isDecoding) {
            C4990ab.m7412e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
            AppMethodBeat.m2505o(81453);
            return false;
        }
        this.isDecoding = true;
        boolean z;
        if (bArr == null || point == null || rect == null) {
            String str = "MicroMsg.scanner.ScanImageDecoder";
            String str2 = "decode() data null:[%s], resolution null:[%s], coverage null:[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(bArr == null);
            if (point == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (rect == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
            this.isDecoding = false;
            AppMethodBeat.m2505o(81453);
            return false;
        }
        try {
            if (this.qik <= 0) {
                this.qik++;
                this.isDecoding = false;
                AppMethodBeat.m2505o(81453);
                return false;
            }
            synchronized (this.cli) {
                int width;
                Rect rect2 = new Rect();
                int height;
                if (C32468d.m53154Lt() || !this.ovx) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.isDecoding = false;
                        AppMethodBeat.m2505o(81453);
                        return false;
                    }
                }
                rect2.left = (point.x / 2) - (rect.height() / 2);
                rect2.right = (point.x / 2) + (rect.height() / 2);
                rect2.top = (point.y / 2) - (rect.width() / 2);
                rect2.bottom = (point.y / 2) + (rect.width() / 2);
                if (rect2.left < 0) {
                    rect2.left = 0;
                }
                if (rect2.right > point.x - 1) {
                    rect2.right = point.x - 1;
                }
                if (rect2.top < 0) {
                    rect2.top = 0;
                }
                if (rect2.bottom > point.y - 1) {
                    rect2.bottom = point.y - 1;
                }
                width = rect2.width() % 4;
                height = rect2.height() % 4;
                if (width != 0) {
                    rect2.right -= width;
                }
                if (height != 0) {
                    rect2.bottom -= height;
                }
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    this.isDecoding = false;
                    AppMethodBeat.m2505o(81453);
                    return false;
                }
                C13177c c13177c = new C13177c(bArr, point.x, point.y, rect2);
                if (c13177c.height == 0 || c13177c.width == 0) {
                    this.isDecoding = false;
                    AppMethodBeat.m2505o(81453);
                    return false;
                } else if (this.qdM) {
                    C4990ab.m7420w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
                    AppMethodBeat.m2505o(81453);
                    return false;
                } else {
                    byte[] chR = c13177c.chR();
                    if (chR == null) {
                        this.isDecoding = false;
                        AppMethodBeat.m2505o(81453);
                        return false;
                    }
                    if (!this.qii) {
                        if (!C32468d.m53154Lt() || this.ovx) {
                            width = C28920j.m45934a(rect2.height(), rect2.width(), this.qil, C28920j.m45933Cg(C1427q.etc.erk));
                            C4990ab.m7411d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", Integer.valueOf(rect2.height()), Integer.valueOf(rect2.width()), Boolean.valueOf(this.qil), Integer.valueOf(C1427q.etc.erk));
                        } else {
                            width = C28920j.m45934a(rect2.width(), rect2.height(), this.qil, C28920j.m45933Cg(C1427q.etc.erk));
                            C4990ab.m7411d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()), Boolean.valueOf(this.qil), Integer.valueOf(C1427q.etc.erk));
                        }
                        if (width == -1) {
                            C4990ab.m7413e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", Integer.valueOf(width));
                            AppMethodBeat.m2505o(81453);
                            return false;
                        }
                        this.qii = true;
                    }
                    boolean[] zArr = new boolean[2];
                    long yz = C5046bo.m7588yz();
                    z = C32468d.m53154Lt() && !this.ovx;
                    QbarNative.FocusPro(chR, z, zArr);
                    C4990ab.m7411d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Long.valueOf(C5046bo.m7525az(yz)));
                    this.qim = zArr[0];
                    this.qin = zArr[1];
                    if (this.qio == 0) {
                        this.qio = System.currentTimeMillis();
                    }
                    if (!this.qin && System.currentTimeMillis() - this.qio > 9000) {
                        C4990ab.m7410d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
                        this.qin = true;
                        this.qio = System.currentTimeMillis();
                    }
                    if (this.qim) {
                        if (this.qdM) {
                            C4990ab.m7420w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
                            AppMethodBeat.m2505o(81453);
                            return false;
                        }
                        this.outWidth = c13177c.width;
                        this.outHeight = c13177c.height;
                        width = 0;
                        if (!C32468d.m53154Lt()) {
                            width = 1;
                            this.outWidth = c13177c.height;
                            this.outHeight = c13177c.width;
                        }
                        if (this.hHh == null) {
                            this.hHh = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            C4990ab.m7419v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2));
                        } else if (this.hHh.length != ((this.outWidth * this.outHeight) * 3) / 2) {
                            this.hHh = null;
                            this.hHh = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            C4990ab.m7419v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2));
                        }
                        C4990ab.m7411d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", Integer.valueOf(QbarNative.m49365b(this.hHh, chR, this.outWidth, this.outHeight)), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(width), Integer.valueOf(0));
                        if (QbarNative.m49365b(this.hHh, chR, this.outWidth, this.outHeight) != 0) {
                            this.qhk = null;
                            this.isDecoding = false;
                            AppMethodBeat.m2505o(81453);
                            return false;
                        } else if (this.qdM) {
                            C4990ab.m7420w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
                            AppMethodBeat.m2505o(81453);
                            return false;
                        } else {
                            if (C1443d.m3068iW(8)) {
                                C41933a.m74069a(8, new C289211());
                            } else {
                                C4990ab.m7410d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
                                C13177c c13177c2 = new C13177c(this.hHh, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
                                int[] iArr = new int[(c13177c2.width * c13177c2.height)];
                                QbarNative.m49362a(c13177c2.cLa, iArr, c13177c2.qhr, c13177c2.qhs, c13177c2.left, c13177c2.top, c13177c2.width, c13177c2.height);
                                QbarNative.nativeRelease();
                                Bitmap createBitmap = Bitmap.createBitmap(c13177c2.width, c13177c2.height, Config.ARGB_8888);
                                createBitmap.setPixels(iArr, 0, c13177c2.width, 0, 0, c13177c2.width, c13177c2.height);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(CompressFormat.JPEG, this.quality, byteArrayOutputStream);
                                this.qhk = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                if (C1947ae.gin) {
                                    C5056d.m7625a(createBitmap, this.quality, CompressFormat.JPEG, C1448h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
                                }
                                createBitmap.recycle();
                            }
                            C4990ab.m7417i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", Integer.valueOf(this.qhk.length));
                            this.isDecoding = false;
                            AppMethodBeat.m2505o(81453);
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", e.toString());
            C4990ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(81453);
            throw th;
        }
        this.qhk = null;
        this.isDecoding = false;
        AppMethodBeat.m2505o(81453);
        return false;
    }

    /* renamed from: sI */
    public final void mo8444sI() {
        AppMethodBeat.m2504i(81454);
        C4990ab.m7410d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
        this.qdM = true;
        if (this.cli != null) {
            synchronized (this.cli) {
                try {
                    if (this.qii) {
                        C4990ab.m7411d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", Integer.valueOf(0));
                        this.qii = false;
                        C4990ab.m7411d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", Integer.valueOf(QbarNative.FocusRelease()));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(81454);
                    }
                }
            }
        }
        this.hHh = null;
        C13177c.chQ();
        C4990ab.m7410d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
        AppMethodBeat.m2505o(81454);
    }

    public final void chP() {
        AppMethodBeat.m2504i(81455);
        if (this.qii) {
            mo8444sI();
        }
        this.isDecoding = false;
        this.qdM = false;
        this.qii = false;
        AppMethodBeat.m2505o(81455);
    }

    /* renamed from: a */
    private static int m45934a(int i, int i2, boolean z, int i3) {
        AppMethodBeat.m2504i(81456);
        int FocusInit;
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(81456);
            return -1;
        } else if (i3 == 1) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 6, 140);
            AppMethodBeat.m2505o(81456);
            return FocusInit;
        } else if (i3 == 2) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 8, 120);
            AppMethodBeat.m2505o(81456);
            return FocusInit;
        } else if (i3 == 4) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 13, 80);
            AppMethodBeat.m2505o(81456);
            return FocusInit;
        } else if (i3 == 5) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 15, 65);
            AppMethodBeat.m2505o(81456);
            return FocusInit;
        } else {
            FocusInit = QbarNative.FocusInit(i, i2, z, 10, 100);
            AppMethodBeat.m2505o(81456);
            return FocusInit;
        }
    }

    /* renamed from: Cg */
    private static int m45933Cg(int i) {
        if (i <= 0 || i > 5) {
            return 3;
        }
        return i;
    }
}
