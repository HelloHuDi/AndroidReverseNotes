package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: a.i.b.a.c.g.j */
public final class C8181j {
    public static final ByteBuffer BzX;
    public static final byte[] EMPTY_BYTE_ARRAY;

    /* renamed from: a.i.b.a.c.g.j$b */
    public interface C8182b<T extends C8183a> {
        /* renamed from: SW */
        T mo146SW(int i);
    }

    /* renamed from: a.i.b.a.c.g.j$a */
    public interface C8183a {
        int edd();
    }

    /* renamed from: cB */
    public static String m14443cB(byte[] bArr) {
        AppMethodBeat.m2504i(121529);
        try {
            String str = new String(bArr, "UTF-8");
            AppMethodBeat.m2505o(121529);
            return str;
        } catch (UnsupportedEncodingException e) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", e);
            AppMethodBeat.m2505o(121529);
            throw runtimeException;
        }
    }

    static {
        AppMethodBeat.m2504i(121530);
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        BzX = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(121530);
    }

    /* renamed from: cA */
    public static boolean m14442cA(byte[] bArr) {
        AppMethodBeat.m2504i(121528);
        boolean C = C25164y.m39648C(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(121528);
        return C;
    }
}
