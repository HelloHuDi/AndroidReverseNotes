package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    @KeepForSdk
    public DataBufferResponse(R r) {
        super(r);
    }

    public void close() {
        AppMethodBeat.m2504i(60498);
        ((AbstractDataBuffer) getResult()).close();
        AppMethodBeat.m2505o(60498);
    }

    public T get(int i) {
        AppMethodBeat.m2504i(60496);
        Object obj = ((AbstractDataBuffer) getResult()).get(i);
        AppMethodBeat.m2505o(60496);
        return obj;
    }

    public int getCount() {
        AppMethodBeat.m2504i(60495);
        int count = ((AbstractDataBuffer) getResult()).getCount();
        AppMethodBeat.m2505o(60495);
        return count;
    }

    public Bundle getMetadata() {
        AppMethodBeat.m2504i(60497);
        Bundle metadata = ((AbstractDataBuffer) getResult()).getMetadata();
        AppMethodBeat.m2505o(60497);
        return metadata;
    }

    public boolean isClosed() {
        AppMethodBeat.m2504i(60499);
        boolean isClosed = ((AbstractDataBuffer) getResult()).isClosed();
        AppMethodBeat.m2505o(60499);
        return isClosed;
    }

    public Iterator<T> iterator() {
        AppMethodBeat.m2504i(60500);
        Iterator it = ((AbstractDataBuffer) getResult()).iterator();
        AppMethodBeat.m2505o(60500);
        return it;
    }

    public void release() {
        AppMethodBeat.m2504i(60502);
        ((AbstractDataBuffer) getResult()).release();
        AppMethodBeat.m2505o(60502);
    }

    public Iterator<T> singleRefIterator() {
        AppMethodBeat.m2504i(60501);
        Iterator singleRefIterator = ((AbstractDataBuffer) getResult()).singleRefIterator();
        AppMethodBeat.m2505o(60501);
        return singleRefIterator;
    }
}
