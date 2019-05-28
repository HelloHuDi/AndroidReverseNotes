package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TmplInfoEx;", "", "()V", "genTmplFDPath", "", "tmplType", "", "uid", "genTmplPath", "genTmplZipPath", "file", "plugin-brandservice_release"})
public final class k {
    public static final k jTx = new k();

    static {
        AppMethodBeat.i(14952);
        AppMethodBeat.o(14952);
    }

    private k() {
    }

    public static final String ak(int i, String str) {
        AppMethodBeat.i(14948);
        j.p(str, "uid");
        String str2 = b.aXA() + i + '_' + str + ".html";
        ab.i(l.TAG, "genTmplPath() tmplPath:".concat(String.valueOf(str2)));
        AppMethodBeat.o(14948);
        return str2;
    }

    public static /* synthetic */ String al(int i, String str) {
        AppMethodBeat.i(14950);
        String q = q(i, str, "index.html");
        AppMethodBeat.o(14950);
        return q;
    }

    public static final String q(int i, String str, String str2) {
        AppMethodBeat.i(14949);
        j.p(str, "uid");
        j.p(str2, "file");
        String str3 = b.aXA() + i + '_' + str + IOUtils.DIR_SEPARATOR_UNIX + str2;
        ab.i(l.TAG, "genTmplPath() tmplPath:".concat(String.valueOf(str3)));
        AppMethodBeat.o(14949);
        return str3;
    }

    public static final String am(int i, String str) {
        AppMethodBeat.i(14951);
        j.p(str, "uid");
        String str2 = b.aXA() + i + '_' + str + ".fd";
        ab.i(l.TAG, "genTmplPath() genTmplFDPath:".concat(String.valueOf(str2)));
        AppMethodBeat.o(14951);
        return str2;
    }
}
