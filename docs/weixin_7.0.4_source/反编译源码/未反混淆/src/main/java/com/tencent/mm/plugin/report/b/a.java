package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.io.IOException;

public final class a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private a pXh;
    private int pXi;
    private int pXj;
    private int pXk;
    private int pXl;

    public interface a {
    }

    static {
        AppMethodBeat.i(72668);
        AppMethodBeat.o(72668);
    }

    public a() {
        this.pXh = null;
        this.pXi = 0;
        this.pXj = 1;
        this.pXk = 2;
        this.pXl = 3;
        this.pXh = null;
    }

    public final void a(ate ate, int i) {
        AppMethodBeat.i(72665);
        ab.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:".concat(String.valueOf(i)));
        int i2;
        if (ate == null) {
            ab.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
            AppMethodBeat.o(72665);
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
            ab.e(str2, stringBuilder.append(str).append(",version:").append(ate.wxc).toString());
            AppMethodBeat.o(72665);
        } else {
            i2 = BM(i);
            int i3 = ate.wxc;
            if (i2 == i3) {
                ab.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:".concat(String.valueOf(i3)));
                AppMethodBeat.o(72665);
                return;
            }
            ab.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + BM(i) + ", svr:" + i3);
            ab.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + ate.wxc + ", ret:" + ate.wxe + ", size: " + ate.wxd.size());
            try {
                byte[] toByteArray = ate.toByteArray();
                synchronized (lock) {
                    try {
                        ab.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + ate.wxc);
                        e.b(ac.eSj, filename, toByteArray);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(72665);
                    }
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
                AppMethodBeat.o(72665);
            }
        }
    }

    public static ate cgh() {
        byte[] f;
        AppMethodBeat.i(72666);
        ab.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            try {
                f = e.f(ac.eSj + filename, 0, -1);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72666);
            }
        }
        if (f == null) {
            ab.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            return null;
        }
        ate ate = new ate();
        try {
            ate.parseFrom(f);
            ab.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + ate.wxc + ", ret:" + ate.wxe + ", size: " + ate.wxd.size());
            AppMethodBeat.o(72666);
            return ate;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            AppMethodBeat.o(72666);
            return null;
        }
    }

    public static int BM(int i) {
        AppMethodBeat.i(72667);
        ab.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:".concat(String.valueOf(i)));
        ate cgh = cgh();
        if (cgh == null) {
            AppMethodBeat.o(72667);
            return 0;
        }
        int i2 = cgh.wxc;
        ab.i("MicroMsg.HeavyUserIDMappingStg", "version:".concat(String.valueOf(i2)));
        AppMethodBeat.o(72667);
        return i2;
    }
}
