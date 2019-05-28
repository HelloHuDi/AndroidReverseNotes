package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.io.ObjectInputStream;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A:{SYNTHETIC, Splitter:B:23:0x0075} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object x(InputStream inputStream) {
        Object readObject;
        Exception e;
        Throwable th;
        ObjectInputStream readObject2 = null;
        AppMethodBeat.i(58337);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            try {
                readObject2 = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (Exception e2) {
                    ab.w("MicroMsg.ObjectUtil", "Read close exception:" + e2.getMessage());
                }
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            objectInputStream = readObject2;
            try {
                ab.w("MicroMsg.ObjectUtil", "Read exception:" + e2.getMessage());
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e22) {
                        ab.w("MicroMsg.ObjectUtil", "Read close exception:" + e22.getMessage());
                    }
                }
                AppMethodBeat.o(58337);
                return readObject2;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e5) {
                        ab.w("MicroMsg.ObjectUtil", "Read close exception:" + e5.getMessage());
                    }
                }
                AppMethodBeat.o(58337);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = readObject2;
            if (objectInputStream != null) {
            }
            AppMethodBeat.o(58337);
            throw th;
        }
        AppMethodBeat.o(58337);
        return readObject2;
    }
}
