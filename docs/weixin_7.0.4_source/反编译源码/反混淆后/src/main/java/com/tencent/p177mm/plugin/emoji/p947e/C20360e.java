package com.tencent.p177mm.plugin.emoji.p947e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.emoji.e.e */
public class C20360e {
    public static C20360e kTK;
    public boolean kTL = false;
    private Pattern kTM = Pattern.compile("_\\d");

    /* renamed from: com.tencent.mm.plugin.emoji.e.e$1 */
    class C203611 implements Runnable {
        final /* synthetic */ String val$filePath;

        C203611(String str) {
            this.val$filePath = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(52859);
            C20360e.this.mo35588Jb(this.val$filePath);
            if (C20360e.this.kTL) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
            }
            AppMethodBeat.m2505o(52859);
        }
    }

    public C20360e() {
        AppMethodBeat.m2504i(52860);
        AppMethodBeat.m2505o(52860);
    }

    public static C20360e bjJ() {
        AppMethodBeat.m2504i(52861);
        if (kTK == null) {
            synchronized (C20360e.class) {
                try {
                    kTK = new C20360e();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(52861);
                    }
                }
            }
        }
        C20360e c20360e = kTK;
        AppMethodBeat.m2505o(52861);
        return c20360e;
    }

    /* renamed from: Jb */
    public final void mo35588Jb(String str) {
        AppMethodBeat.m2504i(52862);
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
                            mo35588Jb(file2.getPath());
                        } else {
                            String name = file2.getName();
                            if (this.kTM.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        AppMethodBeat.m2505o(52862);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52862);
    }

    /* renamed from: Jc */
    public final void mo35589Jc(String str) {
        AppMethodBeat.m2504i(52863);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        mo35589Jc(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52863);
    }
}
