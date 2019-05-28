package com.tencent.p177mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p215cf.C37632b;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;

@TargetApi(17)
/* renamed from: com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity */
public class MemoryLeakActivity extends Activity {
    private AlertDialog ggr;
    private C7306ak mHandler = new C97791();
    private String mKey;

    /* renamed from: com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity$1 */
    class C97791 extends C7306ak {
        C97791() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(76882);
            if (((WeakReference) C18755a.ggu.get(MemoryLeakActivity.this.mKey)).get() == null) {
                MemoryLeakActivity.this.finish();
                AppMethodBeat.m2505o(76882);
                return;
            }
            MemoryLeakActivity.this.ggr.show();
            AppMethodBeat.m2505o(76882);
        }
    }

    /* renamed from: com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity$3 */
    class C97813 implements OnClickListener {
        C97813() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(76884);
            if (MemoryLeakActivity.this.ggr != null && MemoryLeakActivity.this.ggr.isShowing()) {
                MemoryLeakActivity.this.ggr.dismiss();
            }
            MemoryLeakActivity.this.finish();
            AppMethodBeat.m2505o(76884);
        }
    }

    /* renamed from: com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity$4 */
    class C97824 implements OnDismissListener {
        C97824() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(76885);
            MemoryLeakActivity.this.finish();
            AppMethodBeat.m2505o(76885);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MemoryLeakActivity() {
        AppMethodBeat.m2504i(76886);
        AppMethodBeat.m2505o(76886);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(76887);
        super.onCreate(bundle);
        setContentView(2130968794);
        Builder builder = new Builder(this);
        builder.setTitle("memory leak");
        this.mKey = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        final String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + C37632b.ydz + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(76883);
                C37632b.aqz(replace);
                if (MemoryLeakActivity.this.ggr != null && MemoryLeakActivity.this.ggr.isShowing()) {
                    MemoryLeakActivity.this.ggr.dismiss();
                }
                MemoryLeakActivity.this.finish();
                AppMethodBeat.m2505o(76883);
            }
        });
        builder.setNegativeButton("cancel", new C97813());
        builder.setOnDismissListener(new C97824());
        this.ggr = builder.create();
        C37632b.dvS();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
        AppMethodBeat.m2505o(76887);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(76888);
        super.onDestroy();
        C18755a.ggu.remove(this.mKey);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ggr != null && this.ggr.isShowing()) {
            this.ggr.dismiss();
            this.ggr = null;
        }
        AppMethodBeat.m2505o(76888);
    }
}
