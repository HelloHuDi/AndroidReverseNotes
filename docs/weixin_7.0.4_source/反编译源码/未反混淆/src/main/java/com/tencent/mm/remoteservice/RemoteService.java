package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Constructor;

public class RemoteService extends Service {
    private a xtX = new a() {
        public final void a(String str, String str2, Bundle bundle, b bVar) {
            AppMethodBeat.i(80224);
            try {
                a aVar;
                Class loadClass = RemoteService.this.getClassLoader().loadClass(str);
                Constructor[] constructors = loadClass.getConstructors();
                if (constructors.length > 0) {
                    Object[] objArr = new Object[constructors[0].getParameterTypes().length];
                    objArr[0] = null;
                    aVar = (a) constructors[0].newInstance(objArr);
                } else {
                    aVar = (a) loadClass.newInstance();
                }
                aVar.xtV = bVar;
                aVar.xtU = RemoteService.this;
                aVar.onCallback(str2, bundle, false);
                AppMethodBeat.o(80224);
            } catch (Exception e) {
                ab.e("MicroMsg.RemoveService", "exception:%s", bo.l(e));
                AppMethodBeat.o(80224);
            }
        }
    };

    public RemoteService() {
        AppMethodBeat.i(80225);
        AppMethodBeat.o(80225);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(80226);
        new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
        a aVar = this.xtX;
        AppMethodBeat.o(80226);
        return aVar;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(80227);
        new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
        super.onRebind(intent);
        AppMethodBeat.o(80227);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(80228);
        new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(80228);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.i(80229);
        new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
        super.onDestroy();
        AppMethodBeat.o(80229);
    }
}
