package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class j {
    public static final ByteBuffer BzX;
    public static final byte[] EMPTY_BYTE_ARRAY;

    public interface b<T extends a> {
        T SW(int i);
    }

    public interface a {
        int edd();
    }

    public static String cB(byte[] bArr) {
        AppMethodBeat.i(121529);
        try {
            String str = new String(bArr, "UTF-8");
            AppMethodBeat.o(121529);
            return str;
        } catch (UnsupportedEncodingException e) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", e);
            AppMethodBeat.o(121529);
            throw runtimeException;
        }
    }

    static {
        AppMethodBeat.i(121530);
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        BzX = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(121530);
    }

    public static boolean cA(byte[] bArr) {
        AppMethodBeat.i(121528);
        boolean C = y.C(bArr, 0, bArr.length);
        AppMethodBeat.o(121528);
        return C;
    }
}
