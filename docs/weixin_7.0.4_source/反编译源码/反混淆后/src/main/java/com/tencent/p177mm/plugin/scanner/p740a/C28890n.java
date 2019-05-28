package com.tencent.p177mm.plugin.scanner.p740a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45353oq;
import com.tencent.p177mm.plugin.facedetect.model.C43038r;
import com.tencent.p177mm.plugin.scanner.util.C13178d;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.scanner.a.n */
public final class C28890n extends C4884c<C45353oq> implements C3772a {
    private boolean isDecoding;
    private C13178d qaf;
    private C43038r qag;

    public C28890n() {
        AppMethodBeat.m2504i(80873);
        this.qaf = null;
        this.isDecoding = false;
        this.qag = null;
        this.xxI = C45353oq.class.getName().hashCode();
        AppMethodBeat.m2505o(80873);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(80876);
        C45353oq c45353oq = (C45353oq) c4883b;
        C43038r c43038r = c45353oq.cKZ.cLc;
        if (!this.isDecoding || c43038r == null) {
            boolean z;
            this.qag = c43038r;
            this.isDecoding = true;
            if (this.qaf == null) {
                this.qaf = new C13178d(this, 3, false);
            }
            if (this.qaf.qdM) {
                this.qaf.chP();
            }
            int i = c45353oq.cKZ.width;
            int i2 = c45353oq.cKZ.height;
            Rect rect = c45353oq.cKZ.cLb;
            byte[] bArr = c45353oq.cKZ.cLa;
            int i3 = c45353oq.cKZ.rotate;
            String str = "MicroMsg.RecogQBarInYUVListener";
            String str2 = "hy: request scanning width: %d, height: %d, scanRect: %s, yuvLen: %d, rotate: %d";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = rect;
            objArr[3] = Integer.valueOf(bArr != null ? bArr.length : 0);
            objArr[4] = Integer.valueOf(i3);
            C4990ab.m7417i(str, str2, objArr);
            C13178d c13178d = this.qaf;
            if (i3 != 0) {
                z = true;
            } else {
                z = false;
            }
            c13178d.ovx = z;
            this.qaf.mo8441a(bArr, new Point(i, i2), i3, rect);
            AppMethodBeat.m2505o(80876);
        } else {
            C4990ab.m7420w("MicroMsg.RecogQBarInYUVListener", "hy: is decoding. direct return");
            c43038r.mo23565S("", -1, -1);
            AppMethodBeat.m2505o(80876);
        }
        return false;
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.m2504i(80874);
        C4990ab.m7417i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.qag != null) {
            this.qag.mo23565S(str, i2, i3);
        }
        this.isDecoding = false;
        AppMethodBeat.m2505o(80874);
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
        AppMethodBeat.m2504i(80875);
        C4990ab.m7416i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
        if (this.qag != null) {
            this.qag.mo23565S("", -2, -1);
        }
        this.isDecoding = false;
        AppMethodBeat.m2505o(80875);
    }

    /* renamed from: K */
    public final void mo8420K(Bundle bundle) {
    }
}
