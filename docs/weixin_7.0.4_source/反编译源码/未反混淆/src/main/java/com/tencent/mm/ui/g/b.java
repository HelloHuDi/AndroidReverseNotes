package com.tencent.mm.ui.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

public final class b extends o {
    public long mDuration = 3000;
    @SuppressLint({"HandlerLeak"})
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(107426);
            switch (message.what) {
                case 256:
                    b.this.dismiss();
                    AppMethodBeat.o(107426);
                    return;
                default:
                    super.handleMessage(message);
                    AppMethodBeat.o(107426);
                    return;
            }
        }
    };

    private b(View view) {
        super(view);
        AppMethodBeat.i(107427);
        AppMethodBeat.o(107427);
    }

    public static b ig(Context context) {
        AppMethodBeat.i(107428);
        View inflate = LayoutInflater.from(context).inflate(R.layout.azu, null);
        ((TextView) inflate.findViewById(R.id.ew6)).setVisibility(8);
        b bVar = new b(inflate);
        bVar.setFocusable(false);
        bVar.setContentView(inflate);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        bVar.setAnimationStyle(R.style.ur);
        bVar.mDuration = 1200;
        AppMethodBeat.o(107428);
        return bVar;
    }

    public final void showAsDropDown(View view, int i, int i2) {
        AppMethodBeat.i(107429);
        super.showAsDropDown(view, i, i2);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.o(107429);
    }

    public final void showAsDropDown(View view) {
        AppMethodBeat.i(107430);
        super.showAsDropDown(view);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.o(107430);
    }

    public final void showAtLocation(View view, int i, int i2, int i3) {
        AppMethodBeat.i(107431);
        super.showAtLocation(view, i, i2, i3);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
        AppMethodBeat.o(107431);
    }
}
