package com.tencent.tmassistantsdk.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class IPCPackageTools {
    protected static final String CHILD_NAME = ".jce.";
    static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    private static final String TAG = "IPCPackageTools";
    protected static int mReqId = 0;

    public static int getCmdId(JceStruct jceStruct) {
        AppMethodBeat.i(75971);
        if (jceStruct == null) {
            AppMethodBeat.o(75971);
            return -1;
        }
        String simpleName = jceStruct.getClass().getSimpleName();
        int value = IPCCmd.convert(simpleName.substring(0, simpleName.length() - 7)).value();
        AppMethodBeat.o(75971);
        return value;
    }

    public static IPCRequest buildIpcRequest(JceStruct jceStruct) {
        AppMethodBeat.i(75972);
        if (jceStruct == null) {
            AppMethodBeat.o(75972);
            return null;
        }
        IPCRequest iPCRequest = new IPCRequest();
        IPCHead iPCHead = new IPCHead();
        int i = mReqId;
        mReqId = i + 1;
        iPCHead.requestId = i;
        iPCHead.cmdId = getCmdId(jceStruct);
        iPCHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        iPCHead.hostVersionCode = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
        iPCRequest.head = iPCHead;
        iPCRequest.body = jceStruct2ByteArray(jceStruct);
        AppMethodBeat.o(75972);
        return iPCRequest;
    }

    public static byte[] buildPostData(IPCRequest iPCRequest) {
        AppMethodBeat.i(75973);
        if (iPCRequest == null) {
            AppMethodBeat.o(75973);
            return null;
        }
        iPCRequest.body = ProtocolPackage.encrypt(iPCRequest.body, CRYPT_KEY.getBytes());
        byte[] jceStruct2ByteArray = jceStruct2ByteArray(iPCRequest);
        AppMethodBeat.o(75973);
        return jceStruct2ByteArray;
    }

    public static IPCResponse unpackPackage(byte[] bArr) {
        AppMethodBeat.i(75974);
        if (bArr == null || bArr.length < 4) {
            AppMethodBeat.o(75974);
            return null;
        }
        IPCResponse iPCResponse = new IPCResponse();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ProtocolPackage.ServerEncoding);
            iPCResponse.readFrom(jceInputStream);
            if (!TextUtils.isEmpty(iPCResponse.head.hostPackageName)) {
                iPCResponse.body = ProtocolPackage.decrypt(iPCResponse.body, CRYPT_KEY.getBytes());
            }
            AppMethodBeat.o(75974);
            return iPCResponse;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(75974);
            return null;
        }
    }

    public static JceStruct unpackBodyStruct(IPCResponse iPCResponse) {
        AppMethodBeat.i(75975);
        JceStruct createFromRequest = createFromRequest(IPCCmd.convert(iPCResponse.head.cmdId).toString());
        if (createFromRequest == null || iPCResponse.body.length <= 0) {
            AppMethodBeat.o(75975);
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(iPCResponse.body);
            jceInputStream.setServerEncoding(ProtocolPackage.ServerEncoding);
            createFromRequest.readFrom(jceInputStream);
            AppMethodBeat.o(75975);
            return createFromRequest;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(75975);
            return null;
        }
    }

    private static JceStruct createFromRequest(String str) {
        AppMethodBeat.i(75976);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75976);
            return null;
        }
        JceStruct jceStruct;
        try {
            jceStruct = (JceStruct) Class.forName((IPCPackageTools.class.getPackage().getName() + CHILD_NAME + str) + "Response").newInstance();
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            jceStruct = null;
        } catch (IllegalAccessException e2) {
            ab.printErrStackTrace(TAG, e2, "", new Object[0]);
            jceStruct = null;
        } catch (InstantiationException e3) {
            ab.printErrStackTrace(TAG, e3, "", new Object[0]);
            jceStruct = null;
        }
        AppMethodBeat.o(75976);
        return jceStruct;
    }

    public static byte[] jceStruct2ByteArray(JceStruct jceStruct) {
        AppMethodBeat.i(75977);
        byte[] jceStructToUTF8Byte = ProtocolPackage.jceStructToUTF8Byte(jceStruct);
        AppMethodBeat.o(75977);
        return jceStructToUTF8Byte;
    }
}
