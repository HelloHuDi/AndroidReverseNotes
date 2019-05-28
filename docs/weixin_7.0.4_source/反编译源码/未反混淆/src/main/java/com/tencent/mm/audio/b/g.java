package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public class g {
    public static final String cqq = (e.eSn + "test.wav");
    public static final String cqr = (e.eSn + "test.pcm");

    public static class a {
        public byte[] buf;
        public int cqs = 0;
        public boolean cqt = false;

        public a(byte[] bArr, int i) {
            this.buf = bArr;
            this.cqs = i;
            this.cqt = false;
        }

        public a(byte[] bArr, int i, boolean z) {
            this.buf = bArr;
            this.cqs = i;
            this.cqt = z;
        }
    }

    public static class b {
        private static boolean cqu;
        private static boolean cqv;

        static {
            AppMethodBeat.i(55758);
            cqu = false;
            cqv = false;
            int Lw = m.Lw();
            ab.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(Lw));
            if (!bo.isNullOrNil(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !bo.isNullOrNil(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
                ab.i("MicroMsg.RecorderUtil", "don't contains armeabi");
                k.a("wechatvoicesilk_v5", g.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
                cqu = true;
                cqv = false;
            } else if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                try {
                    k.a("wechatvoicesilk_v7a", g.class.getClassLoader());
                    cqu = true;
                    cqv = true;
                } catch (UnsatisfiedLinkError e) {
                    ab.e("MicroMsg.RecorderUtil", "load library failed!");
                    cqu = false;
                    cqv = false;
                }
            } else if ((Lw & 512) != 0) {
                k.a("wechatvoicesilk", g.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
                cqu = true;
                cqv = true;
            } else {
                k.a("wechatvoicesilk_v5", g.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
                cqu = true;
                cqv = false;
            }
            ab.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(cqu), Boolean.valueOf(cqv));
            AppMethodBeat.o(55758);
        }

        public static boolean ER() {
            return cqu;
        }

        public static boolean ES() {
            return cqv;
        }
    }

    static {
        AppMethodBeat.i(55760);
        AppMethodBeat.o(55760);
    }

    public static int x(String str, int i) {
        AppMethodBeat.i(55759);
        try {
            i = bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue(str), i);
        } catch (Exception e) {
            ab.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(str)));
        } catch (Error e2) {
            ab.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(55759);
        return i;
    }
}
