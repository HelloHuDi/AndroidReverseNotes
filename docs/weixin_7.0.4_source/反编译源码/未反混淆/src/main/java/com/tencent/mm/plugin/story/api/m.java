package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;

public interface m {

    public enum a {
        SelfTabGallery,
        SelfGallery,
        ProfileGallery,
        SingleGallery,
        MultiUserGallery,
        HistoryGallery,
        AllFriendGallery,
        FavSelfStoryGallery,
        FavOtherStoryGallery;

        static {
            AppMethodBeat.o(56482);
        }
    }

    AbsStoryGallery a(Context context, a aVar, String str);

    void d(ViewGroup viewGroup, View view);

    AbsStoryMuteView eV(Context context);

    i eW(Context context);

    void ee(View view);

    void ef(View view);

    void eg(View view);

    MMFragment instantiateAlbumFragment(Context context, Bundle bundle);

    Drawable ls(boolean z);
}
