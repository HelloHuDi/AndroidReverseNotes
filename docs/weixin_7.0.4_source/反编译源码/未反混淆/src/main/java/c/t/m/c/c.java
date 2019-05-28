package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class c implements Runnable {
    private static int g = 0;
    private final int a = 30000;
    private final int b = i.sHCENCODEVIDEOTIMEOUT;
    private Context c;
    private List<a> d = null;
    private String e = null;
    private boolean f = false;

    public c(Context context) {
        AppMethodBeat.i(136331);
        this.c = context;
        this.e = this.c.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        File file = new File(this.c.getFilesDir().getAbsolutePath(), "TencentLocation/comp");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(136331);
    }

    public void run() {
        AppMethodBeat.i(136332);
        a();
        e.a(this.c).c();
        AppMethodBeat.o(136332);
    }

    private synchronized void a() {
        AppMethodBeat.i(136333);
        if (this.d != null && this.d.size() > 0) {
            g = 1;
            q.f(this.c);
            if (q.d() < 10485760) {
                g = 2;
                AppMethodBeat.o(136333);
            } else {
                ArrayList<a> arrayList = new ArrayList();
                Object obj = 1;
                for (a aVar : this.d) {
                    if (a(aVar)) {
                        arrayList.add(aVar);
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    g = 2;
                    b(arrayList);
                    AppMethodBeat.o(136333);
                } else if (arrayList.size() == this.d.size()) {
                    d.a(this.c).a("load");
                    if (q.a(this.c, this.d)) {
                        for (a aVar2 : arrayList) {
                            if (!aVar2.c.contains(".dex")) {
                                aVar2.c += ".dex";
                            }
                            File file = new File(this.e, aVar2.c);
                            if (file.exists()) {
                                file.delete();
                            }
                            new File(this.e, "tmp_" + aVar2.c).renameTo(new File(this.e, aVar2.c));
                        }
                        g = 1;
                        e.a(this.c).a("CPU", "down suc");
                        d.a(this.c).b("load");
                        AppMethodBeat.o(136333);
                    } else {
                        b(arrayList);
                        g = 2;
                        AppMethodBeat.o(136333);
                    }
                } else {
                    e.a(this.c).a("CPU", "down failed");
                    b(arrayList);
                    g = 2;
                }
            }
        }
        AppMethodBeat.o(136333);
    }

    private void b(List<a> list) {
        AppMethodBeat.i(136334);
        for (a aVar : list) {
            File file = new File(this.e, "tmp_" + aVar.c);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        AppMethodBeat.o(136334);
    }

    private boolean a(a aVar) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(136335);
        try {
            String str = "https://lbs.gtimg.com/maplbs/Index/" + aVar.e;
            BufferedOutputStream bufferedOutputStream = null;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 3) {
                    break;
                }
                byte[] a = p.a(str);
                if (a != null) {
                    a = q.a(m.b(a, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
                    if (a != null) {
                        File file = new File(this.e, "tmp_" + aVar.c);
                        BufferedOutputStream bufferedOutputStream2;
                        try {
                            bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, false), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                            try {
                                bufferedOutputStream2.write(a);
                                if (a(aVar, file)) {
                                    e.a(this.c).a("CPU", "sud:" + aVar.e);
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (Exception e2) {
                                    }
                                    AppMethodBeat.o(136335);
                                    return true;
                                }
                                e.a(this.c).a("CPU", "failed:" + aVar.e);
                                if (file.exists() && file.isFile()) {
                                    file.delete();
                                }
                                try {
                                    bufferedOutputStream2.close();
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Exception e3) {
                                    bufferedOutputStream = bufferedOutputStream2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                try {
                                    file.delete();
                                    e.a(this.c).a("CPU", "failed:" + e.toString());
                                    try {
                                        bufferedOutputStream2.close();
                                        bufferedOutputStream = bufferedOutputStream2;
                                    } catch (Exception e5) {
                                        bufferedOutputStream = bufferedOutputStream2;
                                    }
                                    q.a(5000);
                                    i = i2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (Exception e6) {
                                    }
                                    AppMethodBeat.o(136335);
                                    throw th;
                                }
                            }
                        } catch (Exception e7) {
                            e = e7;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                            e.a(this.c).a("CPU", "failed:" + e.toString());
                            bufferedOutputStream2.close();
                            bufferedOutputStream = bufferedOutputStream2;
                            q.a(5000);
                            i = i2;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedOutputStream2.close();
                            AppMethodBeat.o(136335);
                            throw th;
                        }
                    }
                }
                q.a(5000);
                i = i2;
            }
        } catch (Throwable th4) {
        }
        AppMethodBeat.o(136335);
        return false;
    }

    private boolean a(a aVar, File file) {
        AppMethodBeat.i(136336);
        boolean z = false;
        if (file != null && file.exists()) {
            int length = (int) file.length();
            String a = q.a(file);
            if (aVar.d == length && aVar.e.equals(a)) {
                z = true;
            }
        }
        AppMethodBeat.o(136336);
        return z;
    }

    public void a(List<a> list) {
        AppMethodBeat.i(136337);
        this.d = list;
        if (g != 1) {
            new Thread(this).start();
        }
        AppMethodBeat.o(136337);
    }
}
