package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class i {
    public static String ckx() {
        AppMethodBeat.i(24636);
        if (aw.RK()) {
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            b bVar = new b(stringBuilder.append(c.getAccPath()).append("shakemusic/").toString());
            if (!(bVar.exists() && bVar.isDirectory())) {
                ab.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", j.w(bVar.dMD()));
                bVar.mkdirs();
            }
            b bVar2 = new b(bVar, ".nomedia");
            if (!bVar2.exists()) {
                ab.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", j.w(bVar.dMD()));
                try {
                    bVar2.createNewFile();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (bVar.exists()) {
                String str = j.w(bVar.dMD()) + "/";
                AppMethodBeat.o(24636);
                return str;
            }
            ab.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            AppMethodBeat.o(24636);
            return null;
        }
        ab.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        AppMethodBeat.o(24636);
        return null;
    }

    public static e d(byte[] bArr, long j) {
        AppMethodBeat.i(24637);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(24637);
            return null;
        }
        try {
            byq byq = (byq) new byq().parseFrom(bArr);
            e eVar = new e();
            eVar.fJS = 4;
            eVar.fJU = String.valueOf(byq.wXR);
            eVar.fJV = byq.fJV;
            eVar.fJY = aa.b(byq.wrD);
            eVar.fJZ = aa.b(byq.wrE);
            eVar.fKe = a.UK(eVar.fJZ);
            eVar.fJT = byq.fJT;
            eVar.fKd = aa.b(byq.wrC);
            eVar.fJW = aa.b(byq.wXS);
            eVar.fJX = aa.b(byq.wXT);
            eVar.fKc = aa.b(byq.wXW);
            eVar.fKa = aa.b(byq.wXU);
            eVar.fKb = aa.b(byq.wXV);
            eVar.fKn = j;
            AppMethodBeat.o(24637);
            return eVar;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            ab.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            AppMethodBeat.o(24637);
            return null;
        }
    }
}
