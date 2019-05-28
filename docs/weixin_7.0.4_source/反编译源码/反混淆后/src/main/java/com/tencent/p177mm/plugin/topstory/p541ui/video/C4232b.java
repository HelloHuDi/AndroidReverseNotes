package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.graphics.Point;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.view.View;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.b */
public interface C4232b {
    /* renamed from: DX */
    boolean mo9156DX();

    /* renamed from: FC */
    boolean mo9157FC(int i);

    /* renamed from: FD */
    void mo9158FD(int i);

    /* renamed from: FE */
    void mo9159FE(int i);

    /* renamed from: a */
    void mo9160a(bzs bzs);

    /* renamed from: a */
    void mo9161a(chw chw);

    void abH(String str);

    void abI(String str);

    /* renamed from: ad */
    void mo9164ad(View view, int i);

    MMActivity bKU();

    void cFN();

    void cFO();

    C4239l cFQ();

    C46311o cFR();

    String cFS();

    chv cFT();

    C13979m cFU();

    C39996r cFV();

    Point cFW();

    C17487am cFX();

    int cFY();

    boolean cFZ();

    C4233e cGa();

    boolean cGb();

    void cGc();

    int cGd();

    void cGe();

    void cGf();

    C13986n cGg();

    String cGh();

    int cGi();

    void cGj();

    int cGk();

    /* renamed from: fS */
    boolean mo9189fS(int i, int i2);

    C17480i getLayoutManager();

    RecyclerView getRecyclerView();

    int getVideoHeight();

    int getVideoWidth();

    /* renamed from: i */
    void mo9194i(List<chw> list, boolean z);

    boolean isFullscreenMode();
}
