package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.mm.sdk.platformtools.ag */
public final class C4995ag {
    protected static char[] caT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static ThreadLocal<MessageDigest> cok = new C49941();

    /* renamed from: com.tencent.mm.sdk.platformtools.ag$1 */
    static class C49941 extends ThreadLocal<MessageDigest> {
        C49941() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(52052);
            MessageDigest zN = C49941.m7425zN();
            AppMethodBeat.m2505o(52052);
            return zN;
        }

        /* renamed from: zN */
        private static MessageDigest m7425zN() {
            AppMethodBeat.m2504i(52051);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                AppMethodBeat.m2505o(52051);
                return instance;
            } catch (NoSuchAlgorithmException e) {
                RuntimeException runtimeException = new RuntimeException("Initialize MD5 failed.", e);
                AppMethodBeat.m2505o(52051);
                throw runtimeException;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(52057);
        AppMethodBeat.m2505o(52057);
    }

    /* renamed from: ck */
    public static String m7428ck(String str) {
        AppMethodBeat.m2504i(52053);
        String w = C4995ag.m7429w(str.getBytes());
        AppMethodBeat.m2505o(52053);
        return w;
    }

    /* renamed from: w */
    public static String m7429w(byte[] bArr) {
        AppMethodBeat.m2504i(52054);
        byte[] digest = ((MessageDigest) cok.get()).digest(bArr);
        String V = C4995ag.m7426V(digest, digest.length);
        AppMethodBeat.m2505o(52054);
        return V;
    }

    /* renamed from: V */
    private static String m7426V(byte[] bArr, int i) {
        AppMethodBeat.m2504i(52055);
        StringBuffer stringBuffer = new StringBuffer(i * 2);
        int i2 = i + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            C4995ag.m7427a(bArr[i3], stringBuffer);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(52055);
        return stringBuffer2;
    }

    /* renamed from: a */
    private static void m7427a(byte b, StringBuffer stringBuffer) {
        AppMethodBeat.m2504i(52056);
        char c = caT[(b & 240) >> 4];
        char c2 = caT[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
        AppMethodBeat.m2505o(52056);
    }
}
