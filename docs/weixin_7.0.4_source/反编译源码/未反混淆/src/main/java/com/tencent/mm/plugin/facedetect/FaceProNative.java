package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

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

    public static class FaceResult implements Parcelable {
        public static final Creator<FaceResult> CREATOR = new Creator<FaceResult>() {
            public final FaceResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(30);
                FaceResult faceResult = new FaceResult(parcel);
                AppMethodBeat.o(30);
                return faceResult;
            }

            public final FaceResult[] newArray(int i) {
                return new FaceResult[i];
            }
        };
        public byte[] data;
        public int result;
        public byte[] sidedata;

        protected FaceResult(Parcel parcel) {
            AppMethodBeat.i(33);
            this.result = parcel.readInt();
            this.data = parcel.createByteArray();
            this.sidedata = parcel.createByteArray();
            AppMethodBeat.o(33);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(34);
            parcel.writeInt(this.result);
            parcel.writeByteArray(this.data);
            parcel.writeByteArray(this.sidedata);
            AppMethodBeat.o(34);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(36);
            AppMethodBeat.o(36);
        }

        public String toString() {
            int i = 0;
            AppMethodBeat.i(35);
            StringBuilder append = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=").append(this.sidedata == null ? 0 : this.sidedata.length).append(", dataLen=");
            if (this.data != null) {
                i = this.data.length;
            }
            String stringBuilder = append.append(i).append('}').toString();
            AppMethodBeat.o(35);
            return stringBuilder;
        }
    }

    public static class FaceStatus implements Parcelable {
        public static final Creator<FaceStatus> CREATOR = new Creator<FaceStatus>() {
            public final FaceStatus createFromParcel(Parcel parcel) {
                AppMethodBeat.i(37);
                FaceStatus faceStatus = new FaceStatus(parcel);
                AppMethodBeat.o(37);
                return faceStatus;
            }

            public final FaceStatus[] newArray(int i) {
                return new FaceStatus[i];
            }
        };
        public Rect facerect;
        public float pitch;
        public int result;
        public float roll;
        public float[] xys;
        public float yaw;

        protected FaceStatus(Parcel parcel) {
            AppMethodBeat.i(40);
            this.result = parcel.readInt();
            this.facerect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.xys = parcel.createFloatArray();
            this.pitch = parcel.readFloat();
            this.yaw = parcel.readFloat();
            this.roll = parcel.readFloat();
            AppMethodBeat.o(40);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(41);
            parcel.writeInt(this.result);
            parcel.writeParcelable(this.facerect, i);
            parcel.writeFloatArray(this.xys);
            parcel.writeFloat(this.pitch);
            parcel.writeFloat(this.yaw);
            parcel.writeFloat(this.roll);
            AppMethodBeat.o(41);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(43);
            AppMethodBeat.o(43);
        }

        public String toString() {
            AppMethodBeat.i(42);
            String str = "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
            AppMethodBeat.o(42);
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
        AppMethodBeat.i(44);
        NativeConstructor();
        AppMethodBeat.o(44);
    }

    public void destroy() {
        AppMethodBeat.i(45);
        NativeDestructor();
        AppMethodBeat.o(45);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(46);
        super.finalize();
        NativeDestructor();
        AppMethodBeat.o(46);
    }

    static {
        AppMethodBeat.i(49);
        k.a("FacePro", FaceProNative.class.getClassLoader());
        k.a("wechatvoicereco", FaceProNative.class.getClassLoader());
        k.a("wechatxlog", FaceProNative.class.getClassLoader());
        nativeInit();
        AppMethodBeat.o(49);
    }

    public static int detectFaceCnt(String str) {
        return 0;
    }

    public static void checkInitDetectFace() {
        AppMethodBeat.i(47);
        synchronized (FaceProNative.class) {
            try {
                ab.c(TAG, "checkInitDetectFace, hasDetectInit: %s", Boolean.valueOf(hasDetectInit));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29);
                        if (!FaceProNative.hasDetectInit) {
                            if (FaceProNative.nativeFacedetectInitBin(e.e(p.bsP(), 0, -1)) == -1) {
                                ab.w(FaceProNative.TAG, "detectFaceCnt init failed: %s", p.bsP());
                                AppMethodBeat.o(29);
                                return;
                            }
                            ab.i(FaceProNative.TAG, "detectFaceCnt init:%d, %s", Integer.valueOf(FaceProNative.nativeFacedetectInitBin(e.e(p.bsP(), 0, -1))), p.bsP());
                            FaceProNative.hasDetectInit = true;
                        }
                        AppMethodBeat.o(29);
                    }
                });
            } finally {
                while (true) {
                }
                AppMethodBeat.o(47);
            }
        }
    }

    @Keep
    public static String[] getDynamicValue(String str) {
        AppMethodBeat.i(48);
        if (System.currentTimeMillis() - lastCheckTime >= TIMEOUT_CHECKER) {
            lastCheckTime = System.currentTimeMillis();
            String value = ((a) g.K(a.class)).Nu().getValue(str);
            if (!bo.isNullOrNil(value)) {
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
                    ab.printErrStackTrace(TAG, e, "hy: array resolve failed", new Object[0]);
                }
            }
        }
        String[] strArr = cachedStr;
        AppMethodBeat.o(48);
        return strArr;
    }
}
