package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class f {
    public static String od(int i) {
        AppMethodBeat.i(94281);
        String str;
        switch (i) {
            case 1:
                str = "GATT CONN L2C FAILURE";
                AppMethodBeat.o(94281);
                return str;
            case 8:
                str = "GATT CONN TIMEOUT";
                AppMethodBeat.o(94281);
                return str;
            case 19:
                str = "GATT CONN TERMINATE PEER USER";
                AppMethodBeat.o(94281);
                return str;
            case 22:
                str = "GATT CONN TERMINATE LOCAL HOST";
                AppMethodBeat.o(94281);
                return str;
            case 34:
                str = "GATT CONN LMP TIMEOUT";
                AppMethodBeat.o(94281);
                return str;
            case 62:
                str = "GATT CONN FAIL ESTABLISH";
                AppMethodBeat.o(94281);
                return str;
            case e.CTRL_INDEX /*133*/:
                str = "GATT ERROR";
                AppMethodBeat.o(94281);
                return str;
            case 256:
                str = "GATT CONN CANCEL ";
                AppMethodBeat.o(94281);
                return str;
            default:
                str = oe(i);
                AppMethodBeat.o(94281);
                return str;
        }
    }

    private static String oe(int i) {
        AppMethodBeat.i(94282);
        String str;
        switch (i) {
            case 0:
                str = "GATT SUCCESS";
                AppMethodBeat.o(94282);
                return str;
            case 1:
                str = "GATT INVALID HANDLE";
                AppMethodBeat.o(94282);
                return str;
            case 2:
                str = "GATT READ NOT PERMIT";
                AppMethodBeat.o(94282);
                return str;
            case 3:
                str = "GATT WRITE NOT PERMIT";
                AppMethodBeat.o(94282);
                return str;
            case 4:
                str = "GATT INVALID PDU";
                AppMethodBeat.o(94282);
                return str;
            case 5:
                str = "GATT INSUF AUTHENTICATION";
                AppMethodBeat.o(94282);
                return str;
            case 6:
                str = "GATT REQ NOT SUPPORTED";
                AppMethodBeat.o(94282);
                return str;
            case 7:
                str = "GATT INVALID OFFSET";
                AppMethodBeat.o(94282);
                return str;
            case 8:
                str = "GATT INSUF AUTHORIZATION";
                AppMethodBeat.o(94282);
                return str;
            case 9:
                str = "GATT PREPARE Q FULL";
                AppMethodBeat.o(94282);
                return str;
            case 10:
                str = "GATT NOT FOUND";
                AppMethodBeat.o(94282);
                return str;
            case 11:
                str = "GATT NOT LONG";
                AppMethodBeat.o(94282);
                return str;
            case 12:
                str = "GATT INSUF KEY SIZE";
                AppMethodBeat.o(94282);
                return str;
            case 13:
                str = "GATT INVALID ATTR LEN";
                AppMethodBeat.o(94282);
                return str;
            case 14:
                str = "GATT ERR UNLIKELY";
                AppMethodBeat.o(94282);
                return str;
            case 15:
                str = "GATT INSUF ENCRYPTION";
                AppMethodBeat.o(94282);
                return str;
            case 16:
                str = "GATT UNSUPPORT GRP TYPE";
                AppMethodBeat.o(94282);
                return str;
            case 17:
                str = "GATT INSUF RESOURCE";
                AppMethodBeat.o(94282);
                return str;
            case 128:
                str = "GATT NO RESOURCES";
                AppMethodBeat.o(94282);
                return str;
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                str = "GATT INTERNAL ERROR";
                AppMethodBeat.o(94282);
                return str;
            case 130:
                str = "GATT WRONG STATE";
                AppMethodBeat.o(94282);
                return str;
            case 131:
                str = "GATT DB FULL";
                AppMethodBeat.o(94282);
                return str;
            case 132:
                str = "GATT BUSY";
                AppMethodBeat.o(94282);
                return str;
            case e.CTRL_INDEX /*133*/:
                str = "GATT ERROR";
                AppMethodBeat.o(94282);
                return str;
            case d.CTRL_INDEX /*134*/:
                str = "GATT CMD STARTED";
                AppMethodBeat.o(94282);
                return str;
            case b.CTRL_INDEX /*135*/:
                str = "GATT ILLEGAL PARAMETER";
                AppMethodBeat.o(94282);
                return str;
            case n.CTRL_INDEX /*136*/:
                str = "GATT PENDING";
                AppMethodBeat.o(94282);
                return str;
            case 137:
                str = "GATT AUTH FAIL";
                AppMethodBeat.o(94282);
                return str;
            case 138:
                str = "GATT MORE";
                AppMethodBeat.o(94282);
                return str;
            case a.CTRL_INDEX /*139*/:
                str = "GATT INVALID CFG";
                AppMethodBeat.o(94282);
                return str;
            case 140:
                str = "GATT SERVICE STARTED";
                AppMethodBeat.o(94282);
                return str;
            case 141:
                str = "GATT ENCRYPTED NO MITM";
                AppMethodBeat.o(94282);
                return str;
            case ErrorCode.NEEDDOWNLOAD_3 /*142*/:
                str = "GATT NOT ENCRYPTED";
                AppMethodBeat.o(94282);
                return str;
            case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                str = "GATT CONGESTED";
                AppMethodBeat.o(94282);
                return str;
            case com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                str = "GATT CCCD CFG ERROR";
                AppMethodBeat.o(94282);
                return str;
            case com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                str = "GATT PROCEDURE IN PROGRESS";
                AppMethodBeat.o(94282);
                return str;
            case 255:
                str = "GATT VALUE OUT OF RANGE";
                AppMethodBeat.o(94282);
                return str;
            case com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                str = "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
                AppMethodBeat.o(94282);
                return str;
            default:
                str = "UNKNOWN (" + i + ")";
                AppMethodBeat.o(94282);
                return str;
        }
    }
}
