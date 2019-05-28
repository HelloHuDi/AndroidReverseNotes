package android.support.p057v4.app;

import android.os.Bundle;
import android.support.p057v4.content.C0383c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.r */
public abstract class C0354r {

    /* renamed from: android.support.v4.app.r$a */
    public interface C0353a<D> {
        C0383c<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(C0383c<D> c0383c, D d);

        void onLoaderReset(C0383c<D> c0383c);
    }

    /* renamed from: a */
    public abstract <D> C0383c<D> mo607a(C0353a<D> c0353a);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
