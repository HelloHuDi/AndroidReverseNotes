package com.tencent.mm.model.gdpr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.f;

public final class c {

    static final class a implements i<IPCVoid, IPCBoolean> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            AppMethodBeat.i(1492);
            if (g.RK() && b.sO((String) g.RP().Ry().get(274436, null))) {
                z = true;
            } else {
                z = false;
            }
            IPCBoolean iPCBoolean = new IPCBoolean(z);
            AppMethodBeat.o(1492);
            return iPCBoolean;
        }
    }

    public static boolean aaZ() {
        AppMethodBeat.i(1493);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, a.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(1493);
            return false;
        }
        AppMethodBeat.o(1493);
        return true;
    }

    public static void a(Context context, final a aVar, final String str, final b bVar) {
        AppMethodBeat.i(1494);
        if (context == null) {
            context = ah.getContext();
        }
        if (!aaZ()) {
            bVar.kL(0);
            AppMethodBeat.o(1494);
        } else if (bo.isNullOrNil(str)) {
            bVar.kL(1);
            AppMethodBeat.o(1494);
        } else {
            com.tencent.mm.ci.g.dOW().h(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(1491);
                    if (aVar.foo == 0) {
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.o(1491);
                        return bool;
                    }
                    final com.tencent.mm.vending.g.b dMo = f.dMo();
                    ajd ajd = new ajd();
                    ajd.csB = str;
                    ajd.scene = aVar.foo;
                    com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                    aVar.fsI = 2575;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getgdrpauth";
                    aVar.fsJ = ajd;
                    aVar.fsK = new aje();
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                        public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                            int i3;
                            AppMethodBeat.i(1490);
                            btd btd = (btd) bVar.fsH.fsP;
                            if (i == 0 && i2 == 0 && btd != null) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            if (i3 != 0) {
                                aje aje = (aje) bVar.fsH.fsP;
                                if (aje.wpb == null) {
                                    aje.wpb = new cxd();
                                    aje.wpb.cyE = -1;
                                }
                                ab.i("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d)", aVar.fon, str, Integer.valueOf(aje.wpb.cyE), Integer.valueOf(aje.state));
                                if (aje.wpb.cyE != 0) {
                                    bVar.kL(0);
                                    dMo.cR(Boolean.FALSE);
                                    AppMethodBeat.o(1490);
                                    return;
                                } else if (aje.state <= 0) {
                                    dMo.B(Boolean.TRUE);
                                    AppMethodBeat.o(1490);
                                    return;
                                } else {
                                    bVar.kL(0);
                                    dMo.cR(Boolean.FALSE);
                                    AppMethodBeat.o(1490);
                                    return;
                                }
                            }
                            ab.e("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d %s)", aVar.fon, str, Integer.valueOf(i2), Integer.valueOf(i), str);
                            bVar.kL(0);
                            dMo.cR(Boolean.FALSE);
                            AppMethodBeat.o(1490);
                        }
                    });
                    AppMethodBeat.o(1491);
                    return null;
                }
            }).g(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(1489);
                    if (((Boolean) obj).booleanValue()) {
                        Intent putExtra = new Intent(context, MPGdprPolicyUI.class).putExtra("MPGdprPolicyUI_KEY_BUSINESS", aVar.fon).putExtra("MPGdprPolicyUI_KEY_APPID", str).putExtra("MPGdprPolicyUI_KEY_RECEIVER", new MPGdprPolicyUtil$1$1(this, new Handler(Looper.getMainLooper())));
                        if (!(context instanceof Activity)) {
                            putExtra.addFlags(268435456);
                        }
                        context.startActivity(putExtra);
                    }
                    AppMethodBeat.o(1489);
                    return null;
                }
            });
            AppMethodBeat.o(1494);
        }
    }
}
