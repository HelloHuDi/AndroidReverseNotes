package com.tencent.p177mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.cio;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel */
public class TransferRecordParcel implements Parcelable {
    public static final Creator<TransferRecordParcel> CREATOR = new C130241();
    public String nuL;
    public String pLH;
    public String pMd;
    public String pMe;
    public String pMf;
    public String pMg;
    public String pbn;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel$1 */
    static class C130241 implements Creator<TransferRecordParcel> {
        C130241() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TransferRecordParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(44508);
            TransferRecordParcel transferRecordParcel = new TransferRecordParcel(parcel);
            AppMethodBeat.m2505o(44508);
            return transferRecordParcel;
        }
    }

    private TransferRecordParcel(cio cio) {
        this.pMd = cio.pMd;
        this.pMe = cio.pMe;
        this.pLH = cio.pLH;
        this.nuL = cio.nuL;
        this.pbn = cio.pbn;
        this.pMf = cio.pMf;
        this.pMg = cio.pMg;
    }

    protected TransferRecordParcel(Parcel parcel) {
        AppMethodBeat.m2504i(44509);
        this.pMd = parcel.readString();
        this.pMe = parcel.readString();
        this.pLH = parcel.readString();
        this.nuL = parcel.readString();
        this.pbn = parcel.readString();
        this.pMf = parcel.readString();
        this.pMg = parcel.readString();
        AppMethodBeat.m2505o(44509);
    }

    static {
        AppMethodBeat.m2504i(44512);
        AppMethodBeat.m2505o(44512);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(44510);
        parcel.writeString(this.pMd);
        parcel.writeString(this.pMe);
        parcel.writeString(this.pLH);
        parcel.writeString(this.nuL);
        parcel.writeString(this.pbn);
        parcel.writeString(this.pMf);
        parcel.writeString(this.pMg);
        AppMethodBeat.m2505o(44510);
    }

    /* renamed from: cO */
    public static ArrayList<TransferRecordParcel> m86204cO(List<cio> list) {
        AppMethodBeat.m2504i(44511);
        if (list == null) {
            AppMethodBeat.m2505o(44511);
            return null;
        }
        ArrayList<TransferRecordParcel> arrayList = new ArrayList();
        for (cio transferRecordParcel : list) {
            arrayList.add(new TransferRecordParcel(transferRecordParcel));
        }
        AppMethodBeat.m2505o(44511);
        return arrayList;
    }
}
