package android.support.p057v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.p057v4.app.C0354r.C0353a;
import android.support.p057v4.content.C0383c;
import android.support.p057v4.content.C0383c.C0382b;
import android.support.p057v4.p065f.C0405d;
import android.support.p057v4.p065f.C0418n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.app.s */
final class C6191s extends C0354r {
    static boolean DEBUG = false;
    /* renamed from: Eq */
    private final LifecycleOwner f1774Eq;
    /* renamed from: Er */
    final C6190c f1775Er;
    /* renamed from: Es */
    private boolean f1776Es;

    /* renamed from: android.support.v4.app.s$b */
    static class C6188b<D> implements Observer<D> {
        /* renamed from: Eu */
        final C0383c<D> f1769Eu;
        /* renamed from: Ex */
        final C0353a<D> f1770Ex;
        /* renamed from: Ey */
        boolean f1771Ey = false;

        C6188b(C0383c<D> c0383c, C0353a<D> c0353a) {
            this.f1769Eu = c0383c;
            this.f1770Ex = c0353a;
        }

        public final void onChanged(D d) {
            if (C6191s.DEBUG) {
                new StringBuilder("  onLoadFinished in ").append(this.f1769Eu).append(": ").append(this.f1769Eu.dataToString(d));
            }
            this.f1770Ex.onLoadFinished(this.f1769Eu, d);
            this.f1771Ey = true;
        }

        public final String toString() {
            return this.f1770Ex.toString();
        }
    }

    /* renamed from: android.support.v4.app.s$c */
    static class C6190c extends ViewModel {
        /* renamed from: Ez */
        private static final Factory f1772Ez = new C61891();
        /* renamed from: EA */
        C0418n<C6192a> f1773EA = new C0418n();

        /* renamed from: android.support.v4.app.s$c$1 */
        static class C61891 implements Factory {
            C61891() {
            }

            public final <T extends ViewModel> T create(Class<T> cls) {
                return new C6190c();
            }
        }

        C6190c() {
        }

