package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class d {
    static d c = null;
    Context a = null;
    Map<String, FileChannel> b = null;

    protected d(Context context) {
        AppMethodBeat.i(136338);
        this.a = context;
        this.b = new HashMap(5);
        AppMethodBeat.o(136338);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(136339);
            if (c == null) {
                c = new d(context);
            }
            dVar = c;
            AppMethodBeat.o(136339);
        }
        return dVar;
    }

    public synchronized boolean a(String str) {
        boolean z;
        AppMethodBeat.i(136340);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.o(136340);
            z = false;
        } else {
            File c = c(str);
            if (c == null) {
                AppMethodBeat.o(136340);
                z = true;
            } else {
                try {
                    FileChannel fileChannel = (FileChannel) this.b.get(str);
                    if (fileChannel == null || !fileChannel.isOpen()) {
                        fileChannel = new FileOutputStream(c).getChannel();
                        this.b.put(str, fileChannel);
                    }
                    FileLock lock = fileChannel.lock();
                    if (lock != null && lock.isValid()) {
                        AppMethodBeat.o(136340);
                        z = true;
                    }
                } catch (Throwable th) {
                }
                AppMethodBeat.o(136340);
                z = false;
            }
        }
        return z;
    }

    public synchronized void b(String str) {
        AppMethodBeat.i(136341);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.o(136341);
        } else {
            try {
                FileChannel fileChannel = (FileChannel) this.b.get(str);
                if (fileChannel != null) {
                    fileChannel.close();
                }
                AppMethodBeat.o(136341);
            } catch (Throwable th) {
                AppMethodBeat.o(136341);
            }
        }
        return;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized File c(String str) {
        File file;
        AppMethodBeat.i(136342);
        try {
            file = new File(this.a.getFilesDir(), "TencentLocationCoverSDK_" + str + ".lock");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            file = null;
        }
        AppMethodBeat.o(136342);
        return file;
    }
}
