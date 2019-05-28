package com.tencent.mm.ui.contact;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

public final class s {
    public static final int znD = C(256, 16, 1, 2, 4);
    public static final int znE = C(16, 1, 2, 4, 64, 16384);
    public static int znF = C(16, 1, 2, 4, 64, 16384, 16777216);
    public static int znG = C(16, 1, 2, 4, 64, 4096, 16777216);
    public static final int znH = C(znD, 64, 16384, 4096, 16777216);
    public static final int znI = C(16, 2, 16384, 4);
    public static final int znJ = C(znD, 16384, 64, 4096, 16777216);
    public static final int znK = C(znD, 16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, Utility.DEFAULT_STREAM_BUFFER_SIZE, 16777216);
    public static final int znL = C(16, 32, 1, 4, 2, 64);
    public static final int znM = C(1, 2, 4, 64, 256, 16384);
    public static final int znN = C(znF, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);

    static {
        AppMethodBeat.i(114745);
        AppMethodBeat.o(114745);
    }

    public static HashSet<String> dIf() {
        AppMethodBeat.i(114740);
        HashSet hashSet = new HashSet();
        hashSet.add("weixin");
        AppMethodBeat.o(114740);
        return hashSet;
    }

    public static void h(HashSet<String> hashSet) {
        AppMethodBeat.i(114741);
        hashSet.remove("filehelper");
        AppMethodBeat.o(114741);
    }

    public static HashSet<String> dIg() {
        AppMethodBeat.i(114742);
        HashSet hashSet = new HashSet();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (Object add : t.fkY) {
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
        AppMethodBeat.o(114742);
        return hashSet;
    }

    public static boolean hr(int i, int i2) {
        return (i & i2) > 0;
    }

    public static int hs(int i, int i2) {
        return (i2 ^ -1) & i;
    }

    public static int C(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] | i2;
        }
        return i2;
    }

    public static void init() {
        AppMethodBeat.i(114743);
        if (dIh()) {
            if (!hr(znF, 16777216)) {
                znF = C(znF, 16777216);
            }
            if (!hr(znG, 16777216)) {
                znG = C(znG, 16777216);
            }
        } else {
            if (hr(znF, 16777216)) {
                znF &= -16777217;
            }
            if (hr(znG, 16777216)) {
                znG &= -16777217;
                AppMethodBeat.o(114743);
                return;
            }
        }
        AppMethodBeat.o(114743);
    }

    public static boolean dIh() {
        AppMethodBeat.i(114744);
        ab.i("MMSelectContactLogic", "config_val %s ", Integer.valueOf(((a) g.K(a.class)).Nu().getInt("ShowOpenImInGroup", 0)));
        if (((a) g.K(a.class)).Nu().getInt("ShowOpenImInGroup", 0) == 0) {
            AppMethodBeat.o(114744);
            return false;
        }
        AppMethodBeat.o(114744);
        return true;
    }
}
