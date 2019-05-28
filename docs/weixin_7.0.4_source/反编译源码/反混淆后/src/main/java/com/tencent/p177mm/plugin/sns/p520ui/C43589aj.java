package com.tencent.p177mm.plugin.sns.p520ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;

/* renamed from: com.tencent.mm.plugin.sns.ui.aj */
public final class C43589aj {
    public String cwT;
    public int position;
    public boolean qFG = false;
    public C34915a qzM;
    public ImageView raP;
    public TextView raQ;
    public TimeLineObject rnr;
    public View rns;
    public View rnt;
    public MMPinProgressBtn rnu;
    public TextView rnv;
    public boolean rnw = false;
    public int rnx = 0;

    /* renamed from: a */
    public final void mo69200a(TimeLineObject timeLineObject, int i, String str, boolean z) {
        this.rnr = timeLineObject;
        this.position = i;
        this.cwT = str;
        this.qFG = z;
    }
}
