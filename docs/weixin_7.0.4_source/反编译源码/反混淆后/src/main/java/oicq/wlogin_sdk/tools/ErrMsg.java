package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ErrMsg implements Parcelable, Cloneable {
    public static final Creator<ErrMsg> CREATOR = new C61151();
    public String BVZ;
    public String message;
    public String title;
    private int type;

    /* renamed from: oicq.wlogin_sdk.tools.ErrMsg$1 */
    class C61151 implements Creator<ErrMsg> {
        C61151() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(96552);
            ErrMsg errMsg = new ErrMsg(parcel, (byte) 0);
            AppMethodBeat.m2505o(96552);
            return errMsg;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ErrMsg[i];
        }
    }

    public ErrMsg() {
        this.type = 0;
        this.title = "";
        this.message = "";
        this.BVZ = "";
    }

    public final void emK() {
        this.type = 0;
        this.title = "";
        this.message = "";
        this.BVZ = "";
    }

    public Object clone() {
        AppMethodBeat.m2504i(96554);
        Object clone = super.clone();
        AppMethodBeat.m2505o(96554);
        return clone;
    }

    private ErrMsg(Parcel parcel) {
        AppMethodBeat.m2504i(96555);
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.BVZ = parcel.readString();
        AppMethodBeat.m2505o(96555);
    }

    /* synthetic */ ErrMsg(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(96556);
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.BVZ);
        AppMethodBeat.m2505o(96556);
    }

    static {
        AppMethodBeat.m2504i(96553);
        AppMethodBeat.m2505o(96553);
    }
}
