package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e {
    public static boolean b(bil bil) {
        AppMethodBeat.i(51573);
        if (bil == null || bil.wLQ == null || bil.wLQ.getBuffer() == null) {
            AppMethodBeat.o(51573);
            return false;
        }
        byte[] bufferToBytes = bil.wLQ.getBufferToBytes();
        if (bufferToBytes.length == 0 || (bufferToBytes.length & 1) != 0) {
            AppMethodBeat.o(51573);
            return false;
        }
        long longValue = new p(bil.uin).longValue();
        bufferToBytes = bx(bufferToBytes);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bil.version);
        if (bil.wLO.hasBuffer()) {
            stringBuilder.append(new String(bil.wLO.getBufferToBytes()));
        }
        stringBuilder.append(longValue);
        ab.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[]{Integer.valueOf(UtilsJni.doEcdsaVerify(a.tVz, stringBuilder.toString().getBytes(), bufferToBytes))}));
        if (UtilsJni.doEcdsaVerify(a.tVz, stringBuilder.toString().getBytes(), bufferToBytes) == 1) {
            AppMethodBeat.o(51573);
            return true;
        }
        AppMethodBeat.o(51573);
        return false;
    }

    public static boolean b(bim bim) {
        AppMethodBeat.i(51574);
        if (bim == null || bim.wLS == null || bim.wLS.getBuffer() == null) {
            AppMethodBeat.o(51574);
            return false;
        }
        byte[] bufferToBytes = bim.wLS.getBufferToBytes();
        if (bufferToBytes.length == 0 || (bufferToBytes.length & 1) != 0) {
            AppMethodBeat.o(51574);
            return false;
        }
        boolean z;
        bufferToBytes = bx(bufferToBytes);
        g.RN();
        long longValue = new p(a.QF()).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bim.wLR);
        stringBuilder.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.tVz, stringBuilder.toString().getBytes(), bufferToBytes);
        if ((doEcdsaVerify == 1 || bim.wLT != 1) && !(doEcdsaVerify == 1 && bim.wLT == 0)) {
            z = false;
        } else {
            z = true;
        }
        ab.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[]{Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)}));
        AppMethodBeat.o(51574);
        return z;
    }

    private static byte[] bx(byte[] bArr) {
        AppMethodBeat.i(51575);
        String str = "0123456789abcdef";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length - 1; i += 2) {
            byteArrayOutputStream.write((str.indexOf(Character.toLowerCase(bArr[i])) << 4) | str.indexOf(Character.toLowerCase(bArr[i + 1])));
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(51575);
        return toByteArray;
    }

    public static boolean cTz() {
        int i = -1;
        AppMethodBeat.i(51576);
        if (!g.RK() || a.QT()) {
            ab.w("MicroMsg.GestureUtil", "not login !!");
            AppMethodBeat.o(51576);
            return false;
        }
        int i2;
        boolean i22;
        int i3;
        boolean b;
        bim cTG = d.cTG();
        bil cTF = d.cTF();
        if (cTG == null) {
            i22 = 1;
        } else {
            i22 = false;
        }
        if (cTF == null) {
            i3 = 1;
        } else {
            boolean i32 = false;
        }
        if (i22 == 0) {
            i22 = b(cTG);
        } else {
            i22 = false;
        }
        String str = "MicroMsg.GestureUtil";
        String str2 = "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s";
        Object[] objArr = new Object[3];
        objArr[0] = cTG;
        objArr[1] = Integer.valueOf(cTG == null ? -1 : cTG.wLT);
        objArr[2] = Boolean.valueOf(i22);
        ab.i(str, str2, objArr);
        if (i32 == 0) {
            b = b(cTF);
        } else {
            b = false;
        }
        String str3 = "MicroMsg.GestureUtil";
        str = "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = cTF;
        if (cTF != null) {
            i = cTF.wLP;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = Boolean.valueOf(b);
        ab.i(str3, str, objArr2);
        if (i22) {
            if (b) {
                try {
                    ab.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
                    if (cTG.wLR > cTF.version) {
                        ab.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", Integer.valueOf(cTG.wLR), Integer.valueOf(cTF.version));
                        if (cTG.wLT == 1) {
                            AppMethodBeat.o(51576);
                            return true;
                        }
                        AppMethodBeat.o(51576);
                        return false;
                    } else if (cTG.wLR == cTF.version) {
                        ab.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", Integer.valueOf(cTG.wLR), Integer.valueOf(cTF.version));
                        if (cTG.wLT == 1) {
                            AppMethodBeat.o(51576);
                            return true;
                        }
                        AppMethodBeat.o(51576);
                        return false;
                    } else {
                        ab.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", Integer.valueOf(cTG.wLR), Integer.valueOf(cTF.version));
                        if (cTF.wLP == 1) {
                            AppMethodBeat.o(51576);
                            return true;
                        }
                        AppMethodBeat.o(51576);
                        return false;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.GestureUtil", e, "isUserSetWalletLock throw an exception.", new Object[0]);
                    AppMethodBeat.o(51576);
                    return false;
                }
            }
            ab.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
            if (cTG.wLT == 1) {
                AppMethodBeat.o(51576);
                return true;
            }
            AppMethodBeat.o(51576);
            return false;
        } else if (b) {
            ab.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
            if (cTF.wLP == 1) {
                AppMethodBeat.o(51576);
                return true;
            }
            AppMethodBeat.o(51576);
            return false;
        } else {
            ab.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            AppMethodBeat.o(51576);
            return false;
        }
    }

    public static byte[] dX(List<f> list) {
        AppMethodBeat.i(51577);
        if (list == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("pattern is null");
            AppMethodBeat.o(51577);
            throw illegalArgumentException;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) ((fVar.tVB + (fVar.tVA * 3)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append(bArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        byte[] bytes = com.tencent.mm.a.g.x((com.tencent.mm.a.g.x((com.tencent.mm.a.g.x(stringBuilder2.getBytes()) + r.Yz()).getBytes()) + stringBuilder2).getBytes()).getBytes();
        AppMethodBeat.o(51577);
        return bytes;
    }

    public static void a(g gVar) {
        AppMethodBeat.i(51578);
        if (gVar.tVD == -1) {
            AppMethodBeat.o(51578);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < gVar.tVD) {
            gVar.tVD = elapsedRealtime;
            gVar.tVE += elapsedRealtime;
            ab.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(gVar.tVE)}));
            AppMethodBeat.o(51578);
            return;
        }
        gVar.tVE = (elapsedRealtime - gVar.tVD) + gVar.tVE;
        gVar.tVD = elapsedRealtime;
        AppMethodBeat.o(51578);
    }

    public static byte[] stringToBytes(String str) {
        AppMethodBeat.i(51579);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(51579);
        return toByteArray;
    }

    public static String by(byte[] bArr) {
        AppMethodBeat.i(51580);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(51580);
        return stringBuilder2;
    }
}
