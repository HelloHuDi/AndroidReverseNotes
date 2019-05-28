package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import org.json.JSONObject;

public interface ITenpaySave {

    public static class RetryPayInfo implements Parcelable {
        public static final Creator<RetryPayInfo> CREATOR = new Creator<RetryPayInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RetryPayInfo[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(49168);
                RetryPayInfo retryPayInfo = new RetryPayInfo(parcel);
                AppMethodBeat.o(49168);
                return retryPayInfo;
            }
        };
        public int Agu;
        public int Agv;
        public String Agw;

        public RetryPayInfo() {
            this.Agu = -1;
            this.Agv = -1;
            this.Agw = "";
        }

        protected RetryPayInfo(Parcel parcel) {
            AppMethodBeat.i(49169);
            this.Agu = parcel.readInt();
            this.Agv = parcel.readInt();
            this.Agw = parcel.readString();
            AppMethodBeat.o(49169);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(49170);
            parcel.writeInt(this.Agu);
            parcel.writeInt(this.Agv);
            parcel.writeString(this.Agw);
            AppMethodBeat.o(49170);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(49172);
            AppMethodBeat.o(49172);
        }

        public final boolean bVy() {
            if (this.Agu == -1 || this.Agv == -1) {
                return false;
            }
            return true;
        }

        public final void aA(JSONObject jSONObject) {
            AppMethodBeat.i(49171);
            if (jSONObject == null) {
                AppMethodBeat.o(49171);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("retry_pay_info");
            if (optJSONObject == null) {
                AppMethodBeat.o(49171);
                return;
            }
            this.Agu = optJSONObject.optInt(TbsConfigKey.KEY_RETRY_INTERVAL, -1);
            this.Agv = optJSONObject.optInt("max_retry_count", -1);
            this.Agw = optJSONObject.optString("retry_fail_wording", "");
            AppMethodBeat.o(49171);
        }
    }

    RetryPayInfo cMC();
}
