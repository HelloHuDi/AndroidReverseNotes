package com.tencent.p177mm.p612ui.p1347g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.g.b */
public final class C24005b extends C46633o {
    public long mDuration = 3000;
    @SuppressLint({"HandlerLeak"})
    private C7306ak mHandler = new C240061();

    /* renamed from: com.tencent.mm.ui.g.b$1 */
    class C240061 extends C7306ak {
        C240061() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(107426);
            switch (message.what) {
                case 256:
                    C24005b.this.dismiss();
                    AppMethodBeat.m2505o(107426);
                    return;
                default:
                    super.handleMessage(message);
                    AppMethodBeat.m2505o(107426);
                    return;
            }
        }
    }

    private C24005b(View view) {
        super(view);
        AppMethodBeat.m2504i(107427);
        AppMethodBeat.m2505o(107427);
    }

    /* renamed from: ig */
    public static C24005b m36990ig(Context context) {
        AppMethodBeat.m2504i(107428);
        View inflate = LayoutInflater.from(context).inflate(2130970933, null);
        ((TextView) inflate.findViewById(2131828245)).setVisibility(8);
        C24005b c24005b = new C24005b(inflate);
        c24005b.setFocusable(false);
        c24005b.setContentView(inflate);
        c24005b.setWidth(-1);
        c24005b.setHeight(-1);
        c24005b.setAnimationStyle(C25738R.style.f11261ur);
        c24005b.mDuration = 1200;
        AppMethodBeat.m2505o(107428);
        return c24005b;
    }

    public final void showAsDropDown(View view, int i, int i2) {
        AppMethodBeat.m2504i(107429);
        super.showAsDropDown(view, i, i2);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.m2505o(107429);
    }

    public final void showAsDropDown(View view) {
        AppMethodBeat.m2504i(107430);
        super.showAsDropDown(view);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.m2505o(107430);
    }

    public final void showAtLocation(View view, int i, int i2, int i3) {
        AppMethodBeat.m2504i(107431);
        super.showAtLocation(view, i, i2, i3);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.m2505o(107431);
    }
}
