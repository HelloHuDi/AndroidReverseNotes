package com.tencent.p177mm.plugin.walletlock.gesture.p1059a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.protocal.protobuf.bil;
import com.tencent.p177mm.protocal.protobuf.bim;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.walletlock.gesture.a.e */
public final class C46391e {
    /* renamed from: b */
    public static boolean m87261b(bil bil) {
        AppMethodBeat.m2504i(51573);
        if (bil == null || bil.wLQ == null || bil.wLQ.getBuffer() == null) {
            AppMethodBeat.m2505o(51573);
            return false;
        }
        byte[] bufferToBytes = bil.wLQ.getBufferToBytes();
        if (bufferToBytes.length == 0 || (bufferToBytes.length & 1) != 0) {
            AppMethodBeat.m2505o(51573);
            return false;
        }
        long longValue = new C1183p(bil.uin).longValue();
        bufferToBytes = C46391e.m87263bx(bufferToBytes);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bil.version);
        if (bil.wLO.hasBuffer()) {
            stringBuilder.append(new String(bil.wLO.getBufferToBytes()));
        }
        stringBuilder.append(longValue);
        C4990ab.m7410d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[]{Integer.valueOf(UtilsJni.doEcdsaVerify(C29714a.tVz, stringBuilder.toString().getBytes(), bufferToBytes))}));
        if (UtilsJni.doEcdsaVerify(C29714a.tVz, stringBuilder.toString().getBytes(), bufferToBytes) == 1) {
            AppMethodBeat.m2505o(51573);
            return true;
        }
        AppMethodBeat.m2505o(51573);
        return false;
    }

    /* renamed from: b */
    public static boolean m87262b(bim bim) {
        AppMethodBeat.m2504i(51574);
        if (bim == null || bim.wLS == null || bim.wLS.getBuffer() == null) {
            AppMethodBeat.m2505o(51574);
            return false;
        }
        byte[] bufferToBytes = bim.wLS.getBufferToBytes();
        if (bufferToBytes.length == 0 || (bufferToBytes.length & 1) != 0) {
            AppMethodBeat.m2505o(51574);
            return false;
        }
        boolean z;
        bufferToBytes = C46391e.m87263bx(bufferToBytes);
        C1720g.m3534RN();
        long longValue = new C1183p(C1668a.m3383QF()).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bim.wLR);
        stringBuilder.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(C29714a.tVz, stringBuilder.toString().getBytes(), bufferToBytes);
        if ((doEcdsaVerify == 1 || bim.wLT != 1) && !(doEcdsaVerify == 1 && bim.wLT == 0)) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7410d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[]{Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)}));
        AppMethodBeat.m2505o(51574);
        return z;
    }

    /* renamed from: bx */
    private static byte[] m87263bx(byte[] bArr) {
        AppMethodBeat.m2504i(51575);
        String str = "0123456789abcdef";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length - 1; i += 2) {
            byteArrayOutputStream.write((str.indexOf(Character.toLowerCase(bArr[i])) << 4) | str.indexOf(Character.toLowerCase(bArr[i + 1])));
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(51575);
        return toByteArray;
    }

    public static boolean cTz() {
        int i = -1;
        AppMethodBeat.m2504i(51576);
        if (!C1720g.m3531RK() || C1668a.m3393QT()) {
            C4990ab.m7420w("MicroMsg.GestureUtil", "not login !!");
            AppMethodBeat.m2505o(51576);
            return false;
        }
        int i2;
        boolean i22;
        int i3;
        boolean b;
        bim cTG = C40176d.cTG();
        bil cTF = C40176d.cTF();
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
            i22 = C46391e.m87262b(cTG);
        } else {
            i22 = false;
        }
        String str = "MicroMsg.GestureUtil";
        String str2 = "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s";
        Object[] objArr = new Object[3];
        objArr[0] = cTG;
        objArr[1] = Integer.valueOf(cTG == null ? -1 : cTG.wLT);
        objArr[2] = Boolean.valueOf(i22);
        C4990ab.m7417i(str, str2, objArr);
        if (i32 == 0) {
            b = C46391e.m87261b(cTF);
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
        C4990ab.m7417i(str3, str, objArr2);
        if (i22) {
            if (b) {
                try {
                    C4990ab.m7416i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
                    if (cTG.wLR > cTF.version) {
                        C4990ab.m7417i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", Integer.valueOf(cTG.wLR), Integer.valueOf(cTF.version));
                        if (cTG.wLT == 1) {
                            AppMethodBeat.m2505o(51576);
                            return true;
                        }
                        AppMethodBeat.m2505o(51576);
                        return false;
                    } else if (cTG.wLR == cTF.version) {
                        C4990ab.m7417i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", Integer.valueOf(cTG.wLR), Integer.valueOf(cTF.version));
                        if (cTG.wLT == 1) {
                            AppMethodBeat.m2505o(51576);
                            return true;
                        }
                        AppMethodBeat.m2505o(51576);
                        return false;
                    } else {
                        C4990ab.m7417i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", Integer.valueOf(cTG.wLR), Integer.valueOf(cTF.version));
                        if (cTF.wLP == 1) {
                            AppMethodBeat.m2505o(51576);
                            return true;
                        }
                        AppMethodBeat.m2505o(51576);
                        return false;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.GestureUtil", e, "isUserSetWalletLock throw an exception.", new Object[0]);
                    AppMethodBeat.m2505o(51576);
                    return false;
                }
            }
            C4990ab.m7416i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
            if (cTG.wLT == 1) {
                AppMethodBeat.m2505o(51576);
                return true;
            }
            AppMethodBeat.m2505o(51576);
            return false;
        } else if (b) {
            C4990ab.m7416i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
            if (cTF.wLP == 1) {
                AppMethodBeat.m2505o(51576);
                return true;
            }
            AppMethodBeat.m2505o(51576);
            return false;
        } else {
            C4990ab.m7420w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            AppMethodBeat.m2505o(51576);
            return false;
        }
    }

    /* renamed from: dX */
    public static byte[] m87265dX(List<C14393f> list) {
        AppMethodBeat.m2504i(51577);
        if (list == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("pattern is null");
            AppMethodBeat.m2505o(51577);
            throw illegalArgumentException;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            C14393f c14393f = (C14393f) list.get(i);
            bArr[i] = (byte) ((c14393f.tVB + (c14393f.tVA * 3)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append(bArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        byte[] bytes = C1178g.m2591x((C1178g.m2591x((C1178g.m2591x(stringBuilder2.getBytes()) + C1853r.m3846Yz()).getBytes()) + stringBuilder2).getBytes()).getBytes();
        AppMethodBeat.m2505o(51577);
        return bytes;
    }

    /* renamed from: a */
    public static void m87260a(C14394g c14394g) {
        AppMethodBeat.m2504i(51578);
        if (c14394g.tVD == -1) {
            AppMethodBeat.m2505o(51578);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < c14394g.tVD) {
            c14394g.tVD = elapsedRealtime;
            c14394g.tVE += elapsedRealtime;
            C4990ab.m7410d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(c14394g.tVE)}));
            AppMethodBeat.m2505o(51578);
            return;
        }
        c14394g.tVE = (elapsedRealtime - c14394g.tVD) + c14394g.tVE;
        c14394g.tVD = elapsedRealtime;
        AppMethodBeat.m2505o(51578);
    }

    public static byte[] stringToBytes(String str) {
        AppMethodBeat.m2504i(51579);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(51579);
        return toByteArray;
    }

    /* renamed from: by */
    public static String m87264by(byte[] bArr) {
        AppMethodBeat.m2504i(51580);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(51580);
        return stringBuilder2;
    }
}
