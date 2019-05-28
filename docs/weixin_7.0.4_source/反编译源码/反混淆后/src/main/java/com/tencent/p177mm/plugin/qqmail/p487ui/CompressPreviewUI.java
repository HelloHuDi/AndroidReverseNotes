package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p487ui.C12925c.C12927a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.FileExplorerUI;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI */
public class CompressPreviewUI extends MMActivity {
    private ProgressBar juA;
    private TextView mKx;
    private String ptI = null;
    private String pux = null;
    private String pvZ;
    private C12925c pwy = new C12925c(this);
    private long pxn = 0;
    private List<C12912a> pxo = new ArrayList();
    private String pxp;
    private ListView pxq;
    private C12914b pxr;
    private C21523a pxs = new C129105();

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$4 */
    class C129084 implements OnMenuItemClickListener {
        C129084() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68241);
            Intent intent = new Intent(CompressPreviewUI.this, AttachDownloadPage.class);
            intent.putExtra("attach_name", CompressPreviewUI.this.pvZ);
            intent.putExtra("mail_id", CompressPreviewUI.this.ptI);
            intent.putExtra("attach_id", CompressPreviewUI.this.pux);
            intent.putExtra("total_size", CompressPreviewUI.this.pxn);
            intent.putExtra("is_preview", 0);
            intent.putExtra("is_compress", true);
            CompressPreviewUI.this.startActivity(intent);
            AppMethodBeat.m2505o(68241);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$3 */
    class C129093 implements OnClickListener {
        C129093() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68240);
            C4978c.m7375a(CompressPreviewUI.this.pxq);
            AppMethodBeat.m2505o(68240);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$5 */
    class C129105 extends C21523a {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$5$1 */
        class C129111 extends C12927a {
            C129111() {
            }

            public final void ccF() {
                AppMethodBeat.m2504i(68242);
                CompressPreviewUI.m20903i(CompressPreviewUI.this);
                AppMethodBeat.m2505o(68242);
            }

            public final void ccG() {
            }
        }

        C129105() {
        }

        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(68243);
            CompressPreviewUI.this.pxp = (String) map.get(".Response.result.compressfilepath");
            int i = C5046bo.getInt((String) map.get(".Response.result.filelist.count"), 0);
            int i2 = 0;
            while (i2 < i) {
                try {
                    String str2 = ".Response.result.filelist.list.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    String str3 = (String) map.get(str2 + ".path");
                    if (str3 != null) {
                        String str4;
                        String decode = URLDecoder.decode(str3, ProtocolPackage.ServerEncoding);
                        String str5 = (String) map.get(str2 + ".parentpath");
                        int i3 = C5046bo.getInt((String) map.get(str2 + ".size"), 0);
                        int i4 = C5046bo.getInt((String) map.get(str2 + ".type"), 0);
                        boolean equals = ((String) map.get(str2 + ".preview")).equals("1");
                        String str6 = (String) map.get(str2 + ".name");
                        List h = CompressPreviewUI.this.pxo;
                        CompressPreviewUI compressPreviewUI = CompressPreviewUI.this;
                        if (i3 == 0) {
                            str4 = "";
                        } else {
                            str4 = "(" + C5046bo.m7565ga((long) i3) + ")";
                        }
                        h.add(new C12912a(decode, str6, str5, i4, str4, equals));
                    }
                    i2++;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.CompressPreviewUI", e, "", new Object[0]);
                }
            }
            CompressPreviewUI.m20894a(CompressPreviewUI.this, "");
            AppMethodBeat.m2505o(68243);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(68244);
            if (i == -5) {
                CompressPreviewUI.this.pwy.mo24951a(new C129111());
                AppMethodBeat.m2505o(68244);
                return;
            }
            CompressPreviewUI.this.juA.setVisibility(8);
            CompressPreviewUI.this.mKx.setVisibility(0);
            CompressPreviewUI.this.pxq.setVisibility(8);
            AppMethodBeat.m2505o(68244);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$a */
    class C12912a {
        boolean aIt;
        /* renamed from: id */
        String f2917id;
        String name;
        String pxv;
        String size;
        int type;

        public C12912a(String str, String str2, String str3, int i, String str4, boolean z) {
            AppMethodBeat.m2504i(68245);
            this.f2917id = str;
            this.name = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.pxv = str3;
            this.type = i;
            this.size = str4;
            this.aIt = z;
            AppMethodBeat.m2505o(68245);
        }

