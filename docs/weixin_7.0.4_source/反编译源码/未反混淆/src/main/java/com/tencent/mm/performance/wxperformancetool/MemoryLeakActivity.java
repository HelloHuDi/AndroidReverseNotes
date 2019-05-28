package com.tencent.mm.performance.wxperformancetool;

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
import com.tencent.mm.R;
import com.tencent.mm.cf.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

@TargetApi(17)
public class MemoryLeakActivity extends Activity {
    private AlertDialog ggr;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(76882);
            if (((WeakReference) a.ggu.get(MemoryLeakActivity.this.mKey)).get() == null) {
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(76882);
                return;
            }
            MemoryLeakActivity.this.ggr.show();
            AppMethodBeat.o(76882);
        }
    };
    private String mKey;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MemoryLeakActivity() {
        AppMethodBeat.i(76886);
        AppMethodBeat.o(76886);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(76887);
        super.onCreate(bundle);
        setContentView(R.layout.f7);
        Builder builder = new Builder(this);
        builder.setTitle("memory leak");
        this.mKey = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        final String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + b.ydz + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(76883);
                b.aqz(replace);
                if (MemoryLeakActivity.this.ggr != null && MemoryLeakActivity.this.ggr.isShowing()) {
                    MemoryLeakActivity.this.ggr.dismiss();
                }
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(76883);
            }
        });
        builder.setNegativeButton("cancel", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(76884);
                if (MemoryLeakActivity.this.ggr != null && MemoryLeakActivity.this.ggr.isShowing()) {
                    MemoryLeakActivity.this.ggr.dismiss();
                }
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(76884);
            }
        });
        builder.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(76885);
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(76885);
            }
        });
        this.ggr = builder.create();
        b.dvS();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
        AppMethodBeat.o(76887);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(76888);
        super.onDestroy();
        a.ggu.remove(this.mKey);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ggr != null && this.ggr.isShowing()) {
            this.ggr.dismiss();
            this.ggr = null;
        }
        AppMethodBeat.o(76888);
    }
}
