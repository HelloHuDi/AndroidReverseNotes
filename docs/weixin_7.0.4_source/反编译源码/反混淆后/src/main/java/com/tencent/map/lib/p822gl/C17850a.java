package com.tencent.map.lib.p822gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* renamed from: com.tencent.map.lib.gl.a */
public class C17850a {
    /* renamed from: a */
    public static int f4293a;

    static {
        AppMethodBeat.m2504i(98045);
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory <= 16777216) {
            f4293a = 1;
            AppMethodBeat.m2505o(98045);
        } else if (maxMemory >= 67108864) {
            f4293a = 2;
            AppMethodBeat.m2505o(98045);
        } else {
            f4293a = 0;
            AppMethodBeat.m2505o(98045);
        }
    }

    /* renamed from: a */
    public static FloatBuffer m27933a(int i) {
        ByteBuffer allocateDirect;
        AppMethodBeat.m2504i(98041);
        ByteBuffer.allocate(0);
        try {
            allocateDirect = ByteBuffer.allocateDirect(i * 4);
        } catch (OutOfMemoryError e) {
            allocateDirect = ByteBuffer.allocateDirect(i * 4);
        }
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.rewind();
        AppMethodBeat.m2505o(98041);
        return asFloatBuffer;
    }

    /* renamed from: a */
    public static FloatBuffer m27934a(float[] fArr, FloatBuffer floatBuffer) {
        AppMethodBeat.m2504i(98042);
        int length = fArr.length;
        if (floatBuffer == null || floatBuffer.capacity() != length) {
            floatBuffer = C17850a.m27933a(length);
        }
        floatBuffer.put(fArr);
        floatBuffer.rewind();
        AppMethodBeat.m2505o(98042);
        return floatBuffer;
    }

    /* renamed from: b */
    public static ShortBuffer m27936b(int i) {
        AppMethodBeat.m2504i(98043);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.rewind();
        AppMethodBeat.m2505o(98043);
        return asShortBuffer;
    }

    /* renamed from: a */
    public static ShortBuffer m27935a(short[] sArr, ShortBuffer shortBuffer) {
        AppMethodBeat.m2504i(98044);
        int length = sArr.length;
        if (shortBuffer == null || shortBuffer.capacity() != length) {
            shortBuffer = C17850a.m27936b(length);
        }
        shortBuffer.put(sArr);
        shortBuffer.rewind();
        AppMethodBeat.m2505o(98044);
        return shortBuffer;
    }
}
