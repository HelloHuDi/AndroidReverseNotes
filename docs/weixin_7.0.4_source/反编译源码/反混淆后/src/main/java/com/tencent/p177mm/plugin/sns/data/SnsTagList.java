package com.tencent.p177mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.data.SnsTagList */
public class SnsTagList implements Parcelable {
    public static final Creator<SnsTagList> CREATOR = new C218801();
    private int qFV = 0;
    private List<Long> qFW = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.sns.data.SnsTagList$1 */
    static class C218801 implements Creator<SnsTagList> {
        C218801() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsTagList[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(35800);
            SnsTagList snsTagList = new SnsTagList();
            snsTagList.qFV = parcel.readInt();
            for (int i = 0; i < snsTagList.qFV; i++) {
                snsTagList.qFW.add(Long.valueOf(parcel.readLong()));
            }
            AppMethodBeat.m2505o(35800);
            return snsTagList;
        }
    }

    public SnsTagList() {
        AppMethodBeat.m2504i(35801);
        AppMethodBeat.m2505o(35801);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(35802);
        this.qFV = this.qFW.size();
        parcel.writeInt(this.qFV);
        for (Long longValue : this.qFW) {
            parcel.writeLong(longValue.longValue());
        }
        AppMethodBeat.m2505o(35802);
    }

    static {
        AppMethodBeat.m2504i(35803);
        AppMethodBeat.m2505o(35803);
    }
}
