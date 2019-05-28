package com.tencent.p177mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C26341k;

/* renamed from: com.tencent.mm.ipcinvoker.extension.XParcelableWrapper */
public class XParcelableWrapper implements Parcelable {
    public static final Creator<XParcelableWrapper> CREATOR = new C263351();
    public C42136f eGC;

    /* renamed from: com.tencent.mm.ipcinvoker.extension.XParcelableWrapper$1 */
    static class C263351 implements Creator<XParcelableWrapper> {
        C263351() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XParcelableWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114103);
            XParcelableWrapper xParcelableWrapper = new XParcelableWrapper();
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (xParcelableWrapper.eGC == null) {
                    xParcelableWrapper.eGC = (C42136f) C26341k.m41920c(readString, C42136f.class);
                }
                if (xParcelableWrapper.eGC != null) {
                    xParcelableWrapper.eGC.readFromParcel(parcel);
                }
            }
            AppMethodBeat.m2505o(114103);
            return xParcelableWrapper;
        }
    }

    /* synthetic */ XParcelableWrapper(byte b) {
        this();
    }

    private XParcelableWrapper() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114104);
        if (this.eGC != null) {
            parcel.writeInt(1);
            parcel.writeString(this.eGC.getClass().getName());
            this.eGC.mo5956e(parcel);
            AppMethodBeat.m2505o(114104);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(114104);
    }

    static {
        AppMethodBeat.m2504i(114105);
        AppMethodBeat.m2505o(114105);
    }
}
