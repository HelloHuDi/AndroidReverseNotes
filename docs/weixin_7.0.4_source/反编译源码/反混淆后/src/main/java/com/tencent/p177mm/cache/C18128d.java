package com.tencent.p177mm.cache;

import android.graphics.Canvas;

/* renamed from: com.tencent.mm.cache.d */
public interface C18128d<T> extends Cloneable {
    /* renamed from: CO */
    void mo33613CO();

    /* renamed from: Je */
    void mo33614Je();

    /* renamed from: a */
    void mo33615a(Canvas canvas, boolean z);

    /* renamed from: ac */
    int mo33616ac(boolean z);

    void add(T t);

    /* renamed from: b */
    void mo33618b(Canvas canvas);

    /* renamed from: by */
    void mo33619by(boolean z);

    void onCreate();

    void onDestroy();

    T pop();
}
