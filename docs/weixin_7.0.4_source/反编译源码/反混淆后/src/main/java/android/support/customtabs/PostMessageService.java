package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.C25296f.C25297a;

public class PostMessageService extends Service {
    /* renamed from: kL */
    private C25297a f5053kL = new C252921();

    /* renamed from: android.support.customtabs.PostMessageService$1 */
    class C252921 extends C25297a {
        C252921() {
        }

        /* renamed from: a */
        public final void mo42152a(C25293d c25293d, Bundle bundle) {
            c25293d.mo42156b(bundle);
        }

        /* renamed from: a */
        public final void mo42153a(C25293d c25293d, String str, Bundle bundle) {
            c25293d.mo42158c(str, bundle);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f5053kL;
    }
}
