package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C12886ai;
import com.tencent.p177mm.plugin.qqmail.p486b.C28745u;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C28746c;
import com.tencent.p177mm.plugin.qqmail.p487ui.C12925c.C12927a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.FileExplorerUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.b */
public final class C7027b implements C1202f {
    int mode;
    private TextView pwq;
    private ImageView pwr;
    ComposeUI pxP;
    ViewGroup pxQ;
    Map<String, C12886ai> pxR;
    Map<String, C28745u> pxS;
    Map<String, String> pxT;
    Map<String, String> pxU;
    C7034b pxV;
    private OnClickListener pxW;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.b$a */
    class C7028a {
        TextView gxi;
        ImageView iqT;
        TextView pxy;
        ProgressBar pyf;
        TextView pyg;
        ImageView pyh;
        ImageView pyi;

        private C7028a() {
        }

        /* synthetic */ C7028a(C7027b c7027b, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.b$b */
    public interface C7034b {
        void ccU();

        void onComplete();
    }

    private C7027b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(68295);
        this.pxR = new HashMap();
        this.pxS = new HashMap();
        this.pxT = new LinkedHashMap();
        this.pxU = new LinkedHashMap();
        this.pxV = null;
        this.pxW = null;
        this.mode = 5;
        this.pxP = composeUI;
        this.pxQ = viewGroup;
        this.pxW = null;
        this.pwq = textView;
        this.pwr = imageView;
        cdd();
        C1720g.m3535RO().eJo.mo14539a(484, (C1202f) this);
        AppMethodBeat.m2505o(68295);
    }

    public C7027b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    /* renamed from: cI */
    public final void mo15398cI(List<C12886ai> list) {
        AppMethodBeat.m2504i(68296);
        if (list == null) {
            AppMethodBeat.m2505o(68296);
            return;
        }
        for (C12886ai c12886ai : list) {
            m11737a(c12886ai);
            this.pxR.put(c12886ai.path, c12886ai);
        }
        if (this.mode == 6) {
            for (C12886ai c12886ai2 : list) {
                this.pxT.put(c12886ai2.path, c12886ai2.pvH);
                this.pxU.put(c12886ai2.path, c12886ai2.name);
            }
        }
        AppMethodBeat.m2505o(68296);
    }

    /* renamed from: fG */
    public final void mo15405fG(String str, String str2) {
        AppMethodBeat.m2504i(68297);
        if (str == null || str.length() == 0 || this.pxR.containsKey(str)) {
            AppMethodBeat.m2505o(68297);
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            C12886ai c12886ai = new C12886ai();
            c12886ai.path = str;
            if (str2 == null) {
                c12886ai.name = file.getName();
            } else {
                c12886ai.name = str2;
            }
            c12886ai.size = file.length();
            c12886ai.state = 0;
            this.pxR.put(str, c12886ai);
            m11737a(c12886ai);
            AppMethodBeat.m2505o(68297);
            return;
        }
        AppMethodBeat.m2505o(68297);
    }

    /* renamed from: wi */
    public final boolean mo15407wi(String str) {
        AppMethodBeat.m2504i(68298);
        boolean containsKey = this.pxR.containsKey(str);
        AppMethodBeat.m2505o(68298);
        return containsKey;
    }

