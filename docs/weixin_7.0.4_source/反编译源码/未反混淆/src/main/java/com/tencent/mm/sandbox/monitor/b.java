package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

public final class b {

    static class a {
        public String bzH;
        public final String platform = (d.eSg + "_" + d.vxo + "_" + Build.CPU_ABI);
        public String tag;
        public long timestamp;
        public String username;
        public boolean xvn;

        public a(String str, String str2, long j, String str3, boolean z) {
            AppMethodBeat.i(28784);
            this.username = str;
            this.tag = str2;
            this.timestamp = j;
            this.bzH = str3;
            this.xvn = false;
            this.xvn = z;
            AppMethodBeat.o(28784);
        }

        public final String toString() {
            AppMethodBeat.i(28785);
            String str = this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.bzH;
            AppMethodBeat.o(28785);
            return str;
        }
    }
}
