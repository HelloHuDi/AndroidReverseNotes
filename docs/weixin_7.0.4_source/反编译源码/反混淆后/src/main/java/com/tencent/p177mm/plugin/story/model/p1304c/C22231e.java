package com.tencent.p177mm.plugin.story.model.p1304c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.C18532d;
import com.tencent.p177mm.loader.C37881e;
import com.tencent.p177mm.loader.p245d.C32725b;
import com.tencent.p177mm.loader.p246e.C45418a;
import com.tencent.p177mm.loader.p858b.p859a.C26352d;
import com.tencent.p177mm.loader.p861c.C26354a;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p861c.C37878e.C32724a;
import com.tencent.p177mm.loader.p861c.C42153d;
import com.tencent.p177mm.loader.p861c.C9567b.C9568a;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a.C13738a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.c.e */
public final class C22231e {
    public C18532d<C24833d> rVR;
    private final C45418a rVS = new C45418a();
    public final C37878e rVT;
    public final C37878e rVU;

    public C22231e() {
        AppMethodBeat.m2504i(109302);
        C37878e TL = new C32724a().mo53278TJ().mo53277TI().mo53280TL();
        C25052j.m39375o(TL, "ImageLoaderOptions.Build…cheInMemory(true).build()");
        this.rVT = TL;
        TL = new C32724a().mo53278TJ().mo53277TI().mo53279TK().mo53282jZ(((C13738a) C29274a.rQZ.mo53288Uw()).rRh).mo53281jY(((C13738a) C29274a.rQZ.mo53288Uw()).rRi).mo53280TL();
        C25052j.m39375o(TL, "ImageLoaderOptions.Build….albumThumbWidth).build()");
        this.rVU = TL;
        C26354a c26354a = new C26354a();
        C26352d c22227b = new C22227b();
        C25052j.m39376p(c22227b, "cache");
        c26354a.ePt = c22227b;
        C32725b c22229c = new C22229c();
        C25052j.m39376p(c22229c, "downloader");
        c26354a.ePu = c22229c;
        C32733f c32733f = this.rVS;
        C25052j.m39376p(c32733f, "creater");
        c26354a.ePv = c32733f;
        TL = this.rVT;
        C25052j.m39376p(TL, "options");
        c26354a.ePr = TL;
        C42153d c9568a = new C9568a(c26354a);
        C37881e c37881e = C37881e.eOD;
        this.rVR = C37881e.m63943a(c9568a);
        AppMethodBeat.m2505o(109302);
    }
}
