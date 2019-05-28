package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class k extends b {
    private final Object lock = new Object();
    private final int nsd;
    private boolean[] qhL = new boolean[4];
    private boolean qhM = false;
    private boolean qhO = false;
    private Bitmap qiq;
    public Bitmap qir;

    public k(a aVar, int i) {
        super(aVar);
        AppMethodBeat.i(81457);
        this.nsd = i;
        AppMethodBeat.o(81457);
    }

    public final boolean[] cih() {
        boolean[] zArr;
        synchronized (this.lock) {
            zArr = this.qhL;
        }
        return zArr;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        AppMethodBeat.i(81458);
        ab.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", point, rect, Integer.valueOf(bArr.length));
        synchronized (this.lock) {
            try {
                if (!(this.qiq == null || this.qiq.isRecycled())) {
                    ab.i("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap %s", this.qiq.toString());
                    this.qiq.recycle();
                }
                ab.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", point, rect);
                if (this.qhM) {
                    ab.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
                    z = false;
                } else {
                    int i;
                    for (i = 0; i < 4; i++) {
                        this.qhL[i] = false;
                    }
                    float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.0f);
                    int width = rect.width();
                    int height = rect.height();
                    ab.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height));
                    if (!this.qhO) {
                        ab.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
                        LibCardRecog.recognizeCardInit(width, height, this.nsd);
                        this.qhO = true;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    CardInfo cardInfo = new CardInfo(width, height);
                    int i2 = rect.top;
                    try {
                        i = LibCardRecog.recognizeCardProcess(bArr, point.y, point.x, rect.left, i2, height, width, cardInfo, this.qhL);
                        ab.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", Integer.valueOf(i));
                        ab.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        ab.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", Arrays.toString(this.qhL));
                        if (i == 0) {
                            z = false;
                            AppMethodBeat.o(81458);
                        } else if (1 != i) {
                            for (i = 0; i < 4; i++) {
                                this.qhL[i] = false;
                            }
                            ab.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
                            z = false;
                            AppMethodBeat.o(81458);
                        } else {
                            for (i = 0; i < 4; i++) {
                                this.qhL[i] = true;
                            }
                            this.qiq = BitmapFactory.decodeByteArray(cardInfo.bitmapData, 0, cardInfo.bitmapLen);
                            this.qir = this.qiq.copy(Config.ARGB_8888, true);
                            this.qhM = true;
                            z = true;
                            AppMethodBeat.o(81458);
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", e);
                        this.qhM = false;
                        z = false;
                        AppMethodBeat.o(81458);
                    }
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", e2);
                this.qhO = false;
                cii();
                z = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81458);
            }
        }
        return z;
    }

    public final void sI() {
        AppMethodBeat.i(81459);
        if (!(this.qiq == null || this.qiq.isRecycled())) {
            ab.i("MicroMsg.ScanLicenceDecoder", "bitmap recycle %s", this.qiq.toString());
            this.qiq.recycle();
        }
        cii();
        AppMethodBeat.o(81459);
    }

    public final void chP() {
        this.qhM = false;
    }

    private static void cii() {
        AppMethodBeat.i(81460);
        ab.i("MicroMsg.ScanLicenceDecoder", "lib release");
        try {
            LibCardRecog.recognizeCardRelease();
            AppMethodBeat.o(81460);
        } catch (Exception e) {
            ab.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", e);
            AppMethodBeat.o(81460);
        }
    }
}
