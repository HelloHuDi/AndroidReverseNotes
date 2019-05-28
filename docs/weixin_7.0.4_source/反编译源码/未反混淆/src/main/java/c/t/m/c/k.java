package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class k {
    private static boolean a = false;
    private File b;
    private File c;
    private Context d;

    public k(Context context) {
        AppMethodBeat.i(136374);
        if (context == null) {
            AppMethodBeat.o(136374);
            return;
        }
        this.d = context.getApplicationContext();
        try {
            this.b = new File(context.getExternalFilesDir("data").getAbsolutePath() + "/d_l");
            AppMethodBeat.o(136374);
        } catch (Throwable th) {
            this.b = null;
            AppMethodBeat.o(136374);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046 A:{SYNTHETIC, Splitter:B:29:0x0046} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005f A:{SYNTHETIC, Splitter:B:41:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] bArr) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.i(136375);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (this.c == null) {
                        this.c = a();
                    }
                    if (this.c == null) {
                        AppMethodBeat.o(136375);
                        return;
                    }
                    BufferedOutputStream bufferedOutputStream2;
                    try {
                        bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(this.c, true));
                        try {
                            bufferedOutputStream2.write(bArr);
                            bufferedOutputStream2.flush();
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e) {
                            }
                            this.c = null;
                            AppMethodBeat.o(136375);
                            return;
                        } catch (IOException e2) {
                            try {
                                this.c = null;
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                        AppMethodBeat.o(136375);
                                        return;
                                    } catch (IOException e3) {
                                        AppMethodBeat.o(136375);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(136375);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (bufferedOutputStream != null) {
                                }
                                AppMethodBeat.o(136375);
                                throw th;
                            }
                        }
                    } catch (IOException e4) {
                        bufferedOutputStream2 = null;
                        this.c = null;
                        if (bufferedOutputStream2 != null) {
                        }
                        AppMethodBeat.o(136375);
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
                        AppMethodBeat.o(136375);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                AppMethodBeat.o(136375);
                return;
            }
        }
        AppMethodBeat.o(136375);
    }

    private File a() {
        AppMethodBeat.i(136376);
        try {
            File file = this.b;
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "d_".concat(String.valueOf(q.a(String.valueOf(System.currentTimeMillis())))));
            AppMethodBeat.o(136376);
            return file2;
        } catch (Throwable th) {
            AppMethodBeat.o(136376);
            return null;
        }
    }
}
