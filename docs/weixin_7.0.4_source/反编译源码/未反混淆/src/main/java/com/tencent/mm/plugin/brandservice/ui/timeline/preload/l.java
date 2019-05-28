package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f;
import a.f.b.j;
import a.f.b.r;
import a.f.b.v;
import a.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.platformtools.as;
import java.io.File;

@a.l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u001a&\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0003\u001a\n\u0010,\u001a\u00020-*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0017\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\"\u0015\u0010\u0018\u001a\u00020\u0013*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000f\"\u0015\u0010\u001f\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b \u0010\u000f\"\u0015\u0010!\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u000f\"\u0015\u0010#\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b$\u0010\u000f\"\u0015\u0010%\u001a\u00020\u0001*\u00020\r8F¢\u0006\u0006\u001a\u0004\b&\u0010\u000f¨\u0006."}, dWq = {"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Ljava/io/File;", "plugin-brandservice_release"})
public final class l {
    private static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new r(v.f(l.class, "plugin-brandservice_release"), "TMPL_CONTROL_FLAG", "getTMPL_CONTROL_FLAG()J"))};
    private static final f jTy = i.g(a.jTz);

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<Long> {
        public static final a jTz = new a();

        static {
            AppMethodBeat.i(14954);
            AppMethodBeat.o(14954);
        }

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14953);
            Long valueOf = Long.valueOf(1);
            AppMethodBeat.o(14953);
            return valueOf;
        }
    }

    public static final long aXx() {
        AppMethodBeat.i(14956);
        long longValue = ((Number) jTy.getValue()).longValue();
        AppMethodBeat.o(14956);
        return longValue;
    }

    static {
        AppMethodBeat.i(14955);
        AppMethodBeat.o(14955);
    }

    public static final as aXy() {
        AppMethodBeat.i(14957);
        as eg = as.eg("_webview_tmpl_info", 2);
        j.o(eg, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
        AppMethodBeat.o(14957);
        return eg;
    }

    public static final File FR(String str) {
        AppMethodBeat.i(14958);
        j.p(str, "receiver$0");
        File file = new File(str);
        AppMethodBeat.o(14958);
        return file;
    }

    public static final boolean FS(String str) {
        AppMethodBeat.i(14959);
        j.p(str, "receiver$0");
        boolean exists = FR(str).exists();
        AppMethodBeat.o(14959);
        return exists;
    }

    public static final boolean a(chi chi) {
        AppMethodBeat.i(14960);
        j.p(chi, "receiver$0");
        if (chi.Version != 0) {
            AppMethodBeat.o(14960);
            return true;
        }
        AppMethodBeat.o(14960);
        return false;
    }

    public static final String b(chi chi) {
        AppMethodBeat.i(14961);
        j.p(chi, "receiver$0");
        int i = chi.jCt;
        String str = chi.wld;
        j.o(str, "this.Uid");
        String q = k.q(i, str, "");
        if (!FS(q)) {
            i = chi.jCt;
            str = chi.wld;
            j.o(str, "this.Uid");
            q = k.ak(i, str);
        }
        AppMethodBeat.o(14961);
        return q;
    }

    public static final String c(chi chi) {
        AppMethodBeat.i(14962);
        j.p(chi, "receiver$0");
        int i = chi.jCt;
        String str = chi.wld;
        j.o(str, "this.Uid");
        String al = k.al(i, str);
        if (!FS(al)) {
            i = chi.jCt;
            str = chi.wld;
            j.o(str, "this.Uid");
            al = k.ak(i, str);
        }
        AppMethodBeat.o(14962);
        return al;
    }

    public static final boolean d(chi chi) {
        AppMethodBeat.i(14963);
        j.p(chi, "receiver$0");
        String c = c(chi);
        int i = chi.jCt;
        String str = chi.wld;
        j.o(str, "this.Uid");
        boolean j = j.j(c, k.al(i, str));
        AppMethodBeat.o(14963);
        return j;
    }

    public static final String ss(int i) {
        AppMethodBeat.i(14964);
        String concat = "_tmpl_info_latest_responsed_-".concat(String.valueOf(i));
        AppMethodBeat.o(14964);
        return concat;
    }

    public static final String e(chi chi) {
        AppMethodBeat.i(14965);
        j.p(chi, "receiver$0");
        String str = "_tmpl_info_-" + chi.jCt + '-' + chi.wld;
        AppMethodBeat.o(14965);
        return str;
    }

    public static final String f(chi chi) {
        AppMethodBeat.i(14966);
        j.p(chi, "receiver$0");
        String str = "_tmpl_info_latest_verified_-" + chi.jCt + '-' + chi.xgf;
        AppMethodBeat.o(14966);
        return str;
    }

    public static final String g(chi chi) {
        AppMethodBeat.i(14967);
        j.p(chi, "receiver$0");
        String str = "_tmpl_info_latest_verified_time_-" + chi.jCt + '-' + chi.xgf;
        AppMethodBeat.o(14967);
        return str;
    }

    public static final String h(chi chi) {
        AppMethodBeat.i(14968);
        j.p(chi, "receiver$0");
        String str = "_tmpl_info_version_list_-" + chi.jCt + '-' + chi.xgf;
        AppMethodBeat.o(14968);
        return str;
    }

    public static final boolean i(chi chi) {
        AppMethodBeat.i(14969);
        j.p(chi, "receiver$0");
        boolean C = d.C(aXy().getLong(g(chi), 0), 3600000);
        AppMethodBeat.o(14969);
        return C;
    }

    public static final int a(int i, long j, int i2, long j2) {
        AppMethodBeat.i(14970);
        int hashCode = (i + '-' + j).hashCode();
        if (aXy().getInt("_tmpl_lastest_mm_open", 0) == hashCode) {
            hashCode = (i2 + '-' + j2).hashCode();
            if (aXy().getInt("_tmpl_lastest_mp_open", 0) == hashCode) {
                AppMethodBeat.o(14970);
                return 2;
            }
            aXy().putInt("_tmpl_lastest_mp_open", hashCode);
            AppMethodBeat.o(14970);
            return 1;
        }
        aXy().putInt("_tmpl_lastest_mm_open", hashCode);
        AppMethodBeat.o(14970);
        return 0;
    }
}
