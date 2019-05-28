package com.tencent.p177mm.p230g.p231a;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abt;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.cl */
public final class C45316cl extends C4883b {
    public C26105a cvA;
    public C9307b cvB;

    /* renamed from: com.tencent.mm.g.a.cl$b */
    public static final class C9307b {
        public int ret = 0;
    }

    /* renamed from: com.tencent.mm.g.a.cl$a */
    public static final class C26105a {
        public Activity activity;
        public abf cvC;
        public abt cvD;
        public int cvE = 0;
        public String cvF;
        public int cvG = 0;
        public int cvH = 0;
        public OnClickListener cvI;
        public C24112c cvJ;
        public String cvq;
        public String desc;
        public Fragment fragment;
        public int scene = 0;
        public String title;
        public int type = 0;
    }

    public C45316cl() {
        this((byte) 0);
    }

    private C45316cl(byte b) {
        AppMethodBeat.m2504i(51335);
        this.cvA = new C26105a();
        this.cvB = new C9307b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(51335);
    }
}
