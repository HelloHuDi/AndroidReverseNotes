package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.sns.p520ui.C13698j;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35169f.C35170a;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.d */
public final class C39851d {
    /* renamed from: a */
    public static CharSequence m68261a(Context context, cat cat, C13698j c13698j, int i, String str, int i2) {
        AppMethodBeat.m2504i(40503);
        CharSequence b = C39851d.m68263b(context, cat, c13698j, i, str, i2);
        AppMethodBeat.m2505o(40503);
        return b;
    }

    /* renamed from: b */
    private static CharSequence m68263b(Context context, cat cat, C13698j c13698j, int i, String str, int i2) {
        int i3;
        C7616ad c7616ad;
        int length;
        int i4;
        int length2;
        AppMethodBeat.m2504i(40504);
        String str2 = "";
        String a = C39851d.m68262a(cat);
        String str3 = "";
        String str4 = null;
        String str5 = null;
        Object obj = null;
        Object obj2 = null;
        boolean z = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().mo47460a(C35170a.TimeLine_Comment) && C39732a.m67944Xu(cat.vHl);
        if (i == 21) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        String nullAsNil = C5046bo.nullAsNil(cat.ncM);
        if (C5046bo.isNullOrNil(str)) {
            c7616ad = null;
        } else {
            C1720g.m3537RQ();
            c7616ad = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(str);
        }
        if (i2 == 1) {
            if (C39732a.m67943Xt(cat.vHl) && ((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().mo47460a(C35170a.TimeLine_Like) && C46270n.isShowStoryCheck()) {
                str3 = a + "  ";
                obj = 1;
            } else {
                str3 = a;
            }
        }
        String mJ;
        if (C39851d.m68264fF(cat.wZL, 1)) {
            if (c7616ad != null) {
                String Oj = (c7616ad == null || TextUtils.isEmpty(c7616ad.mo16707Oj())) ? str : c7616ad.mo16707Oj();
                String str6 = str3 + context.getString(C25738R.string.ejp);
                length = str6.length();
                str6 = str6 + Oj;
                i4 = 0;
                str4 = Oj;
                str2 = str2 + str6 + ": ";
            } else {
                C4990ab.m7421w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", str);
                length = 0;
                i4 = 0;
            }
        } else if (C39851d.m68264fF(cat.wZL, 8)) {
            mJ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(cat.xaa);
            if (!C5046bo.isNullOrNil(str3)) {
                str3 = str3 + ": ";
            }
            str3 = str3 + context.getString(C25738R.string.ejp);
            length2 = str3.length();
            str2 = str2 + (str3 + mJ) + " ";
            length = 0;
            i4 = length2;
            str5 = mJ;
        } else if (C5046bo.isNullOrNil(cat.xaa)) {
            if (!C5046bo.isNullOrNil(str3)) {
                str3 = str3 + ": ";
            }
            length = 0;
            i4 = 0;
            str2 = str2 + str3;
        } else {
            Object obj3;
            C7616ad aoN = C13373af.cnt().aoN(cat.xaa);
            mJ = aoN == null ? cat.xaa : aoN.mo16707Oj();
            if (C39732a.m67943Xt(cat.xaa) && ((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().mo47460a(C35170a.TimeLine_Like) && C46270n.isShowStoryCheck()) {
                mJ = mJ + "  ";
                obj3 = 1;
            } else {
                obj3 = null;
            }
            str3 = str3 + context.getString(C25738R.string.env);
            i4 = str3.length();
            str2 = str2 + (str3 + mJ) + ": ";
            obj2 = obj3;
            length = 0;
            str5 = mJ;
        }
        SpannableString a2 = C44089j.m79284a(context, str2 + nullAsNil, C1338a.fromDPToPix(context, (int) (15.0f * C1338a.m2860dm(context))), 2, z);
        length2 = i == 21 ? 3 : 2;
        C44090k c44090k = new C44090k(a2);
        if (i2 == 1) {
            c44090k.mo69792a(new C24944o(cat.vHl, c13698j, length2), a, 0);
            if (obj != null) {
                c44090k.setSpan(new C7134g(((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69264ls(true)), a.length() + 1, a.length() + 2, 17);
            }
        }
        if (!C5046bo.isNullOrNil(str4)) {
            c44090k.mo69792a(new C24944o(str, c13698j, i3), str4, length);
        } else if (!C5046bo.isNullOrNil(str5)) {
            c44090k.mo69792a(new C24944o(cat.xaa, c13698j, i3), str5, i4);
            if (obj2 != null) {
                c44090k.setSpan(new C7134g(((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69264ls(true)), (str5.length() + i4) - 1, str5.length() + i4, 17);
            }
        }
        AppMethodBeat.m2505o(40504);
        return c44090k;
    }

    /* renamed from: a */
    private static String m68262a(cat cat) {
        AppMethodBeat.m2504i(40505);
        C7616ad aoN = C13373af.cnt().aoN(cat.vHl);
        String Oj;
        if (aoN != null) {
            Oj = aoN.mo16707Oj();
            AppMethodBeat.m2505o(40505);
            return Oj;
        } else if (cat.wCW != null) {
            Oj = cat.wCW;
            AppMethodBeat.m2505o(40505);
            return Oj;
        } else {
            Oj = cat.vHl;
            AppMethodBeat.m2505o(40505);
            return Oj;
        }
    }

    /* renamed from: fF */
    public static boolean m68264fF(int i, int i2) {
        return (i & i2) == i2;
    }
}
