package com.tencent.mm.plugin.appbrand.config;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class l {

    public static class a {
        private static String aS(String str, int i) {
            AppMethodBeat.i(129855);
            String format = String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
            AppMethodBeat.o(129855);
            return format;
        }

        private static String aT(String str, int i) {
            AppMethodBeat.i(129856);
            String format = String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
            AppMethodBeat.o(129856);
            return format;
        }

        private static String aU(String str, int i) {
            AppMethodBeat.i(129857);
            String format = String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
            AppMethodBeat.o(129857);
            return format;
        }

        public static void C(String str, int i, int i2) {
            AppMethodBeat.i(129858);
            if (f.xH() == null) {
                AppMethodBeat.o(129858);
                return;
            }
            f.xH().bG(aS(str, i), String.valueOf(i2));
            AppMethodBeat.o(129858);
        }

        public static void D(String str, int i, int i2) {
            AppMethodBeat.i(129859);
            if (f.xH() == null) {
                AppMethodBeat.o(129859);
                return;
            }
            f.xH().bG(aT(str, i), String.valueOf(i2));
            AppMethodBeat.o(129859);
        }

        public static void h(String str, int i, String str2) {
            AppMethodBeat.i(129860);
            if (f.xH() == null) {
                AppMethodBeat.o(129860);
                return;
            }
            f.xH().bG(aU(str, i), str2);
            AppMethodBeat.o(129860);
        }

        public static int aV(String str, int i) {
            AppMethodBeat.i(129861);
            if (f.xH() == null) {
                AppMethodBeat.o(129861);
                return 0;
            }
            int i2 = bo.getInt(f.xH().get(aS(str, i), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            AppMethodBeat.o(129861);
            return i2;
        }

        public static int aW(String str, int i) {
            AppMethodBeat.i(129862);
            if (f.xH() == null) {
                AppMethodBeat.o(129862);
                return 0;
            }
            int i2 = bo.getInt(f.xH().get(aT(str, i), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            AppMethodBeat.o(129862);
            return i2;
        }

        public static String aX(String str, int i) {
            AppMethodBeat.i(129863);
            String str2;
            if (f.xH() == null) {
                str2 = "";
                AppMethodBeat.o(129863);
                return str2;
            }
            str2 = f.xH().get(aU(str, i), "");
            AppMethodBeat.o(129863);
            return str2;
        }
    }

    public interface b {
        void a(int i, int i2, String str, com.tencent.mm.ai.b bVar);
    }

    public interface c {
        void xC(String str);
    }

    public static void b(String str, LinkedList<cnp> linkedList) {
        AppMethodBeat.i(129864);
        a(str, linkedList, true);
        AppMethodBeat.o(129864);
    }

    public static void a(final String str, LinkedList<cnp> linkedList, boolean z) {
        AppMethodBeat.i(129865);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
            AppMethodBeat.o(129865);
        } else if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
            AppMethodBeat.o(129865);
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cnp cnp = (cnp) it.next();
                ab.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", Integer.valueOf(cnp.version), Integer.valueOf(cnp.type));
                int aV = a.aV(str, cnp.type);
                int i = cnp.version;
                a.D(str, cnp.type, i);
                if (i != 0) {
                    if (i > aV) {
                        linkedList2.add(B(str, cnp.type, cnp.version));
                    } else if (i != aV) {
                        ab.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", Integer.valueOf(aV), Integer.valueOf(i));
                        if (bo.isNullOrNil(a.aX(str, cnp.type))) {
                            linkedList2.add(B(str, cnp.type, cnp.version));
                        }
                    } else if (bo.isNullOrNil(a.aX(str, cnp.type))) {
                        linkedList2.add(B(str, cnp.type, cnp.version));
                    }
                }
            }
            ab.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (z) {
                if (linkedList2.size() == 0) {
                    AppMethodBeat.o(129865);
                    return;
                }
                ab.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", str);
                a(linkedList2, new b() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                        AppMethodBeat.i(129852);
                        if (i == 0 && i2 == 0) {
                            aee aee = (aee) bVar.fsH.fsP;
                            if (aee.wmh == null || aee.wmh.size() == 0) {
                                ab.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                                AppMethodBeat.o(129852);
                                return;
                            }
                            ab.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", Integer.valueOf(aee.wmh.size()));
                            Iterator it = aee.wmh.iterator();
                            while (it.hasNext()) {
                                do doVar = (do) it.next();
                                ab.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", doVar.vFt, Integer.valueOf(doVar.vFs));
                                if (!bo.isNullOrNil(doVar.vFt)) {
                                    a.C(str, doVar.jCt, doVar.vFs);
                                    a.D(str, doVar.jCt, doVar.vFs);
                                    a.h(str, doVar.jCt, doVar.vFt);
                                }
                            }
                            AppMethodBeat.o(129852);
                            return;
                        }
                        ab.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        AppMethodBeat.o(129852);
                    }
                });
            }
            AppMethodBeat.o(129865);
        }
    }

    private static aec B(String str, int i, int i2) {
        AppMethodBeat.i(129866);
        aec aec = new aec();
        aec.fKh = str;
        aec.jCt = i;
        aec.vFs = i2;
        AppMethodBeat.o(129866);
        return aec;
    }

    public static String a(final String str, int i, int i2, final c cVar, boolean z) {
        AppMethodBeat.i(129867);
        if (f.xH() == null) {
            String str2 = "";
            AppMethodBeat.o(129867);
            return str2;
        }
        int aV = a.aV(str, i);
        int aW = a.aW(str, i);
        String aX = a.aX(str, i);
        boolean z2 = aW != 0 && (bo.isNullOrNil(aX) || aW > aV);
        ab.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", Integer.valueOf(aW), Integer.valueOf(aV));
        ab.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", aX, Boolean.valueOf(z2));
        if (!z2) {
            cVar.xC(aX);
        } else if (z) {
            a(str, i, aW, i2, new b() {
                public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                    AppMethodBeat.i(129853);
                    if (i == 0 && i2 == 0) {
                        aee aee = (aee) bVar.fsH.fsP;
                        if (aee.wmh == null || aee.wmh.size() == 0) {
                            ab.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                            if (cVar != null) {
                                cVar.xC("");
                            }
                            AppMethodBeat.o(129853);
                            return;
                        }
                        do doVar = (do) aee.wmh.get(0);
                        ab.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", doVar.vFt, Integer.valueOf(doVar.vFs));
                        if (!bo.isNullOrNil(doVar.vFt)) {
                            a.C(str, doVar.jCt, doVar.vFs);
                            a.D(str, doVar.jCt, doVar.vFs);
                            a.h(str, doVar.jCt, doVar.vFt);
                            if (cVar != null) {
                                cVar.xC(doVar.vFt);
                                AppMethodBeat.o(129853);
                                return;
                            }
                        } else if (cVar != null) {
                            cVar.xC("");
                        }
                        AppMethodBeat.o(129853);
                        return;
                    }
                    ab.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (cVar != null) {
                        cVar.xC("");
                    }
                    AppMethodBeat.o(129853);
                }
            });
        }
        AppMethodBeat.o(129867);
        return aX;
    }

    private static void a(String str, int i, int i2, int i3, b bVar) {
        AppMethodBeat.i(129868);
        LinkedList linkedList = new LinkedList();
        aec aec = new aec();
        aec.fKh = str;
        aec.jCt = i;
        aec.vFs = i2;
        aec.wmf = i3;
        linkedList.add(aec);
        a(linkedList, bVar);
        AppMethodBeat.o(129868);
    }

    private static void a(LinkedList<aec> linkedList, final b bVar) {
        AppMethodBeat.i(129869);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.fsK = new aee();
        aVar.fsL = 0;
        aVar.fsM = 0;
        aed aed = new aed();
        aed.wmg = linkedList;
        aVar.fsJ = aed;
        w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(129854);
                if (bVar != null) {
                    bVar.a(i, i2, str, bVar);
                }
                AppMethodBeat.o(129854);
                return 0;
            }
        }, true);
        AppMethodBeat.o(129869);
    }
}
