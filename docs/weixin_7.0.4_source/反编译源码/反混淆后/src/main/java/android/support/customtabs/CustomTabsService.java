package android.support.customtabs;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.customtabs.C8317e.C8318a;
import android.support.p057v4.p065f.C6197a;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    /* renamed from: kD */
    private final Map<IBinder, DeathRecipient> f17613kD = new C6197a();
    /* renamed from: kE */
    private C8318a f17614kE = new C02451();

    /* renamed from: android.support.customtabs.CustomTabsService$1 */
    class C02451 extends C8318a {
        C02451() {
        }

        /* renamed from: bi */
        public final boolean mo362bi() {
            return CustomTabsService.this.mo72137bi();
        }

        /* renamed from: a */
        public final boolean mo360a(C25293d c25293d) {
            boolean z = false;
            final C8315c c8315c = new C8315c(c25293d);
            try {
                C02461 c02461 = new DeathRecipient() {
                    public final void binderDied() {
                        CustomTabsService.this.mo72136a(c8315c);
                    }
                };
                synchronized (CustomTabsService.this.f17613kD) {
                    c25293d.asBinder().linkToDeath(c02461, 0);
                    CustomTabsService.this.f17613kD.put(c25293d.asBinder(), c02461);
                }
                return CustomTabsService.this.mo72138bj();
            } catch (RemoteException e) {
                return z;
            }
        }

        /* renamed from: b */
        public final boolean mo361b(C25293d c25293d) {
            CustomTabsService customTabsService = CustomTabsService.this;
            C8315c c8315c = new C8315c(c25293d);
            return customTabsService.mo72139bk();
        }

        /* renamed from: bl */
        public final Bundle mo363bl() {
            return CustomTabsService.this.mo72140bl();
        }

        /* renamed from: c */
        public final boolean mo364c(C25293d c25293d) {
            CustomTabsService customTabsService = CustomTabsService.this;
            C8315c c8315c = new C8315c(c25293d);
            return customTabsService.mo72141bm();
        }

        /* renamed from: d */
        public final boolean mo365d(C25293d c25293d) {
            CustomTabsService customTabsService = CustomTabsService.this;
            C8315c c8315c = new C8315c(c25293d);
            return customTabsService.mo72142bn();
        }

        /* renamed from: e */
        public final int mo366e(C25293d c25293d) {
            CustomTabsService customTabsService = CustomTabsService.this;
            C8315c c8315c = new C8315c(c25293d);
            return customTabsService.mo72143bo();
        }

        /* renamed from: f */
        public final boolean mo367f(C25293d c25293d) {
            CustomTabsService customTabsService = CustomTabsService.this;
            C8315c c8315c = new C8315c(c25293d);
            return customTabsService.mo72144bp();
        }
    }

    /* renamed from: bi */
    public abstract boolean mo72137bi();

    /* renamed from: bj */
    public abstract boolean mo72138bj();

    /* renamed from: bk */
    public abstract boolean mo72139bk();

    /* renamed from: bl */
    public abstract Bundle mo72140bl();

    /* renamed from: bm */
    public abstract boolean mo72141bm();

    /* renamed from: bn */
    public abstract boolean mo72142bn();

    /* renamed from: bo */
    public abstract int mo72143bo();

    /* renamed from: bp */
    public abstract boolean mo72144bp();

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo72136a(C8315c c8315c) {
        try {
            synchronized (this.f17613kD) {
                IBinder bq = c8315c.mo18101bq();
                bq.unlinkToDeath((DeathRecipient) this.f17613kD.get(bq), 0);
                this.f17613kD.remove(bq);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
