package com.tencent.p177mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.SightCaptureResult */
public class SightCaptureResult implements Parcelable {
    public static final Creator<SightCaptureResult> CREATOR = new C212831();
    public boolean mog = false;
    public boolean osA = false;
    public boolean osB = true;
    public String osC = "";
    public String osD = "";
    public String osE = "";
    public String osF = "";
    public int osG = 0;
    public baa osH = new baa();
    public String osI = "";

    /* renamed from: com.tencent.mm.plugin.mmsight.SightCaptureResult$1 */
    static class C212831 implements Creator<SightCaptureResult> {
        C212831() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightCaptureResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(60271);
            SightCaptureResult sightCaptureResult = new SightCaptureResult(parcel);
            AppMethodBeat.m2505o(60271);
            return sightCaptureResult;
        }
    }

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i, baa baa) {
        AppMethodBeat.m2504i(60272);
        this.osB = z;
        this.osC = str;
        this.osD = str2;
        this.osE = str3;
        this.osG = i;
        this.osH = baa;
        this.osF = str4;
        this.mog = true;
        this.osA = false;
        AppMethodBeat.m2505o(60272);
    }

    public SightCaptureResult(boolean z, String str) {
        AppMethodBeat.m2504i(60273);
        this.osB = z;
        this.osI = str;
        this.mog = false;
        this.osA = true;
        AppMethodBeat.m2505o(60273);
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        AppMethodBeat.m2504i(60274);
        this.mog = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.osA = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.osB = z;
        this.osC = parcel.readString();
        this.osD = parcel.readString();
        this.osE = parcel.readString();
        this.osF = parcel.readString();
        this.osG = parcel.readInt();
        this.osI = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.osH = new baa();
            this.osH.parseFrom(bArr);
            AppMethodBeat.m2505o(60274);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SightCaptureResult", "read ext info error: %s", e.getMessage());
            AppMethodBeat.m2505o(60274);
        }
    }

    static {
        AppMethodBeat.m2504i(60276);
        AppMethodBeat.m2505o(60276);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(60275);
        parcel.writeByte((byte) (this.mog ? 1 : 0));
        if (this.osA) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.osB) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.osC);
        parcel.writeString(this.osD);
        parcel.writeString(this.osE);
        parcel.writeString(this.osF);
        parcel.writeInt(this.osG);
        parcel.writeString(this.osI);
        try {
            byte[] toByteArray = this.osH.toByteArray();
            parcel.writeInt(toByteArray.length);
            parcel.writeByteArray(toByteArray);
            AppMethodBeat.m2505o(60275);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SightCaptureResult", "write ext info error");
            AppMethodBeat.m2505o(60275);
        }
    }
}
