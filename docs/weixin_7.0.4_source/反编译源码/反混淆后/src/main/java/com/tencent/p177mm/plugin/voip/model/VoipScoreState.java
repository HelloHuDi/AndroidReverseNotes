package com.tencent.p177mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.voip.model.VoipScoreState */
public class VoipScoreState implements Parcelable {
    public static final Creator<VoipScoreState> CREATOR = new C140361();
    public int nwu = -1;
    public long nwv = -1;
    public long nxT = -1;
    public String sSM = "";
    public int sSN = -1;
    public long sSO = 0;

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipScoreState$1 */
    static class C140361 implements Creator<VoipScoreState> {
        C140361() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VoipScoreState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(4593);
            VoipScoreState voipScoreState = new VoipScoreState(parcel);
            AppMethodBeat.m2505o(4593);
            return voipScoreState;
        }
    }

    public VoipScoreState() {
        AppMethodBeat.m2504i(4594);
        C4990ab.m7409c("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
        AppMethodBeat.m2505o(4594);
    }

    protected VoipScoreState(Parcel parcel) {
        AppMethodBeat.m2504i(4595);
        this.sSM = parcel.readString();
        this.sSN = parcel.readInt();
        this.nwu = parcel.readInt();
        this.nwv = parcel.readLong();
        this.nxT = parcel.readLong();
        this.sSO = parcel.readLong();
        AppMethodBeat.m2505o(4595);
    }

    static {
        AppMethodBeat.m2504i(4600);
        AppMethodBeat.m2505o(4600);
    }

    /* renamed from: a */
    public final void mo69415a(String str, int i, int i2, long j) {
        AppMethodBeat.m2504i(4596);
        C4990ab.m7417i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i));
        this.nwu = i2;
        this.nwv = j;
        if (!C5046bo.isNullOrNil(str)) {
            try {
                C4990ab.m7409c("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new String(Base64.decode(str.getBytes(), 0)), Integer.valueOf(i));
                this.sSN = i;
                this.sSM = r0;
                AppMethodBeat.m2505o(4596);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoipScoreState", e, "setScoreState error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(4596);
    }

    public static void cJX() {
        AppMethodBeat.m2504i(4597);
        long aaa = C1829bf.aaa();
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOIP_LAST_SCORE_TIME_LONG, Long.valueOf(aaa));
        C4990ab.m7417i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", Long.valueOf(aaa));
        AppMethodBeat.m2505o(4597);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(4598);
        parcel.writeString(this.sSM);
        parcel.writeInt(this.sSN);
        parcel.writeInt(this.nwu);
        parcel.writeLong(this.nwv);
        parcel.writeLong(this.nxT);
        parcel.writeLong(this.sSO);
        AppMethodBeat.m2505o(4598);
    }

    public String toString() {
        AppMethodBeat.m2504i(4599);
        String str = "VoipScoreState{scoreTitle='" + this.sSM + '\'' + ", scoreIntervalDay=" + this.sSN + ", roomId=" + this.nwu + ", roomKey=" + this.nwv + ", startTalkTime=" + this.nxT + ", lastShowScoreTime=" + this.sSO + '}';
        AppMethodBeat.m2505o(4599);
        return str;
    }
}
