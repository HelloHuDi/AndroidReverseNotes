package com.tencent.p177mm.plugin.wallet_payu.security_question.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion */
public class PayUSecurityQuestion implements Parcelable {
    public static final Creator<PayUSecurityQuestion> CREATOR = new C297041();
    public String desc;
    /* renamed from: id */
    public String f13718id;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion$1 */
    static class C297041 implements Creator<PayUSecurityQuestion> {
        C297041() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayUSecurityQuestion[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(48574);
            PayUSecurityQuestion payUSecurityQuestion = new PayUSecurityQuestion(parcel);
            AppMethodBeat.m2505o(48574);
            return payUSecurityQuestion;
        }
    }

    public PayUSecurityQuestion(String str, String str2) {
        this.f13718id = str;
        this.desc = str2;
    }

    public PayUSecurityQuestion(Parcel parcel) {
        AppMethodBeat.m2504i(48575);
        this.f13718id = parcel.readString();
        this.desc = parcel.readString();
        AppMethodBeat.m2505o(48575);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(48576);
        parcel.writeString(this.f13718id);
        parcel.writeString(this.desc);
        AppMethodBeat.m2505o(48576);
    }

    static {
        AppMethodBeat.m2504i(48577);
        AppMethodBeat.m2505o(48577);
    }
}
