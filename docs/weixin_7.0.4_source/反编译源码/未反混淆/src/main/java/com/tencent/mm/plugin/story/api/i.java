package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public interface i {

    public interface a {
        boolean ed(View view);
    }

    void a(Canvas canvas, boolean z, int i);

    void aR(View view);

    OnClickListener cwV();

    void dk(String str, int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnDoubleClickListener(a aVar);

    void setShowStoryHint(boolean z);

    void setWeakContext(Context context);
}
