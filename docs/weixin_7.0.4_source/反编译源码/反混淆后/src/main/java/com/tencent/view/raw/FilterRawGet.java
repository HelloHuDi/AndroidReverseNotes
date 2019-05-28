package com.tencent.view.raw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class FilterRawGet {
    private static GetInputStream mGetInputStream;

    public interface GetInputStream {
        InputStream getInputStream(String str);
    }

    public static void setGetInputStream(GetInputStream getInputStream) {
        mGetInputStream = getInputStream;
    }

    public InputStream getInpuStream(String str) {
        AppMethodBeat.m2504i(86638);
        try {
            InputStream inputStream;
            if (mGetInputStream != null) {
                inputStream = mGetInputStream.getInputStream(str);
            } else {
                inputStream = getClass().getResourceAsStream(str);
            }
            AppMethodBeat.m2505o(86638);
            return inputStream;
        } catch (Exception e) {
            AppMethodBeat.m2505o(86638);
            return null;
        }
    }
}
