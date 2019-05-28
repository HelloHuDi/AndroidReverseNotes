package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class e {
    public static String T(InputStream inputStream) {
        AppMethodBeat.i(77314);
        d.r(inputStream, "Cannot get String from a null object");
        try {
            char[] cArr = new char[65536];
            StringBuilder stringBuilder = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            int read;
            do {
                read = inputStreamReader.read(cArr, 0, 65536);
                if (read > 0) {
                    stringBuilder.append(cArr, 0, read);
                    continue;
                }
            } while (read >= 0);
            inputStreamReader.close();
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(77314);
            return stringBuilder2;
        } catch (IOException e) {
            IllegalStateException illegalStateException = new IllegalStateException("Error while reading response body", e);
            AppMethodBeat.o(77314);
            throw illegalStateException;
        }
    }
}
