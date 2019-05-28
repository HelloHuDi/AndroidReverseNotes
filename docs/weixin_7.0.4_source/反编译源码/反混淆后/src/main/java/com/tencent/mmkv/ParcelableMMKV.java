package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class ParcelableMMKV implements Parcelable {
    public static final Creator<ParcelableMMKV> CREATOR = new C57621();
    String AiR;
    int AiS;
    int AiT;
    String AiU;

    /* renamed from: com.tencent.mmkv.ParcelableMMKV$1 */
    static class C57621 implements Creator<ParcelableMMKV> {
        C57621() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableMMKV[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(124052);
            String readString = parcel.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                AppMethodBeat.m2505o(124052);
                return null;
            }
            ParcelableMMKV parcelableMMKV = new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, (byte) 0);
            AppMethodBeat.m2505o(124052);
            return parcelableMMKV;
        }
    }

    /* synthetic */ ParcelableMMKV(String str, int i, int i2, String str2, byte b) {
        this(str, i, i2, str2);
    }

    public ParcelableMMKV(MMKV mmkv) {
        AppMethodBeat.m2504i(124053);
        this.AiS = -1;
        this.AiT = -1;
        this.AiU = null;
        this.AiR = mmkv.mmapID();
        this.AiS = mmkv.ashmemFD();
        this.AiT = mmkv.ashmemMetaFD();
        this.AiU = mmkv.cryptKey();
        AppMethodBeat.m2505o(124053);
    }

    private ParcelableMMKV(String str, int i, int i2, String str2) {
        this.AiS = -1;
        this.AiT = -1;
        this.AiU = null;
        this.AiR = str;
        this.AiS = i;
        this.AiT = i2;
        this.AiU = str2;
    }

    public final int describeContents() {
        return 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(124054);
        try {
            parcel.writeString(this.AiR);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.AiS);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.AiT);
            int i2 = i | 1;
            fromFd.writeToParcel(parcel, i2);
            fromFd2.writeToParcel(parcel, i2);
            if (this.AiU != null) {
                parcel.writeString(this.AiU);
            }
            AppMethodBeat.m2505o(124054);
        } catch (IOException e) {
            AppMethodBeat.m2505o(124054);
        }
    }

    static {
        AppMethodBeat.m2504i(124055);
        AppMethodBeat.m2505o(124055);
    }
}
