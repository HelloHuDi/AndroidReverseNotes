package com.tencent.p177mm.audio.mix.p197h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.mm.audio.mix.h.c */
public final class C9057c {
    protected static char[] caT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> cok = new C12961();

    /* renamed from: com.tencent.mm.audio.mix.h.c$1 */
    static class C12961 extends ThreadLocal<MessageDigest> {
        C12961() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(137220);
            MessageDigest zN = C12961.m2771zN();
            AppMethodBeat.m2505o(137220);
            return zN;
        }

        /* renamed from: zN */
        private static MessageDigest m2771zN() {
            AppMethodBeat.m2504i(137219);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                AppMethodBeat.m2505o(137219);
                return instance;
            } catch (NoSuchAlgorithmException e) {
                RuntimeException runtimeException = new RuntimeException("Initialize MD5 failed.", e);
                AppMethodBeat.m2505o(137219);
                throw runtimeException;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(137222);
        AppMethodBeat.m2505o(137222);
    }

    /* renamed from: ck */
    public static String m16429ck(String str) {
        AppMethodBeat.m2504i(137221);
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
        AppMethodBeat.m2505o(137221);
        return stringBuffer2;
    }
}
