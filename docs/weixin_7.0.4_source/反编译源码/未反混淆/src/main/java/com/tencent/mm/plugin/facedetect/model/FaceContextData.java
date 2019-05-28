package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import junit.framework.Assert;

public class FaceContextData implements Parcelable {
    public static final Creator<FaceContextData> CREATOR = new Creator<FaceContextData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceContextData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(FaceMoveUtil.TRIANGLE_COUNT);
            FaceContextData faceContextData = new FaceContextData(parcel);
            AppMethodBeat.o(FaceMoveUtil.TRIANGLE_COUNT);
            return faceContextData;
        }
    };
    private static volatile FaceContextData lTG = null;
    public long lTH = -1;

    static {
        AppMethodBeat.i(187);
        AppMethodBeat.o(187);
    }

    public static void a(FaceContextData faceContextData) {
        AppMethodBeat.i(183);
        if (faceContextData == null) {
            lTG = null;
            AppMethodBeat.o(183);
        } else if (lTG != null) {
            b(faceContextData);
            AppMethodBeat.o(183);
        } else {
            synchronized (FaceContextData.class) {
                try {
                    if (lTG != null) {
                        b(faceContextData);
                    } else {
                        lTG = faceContextData;
                        AppMethodBeat.o(183);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(183);
                }
            }
        }
    }

    private static void b(FaceContextData faceContextData) {
        AppMethodBeat.i(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE);
        boolean z = (lTG == null || faceContextData == null) ? false : true;
        Assert.assertTrue(z);
        lTG.lTH = faceContextData.lTH;
        AppMethodBeat.o(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE);
    }

    public static synchronized FaceContextData bss() {
        FaceContextData faceContextData;
        synchronized (FaceContextData.class) {
            faceContextData = lTG;
        }
        return faceContextData;
    }

    protected FaceContextData(Parcel parcel) {
        AppMethodBeat.i(185);
        this.lTH = parcel.readLong();
        AppMethodBeat.o(185);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(186);
        parcel.writeLong(this.lTH);
        AppMethodBeat.o(186);
    }
}
