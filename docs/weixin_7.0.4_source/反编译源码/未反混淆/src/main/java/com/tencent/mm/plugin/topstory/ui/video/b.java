package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.am;
import android.view.View;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public interface b {
    boolean DX();

    boolean FC(int i);

    void FD(int i);

    void FE(int i);

    void a(bzs bzs);

    void a(chw chw);

    void abH(String str);

    void abI(String str);

    void ad(View view, int i);

    MMActivity bKU();

    void cFN();

    void cFO();

    l cFQ();

    o cFR();

    String cFS();

    chv cFT();

    m cFU();

    r cFV();

    Point cFW();

    am cFX();

    int cFY();

    boolean cFZ();

    e cGa();

    boolean cGb();

    void cGc();

    int cGd();

    void cGe();

    void cGf();

    n cGg();

    String cGh();

    int cGi();

    void cGj();

    int cGk();

    boolean fS(int i, int i2);

    i getLayoutManager();

    RecyclerView getRecyclerView();

    int getVideoHeight();

    int getVideoWidth();

    void i(List<chw> list, boolean z);

    boolean isFullscreenMode();
}
