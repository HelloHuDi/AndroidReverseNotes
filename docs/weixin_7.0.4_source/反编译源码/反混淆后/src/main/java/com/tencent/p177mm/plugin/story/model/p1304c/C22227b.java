package com.tencent.p177mm.plugin.story.model.p1304c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p1197h.C42162f;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import com.tencent.p177mm.loader.p858b.p859a.C37877a;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J3\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0002J@\u0010\u0011\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016JL\u0010\u0015\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.c.b */
public final class C22227b extends C37877a<C24833d> {
    /* renamed from: a */
    public final boolean mo37767a(C42156a<C24833d> c42156a, C42162f<?> c42162f, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        AppMethodBeat.m2504i(109288);
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c42162f, "httpResponse");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        AppMethodBeat.m2505o(109288);
        return true;
    }

    /* renamed from: b */
    public final boolean mo37768b(C42156a<C24833d> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        AppMethodBeat.m2504i(109289);
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        AppMethodBeat.m2505o(109289);
        return true;
    }

    /* renamed from: a */
    public final String mo37766a(C42156a<C24833d> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        AppMethodBeat.m2504i(109290);
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        C29309l c29309l = C29309l.rTg;
        String gx = C29309l.m46528gx(((C24833d) c42156a.value()).rVQ.f4416Id, ((C24833d) c42156a.value()).username);
        C29309l c29309l2 = C29309l.rTg;
        C29309l.aax(gx);
        AppMethodBeat.m2505o(109290);
        return gx;
    }

    /* renamed from: c */
    public final C18545a mo37769c(C42156a<C24833d> c42156a, C37878e c37878e, C45421f<?, Bitmap> c45421f) {
        AppMethodBeat.m2504i(109291);
        C25052j.m39376p(c42156a, "url");
        C25052j.m39376p(c37878e, "opts");
        C25052j.m39376p(c45421f, "reaper");
        String a = mo37766a(c42156a, c37878e, c45421f);
        C4990ab.m7418v(C46280g.getTAG(), "url " + c42156a + " and path " + a);
        C18545a lT;
        if (C5730e.m8628ct(a)) {
            lT = C18545a.m28857lT(a);
            AppMethodBeat.m2505o(109291);
            return lT;
        }
        C29309l c29309l = C29309l.rTg;
        a = C29309l.aas(((C24833d) c42156a.value()).rVQ.f4416Id);
        if (C5730e.m8628ct(a)) {
            lT = C18545a.m28857lT(a);
            AppMethodBeat.m2505o(109291);
            return lT;
        }
        AppMethodBeat.m2505o(109291);
        return null;
    }
}
