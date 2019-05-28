package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    public static void a(String str, String str2, int i, String str3, int i2, g gVar) {
        AppMethodBeat.i(129761);
        if (bo.isNullOrNil(str2)) {
            ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
            AppMethodBeat.o(129761);
            return;
        }
        a zi = p.zi(str2);
        if (zi != null && !zi.hbV) {
            ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", str2, Integer.valueOf(i));
            AppMethodBeat.o(129761);
        } else if (aO(str2, i)) {
            Object obj;
            Object str32;
            if (bo.isNullOrNil(str32)) {
                obj = null;
                str32 = null;
            } else {
                int lastIndexOf = str32.lastIndexOf(63);
                if (lastIndexOf > 0) {
                    String substring = str32.substring(0, lastIndexOf);
                    if (lastIndexOf < str32.length() - 1) {
                        obj = str32.substring(lastIndexOf + 1);
                        str32 = substring;
                    } else {
                        obj = null;
                        str32 = substring;
                    }
                } else {
                    obj = null;
                }
            }
            c F = a.F(str32, obj);
            String str4 = (String) F.get(0);
            String str5 = (String) F.get(1);
            ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", str2, str4, str5, Integer.valueOf(i2));
            gk gkVar = new gk();
            gkVar.csB = str;
            gkVar.username = str2;
            gkVar.vIG = 0;
            gkVar.vIH = new ble();
            gkVar.vIH.scene = i2;
            if (!bo.isNullOrNil(str4)) {
                gkVar.vIH.path = str4;
            }
            if (!bo.isNullOrNil(str5)) {
                gkVar.vIH.query = str5;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(gkVar);
            a(0, linkedList, gVar);
            AppMethodBeat.o(129761);
        } else {
            ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) is not star app", str2, Integer.valueOf(i));
            AppMethodBeat.o(129761);
        }
    }

    private static void a(final int i, List<gk> list, final i iVar) {
        AppMethodBeat.i(129762);
        if (list.isEmpty() || iVar == null) {
            ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
            AppMethodBeat.o(129762);
            return;
        }
        ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", Integer.valueOf(list.size()));
        final cxb cxb = new cxb();
        cxb.xsC.addAll(list);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 1733;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
        aVar.fsJ = cxb;
        aVar.fsK = new cxc();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                AppMethodBeat.i(129760);
                if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof cxc)) {
                    cxc cxc = (cxc) bVar.fsH.fsP;
                    if (cxc.xsD == null || cxc.xsD.isEmpty()) {
                        ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
                        iVar.onFail(i);
                        AppMethodBeat.o(129760);
                        return;
                    }
                    ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
                    iVar.e(cxc.xsD, cxb.xsC);
                    AppMethodBeat.o(129760);
                    return;
                }
                ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
                iVar.onFail(i);
                AppMethodBeat.o(129760);
            }
        });
        AppMethodBeat.o(129762);
    }

    static boolean aO(String str, int i) {
        AppMethodBeat.i(129763);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129763);
            return false;
        }
        boolean aB = ((af) g.K(af.class)).aB(str, i);
        AppMethodBeat.o(129763);
        return aB;
    }

    public static boolean a(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(129764);
        if (appBrandInitConfigWC == null || bo.isNullOrNil(appBrandInitConfigWC.appId) || h.DS(appBrandInitConfigWC.appId)) {
            AppMethodBeat.o(129764);
            return false;
        }
        AppMethodBeat.o(129764);
        return true;
    }

    static /* synthetic */ void a(Map map, i iVar) {
        AppMethodBeat.i(129765);
        if (map.isEmpty()) {
            ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataInternal, no starAppMap or no callback");
            AppMethodBeat.o(129765);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (Entry entry : map.entrySet()) {
            gk gkVar = new gk();
            gkVar.username = (String) entry.getKey();
            gkVar.csB = (String) entry.getValue();
            gkVar.vIG = 1;
            linkedList.add(gkVar);
        }
        a(1, linkedList, iVar);
        AppMethodBeat.o(129765);
    }
}
