package com.tencent.mm.plugin.story.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.e.a;
import com.tencent.mm.loader.f.f;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e {
    public d<d> rVR;
    private final a rVS = new a();
    public final com.tencent.mm.loader.c.e rVT;
    public final com.tencent.mm.loader.c.e rVU;

    public e() {
        AppMethodBeat.i(109302);
        com.tencent.mm.loader.c.e TL = new com.tencent.mm.loader.c.e.a().TJ().TI().TL();
        j.o(TL, "ImageLoaderOptions.Build…cheInMemory(true).build()");
        this.rVT = TL;
        TL = new com.tencent.mm.loader.c.e.a().TJ().TI().TK().jZ(((com.tencent.mm.plugin.story.c.a.a.a) com.tencent.mm.plugin.story.c.a.a.rQZ.Uw()).rRh).jY(((com.tencent.mm.plugin.story.c.a.a.a) com.tencent.mm.plugin.story.c.a.a.rQZ.Uw()).rRi).TL();
        j.o(TL, "ImageLoaderOptions.Build….albumThumbWidth).build()");
        this.rVU = TL;
        com.tencent.mm.loader.c.a aVar = new com.tencent.mm.loader.c.a();
        com.tencent.mm.loader.b.a.d bVar = new b();
        j.p(bVar, "cache");
        aVar.ePt = bVar;
        b cVar = new c();
        j.p(cVar, "downloader");
        aVar.ePu = cVar;
        f fVar = this.rVS;
        j.p(fVar, "creater");
        aVar.ePv = fVar;
        TL = this.rVT;
        j.p(TL, "options");
        aVar.ePr = TL;
        com.tencent.mm.loader.c.d aVar2 = new com.tencent.mm.loader.c.b.a(aVar);
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.eOD;
        this.rVR = com.tencent.mm.loader.e.a(aVar2);
        AppMethodBeat.o(109302);
    }
}
