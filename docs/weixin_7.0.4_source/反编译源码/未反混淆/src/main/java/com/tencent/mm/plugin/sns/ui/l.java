package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.protocal.protobuf.cat;

public final class l implements a {
    public String jBB = "";
    public String ncM = "";
    public cat qJj;
    public String ria = "";
    public String rib = "";
    public View ric;
    public int scene = -1;
    public Object tag;

    public l(String str, String str2, cat cat, String str3, String str4, View view, int i) {
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
