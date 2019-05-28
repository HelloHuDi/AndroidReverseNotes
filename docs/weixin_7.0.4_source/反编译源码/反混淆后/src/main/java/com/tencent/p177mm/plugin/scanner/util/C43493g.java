package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.licence.model.BankCardInfo;
import com.tencent.p177mm.plugin.licence.model.LibCardRecog;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.scanner.util.g */
public final class C43493g extends C3771b {
    private int mCount = 0;
    private boolean qhI = false;
    public boolean qhJ;
    private boolean qhK;
    public boolean[] qhL = new boolean[4];
    private boolean qhM;
    private boolean qhN;
    private boolean qhO;
    private Bitmap qhP;
    private final Object qhQ = new Object();

    public C43493g(C3772a c3772a, boolean z, boolean z2) {
        super(c3772a);
        AppMethodBeat.m2504i(81416);
        this.qhJ = z;
        this.qhK = z2;
        C4990ab.m7411d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", Boolean.FALSE, Boolean.valueOf(z));
        AppMethodBeat.m2505o(81416);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:80:0x0347=Splitter:B:80:0x0347, B:42:0x021f=Splitter:B:42:0x021f} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0268 A:{Catch:{ IOException -> 0x02d2, all -> 0x02e1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x036d A:{Catch:{ IOException -> 0x02d2, all -> 0x02e1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x02b4 A:{Catch:{ IOException -> 0x02d2, all -> 0x02e1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x031c A:{SYNTHETIC, Splitter:B:67:0x031c} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0268 A:{Catch:{ IOException -> 0x02d2, all -> 0x02e1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x02b4 A:{Catch:{ IOException -> 0x02d2, all -> 0x02e1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x036d A:{Catch:{ IOException -> 0x02d2, all -> 0x02e1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0344 A:{SYNTHETIC, Splitter:B:78:0x0344} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo8442a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        IOException e;
        long currentTimeMillis;
        BankCardInfo bankCardInfo;
        int recognizeBankCardProcess;
        Throwable th;
        AppMethodBeat.m2504i(81417);
        synchronized (this.qhQ) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                C4990ab.m7411d("MicroMsg.ScanBankCardDecoder", "resolution:%s, coverage:%s", point, rect);
                if (true == this.qhM) {
                    C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "recognize bank succeed, no need more handle");
                    z = false;
                    AppMethodBeat.m2505o(81417);
                } else {
                    int focusedEngineForBankcardInit;
                    int i;
                    float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.15f);
                    int width = (((int) (((float) rect.width()) * (1.0f + ((min - 1.0f) * 1.6f)))) / 4) * 4;
                    int height = (((int) (((float) rect.height()) * min)) / 4) * 4;
                    C4990ab.m7411d("MicroMsg.ScanBankCardDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height));
                    if (!this.qhN) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        focusedEngineForBankcardInit = QbarNative.focusedEngineForBankcardInit(width, height, 8, this.qhI);
                        C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "focusedEngineForBankcardInit, cost: " + (System.currentTimeMillis() - currentTimeMillis3));
                        if (focusedEngineForBankcardInit != 0) {
                            C4990ab.m7412e("MicroMsg.ScanBankCardDecoder", "init failed on init focusedEngine:".concat(String.valueOf(focusedEngineForBankcardInit)));
                            z = false;
                            AppMethodBeat.m2505o(81417);
                        } else {
                            this.qhN = true;
                        }
                    }
                    if (!this.qhO && true == this.qhN) {
                        C4990ab.m7411d("MicroMsg.ScanBankCardDecoder", "init param:%d, %d, %d, %d, %s", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()), Boolean.valueOf(this.qhI));
                        this.qhO = LibCardRecog.recognizeBankCardInit(width, height, this.qhI) == 0;
                    }
                    C4990ab.m7411d("MicroMsg.ScanBankCardDecoder", "crop image start:%d, %d, dataLen:%d", Integer.valueOf(rect.left - ((width - rect.width()) / 2)), Integer.valueOf(rect.top - ((height - rect.height()) / 2)), Integer.valueOf(bArr.length));
                    String value = C26373g.m41964Nu().getValue("debug_scan_bank");
                    if (value != null && value.equals("true")) {
                        this.mCount++;
                        i = point.x;
                        int i2 = point.y;
                        int i3 = this.mCount;
                        String str = "_scanImage_org.jpeg";
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "decode() compress jpeg by YuvImage");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        FileOutputStream fileOutputStream = null;
                        FileOutputStream fileOutputStream2;
                        try {
                            fileOutputStream2 = new FileOutputStream(new File(C1448h.getExternalStorageDirectory().getAbsolutePath() + "/test/" + String.valueOf(i3) + str));
                            try {
                                fileOutputStream2.write(toByteArray);
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2, "", new Object[0]);
                                }
                            } catch (IOException e3) {
                                e2 = e3;
                                try {
                                    C4990ab.m7413e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", e2.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2, "", new Object[0]);
                                    if (fileOutputStream2 != null) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e22) {
                                        C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                                    }
                                    currentTimeMillis = System.currentTimeMillis();
                                    bankCardInfo = new BankCardInfo(point.x, point.y);
                                    recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qhL);
                                    C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                                    if (!this.qhJ) {
                                    }
                                    C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:".concat(String.valueOf(recognizeBankCardProcess)));
                                    if (recognizeBankCardProcess != 1) {
                                    }
                                    return z;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e4) {
                                        C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e4, "", new Object[0]);
                                    }
                                    AppMethodBeat.m2505o(81417);
                                    throw th;
                                }
                            }
                        } catch (IOException e5) {
                            e22 = e5;
                            fileOutputStream2 = null;
                            C4990ab.m7413e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", e22.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e222) {
                                    C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e222, "", new Object[0]);
                                }
                            }
                            byteArrayOutputStream.close();
                            currentTimeMillis = System.currentTimeMillis();
                            bankCardInfo = new BankCardInfo(point.x, point.y);
                            recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qhL);
                            C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                            if (this.qhJ) {
                            }
                            C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:".concat(String.valueOf(recognizeBankCardProcess)));
                            if (recognizeBankCardProcess != 1) {
                            }
                            return z;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e42) {
                                    C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e42, "", new Object[0]);
                                }
                            }
                            byteArrayOutputStream.close();
                            AppMethodBeat.m2505o(81417);
                            throw th;
                        }
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    bankCardInfo = new BankCardInfo(point.x, point.y);
                    recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.qhL);
                    C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.qhJ) {
                        boolean z2 = this.qhL[0];
                        this.qhL[0] = this.qhL[2];
                        this.qhL[2] = z2;
                        z2 = this.qhL[1];
                        this.qhL[1] = this.qhL[3];
                        this.qhL[3] = z2;
                    }
                    C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:".concat(String.valueOf(recognizeBankCardProcess)));
                    if (recognizeBankCardProcess != 1) {
                        C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "scan bank failed:".concat(String.valueOf(recognizeBankCardProcess)));
                        z = false;
                        AppMethodBeat.m2505o(81417);
                    } else {
                        Options options = new Options();
                        options.inSampleSize = 1;
                        this.qhP = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                        if (this.qhP == null) {
                            z = false;
                            AppMethodBeat.m2505o(81417);
                        } else {
                            int[] rectX = bankCardInfo.getRectX();
                            int[] rectY = bankCardInfo.getRectY();
                            int i4 = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                            recognizeBankCardProcess = (int) (((float) i4) * 0.21319798f);
                            int i5 = (int) (((float) rectX[0]) - (((float) i4) * 0.04568528f));
                            i = i5 > 0 ? i5 : 0;
                            i5 = ((int) (((float) (i4 * 2)) * 0.04568528f)) + i4;
                            focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                            if (focusedEngineForBankcardInit <= 0) {
                                focusedEngineForBankcardInit = 0;
                            }
                            if (i + i5 > bankCardInfo.width) {
                                i5 = bankCardInfo.width - i;
                            }
                            if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                            }
                            this.qhP = Bitmap.createBitmap(this.qhP, i, focusedEngineForBankcardInit, i5, recognizeBankCardProcess);
                            qhm = 3;
                            if (this.qhK) {
                                this.qhl = bankCardInfo.getCardNum();
                            } else {
                                this.qhl = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                            }
                            this.qhM = true;
                            C4990ab.m7410d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                            z = true;
                            AppMethodBeat.m2505o(81417);
                        }
                    }
                }
            } catch (IOException e2222) {
                C4990ab.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
            } catch (Throwable th4) {
                AppMethodBeat.m2505o(81417);
            }
        }
        return z;
    }

    /* renamed from: sI */
    public final void mo8444sI() {
        AppMethodBeat.m2504i(81418);
        synchronized (this.qhQ) {
            try {
                if (true == this.qhN) {
                    QbarNative.focusedEngineRelease();
                    this.qhN = false;
                }
                if (true == this.qhO) {
                    LibCardRecog.recognizeBankCardRelease();
                    this.qhO = false;
                }
                this.qhP = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(81418);
            }
        }
    }

    public final void chP() {
        AppMethodBeat.m2504i(81419);
        mo8444sI();
        AppMethodBeat.m2505o(81419);
    }

    public final Bitmap chW() {
        Bitmap bitmap;
        synchronized (this.qhQ) {
            bitmap = this.qhP;
        }
        return bitmap;
    }
}
