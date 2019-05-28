package com.google.android.gms.common.server.response;

import android.content.ContentValues;
import com.google.android.gms.common.util.VisibleForTesting;

public abstract class FastContentValuesJsonResponse extends FastJsonResponse {
    private final ContentValues zzwj;

    public FastContentValuesJsonResponse() {
        this.zzwj = new ContentValues();
    }

    @VisibleForTesting
    public FastContentValuesJsonResponse(ContentValues contentValues) {
        this.zzwj = contentValues;
    }

    /* Access modifiers changed, original: protected */
    public Object getValueObject(String str) {
        return this.zzwj.get(str);
    }

    public ContentValues getValues() {
        return this.zzwj;
    }

    /* Access modifiers changed, original: protected */
    public boolean isPrimitiveFieldSet(String str) {
        return this.zzwj.containsKey(str);
    }

    /* Access modifiers changed, original: protected */
    public void setBoolean(String str, boolean z) {
        this.zzwj.put(str, Boolean.valueOf(z));
    }

    /* Access modifiers changed, original: protected */
    public void setDecodedBytes(String str, byte[] bArr) {
        this.zzwj.put(str, bArr);
    }

    /* Access modifiers changed, original: protected */
    public void setDouble(String str, double d) {
        this.zzwj.put(str, Double.valueOf(d));
    }

    /* Access modifiers changed, original: protected */
    public void setFloat(String str, float f) {
        this.zzwj.put(str, Float.valueOf(f));
    }

    /* Access modifiers changed, original: protected */
    public void setInteger(String str, int i) {
        this.zzwj.put(str, Integer.valueOf(i));
    }

    /* Access modifiers changed, original: protected */
    public void setLong(String str, long j) {
        this.zzwj.put(str, Long.valueOf(j));
    }

    /* Access modifiers changed, original: protected */
    public void setString(String str, String str2) {
        this.zzwj.put(str, str2);
    }
}
