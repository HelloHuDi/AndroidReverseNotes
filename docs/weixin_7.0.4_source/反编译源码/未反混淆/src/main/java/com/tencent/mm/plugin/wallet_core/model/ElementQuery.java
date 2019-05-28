package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElementQuery implements Parcelable {
    public static final Creator<ElementQuery> CREATOR = new Creator<ElementQuery>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElementQuery[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46751);
            ElementQuery elementQuery = new ElementQuery(parcel);
            AppMethodBeat.o(46751);
            return elementQuery;
        }
    };
    public static String tyu = "bind_serial";
    public JSONObject fvc;
    public String nuL;
    public String pbn;
    public String pbo;
    public int tuo;
    public String twk;
    public String tyA;
    public String tyB;
    public boolean tyC;
    public int tyD;
    public int tyE;
    public String tyF;
    public String tyG;
    public String tyH;
    public String tyI;
    public String tyJ;
    public String tyK;
    public boolean tyL;
    public boolean tyM;
    public boolean tyN;
    public boolean tyO;
    public boolean tyP;
    public boolean tyQ;
    public boolean tyR;
    public boolean tyS;
    public boolean tyT;
    public String tyU;
    private List<Integer> tyV = null;
    public boolean tyW;
    public String tyX;
    public int tyY;
    public ArrayList<CreTypeRuleInfo> tyZ;
    public String tyv;
    public boolean tyw;
    public boolean tyx;
    public boolean tyy;
    public boolean tyz;
    public boolean tza = false;

    static {
        AppMethodBeat.i(46757);
        AppMethodBeat.o(46757);
    }

    public final boolean isError() {
        AppMethodBeat.i(46752);
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(bo.bc(this.tyG, "").trim());
        AppMethodBeat.o(46752);
        return equals;
    }

    public final boolean cPe() {
        return 2 == this.tyE;
    }

    public final boolean cPr() {
        return 1 == this.tyE;
    }

    public final List<Integer> cPs() {
        AppMethodBeat.i(46753);
        if (this.tyV != null) {
            List list = this.tyV;
            AppMethodBeat.o(46753);
            return list;
        } else if (bo.isNullOrNil(this.tyU)) {
            AppMethodBeat.o(46753);
            return null;
        } else {
            this.tyV = new ArrayList();
            for (String str : this.tyU.split("\\|")) {
                int i = bo.getInt(str, 0);
                if (i > 0) {
                    this.tyV.add(Integer.valueOf(i));
                }
            }
            List<Integer> list2 = this.tyV;
            AppMethodBeat.o(46753);
            return list2;
        }
    }

    public static ArrayList<CreTypeRuleInfo> ax(JSONObject jSONObject) {
        AppMethodBeat.i(46754);
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("cre_rule_array");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    CreTypeRuleInfo av = CreTypeRuleInfo.av(optJSONArray.optJSONObject(i));
                    if (av != null) {
                        arrayList.add(av);
                    }
                }
            }
        }
        AppMethodBeat.o(46754);
        return arrayList;
    }

    public ElementQuery(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(46755);
        this.pbo = parcel.readString();
        this.nuL = parcel.readString();
        this.tyv = parcel.readString();
        this.tyw = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyx = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyy = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyz = z;
        this.tyB = parcel.readString();
        this.pbo = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyC = z;
        this.tyD = parcel.readInt();
        this.tyE = parcel.readInt();
        this.pbn = parcel.readString();
        this.tyF = parcel.readString();
        this.tyG = parcel.readString();
        this.tyH = parcel.readString();
        this.tyK = parcel.readString();
        this.tyJ = parcel.readString();
        this.tyI = parcel.readString();
        this.tyL = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyM = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyN = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyO = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyP = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyQ = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyS = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyR = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tyT = z;
        this.tuo = parcel.readInt();
        this.tyU = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.tza = z;
        this.twk = parcel.readString();
        if (1 != parcel.readInt()) {
            z2 = false;
        }
        this.tyW = z2;
        this.tyX = parcel.readString();
        this.tyY = parcel.readInt();
        this.tyZ = parcel.readArrayList(CreTypeRuleInfo.class.getClassLoader());
        AppMethodBeat.o(46755);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(46756);
        parcel.writeString(bo.bc(this.pbo, ""));
        parcel.writeString(bo.bc(this.nuL, ""));
        parcel.writeString(bo.bc(this.tyv, ""));
        parcel.writeInt(this.tyw ? 1 : 0);
        if (this.tyx) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyy) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyz) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(bo.bc(this.tyB, ""));
        parcel.writeString(bo.bc(this.pbo, ""));
        if (this.tyC) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.tyD);
        parcel.writeInt(this.tyE);
        parcel.writeString(bo.bc(this.pbn, ""));
        parcel.writeString(bo.bc(this.tyF, ""));
        parcel.writeString(bo.bc(this.tyG, ""));
        parcel.writeString(bo.bc(this.tyH, ""));
        parcel.writeString(bo.bc(this.tyK, ""));
        parcel.writeString(bo.bc(this.tyJ, ""));
        parcel.writeString(bo.bc(this.tyI, ""));
        parcel.writeInt(this.tyL ? 1 : 0);
        if (this.tyM) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyO) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyP) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyQ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyS) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyR) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.tyT) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.tuo);
        parcel.writeString(this.tyU);
        if (this.tza) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.twk);
        if (!this.tyW) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.tyX);
        parcel.writeInt(this.tyY);
        parcel.writeList(this.tyZ);
        AppMethodBeat.o(46756);
    }
}
