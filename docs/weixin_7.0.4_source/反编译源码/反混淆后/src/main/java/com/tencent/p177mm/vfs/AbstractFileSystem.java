package com.tencent.p177mm.vfs;

import android.os.CancellationSignal;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.vfs.AbstractFileSystem */
public abstract class AbstractFileSystem implements FileSystem {
    private String zYy;
    private C5727a zYz;

    /* Access modifiers changed, original: protected|final|varargs */
    /* renamed from: j */
    public final void mo15900j(int i, Object... objArr) {
        Map map;
        String str;
        C5727a c5727a;
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
            c5727a = this.zYz;
        }
        if (c5727a != null) {
            c5727a.mo11650b(str, i, map2);
        }
    }

    /* renamed from: a */
    public final void mo15899a(String str, C5727a c5727a) {
        synchronized (this) {
            this.zYy = str;
            this.zYz = c5727a;
        }
    }

    /* renamed from: p */
    public void mo11616p(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo11611a(CancellationSignal cancellationSignal) {
    }
}
