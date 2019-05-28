package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.muxer.c */
public class C8818c implements C32170a {
    /* renamed from: a */
    private int f2702a = 0;
    /* renamed from: b */
    private C32170a f2703b;

    public C8818c(Context context, int i) {
        AppMethodBeat.m2504i(67111);
        switch (i) {
            case 0:
                this.f2702a = 0;
                this.f2703b = new C25660d();
                TXCLog.m15677i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                AppMethodBeat.m2505o(67111);
                return;
            case 1:
                this.f2702a = 1;
                this.f2703b = new C8816b();
                TXCLog.m15677i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                AppMethodBeat.m2505o(67111);
                return;
            default:
                if (C8818c.m15711a(context)) {
                    this.f2702a = 0;
                    this.f2703b = new C25660d();
                    TXCLog.m15677i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                    AppMethodBeat.m2505o(67111);
                    return;
                }
                this.f2702a = 1;
                this.f2703b = new C8816b();
                TXCLog.m15677i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                AppMethodBeat.m2505o(67111);
                return;
        }
    }

    /* renamed from: a */
    public static boolean m15711a(Context context) {
        AppMethodBeat.m2504i(67112);
        C45104b.m82752a().mo72875a(context);
        if (C45104b.m82752a().mo72882e() == 1) {
            AppMethodBeat.m2505o(67112);
            return true;
        }
        AppMethodBeat.m2505o(67112);
        return false;
    }

    /* renamed from: a */
    public void mo19918a(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67113);
        this.f2703b.mo19918a(mediaFormat);
        AppMethodBeat.m2505o(67113);
    }

    /* renamed from: b */
    public void mo19923b(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67114);
        this.f2703b.mo19923b(mediaFormat);
        AppMethodBeat.m2505o(67114);
    }

    /* renamed from: a */
    public void mo19919a(String str) {
        AppMethodBeat.m2504i(67115);
        this.f2703b.mo19919a(str);
        AppMethodBeat.m2505o(67115);
    }

    /* renamed from: a */
    public void mo19921a(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(67116);
        this.f2703b.mo19921a(bArr, i, i2, j, i3);
        AppMethodBeat.m2505o(67116);
    }

    /* renamed from: b */
    public void mo19925b(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(67117);
        this.f2703b.mo19925b(bArr, i, i2, j, i3);
        AppMethodBeat.m2505o(67117);
    }

    /* renamed from: a */
    public int mo19917a() {
        AppMethodBeat.m2504i(67118);
        int a = this.f2703b.mo19917a();
        AppMethodBeat.m2505o(67118);
        return a;
    }

    /* renamed from: b */
    public int mo19922b() {
        AppMethodBeat.m2504i(67119);
        int b = this.f2703b.mo19922b();
        AppMethodBeat.m2505o(67119);
        return b;
    }

    /* renamed from: c */
    public boolean mo19926c() {
        AppMethodBeat.m2504i(67120);
        boolean c = this.f2703b.mo19926c();
        AppMethodBeat.m2505o(67120);
        return c;
    }
}
