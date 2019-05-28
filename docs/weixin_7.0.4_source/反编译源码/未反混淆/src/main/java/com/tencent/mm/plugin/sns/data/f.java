package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.storage.az;

public final class f {
    public String cFc;
    public bau cNr;
    public String key;
    public String qFR;
    public String qFS;
    public az qFT;
    public SparseArray<bau> qFU;
    public int requestType;
    public int size;

    public f() {
        AppMethodBeat.i(35799);
        this.qFU = new SparseArray();
        AppMethodBeat.o(35799);
    }

    public f(String str, SparseArray<bau> sparseArray, String str2, az azVar, int i) {
        this.cFc = str;
        this.qFU = sparseArray;
        this.requestType = 9;
        this.key = str2;
        this.qFT = azVar;
        this.size = i;
    }

    public f(bau bau, int i, String str, az azVar, String str2, String str3) {
        this.cNr = bau;
        this.requestType = i;
        this.qFT = azVar;
        this.key = str;
        this.qFR = str2;
        this.qFS = str3;
    }
}
