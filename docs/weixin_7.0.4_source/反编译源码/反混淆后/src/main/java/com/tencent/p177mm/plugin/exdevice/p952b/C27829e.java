package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.p1255e.C20470f;
import com.tencent.p177mm.plugin.exdevice.p1255e.C27832g;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.CRC32;

/* renamed from: com.tencent.mm.plugin.exdevice.b.e */
public final class C27829e extends C11634d {
    public C27829e(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        AppMethodBeat.m2504i(19042);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        AppMethodBeat.m2505o(19042);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aL */
    public final C1331a mo23391aL(byte[] bArr) {
        AppMethodBeat.m2504i(19043);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
            AppMethodBeat.m2505o(19043);
            return null;
        }
        C1331a c20470f = new C20470f();
        try {
            c20470f.parseFrom(bArr);
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
            this.lqE = c20470f;
            AppMethodBeat.m2505o(19043);
            return c20470f;
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", e, "", new Object[0]);
            AppMethodBeat.m2505o(19043);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo45699a(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        int[] iArr;
        int i4;
        int i5;
        AppMethodBeat.m2504i(19044);
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", Integer.valueOf(i), str, C42992b.m76349aN(bArr), C42992b.m76349aN(bArr2), Integer.valueOf(i2), Integer.valueOf(i3));
        C27832g c27832g = new C27832g();
        c27832g.lvk = mo45698as(0, "ok");
        String Yz = C1853r.m3846Yz();
        if (C5046bo.isNullOrNil(Yz)) {
            iArr = null;
        } else {
            long j;
            Yz = C4995ag.m7428ck(Yz).toLowerCase();
            C4990ab.m7417i("MicroMsg.exdevice.Util", "user md5 : [%s]", Yz);
            if (C5046bo.isNullOrNil(Yz)) {
                C4990ab.m7412e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
                j = 0;
            } else {
                i4 = 0;
                char[] toCharArray = Yz.toCharArray();
                if (toCharArray.length > 0) {
                    for (char c : toCharArray) {
                        i4 = (i4 * 31) + c;
                    }
                }
                C4990ab.m7417i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", Integer.valueOf(i4), Long.valueOf(((long) i4) & 4294967295L));
                j = r4;
            }
            iArr = new int[]{(int) ((j >> 32) & 4294967295L), (int) (j & 4294967295L)};
        }
        c27832g.luX = iArr[0];
        c27832g.luY = iArr[1];
        if (!C5046bo.m7540cb(bArr2)) {
            if (bArr2 == null || bArr2.length == 0) {
                i5 = 0;
            } else {
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                i5 = (int) crc32.getValue();
            }
            c27832g.luZ = i5;
        }
        if (!C5046bo.m7540cb(bArr)) {
            if ((bArr[0] & 4) != 0) {
                c27832g.jBG = C7243d.vxj;
            }
            if ((bArr[0] & 8) != 0) {
                c27832g.lve = C7243d.vxm;
            }
            if ((bArr[0] & 2) != 0) {
                c27832g.lvd = 2;
            }
            if ((bArr[0] & 16) != 0) {
                c27832g.lvf = (int) C5046bo.anT();
            }
            if ((bArr[0] & 32) != 0) {
                TimeZone timeZone = TimeZone.getDefault();
                i4 = timeZone.getRawOffset() / 1000;
                i5 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 1 : 0;
                C4990ab.m7417i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((i4 / 3600) + i5));
                c27832g.lvg = r4;
            }
            if ((bArr[0] & 64) != 0) {
                c27832g.lvh = C42992b.bqh();
            }
            if ((bArr[0] & 1) != 0) {
                c27832g.lvc = C1853r.m3820YB();
            }
        }
        c27832g.lva = i2;
        c27832g.lvb = i3;
        this.lqD = c27832g;
        this.lqB = (short) 20003;
        AppMethodBeat.m2505o(19044);
    }
}
