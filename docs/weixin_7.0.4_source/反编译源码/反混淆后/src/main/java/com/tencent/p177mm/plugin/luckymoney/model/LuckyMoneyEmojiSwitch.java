package com.tencent.p177mm.plugin.luckymoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch */
public class LuckyMoneyEmojiSwitch implements Parcelable {
    public static final Creator<LuckyMoneyEmojiSwitch> CREATOR = new C124241();
    public int nXp = 0;
    public int nXq = 0;
    public int nXr = 0;
    public int nXs = 0;

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch$1 */
    static class C124241 implements Creator<LuckyMoneyEmojiSwitch> {
        C124241() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LuckyMoneyEmojiSwitch[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(42294);
            LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch(parcel);
            AppMethodBeat.m2505o(42294);
            return luckyMoneyEmojiSwitch;
        }
    }

    /* renamed from: V */
    public static LuckyMoneyEmojiSwitch m20343V(JSONObject jSONObject) {
        AppMethodBeat.m2504i(42295);
        LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
        luckyMoneyEmojiSwitch.nXp = jSONObject.optInt("showOpenNormalExpression", 0);
        luckyMoneyEmojiSwitch.nXq = jSONObject.optInt("showDetailNormalExpression", 0);
        luckyMoneyEmojiSwitch.nXr = jSONObject.optInt("enableAnswerByExpression", 0);
        luckyMoneyEmojiSwitch.nXs = jSONObject.optInt("enableAnswerBySelfie", 0);
        AppMethodBeat.m2505o(42295);
        return luckyMoneyEmojiSwitch;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(42296);
        parcel.writeInt(this.nXp);
        parcel.writeInt(this.nXq);
        parcel.writeInt(this.nXr);
        parcel.writeInt(this.nXs);
        AppMethodBeat.m2505o(42296);
    }

    protected LuckyMoneyEmojiSwitch(Parcel parcel) {
        AppMethodBeat.m2504i(42297);
        this.nXp = parcel.readInt();
        this.nXq = parcel.readInt();
        this.nXr = parcel.readInt();
        this.nXs = parcel.readInt();
        AppMethodBeat.m2505o(42297);
    }

    static {
        AppMethodBeat.m2504i(42299);
        AppMethodBeat.m2505o(42299);
    }

    public String toString() {
        AppMethodBeat.m2504i(42298);
        String str = "LuckyMoneyEmojiSwitch{showOpenNormalExpression=" + this.nXp + ", showDetailNormalExpression=" + this.nXq + ", enalbeAnswerByExpression=" + this.nXr + ", enableAnswerBySelfie=" + this.nXs + '}';
        AppMethodBeat.m2505o(42298);
        return str;
    }
}
