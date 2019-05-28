package com.tencent.mm.br;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.k;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.cache.d;
import com.tencent.mm.e.a;

public interface b {
    boolean Ab();

    boolean G(MotionEvent motionEvent);

    d a(a aVar);

    void a(Editable editable, int i, int i2);

    void a(n nVar, boolean z);

    void a(s.a aVar);

    void a(com.tencent.mm.view.a aVar);

    <T extends com.tencent.mm.e.b> T b(e eVar);

    void d(k kVar);

    void dlS();

    com.tencent.mm.view.a dlT();

    <T extends com.tencent.mm.e.b> T dlU();

    Bitmap dlV();

    boolean dlW();

    s.a getConfig();

    Context getContext();

    float getCurScale();

    e[] getFeatures();

    float getInitScale();

    r getSelectedFeatureListener();

    void onAttachedToWindow();

    void onDestroy();

    void onDraw(Canvas canvas);

    void onExit();

    void onFinish();

    void setActionBarCallback(g gVar);

    void setAutoShowFooterAndBar(boolean z);
}
