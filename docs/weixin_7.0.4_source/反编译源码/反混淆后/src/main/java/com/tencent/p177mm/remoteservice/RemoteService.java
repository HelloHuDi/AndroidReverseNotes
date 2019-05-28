package com.tencent.p177mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.remoteservice.C15406c.C15407a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Constructor;

/* renamed from: com.tencent.mm.remoteservice.RemoteService */
public class RemoteService extends Service {
    private C15407a xtX = new C406011();

    /* renamed from: com.tencent.mm.remoteservice.RemoteService$1 */
    class C406011 extends C15407a {
        C406011() {
        }

        /* renamed from: a */
        public final void mo27448a(String str, String str2, Bundle bundle, C30258b c30258b) {
            AppMethodBeat.m2504i(80224);
            try {
                C31577a c31577a;
                Class loadClass = RemoteService.this.getClassLoader().loadClass(str);
                Constructor[] constructors = loadClass.getConstructors();
                if (constructors.length > 0) {
                    Object[] objArr = new Object[constructors[0].getParameterTypes().length];
                    objArr[0] = null;
                    c31577a = (C31577a) constructors[0].newInstance(objArr);
                } else {
                    c31577a = (C31577a) loadClass.newInstance();
                }
                c31577a.xtV = c30258b;
                c31577a.xtU = RemoteService.this;
                c31577a.onCallback(str2, bundle, false);
                AppMethodBeat.m2505o(80224);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.RemoveService", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(80224);
            }
        }
    }

    public RemoteService() {
        AppMethodBeat.m2504i(80225);
        AppMethodBeat.m2505o(80225);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(80226);
        new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
        C15407a c15407a = this.xtX;
        AppMethodBeat.m2505o(80226);
        return c15407a;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.m2504i(80227);
        new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
        super.onRebind(intent);
        AppMethodBeat.m2505o(80227);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.m2504i(80228);
        new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.m2505o(80228);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(80229);
        new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
        super.onDestroy();
        AppMethodBeat.m2505o(80229);
    }
}
