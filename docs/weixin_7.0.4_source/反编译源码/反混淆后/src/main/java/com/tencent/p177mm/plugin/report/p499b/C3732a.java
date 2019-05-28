package com.tencent.p177mm.plugin.report.p499b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.protocal.protobuf.ate;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.report.b.a */
public final class C3732a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private C3731a pXh;
    private int pXi;
    private int pXj;
    private int pXk;
    private int pXl;

    /* renamed from: com.tencent.mm.plugin.report.b.a$a */
    public interface C3731a {
    }

    static {
        AppMethodBeat.m2504i(72668);
        AppMethodBeat.m2505o(72668);
    }

    public C3732a() {
        this.pXh = null;
        this.pXi = 0;
        this.pXj = 1;
        this.pXk = 2;
        this.pXl = 3;
        this.pXh = null;
    }

    /* renamed from: a */
    public final void mo8372a(ate ate, int i) {
        AppMethodBeat.m2504i(72665);
        C4990ab.m7416i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:".concat(String.valueOf(i)));
        int i2;
        if (ate == null) {
            C4990ab.m7420w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
            AppMethodBeat.m2505o(72665);
        } else if (this.pXi != ate.wxe) {
            String str;
            String str2 = "MicroMsg.HeavyUserIDMappingStg";
            StringBuilder stringBuilder = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
            i2 = ate.wxe;
            if (this.pXj == i2) {
                str = "服务器过载";
            } else if (this.pXk == i2) {
                str = "服务器没有配置表";
            } else if (this.pXl == i2) {
                str = "服务器配置表错误";
            } else {
                str = "非法的错误类型";
            }
            C4990ab.m7412e(str2, stringBuilder.append(str).append(",version:").append(ate.wxc).toString());
            AppMethodBeat.m2505o(72665);
        } else {
            i2 = C3732a.m6037BM(i);
            int i3 = ate.wxc;
            if (i2 == i3) {
                C4990ab.m7410d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:".concat(String.valueOf(i3)));
                AppMethodBeat.m2505o(72665);
                return;
            }
            C4990ab.m7416i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + C3732a.m6037BM(i) + ", svr:" + i3);
            C4990ab.m7416i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + ate.wxc + ", ret:" + ate.wxe + ", size: " + ate.wxd.size());
            try {
                byte[] toByteArray = ate.toByteArray();
                synchronized (lock) {
                    try {
                        C4990ab.m7416i("MicroMsg.HeavyUserIDMappingStg", "new version:" + ate.wxc);
                        C1173e.m2558b(C5128ac.eSj, filename, toByteArray);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(72665);
                    }
                }
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
                AppMethodBeat.m2505o(72665);
            }
        }
    }

    public static ate cgh() {
        byte[] f;
        AppMethodBeat.m2504i(72666);
        C4990ab.m7410d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            try {
                f = C1173e.m2571f(C5128ac.eSj + filename, 0, -1);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(72666);
            }
        }
        if (f == null) {
            C4990ab.m7420w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            return null;
        }
        ate ate = new ate();
        try {
            ate.parseFrom(f);
            C4990ab.m7416i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + ate.wxc + ", ret:" + ate.wxe + ", size: " + ate.wxd.size());
            AppMethodBeat.m2505o(72666);
            return ate;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            AppMethodBeat.m2505o(72666);
            return null;
        }
    }

    /* renamed from: BM */
    public static int m6037BM(int i) {
        AppMethodBeat.m2504i(72667);
        C4990ab.m7410d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:".concat(String.valueOf(i)));
        ate cgh = C3732a.cgh();
        if (cgh == null) {
            AppMethodBeat.m2505o(72667);
            return 0;
        }
        int i2 = cgh.wxc;
        C4990ab.m7416i("MicroMsg.HeavyUserIDMappingStg", "version:".concat(String.valueOf(i2)));
        AppMethodBeat.m2505o(72667);
        return i2;
    }
}
