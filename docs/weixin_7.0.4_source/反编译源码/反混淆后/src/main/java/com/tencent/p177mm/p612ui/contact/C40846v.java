package com.tencent.p177mm.p612ui.contact;

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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;

/* renamed from: com.tencent.mm.ui.contact.v */
public final class C40846v extends LinearLayout {
    private Context context;
    private String zoe;

    /* renamed from: com.tencent.mm.ui.contact.v$2 */
    class C306692 implements OnTouchListener {
        C306692() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(33812);
            if (C40846v.this.context instanceof MMActivity) {
                ((MMActivity) C40846v.this.context).aqX();
            }
            AppMethodBeat.m2505o(33812);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.v$1 */
    class C408471 implements OnClickListener {
        C408471() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33811);
            Context context = view.getContext();
            Intent intent = new Intent(context, OpenIMAddressUI.class);
            intent.addFlags(67108864);
            intent.putExtra("key_openim_acctype_id", C40846v.this.zoe);
            context.startActivity(intent);
            AppMethodBeat.m2505o(33811);
        }
    }

    public C40846v(Context context, String str) {
        super(context);
        AppMethodBeat.m2504i(33813);
        this.context = context;
        this.zoe = str;
        View inflate = View.inflate(getContext(), 2130970338, this);
        View findViewById = findViewById(2131823612);
        inflate.setOnClickListener(new C408471());
        findViewById.setOnTouchListener(new C306692());
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(2131821798);
        ((C32873b) C1720g.m3528K(C32873b.class)).mo44305b(this.zoe, "openim_acct_type_icon", C32874a.TYPE_URL);
        if (this.zoe.equals("cloudim")) {
            ((ImageView) maskLayout.getContentView()).setImageResource(C1318a.avatar_wechat_frame);
        }
        ((TextView) findViewById(2131823613)).setText(((C32873b) C1720g.m3528K(C32873b.class)).mo44305b(this.zoe, "openim_acct_type_title", C32874a.TYPE_WORDING));
        AppMethodBeat.m2505o(33813);
    }
}
