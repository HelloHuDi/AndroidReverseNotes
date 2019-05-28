package com.tencent.mm.audio.mix.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    protected static char[] caT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> cok = new ThreadLocal<MessageDigest>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(137220);
            MessageDigest zN = AnonymousClass1.zN();
            AppMethodBeat.o(137220);
            return zN;
        }

        private static MessageDigest zN() {
            AppMethodBeat.i(137219);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                AppMethodBeat.o(137219);
                return instance;
            } catch (NoSuchAlgorithmException e) {
                RuntimeException runtimeException = new RuntimeException("Initialize MD5 failed.", e);
                AppMethodBeat.o(137219);
                throw runtimeException;
            }
        }
    };

    static {
        AppMethodBeat.i(137222);
        AppMethodBeat.o(137222);
    }

    public static String ck(String str) {
        AppMethodBeat.i(137221);
        byte[] digest = ((MessageDigest) cok.get()).digest(str.getBytes());
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i = length + 0;
        for (length = 0; length < i; length++) {
            byte b = digest[length];
            char c = caT[(b & 240) >> 4];
            char c2 = caT[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(137221);
        return stringBuffer2;
    }
}
