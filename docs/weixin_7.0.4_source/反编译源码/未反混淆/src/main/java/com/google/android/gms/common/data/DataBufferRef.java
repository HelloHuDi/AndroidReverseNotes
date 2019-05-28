package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zznj;

    public DataBufferRef(DataHolder dataHolder, int i) {
        AppMethodBeat.i(61049);
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        setDataRow(i);
        AppMethodBeat.o(61049);
    }

    /* Access modifiers changed, original: protected */
    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(61061);
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.zznj, charArrayBuffer);
        AppMethodBeat.o(61061);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(61064);
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.zznj), Integer.valueOf(this.zznj)) && dataBufferRef.mDataHolder == this.mDataHolder) {
                AppMethodBeat.o(61064);
                return true;
            }
            AppMethodBeat.o(61064);
            return false;
        }
        AppMethodBeat.o(61064);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean getBoolean(String str) {
        AppMethodBeat.i(61055);
        boolean z = this.mDataHolder.getBoolean(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61055);
        return z;
    }

    /* Access modifiers changed, original: protected */
    public byte[] getByteArray(String str) {
        AppMethodBeat.i(61059);
        byte[] byteArray = this.mDataHolder.getByteArray(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61059);
        return byteArray;
    }

    /* Access modifiers changed, original: protected */
    public int getDataRow() {
        return this.mDataRow;
    }

    /* Access modifiers changed, original: protected */
    public double getDouble(String str) {
        AppMethodBeat.i(61058);
        double d = this.mDataHolder.getDouble(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61058);
        return d;
    }

    /* Access modifiers changed, original: protected */
    public float getFloat(String str) {
        AppMethodBeat.i(61057);
        float f = this.mDataHolder.getFloat(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61057);
        return f;
    }

    /* Access modifiers changed, original: protected */
    public int getInteger(String str) {
        AppMethodBeat.i(61054);
        int integer = this.mDataHolder.getInteger(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61054);
        return integer;
    }

    /* Access modifiers changed, original: protected */
    public long getLong(String str) {
        AppMethodBeat.i(61053);
        long j = this.mDataHolder.getLong(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61053);
        return j;
    }

    /* Access modifiers changed, original: protected */
    public String getString(String str) {
        AppMethodBeat.i(61056);
        String string = this.mDataHolder.getString(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61056);
        return string;
    }

    public boolean hasColumn(String str) {
        AppMethodBeat.i(61052);
        boolean hasColumn = this.mDataHolder.hasColumn(str);
        AppMethodBeat.o(61052);
        return hasColumn;
    }

    /* Access modifiers changed, original: protected */
    public boolean hasNull(String str) {
        AppMethodBeat.i(61062);
        boolean hasNull = this.mDataHolder.hasNull(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61062);
        return hasNull;
    }

    public int hashCode() {
        AppMethodBeat.i(61063);
        int hashCode = Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zznj), this.mDataHolder);
        AppMethodBeat.o(61063);
        return hashCode;
    }

    public boolean isDataValid() {
        AppMethodBeat.i(61051);
        if (this.mDataHolder.isClosed()) {
            AppMethodBeat.o(61051);
            return false;
        }
        AppMethodBeat.o(61051);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public Uri parseUri(String str) {
        AppMethodBeat.i(61060);
        Uri parseUri = this.mDataHolder.parseUri(str, this.mDataRow, this.zznj);
        AppMethodBeat.o(61060);
        return parseUri;
    }

    /* Access modifiers changed, original: protected */
    public void setDataRow(int i) {
        AppMethodBeat.i(61050);
        boolean z = i >= 0 && i < this.mDataHolder.getCount();
        Preconditions.checkState(z);
        this.mDataRow = i;
        this.zznj = this.mDataHolder.getWindowIndex(this.mDataRow);
        AppMethodBeat.o(61050);
    }
}
