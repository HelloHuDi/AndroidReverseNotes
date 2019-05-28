package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.f.a;

public class PostMessageService extends Service {
    private a kL = new a() {
        public final void a(d dVar, Bundle bundle) {
            dVar.b(bundle);
        }

        public final void a(d dVar, String str, Bundle bundle) {
            dVar.c(str, bundle);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.kL;
    }
}
