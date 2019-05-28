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

    /* renamed from: com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy$2 */
    class C87522 implements OnImageWritingListener {
        C87522() {
        }

        public void onImageReceived(Bitmap bitmap) {
            AppMethodBeat.m2504i(117193);
            SlookWritingBuddy.this.mImageWritingListener.onImageReceived(bitmap);
            AppMethodBeat.m2505o(117193);
        }
    }

    public interface ImageWritingListener {
        void onImageReceived(Bitmap bitmap);
    }

    /* renamed from: com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy$1 */
    class C416571 implements OnTextWritingListener {
        C416571() {
        }

        public void onTextReceived(CharSequence charSequence) {
            AppMethodBeat.m2504i(117194);
            SlookWritingBuddy.this.mTextWritingListener.onTextReceived(charSequence);
            AppMethodBeat.m2505o(117194);
        }
    }

    public SlookWritingBuddy(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(117195);
        if (isSupport(1)) {
            this.mParentView = viewGroup;
            this.mWritingBuddyImpl = new WritingBuddyImpl(viewGroup);
            AppMethodBeat.m2505o(117195);
            return;
        }
        AppMethodBeat.m2505o(117195);
    }

    public SlookWritingBuddy(EditText editText) {
        AppMethodBeat.m2504i(117196);
        if (isSupport(1)) {
            this.mParentView = editText;
            this.mWritingBuddyImpl = new WritingBuddyImpl(editText);
            AppMethodBeat.m2505o(117196);
            return;
        }
        AppMethodBeat.m2505o(117196);
    }

    public final void setEditorType(int i) {
        AppMethodBeat.m2504i(117197);
        if (isSupport(1)) {
            this.mWritingBuddyImpl.setEditorType(i);
            AppMethodBeat.m2505o(117197);
            return;
        }
        AppMethodBeat.m2505o(117197);
    }

    public final int getEditorType() {
        AppMethodBeat.m2504i(117198);
        if (isSupport(1)) {
            int editorType = this.mWritingBuddyImpl.getEditorType();
            AppMethodBeat.m2505o(117198);
            return editorType;
        }
        AppMethodBeat.m2505o(117198);
        return 0;
    }

    public final void setTextWritingListener(TextWritingListener textWritingListener) {
        AppMethodBeat.m2504i(117199);
        if (isSupport(1)) {
            this.mTextWritingListener = textWritingListener;
            this.mWritingBuddyImpl.setOnTextWritingListener(new C416571());
            AppMethodBeat.m2505o(117199);
            return;
        }
        AppMethodBeat.m2505o(117199);
    }

    public final void setImageWritingListener(ImageWritingListener imageWritingListener) {
        AppMethodBeat.m2504i(117200);
        if (isSupport(1)) {
            this.mImageWritingListener = imageWritingListener;
            if (imageWritingListener == null) {
                this.mWritingBuddyImpl.setImageWritingEnabled(false);
                this.mWritingBuddyImpl.setOnImageWritingListener(null);
                AppMethodBeat.m2505o(117200);
                return;
            }
            this.mWritingBuddyImpl.setImageWritingEnabled(true);
            this.mWritingBuddyImpl.setOnImageWritingListener(new C87522());
            AppMethodBeat.m2505o(117200);
            return;
        }
        AppMethodBeat.m2505o(117200);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.m2504i(117201);
        IllegalStateException illegalStateException;
        if (!isSupport(1)) {
            AppMethodBeat.m2505o(117201);
        } else if (this.mParentView == null) {
            illegalStateException = new IllegalStateException("mParentView is null.");
            AppMethodBeat.m2505o(117201);
            throw illegalStateException;
        } else if (this.mParentView instanceof EditText) {
            this.mParentView.setWritingBuddyEnabled(z);
            AppMethodBeat.m2505o(117201);
        } else if (this.mParentView.getWritingBuddy(false) != null) {
            this.mParentView.setWritingBuddyEnabled(z);
            AppMethodBeat.m2505o(117201);
        } else {
            illegalStateException = new IllegalStateException("WritingBuddy was not enabled.");
            AppMethodBeat.m2505o(117201);
            throw illegalStateException;
        }
    }

    public final boolean isEnabled() {
        AppMethodBeat.m2504i(117202);
        if (!isSupport(1)) {
            AppMethodBeat.m2505o(117202);
            return false;
        } else if (this.mParentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("mParentView is null.");
            AppMethodBeat.m2505o(117202);
            throw illegalStateException;
        } else {
            boolean isWritingBuddyEnabled = this.mParentView.isWritingBuddyEnabled();
            AppMethodBeat.m2505o(117202);
            return isWritingBuddyEnabled;
        }
    }

    private boolean isSupport(int i) {
        AppMethodBeat.m2504i(117203);
        if (this.mSlook.isFeatureEnabled(3)) {
            AppMethodBeat.m2505o(117203);
            return true;
        }
        AppMethodBeat.m2505o(117203);
        return false;
    }
}
