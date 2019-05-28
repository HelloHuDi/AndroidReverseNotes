package com.tencent.p177mm.plugin.topstory.p541ui.debug;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.C24020t;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.websearch.api.C40190ao;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI */
public class TopStoryDebugUI extends MMActivity {
    private TextView sBC;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI$1 */
    class C248431 extends C24020t {
        C248431() {
        }

        /* renamed from: Kp */
        public final void mo39830Kp() {
            AppMethodBeat.m2504i(1548);
            TopStoryDebugUI.this.finish();
            AppMethodBeat.m2505o(1548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI$4 */
    class C436934 implements OnClickListener {
        C436934() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1551);
            try {
                TopStoryDebugUI.m86869aV(TopStoryDebugUI.this, C5730e.m8631cy(C6457e.eSn + "topstory/trace.info"));
                AppMethodBeat.m2505o(1551);
            } catch (Exception e) {
                AppMethodBeat.m2505o(1551);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1552);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ewx);
        setBackBtn(new C248431());
        final C40190ao HQ = C46400aa.m87300HQ(1);
        this.sBC = (TextView) findViewById(2131828248);
        this.sBC.setText(getString(C25738R.string.ewv, new Object[]{String.valueOf(HQ.afW())}));
        findViewById(2131828249).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(1549);
                String cVz = HQ.cVz();
                String atg = C5730e.atg(String.format("%s/%s", new Object[]{HQ.aLD(), "dist/build.js"}));
                TopStoryDebugUI.m86869aV(TopStoryDebugUI.this, String.format("currentConfigJSMD5: %s\ncurrentFileJSMD5: %s", new Object[]{cVz, atg}));
                AppMethodBeat.m2505o(1549);
            }
        });
        findViewById(2131828250).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(1550);
                C5730e.m8618N(HQ.aLD(), true);
                Process.killProcess(Process.myPid());
                AppMethodBeat.m2505o(1550);
            }
        });
        findViewById(2131828251).setOnClickListener(new C436934());
        AppMethodBeat.m2505o(1552);
    }

    public final int getLayoutId() {
        return 2130970936;
    }

    /* renamed from: aV */
    static /* synthetic */ void m86869aV(Context context, String str) {
        AppMethodBeat.m2504i(1553);
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        C30379h.m48435a(context, null, textView, null);
        AppMethodBeat.m2505o(1553);
    }
}
