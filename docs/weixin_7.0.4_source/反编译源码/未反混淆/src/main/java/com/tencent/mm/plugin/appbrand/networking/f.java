package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.bt.a;
import com.tencent.mm.ci.g;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.h.h;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class f implements a {
    protected static final boolean gNV = bp.dpL();
    protected static final h ipK = new h(new al("MicroMsg.WxaCgiServiceWC").oAl.getLooper(), "MicroMsg.WxaCgiServiceWC");
    protected static final Map<String, Integer> ipL;

    public final /* synthetic */ c a(String str, a aVar, Class cls) {
        AppMethodBeat.i(132320);
        com.tencent.mm.ci.f b = b(str, aVar, cls);
        AppMethodBeat.o(132320);
        return b;
    }

    static {
        AppMethodBeat.i(132321);
        AnonymousClass1 anonymousClass1 = new HashMap<String, Integer>() {
            public final /* synthetic */ Object get(Object obj) {
                int i;
                AppMethodBeat.i(132316);
                Object obj2 = super.get(obj);
                if (obj2 == null) {
                    Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[]{obj}), false, f.gNV);
                }
                if (obj2 == null) {
                    i = -1;
                } else {
                    i = ((Integer) obj2).intValue();
                }
                Integer valueOf = Integer.valueOf(i);
                AppMethodBeat.o(132316);
                return valueOf;
            }
        };
        ipL = anonymousClass1;
        anonymousClass1.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", Integer.valueOf(1714));
        ipL.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", Integer.valueOf(1345));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", Integer.valueOf(FaceManager.FACE_ACQUIRED_UP));
        ipL.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", Integer.valueOf(1862));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", Integer.valueOf(1194));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", Integer.valueOf(1191));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", Integer.valueOf(1180));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", Integer.valueOf(1183));
        ipL.put("/cgi-bin/mmbiz-bin/js-authorize", Integer.valueOf(1157));
        ipL.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", Integer.valueOf(1158));
        AppMethodBeat.o(132321);
    }

    private <Resp extends btd> com.tencent.mm.ci.f<Resp> b(String str, a aVar, Class<Resp> cls) {
        AppMethodBeat.i(132319);
        final b.a aVar2 = new b.a();
        aVar2.fsI = ((Integer) ipL.get(str)).intValue();
        aVar2.uri = str;
        aVar2.fsJ = aVar;
        try {
            aVar2.fsK = (a) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            ab.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", cls.getName());
            if (gNV) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.o(132319);
                throw runtimeException;
            }
        }
        com.tencent.mm.ci.f g = g.dOW().d(ipK).g(new com.tencent.mm.vending.c.a<Resp, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(132318);
                final com.tencent.mm.vending.g.b dMo = com.tencent.mm.vending.g.f.dMo();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                    public final void a(int i, int i2, String str, b bVar) {
                        AppMethodBeat.i(132317);
                        if (!(bVar.fsH.fsP instanceof btd)) {
                            dMo.cR(new Exception("Invalid ResponseProtoBuf"));
                            AppMethodBeat.o(132317);
                        } else if (com.tencent.mm.plugin.appbrand.k.a.a(i, i2, (btd) bVar.fsH.fsP)) {
                            dMo.B(bVar.fsH.fsP);
                            AppMethodBeat.o(132317);
                        } else {
                            dMo.cR(new IllegalArgumentException(String.format(Locale.US, "Invalid response, %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str})));
                            AppMethodBeat.o(132317);
                        }
                    }
                });
                AppMethodBeat.o(132318);
                return null;
            }
        });
        AppMethodBeat.o(132319);
        return g;
    }
}
