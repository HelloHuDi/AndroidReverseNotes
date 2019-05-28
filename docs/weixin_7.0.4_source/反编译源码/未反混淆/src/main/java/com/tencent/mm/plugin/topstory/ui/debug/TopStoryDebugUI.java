package com.tencent.mm.plugin.topstory.ui.debug;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.vfs.e;

public class TopStoryDebugUI extends MMActivity {
    private TextView sBC;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1552);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ewx);
        setBackBtn(new t() {
            public final void Kp() {
                AppMethodBeat.i(1548);
                TopStoryDebugUI.this.finish();
                AppMethodBeat.o(1548);
            }
        });
        final ao HQ = aa.HQ(1);
        this.sBC = (TextView) findViewById(R.id.ew9);
        this.sBC.setText(getString(R.string.ewv, new Object[]{String.valueOf(HQ.afW())}));
        findViewById(R.id.ew_).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1549);
                String cVz = HQ.cVz();
                String atg = e.atg(String.format("%s/%s", new Object[]{HQ.aLD(), "dist/build.js"}));
                TopStoryDebugUI.aV(TopStoryDebugUI.this, String.format("currentConfigJSMD5: %s\ncurrentFileJSMD5: %s", new Object[]{cVz, atg}));
                AppMethodBeat.o(1549);
            }
        });
        findViewById(R.id.ewa).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1550);
                e.N(HQ.aLD(), true);
                Process.killProcess(Process.myPid());
                AppMethodBeat.o(1550);
            }
        });
        findViewById(R.id.ewb).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1551);
                try {
                    TopStoryDebugUI.aV(TopStoryDebugUI.this, e.cy(com.tencent.mm.compatible.util.e.eSn + "topstory/trace.info"));
                    AppMethodBeat.o(1551);
                } catch (Exception e) {
                    AppMethodBeat.o(1551);
                }
            }
        });
        AppMethodBeat.o(1552);
    }

    public final int getLayoutId() {
        return R.layout.azx;
    }

    static /* synthetic */ void aV(Context context, String str) {
        AppMethodBeat.i(1553);
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        h.a(context, null, textView, null);
        AppMethodBeat.o(1553);
    }
}
