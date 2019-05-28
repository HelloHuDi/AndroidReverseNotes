package com.tencent.p177mm.model.gdpr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.gdpr.p872ui.MPGdprPolicyUI;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.protocal.protobuf.ajd;
import com.tencent.p177mm.protocal.protobuf.aje;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.cxd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.model.gdpr.c */
public final class C37918c {

    /* renamed from: com.tencent.mm.model.gdpr.c$a */
    static final class C32793a implements C45413i<IPCVoid, IPCBoolean> {
        private C32793a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(1492);
            if (C1720g.m3531RK() && C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                z = true;
            } else {
                z = false;
            }
            IPCBoolean iPCBoolean = new IPCBoolean(z);
            AppMethodBeat.m2505o(1492);
            return iPCBoolean;
        }
    }

    public static boolean aaZ() {
        AppMethodBeat.m2504i(1493);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", IPCVoid.eGH, C32793a.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.m2505o(1493);
            return false;
        }
        AppMethodBeat.m2505o(1493);
        return true;
    }

    /* renamed from: a */
    public static void m64041a(Context context, final C32791a c32791a, final String str, final C32792b c32792b) {
        AppMethodBeat.m2504i(1494);
        if (context == null) {
            context = C4996ah.getContext();
        }
        if (!C37918c.aaZ()) {
            c32792b.mo8219kL(0);
            AppMethodBeat.m2505o(1494);
        } else if (C5046bo.isNullOrNil(str)) {
            c32792b.mo8219kL(1);
            AppMethodBeat.m2505o(1494);
        } else {
            C41930g.dOW().mo60492h(new C5681a<Boolean, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(1491);
                    if (c32791a.foo == 0) {
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.m2505o(1491);
                        return bool;
                    }
                    final C5688b dMo = C5698f.dMo();
                    ajd ajd = new ajd();
                    ajd.csB = str;
                    ajd.scene = c32791a.foo;
                    C1196a c1196a = new C1196a();
                    c1196a.fsI = 2575;
                    c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getgdrpauth";
                    c1196a.fsJ = ajd;
                    c1196a.fsK = new aje();
                    C42146b.m74301a(c1196a.acD(), new C9557a() {
                        /* renamed from: a */
                        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                            int i3;
                            AppMethodBeat.m2504i(1490);
                            btd btd = (btd) c7472b.fsH.fsP;
                            if (i == 0 && i2 == 0 && btd != null) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            if (i3 != 0) {
                                aje aje = (aje) c7472b.fsH.fsP;
                                if (aje.wpb == null) {
                                    aje.wpb = new cxd();
                                    aje.wpb.cyE = -1;
                                }
                                C4990ab.m7417i("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d)", c32791a.fon, str, Integer.valueOf(aje.wpb.cyE), Integer.valueOf(aje.state));
                                if (aje.wpb.cyE != 0) {
                                    c32792b.mo8219kL(0);
                                    dMo.mo11582cR(Boolean.FALSE);
                                    AppMethodBeat.m2505o(1490);
                                    return;
                                } else if (aje.state <= 0) {
                                    dMo.mo11581B(Boolean.TRUE);
                                    AppMethodBeat.m2505o(1490);
                                    return;
                                } else {
                                    c32792b.mo8219kL(0);
                                    dMo.mo11582cR(Boolean.FALSE);
                                    AppMethodBeat.m2505o(1490);
                                    return;
                                }
                            }
                            C4990ab.m7413e("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d %s)", c32791a.fon, str, Integer.valueOf(i2), Integer.valueOf(i), str);
                            c32792b.mo8219kL(0);
                            dMo.mo11582cR(Boolean.FALSE);
                            AppMethodBeat.m2505o(1490);
                        }
                    });
                    AppMethodBeat.m2505o(1491);
                    return null;
                }
            }).mo60491g(new C5681a<Void, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(1489);
                    if (((Boolean) obj).booleanValue()) {
                        Intent putExtra = new Intent(context, MPGdprPolicyUI.class).putExtra("MPGdprPolicyUI_KEY_BUSINESS", c32791a.fon).putExtra("MPGdprPolicyUI_KEY_APPID", str).putExtra("MPGdprPolicyUI_KEY_RECEIVER", new MPGdprPolicyUtil$1$1(this, new Handler(Looper.getMainLooper())));
                        if (!(context instanceof Activity)) {
                            putExtra.addFlags(268435456);
                        }
                        context.startActivity(putExtra);
                    }
                    AppMethodBeat.m2505o(1489);
                    return null;
                }
            });
            AppMethodBeat.m2505o(1494);
        }
    }
}
