package android.arch.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;

public class AndroidViewModel extends ViewModel {
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: cc */
    private Application f1695cc;

    public AndroidViewModel(Application application) {
        this.f1695cc = application;
    }

    public <T extends Application> T getApplication() {
        return this.f1695cc;
    }
}
