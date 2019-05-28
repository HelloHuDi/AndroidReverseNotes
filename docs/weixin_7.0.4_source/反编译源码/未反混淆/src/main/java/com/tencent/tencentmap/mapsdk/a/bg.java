package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hl;
import java.util.Arrays;

public class bg {
    private int a;
    private int b;
    private int c;
    private byte[] d = new byte[4];

    public bg() {
        AppMethodBeat.i(100786);
        AppMethodBeat.o(100786);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(100787);
        Arrays.fill(this.d, (byte) 0);
        System.arraycopy(bArr, 0, this.d, 0, 4);
        this.a = hl.a(this.d);
        System.arraycopy(bArr, 4, this.d, 0, 4);
        this.b = hl.a(this.d);
        System.arraycopy(bArr, 8, this.d, 0, 4);
        this.c = hl.a(this.d);
        AppMethodBeat.o(100787);
    }
}
