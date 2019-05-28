package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.e.f;
import com.tencent.mm.plugin.exdevice.e.g;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.CRC32;

public final class e extends d {
    public e(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        AppMethodBeat.i(19042);
        ab.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        AppMethodBeat.o(19042);
    }

    /* Access modifiers changed, original: protected|final */
    public final a aL(byte[] bArr) {
        AppMethodBeat.i(19043);
        if (bArr == null || bArr.length == 0) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
            AppMethodBeat.o(19043);
            return null;
        }
        a fVar = new f();
        try {
            fVar.parseFrom(bArr);
            ab.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
            this.lqE = fVar;
            AppMethodBeat.o(19043);
            return fVar;
        } catch (IOException e) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", e, "", new Object[0]);
            AppMethodBeat.o(19043);
            return null;
        }
    }

    public final void a(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        int[] iArr;
        int i4;
        int i5;
        AppMethodBeat.i(19044);
        ab.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", Integer.valueOf(i), str, b.aN(bArr), b.aN(bArr2), Integer.valueOf(i2), Integer.valueOf(i3));
        g gVar = new g();
        gVar.lvk = as(0, "ok");
        String Yz = r.Yz();
        if (bo.isNullOrNil(Yz)) {
            iArr = null;
        } else {
            long j;
            Yz = ag.ck(Yz).toLowerCase();
            ab.i("MicroMsg.exdevice.Util", "user md5 : [%s]", Yz);
            if (bo.isNullOrNil(Yz)) {
                ab.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
                j = 0;
            } else {
                i4 = 0;
                char[] toCharArray = Yz.toCharArray();
                if (toCharArray.length > 0) {
                    for (char c : toCharArray) {
                        i4 = (i4 * 31) + c;
                    }
                }
                ab.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", Integer.valueOf(i4), Long.valueOf(((long) i4) & 4294967295L));
                j = r4;
            }
            iArr = new int[]{(int) ((j >> 32) & 4294967295L), (int) (j & 4294967295L)};
        }
        gVar.luX = iArr[0];
        gVar.luY = iArr[1];
        if (!bo.cb(bArr2)) {
            if (bArr2 == null || bArr2.length == 0) {
                i5 = 0;
            } else {
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                i5 = (int) crc32.getValue();
            }
            gVar.luZ = i5;
        }
        if (!bo.cb(bArr)) {
            if ((bArr[0] & 4) != 0) {
                gVar.jBG = d.vxj;
            }
            if ((bArr[0] & 8) != 0) {
                gVar.lve = d.vxm;
            }
            if ((bArr[0] & 2) != 0) {
                gVar.lvd = 2;
            }
            if ((bArr[0] & 16) != 0) {
                gVar.lvf = (int) bo.anT();
            }
            if ((bArr[0] & 32) != 0) {
                TimeZone timeZone = TimeZone.getDefault();
                i4 = timeZone.getRawOffset() / 1000;
                i5 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 1 : 0;
                ab.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((i4 / 3600) + i5));
                gVar.lvg = r4;
            }
            if ((bArr[0] & 64) != 0) {
                gVar.lvh = b.bqh();
            }
            if ((bArr[0] & 1) != 0) {
                gVar.lvc = r.YB();
            }
        }
        gVar.lva = i2;
        gVar.lvb = i3;
        this.lqD = gVar;
        this.lqB = (short) 20003;
        AppMethodBeat.o(19044);
    }
}
