package android.arch.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider {
    private final Factory cQ;
    private final ViewModelStore mViewModelStore;

    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    public static class NewInstanceFactory implements Factory {
        public <T extends ViewModel> T create(Class<T> cls) {
            try {
                return (ViewModel) cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            }
        }
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory cR;
        private Application cc;

        public static AndroidViewModelFactory getInstance(Application application) {
            if (cR == null) {
                cR = new AndroidViewModelFactory(application);
            }
            return cR;
        }

        public AndroidViewModelFactory(Application application) {
            this.cc = application;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.cc});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
            }
        }
    }

    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this.cQ = factory;
        this.mViewModelStore = viewModelStore;
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return get("android.arch.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(canonicalName)), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T get(String str, Class<T> cls) {
        ViewModel viewModel = (ViewModel) this.mViewModelStore.cS.get(str);
        if (cls.isInstance(viewModel)) {
            return viewModel;
        }
        T create = this.cQ.create(cls);
        this.mViewModelStore.a(str, create);
        return create;
    }
}