        public final boolean ccX() {
            return this.type == 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$2 */
    class C129132 implements OnMenuItemClickListener {
        C129132() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68239);
            CompressPreviewUI.this.onKeyDown(4, null);
            AppMethodBeat.m2505o(68239);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$b */
    class C12914b extends BaseAdapter {
        C12912a pxw;
        private List<C12912a> pxx;

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$b$a */
        class C12915a {
            TextView gxi;
            ImageView iqT;
            TextView pxy;
            ImageView pxz;

            private C12915a() {
            }

            /* synthetic */ C12915a(C12914b c12914b, byte b) {
                this();
            }
        }

        private C12914b() {
            this.pxx = null;
        }

        /* synthetic */ C12914b(CompressPreviewUI compressPreviewUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(68250);
            C12912a Bs = mo24933Bs(i);
            AppMethodBeat.m2505o(68250);
            return Bs;
        }

        /* renamed from: a */
        public final void mo24934a(C12912a c12912a, List<C12912a> list) {
            this.pxw = c12912a;
            this.pxx = list;
        }

        public final String ccY() {
            AppMethodBeat.m2504i(68246);
            String str;
            if (this.pxw == null || this.pxw.pxv == null) {
                AppMethodBeat.m2505o(68246);
                return null;
            } else if (this.pxw.pxv.length() == 0) {
                str = "";
                AppMethodBeat.m2505o(68246);
                return str;
            } else {
                int indexOf = this.pxw.f2917id.indexOf(this.pxw.pxv);
                if (indexOf >= 0) {
                    str = this.pxw.f2917id.substring(0, indexOf) + this.pxw.pxv;
                    AppMethodBeat.m2505o(68246);
                    return str;
                }
                AppMethodBeat.m2505o(68246);
                return null;
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(68247);
            if (this.pxx != null) {
                int size = this.pxx.size();
                AppMethodBeat.m2505o(68247);
                return size;
            }
            AppMethodBeat.m2505o(68247);
            return 0;
        }

        /* renamed from: Bs */
        public final C12912a mo24933Bs(int i) {
            AppMethodBeat.m2504i(68248);
            if (this.pxx == null || this.pxx.size() <= i) {
                AppMethodBeat.m2505o(68248);
                return null;
            }
            C12912a c12912a = (C12912a) this.pxx.get(i);
            AppMethodBeat.m2505o(68248);
            return c12912a;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            int i2;
            AppMethodBeat.m2504i(68249);
            if (view == null) {
                view = View.inflate(CompressPreviewUI.this.mController.ylL, 2130970013, null);
                C12915a c12915a = new C12915a(this, (byte) 0);
                c12915a.iqT = (ImageView) view.findViewById(2131825695);
                c12915a.gxi = (TextView) view.findViewById(2131823901);
                c12915a.pxy = (TextView) view.findViewById(2131825696);
                c12915a.pxz = (ImageView) view.findViewById(2131825697);
                view.setTag(c12915a);
            }
            C12915a c12915a2 = (C12915a) view.getTag();
            C12912a Bs = mo24933Bs(i);
            if (i != 0 || ccY() == null) {
                imageView = c12915a2.iqT;
                if (Bs.ccX()) {
                    i2 = C25738R.drawable.alq;
                } else {
                    i2 = FileExplorerUI.ajW(Bs.name);
                }
            } else {
                imageView = c12915a2.iqT;
                i2 = C25738R.drawable.alp;
            }
            imageView.setImageResource(i2);
            c12915a2.pxz.setVisibility(Bs.aIt ? 0 : 4);
            c12915a2.gxi.setText(Bs.name);
            c12915a2.pxy.setText(Bs.size);
            AppMethodBeat.m2505o(68249);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI$1 */
    class C129161 implements OnItemClickListener {
        C129161() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object obj;
            AppMethodBeat.m2504i(68238);
            C12912a Bs = CompressPreviewUI.this.pxr.mo24933Bs(i);
            String str = Bs.f2917id;
            C12914b a = CompressPreviewUI.this.pxr;
            if (a.pxw == null) {
                obj = null;
            } else {
                obj = a.pxw.f2917id;
            }
            if (str.equals(obj)) {
                CompressPreviewUI.m20894a(CompressPreviewUI.this, CompressPreviewUI.this.pxr.ccY());
                AppMethodBeat.m2505o(68238);
            } else if (Bs.ccX()) {
                CompressPreviewUI.m20894a(CompressPreviewUI.this, Bs.f2917id);
                AppMethodBeat.m2505o(68238);
            } else {
                if (Bs.aIt) {
                    String[] strArr = new String[]{"mailid=" + CompressPreviewUI.this.ptI, "attachid=" + Bs.f2917id, "compressfilepath=" + CompressPreviewUI.this.pxp, "texttype=html"};
                    Intent intent = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
                    intent.putExtra(ShareConstants.MEDIA_URI, "/cgi-bin/viewdocument");
                    intent.putExtra("params", strArr);
                    intent.putExtra("baseurl", C39540v.ccw());
                    intent.putExtra(C8741b.METHOD, "get");
                    intent.putExtra("singleColumn", FileExplorerUI.ajX(Bs.name));
                    intent.putExtra("title", CompressPreviewUI.this.getString(C25738R.string.di7));
                    CompressPreviewUI.this.startActivity(intent);
                }
                AppMethodBeat.m2505o(68238);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CompressPreviewUI() {
        AppMethodBeat.m2504i(68251);
        AppMethodBeat.m2505o(68251);
    }

    /* renamed from: a */
    static /* synthetic */ void m20894a(CompressPreviewUI compressPreviewUI, String str) {
        AppMethodBeat.m2504i(68259);
        compressPreviewUI.m20891Vp(str);
        AppMethodBeat.m2505o(68259);
    }

    /* renamed from: i */
    static /* synthetic */ void m20903i(CompressPreviewUI compressPreviewUI) {
        AppMethodBeat.m2504i(68260);
        compressPreviewUI.ccW();
        AppMethodBeat.m2505o(68260);
    }

    public final int getLayoutId() {
        return 2130970014;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68252);
        super.onCreate(bundle);
        this.ptI = getIntent().getStringExtra("mail_id");
        this.pux = getIntent().getStringExtra("attach_id");
        this.pxn = getIntent().getLongExtra("attach_size", 0);
        this.pvZ = getIntent().getStringExtra("attach_name");
        initView();
        setMMTitle(this.pvZ);
        AppMethodBeat.m2505o(68252);
    }

    public final void initView() {
        AppMethodBeat.m2504i(68253);
        this.pxq = (ListView) findViewById(2131825698);
        this.mKx = (TextView) findViewById(2131825699);
        this.juA = (ProgressBar) findViewById(2131825700);
        if (this.ptI == null || this.pux == null) {
            this.juA.setVisibility(8);
            this.mKx.setText(C25738R.string.cv5);
            AppMethodBeat.m2505o(68253);
            return;
        }
        this.pxr = new C12914b(this, (byte) 0);
        this.pxq.setAdapter(this.pxr);
        this.pxq.setOnItemClickListener(new C129161());
        setBackBtn(new C129132());
        C129093 c129093 = new C129093();
        addTextOptionMenu(0, getString(C25738R.string.f9093p_), new C129084());
        ccW();
        AppMethodBeat.m2505o(68253);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(68254);
        super.onDestroy();
        this.pwy.release();
        AppMethodBeat.m2505o(68254);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(68255);
        if (i == 4 && this.pxr.ccY() != null) {
            m20891Vp(this.pxr.ccY());
            AppMethodBeat.m2505o(68255);
            return true;
        } else if (keyEvent == null) {
            finish();
            AppMethodBeat.m2505o(68255);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(68255);
            return onKeyDown;
        }
    }

    /* renamed from: Vp */
    private void m20891Vp(String str) {
        AppMethodBeat.m2504i(68256);
        C4990ab.m7416i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(str)));
        this.juA.setVisibility(8);
        this.mKx.setVisibility(8);
        this.pxq.setVisibility(0);
        C12912a Vq = m20892Vq(str);
        ArrayList arrayList = new ArrayList();
        if (Vq != null) {
            arrayList.add(Vq);
        }
        for (int i = 0; i < this.pxo.size(); i++) {
            C12912a c12912a = (C12912a) this.pxo.get(i);
            if ((str.endsWith(c12912a.pxv) && c12912a.pxv.length() > 0) || c12912a.pxv.equals(str)) {
                arrayList.add(c12912a);
            }
        }
        this.pxr.mo24934a(Vq, arrayList);
        this.pxr.notifyDataSetChanged();
        this.pxq.setSelection(0);
        AppMethodBeat.m2505o(68256);
    }

    /* renamed from: Vq */
    private C12912a m20892Vq(String str) {
        AppMethodBeat.m2504i(68257);
        for (C12912a c12912a : this.pxo) {
            if (c12912a.f2917id.equals(str)) {
                AppMethodBeat.m2505o(68257);
                return c12912a;
            }
        }
        AppMethodBeat.m2505o(68257);
        return null;
    }

    private void ccW() {
        AppMethodBeat.m2504i(68258);
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.ptI);
        hashMap.put("attachid", this.pux);
        hashMap.put("fun", "list");
        C12884ac.ccC().mo62491a("/cgi-bin/viewcompress", hashMap, this.pxs);
        AppMethodBeat.m2505o(68258);
    }
}
