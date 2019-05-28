package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.sdk.platformtools.ab;

public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new Creator<GeneralControlWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralControlWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79964);
            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(parcel, (byte) 0);
            AppMethodBeat.o(79964);
            return generalControlWrapper;
        }
    };
    public static final GeneralControlWrapper vxE = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper vxF = new GeneralControlWrapper(1);
    private static Boolean vxH = null;
    public int vxG;

    /* synthetic */ GeneralControlWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(79976);
        AppMethodBeat.o(79976);
    }

    public GeneralControlWrapper(adl adl) {
        AppMethodBeat.i(79965);
        if (adl == null) {
            this.vxG = 0;
        } else {
            this.vxG = adl.wli;
        }
        ab.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
        AppMethodBeat.o(79965);
    }

    public GeneralControlWrapper(int i) {
        AppMethodBeat.i(79966);
        this.vxG = i;
        ab.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
        AppMethodBeat.o(79966);
    }

    public final boolean dmj() {
        AppMethodBeat.i(79967);
        boolean z = (this.vxG & 262144) != 0;
        if (vxH == null) {
            boolean z2;
            if (1 == ((a) g.K(a.class)).a(a.a.clicfg_webview_can_call_jsapi_before_loaded, 0)) {
                z2 = true;
            } else {
                z2 = false;
            }
            vxH = Boolean.valueOf(z2);
        }
        ab.d("MicroMsg.GeneralControlWrapper", "canCallJsApiBeforeLoad, ret = %b, canCallJsApiBeforeLoaded = %b", Boolean.valueOf(z), vxH);
        if (z || vxH.booleanValue()) {
            AppMethodBeat.o(79967);
            return true;
        }
        AppMethodBeat.o(79967);
        return false;
    }

    public final boolean dmk() {
        AppMethodBeat.i(79968);
        boolean z = (this.vxG & 2) > 0;
        ab.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(79968);
        return z;
    }

    public final boolean dml() {
        AppMethodBeat.i(79969);
        boolean z = (this.vxG & 64) > 0;
        ab.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(79969);
        return z;
    }

    public final boolean dmm() {
        AppMethodBeat.i(79970);
        boolean z = (this.vxG & 2048) > 0;
        ab.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(79970);
        return z;
    }

    public final boolean dmn() {
        AppMethodBeat.i(79971);
        boolean z = (this.vxG & 16384) > 0;
        ab.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(79971);
        return z;
    }

    public final boolean dmo() {
        AppMethodBeat.i(79972);
        boolean z = (this.vxG & 32768) > 0;
        ab.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(79972);
        return z;
    }

    public String toString() {
        AppMethodBeat.i(79973);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.vxG));
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(79973);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(79974);
        parcel.writeInt(this.vxG);
        AppMethodBeat.o(79974);
    }

    private GeneralControlWrapper(Parcel parcel) {
        AppMethodBeat.i(79975);
        this.vxG = parcel.readInt();
        AppMethodBeat.o(79975);
    }
}
