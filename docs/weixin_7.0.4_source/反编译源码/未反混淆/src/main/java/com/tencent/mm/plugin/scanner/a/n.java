package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends c<oq> implements a {
    private boolean isDecoding;
    private d qaf;
    private r qag;

    public n() {
        AppMethodBeat.i(80873);
        this.qaf = null;
        this.isDecoding = false;
        this.qag = null;
        this.xxI = oq.class.getName().hashCode();
        AppMethodBeat.o(80873);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(80876);
        oq oqVar = (oq) bVar;
        r rVar = oqVar.cKZ.cLc;
        if (!this.isDecoding || rVar == null) {
            boolean z;
            this.qag = rVar;
            this.isDecoding = true;
            if (this.qaf == null) {
                this.qaf = new d(this, 3, false);
            }
            if (this.qaf.qdM) {
                this.qaf.chP();
            }
            int i = oqVar.cKZ.width;
            int i2 = oqVar.cKZ.height;
            Rect rect = oqVar.cKZ.cLb;
            byte[] bArr = oqVar.cKZ.cLa;
            int i3 = oqVar.cKZ.rotate;
            String str = "MicroMsg.RecogQBarInYUVListener";
            String str2 = "hy: request scanning width: %d, height: %d, scanRect: %s, yuvLen: %d, rotate: %d";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = rect;
            objArr[3] = Integer.valueOf(bArr != null ? bArr.length : 0);
            objArr[4] = Integer.valueOf(i3);
            ab.i(str, str2, objArr);
            d dVar = this.qaf;
            if (i3 != 0) {
                z = true;
            } else {
                z = false;
            }
            dVar.ovx = z;
            this.qaf.a(bArr, new Point(i, i2), i3, rect);
            AppMethodBeat.o(80876);
        } else {
            ab.w("MicroMsg.RecogQBarInYUVListener", "hy: is decoding. direct return");
            rVar.S("", -1, -1);
            AppMethodBeat.o(80876);
        }
        return false;
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(80874);
        ab.i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.qag != null) {
            this.qag.S(str, i2, i3);
        }
        this.isDecoding = false;
        AppMethodBeat.o(80874);
    }

    public final void jJ(long j) {
        AppMethodBeat.i(80875);
        ab.i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
        if (this.qag != null) {
            this.qag.S("", -2, -1);
        }
        this.isDecoding = false;
        AppMethodBeat.o(80875);
    }

    public final void K(Bundle bundle) {
    }
}
