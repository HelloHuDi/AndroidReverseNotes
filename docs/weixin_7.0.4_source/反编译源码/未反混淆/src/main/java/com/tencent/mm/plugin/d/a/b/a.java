package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int jFv = 20;
    private int jFw = 0;
    private int jFx = 0;
    BluetoothGattCharacteristic jFy = null;
    private byte[] mData = null;

    public final void setData(byte[] bArr) {
        AppMethodBeat.i(18361);
        if (bArr == null) {
            this.mData = null;
            this.jFx = 0;
            this.jFw = 0;
            AppMethodBeat.o(18361);
            return;
        }
        this.mData = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.mData, 0, bArr.length);
        this.jFx = bArr.length;
        this.jFw = 0;
        AppMethodBeat.o(18361);
    }

    public final byte[] aVu() {
        AppMethodBeat.i(18362);
        int i = this.jFx - this.jFw;
        if (i == 0) {
            AppMethodBeat.o(18362);
            return null;
        }
        if (i >= this.jFv) {
            i = this.jFv;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.mData, this.jFw, bArr, 0, i);
        this.jFw = i + this.jFw;
        AppMethodBeat.o(18362);
        return bArr;
    }
}
