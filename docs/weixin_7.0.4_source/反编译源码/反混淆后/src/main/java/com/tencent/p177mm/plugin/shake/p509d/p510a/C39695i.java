package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.shake.p509d.p1412b.C29001a;
import com.tencent.p177mm.protocal.protobuf.byq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.shake.d.a.i */
public final class C39695i {

    /* renamed from: com.tencent.mm.plugin.shake.d.a.i$1 */
    public static class C396961 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(24634);
            C5730e.m8618N(C39695i.ckx(), true);
            AppMethodBeat.m2505o(24634);
        }

        public final String toString() {
            AppMethodBeat.m2504i(24635);
            String str = super.toString() + "|asyncClearMusicData";
            AppMethodBeat.m2505o(24635);
            return str;
        }
    }

    public static String ckx() {
        AppMethodBeat.m2504i(24636);
        if (C9638aw.m17179RK()) {
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            C5728b c5728b = new C5728b(stringBuilder.append(C18628c.getAccPath()).append("shakemusic/").toString());
            if (!(c5728b.exists() && c5728b.isDirectory())) {
                C4990ab.m7421w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", C5736j.m8649w(c5728b.dMD()));
                c5728b.mkdirs();
            }
            C5728b c5728b2 = new C5728b(c5728b, ".nomedia");
            if (!c5728b2.exists()) {
                C4990ab.m7421w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", C5736j.m8649w(c5728b.dMD()));
                try {
                    c5728b2.createNewFile();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (c5728b.exists()) {
                String str = C5736j.m8649w(c5728b.dMD()) + "/";
                AppMethodBeat.m2505o(24636);
                return str;
            }
            C4990ab.m7420w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            AppMethodBeat.m2505o(24636);
            return null;
        }
        C4990ab.m7420w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        AppMethodBeat.m2505o(24636);
        return null;
    }

    /* renamed from: d */
    public static C9058e m67840d(byte[] bArr, long j) {
        AppMethodBeat.m2504i(24637);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.m2505o(24637);
            return null;
        }
        try {
            byq byq = (byq) new byq().parseFrom(bArr);
            C9058e c9058e = new C9058e();
            c9058e.fJS = 4;
            c9058e.fJU = String.valueOf(byq.wXR);
            c9058e.fJV = byq.fJV;
            c9058e.fJY = C1946aa.m4153b(byq.wrD);
            c9058e.fJZ = C1946aa.m4153b(byq.wrE);
            c9058e.fKe = C29001a.m46039UK(c9058e.fJZ);
            c9058e.fJT = byq.fJT;
            c9058e.fKd = C1946aa.m4153b(byq.wrC);
            c9058e.fJW = C1946aa.m4153b(byq.wXS);
            c9058e.fJX = C1946aa.m4153b(byq.wXT);
            c9058e.fKc = C1946aa.m4153b(byq.wXW);
            c9058e.fKa = C1946aa.m4153b(byq.wXU);
            c9058e.fKb = C1946aa.m4153b(byq.wXV);
            c9058e.fKn = j;
            AppMethodBeat.m2505o(24637);
            return c9058e;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            AppMethodBeat.m2505o(24637);
            return null;
        }
    }
}
