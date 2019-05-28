package com.tencent.p177mm.plugin.story.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMFragment;

/* renamed from: com.tencent.mm.plugin.story.api.m */
public interface C46269m {

    /* renamed from: com.tencent.mm.plugin.story.api.m$a */
    public enum C29273a {
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
            AppMethodBeat.m2505o(56482);
        }
    }

    /* renamed from: a */
    AbsStoryGallery mo69256a(Context context, C29273a c29273a, String str);

    /* renamed from: d */
    void mo69257d(ViewGroup viewGroup, View view);

    /* renamed from: eV */
    AbsStoryMuteView mo69258eV(Context context);

    /* renamed from: eW */
    C29268i mo69259eW(Context context);

    /* renamed from: ee */
    void mo69260ee(View view);

    /* renamed from: ef */
    void mo69261ef(View view);

    /* renamed from: eg */
    void mo69262eg(View view);

    MMFragment instantiateAlbumFragment(Context context, Bundle bundle);

    /* renamed from: ls */
    Drawable mo69264ls(boolean z);
}
