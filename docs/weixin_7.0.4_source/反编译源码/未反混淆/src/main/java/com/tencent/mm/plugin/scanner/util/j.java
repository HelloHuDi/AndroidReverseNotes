package com.tencent.mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class j extends b {
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

    public j(a aVar, int i, boolean z, boolean z2) {
        super(aVar);
        AppMethodBeat.i(81452);
        this.quality = i;
        this.ovx = z2;
        this.qil = z;
        ab.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], needRotate = [%s], ocrMode=[%s]", Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z));
        AppMethodBeat.o(81452);
    }

    @TargetApi(8)
    public final boolean a(byte[] bArr, Point point, Rect rect) {
        AppMethodBeat.i(81453);
        if (this.isDecoding) {
            ab.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
            AppMethodBeat.o(81453);
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
            ab.e(str, str2, objArr);
            this.isDecoding = false;
            AppMethodBeat.o(81453);
            return false;
        }
        try {
            if (this.qik <= 0) {
                this.qik++;
                this.isDecoding = false;
                AppMethodBeat.o(81453);
                return false;
            }
            synchronized (this.cli) {
                int width;
                Rect rect2 = new Rect();
                int height;
                if (d.Lt() || !this.ovx) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.isDecoding = false;
                        AppMethodBeat.o(81453);
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
                    AppMethodBeat.o(81453);
                    return false;
                }
                c cVar = new c(bArr, point.x, point.y, rect2);
                if (cVar.height == 0 || cVar.width == 0) {
                    this.isDecoding = false;
                    AppMethodBeat.o(81453);
                    return false;
                } else if (this.qdM) {
                    ab.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
                    AppMethodBeat.o(81453);
                    return false;
                } else {
                    byte[] chR = cVar.chR();
                    if (chR == null) {
                        this.isDecoding = false;
                        AppMethodBeat.o(81453);
                        return false;
                    }
                    if (!this.qii) {
                        if (!d.Lt() || this.ovx) {
                            width = a(rect2.height(), rect2.width(), this.qil, Cg(q.etc.erk));
                            ab.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", Integer.valueOf(rect2.height()), Integer.valueOf(rect2.width()), Boolean.valueOf(this.qil), Integer.valueOf(q.etc.erk));
                        } else {
                            width = a(rect2.width(), rect2.height(), this.qil, Cg(q.etc.erk));
                            ab.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()), Boolean.valueOf(this.qil), Integer.valueOf(q.etc.erk));
                        }
                        if (width == -1) {
                            ab.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", Integer.valueOf(width));
                            AppMethodBeat.o(81453);
                            return false;
                        }
                        this.qii = true;
                    }
                    boolean[] zArr = new boolean[2];
                    long yz = bo.yz();
                    z = d.Lt() && !this.ovx;
                    QbarNative.FocusPro(chR, z, zArr);
                    ab.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Long.valueOf(bo.az(yz)));
                    this.qim = zArr[0];
                    this.qin = zArr[1];
                    if (this.qio == 0) {
                        this.qio = System.currentTimeMillis();
                    }
                    if (!this.qin && System.currentTimeMillis() - this.qio > 9000) {
                        ab.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
                        this.qin = true;
                        this.qio = System.currentTimeMillis();
                    }
                    if (this.qim) {
                        if (this.qdM) {
                            ab.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
                            AppMethodBeat.o(81453);
                            return false;
                        }
                        this.outWidth = cVar.width;
                        this.outHeight = cVar.height;
                        width = 0;
                        if (!d.Lt()) {
                            width = 1;
                            this.outWidth = cVar.height;
                            this.outHeight = cVar.width;
                        }
                        if (this.hHh == null) {
                            this.hHh = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            ab.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2));
                        } else if (this.hHh.length != ((this.outWidth * this.outHeight) * 3) / 2) {
                            this.hHh = null;
                            this.hHh = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            ab.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2));
                        }
                        ab.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", Integer.valueOf(QbarNative.b(this.hHh, chR, this.outWidth, this.outHeight)), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(width), Integer.valueOf(0));
                        if (QbarNative.b(this.hHh, chR, this.outWidth, this.outHeight) != 0) {
                            this.qhk = null;
                            this.isDecoding = false;
                            AppMethodBeat.o(81453);
                            return false;
                        } else if (this.qdM) {
                            ab.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
                            AppMethodBeat.o(81453);
                            return false;
                        } else {
                            if (com.tencent.mm.compatible.util.d.iW(8)) {
                                com.tencent.mm.compatible.a.a.a(8, new com.tencent.mm.compatible.a.a.a() {
                                    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d0 A:{SYNTHETIC, Splitter:B:21:0x00d0} */
                                    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fa A:{SYNTHETIC, Splitter:B:32:0x00fa} */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void run() {
                                        IOException e;
                                        Throwable th;
                                        FileOutputStream fileOutputStream = null;
                                        AppMethodBeat.i(81451);
                                        YuvImage yuvImage = new YuvImage(j.this.hHh, 17, j.this.outWidth, j.this.outHeight, null);
                                        ab.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by YuvImage");
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        yuvImage.compressToJpeg(new Rect(0, 0, j.this.outWidth, j.this.outHeight), j.this.quality, byteArrayOutputStream);
                                        j.this.qhk = byteArrayOutputStream.toByteArray();
                                        try {
                                            FileOutputStream fileOutputStream2;
                                            if (ae.gin) {
                                                fileOutputStream2 = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage.JPEG"));
                                                try {
                                                    fileOutputStream2.write(j.this.qhk);
                                                    fileOutputStream2.flush();
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    fileOutputStream = fileOutputStream2;
                                                    try {
                                                        ab.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", e.getMessage());
                                                        ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
                                                        if (fileOutputStream != null) {
                                                        }
                                                        try {
                                                            byteArrayOutputStream.close();
                                                            AppMethodBeat.o(81451);
                                                        } catch (IOException e3) {
                                                            ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3, "", new Object[0]);
                                                            AppMethodBeat.o(81451);
                                                            return;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (IOException e4) {
                                                                ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e4, "", new Object[0]);
                                                            }
                                                        }
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (IOException e42) {
                                                            ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e42, "", new Object[0]);
                                                        }
                                                        AppMethodBeat.o(81451);
                                                        throw th;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    fileOutputStream = fileOutputStream2;
                                                    if (fileOutputStream != null) {
                                                    }
                                                    byteArrayOutputStream.close();
                                                    AppMethodBeat.o(81451);
                                                    throw th;
                                                }
                                            }
                                            fileOutputStream2 = null;
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException e32) {
                                                    ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e32, "", new Object[0]);
                                                }
                                            }
                                            try {
                                                byteArrayOutputStream.close();
                                                AppMethodBeat.o(81451);
                                            } catch (IOException e322) {
                                                ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                                                AppMethodBeat.o(81451);
                                            }
                                        } catch (IOException e5) {
                                            e322 = e5;
                                            ab.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode() ApiTask : [%s]", e322.getMessage());
                                            ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e322, "", new Object[0]);
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e3222) {
                                                    ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e3222, "", new Object[0]);
                                                }
                                            }
                                            byteArrayOutputStream.close();
                                            AppMethodBeat.o(81451);
                                        }
                                    }
                                });
                            } else {
                                ab.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
                                c cVar2 = new c(this.hHh, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
                                int[] iArr = new int[(cVar2.width * cVar2.height)];
                                QbarNative.a(cVar2.cLa, iArr, cVar2.qhr, cVar2.qhs, cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                                QbarNative.nativeRelease();
                                Bitmap createBitmap = Bitmap.createBitmap(cVar2.width, cVar2.height, Config.ARGB_8888);
                                createBitmap.setPixels(iArr, 0, cVar2.width, 0, 0, cVar2.width, cVar2.height);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(CompressFormat.JPEG, this.quality, byteArrayOutputStream);
                                this.qhk = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                if (ae.gin) {
                                    com.tencent.mm.sdk.platformtools.d.a(createBitmap, this.quality, CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
                                }
                                createBitmap.recycle();
                            }
                            ab.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", Integer.valueOf(this.qhk.length));
                            this.isDecoding = false;
                            AppMethodBeat.o(81453);
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", e.toString());
            ab.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.o(81453);
            throw th;
        }
        this.qhk = null;
        this.isDecoding = false;
        AppMethodBeat.o(81453);
        return false;
    }

    public final void sI() {
        AppMethodBeat.i(81454);
        ab.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
        this.qdM = true;
        if (this.cli != null) {
            synchronized (this.cli) {
                try {
                    if (this.qii) {
                        ab.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", Integer.valueOf(0));
                        this.qii = false;
                        ab.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", Integer.valueOf(QbarNative.FocusRelease()));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(81454);
                    }
                }
            }
        }
        this.hHh = null;
        c.chQ();
        ab.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
        AppMethodBeat.o(81454);
    }

    public final void chP() {
        AppMethodBeat.i(81455);
        if (this.qii) {
            sI();
        }
        this.isDecoding = false;
        this.qdM = false;
        this.qii = false;
        AppMethodBeat.o(81455);
    }

    private static int a(int i, int i2, boolean z, int i3) {
        AppMethodBeat.i(81456);
        int FocusInit;
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.o(81456);
            return -1;
        } else if (i3 == 1) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 6, 140);
            AppMethodBeat.o(81456);
            return FocusInit;
        } else if (i3 == 2) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 8, 120);
            AppMethodBeat.o(81456);
            return FocusInit;
        } else if (i3 == 4) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 13, 80);
            AppMethodBeat.o(81456);
            return FocusInit;
        } else if (i3 == 5) {
            FocusInit = QbarNative.FocusInit(i, i2, z, 15, 65);
            AppMethodBeat.o(81456);
            return FocusInit;
        } else {
            FocusInit = QbarNative.FocusInit(i, i2, z, 10, 100);
            AppMethodBeat.o(81456);
            return FocusInit;
        }
    }

    private static int Cg(int i) {
        if (i <= 0 || i > 5) {
            return 3;
        }
        return i;
    }
}
