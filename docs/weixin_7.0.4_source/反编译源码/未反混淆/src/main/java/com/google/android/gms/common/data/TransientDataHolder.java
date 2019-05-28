package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder.Builder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TransientDataHolder {
    private String zzos;
    private String zzot;
    private Builder zzou;

    public TransientDataHolder(String[] strArr) {
        this(strArr, null, null, null);
    }

    public TransientDataHolder(String[] strArr, String str, String str2, String str3) {
        AppMethodBeat.i(61187);
        this.zzos = str2;
        this.zzot = str3;
        if (str != null) {
            this.zzou = DataHolder.builder(strArr, str);
            AppMethodBeat.o(61187);
            return;
        }
        this.zzou = DataHolder.builder(strArr);
        AppMethodBeat.o(61187);
    }

    public final void addRow(ContentValues contentValues) {
        AppMethodBeat.i(61188);
        this.zzou.withRow(contentValues);
        AppMethodBeat.o(61188);
    }

    @VisibleForTesting
    public final DataHolder build(int i) {
        AppMethodBeat.i(61195);
        DataHolder build = build(i, new Bundle(), -1);
        AppMethodBeat.o(61195);
        return build;
    }

    public final DataHolder build(int i, Bundle bundle, int i2) {
        AppMethodBeat.i(61196);
        bundle.putString(DataBufferUtils.KEY_NEXT_PAGE_TOKEN, this.zzot);
        bundle.putString(DataBufferUtils.KEY_PREV_PAGE_TOKEN, this.zzos);
        DataHolder build = this.zzou.build(i, bundle, i2);
        AppMethodBeat.o(61196);
        return build;
    }

    public final boolean containsRowWithValue(String str, Object obj) {
        AppMethodBeat.i(61189);
        boolean containsRowWithValue = this.zzou.containsRowWithValue(str, obj);
        AppMethodBeat.o(61189);
        return containsRowWithValue;
    }

    public final int getCount() {
        AppMethodBeat.i(61192);
        int count = this.zzou.getCount();
        AppMethodBeat.o(61192);
        return count;
    }

    public final String getNextToken() {
        return this.zzot;
    }

    public final String getPrevToken() {
        return this.zzos;
    }

    public final void modifyUniqueRowValue(Object obj, String str, Object obj2) {
        AppMethodBeat.i(61190);
        this.zzou.modifyUniqueRowValue(obj, str, obj2);
        AppMethodBeat.o(61190);
    }

    @VisibleForTesting
    public final void removeRows(String str, Object obj) {
        AppMethodBeat.i(61191);
        this.zzou.removeRowsWithValue(str, obj);
        AppMethodBeat.o(61191);
    }

    public final void setNextToken(String str) {
        this.zzot = str;
    }

    public final void setPrevToken(String str) {
        this.zzos = str;
    }

    public final void sortData(String str) {
        AppMethodBeat.i(61193);
        this.zzou.sort(str);
        AppMethodBeat.o(61193);
    }

    public final void sortDataDescending(String str) {
        AppMethodBeat.i(61194);
        this.zzou.descendingSort(str);
        AppMethodBeat.o(61194);
    }
}
