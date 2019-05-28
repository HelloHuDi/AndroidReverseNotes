package android.support.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.C8377e;
import java.util.ArrayList;

/* renamed from: android.support.customtabs.b */
public final class C41482b {
    public final Intent intent;
    /* renamed from: ky */
    public final Bundle f16699ky;

    /* renamed from: android.support.customtabs.b$a */
    public static final class C31829a {
        /* renamed from: kA */
        public Bundle f14540kA;
        /* renamed from: kB */
        public ArrayList<Bundle> f14541kB;
        /* renamed from: kC */
        public boolean f14542kC;
        /* renamed from: kz */
        public ArrayList<Bundle> f14543kz;
        public final Intent mIntent;

        public C31829a() {
            this((byte) 0);
        }

        private C31829a(byte b) {
            this.mIntent = new Intent("android.intent.action.VIEW");
            this.f14543kz = null;
            this.f14540kA = null;
            this.f14541kB = null;
            this.f14542kC = true;
            Bundle bundle = new Bundle();
            C8377e.m14782a(bundle, "android.support.customtabs.extra.SESSION", null);
            this.mIntent.putExtras(bundle);
        }
    }

    public /* synthetic */ C41482b(Intent intent, Bundle bundle, byte b) {
        this(intent, bundle);
    }

    private C41482b(Intent intent, Bundle bundle) {
        this.intent = intent;
        this.f16699ky = bundle;
    }
}
