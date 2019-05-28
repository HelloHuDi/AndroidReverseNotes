package com.tencent.p177mm.audio.p195b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.audio.b.g */
public class C32304g {
    public static final String cqq = (C6457e.eSn + "test.wav");
    public static final String cqr = (C6457e.eSn + "test.pcm");

    /* renamed from: com.tencent.mm.audio.b.g$a */
    public static class C32305a {
        public byte[] buf;
        public int cqs = 0;
        public boolean cqt = false;

        public C32305a(byte[] bArr, int i) {
            this.buf = bArr;
            this.cqs = i;
            this.cqt = false;
        }

        public C32305a(byte[] bArr, int i, boolean z) {
            this.buf = bArr;
            this.cqs = i;
            this.cqt = z;
        }
    }

    /* renamed from: com.tencent.mm.audio.b.g$b */
    public static class C32306b {
        private static boolean cqu;
        private static boolean cqv;

        static {
            AppMethodBeat.m2504i(55758);
            cqu = false;
            cqv = false;
            int Lw = C45290m.m83509Lw();
            C4990ab.m7417i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(Lw));
            if (!C5046bo.isNullOrNil(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !C5046bo.isNullOrNil(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
                C4990ab.m7416i("MicroMsg.RecorderUtil", "don't contains armeabi");
                C1449k.m3079a("wechatvoicesilk_v5", C32304g.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
                cqu = true;
                cqv = false;
            } else if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                try {
                    C1449k.m3079a("wechatvoicesilk_v7a", C32304g.class.getClassLoader());
                    cqu = true;
                    cqv = true;
                } catch (UnsatisfiedLinkError e) {
                    C4990ab.m7412e("MicroMsg.RecorderUtil", "load library failed!");
                    cqu = false;
                    cqv = false;
                }
            } else if ((Lw & 512) != 0) {
                C1449k.m3079a("wechatvoicesilk", C32304g.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
                cqu = true;
                cqv = true;
            } else {
                C1449k.m3079a("wechatvoicesilk_v5", C32304g.class.getClassLoader());
                Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
                cqu = true;
                cqv = false;
            }
            C4990ab.m7417i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(cqu), Boolean.valueOf(cqv));
            AppMethodBeat.m2505o(55758);
        }

        /* renamed from: ER */
        public static boolean m52781ER() {
            return cqu;
        }

        /* renamed from: ES */
        public static boolean m52782ES() {
            return cqv;
        }
    }

    static {
        AppMethodBeat.m2504i(55760);
        AppMethodBeat.m2505o(55760);
    }

    /* renamed from: x */
    public static int m52780x(String str, int i) {
        AppMethodBeat.m2504i(55759);
        try {
            i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue(str), i);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(str)));
        } catch (Error e2) {
            C4990ab.m7412e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(55759);
        return i;
    }
}
