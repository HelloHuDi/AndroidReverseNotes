package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public final class l {
    public byte[] data;
    public int limit;
    public int position;

    public l(int i) {
        AppMethodBeat.i(95903);
        this.data = new byte[i];
        this.limit = i;
        AppMethodBeat.o(95903);
    }

    public l(byte[] bArr) {
        AppMethodBeat.i(95904);
        this.data = bArr;
        this.limit = bArr.length;
        AppMethodBeat.o(95904);
    }

    public l(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
    }

    public final void reset(int i) {
        AppMethodBeat.i(95905);
        n(capacity() < i ? new byte[i] : this.data, i);
        AppMethodBeat.o(95905);
    }

    public final void n(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public final int tB() {
        return this.limit - this.position;
    }

    public final void eL(int i) {
        AppMethodBeat.i(95906);
        boolean z = i >= 0 && i <= this.data.length;
        a.checkArgument(z);
        this.limit = i;
        AppMethodBeat.o(95906);
    }

    public final int capacity() {
        return this.data == null ? 0 : this.data.length;
    }

    public final void setPosition(int i) {
        boolean z = true;
        AppMethodBeat.i(95907);
        if (i < 0 || i > this.limit) {
            b.i("ExoPlayer", "position%d, limit:%d", Integer.valueOf(i), Integer.valueOf(this.limit));
        }
        if (i < 0 || i > this.limit) {
            z = false;
        }
        a.checkArgument(z);
        this.position = i;
        AppMethodBeat.o(95907);
    }

    public final void eM(int i) {
        AppMethodBeat.i(95908);
        setPosition(this.position + i);
        AppMethodBeat.o(95908);
    }

    public final void c(k kVar, int i) {
        AppMethodBeat.i(95909);
        readBytes(kVar.data, 0, i);
        kVar.setPosition(0);
        AppMethodBeat.o(95909);
    }

    public final void readBytes(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95910);
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
        AppMethodBeat.o(95910);
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int tC() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    public final int tD() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final long cM() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final long tE() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 24);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int tF() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 24);
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final long tG() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 56);
    }

    public final int tH() {
        AppMethodBeat.i(95911);
        int readUnsignedByte = (((readUnsignedByte() << 21) | (readUnsignedByte() << 14)) | (readUnsignedByte() << 7)) | readUnsignedByte();
        AppMethodBeat.o(95911);
        return readUnsignedByte;
    }

    public final int tI() {
        AppMethodBeat.i(95912);
        int readInt = readInt();
        if (readInt < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(95912);
            throw illegalStateException;
        }
        AppMethodBeat.o(95912);
        return readInt;
    }

    public final int tJ() {
        AppMethodBeat.i(95913);
        int tF = tF();
        if (tF < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(tF)));
            AppMethodBeat.o(95913);
            throw illegalStateException;
        }
        AppMethodBeat.o(95913);
        return tF;
    }

    public final long tK() {
        AppMethodBeat.i(95914);
        long readLong = readLong();
        if (readLong < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(readLong)));
            AppMethodBeat.o(95914);
            throw illegalStateException;
        }
        AppMethodBeat.o(95914);
        return readLong;
    }

    public final String readString(int i) {
        AppMethodBeat.i(95915);
        String a = a(i, Charset.forName("UTF-8"));
        AppMethodBeat.o(95915);
        return a;
    }

    public final String a(int i, Charset charset) {
        AppMethodBeat.i(95916);
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        AppMethodBeat.o(95916);
        return str;
    }

    public final String eN(int i) {
        AppMethodBeat.i(95917);
        if (i == 0) {
            String str = "";
            AppMethodBeat.o(95917);
            return str;
        }
        int i2 = (this.position + i) - 1;
        if (i2 >= this.limit || this.data[i2] != (byte) 0) {
            i2 = i;
        } else {
            i2 = i - 1;
        }
        String str2 = new String(this.data, this.position, i2);
        this.position += i;
        AppMethodBeat.o(95917);
        return str2;
    }

    public final String tL() {
        AppMethodBeat.i(95918);
        if (tB() == 0) {
            AppMethodBeat.o(95918);
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != (byte) 0) {
            i++;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position < this.limit) {
            this.position++;
        }
        AppMethodBeat.o(95918);
        return str;
    }

    public final String readLine() {
        AppMethodBeat.i(95919);
        if (tB() == 0) {
            AppMethodBeat.o(95919);
            return null;
        }
        int i = this.position;
        while (i < this.limit && !v.eQ(this.data[i])) {
            i++;
        }
        if (i - this.position >= 3 && this.data[this.position] == (byte) -17 && this.data[this.position + 1] == (byte) -69 && this.data[this.position + 2] == (byte) -65) {
            this.position += 3;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position == this.limit) {
            AppMethodBeat.o(95919);
            return str;
        }
        if (this.data[this.position] == (byte) 13) {
            this.position++;
            if (this.position == this.limit) {
                AppMethodBeat.o(95919);
                return str;
            }
        }
        if (this.data[this.position] == (byte) 10) {
            this.position++;
        }
        AppMethodBeat.o(95919);
        return str;
    }
}
