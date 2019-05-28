package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI */
public class FileExplorerUI extends MMActivity {
    private int vtO = 0;
    private ListView vtP;
    private C23335a vtQ;
    private TextView vtR;
    private TextView vtS;
    private View vtT;
    private View vtU;
    private String vtV;
    private String vtW;
    private File vtX;
    private File vtY;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$2 */
    class C47632 implements OnItemClickListener {
        C47632() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(105841);
            File file = (File) FileExplorerUI.this.vtQ.getItem(i);
            if (1 == FileExplorerUI.this.vtO) {
                if (file.isFile()) {
                    C1720g.m3536RP().mo5239Ry().set(131074, FileExplorerUI.this.vtQ.vud.getAbsolutePath());
                    C1720g.m3536RP().mo5239Ry().set(131073, FileExplorerUI.this.vtX.getAbsolutePath());
                } else {
                    FileExplorerUI.this.vtY = file;
                }
            } else if (FileExplorerUI.this.vtO == 0) {
                if (file.isFile()) {
                    C1720g.m3536RP().mo5239Ry().set(131073, FileExplorerUI.this.vtQ.vud.getAbsolutePath());
                    C1720g.m3536RP().mo5239Ry().set(131074, FileExplorerUI.this.vtY.getAbsolutePath());
                } else {
                    FileExplorerUI.this.vtX = file;
                }
            }
            if (file == FileExplorerUI.this.vtQ.vuc) {
                FileExplorerUI.this.vtQ.mo39067g(FileExplorerUI.this.vtQ.vuc.getParentFile(), FileExplorerUI.this.vtQ.vuc);
            } else if (file.isDirectory()) {
                FileExplorerUI.this.vtQ.mo39067g(FileExplorerUI.this.vtQ.vud, file);
            } else if (file.isFile()) {
                FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
                FileExplorerUI.this.finish();
            }
            FileExplorerUI.dlo();
            FileExplorerUI.this.vtQ.notifyDataSetChanged();
            FileExplorerUI.this.vtP.setSelection(0);
            AppMethodBeat.m2505o(105841);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$1 */
    class C149581 implements OnMenuItemClickListener {
        C149581() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(105840);
            if (FileExplorerUI.this.vtQ.vuc != null) {
                if (1 == FileExplorerUI.this.vtO) {
                    FileExplorerUI.this.vtY = FileExplorerUI.this.vtQ.vuc;
                } else if (FileExplorerUI.this.vtO == 0) {
                    FileExplorerUI.this.vtX = FileExplorerUI.this.vtQ.vuc;
                }
                FileExplorerUI.this.vtQ.mo39067g(FileExplorerUI.this.vtQ.vuc.getParentFile(), FileExplorerUI.this.vtQ.vuc);
                FileExplorerUI.this.vtQ.notifyDataSetChanged();
                FileExplorerUI.this.vtP.setSelection(0);
                FileExplorerUI.dlo();
                AppMethodBeat.m2505o(105840);
            } else {
                C1720g.m3536RP().mo5239Ry().set(131074, FileExplorerUI.this.vtY.getAbsolutePath());
                C1720g.m3536RP().mo5239Ry().set(131073, FileExplorerUI.this.vtX.getAbsolutePath());
                FileExplorerUI.this.finish();
                AppMethodBeat.m2505o(105840);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$a */
    class C23335a extends BaseAdapter {
        String fUJ;
        private File vuc;
        private File vud;
        private File[] vue;

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$a$1 */
        class C47651 implements FileFilter {
            C47651() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.m2504i(105844);
                if (file.isHidden()) {
                    AppMethodBeat.m2505o(105844);
                    return false;
                }
                AppMethodBeat.m2505o(105844);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$a$2 */
        class C233342 implements Comparator<C23337b> {
            C233342() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(105845);
                int compareTo = ((C23337b) obj).vug.compareTo(((C23337b) obj2).vug);
                AppMethodBeat.m2505o(105845);
                return compareTo;
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$a$3 */
        class C233363 implements Comparator<C23337b> {
            C233363() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(105846);
                int compareTo = ((C23337b) obj).vug.compareTo(((C23337b) obj2).vug);
                AppMethodBeat.m2505o(105846);
                return compareTo;
            }
        }

        private C23335a() {
        }

        /* synthetic */ C23335a(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }

        /* renamed from: g */
        public final void mo39067g(File file, File file2) {
            AppMethodBeat.m2504i(105847);
            this.vuc = file;
            if (file2.getAbsolutePath().equalsIgnoreCase(this.fUJ)) {
                this.vuc = null;
            }
            this.vud = file2;
            if (this.vud.canRead() && this.vud.isDirectory()) {
                this.vue = this.vud.listFiles(new C47651());
                if (this.vue == null) {
                    this.vue = new File[0];
                }
                if (this.vue.length > 0) {
                    m35840a(this.vue);
                    AppMethodBeat.m2505o(105847);
                    return;
                }
            }
            this.vue = new File[0];
            AppMethodBeat.m2505o(105847);
        }

        public final int getCount() {
            int i = 0;
            if (this.vue == null) {
                return 0;
            }
            int length = this.vue.length;
            if (this.vuc != null) {
                i = 1;
            }
            return i + length;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(105848);
            if (this.vuc == null || i != 0) {
                C4990ab.m7410d("FileExplorer", "pos:" + i + ", subFile length:" + this.vue.length);
                File[] fileArr = this.vue;
                if (this.vuc != null) {
                    i--;
                }
                Object obj = fileArr[i];
                AppMethodBeat.m2505o(105848);
                return obj;
            }
            File file = this.vuc;
            AppMethodBeat.m2505o(105848);
            return file;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(105849);
            if (view == null) {
                view = View.inflate(FileExplorerUI.this, 2130970016, null);
                C23338c c23338c = new C23338c(FileExplorerUI.this, (byte) 0);
                c23338c.iqT = (ImageView) view.findViewById(2131825695);
                c23338c.gxi = (TextView) view.findViewById(2131823901);
                c23338c.vuh = (TextView) view.findViewById(2131825707);
                view.setTag(c23338c);
            }
            C23338c c23338c2 = (C23338c) view.getTag();
            File file = (File) getItem(i);
            if (file == this.vuc) {
                c23338c2.gxi.setText(file.getName());
                c23338c2.iqT.setImageResource(C25738R.drawable.alp);
                c23338c2.vuh.setVisibility(0);
            } else {
                c23338c2.iqT.setImageResource(FileExplorerUI.m35830X(file));
                c23338c2.gxi.setText(file.getName());
                c23338c2.vuh.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + C5046bo.m7565ga(file.length())));
            }
            AppMethodBeat.m2505o(105849);
            return view;
        }

        /* renamed from: a */
        private void m35840a(File[] fileArr) {
            byte b = (byte) 0;
            AppMethodBeat.m2504i(105850);
            if (fileArr == null || fileArr.length == 0) {
                AppMethodBeat.m2505o(105850);
                return;
            }
            int i;
            ArrayList arrayList = new ArrayList();
            ArrayList<C23337b> arrayList2 = new ArrayList();
            for (File file : fileArr) {
                C23337b c23337b = new C23337b(FileExplorerUI.this, (byte) 0);
                c23337b.file = file;
                c23337b.vug = C9790g.m17432vo(file.getName()).toUpperCase();
                if (file.isDirectory()) {
                    arrayList.add(c23337b);
                } else {
                    arrayList2.add(c23337b);
                }
            }
            Collections.sort(arrayList, new C233342());
            Collections.sort(arrayList2, new C233363());
            Iterator it = arrayList.iterator();
            while (true) {
                i = b;
                if (!it.hasNext()) {
                    break;
                }
                fileArr[i] = ((C23337b) it.next()).file;
                b = i + 1;
            }
            for (C23337b c23337b2 : arrayList2) {
                fileArr[i] = c23337b2.file;
                i++;
            }
            AppMethodBeat.m2505o(105850);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$b */
    class C23337b {
        File file;
        String vug;

        private C23337b() {
        }

        /* synthetic */ C23337b(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI$c */
    class C23338c {
        TextView gxi;
        ImageView iqT;
        TextView vuh;

        private C23338c() {
        }

        /* synthetic */ C23338c(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static /* synthetic */ void dlo() {
    }

    public final int getLayoutId() {
        return 2130970015;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(105851);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (C5046bo.isNullOrNil(stringExtra)) {
            setMMTitle((int) C25738R.string.ddr);
        } else {
            setMMTitle(stringExtra);
        }
        initView();
        AppMethodBeat.m2505o(105851);
    }

    public void onResume() {
        AppMethodBeat.m2504i(105852);
        super.onResume();
        AppMethodBeat.m2505o(105852);
    }

    public void onPause() {
        AppMethodBeat.m2504i(105853);
        super.onPause();
        AppMethodBeat.m2505o(105853);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(105854);
        super.onDestroy();
        AppMethodBeat.m2505o(105854);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(105855);
        if (i != 4 || this.vtQ.vuc == null) {
            if (this.vtY != null) {
                C1720g.m3536RP().mo5239Ry().set(131074, this.vtY.getAbsolutePath());
            }
            if (this.vtX != null) {
                C1720g.m3536RP().mo5239Ry().set(131073, this.vtX.getAbsolutePath());
            }
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(105855);
            return onKeyDown;
        }
        if (1 == this.vtO) {
            this.vtY = this.vtQ.vuc;
        } else if (this.vtO == 0) {
            this.vtX = this.vtQ.vuc;
        }
        this.vtQ.mo39067g(this.vtQ.vuc.getParentFile(), this.vtQ.vuc);
        this.vtQ.notifyDataSetChanged();
        this.vtP.setSelection(0);
        AppMethodBeat.m2505o(105855);
        return true;
    }

    public final void initView() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(105856);
        this.vtP = (ListView) findViewById(2131825706);
        this.vtR = (TextView) findViewById(2131825702);
        this.vtT = findViewById(2131825703);
        this.vtS = (TextView) findViewById(2131825704);
        this.vtU = findViewById(2131825705);
        setBackBtn(new C149581());
        this.vtV = getString(C25738R.string.ddp);
        this.vtW = getString(C25738R.string.ddq);
        final File dlm = dlm();
        final File dln = dln();
        this.vtX = FileExplorerUI.m35828V(dlm);
        this.vtY = FileExplorerUI.m35829W(dln);
        this.vtQ = new C23335a(this, (byte) 0);
        if (dln != null) {
            m35827Lr(1);
            this.vtQ.fUJ = dln.getPath();
            this.vtQ.mo39067g(this.vtY.getParentFile(), this.vtY);
        } else if (dlm != null) {
            m35827Lr(0);
            this.vtQ.fUJ = dlm.getPath();
            this.vtQ.mo39067g(this.vtX.getParentFile(), this.vtX);
        } else {
            C4990ab.m7410d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            AppMethodBeat.m2505o(105856);
            return;
        }
        TextView textView = this.vtR;
        if (dlm != null) {
            z = true;
        } else {
            z = false;
        }
        textView.setEnabled(z);
        TextView textView2 = this.vtS;
        if (dln == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.vtP.setAdapter(this.vtQ);
        this.vtQ.notifyDataSetChanged();
        this.vtP.setOnItemClickListener(new C47632());
        this.vtR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(105842);
                FileExplorerUI.m35833a(FileExplorerUI.this, 0);
                FileExplorerUI.this.vtQ.fUJ = dlm.getPath();
                FileExplorerUI.this.vtQ.mo39067g(FileExplorerUI.this.vtX.getParentFile(), FileExplorerUI.this.vtX);
                FileExplorerUI.this.vtQ.notifyDataSetInvalidated();
                FileExplorerUI.this.vtQ.notifyDataSetChanged();
                FileExplorerUI.this.vtP.setSelection(0);
                AppMethodBeat.m2505o(105842);
            }
        });
        this.vtS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(105843);
                FileExplorerUI.m35833a(FileExplorerUI.this, 1);
                FileExplorerUI.this.vtQ.fUJ = dln.getPath();
                FileExplorerUI.this.vtQ.mo39067g(FileExplorerUI.this.vtY.getParentFile(), FileExplorerUI.this.vtY);
                FileExplorerUI.this.vtQ.notifyDataSetInvalidated();
                FileExplorerUI.this.vtQ.notifyDataSetChanged();
                FileExplorerUI.this.vtP.setSelection(0);
                AppMethodBeat.m2505o(105843);
            }
        });
        AppMethodBeat.m2505o(105856);
    }

