package com.tencent.p177mm.plugin.story.api;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.tencent.mm.plugin.story.api.i */
public interface C29268i {

    /* renamed from: com.tencent.mm.plugin.story.api.i$a */
    public interface C29267a {
        /* renamed from: ed */
        boolean mo47442ed(View view);
    }

    /* renamed from: a */
    void mo9013a(Canvas canvas, boolean z, int i);

    /* renamed from: aR */
    void mo9014aR(View view);

    OnClickListener cwV();

    /* renamed from: dk */
    void mo9016dk(String str, int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnDoubleClickListener(C29267a c29267a);

    void setShowStoryHint(boolean z);

    void setWeakContext(Context context);
}
