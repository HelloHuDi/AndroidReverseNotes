package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.b.a;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
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

public final class b {
    public static byte[] a(String str, int i) {
        AppMethodBeat.i(67642);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        a aVar = new a();
        aVar.a(8);
        try {
            dataOutputStream.writeShort((short) i);
            dataOutputStream.writeShort((short) aVar.a());
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
            b(byteArrayOutputStream, str);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(67642);
            return toByteArray;
        } catch (IOException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.o(67642);
            throw assertionError;
        }
    }

    private static void a(OutputStream outputStream, String str) {
        AppMethodBeat.i(67643);
        for (String toASCII : str.split("[.。．｡]")) {
            byte[] bytes = IDN.toASCII(toASCII).getBytes();
            outputStream.write(bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }
        outputStream.write(0);
        AppMethodBeat.o(67643);
    }

    private static void b(OutputStream outputStream, String str) {
        AppMethodBeat.i(67644);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        a(outputStream, str);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(1);
        AppMethodBeat.o(67644);
    }

    public static e[] a(byte[] bArr, int i, String str) {
        Object obj = 1;
        AppMethodBeat.i(67645);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        com.tencent.liteav.network.a.a aVar;
        if (readUnsignedShort != i) {
            aVar = new com.tencent.liteav.network.a.a(str, "the answer id " + readUnsignedShort + " is not match " + i);
            AppMethodBeat.o(67645);
            throw aVar;
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
            aVar = new com.tencent.liteav.network.a.a(str, "the dns server cant support recursion ");
            AppMethodBeat.o(67645);
            throw aVar;
        }
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        a(dataInputStream, bArr, readUnsignedShort3);
        e[] b = b(dataInputStream, bArr, readUnsignedShort4);
        AppMethodBeat.o(67645);
        return b;
    }

    private static String a(DataInputStream dataInputStream, byte[] bArr) {
        AppMethodBeat.i(67646);
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        String a;
        if ((readUnsignedByte & az.CTRL_INDEX) == az.CTRL_INDEX) {
            readUnsignedByte = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte));
            a = a(bArr, readUnsignedByte, hashSet);
            AppMethodBeat.o(67646);
            return a;
        } else if (readUnsignedByte == 0) {
            a = "";
            AppMethodBeat.o(67646);
            return a;
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            a = IDN.toUnicode(new String(bArr2));
            String a2 = a(dataInputStream, bArr);
            if (a2.length() > 0) {
                a = a + "." + a2;
            }
            AppMethodBeat.o(67646);
            return a;
        }
    }

    private static String a(byte[] bArr, int i, HashSet<Integer> hashSet) {
        AppMethodBeat.i(67647);
        while (true) {
            int i2 = bArr[i] & 255;
            String str;
            if ((i2 & az.CTRL_INDEX) == az.CTRL_INDEX) {
                i = ((i2 & 63) << 8) + (bArr[i + 1] & 255);
                if (hashSet.contains(Integer.valueOf(i))) {
                    com.tencent.liteav.network.a.a aVar = new com.tencent.liteav.network.a.a("", "Cyclic offsets detected.");
                    AppMethodBeat.o(67647);
                    throw aVar;
                }
                hashSet.add(Integer.valueOf(i));
            } else if (i2 == 0) {
                str = "";
                AppMethodBeat.o(67647);
                return str;
            } else {
                str = new String(bArr, i + 1, i2);
                String a = a(bArr, i2 + (i + 1), (HashSet) hashSet);
                if (a.length() > 0) {
                    str = str + "." + a;
                }
                AppMethodBeat.o(67647);
                return str;
            }
        }
    }

    private static void a(DataInputStream dataInputStream, byte[] bArr, int i) {
        AppMethodBeat.i(67648);
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                a(dataInputStream, bArr);
                dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                i = i2;
            } else {
                AppMethodBeat.o(67648);
                return;
            }
        }
    }

    private static e[] b(DataInputStream dataInputStream, byte[] bArr, int i) {
        AppMethodBeat.i(67649);
        int i2 = 0;
        e[] eVarArr = new e[i];
        while (true) {
            int i3 = i - 1;
            if (i > 0) {
                int i4 = i2 + 1;
                eVarArr[i2] = b(dataInputStream, bArr);
                i2 = i4;
                i = i3;
            } else {
                AppMethodBeat.o(67649);
                return eVarArr;
            }
        }
    }

    private static e b(DataInputStream dataInputStream, byte[] bArr) {
        String hostAddress;
        AppMethodBeat.i(67650);
        a(dataInputStream, bArr);
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
                hostAddress = a(dataInputStream, bArr);
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
            AppMethodBeat.o(67650);
            throw unknownHostException;
        }
        e eVar = new e(hostAddress, readUnsignedShort, (int) readUnsignedShort2, System.currentTimeMillis() / 1000);
        AppMethodBeat.o(67650);
        return eVar;
    }
}
