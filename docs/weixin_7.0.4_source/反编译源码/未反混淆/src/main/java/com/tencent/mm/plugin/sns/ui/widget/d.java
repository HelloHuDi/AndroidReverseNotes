package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class d {
    public static CharSequence a(Context context, cat cat, j jVar, int i, String str, int i2) {
        AppMethodBeat.i(40503);
        CharSequence b = b(context, cat, jVar, i, str, i2);
        AppMethodBeat.o(40503);
        return b;
    }

    private static CharSequence b(Context context, cat cat, j jVar, int i, String str, int i2) {
        int i3;
        ad adVar;
        int length;
        int i4;
        int length2;
        AppMethodBeat.i(40504);
        String str2 = "";
        String a = a(cat);
        String str3 = "";
        String str4 = null;
        String str5 = null;
        Object obj = null;
        Object obj2 = null;
        boolean z = ((e) g.M(e.class)).getStoryBasicConfig().a(a.TimeLine_Comment) && com.tencent.mm.plugin.sns.e.a.Xu(cat.vHl);
        if (i == 21) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        String nullAsNil = bo.nullAsNil(cat.ncM);
        if (bo.isNullOrNil(str)) {
            adVar = null;
        } else {
            g.RQ();
            adVar = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(str);
        }
        if (i2 == 1) {
            if (com.tencent.mm.plugin.sns.e.a.Xt(cat.vHl) && ((e) g.M(e.class)).getStoryBasicConfig().a(a.TimeLine_Like) && n.isShowStoryCheck()) {
                str3 = a + "  ";
                obj = 1;
            } else {
                str3 = a;
            }
        }
        String mJ;
        if (fF(cat.wZL, 1)) {
            if (adVar != null) {
                String Oj = (adVar == null || TextUtils.isEmpty(adVar.Oj())) ? str : adVar.Oj();
                String str6 = str3 + context.getString(R.string.ejp);
                length = str6.length();
                str6 = str6 + Oj;
                i4 = 0;
                str4 = Oj;
                str2 = str2 + str6 + ": ";
            } else {
                ab.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", str);
                length = 0;
                i4 = 0;
            }
        } else if (fF(cat.wZL, 8)) {
            mJ = ((b) g.K(b.class)).mJ(cat.xaa);
            if (!bo.isNullOrNil(str3)) {
                str3 = str3 + ": ";
            }
            str3 = str3 + context.getString(R.string.ejp);
            length2 = str3.length();
            str2 = str2 + (str3 + mJ) + " ";
            length = 0;
            i4 = length2;
            str5 = mJ;
        } else if (bo.isNullOrNil(cat.xaa)) {
            if (!bo.isNullOrNil(str3)) {
                str3 = str3 + ": ";
            }
            length = 0;
            i4 = 0;
            str2 = str2 + str3;
        } else {
            Object obj3;
            ad aoN = af.cnt().aoN(cat.xaa);
            mJ = aoN == null ? cat.xaa : aoN.Oj();
            if (com.tencent.mm.plugin.sns.e.a.Xt(cat.xaa) && ((e) g.M(e.class)).getStoryBasicConfig().a(a.TimeLine_Like) && n.isShowStoryCheck()) {
                mJ = mJ + "  ";
                obj3 = 1;
            } else {
                obj3 = null;
            }
            str3 = str3 + context.getString(R.string.env);
            i4 = str3.length();
            str2 = str2 + (str3 + mJ) + ": ";
            obj2 = obj3;
            length = 0;
            str5 = mJ;
        }
        SpannableString a2 = com.tencent.mm.pluginsdk.ui.e.j.a(context, str2 + nullAsNil, com.tencent.mm.bz.a.fromDPToPix(context, (int) (15.0f * com.tencent.mm.bz.a.dm(context))), 2, z);
        length2 = i == 21 ? 3 : 2;
        k kVar = new k(a2);
        if (i2 == 1) {
            kVar.a(new o(cat.vHl, jVar, length2), a, 0);
            if (obj != null) {
                kVar.setSpan(new g(((e) g.M(e.class)).getStoryUIFactory().ls(true)), a.length() + 1, a.length() + 2, 17);
            }
        }
        if (!bo.isNullOrNil(str4)) {
            kVar.a(new o(str, jVar, i3), str4, length);
        } else if (!bo.isNullOrNil(str5)) {
            kVar.a(new o(cat.xaa, jVar, i3), str5, i4);
            if (obj2 != null) {
                kVar.setSpan(new g(((e) g.M(e.class)).getStoryUIFactory().ls(true)), (str5.length() + i4) - 1, str5.length() + i4, 17);
            }
        }
        AppMethodBeat.o(40504);
        return kVar;
    }

    private static String a(cat cat) {
        AppMethodBeat.i(40505);
        ad aoN = af.cnt().aoN(cat.vHl);
        String Oj;
        if (aoN != null) {
            Oj = aoN.Oj();
            AppMethodBeat.o(40505);
            return Oj;
        } else if (cat.wCW != null) {
            Oj = cat.wCW;
            AppMethodBeat.o(40505);
            return Oj;
        } else {
            Oj = cat.vHl;
            AppMethodBeat.o(40505);
            return Oj;
        }
    }

    public static boolean fF(int i, int i2) {
        return (i & i2) == i2;
    }
}