    /* renamed from: a */
    private void m11737a(final C12886ai c12886ai) {
        AppMethodBeat.m2504i(68299);
        final LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.pxP, 2130970425, null)).findViewById(2131826696);
        ImageView imageView = (ImageView) linearLayout.findViewById(2131826697);
        TextView textView = (TextView) linearLayout.findViewById(2131826698);
        TextView textView2 = (TextView) linearLayout.findViewById(2131826699);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(2131826700);
        TextView textView3 = (TextView) linearLayout.findViewById(2131826701);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(2131826702);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(2131826703);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.ajW(c12886ai.name));
        textView.setText(c12886ai.name);
        textView2.setText(C5046bo.m7565ga(c12886ai.size));
        C7028a c7028a = new C7028a(this, (byte) 0);
        c7028a.iqT = imageView;
        c7028a.gxi = textView;
        c7028a.pxy = textView2;
        c7028a.pyf = progressBar;
        c7028a.pyg = textView3;
        c7028a.pyh = imageView2;
        c7028a.pyi = imageView3;
        linearLayout.setTag(c7028a);
        linearLayout.setId(Math.abs(c12886ai.path.hashCode() / 2));
        if (this.pxW != null) {
            linearLayout.setOnClickListener(this.pxW);
        }
        this.pxQ.addView(linearLayout);
        cdd();
        linearLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(68282);
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
                AppMethodBeat.m2505o(68282);
            }
        });
        imageView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(68283);
                if (C7027b.this.mode == 5) {
                    c12886ai.pvG = C7027b.this.mo15396Vr(c12886ai.path);
                    AppMethodBeat.m2505o(68283);
                    return;
                }
                if (C7027b.this.mode == 6) {
                    c12886ai.pvG = C7027b.this.mo15406fH(c12886ai.path, c12886ai.name);
                }
                AppMethodBeat.m2505o(68283);
            }
        });
        imageView3.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.qqmail.ui.b$3$1 */
            class C70301 implements DialogInterface.OnClickListener {
                C70301() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(68284);
                    if (c12886ai.state == 0 || c12886ai.state == 1) {
                        C7027b c7027b = C7027b.this;
                        C12886ai c12886ai = c12886ai;
                        if (c7027b.mode == 5) {
                            C12884ac.ccC().cancel(c12886ai.pvG);
                        } else if (c7027b.mode == 6) {
                            C1207m c1207m = (C28745u) c7027b.pxS.get(c12886ai.path);
                            if (c1207m != null) {
                                C1720g.m3535RO().eJo.mo14547c(c1207m);
                            }
                            c7027b.pxT.remove(c12886ai.path);
                            c7027b.pxU.remove(c12886ai.path);
                        }
                    }
                    C7027b.this.pxR.remove(c12886ai.path);
                    C7027b.this.pxS.remove(c12886ai.path);
                    C7027b.this.pxT.remove(c12886ai.path);
                    C7027b.this.pxU.remove(c12886ai.path);
                    C7027b.this.pxQ.removeView(linearLayout);
                    C7027b.this.cdd();
                    AppMethodBeat.m2505o(68284);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(68285);
                C30379h.m48432a(C7027b.this.pxP, (int) C25738R.string.dd0, (int) C25738R.string.f9238tz, new C70301(), null);
                AppMethodBeat.m2505o(68285);
            }
        });
        this.pxQ.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68286);
                C7027b.this.mo15397b(c12886ai);
                AppMethodBeat.m2505o(68286);
            }
        });
        if (c12886ai.state == 0) {
            if (this.mode == 5) {
                c12886ai.pvG = mo15396Vr(c12886ai.path);
                AppMethodBeat.m2505o(68299);
                return;
            } else if (this.mode == 6) {
                c12886ai.pvG = mo15406fH(c12886ai.path, c12886ai.name);
            }
        }
        AppMethodBeat.m2505o(68299);
    }

    public final String ccZ() {
        AppMethodBeat.m2504i(68300);
        String str = "";
        for (String str2 : this.pxR.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((C12886ai) this.pxR.get(str2)).pvH;
        }
        AppMethodBeat.m2505o(68300);
        return str;
    }

    public final LinkedList<C12886ai> cda() {
        AppMethodBeat.m2504i(68301);
        LinkedList linkedList = new LinkedList();
        for (String str : this.pxR.keySet()) {
            linkedList.add(this.pxR.get(str));
        }
        AppMethodBeat.m2505o(68301);
        return linkedList;
    }

    public final void cdb() {
        AppMethodBeat.m2504i(68302);
        C12886ai c12886ai;
        if (this.mode == 5) {
            for (String str : this.pxR.keySet()) {
                c12886ai = (C12886ai) this.pxR.get(str);
                if (c12886ai.state != 2) {
                    C12884ac.ccC().cancel(c12886ai.pvG);
                    c12886ai.state = 3;
                    mo15397b(c12886ai);
                }
            }
            AppMethodBeat.m2505o(68302);
            return;
        }
        if (this.mode == 6) {
            for (String str2 : this.pxR.keySet()) {
                c12886ai = (C12886ai) this.pxR.get(str2);
                if (c12886ai.state != 2) {
                    C1207m c1207m = (C28745u) this.pxS.get(c12886ai.path);
                    if (c1207m != null) {
                        C1720g.m3535RO().eJo.mo14547c(c1207m);
                        c12886ai.state = 3;
                        mo15397b(c12886ai);
                    }
                    this.pxT.remove(c12886ai.path);
                    this.pxU.remove(c12886ai.path);
                    this.pxS.remove(c12886ai.path);
                }
            }
        }
        AppMethodBeat.m2505o(68302);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Vr */
    public final long mo15396Vr(final String str) {
        AppMethodBeat.m2504i(68303);
        C28746c c28746c = new C28746c();
        c28746c.puP = false;
        c28746c.puO = true;
        long a = C12884ac.ccC().mo62490a("/cgi-bin/uploaddata", "UploadFile", str, c28746c, new C21523a() {

            /* renamed from: com.tencent.mm.plugin.qqmail.ui.b$5$1 */
            class C36681 extends C12927a {
                C36681() {
                }

                public final void ccF() {
                }

                public final void ccG() {
                }
            }

            public final boolean onReady() {
                AppMethodBeat.m2504i(68287);
                C12886ai c12886ai = (C12886ai) C7027b.this.pxR.get(str);
                if (c12886ai != null) {
                    c12886ai.state = 1;
                    C7027b.this.mo15397b(c12886ai);
                }
                AppMethodBeat.m2505o(68287);
                return true;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.m2504i(68288);
                String str2 = (String) map.get(".Response.result.DataID");
                C12886ai c12886ai = (C12886ai) C7027b.this.pxR.get(str);
                if (c12886ai != null) {
                    c12886ai.state = 2;
                    c12886ai.pvH = str2;
                    C7027b.this.mo15397b(c12886ai);
                }
                AppMethodBeat.m2505o(68288);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.m2504i(68289);
                C4990ab.m7413e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", Integer.valueOf(i), str);
                C12886ai c12886ai = (C12886ai) C7027b.this.pxR.get(str);
                if (c12886ai != null) {
                    c12886ai.state = 3;
                    C7027b.this.mo15397b(c12886ai);
                }
                if (i == -5) {
                    C7027b.this.pxP.pwy.mo24951a(new C36681());
                    AppMethodBeat.m2505o(68289);
                    return;
                }
                AppMethodBeat.m2505o(68289);
            }

            public final void onComplete() {
                AppMethodBeat.m2504i(68290);
                C7027b.m11738a(C7027b.this);
                AppMethodBeat.m2505o(68290);
            }
        });
        AppMethodBeat.m2505o(68303);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fH */
    public final long mo15406fH(final String str, final String str2) {
        AppMethodBeat.m2504i(68304);
        long hashCode;
        if (this.pxS.containsKey(str)) {
            hashCode = (long) ((C28745u) this.pxS.get(str)).hashCode();
            AppMethodBeat.m2505o(68304);
            return hashCode;
        }
        C1207m c28745u = new C28745u(str, str, new C32231g() {
            /* renamed from: a */
            public final void mo8280a(int i, int i2, C1207m c1207m) {
                AppMethodBeat.m2504i(68293);
                C4990ab.m7417i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                final C12886ai c12886ai;
                if (i < i2) {
                    C4990ab.m7417i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                    c12886ai = (C12886ai) C7027b.this.pxR.get(str);
                    if (c12886ai != null) {
                        c12886ai.state = 1;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(68291);
                                C7027b.this.mo15397b(c12886ai);
                                AppMethodBeat.m2505o(68291);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(68293);
                    return;
                }
                if (i >= i2) {
                    c12886ai = (C12886ai) C7027b.this.pxR.get(str);
                    String str = ((C28745u) c1207m).ccv().ptE;
                    C7027b.this.pxT.put(str, str);
                    C7027b.this.pxU.put(str, str2);
                    C7027b.this.pxS.remove(str);
                    C4990ab.m7417i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", str, str);
                    if (c12886ai != null) {
                        c12886ai.state = 2;
                        c12886ai.pvH = str;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(68292);
                                C7027b.this.mo15397b(c12886ai);
                                AppMethodBeat.m2505o(68292);
                            }
                        });
                    }
                    C7027b.m11738a(C7027b.this);
                }
                AppMethodBeat.m2505o(68293);
            }
        });
        C12886ai c12886ai = (C12886ai) this.pxR.get(str);
        if (c12886ai != null) {
            c12886ai.state = 1;
        }
        mo15397b(c12886ai);
        C1720g.m3535RO().eJo.mo14541a(c28745u, 0);
        this.pxS.put(str, c28745u);
        hashCode = (long) c28745u.hashCode();
        AppMethodBeat.m2505o(68304);
        return hashCode;
    }

    public final boolean cdc() {
        AppMethodBeat.m2504i(68305);
        for (String str : this.pxR.keySet()) {
            C12886ai c12886ai = (C12886ai) this.pxR.get(str);
            if (c12886ai.state != 2 && c12886ai.state != 3) {
                AppMethodBeat.m2505o(68305);
                return false;
            }
        }
        AppMethodBeat.m2505o(68305);
        return true;
    }

    public final void cdd() {
        AppMethodBeat.m2504i(68306);
        if (this.pxR.size() == 0) {
            this.pwq.setText(this.pxP.getString(C25738R.string.dd7) + " " + this.pxP.getString(C25738R.string.dd_));
            this.pwr.setImageResource(C1318a.qqmail_attach_icon_normal);
            ((View) this.pxQ.getParent()).setVisibility(8);
        } else {
            this.pwq.setText(this.pxP.getString(C25738R.string.dd7) + this.pxP.getResources().getQuantityString(C25738R.plurals.f9612y, this.pxR.size(), new Object[]{Integer.valueOf(this.pxR.size()), C5046bo.m7565ga((long) cde())}));
            this.pwr.setImageResource(C1318a.qqmail_attach_icon_pressed);
            ((View) this.pxQ.getParent()).setVisibility(0);
        }
        int childCount = this.pxQ.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.pxQ.getChildAt(i).setBackgroundResource(C25738R.drawable.f6856td);
            } else if (i == 0) {
                this.pxQ.getChildAt(i).setBackgroundResource(C25738R.drawable.f6857te);
            } else if (i <= 0 || i >= childCount - 1) {
                this.pxQ.getChildAt(i).setBackgroundResource(C25738R.drawable.f6859tg);
            } else {
                this.pxQ.getChildAt(i).setBackgroundResource(C25738R.drawable.f6858tf);
            }
            i++;
        }
        AppMethodBeat.m2505o(68306);
    }

    public final int cde() {
        AppMethodBeat.m2504i(68307);
        int i = 0;
        Iterator it = this.pxR.keySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                long j = (long) i2;
                i = (int) (((C12886ai) this.pxR.get((String) it.next())).size + j);
            } else {
                AppMethodBeat.m2505o(68307);
                return i2;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo15397b(C12886ai c12886ai) {
        AppMethodBeat.m2504i(68308);
        LinearLayout linearLayout = (LinearLayout) this.pxQ.findViewById(Math.abs(c12886ai.path.hashCode() / 2));
        if (linearLayout == null) {
            AppMethodBeat.m2505o(68308);
            return;
        }
        C7028a c7028a = (C7028a) linearLayout.getTag();
        switch (c12886ai.state) {
            case 0:
            case 1:
                c7028a.gxi.setTextColor(WebView.NIGHT_MODE_COLOR);
                c7028a.pyf.setVisibility(0);
                c7028a.pyg.setVisibility(8);
                c7028a.pyh.setVisibility(8);
                c7028a.pyi.setVisibility(0);
                AppMethodBeat.m2505o(68308);
                return;
            case 2:
                c7028a.gxi.setTextColor(WebView.NIGHT_MODE_COLOR);
                c7028a.pyf.setVisibility(8);
                c7028a.pyg.setVisibility(8);
                c7028a.pyh.setVisibility(8);
                c7028a.pyi.setVisibility(0);
                AppMethodBeat.m2505o(68308);
                return;
            case 3:
                c7028a.gxi.setTextColor(C1338a.m2872i(this.pxP, C25738R.color.f12121t4));
                c7028a.pyf.setVisibility(8);
                c7028a.pyg.setVisibility(0);
                c7028a.pyh.setVisibility(0);
                c7028a.pyi.setVisibility(0);
                break;
        }
        AppMethodBeat.m2505o(68308);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(68309);
        if (c1207m.getType() == 484) {
            c1207m = (C28745u) c1207m;
            String str2 = c1207m.filePath;
            final C12886ai c12886ai = (C12886ai) this.pxR.get(str2);
            if (!(c12886ai == null || (i == 0 && i2 == 0))) {
                C4990ab.m7413e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", Integer.valueOf(i), Integer.valueOf(i2), str2);
                c12886ai.state = 3;
                this.pxS.remove(str2);
                C1720g.m3535RO().eJo.mo14547c(c1207m);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(68294);
                        C7027b.this.mo15397b(c12886ai);
                        AppMethodBeat.m2505o(68294);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(68309);
    }
}
