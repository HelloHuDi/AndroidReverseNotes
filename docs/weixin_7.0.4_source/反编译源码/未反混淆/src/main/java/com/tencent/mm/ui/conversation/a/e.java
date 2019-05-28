package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {

    public enum a {
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
            AppMethodBeat.o(34648);
        }
    }

    public static com.tencent.mm.pluginsdk.ui.b.a a(Context context, a aVar, Object[] objArr) {
        com.tencent.mm.pluginsdk.ui.b.a aVar2 = null;
        int i = 0;
        AppMethodBeat.i(34649);
        String obj;
        String obj2;
        switch (aVar) {
            case CHATTING_RECOMMEND_BANNER:
                if (objArr != null && objArr.length == 2) {
                    obj = objArr[0] != null ? objArr[0].toString() : null;
                    if (objArr[1] != null) {
                        obj2 = objArr[1].toString();
                    } else {
                        obj2 = null;
                    }
                    if (aw.ZK().Yk() == null) {
                        ab.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                    }
                    if (aw.ZK().Yk() != null && (aw.ZK().Yk().oV(obj) || aw.ZK().Yk().oV(obj2))) {
                        aVar2 = new f(context, obj, obj2);
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
                    if ((aw.RK() && aw.ZK().Yl() != null && aw.ZK().Yl().oV(obj2)) || aw.ZK().Yl().oV(obj3)) {
                        aVar2 = new g(context, obj2, obj3, z);
                        break;
                    }
                }
                break;
            case NET_WARN_BANNER:
                aVar2 = new o(context);
                break;
            case OTHER_ONLINE_BANNER:
                aVar2 = new p(context);
                break;
            case FORCE_NOTIFY_BANNER:
                aVar2 = new i(context);
                break;
            case FACEBOOK_BANNER:
                aVar2 = new h(context);
                break;
            case AD_BANNER:
                aVar2 = new a(context);
                break;
            case MAIN_FRAME_BANNER:
                be.ZV();
                bd ZW = be.ZW();
                if (ZW != null) {
                    aVar2 = new l(context, ZW);
                    break;
                }
                break;
            case ABTEST_BANNER:
                com.tencent.mm.model.a.e oP = g.aaK().oP("4");
                if (oP != null) {
                    obj = oP.value;
                    if (!(bo.isNullOrNil(obj) || obj.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                        Object obj4;
                        if (!obj.equals("1")) {
                            if (obj.equals("2")) {
                                aw.ZK();
                                obj4 = c.Ry().get(328196, Boolean.FALSE);
                                if (obj4 instanceof Boolean) {
                                    i = ((Boolean) obj4).booleanValue();
                                }
                                if (i != 0) {
                                    ab.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                                    break;
                                }
                                be.ZV();
                                if (be.ZY() != com.tencent.mm.model.be.a.SUCC) {
                                    aVar2 = new l(context, new bd(2, 1, ""));
                                    f.oT("4");
                                    break;
                                }
                                ab.i("MicroMsg.BannerFactory", "already upload the Mobile");
                                break;
                            }
                        }
                        aw.ZK();
                        obj4 = c.Ry().get(328195, Boolean.FALSE);
                        if (obj4 instanceof Boolean) {
                            i = ((Boolean) obj4).booleanValue();
                        }
                        if (i != 0) {
                            ab.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                            break;
                        }
                        be.ZV();
                        com.tencent.mm.model.be.a ZY = be.ZY();
                        if (ZY != com.tencent.mm.model.be.a.SUCC && ZY != com.tencent.mm.model.be.a.SUCC_UNLOAD) {
                            aVar2 = new l(context, new bd(1, 1, ""));
                            f.oT("4");
                            break;
                        }
                        ab.i("MicroMsg.BannerFactory", "already Bind the Mobile");
                        break;
                    }
                }
                break;
            case MASS_SEND_SIGHT_BANNER:
                aVar2 = new m(context);
                break;
            case TRY_NEW_INIT_BANNER:
                aVar2 = new q(context);
                break;
            case MAIN_FRAME_AND_ABTEST_BANNER:
                aVar2 = new k(context);
                break;
            case CHATTING_MONITORED_HINT:
                b bVar;
                if (objArr == null || objArr.length <= 0) {
                    bVar = b.Main;
                } else {
                    bVar = (b) objArr[0];
                }
                aVar2 = new com.tencent.mm.ui.d.a(context, bVar);
                break;
        }
        AppMethodBeat.o(34649);
        return aVar2;
    }
}
