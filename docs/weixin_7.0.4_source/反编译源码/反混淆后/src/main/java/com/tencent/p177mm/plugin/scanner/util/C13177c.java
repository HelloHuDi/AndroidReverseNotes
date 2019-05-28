package com.tencent.p177mm.plugin.scanner.util;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p699f.C6094a;

/* renamed from: com.tencent.mm.plugin.scanner.util.c */
public final class C13177c extends C6094a {
    public final byte[] cLa;
    public int height;
    public int left;
    final int qhr;
    final int qhs;
    public int top;
    public int width;

    public C13177c(byte[] bArr, int i, int i2, Rect rect) {
        int i3 = 0;
        super(rect.width(), rect.height());
        AppMethodBeat.m2504i(81373);
        C4990ab.m7419v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
        this.cLa = bArr;
        this.qhr = i;
        this.qhs = i2;
        int i4 = (rect.left < 0 || rect.left >= i) ? 0 : rect.left;
        this.left = i4;
        if (rect.top >= 0 && rect.top < i2) {
            i3 = rect.top;
        }
        this.top = i3;
        this.width = this.left + rect.width() > i ? i - this.left : rect.width();
        this.height = this.top + rect.height() > i2 ? i2 - this.top : rect.height();
        if (this.left + this.width > i || this.top + this.height > i2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Crop rectangle does not fit within image data.");
            AppMethodBeat.m2505o(81373);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(81373);
    }

    /* renamed from: n */
    public final byte[] mo13483n(int i, byte[] bArr) {
        AppMethodBeat.m2504i(81374);
        if (i < 0 || i >= this.height) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(81374);
            throw illegalArgumentException;
        }
        Object bArr2;
        if (bArr2 == null || bArr2.length < this.width) {
            bArr2 = new byte[this.width];
        }
        System.arraycopy(this.cLa, ((this.top + i) * this.qhr) + this.left, bArr2, 0, this.width);
        AppMethodBeat.m2505o(81374);
        return bArr2;
    }

    public static void chQ() {
        AppMethodBeat.m2504i(81375);
        C28922l.cij().cik();
        System.gc();
        AppMethodBeat.m2505o(81375);
    }

    public final byte[] chR() {
        AppMethodBeat.m2504i(81376);
        byte[] bArr;
        if (this.width == this.qhr && this.height == this.qhs) {
            bArr = this.cLa;
            AppMethodBeat.m2505o(81376);
            return bArr;
        }
        try {
            int i = this.width * this.height;
            C28922l cij = C28922l.cij();
            if (cij.qit == null) {
                cij.qit = new byte[i];
            } else if (cij.qit.length != i) {
                cij.qit = null;
                cij.qit = new byte[i];
            }
            bArr = cij.qit;
            int i2 = (this.top * this.qhr) + this.left;
            if (this.width == this.qhr) {
                System.arraycopy(this.cLa, i2, bArr, 0, i);
                AppMethodBeat.m2505o(81376);
                return bArr;
            }
            byte[] bArr2 = this.cLa;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(bArr2, i2, bArr, this.width * i3, this.width);
                i2 += this.qhr;
            }
            AppMethodBeat.m2505o(81376);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.cLa.length + " dataWidth:" + this.qhr + " dataHeight:" + this.qhs + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            AppMethodBeat.m2505o(81376);
            return null;
        }
    }

    public final byte[] chS() {
        AppMethodBeat.m2504i(81377);
        byte[] bArr;
        if (this.width == this.qhr && this.height == this.qhs) {
            bArr = this.cLa;
            AppMethodBeat.m2505o(81377);
            return bArr;
        }
        try {
            int i = this.width * this.height;
            bArr = new byte[i];
            int i2 = (this.top * this.qhr) + this.left;
            if (this.width == this.qhr) {
                System.arraycopy(this.cLa, i2, bArr, 0, i);
                AppMethodBeat.m2505o(81377);
                return bArr;
            }
            byte[] bArr2 = this.cLa;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(bArr2, i2, bArr, this.width * i3, this.width);
                i2 += this.qhr;
            }
            AppMethodBeat.m2505o(81377);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.cLa.length + " dataWidth:" + this.qhr + " dataHeight:" + this.qhs + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            AppMethodBeat.m2505o(81377);
            return null;
        }
    }
}
