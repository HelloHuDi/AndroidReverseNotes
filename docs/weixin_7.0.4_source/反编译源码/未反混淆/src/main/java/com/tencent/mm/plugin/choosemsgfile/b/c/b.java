package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public abstract class b implements h {
    protected String edV;
    protected ArrayList<a> iPr = new ArrayList();
    protected com.tencent.mm.plugin.choosemsgfile.ui.a kuT;

    public b(com.tencent.mm.plugin.choosemsgfile.ui.a aVar) {
        this.kuT = aVar;
        this.edV = aVar.getUserName();
    }

    public void dx(String str, String str2) {
        ab.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", str, str2);
        b(true, str, str2);
    }

    public void onResume() {
        ab.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
    }

    public void onPause() {
        ab.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
    }

    public void onDestroy() {
        ab.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.vending.e.b bfA() {
        return this.kuT.getContext() instanceof com.tencent.mm.vending.e.b ? (com.tencent.mm.vending.e.b) this.kuT.getContext() : null;
    }
}
