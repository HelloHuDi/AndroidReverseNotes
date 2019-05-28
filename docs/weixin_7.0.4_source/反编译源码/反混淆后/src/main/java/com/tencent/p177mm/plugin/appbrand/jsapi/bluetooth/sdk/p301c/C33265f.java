package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f */
public final class C33265f {
    /* renamed from: od */
    public static String m54415od(int i) {
        AppMethodBeat.m2504i(94281);
        String str;
        switch (i) {
            case 1:
                str = "GATT CONN L2C FAILURE";
                AppMethodBeat.m2505o(94281);
                return str;
            case 8:
                str = "GATT CONN TIMEOUT";
                AppMethodBeat.m2505o(94281);
                return str;
            case 19:
                str = "GATT CONN TERMINATE PEER USER";
                AppMethodBeat.m2505o(94281);
                return str;
            case 22:
                str = "GATT CONN TERMINATE LOCAL HOST";
                AppMethodBeat.m2505o(94281);
                return str;
            case 34:
                str = "GATT CONN LMP TIMEOUT";
                AppMethodBeat.m2505o(94281);
                return str;
            case 62:
                str = "GATT CONN FAIL ESTABLISH";
                AppMethodBeat.m2505o(94281);
                return str;
            case C19394e.CTRL_INDEX /*133*/:
                str = "GATT ERROR";
                AppMethodBeat.m2505o(94281);
                return str;
            case 256:
                str = "GATT CONN CANCEL ";
                AppMethodBeat.m2505o(94281);
                return str;
            default:
                str = C33265f.m54416oe(i);
                AppMethodBeat.m2505o(94281);
                return str;
        }
    }

    /* renamed from: oe */
    private static String m54416oe(int i) {
        AppMethodBeat.m2504i(94282);
        String str;
        switch (i) {
            case 0:
                str = "GATT SUCCESS";
                AppMethodBeat.m2505o(94282);
                return str;
            case 1:
                str = "GATT INVALID HANDLE";
                AppMethodBeat.m2505o(94282);
                return str;
            case 2:
                str = "GATT READ NOT PERMIT";
                AppMethodBeat.m2505o(94282);
                return str;
            case 3:
                str = "GATT WRITE NOT PERMIT";
                AppMethodBeat.m2505o(94282);
                return str;
            case 4:
                str = "GATT INVALID PDU";
                AppMethodBeat.m2505o(94282);
                return str;
            case 5:
                str = "GATT INSUF AUTHENTICATION";
                AppMethodBeat.m2505o(94282);
                return str;
            case 6:
                str = "GATT REQ NOT SUPPORTED";
                AppMethodBeat.m2505o(94282);
                return str;
            case 7:
                str = "GATT INVALID OFFSET";
                AppMethodBeat.m2505o(94282);
                return str;
            case 8:
                str = "GATT INSUF AUTHORIZATION";
                AppMethodBeat.m2505o(94282);
                return str;
            case 9:
                str = "GATT PREPARE Q FULL";
                AppMethodBeat.m2505o(94282);
                return str;
            case 10:
                str = "GATT NOT FOUND";
                AppMethodBeat.m2505o(94282);
                return str;
            case 11:
                str = "GATT NOT LONG";
                AppMethodBeat.m2505o(94282);
                return str;
            case 12:
                str = "GATT INSUF KEY SIZE";
                AppMethodBeat.m2505o(94282);
                return str;
            case 13:
                str = "GATT INVALID ATTR LEN";
                AppMethodBeat.m2505o(94282);
                return str;
            case 14:
                str = "GATT ERR UNLIKELY";
                AppMethodBeat.m2505o(94282);
                return str;
            case 15:
                str = "GATT INSUF ENCRYPTION";
                AppMethodBeat.m2505o(94282);
                return str;
            case 16:
                str = "GATT UNSUPPORT GRP TYPE";
                AppMethodBeat.m2505o(94282);
                return str;
            case 17:
                str = "GATT INSUF RESOURCE";
                AppMethodBeat.m2505o(94282);
                return str;
            case 128:
                str = "GATT NO RESOURCES";
                AppMethodBeat.m2505o(94282);
                return str;
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                str = "GATT INTERNAL ERROR";
                AppMethodBeat.m2505o(94282);
                return str;
            case 130:
                str = "GATT WRONG STATE";
                AppMethodBeat.m2505o(94282);
                return str;
            case 131:
                str = "GATT DB FULL";
                AppMethodBeat.m2505o(94282);
                return str;
            case 132:
                str = "GATT BUSY";
                AppMethodBeat.m2505o(94282);
                return str;
            case C19394e.CTRL_INDEX /*133*/:
                str = "GATT ERROR";
                AppMethodBeat.m2505o(94282);
                return str;
            case C19392d.CTRL_INDEX /*134*/:
                str = "GATT CMD STARTED";
                AppMethodBeat.m2505o(94282);
                return str;
            case C44697b.CTRL_INDEX /*135*/:
                str = "GATT ILLEGAL PARAMETER";
                AppMethodBeat.m2505o(94282);
                return str;
            case C19395n.CTRL_INDEX /*136*/:
                str = "GATT PENDING";
                AppMethodBeat.m2505o(94282);
                return str;
            case 137:
                str = "GATT AUTH FAIL";
                AppMethodBeat.m2505o(94282);
                return str;
            case 138:
                str = "GATT MORE";
                AppMethodBeat.m2505o(94282);
                return str;
            case C33333a.CTRL_INDEX /*139*/:
                str = "GATT INVALID CFG";
                AppMethodBeat.m2505o(94282);
                return str;
            case 140:
                str = "GATT SERVICE STARTED";
                AppMethodBeat.m2505o(94282);
                return str;
            case 141:
                str = "GATT ENCRYPTED NO MITM";
                AppMethodBeat.m2505o(94282);
                return str;
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                str = "GATT NOT ENCRYPTED";
                AppMethodBeat.m2505o(94282);
                return str;
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                str = "GATT CONGESTED";
                AppMethodBeat.m2505o(94282);
                return str;
            case C31128d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                str = "GATT CCCD CFG ERROR";
                AppMethodBeat.m2505o(94282);
                return str;
            case C31128d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                str = "GATT PROCEDURE IN PROGRESS";
                AppMethodBeat.m2505o(94282);
                return str;
            case 255:
                str = "GATT VALUE OUT OF RANGE";
                AppMethodBeat.m2505o(94282);
                return str;
            case C31128d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                str = "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
                AppMethodBeat.m2505o(94282);
                return str;
            default:
                str = "UNKNOWN (" + i + ")";
                AppMethodBeat.m2505o(94282);
                return str;
        }
    }
}
