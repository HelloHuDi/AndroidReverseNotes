package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abt;
import com.tencent.mm.ui.widget.snackbar.a.c;

public final class cl extends com.tencent.mm.sdk.b.b {
    public a cvA;
    public b cvB;

    public static final class b {
        public int ret = 0;
    }

    public static final class a {
        public Activity activity;
        public abf cvC;
        public abt cvD;
        public int cvE = 0;
        public String cvF;
        public int cvG = 0;
        public int cvH = 0;
        public OnClickListener cvI;
        public c cvJ;
        public String cvq;
        public String desc;
        public Fragment fragment;
        public int scene = 0;
        public String title;
        public int type = 0;
    }

    public cl() {
        this((byte) 0);
    }

    private cl(byte b) {
        AppMethodBeat.i(51335);
        this.cvA = new a();
        this.cvB = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(51335);
    }
}
