package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import a.a.p;
import a.a.q;
import a.a.t;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\n\u0010\u001d\u001a\u00020\u001e\"\u00020\u0006H\u0007J&\u0010\u001f\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0003J\b\u0010#\u001a\u00020\u001aH\u0007J\b\u0010$\u001a\u00020\u001aH\u0003J\b\u0010%\u001a\u00020\u001aH\u0007J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0006H\u0007J\b\u0010)\u001a\u00020\u0004H\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0006H\u0007J\b\u0010,\u001a\u00020\u0004H\u0007J\b\u0010-\u001a\u00020\u0004H\u0007J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0004H\u0007J\u001a\u00101\u001a\u00020+2\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0004H\u0002J\u0016\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u0002062\u0006\u00108\u001a\u00020+H\u0003J\u0010\u00109\u001a\u0002062\u0006\u0010(\u001a\u00020\u0006H\u0003J\u0018\u0010:\u001a\u00020\u001a2\u0006\u00108\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0006H\u0003J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0006H\u0007J\u0010\u0010=\u001a\u00020\u001a2\u0006\u00108\u001a\u00020+H\u0007J\u0018\u0010>\u001a\u0002062\u0006\u00108\u001a\u00020+2\u0006\u0010?\u001a\u00020+H\u0002J\u0018\u0010@\u001a\u0002062\u0006\u00108\u001a\u00020+2\u0006\u0010?\u001a\u00020+H\u0002J\u0014\u0010A\u001a\u00020\u001a*\u00020+2\u0006\u0010B\u001a\u00020\u0004H\u0002J\u001c\u0010C\u001a\u00020+*\u00020+2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\r8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "supportTmplList", "", "[Ljava/lang/Integer;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "tmplType", "getHARDCODE_URL", "getLatestTmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "tmplInfo", "needCheck", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "updateTmplInfo", "verify", "standard", "verifyVersion", "appendToList", "key", "parseFrom", "type", "uid", "plugin-brandservice_release"})
public final class b {
    private static final String PREFIX = PREFIX;
    private static final Integer[] jTD = new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)};
    private static final int jTE = jTE;
    private static final ConcurrentHashMap<Integer, Long> jTF = new ConcurrentHashMap();
    private static final ArrayList<Integer> jTG = new ArrayList();
    public static final b jTH = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ int jTL;

        d(int i) {
            this.jTL = i;
        }

        public final void run() {
            AppMethodBeat.i(14986);
            as aXy = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy();
            b bVar = b.jTH;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(aXy, b.sy(this.jTL));
            if (this.jTL == 0) {
                PreloadLogic.aXo();
            }
            AppMethodBeat.o(14986);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "checkTmplVerRespCgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplVerResp;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<ry>> {
        final /* synthetic */ int jKl;
        final /* synthetic */ LinkedList jTI;

        a(int i, LinkedList linkedList) {
            this.jKl = i;
            this.jTI = linkedList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0099 A:{LOOP_END, LOOP:1: B:24:0x0093->B:26:0x0099} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(14980);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.Preload.TmplInfoManager", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
            Iterator it;
            if (aVar.errType == 0 && aVar.errCode == 0 && aVar.fsy != null) {
                if (((ry) aVar.fsy).vZp > 0) {
                    b.su(((ry) aVar.fsy).vZp);
                }
                if (((ry) aVar.fsy).vZo == null || ((ry) aVar.fsy).vZo.size() > 0) {
                    it = ((ry) aVar.fsy).vZo.iterator();
                    while (it.hasNext()) {
                        chi chi = (chi) it.next();
                        if (chi != null) {
                            b.a(chi, this.jKl);
                            b.j(chi);
                        }
                    }
                    com.tencent.mm.plugin.webview.preload.a.kT(1);
                    it = this.jTI.iterator();
                    while (it.hasNext()) {
                    }
                } else {
                    ab.w("MicroMsg.Preload.TmplInfoManager", "cgi back tmplInfoList is empty, return");
                }
            } else {
                com.tencent.mm.plugin.webview.preload.a.kT(2);
                it = this.jTI.iterator();
                while (it.hasNext()) {
                    rw rwVar = (rw) it.next();
                    b bVar = b.jTH;
                    b.jTG.remove(Integer.valueOf(rwVar.jCt));
                }
            }
            AppMethodBeat.o(14980);
            return null;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b jTJ = new b();

        static {
            AppMethodBeat.i(14982);
            AppMethodBeat.o(14982);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(14981);
            b.aXD();
            AppMethodBeat.o(14981);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Ljava/io/File;", "invoke"})
    static final class c extends k implements m<ArrayList<String>, File, Boolean> {
        public static final c jTK = new c();

        static {
            AppMethodBeat.i(14985);
            AppMethodBeat.o(14985);
        }

        c() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(14983);
            Boolean valueOf = Boolean.valueOf(a((ArrayList) obj, (File) obj2));
            AppMethodBeat.o(14983);
            return valueOf;
        }

        public static boolean a(ArrayList<String> arrayList, File file) {
            AppMethodBeat.i(14984);
            j.p(arrayList, "receiver$0");
            j.p(file, "file");
            boolean contains = arrayList.contains(file.getAbsolutePath() + (file.isDirectory() ? "/" : ""));
            AppMethodBeat.o(14984);
            return contains;
        }
    }

    static {
        AppMethodBeat.i(15003);
        AppMethodBeat.o(15003);
    }

    private b() {
    }

    public static final /* synthetic */ String sy(int i) {
        AppMethodBeat.i(15005);
        String st = st(i);
        AppMethodBeat.o(15005);
        return st;
    }

    private static String st(int i) {
        AppMethodBeat.i(14987);
        String concat = "_tmpl_download_time_".concat(String.valueOf(i));
        AppMethodBeat.o(14987);
        return concat;
    }

    public static void a(TmplParams tmplParams, boolean z) {
        AppMethodBeat.i(14988);
        j.p(tmplParams, "tmplParams");
        String str = "_tmpl_info_inject_fail_-" + tmplParams.jSV + '-' + tmplParams.jSY;
        if (z) {
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().removeValueForKey(str);
            AppMethodBeat.o(14988);
            return;
        }
        int i = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getInt(str, 0) + 1;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().putInt(str, i);
        ab.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + tmplParams.jSV + ',' + tmplParams.jSY + ',' + i);
        if (i > 2) {
            com.tencent.mm.plugin.webview.preload.a.kT(219);
            ab.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + tmplParams.jSV + ',' + tmplParams.jSY + ',' + i);
        }
        AppMethodBeat.o(14988);
    }

    public static final void a(int i, String str, int... iArr) {
        AppMethodBeat.i(14989);
        j.p(str, DownloadInfo.NETTYPE);
        j.p(iArr, "tmplTypes");
        if (at.is2G(ah.getContext())) {
            ab.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
            AppMethodBeat.o(14989);
            return;
        }
        Object obj;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        if (f.IS_FLAVOR_RED || h.aXn().getInt("preload_type", 1) != 3) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.de("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
            AppMethodBeat.o(14989);
            return;
        }
        if (i == -1) {
            jTF.clear();
        }
        LinkedList linkedList = new LinkedList();
        Integer[] numArr = jTD;
        Collection arrayList = new ArrayList();
        for (Object obj2 : numArr) {
            boolean z;
            int intValue = ((Number) obj2).intValue();
            long j = 0;
            if (jTF.containsKey(Integer.valueOf(intValue))) {
                Object obj3 = jTF.get(Integer.valueOf(intValue));
                if (obj3 == null) {
                    j.dWJ();
                }
                j = ((Number) obj3).longValue();
            }
            if (jTG.contains(Integer.valueOf(intValue))) {
                ab.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", Integer.valueOf(intValue));
                z = false;
            } else {
                z = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.C(j, com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getLong("_check_time_colddown", (long) jTE));
            }
            if (z) {
                arrayList.add(obj2);
            }
        }
        for (Number intValue2 : (List) arrayList) {
            int intValue3 = intValue2.intValue();
            jTG.add(Integer.valueOf(intValue3));
            jTF.put(Integer.valueOf(intValue3), Long.valueOf(System.currentTimeMillis()));
            rw rwVar = new rw();
            rwVar.jCt = intValue3;
            if (PreloadLogic.rW(101)) {
                rwVar.vZj = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXx();
            }
            linkedList.add(rwVar);
            chi sw = sw(intValue3);
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.a(sw)) {
                List list;
                if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FS(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b(sw))) {
                    rwVar.vZi = sw.wld;
                }
                Set stringSet = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getStringSet(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.h(sw), null);
                if (stringSet != null) {
                    Iterable iterable = stringSet;
                    arrayList = new ArrayList();
                    for (Object obj22 : iterable) {
                        String str2 = (String) obj22;
                        chi chi = new chi();
                        j.o(str2, "it");
                        if (a(a(chi, intValue3, str2), sw)) {
                            arrayList.add(obj22);
                        }
                    }
                    list = (List) arrayList;
                } else {
                    list = null;
                }
                arrayList = list;
                obj = (arrayList == null || arrayList.isEmpty()) ? 1 : null;
                if (obj == null) {
                    rwVar.vZh.addAll(list);
                }
            }
        }
        if (linkedList.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            com.tencent.mm.plugin.webview.preload.a.kT(0);
            new a(linkedList, i, str).acy().g(new a(i, linkedList));
        }
        AppMethodBeat.o(14989);
    }

    public static final void clear() {
        AppMethodBeat.i(14990);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().clear();
        e.t(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FR(aXA()));
        e.cu(com.tencent.mm.loader.j.b.eSj + "/jscache/");
        AppMethodBeat.o(14990);
    }

    public static final void su(int i) {
        AppMethodBeat.i(14991);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().putLong("_check_time_colddown", (long) (i * 1000));
        AppMethodBeat.o(14991);
    }

    public static final void j(chi chi) {
        AppMethodBeat.i(14992);
        j.p(chi, "tmplInfo");
        String e = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.e(chi);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().putString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.ss(chi.jCt), chi.wld);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.f(chi));
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.g(chi));
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().encode(e, chi.toByteArray());
        String h = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.h(chi);
        as aXy = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy();
        Set stringSet = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getStringSet(h, null);
        if (stringSet == null) {
            stringSet = new HashSet();
        }
        stringSet.add(chi.wld);
        aXy.putStringSet(h, stringSet);
        AppMethodBeat.o(14992);
    }

    private static chi a(chi chi, int i, String str) {
        int i2 = 1;
        AppMethodBeat.i(14993);
        chi.jCt = i;
        chi.wld = str;
        byte[] decodeBytes = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().decodeBytes(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.e(chi));
        j.o(decodeBytes, "bytes");
        if ((decodeBytes.length == 0 ? 1 : 0) != 0) {
            i2 = 0;
        }
        if (i2 != 0) {
            try {
                chi.parseFrom(decodeBytes);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e, "decode TmplInfo:" + i + ", " + str, new Object[0]);
            }
        }
        AppMethodBeat.o(14993);
        return chi;
    }

    private static boolean a(chi chi, chi chi2) {
        AppMethodBeat.i(14994);
        if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FR(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b(chi)).exists()) {
            ab.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + chi.wld);
        } else if (b(chi, chi2)) {
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().putString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.f(chi), chi.wld);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy(), com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.g(chi));
            AppMethodBeat.o(14994);
            return true;
        } else {
            if (j.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.e(chi), com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.f(chi), null))) {
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.f(chi));
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.g(chi));
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().remove(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.e(chi));
            String h = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.h(chi2);
            Set stringSet = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getStringSet(h, null);
            if (stringSet != null) {
                stringSet.remove(chi.wld);
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().putStringSet(h, stringSet);
            }
            ab.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + chi.wld + " is invalid");
        }
        AppMethodBeat.o(14994);
        return false;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code skipped:
            if (r0 > 0) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(chi chi, chi chi2) {
        AppMethodBeat.i(14995);
        if (!j.j(chi, chi2) || chi.Version == 0) {
            int aXj;
            int i = chi2.vZn;
            if (ab.getLogLevel() == 0) {
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
                aXj = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXj();
            }
            aXj = i;
            if (chi.Version < aXj) {
                ab.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + chi.wld + " version:" + chi.Version + " < " + aXj);
                AppMethodBeat.o(14995);
                return false;
            }
            LinkedList<chj> linkedList = chi2.xge;
            j.o(linkedList, "standard.VersionControlList");
            for (chj chj : linkedList) {
                if (j.j(chj.wld, chi.wld)) {
                    ab.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + chj.wld + " matchControls in forceH5:" + chj.xgg);
                    if (chj.xgg) {
                        AppMethodBeat.o(14995);
                        return false;
                    }
                    AppMethodBeat.o(14995);
                    return true;
                }
            }
            AppMethodBeat.o(14995);
            return true;
        }
        AppMethodBeat.o(14995);
        return true;
    }

    public static final chi sv(int i) {
        AppMethodBeat.i(14996);
        chi chi = new chi();
        String string = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.ss(i), null);
        if (string != null) {
            j.o(string, "uid");
            a(chi, i, string);
        }
        AppMethodBeat.o(14996);
        return chi;
    }

    private static /* synthetic */ chi sw(int i) {
        AppMethodBeat.i(14998);
        chi an = an(i, "");
        AppMethodBeat.o(14998);
        return an;
    }

    private static chi an(int i, String str) {
        chi a;
        AppMethodBeat.i(14997);
        chi sv = sv(i);
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.a(sv)) {
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FS(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b(sv)) || (j.j(sv.wld, str) ^ 1) == 0) {
                String string = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.f(sv), null);
                if (string != null) {
                    chi chi = new chi();
                    j.o(string, "it");
                    a = a(chi, i, string);
                    if (!(a == null || !com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.a(a) || com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.i(a) || !com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FS(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b(a)) || (j.j(a.wld, str) ^ 1) == 0)) {
                        AppMethodBeat.o(14997);
                        return a;
                    }
                }
                Set stringSet = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getStringSet(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.h(sv), null);
                if (stringSet != null) {
                    Iterable iterable = stringSet;
                    j.p(iterable, "receiver$0");
                    a.b.f fVar = a.b.f.AUW;
                    v vVar;
                    if (fVar == null) {
                        vVar = new v("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
                        AppMethodBeat.o(14997);
                        throw vVar;
                    }
                    Comparator comparator = fVar;
                    j.p(iterable, "receiver$0");
                    j.p(comparator, "comparator");
                    List n;
                    if (!(iterable instanceof Collection)) {
                        n = t.n(iterable);
                        p.a(n, comparator);
                    } else if (((Collection) iterable).size() <= 1) {
                        n = t.m(iterable);
                    } else {
                        Object[] toArray = ((Collection) iterable).toArray(new Object[0]);
                        if (toArray == null) {
                            vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.o(14997);
                            throw vVar;
                        } else if (toArray == null) {
                            vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.o(14997);
                            throw vVar;
                        } else {
                            a.a.h.a(toArray, comparator);
                            n = a.a.h.asList(toArray);
                        }
                    }
                    if (n != null) {
                        for (String string2 : n) {
                            if ((j.j(string2, str) ^ 1) != 0) {
                                chi chi2 = new chi();
                                j.o(string2, "uid");
                                a = a(chi2, i, string2);
                                if (a(a, sv)) {
                                    AppMethodBeat.o(14997);
                                    return a;
                                }
                            }
                        }
                    }
                }
            } else {
                AppMethodBeat.o(14997);
                return sv;
            }
        }
        a = new chi();
        AppMethodBeat.o(14997);
        return a;
    }

    private static final synchronized boolean k(chi chi) {
        boolean z = false;
        synchronized (b.class) {
            AppMethodBeat.i(14999);
            if (chi == null) {
                ab.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
                AppMethodBeat.o(14999);
            } else if (sv(chi.jCt).Version != chi.Version) {
                AppMethodBeat.o(14999);
            } else if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FS(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b(chi))) {
                z = true;
                AppMethodBeat.o(14999);
            } else {
                ab.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
                AppMethodBeat.o(14999);
            }
        }
        return z;
    }

    public static final void aXz() {
        AppMethodBeat.i(15000);
        com.tencent.mm.sdk.g.d.xDG.b(b.jTJ, "tmplPreload");
        AppMethodBeat.o(15000);
    }

    public static final TmplParams sx(int i) {
        AppMethodBeat.i(15001);
        chi sw = sw(i);
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.a(sw)) {
            String c = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.c(sw);
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FS(c)) {
                com.tencent.mm.plugin.webview.preload.TmplParams.a aeZ = new com.tencent.mm.plugin.webview.preload.TmplParams.a().IW(i).IX(sw.Version).aeY(sw.Md5).aeX(c).aeW(new StringBuilder(PREFIX).append(i).append('_').append(sw.wld).append(".html").append((j.j(PREFIX, PREFIX) ^ 1) != 0 ? "?prefix=" + URLEncoder.encode(PREFIX) : "").toString()).IY(sw.wUX).lR(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getLong(st(sw.jCt), 0)).aeZ(sw.wld);
                LinkedList linkedList = sw.xgc;
                j.o(linkedList, "tmplInfo.HttpHeaderList");
                Iterable<chh> iterable = linkedList;
                StringBuilder stringBuilder = new StringBuilder();
                for (chh chh : iterable) {
                    StringBuilder append = stringBuilder.append(new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(chh.vMU).append(':').append(chh.pXM).toString());
                    j.o(append, "sb.append(\"\\n${header.Key}:${header.Value}\")");
                    stringBuilder = append;
                }
                TmplParams cYS = aeZ.afa(stringBuilder.toString()).cYS();
                AppMethodBeat.o(15001);
                return cYS;
            }
            ab.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + c + " is null");
            com.tencent.mm.plugin.webview.preload.a.gu(sw.wUX, 100);
            AppMethodBeat.o(15001);
            return null;
        }
        ab.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + i + " localTmplInfo is null");
        com.tencent.mm.plugin.webview.preload.a.kT(100);
        AppMethodBeat.o(15001);
        return null;
    }

    public static final String aXA() {
        AppMethodBeat.i(15002);
        String str = com.tencent.mm.compatible.util.e.eSj + "webview_tmpl/";
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXi()) {
            str = com.tencent.mm.compatible.util.e.eSn;
            j.o(str, "CConstants.DATAROOT_SDCARD_PATH");
        }
        if (!u.jc(str, "/")) {
            str = str + "/";
        }
        str = str + "tmpls/";
        com.tencent.mm.sdk.platformtools.j.aih(str);
        AppMethodBeat.o(15002);
        return str;
    }

    public static final String aXB() {
        return PREFIX;
    }

    public static final String getPrefix() {
        return PREFIX;
    }

    public static final /* synthetic */ void aXD() {
        String str;
        AppMethodBeat.i(15006);
        ab.i("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl saveDir:%s", aXA());
        File FR = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FR(str);
        if (!FR.exists()) {
            ab.w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not exist, err", str);
            AppMethodBeat.o(15006);
        } else if (FR.isDirectory()) {
            File[] listFiles = FR.listFiles();
            if (listFiles != null) {
                int i;
                if (listFiles.length == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i == 0 ? 1 : 0) != 0) {
                    int intValue;
                    if (f.DEBUG) {
                        ab.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl oldCount %d", Integer.valueOf(listFiles.length));
                        for (Object obj : listFiles) {
                            Object[] objArr = new Object[1];
                            j.o(obj, "file");
                            objArr[0] = obj.getName();
                            ab.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl file:%s", objArr);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    Integer[] numArr = jTD;
                    Collection arrayList2 = new ArrayList();
                    for (Integer intValue2 : numArr) {
                        Set stringSet = com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.aXy().getStringSet(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.h(sv(intValue2.intValue())), new HashSet());
                        if (stringSet == null) {
                            j.dWJ();
                        }
                        j.o(stringSet, "kvTmpl.getStringSet(\n   …keyVersions, HashSet())!!");
                        Iterable<String> m = t.m(stringSet);
                        Collection arrayList3 = new ArrayList(a.a.m.d(m));
                        for (String str2 : m) {
                            arrayList3.add(a.a.l.listOf(Integer.valueOf(r10), str2));
                        }
                        q.a(arrayList2, (Iterable) (List) arrayList3);
                    }
                    for (List list : (List) arrayList2) {
                        Object obj2 = list.get(0);
                        v vVar;
                        if (obj2 == null) {
                            vVar = new v("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(15006);
                            throw vVar;
                        }
                        intValue = ((Integer) obj2).intValue();
                        Object obj3 = list.get(1);
                        if (obj3 == null) {
                            vVar = new v("null cannot be cast to non-null type kotlin.String");
                            AppMethodBeat.o(15006);
                            throw vVar;
                        }
                        chi a = a(new chi(), intValue, (String) obj3);
                        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.a(a)) {
                            arrayList.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b(a));
                        }
                    }
                    if (f.DEBUG) {
                        ab.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl curFilePaths %s", arrayList);
                    }
                    c cVar = c.jTK;
                    ArrayList arrayList4 = new ArrayList();
                    for (File file : listFiles) {
                        long lastModified = file.lastModified();
                        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.C(lastModified, 604800000)) {
                            j.o(file, "file");
                            if (!c.a(arrayList, file)) {
                                arrayList4.add(file.getAbsolutePath());
                            }
                        }
                        if (f.DEBUG && com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.C(lastModified, 60000)) {
                            j.o(file, "file");
                            if (!c.a(arrayList, file)) {
                                arrayList4.add(file.getAbsolutePath());
                            }
                        }
                    }
                    if (1 >= ab.getLogLevel()) {
                        ab.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl deleteFilePaths %s", arrayList4);
                    }
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        str = (String) it.next();
                        j.o(str, "filePath");
                        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.FR(str).isDirectory()) {
                            FileOp.tg(str);
                        } else {
                            FileOp.deleteFile(str);
                        }
                    }
                    AppMethodBeat.o(15006);
                }
            }
            ab.w("MicroMsg.Preload.TmplInfoManager", "files is null");
            AppMethodBeat.o(15006);
        } else {
            ab.w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not dir, err", str);
            AppMethodBeat.o(15006);
        }
    }
}
