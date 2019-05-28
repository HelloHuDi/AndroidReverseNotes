package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayUSecurityQuestion implements Parcelable {
    public static final Creator<PayUSecurityQuestion> CREATOR = new Creator<PayUSecurityQuestion>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayUSecurityQuestion[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(48574);
            PayUSecurityQuestion payUSecurityQuestion = new PayUSecurityQuestion(parcel);
            AppMethodBeat.o(48574);
            return payUSecurityQuestion;
        }
    };
    public String desc;
    public String id;

    public PayUSecurityQuestion(String str, String str2) {
        this.id = str;
        this.desc = str2;
    }

    public PayUSecurityQuestion(Parcel parcel) {
        AppMethodBeat.i(48575);
        this.id = parcel.readString();
        this.desc = parcel.readString();
        AppMethodBeat.o(48575);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(48576);
        parcel.writeString(this.id);
        parcel.writeString(this.desc);
        AppMethodBeat.o(48576);
    }

    static {
        AppMethodBeat.i(48577);
        AppMethodBeat.o(48577);
    }
}
