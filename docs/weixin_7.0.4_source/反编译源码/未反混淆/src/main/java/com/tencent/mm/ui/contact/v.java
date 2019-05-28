package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class v extends LinearLayout {
    private Context context;
    private String zoe;

    public v(Context context, String str) {
        super(context);
        AppMethodBeat.i(33813);
        this.context = context;
        this.zoe = str;
        View inflate = View.inflate(getContext(), R.layout.ajs, this);
        View findViewById = findViewById(R.id.bhx);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(33811);
                Context context = view.getContext();
                Intent intent = new Intent(context, OpenIMAddressUI.class);
                intent.addFlags(67108864);
                intent.putExtra("key_openim_acctype_id", v.this.zoe);
                context.startActivity(intent);
                AppMethodBeat.o(33811);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(33812);
                if (v.this.context instanceof MMActivity) {
                    ((MMActivity) v.this.context).aqX();
                }
                AppMethodBeat.o(33812);
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.id.a6v);
        ((b) g.K(b.class)).b(this.zoe, "openim_acct_type_icon", a.TYPE_URL);
        if (this.zoe.equals("cloudim")) {
            ((ImageView) maskLayout.getContentView()).setImageResource(R.raw.avatar_wechat_frame);
        }
        ((TextView) findViewById(R.id.bhy)).setText(((b) g.K(b.class)).b(this.zoe, "openim_acct_type_title", a.TYPE_WORDING));
        AppMethodBeat.o(33813);
    }
}
