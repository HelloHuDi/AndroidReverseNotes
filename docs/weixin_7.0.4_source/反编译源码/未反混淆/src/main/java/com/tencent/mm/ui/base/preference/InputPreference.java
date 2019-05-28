package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class InputPreference extends Preference {
    private String suV;
    private a suY;
    private OnClickListener sva;
    private String yCe;
    private EditText yCf;
    private Button yCg;
    private OnEditorActionListener yCh;

    public interface a {
    }

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107197);
        this.sva = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(107195);
                if (!(InputPreference.this.suY == null || InputPreference.this.yCf == null)) {
                    if (InputPreference.this.yCf.getText() == null) {
                        InputPreference.this.suY;
                        AppMethodBeat.o(107195);
                        return;
                    }
                    InputPreference.this.suY;
                    InputPreference.this.yCf.getText();
                }
                AppMethodBeat.o(107195);
            }
        };
        this.yCh = new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(107196);
                if (3 != i || InputPreference.this.suY == null || InputPreference.this.yCf == null) {
                    AppMethodBeat.o(107196);
                    return false;
                }
                if (InputPreference.this.yCf.getText() == null) {
                    InputPreference.this.suY;
                } else {
                    InputPreference.this.suY;
                    InputPreference.this.yCf.getText();
                }
                AppMethodBeat.o(107196);
                return true;
            }
        };
        AppMethodBeat.o(107197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107198);
        super.onBindView(view);
        this.yCf = (EditText) view.findViewById(R.id.l3);
        this.yCf.setHint(this.suV);
        this.yCf.setOnEditorActionListener(this.yCh);
        this.yCg = (Button) view.findViewById(R.id.i3);
        this.yCg.setText(this.yCe);
        this.yCg.setOnClickListener(this.sva);
        AppMethodBeat.o(107198);
    }
}
