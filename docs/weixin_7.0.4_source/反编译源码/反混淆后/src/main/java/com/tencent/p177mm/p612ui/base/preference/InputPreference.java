package com.tencent.p177mm.p612ui.base.preference;

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

/* renamed from: com.tencent.mm.ui.base.preference.InputPreference */
public class InputPreference extends Preference {
    private String suV;
    private C15537a suY;
    private OnClickListener sva;
    private String yCe;
    private EditText yCf;
    private Button yCg;
    private OnEditorActionListener yCh;

    /* renamed from: com.tencent.mm.ui.base.preference.InputPreference$a */
    public interface C15537a {
    }

    /* renamed from: com.tencent.mm.ui.base.preference.InputPreference$1 */
    class C360751 implements OnClickListener {
        C360751() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107195);
            if (!(InputPreference.this.suY == null || InputPreference.this.yCf == null)) {
                if (InputPreference.this.yCf.getText() == null) {
                    InputPreference.this.suY;
                    AppMethodBeat.m2505o(107195);
                    return;
                }
                InputPreference.this.suY;
                InputPreference.this.yCf.getText();
            }
            AppMethodBeat.m2505o(107195);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.InputPreference$2 */
    class C406732 implements OnEditorActionListener {
        C406732() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(107196);
            if (3 != i || InputPreference.this.suY == null || InputPreference.this.yCf == null) {
                AppMethodBeat.m2505o(107196);
                return false;
            }
            if (InputPreference.this.yCf.getText() == null) {
                InputPreference.this.suY;
            } else {
                InputPreference.this.suY;
                InputPreference.this.yCf.getText();
            }
            AppMethodBeat.m2505o(107196);
            return true;
        }
    }

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107197);
        this.sva = new C360751();
        this.yCh = new C406732();
        AppMethodBeat.m2505o(107197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107198);
        super.onBindView(view);
        this.yCf = (EditText) view.findViewById(2131820980);
        this.yCf.setHint(this.suV);
        this.yCf.setOnEditorActionListener(this.yCh);
        this.yCg = (Button) view.findViewById(2131820869);
        this.yCg.setText(this.yCe);
        this.yCg.setOnClickListener(this.sva);
        AppMethodBeat.m2505o(107198);
    }
}
