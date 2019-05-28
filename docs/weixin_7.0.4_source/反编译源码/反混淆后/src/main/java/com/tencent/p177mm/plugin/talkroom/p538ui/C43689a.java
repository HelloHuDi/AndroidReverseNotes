package com.tencent.p177mm.plugin.talkroom.p538ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.talkroom.ui.a */
public final class C43689a {
    private static final int[] gcc = new int[]{C25738R.drawable.aab, C25738R.drawable.aac, C25738R.drawable.aad, C25738R.drawable.aae, C25738R.drawable.aaf, C25738R.drawable.aag, C25738R.drawable.aah};
    private static final int[] miN = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private Context context;
    private View miF;
    private View miG;
    private ImageView miH;
    private View miJ;
    private final C7306ak miO = new C139421();
    private int saE;
    private C46633o szb;
    private TextView szc;
    private ImageView szd;
    private View sze;

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.a$1 */
    class C139421 extends C7306ak {
        C139421() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(25888);
            super.handleMessage(message);
            C43689a.this.szb.dismiss();
            AppMethodBeat.m2505o(25888);
        }
    }

    public C43689a(Context context) {
        AppMethodBeat.m2504i(25889);
        this.context = context;
        this.saE = C4977b.m7371b(context, 180.0f);
        this.szb = new C46633o(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130971021, null), -1, -2);
        this.miH = (ImageView) this.szb.getContentView().findViewById(2131823958);
        this.miJ = this.szb.getContentView().findViewById(2131823960);
        this.szc = (TextView) this.szb.getContentView().findViewById(2131823962);
        this.szd = (ImageView) this.szb.getContentView().findViewById(2131823961);
        this.sze = this.szb.getContentView().findViewById(2131828470);
        this.miF = this.szb.getContentView().findViewById(2131823955);
        this.miG = this.szb.getContentView().findViewById(2131823963);
        AppMethodBeat.m2505o(25889);
    }
}
