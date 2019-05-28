package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;

public final class a {
    public String cFc;
    public String cHr = "";
    public String cvZ = "";
    public e qFJ = null;
    public SparseArray<e> qFK;
    public String qFR = "";
    public String qFS = "";
    public SparseArray<bau> qFU;
    public String qJc = "";
    public String qJg = "";
    public bau qJh;
    public boolean qNT = false;
    public boolean qNU = false;
    public int qNV = 0;
    public az qNW;
    public float qNX = 0.0f;
    public int size;
    public String url = "";

    public a(String str) {
        this.cHr = str;
    }

    public a(String str, SparseArray<bau> sparseArray, SparseArray<e> sparseArray2, int i) {
        this.cFc = str;
        this.qFU = sparseArray;
        this.qFK = sparseArray2;
        this.size = i;
    }

    public final boolean EK() {
        AppMethodBeat.i(36742);
        this.qJc = an.fZ(af.getAccSnsPath(), this.cHr);
        AppMethodBeat.o(36742);
        return true;
    }

    public final a gf(String str, String str2) {
        this.qFR = str;
        this.qFS = str2;
        return this;
    }

    public final String cop() {
        AppMethodBeat.i(36743);
        String p;
        if (this.qNV == 4) {
            p = i.p(this.qJh);
            AppMethodBeat.o(36743);
            return p;
        } else if (this.qNV == 6) {
            p = i.q(this.qJh);
            AppMethodBeat.o(36743);
            return p;
        } else if (this.qNT) {
            p = i.n(this.qJh);
            AppMethodBeat.o(36743);
            return p;
        } else {
            p = i.m(this.qJh);
            AppMethodBeat.o(36743);
            return p;
        }
    }

    public final String getPath() {
        AppMethodBeat.i(36744);
        String str;
        if (bo.isNullOrNil(this.qFR)) {
            if (bo.isNullOrNil(this.qJc)) {
                EK();
            }
            str = this.qJc;
            AppMethodBeat.o(36744);
            return str;
        }
        str = this.qFR;
        AppMethodBeat.o(36744);
        return str;
    }
}
