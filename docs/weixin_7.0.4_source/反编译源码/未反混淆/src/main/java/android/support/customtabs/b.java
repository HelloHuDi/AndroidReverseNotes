package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.e;
import java.util.ArrayList;

public final class b {
    public final Intent intent;
    public final Bundle ky;

    public static final class a {
        public Bundle kA;
        public ArrayList<Bundle> kB;
        public boolean kC;
        public ArrayList<Bundle> kz;
        public final Intent mIntent;

        public a() {
            this((byte) 0);
        }

        private a(byte b) {
            this.mIntent = new Intent("android.intent.action.VIEW");
            this.kz = null;
            this.kA = null;
            this.kB = null;
            this.kC = true;
            Bundle bundle = new Bundle();
            e.a(bundle, "android.support.customtabs.extra.SESSION", null);
            this.mIntent.putExtras(bundle);
        }
    }

    public /* synthetic */ b(Intent intent, Bundle bundle, byte b) {
        this(intent, bundle);
    }

    private b(Intent intent, Bundle bundle) {
        this.intent = intent;
        this.ky = bundle;
    }
}
