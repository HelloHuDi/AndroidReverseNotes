package com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c;

import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.C42890a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p639e.C5685b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.b */
public abstract class C33815b implements C2802h {
    protected String edV;
    protected ArrayList<C11376a> iPr = new ArrayList();
    protected C42890a kuT;

    public C33815b(C42890a c42890a) {
        this.kuT = c42890a;
        this.edV = c42890a.getUserName();
    }

    /* renamed from: dx */
    public void mo35455dx(String str, String str2) {
        C4990ab.m7417i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", str, str2);
        mo6921b(true, str, str2);
    }

    public void onResume() {
        C4990ab.m7416i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
    }

    public void onPause() {
        C4990ab.m7416i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
    }

    public void onDestroy() {
        C4990ab.m7416i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
    }

    /* Access modifiers changed, original: protected|final */
    public final C5685b bfA() {
        return this.kuT.getContext() instanceof C5685b ? (C5685b) this.kuT.getContext() : null;
    }
}
