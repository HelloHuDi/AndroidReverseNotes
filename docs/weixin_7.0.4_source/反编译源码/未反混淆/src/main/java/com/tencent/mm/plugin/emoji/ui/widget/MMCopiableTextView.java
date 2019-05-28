package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class MMCopiableTextView extends EditText implements OnLongClickListener {
    private final String TAG = "MicroMsg.MMCopiableTextView";
    private int jis;
    private int lgz;

    public MMCopiableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53855);
        init();
        AppMethodBeat.o(53855);
    }

    public MMCopiableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53856);
        init();
        AppMethodBeat.o(53856);
    }

    private void init() {
        AppMethodBeat.i(53857);
        setOnLongClickListener(this);
        setLongClickable(true);
        AppMethodBeat.o(53857);
    }

    /* Access modifiers changed, original: protected */
    public void onCreateContextMenu(ContextMenu contextMenu) {
    }

    /* Access modifiers changed, original: protected */
    public boolean getDefaultEditable() {
        return false;
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(53858);
        String obj = getEditableText().toString();
        if (!bo.isNullOrNil(obj) && this.jis > 0 && this.lgz > 0 && this.lgz > this.jis) {
            ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setText(obj.substring(this.jis, this.lgz).trim());
                ab.i("MicroMsg.MMCopiableTextView", "copy text :%s", clipboardManager.getText());
            }
            Toast.makeText(getContext(), R.string.oz, 0).show();
        }
        AppMethodBeat.o(53858);
        return false;
    }

    public void setStartIndex(int i) {
        this.jis = i;
    }

    public void setEndIndex(int i) {
        this.lgz = i;
    }
}
