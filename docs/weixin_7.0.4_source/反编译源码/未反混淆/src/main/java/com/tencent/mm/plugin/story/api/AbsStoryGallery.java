package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.widget.listview.PullDownListView;

public abstract class AbsStoryGallery extends RelativeLayout {
    public abstract void AW(int i);

    public abstract void EF(int i);

    public abstract void EG(int i);

    public abstract void K(boolean z, boolean z2);

    public abstract void Pb();

    public abstract void a(PullDownListView pullDownListView);

    public abstract void cwK();

    public abstract void cwL();

    public abstract void lr(boolean z);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public abstract void setCurrentHItem(int i);

    public abstract void setCurrentVItem(int i);

    public abstract void setDataSeed(Object obj);

    public abstract void setStoryBrowseUIListener(g gVar);

    public abstract boolean wY();

    public AbsStoryGallery(Context context) {
        super(context);
    }

    public AbsStoryGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsStoryGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