    /* renamed from: Lr */
    private void m35827Lr(int i) {
        AppMethodBeat.m2504i(105857);
        if (1 == i) {
            this.vtO = 1;
            this.vtS.setTextColor(getResources().getColor(C25738R.color.f12069r8));
            this.vtR.setTextColor(getResources().getColor(C25738R.color.f12212w4));
            this.vtT.setVisibility(4);
            this.vtU.setVisibility(0);
            AppMethodBeat.m2505o(105857);
            return;
        }
        this.vtO = 0;
        this.vtR.setTextColor(getResources().getColor(C25738R.color.f12069r8));
        this.vtS.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        this.vtT.setVisibility(0);
        this.vtU.setVisibility(4);
        AppMethodBeat.m2505o(105857);
    }

    private File dlm() {
        AppMethodBeat.m2504i(105858);
        File rootDirectory = C1448h.getRootDirectory();
        if (rootDirectory.canRead()) {
            AppMethodBeat.m2505o(105858);
            return rootDirectory;
        }
        rootDirectory = C1448h.getDataDirectory();
        if (rootDirectory.canRead()) {
            this.vtV = rootDirectory.getName();
            AppMethodBeat.m2505o(105858);
            return rootDirectory;
        }
        AppMethodBeat.m2505o(105858);
        return null;
    }

