package com.tencent.p177mm.plugin.emoji.p384ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView */
public class MMCopiableTextView extends EditText implements OnLongClickListener {
    private final String TAG = "MicroMsg.MMCopiableTextView";
    private int jis;
    private int lgz;

    public MMCopiableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53855);
        init();
        AppMethodBeat.m2505o(53855);
    }

    public MMCopiableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53856);
        init();
        AppMethodBeat.m2505o(53856);
    }

    private void init() {
        AppMethodBeat.m2504i(53857);
        setOnLongClickListener(this);
        setLongClickable(true);
        AppMethodBeat.m2505o(53857);
    }

    /* Access modifiers changed, original: protected */
    public void onCreateContextMenu(ContextMenu contextMenu) {
    }

    /* Access modifiers changed, original: protected */
    public boolean getDefaultEditable() {
        return false;
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.m2504i(53858);
        String obj = getEditableText().toString();
        if (!C5046bo.isNullOrNil(obj) && this.jis > 0 && this.lgz > 0 && this.lgz > this.jis) {
            ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setText(obj.substring(this.jis, this.lgz).trim());
                C4990ab.m7417i("MicroMsg.MMCopiableTextView", "copy text :%s", clipboardManager.getText());
            }
            Toast.makeText(getContext(), C25738R.string.f9083oz, 0).show();
        }
        AppMethodBeat.m2505o(53858);
        return false;
    }

    public void setStartIndex(int i) {
        this.jis = i;
    }

    public void setEndIndex(int i) {
        this.lgz = i;
    }
}
