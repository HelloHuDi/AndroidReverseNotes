package com.tencent.p177mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.facedetect.model.FaceContextData */
public class FaceContextData implements Parcelable {
    public static final Creator<FaceContextData> CREATOR = new C340951();
    private static volatile FaceContextData lTG = null;
    public long lTH = -1;

    /* renamed from: com.tencent.mm.plugin.facedetect.model.FaceContextData$1 */
    static class C340951 implements Creator<FaceContextData> {
        C340951() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceContextData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(FaceMoveUtil.TRIANGLE_COUNT);
            FaceContextData faceContextData = new FaceContextData(parcel);
            AppMethodBeat.m2505o(FaceMoveUtil.TRIANGLE_COUNT);
            return faceContextData;
        }
    }

    static {
        AppMethodBeat.m2504i(187);
        AppMethodBeat.m2505o(187);
    }

    /* renamed from: a */
    public static void m85187a(FaceContextData faceContextData) {
        AppMethodBeat.m2504i(183);
        if (faceContextData == null) {
            lTG = null;
            AppMethodBeat.m2505o(183);
        } else if (lTG != null) {
            FaceContextData.m85188b(faceContextData);
            AppMethodBeat.m2505o(183);
        } else {
            synchronized (FaceContextData.class) {
                try {
                    if (lTG != null) {
                        FaceContextData.m85188b(faceContextData);
                    } else {
                        lTG = faceContextData;
                        AppMethodBeat.m2505o(183);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(183);
                }
            }
        }
    }

    /* renamed from: b */
    private static void m85188b(FaceContextData faceContextData) {
        AppMethodBeat.m2504i(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE);
        boolean z = (lTG == null || faceContextData == null) ? false : true;
        Assert.assertTrue(z);
        lTG.lTH = faceContextData.lTH;
        AppMethodBeat.m2505o(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE);
    }

    public static synchronized FaceContextData bss() {
        FaceContextData faceContextData;
        synchronized (FaceContextData.class) {
            faceContextData = lTG;
        }
        return faceContextData;
    }

    protected FaceContextData(Parcel parcel) {
        AppMethodBeat.m2504i(185);
        this.lTH = parcel.readLong();
        AppMethodBeat.m2505o(185);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(186);
        parcel.writeLong(this.lTH);
        AppMethodBeat.m2505o(186);
    }
}
