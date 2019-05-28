package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.d.b.b;
import com.tencent.mm.plugin.downloader.d.h.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;

public final class e {
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0219 A:{Catch:{ Exception -> 0x007e }} */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x045e A:{Catch:{ IOException -> 0x0272, b -> 0x02d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019f A:{Catch:{ Exception -> 0x007e }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0116 A:{SYNTHETIC, Splitter:B:49:0x0116} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(File file, String str) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        AppMethodBeat.i(2314);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(2314);
            return false;
        }
        boolean R;
        int i;
        if (file.exists() && file.isFile()) {
            R = i.R(file);
        } else {
            R = false;
        }
        if (R) {
            i = 2;
        } else {
            if (file.exists() && file.isFile()) {
                R = h.O(file);
            } else {
                R = false;
            }
            if (R) {
                i = 1;
            } else {
                i = -1;
            }
        }
        f fVar;
        if (i == 1) {
            ab.i("MicroMsg.Channel.GameChannelUtil", "apk : " + file.getAbsolutePath() + ", ChannelPackageMode : V1");
            Exception exception;
            try {
                if (file.exists() && file.isFile() && !str.isEmpty()) {
                    randomAccessFile = null;
                    fVar = new f();
                    fVar.F(new AnonymousClass1(str));
                    byte[] AL = fVar.AL();
                    Pair N = h.N(file);
                    RandomAccessFile randomAccessFile2;
                    if (((ByteBuffer) N.first).remaining() == 22) {
                        ab.i("MicroMsg.Channel.V1SchemeUtil", "file : %s, has no comment", file.getAbsolutePath());
                        try {
                            randomAccessFile2 = new RandomAccessFile(file, "rw");
                            try {
                                randomAccessFile2.seek(file.length() - 2);
                                h.a(AL.length, randomAccessFile2);
                                randomAccessFile2.write(AL);
                                randomAccessFile2.close();
                            } catch (Throwable th2) {
                                th = th2;
                                if (randomAccessFile2 != null) {
                                }
                                AppMethodBeat.o(2314);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = null;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            AppMethodBeat.o(2314);
                            throw th;
                        }
                    }
                    ab.i("MicroMsg.Channel.V1SchemeUtil", "file : %s, has comment", file.getAbsolutePath());
                    int f = k.f((ByteBuffer) N.first, 20);
                    byte[] bArr = new byte[f];
                    ((ByteBuffer) N.first).position(((ByteBuffer) N.first).capacity() - f);
                    ((ByteBuffer) N.first).get(bArr, 0, bArr.length);
                    f fVar2 = new f();
                    fVar2.E(bArr);
                    String property = fVar2.kMf.getProperty(DownloadInfoColumns.CHANNELID);
                    if (property == null) {
                        ab.i("MicroMsg.Channel.V1SchemeUtil", "has no game channel, need to add channel");
                        f += AL.length;
                        try {
                            randomAccessFile2 = new RandomAccessFile(file, "rw");
                            try {
                                randomAccessFile2.seek((((Long) N.second).longValue() + 22) - 2);
                                h.a(f, randomAccessFile2);
                                randomAccessFile2.write(AL);
                                randomAccessFile2.write(bArr);
                                randomAccessFile2.close();
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile = randomAccessFile2;
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                AppMethodBeat.o(2314);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (randomAccessFile != null) {
                            }
                            AppMethodBeat.o(2314);
                            throw th;
                        }
                    }
                    String str2 = "MicroMsg.Channel.V1SchemeUtil";
                    String str3 = "newChannel(%s) %s existChannel(%s)";
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    objArr[1] = str.equals(property) ? "==" : "!=";
                    objArr[2] = property;
                    ab.i(str2, str3, objArr);
                    if (!str.equals(property)) {
                        ab.i("MicroMsg.Channel.V1SchemeUtil", "need update game channel");
                        fVar2.kMf.put(DownloadInfoColumns.CHANNELID, str);
                        AL = fVar2.AL();
                        try {
                            randomAccessFile2 = new RandomAccessFile(file, "rw");
                            try {
                                randomAccessFile2.setLength(((long) (AL.length - bArr.length)) + randomAccessFile2.length());
                                randomAccessFile2.seek((((Long) N.second).longValue() + 22) - 2);
                                h.a(AL.length, randomAccessFile2);
                                randomAccessFile2.write(AL);
                                randomAccessFile2.close();
                            } catch (Throwable th6) {
                                th = th6;
                                randomAccessFile = randomAccessFile2;
                                if (randomAccessFile != null) {
                                }
                                AppMethodBeat.o(2314);
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            AppMethodBeat.o(2314);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(2314);
                    return true;
                }
                exception = new Exception("param error , file : " + file + " , channel : " + str);
                AppMethodBeat.o(2314);
                throw exception;
            } catch (Exception exception2) {
                ab.e("MicroMsg.Channel.GameChannelUtil", "writeChannel, error1: %s", exception2.getMessage());
                AppMethodBeat.o(2314);
                return false;
            }
        } else if (i == 2) {
            ab.i("MicroMsg.Channel.GameChannelUtil", "apk : " + file.getAbsolutePath() + ", ChannelPackageMode : V2");
            b bVar;
            try {
                RuntimeException runtimeException;
                if (str.length() <= 0) {
                    runtimeException = new RuntimeException("addChannelByV2 , param invalid, channel = " + str + " , apkFile = " + file);
                    AppMethodBeat.o(2314);
                    throw runtimeException;
                }
                a Q;
                if (file.exists() && file.isFile()) {
                    Q = i.Q(file);
                } else {
                    Q = null;
                }
                fVar = new f();
                fVar.F(new d.AnonymousClass1(str));
                ByteBuffer wrap = ByteBuffer.wrap(fVar.AL());
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(Integer.valueOf(1903261812), wrap);
                if (linkedHashMap.isEmpty()) {
                    runtimeException = new RuntimeException("addIdValueByteBufferMap , id value pair is empty");
                    AppMethodBeat.o(2314);
                    throw runtimeException;
                }
                if (linkedHashMap.containsKey(Integer.valueOf(1896449818))) {
                    linkedHashMap.remove(Integer.valueOf(1896449818));
                }
                ab.i("MicroMsg.Channel.IdValueWriter", "addIdValueByteBufferMap , new IdValueMap = ".concat(String.valueOf(linkedHashMap)));
                Map E = i.E((ByteBuffer) Q.kLV.first);
                if (E.containsKey(Integer.valueOf(1896449818))) {
                    ab.i("MicroMsg.Channel.IdValueWriter", "addIdValueByteBufferMap , existed IdValueMap = ".concat(String.valueOf(E)));
                    E.putAll(linkedHashMap);
                    ab.i("MicroMsg.Channel.IdValueWriter", "addIdValueByteBufferMap , final IdValueMap = ".concat(String.valueOf(E)));
                    ByteBuffer G = i.G(E);
                    ab.i("MicroMsg.Channel.IdValueWriter", "addIdValueByteBufferMap , oldApkSigningBlock size = " + ((ByteBuffer) Q.kLV.first).remaining() + " , newApkSigningBlock size = " + G.remaining());
                    wrap = (ByteBuffer) Q.kLW.first;
                    ByteBuffer byteBuffer = (ByteBuffer) Q.kLX.first;
                    long longValue = ((Long) Q.kLW.second).longValue();
                    int remaining = G.remaining() - ((ByteBuffer) Q.kLV.first).remaining();
                    k.c(byteBuffer, ((long) remaining) + longValue);
                    long j = Q.kLT + ((long) remaining);
                    randomAccessFile = null;
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rw");
                        try {
                            if (Q.lowMemory) {
                                randomAccessFile3.seek(((Long) Q.kLV.second).longValue());
                            } else {
                                ByteBuffer byteBuffer2 = (ByteBuffer) Q.kLU.first;
                                randomAccessFile3.seek(((Long) Q.kLU.second).longValue());
                                randomAccessFile3.write(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), byteBuffer2.remaining());
                            }
                            randomAccessFile3.write(G.array(), G.arrayOffset() + G.position(), G.remaining());
                            randomAccessFile3.write(wrap.array(), wrap.arrayOffset() + wrap.position(), wrap.remaining());
                            randomAccessFile3.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                            if (randomAccessFile3.getFilePointer() != j) {
                                runtimeException = new RuntimeException("after addIdValueByteBufferMap , file size wrong , FilePointer : " + randomAccessFile3.getFilePointer() + ", apkLength : " + j);
                                AppMethodBeat.o(2314);
                                throw runtimeException;
                            }
                            randomAccessFile3.setLength(j);
                            ab.i("MicroMsg.Channel.IdValueWriter", "addIdValueByteBufferMap , after add channel , new apk is " + file.getAbsolutePath() + " , length = " + file.length());
                            k.c(byteBuffer, longValue);
                            randomAccessFile3.close();
                            AppMethodBeat.o(2314);
                            return true;
                        } catch (Throwable th8) {
                            th = th8;
                            randomAccessFile = randomAccessFile3;
                            k.c(byteBuffer, longValue);
                            if (randomAccessFile != null) {
                            }
                            AppMethodBeat.o(2314);
                            throw th;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        k.c(byteBuffer, longValue);
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        AppMethodBeat.o(2314);
                        throw th;
                    }
                }
                bVar = new b("No APK V2 Signature Scheme block in APK Signing Block");
                AppMethodBeat.o(2314);
                throw bVar;
            } catch (IOException e) {
                ab.e("MicroMsg.Channel.GameChannelUtil", "writeChannel, error2: %s", e.getMessage());
                AppMethodBeat.o(2314);
                return false;
            } catch (b bVar2) {
                ab.e("MicroMsg.Channel.GameChannelUtil", "writeChannel, error3: %s", bVar2.getMessage());
                AppMethodBeat.o(2314);
                return false;
            }
        } else {
            ab.i("MicroMsg.Channel.GameChannelUtil", "apk : " + file.getAbsolutePath() + ", not have precise channel package mode");
            AppMethodBeat.o(2314);
            return false;
        }
    }
}
