package com.tencent.p177mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C23396hd;
import com.tencent.p177mm.protocal.protobuf.C44196yq;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel */
public class BankcardElemParcel implements Parcelable {
    public static final Creator<BankcardElemParcel> CREATOR = new C130231();
    public String nuL;
    public String pLH;
    public int pLI;
    public int pLJ;
    public String pLK;
    public String pLL;
    public String pLM;
    public ArrayList<EnterTimeParcel> pLN;
    public String pLO;
    public long pLP;
    public String pbn;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel$1 */
    static class C130231 implements Creator<BankcardElemParcel> {
        C130231() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BankcardElemParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(44491);
            BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(parcel);
            AppMethodBeat.m2505o(44491);
            return bankcardElemParcel;
        }
    }

    public BankcardElemParcel(C23396hd c23396hd) {
        AppMethodBeat.m2504i(44492);
        this.pbn = c23396hd.pbn;
        this.nuL = c23396hd.nuL;
        this.pLH = c23396hd.pLH;
        this.pLI = c23396hd.pLI;
        this.pLJ = c23396hd.pLJ;
        this.pLK = c23396hd.pLK;
        this.pLL = c23396hd.pLL;
        this.pLM = c23396hd.pLM;
        this.pLN = new ArrayList();
        Iterator it = c23396hd.vJM.iterator();
        while (it.hasNext()) {
            this.pLN.add(new EnterTimeParcel((C44196yq) it.next()));
        }
        this.pLO = c23396hd.vJO;
        this.pLP = c23396hd.pLP;
        AppMethodBeat.m2505o(44492);
    }

    public BankcardElemParcel(Parcel parcel) {
        AppMethodBeat.m2504i(44493);
        this.pbn = parcel.readString();
        this.nuL = parcel.readString();
        this.pLH = parcel.readString();
        this.pLI = parcel.readInt();
        this.pLJ = parcel.readInt();
        this.pLN = new ArrayList();
        parcel.readTypedList(this.pLN, EnterTimeParcel.CREATOR);
        this.pLK = parcel.readString();
        this.pLL = parcel.readString();
        this.pLM = parcel.readString();
        this.pLO = parcel.readString();
        this.pLP = parcel.readLong();
        AppMethodBeat.m2505o(44493);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(44494);
        parcel.writeString(this.pbn);
        parcel.writeString(this.nuL);
        parcel.writeString(this.pLH);
        parcel.writeInt(this.pLI);
        parcel.writeInt(this.pLJ);
        parcel.writeTypedList(this.pLN);
        parcel.writeString(this.pLK);
        parcel.writeString(this.pLL);
        parcel.writeString(this.pLM);
        parcel.writeString(this.pLO);
        parcel.writeLong(this.pLP);
        AppMethodBeat.m2505o(44494);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(44495);
        AppMethodBeat.m2505o(44495);
    }
}
