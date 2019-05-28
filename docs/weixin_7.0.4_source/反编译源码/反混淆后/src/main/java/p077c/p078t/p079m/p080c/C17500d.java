package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* renamed from: c.t.m.c.d */
public class C17500d {
    /* renamed from: c */
    static C17500d f4039c = null;
    /* renamed from: a */
    Context f4040a = null;
    /* renamed from: b */
    Map<String, FileChannel> f4041b = null;

    protected C17500d(Context context) {
        AppMethodBeat.m2504i(136338);
        this.f4040a = context;
        this.f4041b = new HashMap(5);
        AppMethodBeat.m2505o(136338);
    }

    /* renamed from: a */
    public static synchronized C17500d m27317a(Context context) {
        C17500d c17500d;
        synchronized (C17500d.class) {
            AppMethodBeat.m2504i(136339);
            if (f4039c == null) {
                f4039c = new C17500d(context);
            }
            c17500d = f4039c;
            AppMethodBeat.m2505o(136339);
        }
        return c17500d;
    }

    /* renamed from: a */
    public synchronized boolean mo31932a(String str) {
        boolean z;
        AppMethodBeat.m2504i(136340);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.m2505o(136340);
            z = false;
        } else {
            File c = mo31934c(str);
            if (c == null) {
                AppMethodBeat.m2505o(136340);
                z = true;
            } else {
                try {
                    FileChannel fileChannel = (FileChannel) this.f4041b.get(str);
                    if (fileChannel == null || !fileChannel.isOpen()) {
                        fileChannel = new FileOutputStream(c).getChannel();
                        this.f4041b.put(str, fileChannel);
                    }
                    FileLock lock = fileChannel.lock();
                    if (lock != null && lock.isValid()) {
                        AppMethodBeat.m2505o(136340);
                        z = true;
                    }
                } catch (Throwable th) {
                }
                AppMethodBeat.m2505o(136340);
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public synchronized void mo31933b(String str) {
        AppMethodBeat.m2504i(136341);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.m2505o(136341);
        } else {
            try {
                FileChannel fileChannel = (FileChannel) this.f4041b.get(str);
                if (fileChannel != null) {
                    fileChannel.close();
                }
                AppMethodBeat.m2505o(136341);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(136341);
            }
        }
        return;
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* renamed from: c */
    public synchronized File mo31934c(String str) {
        File file;
        AppMethodBeat.m2504i(136342);
        try {
            file = new File(this.f4040a.getFilesDir(), "TencentLocationCoverSDK_" + str + ".lock");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            file = null;
        }
        AppMethodBeat.m2505o(136342);
        return file;
    }
}