    private File dln() {
        AppMethodBeat.m2504i(105859);
        File externalStorageDirectory;
        if (C1720g.m3536RP().isSDCardAvailable()) {
            externalStorageDirectory = C1448h.getExternalStorageDirectory();
            AppMethodBeat.m2505o(105859);
            return externalStorageDirectory;
        }
        externalStorageDirectory = C1448h.getDownloadCacheDirectory();
        if (externalStorageDirectory.canRead()) {
            this.vtW = externalStorageDirectory.getName();
            AppMethodBeat.m2505o(105859);
            return externalStorageDirectory;
        }
        AppMethodBeat.m2505o(105859);
        return null;
    }

    /* renamed from: V */
    private static File m35828V(File file) {
        AppMethodBeat.m2504i(105860);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file2 = new File(str);
            if (file2.exists()) {
                AppMethodBeat.m2505o(105860);
                return file2;
            }
        }
        AppMethodBeat.m2505o(105860);
        return file;
    }

    /* renamed from: W */
    private static File m35829W(File file) {
        AppMethodBeat.m2504i(105861);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(131074, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file2 = new File(str);
            if (file2.exists()) {
                AppMethodBeat.m2505o(105861);
                return file2;
            }
        }
        AppMethodBeat.m2505o(105861);
        return file;
    }

