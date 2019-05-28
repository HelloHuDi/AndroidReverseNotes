package com.tencent.liteav.network.p812a.p813a;

import com.tencent.liteav.network.p812a.C25662a;
import com.tencent.liteav.network.p812a.C45111e;
import com.tencent.liteav.network.p812a.p1373b.C25663a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

/* renamed from: com.tencent.liteav.network.a.a.b */
public final class C8830b {
    /* renamed from: a */
    public static byte[] m15733a(String str, int i) {
        AppMethodBeat.m2504i(67642);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        C25663a c25663a = new C25663a();
        c25663a.mo43414a(8);
        try {
            dataOutputStream.writeShort((short) i);
            dataOutputStream.writeShort((short) c25663a.mo43413a());
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
            C8830b.m15736b(byteArrayOutputStream, str);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(67642);
            return toByteArray;
        } catch (IOException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.m2505o(67642);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private static void m15732a(OutputStream outputStream, String str) {
        AppMethodBeat.m2504i(67643);
        for (String toASCII : str.split("[.。．｡]")) {
            byte[] bytes = IDN.toASCII(toASCII).getBytes();
            outputStream.write(bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }
        outputStream.write(0);
        AppMethodBeat.m2505o(67643);
    }

    /* renamed from: b */
    private static void m15736b(OutputStream outputStream, String str) {
        AppMethodBeat.m2504i(67644);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        C8830b.m15732a(outputStream, str);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(1);
        AppMethodBeat.m2505o(67644);
    }

    /* renamed from: a */
    public static C45111e[] m15734a(byte[] bArr, int i, String str) {
        Object obj = 1;
        AppMethodBeat.m2504i(67645);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        C25662a c25662a;
        if (readUnsignedShort != i) {
            c25662a = new C25662a(str, "the answer id " + readUnsignedShort + " is not match " + i);
            AppMethodBeat.m2505o(67645);
            throw c25662a;
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        Object obj2;
        if (((readUnsignedShort2 >> 8) & 1) == 1) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (((readUnsignedShort2 >> 7) & 1) != 1) {
            obj = null;
        }
        if (obj == null || obj2 == null) {
            c25662a = new C25662a(str, "the dns server cant support recursion ");
            AppMethodBeat.m2505o(67645);
            throw c25662a;
        }
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        C8830b.m15731a(dataInputStream, bArr, readUnsignedShort3);
        C45111e[] b = C8830b.m15737b(dataInputStream, bArr, readUnsignedShort4);
        AppMethodBeat.m2505o(67645);
        return b;
    }

    /* renamed from: a */
    private static String m15729a(DataInputStream dataInputStream, byte[] bArr) {
        AppMethodBeat.m2504i(67646);
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        String a;
        if ((readUnsignedByte & C33250az.CTRL_INDEX) == C33250az.CTRL_INDEX) {
            readUnsignedByte = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte));
            a = C8830b.m15730a(bArr, readUnsignedByte, hashSet);
            AppMethodBeat.m2505o(67646);
            return a;
        } else if (readUnsignedByte == 0) {
            a = "";
            AppMethodBeat.m2505o(67646);
            return a;
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            a = IDN.toUnicode(new String(bArr2));
            String a2 = C8830b.m15729a(dataInputStream, bArr);
            if (a2.length() > 0) {
                a = a + "." + a2;
            }
            AppMethodBeat.m2505o(67646);
            return a;
        }
    }

    /* renamed from: a */
    private static String m15730a(byte[] bArr, int i, HashSet<Integer> hashSet) {
        AppMethodBeat.m2504i(67647);
        while (true) {
            int i2 = bArr[i] & 255;
            String str;
            if ((i2 & C33250az.CTRL_INDEX) == C33250az.CTRL_INDEX) {
                i = ((i2 & 63) << 8) + (bArr[i + 1] & 255);
                if (hashSet.contains(Integer.valueOf(i))) {
                    C25662a c25662a = new C25662a("", "Cyclic offsets detected.");
                    AppMethodBeat.m2505o(67647);
                    throw c25662a;
                }
                hashSet.add(Integer.valueOf(i));
            } else if (i2 == 0) {
                str = "";
                AppMethodBeat.m2505o(67647);
                return str;
            } else {
                str = new String(bArr, i + 1, i2);
                String a = C8830b.m15730a(bArr, i2 + (i + 1), (HashSet) hashSet);
                if (a.length() > 0) {
                    str = str + "." + a;
                }
                AppMethodBeat.m2505o(67647);
                return str;
            }
        }
    }

    /* renamed from: a */
    private static void m15731a(DataInputStream dataInputStream, byte[] bArr, int i) {
        AppMethodBeat.m2504i(67648);
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                C8830b.m15729a(dataInputStream, bArr);
                dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                i = i2;
            } else {
                AppMethodBeat.m2505o(67648);
                return;
            }
        }
    }

    /* renamed from: b */
    private static C45111e[] m15737b(DataInputStream dataInputStream, byte[] bArr, int i) {
        AppMethodBeat.m2504i(67649);
        int i2 = 0;
        C45111e[] c45111eArr = new C45111e[i];
        while (true) {
            int i3 = i - 1;
            if (i > 0) {
                int i4 = i2 + 1;
                c45111eArr[i2] = C8830b.m15735b(dataInputStream, bArr);
                i2 = i4;
                i = i3;
            } else {
                AppMethodBeat.m2505o(67649);
                return c45111eArr;
            }
        }
    }

    /* renamed from: b */
    private static C45111e m15735b(DataInputStream dataInputStream, byte[] bArr) {
        String hostAddress;
        AppMethodBeat.m2504i(67650);
        C8830b.m15729a(dataInputStream, bArr);
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        long readUnsignedShort2 = ((long) dataInputStream.readUnsignedShort()) + (((long) dataInputStream.readUnsignedShort()) << 16);
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        switch (readUnsignedShort) {
            case 1:
                byte[] bArr2 = new byte[4];
                dataInputStream.readFully(bArr2);
                hostAddress = InetAddress.getByAddress(bArr2).getHostAddress();
                break;
            case 5:
                hostAddress = C8830b.m15729a(dataInputStream, bArr);
                break;
            default:
                hostAddress = null;
                for (int i = 0; i < readUnsignedShort3; i++) {
                    dataInputStream.readByte();
                }
                break;
        }
        if (hostAddress == null) {
            UnknownHostException unknownHostException = new UnknownHostException("no record");
            AppMethodBeat.m2505o(67650);
            throw unknownHostException;
        }
        C45111e c45111e = new C45111e(hostAddress, readUnsignedShort, (int) readUnsignedShort2, System.currentTimeMillis() / 1000);
        AppMethodBeat.m2505o(67650);
        return c45111e;
    }
}
