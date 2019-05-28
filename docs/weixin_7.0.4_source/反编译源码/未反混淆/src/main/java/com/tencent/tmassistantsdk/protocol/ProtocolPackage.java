package com.tencent.tmassistantsdk.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReqHead;
import com.tencent.tmassistantsdk.protocol.jce.Request;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import com.tencent.tmassistantsdk.protocol.jce.Terminal;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ProtocolPackage {
    static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    static final byte FLAG_CRYPT = (byte) 2;
    static final byte FLAG_ZIP = (byte) 1;
    public static final String ServerEncoding = "utf-8";
    private static final String TAG = "ProtocolPackage";
    static final int ZIP_TRIGGER = 256;

    public static JceStruct buildReportRequest(byte b, List<byte[]> list, String str, int i, String str2) {
        AppMethodBeat.i(76014);
        ReportLogRequest reportLogRequest = new ReportLogRequest();
        reportLogRequest.logType = b;
        reportLogRequest.logData = formatLogData(list);
        reportLogRequest.hostAppPackageName = str;
        reportLogRequest.hostAppVersion = i;
        reportLogRequest.hostUserId = str2;
        AppMethodBeat.o(76014);
        return reportLogRequest;
    }

    public static ReqHead getReqHead(JceStruct jceStruct) {
        AppMethodBeat.i(76015);
        if (jceStruct == null) {
            AppMethodBeat.o(76015);
            return null;
        }
        ReqHead reqHead = new ReqHead();
        reqHead.requestId = GlobalUtil.getMemUUID();
        String simpleName = jceStruct.getClass().getSimpleName();
        reqHead.cmdId = GlobalUtil.getInstance().getJceCmdIdByClassName(simpleName.substring(0, simpleName.length() - 7));
        reqHead.qua = GlobalUtil.getInstance().mQUA;
        reqHead.phoneGuid = GlobalUtil.getInstance().getPhoneGuid();
        reqHead.terminal = new Terminal();
        reqHead.assistantAPILevel = GlobalUtil.getInstance().getQQDownloaderAPILevel();
        reqHead.assistantVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        AppMethodBeat.o(76015);
        return reqHead;
    }

    public static Request buildRequest(JceStruct jceStruct) {
        AppMethodBeat.i(76016);
        if (jceStruct == null) {
            AppMethodBeat.o(76016);
            return null;
        }
        Request request = new Request();
        request.head = getReqHead(jceStruct);
        request.body = jceStructToUTF8Byte(jceStruct);
        AppMethodBeat.o(76016);
        return request;
    }

    public static byte[] buildPostData(Request request) {
        AppMethodBeat.i(76017);
        if (request == null) {
            AppMethodBeat.o(76017);
            return null;
        }
        request.head.encryptWithPack = (byte) 0;
        if (request.body.length > 256) {
            request.body = ZipUtils.zip(request.body);
            request.head.encryptWithPack = (byte) (request.head.encryptWithPack | 1);
        }
        request.body = encrypt(request.body, CRYPT_KEY.getBytes());
        request.head.encryptWithPack = (byte) (request.head.encryptWithPack | 2);
        byte[] jceStructToUTF8Byte = jceStructToUTF8Byte(request);
        AppMethodBeat.o(76017);
        return jceStructToUTF8Byte;
    }

    public static Response unpackPackage(byte[] bArr) {
        AppMethodBeat.i(76018);
        if (bArr == null || bArr.length < 4) {
            AppMethodBeat.o(76018);
            return null;
        }
        Response response = new Response();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            response.readFrom(jceInputStream);
            if (response.head.ret == 0) {
                if ((response.head.encryptWithPack & 2) == 2) {
                    response.body = decrypt(response.body, CRYPT_KEY.getBytes());
                }
                if ((response.head.encryptWithPack & 1) == 1) {
                    response.body = ZipUtils.unzip(response.body);
                }
                GlobalUtil.getInstance().setPhoneGuid(response.head.phoneGuid);
            }
            AppMethodBeat.o(76018);
            return response;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(76018);
            return null;
        }
    }

    public static JceStruct unpageageJceResponse(JceStruct jceStruct, byte[] bArr) {
        AppMethodBeat.i(76019);
        if (!(jceStruct == null || bArr == null)) {
            JceStruct createFromRequest = createFromRequest(jceStruct);
            if (createFromRequest != null) {
                try {
                    JceInputStream jceInputStream = new JceInputStream(bArr);
                    jceInputStream.setServerEncoding(ServerEncoding);
                    createFromRequest.readFrom(jceInputStream);
                    AppMethodBeat.o(76019);
                    return createFromRequest;
                } catch (Exception e) {
                    ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    AppMethodBeat.o(76019);
                    return null;
                }
            }
        }
        AppMethodBeat.o(76019);
        return null;
    }

    private static JceStruct createFromRequest(JceStruct jceStruct) {
        AppMethodBeat.i(76020);
        if (jceStruct == null) {
            AppMethodBeat.o(76020);
            return null;
        }
        JceStruct jceStruct2;
        String name = jceStruct.getClass().getName();
        try {
            jceStruct2 = (JceStruct) Class.forName(name.substring(0, name.length() - 7) + "Response").newInstance();
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            jceStruct2 = null;
        } catch (IllegalAccessException e2) {
            ab.printErrStackTrace(TAG, e2, "", new Object[0]);
            jceStruct2 = null;
        } catch (InstantiationException e3) {
            ab.printErrStackTrace(TAG, e3, "", new Object[0]);
            jceStruct2 = null;
        }
        AppMethodBeat.o(76020);
        return jceStruct2;
    }

    public static byte[] jceStructToUTF8Byte(JceStruct jceStruct) {
        AppMethodBeat.i(76021);
        if (jceStruct == null) {
            AppMethodBeat.o(76021);
            return null;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(ServerEncoding);
        jceStruct.writeTo(jceOutputStream);
        byte[] toByteArray = jceOutputStream.toByteArray();
        AppMethodBeat.o(76021);
        return toByteArray;
    }

    public static JceStruct bytes2JceObj(byte[] bArr, Class<? extends JceStruct> cls) {
        AppMethodBeat.i(76022);
        if (bArr == null) {
            AppMethodBeat.o(76022);
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            JceStruct jceStruct = (JceStruct) cls.newInstance();
            jceStruct.readFrom(jceInputStream);
            AppMethodBeat.o(76022);
            return jceStruct;
        } catch (Exception e) {
            AppMethodBeat.o(76022);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008d A:{SYNTHETIC, Splitter:B:39:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092 A:{SYNTHETIC, Splitter:B:42:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A:{SYNTHETIC, Splitter:B:15:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A:{SYNTHETIC, Splitter:B:18:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008d A:{SYNTHETIC, Splitter:B:39:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092 A:{SYNTHETIC, Splitter:B:42:0x0092} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] formatLogData(List<byte[]> list) {
        Throwable e;
        AppMethodBeat.i(76023);
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    for (byte[] bArr : list) {
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                    }
                    byte[] bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        ab.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                    try {
                        dataOutputStream.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace(TAG, e22, "", new Object[0]);
                    }
                    AppMethodBeat.o(76023);
                    return bArr2;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                dataOutputStream = null;
                try {
                    ab.printErrStackTrace(TAG, e, "", new Object[0]);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e5) {
                            ab.printErrStackTrace(TAG, e5, "", new Object[0]);
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e52) {
                            ab.printErrStackTrace(TAG, e52, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(76023);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (byteArrayOutputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    AppMethodBeat.o(76023);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataOutputStream = null;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e222) {
                        ab.printErrStackTrace(TAG, e222, "", new Object[0]);
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e2222) {
                        ab.printErrStackTrace(TAG, e2222, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(76023);
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            dataOutputStream = null;
            byteArrayOutputStream = null;
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            if (byteArrayOutputStream != null) {
            }
            if (dataOutputStream != null) {
            }
            AppMethodBeat.o(76023);
            return null;
        } catch (Throwable th3) {
            e = th3;
            dataOutputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (dataOutputStream != null) {
            }
            AppMethodBeat.o(76023);
            throw e;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(76024);
        byte[] encrypt = new Cryptor().encrypt(bArr, bArr2);
        AppMethodBeat.o(76024);
        return encrypt;
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(76025);
        byte[] decrypt = new Cryptor().decrypt(bArr, bArr2);
        AppMethodBeat.o(76025);
        return decrypt;
    }
}
