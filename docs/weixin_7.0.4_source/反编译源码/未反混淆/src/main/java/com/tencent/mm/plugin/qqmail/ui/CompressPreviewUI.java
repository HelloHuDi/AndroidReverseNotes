package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private ProgressBar juA;
    private TextView mKx;
    private String ptI = null;
    private String pux = null;
    private String pvZ;
    private c pwy = new c(this);
    private long pxn = 0;
    private List<a> pxo = new ArrayList();
    private String pxp;
    private ListView pxq;
    private b pxr;
    private com.tencent.mm.plugin.qqmail.b.v.a pxs = new com.tencent.mm.plugin.qqmail.b.v.a() {
        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.i(68243);
            CompressPreviewUI.this.pxp = (String) map.get(".Response.result.compressfilepath");
            int i = bo.getInt((String) map.get(".Response.result.filelist.count"), 0);
            int i2 = 0;
            while (i2 < i) {
                try {
                    String str2 = ".Response.result.filelist.list.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    String str3 = (String) map.get(str2 + ".path");
                    if (str3 != null) {
                        String str4;
                        String decode = URLDecoder.decode(str3, ProtocolPackage.ServerEncoding);
                        String str5 = (String) map.get(str2 + ".parentpath");
                        int i3 = bo.getInt((String) map.get(str2 + ".size"), 0);
                        int i4 = bo.getInt((String) map.get(str2 + ".type"), 0);
                        boolean equals = ((String) map.get(str2 + ".preview")).equals("1");
                        String str6 = (String) map.get(str2 + ".name");
                        List h = CompressPreviewUI.this.pxo;
                        CompressPreviewUI compressPreviewUI = CompressPreviewUI.this;
                        if (i3 == 0) {
                            str4 = "";
                        } else {
                            str4 = "(" + bo.ga((long) i3) + ")";
                        }
                        h.add(new a(decode, str6, str5, i4, str4, equals));
                    }
                    i2++;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.CompressPreviewUI", e, "", new Object[0]);
                }
            }
            CompressPreviewUI.a(CompressPreviewUI.this, "");
            AppMethodBeat.o(68243);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.i(68244);
            if (i == -5) {
                CompressPreviewUI.this.pwy.a(new com.tencent.mm.plugin.qqmail.ui.c.a() {
                    public final void ccF() {
                        AppMethodBeat.i(68242);
                        CompressPreviewUI.i(CompressPreviewUI.this);
                        AppMethodBeat.o(68242);
                    }

                    public final void ccG() {
                    }
                });
                AppMethodBeat.o(68244);
                return;
            }
            CompressPreviewUI.this.juA.setVisibility(8);
            CompressPreviewUI.this.mKx.setVisibility(0);
            CompressPreviewUI.this.pxq.setVisibility(8);
            AppMethodBeat.o(68244);
        }
    };

    class a {
        boolean aIt;
        String id;
        String name;
        String pxv;
        String size;
        int type;

        public a(String str, String str2, String str3, int i, String str4, boolean z) {
            AppMethodBeat.i(68245);
            this.id = str;
            this.name = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.pxv = str3;
            this.type = i;
            this.size = str4;
            this.aIt = z;
            AppMethodBeat.o(68245);
        }

        public final boolean ccX() {
            return this.type == 1;
        }
    }

    class b extends BaseAdapter {
        a pxw;
        private List<a> pxx;

        class a {
            TextView gxi;
            ImageView iqT;
            TextView pxy;
            ImageView pxz;

            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }
        }

        private b() {
            this.pxx = null;
        }

        /* synthetic */ b(CompressPreviewUI compressPreviewUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(68250);
            a Bs = Bs(i);
            AppMethodBeat.o(68250);
            return Bs;
        }

        public final void a(a aVar, List<a> list) {
            this.pxw = aVar;
            this.pxx = list;
        }

        public final String ccY() {
            AppMethodBeat.i(68246);
            String str;
            if (this.pxw == null || this.pxw.pxv == null) {
                AppMethodBeat.o(68246);
                return null;
            } else if (this.pxw.pxv.length() == 0) {
                str = "";
                AppMethodBeat.o(68246);
                return str;
            } else {
                int indexOf = this.pxw.id.indexOf(this.pxw.pxv);
                if (indexOf >= 0) {
                    str = this.pxw.id.substring(0, indexOf) + this.pxw.pxv;
                    AppMethodBeat.o(68246);
                    return str;
                }
                AppMethodBeat.o(68246);
                return null;
            }
        }

        public final int getCount() {
            AppMethodBeat.i(68247);
            if (this.pxx != null) {
                int size = this.pxx.size();
                AppMethodBeat.o(68247);
                return size;
            }
            AppMethodBeat.o(68247);
            return 0;
        }

        public final a Bs(int i) {
            AppMethodBeat.i(68248);
            if (this.pxx == null || this.pxx.size() <= i) {
                AppMethodBeat.o(68248);
                return null;
            }
            a aVar = (a) this.pxx.get(i);
            AppMethodBeat.o(68248);
            return aVar;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            int i2;
            AppMethodBeat.i(68249);
            if (view == null) {
                view = View.inflate(CompressPreviewUI.this.mController.ylL, R.layout.ab1, null);
                a aVar = new a(this, (byte) 0);
                aVar.iqT = (ImageView) view.findViewById(R.id.d19);
                aVar.gxi = (TextView) view.findViewById(R.id.bpq);
                aVar.pxy = (TextView) view.findViewById(R.id.d1_);
                aVar.pxz = (ImageView) view.findViewById(R.id.d1a);
                view.setTag(aVar);
            }
            a aVar2 = (a) view.getTag();
            a Bs = Bs(i);
            if (i != 0 || ccY() == null) {
                imageView = aVar2.iqT;
                if (Bs.ccX()) {
                    i2 = R.drawable.alq;
                } else {
                    i2 = FileExplorerUI.ajW(Bs.name);
                }
            } else {
                imageView = aVar2.iqT;
                i2 = R.drawable.alp;
            }
            imageView.setImageResource(i2);
            aVar2.pxz.setVisibility(Bs.aIt ? 0 : 4);
            aVar2.gxi.setText(Bs.name);
            aVar2.pxy.setText(Bs.size);
            AppMethodBeat.o(68249);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CompressPreviewUI() {
        AppMethodBeat.i(68251);
        AppMethodBeat.o(68251);
    }

    static /* synthetic */ void a(CompressPreviewUI compressPreviewUI, String str) {
        AppMethodBeat.i(68259);
        compressPreviewUI.Vp(str);
        AppMethodBeat.o(68259);
    }

    static /* synthetic */ void i(CompressPreviewUI compressPreviewUI) {
        AppMethodBeat.i(68260);
        compressPreviewUI.ccW();
        AppMethodBeat.o(68260);
    }

    public final int getLayoutId() {
        return R.layout.ab2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68252);
        super.onCreate(bundle);
        this.ptI = getIntent().getStringExtra("mail_id");
        this.pux = getIntent().getStringExtra("attach_id");
        this.pxn = getIntent().getLongExtra("attach_size", 0);
        this.pvZ = getIntent().getStringExtra("attach_name");
        initView();
        setMMTitle(this.pvZ);
        AppMethodBeat.o(68252);
    }

    public final void initView() {
        AppMethodBeat.i(68253);
        this.pxq = (ListView) findViewById(R.id.d1b);
        this.mKx = (TextView) findViewById(R.id.d1c);
        this.juA = (ProgressBar) findViewById(R.id.d1d);
        if (this.ptI == null || this.pux == null) {
            this.juA.setVisibility(8);
            this.mKx.setText(R.string.cv5);
            AppMethodBeat.o(68253);
            return;
        }
        this.pxr = new b(this, (byte) 0);
        this.pxq.setAdapter(this.pxr);
        this.pxq.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object obj;
                AppMethodBeat.i(68238);
                a Bs = CompressPreviewUI.this.pxr.Bs(i);
                String str = Bs.id;
                b a = CompressPreviewUI.this.pxr;
                if (a.pxw == null) {
                    obj = null;
                } else {
                    obj = a.pxw.id;
                }
                if (str.equals(obj)) {
                    CompressPreviewUI.a(CompressPreviewUI.this, CompressPreviewUI.this.pxr.ccY());
                    AppMethodBeat.o(68238);
                } else if (Bs.ccX()) {
                    CompressPreviewUI.a(CompressPreviewUI.this, Bs.id);
                    AppMethodBeat.o(68238);
                } else {
                    if (Bs.aIt) {
                        String[] strArr = new String[]{"mailid=" + CompressPreviewUI.this.ptI, "attachid=" + Bs.id, "compressfilepath=" + CompressPreviewUI.this.pxp, "texttype=html"};
                        Intent intent = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
                        intent.putExtra(ShareConstants.MEDIA_URI, "/cgi-bin/viewdocument");
                        intent.putExtra("params", strArr);
                        intent.putExtra("baseurl", v.ccw());
                        intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.METHOD, "get");
                        intent.putExtra("singleColumn", FileExplorerUI.ajX(Bs.name));
                        intent.putExtra("title", CompressPreviewUI.this.getString(R.string.di7));
                        CompressPreviewUI.this.startActivity(intent);
                    }
                    AppMethodBeat.o(68238);
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68239);
                CompressPreviewUI.this.onKeyDown(4, null);
                AppMethodBeat.o(68239);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68240);
                c.a(CompressPreviewUI.this.pxq);
                AppMethodBeat.o(68240);
            }
        };
        addTextOptionMenu(0, getString(R.string.p_), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68241);
                Intent intent = new Intent(CompressPreviewUI.this, AttachDownloadPage.class);
                intent.putExtra("attach_name", CompressPreviewUI.this.pvZ);
                intent.putExtra("mail_id", CompressPreviewUI.this.ptI);
                intent.putExtra("attach_id", CompressPreviewUI.this.pux);
                intent.putExtra("total_size", CompressPreviewUI.this.pxn);
                intent.putExtra("is_preview", 0);
                intent.putExtra("is_compress", true);
                CompressPreviewUI.this.startActivity(intent);
                AppMethodBeat.o(68241);
                return true;
            }
        });
        ccW();
        AppMethodBeat.o(68253);
    }

    public void onDestroy() {
        AppMethodBeat.i(68254);
        super.onDestroy();
        this.pwy.release();
        AppMethodBeat.o(68254);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(68255);
        if (i == 4 && this.pxr.ccY() != null) {
            Vp(this.pxr.ccY());
            AppMethodBeat.o(68255);
            return true;
        } else if (keyEvent == null) {
            finish();
            AppMethodBeat.o(68255);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(68255);
            return onKeyDown;
        }
    }

    private void Vp(String str) {
        AppMethodBeat.i(68256);
        ab.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(str)));
        this.juA.setVisibility(8);
        this.mKx.setVisibility(8);
        this.pxq.setVisibility(0);
        a Vq = Vq(str);
        ArrayList arrayList = new ArrayList();
        if (Vq != null) {
            arrayList.add(Vq);
        }
        for (int i = 0; i < this.pxo.size(); i++) {
            a aVar = (a) this.pxo.get(i);
            if ((str.endsWith(aVar.pxv) && aVar.pxv.length() > 0) || aVar.pxv.equals(str)) {
                arrayList.add(aVar);
            }
        }
        this.pxr.a(Vq, arrayList);
        this.pxr.notifyDataSetChanged();
        this.pxq.setSelection(0);
        AppMethodBeat.o(68256);
    }

    private a Vq(String str) {
        AppMethodBeat.i(68257);
        for (a aVar : this.pxo) {
            if (aVar.id.equals(str)) {
                AppMethodBeat.o(68257);
                return aVar;
            }
        }
        AppMethodBeat.o(68257);
        return null;
    }

    private void ccW() {
        AppMethodBeat.i(68258);
        HashMap hashMap = new HashMap();
        hashMap.put("mailid", this.ptI);
        hashMap.put("attachid", this.pux);
        hashMap.put("fun", "list");
        ac.ccC().a("/cgi-bin/viewcompress", hashMap, this.pxs);
        AppMethodBeat.o(68258);
    }
}
