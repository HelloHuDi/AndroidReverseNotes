package android.support.customtabs;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.f.a;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    private final Map<IBinder, DeathRecipient> kD = new a();
    private e.a kE = new e.a() {
        public final boolean bi() {
            return CustomTabsService.this.bi();
        }

        public final boolean a(d dVar) {
            boolean z = false;
            final c cVar = new c(dVar);
            try {
                AnonymousClass1 anonymousClass1 = new DeathRecipient() {
                    public final void binderDied() {
                        CustomTabsService.this.a(cVar);
                    }
                };
                synchronized (CustomTabsService.this.kD) {
                    dVar.asBinder().linkToDeath(anonymousClass1, 0);
                    CustomTabsService.this.kD.put(dVar.asBinder(), anonymousClass1);
                }
                return CustomTabsService.this.bj();
            } catch (RemoteException e) {
                return z;
            }
        }

        public final boolean b(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            c cVar = new c(dVar);
            return customTabsService.bk();
        }

        public final Bundle bl() {
            return CustomTabsService.this.bl();
        }

        public final boolean c(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            c cVar = new c(dVar);
            return customTabsService.bm();
        }

        public final boolean d(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            c cVar = new c(dVar);
            return customTabsService.bn();
        }

        public final int e(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            c cVar = new c(dVar);
            return customTabsService.bo();
        }

        public final boolean f(d dVar) {
            CustomTabsService customTabsService = CustomTabsService.this;
            c cVar = new c(dVar);
            return customTabsService.bp();
        }
    };

    public abstract boolean bi();

    public abstract boolean bj();

    public abstract boolean bk();

    public abstract Bundle bl();

    public abstract boolean bm();

    public abstract boolean bn();

    public abstract int bo();

    public abstract boolean bp();

    /* Access modifiers changed, original: protected|final */
    public final boolean a(c cVar) {
        try {
            synchronized (this.kD) {
                IBinder bq = cVar.bq();
                bq.unlinkToDeath((DeathRecipient) this.kD.get(bq), 0);
                this.kD.remove(bq);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
