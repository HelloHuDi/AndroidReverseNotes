package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.writingbuddy.WritingBuddyImpl;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnImageWritingListener;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnTextWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookWritingBuddy {
    private static final String TAG = "WritingBuddy";
    public static final int TYPE_EDITOR_NUMBER = 1;
    public static final int TYPE_EDITOR_TEXT = 2;
    private ImageWritingListener mImageWritingListener;
    private View mParentView;
    private Slook mSlook = new Slook();
    private TextWritingListener mTextWritingListener;
    private WritingBuddyImpl mWritingBuddyImpl;

    public interface TextWritingListener {
        void onTextReceived(CharSequence charSequence);
    }

    public interface ImageWritingListener {
        void onImageReceived(Bitmap bitmap);
    }

    public SlookWritingBuddy(ViewGroup viewGroup) {
        AppMethodBeat.i(117195);
        if (isSupport(1)) {
            this.mParentView = viewGroup;
            this.mWritingBuddyImpl = new WritingBuddyImpl(viewGroup);
            AppMethodBeat.o(117195);
            return;
        }
        AppMethodBeat.o(117195);
    }

    public SlookWritingBuddy(EditText editText) {
        AppMethodBeat.i(117196);
        if (isSupport(1)) {
            this.mParentView = editText;
            this.mWritingBuddyImpl = new WritingBuddyImpl(editText);
            AppMethodBeat.o(117196);
            return;
        }
        AppMethodBeat.o(117196);
    }

    public final void setEditorType(int i) {
        AppMethodBeat.i(117197);
        if (isSupport(1)) {
            this.mWritingBuddyImpl.setEditorType(i);
            AppMethodBeat.o(117197);
            return;
        }
        AppMethodBeat.o(117197);
    }

    public final int getEditorType() {
        AppMethodBeat.i(117198);
        if (isSupport(1)) {
            int editorType = this.mWritingBuddyImpl.getEditorType();
            AppMethodBeat.o(117198);
            return editorType;
        }
        AppMethodBeat.o(117198);
        return 0;
    }

    public final void setTextWritingListener(TextWritingListener textWritingListener) {
        AppMethodBeat.i(117199);
        if (isSupport(1)) {
            this.mTextWritingListener = textWritingListener;
            this.mWritingBuddyImpl.setOnTextWritingListener(new OnTextWritingListener() {
                public void onTextReceived(CharSequence charSequence) {
                    AppMethodBeat.i(117194);
                    SlookWritingBuddy.this.mTextWritingListener.onTextReceived(charSequence);
                    AppMethodBeat.o(117194);
                }
            });
            AppMethodBeat.o(117199);
            return;
        }
        AppMethodBeat.o(117199);
    }

    public final void setImageWritingListener(ImageWritingListener imageWritingListener) {
        AppMethodBeat.i(117200);
        if (isSupport(1)) {
            this.mImageWritingListener = imageWritingListener;
            if (imageWritingListener == null) {
                this.mWritingBuddyImpl.setImageWritingEnabled(false);
                this.mWritingBuddyImpl.setOnImageWritingListener(null);
                AppMethodBeat.o(117200);
                return;
            }
            this.mWritingBuddyImpl.setImageWritingEnabled(true);
            this.mWritingBuddyImpl.setOnImageWritingListener(new OnImageWritingListener() {
                public void onImageReceived(Bitmap bitmap) {
                    AppMethodBeat.i(117193);
                    SlookWritingBuddy.this.mImageWritingListener.onImageReceived(bitmap);
                    AppMethodBeat.o(117193);
                }
            });
            AppMethodBeat.o(117200);
            return;
        }
        AppMethodBeat.o(117200);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.i(117201);
        IllegalStateException illegalStateException;
        if (!isSupport(1)) {
            AppMethodBeat.o(117201);
        } else if (this.mParentView == null) {
            illegalStateException = new IllegalStateException("mParentView is null.");
            AppMethodBeat.o(117201);
            throw illegalStateException;
        } else if (this.mParentView instanceof EditText) {
            this.mParentView.setWritingBuddyEnabled(z);
            AppMethodBeat.o(117201);
        } else if (this.mParentView.getWritingBuddy(false) != null) {
            this.mParentView.setWritingBuddyEnabled(z);
            AppMethodBeat.o(117201);
        } else {
            illegalStateException = new IllegalStateException("WritingBuddy was not enabled.");
            AppMethodBeat.o(117201);
            throw illegalStateException;
        }
    }

    public final boolean isEnabled() {
        AppMethodBeat.i(117202);
        if (!isSupport(1)) {
            AppMethodBeat.o(117202);
            return false;
        } else if (this.mParentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("mParentView is null.");
            AppMethodBeat.o(117202);
            throw illegalStateException;
        } else {
            boolean isWritingBuddyEnabled = this.mParentView.isWritingBuddyEnabled();
            AppMethodBeat.o(117202);
            return isWritingBuddyEnabled;
        }
    }

    private boolean isSupport(int i) {
        AppMethodBeat.i(117203);
        if (this.mSlook.isFeatureEnabled(3)) {
            AppMethodBeat.o(117203);
            return true;
        }
        AppMethodBeat.o(117203);
        return false;
    }
}
