package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryCaptureIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCpuCrop", "", "markGpuCrop", "markGpuCropFailed", "markOnCreate", "markOnDestroy", "plugin-story_release"})
public final class d {
    public static final d sbR = new d();

    static {
        AppMethodBeat.i(109799);
        AppMethodBeat.o(109799);
    }

    private d() {
    }

    public static void czX() {
        AppMethodBeat.i(109797);
        ab.i("MicroMsg.StoryCaptureIDKeyStat", "markOnCreate");
        h.pYm.k(985, 0, 1);
        AppMethodBeat.o(109797);
    }

    public static void czY() {
        AppMethodBeat.i(109798);
        ab.i("MicroMsg.StoryCaptureIDKeyStat", "markOnDestroy");
        h.pYm.k(985, 1, 1);
        AppMethodBeat.o(109798);
    }
}
