package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.m.a;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] eQZ;

    static {
        AppMethodBeat.i(110752);
        int[] iArr = new int[a.values().length];
        eQZ = iArr;
        iArr[a.MultiUserGallery.ordinal()] = 1;
        eQZ[a.FavOtherStoryGallery.ordinal()] = 2;
        eQZ[a.FavSelfStoryGallery.ordinal()] = 3;
        eQZ[a.HistoryGallery.ordinal()] = 4;
        eQZ[a.ProfileGallery.ordinal()] = 5;
        AppMethodBeat.o(110752);
    }
}
