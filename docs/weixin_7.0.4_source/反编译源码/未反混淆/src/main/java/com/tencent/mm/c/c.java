package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.zip.ZipException;

public final class c {
    private static final k cdn = new k(84298576);
    private static final k cdo = new k(50613072);
    private static int cdp = 0;
    private static final k cdq = new k(101010256);

    static class a {
        Properties cdr;
        byte[] cds;

        private a() {
            AppMethodBeat.i(125710);
            this.cdr = new Properties();
            AppMethodBeat.o(125710);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void E(byte[] bArr) {
            AppMethodBeat.i(125711);
            if (bArr == null || bArr.length == 0) {
                AppMethodBeat.o(125711);
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            c.cdn;
            byte[] bArr2 = new byte[4];
            wrap.get(bArr2);
            System.out.println("securityPart: " + new k(bArr2).value);
            int i;
            if (c.cdn.equals(new k(bArr2))) {
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - securityMarkLength <= 2");
                    AppMethodBeat.o(125711);
                    return;
                }
                bArr2 = new byte[2];
                wrap.get(bArr2);
                i = new l(bArr2).value;
                if ((bArr.length - 4) - 2 < i) {
                    System.err.println("data.length - securityMarkLength - 2 < len");
                    System.err.println("exit");
                    AppMethodBeat.o(125711);
                    return;
                }
                byte[] bArr3 = new byte[i];
                wrap.get(bArr3);
                this.cdr.load(new ByteArrayInputStream(bArr3));
                i = ((bArr.length - 4) - i) - 2;
                if (i > 0) {
                    c.cdo;
                    bArr3 = new byte[4];
                    wrap.get(bArr3);
                    if (c.cdo.equals(new k(bArr3))) {
                        if (i - 4 <= 2) {
                            System.err.println("data.length - oriMarkLength <= 2");
                            AppMethodBeat.o(125711);
                            return;
                        }
                        bArr3 = new byte[2];
                        wrap.get(bArr3);
                        int i2 = new l(bArr3).value;
                        if ((i - 4) - 2 < i2) {
                            System.err.println("data.length - oriMarkLength - 2 < len");
                            System.err.println("exit");
                            AppMethodBeat.o(125711);
                            return;
                        }
                        this.cds = new byte[i2];
                        wrap.get(this.cds);
                        AppMethodBeat.o(125711);
                        return;
                    }
                }
                AppMethodBeat.o(125711);
            } else if (c.cdo.equals(new k(bArr2))) {
                c.cdo;
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - oriMarkLength <= 2");
                    AppMethodBeat.o(125711);
                    return;
                }
                bArr2 = new byte[2];
                wrap.get(bArr2);
                i = new l(bArr2).value;
                if ((bArr.length - 4) - 2 < i) {
                    System.err.println("data.length - oriMarkLength - 2 < len");
                    System.err.println("exit");
                    AppMethodBeat.o(125711);
                    return;
                }
                this.cds = new byte[i];
                wrap.get(this.cds);
                AppMethodBeat.o(125711);
            } else {
                ProtocolException protocolException = new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
                AppMethodBeat.o(125711);
                throw protocolException;
            }
        }

        /* Access modifiers changed, original: final */
        public final byte[] AL() {
            byte[] bytes;
            AppMethodBeat.i(125712);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.cdr.size() > 0) {
                String str;
                byteArrayOutputStream.write(c.cdn.getBytes());
                String str2 = "";
                Iterator it = this.cdr.keySet().iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    str2 = new StringBuilder(String.valueOf(str)).append(next).append("=").append(this.cdr.getProperty((String) next)).append(IOUtils.LINE_SEPARATOR_WINDOWS).toString();
                }
                bytes = str.getBytes();
                byteArrayOutputStream.write(new l(bytes.length).getBytes());
                byteArrayOutputStream.write(bytes);
            }
            if (this.cds != null && this.cds.length > 0) {
                byteArrayOutputStream.write(c.cdo.getBytes());
                byteArrayOutputStream.write(new l(this.cds.length).getBytes());
                byteArrayOutputStream.write(this.cds);
            }
            bytes = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(125712);
            return bytes;
        }
    }

    static {
        AppMethodBeat.i(125713);
        AppMethodBeat.o(125713);
    }

    private static byte[] c(RandomAccessFile randomAccessFile) {
        int i = 1;
        AppMethodBeat.i(125714);
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = cdq.getBytes();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            System.err.println("archive is not a ZIP archive");
            ZipException zipException = new ZipException("archive is not a ZIP archive");
            AppMethodBeat.o(125714);
            throw zipException;
        }
        randomAccessFile.seek((length + 16) + 4);
        if (((long) cdp) != (length + 16) + 4) {
            cdp = (int) ((length + 16) + 4);
        }
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        System.err.println("readComment:length bytes data = " + D(bArr));
        i = new l(bArr).value;
        if (i == 0) {
            AppMethodBeat.o(125714);
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        AppMethodBeat.o(125714);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(File file, String str) {
        Throwable th;
        byte[] bArr = null;
        AppMethodBeat.i(125715);
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                byte[] c = c(randomAccessFile);
                if (c != null) {
                    byte[] bArr2 = new byte[4];
                    ByteBuffer.wrap(c).get(bArr2);
                    if (cdn.equals(new k(bArr2))) {
                        bArr = c;
                    } else if (cdo.equals(new k(bArr2))) {
                        bArr = c;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(cdo.getBytes());
                        byteArrayOutputStream.write(new l(c.length).getBytes());
                        byteArrayOutputStream.write(c);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                }
                a aVar = new a();
                aVar.E(bArr);
                aVar.cdr.setProperty("apkSecurityCode", str);
                c = aVar.AL();
                randomAccessFile.seek((long) cdp);
                randomAccessFile.write(new l(c.length).getBytes());
                randomAccessFile.write(c);
                randomAccessFile.setLength((long) ((c.length + cdp) + 2));
                System.err.println("file length is = " + randomAccessFile.length());
                randomAccessFile.close();
                System.err.println("exit writeSecurityCode");
                AppMethodBeat.o(125715);
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit writeSecurityCode");
                AppMethodBeat.o(125715);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            System.err.println("exit writeSecurityCode");
            AppMethodBeat.o(125715);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String y(File file) {
        Throwable th;
        String str = null;
        AppMethodBeat.i(125716);
        System.err.println("enter getSecurityCode");
        System.err.println("apkFile filename:" + file.getName());
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] c = c(randomAccessFile);
                if (c == null) {
                    System.err.println("null == readComment");
                    System.err.println("exit");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                    AppMethodBeat.o(125716);
                } else {
                    a aVar = new a();
                    aVar.E(c);
                    str = aVar.cdr.getProperty("apkSecurityCode");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                    AppMethodBeat.o(125716);
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                }
                System.err.println("exit getSecurityCode");
                AppMethodBeat.o(125716);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit getSecurityCode");
            AppMethodBeat.o(125716);
            throw th;
        }
    }

    private static String D(byte[] bArr) {
        AppMethodBeat.i(125717);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(bArr[i]);
            stringBuilder.append(",");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(125717);
        return stringBuilder2;
    }
}
