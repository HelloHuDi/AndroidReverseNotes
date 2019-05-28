package com.tencent.p177mm.plugin.appbrand.dynamic.p770ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.collector.C33128f;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI */
public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn hpg;
    MMSwitchBtn hph;
    MMSwitchBtn hpi;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$1 */
    class C102201 implements OnMenuItemClickListener {
        C102201() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT);
            WxaWidgetPerformanceUI.this.finish();
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$d */
    static class C19205d implements C37866a<IPCBoolean, IPCVoid> {
        private C19205d() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11026);
            C2107c.m4316dG(((IPCBoolean) obj).value);
            AppMethodBeat.m2505o(11026);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$e */
    static class C19206e implements C45413i<IPCString, IPCString> {
        private C19206e() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(11027);
            IPCString iPCString = new IPCString(C2107c.m4320yJ(((IPCString) obj).value).toString());
            AppMethodBeat.m2505o(11027);
            return iPCString;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$6 */
    class C382086 implements C30795a {
        C382086() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN);
            C9549f.m17012a("com.tencent.mm:support", new IPCBoolean(z), C42430c.class, null);
            if (z) {
                C2107c.m4321yK("widget_launch");
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN);
                return;
            }
            C2107c.m4322yL("widget_launch");
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$a */
    static class C41229a implements C37866a<IPCVoid, IPCVoid> {
        private C41229a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST);
            C2107c.clear();
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$b */
    static class C42429b implements C37866a<IPCBoolean, IPCVoid> {
        private C42429b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER);
            if (((IPCBoolean) obj).value) {
                C2107c.m4321yK("jsapi_draw_canvas");
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER);
                return;
            }
            C2107c.m4322yL("jsapi_draw_canvas");
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$c */
    static class C42430c implements C37866a<IPCBoolean, IPCVoid> {
        private C42430c() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(11025);
            if (((IPCBoolean) obj).value) {
                C2107c.m4321yK("widget_launch");
                AppMethodBeat.m2505o(11025);
                return;
            }
            C2107c.m4322yL("widget_launch");
            AppMethodBeat.m2505o(11025);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$5 */
    class C424315 implements C30795a {
        C424315() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(11020);
            C9549f.m17012a("com.tencent.mm:support", new IPCBoolean(z), C42429b.class, null);
            if (z) {
                C2107c.m4321yK("jsapi_draw_canvas");
                AppMethodBeat.m2505o(11020);
                return;
            }
            C2107c.m4322yL("jsapi_draw_canvas");
            AppMethodBeat.m2505o(11020);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI$7 */
    class C424327 implements C30795a {
        C424327() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT);
            C33128f.m54149dH(z);
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(11028);
        super.onCreate(bundle);
        setBackBtn(new C102201());
        setMMTitle((int) C25738R.string.g3k);
        final TextView textView = (TextView) findViewById(2131826524);
        final View findViewById = findViewById(2131826523);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED);
                String stringBuilder = C2107c.m4320yJ("jsapi_draw_canvas").toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder != null && stringBuilder.length() > 0) {
                    stringBuilder2.append("data size :").append(C2107c.m4314bF("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append(IOUtils.LINE_SEPARATOR_UNIX).append(stringBuilder);
                }
                IPCString iPCString = (IPCString) C9549f.m17010a("com.tencent.mm:support", new IPCString("widget_launch"), C19206e.class);
                if (iPCString != null) {
                    stringBuilder2.append("\n\n").append(iPCString);
                }
                if (C33128f.ayu()) {
                    stringBuilder2.append("\n\n").append(C33128f.ayv());
                }
                textView.setText(stringBuilder2.toString());
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED);
            }
        });
        findViewById(2131820976).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED);
                C9549f.m17012a("com.tencent.mm:support", null, C41229a.class, null);
                C2107c.clear();
                C33128f.reset();
                textView.setText(C2107c.m4320yJ("jsapi_draw_canvas").toString());
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(2131826519);
        boolean ayt = C2107c.ayt();
        mMSwitchBtn.setCheck(ayt);
        mMSwitchBtn.setSwitchListener(new C30795a() {
            /* renamed from: di */
            public final void mo6646di(boolean z) {
                AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS);
                C9549f.m17012a("com.tencent.mm:support", new IPCBoolean(z), C19205d.class, null);
                C2107c.m4316dG(z);
                findViewById.setEnabled(z);
                WxaWidgetPerformanceUI.this.hpg.setEnabled(z);
                WxaWidgetPerformanceUI.this.hph.setEnabled(z);
                WxaWidgetPerformanceUI.this.hpi.setEnabled(z);
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS);
            }
        });
        findViewById.setEnabled(ayt);
        this.hpg = (MMSwitchBtn) findViewById(2131826520);
        this.hpg.setEnabled(ayt);
        this.hpg.setCheck(C2107c.m4323yM("jsapi_draw_canvas"));
        this.hpg.setSwitchListener(new C424315());
        this.hph = (MMSwitchBtn) findViewById(2131826521);
        this.hph.setEnabled(ayt);
        this.hph.setCheck(C2107c.m4323yM("widget_launch"));
        this.hph.setSwitchListener(new C382086());
        this.hpi = (MMSwitchBtn) findViewById(2131826522);
        this.hpi.setEnabled(ayt);
        this.hpi.setCheck(C33128f.ayu());
        this.hpi.setSwitchListener(new C424327());
        AppMethodBeat.m2505o(11028);
    }

    public void finish() {
        AppMethodBeat.m2504i(11029);
        if (isFinishing() || this.uiu) {
            AppMethodBeat.m2505o(11029);
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
        AppMethodBeat.m2505o(11029);
    }

    public final int getLayoutId() {
        return 2130971250;
    }
}
