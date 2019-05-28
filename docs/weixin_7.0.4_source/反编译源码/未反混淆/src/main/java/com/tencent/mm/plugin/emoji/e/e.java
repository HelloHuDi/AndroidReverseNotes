package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.io.File;
import java.util.regex.Pattern;

public class e {
    public static e kTK;
    public boolean kTL = false;
    private Pattern kTM = Pattern.compile("_\\d");

    /* renamed from: com.tencent.mm.plugin.emoji.e.e$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$filePath;

        AnonymousClass1(String str) {
            this.val$filePath = str;
        }

        public final void run() {
            AppMethodBeat.i(52859);
            e.this.Jb(this.val$filePath);
            if (e.this.kTL) {
                g.RP().Ry().set(a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
            }
            AppMethodBeat.o(52859);
        }
    }

    public e() {
        AppMethodBeat.i(52860);
        AppMethodBeat.o(52860);
    }

    public static e bjJ() {
        AppMethodBeat.i(52861);
        if (kTK == null) {
            synchronized (e.class) {
                try {
                    kTK = new e();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(52861);
                    }
                }
            }
        }
        e eVar = kTK;
        AppMethodBeat.o(52861);
        return eVar;
    }

    public final void Jb(String str) {
        AppMethodBeat.i(52862);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (this.kTL) {
                        if (file2.isDirectory()) {
                            Jb(file2.getPath());
                        } else {
                            String name = file2.getName();
                            if (this.kTM.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        ab.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        AppMethodBeat.o(52862);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(52862);
    }

    public final void Jc(String str) {
        AppMethodBeat.i(52863);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        Jc(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
        AppMethodBeat.o(52863);
    }
}
