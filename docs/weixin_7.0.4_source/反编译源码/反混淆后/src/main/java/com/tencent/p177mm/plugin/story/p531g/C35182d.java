package com.tencent.p177mm.plugin.story.p531g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryCaptureIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCpuCrop", "", "markGpuCrop", "markGpuCropFailed", "markOnCreate", "markOnDestroy", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.d */
public final class C35182d {
    public static final C35182d sbR = new C35182d();

    static {
        AppMethodBeat.m2504i(109799);
        AppMethodBeat.m2505o(109799);
    }

    private C35182d() {
    }

    public static void czX() {
        AppMethodBeat.m2504i(109797);
        C4990ab.m7416i("MicroMsg.StoryCaptureIDKeyStat", "markOnCreate");
        C7060h.pYm.mo15419k(985, 0, 1);
        AppMethodBeat.m2505o(109797);
    }

    public static void czY() {
        AppMethodBeat.m2504i(109798);
        C4990ab.m7416i("MicroMsg.StoryCaptureIDKeyStat", "markOnDestroy");
        C7060h.pYm.mo15419k(985, 1, 1);
        AppMethodBeat.m2505o(109798);
    }
}
