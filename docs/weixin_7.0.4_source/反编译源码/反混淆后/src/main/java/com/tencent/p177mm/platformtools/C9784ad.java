package com.tencent.p177mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1171c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.tencent.mm.platformtools.ad */
public final class C9784ad {
    /* renamed from: a */
    public static boolean m17422a(final String str, final String str2, final boolean z, boolean z2, final int i) {
        AppMethodBeat.m2504i(72654);
        if (z2) {
            C7305d.m12298f(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(72653);
                    C9784ad.m17420a(str, str2, z, i);
                    AppMethodBeat.m2505o(72653);
                }
            }, "StackReportUploader_uploadFileDirect");
            AppMethodBeat.m2505o(72654);
            return true;
        }
        boolean a = C9784ad.m17420a(str, str2, z, i);
        AppMethodBeat.m2505o(72654);
        return a;
    }

    /* renamed from: a */
    public static boolean m17421a(String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(72655);
        boolean a = C9784ad.m17422a(str, str2, z, z2, 20003);
        AppMethodBeat.m2505o(72655);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x017a A:{SYNTHETIC, Splitter:B:49:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018a A:{SYNTHETIC, Splitter:B:55:0x018a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static boolean m17420a(String str, String str2, boolean z, int i) {
        Throwable e;
        AppMethodBeat.m2504i(72656);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.StackReportUploader", "uploadFile param err file:%s  user:%s", str, str2);
            AppMethodBeat.m2505o(72656);
            return false;
        }
        int cs = C1173e.m2560cs(str);
        byte[] f;
        if (cs <= 0) {
            C4990ab.m7413e("MicroMsg.StackReportUploader", "uploadFile err len file:%s len:%d", str, Integer.valueOf(cs));
            AppMethodBeat.m2505o(72656);
            return false;
        } else if (cs <= 128000) {
            f = C1173e.m2571f(str, 0, -1);
            boolean a = C9784ad.m17423a(f, str, str2, i);
            String str3 = "MicroMsg.StackReportUploader";
            String str4 = "uploadFile ret:%b size:%d file:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a);
            objArr[1] = Integer.valueOf(f != null ? f.length : -1);
            objArr[2] = str;
            C4990ab.m7411d(str3, str4, objArr);
            if (a && z) {
                C1173e.m2575t(new File(str));
            }
            AppMethodBeat.m2505o(72656);
            return a;
        } else {
            int i2 = (cs / 127988) + 1;
            byte[] bArr = new byte[128000];
            int anU = (int) C5046bo.anU();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                int i3 = 0;
                while (i3 < i2) {
                    try {
                        int read = fileInputStream.read(bArr, 12, 127988);
                        if (read < 0) {
                            C4990ab.m7413e("MicroMsg.StackReportUploader", "uploadFile read failed file:%s", str);
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                            AppMethodBeat.m2505o(72656);
                            return false;
                        }
                        boolean a2;
                        C9784ad.m17424d(anU, bArr, 0);
                        C9784ad.m17424d(i3, bArr, 4);
                        C9784ad.m17424d(read, bArr, 8);
                        if (read < 127988) {
                            f = new byte[(read + 12)];
                            System.arraycopy(bArr, 0, f, 0, f.length);
                            a2 = C9784ad.m17423a(f, str, str2, i);
                        } else {
                            a2 = C9784ad.m17423a(bArr, str, str2, i);
                        }
                        C4990ab.m7411d("MicroMsg.StackReportUploader", "uploadFile idx:%d(%d) read:%d ret:%b size:%d file:%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(read), Boolean.valueOf(a2), Integer.valueOf(cs), str);
                        i3++;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            C4990ab.m7413e("MicroMsg.StackReportUploader", "exception:%s", C5046bo.m7574l(e));
                            C4990ab.m7413e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            AppMethodBeat.m2505o(72656);
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            AppMethodBeat.m2505o(72656);
                            throw e;
                        }
                    }
                }
                if (z) {
                    C1173e.m2575t(new File(str));
                }
                try {
                    fileInputStream.close();
                } catch (Exception e6) {
                }
                AppMethodBeat.m2505o(72656);
                return true;
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
                C4990ab.m7413e("MicroMsg.StackReportUploader", "exception:%s", C5046bo.m7574l(e));
                C4990ab.m7413e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(72656);
                return false;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(72656);
                throw e;
            }
        }
    }

    /* renamed from: d */
    private static boolean m17424d(int i, byte[] bArr, int i2) {
        if (128000 < i2 + 4) {
            return false;
        }
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        return true;
    }

    /* renamed from: a */
    private static boolean m17423a(byte[] bArr, String str, String str2, int i) {
        AppMethodBeat.m2504i(72657);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7413e("MicroMsg.StackReportUploader", "read file failed:%s", str);
            AppMethodBeat.m2505o(72657);
            return false;
        } else if (bArr.length > 128000) {
            C4990ab.m7413e("MicroMsg.StackReportUploader", "file :%s data len error:%d", str, Integer.valueOf(bArr.length));
            AppMethodBeat.m2505o(72657);
            return false;
        } else {
            String toLowerCase = C1178g.m2591x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(C7243d.vxo), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
            byte[] compress = C1184r.compress(bArr);
            if (C5046bo.m7540cb(compress)) {
                C4990ab.m7413e("MicroMsg.StackReportUploader", "zip data failed file:%s", str);
                AppMethodBeat.m2505o(72657);
                return false;
            }
            PByteArray pByteArray = new PByteArray();
            C1171c.m2554a(pByteArray, compress, toLowerCase.getBytes());
            compress = pByteArray.value;
            if (C5046bo.m7540cb(compress)) {
                C4990ab.m7413e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", str);
            }
            String str3 = "http://" + C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str3 + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(C7243d.vxo));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(C7243d.eSg);
            stringBuffer.append("&filelength=");
            stringBuffer.append(r2);
            stringBuffer.append("&sum=");
            stringBuffer.append(toLowerCase);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(i);
            stringBuffer.append("&reportvalue=");
            stringBuffer.append(C5046bo.anU() + ".0.1");
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
                    C4990ab.m7412e("MicroMsg.StackReportUploader", "execute http failed resp null");
                    AppMethodBeat.m2505o(72657);
                    return false;
                } else if (execute.getStatusLine().getStatusCode() != 200) {
                    C4990ab.m7413e("MicroMsg.StackReportUploader", "error response code:%d ", Integer.valueOf(execute.getStatusLine().getStatusCode()));
                    AppMethodBeat.m2505o(72657);
                    return false;
                } else {
                    AppMethodBeat.m2505o(72657);
                    return true;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.StackReportUploader", "exception:%s", C5046bo.m7574l(e));
                C4990ab.m7411d("MicroMsg.StackReportUploader", "execute post failed msg:%s", e.getMessage());
                AppMethodBeat.m2505o(72657);
                return false;
            }
        }
    }
}
