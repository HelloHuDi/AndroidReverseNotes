package com.tencent.p177mm.plugin.sns.model.p519a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.model.a.a */
public final class C46216a {
    public String cFc;
    public String cHr = "";
    public String cvZ = "";
    public C39731e qFJ = null;
    public SparseArray<C39731e> qFK;
    public String qFR = "";
    public String qFS = "";
    public SparseArray<bau> qFU;
    public String qJc = "";
    public String qJg = "";
    public bau qJh;
    public boolean qNT = false;
    public boolean qNU = false;
    public int qNV = 0;
    public C44222az qNW;
    public float qNX = 0.0f;
    public int size;
    public String url = "";

    public C46216a(String str) {
        this.cHr = str;
    }

    public C46216a(String str, SparseArray<bau> sparseArray, SparseArray<C39731e> sparseArray2, int i) {
        this.cFc = str;
        this.qFU = sparseArray;
        this.qFK = sparseArray2;
        this.size = i;
    }

    /* renamed from: EK */
    public final boolean mo74230EK() {
        AppMethodBeat.m2504i(36742);
        this.qJc = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.cHr);
        AppMethodBeat.m2505o(36742);
        return true;
    }

    /* renamed from: gf */
    public final C46216a mo74233gf(String str, String str2) {
        this.qFR = str;
        this.qFS = str2;
        return this;
    }

    public final String cop() {
        AppMethodBeat.m2504i(36743);
        String p;
        if (this.qNV == 4) {
            p = C29036i.m46126p(this.qJh);
            AppMethodBeat.m2505o(36743);
            return p;
        } else if (this.qNV == 6) {
            p = C29036i.m46127q(this.qJh);
            AppMethodBeat.m2505o(36743);
            return p;
        } else if (this.qNT) {
            p = C29036i.m46123n(this.qJh);
            AppMethodBeat.m2505o(36743);
            return p;
        } else {
            p = C29036i.m46122m(this.qJh);
            AppMethodBeat.m2505o(36743);
            return p;
        }
    }

    public final String getPath() {
        AppMethodBeat.m2504i(36744);
        String str;
        if (C5046bo.isNullOrNil(this.qFR)) {
            if (C5046bo.isNullOrNil(this.qJc)) {
                mo74230EK();
            }
            str = this.qJc;
            AppMethodBeat.m2505o(36744);
            return str;
        }
        str = this.qFR;
        AppMethodBeat.m2505o(36744);
        return str;
    }
}