        /* renamed from: a */
        static C6190c m9939a(ViewModelStore viewModelStore) {
            return (C6190c) new ViewModelProvider(viewModelStore, f1772Ez).get(C6190c.class);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final void mo14012dr() {
            int size = this.f1773EA.size();
            for (int i = 0; i < size; i++) {
                ((C6192a) this.f1773EA.valueAt(i)).mo14016dr();
            }
        }

        /* renamed from: ao */
        public final void mo322ao() {
            super.mo322ao();
            int size = this.f1773EA.size();
            for (int i = 0; i < size; i++) {
                C6192a c6192a = (C6192a) this.f1773EA.valueAt(i);
                if (C6191s.DEBUG) {
                    new StringBuilder("  Destroying: ").append(c6192a);
                }
                c6192a.f1779Eu.cancelLoad();
                c6192a.f1779Eu.abandon();
                C6188b c6188b = c6192a.f1780Ev;
                if (c6188b != null) {
                    c6192a.removeObserver(c6188b);
                    if (c6188b.f1771Ey) {
                        if (C6191s.DEBUG) {
                            new StringBuilder("  Resetting: ").append(c6188b.f1769Eu);
                        }
                        c6188b.f1770Ex.onLoaderReset(c6188b.f1769Eu);
                    }
                }
                c6192a.f1779Eu.unregisterListener(c6192a);
                c6192a.f1779Eu.reset();
            }
            this.f1773EA.clear();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1773EA.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.f1773EA.size()) {
                        C6192a c6192a = (C6192a) this.f1773EA.valueAt(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(this.f1773EA.keyAt(i2));
                        printWriter.print(": ");
                        printWriter.println(c6192a.toString());
                        c6192a.dump(str2, fileDescriptor, printWriter, strArr);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.s$a */
    public static class C6192a<D> extends MutableLiveData<D> implements C0382b<D> {
        /* renamed from: Eq */
        private LifecycleOwner f1777Eq;
        /* renamed from: Et */
        private final Bundle f1778Et = null;
        /* renamed from: Eu */
        final C0383c<D> f1779Eu;
        /* renamed from: Ev */
        C6188b<D> f1780Ev;
        /* renamed from: Ew */
        C0383c<D> f1781Ew;
        private final int mId = 0;

        C6192a(C0383c<D> c0383c) {
            this.f1779Eu = c0383c;
            this.f1781Ew = null;
            this.f1779Eu.registerListener(0, this);
        }

        public final void onActive() {
            if (C6191s.DEBUG) {
                new StringBuilder("  Starting: ").append(this);
            }
            this.f1779Eu.startLoading();
        }

        /* renamed from: ag */
        public final void mo298ag() {
            if (C6191s.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.f1779Eu.stopLoading();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final C0383c<D> mo14015a(LifecycleOwner lifecycleOwner, C0353a<D> c0353a) {
            C6188b c6188b = new C6188b(this.f1779Eu, c0353a);
            observe(lifecycleOwner, c6188b);
            if (this.f1780Ev != null) {
                removeObserver(this.f1780Ev);
            }
            this.f1777Eq = lifecycleOwner;
            this.f1780Ev = c6188b;
            return this.f1779Eu;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final void mo14016dr() {
            LifecycleOwner lifecycleOwner = this.f1777Eq;
            C6188b c6188b = this.f1780Ev;
            if (lifecycleOwner != null && c6188b != null) {
                super.removeObserver(c6188b);
                observe(lifecycleOwner, c6188b);
            }
        }

        public final void removeObserver(Observer<D> observer) {
            super.removeObserver(observer);
            this.f1777Eq = null;
            this.f1780Ev = null;
        }

        /* renamed from: m */
        public final void mo665m(D d) {
            if (C6191s.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            boolean z = C6191s.DEBUG;
            postValue(d);
        }

        public final void setValue(D d) {
            super.setValue(d);
            if (this.f1781Ew != null) {
                this.f1781Ew.reset();
                this.f1781Ew = null;
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            C0405d.m692a(this.f1779Eu, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1778Et);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1779Eu);
            this.f1779Eu.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f1780Ev != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f1780Ev);
                C6188b c6188b = this.f1780Ev;
                printWriter.print(str + "  ");
                printWriter.print("mDeliveredData=");
                printWriter.println(c6188b.f1771Ey);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f1779Eu.dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }
    }

    C6191s(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f1774Eq = lifecycleOwner;
        this.f1775Er = C6190c.m9939a(viewModelStore);
    }

    /* renamed from: b */
    private <D> C0383c<D> m9942b(C0353a<D> c0353a) {
        try {
            this.f1776Es = true;
            C0383c onCreateLoader = c0353a.onCreateLoader(0, null);
            C6192a isMemberClass = onCreateLoader.getClass().isMemberClass();
            if (isMemberClass == true) {
                isMemberClass = Modifier.isStatic(onCreateLoader.getClass().getModifiers());
                if (!isMemberClass == true) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(onCreateLoader)));
                }
            }
            isMemberClass = new C6192a(onCreateLoader);
            if (DEBUG) {
                new StringBuilder("  Created new loader ").append(isMemberClass);
            }
            this.f1775Er.f1773EA.put(0, isMemberClass);
            return isMemberClass.mo14015a(this.f1774Eq, c0353a);
        } finally {
            this.f1776Es = false;
        }
    }

    /* renamed from: a */
    public final <D> C0383c<D> mo607a(C0353a<D> c0353a) {
        if (this.f1776Es) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        } else {
            C6192a c6192a = (C6192a) this.f1775Er.f1773EA.mo847aH(0);
            if (DEBUG) {
                new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
            }
            if (c6192a == null) {
                return m9942b(c0353a);
            }
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(c6192a);
            }
            return c6192a.mo14015a(this.f1774Eq, c0353a);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0405d.m692a(this.f1774Eq, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1775Er.dump(str, fileDescriptor, printWriter, strArr);
    }
}
