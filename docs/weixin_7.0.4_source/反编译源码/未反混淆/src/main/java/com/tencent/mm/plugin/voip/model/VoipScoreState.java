package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public class VoipScoreState implements Parcelable {
    public static final Creator<VoipScoreState> CREATOR = new Creator<VoipScoreState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VoipScoreState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(4593);
            VoipScoreState voipScoreState = new VoipScoreState(parcel);
            AppMethodBeat.o(4593);
            return voipScoreState;
        }
    };
    public int nwu = -1;
    public long nwv = -1;
    public long nxT = -1;
    public String sSM = "";
    public int sSN = -1;
    public long sSO = 0;

    public VoipScoreState() {
        AppMethodBeat.i(4594);
        ab.c("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
        AppMethodBeat.o(4594);
    }

    protected VoipScoreState(Parcel parcel) {
        AppMethodBeat.i(4595);
        this.sSM = parcel.readString();
        this.sSN = parcel.readInt();
        this.nwu = parcel.readInt();
        this.nwv = parcel.readLong();
        this.nxT = parcel.readLong();
        this.sSO = parcel.readLong();
        AppMethodBeat.o(4595);
    }

    static {
        AppMethodBeat.i(4600);
        AppMethodBeat.o(4600);
    }

    public final void a(String str, int i, int i2, long j) {
        AppMethodBeat.i(4596);
        ab.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i));
        this.nwu = i2;
        this.nwv = j;
        if (!bo.isNullOrNil(str)) {
            try {
                ab.c("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new String(Base64.decode(str.getBytes(), 0)), Integer.valueOf(i));
                this.sSN = i;
                this.sSM = r0;
                AppMethodBeat.o(4596);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoipScoreState", e, "setScoreState error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(4596);
    }

    public static void cJX() {
        AppMethodBeat.i(4597);
        long aaa = bf.aaa();
        g.RQ();
        g.RP().Ry().set(a.USERINFO_VOIP_LAST_SCORE_TIME_LONG, Long.valueOf(aaa));
        ab.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", Long.valueOf(aaa));
        AppMethodBeat.o(4597);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(4598);
        parcel.writeString(this.sSM);
        parcel.writeInt(this.sSN);
        parcel.writeInt(this.nwu);
        parcel.writeLong(this.nwv);
        parcel.writeLong(this.nxT);
        parcel.writeLong(this.sSO);
        AppMethodBeat.o(4598);
    }

    public String toString() {
        AppMethodBeat.i(4599);
        String str = "VoipScoreState{scoreTitle='" + this.sSM + '\'' + ", scoreIntervalDay=" + this.sSN + ", roomId=" + this.nwu + ", roomKey=" + this.nwv + ", startTalkTime=" + this.nxT + ", lastShowScoreTime=" + this.sSO + '}';
        AppMethodBeat.o(4599);
        return str;
    }
}
