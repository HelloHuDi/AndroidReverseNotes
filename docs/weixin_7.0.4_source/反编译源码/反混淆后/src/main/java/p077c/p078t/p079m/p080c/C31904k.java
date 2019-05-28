package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: c.t.m.c.k */
public class C31904k {
    /* renamed from: a */
    private static boolean f14666a = false;
    /* renamed from: b */
    private File f14667b;
    /* renamed from: c */
    private File f14668c;
    /* renamed from: d */
    private Context f14669d;

    public C31904k(Context context) {
        AppMethodBeat.m2504i(136374);
        if (context == null) {
            AppMethodBeat.m2505o(136374);
            return;
        }
        this.f14669d = context.getApplicationContext();
        try {
            this.f14667b = new File(context.getExternalFilesDir("data").getAbsolutePath() + "/d_l");
            AppMethodBeat.m2505o(136374);
        } catch (Throwable th) {
            this.f14667b = null;
            AppMethodBeat.m2505o(136374);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A:{SYNTHETIC, Splitter:B:29:0x0046} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005f A:{SYNTHETIC, Splitter:B:41:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo52018a(byte[] bArr) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.m2504i(136375);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (this.f14668c == null) {
                        this.f14668c = m51768a();
                    }
                    if (this.f14668c == null) {
                        AppMethodBeat.m2505o(136375);
                        return;
                    }
                    BufferedOutputStream bufferedOutputStream2;
                    try {
                        bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(this.f14668c, true));
                        try {
                            bufferedOutputStream2.write(bArr);
                            bufferedOutputStream2.flush();
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e) {
                            }
                            this.f14668c = null;
                            AppMethodBeat.m2505o(136375);
                            return;
                        } catch (IOException e2) {
                            try {
                                this.f14668c = null;
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                        AppMethodBeat.m2505o(136375);
                                        return;
                                    } catch (IOException e3) {
                                        AppMethodBeat.m2505o(136375);
                                        return;
                                    }
                                }
                                AppMethodBeat.m2505o(136375);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (bufferedOutputStream != null) {
                                }
                                AppMethodBeat.m2505o(136375);
                                throw th;
                            }
                        }
                    } catch (IOException e4) {
                        bufferedOutputStream2 = null;
                        this.f14668c = null;
                        if (bufferedOutputStream2 != null) {
                        }
                        AppMethodBeat.m2505o(136375);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        AppMethodBeat.m2505o(136375);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                AppMethodBeat.m2505o(136375);
                return;
            }
        }
        AppMethodBeat.m2505o(136375);
    }

    /* renamed from: a */
    private File m51768a() {
        AppMethodBeat.m2504i(136376);
        try {
            File file = this.f14667b;
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "d_".concat(String.valueOf(C37150q.m62207a(String.valueOf(System.currentTimeMillis())))));
            AppMethodBeat.m2505o(136376);
            return file2;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136376);
            return null;
        }
    }
}
