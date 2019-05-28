package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.chi;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import java.io.File;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C17085r;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u001a&\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0003\u001a\n\u0010,\u001a\u00020-*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0017\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\"\u0015\u0010\u0018\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000f\"\u0015\u0010\u001f\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b \u0010\u000f\"\u0015\u0010!\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u000f\"\u0015\u0010#\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b$\u0010\u000f\"\u0015\u0010%\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b&\u0010\u000f¨\u0006."}, dWq = {"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Ljava/io/File;", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.l */
public final class C20086l {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82051a(new C17085r(C44855v.m82056f(C20086l.class, "plugin-brandservice_release"), "TMPL_CONTROL_FLAG", "getTMPL_CONTROL_FLAG()J"))};
    private static final C44856f jTy = C17344i.m26854g(C20087a.jTz);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.l$a */
    static final class C20087a extends C25053k implements C31214a<Long> {
        public static final C20087a jTz = new C20087a();

        static {
            AppMethodBeat.m2504i(14954);
            AppMethodBeat.m2505o(14954);
        }

        C20087a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14953);
            Long valueOf = Long.valueOf(1);
            AppMethodBeat.m2505o(14953);
            return valueOf;
        }
    }

    public static final long aXx() {
        AppMethodBeat.m2504i(14956);
        long longValue = ((Number) jTy.getValue()).longValue();
        AppMethodBeat.m2505o(14956);
        return longValue;
    }

    static {
        AppMethodBeat.m2504i(14955);
        AppMethodBeat.m2505o(14955);
    }

    public static final C5018as aXy() {
        AppMethodBeat.m2504i(14957);
        C5018as eg = C5018as.m7465eg("_webview_tmpl_info", 2);
        C25052j.m39375o(eg, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
        AppMethodBeat.m2505o(14957);
        return eg;
    }

    /* renamed from: FR */
    public static final File m31073FR(String str) {
        AppMethodBeat.m2504i(14958);
        C25052j.m39376p(str, "receiver$0");
        File file = new File(str);
        AppMethodBeat.m2505o(14958);
        return file;
    }

    /* renamed from: FS */
    public static final boolean m31074FS(String str) {
        AppMethodBeat.m2504i(14959);
        C25052j.m39376p(str, "receiver$0");
        boolean exists = C20086l.m31073FR(str).exists();
        AppMethodBeat.m2505o(14959);
        return exists;
    }

    /* renamed from: a */
    public static final boolean m31077a(chi chi) {
        AppMethodBeat.m2504i(14960);
        C25052j.m39376p(chi, "receiver$0");
        if (chi.Version != 0) {
            AppMethodBeat.m2505o(14960);
            return true;
        }
        AppMethodBeat.m2505o(14960);
        return false;
    }

    /* renamed from: b */
    public static final String m31078b(chi chi) {
        AppMethodBeat.m2504i(14961);
        C25052j.m39376p(chi, "receiver$0");
        int i = chi.jCt;
        String str = chi.wld;
        C25052j.m39375o(str, "this.Uid");
        String q = C27539k.m43702q(i, str, "");
        if (!C20086l.m31074FS(q)) {
            i = chi.jCt;
            str = chi.wld;
            C25052j.m39375o(str, "this.Uid");
            q = C27539k.m43699ak(i, str);
        }
        AppMethodBeat.m2505o(14961);
        return q;
    }

    /* renamed from: c */
    public static final String m31079c(chi chi) {
        AppMethodBeat.m2504i(14962);
        C25052j.m39376p(chi, "receiver$0");
        int i = chi.jCt;
        String str = chi.wld;
        C25052j.m39375o(str, "this.Uid");
        String al = C27539k.m43700al(i, str);
        if (!C20086l.m31074FS(al)) {
            i = chi.jCt;
            str = chi.wld;
            C25052j.m39375o(str, "this.Uid");
            al = C27539k.m43699ak(i, str);
        }
        AppMethodBeat.m2505o(14962);
        return al;
    }

    /* renamed from: d */
    public static final boolean m31080d(chi chi) {
        AppMethodBeat.m2504i(14963);
        C25052j.m39376p(chi, "receiver$0");
        String c = C20086l.m31079c(chi);
        int i = chi.jCt;
        String str = chi.wld;
        C25052j.m39375o(str, "this.Uid");
        boolean j = C25052j.m39373j(c, C27539k.m43700al(i, str));
        AppMethodBeat.m2505o(14963);
        return j;
    }

    /* renamed from: ss */
    public static final String m31086ss(int i) {
        AppMethodBeat.m2504i(14964);
        String concat = "_tmpl_info_latest_responsed_-".concat(String.valueOf(i));
        AppMethodBeat.m2505o(14964);
        return concat;
    }

    /* renamed from: e */
    public static final String m31081e(chi chi) {
        AppMethodBeat.m2504i(14965);
        C25052j.m39376p(chi, "receiver$0");
        String str = "_tmpl_info_-" + chi.jCt + '-' + chi.wld;
        AppMethodBeat.m2505o(14965);
        return str;
    }

    /* renamed from: f */
    public static final String m31082f(chi chi) {
        AppMethodBeat.m2504i(14966);
        C25052j.m39376p(chi, "receiver$0");
        String str = "_tmpl_info_latest_verified_-" + chi.jCt + '-' + chi.xgf;
        AppMethodBeat.m2505o(14966);
        return str;
    }

    /* renamed from: g */
    public static final String m31083g(chi chi) {
        AppMethodBeat.m2504i(14967);
        C25052j.m39376p(chi, "receiver$0");
        String str = "_tmpl_info_latest_verified_time_-" + chi.jCt + '-' + chi.xgf;
        AppMethodBeat.m2505o(14967);
        return str;
    }

    /* renamed from: h */
    public static final String m31084h(chi chi) {
        AppMethodBeat.m2504i(14968);
        C25052j.m39376p(chi, "receiver$0");
        String str = "_tmpl_info_version_list_-" + chi.jCt + '-' + chi.xgf;
        AppMethodBeat.m2505o(14968);
        return str;
    }

    /* renamed from: i */
    public static final boolean m31085i(chi chi) {
        AppMethodBeat.m2504i(14969);
        C25052j.m39376p(chi, "receiver$0");
        boolean C = C2710d.m4952C(C20086l.aXy().getLong(C20086l.m31083g(chi), 0), 3600000);
        AppMethodBeat.m2505o(14969);
        return C;
    }

    /* renamed from: a */
    public static final int m31076a(int i, long j, int i2, long j2) {
        AppMethodBeat.m2504i(14970);
        int hashCode = (i + '-' + j).hashCode();
        if (C20086l.aXy().getInt("_tmpl_lastest_mm_open", 0) == hashCode) {
            hashCode = (i2 + '-' + j2).hashCode();
            if (C20086l.aXy().getInt("_tmpl_lastest_mp_open", 0) == hashCode) {
                AppMethodBeat.m2505o(14970);
                return 2;
            }
            C20086l.aXy().putInt("_tmpl_lastest_mp_open", hashCode);
            AppMethodBeat.m2505o(14970);
            return 1;
        }
        C20086l.aXy().putInt("_tmpl_lastest_mm_open", hashCode);
        AppMethodBeat.m2505o(14970);
        return 0;
    }
}
