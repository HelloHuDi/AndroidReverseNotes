package com.tencent.p177mm.plugin.appbrand.config;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.protocal.protobuf.C30176do;
import com.tencent.p177mm.protocal.protobuf.aec;
import com.tencent.p177mm.protocal.protobuf.aed;
import com.tencent.p177mm.protocal.protobuf.aee;
import com.tencent.p177mm.protocal.protobuf.cnp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.config.l */
public final class C45535l {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.l$a */
    public static class C19157a {
        /* renamed from: aS */
        private static String m29809aS(String str, int i) {
            AppMethodBeat.m2504i(129855);
            String format = String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
            AppMethodBeat.m2505o(129855);
            return format;
        }

        /* renamed from: aT */
        private static String m29810aT(String str, int i) {
            AppMethodBeat.m2504i(129856);
            String format = String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
            AppMethodBeat.m2505o(129856);
            return format;
        }

        /* renamed from: aU */
        private static String m29811aU(String str, int i) {
            AppMethodBeat.m2504i(129857);
            String format = String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
            AppMethodBeat.m2505o(129857);
            return format;
        }

        /* renamed from: C */
        public static void m29807C(String str, int i, int i2) {
            AppMethodBeat.m2504i(129858);
            if (C42340f.m74880xH() == null) {
                AppMethodBeat.m2505o(129858);
                return;
            }
            C42340f.m74880xH().mo53682bG(C19157a.m29809aS(str, i), String.valueOf(i2));
            AppMethodBeat.m2505o(129858);
        }

        /* renamed from: D */
        public static void m29808D(String str, int i, int i2) {
            AppMethodBeat.m2504i(129859);
            if (C42340f.m74880xH() == null) {
                AppMethodBeat.m2505o(129859);
                return;
            }
            C42340f.m74880xH().mo53682bG(C19157a.m29810aT(str, i), String.valueOf(i2));
            AppMethodBeat.m2505o(129859);
        }

        /* renamed from: h */
        public static void m29815h(String str, int i, String str2) {
            AppMethodBeat.m2504i(129860);
            if (C42340f.m74880xH() == null) {
                AppMethodBeat.m2505o(129860);
                return;
            }
            C42340f.m74880xH().mo53682bG(C19157a.m29811aU(str, i), str2);
            AppMethodBeat.m2505o(129860);
        }

