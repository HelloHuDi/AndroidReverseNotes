package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BM\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\b\u0010$\u001a\u00020%H\u0016J\u0013\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\t\u0010)\u001a\u00020%HÖ\u0001J\u0006\u0010*\u001a\u00020\u0006J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020%H\u0016R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0011\"\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00061"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mobile", "", "showMobile", "encryptedData", "iv", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getAllowSendSms", "()Z", "getEncryptedData", "()Ljava/lang/String;", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class PhoneItem implements Parcelable {
    public static final Creator<PhoneItem> CREATOR = new b();
    public static final a ixO = new a();
    final String biC;
    final String cFl;
    final String ixI;
    final String ixJ;
    final boolean ixK;
    final boolean ixL;
    boolean ixM;
    boolean ixN;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
    public final class b implements Creator<PhoneItem> {
        b() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134798);
            j.p(parcel, "source");
            PhoneItem phoneItem = new PhoneItem(parcel);
            AppMethodBeat.o(134798);
            return phoneItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PhoneItem[i];
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "TAG", "", "parseFromJson", "jsonStr", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static PhoneItem Ds(String str) {
            AppMethodBeat.i(134799);
            j.p(str, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("mobile");
                String optString2 = jSONObject.optString("show_mobile");
                boolean optBoolean = jSONObject.optBoolean("need_auth", true);
                boolean optBoolean2 = jSONObject.optBoolean("allow_send_sms", true);
                String optString3 = jSONObject.optString("encryptedData");
                String optString4 = jSONObject.optString("iv");
                boolean optBoolean3 = jSONObject.optBoolean("is_wechat", false);
                boolean optBoolean4 = jSONObject.optBoolean("is_check", false);
                j.o(optString, "mobile");
                j.o(optString2, "showMobile");
                j.o(optString3, "encryptedData");
                j.o(optString4, "iv");
                PhoneItem phoneItem = new PhoneItem(optString, optString2, optString3, optString4, optBoolean, optBoolean2, optBoolean3, optBoolean4);
                AppMethodBeat.o(134799);
                return phoneItem;
            } catch (JSONException e) {
                d.e("MicroMsg.PhoneItem", "jsonStr:%s", str);
                AppMethodBeat.o(134799);
                return null;
            }
        }
    }

    public final int hashCode() {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(134806);
        String str = this.cFl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        str = this.ixI;
        hashCode = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        str = this.ixJ;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.biC;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        i2 = (hashCode2 + i2) * 31;
        hashCode2 = this.ixK;
        if (hashCode2 != 0) {
            hashCode2 = 1;
        }
        i2 = (hashCode2 + i2) * 31;
        hashCode2 = this.ixL;
        if (hashCode2 != 0) {
            hashCode2 = 1;
        }
        i2 = (hashCode2 + i2) * 31;
        hashCode2 = this.ixM;
        if (hashCode2 != 0) {
            hashCode2 = 1;
        }
        i2 = (hashCode2 + i2) * 31;
        boolean z = this.ixN;
        if (!z) {
            boolean i3 = z;
        }
        hashCode2 = i2 + i3;
        AppMethodBeat.o(134806);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.i(134805);
        String str = "PhoneItem(mobile=" + this.cFl + ", showMobile=" + this.ixI + ", encryptedData=" + this.ixJ + ", iv=" + this.biC + ", needAuth=" + this.ixK + ", allowSendSms=" + this.ixL + ", isWechat=" + this.ixM + ", isCheck=" + this.ixN + ")";
        AppMethodBeat.o(134805);
        return str;
    }

    public PhoneItem(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        j.p(str, "mobile");
        j.p(str2, "showMobile");
        j.p(str3, "encryptedData");
        j.p(str4, "iv");
        AppMethodBeat.i(134802);
        this.cFl = str;
        this.ixI = str2;
        this.ixJ = str3;
        this.biC = str4;
        this.ixK = z;
        this.ixL = z2;
        this.ixM = z3;
        this.ixN = z4;
        AppMethodBeat.o(134802);
    }

    public /* synthetic */ PhoneItem(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, false, true, false, true);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(134800);
        if (!(obj instanceof PhoneItem)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(134800);
            return equals;
        } else if (j.j(((PhoneItem) obj).cFl, this.cFl) && ((PhoneItem) obj).ixM == this.ixM) {
            AppMethodBeat.o(134800);
            return true;
        } else {
            AppMethodBeat.o(134800);
            return false;
        }
    }

    public PhoneItem(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        j.p(parcel, "source");
        String readString = parcel.readString();
        j.o(readString, "source.readString()");
        String readString2 = parcel.readString();
        j.o(readString2, "source.readString()");
        String readString3 = parcel.readString();
        j.o(readString3, "source.readString()");
        String readString4 = parcel.readString();
        j.o(readString4, "source.readString()");
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        if (1 == parcel.readInt()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (1 == parcel.readInt()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (1 == parcel.readInt()) {
            z4 = true;
        }
        this(readString, readString2, readString3, readString4, z, z2, z3, z4);
        AppMethodBeat.i(134803);
        AppMethodBeat.o(134803);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(134801);
        j.p(parcel, "dest");
        parcel.writeString(this.cFl);
        parcel.writeString(this.ixI);
        parcel.writeString(this.ixJ);
        parcel.writeString(this.biC);
        if (this.ixK) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.ixL) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.ixM) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.ixN) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        AppMethodBeat.o(134801);
    }

    static {
        AppMethodBeat.i(134804);
        AppMethodBeat.o(134804);
    }
}
