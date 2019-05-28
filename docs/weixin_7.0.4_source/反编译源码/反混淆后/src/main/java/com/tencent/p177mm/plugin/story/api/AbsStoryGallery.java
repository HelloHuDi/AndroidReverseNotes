package com.tencent.p177mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.p177mm.p612ui.widget.listview.PullDownListView;

/* renamed from: com.tencent.mm.plugin.story.api.AbsStoryGallery */
public abstract class AbsStoryGallery extends RelativeLayout {
    /* renamed from: AW */
    public abstract void mo55928AW(int i);

    /* renamed from: EF */
    public abstract void mo55929EF(int i);

    /* renamed from: EG */
    public abstract void mo55930EG(int i);

    /* renamed from: K */
    public abstract void mo55932K(boolean z, boolean z2);

    /* renamed from: Pb */
    public abstract void mo55933Pb();

    /* renamed from: a */
    public abstract void mo55934a(PullDownListView pullDownListView);

    public abstract void cwK();

    public abstract void cwL();

    /* renamed from: lr */
    public abstract void mo55945lr(boolean z);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public abstract void setCurrentHItem(int i);

    public abstract void setCurrentVItem(int i);

    public abstract void setDataSeed(Object obj);

    public abstract void setStoryBrowseUIListener(C35171g c35171g);

    /* renamed from: wY */
    public abstract boolean mo55964wY();

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
