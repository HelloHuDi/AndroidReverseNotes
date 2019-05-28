package com.tencent.qbar;

import android.graphics.Bitmap;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class QbarNative {
    public byte[] Aqt = new byte[100];
    public int[] Aqu = new int[4];
    public byte[] Aqv = new byte[300];
    public int[] Aqw = new int[2];
    public int Aqx = -1;
    public byte[] data = new byte[AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS];
    public byte[] type = new byte[100];

    public static class QBarCodeDetectInfo {
        public float prob;
        public int readerId;
    }

    public static class QBarResultJNI {
        public String charset;
        public byte[] data;
        public int typeID;
        public String typeName;
    }

    public static class QbarAiModelParam {
        public String detect_model_bin_path_;
        public String detect_model_param_path_;
        public String superresolution_model_bin_path_;
        public String superresolution_model_param_path_;
    }

    public static class QBarPoint {
        public int point_cnt;
        public float x0;
        public float x1;
        public float x2;
        public float x3;
        public float y0;
        public float y1;
        public float y2;
        public float y3;
    }

    public static class QBarReportMsg {
        public String binaryMethod;
        public String charsetMode;
        public float decodeScale;
        public int detectTime;
        public String ecLevel;
        public boolean inBlackList;
        public boolean inWhiteList;
        public int pyramidLv;
        public int qrcodeVersion;
        public String scaleList;
        public int srTime;
    }

    public static class QBarResult {
        public String charset;
        public String data;
        public byte[] rawData;
        public int typeID;
        public String typeName;
    }

    public static class QBarZoomInfo {
        public boolean isZoom;
        public float zoomFactor;
    }

    private static native int Encode(byte[] bArr, int[] iArr, String str, int i, int i2, String str2, int i3);

    private static native int EncodeBitmap(String str, Bitmap bitmap, int i, int i2, int i3, int i4, String str2, int i5);

    public static native int FocusInit(int i, int i2, boolean z, int i3, int i4);

    public static native boolean FocusPro(byte[] bArr, boolean z, boolean[] zArr);

    public static native int FocusRelease();

    private native int GetCodeDetectInfo(QBarCodeDetectInfo[] qBarCodeDetectInfoArr, QBarPoint[] qBarPointArr, int i);

    private native int GetDetailResults(QBarResultJNI[] qBarResultJNIArr, QBarPoint[] qBarPointArr, QBarReportMsg[] qBarReportMsgArr, int i);

    private native int GetDetectInfoByFrames(QBarCodeDetectInfo qBarCodeDetectInfo, QBarPoint qBarPoint, int i);

    private native int GetOneResult(byte[] bArr, byte[] bArr2, byte[] bArr3, int[] iArr, int i);

    private native int GetOneResultReport(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int[] iArr, int[] iArr2, int i);

    private native int GetResults(QBarResultJNI[] qBarResultJNIArr, int i);

    private static native String GetVersion();

    private native int Init(int i, int i2, String str, String str2);

    private native int Init(int i, int i2, String str, String str2, QbarAiModelParam qbarAiModelParam);

    public static native int QIPUtilYUVCrop(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    private native int Release(int i);

    private native int ScanImage(byte[] bArr, int i, int i2, int i3, int i4);

    private native int SetReaders(int[] iArr, int i, int i2);

    public static native int focusedEngineForBankcardInit(int i, int i2, int i3, boolean z);

    public static native int focusedEngineGetVersion();

    public static native int focusedEngineProcess(byte[] bArr);

    public static native int focusedEngineRelease();

    private static native int nativeArrayConvert(int i, int i2, byte[] bArr, int[] iArr);

    private static native int nativeCropGray2(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    private static native int nativeGrayRotateCropSub(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int[] iArr, int i7, int i8);

    public static native int nativeRelease();

    private static native int nativeTransBytes(int[] iArr, byte[] bArr, int i, int i2);

    private static native int nativeTransPixels(int[] iArr, byte[] bArr, int i, int i2);

    private static native int nativeYUVrotate(byte[] bArr, byte[] bArr2, int i, int i2);

    private static native int nativeYUVrotateLess(byte[] bArr, int i, int i2);

    private static native int nativeYuvToCropIntArray(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native int AddBlackInternal(int i, int i2);

    public native int AddBlackList(String str, int i);

    public native int AddWhiteList(String str, int i);

    public native int GetZoomInfo(QBarZoomInfo qBarZoomInfo, int i);

    public native int SetCenterCoordinate(int i, int i2, int i3, int i4, int i5);

    public QbarNative() {
        AppMethodBeat.i(56461);
        AppMethodBeat.o(56461);
    }

    static {
        AppMethodBeat.i(56476);
        System.loadLibrary("wechatQrMod");
        AppMethodBeat.o(56476);
    }

    public static String getVersion() {
        AppMethodBeat.i(56462);
        String GetVersion = GetVersion();
        AppMethodBeat.o(56462);
        return GetVersion;
    }

    public static int a(byte[] bArr, int[] iArr, String str, int i, int i2, String str2) {
        AppMethodBeat.i(56463);
        int Encode = Encode(bArr, iArr, str, i, i2, str2, -1);
        AppMethodBeat.o(56463);
        return Encode;
    }

    public final int a(int i, String str, String str2, QbarAiModelParam qbarAiModelParam) {
        AppMethodBeat.i(56464);
        if (this.Aqx < 0) {
            if (qbarAiModelParam != null) {
                this.Aqx = Init(1, i, str, str2, qbarAiModelParam);
            } else {
                this.Aqx = Init(1, i, str, str2);
            }
        }
        if (this.Aqx < 0) {
            AppMethodBeat.o(56464);
            return -1;
        }
        AppMethodBeat.o(56464);
        return 0;
    }

    public final int i(int[] iArr, int i) {
        AppMethodBeat.i(56465);
        int SetReaders = SetReaders(iArr, i, this.Aqx);
        AppMethodBeat.o(56465);
        return SetReaders;
    }

    public final int z(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(56466);
        ScanImage(bArr, i, i2, 0, this.Aqx);
        if (dPR().size() > 0) {
            AppMethodBeat.o(56466);
            return 0;
        }
        AppMethodBeat.o(56466);
        return -1;
    }

    public final int release() {
        AppMethodBeat.i(56467);
        int Release = Release(this.Aqx);
        this.Aqx = -1;
        AppMethodBeat.o(56467);
        return Release;
    }

    public final List<QBarResult> dPR() {
        int i = 0;
        AppMethodBeat.i(56468);
        QBarResultJNI[] qBarResultJNIArr = new QBarResultJNI[3];
        for (int i2 = 0; i2 < 3; i2++) {
            qBarResultJNIArr[i2] = new QBarResultJNI();
            qBarResultJNIArr[i2].charset = new String();
            qBarResultJNIArr[i2].data = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            qBarResultJNIArr[i2].typeName = new String();
        }
        GetResults(qBarResultJNIArr, this.Aqx);
        ArrayList arrayList = new ArrayList();
        while (i < 3) {
            try {
                QBarResultJNI qBarResultJNI = qBarResultJNIArr[i];
                if (!isNullOrNil(qBarResultJNI.typeName)) {
                    QBarResult qBarResult = new QBarResult();
                    qBarResult.charset = qBarResultJNI.charset;
                    qBarResult.typeID = qBarResultJNI.typeID;
                    qBarResult.typeName = qBarResultJNI.typeName;
                    qBarResult.rawData = qBarResultJNI.data;
                    if (qBarResult.charset.equals("ANY")) {
                        qBarResult.data = new String(qBarResultJNI.data, "UTF-8");
                        if (qBarResult.data.length() == 0) {
                            qBarResult.data = new String(qBarResultJNI.data, "ASCII");
                        }
                    } else {
                        qBarResult.data = new String(qBarResultJNI.data, qBarResult.charset);
                    }
                    arrayList.add(qBarResult);
                }
                i++;
            } catch (UnsupportedEncodingException e) {
                new StringBuilder("GetResults exp:").append(e.getMessage());
            }
        }
        AppMethodBeat.o(56468);
        return arrayList;
    }

    public final int s(List<QBarResult> list, List<QBarReportMsg> list2) {
        int i;
        AppMethodBeat.i(56469);
        QBarResultJNI[] qBarResultJNIArr = new QBarResultJNI[3];
        QBarPoint[] qBarPointArr = new QBarPoint[3];
        QBarReportMsg[] qBarReportMsgArr = new QBarReportMsg[3];
        for (i = 0; i < 3; i++) {
            qBarResultJNIArr[i] = new QBarResultJNI();
            qBarResultJNIArr[i].charset = new String();
            qBarResultJNIArr[i].data = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            qBarResultJNIArr[i].typeName = new String();
            qBarPointArr[i] = new QBarPoint();
            qBarReportMsgArr[i] = new QBarReportMsg();
            qBarReportMsgArr[i].binaryMethod = new String();
            qBarReportMsgArr[i].charsetMode = new String();
            qBarReportMsgArr[i].ecLevel = new String();
            qBarReportMsgArr[i].scaleList = new String();
        }
        list.clear();
        list2.clear();
        GetDetailResults(qBarResultJNIArr, qBarPointArr, qBarReportMsgArr, this.Aqx);
        i = 0;
        while (i < 3) {
            try {
                QBarResultJNI qBarResultJNI = qBarResultJNIArr[i];
                if (!isNullOrNil(qBarResultJNI.typeName)) {
                    QBarResult qBarResult = new QBarResult();
                    qBarResult.charset = qBarResultJNI.charset;
                    qBarResult.typeID = qBarResultJNI.typeID;
                    qBarResult.typeName = qBarResultJNI.typeName;
                    qBarResult.rawData = qBarResultJNI.data;
                    if (qBarResult.charset.equals("ANY")) {
                        qBarResult.data = new String(qBarResultJNI.data, "UTF-8");
                        if (qBarResult.data.length() == 0) {
                            qBarResult.data = new String(qBarResultJNI.data, "ASCII");
                        }
                    } else {
                        qBarResult.data = new String(qBarResultJNI.data, qBarResult.charset);
                    }
                    list.add(qBarResult);
                }
                i++;
            } catch (UnsupportedEncodingException e) {
                new StringBuilder("GetResults exp:").append(e.getMessage());
            }
        }
        for (i = 0; i < 3; i++) {
            QBarReportMsg qBarReportMsg = qBarReportMsgArr[i];
            if (!isNullOrNil(qBarReportMsg.charsetMode)) {
                list2.add(qBarReportMsg);
            }
        }
        i = list.size();
        AppMethodBeat.o(56469);
        return i;
    }

    public final int t(List<QBarCodeDetectInfo> list, List<QBarPoint> list2) {
        int i = 0;
        AppMethodBeat.i(56470);
        if (this.Aqx < 0) {
            AppMethodBeat.o(56470);
            return 0;
        }
        int i2;
        QBarCodeDetectInfo[] qBarCodeDetectInfoArr = new QBarCodeDetectInfo[3];
        QBarPoint[] qBarPointArr = new QBarPoint[3];
        for (i2 = 0; i2 < 3; i2++) {
            qBarCodeDetectInfoArr[i2] = new QBarCodeDetectInfo();
            qBarPointArr[i2] = new QBarPoint();
        }
        list.clear();
        list2.clear();
        GetCodeDetectInfo(qBarCodeDetectInfoArr, qBarPointArr, this.Aqx);
        for (i2 = 0; i2 < 3; i2++) {
            QBarCodeDetectInfo qBarCodeDetectInfo = qBarCodeDetectInfoArr[i2];
            if (qBarCodeDetectInfo.readerId > 0) {
                list.add(qBarCodeDetectInfo);
            }
        }
        while (i < 3) {
            QBarPoint qBarPoint = qBarPointArr[i];
            if (qBarPoint.point_cnt != 0) {
                list2.add(qBarPoint);
            }
            i++;
        }
        i = list.size();
        AppMethodBeat.o(56470);
        return i;
    }

    public static int a(byte[] bArr, int[] iArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(56471);
        if (bArr == null || bArr2 == null) {
            AppMethodBeat.o(56471);
            return -1;
        }
        int nativeGrayRotateCropSub = nativeGrayRotateCropSub(bArr2, i, i2, i3, i4, i5, i6, bArr, iArr, i7, 0);
        AppMethodBeat.o(56471);
        return nativeGrayRotateCropSub;
    }

    public static int a(byte[] bArr, byte[] bArr2, int i, int i2) {
        AppMethodBeat.i(56472);
        if (bArr2 == null) {
            AppMethodBeat.o(56472);
            return -1;
        }
        int nativeYUVrotate = nativeYUVrotate(bArr, bArr2, i, i2);
        AppMethodBeat.o(56472);
        return nativeYUVrotate;
    }

    public static int b(byte[] bArr, byte[] bArr2, int i, int i2) {
        AppMethodBeat.i(56473);
        if (bArr == null || bArr2 == null) {
            AppMethodBeat.o(56473);
            return -1;
        }
        int nativeCropGray2 = nativeCropGray2(bArr, bArr2, i, i2, 0);
        AppMethodBeat.o(56473);
        return nativeCropGray2;
    }

    public static int a(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(56474);
        if (bArr == null) {
            AppMethodBeat.o(56474);
            return -1;
        }
        int nativeYuvToCropIntArray = nativeYuvToCropIntArray(bArr, iArr, i, i2, i3, i4, i5, i6);
        AppMethodBeat.o(56474);
        return nativeYuvToCropIntArray;
    }

    private static boolean isNullOrNil(String str) {
        AppMethodBeat.i(56475);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(56475);
            return true;
        }
        AppMethodBeat.o(56475);
        return false;
    }
}
