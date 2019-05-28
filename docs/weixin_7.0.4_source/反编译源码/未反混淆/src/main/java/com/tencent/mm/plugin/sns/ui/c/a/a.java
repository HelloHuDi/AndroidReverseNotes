package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class a {
    public View contentView;
    public aj rGD;
    public n ros;
    public View rpP;
    protected b rqo;
    protected TimeLineObject timeLineObject;

    public abstract void g(View view, View view2);

    public abstract void refreshView();
}
