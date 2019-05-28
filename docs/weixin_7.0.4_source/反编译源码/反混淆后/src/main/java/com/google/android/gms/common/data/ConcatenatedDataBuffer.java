package com.google.android.gms.common.data;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.data.TextFilterable.StringFilter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
public final class ConcatenatedDataBuffer<T> implements DataBuffer<T>, ExclusionFilterable, TextFilterable {
    private Bundle mBundle;
    private final ArrayList<DataBuffer<T>> zznf = new ArrayList();
    private final ArrayList<Integer> zzng = new ArrayList();
    private int zznh;

    public ConcatenatedDataBuffer() {
        AppMethodBeat.m2504i(61020);
        AppMethodBeat.m2505o(61020);
    }

    public ConcatenatedDataBuffer(DataBuffer<T> dataBuffer) {
        AppMethodBeat.m2504i(61021);
        append(dataBuffer);
        AppMethodBeat.m2505o(61021);
    }

    public static <T> ConcatenatedDataBuffer<T> extend(ConcatenatedDataBuffer<T> concatenatedDataBuffer, DataBuffer<T> dataBuffer) {
        AppMethodBeat.m2504i(61029);
        ConcatenatedDataBuffer concatenatedDataBuffer2 = new ConcatenatedDataBuffer();
        ArrayList arrayList = concatenatedDataBuffer.zznf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            concatenatedDataBuffer2.append((DataBuffer) obj);
        }
        concatenatedDataBuffer2.append(dataBuffer);
        AppMethodBeat.m2505o(61029);
        return concatenatedDataBuffer2;
    }

    public final void append(DataBuffer<T> dataBuffer) {
        AppMethodBeat.m2504i(61024);
        if (dataBuffer == null) {
            AppMethodBeat.m2505o(61024);
            return;
        }
        synchronized (this) {
            try {
                Bundle metadata;
                if (this.zznf.isEmpty()) {
                    this.mBundle = new Bundle();
                    metadata = dataBuffer.getMetadata();
                    if (metadata != null) {
                        this.mBundle.putString(DataBufferUtils.KEY_PREV_PAGE_TOKEN, metadata.getString(DataBufferUtils.KEY_PREV_PAGE_TOKEN));
                    }
                }
                this.zznf.add(dataBuffer);
                computeCounts();
                metadata = dataBuffer.getMetadata();
                if (metadata != null) {
                    this.mBundle.putString(DataBufferUtils.KEY_NEXT_PAGE_TOKEN, metadata.getString(DataBufferUtils.KEY_NEXT_PAGE_TOKEN));
                } else {
                    this.mBundle.remove(DataBufferUtils.KEY_NEXT_PAGE_TOKEN);
                }
            } finally {
                AppMethodBeat.m2505o(61024);
            }
        }
    }

    public final void clearFilters() {
        AppMethodBeat.m2504i(61032);
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).clearFilters();
            }
        }
        computeCounts();
        AppMethodBeat.m2505o(61032);
    }

    @Deprecated
    public final void close() {
        AppMethodBeat.m2504i(61025);
        release();
        AppMethodBeat.m2505o(61025);
    }

    public final void computeCounts() {
        AppMethodBeat.m2504i(61028);
        this.zzng.clear();
        int size = this.zznf.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
            int count = dataBuffer != null ? dataBuffer.getCount() + i2 : i2;
            this.zzng.add(Integer.valueOf(count));
            i++;
            i2 = count;
        }
        this.zznh = i2;
        AppMethodBeat.m2505o(61028);
    }

    public final void filterOut(String str) {
        AppMethodBeat.m2504i(61030);
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).filterOut(str);
            }
        }
        computeCounts();
        AppMethodBeat.m2505o(61030);
    }

    public final T get(int i) {
        T t;
        AppMethodBeat.m2504i(61022);
        synchronized (this) {
            try {
                int size = this.zznf.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int intValue = ((Integer) this.zzng.get(i2)).intValue();
                    if (i < intValue) {
                        DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i2);
                        if (dataBuffer != null) {
                            t = dataBuffer.get((i - intValue) + dataBuffer.getCount());
                            break;
                        }
                    }
                }
                t = null;
                AppMethodBeat.m2505o(61022);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(61022);
            }
        }
        return t;
    }

    public final int getCount() {
        int i;
        synchronized (this) {
            i = this.zznh;
        }
        return i;
    }

    public final Bundle getMetadata() {
        Bundle bundle;
        synchronized (this) {
            bundle = this.mBundle;
        }
        return bundle;
    }

    @Deprecated
    public final boolean isClosed() {
        return false;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(61026);
        DataBufferIterator dataBufferIterator = new DataBufferIterator(this);
        AppMethodBeat.m2505o(61026);
        return dataBufferIterator;
    }

    public final void release() {
        AppMethodBeat.m2504i(61023);
        synchronized (this) {
            try {
                int size = this.zznf.size();
                for (int i = 0; i < size; i++) {
                    DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
                    if (dataBuffer != null) {
                        dataBuffer.release();
                    }
                }
                this.zznf.clear();
                this.zzng.clear();
                this.mBundle = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(61023);
            }
        }
    }

    public final void setFilterTerm(Context context, StringFilter stringFilter, String str) {
        AppMethodBeat.m2504i(61034);
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
            if (dataBuffer instanceof TextFilterable) {
                ((TextFilterable) dataBuffer).setFilterTerm(context, stringFilter, str);
            }
        }
        computeCounts();
        AppMethodBeat.m2505o(61034);
    }

    public final void setFilterTerm(Context context, String str) {
        AppMethodBeat.m2504i(61033);
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
            if (dataBuffer instanceof TextFilterable) {
                ((TextFilterable) dataBuffer).setFilterTerm(context, str);
            }
        }
        computeCounts();
        AppMethodBeat.m2505o(61033);
    }

    public final Iterator<T> singleRefIterator() {
        AppMethodBeat.m2504i(61027);
        Iterator it = iterator();
        AppMethodBeat.m2505o(61027);
        return it;
    }

    public final void unfilter(String str) {
        AppMethodBeat.m2504i(61031);
        int size = this.zznf.size();
        for (int i = 0; i < size; i++) {
            DataBuffer dataBuffer = (DataBuffer) this.zznf.get(i);
            if (dataBuffer instanceof ExclusionFilterable) {
                ((ExclusionFilterable) dataBuffer).unfilter(str);
            }
        }
        computeCounts();
        AppMethodBeat.m2505o(61031);
    }
}
