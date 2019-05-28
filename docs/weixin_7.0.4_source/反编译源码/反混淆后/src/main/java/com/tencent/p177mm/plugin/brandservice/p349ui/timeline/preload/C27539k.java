package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.k */
public final class C27539k {
    public static final C27539k jTx = new C27539k();

    static {
        AppMethodBeat.m2504i(14952);
        AppMethodBeat.m2505o(14952);
    }

    private C27539k() {
    }

    /* renamed from: ak */
    public static final String m43699ak(int i, String str) {
        AppMethodBeat.m2504i(14948);
        C25052j.m39376p(str, "uid");
        String str2 = C20082b.aXA() + i + '_' + str + ".html";
        C4990ab.m7416i(C20086l.TAG, "genTmplPath() tmplPath:".concat(String.valueOf(str2)));
        AppMethodBeat.m2505o(14948);
        return str2;
    }

    /* renamed from: al */
    public static /* synthetic */ String m43700al(int i, String str) {
        AppMethodBeat.m2504i(14950);
        String q = C27539k.m43702q(i, str, "index.html");
        AppMethodBeat.m2505o(14950);
        return q;
    }

    /* renamed from: q */
    public static final String m43702q(int i, String str, String str2) {
        AppMethodBeat.m2504i(14949);
        C25052j.m39376p(str, "uid");
        C25052j.m39376p(str2, "file");
        String str3 = C20082b.aXA() + i + '_' + str + IOUtils.DIR_SEPARATOR_UNIX + str2;
        C4990ab.m7416i(C20086l.TAG, "genTmplPath() tmplPath:".concat(String.valueOf(str3)));
        AppMethodBeat.m2505o(14949);
        return str3;
    }

    /* renamed from: am */
    public static final String m43701am(int i, String str) {
        AppMethodBeat.m2504i(14951);
        C25052j.m39376p(str, "uid");
        String str2 = C20082b.aXA() + i + '_' + str + ".fd";
        C4990ab.m7416i(C20086l.TAG, "genTmplPath() genTmplFDPath:".concat(String.valueOf(str2)));
        AppMethodBeat.m2505o(14951);
        return str2;
    }
}
