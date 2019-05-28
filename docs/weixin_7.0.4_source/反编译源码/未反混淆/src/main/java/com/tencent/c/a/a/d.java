package com.tencent.c.a.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

final class d extends q {
    d(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zO() {
        AppMethodBeat.i(125718);
        if (s.q(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted")) {
            AppMethodBeat.o(125718);
            return true;
        }
        AppMethodBeat.o(125718);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String read() {
        String str;
        AppMethodBeat.i(125719);
        synchronized (this) {
            try {
                s.zX();
                for (String str2 : c.s(new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        new StringBuilder("read mid from InternalStorage:").append(split[1]);
                        s.zX();
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (IOException e) {
                s.zY();
                str2 = null;
            } catch (Throwable th) {
                AppMethodBeat.o(125719);
            }
        }
        AppMethodBeat.o(125719);
        return str2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void write(String str) {
        AppMethodBeat.i(125720);
        synchronized (this) {
            try {
                s.zX();
                c.cl(Environment.getExternalStorageDirectory() + "/" + s.decode("6X8Y4XdM2Vhvn0I="));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(new StringBuilder(String.valueOf(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))).append(",").append(str).toString());
                bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
                bufferedWriter.close();
            } catch (Exception e) {
                s.zY();
            } catch (Throwable th) {
                AppMethodBeat.o(125720);
            }
        }
        AppMethodBeat.o(125720);
    }

    /* Access modifiers changed, original: protected|final */
    public final a zP() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
    }
}
