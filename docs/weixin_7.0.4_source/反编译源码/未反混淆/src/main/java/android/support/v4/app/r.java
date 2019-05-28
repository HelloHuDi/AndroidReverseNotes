package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class r {

    public interface a<D> {
        c<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(c<D> cVar, D d);

        void onLoaderReset(c<D> cVar);
    }

    public abstract <D> c<D> a(a<D> aVar);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
