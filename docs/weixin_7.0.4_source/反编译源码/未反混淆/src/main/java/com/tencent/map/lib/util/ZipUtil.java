package com.tencent.map.lib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    public static void zipFile(File file, String str) {
        AppMethodBeat.i(98232);
        if (file == null || !file.exists()) {
            AppMethodBeat.o(98232);
            return;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        byte[] bArr = new byte[49152];
        FileInputStream fileInputStream = new FileInputStream(file);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(str, file.getName() + ".zip")));
        zipOutputStream.setLevel(9);
        zipOutputStream.setMethod(8);
        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                zipOutputStream.finish();
                zipOutputStream.close();
                fileInputStream.close();
                AppMethodBeat.o(98232);
                return;
            }
        }
    }

    public static void upZipFile(File file, String str) {
        AppMethodBeat.i(98233);
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        byte[] bArr = new byte[49152];
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (name == null || !name.contains("../")) {
                if (zipEntry.isDirectory()) {
                    new File(str + File.separator + zipEntry.getName()).mkdir();
                } else {
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    File file3 = new File(str + File.separator + zipEntry.getName());
                    if (!file3.exists()) {
                        file2 = file3.getParentFile();
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    inputStream.close();
                    fileOutputStream.close();
                }
            }
        }
        zipFile.close();
        AppMethodBeat.o(98233);
    }

    public static byte[] deflate(byte[] bArr) {
        AppMethodBeat.i(98234);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(98234);
            return toByteArray;
        } catch (Exception e) {
            AppMethodBeat.o(98234);
            return null;
        }
    }

    public static byte[] inflate(byte[] bArr) {
        AppMethodBeat.i(98235);
        byte[] inflate = inflate(bArr, 0, bArr.length);
        AppMethodBeat.o(98235);
        return inflate;
    }

    public static byte[] inflate(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(98236);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr, i, i2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        int read;
        do {
            try {
                read = inflaterInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    continue;
                }
            } catch (IOException e) {
                try {
                    inflaterInputStream.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.o(98236);
                return null;
            }
        } while (read > 0);
        try {
            inflaterInputStream.close();
        } catch (IOException e3) {
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e4) {
        }
        AppMethodBeat.o(98236);
        return toByteArray;
    }

    public static void upZipFiles(File file, String str) {
        AppMethodBeat.i(98237);
        try {
            upZipFileFromInputStream(new FileInputStream(file), new File(str));
            AppMethodBeat.o(98237);
        } catch (Exception e) {
            AppMethodBeat.o(98237);
        }
    }

    public static void upZipFileFromInputStream(InputStream inputStream, File file) {
        AppMethodBeat.i(98238);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        byte[] bArr = new byte[49152];
        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            if (nextEntry.isDirectory()) {
                String name = nextEntry.getName();
                new File(file + File.separator + name.substring(0, name.length() - 1)).mkdir();
            } else {
                File file2 = new File(file, File.separator + nextEntry.getName());
                if (!file2.exists()) {
                    File parentFile = file2.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        inputStream.close();
        zipInputStream.close();
        AppMethodBeat.o(98238);
    }
}
