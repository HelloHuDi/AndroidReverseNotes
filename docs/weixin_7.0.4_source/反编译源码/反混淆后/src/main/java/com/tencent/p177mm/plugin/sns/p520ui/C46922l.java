package com.tencent.p177mm.plugin.sns.p520ui;

import android.view.View;
import com.tencent.p177mm.pluginsdk.p597ui.p1669d.C46504a;
import com.tencent.p177mm.protocal.protobuf.cat;

/* renamed from: com.tencent.mm.plugin.sns.ui.l */
public final class C46922l implements C46504a {
    public String jBB = "";
    public String ncM = "";
    public cat qJj;
    public String ria = "";
    public String rib = "";
    public View ric;
    public int scene = -1;
    public Object tag;

    public C46922l(String str, String str2, cat cat, String str3, String str4, View view, int i) {
        this.ria = str;
        this.rib = str2;
        this.qJj = cat;
        this.jBB = str3;
        this.ncM = str4;
        this.ric = view;
        this.scene = i;
    }

    public final String getUserName() {
        if (this.qJj == null) {
            return null;
        }
        return this.qJj.vHl;
    }
}