    public static int ajW(String str) {
        Object obj;
        Object obj2 = null;
        AppMethodBeat.m2504i(105862);
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = C5046bo.nullAsNil(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(105862);
            return C1318a.app_attach_file_icon_word;
        } else if (FileExplorerUI.ajX(toLowerCase)) {
            AppMethodBeat.m2505o(105862);
            return C25738R.drawable.alr;
        } else {
            toLowerCase2 = C5046bo.nullAsNil(toLowerCase).toLowerCase();
            if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(105862);
                return C1318a.app_attach_file_icon_rar;
            }
            toLowerCase2 = C5046bo.nullAsNil(toLowerCase).toLowerCase();
            if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(105862);
                return C1318a.app_attach_file_icon_txt;
            } else if (C5046bo.nullAsNil(toLowerCase).toLowerCase().endsWith(".pdf")) {
                AppMethodBeat.m2505o(105862);
                return C1318a.app_attach_file_icon_pdf;
            } else {
                toLowerCase2 = C5046bo.nullAsNil(toLowerCase).toLowerCase();
                if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.m2505o(105862);
                    return C1318a.app_attach_file_icon_ppt;
                }
                toLowerCase2 = C5046bo.nullAsNil(toLowerCase).toLowerCase();
                if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    AppMethodBeat.m2505o(105862);
                    return C1318a.app_attach_file_icon_excel;
                }
                AppMethodBeat.m2505o(105862);
                return C1318a.app_attach_file_icon_unknow;
            }
        }
    }

    public static boolean ajX(String str) {
        AppMethodBeat.m2504i(105863);
        String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
        if (toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(FileUtils.PIC_POSTFIX_JPEG) || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif")) {
            AppMethodBeat.m2505o(105863);
            return true;
        }
        AppMethodBeat.m2505o(105863);
        return false;
    }

    public static boolean ajY(String str) {
        AppMethodBeat.m2504i(105864);
        String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
        if (toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(VideoMaterialUtil.MP4_SUFFIX) || toLowerCase.endsWith(".rm")) {
            AppMethodBeat.m2505o(105864);
            return true;
        }
        AppMethodBeat.m2505o(105864);
        return false;
    }

    /* renamed from: X */
    static /* synthetic */ int m35830X(File file) {
        AppMethodBeat.m2504i(105866);
        if (file.isDirectory()) {
            AppMethodBeat.m2505o(105866);
            return C25738R.drawable.alq;
        }
        int ajW = FileExplorerUI.ajW(file.getName());
        AppMethodBeat.m2505o(105866);
        return ajW;
    }
}
