package com.tencent.p177mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;

/* renamed from: com.tencent.mm.platformtools.aa */
public final class C1946aa {
    /* renamed from: ad */
    public static SKBuiltinBuffer_t m4152ad(byte[] bArr) {
        AppMethodBeat.m2504i(58726);
        if (bArr == null) {
            AppMethodBeat.m2505o(58726);
            return null;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        AppMethodBeat.m2505o(58726);
        return sKBuiltinBuffer_t;
    }

    /* renamed from: a */
    public static byte[] m4150a(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.m2504i(58727);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.m2505o(58727);
            return null;
        }
        byte[] toByteArray = sKBuiltinBuffer_t.getBuffer().toByteArray();
        AppMethodBeat.m2505o(58727);
        return toByteArray;
    }

    /* renamed from: a */
    public static byte[] m4151a(SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        AppMethodBeat.m2504i(58728);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.m2505o(58728);
            return bArr;
        }
        bArr = sKBuiltinBuffer_t.getBuffer().toByteArray();
        AppMethodBeat.m2505o(58728);
        return bArr;
    }

    /* renamed from: a */
    public static String m4148a(bts bts) {
        if (bts == null) {
            return null;
        }
        return bts.wVI;
    }

    /* renamed from: a */
    public static String m4149a(bts bts, String str) {
        if (bts == null) {
            return str;
        }
        return bts.wVI;
    }

    /* renamed from: vy */
    public static bts m4154vy(String str) {
        AppMethodBeat.m2504i(58729);
        if (str == null) {
            AppMethodBeat.m2505o(58729);
            return null;
        }
        bts bts = new bts();
        bts.alV(str);
        AppMethodBeat.m2505o(58729);
        return bts;
    }

    /* renamed from: a */
    public static String m4147a(C1332b c1332b) {
        AppMethodBeat.m2504i(58730);
        if (c1332b == null) {
            AppMethodBeat.m2505o(58730);
            return null;
        }
        String dlY = c1332b.dlY();
        AppMethodBeat.m2505o(58730);
        return dlY;
    }

    /* renamed from: b */
    public static String m4153b(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.m2504i(58731);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.m2505o(58731);
            return null;
        }
        String dlY = sKBuiltinBuffer_t.getBuffer().dlY();
        AppMethodBeat.m2505o(58731);
        return dlY;
    }

    /* renamed from: vz */
    public static SKBuiltinBuffer_t m4155vz(String str) {
        AppMethodBeat.m2504i(58732);
        if (str == null) {
            AppMethodBeat.m2505o(58732);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        if (decode == null) {
            AppMethodBeat.m2505o(58732);
            return null;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(decode);
        AppMethodBeat.m2505o(58732);
        return sKBuiltinBuffer_t;
    }
}
