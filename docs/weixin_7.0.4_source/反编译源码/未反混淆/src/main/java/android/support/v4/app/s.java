package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.f.d;
import android.support.v4.f.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class s extends r {
    static boolean DEBUG = false;
    private final LifecycleOwner Eq;
    final c Er;
    private boolean Es;

    static class b<D> implements Observer<D> {
        final android.support.v4.content.c<D> Eu;
        final android.support.v4.app.r.a<D> Ex;
        boolean Ey = false;

        b(android.support.v4.content.c<D> cVar, android.support.v4.app.r.a<D> aVar) {
            this.Eu = cVar;
            this.Ex = aVar;
        }

        public final void onChanged(D d) {
            if (s.DEBUG) {
                new StringBuilder("  onLoadFinished in ").append(this.Eu).append(": ").append(this.Eu.dataToString(d));
            }
            this.Ex.onLoadFinished(this.Eu, d);
            this.Ey = true;
        }

        public final String toString() {
            return this.Ex.toString();
        }
    }

    static class c extends ViewModel {
        private static final Factory Ez = new Factory() {
            public final <T extends ViewModel> T create(Class<T> cls) {
                return new c();
            }
        };
        n<a> EA = new n();

        c() {
        }

        static c a(ViewModelStore viewModelStore) {
            return (c) new ViewModelProvider(viewModelStore, Ez).get(c.class);
        }

        /* Access modifiers changed, original: final */
        public final void dr() {
            int size = this.EA.size();
            for (int i = 0; i < size; i++) {
                ((a) this.EA.valueAt(i)).dr();
            }
        }

        public final void ao() {
            super.ao();
            int size = this.EA.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) this.EA.valueAt(i);
                if (s.DEBUG) {
                    new StringBuilder("  Destroying: ").append(aVar);
                }
                aVar.Eu.cancelLoad();
                aVar.Eu.abandon();
                b bVar = aVar.Ev;
                if (bVar != null) {
                    aVar.removeObserver(bVar);
                    if (bVar.Ey) {
                        if (s.DEBUG) {
                            new StringBuilder("  Resetting: ").append(bVar.Eu);
                        }
                        bVar.Ex.onLoaderReset(bVar.Eu);
                    }
                }
                aVar.Eu.unregisterListener(aVar);
                aVar.Eu.reset();
            }
            this.EA.clear();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.EA.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.EA.size()) {
                        a aVar = (a) this.EA.valueAt(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(this.EA.keyAt(i2));
                        printWriter.print(": ");
                        printWriter.println(aVar.toString());
                        aVar.dump(str2, fileDescriptor, printWriter, strArr);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static class a<D> extends MutableLiveData<D> implements android.support.v4.content.c.b<D> {
        private LifecycleOwner Eq;
        private final Bundle Et = null;
        final android.support.v4.content.c<D> Eu;
        b<D> Ev;
        android.support.v4.content.c<D> Ew;
        private final int mId = 0;

        a(android.support.v4.content.c<D> cVar) {
            this.Eu = cVar;
            this.Ew = null;
            this.Eu.registerListener(0, this);
        }

        public final void onActive() {
            if (s.DEBUG) {
                new StringBuilder("  Starting: ").append(this);
            }
            this.Eu.startLoading();
        }

        public final void ag() {
            if (s.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.Eu.stopLoading();
        }

        /* Access modifiers changed, original: final */
        public final android.support.v4.content.c<D> a(LifecycleOwner lifecycleOwner, android.support.v4.app.r.a<D> aVar) {
            b bVar = new b(this.Eu, aVar);
            observe(lifecycleOwner, bVar);
            if (this.Ev != null) {
                removeObserver(this.Ev);
            }
            this.Eq = lifecycleOwner;
            this.Ev = bVar;
            return this.Eu;
        }

        /* Access modifiers changed, original: final */
        public final void dr() {
            LifecycleOwner lifecycleOwner = this.Eq;
            b bVar = this.Ev;
            if (lifecycleOwner != null && bVar != null) {
                super.removeObserver(bVar);
                observe(lifecycleOwner, bVar);
            }
        }

        public final void removeObserver(Observer<D> observer) {
            super.removeObserver(observer);
            this.Eq = null;
            this.Ev = null;
        }

        public final void m(D d) {
            if (s.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            boolean z = s.DEBUG;
            postValue(d);
        }

        public final void setValue(D d) {
            super.setValue(d);
            if (this.Ew != null) {
                this.Ew.reset();
                this.Ew = null;
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            d.a(this.Eu, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.Et);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.Eu);
            this.Eu.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.Ev != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.Ev);
                b bVar = this.Ev;
                printWriter.print(str + "  ");
                printWriter.print("mDeliveredData=");
                printWriter.println(bVar.Ey);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.Eu.dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }
    }

    s(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.Eq = lifecycleOwner;
        this.Er = c.a(viewModelStore);
    }

    private <D> android.support.v4.content.c<D> b(android.support.v4.app.r.a<D> aVar) {
        try {
            this.Es = true;
            android.support.v4.content.c onCreateLoader = aVar.onCreateLoader(0, null);
            a isMemberClass = onCreateLoader.getClass().isMemberClass();
            if (isMemberClass == true) {
                isMemberClass = Modifier.isStatic(onCreateLoader.getClass().getModifiers());
                if (!isMemberClass == true) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(onCreateLoader)));
                }
            }
            isMemberClass = new a(onCreateLoader);
            if (DEBUG) {
                new StringBuilder("  Created new loader ").append(isMemberClass);
            }
            this.Er.EA.put(0, isMemberClass);
            return isMemberClass.a(this.Eq, aVar);
        } finally {
            this.Es = false;
        }
    }

    public final <D> android.support.v4.content.c<D> a(android.support.v4.app.r.a<D> aVar) {
        if (this.Es) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        } else {
            a aVar2 = (a) this.Er.EA.aH(0);
            if (DEBUG) {
                new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
            }
            if (aVar2 == null) {
                return b(aVar);
            }
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(aVar2);
            }
            return aVar2.a(this.Eq, aVar);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.Eq, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.Er.dump(str, fileDescriptor, printWriter, strArr);
    }
}
