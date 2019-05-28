package com.google.android.gms.common.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class DataBufferUtils {
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";
    public static final String PAGE_PLACEHOLDER_TOKEN = "has_local_data";

    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        AppMethodBeat.m2504i(61069);
        ArrayList arrayList = new ArrayList(dataBuffer.getCount());
        try {
            for (E freeze : dataBuffer) {
                arrayList.add(freeze.freeze());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
            AppMethodBeat.m2505o(61069);
        }
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        AppMethodBeat.m2504i(61072);
        if (dataBuffer == null || dataBuffer.getCount() <= 0) {
            AppMethodBeat.m2505o(61072);
            return false;
        }
        AppMethodBeat.m2505o(61072);
        return true;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        AppMethodBeat.m2504i(61070);
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata == null || metadata.getString(KEY_NEXT_PAGE_TOKEN) == null) {
            AppMethodBeat.m2505o(61070);
            return false;
        }
        AppMethodBeat.m2505o(61070);
        return true;
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        AppMethodBeat.m2504i(61071);
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata == null || metadata.getString(KEY_PREV_PAGE_TOKEN) == null) {
            AppMethodBeat.m2505o(61071);
            return false;
        }
        AppMethodBeat.m2505o(61071);
        return true;
    }
}
