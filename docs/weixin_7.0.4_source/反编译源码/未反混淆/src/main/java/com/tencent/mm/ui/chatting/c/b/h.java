package com.tencent.mm.ui.chatting.c.b;

import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c;
import com.tencent.mm.ui.chatting.c.v;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.s.g;
import com.tencent.mm.ui.x;
import java.util.Set;

public interface h extends a, v {
    void B(long j, boolean z);

    bi Ou(int i);

    void Ov(int i);

    void Ow(int i);

    void a(int i, d.a aVar);

    void a(long j, bi biVar, boolean z);

    void a(long j, boolean z, d.a aVar);

    void bvQ();

    void c(OnClickListener onClickListener);

    int cdf();

    int dCP();

    Set<Long> dCQ();

    void dCR();

    void dCS();

    void dCT();

    void dCU();

    void dCV();

    void dCW();

    t.a dCX();

    f dCY();

    g dCZ();

    x dDa();

    l dDb();

    c dDc();

    long dDd();

    com.tencent.mm.at.a.a.c dDe();

    int getCount();

    boolean isInEditMode();

    boolean nf(long j);

    void o(long j, int i, int i2);
}
