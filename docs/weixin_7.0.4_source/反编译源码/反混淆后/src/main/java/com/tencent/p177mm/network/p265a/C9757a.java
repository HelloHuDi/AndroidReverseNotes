package com.tencent.p177mm.network.p265a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;

/* renamed from: com.tencent.mm.network.a.a */
public interface C9757a {

    /* renamed from: com.tencent.mm.network.a.a$a */
    public static class C9758a {
        public long bZI = 0;
        public long beginTime = 0;
        public String clientIp = "";
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public C18727c geA;
        public boolean geB = false;
        public long geC = 0;
        public long geD = 0;
        public long geE = 0;
        public int geF = 0;
        public int geG = 0;
        public long geH = 0;
        public long geI = 0;
        public long geJ = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int retryCount = 0;
        public long rtType = 0;

        public final String toString() {
            AppMethodBeat.m2504i(58712);
            String str = "rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d";
            Object[] objArr = new Object[13];
            objArr[0] = Long.valueOf(this.rtType);
            objArr[1] = Long.valueOf(this.beginTime);
            objArr[2] = Long.valueOf(this.endTime);
            objArr[3] = Long.valueOf(this.endTime - this.beginTime);
            objArr[4] = Long.valueOf(this.bZI);
            objArr[5] = Long.valueOf(this.geE);
            objArr[6] = this.geA == null ? BuildConfig.COMMAND : this.geA.toString();
            objArr[7] = Boolean.valueOf(this.geB);
            objArr[8] = Integer.valueOf(this.netType);
            objArr[9] = Integer.valueOf(this.errType);
            objArr[10] = Integer.valueOf(this.errCode);
            objArr[11] = Long.valueOf(this.geC);
            objArr[12] = Long.valueOf(this.geD);
            String format = String.format(str, objArr);
            AppMethodBeat.m2505o(58712);
            return format;
        }
    }
}
