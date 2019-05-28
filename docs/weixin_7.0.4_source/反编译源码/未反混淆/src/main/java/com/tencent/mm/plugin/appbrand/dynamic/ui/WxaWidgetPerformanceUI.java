package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.ttpic.baseutils.IOUtils;

public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn hpg;
    MMSwitchBtn hph;
    MMSwitchBtn hpi;

    static class d implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(11026);
            com.tencent.mm.plugin.appbrand.collector.c.dG(((IPCBoolean) obj).value);
            AppMethodBeat.o(11026);
        }
    }

    static class e implements i<IPCString, IPCString> {
        private e() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(11027);
            IPCString iPCString = new IPCString(com.tencent.mm.plugin.appbrand.collector.c.yJ(((IPCString) obj).value).toString());
            AppMethodBeat.o(11027);
            return iPCString;
        }
    }

    static class a implements com.tencent.mm.ipcinvoker.a<IPCVoid, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST);
            com.tencent.mm.plugin.appbrand.collector.c.clear();
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER);
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.yK("jsapi_draw_canvas");
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.yL("jsapi_draw_canvas");
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER);
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(11025);
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.yK("widget_launch");
                AppMethodBeat.o(11025);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.yL("widget_launch");
            AppMethodBeat.o(11025);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(11028);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT);
                WxaWidgetPerformanceUI.this.finish();
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT);
                return false;
            }
        });
        setMMTitle((int) R.string.g3k);
        final TextView textView = (TextView) findViewById(R.id.dmn);
        final View findViewById = findViewById(R.id.dmm);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED);
                String stringBuilder = com.tencent.mm.plugin.appbrand.collector.c.yJ("jsapi_draw_canvas").toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder != null && stringBuilder.length() > 0) {
                    stringBuilder2.append("data size :").append(com.tencent.mm.plugin.appbrand.collector.c.bF("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append(IOUtils.LINE_SEPARATOR_UNIX).append(stringBuilder);
                }
                IPCString iPCString = (IPCString) f.a("com.tencent.mm:support", new IPCString("widget_launch"), e.class);
                if (iPCString != null) {
                    stringBuilder2.append("\n\n").append(iPCString);
                }
                if (com.tencent.mm.plugin.appbrand.collector.f.ayu()) {
                    stringBuilder2.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.ayv());
                }
                textView.setText(stringBuilder2.toString());
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED);
            }
        });
        findViewById(R.id.kz).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED);
                f.a("com.tencent.mm:support", null, a.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.clear();
                com.tencent.mm.plugin.appbrand.collector.f.reset();
                textView.setText(com.tencent.mm.plugin.appbrand.collector.c.yJ("jsapi_draw_canvas").toString());
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.dmi);
        boolean ayt = com.tencent.mm.plugin.appbrand.collector.c.ayt();
        mMSwitchBtn.setCheck(ayt);
        mMSwitchBtn.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS);
                f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.dG(z);
                findViewById.setEnabled(z);
                WxaWidgetPerformanceUI.this.hpg.setEnabled(z);
                WxaWidgetPerformanceUI.this.hph.setEnabled(z);
                WxaWidgetPerformanceUI.this.hpi.setEnabled(z);
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS);
            }
        });
        findViewById.setEnabled(ayt);
        this.hpg = (MMSwitchBtn) findViewById(R.id.dmj);
        this.hpg.setEnabled(ayt);
        this.hpg.setCheck(com.tencent.mm.plugin.appbrand.collector.c.yM("jsapi_draw_canvas"));
        this.hpg.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(11020);
                f.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.yK("jsapi_draw_canvas");
                    AppMethodBeat.o(11020);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.yL("jsapi_draw_canvas");
                AppMethodBeat.o(11020);
            }
        });
        this.hph = (MMSwitchBtn) findViewById(R.id.dmk);
        this.hph.setEnabled(ayt);
        this.hph.setCheck(com.tencent.mm.plugin.appbrand.collector.c.yM("widget_launch"));
        this.hph.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN);
                f.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.yK("widget_launch");
                    AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.yL("widget_launch");
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN);
            }
        });
        this.hpi = (MMSwitchBtn) findViewById(R.id.dml);
        this.hpi.setEnabled(ayt);
        this.hpi.setCheck(com.tencent.mm.plugin.appbrand.collector.f.ayu());
        this.hpi.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT);
                com.tencent.mm.plugin.appbrand.collector.f.dH(z);
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT);
            }
        });
        AppMethodBeat.o(11028);
    }

    public void finish() {
        AppMethodBeat.i(11029);
        if (isFinishing() || this.uiu) {
            AppMethodBeat.o(11029);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
        TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        overridePendingTransition(resourceId, resourceId2);
        AppMethodBeat.o(11029);
    }

    public final int getLayoutId() {
        return R.layout.b8c;
    }
}
