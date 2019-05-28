package com.tencent.p177mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.facedetect.FaceProNative */
public class FaceProNative {
    public static final int ROTFLIPHOR = 3;
    public static final int ROTFLIPLEFT = 4;
    public static final int ROTFLIPRIGHT = 5;
    public static final int ROTLEFT = 1;
    public static final int ROTRIGHT = 2;
    public static final int ROTSTABLE = 0;
    private static final String TAG = "MicroMsg.FaceProNative";
    private static final long TIMEOUT_CHECKER = 3600000;
    private static String[] cachedStr = null;
    public static volatile boolean hasDetectInit = false;
    private static long lastCheckTime = -1;
    private long nativePtr;

    /* renamed from: com.tencent.mm.plugin.facedetect.FaceProNative$1 */
    static class C206191 implements Runnable {
        C206191() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29);
            if (!FaceProNative.hasDetectInit) {
                if (FaceProNative.nativeFacedetectInitBin(C5730e.m8632e(C43036p.bsP(), 0, -1)) == -1) {
                    C4990ab.m7421w(FaceProNative.TAG, "detectFaceCnt init failed: %s", C43036p.bsP());
                    AppMethodBeat.m2505o(29);
                    return;
                }
                C4990ab.m7417i(FaceProNative.TAG, "detectFaceCnt init:%d, %s", Integer.valueOf(FaceProNative.nativeFacedetectInitBin(C5730e.m8632e(C43036p.bsP(), 0, -1))), C43036p.bsP());
                FaceProNative.hasDetectInit = true;
            }
            AppMethodBeat.m2505o(29);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.FaceProNative$FaceResult */
    public static class FaceResult implements Parcelable {
        public static final Creator<FaceResult> CREATOR = new C206181();
        public byte[] data;
        public int result;
        public byte[] sidedata;

        /* renamed from: com.tencent.mm.plugin.facedetect.FaceProNative$FaceResult$1 */
        static class C206181 implements Creator<FaceResult> {
            C206181() {
            }

            public final FaceResult createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(30);
                FaceResult faceResult = new FaceResult(parcel);
                AppMethodBeat.m2505o(30);
                return faceResult;
            }

            public final FaceResult[] newArray(int i) {
                return new FaceResult[i];
            }
        }

        protected FaceResult(Parcel parcel) {
            AppMethodBeat.m2504i(33);
            this.result = parcel.readInt();
            this.data = parcel.createByteArray();
            this.sidedata = parcel.createByteArray();
            AppMethodBeat.m2505o(33);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(34);
            parcel.writeInt(this.result);
            parcel.writeByteArray(this.data);
            parcel.writeByteArray(this.sidedata);
            AppMethodBeat.m2505o(34);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.m2504i(36);
            AppMethodBeat.m2505o(36);
        }

        public String toString() {
            int i = 0;
            AppMethodBeat.m2504i(35);
            StringBuilder append = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=").append(this.sidedata == null ? 0 : this.sidedata.length).append(", dataLen=");
            if (this.data != null) {
                i = this.data.length;
            }
            String stringBuilder = append.append(i).append('}').toString();
            AppMethodBeat.m2505o(35);
            return stringBuilder;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.FaceProNative$FaceStatus */
    public static class FaceStatus implements Parcelable {
        public static final Creator<FaceStatus> CREATOR = new C206201();
        public Rect facerect;
        public float pitch;
        public int result;
        public float roll;
        public float[] xys;
        public float yaw;

        /* renamed from: com.tencent.mm.plugin.facedetect.FaceProNative$FaceStatus$1 */
        static class C206201 implements Creator<FaceStatus> {
            C206201() {
            }

            public final FaceStatus createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(37);
                FaceStatus faceStatus = new FaceStatus(parcel);
                AppMethodBeat.m2505o(37);
                return faceStatus;
            }

            public final FaceStatus[] newArray(int i) {
                return new FaceStatus[i];
            }
        }

        protected FaceStatus(Parcel parcel) {
            AppMethodBeat.m2504i(40);
            this.result = parcel.readInt();
            this.facerect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.xys = parcel.createFloatArray();
            this.pitch = parcel.readFloat();
            this.yaw = parcel.readFloat();
            this.roll = parcel.readFloat();
            AppMethodBeat.m2505o(40);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(41);
            parcel.writeInt(this.result);
            parcel.writeParcelable(this.facerect, i);
            parcel.writeFloatArray(this.xys);
            parcel.writeFloat(this.pitch);
            parcel.writeFloat(this.yaw);
            parcel.writeFloat(this.roll);
            AppMethodBeat.m2505o(41);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.m2504i(43);
            AppMethodBeat.m2505o(43);
        }

        public String toString() {
            AppMethodBeat.m2504i(42);
            String str = "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
            AppMethodBeat.m2505o(42);
            return str;
        }
    }

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static native int engineVersion();

    public static native int nativeFacedetectInitBin(byte[] bArr);

    public static native void nativeFacedetectRelease();

    public static native int nativeFacedetectWithBitmap(Object obj);

    public static native boolean nativeInit();

    public native FaceStatus engineFaceProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int[] engineGetAllMotions();

    public native int engineGetCurrMotion();

    public native String engineGetCurrMotionData();

    public native int engineGroupChange();

    public native int engineInit(String str, byte[] bArr, String str2, String str3);

    public native int engineNextMotion();

    public native int engineRelease();

    public native int engineReleaseCurrMotion();

    public native FaceResult engineReleaseOut();

    public native int engineSetVoiceData(byte[] bArr);

    public native int engineStartRecord();

    public FaceProNative() {
        AppMethodBeat.m2504i(44);
        NativeConstructor();
        AppMethodBeat.m2505o(44);
    }

    public void destroy() {
        AppMethodBeat.m2504i(45);
        NativeDestructor();
        AppMethodBeat.m2505o(45);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(46);
        super.finalize();
        NativeDestructor();
        AppMethodBeat.m2505o(46);
    }

    static {
        AppMethodBeat.m2504i(49);
        C1449k.m3079a("FacePro", FaceProNative.class.getClassLoader());
        C1449k.m3079a("wechatvoicereco", FaceProNative.class.getClassLoader());
        C1449k.m3079a("wechatxlog", FaceProNative.class.getClassLoader());
        FaceProNative.nativeInit();
        AppMethodBeat.m2505o(49);
    }

    public static int detectFaceCnt(String str) {
        return 0;
    }

    public static void checkInitDetectFace() {
        AppMethodBeat.m2504i(47);
        synchronized (FaceProNative.class) {
            try {
                C4990ab.m7409c(TAG, "checkInitDetectFace, hasDetectInit: %s", Boolean.valueOf(hasDetectInit));
                C5004al.m7441d(new C206191());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(47);
            }
        }
    }

    @Keep
    public static String[] getDynamicValue(String str) {
        AppMethodBeat.m2504i(48);
        if (System.currentTimeMillis() - lastCheckTime >= TIMEOUT_CHECKER) {
            lastCheckTime = System.currentTimeMillis();
            String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue(str);
            if (!C5046bo.isNullOrNil(value)) {
                try {
                    JSONArray jSONArray = new JSONArray(value);
                    ArrayList arrayList = new ArrayList(5);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    cachedStr = new String[length];
                    arrayList.toArray(cachedStr);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace(TAG, e, "hy: array resolve failed", new Object[0]);
                }
            }
        }
        String[] strArr = cachedStr;
        AppMethodBeat.m2505o(48);
        return strArr;
    }
}
