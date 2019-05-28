package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class c {
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    static {
        AppMethodBeat.i(51813);
        AppMethodBeat.o(51813);
    }

    static void l(File file) {
        AppMethodBeat.i(51811);
        File[] listFiles = file.listFiles();
        IOException iOException;
        if (listFiles == null) {
            iOException = new IOException("not a readable directory: ".concat(String.valueOf(file)));
            AppMethodBeat.o(51811);
            throw iOException;
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                l(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                iOException = new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                AppMethodBeat.o(51811);
                throw iOException;
            }
        }
        AppMethodBeat.o(51811);
    }

    static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(51812);
        try {
            closeable.close();
            AppMethodBeat.o(51812);
        } catch (RuntimeException e) {
            AppMethodBeat.o(51812);
            throw e;
        } catch (Exception e2) {
            AppMethodBeat.o(51812);
        }
    }
}
