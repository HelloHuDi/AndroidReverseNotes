package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ag {
    protected static char[] caT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> cok = new ThreadLocal<MessageDigest>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(52052);
            MessageDigest zN = AnonymousClass1.zN();
            AppMethodBeat.o(52052);
            return zN;
        }

        private static MessageDigest zN() {
            AppMethodBeat.i(52051);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                AppMethodBeat.o(52051);
                return instance;
            } catch (NoSuchAlgorithmException e) {
                RuntimeException runtimeException = new RuntimeException("Initialize MD5 failed.", e);
                AppMethodBeat.o(52051);
                throw runtimeException;
            }
        }
    };

    static {
        AppMethodBeat.i(52057);
        AppMethodBeat.o(52057);
    }

    public static String ck(String str) {
        AppMethodBeat.i(52053);
        String w = w(str.getBytes());
        AppMethodBeat.o(52053);
        return w;
    }

    public static String w(byte[] bArr) {
        AppMethodBeat.i(52054);
        byte[] digest = ((MessageDigest) cok.get()).digest(bArr);
        String V = V(digest, digest.length);
        AppMethodBeat.o(52054);
        return V;
    }

    private static String V(byte[] bArr, int i) {
        AppMethodBeat.i(52055);
        StringBuffer stringBuffer = new StringBuffer(i * 2);
        int i2 = i + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            a(bArr[i3], stringBuffer);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(52055);
        return stringBuffer2;
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        AppMethodBeat.i(52056);
        char c = caT[(b & 240) >> 4];
        char c2 = caT[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
        AppMethodBeat.o(52056);
    }
}