        /* renamed from: aV */
        public static int m29812aV(String str, int i) {
            AppMethodBeat.m2504i(129861);
            if (C42340f.m74880xH() == null) {
                AppMethodBeat.m2505o(129861);
                return 0;
            }
            int i2 = C5046bo.getInt(C42340f.m74880xH().get(C19157a.m29809aS(str, i), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            AppMethodBeat.m2505o(129861);
            return i2;
        }

        /* renamed from: aW */
        public static int m29813aW(String str, int i) {
            AppMethodBeat.m2504i(129862);
            if (C42340f.m74880xH() == null) {
                AppMethodBeat.m2505o(129862);
                return 0;
            }
            int i2 = C5046bo.getInt(C42340f.m74880xH().get(C19157a.m29810aT(str, i), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            AppMethodBeat.m2505o(129862);
            return i2;
        }

        /* renamed from: aX */
        public static String m29814aX(String str, int i) {
            AppMethodBeat.m2504i(129863);
            String str2;
            if (C42340f.m74880xH() == null) {
                str2 = "";
                AppMethodBeat.m2505o(129863);
                return str2;
            }
            str2 = C42340f.m74880xH().get(C19157a.m29811aU(str, i), "");
            AppMethodBeat.m2505o(129863);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.l$b */
    public interface C19158b {
        /* renamed from: a */
        void mo34394a(int i, int i2, String str, C7472b c7472b);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.l$c */
    public interface C42404c {
        /* renamed from: xC */
        void mo53649xC(String str);
    }

    /* renamed from: b */
    public static void m83975b(String str, LinkedList<cnp> linkedList) {
        AppMethodBeat.m2504i(129864);
        C45535l.m83973a(str, linkedList, true);
        AppMethodBeat.m2505o(129864);
    }

    /* renamed from: a */
    public static void m83973a(final String str, LinkedList<cnp> linkedList, boolean z) {
        AppMethodBeat.m2504i(129865);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
            AppMethodBeat.m2505o(129865);
        } else if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
            AppMethodBeat.m2505o(129865);
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cnp cnp = (cnp) it.next();
                C4990ab.m7411d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", Integer.valueOf(cnp.version), Integer.valueOf(cnp.type));
                int aV = C19157a.m29812aV(str, cnp.type);
                int i = cnp.version;
                C19157a.m29808D(str, cnp.type, i);
                if (i != 0) {
                    if (i > aV) {
                        linkedList2.add(C45535l.m83970B(str, cnp.type, cnp.version));
                    } else if (i != aV) {
                        C4990ab.m7417i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", Integer.valueOf(aV), Integer.valueOf(i));
                        if (C5046bo.isNullOrNil(C19157a.m29814aX(str, cnp.type))) {
                            linkedList2.add(C45535l.m83970B(str, cnp.type, cnp.version));
                        }
                    } else if (C5046bo.isNullOrNil(C19157a.m29814aX(str, cnp.type))) {
                        linkedList2.add(C45535l.m83970B(str, cnp.type, cnp.version));
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (z) {
                if (linkedList2.size() == 0) {
                    AppMethodBeat.m2505o(129865);
                    return;
                }
                C4990ab.m7411d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", str);
                C45535l.m83974a(linkedList2, new C19158b() {
                    /* renamed from: a */
                    public final void mo34394a(int i, int i2, String str, C7472b c7472b) {
                        AppMethodBeat.m2504i(129852);
                        if (i == 0 && i2 == 0) {
                            aee aee = (aee) c7472b.fsH.fsP;
                            if (aee.wmh == null || aee.wmh.size() == 0) {
                                C4990ab.m7412e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                                AppMethodBeat.m2505o(129852);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", Integer.valueOf(aee.wmh.size()));
                            Iterator it = aee.wmh.iterator();
                            while (it.hasNext()) {
                                C30176do c30176do = (C30176do) it.next();
                                C4990ab.m7417i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", c30176do.vFt, Integer.valueOf(c30176do.vFs));
                                if (!C5046bo.isNullOrNil(c30176do.vFt)) {
                                    C19157a.m29807C(str, c30176do.jCt, c30176do.vFs);
                                    C19157a.m29808D(str, c30176do.jCt, c30176do.vFs);
                                    C19157a.m29815h(str, c30176do.jCt, c30176do.vFt);
                                }
                            }
                            AppMethodBeat.m2505o(129852);
                            return;
                        }
                        C4990ab.m7413e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        AppMethodBeat.m2505o(129852);
                    }
                });
            }
            AppMethodBeat.m2505o(129865);
        }
    }

    /* renamed from: B */
    private static aec m83970B(String str, int i, int i2) {
        AppMethodBeat.m2504i(129866);
        aec aec = new aec();
        aec.fKh = str;
        aec.jCt = i;
        aec.vFs = i2;
        AppMethodBeat.m2505o(129866);
        return aec;
    }

    /* renamed from: a */
    public static String m83971a(final String str, int i, int i2, final C42404c c42404c, boolean z) {
        AppMethodBeat.m2504i(129867);
        if (C42340f.m74880xH() == null) {
            String str2 = "";
            AppMethodBeat.m2505o(129867);
            return str2;
        }
        int aV = C19157a.m29812aV(str, i);
        int aW = C19157a.m29813aW(str, i);
        String aX = C19157a.m29814aX(str, i);
        boolean z2 = aW != 0 && (C5046bo.isNullOrNil(aX) || aW > aV);
        C4990ab.m7417i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", Integer.valueOf(aW), Integer.valueOf(aV));
        C4990ab.m7417i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", aX, Boolean.valueOf(z2));
        if (!z2) {
            c42404c.mo53649xC(aX);
        } else if (z) {
            C45535l.m83972a(str, i, aW, i2, new C19158b() {
                /* renamed from: a */
                public final void mo34394a(int i, int i2, String str, C7472b c7472b) {
                    AppMethodBeat.m2504i(129853);
                    if (i == 0 && i2 == 0) {
                        aee aee = (aee) c7472b.fsH.fsP;
                        if (aee.wmh == null || aee.wmh.size() == 0) {
                            C4990ab.m7412e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                            if (c42404c != null) {
                                c42404c.mo53649xC("");
                            }
                            AppMethodBeat.m2505o(129853);
                            return;
                        }
                        C30176do c30176do = (C30176do) aee.wmh.get(0);
                        C4990ab.m7417i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", c30176do.vFt, Integer.valueOf(c30176do.vFs));
                        if (!C5046bo.isNullOrNil(c30176do.vFt)) {
                            C19157a.m29807C(str, c30176do.jCt, c30176do.vFs);
                            C19157a.m29808D(str, c30176do.jCt, c30176do.vFs);
                            C19157a.m29815h(str, c30176do.jCt, c30176do.vFt);
                            if (c42404c != null) {
                                c42404c.mo53649xC(c30176do.vFt);
                                AppMethodBeat.m2505o(129853);
                                return;
                            }
                        } else if (c42404c != null) {
                            c42404c.mo53649xC("");
                        }
                        AppMethodBeat.m2505o(129853);
                        return;
                    }
                    C4990ab.m7413e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (c42404c != null) {
                        c42404c.mo53649xC("");
                    }
                    AppMethodBeat.m2505o(129853);
                }
            });
        }
        AppMethodBeat.m2505o(129867);
        return aX;
    }

    /* renamed from: a */
    private static void m83972a(String str, int i, int i2, int i3, C19158b c19158b) {
        AppMethodBeat.m2504i(129868);
        LinkedList linkedList = new LinkedList();
        aec aec = new aec();
        aec.fKh = str;
        aec.jCt = i;
        aec.vFs = i2;
        aec.wmf = i3;
        linkedList.add(aec);
        C45535l.m83974a(linkedList, c19158b);
        AppMethodBeat.m2505o(129868);
    }

    /* renamed from: a */
    private static void m83974a(LinkedList<aec> linkedList, final C19158b c19158b) {
        AppMethodBeat.m2504i(129869);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1138;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        c1196a.fsK = new aee();
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        aed aed = new aed();
        aed.wmg = linkedList;
        c1196a.fsJ = aed;
        C1226w.m2655a(c1196a.acD(), new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(129854);
                if (c19158b != null) {
                    c19158b.mo34394a(i, i2, str, c7472b);
                }
                AppMethodBeat.m2505o(129854);
                return 0;
            }
        }, true);
        AppMethodBeat.m2505o(129869);
    }
}
