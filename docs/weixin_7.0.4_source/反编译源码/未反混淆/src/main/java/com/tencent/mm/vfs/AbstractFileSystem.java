package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFileSystem implements FileSystem {
    private String zYy;
    private a zYz;

    /* Access modifiers changed, original: protected|final|varargs */
    public final void j(int i, Object... objArr) {
        Map map;
        String str;
        a aVar;
        if (objArr.length == 0) {
            map = null;
        } else {
            HashMap hashMap = new HashMap(objArr.length / 2);
            int i2 = 0;
            while (i2 < objArr.length - 1) {
                int i3 = i2 + 1;
                Object obj = objArr[i2];
                if (i3 >= objArr.length) {
                    break;
                }
                i2 = i3 + 1;
                hashMap.put(obj.toString(), objArr[i3]);
            }
            Object map2 = hashMap;
        }
        synchronized (this) {
            str = this.zYy;
            aVar = this.zYz;
        }
        if (aVar != null) {
            aVar.b(str, i, map2);
        }
    }

    public final void a(String str, a aVar) {
        synchronized (this) {
            this.zYy = str;
            this.zYz = aVar;
        }
    }

    public void p(Map<String, String> map) {
    }

    public void a(CancellationSignal cancellationSignal) {
    }
}
