package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.yq;
import java.util.ArrayList;
import java.util.Iterator;

public class BankcardElemParcel implements Parcelable {
    public static final Creator<BankcardElemParcel> CREATOR = new Creator<BankcardElemParcel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BankcardElemParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44491);
            BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(parcel);
            AppMethodBeat.o(44491);
            return bankcardElemParcel;
        }
    };
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

    public BankcardElemParcel(hd hdVar) {
        AppMethodBeat.i(44492);
        this.pbn = hdVar.pbn;
        this.nuL = hdVar.nuL;
        this.pLH = hdVar.pLH;
        this.pLI = hdVar.pLI;
        this.pLJ = hdVar.pLJ;
        this.pLK = hdVar.pLK;
        this.pLL = hdVar.pLL;
        this.pLM = hdVar.pLM;
        this.pLN = new ArrayList();
        Iterator it = hdVar.vJM.iterator();
        while (it.hasNext()) {
            this.pLN.add(new EnterTimeParcel((yq) it.next()));
        }
        this.pLO = hdVar.vJO;
        this.pLP = hdVar.pLP;
        AppMethodBeat.o(44492);
    }

    public BankcardElemParcel(Parcel parcel) {
        AppMethodBeat.i(44493);
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
        AppMethodBeat.o(44493);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(44494);
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
        AppMethodBeat.o(44494);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(44495);
        AppMethodBeat.o(44495);
    }
}
