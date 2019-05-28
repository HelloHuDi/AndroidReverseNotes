package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class ad {
    public static boolean a(final String str, final String str2, final boolean z, boolean z2, final int i) {
        AppMethodBeat.i(72654);
        if (z2) {
            d.f(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(72653);
                    ad.a(str, str2, z, i);
                    AppMethodBeat.o(72653);
                }
            }, "StackReportUploader_uploadFileDirect");
            AppMethodBeat.o(72654);
            return true;
        }
        boolean a = a(str, str2, z, i);
        AppMethodBeat.o(72654);
        return a;
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(72655);
        boolean a = a(str, str2, z, z2, 20003);
        AppMethodBeat.o(72655);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x017a A:{SYNTHETIC, Splitter:B:49:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018a A:{SYNTHETIC, Splitter:B:55:0x018a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(String str, String str2, boolean z, int i) {
        Throwable e;
        AppMethodBeat.i(72656);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.StackReportUploader", "uploadFile param err file:%s  user:%s", str, str2);
            AppMethodBeat.o(72656);
            return false;
        }
        int cs = e.cs(str);
        byte[] f;
        if (cs <= 0) {
            ab.e("MicroMsg.StackReportUploader", "uploadFile err len file:%s len:%d", str, Integer.valueOf(cs));
            AppMethodBeat.o(72656);
            return false;
        } else if (cs <= 128000) {
            f = e.f(str, 0, -1);
            boolean a = a(f, str, str2, i);
            String str3 = "MicroMsg.StackReportUploader";
            String str4 = "uploadFile ret:%b size:%d file:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a);
            objArr[1] = Integer.valueOf(f != null ? f.length : -1);
            objArr[2] = str;
            ab.d(str3, str4, objArr);
            if (a && z) {
                e.t(new File(str));
            }
            AppMethodBeat.o(72656);
            return a;
        } else {
            int i2 = (cs / 127988) + 1;
            byte[] bArr = new byte[128000];
            int anU = (int) bo.anU();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                int i3 = 0;
                while (i3 < i2) {
                    try {
                        int read = fileInputStream.read(bArr, 12, 127988);
                        if (read < 0) {
                            ab.e("MicroMsg.StackReportUploader", "uploadFile read failed file:%s", str);
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                            AppMethodBeat.o(72656);
                            return false;
                        }
                        boolean a2;
                        d(anU, bArr, 0);
                        d(i3, bArr, 4);
                        d(read, bArr, 8);
                        if (read < 127988) {
                            f = new byte[(read + 12)];
                            System.arraycopy(bArr, 0, f, 0, f.length);
                            a2 = a(f, str, str2, i);
                        } else {
                            a2 = a(bArr, str, str2, i);
                        }
                        ab.d("MicroMsg.StackReportUploader", "uploadFile idx:%d(%d) read:%d ret:%b size:%d file:%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(read), Boolean.valueOf(a2), Integer.valueOf(cs), str);
                        i3++;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            ab.e("MicroMsg.StackReportUploader", "exception:%s", bo.l(e));
                            ab.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            AppMethodBeat.o(72656);
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            AppMethodBeat.o(72656);
                            throw e;
                        }
                    }
                }
                if (z) {
                    e.t(new File(str));
                }
                try {
                    fileInputStream.close();
                } catch (Exception e6) {
                }
                AppMethodBeat.o(72656);
                return true;
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
                ab.e("MicroMsg.StackReportUploader", "exception:%s", bo.l(e));
                ab.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(72656);
                return false;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(72656);
                throw e;
            }
        }
    }

    private static boolean d(int i, byte[] bArr, int i2) {
        if (128000 < i2 + 4) {
            return false;
        }
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        return true;
    }

    private static boolean a(byte[] bArr, String str, String str2, int i) {
        AppMethodBeat.i(72657);
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.StackReportUploader", "read file failed:%s", str);
            AppMethodBeat.o(72657);
            return false;
        } else if (bArr.length > 128000) {
            ab.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", str, Integer.valueOf(bArr.length));
            AppMethodBeat.o(72657);
            return false;
        } else {
            String toLowerCase = g.x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vxo), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
            byte[] compress = r.compress(bArr);
            if (bo.cb(compress)) {
                ab.e("MicroMsg.StackReportUploader", "zip data failed file:%s", str);
                AppMethodBeat.o(72657);
                return false;
            }
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, compress, toLowerCase.getBytes());
            compress = pByteArray.value;
            if (bo.cb(compress)) {
                ab.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", str);
            }
            String str3 = "http://" + ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str3 + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(com.tencent.mm.protocal.d.vxo));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(com.tencent.mm.protocal.d.eSg);
            stringBuffer.append("&filelength=");
            stringBuffer.append(r2);
            stringBuffer.append("&sum=");
            stringBuffer.append(toLowerCase);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(i);
            stringBuffer.append("&reportvalue=");
            stringBuffer.append(bo.anU() + ".0.1");
            if (!(str2 == null || str2.equals(""))) {
                stringBuffer.append("&username=");
                stringBuffer.append(str2);
            }
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(stringBuffer.toString());
            try {
                ByteArrayEntity byteArrayEntity = new ByteArrayEntity(compress);
                byteArrayEntity.setContentType("binary/octet-stream");
                httpPost.setEntity(byteArrayEntity);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute == null || execute.getStatusLine() == null) {
                    ab.e("MicroMsg.StackReportUploader", "execute http failed resp null");
                    AppMethodBeat.o(72657);
                    return false;
                } else if (execute.getStatusLine().getStatusCode() != 200) {
                    ab.e("MicroMsg.StackReportUploader", "error response code:%d ", Integer.valueOf(execute.getStatusLine().getStatusCode()));
                    AppMethodBeat.o(72657);
                    return false;
                } else {
                    AppMethodBeat.o(72657);
                    return true;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.StackReportUploader", "exception:%s", bo.l(e));
                ab.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", e.getMessage());
                AppMethodBeat.o(72657);
                return false;
            }
        }
    }
}
