package com.tencent.p177mm.plugin.appbrand.networking;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.p177mm.vending.p642h.C7369h;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.networking.f */
public final class C10645f implements C42637a {
    protected static final boolean gNV = C5047bp.dpL();
    protected static final C7369h ipK = new C7369h(new C5004al("MicroMsg.WxaCgiServiceWC").oAl.getLooper(), "MicroMsg.WxaCgiServiceWC");
    protected static final Map<String, Integer> ipL;

    /* renamed from: com.tencent.mm.plugin.appbrand.networking.f$1 */
    static class C106461 extends HashMap<String, Integer> {
        C106461() {
        }

        public final /* synthetic */ Object get(Object obj) {
            int i;
            AppMethodBeat.m2504i(132316);
            Object obj2 = super.get(obj);
            if (obj2 == null) {
                Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[]{obj}), false, C10645f.gNV);
            }
            if (obj2 == null) {
                i = -1;
            } else {
                i = ((Integer) obj2).intValue();
            }
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(132316);
            return valueOf;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ C7361c mo22168a(String str, C1331a c1331a, Class cls) {
        AppMethodBeat.m2504i(132320);
        C37654f b = m18342b(str, c1331a, cls);
        AppMethodBeat.m2505o(132320);
        return b;
    }

    static {
        AppMethodBeat.m2504i(132321);
        C106461 c106461 = new C106461();
        ipL = c106461;
        c106461.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", Integer.valueOf(1714));
        ipL.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", Integer.valueOf(1345));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", Integer.valueOf(FaceManager.FACE_ACQUIRED_UP));
        ipL.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", Integer.valueOf(1862));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", Integer.valueOf(1194));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", Integer.valueOf(1191));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", Integer.valueOf(1180));
        ipL.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", Integer.valueOf(1183));
        ipL.put("/cgi-bin/mmbiz-bin/js-authorize", Integer.valueOf(1157));
        ipL.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", Integer.valueOf(1158));
        AppMethodBeat.m2505o(132321);
    }

    /* renamed from: b */
    private <Resp extends btd> C37654f<Resp> m18342b(String str, C1331a c1331a, Class<Resp> cls) {
        AppMethodBeat.m2504i(132319);
        final C1196a c1196a = new C1196a();
        c1196a.fsI = ((Integer) ipL.get(str)).intValue();
        c1196a.uri = str;
        c1196a.fsJ = c1331a;
        try {
            c1196a.fsK = (C1331a) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            C4990ab.m7413e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", cls.getName());
            if (gNV) {
                RuntimeException runtimeException = new RuntimeException(e);
                AppMethodBeat.m2505o(132319);
                throw runtimeException;
            }
        }
        C37654f g = C41930g.dOW().mo60490d(ipK).mo60491g(new C5681a<Resp, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(132318);
                final C5688b dMo = C5698f.dMo();
                C42146b.m74301a(c1196a.acD(), new C9557a() {
                    /* renamed from: a */
                    public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                        AppMethodBeat.m2504i(132317);
                        if (!(c7472b.fsH.fsP instanceof btd)) {
                            dMo.mo11582cR(new Exception("Invalid ResponseProtoBuf"));
                            AppMethodBeat.m2505o(132317);
                        } else if (C42597a.m75414a(i, i2, (btd) c7472b.fsH.fsP)) {
                            dMo.mo11581B(c7472b.fsH.fsP);
                            AppMethodBeat.m2505o(132317);
                        } else {
                            dMo.mo11582cR(new IllegalArgumentException(String.format(Locale.US, "Invalid response, %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str})));
                            AppMethodBeat.m2505o(132317);
                        }
                    }
                });
                AppMethodBeat.m2505o(132318);
                return null;
            }
        });
        AppMethodBeat.m2505o(132319);
        return g;
    }
}
