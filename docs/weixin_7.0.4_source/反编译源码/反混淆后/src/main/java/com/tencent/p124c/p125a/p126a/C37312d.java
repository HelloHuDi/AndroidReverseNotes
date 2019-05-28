package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.tencent.c.a.a.d */
final class C37312d extends C25595q {
    C37312d(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zO */
    public final boolean mo19819zO() {
        AppMethodBeat.m2504i(125718);
        if (C0916s.m2087q(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted")) {
            AppMethodBeat.m2505o(125718);
            return true;
        }
        AppMethodBeat.m2505o(125718);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String read() {
        String str;
        AppMethodBeat.m2504i(125719);
        synchronized (this) {
            try {
                C0916s.m2088zX();
                for (String str2 : C25594c.m40607s(new File(Environment.getExternalStorageDirectory(), C0916s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        new StringBuilder("read mid from InternalStorage:").append(split[1]);
                        C0916s.m2088zX();
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (IOException e) {
                C0916s.m2089zY();
                str2 = null;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(125719);
            }
        }
        AppMethodBeat.m2505o(125719);
        return str2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void write(String str) {
        AppMethodBeat.m2504i(125720);
        synchronized (this) {
            try {
                C0916s.m2088zX();
                C25594c.m40606cl(Environment.getExternalStorageDirectory() + "/" + C0916s.decode("6X8Y4XdM2Vhvn0I="));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C0916s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(new StringBuilder(String.valueOf(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))).append(",").append(str).toString());
                bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
                bufferedWriter.close();
            } catch (Exception e) {
                C0916s.m2089zY();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(125720);
            }
        }
        AppMethodBeat.m2505o(125720);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zP */
    public final C25593a mo19820zP() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo19816a(C25593a c25593a) {
    }
}
