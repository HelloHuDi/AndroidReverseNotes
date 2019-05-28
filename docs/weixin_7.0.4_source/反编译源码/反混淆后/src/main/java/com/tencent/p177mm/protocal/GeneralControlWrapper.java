package com.tencent.p177mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.protocal.protobuf.adl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.protocal.GeneralControlWrapper */
public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new C233631();
    public static final GeneralControlWrapper vxE = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper vxF = new GeneralControlWrapper(1);
    private static Boolean vxH = null;
    public int vxG;

    /* renamed from: com.tencent.mm.protocal.GeneralControlWrapper$1 */
    static class C233631 implements Creator<GeneralControlWrapper> {
        C233631() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralControlWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(79964);
            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(parcel, (byte) 0);
            AppMethodBeat.m2505o(79964);
            return generalControlWrapper;
        }
    }

    /* synthetic */ GeneralControlWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.m2504i(79976);
        AppMethodBeat.m2505o(79976);
    }

    public GeneralControlWrapper(adl adl) {
        AppMethodBeat.m2504i(79965);
        if (adl == null) {
            this.vxG = 0;
        } else {
            this.vxG = adl.wli;
        }
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(79965);
    }

    public GeneralControlWrapper(int i) {
        AppMethodBeat.m2504i(79966);
        this.vxG = i;
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
        AppMethodBeat.m2505o(79966);
    }

    public final boolean dmj() {
        AppMethodBeat.m2504i(79967);
        boolean z = (this.vxG & 262144) != 0;
        if (vxH == null) {
            boolean z2;
            if (1 == ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_can_call_jsapi_before_loaded, 0)) {
                z2 = true;
            } else {
                z2 = false;
            }
            vxH = Boolean.valueOf(z2);
        }
        C4990ab.m7411d("MicroMsg.GeneralControlWrapper", "canCallJsApiBeforeLoad, ret = %b, canCallJsApiBeforeLoaded = %b", Boolean.valueOf(z), vxH);
        if (z || vxH.booleanValue()) {
            AppMethodBeat.m2505o(79967);
            return true;
        }
        AppMethodBeat.m2505o(79967);
        return false;
    }

    public final boolean dmk() {
        AppMethodBeat.m2504i(79968);
        boolean z = (this.vxG & 2) > 0;
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(79968);
        return z;
    }

    public final boolean dml() {
        AppMethodBeat.m2504i(79969);
        boolean z = (this.vxG & 64) > 0;
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(79969);
        return z;
    }

    public final boolean dmm() {
        AppMethodBeat.m2504i(79970);
        boolean z = (this.vxG & 2048) > 0;
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(79970);
        return z;
    }

    public final boolean dmn() {
        AppMethodBeat.m2504i(79971);
        boolean z = (this.vxG & 16384) > 0;
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(79971);
        return z;
    }

    public final boolean dmo() {
        AppMethodBeat.m2504i(79972);
        boolean z = (this.vxG & 32768) > 0;
        C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(79972);
        return z;
    }

    public String toString() {
        AppMethodBeat.m2504i(79973);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.vxG));
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(79973);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(79974);
        parcel.writeInt(this.vxG);
        AppMethodBeat.m2505o(79974);
    }

    private GeneralControlWrapper(Parcel parcel) {
        AppMethodBeat.m2504i(79975);
        this.vxG = parcel.readInt();
        AppMethodBeat.m2505o(79975);
    }
}
