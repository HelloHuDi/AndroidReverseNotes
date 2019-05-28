package com.tencent.p177mm.sandbox.monitor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C7243d;

/* renamed from: com.tencent.mm.sandbox.monitor.b */
public final class C30273b {

    /* renamed from: com.tencent.mm.sandbox.monitor.b$a */
    static class C30274a {
        public String bzH;
        public final String platform = (C7243d.eSg + "_" + C7243d.vxo + "_" + Build.CPU_ABI);
        public String tag;
        public long timestamp;
        public String username;
        public boolean xvn;

        public C30274a(String str, String str2, long j, String str3, boolean z) {
            AppMethodBeat.m2504i(28784);
            this.username = str;
            this.tag = str2;
            this.timestamp = j;
            this.bzH = str3;
            this.xvn = false;
            this.xvn = z;
            AppMethodBeat.m2505o(28784);
        }

        public final String toString() {
            AppMethodBeat.m2504i(28785);
            String str = this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.bzH;
            AppMethodBeat.m2505o(28785);
            return str;
        }
    }
}
