package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.InputPreference.C15537a;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference */
public class AddFriendSearchPreference extends Preference {
    private Context context;
    private TextView gDQ;
    private String suU;
    String suV;
    private OnClickListener suW;
    OnClickListener suX;
    private C15537a suY;
    private TextView suZ;
    private OnClickListener sva;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference$1 */
    class C41981 implements OnClickListener {
        C41981() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25493);
            if (!(AddFriendSearchPreference.this.suY == null || AddFriendSearchPreference.this.suZ == null)) {
                if (AddFriendSearchPreference.this.suZ.getText() == null) {
                    AddFriendSearchPreference.this.suY;
                    AppMethodBeat.m2505o(25493);
                    return;
                }
                AddFriendSearchPreference.this.suY;
                AddFriendSearchPreference.this.suZ.getText().toString();
            }
            AppMethodBeat.m2505o(25493);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference$2 */
    class C223512 implements OnTouchListener {
        C223512() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference$3 */
    class C352723 implements OnTouchListener {
        C352723() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(25494);
            if (motionEvent.getAction() == 1) {
                AddFriendSearchPreference.this.suX.onClick(view);
            }
            AppMethodBeat.m2505o(25494);
            return true;
        }
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25495);
        this.suU = "";
        this.suV = "";
        this.suW = null;
        this.suX = null;
        this.suY = null;
        this.suZ = null;
        this.gDQ = null;
        this.sva = new C41981();
        this.context = context;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(25495);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(25496);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970143, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), 0, viewGroup2.getPaddingBottom());
        AppMethodBeat.m2505o(25496);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(25497);
        super.onBindView(view);
        view.setOnTouchListener(new C223512());
        this.suZ = (TextView) view.findViewById(2131820980);
        this.gDQ = (TextView) view.findViewById(2131826023);
        this.gDQ.setText(this.suV);
        if (this.suX != null) {
            this.gDQ.setOnTouchListener(new C352723());
        }
        if (this.suY != null) {
            Button button = (Button) view.findViewById(2131820869);
            button.setOnClickListener(this.sva);
            button.setVisibility(0);
        }
        mo39406NW(8);
        AppMethodBeat.m2505o(25497);
    }
}
