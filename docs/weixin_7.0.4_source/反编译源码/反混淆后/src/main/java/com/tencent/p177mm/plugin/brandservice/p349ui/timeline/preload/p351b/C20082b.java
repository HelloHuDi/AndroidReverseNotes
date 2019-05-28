package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C20086l;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2710d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g.C33740a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C38709h;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C38710j;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.plugin.webview.preload.TmplParams.C29850a;
import com.tencent.p177mm.protocal.protobuf.C15383rw;
import com.tencent.p177mm.protocal.protobuf.C23436ry;
import com.tencent.p177mm.protocal.protobuf.chh;
import com.tencent.p177mm.protocal.protobuf.chi;
import com.tencent.p177mm.protocal.protobuf.chj;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.vending.p637c.C5681a;
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
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C36646h;
import p000a.p001a.C41363p;
import p000a.p001a.C44628q;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C6163u;
import p000a.p772b.C44848f;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\n\u0010\u001d\u001a\u00020\u001e\"\u00020\u0006H\u0007J&\u0010\u001f\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0003J\b\u0010#\u001a\u00020\u001aH\u0007J\b\u0010$\u001a\u00020\u001aH\u0003J\b\u0010%\u001a\u00020\u001aH\u0007J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0006H\u0007J\b\u0010)\u001a\u00020\u0004H\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0006H\u0007J\b\u0010,\u001a\u00020\u0004H\u0007J\b\u0010-\u001a\u00020\u0004H\u0007J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0004H\u0007J\u001a\u00101\u001a\u00020+2\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0004H\u0002J\u0016\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u0002062\u0006\u00108\u001a\u00020+H\u0003J\u0010\u00109\u001a\u0002062\u0006\u0010(\u001a\u00020\u0006H\u0003J\u0018\u0010:\u001a\u00020\u001a2\u0006\u00108\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0006H\u0003J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0006H\u0007J\u0010\u0010=\u001a\u00020\u001a2\u0006\u00108\u001a\u00020+H\u0007J\u0018\u0010>\u001a\u0002062\u0006\u00108\u001a\u00020+2\u0006\u0010?\u001a\u00020+H\u0002J\u0018\u0010@\u001a\u0002062\u0006\u00108\u001a\u00020+2\u0006\u0010?\u001a\u00020+H\u0002J\u0014\u0010A\u001a\u00020\u001a*\u00020+2\u0006\u0010B\u001a\u00020\u0004H\u0002J\u001c\u0010C\u001a\u00020+*\u00020+2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\r8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "supportTmplList", "", "[Ljava/lang/Integer;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "tmplType", "getHARDCODE_URL", "getLatestTmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "tmplInfo", "needCheck", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "updateTmplInfo", "verify", "standard", "verifyVersion", "appendToList", "key", "parseFrom", "type", "uid", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b */
public final class C20082b {
    private static final String PREFIX = PREFIX;
    private static final Integer[] jTD = new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)};
    private static final int jTE = jTE;
    private static final ConcurrentHashMap<Integer, Long> jTF = new ConcurrentHashMap();
    private static final ArrayList<Integer> jTG = new ArrayList();
    public static final C20082b jTH = new C20082b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b$d */
    static final class C2701d implements Runnable {
        final /* synthetic */ int jTL;

        C2701d(int i) {
            this.jTL = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(14986);
            C5018as aXy = C20086l.aXy();
            C20082b c20082b = C20082b.jTH;
            C2710d.m4955a(aXy, C20082b.m31071sy(this.jTL));
            if (this.jTL == 0) {
                PreloadLogic.aXo();
            }
            AppMethodBeat.m2505o(14986);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "checkTmplVerRespCgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplVerResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b$a */
    static final class C6812a<_Ret, _Var> implements C5681a<Void, C37441a<C23436ry>> {
        final /* synthetic */ int jKl;
        final /* synthetic */ LinkedList jTI;

        C6812a(int i, LinkedList linkedList) {
            this.jKl = i;
            this.jTI = linkedList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0099 A:{LOOP_END, LOOP:1: B:24:0x0093->B:26:0x0099} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(14980);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.Preload.TmplInfoManager", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            Iterator it;
            if (c37441a.errType == 0 && c37441a.errCode == 0 && c37441a.fsy != null) {
                if (((C23436ry) c37441a.fsy).vZp > 0) {
                    C20082b.m31067su(((C23436ry) c37441a.fsy).vZp);
                }
                if (((C23436ry) c37441a.fsy).vZo == null || ((C23436ry) c37441a.fsy).vZo.size() > 0) {
                    it = ((C23436ry) c37441a.fsy).vZo.iterator();
                    while (it.hasNext()) {
                        chi chi = (chi) it.next();
                        if (chi != null) {
                            C20082b.m31060a(chi, this.jKl);
                            C20082b.m31064j(chi);
                        }
                    }
                    C43924a.m78793kT(1);
                    it = this.jTI.iterator();
                    while (it.hasNext()) {
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.Preload.TmplInfoManager", "cgi back tmplInfoList is empty, return");
                }
            } else {
                C43924a.m78793kT(2);
                it = this.jTI.iterator();
                while (it.hasNext()) {
                    C15383rw c15383rw = (C15383rw) it.next();
                    C20082b c20082b = C20082b.jTH;
                    C20082b.jTG.remove(Integer.valueOf(c15383rw.jCt));
                }
            }
            AppMethodBeat.m2505o(14980);
            return null;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b$b */
    static final class C11251b implements Runnable {
        public static final C11251b jTJ = new C11251b();

        static {
            AppMethodBeat.m2504i(14982);
            AppMethodBeat.m2505o(14982);
        }

        C11251b() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14981);
            C20082b.aXD();
            AppMethodBeat.m2505o(14981);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Ljava/io/File;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b$c */
    static final class C11252c extends C25053k implements C31591m<ArrayList<String>, File, Boolean> {
        public static final C11252c jTK = new C11252c();

        static {
            AppMethodBeat.m2504i(14985);
            AppMethodBeat.m2505o(14985);
        }

        C11252c() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14983);
            Boolean valueOf = Boolean.valueOf(C11252c.m18967a((ArrayList) obj, (File) obj2));
            AppMethodBeat.m2505o(14983);
            return valueOf;
        }

        /* renamed from: a */
        public static boolean m18967a(ArrayList<String> arrayList, File file) {
            AppMethodBeat.m2504i(14984);
            C25052j.m39376p(arrayList, "receiver$0");
            C25052j.m39376p(file, "file");
            boolean contains = arrayList.contains(file.getAbsolutePath() + (file.isDirectory() ? "/" : ""));
            AppMethodBeat.m2505o(14984);
            return contains;
        }
    }

    static {
        AppMethodBeat.m2504i(15003);
        AppMethodBeat.m2505o(15003);
    }

    private C20082b() {
    }

    /* renamed from: sy */
    public static final /* synthetic */ String m31071sy(int i) {
        AppMethodBeat.m2504i(15005);
        String st = C20082b.m31066st(i);
        AppMethodBeat.m2505o(15005);
        return st;
    }

    /* renamed from: st */
    private static String m31066st(int i) {
        AppMethodBeat.m2504i(14987);
        String concat = "_tmpl_download_time_".concat(String.valueOf(i));
        AppMethodBeat.m2505o(14987);
        return concat;
    }

    /* renamed from: a */
    public static void m31059a(TmplParams tmplParams, boolean z) {
        AppMethodBeat.m2504i(14988);
        C25052j.m39376p(tmplParams, "tmplParams");
        String str = "_tmpl_info_inject_fail_-" + tmplParams.jSV + '-' + tmplParams.jSY;
        if (z) {
            C20086l.aXy().removeValueForKey(str);
            AppMethodBeat.m2505o(14988);
            return;
        }
        int i = C20086l.aXy().getInt(str, 0) + 1;
        C20086l.aXy().putInt(str, i);
        C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + tmplParams.jSV + ',' + tmplParams.jSY + ',' + i);
        if (i > 2) {
            C43924a.m78793kT(219);
            C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + tmplParams.jSV + ',' + tmplParams.jSY + ',' + i);
        }
        AppMethodBeat.m2505o(14988);
    }

    /* renamed from: a */
    public static final void m31058a(int i, String str, int... iArr) {
        AppMethodBeat.m2504i(14989);
        C25052j.m39376p(str, DownloadInfo.NETTYPE);
        C25052j.m39376p(iArr, "tmplTypes");
        if (C5023at.is2G(C4996ah.getContext())) {
            C4990ab.m7420w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
            AppMethodBeat.m2505o(14989);
            return;
        }
        Object obj;
        C33740a c33740a = C33739g.jSD;
        if (C5058f.IS_FLAVOR_RED || C38709h.aXn().getInt("preload_type", 1) != 3) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            C38710j.m65658de("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
            AppMethodBeat.m2505o(14989);
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
                    C25052j.dWJ();
                }
                j = ((Number) obj3).longValue();
            }
            if (jTG.contains(Integer.valueOf(intValue))) {
                C4990ab.m7419v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", Integer.valueOf(intValue));
                z = false;
            } else {
                z = C2710d.m4952C(j, C20086l.aXy().getLong("_check_time_colddown", (long) jTE));
            }
            if (z) {
                arrayList.add(obj2);
            }
        }
        for (Number intValue2 : (List) arrayList) {
            int intValue3 = intValue2.intValue();
            jTG.add(Integer.valueOf(intValue3));
            jTF.put(Integer.valueOf(intValue3), Long.valueOf(System.currentTimeMillis()));
            C15383rw c15383rw = new C15383rw();
            c15383rw.jCt = intValue3;
            if (PreloadLogic.m31033rW(101)) {
                c15383rw.vZj = C20086l.aXx();
            }
            linkedList.add(c15383rw);
            chi sw = C20082b.m31069sw(intValue3);
            if (C20086l.m31077a(sw)) {
                List list;
                if (C20086l.m31074FS(C20086l.m31078b(sw))) {
                    c15383rw.vZi = sw.wld;
                }
                Set stringSet = C20086l.aXy().getStringSet(C20086l.m31084h(sw), null);
                if (stringSet != null) {
                    Iterable iterable = stringSet;
                    arrayList = new ArrayList();
                    for (Object obj22 : iterable) {
                        String str2 = (String) obj22;
                        chi chi = new chi();
                        C25052j.m39375o(str2, "it");
                        if (C20082b.m31061a(C20082b.m31057a(chi, intValue3, str2), sw)) {
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
                    c15383rw.vZh.addAll(list);
                }
            }
        }
        if (linkedList.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            C43924a.m78793kT(0);
            new C42823a(linkedList, i, str).acy().mo60491g(new C6812a(i, linkedList));
        }
        AppMethodBeat.m2505o(14989);
    }

    public static final void clear() {
        AppMethodBeat.m2504i(14990);
        C20086l.aXy().clear();
        C1173e.m2575t(C20086l.m31073FR(C20082b.aXA()));
        C1173e.m2562cu(C1761b.eSj + "/jscache/");
        AppMethodBeat.m2505o(14990);
    }

    /* renamed from: su */
    public static final void m31067su(int i) {
        AppMethodBeat.m2504i(14991);
        C20086l.aXy().putLong("_check_time_colddown", (long) (i * 1000));
        AppMethodBeat.m2505o(14991);
    }

    /* renamed from: j */
    public static final void m31064j(chi chi) {
        AppMethodBeat.m2504i(14992);
        C25052j.m39376p(chi, "tmplInfo");
        String e = C20086l.m31081e(chi);
        C20086l.aXy().putString(C20086l.m31086ss(chi.jCt), chi.wld);
        C20086l.aXy().removeValueForKey(C20086l.m31082f(chi));
        C20086l.aXy().removeValueForKey(C20086l.m31083g(chi));
        C20086l.aXy().encode(e, chi.toByteArray());
        String h = C20086l.m31084h(chi);
        C5018as aXy = C20086l.aXy();
        Set stringSet = C20086l.aXy().getStringSet(h, null);
        if (stringSet == null) {
            stringSet = new HashSet();
        }
        stringSet.add(chi.wld);
        aXy.putStringSet(h, stringSet);
        AppMethodBeat.m2505o(14992);
    }

    /* renamed from: a */
    private static chi m31057a(chi chi, int i, String str) {
        int i2 = 1;
        AppMethodBeat.m2504i(14993);
        chi.jCt = i;
        chi.wld = str;
        byte[] decodeBytes = C20086l.aXy().decodeBytes(C20086l.m31081e(chi));
        C25052j.m39375o(decodeBytes, "bytes");
        if ((decodeBytes.length == 0 ? 1 : 0) != 0) {
            i2 = 0;
        }
        if (i2 != 0) {
            try {
                chi.parseFrom(decodeBytes);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", e, "decode TmplInfo:" + i + ", " + str, new Object[0]);
            }
        }
        AppMethodBeat.m2505o(14993);
        return chi;
    }

    /* renamed from: a */
    private static boolean m31061a(chi chi, chi chi2) {
        AppMethodBeat.m2504i(14994);
        if (!C20086l.m31073FR(C20086l.m31078b(chi)).exists()) {
            C4990ab.m7416i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + chi.wld);
        } else if (C20082b.m31063b(chi, chi2)) {
            C20086l.aXy().putString(C20086l.m31082f(chi), chi.wld);
            C2710d.m4955a(C20086l.aXy(), C20086l.m31083g(chi));
            AppMethodBeat.m2505o(14994);
            return true;
        } else {
            if (C25052j.m39373j(C20086l.m31081e(chi), C20086l.aXy().getString(C20086l.m31082f(chi), null))) {
                C20086l.aXy().removeValueForKey(C20086l.m31082f(chi));
                C20086l.aXy().removeValueForKey(C20086l.m31083g(chi));
            }
            C20086l.aXy().remove(C20086l.m31081e(chi));
            String h = C20086l.m31084h(chi2);
            Set stringSet = C20086l.aXy().getStringSet(h, null);
            if (stringSet != null) {
                stringSet.remove(chi.wld);
                C20086l.aXy().putStringSet(h, stringSet);
            }
            C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "tmpl " + chi.wld + " is invalid");
        }
        AppMethodBeat.m2505o(14994);
        return false;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code skipped:
            if (r0 > 0) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static boolean m31063b(chi chi, chi chi2) {
        AppMethodBeat.m2504i(14995);
        if (!C25052j.m39373j(chi, chi2) || chi.Version == 0) {
            int aXj;
            int i = chi2.vZn;
            if (C4990ab.getLogLevel() == 0) {
                C33740a c33740a = C33739g.jSD;
                aXj = C33740a.aXj();
            }
            aXj = i;
            if (chi.Version < aXj) {
                C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "tmpl " + chi.wld + " version:" + chi.Version + " < " + aXj);
                AppMethodBeat.m2505o(14995);
                return false;
            }
            LinkedList<chj> linkedList = chi2.xge;
            C25052j.m39375o(linkedList, "standard.VersionControlList");
            for (chj chj : linkedList) {
                if (C25052j.m39373j(chj.wld, chi.wld)) {
                    C4990ab.m7416i("MicroMsg.Preload.TmplInfoManager", "tmpl " + chj.wld + " matchControls in forceH5:" + chj.xgg);
                    if (chj.xgg) {
                        AppMethodBeat.m2505o(14995);
                        return false;
                    }
                    AppMethodBeat.m2505o(14995);
                    return true;
                }
            }
            AppMethodBeat.m2505o(14995);
            return true;
        }
        AppMethodBeat.m2505o(14995);
        return true;
    }

    /* renamed from: sv */
    public static final chi m31068sv(int i) {
        AppMethodBeat.m2504i(14996);
        chi chi = new chi();
        String string = C20086l.aXy().getString(C20086l.m31086ss(i), null);
        if (string != null) {
            C25052j.m39375o(string, "uid");
            C20082b.m31057a(chi, i, string);
        }
        AppMethodBeat.m2505o(14996);
        return chi;
    }

    /* renamed from: sw */
    private static /* synthetic */ chi m31069sw(int i) {
        AppMethodBeat.m2504i(14998);
        chi an = C20082b.m31062an(i, "");
        AppMethodBeat.m2505o(14998);
        return an;
    }

    /* renamed from: an */
    private static chi m31062an(int i, String str) {
        chi a;
        AppMethodBeat.m2504i(14997);
        chi sv = C20082b.m31068sv(i);
        if (C20086l.m31077a(sv)) {
            if (!C20086l.m31074FS(C20086l.m31078b(sv)) || (C25052j.m39373j(sv.wld, str) ^ 1) == 0) {
                String string = C20086l.aXy().getString(C20086l.m31082f(sv), null);
                if (string != null) {
                    chi chi = new chi();
                    C25052j.m39375o(string, "it");
                    a = C20082b.m31057a(chi, i, string);
                    if (!(a == null || !C20086l.m31077a(a) || C20086l.m31085i(a) || !C20086l.m31074FS(C20086l.m31078b(a)) || (C25052j.m39373j(a.wld, str) ^ 1) == 0)) {
                        AppMethodBeat.m2505o(14997);
                        return a;
                    }
                }
                Set stringSet = C20086l.aXy().getStringSet(C20086l.m31084h(sv), null);
                if (stringSet != null) {
                    Iterable iterable = stringSet;
                    C25052j.m39376p(iterable, "receiver$0");
                    C44848f c44848f = C44848f.AUW;
                    C44941v c44941v;
                    if (c44848f == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
                        AppMethodBeat.m2505o(14997);
                        throw c44941v;
                    }
                    Comparator comparator = c44848f;
                    C25052j.m39376p(iterable, "receiver$0");
                    C25052j.m39376p(comparator, "comparator");
                    List n;
                    if (!(iterable instanceof Collection)) {
                        n = C25035t.m39353n(iterable);
                        C41363p.m72150a(n, comparator);
                    } else if (((Collection) iterable).size() <= 1) {
                        n = C25035t.m39352m(iterable);
                    } else {
                        Object[] toArray = ((Collection) iterable).toArray(new Object[0]);
                        if (toArray == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.m2505o(14997);
                            throw c44941v;
                        } else if (toArray == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.m2505o(14997);
                            throw c44941v;
                        } else {
                            C36646h.m60746a(toArray, comparator);
                            n = C36646h.asList(toArray);
                        }
                    }
                    if (n != null) {
                        for (String string2 : n) {
                            if ((C25052j.m39373j(string2, str) ^ 1) != 0) {
                                chi chi2 = new chi();
                                C25052j.m39375o(string2, "uid");
                                a = C20082b.m31057a(chi2, i, string2);
                                if (C20082b.m31061a(a, sv)) {
                                    AppMethodBeat.m2505o(14997);
                                    return a;
                                }
                            }
                        }
                    }
                }
            } else {
                AppMethodBeat.m2505o(14997);
                return sv;
            }
        }
        a = new chi();
        AppMethodBeat.m2505o(14997);
        return a;
    }

    /* renamed from: k */
    private static final synchronized boolean m31065k(chi chi) {
        boolean z = false;
        synchronized (C20082b.class) {
            AppMethodBeat.m2504i(14999);
            if (chi == null) {
                C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
                AppMethodBeat.m2505o(14999);
            } else if (C20082b.m31068sv(chi.jCt).Version != chi.Version) {
                AppMethodBeat.m2505o(14999);
            } else if (C20086l.m31074FS(C20086l.m31078b(chi))) {
                z = true;
                AppMethodBeat.m2505o(14999);
            } else {
                C4990ab.m7420w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
                AppMethodBeat.m2505o(14999);
            }
        }
        return z;
    }

    public static final void aXz() {
        AppMethodBeat.m2504i(15000);
        C7305d.xDG.mo10151b(C11251b.jTJ, "tmplPreload");
        AppMethodBeat.m2505o(15000);
    }

    /* renamed from: sx */
    public static final TmplParams m31070sx(int i) {
        AppMethodBeat.m2504i(15001);
        chi sw = C20082b.m31069sw(i);
        if (C20086l.m31077a(sw)) {
            String c = C20086l.m31079c(sw);
            if (C20086l.m31074FS(c)) {
                C29850a aeZ = new C29850a().mo48063IW(i).mo48064IX(sw.Version).aeY(sw.Md5).aeX(c).aeW(new StringBuilder(PREFIX).append(i).append('_').append(sw.wld).append(".html").append((C25052j.m39373j(PREFIX, PREFIX) ^ 1) != 0 ? "?prefix=" + URLEncoder.encode(PREFIX) : "").toString()).mo48065IY(sw.wUX).mo48072lR(C20086l.aXy().getLong(C20082b.m31066st(sw.jCt), 0)).aeZ(sw.wld);
                LinkedList linkedList = sw.xgc;
                C25052j.m39375o(linkedList, "tmplInfo.HttpHeaderList");
                Iterable<chh> iterable = linkedList;
                StringBuilder stringBuilder = new StringBuilder();
                for (chh chh : iterable) {
                    StringBuilder append = stringBuilder.append(new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(chh.vMU).append(':').append(chh.pXM).toString());
                    C25052j.m39375o(append, "sb.append(\"\\n${header.Key}:${header.Value}\")");
                    stringBuilder = append;
                }
                TmplParams cYS = aeZ.afa(stringBuilder.toString()).cYS();
                AppMethodBeat.m2505o(15001);
                return cYS;
            }
            C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + c + " is null");
            C43924a.m78791gu(sw.wUX, 100);
            AppMethodBeat.m2505o(15001);
            return null;
        }
        C4990ab.m7412e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + i + " localTmplInfo is null");
        C43924a.m78793kT(100);
        AppMethodBeat.m2505o(15001);
        return null;
    }

    public static final String aXA() {
        AppMethodBeat.m2504i(15002);
        String str = C6457e.eSj + "webview_tmpl/";
        C33740a c33740a = C33739g.jSD;
        if (C33740a.aXi()) {
            str = C6457e.eSn;
            C25052j.m39375o(str, "CConstants.DATAROOT_SDCARD_PATH");
        }
        if (!C6163u.m9840jc(str, "/")) {
            str = str + "/";
        }
        str = str + "tmpls/";
        C15428j.aih(str);
        AppMethodBeat.m2505o(15002);
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
        AppMethodBeat.m2504i(15006);
        C4990ab.m7417i("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl saveDir:%s", C20082b.aXA());
        File FR = C20086l.m31073FR(str);
        if (!FR.exists()) {
            C4990ab.m7421w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not exist, err", str);
            AppMethodBeat.m2505o(15006);
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
                    if (C5058f.DEBUG) {
                        C4990ab.m7419v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl oldCount %d", Integer.valueOf(listFiles.length));
                        for (Object obj : listFiles) {
                            Object[] objArr = new Object[1];
                            C25052j.m39375o(obj, "file");
                            objArr[0] = obj.getName();
                            C4990ab.m7419v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl file:%s", objArr);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    Integer[] numArr = jTD;
                    Collection arrayList2 = new ArrayList();
                    for (Integer intValue2 : numArr) {
                        Set stringSet = C20086l.aXy().getStringSet(C20086l.m31084h(C20082b.m31068sv(intValue2.intValue())), new HashSet());
                        if (stringSet == null) {
                            C25052j.dWJ();
                        }
                        C25052j.m39375o(stringSet, "kvTmpl.getStringSet(\n   …keyVersions, HashSet())!!");
                        Iterable<String> m = C25035t.m39352m(stringSet);
                        Collection arrayList3 = new ArrayList(C25034m.m39318d(m));
                        for (String str2 : m) {
                            arrayList3.add(C7987l.listOf(Integer.valueOf(r10), str2));
                        }
                        C44628q.m81054a(arrayList2, (Iterable) (List) arrayList3);
                    }
                    for (List list : (List) arrayList2) {
                        Object obj2 = list.get(0);
                        C44941v c44941v;
                        if (obj2 == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.m2505o(15006);
                            throw c44941v;
                        }
                        intValue = ((Integer) obj2).intValue();
                        Object obj3 = list.get(1);
                        if (obj3 == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                            AppMethodBeat.m2505o(15006);
                            throw c44941v;
                        }
                        chi a = C20082b.m31057a(new chi(), intValue, (String) obj3);
                        if (C20086l.m31077a(a)) {
                            arrayList.add(C20086l.m31078b(a));
                        }
                    }
                    if (C5058f.DEBUG) {
                        C4990ab.m7419v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl curFilePaths %s", arrayList);
                    }
                    C11252c c11252c = C11252c.jTK;
                    ArrayList arrayList4 = new ArrayList();
                    for (File file : listFiles) {
                        long lastModified = file.lastModified();
                        if (C2710d.m4952C(lastModified, 604800000)) {
                            C25052j.m39375o(file, "file");
                            if (!C11252c.m18967a(arrayList, file)) {
                                arrayList4.add(file.getAbsolutePath());
                            }
                        }
                        if (C5058f.DEBUG && C2710d.m4952C(lastModified, 60000)) {
                            C25052j.m39375o(file, "file");
                            if (!C11252c.m18967a(arrayList, file)) {
                                arrayList4.add(file.getAbsolutePath());
                            }
                        }
                    }
                    if (1 >= C4990ab.getLogLevel()) {
                        C4990ab.m7419v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl deleteFilePaths %s", arrayList4);
                    }
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        str = (String) it.next();
                        C25052j.m39375o(str, "filePath");
                        if (C20086l.m31073FR(str).isDirectory()) {
                            FileOp.m64148tg(str);
                        } else {
                            FileOp.deleteFile(str);
                        }
                    }
                    AppMethodBeat.m2505o(15006);
                }
            }
            C4990ab.m7420w("MicroMsg.Preload.TmplInfoManager", "files is null");
            AppMethodBeat.m2505o(15006);
        } else {
            C4990ab.m7421w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not dir, err", str);
            AppMethodBeat.m2505o(15006);
        }
    }
}
