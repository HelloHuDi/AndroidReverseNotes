package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c implements a {
    private int a = 0;
    private a b;

    public c(Context context, int i) {
        AppMethodBeat.i(67111);
        switch (i) {
            case 0:
                this.a = 0;
                this.b = new d();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                AppMethodBeat.o(67111);
                return;
            case 1:
                this.a = 1;
                this.b = new b();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                AppMethodBeat.o(67111);
                return;
            default:
                if (a(context)) {
                    this.a = 0;
                    this.b = new d();
                    TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                    AppMethodBeat.o(67111);
                    return;
                }
                this.a = 1;
                this.b = new b();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                AppMethodBeat.o(67111);
                return;
        }
    }

    public static boolean a(Context context) {
        AppMethodBeat.i(67112);
        b.a().a(context);
        if (b.a().e() == 1) {
            AppMethodBeat.o(67112);
            return true;
        }
        AppMethodBeat.o(67112);
        return false;
    }

    public void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(67113);
        this.b.a(mediaFormat);
        AppMethodBeat.o(67113);
    }

    public void b(MediaFormat mediaFormat) {
        AppMethodBeat.i(67114);
        this.b.b(mediaFormat);
        AppMethodBeat.o(67114);
    }

    public void a(String str) {
        AppMethodBeat.i(67115);
        this.b.a(str);
        AppMethodBeat.o(67115);
    }

    public void a(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.i(67116);
        this.b.a(bArr, i, i2, j, i3);
        AppMethodBeat.o(67116);
    }

    public void b(byte[] bArr, int i, int i2, long j, int i3) {
        AppMethodBeat.i(67117);
        this.b.b(bArr, i, i2, j, i3);
        AppMethodBeat.o(67117);
    }

    public int a() {
        AppMethodBeat.i(67118);
        int a = this.b.a();
        AppMethodBeat.o(67118);
        return a;
    }

    public int b() {
        AppMethodBeat.i(67119);
        int b = this.b.b();
        AppMethodBeat.o(67119);
        return b;
    }

    public boolean c() {
        AppMethodBeat.i(67120);
        boolean c = this.b.c();
        AppMethodBeat.o(67120);
        return c;
    }
}
