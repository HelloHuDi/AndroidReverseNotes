package com.tencent.p177mm.plugin.fts.p419a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p419a.p1550b.C39130b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.fts.a.g */
public final class C34205g {
    public static HashMap<String, String> ghK = new HashMap();
    public static final C3165a mCS = new C3165a(19968, 40869);
    public static final C3165a mCT = new C3165a(40870, 40907);
    public static final C3165a mCU = new C3165a(13312, 19893);
    public static final C3165a mCV = new C3165a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 173782);
    public static final C3165a mCW = new C3165a(173824, 177972);
    public static final C3165a mCX = new C3165a(177984, 178205);
    public static final C3165a mCY = new C3165a(12032, 12245);
    public static final C3165a mCZ = new C3165a(63744, 64217);
    public static final C3165a mDa = new C3165a(194560, 195101);
    public static final C3165a mDc = new C3165a(59413, 59503);
    public static final C3165a mDd = new C3165a(58368, 58856);
    public static final C3165a mDe = new C3165a(58880, 59087);
    public static final C3165a mDf = new C3165a(12736, 12771);
    public static final C3165a mDg = new C3165a(12272, 12283);
    public static final C3165a mDh = new C3165a(12549, 12576);
    public static final C3165a mDi = new C3165a(12704, 12730);
    public static final C3165a mDj = new C3165a(65, 90);
    public static final C3165a mDk = new C3165a(97, 122);
    public static final C3165a mDl = new C3165a(48, 57);
    public static C39130b mDm = new C39130b();
    public static HashMap<String, String[]> mDn = new HashMap();

    /* renamed from: com.tencent.mm.plugin.fts.a.g$a */
    public static class C3165a {
        int bottom;
        int mDo;

        public C3165a(int i, int i2) {
            this.bottom = i;
            this.mDo = i2;
        }

        /* renamed from: vX */
        public final boolean mo7436vX(int i) {
            return i >= this.bottom && i <= this.mDo;
        }
    }

    static {
        AppMethodBeat.m2504i(114234);
        AppMethodBeat.m2505o(114234);
    }

    /* renamed from: t */
    public static boolean m56097t(char c) {
        AppMethodBeat.m2504i(114230);
        if (mCS.mo7436vX(c) || mCT.mo7436vX(c) || mCU.mo7436vX(c) || mCV.mo7436vX(c) || mCW.mo7436vX(c) || mCX.mo7436vX(c)) {
            AppMethodBeat.m2505o(114230);
            return true;
        }
        AppMethodBeat.m2505o(114230);
        return false;
    }

    /* renamed from: u */
    public static boolean m56098u(char c) {
        AppMethodBeat.m2504i(114231);
        if (mDj.mo7436vX(c) || mDk.mo7436vX(c)) {
            AppMethodBeat.m2505o(114231);
            return true;
        }
        AppMethodBeat.m2505o(114231);
        return false;
    }

    /* renamed from: v */
    public static boolean m56099v(char c) {
        AppMethodBeat.m2504i(114232);
        boolean vX = mDl.mo7436vX(c);
        AppMethodBeat.m2505o(114232);
        return vX;
    }

    /* renamed from: Nf */
    public static final String m56096Nf(String str) {
        String str2;
        AppMethodBeat.m2504i(114233);
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (C34205g.m56097t(c)) {
                str2 = (String) ghK.get(String.valueOf(c));
                if (!C5046bo.isNullOrNil(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c);
        }
        str2 = stringBuffer.toString();
        AppMethodBeat.m2505o(114233);
        return str2;
    }
}
