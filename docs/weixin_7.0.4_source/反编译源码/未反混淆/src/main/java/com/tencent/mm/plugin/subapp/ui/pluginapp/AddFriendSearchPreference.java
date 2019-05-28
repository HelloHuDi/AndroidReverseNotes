package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference extends Preference {
    private Context context;
    private TextView gDQ;
    private String suU;
    String suV;
    private OnClickListener suW;
    OnClickListener suX;
    private a suY;
    private TextView suZ;
    private OnClickListener sva;

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25495);
        this.suU = "";
        this.suV = "";
        this.suW = null;
        this.suX = null;
        this.suY = null;
        this.suZ = null;
        this.gDQ = null;
        this.sva = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25493);
                if (!(AddFriendSearchPreference.this.suY == null || AddFriendSearchPreference.this.suZ == null)) {
                    if (AddFriendSearchPreference.this.suZ.getText() == null) {
                        AddFriendSearchPreference.this.suY;
                        AppMethodBeat.o(25493);
                        return;
                    }
                    AddFriendSearchPreference.this.suY;
                    AddFriendSearchPreference.this.suZ.getText().toString();
                }
                AppMethodBeat.o(25493);
            }
        };
        this.context = context;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(25495);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(25496);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.aej, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), 0, viewGroup2.getPaddingBottom());
        AppMethodBeat.o(25496);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(25497);
        super.onBindView(view);
        view.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.suZ = (TextView) view.findViewById(R.id.l3);
        this.gDQ = (TextView) view.findViewById(R.id.d_4);
        this.gDQ.setText(this.suV);
        if (this.suX != null) {
            this.gDQ.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(25494);
                    if (motionEvent.getAction() == 1) {
                        AddFriendSearchPreference.this.suX.onClick(view);
                    }
                    AppMethodBeat.o(25494);
                    return true;
                }
            });
        }
        if (this.suY != null) {
            Button button = (Button) view.findViewById(R.id.i3);
            button.setOnClickListener(this.sva);
            button.setVisibility(0);
        }
        NW(8);
        AppMethodBeat.o(25497);
    }
}
