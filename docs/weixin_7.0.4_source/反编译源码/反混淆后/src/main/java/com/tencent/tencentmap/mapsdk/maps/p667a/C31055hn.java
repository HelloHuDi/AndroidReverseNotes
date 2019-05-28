package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hn */
public class C31055hn {
    /* renamed from: a */
    public final Rect f14156a = new Rect();
    /* renamed from: b */
    public int[] f14157b;
    /* renamed from: c */
    public int[] f14158c;
    /* renamed from: d */
    public int[] f14159d;

    public C31055hn() {
        AppMethodBeat.m2504i(99558);
        AppMethodBeat.m2505o(99558);
    }

    /* renamed from: a */
    private static void m49933a(int[] iArr, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(99559);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
        AppMethodBeat.m2505o(99559);
    }

    /* renamed from: a */
    private static void m49932a(int i) {
        AppMethodBeat.m2504i(99560);
        if (i == 0 || (i & 1) != 0) {
            RuntimeException runtimeException = new RuntimeException("invalid nine-patch: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(99560);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(99560);
    }

    /* renamed from: a */
    public static C31055hn m49931a(byte[] bArr) {
        AppMethodBeat.m2504i(99561);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == (byte) 0) {
            AppMethodBeat.m2505o(99561);
            return null;
        }
        C31055hn c31055hn = new C31055hn();
        c31055hn.f14157b = new int[order.get()];
        c31055hn.f14158c = new int[order.get()];
        c31055hn.f14159d = new int[order.get()];
        C31055hn.m49932a(c31055hn.f14157b.length);
        C31055hn.m49932a(c31055hn.f14158c.length);
        order.getInt();
        order.getInt();
        c31055hn.f14156a.left = order.getInt();
        c31055hn.f14156a.right = order.getInt();
        c31055hn.f14156a.top = order.getInt();
        c31055hn.f14156a.bottom = order.getInt();
        order.getInt();
        C31055hn.m49933a(c31055hn.f14157b, order);
        C31055hn.m49933a(c31055hn.f14158c, order);
        C31055hn.m49933a(c31055hn.f14159d, order);
        AppMethodBeat.m2505o(99561);
        return c31055hn;
    }
}
