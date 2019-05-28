package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.f;

public class RecordParam implements Parcelable {
    public static final Creator<RecordParam> CREATOR = new Creator<RecordParam>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecordParam[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105660);
            RecordParam recordParam = new RecordParam(parcel);
            AppMethodBeat.o(105660);
            return recordParam;
        }
    };
    public String appId = "";
    public int duration = 0;
    public String euD;
    public String hAQ;
    public int imk = 0;
    public int iml = 0;
    public double imm = 0.0d;
    public b imn = b.MIC;
    public f imo;
    public String processName = "";
    public int sampleRate = 0;
    public int scene = 0;

    public int describeContents() {
        return 0;
    }

    public RecordParam(Parcel parcel) {
        AppMethodBeat.i(105661);
        this.duration = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.imk = parcel.readInt();
        this.iml = parcel.readInt();
        this.hAQ = parcel.readString();
        this.euD = parcel.readString();
        this.scene = parcel.readInt();
        this.imm = parcel.readDouble();
        this.processName = parcel.readString();
        this.appId = parcel.readString();
        this.imn = b.values()[parcel.readInt()];
        AppMethodBeat.o(105661);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(105662);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.imk);
        parcel.writeInt(this.iml);
        parcel.writeString(this.hAQ);
        parcel.writeString(this.euD);
        parcel.writeInt(this.scene);
        parcel.writeDouble(this.imm);
        parcel.writeString(this.processName);
        parcel.writeString(this.appId);
        parcel.writeInt(this.imn.ordinal());
        AppMethodBeat.o(105662);
    }

    static {
        AppMethodBeat.i(105663);
        AppMethodBeat.o(105663);
    }
}
