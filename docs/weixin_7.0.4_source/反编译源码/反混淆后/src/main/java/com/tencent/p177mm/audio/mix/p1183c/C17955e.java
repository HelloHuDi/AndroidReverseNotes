package com.tencent.p177mm.audio.mix.p1183c;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p831d.C41777h;
import com.tencent.p177mm.audio.mix.p831d.C41778i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.audio.mix.c.e */
public final class C17955e {
    public static final Long cln = Long.valueOf(2592000000L);
    public static final Long clo = Long.valueOf(604800000);
    public static final Long clp = Long.valueOf(259200000);
    public static final Long clq = Long.valueOf(172800000);
    public static final Long clr = Long.valueOf(86400000);
    public static final Long cls = Long.valueOf(43200000);
    public static final Long clt = Long.valueOf(240000);
    public static final Long clu = clr;
    public static final Long clv = Long.valueOf(60000);
    public static long clx = 0;
    private List<String> clw = new ArrayList(10);

    /* renamed from: com.tencent.mm.audio.mix.c.e$a */
    public class C17954a extends C41778i {
        public C17954a(String str) {
            super(str);
        }

        public final void run() {
            AppMethodBeat.m2504i(137026);
            C17955e.m28218a(C17955e.this);
            C41777h.m73747b(this);
            AppMethodBeat.m2505o(137026);
        }
    }

    static {
        AppMethodBeat.m2504i(137031);
        AppMethodBeat.m2505o(137031);
    }

    public C17955e() {
        AppMethodBeat.m2504i(137027);
        AppMethodBeat.m2505o(137027);
    }

    /* renamed from: dz */
    private void m28220dz(String str) {
        AppMethodBeat.m2504i(137028);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                C45174b.m83209i("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
                AppMethodBeat.m2505o(137028);
                return;
            }
            for (String str2 : list) {
                String str22;
                if (m28219dA(str22)) {
                    C45174b.m83209i("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
                } else {
                    str22 = str + File.separator + str22;
                    File file2 = new File(str22);
                    if (!file2.exists()) {
                        C45174b.m83209i("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
                    } else if (file2.isDirectory()) {
                        C45174b.m83209i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete");
                        m28220dz(str22);
                    } else if (System.currentTimeMillis() - file2.lastModified() > clq.longValue()) {
                        C45174b.m83208e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", file2.getName(), file2.getAbsolutePath());
                        file2.delete();
                    }
                }
            }
            AppMethodBeat.m2505o(137028);
            return;
        }
        C45174b.m83210i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", str);
        AppMethodBeat.m2505o(137028);
    }

    /* renamed from: dA */
    private boolean m28219dA(String str) {
        AppMethodBeat.m2504i(137029);
        for (String contains : this.clw) {
            if (str.contains(contains)) {
                AppMethodBeat.m2505o(137029);
                return true;
            }
        }
        AppMethodBeat.m2505o(137029);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m28218a(C17955e c17955e) {
        AppMethodBeat.m2504i(137030);
        C45174b.m83209i("MicroMsg.Mix.AudioScanConvertCacheController", "clean mix convert file");
        c17955e.m28220dz(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/MixAudio");
        AppMethodBeat.m2505o(137030);
    }
}
