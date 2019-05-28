package android.support.p057v4.content;

import android.content.Context;
import android.support.p057v4.p065f.C0405d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.content.c */
public class C0383c<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    C0382b<D> mListener;
    C0381a<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    /* renamed from: android.support.v4.content.c$a */
    public interface C0381a<D> {
    }

    /* renamed from: android.support.v4.content.c$b */
    public interface C0382b<D> {
        /* renamed from: m */
        void mo665m(D d);
    }

    public C0383c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void deliverResult(D d) {
        if (this.mListener != null) {
            this.mListener.mo665m(d);
        }
    }

    public void deliverCancellation() {
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public void registerListener(int i, C0382b<D> c0382b) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = c0382b;
        this.mId = i;
    }

    public void unregisterListener(C0382b<D> c0382b) {
        if (this.mListener == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.mListener != c0382b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.mListener = null;
        }
    }

    public void registerOnLoadCanceledListener(C0381a<D> c0381a) {
        if (this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = c0381a;
    }

    public void unregisterOnLoadCanceledListener(C0381a<D> c0381a) {
        if (this.mOnLoadCanceledListener == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.mOnLoadCanceledListener != c0381a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.mOnLoadCanceledListener = null;
        }
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    /* Access modifiers changed, original: protected */
    public void onStartLoading() {
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    /* Access modifiers changed, original: protected */
    public boolean onCancelLoad() {
        return false;
    }

    public void forceLoad() {
        onForceLoad();
    }

    /* Access modifiers changed, original: protected */
    public void onForceLoad() {
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    /* Access modifiers changed, original: protected */
    public void onStopLoading() {
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    /* Access modifiers changed, original: protected */
    public void onAbandon() {
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    /* Access modifiers changed, original: protected */
    public void onReset() {
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public String dataToString(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0405d.m692a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0405d.m692a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.mId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }
}
