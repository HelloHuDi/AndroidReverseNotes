package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class hn {
    public final Rect a = new Rect();
    public int[] b;
    public int[] c;
    public int[] d;

    public hn() {
        AppMethodBeat.i(99558);
        AppMethodBeat.o(99558);
    }

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        AppMethodBeat.i(99559);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
        AppMethodBeat.o(99559);
    }

    private static void a(int i) {
        AppMethodBeat.i(99560);
        if (i == 0 || (i & 1) != 0) {
            RuntimeException runtimeException = new RuntimeException("invalid nine-patch: ".concat(String.valueOf(i)));
            AppMethodBeat.o(99560);
            throw runtimeException;
        }
        AppMethodBeat.o(99560);
    }

    public static hn a(byte[] bArr) {
        AppMethodBeat.i(99561);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == (byte) 0) {
            AppMethodBeat.o(99561);
            return null;
        }
        hn hnVar = new hn();
        hnVar.b = new int[order.get()];
        hnVar.c = new int[order.get()];
        hnVar.d = new int[order.get()];
        a(hnVar.b.length);
        a(hnVar.c.length);
        order.getInt();
        order.getInt();
        hnVar.a.left = order.getInt();
        hnVar.a.right = order.getInt();
        hnVar.a.top = order.getInt();
        hnVar.a.bottom = order.getInt();
        order.getInt();
        a(hnVar.b, order);
        a(hnVar.c, order);
        a(hnVar.d, order);
        AppMethodBeat.o(99561);
        return hnVar;
    }
}
