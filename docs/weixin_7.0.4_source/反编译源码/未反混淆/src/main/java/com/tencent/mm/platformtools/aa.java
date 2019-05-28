package com.tencent.mm.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;

public final class aa {
    public static SKBuiltinBuffer_t ad(byte[] bArr) {
        AppMethodBeat.i(58726);
        if (bArr == null) {
            AppMethodBeat.o(58726);
            return null;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(bArr);
        AppMethodBeat.o(58726);
        return sKBuiltinBuffer_t;
    }

    public static byte[] a(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(58727);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(58727);
            return null;
        }
        byte[] toByteArray = sKBuiltinBuffer_t.getBuffer().toByteArray();
        AppMethodBeat.o(58727);
        return toByteArray;
    }

    public static byte[] a(SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        AppMethodBeat.i(58728);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(58728);
            return bArr;
        }
        bArr = sKBuiltinBuffer_t.getBuffer().toByteArray();
        AppMethodBeat.o(58728);
        return bArr;
    }

    public static String a(bts bts) {
        if (bts == null) {
            return null;
        }
        return bts.wVI;
    }

    public static String a(bts bts, String str) {
        if (bts == null) {
            return str;
        }
        return bts.wVI;
    }

    public static bts vy(String str) {
        AppMethodBeat.i(58729);
        if (str == null) {
            AppMethodBeat.o(58729);
            return null;
        }
        bts bts = new bts();
        bts.alV(str);
        AppMethodBeat.o(58729);
        return bts;
    }

    public static String a(b bVar) {
        AppMethodBeat.i(58730);
        if (bVar == null) {
            AppMethodBeat.o(58730);
            return null;
        }
        String dlY = bVar.dlY();
        AppMethodBeat.o(58730);
        return dlY;
    }

    public static String b(SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(58731);
        if (sKBuiltinBuffer_t == null || sKBuiltinBuffer_t.getBuffer() == null) {
            AppMethodBeat.o(58731);
            return null;
        }
        String dlY = sKBuiltinBuffer_t.getBuffer().dlY();
        AppMethodBeat.o(58731);
        return dlY;
    }

    public static SKBuiltinBuffer_t vz(String str) {
        AppMethodBeat.i(58732);
        if (str == null) {
            AppMethodBeat.o(58732);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        if (decode == null) {
            AppMethodBeat.o(58732);
            return null;
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(decode);
        AppMethodBeat.o(58732);
        return sKBuiltinBuffer_t;
    }
}
