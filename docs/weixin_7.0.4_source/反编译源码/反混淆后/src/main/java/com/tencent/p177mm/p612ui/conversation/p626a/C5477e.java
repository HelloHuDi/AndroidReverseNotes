package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32776be;
import com.tencent.p177mm.model.C32776be.C32777a;
import com.tencent.p177mm.model.C37903bd;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.model.p1207a.C42183e;
import com.tencent.p177mm.model.p871b.C45437b.C9646b;
import com.tencent.p177mm.p612ui.p1093d.C24001a;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C35853a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.conversation.a.e */
public final class C5477e {

    /* renamed from: com.tencent.mm.ui.conversation.a.e$a */
    public enum C5479a {
        MAIN_FRAME_BANNER,
        CHATTING_RECOMMEND_BANNER,
        CHATTING_SECURITY_BANNER,
        NET_WARN_BANNER,
        OTHER_ONLINE_BANNER,
        FORCE_NOTIFY_BANNER,
        FACEBOOK_BANNER,
        AD_BANNER,
        ABTEST_BANNER,
        MASS_SEND_SIGHT_BANNER,
        TRY_NEW_INIT_BANNER,
        MAIN_FRAME_AND_ABTEST_BANNER,
        CHATTING_MONITORED_HINT;

        static {
            AppMethodBeat.m2505o(34648);
        }
    }

    /* renamed from: a */
    public static C35853a m8281a(Context context, C5479a c5479a, Object[] objArr) {
        C35853a c35853a = null;
        int i = 0;
        AppMethodBeat.m2504i(34649);
        String obj;
        String obj2;
        switch (c5479a) {
            case CHATTING_RECOMMEND_BANNER:
                if (objArr != null && objArr.length == 2) {
                    obj = objArr[0] != null ? objArr[0].toString() : null;
                    if (objArr[1] != null) {
                        obj2 = objArr[1].toString();
                    } else {
                        obj2 = null;
                    }
                    if (C9638aw.m17190ZK().mo33885Yk() == null) {
                        C4990ab.m7420w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                    }
                    if (C9638aw.m17190ZK().mo33885Yk() != null && (C9638aw.m17190ZK().mo33885Yk().mo60659oV(obj) || C9638aw.m17190ZK().mo33885Yk().mo60659oV(obj2))) {
                        c35853a = new C36259f(context, obj, obj2);
                        break;
                    }
                }
            case CHATTING_SECURITY_BANNER:
                if (objArr != null && objArr.length == 3) {
                    String obj3;
                    boolean z;
                    obj2 = objArr[0] != null ? objArr[0].toString() : null;
                    if (objArr[1] != null) {
                        obj3 = objArr[1].toString();
                    } else {
                        obj3 = null;
                    }
                    if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                        z = false;
                    } else {
                        z = ((Boolean) objArr[2]).booleanValue();
                    }
                    if ((C9638aw.m17179RK() && C9638aw.m17190ZK().mo33886Yl() != null && C9638aw.m17190ZK().mo33886Yl().mo60659oV(obj2)) || C9638aw.m17190ZK().mo33886Yl().mo60659oV(obj3)) {
                        c35853a = new C40849g(context, obj2, obj3, z);
                        break;
                    }
                }
                break;
            case NET_WARN_BANNER:
                c35853a = new C46679o(context);
                break;
            case OTHER_ONLINE_BANNER:
                c35853a = new C40854p(context);
                break;
            case FORCE_NOTIFY_BANNER:
                c35853a = new C40850i(context);
                break;
            case FACEBOOK_BANNER:
                c35853a = new C46677h(context);
                break;
            case AD_BANNER:
                c35853a = new C36257a(context);
                break;
            case MAIN_FRAME_BANNER:
                C32776be.m53537ZV();
                C37903bd ZW = C32776be.m53538ZW();
                if (ZW != null) {
                    c35853a = new C17054l(context, ZW);
                    break;
                }
                break;
            case ABTEST_BANNER:
                C42183e oP = C26407g.aaK().mo60654oP("4");
                if (oP != null) {
                    obj = oP.value;
                    if (!(C5046bo.isNullOrNil(obj) || obj.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                        Object obj4;
                        if (!obj.equals("1")) {
                            if (obj.equals("2")) {
                                C9638aw.m17190ZK();
                                obj4 = C18628c.m29072Ry().get(328196, Boolean.FALSE);
                                if (obj4 instanceof Boolean) {
                                    i = ((Boolean) obj4).booleanValue();
                                }
                                if (i != 0) {
                                    C4990ab.m7416i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                                    break;
                                }
                                C32776be.m53537ZV();
                                if (C32776be.m53540ZY() != C32777a.SUCC) {
                                    c35853a = new C17054l(context, new C37903bd(2, 1, ""));
                                    C18608f.m29044oT("4");
                                    break;
                                }
                                C4990ab.m7416i("MicroMsg.BannerFactory", "already upload the Mobile");
                                break;
                            }
                        }
                        C9638aw.m17190ZK();
                        obj4 = C18628c.m29072Ry().get(328195, Boolean.FALSE);
                        if (obj4 instanceof Boolean) {
                            i = ((Boolean) obj4).booleanValue();
                        }
                        if (i != 0) {
                            C4990ab.m7416i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                            break;
                        }
                        C32776be.m53537ZV();
                        C32777a ZY = C32776be.m53540ZY();
                        if (ZY != C32777a.SUCC && ZY != C32777a.SUCC_UNLOAD) {
                            c35853a = new C17054l(context, new C37903bd(1, 1, ""));
                            C18608f.m29044oT("4");
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.BannerFactory", "already Bind the Mobile");
                        break;
                    }
                }
                break;
            case MASS_SEND_SIGHT_BANNER:
                c35853a = new C30683m(context);
                break;
            case TRY_NEW_INIT_BANNER:
                c35853a = new C46680q(context);
                break;
            case MAIN_FRAME_AND_ABTEST_BANNER:
                c35853a = new C17051k(context);
                break;
            case CHATTING_MONITORED_HINT:
                C9646b c9646b;
                if (objArr == null || objArr.length <= 0) {
                    c9646b = C9646b.Main;
                } else {
                    c9646b = (C9646b) objArr[0];
                }
                c35853a = new C24001a(context, c9646b);
                break;
        }
        AppMethodBeat.m2505o(34649);
        return c35853a;
    }
}
