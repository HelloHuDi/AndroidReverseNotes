package com.tencent.p177mm.p612ui.contact;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;

/* renamed from: com.tencent.mm.ui.contact.s */
public final class C15830s {
    public static final int znD = C15830s.m24190C(256, 16, 1, 2, 4);
    public static final int znE = C15830s.m24190C(16, 1, 2, 4, 64, 16384);
    public static int znF = C15830s.m24190C(16, 1, 2, 4, 64, 16384, 16777216);
    public static int znG = C15830s.m24190C(16, 1, 2, 4, 64, 4096, 16777216);
    public static final int znH = C15830s.m24190C(znD, 64, 16384, 4096, 16777216);
    public static final int znI = C15830s.m24190C(16, 2, 16384, 4);
    public static final int znJ = C15830s.m24190C(znD, 16384, 64, 4096, 16777216);
    public static final int znK = C15830s.m24190C(znD, 16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, Utility.DEFAULT_STREAM_BUFFER_SIZE, 16777216);
    public static final int znL = C15830s.m24190C(16, 32, 1, 4, 2, 64);
    public static final int znM = C15830s.m24190C(1, 2, 4, 64, 256, 16384);
    public static final int znN = C15830s.m24190C(znF, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);

    static {
        AppMethodBeat.m2504i(114745);
        AppMethodBeat.m2505o(114745);
    }

    public static HashSet<String> dIf() {
        AppMethodBeat.m2504i(114740);
        HashSet hashSet = new HashSet();
        hashSet.add("weixin");
        AppMethodBeat.m2505o(114740);
        return hashSet;
    }

    /* renamed from: h */
    public static void m24191h(HashSet<String> hashSet) {
        AppMethodBeat.m2504i(114741);
        hashSet.remove("filehelper");
        AppMethodBeat.m2505o(114741);
    }

    public static HashSet<String> dIg() {
        AppMethodBeat.m2504i(114742);
        HashSet hashSet = new HashSet();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (Object add : C1855t.fkY) {
            hashSet.add(add);
        }
        hashSet.add("weibo");
        hashSet.add("qqmail");
        hashSet.add("fmessage");
        hashSet.add("tmessage");
        hashSet.add("floatbottle");
        hashSet.add("lbsapp");
        hashSet.add("shakeapp");
        hashSet.add("medianote");
        hashSet.add("qqfriend");
        hashSet.add("readerapp");
        hashSet.add("newsapp");
        hashSet.add("blogapp");
        hashSet.add("facebookapp");
        hashSet.add("masssendapp");
        hashSet.add("meishiapp");
        hashSet.add("feedsapp");
        hashSet.add("voipapp");
        hashSet.add("filehelper");
        hashSet.add("officialaccounts");
        hashSet.add("helper_entry");
        hashSet.add("pc_share");
        hashSet.add("cardpackage");
        hashSet.add("voicevoipapp");
        hashSet.add("voiceinputapp");
        hashSet.add("linkedinplugin");
        hashSet.add("appbrandcustomerservicemsg");
        AppMethodBeat.m2505o(114742);
        return hashSet;
    }

    /* renamed from: hr */
    public static boolean m24192hr(int i, int i2) {
        return (i & i2) > 0;
    }

    /* renamed from: hs */
    public static int m24193hs(int i, int i2) {
        return (i2 ^ -1) & i;
    }

    /* renamed from: C */
    public static int m24190C(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] | i2;
        }
        return i2;
    }

    public static void init() {
        AppMethodBeat.m2504i(114743);
        if (C15830s.dIh()) {
            if (!C15830s.m24192hr(znF, 16777216)) {
                znF = C15830s.m24190C(znF, 16777216);
            }
            if (!C15830s.m24192hr(znG, 16777216)) {
                znG = C15830s.m24190C(znG, 16777216);
            }
        } else {
            if (C15830s.m24192hr(znF, 16777216)) {
                znF &= -16777217;
            }
            if (C15830s.m24192hr(znG, 16777216)) {
                znG &= -16777217;
                AppMethodBeat.m2505o(114743);
                return;
            }
        }
        AppMethodBeat.m2505o(114743);
    }

    public static boolean dIh() {
        AppMethodBeat.m2504i(114744);
        C4990ab.m7417i("MMSelectContactLogic", "config_val %s ", Integer.valueOf(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("ShowOpenImInGroup", 0)));
        if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("ShowOpenImInGroup", 0) == 0) {
            AppMethodBeat.m2505o(114744);
            return false;
        }
        AppMethodBeat.m2505o(114744);
        return true;
    }
}
