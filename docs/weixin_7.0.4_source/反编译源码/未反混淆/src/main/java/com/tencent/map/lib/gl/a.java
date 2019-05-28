package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class a {
    public static int a;

    static {
        AppMethodBeat.i(98045);
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory <= 16777216) {
            a = 1;
            AppMethodBeat.o(98045);
        } else if (maxMemory >= 67108864) {
            a = 2;
            AppMethodBeat.o(98045);
        } else {
            a = 0;
            AppMethodBeat.o(98045);
        }
    }

    public static FloatBuffer a(int i) {
        ByteBuffer allocateDirect;
        AppMethodBeat.i(98041);
        ByteBuffer.allocate(0);
        try {
            allocateDirect = ByteBuffer.allocateDirect(i * 4);
        } catch (OutOfMemoryError e) {
            allocateDirect = ByteBuffer.allocateDirect(i * 4);
        }
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.rewind();
        AppMethodBeat.o(98041);
        return asFloatBuffer;
    }

    public static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        AppMethodBeat.i(98042);
        int length = fArr.length;
        if (floatBuffer == null || floatBuffer.capacity() != length) {
            floatBuffer = a(length);
        }
        floatBuffer.put(fArr);
        floatBuffer.rewind();
        AppMethodBeat.o(98042);
        return floatBuffer;
    }

    public static ShortBuffer b(int i) {
        AppMethodBeat.i(98043);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.rewind();
        AppMethodBeat.o(98043);
        return asShortBuffer;
    }

    public static ShortBuffer a(short[] sArr, ShortBuffer shortBuffer) {
        AppMethodBeat.i(98044);
        int length = sArr.length;
        if (shortBuffer == null || shortBuffer.capacity() != length) {
            shortBuffer = b(length);
        }
        shortBuffer.put(sArr);
        shortBuffer.rewind();
        AppMethodBeat.o(98044);
        return shortBuffer;
    }
}
