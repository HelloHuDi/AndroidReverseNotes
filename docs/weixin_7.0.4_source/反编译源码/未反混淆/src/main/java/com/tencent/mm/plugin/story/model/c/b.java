package com.tencent.mm.plugin.story.model.c;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.a.a;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016J3\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0002J@\u0010\u0011\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016JL\u0010\u0015\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"})
public final class b extends a<d> {
    public final boolean a(com.tencent.mm.loader.h.a.a<d> aVar, f<?> fVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        AppMethodBeat.i(109288);
        j.p(aVar, "url");
        j.p(fVar, "httpResponse");
        j.p(eVar, "opts");
        j.p(fVar2, "reaper");
        AppMethodBeat.o(109288);
        return true;
    }

    public final boolean b(com.tencent.mm.loader.h.a.a<d> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(109289);
        j.p(aVar, "url");
        j.p(eVar, "opts");
        j.p(fVar, "reaper");
        AppMethodBeat.o(109289);
        return true;
    }

    public final String a(com.tencent.mm.loader.h.a.a<d> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(109290);
        j.p(aVar, "url");
        j.p(eVar, "opts");
        j.p(fVar, "reaper");
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        String gx = com.tencent.mm.plugin.story.model.l.gx(((d) aVar.value()).rVQ.Id, ((d) aVar.value()).username);
        com.tencent.mm.plugin.story.model.l lVar2 = com.tencent.mm.plugin.story.model.l.rTg;
        com.tencent.mm.plugin.story.model.l.aax(gx);
        AppMethodBeat.o(109290);
        return gx;
    }

    public final com.tencent.mm.loader.h.b.a c(com.tencent.mm.loader.h.a.a<d> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        AppMethodBeat.i(109291);
        j.p(aVar, "url");
        j.p(eVar, "opts");
        j.p(fVar, "reaper");
        String a = a(aVar, eVar, fVar);
        ab.v(g.getTAG(), "url " + aVar + " and path " + a);
        com.tencent.mm.loader.h.b.a lT;
        if (com.tencent.mm.vfs.e.ct(a)) {
            lT = com.tencent.mm.loader.h.b.a.lT(a);
            AppMethodBeat.o(109291);
            return lT;
        }
        com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
        a = com.tencent.mm.plugin.story.model.l.aas(((d) aVar.value()).rVQ.Id);
        if (com.tencent.mm.vfs.e.ct(a)) {
            lT = com.tencent.mm.loader.h.b.a.lT(a);
            AppMethodBeat.o(109291);
            return lT;
        }
        AppMethodBeat.o(109291);
        return null;
    }
}
