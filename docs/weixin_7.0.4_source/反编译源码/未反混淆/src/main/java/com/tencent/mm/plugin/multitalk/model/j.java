package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public final class j {
    public static final float[][] oGR;

    public enum a {
        WIFI,
        _4G,
        _3GOr_2G,
        None;

        static {
            AppMethodBeat.o(54047);
        }
    }

    static {
        r0 = new float[6][];
        oGR = r0;
        r0[0] = null;
        oGR[1] = new float[]{0.5f, 0.5f};
        oGR[2] = new float[]{0.0f, 0.5f, 1.0f, 0.5f};
        oGR[3] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 1.0f};
        oGR[4] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        oGR[5] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 2.0f, 1.0f, 0.0f, 2.0f, 1.0f, 2.0f, 2.0f, 2.0f};
    }

    public static String h(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54048);
        String str;
        if (multiTalkGroup == null) {
            str = "";
            AppMethodBeat.o(54048);
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<MultiTalkGroupMember> list = multiTalkGroup.Aqg;
        stringBuffer.append("->[usernamelist]");
        if (list != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : list) {
                stringBuffer.append(multiTalkGroupMember.Aqh + "|");
                stringBuffer.append(multiTalkGroupMember.status + ", ");
            }
        }
        stringBuffer.append(" ->createname:" + multiTalkGroup.Aqf);
        stringBuffer.append(" ->talkgroupId:" + multiTalkGroup.Aqc);
        stringBuffer.append(" ->wxGroupId:" + multiTalkGroup.Aqe);
        str = stringBuffer.toString();
        AppMethodBeat.o(54048);
        return str;
    }

    public static boolean a(MultiTalkGroup multiTalkGroup, MultiTalkGroup multiTalkGroup2) {
        AppMethodBeat.i(54049);
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            AppMethodBeat.o(54049);
            return false;
        } else if (!bo.isNullOrNil(multiTalkGroup.Aqc) && !bo.isNullOrNil(multiTalkGroup2.Aqc) && multiTalkGroup.Aqc.equals(multiTalkGroup2.Aqc)) {
            AppMethodBeat.o(54049);
            return true;
        } else if (bo.isNullOrNil(multiTalkGroup.Aqd) || bo.isNullOrNil(multiTalkGroup2.Aqd) || !multiTalkGroup.Aqd.equals(multiTalkGroup2.Aqd)) {
            AppMethodBeat.o(54049);
            return false;
        } else {
            AppMethodBeat.o(54049);
            return true;
        }
    }

    public static boolean i(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54050);
        if (multiTalkGroup == null) {
            AppMethodBeat.o(54050);
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
            boolean z3;
            if (multiTalkGroupMember.Aqh.equals(r.Yz())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z) {
                        AppMethodBeat.o(54050);
                        return true;
                    }
                    z2 = true;
                }
                z3 = z;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        AppMethodBeat.o(54050);
                        return true;
                    }
                    z3 = true;
                }
                z3 = z;
            }
            z = z3;
        }
        AppMethodBeat.o(54050);
        return false;
    }

    public static boolean j(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54051);
        int i = 0;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
            int i2;
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 1) {
            AppMethodBeat.o(54051);
            return true;
        }
        AppMethodBeat.o(54051);
        return false;
    }

    public static boolean c(e eVar) {
        if (eVar == e.Starting || eVar == e.Talking || eVar == e.Inviting) {
            return true;
        }
        return false;
    }

    public static boolean k(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54052);
        boolean equals = multiTalkGroup.Aqf.equals(r.Yz());
        AppMethodBeat.o(54052);
        return equals;
    }

    public static String l(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54053);
        String str;
        if (multiTalkGroup == null) {
            str = "";
            AppMethodBeat.o(54053);
            return str;
        }
        str = multiTalkGroup.Aqc;
        if (bo.isNullOrNil(str)) {
            str = multiTalkGroup.Aqd;
        }
        str = bo.bc(str, "");
        AppMethodBeat.o(54053);
        return str;
    }

    public static String bRU() {
        AppMethodBeat.i(54054);
        String l = l(p.bSf().oGh);
        AppMethodBeat.o(54054);
        return l;
    }

    public static String m(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(54055);
        String str = null;
        int i = 0;
        while (i < multiTalkGroup.Aqg.size()) {
            String str2;
            if (((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i)).Aqh.equals(r.Yz())) {
                str2 = ((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i)).Aqi;
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        AppMethodBeat.o(54055);
        return str;
    }

    public static String bRV() {
        AppMethodBeat.i(54056);
        String m = m(p.bSf().oGh);
        AppMethodBeat.o(54056);
        return m;
    }

    public static boolean bRW() {
        return false;
    }

    public static int z(Context context, Intent intent) {
        AppMethodBeat.i(54057);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra != null) {
                if (stringExtra.equals("IDLE")) {
                    AppMethodBeat.o(54057);
                    return 0;
                } else if (stringExtra.equals("RINGING")) {
                    AppMethodBeat.o(54057);
                    return 1;
                } else if (stringExtra.equals("OFFHOOK")) {
                    AppMethodBeat.o(54057);
                    return 2;
                }
            }
        }
        int callState = ((TelephonyManager) context.getSystemService("phone")).getCallState();
        AppMethodBeat.o(54057);
        return callState;
    }

    public static boolean zg(int i) {
        return i == 2 || i == 3;
    }

    public static boolean zh(int i) {
        return i == 1 || i == 3;
    }

    public static a bRX() {
        AppMethodBeat.i(54058);
        a aVar;
        if (at.isWifi(ah.getContext())) {
            aVar = a.WIFI;
            AppMethodBeat.o(54058);
            return aVar;
        } else if (at.is4G(ah.getContext())) {
            aVar = a._4G;
            AppMethodBeat.o(54058);
            return aVar;
        } else if (at.is3G(ah.getContext()) || at.is2G(ah.getContext())) {
            aVar = a._3GOr_2G;
            AppMethodBeat.o(54058);
            return aVar;
        } else {
            aVar = a.None;
            AppMethodBeat.o(54058);
            return aVar;
        }
    }

    public static boolean bRY() {
        AppMethodBeat.i(54059);
        int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1))).intValue();
        long longValue = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1))).longValue();
        if (intValue <= 0 || longValue <= 0) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
            AppMethodBeat.o(54059);
            return true;
        }
        ab.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", Integer.valueOf(intValue), Long.valueOf(longValue));
        if (bo.az(longValue) <= ((long) (intValue * 1000))) {
            AppMethodBeat.o(54059);
            return false;
        }
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
        AppMethodBeat.o(54059);
        return true;
    }
}
