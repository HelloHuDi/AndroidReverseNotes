package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: c.t.m.c.c */
public class C44973c implements Runnable {
    /* renamed from: g */
    private static int f17715g = 0;
    /* renamed from: a */
    private final int f17716a = 30000;
    /* renamed from: b */
    private final int f17717b = C1625i.sHCENCODEVIDEOTIMEOUT;
    /* renamed from: c */
    private Context f17718c;
    /* renamed from: d */
    private List<C44972a> f17719d = null;
    /* renamed from: e */
    private String f17720e = null;
    /* renamed from: f */
    private boolean f17721f = false;

    public C44973c(Context context) {
        AppMethodBeat.m2504i(136331);
        this.f17718c = context;
        this.f17720e = this.f17718c.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        File file = new File(this.f17718c.getFilesDir().getAbsolutePath(), "TencentLocation/comp");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(136331);
    }

    public void run() {
        AppMethodBeat.m2504i(136332);
        m82335a();
        C25383e.m40076a(this.f17718c).mo42400c();
        AppMethodBeat.m2505o(136332);
    }

    /* renamed from: a */
    private synchronized void m82335a() {
        AppMethodBeat.m2504i(136333);
        if (this.f17719d != null && this.f17719d.size() > 0) {
            f17715g = 1;
            C37150q.m62234f(this.f17718c);
            if (C37150q.m62229d() < 10485760) {
                f17715g = 2;
                AppMethodBeat.m2505o(136333);
            } else {
                ArrayList<C44972a> arrayList = new ArrayList();
                Object obj = 1;
                for (C44972a c44972a : this.f17719d) {
                    if (m82336a(c44972a)) {
                        arrayList.add(c44972a);
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    f17715g = 2;
                    m82338b(arrayList);
                    AppMethodBeat.m2505o(136333);
                } else if (arrayList.size() == this.f17719d.size()) {
                    C17500d.m27317a(this.f17718c).mo31932a("load");
                    if (C37150q.m62214a(this.f17718c, this.f17719d)) {
                        for (C44972a c44972a2 : arrayList) {
                            if (!c44972a2.f17711c.contains(".dex")) {
                                c44972a2.f17711c += ".dex";
                            }
                            File file = new File(this.f17720e, c44972a2.f17711c);
                            if (file.exists()) {
                                file.delete();
                            }
                            new File(this.f17720e, "tmp_" + c44972a2.f17711c).renameTo(new File(this.f17720e, c44972a2.f17711c));
                        }
                        f17715g = 1;
                        C25383e.m40076a(this.f17718c).mo42397a("CPU", "down suc");
                        C17500d.m27317a(this.f17718c).mo31933b("load");
                        AppMethodBeat.m2505o(136333);
                    } else {
                        m82338b(arrayList);
                        f17715g = 2;
                        AppMethodBeat.m2505o(136333);
                    }
                } else {
                    C25383e.m40076a(this.f17718c).mo42397a("CPU", "down failed");
                    m82338b(arrayList);
                    f17715g = 2;
                }
            }
        }
        AppMethodBeat.m2505o(136333);
    }

    /* renamed from: b */
    private void m82338b(List<C44972a> list) {
        AppMethodBeat.m2504i(136334);
        for (C44972a c44972a : list) {
            File file = new File(this.f17720e, "tmp_" + c44972a.f17711c);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        AppMethodBeat.m2505o(136334);
    }

    /* renamed from: a */
    private boolean m82336a(C44972a c44972a) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(136335);
        try {
            String str = "https://lbs.gtimg.com/maplbs/Index/" + c44972a.f17713e;
            BufferedOutputStream bufferedOutputStream = null;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 3) {
                    break;
                }
                byte[] a = C0733p.m1690a(str);
                if (a != null) {
                    a = C37150q.m62216a(C17501m.m27327b(a, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
                    if (a != null) {
                        File file = new File(this.f17720e, "tmp_" + c44972a.f17711c);
                        BufferedOutputStream bufferedOutputStream2;
                        try {
                            bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, false), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                            try {
                                bufferedOutputStream2.write(a);
                                if (m82337a(c44972a, file)) {
                                    C25383e.m40076a(this.f17718c).mo42397a("CPU", "sud:" + c44972a.f17713e);
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (Exception e2) {
                                    }
                                    AppMethodBeat.m2505o(136335);
                                    return true;
                                }
                                C25383e.m40076a(this.f17718c).mo42397a("CPU", "failed:" + c44972a.f17713e);
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
                                    C25383e.m40076a(this.f17718c).mo42397a("CPU", "failed:" + e.toString());
                                    try {
                                        bufferedOutputStream2.close();
                                        bufferedOutputStream = bufferedOutputStream2;
                                    } catch (Exception e5) {
                                        bufferedOutputStream = bufferedOutputStream2;
                                    }
                                    C37150q.m62209a(5000);
                                    i = i2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (Exception e6) {
                                    }
                                    AppMethodBeat.m2505o(136335);
                                    throw th;
                                }
                            }
                        } catch (Exception e7) {
                            e = e7;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                            C25383e.m40076a(this.f17718c).mo42397a("CPU", "failed:" + e.toString());
                            bufferedOutputStream2.close();
                            bufferedOutputStream = bufferedOutputStream2;
                            C37150q.m62209a(5000);
                            i = i2;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedOutputStream2.close();
                            AppMethodBeat.m2505o(136335);
                            throw th;
                        }
                    }
                }
                C37150q.m62209a(5000);
                i = i2;
            }
        } catch (Throwable th4) {
        }
        AppMethodBeat.m2505o(136335);
        return false;
    }

    /* renamed from: a */
    private boolean m82337a(C44972a c44972a, File file) {
        AppMethodBeat.m2504i(136336);
        boolean z = false;
        if (file != null && file.exists()) {
            int length = (int) file.length();
            String a = C37150q.m62206a(file);
            if (c44972a.f17712d == length && c44972a.f17713e.equals(a)) {
                z = true;
            }
        }
        AppMethodBeat.m2505o(136336);
        return z;
    }

    /* renamed from: a */
    public void mo72252a(List<C44972a> list) {
        AppMethodBeat.m2504i(136337);
        this.f17719d = list;
        if (f17715g != 1) {
            new Thread(this).start();
        }
        AppMethodBeat.m2505o(136337);
    }
}
