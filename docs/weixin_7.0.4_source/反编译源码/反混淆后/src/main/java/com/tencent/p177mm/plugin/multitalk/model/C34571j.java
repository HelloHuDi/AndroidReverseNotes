package com.tencent.p177mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C46090e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.multitalk.model.j */
public final class C34571j {
    public static final float[][] oGR;

    /* renamed from: com.tencent.mm.plugin.multitalk.model.j$a */
    public enum C34570a {
        WIFI,
        _4G,
        _3GOr_2G,
        None;

        static {
            AppMethodBeat.m2505o(54047);
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

    /* renamed from: h */
    public static String m56700h(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54048);
        String str;
        if (multiTalkGroup == null) {
            str = "";
            AppMethodBeat.m2505o(54048);
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
        AppMethodBeat.m2505o(54048);
        return str;
    }

    /* renamed from: a */
    public static boolean m56698a(MultiTalkGroup multiTalkGroup, MultiTalkGroup multiTalkGroup2) {
        AppMethodBeat.m2504i(54049);
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            AppMethodBeat.m2505o(54049);
            return false;
        } else if (!C5046bo.isNullOrNil(multiTalkGroup.Aqc) && !C5046bo.isNullOrNil(multiTalkGroup2.Aqc) && multiTalkGroup.Aqc.equals(multiTalkGroup2.Aqc)) {
            AppMethodBeat.m2505o(54049);
            return true;
        } else if (C5046bo.isNullOrNil(multiTalkGroup.Aqd) || C5046bo.isNullOrNil(multiTalkGroup2.Aqd) || !multiTalkGroup.Aqd.equals(multiTalkGroup2.Aqd)) {
            AppMethodBeat.m2505o(54049);
            return false;
        } else {
            AppMethodBeat.m2505o(54049);
            return true;
        }
    }

    /* renamed from: i */
    public static boolean m56701i(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54050);
        if (multiTalkGroup == null) {
            AppMethodBeat.m2505o(54050);
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
            boolean z3;
            if (multiTalkGroupMember.Aqh.equals(C1853r.m3846Yz())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z) {
                        AppMethodBeat.m2505o(54050);
                        return true;
                    }
                    z2 = true;
                }
                z3 = z;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        AppMethodBeat.m2505o(54050);
                        return true;
                    }
                    z3 = true;
                }
                z3 = z;
            }
            z = z3;
        }
        AppMethodBeat.m2505o(54050);
        return false;
    }

    /* renamed from: j */
    public static boolean m56702j(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54051);
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
            AppMethodBeat.m2505o(54051);
            return true;
        }
        AppMethodBeat.m2505o(54051);
        return false;
    }

    /* renamed from: c */
    public static boolean m56699c(C46090e c46090e) {
        if (c46090e == C46090e.Starting || c46090e == C46090e.Talking || c46090e == C46090e.Inviting) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    public static boolean m56703k(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54052);
        boolean equals = multiTalkGroup.Aqf.equals(C1853r.m3846Yz());
        AppMethodBeat.m2505o(54052);
        return equals;
    }

    /* renamed from: l */
    public static String m56704l(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54053);
        String str;
        if (multiTalkGroup == null) {
            str = "";
            AppMethodBeat.m2505o(54053);
            return str;
        }
        str = multiTalkGroup.Aqc;
        if (C5046bo.isNullOrNil(str)) {
            str = multiTalkGroup.Aqd;
        }
        str = C5046bo.m7532bc(str, "");
        AppMethodBeat.m2505o(54053);
        return str;
    }

    public static String bRU() {
        AppMethodBeat.m2504i(54054);
        String l = C34571j.m56704l(C34572p.bSf().oGh);
        AppMethodBeat.m2505o(54054);
        return l;
    }

    /* renamed from: m */
    public static String m56705m(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(54055);
        String str = null;
        int i = 0;
        while (i < multiTalkGroup.Aqg.size()) {
            String str2;
            if (((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i)).Aqh.equals(C1853r.m3846Yz())) {
                str2 = ((MultiTalkGroupMember) multiTalkGroup.Aqg.get(i)).Aqi;
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        AppMethodBeat.m2505o(54055);
        return str;
    }

    public static String bRV() {
        AppMethodBeat.m2504i(54056);
        String m = C34571j.m56705m(C34572p.bSf().oGh);
        AppMethodBeat.m2505o(54056);
        return m;
    }

    public static boolean bRW() {
        return false;
    }

    /* renamed from: z */
    public static int m56706z(Context context, Intent intent) {
        AppMethodBeat.m2504i(54057);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra != null) {
                if (stringExtra.equals("IDLE")) {
                    AppMethodBeat.m2505o(54057);
                    return 0;
                } else if (stringExtra.equals("RINGING")) {
                    AppMethodBeat.m2505o(54057);
                    return 1;
                } else if (stringExtra.equals("OFFHOOK")) {
                    AppMethodBeat.m2505o(54057);
                    return 2;
                }
            }
        }
        int callState = ((TelephonyManager) context.getSystemService("phone")).getCallState();
        AppMethodBeat.m2505o(54057);
        return callState;
    }

    /* renamed from: zg */
    public static boolean m56707zg(int i) {
        return i == 2 || i == 3;
    }

    /* renamed from: zh */
    public static boolean m56708zh(int i) {
        return i == 1 || i == 3;
    }

    public static C34570a bRX() {
        AppMethodBeat.m2504i(54058);
        C34570a c34570a;
        if (C5023at.isWifi(C4996ah.getContext())) {
            c34570a = C34570a.WIFI;
            AppMethodBeat.m2505o(54058);
            return c34570a;
        } else if (C5023at.is4G(C4996ah.getContext())) {
            c34570a = C34570a._4G;
            AppMethodBeat.m2505o(54058);
            return c34570a;
        } else if (C5023at.is3G(C4996ah.getContext()) || C5023at.is2G(C4996ah.getContext())) {
            c34570a = C34570a._3GOr_2G;
            AppMethodBeat.m2505o(54058);
            return c34570a;
        } else {
            c34570a = C34570a.None;
            AppMethodBeat.m2505o(54058);
            return c34570a;
        }
    }

    public static boolean bRY() {
        AppMethodBeat.m2504i(54059);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1))).intValue();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1))).longValue();
        if (intValue <= 0 || longValue <= 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
            AppMethodBeat.m2505o(54059);
            return true;
        }
        C4990ab.m7417i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", Integer.valueOf(intValue), Long.valueOf(longValue));
        if (C5046bo.m7525az(longValue) <= ((long) (intValue * 1000))) {
            AppMethodBeat.m2505o(54059);
            return false;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
        AppMethodBeat.m2505o(54059);
        return true;
    }
}
