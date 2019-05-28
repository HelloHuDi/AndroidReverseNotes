package com.tencent.p177mm.p204br;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.p177mm.api.C25784s.C25785a;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C32249g;
import com.tencent.p177mm.api.C37464n;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.api.C8956r;
import com.tencent.p177mm.cache.C18128d;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.p226e.C9268b;
import com.tencent.p177mm.view.C16051a;

/* renamed from: com.tencent.mm.br.b */
public interface C18117b {
    /* renamed from: Ab */
    boolean mo33559Ab();

    /* renamed from: G */
    boolean mo33560G(MotionEvent motionEvent);

    /* renamed from: a */
    C18128d mo33561a(C1493a c1493a);

    /* renamed from: a */
    void mo33562a(Editable editable, int i, int i2);

    /* renamed from: a */
    void mo33563a(C37464n c37464n, boolean z);

    /* renamed from: a */
    void mo33564a(C25785a c25785a);

    /* renamed from: a */
    void mo33565a(C16051a c16051a);

    /* renamed from: b */
    <T extends C9268b> T mo33566b(C32247e c32247e);

    /* renamed from: d */
    void mo33567d(C8955k c8955k);

    void dlS();

    C16051a dlT();

    <T extends C9268b> T dlU();

    Bitmap dlV();

    boolean dlW();

    C25785a getConfig();

    Context getContext();

    float getCurScale();

    C32247e[] getFeatures();

    float getInitScale();

    C8956r getSelectedFeatureListener();

    void onAttachedToWindow();

    void onDestroy();

    void onDraw(Canvas canvas);

    void onExit();

    void onFinish();

    void setActionBarCallback(C32249g c32249g);

    void setAutoShowFooterAndBar(boolean z);
}
