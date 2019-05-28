package com.tencent.p177mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.ITenpaySave */
public interface ITenpaySave {

    /* renamed from: com.tencent.mm.wallet_core.tenpay.model.ITenpaySave$RetryPayInfo */
    public static class RetryPayInfo implements Parcelable {
        public static final Creator<RetryPayInfo> CREATOR = new C241601();
        public int Agu;
        public int Agv;
        public String Agw;

        /* renamed from: com.tencent.mm.wallet_core.tenpay.model.ITenpaySave$RetryPayInfo$1 */
        static class C241601 implements Creator<RetryPayInfo> {
            C241601() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RetryPayInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(49168);
                RetryPayInfo retryPayInfo = new RetryPayInfo(parcel);
                AppMethodBeat.m2505o(49168);
                return retryPayInfo;
            }
        }

        public RetryPayInfo() {
            this.Agu = -1;
            this.Agv = -1;
            this.Agw = "";
        }

        protected RetryPayInfo(Parcel parcel) {
            AppMethodBeat.m2504i(49169);
            this.Agu = parcel.readInt();
            this.Agv = parcel.readInt();
            this.Agw = parcel.readString();
            AppMethodBeat.m2505o(49169);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(49170);
            parcel.writeInt(this.Agu);
            parcel.writeInt(this.Agv);
            parcel.writeString(this.Agw);
            AppMethodBeat.m2505o(49170);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.m2504i(49172);
            AppMethodBeat.m2505o(49172);
        }

        public final boolean bVy() {
            if (this.Agu == -1 || this.Agv == -1) {
                return false;
            }
            return true;
        }

        /* renamed from: aA */
        public final void mo39956aA(JSONObject jSONObject) {
            AppMethodBeat.m2504i(49171);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(49171);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("retry_pay_info");
            if (optJSONObject == null) {
                AppMethodBeat.m2505o(49171);
                return;
            }
            this.Agu = optJSONObject.optInt(TbsConfigKey.KEY_RETRY_INTERVAL, -1);
            this.Agv = optJSONObject.optInt("max_retry_count", -1);
            this.Agw = optJSONObject.optString("retry_fail_wording", "");
            AppMethodBeat.m2505o(49171);
        }
    }

    RetryPayInfo cMC();
}
